package l84;

import com.bytedance.bdlocation.BDLocation;
import com.bytedance.bdlocation.BaseLocate;
import com.bytedance.bdlocation.LocationUtil;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.bdlocation.client.LocationOption;
import com.bytedance.bdlocation.entity.LocateReasonEntity;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.monitor.LocationExtraDataTraceLogger;
import com.bytedance.bdlocation.monitor.LocationMonitor;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.bdlocation.scan.wifi.WifiUtil;
import com.bytedance.bdlocation.sensor.SensorInfoManager;
import com.bytedance.bdlocation.service.BDLocationExtraDataServer;
import com.bytedance.bdlocation.store.LocationCacheInfo;
import com.bytedance.bdlocation.thread.AppExecutors;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public class k$b implements Runnable {
    public final /* synthetic */ LocationOption a;
    public final /* synthetic */ BDLocation b;
    public final /* synthetic */ l0 c;
    public final /* synthetic */ boolean d;
    public final /* synthetic */ LocationCacheInfo e;
    public final /* synthetic */ LocateReasonEntity f;
    public final /* synthetic */ LocationOption g;
    public final /* synthetic */ k h;

    public final void a() {
        k r10 = k.r;
        monitor-enter(r10);
        LocationMonitor.locationTraceLogEnd(this.a.getLocationTraceLogger(), LocationMonitorConst.LOCATION_THREAD_SWITCH_DURATION);     // Catch: Throwable -> L127
        this.a.setBackground(LocationUtil.isBackground());     // Catch: Throwable -> L127
        this.a.setUploadInterval(j84.a.a().b() / 1000);     // Catch: Throwable -> L127
        k.a(this.h, this.a, this.b);     // Catch: Throwable -> L127
        LocationMonitor.locationTraceLogBegin(this.a.getLocationTraceLogger(), LocationMonitorConst.LOCATION_BEFORE_START_DURATION);     // Catch: Throwable -> L127
        k r11 = this.h;     // Catch: Throwable -> L127
        LocationOption r12 = this.a;     // Catch: Throwable -> L127
        l0 r13 = this.c;     // Catch: Throwable -> L127
        r11.getClass();     // Catch: Throwable -> L127
        boolean r14 = true;
        if (k.d(true, r12, r13) == true) goto L10;
        Logger.i("RestrictedMode|background|LocationServer|permission unable");     // Catch: Throwable -> L127
        monitor-exit(r10);     // Catch: Throwable -> L127
        return;
    L10:
        if (this.d == false) goto L18;
        if (LocationUtil.isLocationEnabled() == true) goto L16;
        Logger.i("check allowUseLocation ERROR_DEVICE_LOCATION_DISABLE");     // Catch: Throwable -> L127
        k r0 = this.h;     // Catch: Throwable -> L127
        l0 r3 = this.c;     // Catch: Throwable -> L127
        r0.getClass();     // Catch: Throwable -> L127
        k.t(BDLocationException.ERROR_DEVICE_LOCATION_DISABLE, r3);     // Catch: Throwable -> L127
        Logger.i("RestrictedMode|background|LocationServer|permission unable");     // Catch: Throwable -> L127
        monitor-exit(r10);     // Catch: Throwable -> L127
        return;
    L16:
        Logger.i("location cache is validity, return cache location ");     // Catch: Throwable -> L127
        LocationMonitor.locationTraceLogEnd(this.a.getLocationTraceLogger(), LocationMonitorConst.LOCATION_RULE_CHECK_DURATION);     // Catch: Throwable -> L127
        k r1 = this.h;     // Catch: Throwable -> L127
        BDLocation r2 = this.b;     // Catch: Throwable -> L127
        l0 r4 = this.c;     // Catch: Throwable -> L127
        r1.getClass();     // Catch: Throwable -> L127
        AppExecutors.getInstance().mainThread().execute(new q(r4, r2));     // Catch: Throwable -> L127
    L124:
        Logger.d("startLocation :");     // Catch: Throwable -> L127
        monitor-exit(r10);     // Catch: Throwable -> L127
        return;
    L18:
        if (LocationUtil.isLocationEnabled() == true) goto L22;
        Logger.i("check allowUseLocation ERROR_DEVICE_LOCATION_DISABLE");     // Catch: Throwable -> L127
        k r5 = this.h;     // Catch: Throwable -> L127
        l0 r6 = this.c;     // Catch: Throwable -> L127
        r5.getClass();     // Catch: Throwable -> L127
        k.t(BDLocationException.ERROR_DEVICE_LOCATION_DISABLE, r6);     // Catch: Throwable -> L127
        Logger.i("RestrictedMode|background|LocationServer|permission unable");     // Catch: Throwable -> L127
        monitor-exit(r10);     // Catch: Throwable -> L127
        return;
    L22:
        k r15 = this.h;     // Catch: Throwable -> L127
        LocationOption r16 = this.a;     // Catch: Throwable -> L127
        r15.getClass();     // Catch: Throwable -> L127
        int r17 = r16.getLocateType();     // Catch: Throwable -> L127
        if (r17 != (-1)) goto L25;
        r17 = BDLocationConfig.getLocateType();     // Catch: Throwable -> L127
    L25:
        Logger.i("startLocation locateType:" + r17);     // Catch: Throwable -> L127
        if (this.a.isOnceLocation() == false) goto L76;
        if (BDLocationConfig.isMockEnable() == false) goto L30;
    L33:
        BaseLocate r7 = this.h.b.a(r17);     // Catch: Throwable -> L127
        if (r7 != null) goto L36;
        Logger.i("mLocation is null");     // Catch: Throwable -> L127
        BDLocationException r8 = new BDLocationException("未获取到定位内核异常", "2.17.6-rc.81", BDLocationException.ERROR_NO_LOCATE);     // Catch: Throwable -> L127
        k r9 = this.h;     // Catch: Throwable -> L127
        l0 r18 = this.c;     // Catch: Throwable -> L127
        r9.getClass();     // Catch: Throwable -> L127
        k.s(r18, r8);     // Catch: Throwable -> L127
    L123:
        LocationMonitor.getLightLocationMonitor();     // Catch: Throwable -> L127
        goto L124
    L36:
        if (BDLocationConfig.isUseCacheCondition() == false) goto L46;
        LocationCacheInfo r19 = this.e;     // Catch: Throwable -> L127
        long r20 = -1;
        if (r19 == null) goto L40;
        long r22 = r19.getLatestLocationCacheTime();     // Catch: Throwable -> L127
        int r21 = this.e.getLatestLocationCacheCondition();     // Catch: Throwable -> L127
    L41:
        long r23 = System.currentTimeMillis();     // Catch: Throwable -> L127
        k r24 = this.h;     // Catch: Throwable -> L127
        long r110 = r24.n;     // Catch: Throwable -> L127
        if (r110 == (-1)) goto L44;
        r20 = r23 - r110;     // Catch: Throwable -> L127
    L44:
        r24.n = r23;     // Catch: Throwable -> L127
        LocationMonitor.locationFrequencyMonitor(this.a, this.f.getReasonCode(), r23, r20, r21, r22);     // Catch: Throwable -> L127
        goto L46
    L40:
        r22 = -1;
        r21 = -1;
    L46:
        if (this.g.isDownGradeLocation() == false) goto L48;
    L64:
        LocationMonitor.locationTraceLogEnd(this.a.getLocationTraceLogger(), LocationMonitorConst.LOCATION_BEFORE_START_DURATION);     // Catch: Throwable -> L127
        LocationMonitor.locationTraceLogEnd(this.a.getLocationTraceLogger(), LocationMonitorConst.LOCATION_RULE_CHECK_DURATION);     // Catch: Throwable -> L127
        k r25 = this.h;     // Catch: Throwable -> L127
        LocationOption r26 = this.a;     // Catch: Throwable -> L127
        l0 r27 = this.c;     // Catch: Throwable -> L127
        r25.getClass();     // Catch: Throwable -> L127
        if (r17 != 3) goto L67;
    L73:
        r7.startLocation(this.c, this.a, k.p);     // Catch: Throwable -> L127
        goto L123
    L67:
        if (r26.isOnceLocation() == false) goto L73;
        if (BDLocationConfig.isAsyncScanWifi() == false) goto L73;
        if ((r27 instanceof WifiUtil.WifiInfoJsonCallback) == false) goto L73;
        Logger.i("start scan wifi");     // Catch: Throwable -> L127
        WifiUtil.getWifiInfoJsonAsync(BDLocationConfig.getContext(), r27, r26.getBpeaCert(), r26.getLocationTraceLogger(), r26);     // Catch: Throwable -> L127
        goto L73
    L48:
        if (BDLocationConfig.isMockEnable() == true) goto L64;
        BDLocationExtraDataServer r28 = new BDLocationExtraDataServer();     // Catch: Throwable -> L127
        k r29 = this.h;     // Catch: Throwable -> L127
        if (r29.o.size() <= 20) goto L54;
        BDLocationExtraDataServer r30 = (BDLocationExtraDataServer) ListProtector.remove(r29.o, 0);     // Catch: Throwable -> L127
        if (r30 == null) goto L54;
        r30.stopCollectExtraData();     // Catch: Throwable -> L127
    L54:
        r29.o.add(r28);     // Catch: Throwable -> L127
        this.a.setLocationExtraDataServer(r28);     // Catch: Throwable -> L127
        LocationExtraDataTraceLogger r31 = new LocationExtraDataTraceLogger();     // Catch: Throwable -> L127
        this.a.setLocationExtraDataTraceLogger(r31);     // Catch: Throwable -> L127
        LocationMonitor.locationExtraDataTraceLogBegin(r31, LocationExtraDataTraceLogger.COLLECT_EXTRA_DATA_DURATION);     // Catch: Throwable -> L127
        Logger.i("location-trace-core isFirstLocation: " + BDLocationConfig.isFirstLocation() + ", ColdBootCollectGps: " + BDLocationConfig.getColdBootCollectGps());     // Catch: Throwable -> L127
        long r32 = BDLocationConfig.getDefaultGpsScanInterval();     // Catch: Throwable -> L127
        if (BDLocationConfig.isFirstLocation() == true) goto L57;
    L63:
        LocationMonitor.locationExtraDataTracePutCategoryData(r31, LocationExtraDataTraceLogger.DEFAULT_GPS_SCAN_INTERVAL, Long.valueOf(r32));     // Catch: Throwable -> L127
        LocationMonitor.locationExtraDataTracePutCategoryData(r31, LocationExtraDataTraceLogger.ENABLE_BACKGROUND_UPLOAD_LOCATION, Boolean.valueOf(BDLocationConfig.enableBackgroundUploadLocation()));     // Catch: Throwable -> L127
        LocationMonitor.locationExtraDataTracePutCategoryData(r31, "enable_upload_last_location_info", Boolean.valueOf(BDLocationConfig.enableUploadLastLocationInfo()));     // Catch: Throwable -> L127
        Logger.i("location-trace-core locationExtraDataServer.startCollectGpsData.");     // Catch: Throwable -> L127
        r28.startCollectGpsData(this.a, k.q, this.h.o);     // Catch: Throwable -> L127
        SensorInfoManager.getInstance().registerListener(5);     // Catch: Throwable -> L127
        goto L64
    L57:
        if (BDLocationConfig.getColdBootCollectGps() == false) goto L63;
        long r111 = this.e.getNextGpsScanInterval();     // Catch: Throwable -> L127
        if (r111 == 0) goto L61;
        long r112 = r111;
    L62:
        BDLocationConfig.setGpsScanInterval(r112);     // Catch: Throwable -> L127
        Logger.i("location-trace-core startLocation: cache nextGpsScanInterval = " + r111 + ", defaultGpsScanInterval = " + r32);     // Catch: Throwable -> L127
        goto L63
    L61:
        r112 = r32;
        goto L62
    L30:
        if (LocationInfoConst.LIBRA_PARAM_V2.equals(BDLocationConfig.getByteLocationLibraParam()) == false) goto L33;
        if (r17 == 0) goto L33;
        Logger.i("location-trace-core change locate type from " + r17 + " to LocationInfoConst.LOCATE_BYTE");     // Catch: Throwable -> L127
        r17 = 3;
        goto L33
    L76:
        if ("bpea-light_navigation".equals(this.a.getUploadSource()) == false) goto L79;
        Logger.i("detect light navigation continuous location, change locateType from " + r17 + " to 1");     // Catch: Throwable -> L127
        this.a.setLocateType(1);     // Catch: Throwable -> L127
        r17 = 1;
    L79:
        if (r17 != 7) goto L101;
        Logger.i("BYTE_FUSION_CONTINUOUS_CHAIN enter BDLocationService branch, locateType:" + r17);     // Catch: Throwable -> L127
        k r33 = this.h;     // Catch: Throwable -> L127
        if (r33.h != null) goto L84;
        r33.h = r33.b.a(r17);     // Catch: Throwable -> L127
        Logger.i("BYTE_FUSION_CONTINUOUS_CHAIN get locate object:" + this.h.h);     // Catch: Throwable -> L127
    L84:
        if (this.h.h == null) goto L99;
        LocationMonitor.locationTraceLogEnd(this.a.getLocationTraceLogger(), LocationMonitorConst.LOCATION_RULE_CHECK_DURATION);     // Catch: Throwable -> L127
        boolean r34 = LocationUtil.isNavigationByteContinuousLocation(this.a);     // Catch: Throwable -> L127
        boolean r35 = BDLocationConfig.isSensorContinuousCollectEnabled();     // Catch: Throwable -> L127
        if (r34 == false) goto L89;
        if (r35 == false) goto L89;
    L90:
        Logger.i("BDLocationService.sensorDecision: locateType=" + this.a.getLocateType() + ", isOnce=" + this.a.isOnceLocation() + ", uploadSource=" + this.a.getUploadSource() + ", sensorCollectionEnabled=" + r35 + ", shouldRegisterSensors=" + r14);     // Catch: Throwable -> L127
        k.b(this.h, this.a, r17);     // Catch: Throwable -> L127
        this.h.h.startLocation(this.c, this.a, k.p);     // Catch: Throwable -> L127
        if (r14 == true) goto L93;
        if (r34 == false) goto L98;
        Logger.i("BDLocationService.sensorDecision: skip registerContinuousSensors (sensor collection disabled)");     // Catch: Throwable -> L127
        goto L123
    L98:
        Logger.i("BDLocationService.sensorDecision: skip registerContinuousSensors (not navigation+byte-continuous scenario)");     // Catch: Throwable -> L127
        goto L123
    L93:
        if (this.h.h.isLocationRunningForBusiness(this.a.getBusinessId()) == false) goto L95;
        k.c(this.h, this.a);     // Catch: Throwable -> L127
        goto L123
    L95:
        this.h.x(this.a.getBusinessId());     // Catch: Throwable -> L127
        Logger.i("BDLocationService.sensorDecision: skip registerContinuousSensors because continuous location failed to start");     // Catch: Throwable -> L127
    L89:
        r14 = false;
        goto L90
    L99:
        Logger.i("mByteFusionContinuousLocation is null");     // Catch: Throwable -> L127
        BDLocationException r36 = new BDLocationException("未获取到定位内核异常", "2.17.6-rc.81", BDLocationException.ERROR_NO_LOCATE);     // Catch: Throwable -> L127
        k r37 = this.h;     // Catch: Throwable -> L127
        l0 r38 = this.c;     // Catch: Throwable -> L127
        r37.getClass();     // Catch: Throwable -> L127
        k.s(r38, r36);     // Catch: Throwable -> L127
        goto L123
    L101:
        if (BDLocationConfig.enableByteContinuousLocation() == false) goto L103;
        r17 = 6;
        this.a.setLocateType(6);     // Catch: Throwable -> L127
    L103:
        k r39 = this.h;     // Catch: Throwable -> L127
        if (r39.f != null) goto L107;
        r39.f = r39.b.a(r17);     // Catch: Throwable -> L127
    L107:
        if (this.h.f == null) goto L122;
        LocationMonitor.locationTraceLogEnd(this.a.getLocationTraceLogger(), LocationMonitorConst.LOCATION_RULE_CHECK_DURATION);     // Catch: Throwable -> L127
        boolean r40 = LocationUtil.isNavigationByteContinuousLocation(this.a);     // Catch: Throwable -> L127
        boolean r41 = BDLocationConfig.isSensorContinuousCollectEnabled();     // Catch: Throwable -> L127
        if (r40 == false) goto L112;
        if (r41 == false) goto L112;
    L113:
        Logger.i("BDLocationService.sensorDecision: locateType=" + this.a.getLocateType() + ", isOnce=" + this.a.isOnceLocation() + ", uploadSource=" + this.a.getUploadSource() + ", sensorCollectionEnabled=" + r41 + ", shouldRegisterSensors=" + r14);     // Catch: Throwable -> L127
        k.b(this.h, this.a, r17);     // Catch: Throwable -> L127
        this.h.f.startLocation(this.c, this.a, k.p);     // Catch: Throwable -> L127
        if (r14 == true) goto L116;
        if (r40 == false) goto L121;
        Logger.i("BDLocationService.sensorDecision: skip registerContinuousSensors (sensor collection disabled)");     // Catch: Throwable -> L127
        goto L123
    L121:
        Logger.i("BDLocationService.sensorDecision: skip registerContinuousSensors (not navigation+byte-continuous scenario)");     // Catch: Throwable -> L127
        goto L123
    L116:
        if (this.h.f.isLocationRunningForBusiness(this.a.getBusinessId()) == false) goto L118;
        k.c(this.h, this.a);     // Catch: Throwable -> L127
        goto L123
    L118:
        this.h.x(this.a.getBusinessId());     // Catch: Throwable -> L127
        Logger.i("BDLocationService.sensorDecision: skip registerContinuousSensors because continuous location failed to start");     // Catch: Throwable -> L127
    L112:
        r14 = false;
        goto L113
    L122:
        Logger.i("mContinuousLocation is null");     // Catch: Throwable -> L127
        BDLocationException r42 = new BDLocationException("未获取到定位内核异常", "2.17.6-rc.81", BDLocationException.ERROR_NO_LOCATE);     // Catch: Throwable -> L127
        k r43 = this.h;     // Catch: Throwable -> L127
        l0 r44 = this.c;     // Catch: Throwable -> L127
        r43.getClass();     // Catch: Throwable -> L127
        k.s(r44, r42);     // Catch: Throwable -> L127
    L127:
        th = move-exception;
        throw th;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public k$b(k r1, LocationOption r2, BDLocation r3, l0 r4, boolean r5, LocationCacheInfo r6, LocateReasonEntity r7, LocationOption r8) {
        this.h = r1;
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
    }
}
