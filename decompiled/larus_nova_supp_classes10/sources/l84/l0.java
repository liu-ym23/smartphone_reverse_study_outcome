package l84;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.bytedance.bdlocation.BDLocation;
import com.bytedance.bdlocation.LocationUtil;
import com.bytedance.bdlocation.callback.BDLocationCallback;
import com.bytedance.bdlocation.callback.LocationUploadCallback;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.bdlocation.client.LocationOption;
import com.bytedance.bdlocation.entity.CacheConditionEntity;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.bdlocation.exception.BDLocationExceptionMessage;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.monitor.LocationMonitor;
import com.bytedance.bdlocation.network.model.LocationUploadExtra;
import com.bytedance.bdlocation.network.model.WifiInfo;
import com.bytedance.bdlocation.network.response.LocInfoRspData;
import com.bytedance.bdlocation.network.response.LocationResp;
import com.bytedance.bdlocation.scan.networklistener.NetworkManager;
import com.bytedance.bdlocation.scan.wifi.WifiUtil;
import com.bytedance.bdlocation.store.BDLightLocationCache;
import com.bytedance.bdlocation.store.LocationCache;
import com.bytedance.bdlocation.thread.ThreadLooperManager;
import com.bytedance.bdlocation_impl.trace.LocationTraceManager;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.JsonArray;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class l0 implements BDLocationCallback, WifiUtil.WifiInfoJsonCallback {
    public final BDLocationCallback a;
    public final k.d b;
    public final LocationOption c;
    public Handler d;
    public final Handler e;
    public final LocationTraceManager.a f;
    public final long g;
    public final Object h;
    public volatile boolean i;
    public volatile boolean j;
    public volatile BDLocation k;
    public volatile JsonArray l;
    public volatile boolean m;
    public volatile boolean n;
    public WifiInfo o;

    public class a implements LocationUploadCallback {
        public final /* synthetic */ long a;
        public final /* synthetic */ BDLocation b;
        public final /* synthetic */ l0 c;

        @Override // com.bytedance.bdlocation.callback.LocationUploadCallback
        public final void onError(String r5) {
            Logger.i("LocationCallbackServer upload interval:" + (System.currentTimeMillis() - this.a));
            if (this.c.c.isOnceLocation() == false) goto L5;
            BDLocationConfig.setOpenStationaryScene(false);
            this.c.c(this.b);
            return;
        L5:
            this.c.b(this.b, false);
        }

        public a(l0 r1, long r2, BDLocation r4) {
            this.c = r1;
            this.a = r2;
            this.b = r4;
        }

        @Override // com.bytedance.bdlocation.callback.LocationUploadCallback
        public final void onSuccess(LocationResp r6, boolean r7, WifiInfo r8) {
            Logger.i("LocationCallbackServer upload intervalTime:" + (System.currentTimeMillis() - this.a));
            LocInfoRspData r9 = LocationUtil.parseLocInfoRsp(r6);
            if (r9 != null) goto L5;
            BDLocation r1 = null;
        L11:
            BDLocation r2 = this.b;
            if (r2 == null) goto L16;
            if (r9 == null) goto L15;
            r2.setSubmitLogId(r9.submitLogId);
        L15:
            this.b.setRecommendWifiResults(r7);
            this.b.setConnectedWifiInfo(r8);
        L16:
            k84.a.d(r9);
            if (r1 != null) goto L19;
            BDLocation r10 = this.b;
        L21:
            if (this.c.c.isOnceLocation() == false) goto L23;
            k84.a.c(r9, r10, this.c.c);
            this.c.c(r10);
        L24:
            k84.a.b(r9, r1, this.c.c);
            return;
        L23:
            this.c.b(r10, false);
            goto L24
        L19:
            r10 = r1;
            goto L21
        L5:
            if (r9.disablePollingUpload != 1) goto L7;
            Logger.i("disablePollingUpload == 1, disable polling upload.");
            BDLocationConfig.setPollingUpload(false);
            j84.a.a().g();
        L7:
            Logger.i("LocationCallbackServer inOutDoorStatus:" + r9.inOutDoorStatus);
            r1 = LocationUtil.locationResultToBDLocation(this.b, r9.location, r9.inOutDoorStatus, r9.inOutDoorConfidence);
            if (r1 == null) goto L11;
            r1.setSubmitLogId(r9.submitLogId);
            r1.setRecommendWifiResults(r7);
            r1.setConnectedWifiInfo(r8);
            goto L11
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ BDLocation a;
        public final /* synthetic */ l0 b;

        @Override // java.lang.Runnable
        public final void run() {
            Logger.i("callbackContinueLocationInfo onLocationChanged");     // Catch: Throwable -> L4
            this.b.a.onLocationChanged(this.a);     // Catch: Throwable -> L4
            this.b.g(this.a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(l0 r1, BDLocation r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    public final void e() {
        Logger.i("location-trace-core LocationCallbackServer decideDownGradeLocationType:" + this.c.getLocateType());
        this.c.setLocateType(0);
        this.c.setDownGradeLocation(true);
        String r0 = LocationUtil.allowUseLocation(true);
        if ("1".equals(r0) == true) goto L7;
        Logger.i("location-trace-core LocationCallbackServer decideDownGradeLocation error:" + r0);
        onError(new BDLocationException(BDLocationExceptionMessage.NON_ALLOWED_MESSAGE, LocationInfoConst.BDLOCATION, r0));
        return;
    L7:
        if (LocationUtil.isUseByteLocationPolicyV2(this.c.getUploadSource()) == true) goto L9;
        this.b.a();
        Logger.i("location-trace-core LocationCallbackServer decideDownGradeLocation");
        k.l().v(this.a, new LocationOption(this.c), null, null);
        return;
    L9:
        if (this.c.getSysLocation() == null) goto L11;
    L13:
        long r1 = 0;
    L14:
        Logger.i("location-trace-core LocationCallbackServer decideByteLocationDownGradeLocation delayedTime:" + r1);
        new Handler(ThreadLooperManager.getLocationWorker()).postDelayed(new f0(this), r1);
        return;
    L11:
        if (this.c.getGpsLocation() != null) goto L13;
        r1 = BDLocationConfig.getGpsScanInterval();
        goto L14
    }

    public final void a(BDLocation r5) {
        k.d r0 = this.b;
        monitor-enter(r0);
        if (r5 != null) goto L19;
    L11:
        boolean r2 = false;
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L9
        if (r2 == false) goto L15;
        final BDLocation r6 = LocationUtil.transformLocationForLevel(r5, this.c.getAccuracyLevel());
        this.e.post(new k0(r6));
        d(r6, false, false);
        Logger.i("location-trace-core callback at light location completion time.");
        return;
    L15:
        Logger.i("location-trace-core not callback at light location completion time.");
        return;
    L9:
        th = move-exception;
        throw th;
    L19:
        k.d r3 = this.b;     // Catch: Throwable -> L9
        LocationOption r4 = this.c;     // Catch: Throwable -> L9
        r3.c = r5;     // Catch: Throwable -> L9
        if (r4.alreadyCallback == true) goto L11;
        r2 = true;
        r4.alreadyCallback = true;     // Catch: Throwable -> L9
        goto L12
    }

    public final void c(BDLocation r5) {
        k.d r0 = this.b;
        monitor-enter(r0);
        LocationOption r1 = this.c;     // Catch: Throwable -> L17
        if (r1.alreadyCallback == true) goto L7;
    L10:
        this.c.alreadyCallback = true;     // Catch: Throwable -> L17
        boolean r2 = true;
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L17
        i(r5);
        h(r5, r2);
        BDLocation r6 = LocationUtil.transformLocationForLevel(r5, this.c.getAccuracyLevel());
        if (r2 == false) goto L15;
        d(r6, true, true);
        Logger.i("location-trace-core callback at full location completion time.");
        return;
    L15:
        Logger.i("location-trace-core not callback at full location completion time.");
        Logger.i("location-trace-core LocationCallbackServer callbackLocationInfo LocateTrace.onLocateStop");
        this.b.a();
        g(r6);
        return;
    L7:
        if (r1.isOnceLocation() == false) goto L10;
        r2 = false;
    L17:
        th = move-exception;
        throw th;
    }

    public final void f(BDLocationException r5) {
        if (r5 == null) goto L5;
        Logger.i("doMonitorLocationFail: errCode:" + r5.getCode() + "--DetailMessage:" + r5.getDetailMessage());
    L5:
        if (this.c.isOnceLocation() == false) goto L7;
        LocationMonitor.locationTraceLogErrorReport(this.c, r5);
        LocationMonitor.doDesiredLocationFail(SystemClock.elapsedRealtime() - this.g, r5, this.c);
        Logger.i("locationmonitor location total duration is: " + (SystemClock.elapsedRealtime() - this.g) + "ms");
        return;
    L7:
        LocationTraceManager r0 = LocationTraceManager.b.a;
        LocationTraceManager.a r1 = this.f;
        monitor-enter(r0);
    L14:
        th = move-exception;
        throw th;
    L10:
        if (r0.g(r1) == false) goto L12;
        r0.j(r1, r5);     // Catch: Throwable -> L14
    L12:
        monitor-exit(r0);
    }

    public final void g(BDLocation r5) {
        if (this.c.isOnceLocation() == false) goto L5;
        LocationMonitor.locationTraceLogEnd(this.c.getLocationTraceLogger(), "total_duration");
        LocationMonitor.locationTraceLogSuccessReport(r5, this.c);
        LocationMonitor.doDesiredLocationSuccess(SystemClock.elapsedRealtime() - this.g, r5, this.c);
        Logger.i("locationmonitor location total duration is: " + (SystemClock.elapsedRealtime() - this.g) + "ms");
        return;
    L5:
        LocationTraceManager.b.a.m(this.f, r5);
    }

    public final synchronized void i(BDLocation r8) {
        monitor-enter(this);
    L24:
        th = move-exception;
        throw th;
    L5:
        if (j84.a.a().c() == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        if (r8 != null) goto L10;
    L22:
        monitor-exit(this);
        return;
    L10:
        if (BDLocationConfig.isUpload() == false) goto L22;
        if (BDLocationConfig.isPollingUpload() == false) goto L22;
        if (LocationUtil.checkBackground() == true) goto L22;
        Logger.i("register UploadScheduleController isCache：" + r8.isCache());     // Catch: Throwable -> L24
        NetworkManager.getInstance().registerObserver(BDLocationConfig.getContext());     // Catch: Throwable -> L24
        long r1 = BDLocationConfig.getUploadInterval();     // Catch: Throwable -> L24
        if (r8.isCache() == false) goto L21;
        r1 = BDLocationConfig.getUploadInterval() - (System.currentTimeMillis() - r8.getLocationMs());     // Catch: Throwable -> L24
        if (r1 > 0) goto L20;
        r1 = 5000;
    L20:
        Logger.d("register UploadScheduleController interval:" + r1 + "--cacheTime:" + r8.getLocationMs());     // Catch: Throwable -> L24
    L21:
        j84.a.a().d(r1);     // Catch: Throwable -> L24
        goto L22
    }

    public final void j(BDLocation r11) {
        long r0 = System.currentTimeMillis();
        if (this.c.isOnceLocation() == false) goto L5;
    L7:
        LocationOption r2 = this.c;
        a r3 = new a(this, r0, r11);
        LocationUploadExtra r4 = new LocationUploadExtra();
        if (r2 != null) goto L10;
    L12:
        LocationOption r5 = r2;
    L13:
        r4.locationOption = r5;
        r4.setLocationEventClockMs(r0);
        r4.setUploadInterval(r2.getUploadInterval());
        r4.setLocateId(r2.getLocateId());
        if (BDLocationConfig.isMockEnable() == false) goto L16;
        r4.setUploadSource("mock");
    L17:
        r4.setTriggerType(r2.getTriggerType());
        r4.setLatestAdminVersion(r2.isLatestAdminVersion());
        r4.setBpeaCert(r2.getBpeaCert());
        r4.setStartLocationTime(r2.getStartLocationTime());
        if (r2.getLocationExtraBean() == null) goto L20;
        r4.setLogIdCache(r2.getLocationExtraBean().getLogIdCacheEntity());
        r4.setBleList(r2.getLocationExtraBean().getBleInfoList());
    L20:
        r4.setExtra(r2.getExtra());
        r4.setWifiDate(this.l);
        r4.setRecommendWifiResults(this.n);
        r4.setWifiCache(this.m);
        r4.setOnceLocation(r2.isOnceLocation());
        r4.setLocationTraceLogger(r2.getLocationTraceLogger());
        r4.setLocationExtraDataServer(r2.getLocationExtraDataServer());
        r4.setConnectedWifiInfo(this.o);
        r4.setStationarySceneCacheInfo(r2.getStationarySceneCacheInfo());
        long r6 = r2.getLastSensorBatchEndTimestampMs();
        if (r6 > 0) goto L23;
        r6 = r2.startLocationTimestampInMillis;
    L23:
        r4.setSensorWindowStartMs(r6);
        r2.setLastSensorBatchEndTimestampMs(r0);
        LocationUtil.startLocateUpload(r11, r4, r3);
        return;
    L16:
        r4.setUploadSource(r2.getUploadSource());
        goto L17
    L10:
        if (r2.getLocateType() != 7) goto L12;
        r5 = new LocationOption(r2);
        goto L13
    L5:
        if (this.c.isSynchronizeUpload() == true) goto L7;
        b(r11, true);
        goto L7
    }

    @Override // com.bytedance.bdlocation.callback.BDLocationCallback
    public final void onError(final BDLocationException r9) {
        Logger.i("LocationCallbackServer onError");
        int r0 = 0;
        BDLocationConfig.setOpenStationaryScene(false);
        if (this.c.isOnceLocation() == true) goto L5;
    L10:
        boolean r2 = true;
        ArrayList r3 = null;
        if (this.c.isChineseRegion() == false) goto L13;
    L31:
        k.d r1 = this.b;
        monitor-enter(r1);
    L74:
        th = move-exception;
        throw th;
    L34:
        if (LocationUtil.isUseByteLocationPolicy(this.c.getUploadSource()) == true) goto L36;
    L40:
        this.c.alreadyCallback = true;     // Catch: Throwable -> L74
        r2 = false;
    L41:
        monitor-exit(r1);     // Catch: Throwable -> L74
        if (r2 == false) goto L46;
        Logger.i("location-trace-core full location failed, try use light location callback.");
        c(this.c.getLightLocation());
        return;
    L46:
        if (this.d != null) goto L49;
        this.d = new Handler(Looper.getMainLooper());
    L49:
        if (BDLocationConfig.isUseCacheCondition() == false) goto L51;
        CacheConditionEntity r4 = new CacheConditionEntity();
        r4.setConditionCode(0);
        LocationCache.getInstance().executeWithoutLocationCache(System.currentTimeMillis(), r4, false);
    L51:
        k.d r5 = this.b;
        monitor-enter(r5);
    L56:
        th = move-exception;
        throw th;
    L54:
        if (this.c.isCallbackThroughLocateTrace == false) goto L58;
        Logger.i("location-trace-core LocationCallbackServer mergeLocation onError");     // Catch: Throwable -> L56
        k.d r6 = this.b;     // Catch: Throwable -> L56
        r6.getClass();     // Catch: Throwable -> L56
        r3 = new ArrayList(r6.d);     // Catch: Throwable -> L56
        ((ArrayList) r6.d).clear();     // Catch: Throwable -> L56
    L58:
        this.b.a();     // Catch: Throwable -> L56
        monitor-exit(r5);     // Catch: Throwable -> L56
        if (r3 != null) goto L62;
    L70:
        this.d.post(new j0(this, r9));
        f(r9);
        return;
    L62:
        if (r3.isEmpty() == true) goto L70;
    L64:
        if (r0 >= r3.size()) goto L69;
        final BDLocationCallback r7 = (BDLocationCallback) ListProtector.get(r3, r0);
        if (r7 == null) goto L68;
        this.d.post(new i0(r7, r9));
    L68:
        r0 = r0 + 1;
        goto L64
    L69:
        f(r9);
        return;
    L36:
        if (this.c.isOnceLocation() == false) goto L40;
        if (this.c.getLightLocation() == null) goto L40;
    L13:
        if (this.c.getLocateType() != 0) goto L31;
        Logger.i("overseas getLocation error and use cache");
        BDLocation r8 = k.l().p(this.c, null);
        k r10 = k.l();
        LocationOption r11 = this.c;
        r10.getClass();
        if (r8 != null) goto L18;
        Logger.i("LocationCache IS NULL");
    L25:
        boolean r12 = false;
    L27:
        LocationMonitor.overseasLocationFailedGetCache(r12);
        if (r12 == false) goto L31;
        c(r8);
        return;
    L18:
        if (r11.getGeocodeMode() == 0) goto L23;
        if (r8.hasAddress() == true) goto L23;
        Logger.i("LocationCache NO_GEOCODE");
    L23:
        if (LocationUtil.checkCacheTime(r8.getLocationMs(), BDLocationConfig.getOverseasGetLocationFailedUseCacheValidity()) == true) goto L26;
        Logger.i("LocationCache checkCacheTime is false");
        goto L25
    L26:
        r12 = true;
        goto L27
    L5:
        if (this.c.getLocateType() == 0) goto L10;
        if (this.c.isDownGradeLocation() == true) goto L10;
        e();
    }

    @Override // com.bytedance.bdlocation.scan.wifi.WifiUtil.WifiInfoJsonCallback
    public final void onFailed(BDLocationException r2) {
        Object r3 = this.h;
        monitor-enter(r3);
        this.i = true;     // Catch: Throwable -> L10
        if (this.j == false) goto L8;
        Logger.i("upLoadLocation from scan Wifi onFailed");     // Catch: Throwable -> L10
        j(this.k);     // Catch: Throwable -> L10
    L8:
        monitor-exit(r3);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.bdlocation.callback.BDLocationCallback
    public final void onLocationChanged(BDLocation r22) {
        ArrayList r10 = new ArrayList();
        Object[] r12 = {r22};
        f06.b r14 = new f06.b();
        g06.a r1 = (g06.a) ApiHookConfig.b.get(101330);
        if (r1 == null) goto L5;
        f06.a[] r2 = r1.i;
    L6:
        f06.a[] r8 = r2;
        int r7 = r8.length;
        int r6 = 0;
    L8:
        if (r6 >= r7) goto L15;
        f06.a r4 = r8[r6];
        int r18 = r6;
        int r19 = r7;
        f06.a[] r20 = r8;
        f06.d r3 = r4.preInvoke(101330, "com/bytedance/bdlocation_impl/service/LocationCallBackServer", "onLocationChanged", this, r12, "void", r14);     // Catch: Exception -> L96
        if (r3.a == true) goto L12;
        r10.add(r4);     // Catch: Exception -> L96
        goto L14
    L12:
        LocInfoRspData r5 = null;
    L17:
        if (r3.a == false) goto L20;
        return;
    L20:
        if (this.c.isHitStationaryScene() == false) goto L28;
        LocationUploadExtra r9 = new LocationUploadExtra();
        r9.setUploadInterval(this.c.getUploadInterval());
        r9.setLocateId(this.c.getLocateId());
        if (BDLocationConfig.isMockEnable() == false) goto L24;
        r9.setUploadSource("mock");
    L25:
        r9.setTriggerType(this.c.getTriggerType());
        r9.setBpeaCert(this.c.getBpeaCert());
        r9.setStartLocationTime(this.c.getStartLocationTime());
        r9.setExtra(this.c.getExtra());
        r9.setOnceLocation(this.c.isOnceLocation());
        r9.setLocationTraceLogger(this.c.getLocationTraceLogger());
        r9.setStartLocationTimestampInMillis(this.c.startLocationTimestampInMillis);
        LocationUtil.startCacheLocateInfoUpload(r9, new m0(this, System.currentTimeMillis(), r22));
        return;
    L24:
        r9.setUploadSource(this.c.getUploadSource());
        goto L25
    L28:
        if (this.c.isOnceLocation() == true) goto L31;
        BDLocationConfig.setOpenStationaryScene(false);
    L31:
        if (LocationUtil.isEmpty(r22) == true) goto L33;
        boolean r11 = r22.isCache();
        if (BDLocationConfig.isFirstLocation() == false) goto L47;
        LocationMonitor.doFirstLocationDuration(SystemClock.elapsedRealtime() - BDLocationConfig.getInitStartTime(), r11);
        Logger.i("locationmonitor first location duration is: " + (SystemClock.elapsedRealtime() - BDLocationConfig.getInitStartTime()) + "ms");
        BDLocationConfig.setFirstLocation(false);
    L47:
        if (r22.isCache() == false) goto L50;
        c(r22);
        return;
    L50:
        BDLocation r0 = LocationUtil.convertLocation(r22);
        if (this.c.isUpload() == true) goto L53;
    L62:
        boolean r13 = false;
    L63:
        if (r13 == true) goto L65;
        LocInfoRspData r15 = r0.getLocInfoRsp();
        if (r15 != null) goto L83;
    L85:
        k84.a.d(r15);
        if (r15 == null) goto L88;
        LocInfoRspData r16 = new LocInfoRspData(r15);
    L89:
        if (r16 == null) goto L92;
        r0.setSubmitLogId(r16.submitLogId);
    L92:
        if (this.c.isOnceLocation() == false) goto L94;
        k84.a.c(r16, r0, this.c);
    L94:
        c(r0);
        k84.a.b(r16, r0, this.c);
        r0.setLocInfoRsp(r5);
        return;
    L88:
        r16 = r5;
        goto L89
    L83:
        if (r15.disablePollingUpload != 1) goto L85;
        Logger.i("disablePollingUpload == 1, disable polling upload.");
        BDLocationConfig.setPollingUpload(false);
        j84.a.a().g();
        goto L85
    L65:
        if (this.c.isOnceLocation() == true) goto L67;
    L79:
        j(r0);
        return;
    L67:
        if (BDLocationConfig.isAsyncScanWifi() == false) goto L79;
        Object r17 = this.h;
        monitor-enter(r17);
    L76:
        th = move-exception;
        throw th;
    L71:
        if (this.i == false) goto L73;
        Logger.i("upLoadLocation from onLocationChanged");     // Catch: Throwable -> L76
        j(r0);     // Catch: Throwable -> L76
    L73:
        this.k = r0;     // Catch: Throwable -> L76
        this.j = true;     // Catch: Throwable -> L76
        monitor-exit(r17);     // Catch: Throwable -> L76
        return;
    L53:
        if (LocationUtil.needUpload(r0) == false) goto L62;
        if (this.c.getLocateType() != 7) goto L61;
        if (r0 == null) goto L62;
        if (r0.validLatlng() == false) goto L62;
    L61:
        r13 = true;
        goto L63
    L33:
        if (this.c.isOnceLocation() == true) goto L35;
    L40:
        onError(new BDLocationException("location callback null!", "UNKnown", BDLocationException.ERROR_LOCATION_IS_NULL));
        return;
    L35:
        if (this.c.getLocateType() == 0) goto L40;
        if (this.c.isDownGradeLocation() == true) goto L40;
        e();
        return;
    L14:
        r6 = r18 + 1;
        r7 = r19;
        r8 = r20;
        goto L8
    L15:
        r5 = null;
        r3 = new f06.d(false, null);
        goto L17
    L5:
        r2 = ApiHookConfig.d;
        goto L6
    }

    public static void h(BDLocation r5, boolean r6) {
        CacheConditionEntity r0 = new CacheConditionEntity();
        if (r5 != null) goto L7;
        r0.setConditionCode(1);
        LocationCache.getInstance().executeWithoutLocationCache(System.currentTimeMillis(), r0, false);
        return;
    L7:
        if (r5.getLocationType() != 6) goto L11;
        Logger.i("IP location");
        r0.setConditionCode(2);
        LocationCache.getInstance().executeWithoutLocationCache(r5.getLocationMs(), r0, !r5.isCache());
        return;
    L11:
        if (r5.isMock() == false) goto L14;
        Logger.i("mock location");
        r0.setConditionCode(3);
        LocationCache.getInstance().executeWithoutLocationCache(r5.getLocationMs(), r0, !r5.isCache());
        return;
    L14:
        Logger.i("CheckNewLocation new location time:" + r5.getLocationMs());
        BDLocation r2 = LocationCache.getInstance().getLocationCache().getLatestLocation();
        Logger.i("LocationCallbackServer executeLocationCache isUseNewCacheStrategy: " + BDLocationConfig.isUseNewCacheStrategy());
        if (BDLocationConfig.isUseCacheCondition() == false) goto L30;
        if (r5.isCache() == false) goto L19;
        return;
    L19:
        if (BDLocationConfig.isRestrictedModeOn() == false) goto L22;
        r0.setConditionCode(4);
        LocationCache.getInstance().executeWithoutLocationCache(r5.getLocationMs(), r0, !r5.isCache());
        return;
    L22:
        if (LocationUtil.isBetterLocation(r5, r2, r0) == false) goto L24;
    L25:
        Logger.i("UseCacheCondition checkNewLocation executeLocationCache");
        long r3 = r5.getLocationMs();
        if (BDLightLocationCache.lightLocationNeedCheckCache() == false) goto L28;
        BDLightLocationCache.setLastLocationTime(BDLocationConfig.getContext(), r3);
    L28:
        LocationCache.getInstance().executeLocationCache(r5, r0, true ^ r5.isCache(), r6);
        return;
    L24:
        if (LocationUtil.isGoodLocation(r5, r0) == true) goto L25;
        return;
    L30:
        if (LocationUtil.isBetterLocation(r5, r2) == true) goto L34;
        if (LocationUtil.isGoodLocation(r5) == true) goto L34;
        return;
    L34:
        if (BDLocationConfig.isRestrictedModeOn() == true) goto L45;
        Logger.i("CheckNewLocation executeLocationCache");
        long r4 = r5.getLocationMs();
        if (BDLightLocationCache.lightLocationNeedCheckCache() == false) goto L38;
        BDLightLocationCache.setLastLocationTime(BDLocationConfig.getContext(), r4);
    L38:
        LocationCache.getInstance().executeLocationCache(r5, true ^ r5.isCache(), r6);
        return;
    }

    public final void b(BDLocation r3, boolean r4) {
        Logger.i("callbackContinueLocationInfo isSynchronizeUpload:" + this.c.isSynchronizeUpload() + "--needCallback:" + r4);
        if (this.c.isSynchronizeUpload() == true) goto L5;
        if (r4 == false) goto L5;
    L7:
        if (this.c.isSynchronizeUpload() == true) goto L9;
        if (r4 == true) goto L9;
        return;
    L9:
        BDLocation r5 = LocationUtil.transformLocationForLevel(r3, this.c.getAccuracyLevel());
        if (this.d != null) goto L12;
        this.d = new Handler(Looper.getMainLooper());
    L12:
        this.d.post(new b(this, r5));
        return;
    L5:
        i(r3);
        h(r3, true);
        goto L7
    }

    public final void d(final BDLocation r5, boolean r6, boolean r7) {
        if (this.d != null) goto L5;
        this.d = new Handler(Looper.getMainLooper());
    L5:
        k.d r0 = this.b;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L8:
        if (this.c.isCallbackThroughLocateTrace == false) goto L12;
        Logger.i("LocationCallbackServer callbackLocationInfoInner callback merge location.");     // Catch: Throwable -> L10
        k.d r1 = this.b;     // Catch: Throwable -> L10
        r1.getClass();     // Catch: Throwable -> L10
        ArrayList r2 = new ArrayList(r1.d);     // Catch: Throwable -> L10
        ((ArrayList) r1.d).clear();     // Catch: Throwable -> L10
    L13:
        if (r6 == false) goto L15;
        this.b.a();     // Catch: Throwable -> L10
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L10
        if (r2 != null) goto L18;
    L28:
        this.d.post(new h0(this, r5));
        if (r7 == false) goto L41;
        g(r5);
        return;
    L41:
        return;
    L18:
        if (r2.isEmpty() == true) goto L28;
        int r8 = 0;
    L21:
        if (r8 >= r2.size()) goto L26;
        final BDLocationCallback r3 = (BDLocationCallback) ListProtector.get(r2, r8);
        if (r3 == null) goto L25;
        this.d.post(new g0(r3, r5));
    L25:
        r8 = r8 + 1;
        goto L21
    L26:
        if (r7 == false) goto L39;
        g(r5);
        return;
    L39:
        return;
    L12:
        r2 = null;
        goto L13
    }

    @Override // com.bytedance.bdlocation.scan.wifi.WifiUtil.WifiInfoJsonCallback
    public final void onWifiInfoJson(JsonArray r1, boolean r2, boolean r3, WifiInfo r4) {
        this.o = r4;
        this.l = r1;
        this.m = r2;
        this.n = r3;
        Object r5 = this.h;
        monitor-enter(r5);
        this.i = true;     // Catch: Throwable -> L10
        if (this.j == false) goto L8;
        Logger.i("upLoadLocation from onWifiInfoJson");     // Catch: Throwable -> L10
        j(this.k);     // Catch: Throwable -> L10
    L8:
        monitor-exit(r5);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public l0(BDLocationCallback r2, LocationOption r3, k.d r4, Handler r5, Handler r6, LocationTraceManager.a r7) {
        this.h = new Object();
        this.m = true;
        this.n = true;
        this.a = r2;
        this.b = r4;
        this.c = r3;
        this.d = r5;
        this.f = r7;
        this.g = SystemClock.elapsedRealtime();
        if (r6 == null) goto L5;
        this.e = r6;
        return;
    L5:
        this.e = new Handler(ThreadLooperManager.getLocationWorker());
    }
}
