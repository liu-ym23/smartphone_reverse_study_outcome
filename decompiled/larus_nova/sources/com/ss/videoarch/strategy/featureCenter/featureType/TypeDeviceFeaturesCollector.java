package com.ss.videoarch.strategy.featureCenter.featureType;

import android.os.BatteryManager;
import com.bytedance.android.livesdkapi.performance.IPerformanceStrategyManager;
import com.bytedance.common.graphics.GraphicsMonitor;
import com.ss.videoarch.strategy.LiveStrategyManager;
import com.ss.videoarch.strategy.dataCenter.config.LSSettings;
import com.ss.videoarch.strategy.dataCenter.config.model.FeatureConfigInfo;
import et3.c;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;
import st3.a;
import ts3.b;

/* JADX INFO: loaded from: classes38.dex */
public class TypeDeviceFeaturesCollector extends BaseTypeFeaturesCollector {
    public static final String BATTERY_PERCENTAGE = "battery_percentage";
    public static final String BATTERY_STATUS = "battery_status";
    public static final String BATTERY_TEMPERATURE = "battery_temperature";
    public static final String CPU_SPEED = "cpu_speed";
    public static final String MEM_GRAPHICS = "mem_graphics";
    public static final String MEM_JAVA_FREE = "mem_java_free";
    public static final String MEM_JAVA_TOTAL = "mem_java_total";
    public static final String MEM_JAVA_USED = "mem_java_used";
    public static final String MEM_PSS_DALVIK = "mem_pss_dalvik";
    public static final String MEM_PSS_NATIVE = "mem_pss_native";
    public static final String MEM_PSS_TOTAL = "mem_pss_total";
    public static final String MEM_VMSIZE = "mem_vmsize";
    private static final String TAG = "TypeDeviceFeatures";
    private static volatile TypeDeviceFeaturesCollector sInstance;
    private JSONObject mBatteryCacheInfo;
    private long mBatteryCacheLatestUpdateTime;
    private double mCpuRateCache;
    private long mCpuRateCacheLatestUpdateTime;
    private double mCpuSpeedCache;
    private long mCpuSpeedCacheLatestUpdateTime;
    public double mFps;
    public ConcurrentHashMap<String, c> mFpsTracerMap;
    private double mGpuUsageCache;
    private long mGpuUsageCacheLatestUpdateTime;
    public boolean mInitGraphicsAlready;
    private JSONObject mMemoryInfoCache;
    private long mMemoryInfoCacheLatestUpdateTime;

