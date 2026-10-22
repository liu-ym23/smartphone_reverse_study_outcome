package rr3;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.bytedance.bdlocation.api.IBPEALocal;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.bytedance.bdlocation.client.LocationOption;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.service.BDLocationExtrasService;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.larus.apm.impl.protector.RunnableProtector;
import fna.g;
import java.util.ArrayList;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Pair;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f538980a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f538981b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f538982c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f538983d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f538984e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final LocationManager f538985f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Function1<? super AbstractC7523a, Unit> f538986g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f538987h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public volatile Location f538988i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public volatile Location f538989j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public volatile long f538990k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public volatile long f538991l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f538992m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public volatile boolean f538993n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public volatile IBPEALocal f538994o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final LocationOption f538995p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Looper f538996q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final b f538997r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final c f538998s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Object f538999t;

    /* JADX INFO: renamed from: rr3.a$a, reason: collision with other inner class name */
    public static abstract class AbstractC7523a {

        /* JADX INFO: renamed from: rr3.a$a$a, reason: collision with other inner class name */
        public static final class C7524a extends AbstractC7523a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final String f539000a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final String f539001b;

            public final boolean equals(Object r100) {
                if (this != r100) goto L4;
                return true;
            L4:
                if ((r100 instanceof C7524a) == false) goto L10;
                C7524a r101 = (C7524a) r100;
                if (Intrinsics.areEqual(this.f539000a, r101.f539000a) == true) goto L8;
                return false;
            L8:
                if (Intrinsics.areEqual(this.f539001b, r101.f539001b) == true) goto L16;
                return false;
            L16:
                return true;
            L10:
                return false;
            }

            public final int hashCode() {
                String r100 = this.f539000a;
                int r101 = 0;
                if (r100 == null) goto L5;
                int r102 = r100.hashCode();
            L6:
                int r103 = r102 * 31;
                String r104 = this.f539001b;
                if (r104 == null) goto L10;
                r101 = r104.hashCode();
            L10:
                return r103 + r101;
            L5:
                r102 = 0;
                goto L6
            }

            public final String toString() {
                return "Failure(reason=" + this.f539000a + ", errorCode=" + this.f539001b + ")";
            }

            public C7524a(String r100, String r101) {
                this.f539000a = r100;
                this.f539001b = r101;
            }
        }

        /* JADX INFO: renamed from: rr3.a$a$b */
        public static final class b extends AbstractC7523a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final Location f539002a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final int f539003b;

            public final boolean equals(Object r100) {
                if (this != r100) goto L4;
                return true;
            L4:
                if ((r100 instanceof b) == false) goto L10;
                b r101 = (b) r100;
                if (Intrinsics.areEqual(this.f539002a, r101.f539002a) == true) goto L8;
                return false;
            L8:
                if (this.f539003b == r101.f539003b) goto L16;
                return false;
            L16:
                return true;
            L10:
                return false;
            }

            public final int hashCode() {
                Location r100 = this.f539002a;
                if (r100 == null) goto L5;
                int r101 = r100.hashCode();
            L7:
                return (r101 * 31) + this.f539003b;
            L5:
                r101 = 0;
                goto L7
            }

            public final String toString() {
                return "Success(location=" + this.f539002a + ", locationType=" + this.f539003b + ")";
            }

            public b(Location r100, int r101) {
                this.f539002a = r100;
                this.f539003b = r101;
            }
        }

        public AbstractC7523a() {
        }
    }

    public static final class b implements LocationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f539004a;

        public b(a r100) {
            this.f539004a = r100;
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
            f06.d r106 = r105.preInvoke(100038, "com/bytedance/api/location/service/continuous/ContinuousLocationManager$mLocationListener$1", "onLocationChanged", this, r111, "void", r112);     // Catch: Exception -> L42
            if (r106.f474982a == true) goto L17;
            r110.add(r105);     // Catch: Exception -> L42
        L17:
            if (r106.f474982a == false) goto L19;
            return;
        L19:
            String r107 = r210.getProvider();
            Logger.i("ContinuousLocationManager onLocationChanged provider: " + r107);
            if (Intrinsics.areEqual(GeocodeSearch.GPS, r107) == false) goto L29;
            Bundle r108 = r210.getExtras();
            if (r108 == null) goto L29;
            if (r108.getBoolean("QUICKGPS", false) == false) goto L29;
            if (BDLocationConfig.isUseQuickGPS() == true) goto L29;
            Logger.i("ContinuousLocationManager onLocationChanged quickGPS");
            r210.setProvider("network");
            r107 = r210.getProvider();
        L29:
            if (Intrinsics.areEqual(r107, "network") == false) goto L40;
            Logger.i("ContinuousLocationManager onLocationChanged NETWORK");
            this.f539004a.f538989j = r210;
            long r109 = System.currentTimeMillis();
            this.f539004a.f538991l = r109;
            a r115 = this.f539004a;
            r115.getClass();
            long r116 = System.currentTimeMillis();
            if (r115.f538988i != null) goto L33;
        L35:
            boolean r117 = false;
        L36:
            if (r117 == true) goto L48;
            a r118 = this.f539004a;
            if ((r109 - r118.f538992m) < r118.f538982c) goto L49;
            a.a(r118, r210, 4);
            return;
        L49:
            return;
        L48:
            return;
        L33:
            if ((r116 - r115.f538990k) >= r115.f538984e) goto L35;
            r117 = true;
            goto L36
        L40:
            Logger.i("ContinuousLocationManager onLocationChanged GPS");
            this.f539004a.f538988i = r210;
            this.f539004a.f538990k = System.currentTimeMillis();
            a.a(this.f539004a, r210, 1);
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

        @Override // android.location.LocationListener
        public final void onProviderDisabled(String r100) {
            Logger.i("ContinuousLocationManager onProviderDisabled provider: " + r100);
            if (Intrinsics.areEqual(r100, GeocodeSearch.GPS) == false) goto L6;
            this.f539004a.f538988i = null;
            return;
        L6:
            if (Intrinsics.areEqual(r100, "network") == false) goto L10;
            this.f539004a.f538989j = null;
            return;
        }

        @Override // android.location.LocationListener
        public final void onProviderEnabled(String r100) {
            Logger.i("ContinuousLocationManager onProviderEnabled provider: " + r100);
        }

        @Override // android.location.LocationListener
        @Deprecated(message = "Deprecated in Java")
        public final void onStatusChanged(String r100, int r101, Bundle r102) {
            Logger.i("ContinuousLocationManager onStatusChanged provider: " + r100 + " status: " + r101);
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f539005a;

        public final void a() {
            if (this.f539005a.f538993n == true) goto L5;
            return;
        L5:
            long r100 = System.currentTimeMillis();
            Logger.i("ContinuousLocationManager periodicRunnable now: " + r100 + ", mLastCallbackTime: " + this.f539005a.f538992m + ", mBackupIntervalMs: " + this.f539005a.f538981b);
            a r101 = this.f539005a;
            if ((r100 - r101.f538992m) < r101.f538981b) goto L37;
            long r102 = System.currentTimeMillis();
            long r103 = System.currentTimeMillis();
            if (r101.f538988i != null) goto L10;
        L12:
            boolean r104 = false;
        L13:
            if (r104 == false) goto L22;
            if (r101.f538988i == null) goto L22;
            if ((r102 - r101.f538990k) >= (BDLocationConfig.getLocationExpiredInterval() + r101.f538982c)) goto L22;
            Location r105 = r101.f538988i;
            if (r105 == null) goto L28;
            Pair r106 = new Pair(r105, 1);
        L29:
            r101.f538992m = System.currentTimeMillis();
            if (r106 == null) goto L34;
            Function1<? super AbstractC7523a, Unit> r107 = r101.f538986g;
            if (r107 == null) goto L37;
            Unit r108 = r107.invoke(new AbstractC7523a.b((Location) r106.getFirst(), ((Number) r106.getSecond()).intValue()));
            goto L37
        L34:
            Logger.i("ContinuousLocationManager deliverBestAvailableResult No location available");
            Function1<? super AbstractC7523a, Unit> r109 = r101.f538986g;
            if (r109 == null) goto L37;
            Unit r110 = r109.invoke(new AbstractC7523a.C7524a("No location available", BDLocationException.ERROR_NO_LOCATION));
        L28:
            r106 = null;
        L22:
            if (r101.f538989j == null) goto L28;
            if ((r102 - r101.f538991l) >= (BDLocationConfig.getLocationExpiredInterval() + r101.f538982c)) goto L28;
            Location r111 = r101.f538989j;
            if (r111 == null) goto L28;
            r106 = new Pair(r111, 4);
            goto L29
        L10:
            if ((r103 - r101.f538990k) >= r101.f538984e) goto L12;
            r104 = true;
        L37:
            a r112 = this.f539005a;
            Handler r113 = r112.f538980a;
            if (r113 == null) goto L41;
            r113.postDelayed(this, r112.f538981b);
            return;
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

        public c(a r100) {
            this.f539005a = r100;
        }
    }

    public static final class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f539006a;

        public d(a r100) {
            this.f539006a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Function1<? super AbstractC7523a, Unit> r100 = this.f539006a.f538986g;     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            Unit r101 = r100.invoke(new AbstractC7523a.C7524a("GPS and NETWORK Provider unavailable", BDLocationException.ERROR_LOCATION_NO_PROVIDER));     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public final void c() {
        this.f538993n = false;     // Catch: Exception -> L17
        Handler r100 = this.f538980a;     // Catch: Exception -> L17
        if (r100 == null) goto L6;
        r100.removeCallbacks(this.f538998s);     // Catch: Exception -> L17
    L6:
        Handler r101 = this.f538980a;     // Catch: Exception -> L17
        if (r101 == null) goto L9;
        r101.removeCallbacksAndMessages(this.f538999t);     // Catch: Exception -> L17
    L9:
        LocationManager r102 = this.f538985f;     // Catch: Exception -> L17
        if (r102 == null) goto L15;
        b r103 = this.f538997r;     // Catch: Exception -> L17
        if (g.d() == true) goto L14;
        r102.removeUpdates(r103);     // Catch: Exception -> L17
        goto L15
    L14:
        r102.removeUpdates(r103);     // Catch: Exception -> L17
        nna.a.a(r103.hashCode());     // Catch: Exception -> L17
    L15:
        this.f538988i = null;     // Catch: Exception -> L17
        this.f538989j = null;     // Catch: Exception -> L17
        this.f538990k = 0;     // Catch: Exception -> L17
        this.f538992m = 0;     // Catch: Exception -> L17
        return;
    L17:
        e = move-exception;
        Logger.e("ContinuousLocationManager stopLocation error:", e);
    }

    public final boolean b() {
        Logger.i("ContinuousLocationManager startLocation isRunning: " + this.f538993n);
    L40:
        e = e;
        boolean r110 = false;
    L42:
        Logger.e("ContinuousLocationManager startLocation exception: " + e);
    L43:
        if (r110 == true) goto L48;
        this.f538993n = false;
        Logger.e("ContinuousLocationManager startLocation GPS and NETWORK Provider unavailable");
        Handler r100 = this.f538980a;
        if (r100 == null) goto L47;
        r100.post(new d(this));
    L47:
        return false;
    L48:
        Handler r101 = this.f538980a;
        if (r101 == null) goto L51;
        r101.postDelayed(this.f538998s, BDLocationConfig.getFirstLocationTimeoutMs());
    L51:
        return true;
    L4:
        if (this.f538993n == false) goto L6;
        return true;
    L6:
        this.f538993n = true;     // Catch: Exception -> L40
        LocationManager r102 = this.f538985f;     // Catch: Exception -> L40
        if (r102 == null) goto L11;
        List<String> r103 = r102.getProviders(true);     // Catch: Exception -> L40
        if (r103 == null) goto L11;
    L12:
        IBPEALocal r111 = this.f538994o;     // Catch: Exception -> L40
        if (r111 != null) goto L15;
    L25:
        r110 = false;
    L26:
        if (r111 == null) goto L43;
    L38:
        e = e;
        goto L42
    L28:
        if (r103.contains("network") == false) goto L43;
        int r104 = this.f538987h;     // Catch: Exception -> L38
        if (r104 == 2) goto L32;
        if (r104 != 0) goto L43;
    L32:
        LocationManager r105 = this.f538985f;     // Catch: Exception -> L38
        long r106 = this.f538982c;     // Catch: Exception -> L38
        float r107 = this.f538983d;     // Catch: Exception -> L38
        b r112 = this.f538997r;     // Catch: Exception -> L38
        Looper r113 = this.f538996q;     // Catch: Exception -> L38
        LocationOption r108 = this.f538995p;     // Catch: Exception -> L38
        if (r108 == null) goto L35;
        Object r114 = r108.getBpeaCert();     // Catch: Exception -> L38
    L36:
        r111.requestLocationUpdates(r105, "network", r106, r107, r112, r113, r114);     // Catch: Exception -> L38
        Logger.i("ContinuousLocationManager startLocation NETWORK Provider started");     // Catch: Exception -> L38
        r110 = true;
        goto L43
    L35:
        r114 = null;
        goto L36
    L15:
        if (r103.contains(GeocodeSearch.GPS) == false) goto L25;
        int r109 = this.f538987h;     // Catch: Exception -> L40
        if (r109 == 2) goto L19;
        if (r109 != 1) goto L25;
    L19:
        LocationManager r115 = this.f538985f;     // Catch: Exception -> L40
        long r116 = this.f538982c;     // Catch: Exception -> L40
        float r117 = this.f538983d;     // Catch: Exception -> L40
        b r118 = this.f538997r;     // Catch: Exception -> L40
        Looper r119 = this.f538996q;     // Catch: Exception -> L40
        LocationOption r120 = this.f538995p;     // Catch: Exception -> L40
        if (r120 == null) goto L22;
        Object r121 = r120.getBpeaCert();     // Catch: Exception -> L40
    L23:
        r111.requestLocationUpdates(r115, GeocodeSearch.GPS, r116, r117, r118, r119, r121);     // Catch: Exception -> L40
        Logger.i("ContinuousLocationManager startLocation GPS Provider started");     // Catch: Exception -> L40
        r110 = true;
        goto L26
    L22:
        r121 = null;
    L11:
        r103 = CollectionsKt.emptyList();     // Catch: Exception -> L40
        goto L12
    }

    public static final void a(a r100, Location r101, int r102) {
        r100.getClass();
    L16:
        e = move-exception;
        Logger.e("ContinuousLocationManager scheduleImmediateCallback", e);
        return;
    L4:
        if (r100.f538993n == false) goto L21;
        Handler r103 = r100.f538980a;     // Catch: Exception -> L16
        if (r103 == null) goto L9;
        r103.removeCallbacksAndMessages(r100.f538999t);     // Catch: Exception -> L16
    L9:
        Handler r104 = r100.f538980a;     // Catch: Exception -> L16
        if (r104 == null) goto L12;
        r104.removeCallbacks(r100.f538998s);     // Catch: Exception -> L16
    L12:
        Handler r105 = r100.f538980a;     // Catch: Exception -> L16
        if (r105 == null) goto L22;
        r105.postAtTime(new rr3.b(r100, r101, r102), r100.f538999t, SystemClock.uptimeMillis());     // Catch: Exception -> L16
        return;
    L22:
        return;
    }

    public a(Context r100, LocationOption r110, Looper r111, Function1<? super AbstractC7523a, Unit> r112) {
        long r101 = 2000;
        this.f538981b = 2000;
        this.f538982c = 1000;
        this.f538984e = 2000;
        this.f538986g = r112;
        int r113 = 2;
        this.f538987h = 2;
        this.f538995p = r110;
        this.f538996q = r111;
        Object r102 = r100.getSystemService("location");
        if (r102 == null) goto L37;
        this.f538985f = (LocationManager) r102;
        this.f538994o = BDLocationExtrasService.getBPEAManager();
        if (r111 == null) goto L7;
        Handler r103 = new Handler(r111);
    L8:
        this.f538980a = r103;
        if (r110 == null) goto L11;
        long r104 = r110.getInterval();
    L12:
        this.f538982c = r104;
        if (r104 > 0) goto L15;
        this.f538982c = 1000;
    L15:
        if (r110 == null) goto L17;
        float r105 = r110.getMinUpdateDistance();
    L18:
        this.f538983d = r105;
        if (r105 >= 0) goto L21;
        this.f538983d = 0.0f;
    L21:
        if (r110 == null) goto L23;
        long r106 = r110.getBackupIntervalMs();
    L24:
        this.f538981b = r106;
        long r107 = this.f538982c;
        if (r106 > r107) goto L27;
        this.f538981b = r107 + 1000;
    L27:
        if (r110 == null) goto L29;
        r101 = r110.getGpsTimeoutMs();
    L29:
        this.f538984e = r101;
        long r108 = this.f538982c;
        if (r101 > r108) goto L32;
        this.f538984e = r108 + 1000;
    L32:
        if (r110 == null) goto L34;
        r113 = r110.getMode();
    L34:
        this.f538987h = r113;
        Logger.i("ContinuousLocationManager constructor mMinUpdateIntervalMs: " + this.f538982c + ", mMinUpdateDistance: " + this.f538983d + ", mBackupIntervalMs: " + this.f538981b + ", mGpsTimeoutMs: " + this.f538984e);
        this.f538997r = new b(this);
        this.f538998s = new c(this);
        this.f538999t = new Object();
        return;
    L23:
        r106 = 2000;
        goto L24
    L17:
        r105 = this.f538983d;
        goto L18
    L11:
        r104 = 1000;
        goto L12
    L7:
        r103 = null;
        goto L8
    L37:
        throw new TypeCastException("null cannot be cast to non-null type android.location.LocationManager");
    }
}
