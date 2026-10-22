package com.ss.videoarch.strategy.strategy.smartStrategy;

import android.os.Handler;
import android.text.TextUtils;
import androidx.camera.video.AudioStats;
import com.bytedance.android.ec.slice.SliceInitService;
import com.bytedance.crash.dumper.Scraps;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.texturerender.TextureRenderManager;
import com.ss.texturerender.VideoSurface;
import com.ss.texturerender.effect.EffectConfig;
import com.ss.videoarch.strategy.dataCenter.config.LSSettings;
import com.ss.videoarch.strategy.network.ThreadPoolApi;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public class SuperResolution extends BaseSmartStrategy {
    private static final int MSG_WHAT_SR_PREDICT = 1025;
    private static final String PROJECT_KEY = "live_stream_strategy_engine";
    private static final int SR_1_5_x = 4;
    private static final int SR_2x = 0;
    private static final String TAG = "DynamicSRPredictEngine";
    private static final int TEX_LIVE = 1;
    private static volatile SuperResolution sInstance;
    private int mCurSupportMaxSRType;
    private int mEnableDynamicSRPredict;
    private int mEnableSRAsyncInit;
    private int mEnableSRPredictAlgorithum;
    private int mEnableSRScreenResControl;
    private int mEnableUseSR;
    private int mEnableUseSRType;
    private int mFirstSRPredict;
    public Handler mHandler;
    private boolean mIsInited;
    private int mLastEnableUseSR;
    private long mLastSRPredictTime;
    private List<Integer> mPlayingSRPredictTimeList;
    private List<VideoSurface> mPlayingTextureSurfaceList;
    private int mSRMaxAlgorithumType;
    private int mSRMaxTextureHeight;
    private int mSRMaxTextureWidth;
    private int mSROpenMaliSync;
    private int mSRPredictMinInterval;
    private List<Integer> mSRPredictScheduleTimeList;
    private int mScreenHeight;
    private int mScreenWidth;
    private long mSupportSRHighAvaliableMem;
    private int mSupportSRHighBatteryLevel;
    private double mSupportSRHighCpuRate;
    private double mSupportSRHighTemperature;
    private long mSupportSRHighTotalMem;
    private long mSupportSRLowAvaliableMem;
    private int mSupportSRLowBatteryLevel;
    private double mSupportSRLowCpuRate;
    private double mSupportSRLowTemperature;
    private long mSupportSRLowTotalMem;
    private int mSupportSRScene;
    private TextureRenderManager mTextureRenderer;
    private final ThreadPoolApi mThreadPoolApi;

    public static SuperResolution inst() {
        if (sInstance != null) goto L15;
        monitor-enter(SuperResolution.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new SuperResolution();     // Catch: Throwable -> L11
    L9:
        monitor-exit(SuperResolution.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    public JSONObject getSRPredictResult() {
        JSONObject r100 = new JSONObject();
        r100.put("enable_sr", this.mEnableUseSR);     // Catch: Exception -> L5
        r100.put("sr_type", this.mEnableUseSRType);     // Catch: Exception -> L5
    L7:
        return r100;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    public void updateSettings() {
        JSONObject r100 = LSSettings.inst().mSettings;
        if (r100 == null) goto L20;
    L15:
        e = move-exception;
        e.printStackTrace();
        return;
    L5:
        if (r100.has("BatchSettingsParams") == false) goto L21;
        String r101 = r100.optJSONObject("BatchSettingsParams").optJSONObject(PROJECT_KEY).optString("2");     // Catch: Exception -> L15
        if (r101 != null) goto L9;
    L11:
        JSONObject r102 = new JSONObject(r101).optJSONObject("SRConfig");     // Catch: Exception -> L15
        if (r102 == null) goto L22;
        parseSettings(r102);     // Catch: Exception -> L15
        return;
    L22:
        return;
    L9:
        if (r101.startsWith("\ufeff") == false) goto L11;
        r101 = r101.substring(1);     // Catch: Exception -> L15
        goto L11
    L21:
        return;
    }

    public SuperResolution() {
        this.mEnableSRPredictAlgorithum = 0;
        this.mEnableSRAsyncInit = 0;
        this.mEnableDynamicSRPredict = 0;
        this.mEnableSRScreenResControl = 0;
        this.mHandler = null;
        this.mPlayingSRPredictTimeList = new ArrayList();
        this.mSRPredictMinInterval = 5000;
        this.mSRMaxTextureWidth = 1280;
        this.mSRMaxTextureHeight = 600;
        this.mSRMaxAlgorithumType = 0;
        this.mSROpenMaliSync = 0;
        this.mIsInited = false;
        this.mThreadPoolApi = new ThreadPoolApi();
        this.mPlayingTextureSurfaceList = new CopyOnWriteArrayList();
        this.mScreenWidth = -1;
        this.mScreenHeight = -1;
        this.mSupportSRHighCpuRate = -1.0d;
        this.mSupportSRLowCpuRate = -1.0d;
        this.mSupportSRHighAvaliableMem = -1;
        this.mSupportSRLowAvaliableMem = -1;
        this.mSupportSRHighTotalMem = -1;
        this.mSupportSRLowTotalMem = -1;
        this.mSupportSRHighBatteryLevel = -1;
        this.mSupportSRLowBatteryLevel = -1;
        this.mSupportSRHighTemperature = -1.0d;
        this.mSupportSRLowTemperature = -1.0d;
        this.mLastSRPredictTime = -1;
        this.mEnableUseSR = -1;
        this.mLastEnableUseSR = -1;
        this.mEnableUseSRType = 0;
        this.mCurSupportMaxSRType = 0;
        this.mFirstSRPredict = 0;
        this.mSRPredictScheduleTimeList = new ArrayList();
        this.mSupportSRScene = -1;
    }

    public void init() {
        String r100 = (String) LSSettings.inst().getAppInfoForKey("SCREEN_RESOLTION", SliceInitService.DEFAULT_SWITCH);
        if (TextUtils.isEmpty(r100) == false) goto L22;
    L8:
        this.mEnableSRAsyncInit = ((Integer) LSSettings.inst().getAppInfoForKey("live_stream_strategy_enable_sr_asyncinit", 0)).intValue();
        this.mEnableDynamicSRPredict = ((Integer) LSSettings.inst().getAppInfoForKey("live_stream_strategy_enable_dynamic_sr", 0)).intValue();
        String r101 = (String) LSSettings.inst().getAppInfoForKey("live_stream_strategy_sr_config", SliceInitService.DEFAULT_SWITCH);
    L13:
        e = move-exception;
        e.printStackTrace();
    L16:
        if (this.mEnableSRAsyncInit != 1) goto L18;
        String r102 = (String) LSSettings.inst().getAppInfoForKey("live_stream_strategy_sr_kernal_bin_path", "none");
        this.mTextureRenderer = TextureRenderManager.getManager();
        asyncInitSR(this.mSRMaxAlgorithumType, r102, this.mSRMaxTextureWidth, this.mSRMaxTextureHeight, this.mSROpenMaliSync);
    L18:
        this.mIsInited = true;
        return;
    L10:
        if (TextUtils.isEmpty(r101) == true) goto L16;
        parseSettings(new JSONObject(r101));     // Catch: JSONException -> L13
        goto L16
    L22:
        JSONObject r103 = new JSONObject(r100);     // Catch: JSONException -> L6
        this.mScreenWidth = r103.optInt("width");     // Catch: JSONException -> L6
        this.mScreenHeight = r103.optInt("height");     // Catch: JSONException -> L6
    L6:
        e = move-exception;
        e.printStackTrace();
        goto L8
    }

    public static /* synthetic */ TextureRenderManager access$000(SuperResolution r100) {
        return r100.mTextureRenderer;
    }

    public void addSRPredictTask(boolean r100) {
        asyncSRPredictTask(r100);
        if (this.mSRPredictScheduleTimeList.isEmpty() == true) goto L6;
        this.mHandler.sendEmptyMessageDelayed(1025, ((Integer) ListProtector.get(this.mSRPredictScheduleTimeList, 0)).intValue() * 1000);
        ListProtector.remove(this.mSRPredictScheduleTimeList, 0);
        return;
    }

    public void asyncSRPredictTask(boolean r210) {
        if (this.mLastSRPredictTime != (-1)) goto L5;
    L18:
        this.mLastSRPredictTime = System.currentTimeMillis();
        String r100 = (String) LSSettings.inst().getAppInfoForKey("DEVICE_PERFORMANCE_INFO", SliceInitService.DEFAULT_SWITCH);
        if (r100.isEmpty() == false) goto L198;
        return;
    L198:
        JSONObject r101 = new JSONObject(r100);     // Catch: JSONException -> L195
        String r102 = r101.optString("cpu", null);     // Catch: JSONException -> L195
        if (TextUtils.isEmpty(r102) == true) goto L31;
        JSONObject r110 = new JSONObject(r102);     // Catch: JSONException -> L195
        if (r110.has("cpu_rate") == false) goto L26;
        double r103 = r110.optDouble("cpu_rate");     // Catch: JSONException -> L195
    L28:
        if (r110.has("cpu_speed") == false) goto L30;
        double r111 = r110.optDouble("cpu_speed");     // Catch: JSONException -> L195
    L32:
        String r104 = r101.optString("pss", null);     // Catch: JSONException -> L195
        if (TextUtils.isEmpty(r104) == true) goto L42;
        JSONObject r112 = new JSONObject(r104);     // Catch: JSONException -> L195
        if (r112.has("java_total") == false) goto L37;
        long r105 = r112.optLong("java_total");     // Catch: JSONException -> L195
    L39:
        if (r112.has("java_free") == false) goto L41;
        long r113 = r112.optLong("java_free");     // Catch: JSONException -> L195
    L43:
        String r106 = r101.optString("thermal", null);     // Catch: JSONException -> L195
        if (TextUtils.isEmpty(r106) == true) goto L48;
        JSONObject r114 = new JSONObject(r106);     // Catch: JSONException -> L195
        if (r114.has("value") == false) goto L48;
        double r107 = r114.optDouble("value");     // Catch: JSONException -> L195
    L49:
        String r108 = r101.optString(Scraps.BATTERY, null);     // Catch: JSONException -> L195
        if (TextUtils.isEmpty(r108) == true) goto L54;
        JSONObject r109 = new JSONObject(r108);     // Catch: JSONException -> L195
        if (r109.has("battery_level") == false) goto L54;
        int r115 = r109.optInt("battery_level");     // Catch: JSONException -> L195
    L56:
        if (r103 > AudioStats.AUDIO_AMPLITUDE_NONE) goto L60;
        if (r111 > AudioStats.AUDIO_AMPLITUDE_NONE) goto L60;
    L185:
        if (this.mPlayingTextureSurfaceList.isEmpty() == true) goto L194;
        Iterator<VideoSurface> r116 = this.mPlayingTextureSurfaceList.iterator();     // Catch: JSONException -> L195
    L188:
        if (r116.hasNext() == false) goto L194;
        VideoSurface r117 = r116.next();     // Catch: JSONException -> L195
        if (this.mSupportSRScene == 1) goto L191;
        r117.setSuperResolutionMode(0);     // Catch: JSONException -> L195
        this.mEnableUseSR = -1;     // Catch: JSONException -> L195
        goto L188
    L191:
        r117.setSuperResolutionMode(1);     // Catch: JSONException -> L195
        this.mEnableUseSR = -1;     // Catch: JSONException -> L195
    L194:
        return;
    L60:
        if (r105 <= 0) goto L185;
        if (r113 <= 0) goto L185;
        if (r107 <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L185;
        if (r115 <= 0) goto L185;
        if (this.mEnableSRPredictAlgorithum != 1) goto L129;
        int r118 = this.mCurSupportMaxSRType;     // Catch: JSONException -> L195
        if (r118 != 0) goto L109;
        if (r103 <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L76;
        if (r103 > this.mSupportSRHighCpuRate) goto L76;
    L80:
        if (r105 >= this.mSupportSRHighTotalMem) goto L82;
    L90:
        if (r103 <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L94;
        if (r103 > this.mSupportSRLowCpuRate) goto L94;
    L98:
        if (r105 >= this.mSupportSRLowTotalMem) goto L100;
    L172:
        int r119 = 0;
    L174:
        if (this.mPlayingTextureSurfaceList.isEmpty() == true) goto L183;
        Iterator<VideoSurface> r120 = this.mPlayingTextureSurfaceList.iterator();     // Catch: JSONException -> L195
    L177:
        if (r120.hasNext() == false) goto L183;
        VideoSurface r121 = r120.next();     // Catch: JSONException -> L195
        if (this.mSupportSRScene != 1) goto L182;
        if (r119 != 1) goto L182;
        r121.setSuperResolutionMode(r119);     // Catch: JSONException -> L195
    L182:
        r121.setSuperResolutionMode(0);     // Catch: JSONException -> L195
    L183:
        this.mEnableUseSR = r119;     // Catch: JSONException -> L195
        return;
    L100:
        if (r113 < this.mSupportSRLowAvaliableMem) goto L172;
        if (r107 <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L172;
        if (r107 > this.mSupportSRHighTemperature) goto L172;
        if (r115 < this.mSupportSRLowBatteryLevel) goto L172;
        this.mEnableUseSRType = 4;     // Catch: JSONException -> L195
    L150:
        r119 = 1;
    L94:
        if (r111 <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L172;
        if (r111 >= this.mSupportSRLowCpuRate) goto L172;
    L82:
        if (r113 < this.mSupportSRHighAvaliableMem) goto L90;
        if (r107 <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L90;
        if (r107 > this.mSupportSRLowTemperature) goto L90;
        if (r115 < this.mSupportSRHighBatteryLevel) goto L90;
        this.mEnableUseSRType = 0;     // Catch: JSONException -> L195
    L76:
        if (r111 <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L90;
        if (r111 >= this.mSupportSRHighCpuRate) goto L90;
    L109:
        if (r118 != 4) goto L172;
        if (r103 <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L115;
        if (r103 > this.mSupportSRLowCpuRate) goto L115;
    L119:
        if (r105 < this.mSupportSRLowTotalMem) goto L172;
        if (r113 < this.mSupportSRLowAvaliableMem) goto L172;
        if (r107 <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L172;
        if (r107 > this.mSupportSRHighTemperature) goto L172;
        if (r115 < this.mSupportSRLowBatteryLevel) goto L172;
        this.mEnableUseSRType = 4;     // Catch: JSONException -> L195
    L115:
        if (r111 <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L172;
        if (r111 >= this.mSupportSRLowCpuRate) goto L172;
    L129:
        int r122 = this.mCurSupportMaxSRType;     // Catch: JSONException -> L195
        if (r122 != 0) goto L152;
        if (r103 <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L136;
        if (r103 > this.mSupportSRHighCpuRate) goto L136;
    L140:
        if (r105 < this.mSupportSRHighTotalMem) goto L172;
        if (r113 < this.mSupportSRHighAvaliableMem) goto L172;
        if (r107 <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L172;
        if (r107 > this.mSupportSRLowTemperature) goto L172;
        if (r115 < this.mSupportSRHighBatteryLevel) goto L172;
        this.mEnableUseSRType = 0;     // Catch: JSONException -> L195
    L136:
        if (r111 <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L172;
        if (r111 >= this.mSupportSRHighCpuRate) goto L172;
    L152:
        if (r122 != 4) goto L172;
        if (r103 <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L158;
        if (r103 > this.mSupportSRLowCpuRate) goto L158;
    L162:
        if (r105 < this.mSupportSRLowTotalMem) goto L172;
        if (r113 < this.mSupportSRLowAvaliableMem) goto L172;
        if (r107 <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L172;
        if (r107 > this.mSupportSRHighTemperature) goto L172;
        if (r115 < this.mSupportSRLowBatteryLevel) goto L172;
        this.mEnableUseSRType = 4;     // Catch: JSONException -> L195
    L158:
        if (r111 <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L172;
        if (r111 >= this.mSupportSRLowCpuRate) goto L172;
    L54:
        r115 = 0;
    L48:
        r107 = 0.0d;
        goto L49
    L41:
        r113 = 0;
        goto L43
    L37:
        r105 = 0;
        goto L39
    L42:
        r105 = 0;
        r113 = 0;
        goto L43
    L30:
        r111 = 0.0d;
        goto L32
    L26:
        r103 = 0.0d;
        goto L28
    L31:
        r103 = 0.0d;
        r111 = 0.0d;
    L195:
        e = move-exception;
        e.printStackTrace();
        return;
    L5:
        if ((System.currentTimeMillis() - this.mLastSRPredictTime) > this.mSRPredictMinInterval) goto L18;
        this.mEnableUseSR = this.mLastEnableUseSR;
        if (this.mPlayingTextureSurfaceList.isEmpty() == true) goto L17;
        Iterator<VideoSurface> r123 = this.mPlayingTextureSurfaceList.iterator();
    L10:
        if (r123.hasNext() == false) goto L220;
        VideoSurface r124 = r123.next();
        if (r124 == null) goto L10;
        if (this.mEnableUseSR != 0) goto L15;
        r124.setSuperResolutionMode(0);
        goto L10
    L15:
        r124.setSuperResolutionMode(1);
        goto L10
    L220:
        return;
    }

    public void parseSettings(JSONObject r110) {
        Objects.toString(r110);
    L28:
        e = move-exception;
        e.printStackTrace();
        return;
    L4:
        if (r110.has("EnableSRAsyncInit") == false) goto L7;
        this.mEnableSRAsyncInit = r110.optInt("EnableSRAsyncInit", 0);     // Catch: JSONException -> L28
    L7:
        if (this.mEnableSRAsyncInit != 1) goto L10;
        this.mSRMaxTextureWidth = r110.optInt("MaxTextureWidth", 1280);     // Catch: JSONException -> L28
        this.mSRMaxTextureHeight = r110.optInt("MaxTextureHeight", 600);     // Catch: JSONException -> L28
        this.mSRMaxAlgorithumType = r110.optInt("MaxAlgorithumType", 0);     // Catch: JSONException -> L28
        this.mSROpenMaliSync = r110.optInt("OpenMaliSync", 1);     // Catch: JSONException -> L28
    L10:
        if (r110.has("EnableDynamicSRPredict") == false) goto L13;
        this.mEnableDynamicSRPredict = r110.optInt("EnableDynamicSRPredict", 0);     // Catch: JSONException -> L28
    L13:
        if (this.mEnableDynamicSRPredict != 1) goto L26;
        this.mEnableSRPredictAlgorithum = r110.optInt("EnableSRPredictAlgorithum", 0);     // Catch: JSONException -> L28
        this.mSupportSRHighCpuRate = r110.optDouble("HighCpuRate", -1.0d);     // Catch: JSONException -> L28
        this.mSupportSRLowCpuRate = r110.optDouble("LowCpuRate", -1.0d);     // Catch: JSONException -> L28
        this.mSupportSRHighAvaliableMem = r110.optLong("HighAvaliableMem", -1);     // Catch: JSONException -> L28
        this.mSupportSRLowAvaliableMem = r110.optLong("LowAvaliableMem", -1);     // Catch: JSONException -> L28
        this.mSupportSRHighTotalMem = r110.optLong("HighTotalMem", -1);     // Catch: JSONException -> L28
        this.mSupportSRLowTotalMem = r110.optLong("LowTotalMem", -1);     // Catch: JSONException -> L28
        this.mSupportSRHighBatteryLevel = r110.optInt("HighBatteryLevel", -1);     // Catch: JSONException -> L28
        this.mSupportSRLowBatteryLevel = r110.optInt("LowBatteryLevel", -1);     // Catch: JSONException -> L28
        this.mSupportSRHighTemperature = r110.optDouble("HighTemperature", -1.0d);     // Catch: JSONException -> L28
        this.mSupportSRLowTemperature = r110.optDouble("LowTemperature", -1.0d);     // Catch: JSONException -> L28
        if (r110.has("PredictTimeList") == false) goto L25;
        JSONArray r100 = r110.optJSONArray("PredictTimeList");     // Catch: JSONException -> L28
        if (r100 == null) goto L25;
        if (this.mPlayingSRPredictTimeList.isEmpty() == true) goto L21;
        this.mPlayingSRPredictTimeList.clear();     // Catch: JSONException -> L28
    L21:
        int r101 = 0;
    L23:
        if (r101 >= r100.length()) goto L25;
        this.mPlayingSRPredictTimeList.add(Integer.valueOf(JSONArrayProtectorUtils.getInt(r100, r101)));     // Catch: JSONException -> L28
        r101 = r101 + 1;     // Catch: JSONException -> L28
    L25:
        this.mSRPredictMinInterval = r110.optInt("PredictMinInterval", 5000);     // Catch: JSONException -> L28
    L26:
        this.mEnableSRScreenResControl = r110.optInt("ScreenResControl", 0);     // Catch: JSONException -> L28
    }

    public void setHandler(Handler r100) {
        this.mHandler = r100;
    }

    public void setSupportSRScene(boolean r100) {
        if (this.mSupportSRScene != 0) goto L15;
        if (r100 == false) goto L15;
        if (this.mEnableUseSR == 0) goto L15;
        if (this.mPlayingTextureSurfaceList.isEmpty() == true) goto L15;
        Iterator<VideoSurface> r101 = this.mPlayingTextureSurfaceList.iterator();
    L11:
        if (r101.hasNext() == false) goto L15;
        VideoSurface r102 = r101.next();
        if (r102 == null) goto L11;
        r102.setSuperResolutionMode(1);
    L15:
        this.mSupportSRScene = r100 ? 1 : 0;
    }

    public void stopSession(JSONObject r100) {
        if (this.mIsInited == true) goto L5;
        return;
    L5:
        if (this.mEnableDynamicSRPredict == 0) goto L18;
        if (r100 == null) goto L21;
        Handler r101 = this.mHandler;
        if (r101 == null) goto L11;
        r101.removeMessages(1025);
    L11:
        Object r102 = r100.opt("textureSurface");
        if (r102 != null) goto L14;
        return;
    L14:
        if ((r102 instanceof VideoSurface) == false) goto L20;
        List<VideoSurface> r103 = this.mPlayingTextureSurfaceList;
        r103.remove((VideoSurface) r102);
        return;
    L20:
        return;
    L21:
        return;
    }

    public void triggerSRPredict(JSONObject r100) {
        Objects.toString(r100);
        if (this.mEnableDynamicSRPredict == 0) goto L63;
        if (r100 != null) goto L6;
        return;
    L6:
        if (this.mIsInited == false) goto L66;
        this.mLastEnableUseSR = this.mEnableUseSR;
        this.mSRPredictScheduleTimeList.clear();
        Handler r101 = this.mHandler;
        if (r101 == null) goto L11;
        r101.removeMessages(1025);
    L11:
        Object r102 = r100.opt("textureSurface");
        if (r102 != null) goto L14;
    L16:
        this.mCurSupportMaxSRType = this.mSRMaxAlgorithumType;
        if (this.mEnableSRScreenResControl == 1) goto L19;
    L51:
        this.mSRPredictScheduleTimeList.addAll(this.mPlayingSRPredictTimeList);
        if (this.mSRPredictScheduleTimeList.isEmpty() == true) goto L54;
        this.mFirstSRPredict = ((Integer) ListProtector.get(this.mSRPredictScheduleTimeList, 0)).intValue();
        ListProtector.remove(this.mSRPredictScheduleTimeList, 0);
    L54:
        Handler r103 = this.mHandler;
        if (r103 != null) goto L57;
        return;
    L57:
        if (this.mFirstSRPredict <= 0) goto L59;
        this.mEnableUseSR = 0;
    L59:
        r103.postDelayed(new AnonymousClass2(this), this.mFirstSRPredict * 1000);
        return;
    L19:
        if (this.mScreenWidth > 0) goto L21;
    L22:
        String r104 = (String) LSSettings.inst().getAppInfoForKey("SCREEN_RESOLTION", SliceInitService.DEFAULT_SWITCH);
        if (TextUtils.isEmpty(r104) == true) goto L29;
        JSONObject r105 = new JSONObject(r104);     // Catch: JSONException -> L26
        this.mScreenWidth = r105.optInt("width");     // Catch: JSONException -> L26
        this.mScreenHeight = r105.optInt("height");     // Catch: JSONException -> L26
    L26:
        e = move-exception;
        e.printStackTrace();
    L29:
        if (this.mScreenWidth <= 0) goto L51;
        if (this.mScreenHeight <= 0) goto L51;
        int r106 = r100.optInt("width");
        int r107 = r100.optInt("height");
        if (r106 <= 0) goto L51;
        if (r107 <= 0) goto L51;
        int r108 = this.mSRMaxAlgorithumType;
        if (r108 != 0) goto L44;
        if ((r106 * 2) <= this.mScreenWidth) goto L40;
    L41:
        this.mEnableUseSR = 0;
        return;
    L40:
        if ((r107 * 2) <= this.mScreenHeight) goto L51;
    L44:
        if (r108 != 4) goto L51;
        if (((r106 * 3) / 2) <= this.mScreenWidth) goto L48;
    L49:
        this.mEnableUseSR = 0;
        return;
    L48:
        if (((r107 * 3) / 2) <= this.mScreenHeight) goto L51;
    L21:
        if (this.mScreenHeight > 0) goto L29;
    L14:
        if ((r102 instanceof VideoSurface) == false) goto L16;
        this.mPlayingTextureSurfaceList.add((VideoSurface) r102);
        goto L16
    L66:
        return;
    }

    public void asyncInitSR(final int r110, final String r111, final int r112, final int r113, final int r114) {
        if (this.mTextureRenderer != null) goto L5;
        return;
    L5:
        final EffectConfig r100 = new EffectConfig(1);
        r100.setOpenSR(true);
        if (this.mTextureRenderer.isEffectAvailable(r100, 1) == true) goto L9;
        this.mThreadPoolApi.execute(new AnonymousClass1(this, r110, r112, r113, r111, r114, r100));
        return;
    }
}
