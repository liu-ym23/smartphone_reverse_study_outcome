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
import com.bytedance.ee.bear.unbundle.BenefitStore;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.JsonArray;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes10.dex */
public final class l0 implements BDLocationCallback, WifiUtil.WifiInfoJsonCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BDLocationCallback f508005a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final k.d f508006b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LocationOption f508007c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Handler f508008d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Handler f508009e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final LocationTraceManager.a f508010f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f508011g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Object f508012h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public volatile boolean f508013i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public volatile boolean f508014j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public volatile BDLocation f508015k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public volatile JsonArray f508016l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public volatile boolean f508017m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public volatile boolean f508018n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public WifiInfo f508019o;

    public class a implements LocationUploadCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f508020a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ BDLocation f508021b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ l0 f508022c;

        @Override // com.bytedance.bdlocation.callback.LocationUploadCallback
        public final void onError(String r100) {
            Logger.i("LocationCallbackServer upload interval:" + (System.currentTimeMillis() - this.f508020a));
            if (this.f508022c.f508007c.isOnceLocation() == false) goto L5;
            BDLocationConfig.setOpenStationaryScene(false);
            this.f508022c.c(this.f508021b);
            return;
        L5:
            this.f508022c.b(this.f508021b, false);
        }

        public a(l0 r100, long r101, BDLocation r102) {
            this.f508022c = r100;
            this.f508020a = r101;
            this.f508021b = r102;
        }

        @Override // com.bytedance.bdlocation.callback.LocationUploadCallback
        public final void onSuccess(LocationResp r100, boolean r101, WifiInfo r102) {
            Logger.i("LocationCallbackServer upload intervalTime:" + (System.currentTimeMillis() - this.f508020a));
            LocInfoRspData r103 = LocationUtil.parseLocInfoRsp(r100);
            if (r103 != null) goto L5;
            BDLocation r104 = null;
        L11:
            BDLocation r105 = this.f508021b;
            if (r105 == null) goto L16;
            if (r103 == null) goto L15;
            r105.setSubmitLogId(r103.submitLogId);
        L15:
            this.f508021b.setRecommendWifiResults(r101);
            this.f508021b.setConnectedWifiInfo(r102);
        L16:
            k84.a.d(r103);
            if (r104 != null) goto L19;
            BDLocation r106 = this.f508021b;
        L21:
            if (this.f508022c.f508007c.isOnceLocation() == false) goto L23;
            k84.a.c(r103, r106, this.f508022c.f508007c);
            this.f508022c.c(r106);
        L24:
            k84.a.b(r103, r104, this.f508022c.f508007c);
            return;
        L23:
            this.f508022c.b(r106, false);
            goto L24
        L19:
            r106 = r104;
            goto L21
        L5:
            if (r103.disablePollingUpload != 1) goto L7;
            Logger.i("disablePollingUpload == 1, disable polling upload.");
            BDLocationConfig.setPollingUpload(false);
            j84.a.a().g();
        L7:
            Logger.i("LocationCallbackServer inOutDoorStatus:" + r103.inOutDoorStatus);
            r104 = LocationUtil.locationResultToBDLocation(this.f508021b, r103.location, r103.inOutDoorStatus, r103.inOutDoorConfidence);
            if (r104 == null) goto L11;
            r104.setSubmitLogId(r103.submitLogId);
            r104.setRecommendWifiResults(r101);
            r104.setConnectedWifiInfo(r102);
            goto L11
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BDLocation f508023a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ l0 f508024b;

        @Override // java.lang.Runnable
        public final void run() {
            Logger.i("callbackContinueLocationInfo onLocationChanged");     // Catch: Throwable -> L4
            this.f508024b.f508005a.onLocationChanged(this.f508023a);     // Catch: Throwable -> L4
            this.f508024b.g(this.f508023a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(l0 r100, BDLocation r101) {
            this.f508024b = r100;
            this.f508023a = r101;
        }
    }

    public final void e() {
        Logger.i("location-trace-core LocationCallbackServer decideDownGradeLocationType:" + this.f508007c.getLocateType());
        this.f508007c.setLocateType(0);
        this.f508007c.setDownGradeLocation(true);
        String r100 = LocationUtil.allowUseLocation(true);
        if ("1".equals(r100) == true) goto L7;
        Logger.i("location-trace-core LocationCallbackServer decideDownGradeLocation error:" + r100);
        onError(new BDLocationException(BDLocationExceptionMessage.NON_ALLOWED_MESSAGE, LocationInfoConst.BDLOCATION, r100));
        return;
    L7:
        if (LocationUtil.isUseByteLocationPolicyV2(this.f508007c.getUploadSource()) == true) goto L9;
        this.f508006b.a();
        Logger.i("location-trace-core LocationCallbackServer decideDownGradeLocation");
        k.l().v(this.f508005a, new LocationOption(this.f508007c), null, null);
        return;
    L9:
        if (this.f508007c.getSysLocation() == null) goto L11;
    L13:
        long r101 = 0;
    L14:
        Logger.i("location-trace-core LocationCallbackServer decideByteLocationDownGradeLocation delayedTime:" + r101);
        new Handler(ThreadLooperManager.getLocationWorker()).postDelayed(new f0(this), r101);
        return;
    L11:
        if (this.f508007c.getGpsLocation() != null) goto L13;
        r101 = BDLocationConfig.getGpsScanInterval();
        goto L14
    }

    public final void a(BDLocation r100) {
        k.d r101 = this.f508006b;
        monitor-enter(r101);
        if (r100 != null) goto L19;
    L11:
        boolean r102 = false;
    L12:
        monitor-exit(r101);     // Catch: Throwable -> L9
        if (r102 == false) goto L15;
        final BDLocation r103 = LocationUtil.transformLocationForLevel(r100, this.f508007c.getAccuracyLevel());
        this.f508009e.post(new k0(r103));
        d(r103, false, false);
        Logger.i("location-trace-core callback at light location completion time.");
        return;
    L15:
        Logger.i("location-trace-core not callback at light location completion time.");
        return;
    L9:
        th = move-exception;
        throw th;
    L19:
        k.d r104 = this.f508006b;     // Catch: Throwable -> L9
        LocationOption r105 = this.f508007c;     // Catch: Throwable -> L9
        r104.f508000c = r100;     // Catch: Throwable -> L9
        if (r105.alreadyCallback == true) goto L11;
        r102 = true;
        r105.alreadyCallback = true;     // Catch: Throwable -> L9
        goto L12
    }

    public final void c(BDLocation r100) {
        k.d r101 = this.f508006b;
        monitor-enter(r101);
        LocationOption r102 = this.f508007c;     // Catch: Throwable -> L17
        if (r102.alreadyCallback == true) goto L7;
    L10:
        this.f508007c.alreadyCallback = true;     // Catch: Throwable -> L17
        boolean r103 = true;
    L11:
        monitor-exit(r101);     // Catch: Throwable -> L17
        i(r100);
        h(r100, r103);
        BDLocation r104 = LocationUtil.transformLocationForLevel(r100, this.f508007c.getAccuracyLevel());
        if (r103 == false) goto L15;
        d(r104, true, true);
        Logger.i("location-trace-core callback at full location completion time.");
        return;
    L15:
        Logger.i("location-trace-core not callback at full location completion time.");
        Logger.i("location-trace-core LocationCallbackServer callbackLocationInfo LocateTrace.onLocateStop");
        this.f508006b.a();
        g(r104);
        return;
    L7:
        if (r102.isOnceLocation() == false) goto L10;
        r103 = false;
    L17:
        th = move-exception;
        throw th;
    }

    public final void f(BDLocationException r100) {
        if (r100 == null) goto L5;
        Logger.i("doMonitorLocationFail: errCode:" + r100.getCode() + "--DetailMessage:" + r100.getDetailMessage());
    L5:
        if (this.f508007c.isOnceLocation() == false) goto L7;
        LocationMonitor.locationTraceLogErrorReport(this.f508007c, r100);
        LocationMonitor.doDesiredLocationFail(SystemClock.elapsedRealtime() - this.f508011g, r100, this.f508007c);
        Logger.i("locationmonitor location total duration is: " + (SystemClock.elapsedRealtime() - this.f508011g) + "ms");
        return;
    L7:
        LocationTraceManager r101 = LocationTraceManager.b.f199957a;
        LocationTraceManager.a r102 = this.f508010f;
        monitor-enter(r101);
    L14:
        th = move-exception;
        throw th;
    L10:
        if (r101.g(r102) == false) goto L12;
        r101.j(r102, r100);     // Catch: Throwable -> L14
    L12:
        monitor-exit(r101);
    }

    public final void g(BDLocation r100) {
        if (this.f508007c.isOnceLocation() == false) goto L5;
        LocationMonitor.locationTraceLogEnd(this.f508007c.getLocationTraceLogger(), "total_duration");
        LocationMonitor.locationTraceLogSuccessReport(r100, this.f508007c);
        LocationMonitor.doDesiredLocationSuccess(SystemClock.elapsedRealtime() - this.f508011g, r100, this.f508007c);
        Logger.i("locationmonitor location total duration is: " + (SystemClock.elapsedRealtime() - this.f508011g) + "ms");
        return;
    L5:
        LocationTraceManager.b.f199957a.m(this.f508010f, r100);
    }

    public final synchronized void i(BDLocation r100) {
        monitor-enter(this);
    L24:
        th = move-exception;
        throw th;
    L5:
        if (j84.a.a().c() == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        if (r100 != null) goto L10;
    L22:
        monitor-exit(this);
        return;
    L10:
        if (BDLocationConfig.isUpload() == false) goto L22;
        if (BDLocationConfig.isPollingUpload() == false) goto L22;
        if (LocationUtil.checkBackground() == true) goto L22;
        Logger.i("register UploadScheduleController isCache：" + r100.isCache());     // Catch: Throwable -> L24
        NetworkManager.getInstance().registerObserver(BDLocationConfig.getContext());     // Catch: Throwable -> L24
        long r101 = BDLocationConfig.getUploadInterval();     // Catch: Throwable -> L24
        if (r100.isCache() == false) goto L21;
        r101 = BDLocationConfig.getUploadInterval() - (System.currentTimeMillis() - r100.getLocationMs());     // Catch: Throwable -> L24
        if (r101 > 0) goto L20;
        r101 = 5000;
    L20:
        Logger.d("register UploadScheduleController interval:" + r101 + "--cacheTime:" + r100.getLocationMs());     // Catch: Throwable -> L24
    L21:
        j84.a.a().d(r101);     // Catch: Throwable -> L24
        goto L22
    }

    public final void j(BDLocation r110) {
        long r100 = System.currentTimeMillis();
        if (this.f508007c.isOnceLocation() == false) goto L5;
    L7:
        LocationOption r101 = this.f508007c;
        a r102 = new a(this, r100, r110);
        LocationUploadExtra r103 = new LocationUploadExtra();
        if (r101 != null) goto L10;
    L12:
        LocationOption r104 = r101;
    L13:
        r103.locationOption = r104;
        r103.setLocationEventClockMs(r100);
        r103.setUploadInterval(r101.getUploadInterval());
        r103.setLocateId(r101.getLocateId());
        if (BDLocationConfig.isMockEnable() == false) goto L16;
        r103.setUploadSource(BenefitStore.FROM_MOCK);
    L17:
        r103.setTriggerType(r101.getTriggerType());
        r103.setLatestAdminVersion(r101.isLatestAdminVersion());
        r103.setBpeaCert(r101.getBpeaCert());
        r103.setStartLocationTime(r101.getStartLocationTime());
        if (r101.getLocationExtraBean() == null) goto L20;
        r103.setLogIdCache(r101.getLocationExtraBean().getLogIdCacheEntity());
        r103.setBleList(r101.getLocationExtraBean().getBleInfoList());
    L20:
        r103.setExtra(r101.getExtra());
        r103.setWifiDate(this.f508016l);
        r103.setRecommendWifiResults(this.f508018n);
        r103.setWifiCache(this.f508017m);
        r103.setOnceLocation(r101.isOnceLocation());
        r103.setLocationTraceLogger(r101.getLocationTraceLogger());
        r103.setLocationExtraDataServer(r101.getLocationExtraDataServer());
        r103.setConnectedWifiInfo(this.f508019o);
        r103.setStationarySceneCacheInfo(r101.getStationarySceneCacheInfo());
        long r105 = r101.getLastSensorBatchEndTimestampMs();
        if (r105 > 0) goto L23;
        r105 = r101.startLocationTimestampInMillis;
    L23:
        r103.setSensorWindowStartMs(r105);
        r101.setLastSensorBatchEndTimestampMs(r100);
        LocationUtil.startLocateUpload(r110, r103, r102);
        return;
    L16:
        r103.setUploadSource(r101.getUploadSource());
        goto L17
    L10:
        if (r101.getLocateType() != 7) goto L12;
        r104 = new LocationOption(r101);
        goto L13
    L5:
        if (this.f508007c.isSynchronizeUpload() == true) goto L7;
        b(r110, true);
        goto L7
    }

    @Override // com.bytedance.bdlocation.callback.BDLocationCallback
    public final void onError(final BDLocationException r100) {
        Logger.i("LocationCallbackServer onError");
        int r101 = 0;
        BDLocationConfig.setOpenStationaryScene(false);
        if (this.f508007c.isOnceLocation() == true) goto L5;
    L10:
        boolean r102 = true;
        ArrayList r103 = null;
        if (this.f508007c.isChineseRegion() == false) goto L13;
    L31:
        k.d r104 = this.f508006b;
        monitor-enter(r104);
    L74:
        th = move-exception;
        throw th;
    L34:
        if (LocationUtil.isUseByteLocationPolicy(this.f508007c.getUploadSource()) == true) goto L36;
    L40:
        this.f508007c.alreadyCallback = true;     // Catch: Throwable -> L74
        r102 = false;
    L41:
        monitor-exit(r104);     // Catch: Throwable -> L74
        if (r102 == false) goto L46;
        Logger.i("location-trace-core full location failed, try use light location callback.");
        c(this.f508007c.getLightLocation());
        return;
    L46:
        if (this.f508008d != null) goto L49;
        this.f508008d = new Handler(Looper.getMainLooper());
    L49:
        if (BDLocationConfig.isUseCacheCondition() == false) goto L51;
        CacheConditionEntity r105 = new CacheConditionEntity();
        r105.setConditionCode(0);
        LocationCache.getInstance().executeWithoutLocationCache(System.currentTimeMillis(), r105, false);
    L51:
        k.d r106 = this.f508006b;
        monitor-enter(r106);
    L56:
        th = move-exception;
        throw th;
    L54:
        if (this.f508007c.isCallbackThroughLocateTrace == false) goto L58;
        Logger.i("location-trace-core LocationCallbackServer mergeLocation onError");     // Catch: Throwable -> L56
        k.d r107 = this.f508006b;     // Catch: Throwable -> L56
        r107.getClass();     // Catch: Throwable -> L56
        r103 = new ArrayList(r107.f508001d);     // Catch: Throwable -> L56
        ((ArrayList) r107.f508001d).clear();     // Catch: Throwable -> L56
    L58:
        this.f508006b.a();     // Catch: Throwable -> L56
        monitor-exit(r106);     // Catch: Throwable -> L56
        if (r103 != null) goto L62;
    L70:
        this.f508008d.post(new j0(this, r100));
        f(r100);
        return;
    L62:
        if (r103.isEmpty() == true) goto L70;
    L64:
        if (r101 >= r103.size()) goto L69;
        final BDLocationCallback r108 = (BDLocationCallback) ListProtector.get(r103, r101);
        if (r108 == null) goto L68;
        this.f508008d.post(new i0(r108, r100));
    L68:
        r101 = r101 + 1;
        goto L64
    L69:
        f(r100);
        return;
    L36:
        if (this.f508007c.isOnceLocation() == false) goto L40;
        if (this.f508007c.getLightLocation() == null) goto L40;
    L13:
        if (this.f508007c.getLocateType() != 0) goto L31;
        Logger.i("overseas getLocation error and use cache");
        BDLocation r109 = k.l().p(this.f508007c, null);
        k r110 = k.l();
        LocationOption r111 = this.f508007c;
        r110.getClass();
        if (r109 != null) goto L18;
        Logger.i("LocationCache IS NULL");
    L25:
        boolean r112 = false;
    L27:
        LocationMonitor.overseasLocationFailedGetCache(r112);
        if (r112 == false) goto L31;
        c(r109);
        return;
    L18:
        if (r111.getGeocodeMode() == 0) goto L23;
        if (r109.hasAddress() == true) goto L23;
        Logger.i("LocationCache NO_GEOCODE");
    L23:
        if (LocationUtil.checkCacheTime(r109.getLocationMs(), BDLocationConfig.getOverseasGetLocationFailedUseCacheValidity()) == true) goto L26;
        Logger.i("LocationCache checkCacheTime is false");
        goto L25
    L26:
        r112 = true;
        goto L27
    L5:
        if (this.f508007c.getLocateType() == 0) goto L10;
        if (this.f508007c.isDownGradeLocation() == true) goto L10;
        e();
    }

    @Override // com.bytedance.bdlocation.scan.wifi.WifiUtil.WifiInfoJsonCallback
    public final void onFailed(BDLocationException r100) {
        Object r101 = this.f508012h;
        monitor-enter(r101);
        this.f508013i = true;     // Catch: Throwable -> L10
        if (this.f508014j == false) goto L8;
        Logger.i("upLoadLocation from scan Wifi onFailed");     // Catch: Throwable -> L10
        j(this.f508015k);     // Catch: Throwable -> L10
    L8:
        monitor-exit(r101);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.bdlocation.callback.BDLocationCallback
    public final void onLocationChanged(BDLocation r210) {
        ArrayList r110 = new ArrayList();
        Object[] r111 = {r210};
        f06.b r112 = new f06.b();
        g06.a r100 = ApiHookConfig.f245611b.get(101330);
        if (r100 == null) goto L5;
        f06.a[] r101 = r100.f479473i;
    L6:
        f06.a[] r102 = r101;
        int r103 = r102.length;
        int r104 = 0;
    L8:
        if (r104 >= r103) goto L15;
        f06.a r105 = r102[r104];
        int r113 = r104;
        int r114 = r103;
        f06.a[] r211 = r102;
        f06.d r106 = r105.preInvoke(101330, "com/bytedance/bdlocation_impl/service/LocationCallBackServer", "onLocationChanged", this, r111, "void", r112);     // Catch: Exception -> L96
        if (r106.f474982a == true) goto L12;
        r110.add(r105);     // Catch: Exception -> L96
        goto L14
    L12:
        LocInfoRspData r107 = null;
    L17:
        if (r106.f474982a == false) goto L20;
        return;
    L20:
        if (this.f508007c.isHitStationaryScene() == false) goto L28;
        LocationUploadExtra r108 = new LocationUploadExtra();
        r108.setUploadInterval(this.f508007c.getUploadInterval());
        r108.setLocateId(this.f508007c.getLocateId());
        if (BDLocationConfig.isMockEnable() == false) goto L24;
        r108.setUploadSource(BenefitStore.FROM_MOCK);
    L25:
        r108.setTriggerType(this.f508007c.getTriggerType());
        r108.setBpeaCert(this.f508007c.getBpeaCert());
        r108.setStartLocationTime(this.f508007c.getStartLocationTime());
        r108.setExtra(this.f508007c.getExtra());
        r108.setOnceLocation(this.f508007c.isOnceLocation());
        r108.setLocationTraceLogger(this.f508007c.getLocationTraceLogger());
        r108.setStartLocationTimestampInMillis(this.f508007c.startLocationTimestampInMillis);
        LocationUtil.startCacheLocateInfoUpload(r108, new m0(this, System.currentTimeMillis(), r210));
        return;
    L24:
        r108.setUploadSource(this.f508007c.getUploadSource());
        goto L25
    L28:
        if (this.f508007c.isOnceLocation() == true) goto L31;
        BDLocationConfig.setOpenStationaryScene(false);
    L31:
        if (LocationUtil.isEmpty(r210) == true) goto L33;
        boolean r109 = r210.isCache();
        if (BDLocationConfig.isFirstLocation() == false) goto L47;
        LocationMonitor.doFirstLocationDuration(SystemClock.elapsedRealtime() - BDLocationConfig.getInitStartTime(), r109);
        Logger.i("locationmonitor first location duration is: " + (SystemClock.elapsedRealtime() - BDLocationConfig.getInitStartTime()) + "ms");
        BDLocationConfig.setFirstLocation(false);
    L47:
        if (r210.isCache() == false) goto L50;
        c(r210);
        return;
    L50:
        BDLocation r115 = LocationUtil.convertLocation(r210);
        if (this.f508007c.isUpload() == true) goto L53;
    L62:
        boolean r116 = false;
    L63:
        if (r116 == true) goto L65;
        LocInfoRspData r117 = r115.getLocInfoRsp();
        if (r117 != null) goto L83;
    L85:
        k84.a.d(r117);
        if (r117 == null) goto L88;
        LocInfoRspData r118 = new LocInfoRspData(r117);
    L89:
        if (r118 == null) goto L92;
        r115.setSubmitLogId(r118.submitLogId);
    L92:
        if (this.f508007c.isOnceLocation() == false) goto L94;
        k84.a.c(r118, r115, this.f508007c);
    L94:
        c(r115);
        k84.a.b(r118, r115, this.f508007c);
        r115.setLocInfoRsp(r107);
        return;
    L88:
        r118 = r107;
        goto L89
    L83:
        if (r117.disablePollingUpload != 1) goto L85;
        Logger.i("disablePollingUpload == 1, disable polling upload.");
        BDLocationConfig.setPollingUpload(false);
        j84.a.a().g();
        goto L85
    L65:
        if (this.f508007c.isOnceLocation() == true) goto L67;
    L79:
        j(r115);
        return;
    L67:
        if (BDLocationConfig.isAsyncScanWifi() == false) goto L79;
        Object r119 = this.f508012h;
        monitor-enter(r119);
    L76:
        th = move-exception;
        throw th;
    L71:
        if (this.f508013i == false) goto L73;
        Logger.i("upLoadLocation from onLocationChanged");     // Catch: Throwable -> L76
        j(r115);     // Catch: Throwable -> L76
    L73:
        this.f508015k = r115;     // Catch: Throwable -> L76
        this.f508014j = true;     // Catch: Throwable -> L76
        monitor-exit(r119);     // Catch: Throwable -> L76
        return;
    L53:
        if (LocationUtil.needUpload(r115) == false) goto L62;
        if (this.f508007c.getLocateType() != 7) goto L61;
        if (r115 == null) goto L62;
        if (r115.validLatlng() == false) goto L62;
    L61:
        r116 = true;
        goto L63
    L33:
        if (this.f508007c.isOnceLocation() == true) goto L35;
    L40:
        onError(new BDLocationException("location callback null!", "UNKnown", "26"));
        return;
    L35:
        if (this.f508007c.getLocateType() == 0) goto L40;
        if (this.f508007c.isDownGradeLocation() == true) goto L40;
        e();
        return;
    L14:
        r104 = r113 + 1;
        r103 = r114;
        r102 = r211;
        goto L8
    L15:
        r107 = null;
        r106 = new f06.d(false, null);
        goto L17
    L5:
        r101 = ApiHookConfig.f245613d;
        goto L6
    }

    public static void h(BDLocation r100, boolean r101) {
        CacheConditionEntity r102 = new CacheConditionEntity();
        if (r100 != null) goto L7;
        r102.setConditionCode(1);
        LocationCache.getInstance().executeWithoutLocationCache(System.currentTimeMillis(), r102, false);
        return;
    L7:
        if (r100.getLocationType() != 6) goto L11;
        Logger.i("IP location");
        r102.setConditionCode(2);
        LocationCache.getInstance().executeWithoutLocationCache(r100.getLocationMs(), r102, !r100.isCache());
        return;
    L11:
        if (r100.isMock() == false) goto L14;
        Logger.i("mock location");
        r102.setConditionCode(3);
        LocationCache.getInstance().executeWithoutLocationCache(r100.getLocationMs(), r102, !r100.isCache());
        return;
    L14:
        Logger.i("CheckNewLocation new location time:" + r100.getLocationMs());
        BDLocation r103 = LocationCache.getInstance().getLocationCache().getLatestLocation();
        Logger.i("LocationCallbackServer executeLocationCache isUseNewCacheStrategy: " + BDLocationConfig.isUseNewCacheStrategy());
        if (BDLocationConfig.isUseCacheCondition() == false) goto L30;
        if (r100.isCache() == false) goto L19;
        return;
    L19:
        if (BDLocationConfig.isRestrictedModeOn() == false) goto L22;
        r102.setConditionCode(4);
        LocationCache.getInstance().executeWithoutLocationCache(r100.getLocationMs(), r102, !r100.isCache());
        return;
    L22:
        if (LocationUtil.isBetterLocation(r100, r103, r102) == false) goto L24;
    L25:
        Logger.i("UseCacheCondition checkNewLocation executeLocationCache");
        long r104 = r100.getLocationMs();
        if (BDLightLocationCache.lightLocationNeedCheckCache() == false) goto L28;
        BDLightLocationCache.setLastLocationTime(BDLocationConfig.getContext(), r104);
    L28:
        LocationCache.getInstance().executeLocationCache(r100, r102, true ^ r100.isCache(), r101);
        return;
    L24:
        if (LocationUtil.isGoodLocation(r100, r102) == true) goto L25;
        return;
    L30:
        if (LocationUtil.isBetterLocation(r100, r103) == true) goto L34;
        if (LocationUtil.isGoodLocation(r100) == true) goto L34;
        return;
    L34:
        if (BDLocationConfig.isRestrictedModeOn() == true) goto L45;
        Logger.i("CheckNewLocation executeLocationCache");
        long r105 = r100.getLocationMs();
        if (BDLightLocationCache.lightLocationNeedCheckCache() == false) goto L38;
        BDLightLocationCache.setLastLocationTime(BDLocationConfig.getContext(), r105);
    L38:
        LocationCache.getInstance().executeLocationCache(r100, true ^ r100.isCache(), r101);
        return;
    }

    public final void b(BDLocation r100, boolean r101) {
        Logger.i("callbackContinueLocationInfo isSynchronizeUpload:" + this.f508007c.isSynchronizeUpload() + "--needCallback:" + r101);
        if (this.f508007c.isSynchronizeUpload() == true) goto L5;
        if (r101 == false) goto L5;
    L7:
        if (this.f508007c.isSynchronizeUpload() == true) goto L9;
        if (r101 == true) goto L9;
        return;
    L9:
        BDLocation r102 = LocationUtil.transformLocationForLevel(r100, this.f508007c.getAccuracyLevel());
        if (this.f508008d != null) goto L12;
        this.f508008d = new Handler(Looper.getMainLooper());
    L12:
        this.f508008d.post(new b(this, r102));
        return;
    L5:
        i(r100);
        h(r100, true);
        goto L7
    }

    public final void d(final BDLocation r100, boolean r101, boolean r102) {
        if (this.f508008d != null) goto L5;
        this.f508008d = new Handler(Looper.getMainLooper());
    L5:
        k.d r103 = this.f508006b;
        monitor-enter(r103);
    L10:
        th = move-exception;
        throw th;
    L8:
        if (this.f508007c.isCallbackThroughLocateTrace == false) goto L12;
        Logger.i("LocationCallbackServer callbackLocationInfoInner callback merge location.");     // Catch: Throwable -> L10
        k.d r104 = this.f508006b;     // Catch: Throwable -> L10
        r104.getClass();     // Catch: Throwable -> L10
        ArrayList r105 = new ArrayList(r104.f508001d);     // Catch: Throwable -> L10
        ((ArrayList) r104.f508001d).clear();     // Catch: Throwable -> L10
    L13:
        if (r101 == false) goto L15;
        this.f508006b.a();     // Catch: Throwable -> L10
    L15:
        monitor-exit(r103);     // Catch: Throwable -> L10
        if (r105 != null) goto L18;
    L28:
        this.f508008d.post(new h0(this, r100));
        if (r102 == false) goto L41;
        g(r100);
        return;
    L41:
        return;
    L18:
        if (r105.isEmpty() == true) goto L28;
        int r106 = 0;
    L21:
        if (r106 >= r105.size()) goto L26;
        final BDLocationCallback r107 = (BDLocationCallback) ListProtector.get(r105, r106);
        if (r107 == null) goto L25;
        this.f508008d.post(new g0(r107, r100));
    L25:
        r106 = r106 + 1;
        goto L21
    L26:
        if (r102 == false) goto L39;
        g(r100);
        return;
    L39:
        return;
    L12:
        r105 = null;
        goto L13
    }

    @Override // com.bytedance.bdlocation.scan.wifi.WifiUtil.WifiInfoJsonCallback
    public final void onWifiInfoJson(JsonArray r100, boolean r101, boolean r102, WifiInfo r103) {
        this.f508019o = r103;
        this.f508016l = r100;
        this.f508017m = r101;
        this.f508018n = r102;
        Object r104 = this.f508012h;
        monitor-enter(r104);
        this.f508013i = true;     // Catch: Throwable -> L10
        if (this.f508014j == false) goto L8;
        Logger.i("upLoadLocation from onWifiInfoJson");     // Catch: Throwable -> L10
        j(this.f508015k);     // Catch: Throwable -> L10
    L8:
        monitor-exit(r104);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public l0(BDLocationCallback r100, LocationOption r101, k.d r102, Handler r103, Handler r104, LocationTraceManager.a r105) {
        this.f508012h = new Object();
        this.f508017m = true;
        this.f508018n = true;
        this.f508005a = r100;
        this.f508006b = r102;
        this.f508007c = r101;
        this.f508008d = r103;
        this.f508010f = r105;
        this.f508011g = SystemClock.elapsedRealtime();
        if (r104 == null) goto L5;
        this.f508009e = r104;
        return;
    L5:
        this.f508009e = new Handler(ThreadLooperManager.getLocationWorker());
    }
}
