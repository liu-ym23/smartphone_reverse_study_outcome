package com.ss.ttvideoengine.superresolution;

import android.text.TextUtils;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.ss.ttvideoengine.Resolution;
import com.ss.ttvideoengine.log.IVideoEventLogger;
import com.ss.ttvideoengine.model.VideoInfo;
import com.ss.ttvideoengine.utils.Error;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes35.dex */
public class SRStrategy {
    public static final String KEY_BITRATE_AFTER_DOWNGRADE = "bad";
    public static final String KEY_BITRATE_BEFORE_DOWNGRADE = "bbd";
    public static final String KEY_BITRATE_DOWNGRADE_TYPE = "bdt";
    public static final String KEY_CURRENT_QUALITY_DESC = "cqd";
    public static final String KEY_CURRENT_RESOLUTION = "cr";
    public static final String KEY_DISPLAY_HEIGHT = "dh";
    public static final String KEY_DISPLAY_WIDTH = "dw";
    public static final String KEY_DOWNGRADE = "do";
    public static final String KEY_ENABLE_ABR_SR = "eas";
    public static final String KEY_ENABLE_SR_STRATEGY = "ess";
    public static final String KEY_FR_PLAYER_TIME = "fpt";
    public static final String KEY_FR_TEXTURE_SET_TIME = "fts";
    public static final String KEY_FR_TEXTURE_TIME = "ftt";
    public static final String KEY_NET_STATE = "ns";
    public static final String KEY_ORIGIN_QUALITY_DESC = "oqd";
    public static final String KEY_ORIGIN_RESOLUTION = "or";
    public static final String KEY_SCREEN_HEIGHT = "sh";
    public static final String KEY_SCREEN_WIDTH = "sw";
    public static final String KEY_SR_FAIL_REASON = "sfr";
    public static final String KEY_SR_MEDIA_INFO = "smi";
    public static final String KEY_SR_OPEN = "so";
    public static final String KEY_SR_SATISFIED = "srs";
    public static final String KEY_SR_STATUS = "ss";
    public static final String KEY_SR_STRATEGY_CONFIG = "sc";
    public static final String KEY_SR_STRATEGY_MODE = "sm";
    public static final String KEY_SR_USE_TEXTURE = "sut";
    public static final String KEY_USER_EXPECTED = "ue";
    public static final String MEDIAINFO_KEY_BITRATE = "br";
    public static final String MEDIAINFO_KEY_CACHE_SIZE = "cs";
    public static final String MEDIAINFO_KEY_RESOLUTION = "res";
    public static final String MEDIAINFO_KEY_SUPPORT_SR = "ss";
    public static final String MEDIAINFO_KEY_WIDTH = "w";
    private static final int PRELOAD_INFO_CACHE_SIZE = 100;
    public static final int SCENE_DETAIL = 2;
    public static final int SCENE_FULLSCREEN = 4;
    public static final int SCENE_LIST = 1;
    public static final int SCENE_NONE = 0;
    public static final int SR_CHECK_TYPE_PLAY = 1;
    public static final int SR_CHECK_TYPE_PRELOAD = 0;
    public static final int SR_STATUS_CLOSE = 0;
    public static final int SR_STATUS_NONE = -1;
    public static final int SR_STATUS_OPEN_FAIL = 2;
    public static final int SR_STATUS_OPEN_SUCCESS = 1;
    public static final int SR_STRATEGY_MODE_AUTO = 0;
    public static final int SR_STRATEGY_MODE_USER = 1;
    private static final String TAG = "TTVideoEngine.SRStrategy";
    public static final int VIDEO_FORMAT_TYPE_DASH = 2;
    public static final int VIDEO_FORMAT_TYPE_MP4 = 1;
    private Map<Integer, List<Integer>> mSRBenchmark;
    private SRStrategyConfig mSRConfig;
    private int mSRNotUseReason;
    private boolean mSRSatisfied;
    private int mSRStatus;
    private ISRStrategyListener mSRStrategyListener;
    private int mSRStrategyMode;
    private boolean mShouldUseSRTexture;
    private Map<String, Object> mStrategyInfo;