    public static TypeDeviceFeaturesCollector inst() {
        if (sInstance != null) goto L15;
        monitor-enter(TypeDeviceFeaturesCollector.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new TypeDeviceFeaturesCollector();     // Catch: Throwable -> L11
    L9:
        monitor-exit(TypeDeviceFeaturesCollector.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    public JSONObject getBatteryInfo() {
        JSONObject r100 = new JSONObject();
        if (LiveStrategyManager.inst().mBatteryIntent == null) goto L11;
        float r101 = LiveStrategyManager.inst().mBatteryIntent.getIntExtra(IPerformanceStrategyManager.KEY_FLOAT_TEMPERATURE, 0) / 10;
        BatteryManager r102 = (BatteryManager) LiveStrategyManager.inst().mContext.getSystemService("batterymanager");     // Catch: Exception -> L9
        if (r102 == null) goto L11;
        int r103 = r102.getIntProperty(4);     // Catch: Exception -> L9
        r100.put(BATTERY_PERCENTAGE, r103).put(BATTERY_STATUS, r102.getIntProperty(6)).put(BATTERY_TEMPERATURE, r101);     // Catch: Exception -> L9
    L9:
        e = move-exception;
        e.printStackTrace();
    L11:
        return r100;
    }

    private TypeDeviceFeaturesCollector() {
        this.mCpuRateCache = -1.0d;
        this.mCpuRateCacheLatestUpdateTime = 0;
        this.mCpuSpeedCache = -1.0d;
        this.mCpuSpeedCacheLatestUpdateTime = 0;
        this.mGpuUsageCache = -1.0d;
        this.mGpuUsageCacheLatestUpdateTime = 0;
        this.mFps = -1.0d;
        this.mMemoryInfoCache = new JSONObject();
        this.mMemoryInfoCacheLatestUpdateTime = 0;
        this.mBatteryCacheInfo = new JSONObject();
        this.mBatteryCacheLatestUpdateTime = 0;
        this.mFpsTracerMap = new ConcurrentHashMap();
        this.mInitGraphicsAlready = false;
        this.mTypeKey = "TypeDeviceFeature";
        FeatureConfigInfo r100 = this.mFeatureConfigInfo;
        if (r100 == null) goto L6;
        r100.mFeatureTypeName = "TypeDeviceFeature";
        return;
    }

    public void initGraphicsMonitor() {
        if (LSSettings.inst().mCommonConfigInfo.mLSStrategySDKSettings.mEnableDeviceFeatureData == 1) goto L5;
        return;
    L5:
        if (this.mInitGraphicsAlready == true) goto L9;
        GraphicsMonitor.init();
        GraphicsMonitor.start();
        this.mInitGraphicsAlready = true;
        return;
    }

    public void startFpsCollect(JSONObject r100) {
        if (r100 == null) goto L4;
        String r101 = r100.optString("PLAY-SessionID");
    L5:
        c r102 = new c(r101);
        r102.c(new AnonymousClass1(this));
        this.mFpsTracerMap.put(r101, r102);
        r102.d();
        return;
    L4:
        r101 = "";
        goto L5
    }

    public void stopFpsCollect(JSONObject r100) {
        if (r100 == null) goto L4;
        String r101 = r100.optString("PLAY-SessionID");
    L5:
        ConcurrentHashMap<String, c> r102 = this.mFpsTracerMap;
        if (r102 != null) goto L8;
        return;
    L8:
        if (r102.containsKey(r101) == false) goto L14;
        c r103 = this.mFpsTracerMap.get(r101);
        if (r103 == null) goto L15;
        r103.f();
        this.mFpsTracerMap.remove(r101);
        this.mFpsTracerMap.size();
        return;
    L15:
        return;
    L14:
        return;
    L4:
        r101 = "";
        goto L5
    }

    @Override // com.ss.videoarch.strategy.featureCenter.featureType.BaseTypeFeaturesCollector
    public JSONObject fillInputFeatures(JSONObject r100, JSONArray r110, String r111, String r112, JSONObject r113) {
        long r114 = System.currentTimeMillis();
        int r101 = 0;
    L4:
        if (r101 >= r110.length()) goto L66;
        String r102 = r110.optString(r101);
        switch(r102.hashCode()) {
            case -1095838600: goto L25;
            case -891779722: goto L22;
            case 293563702: goto L19;
            case 425068049: goto L16;
            case 1266057426: goto L13;
            case 1266058389: goto L10;
            default: goto L27;
        };     // Catch: Exception -> L63
    L27:
        byte r103 = -1;
    L28:
        if (r103 == 0) goto L59;
        if (r103 == 1) goto L55;
        if (r103 == 2) goto L51;
        if (r103 == 3) goto L47;
        if (r103 == 4) goto L45;
        if (r103 == 5) goto L42;
        Map<String, Object> r104 = LSSettings.inst().mUserParams;     // Catch: Exception -> L63
        String[] r105 = r102.split("-", 2);     // Catch: Exception -> L63
        if (r105.length != 2) goto L65;
        String r106 = r105[1].toLowerCase();     // Catch: Exception -> L63
        if (r104.containsKey(r106) == false) goto L40;
        r100.put(r102, r104.get(r106));     // Catch: Exception -> L63
        goto L65
    L40:
        r100.put(r102, "none");     // Catch: Exception -> L63
    L65:
        r101 = r101 + 1;
        goto L4
    L42:
        if ((r114 - this.mBatteryCacheLatestUpdateTime) >= LSSettings.inst().mCommonConfigInfo.mLSStrategySDKSettings.mDeviceFeatureEffectiveTime) goto L44;
        r100.put(r102, this.mBatteryCacheInfo);     // Catch: Exception -> L63
        goto L65
    L44:
        JSONObject r107 = getBatteryInfo();     // Catch: Exception -> L63
        this.mBatteryCacheInfo = r107;     // Catch: Exception -> L63
        this.mBatteryCacheLatestUpdateTime = r114;     // Catch: Exception -> L63
        r100.put(r102, r107);     // Catch: Exception -> L63
        goto L65
    L45:
        r100.put(r102, this.mFps);     // Catch: Exception -> L63
        goto L65
    L47:
        if ((r114 - this.mMemoryInfoCacheLatestUpdateTime) >= LSSettings.inst().mCommonConfigInfo.mLSStrategySDKSettings.mDeviceFeatureEffectiveTime) goto L49;
        r100.put(r102, this.mMemoryInfoCache);     // Catch: Exception -> L63
        goto L65
    L49:
        JSONObject r108 = new JSONObject();     // Catch: Exception -> L63
        b r109 = ss3.c.a(LiveStrategyManager.inst().mContext);     // Catch: Exception -> L63
        r108.put("mem_java_total", r109.f547365a);     // Catch: Exception -> L63
        r108.put("mem_java_free", r109.f547366b);     // Catch: Exception -> L63
        r108.put("mem_java_used", r109.f547367c);     // Catch: Exception -> L63
        r108.put("mem_pss_dalvik", r109.f547368d);     // Catch: Exception -> L63
        r108.put("mem_pss_native", r109.f547369e);     // Catch: Exception -> L63
        r108.put("mem_pss_total", r109.f547370f);     // Catch: Exception -> L63
        r108.put("mem_graphics", r109.f547371g);     // Catch: Exception -> L63
        r108.put("mem_vmsize", r109.f547372h);     // Catch: Exception -> L63
        this.mMemoryInfoCache = r108;     // Catch: Exception -> L63
        this.mMemoryInfoCacheLatestUpdateTime = r114;     // Catch: Exception -> L63
        r100.put(r102, r108);     // Catch: Exception -> L63
        goto L65
    L51:
        if ((r114 - this.mGpuUsageCacheLatestUpdateTime) >= LSSettings.inst().mCommonConfigInfo.mLSStrategySDKSettings.mDeviceFeatureEffectiveTime) goto L53;
        r100.put(r102, this.mGpuUsageCache);     // Catch: Exception -> L63
        goto L65
    L53:
        double r115 = GraphicsMonitor.getByteGpu();     // Catch: Exception -> L63
        this.mGpuUsageCache = r115;     // Catch: Exception -> L63
        this.mGpuUsageCacheLatestUpdateTime = r114;     // Catch: Exception -> L63
        r100.put(r102, r115);     // Catch: Exception -> L63
        goto L65
    L55:
        if ((r114 - this.mCpuSpeedCacheLatestUpdateTime) >= LSSettings.inst().mCommonConfigInfo.mLSStrategySDKSettings.mDeviceFeatureEffectiveTime) goto L57;
        r100.put(r102, this.mCpuSpeedCache);     // Catch: Exception -> L63
        goto L65
    L57:
        a.b().getClass();     // Catch: Exception -> L63
        double r116 = a.a().f547364b;     // Catch: Exception -> L63
        this.mCpuSpeedCache = r116;     // Catch: Exception -> L63
        this.mCpuSpeedCacheLatestUpdateTime = r114;     // Catch: Exception -> L63
        r100.put(r102, r116);     // Catch: Exception -> L63
        goto L65
    L59:
        if ((r114 - this.mCpuRateCacheLatestUpdateTime) >= LSSettings.inst().mCommonConfigInfo.mLSStrategySDKSettings.mDeviceFeatureEffectiveTime) goto L61;
        r100.put(r102, this.mCpuRateCache);     // Catch: Exception -> L63
        goto L65
    L61:
        a.b().getClass();     // Catch: Exception -> L63
        double r117 = a.a().f547363a;     // Catch: Exception -> L63
        this.mCpuRateCache = r117;     // Catch: Exception -> L63
        this.mCpuRateCacheLatestUpdateTime = r114;     // Catch: Exception -> L63
        r100.put(r102, r117);     // Catch: Exception -> L63
        goto L65
    L10:
        if (r102.equals("DEVICE-Gpu") == false) goto L27;
        r103 = 2;
        goto L28
    L13:
        if (r102.equals("DEVICE-Fps") == false) goto L27;
        r103 = 4;
        goto L28
    L16:
        if (r102.equals("DEVICE-CpuRate") == false) goto L27;
        r103 = 0;
        goto L28
    L19:
        if (r102.equals("DEVICE-CpuSpeed") == false) goto L27;
        r103 = 1;
        goto L28
    L22:
        if (r102.equals("DEVICE-Battery") == false) goto L27;
        r103 = 5;
        goto L28
    L25:
        if (r102.equals("DEVICE-Memory") == false) goto L27;
        r103 = 3;
    L63:
        e = move-exception;
        e.printStackTrace();
        goto L65
    L66:
        return r100;
    }
}
