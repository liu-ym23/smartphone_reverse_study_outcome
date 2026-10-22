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
import com.bytedance.bdlocation.entity.LocationExtraBean;
import com.bytedance.bdlocation.exception.BDLocationException;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class d {
    public final Context a;
    public final qr3.c b;
    public LocationManager c;
    public final g d;
    public volatile ByteLocationClientOption e;
    public C0159d f;
    public f g;
    public e h;

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ByteLocationClientOption.LocationMode.values().length];
            a = r0;
            r0[ByteLocationClientOption.LocationMode.Battery_Saving.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            a[ByteLocationClientOption.LocationMode.Device_Sensors.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            a[ByteLocationClientOption.LocationMode.Hight_Accuracy.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    public abstract class b implements LocationListener {
        public b() {
        }

        @Override // android.location.LocationListener
        public final void onProviderDisabled(String r3) {
            Logger.i("ByteLocationManagerImpl: BaseLocationListener onProviderDisabled() provider is " + r3);
        }

        @Override // android.location.LocationListener
        public final void onProviderEnabled(String r3) {
            Logger.i("ByteLocationManagerImpl: BaseLocationListener onProviderEnabled() provider is " + r3);
        }

        @Override // android.location.LocationListener
        public final void onStatusChanged(String r1, int r2, Bundle r3) {
            Logger.i("ByteLocationManagerImpl: BaseLocationListener onStatusChanged() status is " + r2);
        }
    }

    public class c implements LocationUploadCallback {
        public final ByteLocationClientOption a;
        public final BDLocation b;
        public final /* synthetic */ d c;

        public final void onError(String r4) {
            Logger.i("ByteLocationManagerImpl: BatterySavingLocationCallback onError! The message is " + r4);
            this.c.getClass();
            this.c.b.d(new BDLocationException(r4, "ByteLocation", "70"));
        }

        public c(d r1, ByteLocationClientOption r2, BDLocation r3) {
            this.c = r1;
            this.a = r2;
            this.b = r3;
        }

        public final void onSuccess(LocationResp r5, boolean r6, WifiInfo r7) {
            if (r5 != null) goto L5;
            Logger.i("ByteLocationManagerImpl: BatterySavingLocationCallback onError");
            this.c.getClass();
            this.c.b.d(new BDLocationException("analysis locInfoRsp error:resp is null", "ByteLocation", "70"));
            return;
        L5:
            Logger.i("BatterySavingLocationCallback onSuccess");
            LocInfoRspData r8 = LocationUtil.parseLocInfoRsp(r5);
            if (r8 == null) goto L10;
            Logger.i("ByteLocationManagerImpl BatterySavingLocationCallback inOutDoorStatus:" + r8.inOutDoorStatus);
            BDLocation r0 = LocationUtil.locationResultToBDLocation(this.b, r8.location, r8.inOutDoorStatus, r8.inOutDoorConfidence);
            if (r0 == null) goto L11;
            r0.setLocInfoRsp(r8);
            r0.setRecommendWifiResults(r6);
            r0.setConnectedWifiInfo(r7);
        L11:
            Logger.i("ByteLocationManagerImpl: BatterySavingLocationCallback onSuccess.");
            this.c.b.c(r0);
            if (this.a.l == true) goto L15;
            Logger.i("ByteLocationManagerImpl: BatterySavingLocationCallback is continuous location. The interval is " + this.a.a);
            this.c.d.sendMessageDelayed(Message.obtain(this.c.d, 1, this.a), this.a.a);
            Logger.i("performNextLocationIfNecessary interval:" + this.a.a);
            return;
        L15:
            return;
        L10:
            r0 = null;
            goto L11
        }
    }

    /* JADX INFO: renamed from: qr3.d$d, reason: collision with other inner class name */
    public class C0159d extends b {
        public final /* synthetic */ d a;

        public C0159d(d r1) {
            this.a = r1;
        }

        @Override // android.location.LocationListener
        public final void onLocationChanged(Location r22) {
            ArrayList r10 = new ArrayList();
            Object[] r12 = {r22};
            f06.b r14 = new f06.b();
            g06.a r0 = (g06.a) ApiHookConfig.b.get(100038);
            if (r0 == null) goto L5;
            f06.a[] r1 = r0.i;
        L6:
            f06.a[] r7 = r1;
            int r6 = r7.length;
            int r5 = 0;
        L8:
            if (r5 >= r6) goto L15;
            f06.a r4 = r7[r5];
            int r18 = r5;
            int r19 = r6;
            f06.a[] r20 = r7;
            f06.d r2 = r4.preInvoke(100038, "com/bytedance/api/location/service/ByteLocationManagerImpl$DeviceSensorsLocationListener", "onLocationChanged", this, r12, "void", r14);     // Catch: Exception -> L35
            if (r2.a == true) goto L17;
            r10.add(r4);     // Catch: Exception -> L35
        L17:
            if (r2.a == false) goto L19;
            return;
        L19:
            Logger.i("ByteLocationManagerImpl: DeviceSensorsLocationListener onLocationChanged() and the location is " + r22);
            f r3 = this.a.g;
            if (r3 == null) goto L25;
            if (r3.a == null) goto L25;
            Logger.i("ByteLocationManagerImpl: LocationGpsStatusListener stopCountDownTimer() is executed.");
            r3.a.cancel();
        L25:
            if (Build.VERSION.SDK_INT < 24) goto L31;
            e r8 = this.a.h;
            if (r8 == null) goto L31;
            int r9 = e.f;
            if (r8.a == null) goto L31;
            Logger.i("ByteLocationManagerImpl: LocationGpsStatusListener stopCountDownTimer() is executed.");
            r8.a.cancel();
        L31:
            if (r22 == null) goto L33;
            this.a.getClass();
            BDLocation r11 = d.e(r22);
            this.a.b.c(r11);
            r11.setRecommendWifiResults(true);
            return;
        L33:
            this.a.getClass();
            this.a.b.d(new BDLocationException("byte device location is null", "ByteLocation", "26"));
            return;
        L14:
            r5 = r18 + 1;
            r6 = r19;
            r7 = r20;
            goto L8
        L15:
            r2 = new f06.d(false, null);
            goto L17
        L5:
            r1 = ApiHookConfig.d;
            goto L6
        }
    }

    public class e extends GnssStatus.Callback {
        public static final /* synthetic */ int f = 0;
        public qr3.e a;
        public int b;
        public int c;
        public final boolean d;
        public final /* synthetic */ d e;

        @Override // android.location.GnssStatus.Callback
        public final void onStarted() {
            if (this.d == true) goto L5;
            return;
        L5:
            if (this.e.e == null) goto L7;
            long r0 = this.e.e.f;
        L8:
            Logger.i("ByteLocationManagerImpl: LocationGpsStatusListener startCountDownTimer() is executed.");
            qr3.e r2 = new qr3.e(this, r0);
            this.a = r2;
            r2.start();
            return;
        L7:
            r0 = 30000;
            goto L8
        }

        @Override // android.location.GnssStatus.Callback
        public final void onSatelliteStatusChanged(GnssStatus r5) {
            this.b = r5.getSatelliteCount();
            int r0 = 0;
            int r1 = 0;
        L4:
            if (r0 >= this.b) goto L9;
            if (r5.getCn0DbHz(r0) <= 25.0f) goto L8;
            r1 = r1 + 1;
        L8:
            r0 = r0 + 1;
            goto L4
        L9:
            this.c = r1;
            Logger.i("ByteLocationManagerImpl: LocationGnssStatusCallback onSatelliteStatusChanged()" + r1);
        }

        public e(d r1, boolean r2) {
            this.e = r1;
            this.d = r2;
        }
    }

    public class f implements GpsStatus.Listener {
        public qr3.f a;
        public int b;
        public int c;
        public final boolean d;
        public final /* synthetic */ d e;

        @Override // android.location.GpsStatus.Listener
        public final void onGpsStatusChanged(int r6) {
            LocationManager r0 = this.e.c;
            if (r0 != null) goto L6;
            return;
        L6:
            if (r6 != 1) goto L8;
            Logger.i("ByteLocationManagerImpl: LocationGpsStatusListener onLocationChanged() and receive GPS_EVENT_STARTED");
            if (this.d == true) goto L28;
            return;
        L28:
            if (this.e.e == null) goto L30;
            long r1 = this.e.e.f;
        L31:
            Logger.i("ByteLocationManagerImpl: LocationGpsStatusListener startCountDownTimer() is executed.");
            qr3.f r7 = new qr3.f(this, r1);
            this.a = r7;
            r7.start();
            return;
        L30:
            r1 = 30000;
            goto L31
        L8:
            if (r6 != 2) goto L10;
            Logger.i("ByteLocationManagerImpl: LocationGpsStatusListener onLocationChanged() and receive GPS_EVENT_STOPPED");
            return;
        L10:
            if (r6 != 3) goto L12;
            Logger.i("ByteLocationManagerImpl: LocationGpsStatusListener onLocationChanged() and receive GPS_EVENT_FIRST_FIX");
            return;
        L12:
            if (r6 != 4) goto L41;
            GpsStatus r8 = r0.getGpsStatus(null);
            int r2 = r8.getMaxSatellites();
            Iterator<GpsSatellite> r9 = r8.getSatellites().iterator();
            int r3 = 0;
            int r4 = 0;
        L16:
            if (r9.hasNext() == false) goto L22;
            if (r3 >= r2) goto L22;
            if (r9.next().getSnr() <= 25.0f) goto L21;
            r4 = r4 + 1;
        L21:
            r3 = r3 + 1;
        L22:
            this.b = Math.max(r3, this.b);
            this.c = r4;
            Logger.i("ByteLocationManagerImpl: LocationGpsStatusListener onLocationChanged() and receive GPS_EVENT_SATELLITE_STATUS, satellite count:" + r3);
            return;
        }

        public f(d r1, boolean r2) {
            this.e = r1;
            this.d = r2;
        }
    }

    public static class g extends Handler {
        public final WeakReference<d> a;

        public g(d r2) {
            super(Looper.getMainLooper());
            this.a = new WeakReference(r2);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message r5) {
            super.handleMessage(r5);
            d r0 = this.a.get();
            if (r0 != null) goto L6;
            Logger.i("ByteLocationManagerImpl: ByteLocationManagerImpl reference is null.");
            return;
        L6:
            int r1 = r5.what;
            if (r1 != 1) goto L9;
            removeMessages(1);
            ByteLocationClientOption r6 = (ByteLocationClientOption) r5.obj;
            Logger.i("ByteLocationManagerImpl: startLocationInternalForBatterySaving() is executed.");
            r6.c = 1;
            d.b(r6, new c(r0, r6, d.e(null)));
            return;
        L9:
            if (r1 != 2) goto L11;
            removeMessages(2);
            ByteLocationClientOption r7 = (ByteLocationClientOption) r5.obj;
            r7.c = 1;
            d.b(r7, new h(r0, r7));
            Logger.i("ByteLocationManagerImpl TimerHandler2");
            return;
        L11:
            if (r1 != 3) goto L19;
            removeMessages(3);
            r0.c();
            return;
        }
    }

    public class h implements LocationUploadCallback {
        public final ByteLocationClientOption a;
        public final long b;
        public final /* synthetic */ d c;

        public final void onError(String r4) {
            int r0 = this.a.c;
            Logger.i("ByteLocationManagerImpl WifiCellLocationCallback onError status:" + r0 + "--errorMsg:" + r4);
            if (r0 != 3) goto L5;
        L8:
            Logger.i("ByteLocationManagerImpl: WifiCellLocationCallback onError! The status is：" + this.a.a() + "--the message is：" + r4);
            this.c.getClass();
            this.c.b.d(new BDLocationException(r4, "ByteLocation", "70"));
            d.a(this.c, this.a);
            return;
        L5:
            if (r0 == 1) goto L8;
            Logger.i("ByteLocationManagerImpl: WifiCellLocationCallback onError! The status is %s ", this.a.a());
        }

        public h(d r3, ByteLocationClientOption r4) {
            this.c = r3;
            this.b = 0;
            this.a = r4;
            this.b = System.currentTimeMillis();
        }

        public final void onSuccess(LocationResp r8, boolean r9, WifiInfo r10) {
            if (r8 != null) goto L6;
            Logger.i("ByteLocationManagerImpl: WifiCellLocationCallback onError");
            this.c.getClass();
            this.c.b.d(new BDLocationException("analysis locInfoRsp error:resp is null", "ByteLocation", "70"));
            return;
        L6:
            Logger.i("ByteLocationManagerImpl getLocation intervalTime:" + (System.currentTimeMillis() - this.b));
            int r2 = this.a.c;
            Logger.i("ByteLocationManagerImpl WifiCellLocationCallback onSuccess:" + r2);
            if (r2 != 3) goto L9;
        L14:
            this.a.c = 6;
            Logger.i("ByteLocationManagerImpl: WifiCellLocationCallback onSuccess. The status is %s ", this.a.a());
            LocInfoRspData r3 = LocationUtil.parseLocInfoRsp(r8);
            if (r3 == null) goto L19;
            Logger.i("ByteLocationManagerImpl WifiCellLocationCallback inOutDoorStatus:" + r3.inOutDoorStatus);
            this.c.getClass();
            BDLocation r4 = LocationUtil.locationResultToBDLocation(new BDLocation("network", "ByteLocation"), r3.location, r3.inOutDoorStatus, r3.inOutDoorConfidence);
            if (r4 == null) goto L20;
            r4.setLocInfoRsp(r3);
            r4.setRecommendWifiResults(r9);
            r4.setConnectedWifiInfo(r10);
        L20:
            Logger.i("ByteLocationManagerImpl: WifiCellLocationCallback onSuccess.");
            if (r4 == null) goto L23;
            this.c.b.c(r4);
        L24:
            d.a(this.c, this.a);
            return;
        L23:
            Logger.i("ByteLocationManagerImpl: WifiCellLocationCallback onError:" + r8.toString());
            String r11 = "analysis locInfoRsp error:" + r8.toString();
            this.c.getClass();
            this.c.b.d(new BDLocationException(r11, "ByteLocation", "70"));
            goto L24
        L19:
            r4 = null;
            goto L20
        L9:
            if (r2 == 1) goto L14;
            if (r2 == 2) goto L14;
            Logger.i("ByteLocationManagerImpl: WifiCellLocationCallback onSuccess. The status is %s ", this.a.a());
        }
    }

    public final void c() {
        LocationManager r0 = this.c;
        if (r0 == null) goto L25;
        C0159d r1 = this.f;     // Catch: Exception -> L20
        if (r1 != null) goto L7;
    L11:
        f r2 = this.g;     // Catch: Exception -> L20
        if (r2 == null) goto L15;
        this.c.removeGpsStatusListener(r2);     // Catch: Exception -> L20
        this.g = null;     // Catch: Exception -> L20
    L15:
        if (Build.VERSION.SDK_INT < 24) goto L26;
        e r3 = this.h;     // Catch: Exception -> L20
        if (r3 == null) goto L27;
        this.c.unregisterGnssStatusCallback(r3);     // Catch: Exception -> L20
        this.h = null;     // Catch: Exception -> L20
        return;
    L27:
        return;
    L26:
        return;
    L7:
        if (fna.g.d() == true) goto L9;
        r0.removeUpdates(r1);     // Catch: Exception -> L20
    L10:
        this.f = null;     // Catch: Exception -> L20
        goto L11
    L9:
        r0.removeUpdates(r1);     // Catch: Exception -> L20
        nna.a.a(r1.hashCode());     // Catch: Exception -> L20
    L20:
        e = move-exception;
        Logger.i("ByteLocationManagerImpl: removeGPSLocationListener() throw an exception! The message is " + e.getMessage());
        return;
    }

    public final void d() {
        Logger.i("ByteLocationManagerImpl: stopLocation() is executed.");     // Catch: Exception -> L6
        this.d.removeCallbacksAndMessages(null);     // Catch: Exception -> L6
        if (this.e == null) goto L11;
        c();     // Catch: Exception -> L6
        this.e.c = 6;     // Catch: Exception -> L6
        this.e = null;     // Catch: Exception -> L6
        return;
    L11:
        return;
    L6:
        e = move-exception;
        Logger.i("ByteLocationManagerImpl: stopLocation() throw an exception! The message is " + e.getMessage());
    }

    public d(Context r3) {
        this.a = r3;
        this.b = new qr3.c(AppExecutors.getInstance());
        this.c = (LocationManager) r3.getSystemService("location");
        this.d = new g(this);
    }

    public static BDLocation e(Location r2) {
        if (r2 == null) goto L5;
        BDLocation r1 = new BDLocation(r2, "ByteLocation");
        r1.setLocationType(1);
    L6:
        r1.setGeocodeSDKName("ByteLocation");
        Logger.i("ByteLocationManagerImpl: transform() is executed and the result is " + r1);
        return r1;
    L5:
        r1 = new BDLocation("network", "ByteLocation");
        r1.setLocationType(2);
        goto L6
    }

    public static void a(d r3, ByteLocationClientOption r4) {
        r3.getClass();
        if (r4.l == true) goto L6;
        r3.d.sendMessageDelayed(Message.obtain(r3.d, 2, r4), r4.a);
        Logger.i("ByteLocationManagerImpl performNextLocationIfNecessary2 interval:" + r4.a);
        return;
    }

    public static void b(ByteLocationClientOption r3, LocationUploadCallback r4) {
        Logger.i("ByteLocationManagerImpl: doLocationUpload() is executed.");
        LocationUploadExtra r0 = new LocationUploadExtra();
        r0.locationOption = r3.b;
        r0.setUploadInterval(r3.g);
        r0.setUploadSource(r3.h);
        r0.setTriggerType(r3.k);
        r0.setStartLocationTime(r3.o);
        LocationExtraBean r1 = r3.i;
        if (r1 == null) goto L5;
        r0.setLogIdCache(r1.getLogIdCacheEntity());
        r0.setBleList(r3.i.getBleInfoList());
    L5:
        r0.setLatestAdminVersion(r3.m);
        r0.setBpeaCert(r3.n);
        r0.setExtra(r3.j);
        r0.setLocationTraceLogger(r3.p);
        r0.setLocateId(r3.q);
        r0.setLocationExtraDataServer(r3.r);
        LocationUtil.startGetLocate(r0, r4);
    }
}
