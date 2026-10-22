package com.bytedance.bdlocation.amap;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.location.CoordinateConverter;
import com.amap.api.location.DPoint;
import com.bytedance.bdlocation.BDLocation;
import com.bytedance.bdlocation.BaseLocate;
import com.bytedance.bdlocation.LocationUtil;
import com.bytedance.bdlocation.callback.BDLocationCallback;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.bytedance.bdlocation.client.BDPoint;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.bdlocation.client.LocationOption;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.monitor.LocationMonitor;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.bdlocation.trace.LocateState;
import com.bytedance.bdlocation.trace.TraceCons;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import f06.b;
import f06.d;
import g06.a;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public class AMapLocationImpl extends BaseLocate {
    private static final String DEFAULT_BUSINESS_ID = "default_continuous_location";
    public static final String GEOCODE_TYPE = "AMap";
    public static final String LOCATION_NAME = "AMap";
    private volatile AMapLocationClient mClient;
    private Context mContext;
    private final ConcurrentHashMap<String, ContinuousLocationContext> mContinuousClients;
    private Object mContinuousLock;
    private Handler mHandler;
    private volatile boolean mIsFirstLocation;
    private volatile long mLastContinuousLocationStartTime;
    private AMapListener mListener;
    private AMapLocationClient mSingleClient;
    private String sdkVersion;

    /* JADX INFO: renamed from: com.bytedance.bdlocation.amap.AMapLocationImpl$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public class AMapListener implements AMapLocationListener {
        private String mBusinessId;
        private BDLocationCallback mCallback;
        private long mLocationStartTime;
        private Looper mLooper;
        private LocationOption mOption;
        final /* synthetic */ AMapLocationImpl this$0;

        private void setAMapLocateStateStop() {
            if (this.mOption.isOnceLocation() == false) goto L6;
            LocateState.aMapLocationStop(this);
            return;
        }

        public static /* synthetic */ BDLocationCallback access$1200(AMapListener r0) {
            return r0.mCallback;
        }

        public static /* synthetic */ void access$1500(AMapListener r0) {
            r0.setAMapLocateStateStop();
        }

        public static /* synthetic */ LocationOption access$200(AMapListener r0) {
            return r0.mOption;
        }

        public static /* synthetic */ String access$400(AMapListener r0) {
            return r0.mBusinessId;
        }

        public static /* synthetic */ long access$600(AMapListener r2) {
            return r2.mLocationStartTime;
        }

        public void onLocationChanged(final AMapLocation r21) {
            ArrayList r10 = new ArrayList();
            Object[] r11 = {r21};
            b r13 = new b();
            a r0 = (a) ApiHookConfig.b.get(101329);
            if (r0 == null) goto L5;
            f06.a[] r1 = r0.i;
        L6:
            f06.a[] r7 = r1;
            int r6 = r7.length;
            int r5 = 0;
        L8:
            if (r5 >= r6) goto L15;
            f06.a r4 = r7[r5];
            int r17 = r5;
            int r18 = r6;
            f06.a[] r19 = r7;
            d r2 = r4.preInvoke(101329, "com/bytedance/bdlocation/amap/AMapLocationImpl$AMapListener", "onLocationChanged", this, r11, "void", r13);     // Catch: Exception -> L27
            if (r2.a == true) goto L17;
            r10.add(r4);     // Catch: Exception -> L27
        L17:
            if (r2.a == false) goto L19;
            return;
        L19:
            if (r21 != null) goto L23;
            setAMapLocateStateStop();
            return;
        L23:
            if (AMapLocationImpl.access$100(this.this$0) != null) goto L25;
            AMapLocationImpl.access$102(this.this$0, new Handler(this.mLooper));
        L25:
            AMapLocationImpl.access$100(this.this$0).post(new AnonymousClass1(this, r21));
            return;
        L14:
            r5 = r17 + 1;
            r6 = r18;
            r7 = r19;
            goto L8
        L15:
            r2 = new d(false, null);
            goto L17
        L5:
            r1 = ApiHookConfig.d;
            goto L6
        }

        public AMapListener(AMapLocationImpl r7, BDLocationCallback r8, LocationOption r9, Looper r10) {
            this(r7, r8, r9, r10, null);
        }

        public AMapListener(AMapLocationImpl r1, BDLocationCallback r2, LocationOption r3, Looper r4, String r5) {
            this.this$0 = r1;
            this.mCallback = r2;
            this.mOption = r3;
            this.mLooper = r4;
            this.mBusinessId = r5;
            this.mLocationStartTime = SystemClock.elapsedRealtime();
            LocationMonitor.locationTraceLogBegin(r3.getLocationTraceLogger(), LocationMonitorConst.CORE_LOCATE_DURATION);
        }
    }

    public static class ContinuousLocationContext {
        AMapLocationClient client;
        boolean isFirstLocation;
        AMapListener listener;
        LocationOption option;
        long startTime;

        private ContinuousLocationContext() {
        }

        public /* synthetic */ ContinuousLocationContext(AnonymousClass1 r1) {
            this();
        }
    }

    private int transAMapTypeToBDType(int r5) {
        if (r5 != 1) goto L6;
        return 1;
    L6:
        if (r5 != 2) goto L9;
        return 8;
    L9:
        if (r5 != 4) goto L11;
        return 5;
    L11:
        if (r5 != 5) goto L14;
        return 2;
    L14:
        if (r5 != 6) goto L18;
        return 3;
    L18:
        if (r5 != 8) goto L20;
        return 9;
    L20:
        if (r5 != 9) goto L24;
        return 10;
    L24:
        if (r5 != 11) goto L26;
        return 11;
    L26:
        return 0;
    }

    public String getLocateName() {
        return "AMap";
    }

    public void stopLocation() {
        Object r0 = this.mContinuousLock;
        monitor-enter(r0);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (this.mClient == null) goto L10;
        this.mClient.stopLocation();     // Catch: Throwable -> L14
        LocateState.aMapLocationStop(this.mClient);     // Catch: Throwable -> L14
        this.mClient.unRegisterLocationListener(this.mListener);     // Catch: Throwable -> L14
        if (BDLocationConfig.enableDestroyAMapContinuousClient() == false) goto L9;
        Logger.i("AMapLocationImpl mClient onDestroy");     // Catch: Throwable -> L14
        this.mClient.onDestroy();     // Catch: Throwable -> L14
    L9:
        this.mClient = null;     // Catch: Throwable -> L14
    L10:
        this.mListener = null;     // Catch: Throwable -> L14
        this.mLastContinuousLocationStartTime = 0;     // Catch: Throwable -> L14
        monitor-exit(r0);     // Catch: Throwable -> L14
        onLocateStop("AMap");
        Logger.i("AMapLocationImpl stopLocation (legacy mode only)");
    }

    public AMapLocationImpl(Context r3) {
        super(r3);
        this.sdkVersion = "";
        this.mContinuousLock = new Object();
        this.mIsFirstLocation = true;
        this.mContinuousClients = new ConcurrentHashMap();
        this.mContext = r3;
        AMapLocationClient.updatePrivacyShow(r3, BDLocationConfig.isPrivacyConfirmed(), BDLocationConfig.isPrivacyConfirmed());
        AMapLocationClient.updatePrivacyAgree(r3, BDLocationConfig.isPrivacyConfirmed());
        AMapLocationClient r0 = new AMapLocationClient(r3.getApplicationContext());     // Catch: Exception -> L5
        this.mSingleClient = r0;     // Catch: Exception -> L5
        this.sdkVersion = r0.getVersion();     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
    }

    public static /* synthetic */ Handler access$100(AMapLocationImpl r0) {
        return r0.mHandler;
    }

    public static /* synthetic */ long access$1000(AMapLocationImpl r2) {
        return r2.mLastContinuousLocationStartTime;
    }

    public static /* synthetic */ boolean access$1100(AMapLocationImpl r0) {
        return r0.mIsFirstLocation;
    }

    public static /* synthetic */ Context access$300(AMapLocationImpl r0) {
        return r0.mContext;
    }

    public static /* synthetic */ String access$700(AMapLocationImpl r0) {
        return r0.sdkVersion;
    }

    public static /* synthetic */ Object access$800(AMapLocationImpl r0) {
        return r0.mContinuousLock;
    }

    public static /* synthetic */ ConcurrentHashMap access$900(AMapLocationImpl r0) {
        return r0.mContinuousClients;
    }

    private void stopClientSafely(ContinuousLocationContext r3) {
        AMapLocationClient r0 = r3.client;     // Catch: Exception -> L8
        if (r0 == null) goto L13;
        r0.stopLocation();     // Catch: Exception -> L8
        LocateState.aMapLocationStop(r3.client);     // Catch: Exception -> L8
        r3.client.unRegisterLocationListener(r3.listener);     // Catch: Exception -> L8
        if (BDLocationConfig.enableDestroyAMapContinuousClient() == false) goto L14;
        Logger.i("AMapLocationImpl continuous client onDestroy");     // Catch: Exception -> L8
        r3.client.onDestroy();     // Catch: Exception -> L8
        return;
    L14:
        return;
    L13:
        return;
    L8:
        e = move-exception;
        Logger.e("AMapLocationImpl stopClientSafely error", e);
    }

    public BDPoint convertGCJ02(BDPoint r9) {
        DPoint r0 = new DPoint(r9.getLatitude(), r9.getLongitude());     // Catch: Exception -> L4
        CoordinateConverter r1 = new CoordinateConverter(this.mContext);     // Catch: Exception -> L4
        r1.from(CoordinateConverter.CoordType.GPS);     // Catch: Exception -> L4
        r1.coord(r0);     // Catch: Exception -> L4
        DPoint r2 = r1.convert();     // Catch: Exception -> L4
        return new BDPoint(r2.getLatitude(), r2.getLongitude(), r9.getProvider());
    L4:
        e = move-exception;
        Logger.e("", e);
        return null;
    }

    public void stopLocationForBusiness(String r5) {
        if (r5 != null) goto L5;
    L18:
        Logger.w("AMapLocationImpl stopLocationForBusiness: businessId is null or empty");
        return;
    L5:
        if (r5.isEmpty() == true) goto L18;
        Object r2 = this.mContinuousLock;
        monitor-enter(r2);
        ContinuousLocationContext r3 = this.mContinuousClients.remove(r5);     // Catch: Throwable -> L15
        if (r3 == null) goto L12;
        stopClientSafely(r3);     // Catch: Throwable -> L15
        Logger.i("AMapLocationImpl stopLocationForBusiness: " + r5 + ", remaining clients: " + this.mContinuousClients.size());     // Catch: Throwable -> L15
    L13:
        monitor-exit(r2);     // Catch: Throwable -> L15
        return;
    L12:
        Logger.i("AMapLocationImpl stopLocationForBusiness: businessId not found: ".concat(r5));     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    }

    public void stopSingleLocation(AMapListener r2) {
        if (this.mSingleClient == null) goto L8;
        Logger.i("AMapLocationImpl stopSingleLocation");
        this.mSingleClient.stopLocation();
        this.mSingleClient.unRegisterLocationListener(r2);
        if (BDLocationConfig.enableDestroyAMapSingleClient() == false) goto L9;
        Logger.i("AMapLocationImpl mSingleClient onDestroy ");
        this.mSingleClient.onDestroy();
        this.mSingleClient = null;
        return;
    L9:
        return;
    }

    public static /* synthetic */ long access$1002(AMapLocationImpl r0, long r1) {
        r0.mLastContinuousLocationStartTime = r1;
        return r1;
    }

    public static /* synthetic */ Handler access$102(AMapLocationImpl r0, Handler r1) {
        r0.mHandler = r1;
        return r1;
    }

    public static /* synthetic */ boolean access$1102(AMapLocationImpl r0, boolean r1) {
        r0.mIsFirstLocation = r1;
        return r1;
    }

    private BDLocationException mapBDException(int r5, String r6) {
        if (r5 != 12) goto L9;
        if (r6.contains("1206") == false) goto L14;
        BDLocationException r7 = new BDLocationException("定位服务没有开启，请在设置中打开定位服务开关", "AMap", BDLocationException.ERROR_DEVICE_LOCATION_DISABLE);
        r7.addExtra(TraceCons.EXTRA_FAIL_AMAP_CODE, String.valueOf(r5));
        return r7;
    L14:
        BDLocationException r0 = new BDLocationException(r6, "AMap", BDLocationException.ERROR_AMAP_FAIL);
        r0.addExtra(TraceCons.EXTRA_FAIL_AMAP_CODE, String.valueOf(r5));
        return r0;
    L9:
        if (r5 != 4) goto L14;
        if (r6.contains("0401") == false) goto L14;
        BDLocationException r8 = new BDLocationException("网络异常，未连接到网络，请连接网络", "AMap", BDLocationException.ERROR_ABNORMAL_NETWORK);
        r8.addExtra(TraceCons.EXTRA_FAIL_AMAP_CODE, String.valueOf(r5));
        return r8;
    }

    private void onError(BDLocationCallback r1, BDLocationException r2) {
        if (r1 == null) goto L4;
        r1.onError(r2);
    L4:
        onLocateError("AMap", r2);
    }

    private BDLocation transform(AMapLocation r12, LocationOption r13) {
        BDLocation r0 = new BDLocation(r12, "AMap");
        String r2 = r12.getCoordType();
        Logger.i("AMap", "The CoordType of AMapLocation is " + r2);
        if ("GCJ02".equals(r2) == false) goto L6;
        r0.setCoordinateSystem(LocationInfoConst.GCJ_O2);
    L6:
        if ("WGS84".equals(r2) == false) goto L8;
        r0.setCoordinateSystem(LocationInfoConst.WGS_84);
    L8:
        if (r13 != null) goto L10;
    L12:
        r0.setMock(r12.isMock());
        r0.setAddress(r12.getAddress());
        r0.setCountry(r12.getCountry());
        r0.setAdministrativeArea(r12.getProvince());
        r0.setCity(r12.getCity());
        r0.setDistrict(r12.getDistrict());
        r0.setCityCode(r12.getCityCode());
        r0.setStreet(r12.getStreet());
        r0.setStreetNum(r12.getStreetNum());
        r0.setFloor(r12.getFloor());
        r0.setBuildingId(r12.getBuildingId());
        r0.setLocationMs(System.currentTimeMillis());
        r0.setPoi(r12.getPoiName());
        r0.setAoi(r12.getAoiName());
        r0.setBearing(r12.getBearing());
        r0.setSpeed(r12.getSpeed());
        r0.setTrustedLevel(r12.getTrustedLevel());
        r0.setLocationDetail(r12.getLocationDetail());
        r0.setSatellites(r12.getSatellites());
        int r14 = r12.getLocationType();
        Logger.i("AMapLocationImpl amapType:" + r14);
        r0.setLocationType(transAMapTypeToBDType(r14));
        boolean r15 = CoordinateConverter.isAMapDataAvailable(r12.getLatitude(), r12.getLongitude());
        Logger.i("AMap", "The result of the method isAMapDataAvailable is " + r15);
        if (r15 == false) goto L15;
        r0.setGCJ02(new BDPoint(r12.getLatitude(), r12.getLongitude(), r12.getProvider()));
        r0.setCoordinateSystem(LocationInfoConst.GCJ_O2);
    L15:
        return r0;
    L10:
        if (r13.getGeocodeMode() != 1) goto L12;
        r0.setGeocodeSDKName("AMap");
        goto L12
    }

    public float calculateLineDistance(BDPoint r4, BDPoint r5) {
        if (r4 == null) goto L7;
        if (r5 == null) goto L9;
        DPoint r0 = new DPoint();
        r0.setLatitude(r4.getLatitude());
        r0.setLongitude(r4.getLongitude());
        DPoint r6 = new DPoint();
        r6.setLatitude(r5.getLatitude());
        r6.setLongitude(r5.getLongitude());
        return CoordinateConverter.calculateLineDistance(r0, r6);
    L9:
        return 0.0f;
    L7:
        return 0.0f;
    }

    public boolean isAMapDataAvailable(double r3, double r5) {
        new CoordinateConverter(this.mContext);
        return CoordinateConverter.isAMapDataAvailable(r3, r5);
    }

    public static /* synthetic */ BDLocationException access$1300(AMapLocationImpl r0, int r1, String r2) {
        return r0.mapBDException(r1, r2);
    }

    public static /* synthetic */ void access$1400(AMapLocationImpl r0, BDLocationCallback r1, BDLocationException r2) {
        r0.onError(r1, r2);
    }

    public static /* synthetic */ BDLocation access$500(AMapLocationImpl r0, AMapLocation r1, LocationOption r2) {
        return r0.transform(r1, r2);
    }

    public void startLocation(BDLocationCallback r11, LocationOption r12, Looper r13) {
        super.startLocation(r11, r12, r13);
        if (LocationUtil.isLocationEnabled() == true) goto L7;
        Logger.i("AMapLocationImpl startLocation location is disabled");
        r11.onError(new BDLocationException("定位服务没有开启，请在设置中打开定位服务开关", "AMap", BDLocationException.ERROR_DEVICE_LOCATION_DISABLE));
        return;
    L7:
        if (LocationUtil.checkBackground() == false) goto L10;
        Logger.i("AMapLocationImpl startLocation location is background");
        return;
    L10:
        AMapLocationClientOption r0 = new AMapLocationClientOption();
        AMapLocationClientOption.setLocationProtocol(AMapLocationClientOption.AMapLocationProtocol.HTTPS);
        if (r12.getMode() != 0) goto L14;
        r0.setLocationMode(AMapLocationClientOption.AMapLocationMode.Battery_Saving);
    L17:
        r0.setSelfStartServiceEnable(BDLocationConfig.enableSelfStartService());
        boolean r2 = false;
        r0.setNeedAddress(false);
        if (r12.getMaxCacheTime() == 0) goto L20;
        boolean r4 = true;
    L21:
        r0.setLocationCacheEnable(r4);
        StringBuilder r5 = new StringBuilder("amapOption.setLocationCacheEnable: ");
        if (r12.getMaxCacheTime() == 0) goto L24;
        r2 = true;
    L24:
        r5.append(r2);
        r5.append(", uploadSource: ");
        r5.append(r12.getUploadSource());
        Logger.i(r5.toString());
        r0.setNoLocReqCgiEnable(BDLocationConfig.isNoLocReqCgiEnable());
        r0.setSysNetworkLocEnable(BDLocationConfig.isSysNetworkLocEnable());
        Logger.i("amapOption.setGpsFirst: " + r12.isAMapGpsFirst());
        r0.setGpsFirst(r12.isAMapGpsFirst());
        if (r12.isAMapGpsFirst() == false) goto L30;
        if (r12.getAMapGpsFirstTimeoutMillis() <= 0) goto L30;
        Logger.i("amapOption.setGpsFirstTimeout: " + r12.getAMapGpsFirstTimeoutMillis());
        r0.setGpsFirstTimeout(r12.getAMapGpsFirstTimeoutMillis());
    L30:
        if (r12.isOnceLocation() == false) goto L32;
        Logger.i("AMapLocationImpl startSingleLocation amap version:" + this.sdkVersion);
        r0.setInterval(1000);
        r0.setOnceLocation(true);
        r0.setHttpTimeOut(r12.getLocationTimeOutMs());
        startSingleLocation(r11, r12, r13, r0);
    L33:
        onLocateStart("AMap");
        return;
    L32:
        Logger.i("AMapLocationImpl startLocation");
        r0.setInterval(r12.getInterval());
        startContinuousLocation(r11, r12, r13, r0);
        goto L33
    L20:
        r4 = false;
        goto L21
    L14:
        if (r12.getMode() != 1) goto L16;
        r0.setLocationMode(AMapLocationClientOption.AMapLocationMode.Device_Sensors);
        goto L17
    L16:
        r0.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
        goto L17
    }

    private void startContinuousLocation(BDLocationCallback r8, LocationOption r9, Looper r10, AMapLocationClientOption r11) {
        if (this.mContext != null) goto L6;
        r8.onError(new BDLocationException("mContext is null", "AMap", BDLocationException.ERROR_AMAP_CLIENT));
        return;
    L6:
        String r2 = r9.getBusinessId();
        Logger.i("AMapLocationImpl startContinuousLocation businessId: " + r2);
        if (r2 != null) goto L9;
    L13:
        startContinuousLocationLegacy(r8, r9, r10, r11);
        return;
    L9:
        if (r2.isEmpty() == true) goto L13;
        startContinuousLocationMulti(r2, r8, r9, r10, r11);
    }

    private void startContinuousLocationLegacy(BDLocationCallback r6, LocationOption r7, Looper r8, AMapLocationClientOption r9) {
        Object r1 = this.mContinuousLock;     // Catch: Exception -> L15
        monitor-enter(r1);     // Catch: Exception -> L15
        stopLocation();     // Catch: Throwable -> L12
        this.mLastContinuousLocationStartTime = SystemClock.elapsedRealtime();     // Catch: Throwable -> L12
        this.mIsFirstLocation = true;     // Catch: Throwable -> L12
        this.mClient = new AMapLocationClient(this.mContext.getApplicationContext());     // Catch: Throwable -> L12
        this.mListener = new AMapListener(this, r6, r7, r8);     // Catch: Throwable -> L12
        this.mClient.setLocationOption(r9);     // Catch: Throwable -> L12
        Logger.i("amapOption.enableAMapBackgroundContiLocation: " + r7.enableAMapBackgroundContiLocation);     // Catch: Throwable -> L12
        if (r7.enableAMapBackgroundContiLocation == true) goto L8;
        this.mClient.disableBackgroundLocation(true);     // Catch: Throwable -> L12
    L8:
        this.mClient.setLocationListener(this.mListener);     // Catch: Throwable -> L12
        LocateState.aMapLocationStart(this.mClient);     // Catch: Throwable -> L12
        this.mClient.startLocation();     // Catch: Throwable -> L12
        monitor-exit(r1);     // Catch: Throwable -> L12
        Logger.i("AMapLocationImpl startContinuousLocation (legacy mode)");     // Catch: Exception -> L15
        return;
    L12:
        th = move-exception;
        throw th;     // Catch: Exception -> L15
    L15:
        r6.onError(new BDLocationException("amap client is null", "AMap", BDLocationException.ERROR_AMAP_CLIENT));
    }

    private void startSingleLocation(BDLocationCallback r5, LocationOption r6, Looper r7, AMapLocationClientOption r8) {
    L14:
        e = move-exception;
        r5.onError(new BDLocationException(e.getMessage(), "AMap", BDLocationException.ERROR_AMAP_CLIENT));
        return;
    L4:
        if (this.mSingleClient == null) goto L6;
    L12:
        AMapListener r2 = new AMapListener(this, r5, r6, r7);     // Catch: Exception -> L14
        this.mSingleClient.setLocationOption(r8);     // Catch: Exception -> L14
        this.mSingleClient.disableBackgroundLocation(true);     // Catch: Exception -> L14
        this.mSingleClient.setLocationListener(r2);     // Catch: Exception -> L14
        LocateState.aMapLocationStart(r2);     // Catch: Exception -> L14
        this.mSingleClient.startLocation();     // Catch: Exception -> L14
        return;
    L6:
        if (BDLocationConfig.enableDestroyAMapSingleClient() == false) goto L10;
        Context r3 = this.mContext;     // Catch: Exception -> L14
        if (r3 == null) goto L10;
        this.mSingleClient = new AMapLocationClient(r3.getApplicationContext());     // Catch: Exception -> L14
    L10:
        r5.onError(new BDLocationException("amap client is null", "AMap", BDLocationException.ERROR_AMAP_CLIENT));     // Catch: Exception -> L14
    }

    private void startContinuousLocationMulti(String r15, BDLocationCallback r16, LocationOption r17, Looper r18, AMapLocationClientOption r19) {
        Object r11 = this.mContinuousLock;     // Catch: Exception -> L14
        monitor-enter(r11);     // Catch: Exception -> L14
        stopLocationForBusiness(r15);     // Catch: Throwable -> L11
        ContinuousLocationContext r12 = new ContinuousLocationContext(null);     // Catch: Throwable -> L11
        r12.client = new AMapLocationClient(this.mContext.getApplicationContext());     // Catch: Throwable -> L11
        r12.listener = new AMapListener(this, r16, r17, r18, r15);     // Catch: Throwable -> L11
        r12.startTime = SystemClock.elapsedRealtime();     // Catch: Throwable -> L11
        r12.isFirstLocation = true;     // Catch: Throwable -> L11
        r12.option = r17;     // Catch: Throwable -> L11
        r12.client.setLocationOption(r19);     // Catch: Throwable -> L11
        Logger.i("amapOption.enableAMapBackgroundContiLocation: " + r17.enableAMapBackgroundContiLocation);     // Catch: Throwable -> L11
        if (r17.enableAMapBackgroundContiLocation == true) goto L8;
        r12.client.disableBackgroundLocation(true);     // Catch: Throwable -> L11
    L8:
        r12.client.setLocationListener(r12.listener);     // Catch: Throwable -> L11
        LocateState.aMapLocationStart(r12.client);     // Catch: Throwable -> L11
        r12.client.startLocation();     // Catch: Throwable -> L11
        this.mContinuousClients.put(r15, r12);     // Catch: Throwable -> L11
        Logger.i("AMapLocationImpl startContinuousLocation (multi mode) businessId: " + r15 + ", total clients: " + this.mContinuousClients.size());     // Catch: Throwable -> L11
        monitor-exit(r11);     // Catch: Throwable -> L11
    L21:
        return;
    L11:
        th = move-exception;
        throw th;     // Catch: Exception -> L14
    L14:
        e = move-exception;
        Logger.e("AMapLocationImpl startContinuousLocationMulti error", e);
        r16.onError(new BDLocationException("amap client start failed: " + e.getMessage(), "AMap", BDLocationException.ERROR_AMAP_CLIENT));
    }
}
