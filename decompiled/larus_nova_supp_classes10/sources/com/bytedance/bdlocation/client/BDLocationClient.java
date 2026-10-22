package com.bytedance.bdlocation.client;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.bdlocation.BDLocation;
import com.bytedance.bdlocation.LocationUtil;
import com.bytedance.bdlocation.callback.BDLocationCallback;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.bdlocation.exception.BDLocationExceptionMessage;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.monitor.LBSLightLocationTraceLogger;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.bdlocation.monitor.LocationTraceLogger;
import com.bytedance.bdlocation_impl.trace.LocationTraceManager;
import l84.k;
import l84.m;
import l84.n;
import l84.o;
import l84.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public class BDLocationClient {
    public static String COMMON_UPLOAD_SOURCE = "from_client";
    private Context mContext;
    private LocationOption mOption;

    public void stopLocation() {
        monitor-enter(this);
        Logger.i("BDLocationClient:stopLocation");     // Catch: Throwable -> L6
        k r0 = k.l();     // Catch: Throwable -> L6
        r0.getClass();     // Catch: Throwable -> L6
        Logger.i("BDLocationService.stopLocation.");     // Catch: Throwable -> L6
        k.q.post(new n(r0));     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public void stopLocationBecauseEnterBackground() {
        monitor-enter(this);
        Logger.i("BDLocationClient:stopLocationBecauseEnterBackground");     // Catch: Throwable -> L6
        k r0 = k.l();     // Catch: Throwable -> L6
        r0.getClass();     // Catch: Throwable -> L6
        Logger.i("BDLocationService.stopLocationBecauseEnterBackground.");     // Catch: Throwable -> L6
        k.q.post(new m(r0));     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public BDLocation getLocation() throws BDLocationException {
        Logger.d("BDLocationClient:getLocation synchronization");
        LocationTraceLogger r0 = new LocationTraceLogger();
        r0.begin("total_duration");
        r0.begin(LocationMonitorConst.LOCATION_RULE_CHECK_DURATION);
        LBSLightLocationTraceLogger r1 = new LBSLightLocationTraceLogger();
        r1.begin(LBSLightLocationTraceLogger.TOTAL);
        r1.begin(LBSLightLocationTraceLogger.PREPARE);
        if (initIfNeed() == true) goto L6;
        Logger.i("BDLocationClient:getLocation not init");
        r0.locationErrorReport(new BDLocationException(BDLocationExceptionMessage.NOT_INITIALIZATION, LocationInfoConst.BDLOCATION, BDLocationException.ERROR_INIT_LOCATION));
        return null;
    L6:
        LocationOption r2 = this.mOption;
        if (r2 == null) goto L10;
        r2.setLocationTraceLogger(r0);
        this.mOption.setLBSLightLocationTraceLogger(r1);
        this.mOption.setOnceLocation(true);
        this.mOption.setBpeaAction("getLocationCert");
        LocationUtil.checkBpeaCertNull("execLocation", this.mOption.getBpeaCert());
        return k.l().j(new LocationOption(this.mOption));
    L10:
        Logger.i("BDLocationClient:getLocation option is null");
        BDLocationException r3 = new BDLocationException(BDLocationExceptionMessage.LOCATION_OPTION_IS_NULL, LocationInfoConst.UNKNOWN_SERVER_LOCATE_METHOD, BDLocationException.ERROR_LOCATION_OPTION);
        r0.locationErrorReport(r3);
        throw r3;
    }

    private long getPollUploadInterval() {
        return j84.a.a().b();
    }

    public boolean initIfNeed() {
        if (BDLocationConfig.initIfNeed() == false) goto L6;
        return true;
    L6:
        Logger.i("Must be called after BDLocation initialization!");
        return false;
    }

    public BDLocationClient(Context r1) {
        this.mContext = r1;
    }

    private LocationOption getOption(BDLocationClientOption r4) {
        LocationOption r0 = new LocationOption();
        r0.setLocateType(r4.getLocateType());
        r0.setLocationTimeOutMs(r4.getLocationTimeOut());
        r0.setMaxCacheTime(r4.getMaxCacheTime());
        r0.setUploadSource(r4.getUploadSource());
        r0.setCert(r4.isCert());
        r0.setAccuracyLevel(r4.getAccuracyLevel());
        r0.setInterval(r4.getInterval());
        r0.setHostSwitchThreadDuration(r4.getHostSwitchThreadDuration());
        r0.setTriggerType(r4.getTriggerType());
        r0.setMode(r4.getLocationMode());
        r0.setBpeaCert(r4.getBpeaCert());
        r0.setLatestAdminVersion(r4.isLatestAdminVersion());
        r0.setUpload(r4.isUpload());
        r0.enableAMapBackgroundContiLocation = r4.isEnableAMapBackgroundContiLocation();
        r0.setSynchronizeUpload(r4.isSynchronizeUpload());
        r0.setAMapGpsFirst(r4.isAMapGpsFirst());
        r0.setAMapGpsFirstTimeoutMillis(r4.getAMapGpsFirstTimeoutMillis());
        if (TextUtils.isEmpty(r0.getUploadSource()) == false) goto L5;
        r0.setUploadSource(COMMON_UPLOAD_SOURCE);
    L5:
        r0.setExtra(r4.getExtra());
        r0.setGpsTimeoutMs(r4.getGpsTimeoutMs());
        r0.setBackupIntervalMs(r4.getBackupIntervalMs());
        r0.setBusinessId(r4.getBusinessId());
        r0.setAcceptLightLocationResult(r4.getAcceptLightLocationResult());
        r0.setTraceContext(r4.getTraceContext());
        r0.setFusionLocationWorkMode(r4.getFusionLocationWorkMode());
        r0.setFusionLocationUserMotionMode(r4.getFusionLocationUserMotionMode());
        return r0;
    }

    public void getLocation(BDLocationCallback r7) {
        Logger.d("BDLocationClient:getLocation asynchronous");
        LocationTraceManager r0 = LocationTraceManager.b.a;
        LocationOption r1 = this.mOption;
        r0.getClass();
        LocationTraceManager.d r2 = LocationTraceManager.i(r1);
        if (r2 != null) goto L5;
        LocationTraceManager.c r3 = null;
    L6:
        BDLocationCallback r4 = createSingleTraceCallback(r7, r3);
        LocationTraceLogger r5 = new LocationTraceLogger();
        r5.begin("total_duration");
        r5.begin(LocationMonitorConst.LOCATION_RULE_CHECK_DURATION);
        LBSLightLocationTraceLogger r6 = new LBSLightLocationTraceLogger();
        r6.begin(LBSLightLocationTraceLogger.TOTAL);
        r6.begin(LBSLightLocationTraceLogger.PREPARE);
        r6.begin(LBSLightLocationTraceLogger.SUB_PREPARE);
        if (initIfNeed() == true) goto L10;
        Logger.i("BDLocationClient:getLocation not init");
        reportNotInitError(r5, r4);
        return;
    L10:
        LocationOption r8 = this.mOption;
        if (r8 != null) goto L15;
        if (r7 == null) goto L15;
        Logger.i("BDLocationClient:getLocation option is null");
        reportNotInitError(r5, r4);
        return;
    L15:
        r8.setLocationTraceLogger(r5);
        this.mOption.setLBSLightLocationTraceLogger(r6);
        this.mOption.setOnceLocation(true);
        this.mOption.setBpeaAction("getLocation");
        LocationUtil.checkBpeaCertNull("getLocation", this.mOption.getBpeaCert());     // Catch: BDLocationException -> L19
        k.l().v(r4, new LocationOption(this.mOption), r3, null);
        return;
    L19:
        e = move-exception;
        r4.onError(e);
        r5.locationErrorReport(e);
        return;
    L5:
        r3 = new LocationTraceManager.c(r2, r1, SystemClock.elapsedRealtime());
        goto L6
    }

    public void setClientOption(BDLocationClientOption r5) {
        if (r5.getBpeaCert() != null) goto L5;
        Logger.i("setClientOption bpea cert is null");
    L5:
        LocationOption r6 = getOption(r5);
        this.mOption = r6;
        if (r6 != null) goto L8;
        return;
    L8:
        if (r6.getMaxCacheTime() > 0) goto L10;
        return;
    L10:
        if (BDLocationConfig.isPollingUpload() == false) goto L15;
        this.mOption.setMaxCacheTime(getPollUploadInterval());
        return;
    }

    public void startLocation(BDLocationCallback r7) {
        monitor-enter(this);
        Logger.d("BDLocationClient:startLocation");     // Catch: Throwable -> L27
        LocationTraceManager r0 = LocationTraceManager.b.a;     // Catch: Throwable -> L27
        LocationTraceManager.a r1 = r0.q(this.mOption);     // Catch: Throwable -> L27
        if (initIfNeed() == true) goto L10;
        BDLocationException r2 = new BDLocationException(BDLocationExceptionMessage.NOT_INITIALIZATION, LocationInfoConst.BDLOCATION, BDLocationException.ERROR_INIT_LOCATION);     // Catch: Throwable -> L27
        r0.f(r1, r2);     // Catch: Throwable -> L27
        if (r7 == null) goto L8;
        r7.onError(r2);     // Catch: Throwable -> L27
    L8:
        monitor-exit(this);     // Catch: Throwable -> L27
        return;
    L10:
        LocationOption r3 = this.mOption;     // Catch: Throwable -> L27
        if (r3 != null) goto L16;
        if (r7 == null) goto L16;
        r7.onError(new BDLocationException(BDLocationExceptionMessage.LOCATION_OPTION_IS_NULL, LocationInfoConst.UNKNOWN_SERVER_LOCATE_METHOD, BDLocationException.ERROR_LOCATION_OPTION));     // Catch: Throwable -> L27
        monitor-exit(this);     // Catch: Throwable -> L27
        return;
    L16:
        r3.setOnceLocation(false);     // Catch: Throwable -> L27
        this.mOption.setBpeaAction("startLocation");     // Catch: Throwable -> L27
        LocationUtil.checkBpeaCertNull("startLocation", this.mOption.getBpeaCert());     // Catch: BDLocationException -> L21 Throwable -> L27
        k.l().v(r7, new LocationOption(this.mOption), null, r1);     // Catch: Throwable -> L27
        monitor-exit(this);     // Catch: Throwable -> L27
        return;
    L21:
        e = move-exception;
        r0.f(r1, e);     // Catch: Throwable -> L27
        if (r7 == null) goto L26;
        r7.onError(e);     // Catch: Throwable -> L27
    L26:
        return;
    L27:
        th = move-exception;
        throw th;
    }

    public void stopLocation(String r4) {
        monitor-enter(this);
        if (r4 != null) goto L17;
    L11:
        Logger.i("BDLocationClient:stopLocationForBusiness with null/empty businessId, calling legacy stopLocation");     // Catch: Throwable -> L14
        stopLocation();     // Catch: Throwable -> L14
        monitor-exit(this);     // Catch: Throwable -> L14
        return;
    L17:
    L14:
        th = move-exception;
        throw th;
    L6:
        if (r4.isEmpty() == true) goto L11;
        Logger.i("BDLocationClient:stopLocationForBusiness: ".concat(r4));     // Catch: Throwable -> L14
        LocationTraceManager.b.a.r(r4);     // Catch: Throwable -> L14
        k r1 = k.l();     // Catch: Throwable -> L14
        r1.getClass();     // Catch: Throwable -> L14
        Logger.i("BDLocationService.stopLocationForBusiness: ".concat(r4));     // Catch: Throwable -> L14
        k.q.post(new o(r1, r4));     // Catch: Throwable -> L14
        monitor-exit(this);     // Catch: Throwable -> L14
    }

    private BDLocationCallback createSingleTraceCallback(final BDLocationCallback r2, final LocationTraceManager.c r3) {
        if (r3 != null) goto L5;
        return r2;
    L5:
        return new AnonymousClass1(this, r3, r2);
    }

    public void reportNotInitError(LocationTraceLogger r5, BDLocationCallback r6) {
        if (r6 != null) goto L9;
        return;
    L9:
        BDLocationException r0 = new BDLocationException(BDLocationExceptionMessage.NOT_INITIALIZATION, LocationInfoConst.BDLOCATION, BDLocationException.ERROR_INIT_LOCATION);     // Catch: Throwable -> L6
        r6.onError(r0);     // Catch: Throwable -> L6
        r5.locationErrorReport(r0);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        Logger.e("reportNotInitError error: " + th);
        th.printStackTrace();
    }

    public void updateNavigationHint(String r4, int r5, float r6) {
        monitor-enter(this);
        if (r4 != null) goto L22;
    L16:
        Logger.w("BDLocationClient:updateNavigationHint ignored, businessId is null or empty");     // Catch: Throwable -> L19
        monitor-exit(this);     // Catch: Throwable -> L19
        return;
    L22:
    L19:
        th = move-exception;
        throw th;
    L6:
        if (r4.isEmpty() == true) goto L16;
        if (initIfNeed() == true) goto L13;
        Logger.w("BDLocationClient:updateNavigationHint ignored, not initialized");     // Catch: Throwable -> L19
        monitor-exit(this);     // Catch: Throwable -> L19
        return;
    L13:
        Logger.i("BDLocationClient:updateNavigationHint: ".concat(r4));     // Catch: Throwable -> L19
        k r1 = k.l();     // Catch: Throwable -> L19
        r1.getClass();     // Catch: Throwable -> L19
        Logger.i("BDLocationService.updateNavigationHint: ".concat(r4));     // Catch: Throwable -> L19
        k.q.post(new p(r1, r4, r5, r6));     // Catch: Throwable -> L19
        monitor-exit(this);     // Catch: Throwable -> L19
    }

    public void updatingNavigationLocationConfig(String r3, String r4, boolean r5) {
        monitor-enter(this);
        if (r3 != null) goto L29;
    L23:
        Logger.w("BDLocationClient:updatingNavigationLocationConfig ignored, businessId is null or empty");     // Catch: Throwable -> L26
        monitor-exit(this);     // Catch: Throwable -> L26
        return;
    L29:
    L26:
        th = move-exception;
        throw th;
    L6:
        if (r3.isEmpty() == true) goto L23;
        if (initIfNeed() == true) goto L13;
        Logger.w("BDLocationClient:updatingNavigationLocationConfig ignored, not initialized");     // Catch: Throwable -> L26
        monitor-exit(this);     // Catch: Throwable -> L26
        return;
    L13:
        StringBuilder r1 = new StringBuilder("BDLocationClient:updatingNavigationLocationConfig: businessId=");     // Catch: Throwable -> L26
        r1.append(r3);     // Catch: Throwable -> L26
        r1.append(", navigationIdEmpty=");     // Catch: Throwable -> L26
        if (r4 != null) goto L16;
    L19:
        boolean r0 = true;
    L20:
        r1.append(r0);     // Catch: Throwable -> L26
        r1.append(", needUpload=");     // Catch: Throwable -> L26
        r1.append(r5);     // Catch: Throwable -> L26
        Logger.i(r1.toString());     // Catch: Throwable -> L26
        k.l().y(r3, r4, r5);     // Catch: Throwable -> L26
        monitor-exit(this);     // Catch: Throwable -> L26
        return;
    L16:
        if (r4.isEmpty() == true) goto L19;
        r0 = false;
        goto L20
    }
}