    private void checkSatisfied() {
        this.mSRSatisfied = false;
        this.mShouldUseSRTexture = false;
        this.mSRNotUseReason = 0;
        if (2 != this.mSRStatus) goto L6;
        this.mSRNotUseReason = Error.SROpenFail;
        return;
    L6:
        Boolean r100 = this.mSRConfig.getEnableSR();
        if (r100 != null) goto L9;
    L73:
        this.mSRNotUseReason = Error.SRDisabled;
        return;
    L9:
        if (r100.booleanValue() == false) goto L73;
        Boolean r101 = this.mSRConfig.getResolutionChanged();
        if (r101 == null) goto L18;
        if (r101.booleanValue() == false) goto L18;
        this.mSRNotUseReason = Error.ResolutionChanged;
        return;
    L18:
        if (this.mSRBenchmark.size() > 0) goto L21;
        this.mSRNotUseReason = Error.NoSRBenchmark;
        return;
    L21:
        Long r102 = this.mSRConfig.getMinDuration();
        Long r103 = this.mSRConfig.getMaxDuration();
        if (r102 == null) goto L32;
        if (r103 == null) goto L32;
        Integer r104 = this.mSRConfig.getCurrentDuration();
        if (r104 != null) goto L27;
    L30:
        this.mSRNotUseReason = Error.DurationNotSupport;
        return;
    L27:
        if (r104.intValue() < r102.longValue()) goto L30;
        if (r104.intValue() > r103.longValue()) goto L30;
    L32:
        Integer r105 = this.mSRConfig.getVideoFormatType();
        if (r105 == null) goto L40;
        Integer r106 = this.mSRConfig.getCurrentVideoFormatType();
        if (r106 != null) goto L37;
    L38:
        this.mSRNotUseReason = Error.FormatNotSupport;
        return;
    L37:
        if (r106.compareTo(Integer.valueOf(r105.intValue() & r106.intValue())) != 0) goto L38;
    L40:
        Boolean r107 = this.mSRConfig.getEnableHdr();
        if (r107 == null) goto L50;
        Boolean r108 = this.mSRConfig.getIsHdr();
        if (r108 != null) goto L45;
    L48:
        this.mSRNotUseReason = Error.HdrNotSupport;
        return;
    L45:
        if (r107.booleanValue() == true) goto L50;
        if (r108.booleanValue() == true) goto L48;
    L50:
        Integer r109 = this.mSRConfig.getSupportScene();
        if (r109 == null) goto L58;
        Integer r110 = this.mSRConfig.getCurrentScene();
        if (r110 != null) goto L55;
    L56:
        this.mSRNotUseReason = Error.SceneNotSupport;
        return;
    L55:
        if (r110.compareTo(Integer.valueOf(r109.intValue() & r110.intValue())) != 0) goto L56;
    L58:
        this.mShouldUseSRTexture = true;
        Integer r111 = this.mSRConfig.getStrategyType();
        if (r111 != null) goto L61;
    L71:
        this.mSRSatisfied = true;
        return;
    L61:
        if (1 != r111.intValue()) goto L71;
        Boolean r112 = this.mSRConfig.getEnableSpeed();
        if (r112 == null) goto L71;
        Boolean r113 = this.mSRConfig.getIsSpeed();
        if (r112.booleanValue() == true) goto L71;
        if (r113 == null) goto L71;
        if (r113.booleanValue() == false) goto L71;
        this.mSRNotUseReason = Error.SpeedNotSupport;
    }

    public String configString() {
        return this.mSRConfig.toString();
    }

    public JSONObject getConfigJson() {
        return this.mSRConfig.getJson();
    }

    public Integer getMaxHeight() {
        return this.mSRConfig.getMaxHeight();
    }

    public Integer getMaxWidth() {
        return this.mSRConfig.getMaxWidth();
    }

    public boolean isSREnabled() {
        Boolean r100 = this.mSRConfig.getEnableSR();
        if (r100 != null) goto L5;
        return false;
    L5:
        return r100.booleanValue();
    }

    public void resetAll() {
        this.mSRConfig.resetAll();
        this.mSRConfig.enableSR(false);
        this.mSRConfig.setEnableHdr(false);
        this.mSRConfig.setIsSpeed(false);
        this.mSRStrategyListener = null;
        this.mSRStrategyMode = 1;
        this.mSRSatisfied = false;
        this.mShouldUseSRTexture = false;
        this.mSRNotUseReason = 0;
        this.mSRStatus = -1;
        this.mStrategyInfo.clear();
    }

    public SRStrategy() {
        this.mSRConfig = new SRStrategyConfig();
        this.mSRStrategyListener = null;
        this.mSRStrategyMode = 1;
        this.mSRSatisfied = false;
        this.mShouldUseSRTexture = false;
        this.mSRNotUseReason = 0;
        this.mSRStatus = -1;
        this.mSRBenchmark = new HashMap();
        this.mStrategyInfo = new HashMap();
        resetAll();
        this.mSRBenchmark.put(2, new ArrayList(Arrays.asList(new Integer[]{3})));
    }

    public SRStrategyConfig getConfig() {
        return this.mSRConfig;
    }

    public Map<Integer, List<Integer>> getSRBenchmark() {
        return this.mSRBenchmark;
    }

    public int getSRNotUseReason() {
        return this.mSRNotUseReason;
    }

    public int getSRStatus() {
        return this.mSRStatus;
    }

    public int getSRStrategyMode() {
        return this.mSRStrategyMode;
    }

    public Map<String, Object> getStrategyInfo() {
        return this.mStrategyInfo;
    }

