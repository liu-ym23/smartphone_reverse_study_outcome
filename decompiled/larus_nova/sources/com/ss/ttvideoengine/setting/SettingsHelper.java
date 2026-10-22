package com.ss.ttvideoengine.setting;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.vodsetting.SettingsManager;
import com.bytedance.vodsetting.a;
import com.bytedance.vodsetting.b;
import com.bytedance.vodsetting.e;
import com.bytedance.vodsetting.g;
import com.bytedance.vodsetting.h;
import com.bytedance.vodsetting.i;
import com.bytedance.vodsetting.j;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import com.ss.ttm.player.TTPlayerConfiger;
import com.ss.ttvideoengine.AppInfo;
import com.ss.ttvideoengine.BaseAppInfo;
import com.ss.ttvideoengine.DataLoaderHelper;
import com.ss.ttvideoengine.InfoWrapper;
import com.ss.ttvideoengine.TTVideoEngine;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import com.ss.ttvideoengine.configcenter.ConfigCenter;
import com.ss.ttvideoengine.net.TTVNetClient;
import com.ss.ttvideoengine.portrait.PortraitEngine;
import com.ss.ttvideoengine.strategrycenter.StrategyHelper;
import com.ss.ttvideoengine.utils.DeviceUtil;
import com.ss.ttvideoengine.utils.TTHelper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public class SettingsHelper {
    public static int HARDWARE_CONFIG_SETTINGS = 3;
    public static int HARDWARE_CONFIG_VIDEO_MODEL = 2;
    public static String MODULE_ALL = "all";
    public static String MODULE_BIZ_PORTRAIT = "biz_portrait";
    public static String MODULE_MDL = "mdl";
    public static String MODULE_VOD = "vod";
    public static String REGION_CN = "cn-north-1";
    public static String REGION_SG = "ap-singapore-1";
    public static String REGION_US = "us-east-1";
    private static final String TAG = "VodSettings";
    private Context mContext;
    private boolean mDebug;
    private String mDeviceId;
    private int mEnable;
    private final ReentrantReadWriteLock mListenerLock;
    private final ArrayList<ISettingsListener> mListeners;
    private String mMdlVersion;
    private TTVNetClient mNetClient;
    private final List<TTVNetClient> mNetClients;
    private String mPlayerVersion;
    private final SettingsManager mSettingsManager;
    private JSONObject mVodCustomJSONObject;

    /* JADX INFO: renamed from: com.ss.ttvideoengine.setting.SettingsHelper$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class HelperHolder {
        private static final SettingsHelper Instance = null;

        private HelperHolder() {
        }

        static {
            Instance = new SettingsHelper(null);
        }

        public static /* synthetic */ SettingsHelper access$100() {
            return Instance;
        }
    }

    public static class MyListener implements g {
        private MyListener() {
        }

        public /* synthetic */ MyListener(AnonymousClass1 r100) {
            this();
        }

        @Override // com.bytedance.vodsetting.g
        public void onNotify(String r100, int r101) {
            JSONObject r102 = HelperHolder.access$100().getJsonObject(r100);
            if (r102 == null) goto L9;
            StrategyHelper.helper().getCenter().I(r100, r102.toString());
            PortraitEngine.getInstance().updateLabelBySettings(r100, r102.toString());
            if (r100.equals("vod") == false) goto L7;
        L8:
            ConfigCenter.getInstance().updateVodSettings(r100, r102);
            goto L9
        L7:
            if (r100.equals("mdl") == true) goto L8;
        L9:
            SettingsHelper.access$500(SettingsHelper.helper(), r100, r101);
        }
    }

    private String _sdkVersion() {
        return "1.10.252.150-doubao";
    }

    private String _settingsVersion() {
        return "2.1.3";
    }

    private String _strategyVersion() {
        return "3.223.1";
    }

    private String _mdlVersion() {
        if (this.mMdlVersion != null) goto L6;
        this.mMdlVersion = DataLoaderHelper.getDataLoader().getStringValue(6);
    L6:
        return this.mMdlVersion;
    }

    private String _playerVersion() {
        if (this.mPlayerVersion != null) goto L6;
        this.mPlayerVersion = TTPlayerConfiger.getValue(14, "");
    L6:
        return this.mPlayerVersion;
    }

    public SettingsHelper config() {
        if (TextUtils.isEmpty(BaseAppInfo.mRegion) == false) goto L5;
    L11:
        this.mDeviceId = AppInfo.getDeviceId();
        HashMap r100 = new HashMap();
        r100.put("aid", Integer.valueOf(BaseAppInfo.mAppID));
        r100.put("app_name", BaseAppInfo.mAppName);
        r100.put("device_id", this.mDeviceId);
        r100.put("app_channel", BaseAppInfo.mAppChannel);
        r100.put("app_version", BaseAppInfo.mAppVersion);
        a.f272555e = r100;
        HashMap r101 = new HashMap();
        r101.put("sdk_version", _sdkVersion());
        r101.put(TTVideoEngineInterface.PLAY_API_KEY_PLAYERVERSION, _playerVersion());
        r101.put("st_version", _strategyVersion());
        r101.put("settings_version", _settingsVersion());
        a.f272556f = r101;
        return this;
    L5:
        if (BaseAppInfo.mRegion.equals(AppInfo.APP_REGION_CN) == false) goto L8;
        a.f272554d = AppInfo.APP_REGION_CN;
        goto L11
    L8:
        if (BaseAppInfo.mRegion.equals(AppInfo.APP_REGION_SINGAPORE) == false) goto L10;
        a.f272554d = "ap-singapore-1";
        goto L11
    L10:
        a.f272554d = BaseAppInfo.mRegion;
        goto L11
    }

    public SettingsHelper loadMDLCache() {
        if (this.mContext != null) goto L5;
        return this;
    L5:
        SettingsManager r100 = this.mSettingsManager;
        if (r100 == null) goto L8;
        ThreadMethodProxy.start(new PthreadThreadV2(new h(r100), "SettingsManager"));
    L8:
        return this;
    }

    private SettingsHelper() {
        AnonymousClass1 r100 = null;
        this.mContext = null;
        this.mPlayerVersion = null;
        this.mMdlVersion = null;
        this.mDebug = false;
        this.mEnable = 0;
        this.mNetClient = null;
        this.mNetClients = Collections.synchronizedList(new ArrayList());
        this.mListenerLock = new ReentrantReadWriteLock();
        this.mListeners = new ArrayList();
        monitor-enter(SettingsManager.class);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (SettingsManager.f272533n != null) goto L7;
        SettingsManager.f272533n = new SettingsManager();     // Catch: Throwable -> L11
    L7:
        SettingsManager r101 = SettingsManager.f272533n;     // Catch: Throwable -> L11
        monitor-exit(SettingsManager.class);
        this.mSettingsManager = r101;
        MyListener r102 = new MyListener(r100);
        r101.f272534a.writeLock().lock();
        r101.f272535b.add(r102);
        r101.f272534a.writeLock().unlock();
    }

    public static SettingsHelper helper() {
        return HelperHolder.access$100();
    }

    public SettingsManager settings() {
        return this.mSettingsManager;
    }

    public /* synthetic */ SettingsHelper(AnonymousClass1 r100) {
        this();
    }

    public static /* synthetic */ TTVNetClient access$300(SettingsHelper r100) {
        return r100.mNetClient;
    }

    private void addDeviceInfo(Map<String, Object> r100) {
        Context r101 = this.mContext;
        if (r101 == null) goto L6;
        r100.put("player_unique_id", TTVideoEngine.getEngineUniqueId(r101));
        return;
    }

    private void addLicenseInfo(Map<String, Object> r100) {
        List<String> r101 = InfoWrapper.getLicenseIds();
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.isEmpty() == true) goto L19;
        StringBuilder r102 = new StringBuilder();
        int r103 = 0;
    L8:
        if (r103 >= r101.size()) goto L13;
        String r104 = (String) ListProtector.get(r101, r103);
        if (r103 == 0) goto L12;
        r102.append(",");
    L12:
        r102.append(r104);
        r103 = r103 + 1;
        goto L8
    L13:
        r100.put("volc_license_ids", r102);
        return;
    }

    private void addSignatureInfo(Map<String, Object> r100) {
        Context r101 = this.mContext;
        if (r101 != null) goto L5;
        return;
    L5:
        String r102 = TTHelper.md5(r101.getPackageName());
        long r103 = System.currentTimeMillis() / 1000;
        String r104 = getSignature(r102, r103);
        r100.put("bundle_id", r102);
        r100.put("timestamp", Long.valueOf(r103));
        r100.put("signature", r104);
    }

    public void addListener(g r100) {
        SettingsManager r101 = this.mSettingsManager;
        if (r100 != null) goto L5;
        r101.getClass();
        return;
    L5:
        r101.f272534a.writeLock().lock();
        r101.f272535b.add(r100);
        r101.f272534a.writeLock().unlock();
    }

    public JSONObject getJsonObject(String r100) {
        if (this.mEnable != 0) goto L7;
        return null;
    L7:
        return this.mSettingsManager.f272538e.get(r100).b();
    }

    public JSONObject getMDLJsonObject(String r100) {
        if (this.mEnable != 0) goto L7;
        return null;
    L7:
        return this.mSettingsManager.f("mdl", r100);
    }

    public JSONArray getVodJsonArray(String r100) {
        if (this.mEnable != 0) goto L5;
        return null;
    L5:
        j r101 = this.mSettingsManager.f272538e.get("vod");
        r101.getClass();
        if (TextUtils.isEmpty(r100) == true) goto L34;
        r101.g(r101.f272577c);
        if ((r101.f272579e & 1) <= 0) goto L17;
        r101.f272575a.readLock().lock();
        JSONObject r102 = r101.f272576b;
        if (r102 != null) goto L13;
    L15:
        JSONArray r103 = null;
    L16:
        r101.f272575a.readLock().unlock();
    L18:
        if (r103 != null) goto L30;
        if ((r101.f272579e & 2) <= 0) goto L30;
        SharedPreferences r104 = r101.f272580f;
        if (r104 == null) goto L30;
        String r105 = r104.getString(r100, "");
        if (TextUtils.isEmpty(r105) == true) goto L30;
        r103 = new JSONArray(r105);     // Catch: JSONException -> L27
        e.b("Storage", "get JSONArray from SP, key= " + r100 + ", retValue = " + r103);     // Catch: JSONException -> L27
    L27:
        e = move-exception;
        e.a("Storage", e.toString());
        return null;
    L30:
        return r103;
    L13:
        if (r102.isNull(r100) == true) goto L15;
        r103 = r101.f272576b.optJSONArray(r100);
        goto L16
    L17:
        r103 = null;
        goto L18
    L34:
        return null;
    }

    public JSONObject getVodJsonObject(String r100) {
        if (this.mEnable != 0) goto L7;
        return null;
    L7:
        return this.mSettingsManager.f("vod", r100);
    }

    public SettingsHelper load(String r100) {
        if (this.mEnable != 0) goto L6;
        return this;
    L6:
        if (this.mContext != null) goto L8;
        return this;
    L8:
        SettingsManager r101 = this.mSettingsManager;
        if (r101 == null) goto L11;
        r101.getClass();
        ThreadMethodProxy.start(new PthreadThreadV2(new i(r101, r100), "SettingsManager"));
    L11:
        return this;
    }

    public void removeListener(ISettingsListener r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.mListenerLock.writeLock().lock();
        this.mListeners.remove(r100);
        this.mListenerLock.writeLock().unlock();
    }

    public SettingsHelper setContext(Context r100) {
        this.mContext = r100;
        if (this.mSettingsManager == null) goto L12;
        SettingsManager r101 = this.mSettingsManager;
        if (r101.f272536c != null) goto L11;
        r101.f272536c = r100;
        Iterator<j> r102 = r101.f272538e.values().iterator();
    L8:
        if (r102.hasNext() == false) goto L10;
        r102.next().f272577c = r100;
        goto L8
    L10:
        r100.getApplicationContext();
        r101.f272537d = new b(new SettingsManager.b(r101, r101));
    L11:
        SettingsManager r103 = this.mSettingsManager;
        boolean r104 = this.mDebug;
        r103.f272537d.f272558b = r104;
        e.f272570a = r104;
        this.mSettingsManager.f272537d.f272563g = new AnonymousClass2(this);
    L12:
        return this;
    }

    public void setDebug(boolean r100) {
        this.mDebug = r100;
    }

    public void setEnable(int r100) {
        this.mEnable = r100;
        if (a.f272554d == null) goto L6;
        config().load(MODULE_ALL);
        return;
    }

    public void setEnableNotLoad(int r100) {
        this.mEnable = r100;
    }

    public void setNetClient(TTVNetClient r100) {
        monitor-enter(this);
        this.mNetClient = r100;     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public void setVodCustomJSONObject(JSONObject r100) {
        monitor-enter(this);
        this.mVodCustomJSONObject = r100;     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public void addListener(ISettingsListener r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.mListenerLock.writeLock().lock();
        this.mListeners.add(r100);
        this.mListenerLock.writeLock().unlock();
    }

    private void _notifyListener(String r100, int r101) {
        this.mListenerLock.readLock().lock();
        ArrayList r102 = new ArrayList(this.mListeners);
        this.mListenerLock.readLock().unlock();
        Iterator r103 = r102.iterator();
    L4:
        if (r103.hasNext() == false) goto L10;
        ISettingsListener r104 = (ISettingsListener) r103.next();
        if (r101 != 1000) goto L4;
        if (r100 != MODULE_BIZ_PORTRAIT) goto L4;
        r104.onNotify(1);
        goto L4
    }

    public static /* synthetic */ TTVNetClient access$302(SettingsHelper r100, TTVNetClient r101) {
        r100.mNetClient = r101;
        return r101;
    }

    private String buildURLString(String r100, Map<String, String> r101) {
        if (r100 == null) goto L14;
        if (r101 != null) goto L5;
        return r100;
    L5:
        if (r101.isEmpty() == true) goto L16;
        Uri.Builder r102 = UriProtector.parse(r100).buildUpon();
        Iterator<Map.Entry<String, String>> r103 = r101.entrySet().iterator();
    L9:
        if (r103.hasNext() == false) goto L12;
        Map.Entry<String, String> r104 = r103.next();
        r102.appendQueryParameter(r104.getKey(), r104.getValue());
        goto L9
    L12:
        return r102.build().toString();
    L16:
        return r100;
    L14:
        return r100;
    }

    private String getSignature(String r100, long r101) {
        return TTHelper.hmacSha1(r100 + "&" + BaseAppInfo.mAppID + "&" + this.mDeviceId + "&" + DeviceUtil.getDeviceModel().toLowerCase() + "&" + r101);
    }

    public int getMDLInt(String r100, int r101) {
        if (this.mEnable != 0) goto L6;
        return r101;
    L6:
        return this.mSettingsManager.f272538e.get("mdl").a(r100, r101);
    }

    public long getMDLLong(String r100, long r101) {
        if (this.mEnable != 0) goto L6;
        return r101;
    L6:
        return this.mSettingsManager.f272538e.get("mdl").c(r100, r101);
    }

    public String getMDLString(String r100, String r101) {
        if (this.mEnable != 0) goto L6;
        return r101;
    L6:
        return this.mSettingsManager.g("mdl", r100, r101);
    }

    public int getVodInt(String r100, int r101) {
        if (this.mEnable != 0) goto L6;
        return r101;
    L6:
        return this.mSettingsManager.f272538e.get("vod").a(r100, r101);
    }

    public long getVodLong(String r100, long r101) {
        if (this.mEnable != 0) goto L6;
        return r101;
    L6:
        return this.mSettingsManager.f272538e.get("vod").c(r100, r101);
    }

    public String getVodString(String r100, String r101) {
        if (this.mEnable != 0) goto L6;
        return r101;
    L6:
        return this.mSettingsManager.g("vod", r100, r101);
    }

    public SettingsHelper setRegionHost(int r100, String r101) {
        switch(r100) {
            case 116: goto L6;
            case 117: goto L5;
            case 118: goto L4;
            default: goto L7;
        };
    L4:
        a.f272551a = r101;
        goto L7
    L5:
        a.f272552b = r101;
        goto L7
    L6:
        a.f272553c = r101;
    L7:
        return this;
    }

    public static /* synthetic */ String access$400(SettingsHelper r100, String r101, Map r102) {
        return r100.buildURLString(r101, r102);
    }

    public static /* synthetic */ void access$500(SettingsHelper r100, String r101, int r102) {
        r100._notifyListener(r101, r102);
    }
}
