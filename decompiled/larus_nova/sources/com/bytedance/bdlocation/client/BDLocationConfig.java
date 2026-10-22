package com.bytedance.bdlocation.client;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import androidx.camera.video.AudioStats;
import com.bytedance.bdlocation.BDLocation;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.bdlocation.LocationUtil;
import com.bytedance.bdlocation.callback.BDRestrictedMode;
import com.bytedance.bdlocation.callback.IDYHostInfoProvider;
import com.bytedance.bdlocation.callback.ILiveExperienceProvider;
import com.bytedance.bdlocation.callback.ILocationInfoExtra;
import com.bytedance.bdlocation.callback.IPermissionChecker;
import com.bytedance.bdlocation.callback.LocationNotification;
import com.bytedance.bdlocation.callback.LocationSubmitNotification;
import com.bytedance.bdlocation.entity.LogIdCacheEntity;
import com.bytedance.bdlocation.entity.bpea.BPEACertCheckResult;
import com.bytedance.bdlocation.event.IEventManager;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.bdlocation.network.ICustomNetworkApi;
import com.bytedance.bdlocation.permission.PermissionManager;
import com.bytedance.bdlocation.scan.bluetooth.BLECacheEntity;
import com.bytedance.bdlocation.service.BDLocationExtrasService;
import com.bytedance.bdlocation.settings.LocationSettingUtil;
import com.bytedance.bdlocation.store.LocationCache;
import com.bytedance.bdlocation.utils.BDLocationReflectUtils;
import com.bytedance.bdlocation.utils.background.BackgroundProvider;
import com.bytedance.ee.bear.sheet.filter.FilterData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.text.Typography;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class BDLocationConfig {
    private static final String DEFAULT_SLARDAR_AID = "306184";
    public static final String ENABLE_BPEA_CACHE_KEY = "enable_bpea_cache";
    private static final String OPEN_STATIONARY_SCENE_LOCK = "open_stationary_scene_lock";
    private static String RESTRICTED_LOCK = null;
    public static final String TAG = "BDLocation";
    private static boolean isDebug = false;
    private static volatile boolean isInit = false;
    private static boolean isPrivacyConfirmed = false;
    private static BLECacheEntity mBleCacheEntity = null;
    private static boolean mEnableTraceroute = false;
    private static LogIdCacheEntity mLogIdCacheEntity = null;
    private static JSONObject mShakeConfig = null;
    private static boolean sAllowFetchConfigAtStart = false;
    private static boolean sAllowLocateFallback = true;
    private static long sAppBootTime = 0;
    private static String sAppId = null;
    private static String sAppVersion = null;
    private static boolean sAsyncScanWifi = false;
    private static int sBaseStationInfoType = 0;
    private static String sBaseUrl = null;
    private static JSONObject sBeaconConfig = null;
    private static long sBootLegitimateTime = 3000;
    private static Map<String, Object> sBpeaCerts = null;
    private static int sBssNum = 10;
    private static String sByteLocationLibraParam = null;
    private static String sByteLocationWhiteList = null;
    private static String sChannel = null;
    private static boolean sCheckLocationBpea = false;
    private static long sCheckRefreshWifiTimeInterval = 0;
    private static boolean sColdBootABTest = false;
    private static boolean sColdBootCollectGps = false;
    private static int sColdBootCollectGpsStrategy = 0;
    private static long sCollectContinuousGPSDuration = 0;
    private static long sCollectContinuousGPSInterval = 0;
    private static String sCollectContinuousGPSTokenBlacklist = null;
    private static boolean sCollectContinuousGpsDisableGnssUpload = false;
    private static boolean sCollectContinuousGpsOnlyLast = false;
    private static int sCollectGpsType = 0;
    private static boolean sCollectLightInfo = false;
    private static Map<String, String> sCommonParams = null;
    private static int sConnectWifiRssi = 0;
    private static volatile Context sContext = null;
    private static int sContinueAccelerometerInterval = 0;
    private static int sContinueGyroscopeInterval = 0;
    private static int sContinueLightInfoInterval = 0;
    private static int sContinueMagnetometerInterval = 0;
    private static int sContinuePressureInterval = 0;
    private static IDYHostInfoProvider sDYHostInfoProvider = null;
    private static long sDefaultGpsScanInterval = 0;
    private static String sDeviceId = null;
    private static String sDisableCollectAMapLocationSource = null;
    private static String sDisableTailLocateOptimizeSource = null;
    private static List<String> sDisableUuidList = null;
    private static boolean sEenableBackgroundUploadLocation = false;
    private static boolean sEnableAcceptLightLocationParam = false;
    private static boolean sEnableBackgroundLocation = false;
    private static boolean sEnableBlePassiveName = false;
    private static boolean sEnableBleTruncateOnTimeout = false;
    private static boolean sEnableBpea = false;
    private static boolean sEnableByteContinuousLocation = false;
    private static boolean sEnableCheckConnectWifi = false;
    private static boolean sEnableCheckLastLogId = false;
    private static boolean sEnableCheckRefreshWifiTime = false;
    private static boolean sEnableCheckUploadCompliance = false;
    private static boolean sEnableCollectAMapLocationInBatterySavingMode = false;
    private static boolean sEnableCollectBleInBatterySavingMode = false;
    private static boolean sEnableCollectContinuousGPSLocation = false;
    private static boolean sEnableCollectContinuousGpsForTest = false;
    private static boolean sEnableCollectGPSLocationInBatterySavingMode = false;
    private static boolean sEnableCollectNetworkLocationInBatterySavingMode = false;
    private static boolean sEnableContinueLocateUploadCell = false;
    private static boolean sEnableContinueLocateUploadWifi = false;
    private static boolean sEnableDestroyAMapContinuousClient = false;
    private static boolean sEnableDestroyAMapSingleClient = false;
    private static boolean sEnableDimLocationCheck = false;
    private static boolean sEnableFusionLocation = false;
    private static volatile boolean sEnableGetNeighboringCell = false;
    private static boolean sEnableGpsScan = false;
    private static boolean sEnableHARCollect = false;
    private static boolean sEnableInfoRequestOpt = false;
    private static boolean sEnableLightLocation = false;
    private static boolean sEnableLightLocationNewPolicy = false;
    private static boolean sEnableLocationCacheTokenWhiteList = false;
    private static String sEnableLocationOptBpeaList = "";
    private static boolean sEnableLocationOptEncrypt = false;
    private static boolean sEnableMonitor = false;
    private static boolean sEnablePreLocationCallback = false;
    private static boolean sEnableRescanWifi = false;
    private static boolean sEnableScanGnss = false;
    private static boolean sEnableScanWifi = false;
    private static boolean sEnableSelfStartService = false;
    private static boolean sEnableStationaryScenePolicy = false;
    private static boolean sEnableTailLocateOptimize = false;
    private static boolean sEnableUploadLastLocationInfo = false;
    private static boolean sEnableUploadLastLogId = false;
    private static boolean sEnableUseCoarseLocation = false;
    private static Pair<String, String> sEnv = null;
    private static IEventManager sEventManager = null;
    private static long sFirstLocationTimeoutMs = 0;
    private static boolean sFirstRequestLocation = false;
    private static long sFreshBaseStationTimeout = 0;
    private static int sFusionLocationAccelerometerIntervalUs = 0;
    private static int sFusionLocationBarometerIntervalUs = 0;
    private static long sFusionLocationDopIntervalMs = 0;
    private static boolean sFusionLocationEnableTrackUpload = false;
    private static long sFusionLocationGpsIntervalMs = 0;
    private static int sFusionLocationGyroscopeIntervalUs = 0;
    private static int sFusionLocationHeadingIntervalUs = 0;
    private static int sFusionLocationLightIntervalUs = 0;
    private static int sFusionLocationMagnetometerIntervalUs = 0;
    private static long sFusionLocationSatelliteInfoIntervalMs = 0;
    private static long sFusionLocationSensorBatchPushIntervalMs = 0;
    private static int sFusionLocationTempIntervalUs = 0;
    private static int sFusionLocationTrackIntervalSec = 0;
    private static long sGpsScanInterval = 0;
    private static int sHARStatusRange = 0;
    private static int sHotBootCacheTime = 0;
    private static String sHotBootLocToken = null;
    private static long sInOutDoorStatusCacheTime = 0;
    private static long sInfoRequestKeyParamsMaxCacheTime = 0;
    private static long sInitStartTime = 0;
    private static volatile int sInvokerApiInitStatus = 0;
    private static boolean sIsAMapGPSCollectAlwaysUseNewAMapClient = true;
    private static boolean sIsChineseChannel = false;
    private static boolean sIsFirstLocation = false;
    private static boolean sIsIndepentThreadGetScanResults = false;
    private static boolean sIsMockEnable = false;
    private static boolean sIsMockUpload = false;
    private static boolean sIsNoLocReqCgiEnable = false;
    private static boolean sIsPollingUpload = false;
    private static boolean sIsStrictRestrictedMode = false;
    private static boolean sIsSysNetworkLocEnable = false;
    private static boolean sIsUpload = true;
    private static boolean sIsUploadBaseSite = true;
    private static boolean sIsUploadFreshBaseStation = false;
    private static boolean sIsUploadGPS = true;
    private static boolean sIsUploadLocation = true;
    private static boolean sIsUploadWIFI = true;
    private static boolean sIsUseQuickGPS = false;
    private static int sLightInfoInterval = 0;
    private static ILiveExperienceProvider sLiveExperienceProvider = null;
    private static volatile boolean sLiveStallReportEnabled = false;
    private static volatile int sLiveStallReportWindowMs = 0;
    private static long sLocalDefaultGpsScanInterval = 0;
    private static Locale sLocale = null;
    private static int sLocateType = 0;
    private static String sLocationCacheTokenWhiteList = null;
    private static long sLocationExpiredInterval = 0;
    private static ILocationInfoExtra sLocationInfoExtra = null;
    private static int sLocationMode = 0;
    private static int sMaxLightCount = 0;
    private static long sMaxLightDuration = 0;
    private static long sMaxLocationTimeMs = 300000;
    private static long sMaxWaitGpsTimeMillis = 0;
    private static String sMockWifiName = null;
    private static List<String> sMonitorBusinessStartLocationClassMemberList = null;
    private static List<String> sMonitorBusinessStopLocationClassMemberList = null;
    private static int sMonitorStrategy = 0;
    private static List<String> sMonitorStrategyClassMemberList = null;
    private static long sMonitorStrategyInterval = 0;
    private static boolean sNeedDownGradeLocationInOverseas = false;
    private static boolean sNeedUploadLastContinuousLocation = false;
    private static ICustomNetworkApi sNetworkApi = null;
    private static String sNetworkSignatureMode = null;
    private static long sNetworkStatusChangeUploadInterval = 60000;
    private static SparseArray<List<LocationNotification>> sNotifications = null;
    private static boolean sOnline = false;
    private static boolean sOpenStationaryScene = false;
    private static boolean sOpenWifiListMonitor = false;
    private static long sOverseasGetLocationFailedUseCacheValidity = 0;
    private static String sPackageName = null;
    private static IPermissionChecker sPermissionChecker = null;
    private static BackgroundProvider sProvider = null;
    private static String sRedGeoNameIds = null;
    private static boolean sRegionInChineseChannel = false;
    private static boolean sReportAtStart = true;
    private static boolean sReportLocationAtStart = false;
    private static int sRescanWifiCount = 0;
    private static BDRestrictedMode sRestrictedMode = null;
    private static boolean sRevertToSystemLocation = false;
    private static boolean sScanBle = false;
    private static long sScanBleInterval = 0;
    public static final long sScanBleMaxInterval = 10000;
    private static String sSdkVersion = null;
    private static long sSearchLocationCacheTime = 0;
    private static boolean sSensorAccelerometerEnabled = false;
    private static boolean sSensorBarometerEnabled = false;
    private static boolean sSensorContinuousCollectEnabled = false;
    private static boolean sSensorDopEnabled = false;
    private static boolean sSensorGnssEnabled = false;
    private static boolean sSensorGyroscopeEnabled = false;
    private static boolean sSensorLightEnabled = false;
    private static boolean sSensorMagnetometerEnabled = false;
    private static long sSensorMaxCacheSeconds = 0;
    private static String sSessionId = null;
    private static boolean sShouldRequestLocation = false;
    private static String sSlardarAid = null;
    private static int sStationarySceneMaxDistance = 0;
    private static int sStationarySceneMaxGpsAccuracy = 0;
    private static long sStationarySceneMaxInterval = 0;
    private static String sStationarySceneTokenWhiteList = null;
    private static String sStationarySceneWifiWhiteList = null;
    private static List<LocationSubmitNotification> sSubmitNotifications = null;
    private static float sTailAccuracyThreshold = 0.0f;
    private static long sTailWifiTimeThreshold = 0;
    private static String sUpdateVersionCode = null;
    private static boolean sUploadBleImmediately = false;
    private static int sUploadBleNum = 0;
    private static long sUploadInterval = 300000;
    private static boolean sUploadMccAndSystemRegionInfo = true;
    private static long sUploadNetSignalInterval = 0;
    private static boolean sUseCacheCondition = false;
    private static boolean sUseGpsCheckRegion = false;
    private static boolean sUseNewCacheStrategy = false;
    private static boolean sUseNewReverseGeoLocationApi = false;
    private static int sWifiNum = 30;
    private static long sWifiScanInterval;
    private static String sWorldView;

    public BDLocationConfig() {
    }

    public static /* synthetic */ void a(int r100, BDLocation r101) {
        lambda$notificationLocationChange$0(r100, r101);
    }

    public static boolean enableInvokerApiInit() {
        if (sInvokerApiInitStatus == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static long getDefaultGpsScanInterval() {
        if (sDefaultGpsScanInterval != 0) goto L15;
        if (isInit == false) goto L15;
        if (enableUseCoarseLocation() == false) goto L15;
        if (sContext == null) goto L15;
        if (PermissionManager.isApproximateLocation(sContext, false) == false) goto L15;
        Logger.i("BDLocationConfig getDefaultGpsScanInterval sLocalDefaultGpsScanInterval:" + sLocalDefaultGpsScanInterval);
        return sLocalDefaultGpsScanInterval;
    L15:
        return sDefaultGpsScanInterval;
    }

    public static String getDeviceInfoExtra() {
        ILocationInfoExtra r100 = sLocationInfoExtra;
        if (r100 != null) goto L5;
        return null;
    L5:
        JSONObject r101 = r100.getDeviceInfoExtra();
        if (r101 != null) goto L9;
        return null;
    L9:
        return r101.toString();
    }

    public static String getMockWifiName() {
        if (sMockWifiName != null) goto L6;
        sMockWifiName = LocationCache.getInstance().getMockWifiName();
    L6:
        return sMockWifiName;
    }

    public static BDRestrictedMode getRestricted() {
        BDRestrictedMode r100 = sRestrictedMode;
        if (r100 != null) goto L6;
        return null;
    L6:
        return r100;
    }

    public static int getRestrictedMode() {
        BDRestrictedMode r100 = sRestrictedMode;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.getRestrictedMode();
    }

    public static JSONObject getSubmitExtra() {
        ILocationInfoExtra r100 = sLocationInfoExtra;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getSubmitExtra();
    }

    public static boolean initIfNeed() {
        if (sContext != null) goto L5;
    L8:
        Logger.i(BDLocationReflectUtils.TAG, "initIfNeed: invoked, not initialized yet, start weakEnsureAwemeLocationInit.");
        BDLocationReflectUtils.weakEnsureAwemeLocationInit();
        if (sContext != null) goto L11;
    L14:
        Logger.i(BDLocationReflectUtils.TAG, "initIfNeed: invoked, after weakEnsureAwemeLocationInit, not inited, return false.");
        return false;
    L11:
        if (isInit == false) goto L14;
        Logger.i(BDLocationReflectUtils.TAG, "initIfNeed: invoked, after weakEnsureAwemeLocationInit, already inited, return true.");
        return true;
    L5:
        if (isInit == false) goto L8;
        Logger.i(BDLocationReflectUtils.TAG, "initIfNeed: invoked, already inited, return true.");
        return true;
    }

    public static boolean isRestrictedModeOn() {
        BDRestrictedMode r100 = sRestrictedMode;
        if (r100 != null) goto L5;
        return false;
    L5:
        int r101 = r100.getRestrictedMode();
        Logger.i("BDLocationConfig restrictedMode:" + r101);
        if (r101 != 1) goto L9;
        return true;
    L9:
        return false;
    }

    public static boolean legacyCheckInit() {
        if (sContext != null) goto L5;
    L8:
        Logger.i(BDLocationReflectUtils.TAG, "legacyCheckInit: invoked, already inited: false.");
        return false;
    L5:
        if (isInit == false) goto L8;
        Logger.i(BDLocationReflectUtils.TAG, "legacyCheckInit: invoked, already inited: true.");
        return true;
    }

    static {
        sLocale = Locale.getDefault();
        sIsChineseChannel = true;
        sLocateType = 3;
        RESTRICTED_LOCK = "RESTRICTED_LOCK";
        sIsStrictRestrictedMode = false;
        sBaseUrl = "";
        sNotifications = new SparseArray();
        isPrivacyConfirmed = false;
        sOnline = true;
        sIsMockEnable = false;
        sIsMockUpload = true;
        isInit = false;
        sSlardarAid = DEFAULT_SLARDAR_AID;
        sDeviceId = "";
        sAppId = "";
        sSdkVersion = BuildConfig.BDLOCATION_VERSION;
        sChannel = "";
        sAppVersion = "";
        sUpdateVersionCode = "";
        sPackageName = "";
        sLiveStallReportEnabled = false;
        sLiveStallReportWindowMs = 5000;
        sEnableHARCollect = false;
        sHARStatusRange = 64;
        sEnableBpea = true;
        sUploadBleNum = 30;
        sScanBleInterval = 1000;
        sScanBle = false;
        sEnableBlePassiveName = true;
        sEnableBleTruncateOnTimeout = true;
        sCheckLocationBpea = false;
        sLocationMode = 2;
        sSubmitNotifications = null;
        sFirstRequestLocation = true;
        sOverseasGetLocationFailedUseCacheValidity = LocationInfoConst.defaultsOverseasCacheValidity;
        sRegionInChineseChannel = true;
        sRedGeoNameIds = LocationInfoConst.defaultRedGeoNameIds;
        sIsFirstLocation = true;
        sUseNewCacheStrategy = false;
        sCollectLightInfo = false;
        sRevertToSystemLocation = false;
        sLightInfoInterval = 3;
        sMaxLightCount = 30;
        sMaxLightDuration = 5000;
        sSensorContinuousCollectEnabled = false;
        sSensorLightEnabled = true;
        sContinueLightInfoInterval = 100000;
        sSensorMaxCacheSeconds = 5;
        sSensorAccelerometerEnabled = true;
        sContinueAccelerometerInterval = 20000;
        sSensorGyroscopeEnabled = true;
        sContinueGyroscopeInterval = 20000;
        sSensorMagnetometerEnabled = true;
        sContinueMagnetometerInterval = 20000;
        sSensorBarometerEnabled = true;
        sSensorDopEnabled = true;
        sSensorGnssEnabled = true;
        sContinuePressureInterval = 100000;
        sGpsScanInterval = 0;
        sEnableGpsScan = false;
        sAsyncScanWifi = true;
        sConnectWifiRssi = -60;
        sCheckRefreshWifiTimeInterval = 10000;
        sEnableScanWifi = true;
        sUseNewReverseGeoLocationApi = false;
        sIsNoLocReqCgiEnable = false;
        sIsSysNetworkLocEnable = true;
        sEnableMonitor = false;
        sMonitorStrategy = 0;
        sMonitorStrategyInterval = 3000;
        sMonitorStrategyClassMemberList = new ArrayList();
        sMonitorBusinessStartLocationClassMemberList = new ArrayList();
        sMonitorBusinessStopLocationClassMemberList = new ArrayList();
        sEnableBackgroundLocation = false;
        sInfoRequestKeyParamsMaxCacheTime = 86400000;
        sEnableInfoRequestOpt = false;
        sMaxWaitGpsTimeMillis = 0;
        sEnablePreLocationCallback = false;
        sEnableAcceptLightLocationParam = false;
        sEnableSelfStartService = true;
        sByteLocationLibraParam = "v2";
        sSearchLocationCacheTime = -1;
        sByteLocationWhiteList = "";
        sCollectGpsType = 0;
        sEnableRescanWifi = false;
        sRescanWifiCount = 60;
        sUseCacheCondition = false;
        sDisableCollectAMapLocationSource = LocationInfoConst.UNKNOWN_SOURCE;
        sEnableLocationCacheTokenWhiteList = false;
        sLocationCacheTokenWhiteList = "";
        sHotBootLocToken = "";
        sHotBootCacheTime = -1;
        sColdBootCollectGpsStrategy = 0;
        sColdBootCollectGps = false;
        sEnableCollectGPSLocationInBatterySavingMode = false;
        sEnableCollectNetworkLocationInBatterySavingMode = false;
        sEnableCollectAMapLocationInBatterySavingMode = false;
        sEnableCollectBleInBatterySavingMode = false;
        sEnableUploadLastLogId = true;
        sNetworkSignatureMode = "";
        sDefaultGpsScanInterval = 0;
        sLocalDefaultGpsScanInterval = 15000;
        sEnableCheckUploadCompliance = true;
        sEenableBackgroundUploadLocation = false;
        sEnableCheckLastLogId = true;
        sEnableUseCoarseLocation = false;
        sEnableDimLocationCheck = false;
        sEnableTailLocateOptimize = false;
        sTailAccuracyThreshold = 100.0f;
        sTailWifiTimeThreshold = 300000;
        sDisableTailLocateOptimizeSource = LocationInfoConst.UNKNOWN_SOURCE;
        sIsUploadFreshBaseStation = false;
        sFreshBaseStationTimeout = 0;
        sEnableUploadLastLocationInfo = false;
        sEnableCollectContinuousGPSLocation = false;
        sCollectContinuousGPSInterval = 1000;
        sCollectContinuousGPSDuration = 5000;
        sCollectContinuousGPSTokenBlacklist = "";
        sCollectContinuousGpsDisableGnssUpload = false;
        sCollectContinuousGpsOnlyLast = true;
        sInOutDoorStatusCacheTime = 600000;
        sEnableScanGnss = true;
        sEnableStationaryScenePolicy = false;
        sOpenStationaryScene = false;
        sStationarySceneMaxInterval = 1800000;
        sStationarySceneMaxDistance = 50;
        sStationarySceneMaxGpsAccuracy = 50;
        sStationarySceneWifiWhiteList = "";
        sStationarySceneTokenWhiteList = "";
        sEnableCollectContinuousGpsForTest = false;
        sEnableGetNeighboringCell = false;
        sEnableContinueLocateUploadWifi = true;
        sEnableContinueLocateUploadCell = true;
        sInvokerApiInitStatus = -1;
        sEnableByteContinuousLocation = true;
        sUploadNetSignalInterval = 30000;
        sLocationExpiredInterval = 100000;
        sFirstLocationTimeoutMs = 10000;
        sNeedUploadLastContinuousLocation = true;
        sIsUseQuickGPS = false;
        sEnableFusionLocation = true;
        sFusionLocationSensorBatchPushIntervalMs = 100;
        sFusionLocationGpsIntervalMs = 1000;
        sFusionLocationAccelerometerIntervalUs = 20000;
        sFusionLocationGyroscopeIntervalUs = 20000;
        sFusionLocationMagnetometerIntervalUs = 20000;
        sFusionLocationHeadingIntervalUs = 50000;
        sFusionLocationBarometerIntervalUs = 100000;
        sFusionLocationLightIntervalUs = 100000;
        sFusionLocationDopIntervalMs = 1000;
        sFusionLocationTempIntervalUs = 100000;
        sFusionLocationSatelliteInfoIntervalMs = 1000;
        sFusionLocationEnableTrackUpload = true;
        sFusionLocationTrackIntervalSec = 15;
        sColdBootABTest = false;
    }

    public static boolean isOpenStationaryScene() {
        monitor-enter(OPEN_STATIONARY_SCENE_LOCK);
        boolean r100 = sOpenStationaryScene;     // Catch: Throwable -> L7
        monitor-exit(OPEN_STATIONARY_SCENE_LOCK);     // Catch: Throwable -> L7
        return r100;
    L7:
        th = move-exception;
        throw th;
    }

    public static int checkConnectWifiRssi() {
        return sConnectWifiRssi;
    }

    public static long checkRefreshWifiTimeInterval() {
        return sCheckRefreshWifiTimeInterval;
    }

    public static boolean enableAcceptLightLocationParam() {
        return sEnableAcceptLightLocationParam;
    }

    public static boolean enableBackgroundLocation() {
        return sEnableBackgroundLocation;
    }

    public static boolean enableBackgroundUploadLocation() {
        return sEenableBackgroundUploadLocation;
    }

    public static boolean enableBlePassiveName() {
        return sEnableBlePassiveName;
    }

    public static boolean enableBleTruncateOnTimeout() {
        return sEnableBleTruncateOnTimeout;
    }

    public static boolean enableBpea() {
        return sEnableBpea;
    }

    public static boolean enableByteContinuousLocation() {
        return sEnableByteContinuousLocation;
    }

    public static boolean enableCheckConnectWifi() {
        return sEnableCheckConnectWifi;
    }

    public static boolean enableCheckLastLogId() {
        return sEnableCheckLastLogId;
    }

    public static boolean enableCheckRefreshWifiTime() {
        return sEnableCheckRefreshWifiTime;
    }

    public static boolean enableCheckUploadCompliance() {
        return sEnableCheckUploadCompliance;
    }

    public static boolean enableCollectAMapLocationInBatterySavingMode() {
        return sEnableCollectAMapLocationInBatterySavingMode;
    }

    public static boolean enableCollectBleInBatterySavingMode() {
        return sEnableCollectBleInBatterySavingMode;
    }

    public static boolean enableCollectContinuousGPSLocation() {
        return sEnableCollectContinuousGPSLocation;
    }

    public static boolean enableCollectContinuousGpsForTest() {
        return sEnableCollectContinuousGpsForTest;
    }

    public static boolean enableCollectGPSLocationInBatterySavingMode() {
        return sEnableCollectGPSLocationInBatterySavingMode;
    }

    public static boolean enableCollectNetworkLocationInBatterySavingMode() {
        return sEnableCollectNetworkLocationInBatterySavingMode;
    }

    public static boolean enableDestroyAMapContinuousClient() {
        return sEnableDestroyAMapContinuousClient;
    }

    public static boolean enableDestroyAMapSingleClient() {
        return sEnableDestroyAMapSingleClient;
    }

    public static boolean enableDimLocationCheck() {
        return sEnableDimLocationCheck;
    }

    public static boolean enableFusionLocation() {
        return sEnableFusionLocation;
    }

    public static boolean enableGetNeighboringCell() {
        return sEnableGetNeighboringCell;
    }

    public static boolean enableInfoRequestOpt() {
        return sEnableInfoRequestOpt;
    }

    public static boolean enableLightLocation() {
        return sEnableLightLocation;
    }

    public static boolean enableLightLocationNewPolicy() {
        return sEnableLightLocationNewPolicy;
    }

    public static boolean enableMonitor() {
        return sEnableMonitor;
    }

    public static boolean enablePreLocationCallback() {
        return sEnablePreLocationCallback;
    }

    public static boolean enableRescanWifi() {
        return sEnableRescanWifi;
    }

    public static boolean enableScanBle() {
        return sScanBle;
    }

    public static boolean enableScanGnss() {
        return sEnableScanGnss;
    }

    public static boolean enableScanWifi() {
        return sEnableScanWifi;
    }

    public static boolean enableSelfStartService() {
        return sEnableSelfStartService;
    }

    public static boolean enableStationaryScenePolicy() {
        return sEnableStationaryScenePolicy;
    }

    public static boolean enableTailLocateOptimize() {
        return sEnableTailLocateOptimize;
    }

    public static boolean enableTraceroute() {
        return mEnableTraceroute;
    }

    public static boolean enableUploadLastLocationInfo() {
        return sEnableUploadLastLocationInfo;
    }

    public static boolean enableUploadLastLogId() {
        return sEnableUploadLastLogId;
    }

    public static boolean enableUseCoarseLocation() {
        return sEnableUseCoarseLocation;
    }

    public static boolean firstRequestLocation() {
        return sFirstRequestLocation;
    }

    public static BackgroundProvider getAppBackgroundProvider() {
        return sProvider;
    }

    public static long getAppBootTime() {
        return sAppBootTime;
    }

    public static String getAppId() {
        return sAppId;
    }

    public static String getAppVersion() {
        return sAppVersion;
    }

    public static int getBaseStationInfoType() {
        return sBaseStationInfoType;
    }

    public static String getBaseUrl() {
        return sBaseUrl;
    }

    public static JSONObject getBeaconConfig() {
        return sBeaconConfig;
    }

    public static BLECacheEntity getBleCacheEntity() {
        return mBleCacheEntity;
    }

    public static long getBootLegitimateTime() {
        return sBootLegitimateTime;
    }

    public static int getBssNum() {
        return sBssNum;
    }

    public static String getByteLocationLibraParam() {
        return sByteLocationLibraParam;
    }

    public static String getByteLocationWhiteList() {
        return sByteLocationWhiteList;
    }

    public static String getChannel() {
        return sChannel;
    }

    public static boolean getColdBootCollectGps() {
        return sColdBootCollectGps;
    }

    public static int getColdBootCollectGpsStrategy() {
        return sColdBootCollectGpsStrategy;
    }

    public static long getCollectContinuousGPSDuration() {
        return sCollectContinuousGPSDuration;
    }

    public static long getCollectContinuousGPSInterval() {
        return sCollectContinuousGPSInterval;
    }

    public static String getCollectContinuousTokenBlacklist() {
        return sCollectContinuousGPSTokenBlacklist;
    }

    public static int getCollectGpsType() {
        return sCollectGpsType;
    }

    public static Map<String, String> getCommonParams() {
        return sCommonParams;
    }

    public static Context getContext() {
        return sContext;
    }

    public static int getContinueAccelerometerInterval() {
        return sContinueAccelerometerInterval;
    }

    public static int getContinueGyroscopeInterval() {
        return sContinueGyroscopeInterval;
    }

    public static int getContinueLightInfoInterval() {
        return sContinueLightInfoInterval;
    }

    public static int getContinueMagnetometerInterval() {
        return sContinueMagnetometerInterval;
    }

    public static int getContinuePressureInterval() {
        return sContinuePressureInterval;
    }

    public static IDYHostInfoProvider getDYHostInfoProvider() {
        return sDYHostInfoProvider;
    }

    public static String getDeviceId() {
        return sDeviceId;
    }

    public static String getDisableCollectAMapLocationSource() {
        return sDisableCollectAMapLocationSource;
    }

    public static String getDisableTailLocateOptimizeSource() {
        return sDisableTailLocateOptimizeSource;
    }

    public static List<String> getDisableUuidList() {
        return sDisableUuidList;
    }

    public static String getEnableLocationOptBpeaList() {
        return sEnableLocationOptBpeaList;
    }

    public static Pair getEnv() {
        return sEnv;
    }

    public static IEventManager getEventManager() {
        return sEventManager;
    }

    public static long getFirstLocationTimeoutMs() {
        return sFirstLocationTimeoutMs;
    }

    public static long getFreshBaseStationTimeout() {
        return sFreshBaseStationTimeout;
    }

    public static int getFusionLocationAccelerometerIntervalUs() {
        return sFusionLocationAccelerometerIntervalUs;
    }

    public static int getFusionLocationBarometerIntervalUs() {
        return sFusionLocationBarometerIntervalUs;
    }

    public static long getFusionLocationDopIntervalMs() {
        return sFusionLocationDopIntervalMs;
    }

    public static long getFusionLocationGpsIntervalMs() {
        return sFusionLocationGpsIntervalMs;
    }

    public static int getFusionLocationGyroscopeIntervalUs() {
        return sFusionLocationGyroscopeIntervalUs;
    }

    public static int getFusionLocationHeadingIntervalUs() {
        return sFusionLocationHeadingIntervalUs;
    }

    public static int getFusionLocationLightIntervalUs() {
        return sFusionLocationLightIntervalUs;
    }

    public static int getFusionLocationMagnetometerIntervalUs() {
        return sFusionLocationMagnetometerIntervalUs;
    }

    public static long getFusionLocationSatelliteInfoIntervalMs() {
        return sFusionLocationSatelliteInfoIntervalMs;
    }

    public static long getFusionLocationSensorBatchPushIntervalMs() {
        return sFusionLocationSensorBatchPushIntervalMs;
    }

    public static int getFusionLocationTempIntervalUs() {
        return sFusionLocationTempIntervalUs;
    }

    public static int getFusionLocationTrackIntervalSec() {
        return sFusionLocationTrackIntervalSec;
    }

    public static long getGpsScanInterval() {
        return sGpsScanInterval;
    }

    public static int getHARStatusRange() {
        return sHARStatusRange;
    }

    public static int getHotBootCacheTime() {
        return sHotBootCacheTime;
    }

    public static String getHotBootLocToken() {
        return sHotBootLocToken;
    }

    public static long getInOutDoorStatusCacheTime() {
        return sInOutDoorStatusCacheTime;
    }

    public static long getInfoRequestKeyParamsMaxCacheTime() {
        return sInfoRequestKeyParamsMaxCacheTime;
    }

    public static long getInitStartTime() {
        return sInitStartTime;
    }

    public static int getInvokerApiInitStatus() {
        return sInvokerApiInitStatus;
    }

    public static int getLightInfoInterval() {
        return sLightInfoInterval;
    }

    public static ILiveExperienceProvider getLiveExperienceProvider() {
        return sLiveExperienceProvider;
    }

    public static int getLiveStallReportWindowMs() {
        return sLiveStallReportWindowMs;
    }

    public static Locale getLocale() {
        return sLocale;
    }

    public static int getLocateType() {
        return sLocateType;
    }

    public static String getLocationCacheTokenWhiteList() {
        return sLocationCacheTokenWhiteList;
    }

    public static long getLocationExpiredInterval() {
        return sLocationExpiredInterval;
    }

    public static int getLocationMode() {
        return sLocationMode;
    }

    public static LogIdCacheEntity getLogIdCacheEntity() {
        return mLogIdCacheEntity;
    }

    public static int getMaxLightCount() {
        return sMaxLightCount;
    }

    public static long getMaxLightDuration() {
        return sMaxLightDuration;
    }

    public static long getMaxLocationTimeMs() {
        return sMaxLocationTimeMs;
    }

    public static ICustomNetworkApi getNetworkApi() {
        return sNetworkApi;
    }

    public static String getNetworkSignatureMode() {
        return sNetworkSignatureMode;
    }

    public static long getNetworkStatusChangeUploadInterval() {
        return sNetworkStatusChangeUploadInterval;
    }

    public static long getOverseasGetLocationFailedUseCacheValidity() {
        return sOverseasGetLocationFailedUseCacheValidity;
    }

    public static String getPackageName() {
        return sPackageName;
    }

    public static IPermissionChecker getPermissionChecker() {
        return sPermissionChecker;
    }

    public static String getRedGeoNameIds() {
        return sRedGeoNameIds;
    }

    public static long getScanBleInterval() {
        return sScanBleInterval;
    }

    public static String getSdkVersion() {
        return sSdkVersion;
    }

    public static long getSearchLocationCacheTime() {
        return sSearchLocationCacheTime;
    }

    public static long getSensorMaxCacheSeconds() {
        return sSensorMaxCacheSeconds;
    }

    public static String getSessionId() {
        return sSessionId;
    }

    public static JSONObject getShakeConfig() {
        return mShakeConfig;
    }

    public static String getSlardarAid() {
        return sSlardarAid;
    }

    public static int getStationarySceneMaxDistance() {
        return sStationarySceneMaxDistance;
    }

    public static int getStationarySceneMaxGpsAccuracy() {
        return sStationarySceneMaxGpsAccuracy;
    }

    public static long getStationarySceneMaxInterval() {
        return sStationarySceneMaxInterval;
    }

    public static List<LocationSubmitNotification> getSubmitNotification() {
        return sSubmitNotifications;
    }

    public static float getTailAccuracyThreshold() {
        return sTailAccuracyThreshold;
    }

    public static long getTailWifiTimeThreshold() {
        return sTailWifiTimeThreshold;
    }

    public static String getUpdateVersionCode() {
        return sUpdateVersionCode;
    }

    public static int getUploadBleNum() {
        return sUploadBleNum;
    }

    public static long getUploadInterval() {
        return sUploadInterval;
    }

    public static long getUploadNetSignalInterval() {
        return sUploadNetSignalInterval;
    }

    public static int getWifiNum() {
        return sWifiNum;
    }

    public static long getWifiScanInterval() {
        return sWifiScanInterval;
    }

    public static String getWorldView() {
        return sWorldView;
    }

    public static boolean isAMapGPSCollectAlwaysUseNewAMapClient() {
        return sIsAMapGPSCollectAlwaysUseNewAMapClient;
    }

    public static boolean isAllowFetchConfigAtStart() {
        return sAllowFetchConfigAtStart;
    }

    public static boolean isAllowLocateFallback() {
        return sAllowLocateFallback;
    }

    public static boolean isAsyncScanWifi() {
        return sAsyncScanWifi;
    }

    public static boolean isCheckLocationBpea() {
        return sCheckLocationBpea;
    }

    public static boolean isChineseChannel() {
        return sIsChineseChannel;
    }

    public static boolean isColdBootABTest() {
        return sColdBootABTest;
    }

    public static boolean isCollectContinuousGpsDisableGnssUpload() {
        return sCollectContinuousGpsDisableGnssUpload;
    }

    public static boolean isCollectContinuousGpsOnlyLast() {
        return sCollectContinuousGpsOnlyLast;
    }

    public static boolean isCollectLightInfo() {
        return sCollectLightInfo;
    }

    public static boolean isContinueLocateUploadCell() {
        return sEnableContinueLocateUploadCell;
    }

    public static boolean isContinueLocateUploadWifi() {
        return sEnableContinueLocateUploadWifi;
    }

    public static boolean isDebug() {
        return isDebug;
    }

    public static boolean isEnableGpsScan() {
        return sEnableGpsScan;
    }

    public static boolean isEnableHARCollect() {
        return sEnableHARCollect;
    }

    public static boolean isEnableLocationCacheTokenWhiteList() {
        return sEnableLocationCacheTokenWhiteList;
    }

    public static boolean isEnableLocationOptEncrypt() {
        return sEnableLocationOptEncrypt;
    }

    public static boolean isFirstLocation() {
        return sIsFirstLocation;
    }

    public static boolean isFusionLocationTrackUploadEnabled() {
        return sFusionLocationEnableTrackUpload;
    }

    public static boolean isIndependentThreadGetScanResults() {
        return sIsIndepentThreadGetScanResults;
    }

    public static boolean isLiveStallReportEnabled() {
        return sLiveStallReportEnabled;
    }

    public static boolean isMockEnable() {
        return sIsMockEnable;
    }

    public static boolean isMockUpload() {
        return sIsMockUpload;
    }

    public static boolean isNoLocReqCgiEnable() {
        return sIsNoLocReqCgiEnable;
    }

    public static boolean isOnline() {
        return sOnline;
    }

    public static boolean isOpenWifiListMonitor() {
        return sOpenWifiListMonitor;
    }

    public static boolean isPollingUpload() {
        return sIsPollingUpload;
    }

    public static boolean isPrivacyConfirmed() {
        return isPrivacyConfirmed;
    }

    public static boolean isRegionInChineseChannel() {
        return sRegionInChineseChannel;
    }

    public static boolean isReportAtStart() {
        return sReportAtStart;
    }

    public static boolean isReportLocationAtStart() {
        return sReportLocationAtStart;
    }

    public static boolean isRevertToSystemLocation() {
        return sRevertToSystemLocation;
    }

    public static boolean isSensorAccelerometerEnabled() {
        return sSensorAccelerometerEnabled;
    }

    public static boolean isSensorBarometerEnabled() {
        return sSensorBarometerEnabled;
    }

    public static boolean isSensorContinuousCollectEnabled() {
        return sSensorContinuousCollectEnabled;
    }

    public static boolean isSensorDopEnabled() {
        return sSensorDopEnabled;
    }

    public static boolean isSensorGnssEnabled() {
        return sSensorGnssEnabled;
    }

    public static boolean isSensorGyroscopeEnabled() {
        return sSensorGyroscopeEnabled;
    }

    public static boolean isSensorLightEnabled() {
        return sSensorLightEnabled;
    }

    public static boolean isSensorMagnetometerEnabled() {
        return sSensorMagnetometerEnabled;
    }

    public static boolean isStrictRestrictedMode() {
        return sIsStrictRestrictedMode;
    }

    public static boolean isSysNetworkLocEnable() {
        return sIsSysNetworkLocEnable;
    }

    public static boolean isUpload() {
        return sIsUpload;
    }

    public static boolean isUploadBaseSite() {
        return sIsUploadBaseSite;
    }

    public static boolean isUploadBleImmediately() {
        return sUploadBleImmediately;
    }

    public static boolean isUploadFreshBaseStation() {
        return sIsUploadFreshBaseStation;
    }

    public static boolean isUploadGPS() {
        return sIsUploadGPS;
    }

    public static boolean isUploadLocation() {
        return sIsUploadLocation;
    }

    public static boolean isUploadMccAndSystemRegionInfo() {
        return sUploadMccAndSystemRegionInfo;
    }

    public static boolean isUploadWIFI() {
        return sIsUploadWIFI;
    }

    public static boolean isUseCacheCondition() {
        return sUseCacheCondition;
    }

    public static boolean isUseNewCacheStrategy() {
        return sUseNewCacheStrategy;
    }

    public static boolean isUseQuickGPS() {
        return sIsUseQuickGPS;
    }

    public static long maxWaitGPSTimeMillis() {
        return sMaxWaitGpsTimeMillis;
    }

    public static List<String> monitorBusinessStartLocationClassMemberList() {
        return sMonitorBusinessStartLocationClassMemberList;
    }

    public static List<String> monitorBusinessStopLocationClassMemberList() {
        return sMonitorBusinessStopLocationClassMemberList;
    }

    public static int monitorStrategy() {
        return sMonitorStrategy;
    }

    public static List<String> monitorStrategyClassMemberList() {
        return sMonitorStrategyClassMemberList;
    }

    public static long monitorStrategyInterval() {
        return sMonitorStrategyInterval;
    }

    public static boolean needDownGradeLocationInOverseas() {
        return sNeedDownGradeLocationInOverseas;
    }

    public static boolean needUploadLastContinuousLocation() {
        return sNeedUploadLastContinuousLocation;
    }

    public static int rescanWifiCount() {
        return sRescanWifiCount;
    }

    public static boolean shouldRequestLocation() {
        return sShouldRequestLocation;
    }

    public static boolean useGpsCheckRegion() {
        return sUseGpsCheckRegion;
    }

    public static boolean useNewReverseGeoLocationApi() {
        return sUseNewReverseGeoLocationApi;
    }

    public static Object getBpeaCert(String r100) {
        if (sBpeaCerts != null) goto L5;
        return null;
    L5:
        if (TextUtils.isEmpty(r100) == false) goto L8;
        return null;
    L8:
        return sBpeaCerts.get(r100);
    }

    public static boolean init(Context r100) throws BDLocationException {
        if (legacyCheckInit() == false) goto L5;
        return true;
    L5:
        sInitStartTime = SystemClock.elapsedRealtime();
        sContext = r100;
        LocationSettingUtil.setLocationConfig();
        Object r101 = getBpeaCert(LocationInfoConst.INIT_CERT);
        LocationUtil.checkBpeaCertNull("locationInit", r101);
        if (r101 != null) goto L19;
    L17:
        long r102 = getDefaultGpsScanInterval();
        setGpsScanInterval(r102);
        Logger.i("init defaultGpsScanInterval:" + r102);
        LocationUtil.checkLocationMockEnable();
        isInit = true;
        Logger.i("config init finish");
        return true;
    L19:
        BPEACertCheckResult r103 = BDLocationExtrasService.getBPEAManager().checkAndTranslateCert(r101, "init");     // Catch: BDLocationException -> L14
        if (r103 == null) goto L17;
        if (r103.getParams() == null) goto L17;
        setConfigParam(r103.getParams());     // Catch: BDLocationException -> L14
    L14:
        e = move-exception;
        Logger.i("location init bpea check error");
        throw e;
    }

    public static boolean isEnableLocationOpt(String r100) {
        String r101 = sEnableLocationOptBpeaList;
        if (TextUtils.isEmpty(r100) == false) goto L5;
    L9:
        return false;
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L9;
        if (r101.contains(r100) == false) goto L9;
        return true;
    }

    public static boolean isInStationarySceneTokenWhiteList(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return false;
    L5:
        if (TextUtils.isEmpty(sStationarySceneTokenWhiteList) == false) goto L8;
        return false;
    L8:
        return sStationarySceneTokenWhiteList.contains(r100);
    }

    public static boolean isInStationarySceneWifiWhiteList(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
    L19:
        return false;
    L5:
        if (TextUtils.isEmpty(sStationarySceneWifiWhiteList) == true) goto L19;
        if (sStationarySceneWifiWhiteList.contains(",") == false) goto L18;
        String[] r101 = sStationarySceneWifiWhiteList.split(",");
        int r102 = r101.length;
        int r103 = 0;
    L10:
        if (r103 >= r102) goto L16;
        if (r100.contains(r101[r103]) == true) goto L13;
        r103 = r103 + 1;
        goto L10
    L13:
        return true;
    L16:
        return false;
    L18:
        return r100.contains(sStationarySceneWifiWhiteList);
    }

    public static boolean needRevertWifiOrStationInfoUpload(LocationOption r100) {
        if (r100 != null) goto L4;
    L8:
        StringBuilder r101 = new StringBuilder("BDLocationConfig.needRevertWifiOrStationInfoUpload: false, cert: ");
        if (r100 == null) goto L11;
        String r102 = r100.getUploadSource();
    L12:
        r101.append(r102);
        Logger.i(r101.toString());
        return false;
    L11:
        r102 = "null";
        goto L12
    L4:
        if (r100.isOnceLocation() == false) goto L8;
        boolean r103 = isRevertToSystemLocation();
        Logger.i("BDLocationConfig.needRevertWifiOrStationInfoUpload: " + r103 + ", cert: " + r100.getUploadSource());
        return r103;
    }

    public static void removeSubmitNotification(LocationSubmitNotification r100) {
        List<LocationSubmitNotification> r101 = sSubmitNotifications;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.size() < 1) goto L11;
        if (r100 == null) goto L12;
        sSubmitNotifications.remove(r100);
        return;
    L12:
        return;
    }

    public static void setAMapGPSCollectAlwaysUseNewAMapClient(boolean r100) {
        sIsAMapGPSCollectAlwaysUseNewAMapClient = r100;
    }

    public static void setAllowFetchConfigAtStart(boolean r100) {
        sAllowFetchConfigAtStart = r100;
    }

    public static void setAllowLocateFallback(boolean r100) {
        sAllowLocateFallback = r100;
    }

    public static void setAppBackgroundProvider(BackgroundProvider r100) {
        StringBuilder r101 = new StringBuilder("setAppBackgroundProvider provider:");
        if (r100 != null) goto L5;
        boolean r102 = true;
    L6:
        r101.append(r102);
        Logger.i(r101.toString());
        BackgroundProvider r103 = sProvider;
        List<BackgroundProvider.Callback> r104 = null;
        if (r103 == null) goto L9;
        List<BackgroundProvider.Callback> r105 = r103.getCallback();
        sProvider.setCallback(null);
        r104 = r105;
    L9:
        sProvider = r100;
        if (r104 == null) goto L14;
        if (r100 == null) goto L15;
        r100.setCallback(r104);
        return;
    L15:
        return;
    L14:
        return;
    L5:
        r102 = false;
        goto L6
    }

    public static void setAppBootTime(long r100) {
        sAppBootTime = r100;
    }

    public static void setAppId(String r100) {
        sAppId = r100;
    }

    public static void setAppVersion(String r100) {
        sAppVersion = r100;
    }

    public static void setAsyncScanWifi(boolean r100) {
        sAsyncScanWifi = r100;
    }

    public static void setBaseStationInfoType(int r100) {
        sBaseStationInfoType = r100;
    }

    public static void setBaseUrl(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
    L14:
        sBaseUrl = r100;
        return;
    L5:
        if (r100.contains("https") == true) goto L14;
        if (isDebug() == false) goto L9;
    L13:
        Logger.e("当前定位接口非https加密，使用明文信息违反合规要求，请修改为https");
        goto L14
    L9:
        if (isOnline() == false) goto L13;
        throw new IllegalArgumentException("当前定位接口非https加密，使用明文信息违反合规要求，请修改为https");
    }

    public static void setBeaconConfig(JSONObject r100) {
        sBeaconConfig = r100;
    }

    public static void setBleCacheEntity(BLECacheEntity r100) {
        mBleCacheEntity = r100;
    }

    public static void setBootLegitimateTime(long r100) {
        sBootLegitimateTime = r100;
    }

    public static void setBpeaCerts(Map<String, Object> r100) {
        sBpeaCerts = r100;
    }

    public static void setBssNum(int r100) {
        sBssNum = r100;
    }

    public static void setByteLocationLibraParam(String r100) {
        sByteLocationLibraParam = r100;
    }

    public static void setByteLocationWhiteList(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        sByteLocationWhiteList = r100;
    }

    public static void setChannel(String r100) {
        sChannel = r100;
    }

    public static void setCheckConnectWifiRssi(int r100) {
        sConnectWifiRssi = r100;
    }

    public static void setCheckLocationBpea(boolean r100) {
        sCheckLocationBpea = r100;
    }

    public static void setCheckRefreshWifiTimeInterval(long r100) {
        sCheckRefreshWifiTimeInterval = r100;
    }

    public static void setChineseChannel(boolean r100) {
        sIsChineseChannel = r100;
    }

    public static void setColdBootABTest(boolean r100) {
        sColdBootABTest = r100;
    }

    public static void setColdBootCollectGps(boolean r100) {
        sColdBootCollectGps = r100;
    }

    public static void setColdBootCollectGpsStrategy(int r100) {
        sColdBootCollectGpsStrategy = r100;
    }

    public static void setCollectContinuousGPSDuration(long r100) {
        sCollectContinuousGPSDuration = r100;
    }

    public static void setCollectContinuousGPSInterval(long r100) {
        sCollectContinuousGPSInterval = r100;
    }

    public static void setCollectContinuousGpsDisableGnssUpload(boolean r100) {
        sCollectContinuousGpsDisableGnssUpload = r100;
    }

    public static void setCollectContinuousGpsOnlyLast(boolean r100) {
        sCollectContinuousGpsOnlyLast = r100;
    }

    public static void setCollectContinuousTokenBlacklist(String r100) {
        sCollectContinuousGPSTokenBlacklist = r100;
    }

    public static void setCollectGpsType(int r100) {
        sCollectGpsType = r100;
    }

    public static void setCollectLightInfo(boolean r100) {
        sCollectLightInfo = r100;
    }

    public static void setCommonParams(Map<String, String> r100) {
        sCommonParams = r100;
    }

    public static void setConfigParam(JSONObject r100) {
        Logger.d("BDLocation", "init config params are " + r100.toString());
        setIsUploadGPS(r100.optBoolean("report_gps", true));
        int r101 = r100.optInt("report_bss_max", 10);
        if (r101 <= 0) goto L5;
        setUploadBaseSite(true);
        setBssNum(r101);
    L6:
        setReportAtStart(r100.optBoolean("report_at_start", false));
        setReportLocationAtStart(r100.optBoolean("report_location_at_start", false));
        setUpload(r100.optBoolean("is_upload", true));
        setUploadLocation(r100.optBoolean("is_upload_location", true));
        setChineseChannel(r100.optBoolean("chinese_channel", true));
        int r102 = r100.optInt("location_update_interval", 300);
        int r103 = r100.optInt("report_interval_seconds", 300);
        if (r103 <= 0) goto L9;
        setUploadInterval(r103 * 1000);
    L10:
        setDebug(r100.optBoolean("debug_able", false));
        setAllowLocateFallback(r100.optBoolean("allow_locate_fallback", true));
        JSONArray r104 = r100.optJSONArray("error_code_list_for_fallback");
        ArrayList r105 = new ArrayList();
        if (r104 == null) goto L16;
        int r106 = 0;
    L14:
        if (r106 >= r104.length()) goto L16;
        r105.add(Integer.valueOf(r104.optInt(r106, 0)));
        r106 = r106 + 1;
    L16:
        setAllowFetchConfigAtStart(r100.optBoolean("allow_fetch_config_at_start", true));
        setPollingUpload(r100.optBoolean("polling_upload", isPollingUpload()));
        setMaxLocationTimeMs(r100.optLong("max_location_time_ms", 300000));
        setLocateType(r100.optInt(LocationMonitorConst.LOCATE_TYPE, 3));
        return;
    L9:
        setUploadInterval(r102 * 1000);
        goto L10
    L5:
        setUploadBaseSite(false);
        goto L6
    }

    public static void setContext(Context r100) {
        sContext = r100;
    }

    public static void setContinueAccelerometerInterval(int r100) {
        sContinueAccelerometerInterval = 1000000 / r100;
    }

    public static void setContinueGyroscopeInterval(int r100) {
        sContinueGyroscopeInterval = 1000000 / r100;
    }

    public static void setContinueLightInfoInterval(int r100) {
        sContinueLightInfoInterval = 1000000 / r100;
    }

    public static void setContinueMagnetometerInterval(int r100) {
        sContinueMagnetometerInterval = 1000000 / r100;
    }

    public static void setContinuePressureInterval(int r100) {
        sContinuePressureInterval = 1000000 / r100;
    }

    public static void setDYHostInfoProvider(IDYHostInfoProvider r100) {
        sDYHostInfoProvider = r100;
    }

    public static void setDebug(boolean r100) {
        isDebug = r100;
    }

    public static void setDefaultGpsScanInterval(long r100) {
        sDefaultGpsScanInterval = r100;
    }

    public static void setDeviceId(String r100) {
        sDeviceId = r100;
    }

    public static void setDisableCollectAMapLocationSource(String r100) {
        sDisableCollectAMapLocationSource = r100;
    }

    public static void setDisableTailLocateOptimizeSource(String r100) {
        sDisableTailLocateOptimizeSource = r100;
    }

    public static void setDisableUuidList(List<String> r100) {
        sDisableUuidList = r100;
    }

    public static void setEnableAcceptLightLocationParam(boolean r100) {
        sEnableAcceptLightLocationParam = r100;
    }

    public static void setEnableBackgroundLocation(boolean r100) {
        sEnableBackgroundLocation = r100;
    }

    public static void setEnableBackgroundUploadLocationn(boolean r100) {
        sEenableBackgroundUploadLocation = r100;
    }

    public static void setEnableBlePassiveName(boolean r100) {
        sEnableBlePassiveName = r100;
    }

    public static void setEnableBleTruncateOnTimeout(boolean r100) {
        sEnableBleTruncateOnTimeout = r100;
    }

    public static void setEnableBpea(boolean r100) {
        sEnableBpea = r100;
        if (getContext() == null) goto L6;
        LocationCache.getInstance().setBooleanValue(ENABLE_BPEA_CACHE_KEY, r100);
        return;
    }

    public static void setEnableByteContinuousLocation(boolean r100) {
        sEnableByteContinuousLocation = r100;
    }

    public static void setEnableCheckConnectWifi(boolean r100) {
        sEnableCheckConnectWifi = r100;
    }

    public static void setEnableCheckLastLogId(boolean r100) {
        sEnableCheckLastLogId = r100;
    }

    public static void setEnableCheckRefreshWifiTime(boolean r100) {
        sEnableCheckRefreshWifiTime = r100;
    }

    public static void setEnableCheckUploadCompliance(boolean r100) {
        sEnableCheckUploadCompliance = r100;
    }

    public static void setEnableCollectAMapLocationInBatterySavingMode(boolean r100) {
        sEnableCollectAMapLocationInBatterySavingMode = r100;
    }

    public static void setEnableCollectBleInBatterySavingMode(boolean r100) {
        sEnableCollectBleInBatterySavingMode = r100;
    }

    public static void setEnableCollectContinuousGPSLocation(boolean r100) {
        sEnableCollectContinuousGPSLocation = r100;
    }

    public static void setEnableCollectContinuousGpsForTest(boolean r100) {
        sEnableCollectContinuousGpsForTest = r100;
    }

    public static void setEnableCollectGPSLocationInBatterySavingMode(boolean r100) {
        sEnableCollectGPSLocationInBatterySavingMode = r100;
    }

    public static void setEnableCollectNetworkLocationInBatterySavingMode(boolean r100) {
        sEnableCollectNetworkLocationInBatterySavingMode = r100;
    }

    public static void setEnableContinueLocateUploadCell(boolean r100) {
        sEnableContinueLocateUploadCell = r100;
    }

    public static void setEnableContinueLocateUploadWifi(boolean r100) {
        sEnableContinueLocateUploadWifi = r100;
    }

    public static void setEnableDestroyAMapContinuousClient(boolean r100) {
        sEnableDestroyAMapContinuousClient = r100;
    }

    public static void setEnableDestroyAMapSingleClient(boolean r100) {
        sEnableDestroyAMapSingleClient = r100;
    }

    public static void setEnableDimLocationCheck(boolean r100) {
        sEnableDimLocationCheck = r100;
    }

    public static void setEnableFusionLocation(boolean r100) {
        sEnableFusionLocation = r100;
    }

    public static void setEnableGetNeighboringCell(boolean r100) {
        sEnableGetNeighboringCell = r100;
    }

    public static void setEnableGpsScan(boolean r100) {
        sEnableGpsScan = r100;
    }

    public static void setEnableHARCollect(boolean r100) {
        sEnableHARCollect = r100;
    }

    public static void setEnableInfoRequestOpt(boolean r100) {
        sEnableInfoRequestOpt = r100;
    }

    public static void setEnableLightLocation(boolean r100) {
        sEnableLightLocation = r100;
    }

    public static void setEnableLightLocationNewPolicy(boolean r100) {
        sEnableLightLocationNewPolicy = r100;
    }

    public static void setEnableLocationCacheTokenWhiteList(boolean r100) {
        sEnableLocationCacheTokenWhiteList = r100;
    }

    public static void setEnableLocationOptBpeaList(String r100) {
        if (r100 != null) goto L4;
        r100 = "";
    L4:
        Logger.i("setEnableLocationOptBpeaList: \"" + r100 + Typography.quote);
        sEnableLocationOptBpeaList = r100;
    }

    public static void setEnableLocationOptEncrypt(boolean r100) {
        Logger.i("setEnableLocationOptEncrypt: " + r100);
        sEnableLocationOptEncrypt = r100;
    }

    public static void setEnableMonitor(boolean r100) {
        sEnableMonitor = r100;
    }

    public static void setEnableRescanWifi(boolean r100) {
        sEnableRescanWifi = r100;
    }

    public static void setEnableScanBle(boolean r100) {
        sScanBle = r100;
    }

    public static void setEnableScanGnss(boolean r100) {
        sEnableScanGnss = r100;
    }

    public static void setEnableScanWifi(boolean r100) {
        sEnableScanWifi = r100;
    }

    public static void setEnableSelfStartService(boolean r100) {
        sEnableSelfStartService = r100;
    }

    public static void setEnableStationaryScenePolicy(boolean r100) {
        sEnableStationaryScenePolicy = r100;
    }

    public static void setEnableTailLocateOptimize(boolean r100) {
        sEnableTailLocateOptimize = r100;
    }

    public static void setEnableTraceroute(boolean r100) {
        mEnableTraceroute = r100;
    }

    public static void setEnableUploadLastLocationInfo(boolean r100) {
        sEnableUploadLastLocationInfo = r100;
    }

    public static void setEnableUploadLastLogId(boolean r100) {
        sEnableUploadLastLogId = r100;
    }

    public static void setEnableUseCoarseLocation(boolean r100) {
        sEnableUseCoarseLocation = r100;
    }

    public static void setEnv(Pair<String, String> r100) {
        sEnv = r100;
    }

    public static void setEventManager(IEventManager r100) {
        sEventManager = r100;
    }

    public static void setFirstLocation(boolean r100) {
        sIsFirstLocation = r100;
    }

    public static void setFirstLocationTimeoutMs(long r100) {
        sFirstLocationTimeoutMs = r100;
    }

    public static void setFirstRequestLocation(boolean r100) {
        sFirstRequestLocation = r100;
    }

    public static void setFreshBaseStationTimeout(long r100) {
        sFreshBaseStationTimeout = r100;
    }

    public static void setFusionLocationAccelerometerInterval(int r100) {
        sFusionLocationAccelerometerIntervalUs = frequencyHzToIntervalUs(r100, sFusionLocationAccelerometerIntervalUs);
    }

    public static void setFusionLocationBarometerInterval(int r100) {
        sFusionLocationBarometerIntervalUs = frequencyHzToIntervalUs(r100, sFusionLocationBarometerIntervalUs);
    }

    public static void setFusionLocationDopInterval(int r100) {
        sFusionLocationDopIntervalMs = frequencyHzToIntervalMs(r100, sFusionLocationDopIntervalMs);
    }

    public static void setFusionLocationEnableTrackUpload(boolean r100) {
        sFusionLocationEnableTrackUpload = r100;
    }

    public static void setFusionLocationGpsInterval(int r100) {
        sFusionLocationGpsIntervalMs = frequencyHzToIntervalMs(r100, sFusionLocationGpsIntervalMs);
    }

    public static void setFusionLocationGyroscopeInterval(int r100) {
        sFusionLocationGyroscopeIntervalUs = frequencyHzToIntervalUs(r100, sFusionLocationGyroscopeIntervalUs);
    }

    public static void setFusionLocationHeadingInterval(int r100) {
        sFusionLocationHeadingIntervalUs = frequencyHzToIntervalUs(r100, sFusionLocationHeadingIntervalUs);
    }

    public static void setFusionLocationLightInterval(int r100) {
        sFusionLocationLightIntervalUs = frequencyHzToIntervalUs(r100, sFusionLocationLightIntervalUs);
    }

    public static void setFusionLocationMagnetometerInterval(int r100) {
        sFusionLocationMagnetometerIntervalUs = frequencyHzToIntervalUs(r100, sFusionLocationMagnetometerIntervalUs);
    }

    public static void setFusionLocationSatelliteInfoInterval(int r100) {
        sFusionLocationSatelliteInfoIntervalMs = frequencyHzToIntervalMs(r100, sFusionLocationSatelliteInfoIntervalMs);
    }

    public static void setFusionLocationSensorBatchPushInterval(int r100) {
        sFusionLocationSensorBatchPushIntervalMs = frequencyHzToIntervalMs(r100, sFusionLocationSensorBatchPushIntervalMs);
    }

    public static void setFusionLocationTempInterval(int r100) {
        sFusionLocationTempIntervalUs = frequencyHzToIntervalUs(r100, sFusionLocationTempIntervalUs);
    }

    public static void setFusionLocationTrackIntervalSec(int r100) {
        if (r100 <= 0) goto L5;
        sFusionLocationTrackIntervalSec = r100;
        return;
    }

    public static void setGpsScanInterval(long r100) {
        sGpsScanInterval = r100;
    }

    public static void setHARStatusRange(int r100) {
        sHARStatusRange = r100;
    }

    public static void setHotBootCacheTime(int r100) {
        sHotBootCacheTime = r100;
    }

    public static void setHotBootLocToken(String r100) {
        sHotBootLocToken = r100;
    }

    public static void setILocationInfoExtra(ILocationInfoExtra r100) {
        sLocationInfoExtra = r100;
    }

    public static void setInOutDoorStatusCacheTime(long r100) {
        sInOutDoorStatusCacheTime = r100;
    }

    public static void setIndependentThreadGetScanResults(boolean r100) {
        Logger.i("setIndependentThreadGetScanResults: " + r100);
        sIsIndepentThreadGetScanResults = r100;
    }

    public static void setInfoRequestKeyParamsMaxCacheTime(long r100) {
        sInfoRequestKeyParamsMaxCacheTime = r100;
    }

    public static void setInvokerApiInitStatus(int r100) {
        sInvokerApiInitStatus = r100;
    }

    public static void setIsUploadGPS(boolean r100) {
        sIsUploadGPS = r100;
    }

    public static void setIsUseQuickGPS(boolean r100) {
        sIsUseQuickGPS = r100;
    }

    public static void setLightInfoInterval(int r100) {
        sLightInfoInterval = r100;
    }

    public static void setLiveExperienceProvider(ILiveExperienceProvider r100) {
        sLiveExperienceProvider = r100;
    }

    public static void setLiveStallReportEnabled(boolean r100) {
        sLiveStallReportEnabled = r100;
    }

    public static void setLiveStallReportWindowMs(int r100) {
        if (r100 > 0) goto L5;
        r100 = 5000;
    L5:
        sLiveStallReportWindowMs = r100;
    }

    public static void setLocale(Locale r100) {
        sLocale = r100;
    }

    public static void setLocateType(int r100) {
        sLocateType = r100;
    }

    public static void setLocationCacheTokenWhiteList(String r100) {
        sLocationCacheTokenWhiteList = r100;
    }

    public static void setLocationExpiredInterval(long r100) {
        sLocationExpiredInterval = r100;
    }

    public static void setLocationMode(int r100) {
        sLocationMode = r100;
    }

    public static void setLogIdCacheEntity(LogIdCacheEntity r100) {
        mLogIdCacheEntity = r100;
    }

    public static void setMaxLightCount(int r100) {
        sMaxLightCount = r100;
    }

    public static void setMaxLightDuration(long r100) {
        sMaxLightDuration = r100;
    }

    public static void setMaxLocationTimeMs(long r100) {
        sMaxLocationTimeMs = r100;
    }

    public static void setMaxWaitGpsTimeMillis(long r100) {
        sMaxWaitGpsTimeMillis = r100;
    }

    public static void setMockEnable(boolean r100) {
        sIsMockEnable = r100;
    }

    public static void setMockUpload(boolean r100) {
        sIsMockUpload = r100;
    }

    public static void setMockWifiName(String r100) {
        sMockWifiName = r100;
        LocationCache.getInstance().setMockWifiName(r100);
    }

    public static void setMonitorBusinessStartLocationClassMemberList(List<String> r100) {
        sMonitorBusinessStartLocationClassMemberList = r100;
    }

    public static void setMonitorBusinessStopLocationClassMemberList(List<String> r100) {
        sMonitorBusinessStopLocationClassMemberList = r100;
    }

    public static void setMonitorStrategy(int r100) {
        sMonitorStrategy = r100;
    }

    public static void setMonitorStrategyClassMemberList(List<String> r100) {
        sMonitorStrategyClassMemberList = r100;
    }

    public static void setMonitorStrategyInterval(long r100) {
        sMonitorStrategyInterval = r100;
    }

    public static void setNeedDownGradeLocationInOverseas(boolean r100) {
        sNeedDownGradeLocationInOverseas = r100;
    }

    public static void setNeedUploadLastContinuousLocation(boolean r100) {
        sNeedUploadLastContinuousLocation = r100;
    }

    public static void setNetworkApi(ICustomNetworkApi r100) {
        sNetworkApi = r100;
    }

    public static void setNetworkSignatureMode(String r100) {
        sNetworkSignatureMode = r100;
    }

    public static void setNetworkStatusChangeUploadInterval(long r100) {
        sNetworkStatusChangeUploadInterval = sNetworkStatusChangeUploadInterval;
    }

    public static void setNoLocReqCgiEnable(boolean r100) {
        sIsNoLocReqCgiEnable = r100;
    }

    public static void setOnline(boolean r100) {
        sOnline = r100;
    }

    public static void setOpenStationaryScene(boolean r100) {
        monitor-enter(OPEN_STATIONARY_SCENE_LOCK);
        sOpenStationaryScene = r100;     // Catch: Throwable -> L7
        monitor-exit(OPEN_STATIONARY_SCENE_LOCK);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static void setOpenWifiListMonitor(boolean r100) {
        sOpenWifiListMonitor = r100;
    }

    public static void setOverseasGetLocationFailedUseCacheValidity(long r100) {
        sOverseasGetLocationFailedUseCacheValidity = r100;
    }

    public static void setPackageName(String r100) {
        sPackageName = r100;
    }

    public static void setPermissionChecker(IPermissionChecker r100) {
        sPermissionChecker = r100;
    }

    public static void setPollingUpload(boolean r100) {
        Logger.i("setPollingUpload", ":" + r100);
        sIsPollingUpload = r100;
    }

    public static void setPreLocationCallback(boolean r100) {
        sEnablePreLocationCallback = r100;
    }

    public static void setPrivacyConfirmed(boolean r100) {
        isPrivacyConfirmed = r100;
    }

    public static void setRedGeoNameIds(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        sRedGeoNameIds = r100;
    }

    public static void setRegionInChineseChannel(boolean r100) {
        sRegionInChineseChannel = r100;
    }

    public static void setReportAtStart(boolean r100) {
        sReportAtStart = r100;
    }

    public static void setReportLocationAtStart(boolean r100) {
        sReportLocationAtStart = r100;
    }

    public static void setRequestLocation(boolean r100) {
        sShouldRequestLocation = r100;
    }

    public static void setRescanWifiCount(int r100) {
        sRescanWifiCount = r100;
    }

    public static void setRestrictedMode(BDRestrictedMode r100) {
        sRestrictedMode = r100;
    }

    public static void setRevertToSystemLocation(boolean r100) {
        sRevertToSystemLocation = r100;
    }

    public static void setScanBleInterval(long r100) {
        if (r100 <= 10000) goto L5;
        r100 = 10000;
    L5:
        sScanBleInterval = r100;
    }

    public static void setSdkVersion(String r100) {
        sSdkVersion = r100;
    }

    public static void setSearchLocationCacheTime(long r100) {
        sSearchLocationCacheTime = r100;
    }

    public static void setSensorAccelerometerEnabled(boolean r100) {
        sSensorAccelerometerEnabled = r100;
    }

    public static void setSensorBarometerEnabled(boolean r100) {
        sSensorBarometerEnabled = r100;
    }

    public static void setSensorContinuousCollectEnabled(boolean r100) {
        sSensorContinuousCollectEnabled = r100;
    }

    public static void setSensorDopEnabled(boolean r100) {
        sSensorDopEnabled = r100;
    }

    public static void setSensorGnssEnabled(boolean r100) {
        sSensorGnssEnabled = r100;
    }

    public static void setSensorGyroscopeEnabled(boolean r100) {
        sSensorGyroscopeEnabled = r100;
    }

    public static void setSensorLightEnabled(boolean r100) {
        sSensorLightEnabled = r100;
    }

    public static void setSensorMagnetometerEnabled(boolean r100) {
        sSensorMagnetometerEnabled = r100;
    }

    public static void setSensorMaxCacheSeconds(long r100) {
        sSensorMaxCacheSeconds = r100;
    }

    public static void setSessionId(String r100) {
        sSessionId = r100;
    }

    public static void setShakeConfig(JSONObject r100) {
        mShakeConfig = r100;
    }

    public static void setSlardarAid(String r100) {
        sSlardarAid = r100;
    }

    public static void setStationarySceneMaxDistance(int r100) {
        sStationarySceneMaxDistance = r100;
    }

    public static void setStationarySceneMaxGpsAccuracy(int r100) {
        sStationarySceneMaxGpsAccuracy = r100;
    }

    public static void setStationarySceneMaxInterval(long r100) {
        sStationarySceneMaxInterval = r100;
    }

    public static void setStationarySceneTokenWhiteList(String r100) {
        sStationarySceneTokenWhiteList = r100;
    }

    public static void setStationarySceneWifiWhiteList(String r100) {
        sStationarySceneWifiWhiteList = r100;
    }

    public static void setStrictRestrictedMode(boolean r100) {
        sIsStrictRestrictedMode = r100;
    }

    public static void setSysNetworkLocEnable(boolean r100) {
        sIsSysNetworkLocEnable = r100;
    }

    public static void setTailAccuracyThreshold(float r100) {
        sTailAccuracyThreshold = r100;
    }

    public static void setTailWifiTimeThreshold(long r100) {
        sTailWifiTimeThreshold = r100;
    }

    public static void setUpdateVersionCode(String r100) {
        sUpdateVersionCode = r100;
    }

    public static void setUpload(boolean r100) {
        sIsUpload = r100;
    }

    public static void setUploadBaseSite(boolean r100) {
        sIsUploadBaseSite = r100;
    }

    public static void setUploadBleImmediately(boolean r100) {
        sUploadBleImmediately = r100;
    }

    public static void setUploadBleNum(int r100) {
        sUploadBleNum = r100;
    }

    public static void setUploadFreshBaseStation(boolean r100) {
        sIsUploadFreshBaseStation = r100;
    }

    public static void setUploadInterval(long r100) {
        sUploadInterval = r100;
    }

    public static void setUploadLocation(boolean r100) {
        sIsUploadLocation = r100;
    }

    public static void setUploadMccAndSystemRegionInfo(boolean r100) {
        sUploadMccAndSystemRegionInfo = r100;
    }

    public static void setUploadNetSignalInterval(long r100) {
        sUploadNetSignalInterval = r100;
    }

    public static void setUploadWIFI(boolean r100) {
        if (isDebug() == false) goto L6;
        sIsUploadWIFI = r100;
        return;
    }

    public static void setUseCacheCondition(boolean r100) {
        sUseCacheCondition = r100;
    }

    public static void setUseGpsCheckRegion(boolean r100) {
        sUseGpsCheckRegion = r100;
    }

    public static void setUseNewCacheStrategy(boolean r100) {
        sUseNewCacheStrategy = r100;
    }

    public static void setUseNewReverseGeoLocationApi(boolean r100) {
        sUseNewReverseGeoLocationApi = r100;
    }

    public static void setWifiNum(int r100) {
        sWifiNum = r100;
    }

    public static void setWifiScanInterval(long r100) {
        sWifiScanInterval = r100;
    }

    public static void setWorldView(String r100) {
        sWorldView = r100;
    }

    private static List<LocationNotification> switchNotification(int r100) {
        List<LocationNotification> r101 = sNotifications.get(r100);
        if (r101 != null) goto L6;
        ArrayList r102 = new ArrayList();
        sNotifications.put(r100, r102);
        return r102;
    L6:
        return r101;
    }

    public static void addNotification(LocationNotification r100, Object r101) {
        long r102 = System.currentTimeMillis();
        String r103 = RESTRICTED_LOCK;     // Catch: Exception -> L19
        monitor-enter(r103);     // Catch: Exception -> L19
        LocationUtil.checkBpeaCertNull("addNotification", r101);     // Catch: Throwable -> L16
        int r104 = 0;
        if (r101 == null) goto L12;
        BPEACertCheckResult r105 = BDLocationExtrasService.getBPEAManager().checkAndTranslateCert(r101, "addNotification");     // Catch: Throwable -> L16
        if (r105 == null) goto L12;
        if (r105.getParams() == null) goto L12;
        r104 = r105.getParams().optInt(FilterData.FilterOptionItem.Type.RANGE, 0);     // Catch: Throwable -> L16
    L12:
        switchNotification(r104).add(r100);     // Catch: Throwable -> L16
        monitor-exit(r103);     // Catch: Throwable -> L16
        Logger.i("addNotification interval:" + (System.currentTimeMillis() - r102));     // Catch: Exception -> L19
        return;
    L16:
        th = move-exception;
        throw th;     // Catch: Exception -> L19
    L19:
        e = move-exception;
        Logger.d("addNotification change error:" + e.getMessage());
    }

    public static void addSubmitNotification(Object r100, LocationSubmitNotification r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        if (r100 == null) goto L14;
        BDLocationExtrasService.getBPEAManager().checkAndTranslateCert(r100, "addSubmitNotification");     // Catch: BDLocationException -> L11
        if (sSubmitNotifications != null) goto L9;
        sSubmitNotifications = new CopyOnWriteArrayList();     // Catch: BDLocationException -> L11
    L9:
        sSubmitNotifications.add(r101);     // Catch: BDLocationException -> L11
        return;
    L11:
        e = move-exception;
        e.printStackTrace();
        return;
    L14:
        if (sSubmitNotifications != null) goto L16;
        sSubmitNotifications = new CopyOnWriteArrayList();
    L16:
        sSubmitNotifications.add(r101);
    }

    private static long frequencyHzToIntervalMs(int r100, long r101) {
        if (r100 > 0) goto L5;
        return r101;
    L5:
        return Math.max(1, 1000 / ((long) r100));
    }

    private static int frequencyHzToIntervalUs(int r100, int r101) {
        if (r100 > 0) goto L5;
        return r101;
    L5:
        return 1000000 / r100;
    }

    private static /* synthetic */ void lambda$notificationLocationChange$0(int r100, BDLocation r101) {
        String r102 = RESTRICTED_LOCK;
        monitor-enter(r102);
    L5:
        if (r100 >= 5) goto L13;
        List<LocationNotification> r103 = sNotifications.get(r100);     // Catch: Throwable -> L15
        if (r103 == null) goto L12;
        Iterator<LocationNotification> r104 = r103.iterator();     // Catch: Throwable -> L15
    L10:
        if (r104.hasNext() == false) goto L12;
        r104.next().onLocationChanged(r101);     // Catch: Throwable -> L15
    L12:
        r100 = r100 + 1;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    L13:
        monitor-exit(r102);     // Catch: Throwable -> L15
    }

    public static void notificationLocationChange(final int r100, BDLocation r101) {
        final BDLocation r102 = new BDLocation(r101);
        r102.setLongitude(AudioStats.AUDIO_AMPLITUDE_NONE);
        r102.setLatitude(AudioStats.AUDIO_AMPLITUDE_NONE);
        r102.setAltitude(AudioStats.AUDIO_AMPLITUDE_NONE);
        if (r102.getLocationResult() == null) goto L5;
        r102.getLocationResult().gps = null;
    L5:
        new Handler(Looper.getMainLooper()).post(new a(r100, r102));
    }

    public static void removeNotification(LocationNotification r100, int r101) {
        String r102 = RESTRICTED_LOCK;
        monitor-enter(r102);
        switchNotification(r101).remove(r100);     // Catch: Throwable -> L7
        monitor-exit(r102);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static void addNotification(LocationNotification r100, int r101) {
        long r102 = System.currentTimeMillis();
        String r103 = RESTRICTED_LOCK;
        monitor-enter(r103);
        LocationUtil.withoutBpeaCertCheck("addNotification");     // Catch: Throwable -> L6 Exception -> L8
        switchNotification(r101).add(r100);     // Catch: Throwable -> L6 Exception -> L8
        Logger.i("addNotification interval:" + (System.currentTimeMillis() - r102));     // Catch: Throwable -> L6 Exception -> L8
    L10:
        monitor-exit(r103);     // Catch: Throwable -> L6
        return;
    L8:
        e = move-exception;
        Logger.d("addNotification change withoutBpeaCertCheck error:" + e.getMessage());     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        throw th;
    }
}