    public boolean isSRSatisfied() {
        return this.mSRSatisfied;
    }

    public boolean shouldUseSRTexture() {
        return this.mShouldUseSRTexture;
    }

    public static int getResolutionIndex(VideoInfo r100) {
        Resolution r101 = r100.getResolution();
        if (r101 == null) goto L5;
        int r102 = r101.getIndex();
    L6:
        String r103 = r100.getValueStr(32);
        if (r103 == null) goto L13;
        return CastIntegerProtector.parseInt(r103);
    L14:
        return r102;
    L13:
        return r102;
    L5:
        r102 = -1;
        goto L6
    }

    public void setSRStrategyListener(ISRStrategyListener r100) {
        this.mSRStrategyListener = r100;
    }

    public void setSRStrategyMode(int r100) {
        this.mSRStrategyMode = r100;
    }

    public void updateConfig(SRStrategyConfig r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        this.mSRConfig.updateFrom(r100);
        String r101 = r100.getExtraConfig();
        if (r101 != null) goto L8;
    L22:
        checkSatisfied();
        return;
    L8:
        if (r101.isEmpty() == true) goto L22;
        String r102 = r101.toLowerCase();
        HashMap r103 = new HashMap();
        JSONObject r104 = JSONObjectProtectorUtils.getJSONObject(JSONObjectProtectorUtils.getJSONObject(new JSONObject(r102), IVideoEventLogger.FEATURE_KEY_SR), "benchmark");     // Catch: Exception -> L20
        Iterator<String> r105 = r104.keys();     // Catch: Exception -> L20
    L12:
        if (r105.hasNext() == false) goto L18;
        String r106 = r105.next();     // Catch: Exception -> L20
        int r107 = CastIntegerProtector.parseInt(r106);     // Catch: Exception -> L20
        JSONArray r108 = JSONObjectProtectorUtils.getJSONArray(r104, r106);     // Catch: Exception -> L20
        ArrayList r109 = new ArrayList();     // Catch: Exception -> L20
        int r110 = 0;
    L15:
        if (r110 >= r108.length()) goto L17;
        r109.add(Integer.valueOf(JSONArrayProtectorUtils.getInt(r108, r110)));     // Catch: Exception -> L20
        r110 = r110 + 1;     // Catch: Exception -> L20
        goto L15
    L17:
        r103.put(Integer.valueOf(r107), r109);     // Catch: Exception -> L20
        goto L12
    L18:
        this.mSRBenchmark = r103;     // Catch: Exception -> L20
        TTVideoEngineLog.i(TAG, "[SRLog]updateConfig mSRBenchmark=" + this.mSRBenchmark);     // Catch: Exception -> L20
    L20:
        e = move-exception;
        TTVideoEngineLog.i(TAG, "[SRLog]updateConfig exception=" + e);
        e.printStackTrace();
        goto L22
    }

    public void onSRStatus(int r100, int r101) {
        int r102 = this.mSRStatus;
        if (r100 != r102) goto L6;
        return;
    L6:
        if (r100 != 0) goto L9;
        if (2 != r102) goto L9;
        return;
    L9:
        this.mSRStatus = r100;
        if (2 != r100) goto L13;
        this.mSRNotUseReason = r101;
        return;
    }

    public void setStrategyInfo(String r100, Object r101) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return;
    L6:
        if (this.mStrategyInfo.containsKey(r100) == true) goto L9;
        this.mStrategyInfo.put(r100, r101);
        return;
    }

    public Boolean videoInfoSupportSR(VideoInfo r100, List<VideoInfo> r101) {
        int r102 = getResolutionIndex(r100);
        if (this.mSRBenchmark.containsKey(Integer.valueOf(r102)) == false) goto L5;
        Integer r103 = this.mSRConfig.getScreenWidth();
        List<Integer> r104 = this.mSRBenchmark.get(Integer.valueOf(r102));
        if (r104 == null) goto L9;
        Iterator<VideoInfo> r105 = r101.iterator();
        VideoInfo r106 = null;
    L12:
        if (r105.hasNext() == false) goto L22;
        VideoInfo r107 = r105.next();
        int r108 = getResolutionIndex(r107);
        Iterator<Integer> r109 = r104.iterator();
    L15:
        if (r109.hasNext() == false) goto L12;
        if (r109.next().intValue() != r108) goto L15;
        if (r106 == null) goto L21;
        if (r106.getValueInt(3) >= r107.getValueInt(3)) goto L15;
    L21:
        r106 = r107;
        goto L12
    L22:
        if (r106 == null) goto L30;
        if (r103 == null) goto L28;
        if (r106.getValueInt(1) <= r103.intValue()) goto L30;
    L28:
        return Boolean.TRUE;
    L30:
        return Boolean.FALSE;
    L9:
        return Boolean.FALSE;
    L5:
        return Boolean.FALSE;
    }
}
