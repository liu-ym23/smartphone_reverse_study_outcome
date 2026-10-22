package rr3;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.bytedance.bdlocation.api.IBPEALocal;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.bytedance.bdlocation.client.LocationOption;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a {
    public final Handler a;
    public final long b;
    public final long c;
    public final float d;
    public final long e;
    public final LocationManager f;
    public final Function1<? super AbstractC0166a, Unit> g;
    public final int h;
    public volatile Location i;
    public volatile Location j;
    public volatile long k;
    public volatile long l;
    public long m;
    public volatile boolean n;
    public volatile IBPEALocal o;
    public final LocationOption p;
    public final Looper q;
    public final b r;
    public final c s;
    public final Object t;

    /* JADX INFO: renamed from: rr3.a$a, reason: collision with other inner class name */
    public static abstract class AbstractC0166a {

        /* JADX INFO: renamed from: rr3.a$a$a, reason: collision with other inner class name */
        public static final class C0167a extends AbstractC0166a {
            public final String a;
            public final String b;

            public final boolean equals(Object r3) {
                if (this != r3) goto L4;
                return true;
            L4:
                if ((r3 instanceof C0167a) == false) goto L10;
                C0167a r4 = (C0167a) r3;
                if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
                return false;
            L8:
                if (Intrinsics.areEqual(this.b, r4.b) == true) goto L16;
                return false;
            L16:
                return true;
            L10:
                return false;
            }

            public final int hashCode() {
                String r0 = this.a;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = r0.hashCode();
            L6:
                int r3 = r2 * 31;
                String r4 = this.b;
                if (r4 == null) goto L10;
                r1 = r4.hashCode();
            L10:
                return r3 + r1;
            L5:
                r2 = 0;
                goto L6
            }

            public final String toString() {
                return "Failure(reason=" + this.a + ", errorCode=" + this.b + ")";
            }

            public C0167a(String r1, String r2) {
                this.a = r1;
                this.b = r2;
            }
        }

        /* JADX INFO: renamed from: rr3.a$a$b */
        public static final class b extends AbstractC0166a {
            public final Location a;
            public final int b;

            public final boolean equals(Object r3) {
                if (this != r3) goto L4;
                return true;
            L4:
                if ((r3 instanceof b) == false) goto L10;
                b r4 = (b) r3;
                if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
                return false;
            L8:
                if (this.b == r4.b) goto L16;
                return false;
            L16:
                return true;
            L10:
                return false;
            }

            public final int hashCode() {
                Location r0 = this.a;
                if (r0 == null) goto L5;
                int r1 = r0.hashCode();
            L7:
                return (r1 * 31) + this.b;
            L5:
                r1 = 0;
                goto L7
            }

            public final String toString() {
                return "Success(location=" + this.a + ", locationType=" + this.b + ")";
            }

            public b(Location r1, int r2) {
                this.a = r1;
                this.b = r2;
            }
        }

        public AbstractC0166a() {
        }
    }

    public static final class b implements LocationListener {
        public final /* synthetic */ a a;

        public b(a r1) {
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
            f06.d r2 = r4.preInvoke(100038, "com/bytedance/api/location/service/continuous/ContinuousLocationManager$mLocationListener$1", "onLocationChanged", this, r12, "void", r14);     // Catch: Exception -> L42
            if (r2.a == true) goto L17;
            r10.add(r4);     // Catch: Exception -> L42
        L17:
            if (r2.a == false) goto L19;
            return;
        L19:
            String r3 = r22.getProvider();
            Logger.i("ContinuousLocationManager onLocationChanged provider: " + r3);
            if (Intrinsics.areEqual("gps", r3) == false) goto L29;
            Bundle r8 = r22.getExtras();
            if (r8 == null) goto L29;
            if (r8.getBoolean("QUICKGPS", false) == false) goto L29;
            if (BDLocationConfig.isUseQuickGPS() == true) goto L29;
            Logger.i("ContinuousLocationManager onLocationChanged quickGPS");
            r22.setProvider("network");
            r3 = r22.getProvider();
        L29:
            if (Intrinsics.areEqual(r3, "network") == false) goto L40;
            Logger.i("ContinuousLocationManager onLocationChanged NETWORK");
            this.a.j = r22;
            long r9 = System.currentTimeMillis();
            this.a.l = r9;
            a r11 = this.a;
            r11.getClass();
            long r13 = System.currentTimeMillis();
            if (r11.i != null) goto L33;
        L35:
            boolean r15 = false;
        L36:
            if (r15 == true) goto L48;
            a r16 = this.a;
            if ((r9 - r16.m) < r16.c) goto L49;
            a.a(r16, r22, 4);
            return;
        L49:
            return;
        L48:
            return;
        L33:
            if ((r13 - r11.k) >= r11.e) goto L35;
            r15 = true;
            goto L36
        L40:
            Logger.i("ContinuousLocationManager onLocationChanged GPS");
            this.a.i = r22;
            this.a.k = System.currentTimeMillis();
            a.a(this.a, r22, 1);
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

        @Override // android.location.LocationListener
        public final void onProviderDisabled(String r3) {
            Logger.i("ContinuousLocationManager onProviderDisabled provider: " + r3);
            if (Intrinsics.areEqual(r3, "gps") == false) goto L6;
            this.a.i = null;
            return;
        L6:
            if (Intrinsics.areEqual(r3, "network") == false) goto L10;
            this.a.j = null;
            return;
        }

        @Override // android.location.LocationListener
        public final void onProviderEnabled(String r3) {
            Logger.i("ContinuousLocationManager onProviderEnabled provider: " + r3);
        }

        @Override // android.location.LocationListener
        @Deprecated(message = "Deprecated in Java")
        public final void onStatusChanged(String r2, int r3, Bundle r4) {
            Logger.i("ContinuousLocationManager onStatusChanged provider: " + r2 + " status: " + r3);
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ a a;

        public final void a() {
            if (this.a.n == true) goto L5;
            return;
        L5:
            long r0 = System.currentTimeMillis();
            Logger.i("ContinuousLocationManager periodicRunnable now: " + r0 + ", mLastCallbackTime: " + this.a.m + ", mBackupIntervalMs: " + this.a.b);
            a r2 = this.a;
            if ((r0 - r2.m) < r2.b) goto L37;
            long r1 = System.currentTimeMillis();
            long r3 = System.currentTimeMillis();
            if (r2.i != null) goto L10;
        L12:
            boolean r4 = false;
        L13:
            if (r4 == false) goto L22;
            if (r2.i == null) goto L22;
            if ((r1 - r2.k) >= (BDLocationConfig.getLocationExpiredInterval() + r2.c)) goto L22;
            Location r5 = r2.i;
            if (r5 == null) goto L28;
            Pair r6 = new Pair(r5, 1);
        L29:
            r2.m = System.currentTimeMillis();
            if (r6 == null) goto L34;
            Function1<? super AbstractC0166a, Unit> r7 = r2.g;
            if (r7 == null) goto L37;
            Unit r8 = (Unit) r7.invoke(new AbstractC0166a.b((Location) r6.getFirst(), ((Number) r6.getSecond()).intValue()));
            goto L37
        L34:
            Logger.i("ContinuousLocationManager deliverBestAvailableResult No location available");
            Function1<? super AbstractC0166a, Unit> r9 = r2.g;
            if (r9 == null) goto L37;
            Unit r10 = (Unit) r9.invoke(new AbstractC0166a.C0167a("No location available", "146"));
        L28:
            r6 = null;
        L22:
            if (r2.j == null) goto L28;
            if ((r1 - r2.l) >= (BDLocationConfig.getLocationExpiredInterval() + r2.c)) goto L28;
            Location r11 = r2.j;
            if (r11 == null) goto L28;
            r6 = new Pair(r11, 4);
            goto L29
        L10:
            if ((r3 - r2.k) >= r2.e) goto L12;
            r4 = true;
        L37:
            a r12 = this.a;
            Handler r13 = r12.a;
            if (r13 == null) goto L41;
            r13.postDelayed(this, r12.b);
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

        public c(a r1) {
            this.a = r1;
        }
    }

    public static final class d implements Runnable {
        public final /* synthetic */ a a;

        public d(a r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Function1<? super AbstractC0166a, Unit> r0 = this.a.g;     // Catch: Throwable -> L6
            if (r0 == null) goto L9;
            Unit r1 = (Unit) r0.invoke(new AbstractC0166a.C0167a("GPS and NETWORK Provider unavailable", "150"));     // Catch: Throwable -> L6
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
        this.n = false;     // Catch: Exception -> L17
        Handler r0 = this.a;     // Catch: Exception -> L17
        if (r0 == null) goto L6;
        r0.removeCallbacks(this.s);     // Catch: Exception -> L17
    L6:
        Handler r1 = this.a;     // Catch: Exception -> L17
        if (r1 == null) goto L9;
        r1.removeCallbacksAndMessages(this.t);     // Catch: Exception -> L17
    L9:
        LocationManager r2 = this.f;     // Catch: Exception -> L17
        if (r2 == null) goto L15;
        b r3 = this.r;     // Catch: Exception -> L17
        if (g.d() == true) goto L14;
        r2.removeUpdates(r3);     // Catch: Exception -> L17
        goto L15
    L14:
        r2.removeUpdates(r3);     // Catch: Exception -> L17
        nna.a.a(r3.hashCode());     // Catch: Exception -> L17
    L15:
        this.i = null;     // Catch: Exception -> L17
        this.j = null;     // Catch: Exception -> L17
        this.k = 0;     // Catch: Exception -> L17
        this.m = 0;     // Catch: Exception -> L17
        return;
    L17:
        e = move-exception;
        Logger.e("ContinuousLocationManager stopLocation error:", e);
    }

    public final boolean b() {
        Logger.i("ContinuousLocationManager startLocation isRunning: " + this.n);
    L40:
        e = e;
        boolean r16 = false;
    L42:
        Logger.e("ContinuousLocationManager startLocation exception: " + e);
    L43:
        if (r16 == true) goto L48;
        this.n = false;
        Logger.e("ContinuousLocationManager startLocation GPS and NETWORK Provider unavailable");
        Handler r0 = this.a;
        if (r0 == null) goto L47;
        r0.post(new d(this));
    L47:
        return false;
    L48:
        Handler r1 = this.a;
        if (r1 == null) goto L51;
        r1.postDelayed(this.s, BDLocationConfig.getFirstLocationTimeoutMs());
    L51:
        return true;
    L4:
        if (this.n == false) goto L6;
        return true;
    L6:
        this.n = true;     // Catch: Exception -> L40
        LocationManager r2 = this.f;     // Catch: Exception -> L40
        if (r2 == null) goto L11;
        List<String> r3 = r2.getProviders(true);     // Catch: Exception -> L40
        if (r3 == null) goto L11;
    L12:
        IBPEALocal r13 = this.o;     // Catch: Exception -> L40
        if (r13 != null) goto L15;
    L25:
        r16 = false;
    L26:
        if (r13 == null) goto L43;
    L38:
        e = e;
        goto L42
    L28:
        if (r3.contains("network") == false) goto L43;
        int r4 = this.h;     // Catch: Exception -> L38
        if (r4 == 2) goto L32;
        if (r4 != 0) goto L43;
    L32:
        LocationManager r5 = this.f;     // Catch: Exception -> L38
        long r7 = this.c;     // Catch: Exception -> L38
        float r9 = this.d;     // Catch: Exception -> L38
        b r10 = this.r;     // Catch: Exception -> L38
        Looper r11 = this.q;     // Catch: Exception -> L38
        LocationOption r6 = this.p;     // Catch: Exception -> L38
        if (r6 == null) goto L35;
        Object r12 = r6.getBpeaCert();     // Catch: Exception -> L38
    L36:
        r13.requestLocationUpdates(r5, "network", r7, r9, r10, r11, r12);     // Catch: Exception -> L38
        Logger.i("ContinuousLocationManager startLocation NETWORK Provider started");     // Catch: Exception -> L38
        r16 = true;
        goto L43
    L35:
        r12 = null;
        goto L36
    L15:
        if (r3.contains("gps") == false) goto L25;
        int r8 = this.h;     // Catch: Exception -> L40
        if (r8 == 2) goto L19;
        if (r8 != 1) goto L25;
    L19:
        LocationManager r14 = this.f;     // Catch: Exception -> L40
        long r15 = this.c;     // Catch: Exception -> L40
        float r17 = this.d;     // Catch: Exception -> L40
        b r18 = this.r;     // Catch: Exception -> L40
        Looper r19 = this.q;     // Catch: Exception -> L40
        LocationOption r20 = this.p;     // Catch: Exception -> L40
        if (r20 == null) goto L22;
        Object r110 = r20.getBpeaCert();     // Catch: Exception -> L40
    L23:
        r13.requestLocationUpdates(r14, "gps", r15, r17, r18, r19, r110);     // Catch: Exception -> L40
        Logger.i("ContinuousLocationManager startLocation GPS Provider started");     // Catch: Exception -> L40
        r16 = true;
        goto L26
    L22:
        r110 = null;
    L11:
        r3 = CollectionsKt.emptyList();     // Catch: Exception -> L40
        goto L12
    }

    public static final void a(a r2, Location r3, int r4) {
        r2.getClass();
    L16:
        e = move-exception;
        Logger.e("ContinuousLocationManager scheduleImmediateCallback", e);
        return;
    L4:
        if (r2.n == false) goto L21;
        Handler r0 = r2.a;     // Catch: Exception -> L16
        if (r0 == null) goto L9;
        r0.removeCallbacksAndMessages(r2.t);     // Catch: Exception -> L16
    L9:
        Handler r1 = r2.a;     // Catch: Exception -> L16
        if (r1 == null) goto L12;
        r1.removeCallbacks(r2.s);     // Catch: Exception -> L16
    L12:
        Handler r5 = r2.a;     // Catch: Exception -> L16
        if (r5 == null) goto L22;
        r5.postAtTime(new rr3.b(r2, r3, r4), r2.t, SystemClock.uptimeMillis());     // Catch: Exception -> L16
        return;
    L22:
        return;
    }

    public a(Context r9, LocationOption r10, Looper r11, Function1<? super AbstractC0166a, Unit> r12) {
        long r0 = 2000;
        this.b = 2000;
        this.c = 1000;
        this.e = 2000;
        this.g = r12;
        int r13 = 2;
        this.h = 2;
        this.p = r10;
        this.q = r11;
        Object r14 = r9.getSystemService("location");
        if (r14 == null) goto L37;
        this.f = (LocationManager) r14;
        this.o = BDLocationExtrasService.getBPEAManager();
        if (r11 == null) goto L7;
        Handler r15 = new Handler(r11);
    L8:
        this.a = r15;
        if (r10 == null) goto L11;
        long r4 = r10.getInterval();
    L12:
        this.c = r4;
        if (r4 > 0) goto L15;
        this.c = 1000;
    L15:
        if (r10 == null) goto L17;
        float r16 = r10.getMinUpdateDistance();
    L18:
        this.d = r16;
        if (r16 >= 0) goto L21;
        this.d = 0.0f;
    L21:
        if (r10 == null) goto L23;
        long r5 = r10.getBackupIntervalMs();
    L24:
        this.b = r5;
        long r6 = this.c;
        if (r5 > r6) goto L27;
        this.b = r6 + 1000;
    L27:
        if (r10 == null) goto L29;
        r0 = r10.getGpsTimeoutMs();
    L29:
        this.e = r0;
        long r7 = this.c;
        if (r0 > r7) goto L32;
        this.e = r7 + 1000;
    L32:
        if (r10 == null) goto L34;
        r13 = r10.getMode();
    L34:
        this.h = r13;
        Logger.i("ContinuousLocationManager constructor mMinUpdateIntervalMs: " + this.c + ", mMinUpdateDistance: " + this.d + ", mBackupIntervalMs: " + this.b + ", mGpsTimeoutMs: " + this.e);
        this.r = new b(this);
        this.s = new c(this);
        this.t = new Object();
        return;
    L23:
        r5 = 2000;
        goto L24
    L17:
        r16 = this.d;
        goto L18
    L11:
        r4 = 1000;
        goto L12
    L7:
        r15 = null;
        goto L8
    L37:
        throw new TypeCastException("null cannot be cast to non-null type android.location.LocationManager");
    }
}
