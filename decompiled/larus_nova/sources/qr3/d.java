package qr3;

import android.content.Context;
import android.location.GnssStatus;
import android.location.GpsSatellite;
import android.location.GpsStatus;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bytedance.api.location.ByteLocationClientOption;
import com.bytedance.bdlocation.BDLocation;
import com.bytedance.bdlocation.LocationUtil;
import com.bytedance.bdlocation.callback.LocationUploadCallback;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.bdlocation.entity.LocationExtraBean;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.bdlocation.exception.BDLocationExceptionMessage;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.network.model.LocationUploadExtra;
import com.bytedance.bdlocation.network.model.WifiInfo;
import com.bytedance.bdlocation.network.response.LocInfoRspData;
import com.bytedance.bdlocation.network.response.LocationResp;
import com.bytedance.bdlocation.thread.AppExecutors;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes14.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f534586a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final qr3.c f534587b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public LocationManager f534588c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final g f534589d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile ByteLocationClientOption f534590e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public C7382d f534591f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public f f534592g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public e f534593h;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f534594a = null;

        static {
            int[] r100 = new int[ByteLocationClientOption.LocationMode.values().length];
            f534594a = r100;
            r100[ByteLocationClientOption.LocationMode.Battery_Saving.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            f534594a[ByteLocationClientOption.LocationMode.Device_Sensors.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            f534594a[ByteLocationClientOption.LocationMode.Hight_Accuracy.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    public abstract class b implements LocationListener {
        public b() {
        }

        @Override // android.location.LocationListener
        public final void onProviderDisabled(String r100) {
            Logger.i("ByteLocationManagerImpl: BaseLocationListener onProviderDisabled() provider is " + r100);
        }

        @Override // android.location.LocationListener
        public final void onProviderEnabled(String r100) {
            Logger.i("ByteLocationManagerImpl: BaseLocationListener onProviderEnabled() provider is " + r100);
        }

        @Override // android.location.LocationListener
        public final void onStatusChanged(String r100, int r101, Bundle r102) {
            Logger.i("ByteLocationManagerImpl: BaseLocationListener onStatusChanged() status is " + r101);
        }
    }

    public class c implements LocationUploadCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ByteLocationClientOption f534595a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final BDLocation f534596b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ d f534597c;

        @Override // com.bytedance.bdlocation.callback.LocationUploadCallback
        public final void onError(String r100) {
            Logger.i("ByteLocationManagerImpl: BatterySavingLocationCallback onError! The message is " + r100);
            this.f534597c.getClass();
            this.f534597c.f534587b.d(new BDLocationException(r100, LocationInfoConst.BYTE, BDLocationException.ERROR_NETWORK_REQUEST));
        }

        public c(d r100, ByteLocationClientOption r101, BDLocation r102) {
            this.f534597c = r100;
            this.f534595a = r101;
            this.f534596b = r102;
        }

        @Override // com.bytedance.bdlocation.callback.LocationUploadCallback
        public final void onSuccess(LocationResp r100, boolean r101, WifiInfo r102) {
            if (r100 != null) goto L5;
            Logger.i("ByteLocationManagerImpl: BatterySavingLocationCallback onError");
            this.f534597c.getClass();
            this.f534597c.f534587b.d(new BDLocationException("analysis locInfoRsp error:resp is null", LocationInfoConst.BYTE, BDLocationException.ERROR_NETWORK_REQUEST));
            return;
        L5:
            Logger.i("BatterySavingLocationCallback onSuccess");
            LocInfoRspData r103 = LocationUtil.parseLocInfoRsp(r100);
            if (r103 == null) goto L10;
            Logger.i("ByteLocationManagerImpl BatterySavingLocationCallback inOutDoorStatus:" + r103.inOutDoorStatus);
            BDLocation r104 = LocationUtil.locationResultToBDLocation(this.f534596b, r103.location, r103.inOutDoorStatus, r103.inOutDoorConfidence);
            if (r104 == null) goto L11;
            r104.setLocInfoRsp(r103);
            r104.setRecommendWifiResults(r101);
            r104.setConnectedWifiInfo(r102);
        L11:
            Logger.i("ByteLocationManagerImpl: BatterySavingLocationCallback onSuccess.");
            this.f534597c.f534587b.c(r104);
            if (this.f534595a.f190172l == true) goto L15;
            Logger.i("ByteLocationManagerImpl: BatterySavingLocationCallback is continuous location. The interval is " + this.f534595a.f190161a);
            this.f534597c.f534589d.sendMessageDelayed(Message.obtain(this.f534597c.f534589d, 1, this.f534595a), this.f534595a.f190161a);
            Logger.i("performNextLocationIfNecessary interval:" + this.f534595a.f190161a);
            return;
        L15:
            return;
        L10:
            r104 = null;
            goto L11
        }
    }

    /* JADX INFO: renamed from: qr3.d$d, reason: collision with other inner class name */
    public class C7382d extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f534598a;

        public C7382d(d r100) {
            this.f534598a = r100;
        }

        @Override // android.location.LocationListener
        public final void onLocationChanged(Location r210) {
            ArrayList r110 = new ArrayList();
            Object[] r111 = {r210};
            f06.b r112 = new f06.b();
            g06.a r100 = ApiHookConfig.f245611b.get(100038);
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
            f06.d r106 = r105.preInvoke(100038, "com/bytedance/api/location/service/ByteLocationManagerImpl$DeviceSensorsLocationListener", "onLocationChanged", this, r111, "void", r112);     // Catch: Exception -> L35
            if (r106.f474982a == true) goto L17;
            r110.add(r105);     // Catch: Exception -> L35
        L17:
            if (r106.f474982a == false) goto L19;
            return;
        L19:
            Logger.i("ByteLocationManagerImpl: DeviceSensorsLocationListener onLocationChanged() and the location is " + r210);
            f r107 = this.f534598a.f534592g;
            if (r107 == null) goto L25;
            if (r107.f534605a == null) goto L25;
            Logger.i("ByteLocationManagerImpl: LocationGpsStatusListener stopCountDownTimer() is executed.");
            r107.f534605a.cancel();
        L25:
            if (Build.VERSION.SDK_INT < 24) goto L31;
            e r108 = this.f534598a.f534593h;
            if (r108 == null) goto L31;
            int r109 = e.f534599f;
            if (r108.f534600a == null) goto L31;
            Logger.i("ByteLocationManagerImpl: LocationGpsStatusListener stopCountDownTimer() is executed.");
            r108.f534600a.cancel();
        L31:
            if (r210 == null) goto L33;
            this.f534598a.getClass();
            BDLocation r115 = d.e(r210);
            this.f534598a.f534587b.c(r115);
            r115.setRecommendWifiResults(true);
            return;
        L33:
            this.f534598a.getClass();
            this.f534598a.f534587b.d(new BDLocationException(BDLocationExceptionMessage.BYTE_DEVICE_LOCATION_NULL, LocationInfoConst.BYTE, "26"));
            return;
        L14:
            r104 = r113 + 1;
            r103 = r114;
            r102 = r211;
            goto L8
        L15:
            r106 = new f06.d(false, null);
            goto L17
        L5:
            r101 = ApiHookConfig.f245613d;
            goto L6
        }
    }

    public class e extends GnssStatus.Callback {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final /* synthetic */ int f534599f = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public qr3.e f534600a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f534601b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f534602c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f534603d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ d f534604e;

        @Override // android.location.GnssStatus.Callback
        public final void onStarted() {
            if (this.f534603d == true) goto L5;
            return;
        L5:
            if (this.f534604e.f534590e == null) goto L7;
            long r100 = this.f534604e.f534590e.f190166f;
        L8:
            Logger.i("ByteLocationManagerImpl: LocationGpsStatusListener startCountDownTimer() is executed.");
            qr3.e r101 = new qr3.e(this, r100);
            this.f534600a = r101;
            r101.start();
            return;
        L7:
            r100 = 30000;
            goto L8
        }

        @Override // android.location.GnssStatus.Callback
        public final void onSatelliteStatusChanged(GnssStatus r100) {
            this.f534601b = r100.getSatelliteCount();
            int r101 = 0;
            int r102 = 0;
        L4:
            if (r101 >= this.f534601b) goto L9;
            if (r100.getCn0DbHz(r101) <= 25.0f) goto L8;
            r102 = r102 + 1;
        L8:
            r101 = r101 + 1;
            goto L4
        L9:
            this.f534602c = r102;
            Logger.i("ByteLocationManagerImpl: LocationGnssStatusCallback onSatelliteStatusChanged()" + r102);
        }

        public e(d r100, boolean r101) {
            this.f534604e = r100;
            this.f534603d = r101;
        }
    }

    public class f implements GpsStatus.Listener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public qr3.f f534605a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f534606b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f534607c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f534608d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ d f534609e;

        @Override // android.location.GpsStatus.Listener
        public final void onGpsStatusChanged(int r100) {
            LocationManager r101 = this.f534609e.f534588c;
            if (r101 != null) goto L6;
            return;
        L6:
            if (r100 != 1) goto L8;
            Logger.i("ByteLocationManagerImpl: LocationGpsStatusListener onLocationChanged() and receive GPS_EVENT_STARTED");
            if (this.f534608d == true) goto L28;
            return;
        L28:
            if (this.f534609e.f534590e == null) goto L30;
            long r102 = this.f534609e.f534590e.f190166f;
        L31:
            Logger.i("ByteLocationManagerImpl: LocationGpsStatusListener startCountDownTimer() is executed.");
            qr3.f r103 = new qr3.f(this, r102);
            this.f534605a = r103;
            r103.start();
            return;
        L30:
            r102 = 30000;
            goto L31
        L8:
            if (r100 != 2) goto L10;
            Logger.i("ByteLocationManagerImpl: LocationGpsStatusListener onLocationChanged() and receive GPS_EVENT_STOPPED");
            return;
        L10:
            if (r100 != 3) goto L12;
            Logger.i("ByteLocationManagerImpl: LocationGpsStatusListener onLocationChanged() and receive GPS_EVENT_FIRST_FIX");
            return;
        L12:
            if (r100 != 4) goto L41;
            GpsStatus r104 = r101.getGpsStatus(null);
            int r105 = r104.getMaxSatellites();
            Iterator<GpsSatellite> r106 = r104.getSatellites().iterator();
            int r107 = 0;
            int r108 = 0;
        L16:
            if (r106.hasNext() == false) goto L22;
            if (r107 >= r105) goto L22;
            if (r106.next().getSnr() <= 25.0f) goto L21;
            r108 = r108 + 1;
        L21:
            r107 = r107 + 1;
        L22:
            this.f534606b = Math.max(r107, this.f534606b);
            this.f534607c = r108;
            Logger.i("ByteLocationManagerImpl: LocationGpsStatusListener onLocationChanged() and receive GPS_EVENT_SATELLITE_STATUS, satellite count:" + r107);
            return;
        }

        public f(d r100, boolean r101) {
            this.f534609e = r100;
            this.f534608d = r101;
        }
    }

    public static class g extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<d> f534610a;

        public g(d r100) {
            super(Looper.getMainLooper());
            this.f534610a = new WeakReference(r100);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message r100) {
            super.handleMessage(r100);
            d r101 = this.f534610a.get();
            if (r101 != null) goto L6;
            Logger.i("ByteLocationManagerImpl: ByteLocationManagerImpl reference is null.");
            return;
        L6:
            int r102 = r100.what;
            if (r102 != 1) goto L9;
            removeMessages(1);
            ByteLocationClientOption r103 = (ByteLocationClientOption) r100.obj;
            Logger.i("ByteLocationManagerImpl: startLocationInternalForBatterySaving() is executed.");
            r103.f190163c = 1;
            d.b(r103, new c(r101, r103, d.e(null)));
            return;
        L9:
            if (r102 != 2) goto L11;
            removeMessages(2);
            ByteLocationClientOption r104 = (ByteLocationClientOption) r100.obj;
            r104.f190163c = 1;
            d.b(r104, new h(r101, r104));
            Logger.i("ByteLocationManagerImpl TimerHandler2");
            return;
        L11:
            if (r102 != 3) goto L19;
            removeMessages(3);
            r101.c();
            return;
        }
    }

    public class h implements LocationUploadCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ByteLocationClientOption f534611a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f534612b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ d f534613c;

        @Override // com.bytedance.bdlocation.callback.LocationUploadCallback
        public final void onError(String r100) {
            int r101 = this.f534611a.f190163c;
            Logger.i("ByteLocationManagerImpl WifiCellLocationCallback onError status:" + r101 + "--errorMsg:" + r100);
            if (r101 != 3) goto L5;
        L8:
            Logger.i("ByteLocationManagerImpl: WifiCellLocationCallback onError! The status is：" + this.f534611a.a() + "--the message is：" + r100);
            this.f534613c.getClass();
            this.f534613c.f534587b.d(new BDLocationException(r100, LocationInfoConst.BYTE, BDLocationException.ERROR_NETWORK_REQUEST));
            d.a(this.f534613c, this.f534611a);
            return;
        L5:
            if (r101 == 1) goto L8;
            Logger.i("ByteLocationManagerImpl: WifiCellLocationCallback onError! The status is %s ", this.f534611a.a());
        }

        public h(d r100, ByteLocationClientOption r101) {
            this.f534613c = r100;
            this.f534612b = 0;
            this.f534611a = r101;
            this.f534612b = System.currentTimeMillis();
        }

        @Override // com.bytedance.bdlocation.callback.LocationUploadCallback
        public final void onSuccess(LocationResp r100, boolean r101, WifiInfo r110) {
            if (r100 != null) goto L6;
            Logger.i("ByteLocationManagerImpl: WifiCellLocationCallback onError");
            this.f534613c.getClass();
            this.f534613c.f534587b.d(new BDLocationException("analysis locInfoRsp error:resp is null", LocationInfoConst.BYTE, BDLocationException.ERROR_NETWORK_REQUEST));
            return;
        L6:
            Logger.i("ByteLocationManagerImpl getLocation intervalTime:" + (System.currentTimeMillis() - this.f534612b));
            int r102 = this.f534611a.f190163c;
            Logger.i("ByteLocationManagerImpl WifiCellLocationCallback onSuccess:" + r102);
            if (r102 != 3) goto L9;
        L14:
            this.f534611a.f190163c = 6;
            Logger.i("ByteLocationManagerImpl: WifiCellLocationCallback onSuccess. The status is %s ", this.f534611a.a());
            LocInfoRspData r103 = LocationUtil.parseLocInfoRsp(r100);
            if (r103 == null) goto L19;
            Logger.i("ByteLocationManagerImpl WifiCellLocationCallback inOutDoorStatus:" + r103.inOutDoorStatus);
            this.f534613c.getClass();
            BDLocation r104 = LocationUtil.locationResultToBDLocation(new BDLocation("network", LocationInfoConst.BYTE), r103.location, r103.inOutDoorStatus, r103.inOutDoorConfidence);
            if (r104 == null) goto L20;
            r104.setLocInfoRsp(r103);
            r104.setRecommendWifiResults(r101);
            r104.setConnectedWifiInfo(r110);
        L20:
            Logger.i("ByteLocationManagerImpl: WifiCellLocationCallback onSuccess.");
            if (r104 == null) goto L23;
            this.f534613c.f534587b.c(r104);
        L24:
            d.a(this.f534613c, this.f534611a);
            return;
        L23:
            Logger.i("ByteLocationManagerImpl: WifiCellLocationCallback onError:" + r100.toString());
            String r105 = "analysis locInfoRsp error:" + r100.toString();
            this.f534613c.getClass();
            this.f534613c.f534587b.d(new BDLocationException(r105, LocationInfoConst.BYTE, BDLocationException.ERROR_NETWORK_REQUEST));
            goto L24
        L19:
            r104 = null;
            goto L20
        L9:
            if (r102 == 1) goto L14;
            if (r102 == 2) goto L14;
            Logger.i("ByteLocationManagerImpl: WifiCellLocationCallback onSuccess. The status is %s ", this.f534611a.a());
        }
    }

    public final void c() {
        LocationManager r100 = this.f534588c;
        if (r100 == null) goto L25;
        C7382d r101 = this.f534591f;     // Catch: Exception -> L20
        if (r101 != null) goto L7;
    L11:
        f r102 = this.f534592g;     // Catch: Exception -> L20
        if (r102 == null) goto L15;
        this.f534588c.removeGpsStatusListener(r102);     // Catch: Exception -> L20
        this.f534592g = null;     // Catch: Exception -> L20
    L15:
        if (Build.VERSION.SDK_INT < 24) goto L26;
        e r103 = this.f534593h;     // Catch: Exception -> L20
        if (r103 == null) goto L27;
        this.f534588c.unregisterGnssStatusCallback(r103);     // Catch: Exception -> L20
        this.f534593h = null;     // Catch: Exception -> L20
        return;
    L27:
        return;
    L26:
        return;
    L7:
        if (fna.g.d() == true) goto L9;
        r100.removeUpdates(r101);     // Catch: Exception -> L20
    L10:
        this.f534591f = null;     // Catch: Exception -> L20
        goto L11
    L9:
        r100.removeUpdates(r101);     // Catch: Exception -> L20
        nna.a.a(r101.hashCode());     // Catch: Exception -> L20
    L20:
        e = move-exception;
        Logger.i("ByteLocationManagerImpl: removeGPSLocationListener() throw an exception! The message is " + e.getMessage());
        return;
    }

    public final void d() {
        Logger.i("ByteLocationManagerImpl: stopLocation() is executed.");     // Catch: Exception -> L6
        this.f534589d.removeCallbacksAndMessages(null);     // Catch: Exception -> L6
        if (this.f534590e == null) goto L11;
        c();     // Catch: Exception -> L6
        this.f534590e.f190163c = 6;     // Catch: Exception -> L6
        this.f534590e = null;     // Catch: Exception -> L6
        return;
    L11:
        return;
    L6:
        e = move-exception;
        Logger.i("ByteLocationManagerImpl: stopLocation() throw an exception! The message is " + e.getMessage());
    }

    public d(Context r100) {
        this.f534586a = r100;
        this.f534587b = new qr3.c(AppExecutors.getInstance());
        this.f534588c = (LocationManager) r100.getSystemService("location");
        this.f534589d = new g(this);
    }

    public static BDLocation e(Location r100) {
        if (r100 == null) goto L5;
        BDLocation r101 = new BDLocation(r100, LocationInfoConst.BYTE);
        r101.setLocationType(1);
    L6:
        r101.setGeocodeSDKName(LocationInfoConst.BYTE);
        Logger.i("ByteLocationManagerImpl: transform() is executed and the result is " + r101);
        return r101;
    L5:
        r101 = new BDLocation("network", LocationInfoConst.BYTE);
        r101.setLocationType(2);
        goto L6
    }

    public static void a(d r100, ByteLocationClientOption r101) {
        r100.getClass();
        if (r101.f190172l == true) goto L6;
        r100.f534589d.sendMessageDelayed(Message.obtain(r100.f534589d, 2, r101), r101.f190161a);
        Logger.i("ByteLocationManagerImpl performNextLocationIfNecessary2 interval:" + r101.f190161a);
        return;
    }

    public static void b(ByteLocationClientOption r100, LocationUploadCallback r101) {
        Logger.i("ByteLocationManagerImpl: doLocationUpload() is executed.");
        LocationUploadExtra r102 = new LocationUploadExtra();
        r102.locationOption = r100.f190162b;
        r102.setUploadInterval(r100.f190167g);
        r102.setUploadSource(r100.f190168h);
        r102.setTriggerType(r100.f190171k);
        r102.setStartLocationTime(r100.f190175o);
        LocationExtraBean r103 = r100.f190169i;
        if (r103 == null) goto L5;
        r102.setLogIdCache(r103.getLogIdCacheEntity());
        r102.setBleList(r100.f190169i.getBleInfoList());
    L5:
        r102.setLatestAdminVersion(r100.f190173m);
        r102.setBpeaCert(r100.f190174n);
        r102.setExtra(r100.f190170j);
        r102.setLocationTraceLogger(r100.f190176p);
        r102.setLocateId(r100.f190177q);
        r102.setLocationExtraDataServer(r100.f190178r);
        LocationUtil.startGetLocate(r102, r101);
    }
}
