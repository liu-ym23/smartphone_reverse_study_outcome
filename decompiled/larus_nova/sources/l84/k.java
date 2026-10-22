package l84;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.net.wifi.ScanResult;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.bytedance.bdlocation.BDLocation;
import com.bytedance.bdlocation.BaseLocate;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.bdlocation.LocationUtil;
import com.bytedance.bdlocation.api.IBPEALocal;
import com.bytedance.bdlocation.callback.BDLocationCallback;
import com.bytedance.bdlocation.callback.IDYHostInfoProvider;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.bdlocation.client.LocationOption;
import com.bytedance.bdlocation.entity.LastLocationEntity;
import com.bytedance.bdlocation.entity.LocateReasonEntity;
import com.bytedance.bdlocation.entity.bpea.BPEACertCheckResult;
import com.bytedance.bdlocation.entity.gis.BdGisResult;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.bdlocation.exception.BDLocationExceptionMessage;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.monitor.LBSLightLocationTraceLogger;
import com.bytedance.bdlocation.monitor.LocationExtraDataTraceLogger;
import com.bytedance.bdlocation.monitor.LocationMonitor;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.bdlocation.monitor.LocationTraceLogger;
import com.bytedance.bdlocation.network.model.StationarySceneCacheInfo;
import com.bytedance.bdlocation.nmea.NMEAInfoManager;
import com.bytedance.bdlocation.satellite.GnssInfoManager;
import com.bytedance.bdlocation.scan.wifi.LBSLightWifiUtils;
import com.bytedance.bdlocation.scan.wifi.WifiUtil;
import com.bytedance.bdlocation.sensor.SensorInfoManager;
import com.bytedance.bdlocation.service.BDLocationExtraDataServer;
import com.bytedance.bdlocation.service.BDLocationExtrasService;
import com.bytedance.bdlocation.store.LocationCache;
import com.bytedance.bdlocation.store.LocationCacheInfo;
import com.bytedance.bdlocation.thread.AppExecutors;
import com.bytedance.bdlocation.thread.ThreadLooperManager;
import com.bytedance.bdlocation.utils.BDLocationReflectUtils;
import com.bytedance.bdlocation_impl.trace.LocationTraceManager;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class k {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final Looper f507965p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final Handler f507966q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static volatile k f507967r;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LocationCache f507968a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e0 f507969b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f507970c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Handler f507971d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Handler f507972e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public BaseLocate f507973f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Set<String> f507974g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public BaseLocate f507975h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Map<String, Integer> f507976i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Map<String, LocationOption> f507977j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final IBPEALocal f507978k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final AtomicInteger f507979l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final d f507980m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f507981n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final ArrayList<BDLocationExtraDataServer> f507982o;

    /* JADX INFO: loaded from: classes10.dex */
    public class a implements BDLocationCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BDLocation[] f507983a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ CountDownLatch f507984b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ BDLocationException[] f507985c;

        @Override // com.bytedance.bdlocation.callback.BDLocationCallback
        public final void onError(BDLocationException r100) {
            this.f507985c[0] = r100;
            this.f507984b.countDown();
        }

        @Override // com.bytedance.bdlocation.callback.BDLocationCallback
        public final void onLocationChanged(BDLocation r210) {
            ArrayList r100 = new ArrayList();
            Object[] r110 = {r210};
            f06.b r111 = new f06.b();
            g06.a r101 = ApiHookConfig.f245611b.get(101330);
            if (r101 == null) goto L5;
            f06.a[] r102 = r101.f479473i;
        L6:
            f06.a[] r103 = r102;
            int r104 = r103.length;
            int r105 = 0;
        L8:
            if (r105 >= r104) goto L15;
            f06.a r106 = r103[r105];
            int r112 = r105;
            int r113 = r104;
            f06.a[] r114 = r103;
            f06.d r107 = r106.preInvoke(101330, "com/bytedance/bdlocation_impl/service/BDLocationService$1", "onLocationChanged", this, r110, "void", r111);     // Catch: Exception -> L21
            if (r107.f474982a == true) goto L12;
            r100.add(r106);     // Catch: Exception -> L21
            goto L14
        L12:
            char r108 = 0;
        L17:
            if (r107.f474982a == false) goto L19;
            return;
        L19:
            this.f507983a[r108] = r210;
            this.f507984b.countDown();
            return;
        L14:
            r105 = r112 + 1;
            r104 = r113;
            r103 = r114;
            goto L8
        L15:
            r108 = 0;
            r107 = new f06.d(false, null);
            goto L17
        L5:
            r102 = ApiHookConfig.f245613d;
            goto L6
        }

        public a(BDLocation[] r100, CountDownLatch r101, BDLocationException[] r102) {
            this.f507983a = r100;
            this.f507984b = r101;
            this.f507985c = r102;
        }
    }

    /* JADX INFO: loaded from: classes10.dex */
    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LocationOption f507986a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ BDLocation f507987b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ l0 f507988c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ boolean f507989d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ LocationCacheInfo f507990e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ LocateReasonEntity f507991f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ LocationOption f507992g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ k f507993h;

        public final void a() {
            k r110 = k.f507967r;
            monitor-enter(r110);
            LocationMonitor.locationTraceLogEnd(this.f507986a.getLocationTraceLogger(), LocationMonitorConst.LOCATION_THREAD_SWITCH_DURATION);     // Catch: Throwable -> L127
            this.f507986a.setBackground(LocationUtil.isBackground());     // Catch: Throwable -> L127
            this.f507986a.setUploadInterval(j84.a.a().b() / 1000);     // Catch: Throwable -> L127
            k.a(this.f507993h, this.f507986a, this.f507987b);     // Catch: Throwable -> L127
            LocationMonitor.locationTraceLogBegin(this.f507986a.getLocationTraceLogger(), LocationMonitorConst.LOCATION_BEFORE_START_DURATION);     // Catch: Throwable -> L127
            k r111 = this.f507993h;     // Catch: Throwable -> L127
            LocationOption r112 = this.f507986a;     // Catch: Throwable -> L127
            l0 r113 = this.f507988c;     // Catch: Throwable -> L127
            r111.getClass();     // Catch: Throwable -> L127
            boolean r114 = true;
            if (k.d(true, r112, r113) == true) goto L10;
            Logger.i("RestrictedMode|background|LocationServer|permission unable");     // Catch: Throwable -> L127
            monitor-exit(r110);     // Catch: Throwable -> L127
            return;
        L10:
            if (this.f507989d == false) goto L18;
            if (LocationUtil.isLocationEnabled() == true) goto L16;
            Logger.i("check allowUseLocation ERROR_DEVICE_LOCATION_DISABLE");     // Catch: Throwable -> L127
            k r100 = this.f507993h;     // Catch: Throwable -> L127
            l0 r101 = this.f507988c;     // Catch: Throwable -> L127
            r100.getClass();     // Catch: Throwable -> L127
            k.t(BDLocationException.ERROR_DEVICE_LOCATION_DISABLE, r101);     // Catch: Throwable -> L127
            Logger.i("RestrictedMode|background|LocationServer|permission unable");     // Catch: Throwable -> L127
            monitor-exit(r110);     // Catch: Throwable -> L127
            return;
        L16:
            Logger.i("location cache is validity, return cache location ");     // Catch: Throwable -> L127
            LocationMonitor.locationTraceLogEnd(this.f507986a.getLocationTraceLogger(), LocationMonitorConst.LOCATION_RULE_CHECK_DURATION);     // Catch: Throwable -> L127
            k r102 = this.f507993h;     // Catch: Throwable -> L127
            BDLocation r103 = this.f507987b;     // Catch: Throwable -> L127
            l0 r104 = this.f507988c;     // Catch: Throwable -> L127
            r102.getClass();     // Catch: Throwable -> L127
            AppExecutors.getInstance().mainThread().execute(new q(r104, r103));     // Catch: Throwable -> L127
        L124:
            Logger.d("startLocation :");     // Catch: Throwable -> L127
            monitor-exit(r110);     // Catch: Throwable -> L127
            return;
        L18:
            if (LocationUtil.isLocationEnabled() == true) goto L22;
            Logger.i("check allowUseLocation ERROR_DEVICE_LOCATION_DISABLE");     // Catch: Throwable -> L127
            k r105 = this.f507993h;     // Catch: Throwable -> L127
            l0 r106 = this.f507988c;     // Catch: Throwable -> L127
            r105.getClass();     // Catch: Throwable -> L127
            k.t(BDLocationException.ERROR_DEVICE_LOCATION_DISABLE, r106);     // Catch: Throwable -> L127
            Logger.i("RestrictedMode|background|LocationServer|permission unable");     // Catch: Throwable -> L127
            monitor-exit(r110);     // Catch: Throwable -> L127
            return;
        L22:
            k r115 = this.f507993h;     // Catch: Throwable -> L127
            LocationOption r116 = this.f507986a;     // Catch: Throwable -> L127
            r115.getClass();     // Catch: Throwable -> L127
            int r117 = r116.getLocateType();     // Catch: Throwable -> L127
            if (r117 != (-1)) goto L25;
            r117 = BDLocationConfig.getLocateType();     // Catch: Throwable -> L127
        L25:
            Logger.i("startLocation locateType:" + r117);     // Catch: Throwable -> L127
            if (this.f507986a.isOnceLocation() == false) goto L76;
            if (BDLocationConfig.isMockEnable() == false) goto L30;
        L33:
            BaseLocate r107 = this.f507993h.f507969b.a(r117);     // Catch: Throwable -> L127
            if (r107 != null) goto L36;
            Logger.i("mLocation is null");     // Catch: Throwable -> L127
            BDLocationException r108 = new BDLocationException("未获取到定位内核异常", BuildConfig.BDLOCATION_VERSION, BDLocationException.ERROR_NO_LOCATE);     // Catch: Throwable -> L127
            k r109 = this.f507993h;     // Catch: Throwable -> L127
            l0 r118 = this.f507988c;     // Catch: Throwable -> L127
            r109.getClass();     // Catch: Throwable -> L127
            k.s(r118, r108);     // Catch: Throwable -> L127
        L123:
            LocationMonitor.getLightLocationMonitor();     // Catch: Throwable -> L127
            goto L124
        L36:
            if (BDLocationConfig.isUseCacheCondition() == false) goto L46;
            LocationCacheInfo r119 = this.f507990e;     // Catch: Throwable -> L127
            long r120 = -1;
            if (r119 == null) goto L40;
            long r210 = r119.getLatestLocationCacheTime();     // Catch: Throwable -> L127
            int r211 = this.f507990e.getLatestLocationCacheCondition();     // Catch: Throwable -> L127
        L41:
            long r121 = System.currentTimeMillis();     // Catch: Throwable -> L127
            k r122 = this.f507993h;     // Catch: Throwable -> L127
            long r123 = r122.f507981n;     // Catch: Throwable -> L127
            if (r123 == (-1)) goto L44;
            r120 = r121 - r123;     // Catch: Throwable -> L127
        L44:
            r122.f507981n = r121;     // Catch: Throwable -> L127
            LocationMonitor.locationFrequencyMonitor(this.f507986a, this.f507991f.getReasonCode(), r121, r120, r211, r210);     // Catch: Throwable -> L127
            goto L46
        L40:
            r210 = -1;
            r211 = -1;
        L46:
            if (this.f507992g.isDownGradeLocation() == false) goto L48;
        L64:
            LocationMonitor.locationTraceLogEnd(this.f507986a.getLocationTraceLogger(), LocationMonitorConst.LOCATION_BEFORE_START_DURATION);     // Catch: Throwable -> L127
            LocationMonitor.locationTraceLogEnd(this.f507986a.getLocationTraceLogger(), LocationMonitorConst.LOCATION_RULE_CHECK_DURATION);     // Catch: Throwable -> L127
            k r124 = this.f507993h;     // Catch: Throwable -> L127
            LocationOption r125 = this.f507986a;     // Catch: Throwable -> L127
            l0 r126 = this.f507988c;     // Catch: Throwable -> L127
            r124.getClass();     // Catch: Throwable -> L127
            if (r117 != 3) goto L67;
        L73:
            r107.startLocation(this.f507988c, this.f507986a, k.f507965p);     // Catch: Throwable -> L127
            goto L123
        L67:
            if (r125.isOnceLocation() == false) goto L73;
            if (BDLocationConfig.isAsyncScanWifi() == false) goto L73;
            if ((r126 instanceof WifiUtil.WifiInfoJsonCallback) == false) goto L73;
            Logger.i("start scan wifi");     // Catch: Throwable -> L127
            WifiUtil.getWifiInfoJsonAsync(BDLocationConfig.getContext(), r126, r125.getBpeaCert(), r125.getLocationTraceLogger(), r125);     // Catch: Throwable -> L127
            goto L73
        L48:
            if (BDLocationConfig.isMockEnable() == true) goto L64;
            BDLocationExtraDataServer r127 = new BDLocationExtraDataServer();     // Catch: Throwable -> L127
            k r128 = this.f507993h;     // Catch: Throwable -> L127
            if (r128.f507982o.size() <= 20) goto L54;
            BDLocationExtraDataServer r129 = (BDLocationExtraDataServer) ListProtector.remove(r128.f507982o, 0);     // Catch: Throwable -> L127
            if (r129 == null) goto L54;
            r129.stopCollectExtraData();     // Catch: Throwable -> L127
        L54:
            r128.f507982o.add(r127);     // Catch: Throwable -> L127
            this.f507986a.setLocationExtraDataServer(r127);     // Catch: Throwable -> L127
            LocationExtraDataTraceLogger r130 = new LocationExtraDataTraceLogger();     // Catch: Throwable -> L127
            this.f507986a.setLocationExtraDataTraceLogger(r130);     // Catch: Throwable -> L127
            LocationMonitor.locationExtraDataTraceLogBegin(r130, LocationExtraDataTraceLogger.COLLECT_EXTRA_DATA_DURATION);     // Catch: Throwable -> L127
            Logger.i("location-trace-core isFirstLocation: " + BDLocationConfig.isFirstLocation() + ", ColdBootCollectGps: " + BDLocationConfig.getColdBootCollectGps());     // Catch: Throwable -> L127
            long r131 = BDLocationConfig.getDefaultGpsScanInterval();     // Catch: Throwable -> L127
            if (BDLocationConfig.isFirstLocation() == true) goto L57;
        L63:
            LocationMonitor.locationExtraDataTracePutCategoryData(r130, LocationExtraDataTraceLogger.DEFAULT_GPS_SCAN_INTERVAL, Long.valueOf(r131));     // Catch: Throwable -> L127
            LocationMonitor.locationExtraDataTracePutCategoryData(r130, LocationExtraDataTraceLogger.ENABLE_BACKGROUND_UPLOAD_LOCATION, Boolean.valueOf(BDLocationConfig.enableBackgroundUploadLocation()));     // Catch: Throwable -> L127
            LocationMonitor.locationExtraDataTracePutCategoryData(r130, "enable_upload_last_location_info", Boolean.valueOf(BDLocationConfig.enableUploadLastLocationInfo()));     // Catch: Throwable -> L127
            Logger.i("location-trace-core locationExtraDataServer.startCollectGpsData.");     // Catch: Throwable -> L127
            r127.startCollectGpsData(this.f507986a, k.f507966q, this.f507993h.f507982o);     // Catch: Throwable -> L127
            SensorInfoManager.getInstance().registerListener(5);     // Catch: Throwable -> L127
            goto L64
        L57:
            if (BDLocationConfig.getColdBootCollectGps() == false) goto L63;
            long r132 = this.f507990e.getNextGpsScanInterval();     // Catch: Throwable -> L127
            if (r132 == 0) goto L61;
            long r133 = r132;
        L62:
            BDLocationConfig.setGpsScanInterval(r133);     // Catch: Throwable -> L127
            Logger.i("location-trace-core startLocation: cache nextGpsScanInterval = " + r132 + ", defaultGpsScanInterval = " + r131);     // Catch: Throwable -> L127
            goto L63
        L61:
            r133 = r131;
            goto L62
        L30:
            if ("v2".equals(BDLocationConfig.getByteLocationLibraParam()) == false) goto L33;
            if (r117 == 0) goto L33;
            Logger.i("location-trace-core change locate type from " + r117 + " to LocationInfoConst.LOCATE_BYTE");     // Catch: Throwable -> L127
            r117 = 3;
            goto L33
        L76:
            if ("bpea-light_navigation".equals(this.f507986a.getUploadSource()) == false) goto L79;
            Logger.i("detect light navigation continuous location, change locateType from " + r117 + " to 1");     // Catch: Throwable -> L127
            this.f507986a.setLocateType(1);     // Catch: Throwable -> L127
            r117 = 1;
        L79:
            if (r117 != 7) goto L101;
            Logger.i("BYTE_FUSION_CONTINUOUS_CHAIN enter BDLocationService branch, locateType:" + r117);     // Catch: Throwable -> L127
            k r134 = this.f507993h;     // Catch: Throwable -> L127
            if (r134.f507975h != null) goto L84;
            r134.f507975h = r134.f507969b.a(r117);     // Catch: Throwable -> L127
            Logger.i("BYTE_FUSION_CONTINUOUS_CHAIN get locate object:" + this.f507993h.f507975h);     // Catch: Throwable -> L127
        L84:
            if (this.f507993h.f507975h == null) goto L99;
            LocationMonitor.locationTraceLogEnd(this.f507986a.getLocationTraceLogger(), LocationMonitorConst.LOCATION_RULE_CHECK_DURATION);     // Catch: Throwable -> L127
            boolean r135 = LocationUtil.isNavigationByteContinuousLocation(this.f507986a);     // Catch: Throwable -> L127
            boolean r136 = BDLocationConfig.isSensorContinuousCollectEnabled();     // Catch: Throwable -> L127
            if (r135 == false) goto L89;
            if (r136 == false) goto L89;
        L90:
            Logger.i("BDLocationService.sensorDecision: locateType=" + this.f507986a.getLocateType() + ", isOnce=" + this.f507986a.isOnceLocation() + ", uploadSource=" + this.f507986a.getUploadSource() + ", sensorCollectionEnabled=" + r136 + ", shouldRegisterSensors=" + r114);     // Catch: Throwable -> L127
            k.b(this.f507993h, this.f507986a, r117);     // Catch: Throwable -> L127
            this.f507993h.f507975h.startLocation(this.f507988c, this.f507986a, k.f507965p);     // Catch: Throwable -> L127
            if (r114 == true) goto L93;
            if (r135 == false) goto L98;
            Logger.i("BDLocationService.sensorDecision: skip registerContinuousSensors (sensor collection disabled)");     // Catch: Throwable -> L127
            goto L123
        L98:
            Logger.i("BDLocationService.sensorDecision: skip registerContinuousSensors (not navigation+byte-continuous scenario)");     // Catch: Throwable -> L127
            goto L123
        L93:
            if (this.f507993h.f507975h.isLocationRunningForBusiness(this.f507986a.getBusinessId()) == false) goto L95;
            k.c(this.f507993h, this.f507986a);     // Catch: Throwable -> L127
            goto L123
        L95:
            this.f507993h.x(this.f507986a.getBusinessId());     // Catch: Throwable -> L127
            Logger.i("BDLocationService.sensorDecision: skip registerContinuousSensors because continuous location failed to start");     // Catch: Throwable -> L127
        L89:
            r114 = false;
            goto L90
        L99:
            Logger.i("mByteFusionContinuousLocation is null");     // Catch: Throwable -> L127
            BDLocationException r137 = new BDLocationException("未获取到定位内核异常", BuildConfig.BDLOCATION_VERSION, BDLocationException.ERROR_NO_LOCATE);     // Catch: Throwable -> L127
            k r138 = this.f507993h;     // Catch: Throwable -> L127
            l0 r139 = this.f507988c;     // Catch: Throwable -> L127
            r138.getClass();     // Catch: Throwable -> L127
            k.s(r139, r137);     // Catch: Throwable -> L127
            goto L123
        L101:
            if (BDLocationConfig.enableByteContinuousLocation() == false) goto L103;
            r117 = 6;
            this.f507986a.setLocateType(6);     // Catch: Throwable -> L127
        L103:
            k r140 = this.f507993h;     // Catch: Throwable -> L127
            if (r140.f507973f != null) goto L107;
            r140.f507973f = r140.f507969b.a(r117);     // Catch: Throwable -> L127
        L107:
            if (this.f507993h.f507973f == null) goto L122;
            LocationMonitor.locationTraceLogEnd(this.f507986a.getLocationTraceLogger(), LocationMonitorConst.LOCATION_RULE_CHECK_DURATION);     // Catch: Throwable -> L127
            boolean r141 = LocationUtil.isNavigationByteContinuousLocation(this.f507986a);     // Catch: Throwable -> L127
            boolean r142 = BDLocationConfig.isSensorContinuousCollectEnabled();     // Catch: Throwable -> L127
            if (r141 == false) goto L112;
            if (r142 == false) goto L112;
        L113:
            Logger.i("BDLocationService.sensorDecision: locateType=" + this.f507986a.getLocateType() + ", isOnce=" + this.f507986a.isOnceLocation() + ", uploadSource=" + this.f507986a.getUploadSource() + ", sensorCollectionEnabled=" + r142 + ", shouldRegisterSensors=" + r114);     // Catch: Throwable -> L127
            k.b(this.f507993h, this.f507986a, r117);     // Catch: Throwable -> L127
            this.f507993h.f507973f.startLocation(this.f507988c, this.f507986a, k.f507965p);     // Catch: Throwable -> L127
            if (r114 == true) goto L116;
            if (r141 == false) goto L121;
            Logger.i("BDLocationService.sensorDecision: skip registerContinuousSensors (sensor collection disabled)");     // Catch: Throwable -> L127
            goto L123
        L121:
            Logger.i("BDLocationService.sensorDecision: skip registerContinuousSensors (not navigation+byte-continuous scenario)");     // Catch: Throwable -> L127
            goto L123
        L116:
            if (this.f507993h.f507973f.isLocationRunningForBusiness(this.f507986a.getBusinessId()) == false) goto L118;
            k.c(this.f507993h, this.f507986a);     // Catch: Throwable -> L127
            goto L123
        L118:
            this.f507993h.x(this.f507986a.getBusinessId());     // Catch: Throwable -> L127
            Logger.i("BDLocationService.sensorDecision: skip registerContinuousSensors because continuous location failed to start");     // Catch: Throwable -> L127
        L112:
            r114 = false;
            goto L113
        L122:
            Logger.i("mContinuousLocation is null");     // Catch: Throwable -> L127
            BDLocationException r143 = new BDLocationException("未获取到定位内核异常", BuildConfig.BDLOCATION_VERSION, BDLocationException.ERROR_NO_LOCATE);     // Catch: Throwable -> L127
            k r144 = this.f507993h;     // Catch: Throwable -> L127
            l0 r145 = this.f507988c;     // Catch: Throwable -> L127
            r144.getClass();     // Catch: Throwable -> L127
            k.s(r145, r143);     // Catch: Throwable -> L127
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

        public b(k r100, LocationOption r101, BDLocation r102, l0 r103, boolean r104, LocationCacheInfo r105, LocateReasonEntity r106, LocationOption r107) {
            this.f507993h = r100;
            this.f507986a = r101;
            this.f507987b = r102;
            this.f507988c = r103;
            this.f507989d = r104;
            this.f507990e = r105;
            this.f507991f = r106;
            this.f507992g = r107;
        }
    }

    /* JADX INFO: loaded from: classes10.dex */
    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f507994a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f507995b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f507996c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ k f507997d;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0079 -> B:55:0x0083). Please report as a decompilation issue!!! */
        public final void a() {
            if (TextUtils.isEmpty(this.f507994a) == false) goto L6;
            Logger.w("BDLocationService.updatingNavigationLocationConfig ignored, businessId is null or empty");
            return;
        L6:
            Integer r100 = (Integer) ((HashMap) this.f507997d.f507976i).get(this.f507994a);
            if (r100 != null) goto L10;
            Logger.w("BDLocationService.updatingNavigationLocationConfig ignored, businessId locate type not found: " + this.f507994a);
            return;
        L10:
            LocationOption r101 = (LocationOption) ((HashMap) this.f507997d.f507977j).get(this.f507994a);
            if (r101 != null) goto L14;
            Logger.w("BDLocationService.updatingNavigationLocationConfig ignored, option not found: " + this.f507994a);
            return;
        L14:
            k r102 = this.f507997d;
            String r103 = this.f507995b;
            boolean r104 = this.f507996c;
            r102.getClass();
            r101.setUpload(r104);
            String r105 = r101.getExtra();
        L20:
            th = move-exception;
            Logger.e("BDLocationService.updateNavigationIdInExtra parse extra failed", th);
            JSONObject r106 = new JSONObject();
        L55:
            if (TextUtils.isEmpty(r103) == false) goto L26;
            r106.remove("navigation_id");     // Catch: Throwable -> L29
        L27:
            r105 = r106.toString();     // Catch: Throwable -> L29
        L31:
            r101.setExtra(r105);
            Logger.i("BDLocationService.updateNavigationLocationOption: businessId=" + r101.getBusinessId() + ", navigationIdEmpty=" + TextUtils.isEmpty(r103) + ", needUpload=" + r104);
            k r107 = this.f507997d;
            int r108 = r100.intValue();
            r107.getClass();
            if (k.r(r108) == false) goto L34;
            BaseLocate r109 = this.f507997d.f507975h;
        L36:
            if (r109 != null) goto L38;
        L53:
            this.f507997d.x(this.f507994a);
            Logger.w("BDLocationService.updatingNavigationLocationConfig ignored, location instance not running: " + this.f507994a + ", locateType=" + r100);
            return;
        L38:
            if (r109.isLocationRunningForBusiness(this.f507994a) == false) goto L53;
            if (this.f507996c == true) goto L43;
        L47:
            boolean r110 = false;
        L48:
            Logger.i("BDLocationService.updatingNavigationLocationConfig decision: businessId=" + this.f507994a + ", locateType=" + r100 + ", shouldRegisterSensors=" + r110 + ", sensorCollectionEnabled=" + BDLocationConfig.isSensorContinuousCollectEnabled());
            if (r110 == false) goto L51;
            k.c(this.f507997d, r101);
            return;
        L51:
            this.f507997d.x(this.f507994a);
            return;
        L43:
            if (TextUtils.isEmpty(this.f507995b) == true) goto L47;
            if (LocationUtil.isNavigationByteContinuousLocation(r101) == false) goto L47;
            r110 = true;
            goto L48
        L34:
            r109 = this.f507997d.f507973f;
            goto L36
        L26:
            r106.put("navigation_id", r103);     // Catch: Throwable -> L29
        L29:
            th = move-exception;
            Logger.e("BDLocationService.updateNavigationIdInExtra update navigation_id failed", th);
            goto L31
        L16:
            if (TextUtils.isEmpty(r105) == false) goto L18;
            r106 = new JSONObject();     // Catch: Throwable -> L20
            goto L55
        L18:
            r106 = new JSONObject(r105);     // Catch: Throwable -> L20
            goto L55
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

        public c(k r100, String r101, String r102, boolean r103) {
            this.f507997d = r100;
            this.f507994a = r101;
            this.f507995b = r102;
            this.f507996c = r103;
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f507998a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public LocationOption f507999b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public BDLocation f508000c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final List<BDLocationCallback> f508001d;

        public final synchronized void a() {
            monitor-enter(this);
            StringBuilder r100 = new StringBuilder("LocateTrace.onLocateStop, locate id:");     // Catch: Throwable -> L11
            LocationOption r101 = this.f507999b;     // Catch: Throwable -> L11
            if (r101 != null) goto L7;
            String r102 = "null";
        L8:
            r100.append(r102);     // Catch: Throwable -> L11
            Logger.i(r100.toString());     // Catch: Throwable -> L11
            this.f507999b = null;     // Catch: Throwable -> L11
            this.f507998a = false;     // Catch: Throwable -> L11
            this.f508000c = null;     // Catch: Throwable -> L11
            monitor-exit(this);
            return;
        L7:
            r102 = r101.getLocateId();     // Catch: Throwable -> L11
        L11:
            th = move-exception;
            throw th;
        }

        public d() {
            this.f507998a = false;
            this.f507999b = null;
            this.f508000c = null;
            this.f508001d = new ArrayList();
        }
    }

    /* JADX INFO: loaded from: classes10.dex */
    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final r f508002a = null;

        /* JADX WARN: Type inference failed for: r0v0, types: [l84.r] */
        static {
            f508002a = new r();
        }
    }

    public static boolean r(int r100) {
        if (r100 != 7) goto L5;
        return true;
    L5:
        return false;
    }

    public static k l() {
        if (f507967r != null) goto L15;
        monitor-enter(k.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f507967r != null) goto L9;
        f507967r = new k(BDLocationConfig.getContext());     // Catch: Throwable -> L11
    L9:
        monitor-exit(k.class);     // Catch: Throwable -> L11
    L15:
        return f507967r;
    }

    static {
        Looper r100 = ThreadLooperManager.getLocationWorker();
        f507965p = r100;
        f507966q = new Handler(r100);
        f507967r = null;
    }

    public k(Context r100) {
        this.f507974g = new HashSet();
        this.f507976i = new HashMap();
        this.f507977j = new HashMap();
        this.f507979l = new AtomicInteger(1);
        this.f507980m = new d();
        this.f507981n = -1;
        this.f507970c = r100;
        this.f507971d = new Handler(ThreadLooperManager.getLBSLightLocationWorker());
        this.f507972e = new Handler(Looper.getMainLooper());
        LocationCache r101 = LocationCache.getInstance();
        this.f507968a = r101;
        r101.getLocationCache();
        if (e0.f507940b == null) goto L5;
    L14:
        this.f507969b = e0.f507940b;
        this.f507978k = BDLocationExtrasService.getBPEAManager();
        d0.d();
        ThreadLooperManager.getPollUploadWorker();
        this.f507982o = new ArrayList();
        Logger.i(BDLocationReflectUtils.TAG, "BDLocationService: trigger new BDLocationService instance, context: " + r100);
        return;
    L5:
        monitor-enter(k.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (e0.f507940b != null) goto L9;
        e0.f507940b = new e0();     // Catch: Throwable -> L11
    L9:
        monitor-exit(k.class);     // Catch: Throwable -> L11
        goto L14
    }

    public static void g(boolean r100) throws BDLocationException {
        if (BDLocationConfig.shouldRequestLocation() == true) goto L8;
        if (r100 == false) goto L7;
        return;
    L7:
        throw new BDLocationException(BDLocationExceptionMessage.NON_COMPLIANCE_MESSAGE, LocationInfoConst.BDLOCATION, BDLocationException.ERROR_BOOT_NO_CERT_LOCATE);
    }

    public static BDLocation o(int r100) {
        Logger.i("getLastKnowLocation start");
        LocationCache r101 = l().f507968a;
        if (r101 != null) goto L6;
        return null;
    L6:
        BDLocation r102 = r101.getLocationCache().getLatestLocation();
        if (r102 == null) goto L9;
        r102.setCache(true);
    L9:
        BDLocation r103 = LocationUtil.transformLocationForLevel(r102, r100);
        Logger.i("getLastKnowLocation end");
        return r103;
    }

    public static boolean q(l0 r100) {
        if (BDLocationConfig.initIfNeed() == false) goto L6;
        return true;
    L6:
        Logger.i("Must be called after BDLocation initialization!");
        if (r100 == null) goto L11;
        s(r100, new BDLocationException(BDLocationExceptionMessage.NOT_INITIALIZATION, LocationInfoConst.BDLOCATION, BDLocationException.ERROR_INIT_LOCATION));
        return false;
    L11:
        return false;
    }

    public final boolean e(Object r100) {
        if (r100 != null) goto L4;
        return false;
    L4:
        if (this.f507978k == null) goto L9;
        return true;
    L9:
        return false;
    }

    public final BDLocation j(LocationOption r100) throws BDLocationException {
        CountDownLatch r101 = new CountDownLatch(1);
        BDLocation[] r102 = new BDLocation[1];
        BDLocationException[] r103 = new BDLocationException[1];
        v(new a(r102, r101, r103), r100, null, null);
        r101.await(r100.getLocationTimeOutMs(), TimeUnit.MILLISECONDS);     // Catch: InterruptedException -> L9
        BDLocationException r104 = r103[0];
        if (r104 == null) goto L7;
        throw r104;
    L7:
        return r102[0];
    L9:
        e = move-exception;
        throw new BDLocationException(e, "Android", "0");
    }

    public final void x(String r100) {
        if (BDLocationConfig.isSensorContinuousCollectEnabled() == true) goto L7;
        Logger.i("BDLocationService.unregisterContinuousSensorsForBusiness: collect disable.");
        return;
    L7:
        if (TextUtils.isEmpty(r100) == false) goto L9;
        String r101 = "__legacy_continuous_sensor_business__";
    L11:
        if (((HashSet) this.f507974g).remove(r101) == true) goto L15;
        Logger.i("BDLocationService.unregisterContinuousSensorsForBusiness: skip non-navigation business, businessId=" + r100);
        return;
    L15:
        if (((HashSet) this.f507974g).isEmpty() == true) goto L19;
        Logger.i("BDLocationService.unregisterContinuousSensorsForBusiness: keep sensors for remaining navigation businesses=" + this.f507974g);
        return;
    L19:
        if (BDLocationConfig.isSensorContinuousCollectEnabled() == true) goto L21;
        Logger.i("BDLocationService.unregisterContinuousSensors: collect disable.");
        return;
    L21:
        Logger.i("BDLocationService.unregisterContinuousSensors: start unregister continuous sensors.");
        SensorInfoManager r102 = SensorInfoManager.getInstance();
        if (BDLocationConfig.isSensorAccelerometerEnabled() == false) goto L25;
        r102.unregisterListener(1);
    L25:
        if (BDLocationConfig.isSensorGyroscopeEnabled() == false) goto L28;
        r102.unregisterListener(2);
    L28:
        if (BDLocationConfig.isSensorMagnetometerEnabled() == false) goto L31;
        r102.unregisterListener(3);
    L31:
        if (BDLocationConfig.isSensorBarometerEnabled() == false) goto L34;
        r102.unregisterListener(4);
    L34:
        if (BDLocationConfig.isSensorLightEnabled() == false) goto L37;
        r102.unregisterListener(99);
    L37:
        if (BDLocationConfig.isSensorDopEnabled() == false) goto L40;
        NMEAInfoManager.getInstance().unregisterNmeaListener();
    L40:
        if (BDLocationConfig.isSensorGnssEnabled() == false) goto L42;
        GnssInfoManager.getInstance().unregisterGnssCallback();
    L42:
        Logger.i("BDLocationService.unregisterContinuousSensors: finish.");
        return;
    L9:
        r101 = r100;
        goto L11
    }

    public static void c(k r110, LocationOption r111) {
        r110.getClass();
        if (BDLocationConfig.isSensorContinuousCollectEnabled() == true) goto L5;
        Logger.i("BDLocationService.registerContinuousSensorsForBusiness: collect disable.");
        return;
    L5:
        if (r111 != null) goto L7;
        String r100 = null;
    L9:
        if (TextUtils.isEmpty(r100) == false) goto L11;
        String r101 = "__legacy_continuous_sensor_business__";
    L13:
        if (((HashSet) r110.f507974g).add(r101) == true) goto L16;
        Logger.i("BDLocationService.registerContinuousSensorsForBusiness: already active, businessId=" + r100);
        return;
    L16:
        if (((HashSet) r110.f507974g).size() <= 1) goto L19;
        Logger.i("BDLocationService.registerContinuousSensorsForBusiness: reuse active sensors, activeNavigationBusinessIds=" + r110.f507974g);
        return;
    L19:
        if (BDLocationConfig.isSensorContinuousCollectEnabled() == true) goto L21;
        Logger.i("BDLocationService.registerContinuousSensors: collect disable.");
        return;
    L21:
        Logger.i("BDLocationService.registerContinuousSensors: start register continuous sensors.");
        SensorInfoManager r112 = SensorInfoManager.getInstance();
        boolean r102 = BDLocationConfig.isSensorAccelerometerEnabled();
        boolean r103 = BDLocationConfig.isSensorGyroscopeEnabled();
        boolean r104 = BDLocationConfig.isSensorMagnetometerEnabled();
        boolean r105 = BDLocationConfig.isSensorBarometerEnabled();
        boolean r106 = BDLocationConfig.isSensorLightEnabled();
        boolean r107 = BDLocationConfig.isSensorDopEnabled();
        boolean r108 = BDLocationConfig.isSensorGnssEnabled();
        Logger.i("BDLocationService.registerContinuousSensors: config switches - accel=" + r102 + ", gyro=" + r103 + ", magnetometer=" + r104 + ", pressure=" + r105 + ", light=" + r106 + ", dop=" + r107 + ", gnss=" + r108);
        if (r102 == false) goto L24;
        r112.registerListener(1);
    L24:
        if (r103 == false) goto L26;
        r112.registerListener(2);
    L26:
        if (r104 == false) goto L28;
        r112.registerListener(3);
    L28:
        if (r105 == false) goto L30;
        r112.registerListener(4);
    L30:
        if (r106 == false) goto L32;
        r112.registerListener(99);
    L32:
        if (r107 == false) goto L35;
        if (r111 == null) goto L35;
        NMEAInfoManager.getInstance().registerNmeaListener(r111.getBpeaCert());
    L35:
        if (r108 == false) goto L38;
        if (r111 == null) goto L38;
        GnssInfoManager.getInstance().registerGnssCallback(r111.getBpeaCert());
    L38:
        Logger.i("BDLocationService.registerContinuousSensors: finish.");
        return;
    L11:
        r101 = r100;
        goto L13
    L7:
        r100 = r111.getBusinessId();
        goto L9
    }

    public static void s(l0 r100, BDLocationException r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        AppExecutors.getInstance().mainThread().execute(new l84.c(r100, r101));
    }

    public static void t(String r100, l0 r101) {
        Logger.i("checkAbleLocation is not allowed, error code is:" + r100);
        s(r101, new BDLocationException(BDLocationExceptionMessage.NON_ALLOWED_MESSAGE, LocationInfoConst.BDLOCATION, r100));
    }

    public static LocationOption u(JSONObject r100, LocationOption r101) {
        Logger.i("BDLocationService.setCheckParams: " + r100);
        if (r100 == null) goto L18;
        if (r101 != null) goto L6;
        r101 = new LocationOption();
    L6:
        r101.setUpload(r100.optBoolean("single_is_upload", true));
        long r102 = r100.optInt("cache_time", 300000);
        boolean r103 = r100.optBoolean("use_cache_time", false);
        if (r102 <= 0) goto L14;
        if (r103 == true) goto L14;
        j84.a r104 = j84.a.a();
        if (r104.f497710d == 0) goto L12;
        long r105 = r104.f497710d;
    L13:
        r102 = r105 + 1000;
        goto L14
    L12:
        r105 = BDLocationConfig.getUploadInterval();
    L14:
        r101.setMaxCacheTime(r102);
        r101.setLocationTimeOutMs(r100.optLong("time_out", 30000));
        if (r100.has("trigger_type") == false) goto L17;
        r101.setTriggerType(r100.optInt("trigger_type", 1));
    L17:
        r101.setInterval(r100.optInt(LocationMonitorConst.LOCATION_INTERVAL, 1000));
        r101.setGeocodeMode(r100.optInt("geocode_mode", 1));
        r101.setAccuracyLevel(r100.optInt("accuracy_level", 4));
        r101.setLocateType(r100.optInt(LocationMonitorConst.LOCATE_TYPE, 3));
    L18:
        return r101;
    }

    public final boolean h(LocationOption r100, boolean r101) {
        if (r101 == false) goto L7;
        Logger.i("canMergeLocation: cacheLocationValidity is true, return false.");
        return false;
    L7:
        if (r100.isDownGradeLocation() == false) goto L11;
        Logger.i("canMergeLocation: isDownGradeLocation is true, return false.");
        return false;
    L11:
        if (r100.isOnceLocation() == false) goto L28;
        d r102 = this.f507980m;
        LocationOption r103 = r102.f507999b;
        if (r103 != null) goto L15;
    L25:
        boolean r104 = true;
    L26:
        if (r104 == false) goto L28;
        return true;
    L15:
        if (r103.isLatestAdminVersion() == r100.isLatestAdminVersion()) goto L17;
        Logger.i("canMergeLocation: diff AdminVersion, return false.");
    L24:
        r104 = false;
        goto L26
    L17:
        Boolean r105 = r102.f507999b.getAcceptLightLocationResult();
        Boolean r106 = r100.getAcceptLightLocationResult();
        if (r105 != null) goto L22;
        if (r106 == null) goto L25;
        Logger.i("canMergeLocation: diff acceptLightLocationResult, return false.");
        goto L24
    L22:
        if (r105.equals(r106) == true) goto L25;
        Logger.i("canMergeLocation: diff acceptLightLocationResult, return false.");
    L28:
        Logger.i("canMergeLocation: not merge, continuous location or not support, return false.");
        return false;
    }

    public final void i(Object r210, LocationOption r211) {
        long r100 = System.currentTimeMillis();
        LocationManager r101 = (LocationManager) this.f507970c.getSystemService("location");
        Location r102 = BDLocationExtrasService.getBPEAManager().getLastKnownLocation(r101, GeocodeSearch.GPS, r210);
        if (r102 != null) goto L5;
    L7:
        boolean r103 = true;
    L9:
        if (r102 == null) goto L11;
        long r110 = System.currentTimeMillis() - r102.getTime();
    L12:
        long r111 = System.currentTimeMillis() - r100;
        long r112 = System.currentTimeMillis();
        Location r104 = BDLocationExtrasService.getBPEAManager().getLastKnownLocation(r101, "network", r210);
        if (r104 != null) goto L15;
    L17:
        boolean r212 = r103;
    L18:
        if (r104 == null) goto L20;
        long r113 = System.currentTimeMillis() - r104.getTime();
    L21:
        r211.setLastLocationEntity(new LastLocationEntity(r104, r102, System.currentTimeMillis() - r112, r111, System.currentTimeMillis() - r100, r113, r110, r212));
        return;
    L20:
        r113 = -1;
        goto L21
    L15:
        if (LocationUtil.convertLocationToGCJ_O2(r104, "wgs84") == true) goto L17;
        Logger.i("collectLastKnownLocation: lastNetworkLocation convertLocationToGCJ_O2 error");
        r212 = false;
        goto L18
    L11:
        r110 = -1;
        goto L12
    L5:
        if (LocationUtil.convertLocationToGCJ_O2(r102, "wgs84") == true) goto L7;
        Logger.i("collectLastKnownLocation: lastGpsLocation convertLocationToGCJ_O2 error");
        r103 = false;
        goto L9
    }

    public final BDLocation n(Object r100, boolean r101) throws BDLocationException {
        Logger.i("getLastKnowLocation start");
        String r102 = LocationUtil.allowUseLocation(r101);
        Logger.i("getLastKnowLocation allowLocation");
        if ("1".equals(r102) == false) goto L19;
        if (e(r100) == false) goto L16;
        BPEACertCheckResult r103 = BDLocationExtrasService.getBPEAManager().checkAndTranslateCert(r100, "getLastKnowLocation");
        Logger.i("getLastKnowLocation checkAndTranslateCert");
        if (r103 == null) goto L11;
        JSONObject r104 = r103.getParams();
        if (r104 == null) goto L11;
        int r105 = r104.optInt("accuracyLevel", 0);
    L12:
        BDLocation r106 = o(r105);
        if (r106 == null) goto L15;
        r106.setCache(true);
    L15:
        Logger.i("getLastKnowLocation end");
        return r106;
    L11:
        r105 = -1;
        goto L12
    L16:
        return null;
    L19:
        throw new BDLocationException(BDLocationExceptionMessage.NON_ALLOWED_MESSAGE, LocationInfoConst.BDLOCATION, r102);
    }

    public final BDLocation p(LocationOption r100, LocationCacheInfo r101) {
        if (r100.isOnceLocation() == true) goto L6;
        Logger.i("LocationCache MaxCacheTime： " + r100.getMaxCacheTime());
        return null;
    L6:
        if (r101 != null) goto L8;
        r101 = this.f507968a.fastGetLocationCacheUnsafe();
    L8:
        if (r101 != null) goto L11;
        Logger.i("LocationCache cacheInfo is null");
        return null;
    L11:
        BDLocation r102 = r101.getLatestLocation();
        if (r102 != null) goto L14;
    L24:
        Logger.i("LocationCache cache is null");
        return null;
    L14:
        if (LocationUtil.isEmpty(r102) == true) goto L24;
        if (Boolean.FALSE.equals(r100.getAcceptLightLocationResult()) == true) goto L19;
    L22:
        r102.setCache(true);
        Logger.i("LocationCache: cache");
        return r102;
    L19:
        if (LocationInfoConst.LIGHT.equals(r102.getLocationSDKName()) == false) goto L22;
        Logger.i("LocationCache reject light location cache.");
        return null;
    }

    public final void w(String r100, int r101) {
        ((HashMap) this.f507977j).remove(r100);
        if (r(r101) == false) goto L7;
        BaseLocate r102 = this.f507975h;
        if (r102 == null) goto L11;
        r102.stopLocationForBusiness(r100);
        Logger.i("BDLocationService.stopBusinessLocationByLocateType byte fusion continuous completed: " + r100);
        return;
    L11:
        return;
    L7:
        BaseLocate r103 = this.f507973f;
        if (r103 == null) goto L13;
        r103.stopLocationForBusiness(r100);
        x(r100);
        Logger.i("BDLocationService.stopBusinessLocationByLocateType continuous completed: " + r100);
        return;
    }

    public static void a(k r100, LocationOption r101, BDLocation r102) {
        r100.getClass();
        LocationMonitor.locationTraceLogBegin(r101.getLocationTraceLogger(), LocationMonitorConst.LOCATION_RESET_LOCATE_TYPE_DURATION);
        boolean r103 = LocationUtil.isChineseRegion(r102);
        Logger.i("getLocateType check region isChineseRegion:" + r103);
        r101.setChineseRegion(r103);
        if (r103 == true) goto L5;
        r101.setLocateType(0);
    L5:
        LocationMonitor.locationTraceLogEnd(r101.getLocationTraceLogger(), LocationMonitorConst.LOCATION_RESET_LOCATE_TYPE_DURATION);
    }

    public static void b(k r100, LocationOption r101, int r102) {
        r100.getClass();
        if (r101 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r101.getBusinessId()) == true) goto L15;
        String r103 = r101.getBusinessId();
        Integer r104 = (Integer) ((HashMap) r100.f507976i).get(r103);
        if (r104 != null) goto L10;
    L12:
        ((HashMap) r100.f507976i).put(r103, Integer.valueOf(r102));
        ((HashMap) r100.f507977j).put(r103, r101);
        Logger.i("BDLocationService.recordBusinessContinuousLocateType businessId: " + r103 + ", locateType: " + r102);
        return;
    L10:
        if (r(r104.intValue()) == r(r102)) goto L12;
        r100.w(r103, r104.intValue());
        Logger.i("BDLocationService.recordBusinessContinuousLocateType stop previous business location, businessId: " + r103 + ", previousLocateType: " + r104 + ", newLocateType: " + r102);
        goto L12
    }

    public static boolean d(boolean r100, LocationOption r101, l0 r102) {
        LBSLightLocationTraceLogger r103 = null;
        if (r101 != null) goto L5;
        LBSLightLocationTraceLogger r104 = null;
    L6:
        LocationMonitor.lbsLightLocationTraceMetricBegin(r104, LBSLightLocationTraceLogger.CHECK_ABLE_LOCATION);
    L15:
        th = move-exception;
        if (r101 == null) goto L34;
        r103 = r101.getLBSLightLocationTraceLogger();
    L34:
        LocationMonitor.lbsLightLocationTraceMetricEnd(r103, LBSLightLocationTraceLogger.CHECK_ABLE_LOCATION);
        throw th;
    L8:
        if (q(r102) == true) goto L18;
        Logger.i("Must be called after BDLocation initialization!");     // Catch: Throwable -> L15
        if (r101 == null) goto L13;
        r103 = r101.getLBSLightLocationTraceLogger();
    L13:
        LocationMonitor.lbsLightLocationTraceMetricEnd(r103, LBSLightLocationTraceLogger.CHECK_ABLE_LOCATION);
        return false;
    L18:
        String r105 = LocationUtil.allowUseLocation(r100, false, true);     // Catch: Throwable -> L15
        if ("1".equals(r105) == true) goto L26;
        t(r105, r102);     // Catch: Throwable -> L15
        if (r101 == null) goto L24;
        r103 = r101.getLBSLightLocationTraceLogger();
    L24:
        LocationMonitor.lbsLightLocationTraceMetricEnd(r103, LBSLightLocationTraceLogger.CHECK_ABLE_LOCATION);
        return false;
    L26:
        if (r101 == null) goto L29;
        r103 = r101.getLBSLightLocationTraceLogger();
    L29:
        LocationMonitor.lbsLightLocationTraceMetricEnd(r103, LBSLightLocationTraceLogger.CHECK_ABLE_LOCATION);
        return true;
    L5:
        r104 = r101.getLBSLightLocationTraceLogger();
        goto L6
    }

    public static BDLocation m(int r100, boolean r101, boolean r102) throws BDLocationException {
        g(r101);
        String r103 = LocationUtil.allowUseLocation(r102);
        if ("1".equals(r103) == false) goto L7;
        return o(r100);
    L7:
        throw new BDLocationException(BDLocationExceptionMessage.NON_ALLOWED_MESSAGE, LocationInfoConst.BDLOCATION, r103);
    }

    public final void y(String r100, String r101, boolean r102) {
        Logger.i("BDLocationService.updatingNavigationLocationConfig: businessId=" + r100 + ", navigationIdEmpty=" + TextUtils.isEmpty(r101) + ", needUpload=" + r102);
        f507966q.post(new c(this, r100, r101, r102));
    }

    public static boolean f(BDLocation r100, LocationOption r101, LocateReasonEntity r102, boolean r110) {
        if (r100 != null) goto L9;
        Logger.i("LocationCache IS NULL");
        if (r102 == null) goto L7;
        r102.setReasonCode(0);
    L7:
        return false;
    L9:
        if (r101.getGeocodeMode() == 0) goto L17;
        if (r100.hasAddress() == true) goto L17;
        Logger.i("LocationCache NO_GEOCODE");
        if (r102 == null) goto L15;
        r102.setReasonCode(1);
    L15:
        return false;
    L17:
        if (LocationUtil.checkCacheTime(r100.getLocationMs(), r101.getMaxCacheTime(), TextUtils.isEmpty(r101.getExtra())) == true) goto L23;
        Logger.i("LocationCache checkCacheTime is false");
        if (r102 == null) goto L21;
        r102.setReasonCode(2);
    L21:
        return false;
    L23:
        if (BDLocationConfig.getDisableTailLocateOptimizeSource().contains(r101.getUploadSource()) == false) goto L25;
    L31:
        if (r102 == null) goto L33;
        r102.setReasonCode(3);
    L33:
        return true;
    L25:
        if (BDLocationConfig.enableTailLocateOptimize() == false) goto L31;
        if (r110 == true) goto L31;
        Logger.i("LocationCache cache is not recommend, bpea:" + r101.getUploadSource());
        if (r102 == null) goto L30;
        r102.setReasonCode(4);
    L30:
        return false;
    }

    public final void v(final BDLocationCallback r210, LocationOption r211, LocationTraceManager.c r212, LocationTraceManager.a r213) {
        if (r211 != null) goto L6;
        Logger.e("BDLocationService.startLocation failed: mOption == null.");
        return;
    L6:
        r211.startLocationElapsedRealtimeMillis = SystemClock.elapsedRealtime();
        r211.startLocationTimestampInMillis = System.currentTimeMillis();
        Logger.i("location-trace-core set startLocationTimestampInMillis: " + r211.startLocationTimestampInMillis);
        r211.setLocateId(System.currentTimeMillis() + "" + this.f507979l.incrementAndGet());
        if (r211.getLBSLightLocationTraceLogger() != null) goto L9;
        LBSLightLocationTraceLogger r100 = new LBSLightLocationTraceLogger();
        r100.begin("total");
        r100.begin("prepare");
        r100.begin(LBSLightLocationTraceLogger.SUB_PREPARE);
        r211.setLBSLightLocationTraceLogger(r100);
    L9:
        final LBSLightLocationTraceLogger r110 = r211.getLBSLightLocationTraceLogger();
        LocationMonitor.lbsLightLocationTraceMetricEnd(r110, LBSLightLocationTraceLogger.SUB_PREPARE);
        Logger.i("BDLocationService.startLocation is DownGradeLocation:" + r211.isDownGradeLocation());
        LocationMonitor.lbsLightLocationTraceMetricBegin(r110, LBSLightLocationTraceLogger.WRAP_LOCATION_OPTION);
        if (r211.isDownGradeLocation() == false) goto L12;
        LocationOption r111 = new LocationOption(r211);
    L54:
        LocationTraceManager r101 = LocationTraceManager.b.f199957a;
        r101.b(r212, r111);
        r101.a(r213, r111);
        if (BDLocationConfig.enableAcceptLightLocationParam() == true) goto L57;
        r111.setAcceptLightLocationResult(null);
    L57:
        Logger.i("after check cert, locateType: " + r111.getLocateType());
        String r102 = r111.getUploadSource();
        IDYHostInfoProvider r103 = BDLocationConfig.getDYHostInfoProvider();
        if (r103 != null) goto L71;
        Context r104 = BDLocationConfig.getContext();
        if (r104 != null) goto L62;
    L65:
        StringBuilder r105 = new StringBuilder("refreshSearchLocationCacheTimeIfNeed returned: dyHostInfoProvider == null, context == null: ");
        if (r104 != null) goto L68;
        boolean r106 = true;
    L69:
        r105.append(r106);
        Logger.i(r105.toString());
    L84:
        if ("bpea-light_navigation".equals(r102) == true) goto L87;
        Logger.i("needn't refresh maxCacheTime for: " + r102);
    L90:
        long r107 = r111.getHostSwitchThreadDuration();
        if (r107 <= 0) goto L93;
        LocationMonitor.lbsLightLocationTracePutMetricData(r110, LocationMonitorConst.HOST_SWITCH_THREAD_DURATION, r107);
        LocationMonitor.locationTracePutMetricData(r111.getLocationTraceLogger(), LocationMonitorConst.HOST_SWITCH_THREAD_DURATION, r107);
    L93:
        LocationMonitor.lbsLightLocationTraceMetricEnd(r110, LBSLightLocationTraceLogger.WRAP_LOCATION_OPTION);
        LocationMonitor.lbsLightLocationTraceMetricBegin(r110, LBSLightLocationTraceLogger.LOCATION_CACHE);
        LocationMonitor.lbsLightLocationTraceMetricBegin(r110, LBSLightLocationTraceLogger.GET_SUITABLE_CACHE);
        LocationCacheInfo r108 = this.f507968a.fastGetLocationCacheUnsafe();
        BDLocation r109 = p(r111, r108);
        LocationMonitor.lbsLightLocationTraceMetricEnd(r110, LBSLightLocationTraceLogger.GET_SUITABLE_CACHE);
        LocationMonitor.lbsLightLocationTraceMetricBegin(r110, LBSLightLocationTraceLogger.CHECK_CACHE_VALIDITY);
        LocateReasonEntity r112 = new LocateReasonEntity();
        boolean r113 = r108.isRecommendLocation();
        boolean r114 = f(r109, r111, r112, r113);
        Logger.i("BDLocationService.startLocation cacheLocationValidity:" + r114);
        Logger.i("enableTailLocateOptimize:" + BDLocationConfig.enableTailLocateOptimize() + " isRecommendLocation:" + r113);
        LocationMonitor.locationTracePutCategoryData(r111.getLocationTraceLogger(), LocationMonitorConst.ENABLE_TAIL_LOCATE_OPTIMIZE, Boolean.valueOf(BDLocationConfig.enableTailLocateOptimize()));
        LocationMonitor.locationTracePutCategoryData(r111.getLocationTraceLogger(), LocationMonitorConst.IS_RECOMMEND_LOCATION, Boolean.valueOf(r113));
        LocationMonitor.locationTracePutCategoryData(r111.getLocationTraceLogger(), LocationMonitorConst.MAX_WAIT_GPS_TIME_MILLIS, Long.valueOf(BDLocationConfig.maxWaitGPSTimeMillis()));
        LocationTraceLogger r115 = r111.getLocationTraceLogger();
        Boolean r116 = r111.getAcceptLightLocationResult();
        if (r116 != null) goto L96;
        boolean r117 = BDLocationConfig.enablePreLocationCallback();
    L97:
        LocationMonitor.locationTracePutCategoryData(r115, LocationMonitorConst.PRE_LOCATION_CALLBACK, Boolean.valueOf(r117));
        LocationMonitor.lbsLightLocationTraceMetricEnd(r110, LBSLightLocationTraceLogger.CHECK_CACHE_VALIDITY);
        LocationMonitor.lbsLightLocationTraceMetricEnd(r110, LBSLightLocationTraceLogger.LOCATION_CACHE);
        final l0 r118 = new l0(r210, r111, this.f507980m, this.f507972e, f507966q, r213);
        LocationMonitor.lbsLightLocationTraceMetricBegin(r110, LBSLightLocationTraceLogger.LOCATION_MERGE);
        LocationMonitor.lbsLightLocationTraceMetricBegin(r110, LBSLightLocationTraceLogger.LOCATION_MERGE_SYNC);
        StationarySceneCacheInfo r119 = new StationarySceneCacheInfo();
        r119.setLocateId(r111.getLocateId());
        r111.setStationarySceneCacheInfo(r119);
        if (r111.isDownGradeLocation() == false) goto L100;
    L105:
        d r120 = this.f507980m;
        monitor-enter(r120);
        LocationMonitor.lbsLightLocationTraceMetricEnd(r110, LBSLightLocationTraceLogger.LOCATION_MERGE_SYNC);     // Catch: Throwable -> L117
        if (h(r111, r114) == false) goto L121;
        d r121 = this.f507980m;     // Catch: Throwable -> L117
        if (r121.f507998a == false) goto L119;
        Logger.i("location-trace-core location trace is start");     // Catch: Throwable -> L117
        final BDLocation r122 = this.f507980m.f508000c;     // Catch: Throwable -> L117
        if (r122 == null) goto L114;
        this.f507972e.post(new l84.a(r210, r122));     // Catch: Throwable -> L117
        Logger.i("location-trace-core location trace is start and already has light location result, callback immediately.");     // Catch: Throwable -> L117
    L115:
        monitor-exit(r120);     // Catch: Throwable -> L117
        return;
    L114:
        r111.isCallbackThroughLocateTrace = true;     // Catch: Throwable -> L117
        ((ArrayList) this.f507980m.f508001d).add(r210);     // Catch: Throwable -> L117
        Logger.i("location-trace-core location trace is start but not have light location result, merge.");     // Catch: Throwable -> L117
        goto L115
    L119:
        r121.f507999b = r111;     // Catch: Throwable -> L117
        r121.f507998a = true;     // Catch: Throwable -> L117
        r121.f508000c = null;     // Catch: Throwable -> L117
        Logger.i("location-trace-core LocateTrace.onLocateStart: " + r111.getLocateId());     // Catch: Throwable -> L117
        r111.isCallbackThroughLocateTrace = true;     // Catch: Throwable -> L117
        ((ArrayList) this.f507980m.f508001d).add(r210);     // Catch: Throwable -> L117
        Logger.i("no locating task, set locate start: true.");     // Catch: Throwable -> L117
    L121:
        monitor-exit(r120);     // Catch: Throwable -> L117
        LocationMonitor.lbsLightLocationTraceMetricEnd(r110, LBSLightLocationTraceLogger.LOCATION_MERGE);
        if (BDLocationConfig.isMockEnable() == false) goto L125;
        Logger.i("needn't perform lbs light location: mock location.");
    L138:
        List<ScanResult> r123 = null;
    L153:
        LocationMonitor.locationTraceLogBegin(r111.getLocationTraceLogger(), LocationMonitorConst.LOCATION_THREAD_SWITCH_DURATION);
        f507966q.post(new b(this, r111, r109, r118, r114, r108, r112, r211));
        if (r123 != null) goto L156;
    L165:
        Logger.i("location-trace-core needn't perform lbs light location: lbsLightLocationScanResults is (null || empty).");
        return;
    L156:
        if (r123.isEmpty() == true) goto L165;
        LocationMonitor.lbsLightLocationTraceMetricEnd(r110, "prepare");
        LocationMonitor.lbsLightLocationTraceMetricBegin(r110, LBSLightLocationTraceLogger.NETWORK_TOTAL);
        if (Looper.myLooper() == Looper.getMainLooper()) goto L160;
        boolean r124 = true;
    L161:
        LocationMonitor.lbsLightLocationTracePutCategoryData(r110, LBSLightLocationTraceLogger.SWITCH_THREAD, Boolean.valueOf(!r124));
        LocationMonitor.lbsLightLocationTracePutCategoryData(r110, "thread_name", ThreadMethodProxy.currentThread().getName());
        LocationMonitor.lbsLightLocationTraceMetricBegin(r110, LBSLightLocationTraceLogger.SWITCH_THREAD_SECOND_TIME);
        final LocationOption r125 = r111;
        final List<ScanResult> r126 = r123;
        Runnable r127 = new l84.b(this, r110, r125, r126, r118);
        if (r124 == false) goto L164;
        r127.run();
        return;
    L164:
        this.f507971d.post(r127);
        return;
    L160:
        r124 = false;
        goto L161
    L125:
        if (r114 == false) goto L128;
        Logger.i("needn't perform lbs light location: cache location is valid.");
        goto L138
    L128:
        if (r111.isOnceLocation() == true) goto L131;
        Logger.i("lbs light location is disabled in continuous location.");
        goto L138
    L131:
        if (r111.isDownGradeLocation() == false) goto L134;
        Logger.i("lbs light location is disabled in downgrade location.");
        goto L138
    L134:
        if (LocationUtil.isUseByteLocationPolicy(r102) == false) goto L136;
    L139:
        Logger.i("lbs light location is enable, bpea: " + r102);
        LocationMonitor.lbsLightLocationTracePutCategoryData(r110, LBSLightLocationTraceLogger.BPEA, r102);
        List<ScanResult> r128 = null;
        if (d(false, r111, null) == true) goto L142;
        Logger.i("RestrictedMode|background|LocationServer|permission unable");
    L152:
        r123 = r128;
        goto L153
    L142:
        LocationMonitor.lbsLightLocationTraceMetricBegin(r110, LBSLightLocationTraceLogger.GET_WIFI_MODULE);
        Logger.i("performLBSLightLocationFirstPart: before getWifiScanResultsForLBSLightLocation.");
    L148:
        th = move-exception;
        th.printStackTrace();
        if (r110 == null) goto L152;
        Logger.e("lbs light location failed: get wifi scan results failed: " + th, th);
        r110.putCategoryData(LBSLightLocationTraceLogger.IS_GET_WIFI_SUCCESS, Boolean.FALSE);
        r110.reportLBSLightLocationFailed(BDLocationException.ERROR_CODE_LBS_LIGHT_GET_WIFI_INFO_MODULE_FAILED, "lbs light location failed: get wifi scan results failed: " + th);
        goto L152
    L144:
        if (BDLocationConfig.enableUploadLastLocationInfo() == false) goto L146;
        i(r111.getBpeaCert(), r111);     // Catch: Throwable -> L148
    L146:
        r128 = LBSLightWifiUtils.getWifiScanResultsForLBSLightLocation(r110, r111);     // Catch: Throwable -> L148
        Logger.i("performLBSLightLocationFirstPart: after getWifiScanResultsForLBSLightLocation.");
        LocationMonitor.lbsLightLocationTraceMetricEnd(r110, LBSLightLocationTraceLogger.GET_WIFI_MODULE);
        LocationMonitor.lbsLightLocationTracePutCategoryData(r110, LBSLightLocationTraceLogger.IS_GET_WIFI_SUCCESS, Boolean.TRUE);
        goto L152
    L136:
        if (BDLocationConfig.isEnableLocationOpt(r102) == true) goto L139;
        Logger.i("not enable lbs light location with bpea: " + r102);
    L117:
        th = move-exception;
        throw th;
    L100:
        if (r111.isOnceLocation() == false) goto L105;
        boolean r129 = LocationUtil.checkStationaryScenePolicyBeforeLocation(r111.getUploadSource(), r109, r111.getLocationTraceLogger());
        Logger.i("checkStationaryScenePolicyBeforeLocation hitStationaryScene:" + r129);
        LocationMonitor.locationTracePutCategoryData(r111.getLocationTraceLogger(), LocationMonitorConst.HIT_STATIONARY_SCENE, Boolean.valueOf(r129));
        r111.setHitStationaryScene(r129);
        if (r129 == false) goto L105;
        LocationMonitor.locationTraceLogBegin(r111.getLocationTraceLogger(), "total_duration");
        SensorInfoManager.getInstance().registerListener(5);
        Logger.i("location-trace-core location-trace-core isHitStationaryScene");
        AppExecutors.getInstance().mainThread().execute(new q(r118, r109));
        return;
    L96:
        r117 = r116.booleanValue();
        goto L97
    L87:
        if (r111.isOnceLocation() == false) goto L89;
        Logger.i("needn't refresh maxCacheTime for onceLocation.");
        goto L90
    L89:
        Logger.i("change maxCacheTime to 0L for: " + r102);
        r111.setMaxCacheTime(0);
        goto L90
    L68:
        r106 = false;
        goto L69
    L62:
        if ("com.ss.android.ugc.aweme".equals(r104.getPackageName()) == false) goto L65;
        Logger.e("refreshSearchLocationCacheTimeIfNeed returned: unexpected dyHostInfoProvider == null in DY.");
        goto L84
    L71:
        if (r103.isPersonalizedRecommendationEnable() == true) goto L74;
        Logger.i("refreshSearchLocationCacheTimeIfNeed returned: personalized recommendation not enabled.");
        goto L84
    L74:
        if ("bpea-search_requset_net_trytolocate_cache_first".equals(r102) == true) goto L77;
        Logger.i("needn't refresh location cache time, bpea is " + r102);
        goto L84
    L77:
        if (r111.isOnceLocation() == true) goto L79;
        Logger.i("needn't refresh location cache time: continuous location");
        goto L84
    L79:
        long r130 = BDLocationConfig.getSearchLocationCacheTime();
        if (r130 <= 0) goto L82;
        r111.setMaxCacheTime(r130);
        Logger.i("refresh search location cache time: " + r130 + ", bpea: " + r102);
        goto L84
    L82:
        Logger.i("needn't refresh location cache time: searchLocationMaxCacheTime <= 0");
        goto L84
    L12:
        Logger.i("BDLocationService.startLocation, before checkCert, locateType: " + r211.getLocateType());
        LocationMonitor.lbsLightLocationTraceMetricBegin(r110, LBSLightLocationTraceLogger.CHECK_CERT);
    L44:
        e = move-exception;
        e.printStackTrace();
        LocationTraceManager.b.f199957a.f(r213, e);
        if (r210 == null) goto L48;
        r210.onError(e);
    L48:
        LocationOption r131 = null;
    L49:
        LocationMonitor.lbsLightLocationTraceMetricEnd(r110, LBSLightLocationTraceLogger.CHECK_CERT);
        if (r131 != null) goto L53;
        Logger.i("cert check error");
        return;
    L53:
        r111 = new LocationOption(r131);
        goto L54
    L14:
        if (e(r211.getBpeaCert()) == false) goto L42;
        BPEACertCheckResult r132 = this.f507978k.checkAndTranslateCert(r211.getBpeaCert(), r211.getBpeaAction());     // Catch: BDLocationException -> L44
        if (r132 == null) goto L18;
        r131 = u(r132.getParams(), r211);     // Catch: BDLocationException -> L44
    L19:
        String r133 = this.f507978k.getBpeaToken(r131.getBpeaCert());     // Catch: BDLocationException -> L44
        String r134 = BDLocationConfig.getLocationCacheTokenWhiteList();     // Catch: BDLocationException -> L44
        if (BDLocationConfig.isEnableLocationCacheTokenWhiteList() == true) goto L22;
    L33:
        boolean r135 = false;
    L34:
        if (r135 == false) goto L37;
        r131.setMaxCacheTime(0);     // Catch: BDLocationException -> L44
    L37:
        if (BDLocationConfig.getHotBootLocToken().equals(r133) == false) goto L41;
        long r136 = BDLocationConfig.getHotBootCacheTime();     // Catch: BDLocationException -> L44
        if (r136 == (-1)) goto L41;
        r131.setMaxCacheTime(r136 * 1000);     // Catch: BDLocationException -> L44
    L41:
        r131.setUploadSource(r133);     // Catch: BDLocationException -> L44
        Logger.i("startLocation checkCert:" + r133);     // Catch: BDLocationException -> L44
        goto L49
    L22:
        if (TextUtils.isEmpty(r134) == true) goto L33;
        if (TextUtils.isEmpty(r133) == true) goto L33;
        String[] r137 = r134.split(",");     // Catch: BDLocationException -> L44
        int r138 = r137.length;     // Catch: BDLocationException -> L44
        int r139 = 0;
    L27:
        if (r139 >= r138) goto L32;
        if (r133.equals(r137[r139].trim()) == true) goto L33;
        r139 = r139 + 1;     // Catch: BDLocationException -> L44
        goto L27
    L32:
        r135 = true;
        goto L34
    L18:
        r131 = r211;
        goto L19
    L42:
        g(r211.isCert());     // Catch: BDLocationException -> L44
        r131 = r211;
        goto L49
    }

    public final synchronized BdGisResult k(double r100, double r101, int r110, Object r111, int r112) throws BDLocationException {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (e(r111) == false) goto L6;
        BDLocationExtrasService.getBPEAManager().checkAndTranslateCert(r111, "geocode");     // Catch: Throwable -> L9
    L6:
        new LocationOption().setTriggerType(r110);     // Catch: Throwable -> L9
        BdGisResult r102 = LocationUtil.getGeocodeResult(r100, r101, r110, r112);     // Catch: Throwable -> L9
        monitor-exit(this);
        return r102;
    }
}
