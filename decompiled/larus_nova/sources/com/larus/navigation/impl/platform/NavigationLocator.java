package com.larus.navigation.impl.platform;

import android.app.Application;
import android.location.LocationManager;
import android.os.Handler;
import android.os.Looper;
import androidx.core.content.ContextCompat;
import androidx.core.location.LocationManagerCompat;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.navigation.kmp.NavigationController;
import com.larus.api.CoordinateType;
import com.larus.api.LocationService;
import com.larus.common.apphost.AppHost;
import com.larus.platform.api.h1;
import com.larus.platform.model.GeoLocationInfo;
import com.larus.platform.model.LocationResult;
import com.larus.platform.service.g0;
import hq9.z2;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes30.dex */
public final class NavigationLocator implements e37.a, com.larus.navigation.api.n.a {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final Lazy<NavigationLocator> f359907q = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile long f359908a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile c37.a f359909b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile Job f359910c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CoroutineScope f359911d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Handler f359912e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Object f359913f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile c f359914g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ThreadLocal<b> f359915h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f359916i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f359917j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public z2 f359918k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f359919l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public volatile boolean f359920m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public volatile boolean f359921n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public volatile String f359922o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public volatile e37.b f359923p;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0000\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/navigation/impl/platform/NavigationLocator$PrewarmSessionConflictException;", "Ljava/lang/IllegalStateException;", "Lkotlin/IllegalStateException;", "message", "", "<init>", "(Ljava/lang/String;)V", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class PrewarmSessionConflictException extends IllegalStateException {
        public PrewarmSessionConflictException(String r100) {
            Intrinsics.checkNotNullParameter(r100, "message");
            super(r100);
        }
    }

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f359924a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f359924a, ((b) r100).f359924a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f359924a.hashCode();
        }

        public final String toString() {
            return "PrewarmHandoff(identifier=" + this.f359924a + ')';
        }

        public final String getIdentifier() {
            return this.f359924a;
        }

        public b(String r100) {
            Intrinsics.checkNotNullParameter(r100, LocationMonitorConst.IDENTIFIER);
            this.f359924a = r100;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f359925a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final z2 f359926b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f359927c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f359928d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Runnable f359929e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public GeoLocationInfo f359930f;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (Intrinsics.areEqual(this.f359925a, r101.f359925a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f359926b, r101.f359926b) == true) goto L15;
            return false;
        L15:
            if (this.f359927c == r101.f359927c) goto L18;
            return false;
        L18:
            if (this.f359928d == r101.f359928d) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f359929e, r101.f359929e) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f359930f, r101.f359930f) == true) goto L26;
            return false;
        L26:
            return true;
        }

        public final int hashCode() {
            int r100 = ((this.f359925a.hashCode() * 31) + this.f359926b.hashCode()) * 31;
            int r101 = 1231;
            if (this.f359927c == false) goto L5;
            int r102 = 1231;
        L6:
            int r103 = (r100 + r102) * 31;
            if (this.f359928d == true) goto L10;
            r101 = 1237;
        L10:
            int r104 = (r103 + r101) * 31;
            Runnable r105 = this.f359929e;
            int r106 = 0;
            if (r105 != null) goto L13;
            int r107 = 0;
        L14:
            int r108 = (r104 + r107) * 31;
            GeoLocationInfo r109 = this.f359930f;
            if (r109 == null) goto L19;
            r106 = r109.hashCode();
        L19:
            return r108 + r106;
        L13:
            r107 = r105.hashCode();
            goto L14
        L5:
            r102 = 1237;
            goto L6
        }

        public final String toString() {
            return "PrewarmSession(identifier=" + this.f359925a + ", callback=" + this.f359926b + ", clickedLightNavigation=" + this.f359927c + ", nativeStarted=" + this.f359928d + ", timeoutTask=" + this.f359929e + ", latestLocation=" + this.f359930f + ')';
        }

        public final String getIdentifier() {
            return this.f359925a;
        }

        public c(String r100, i r101) {
            Intrinsics.checkNotNullParameter(r100, LocationMonitorConst.IDENTIFIER);
            Intrinsics.checkNotNullParameter(r101, "callback");
            this.f359925a = r100;
            this.f359926b = r101;
            this.f359927c = false;
            this.f359928d = false;
            this.f359929e = null;
            this.f359930f = null;
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f359931a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f359932b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d) == true) goto L8;
            return false;
        L8:
            d r101 = (d) r100;
            if (Intrinsics.areEqual(this.f359931a, r101.f359931a) == true) goto L12;
            return false;
        L12:
            if (this.f359932b == r101.f359932b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            String r100 = this.f359931a;
            if (r100 != null) goto L5;
            int r101 = 0;
        L6:
            int r102 = r101 * 31;
            if (this.f359932b == false) goto L9;
            int r103 = 1231;
        L11:
            return r102 + r103;
        L9:
            r103 = 1237;
            goto L11
        L5:
            r101 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "StopState(identifier=" + this.f359931a + ", stopFakeLocation=" + this.f359932b + ')';
        }

        public final String getIdentifier() {
            return this.f359931a;
        }

        public d(String r100, boolean r101) {
            this.f359931a = r100;
            this.f359932b = r101;
        }
    }

    public static final class e implements h1.a {
        public e() {
        }
    }

    @Override // e37.a
    public final Object b(long r100, Continuation<? super b37.d> r101) {
        return null;
    }

    @Override // e37.a
    public final b37.d getLastKnownLocation() {
        return null;
    }

    static {
        f359907q = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, new f());
    }

    public static boolean g() {
        Application r100 = AppHost.f326268a.getApplication();
        if (r100 != null) goto L21;
        return false;
    L21:
    L18:
        e = move-exception;
        com.larus.navigation.api.c.c("locator", "prewarm availability check failed", e);
        return false;
    L6:
        if (ContextCompat.checkSelfPermission(r100, "android.permission.ACCESS_FINE_LOCATION") != 0) goto L8;
        boolean r101 = true;
    L9:
        Object r102 = r100.getSystemService("location");     // Catch: RuntimeException -> L18
        if ((r102 instanceof LocationManager) == false) goto L12;
        LocationManager r103 = (LocationManager) r102;     // Catch: RuntimeException -> L18
    L13:
        if (r101 == false) goto L23;
        if (r103 == null) goto L24;
        if (LocationManagerCompat.isLocationEnabled(r103) == false) goto L25;
        return true;
    L25:
        return false;
    L24:
        return false;
    L23:
        return false;
    L12:
        r103 = null;
        goto L13
    L8:
        r101 = false;
        goto L9
    }

    @Override // e37.a
    public final String a() {
        return LocationService.f286873a.a();
    }

    @Override // e37.a
    public final void e() {
        Object r100 = this.f359913f;
        monitor-enter(r100);
        String r101 = this.f359922o;     // Catch: Throwable -> L28
        if (this.f359920m == true) goto L8;
        r101 = null;
    L8:
        boolean r102 = this.f359919l;     // Catch: Throwable -> L28
        d r103 = new d(r101, r102);     // Catch: Throwable -> L28
        this.f359923p = null;     // Catch: Throwable -> L28
        this.f359921n = false;     // Catch: Throwable -> L28
        this.f359919l = false;     // Catch: Throwable -> L28
        this.f359920m = false;     // Catch: Throwable -> L28
        this.f359922o = null;     // Catch: Throwable -> L28
        this.f359909b = null;     // Catch: Throwable -> L28
        this.f359908a = 0;     // Catch: Throwable -> L28
        monitor-exit(r100);
        Job r104 = this.f359910c;
        if (r104 == null) goto L13;
        Job.DefaultImpls.cancel$default(r104, null, 1, null);
    L13:
        this.f359910c = null;
        com.larus.navigation.api.n.a r105 = com.larus.navigation.api.n.f359689a;
        if (com.larus.navigation.api.n.f359689a != this) goto L16;
        com.larus.navigation.api.n.f359689a = null;
    L16:
        if (r102 == false) goto L20;
        h1 r106 = g0.f365740a.d();
        if (r106 == null) goto L20;
        r106.b();
    L20:
        String r107 = r103.getIdentifier();
        if (r107 == null) goto L23;
        l("navi_stop", r107);
    L23:
        if (r102 == false) goto L25;
    L26:
        com.larus.navigation.api.c.d("locator", "stream stopped");
        return;
    L25:
        if (r103.getIdentifier() != null) goto L26;
        return;
    L28:
        th = move-exception;
        throw th;
    }

    public NavigationLocator() {
        Function1<? super Long, Unit> r100 = com.larus.navigation.api.o.f359690a;
        com.larus.navigation.api.o.f359690a = new g(this);
        this.f359911d = CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault().plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
        this.f359912e = new Handler(Looper.getMainLooper());
        this.f359913f = new Object();
        this.f359915h = new ThreadLocal();
    }

    public final void f(c r100) {
        this.f359914g = null;
        Runnable r101 = r100.f359929e;
        if (r101 == null) goto L5;
        this.f359912e.removeCallbacks(r101);
    L5:
        r100.f359929e = null;
        r100.f359930f = null;
    }

    public final void h(String r100) {
        if (r100 != null) goto L4;
    L7:
        boolean r101 = true;
    L8:
        if (r101 == false) goto L11;
        return;
    L11:
        if (g() == false) goto L31;
        b r102 = this.f359915h.get();
        if (r102 != null) goto L15;
        return;
    L15:
        Object r103 = this.f359913f;
        monitor-enter(r103);
        c r104 = this.f359914g;     // Catch: Throwable -> L28
        if (r104 == null) goto L20;
        String r105 = r104.getIdentifier();     // Catch: Throwable -> L28
    L22:
        if (Intrinsics.areEqual(r105, r102.getIdentifier()) == false) goto L27;
        Unit r106 = Unit.INSTANCE;     // Catch: Throwable -> L28
        monitor-exit(r103);
        return;
    L27:
        throw new PrewarmSessionConflictException("prepared prewarm was stopped before start");     // Catch: Throwable -> L28
    L20:
        r105 = null;
    L28:
        th = move-exception;
        throw th;
    L31:
        p(r100);
        throw new IllegalStateException("prewarm_location_unavailable");
    L4:
        if (StringsKt.isBlank(r100) == true) goto L7;
        r101 = false;
        goto L8
    }

    public final b i(String r100) {
        b r101 = null;
        if (r100 != null) goto L5;
    L28:
        return null;
    L5:
        if ((!StringsKt.isBlank(r100)) == true) goto L8;
        r100 = null;
    L8:
        if (r100 == null) goto L28;
        Object r102 = this.f359913f;
        monitor-enter(r102);
        c r103 = this.f359914g;     // Catch: Throwable -> L25
        if (r103 != null) goto L16;
    L23:
        monitor-exit(r102);
        return r101;
    L16:
        if (Intrinsics.areEqual(r103.getIdentifier(), r100) == false) goto L23;
        if (r103.f359927c == false) goto L23;
        if (r103.f359928d == false) goto L23;
        r101 = new b(r103.getIdentifier());     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        throw th;
    }

    public final void m(String r100) {
        Object r101 = this.f359913f;
        monitor-enter(r101);
        c r102 = this.f359914g;     // Catch: Throwable -> L18
        c r103 = null;
        if (r102 != null) goto L7;
    L13:
        monitor-exit(r101);
        if (r103 == null) goto L16;
        o("formal_start_failed", r103.getIdentifier());
    L16:
        e();
        return;
    L7:
        if (Intrinsics.areEqual(r102.getIdentifier(), r100) == true) goto L10;
        r102 = null;
    L10:
        if (r102 == null) goto L13;
        f(r102);     // Catch: Throwable -> L18
        r103 = r102;
    L18:
        th = move-exception;
        throw th;
    }

    public final void p(String r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        Object r101 = this.f359913f;
        monitor-enter(r101);
        c r102 = this.f359914g;     // Catch: Throwable -> L23
        if (r102 != null) goto L9;
    L21:
        monitor-exit(r101);
        return;
    L9:
        if (Intrinsics.areEqual(r102.getIdentifier(), r100) == true) goto L12;
        r102 = null;
    L12:
        if (r102 == null) goto L21;
        if (Intrinsics.areEqual(this.f359917j, r102.getIdentifier()) == false) goto L17;
        this.f359917j = null;     // Catch: Throwable -> L23
    L17:
        f(r102);     // Catch: Throwable -> L23
        monitor-exit(r101);
        o("prewarm_location_unavailable", r102.getIdentifier());
        return;
    L23:
        th = move-exception;
        throw th;
    }

    public static void l(String r100, String r101) {
        LocationService.f286873a.p(r100, r101);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        int r102 = com.larus.navigation.api.c.f359656a;
        com.larus.navigation.api.c.c("locator", "stopLocate threw: reason=" + r100 + " identifier=" + r101 + " message=" + e.getMessage(), e);
    }

    public static void o(String r100, String r101) {
        LocationService.f286873a.g(r100, r101);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        int r102 = com.larus.navigation.api.c.f359656a;
        com.larus.navigation.api.c.c("locator", "stopNavigationLocationOnly threw: reason=" + r100 + " identifier=" + r101 + " message=" + e.getMessage(), e);
    }

    @Override // e37.a
    public final void c(c37.a r100, NavigationController.i r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "listener");
        if (j(r100, r101) != LocationResult.SUCCESS) goto L6;
        return;
    L6:
        throw new IllegalStateException("formal_location_start_failed");
    }

    @Override // e37.a
    public final void d(int r100, float r101) {
        String r102 = this.f359922o;
        if (this.f359920m == true) goto L5;
        return;
    L5:
        if (this.f359921n == false) goto L17;
        if (r102 != null) goto L8;
    L11:
        boolean r103 = true;
    L12:
        if (r103 == true) goto L18;
        LocationService.f286873a.updateNavigationHint(r102, r100, r101);
        return;
    L18:
        return;
    L8:
        if (r102.length() == 0) goto L11;
        r103 = false;
        goto L12
    }

    public final LocationResult j(c37.a r110, e37.b r111) {
        Long r100 = r110.f22278a;
        if (r100 == null) goto L5;
        long r101 = r100.longValue();
    L6:
        long r102 = r101;
        boolean r103 = false;
        if (r110.f22280c == null) goto L14;
        com.larus.navigation.impl.platform.e r104 = com.larus.navigation.impl.platform.c.f359933a.f359935b;
        if (r104 == null) goto L11;
        boolean r105 = r104.f359936a;
    L12:
        if (r105 == false) goto L14;
        boolean r106 = true;
    L15:
        int r107 = com.larus.navigation.api.c.f359656a;
        com.larus.navigation.api.c.d("locator", "startContinuousLocation, interval=" + r102 + ", businessTag=" + r110.f22279b + ", navigationId=" + r110.f22280c);
        if (q(r110, r111, r106, this.f359915h.get()) == true) goto L18;
        Object r108 = this.f359913f;
        monitor-enter(r108);
        this.f359923p = r111;     // Catch: Throwable -> L46
        com.larus.navigation.api.n.a r109 = com.larus.navigation.api.n.f359689a;     // Catch: Throwable -> L46
        com.larus.navigation.api.n.f359689a = this;     // Catch: Throwable -> L46
        this.f359921n = false;     // Catch: Throwable -> L46
        if (this.f359920m == false) goto L28;
        String r112 = this.f359922o;     // Catch: Throwable -> L46
        if (r112 == null) goto L28;
        if ((!StringsKt.isBlank(r112)) == false) goto L28;
    L30:
        if (this.f359920m == false) goto L32;
        this.f359920m = false;     // Catch: Throwable -> L46
        this.f359922o = null;     // Catch: Throwable -> L46
        this.f359909b = null;     // Catch: Throwable -> L46
        this.f359908a = 0;     // Catch: Throwable -> L46
    L32:
        monitor-exit(r108);
        if (r112 == null) goto L35;
        com.larus.navigation.api.c.d("locator", "stream active — stop + restart underlying BDLocation before rebinding listener");
        l("locator_swap_restart", r112);
    L35:
        h1 r113 = g0.f365740a.d();
        boolean r114 = com.larus.navigation.api.k.f359663a;
        if (com.larus.navigation.api.k.f359663a == false) goto L45;
        if (r113 != null) goto L39;
    L41:
        if (r103 == false) goto L45;
        com.larus.navigation.api.c.d("locator", "using fake location replay");
        this.f359919l = true;
        Math.max(r102, 3000);
        r113.e(new e());
        return LocationResult.SUCCESS;
    L39:
        if (r113.c() != true) goto L41;
        r103 = true;
    L45:
        return k(r110, r111, r102, r106);
    L28:
        r112 = null;
    L46:
        th = move-exception;
        throw th;
    L18:
        return LocationResult.SUCCESS;
    L11:
        r105 = false;
    L14:
        r106 = false;
        goto L15
    L5:
        r101 = 1000;
        goto L6
    }

    public final void n(String r100, String r101) {
        Object r102 = this.f359913f;
        monitor-enter(r102);
        c r103 = this.f359914g;     // Catch: Throwable -> L20
        if (r103 != null) goto L8;
    L13:
        r103 = null;
    L15:
        monitor-exit(r102);
        if (r103 != null) goto L18;
        return;
    L18:
        o(r100, r103.getIdentifier());
        int r104 = com.larus.navigation.api.c.f359656a;
        com.larus.navigation.api.c.d("locator", "prewarm stopped: reason=" + r100 + " identifier=" + r103.getIdentifier());
        return;
    L8:
        if (Intrinsics.areEqual(this.f359917j, r103.getIdentifier()) == true) goto L13;
        if (r101 != null) goto L12;
    L14:
        f(r103);     // Catch: Throwable -> L20
        goto L15
    L12:
        if (Intrinsics.areEqual(r103.getIdentifier(), r101) == true) goto L14;
    L20:
        th = move-exception;
        throw th;
    }

    public final Object r(b r100, String r110, com.larus.navigation.impl.l r111) {
        Intrinsics.checkNotNullParameter(r111, "block");
        Object r101 = this.f359913f;
        monitor-enter(r101);
        c r102 = this.f359914g;     // Catch: Throwable -> L67
        String r103 = null;
        if (this.f359916i == false) goto L7;
    L30:
        boolean r104 = true;
    L31:
        if (r104 == false) goto L40;
        StringBuilder r112 = new StringBuilder("formal identifier=");     // Catch: Throwable -> L67
        if (r110 != null) goto L35;
        r110 = "none";
    L35:
        r112.append(r110);     // Catch: Throwable -> L67
        r112.append(" conflicts with prewarm identifier=");     // Catch: Throwable -> L67
        if (r102 == null) goto L38;
        r103 = r102.getIdentifier();     // Catch: Throwable -> L67
    L38:
        r112.append(r103);     // Catch: Throwable -> L67
        throw new PrewarmSessionConflictException(r112.toString());     // Catch: Throwable -> L67
    L40:
        this.f359916i = true;     // Catch: Throwable -> L67
        if (r100 == null) goto L43;
        String r113 = r100.getIdentifier();     // Catch: Throwable -> L67
    L44:
        this.f359917j = r113;     // Catch: Throwable -> L67
        Unit r114 = Unit.INSTANCE;     // Catch: Throwable -> L67
        monitor-exit(r101);
        if (r100 != null) goto L48;
        this.f359915h.remove();     // Catch: Throwable -> L58
    L49:
        Object r105 = r111.invoke();     // Catch: Throwable -> L58
        this.f359915h.remove();
        Object r115 = this.f359913f;
        monitor-enter(r115);
        this.f359917j = null;     // Catch: Throwable -> L55
        this.f359916i = false;     // Catch: Throwable -> L55
        monitor-exit(r115);
        return r105;
    L55:
        th = move-exception;
        throw th;
    L48:
        this.f359915h.set(r100);     // Catch: Throwable -> L58
    L58:
        th = move-exception;
        this.f359915h.remove();
        monitor-enter(this.f359913f);
        this.f359917j = null;     // Catch: Throwable -> L64
        this.f359916i = false;     // Catch: Throwable -> L64
        Unit r116 = Unit.INSTANCE;     // Catch: Throwable -> L64
        throw th;
    L64:
        th = move-exception;
        throw th;
    L43:
        r113 = null;
        goto L44
    L7:
        if (this.f359920m == true) goto L30;
        if (this.f359923p != null) goto L30;
        if (r100 == null) goto L22;
        if (r102 == null) goto L30;
        if (Intrinsics.areEqual(r110, r100.getIdentifier()) == false) goto L30;
        if (Intrinsics.areEqual(r102.getIdentifier(), r100.getIdentifier()) == false) goto L30;
        if (r102.f359928d == false) goto L30;
        if (r102.f359927c == false) goto L30;
    L29:
        r104 = false;
        goto L31
    L22:
        if (r110 == null) goto L29;
        if (r102 == null) goto L25;
        String r106 = r102.getIdentifier();     // Catch: Throwable -> L67
    L27:
        if (Intrinsics.areEqual(r106, r110) == false) goto L29;
    L25:
        r106 = null;
    L67:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v2, types: [c37.a, e37.b, java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v6 */
    public final LocationResult k(c37.a r210, e37.b r211, long r212, boolean r213) {
        String r100 = UUID.randomUUID().toString();
        Object r101 = this.f359913f;
        monitor-enter(r101);
        this.f359922o = r100;     // Catch: Throwable -> L62
        this.f359923p = r211;     // Catch: Throwable -> L62
        this.f359920m = true;     // Catch: Throwable -> L62
        this.f359909b = null;     // Catch: Throwable -> L62
        this.f359908a = 0;     // Catch: Throwable -> L62
        i r110 = new i(this, new Ref.IntRef(), r213, r100);     // Catch: Throwable -> L62
        this.f359918k = r110;     // Catch: Throwable -> L62
        monitor-exit(r101);
        JSONObject r102 = new JSONObject();
        r102.put("navigation_id", r210.f22280c);
        if (r213 == false) goto L36;
        int r103 = com.larus.navigation.api.c.f359656a;
        com.larus.navigation.api.c.d("locator", "starting fusion continuous locate, routePlanType=" + r210.f22281d);
        LocationService.Companion r104 = LocationService.f286873a;
        CoordinateType r105 = CoordinateType.GCJ_O2;
        Integer r106 = r210.f22281d;
        if (r106 == null) goto L15;
        if (r106.intValue() != 0) goto L15;
        int r111 = 1;
    L31:
        e37.j r107 = r210.f22282e;
        if (r107 == null) goto L34;
        String r112 = j.a(r107);
    L35:
        ?? r108 = 0;
        LocationResult r109 = r104.o(r212, r105, r102, r110, 7, 2, r111, r100, r112);
    L42:
        if (r109 == LocationResult.SUCCESS) goto L52;
        int r113 = com.larus.navigation.api.c.f359656a;
        com.larus.navigation.api.c.b("locator", "continuousLocate failed: " + r109.getMessage());
        Object r114 = this.f359913f;
        monitor-enter(r114);
        this.f359922o = r108;     // Catch: Throwable -> L49
        this.f359923p = r108;     // Catch: Throwable -> L49
        this.f359920m = false;     // Catch: Throwable -> L49
        this.f359921n = false;     // Catch: Throwable -> L49
        this.f359909b = r108;     // Catch: Throwable -> L49
        this.f359908a = 0;     // Catch: Throwable -> L49
        Unit r115 = Unit.INSTANCE;     // Catch: Throwable -> L49
        monitor-exit(r114);
        r211.onError(r109.ordinal(), r109.getMessage());
        return r109;
    L49:
        th = move-exception;
        throw th;
    L52:
        Object r116 = this.f359913f;
        monitor-enter(r116);
        this.f359921n = r213;     // Catch: Throwable -> L59
        this.f359909b = r210;     // Catch: Throwable -> L59
        Unit r117 = Unit.INSTANCE;     // Catch: Throwable -> L59
        monitor-exit(r116);
        int r118 = com.larus.navigation.api.c.f359656a;
        com.larus.navigation.api.c.d("locator", "stream started: identifier=" + r100);
        return r109;
    L59:
        th = move-exception;
        throw th;
    L34:
        r112 = null;
    L15:
        if (r106 != null) goto L18;
    L19:
        if (r106 != null) goto L22;
    L24:
        if (r106 != null) goto L27;
    L29:
        r111 = 0;
        goto L31
    L27:
        if (r106.intValue() != 3) goto L29;
        r111 = 3;
        goto L31
    L22:
        if (r106.intValue() != 2) goto L24;
    L30:
        r111 = 2;
        goto L31
    L18:
        if (r106.intValue() == 1) goto L30;
    L36:
        r108 = 0;
        LocationService.Companion r119 = LocationService.f286873a;
        CoordinateType r120 = CoordinateType.GCJ_O2;
        e37.j r121 = r210.f22282e;
        if (r121 == null) goto L39;
        String r122 = j.a(r121);
    L40:
        r109 = r119.h(r212, r120, r102, r110, r100, r122);
        goto L42
    L39:
        r122 = null;
    L62:
        th = move-exception;
        throw th;
    }

    public final boolean q(c37.a r100, e37.b r101, boolean r102, b r103) {
        if (r103 != null) goto L5;
        return false;
    L5:
        h(r103.getIdentifier());
        String r104 = r100.f22280c;
        if (r104 == null) goto L36;
        Object r105 = this.f359913f;
        monitor-enter(r105);
        c r106 = this.f359914g;     // Catch: Throwable -> L32
        if (r106 == null) goto L31;
        if (Intrinsics.areEqual(r106.getIdentifier(), r103.getIdentifier()) == false) goto L29;
        if (r102 == false) goto L27;
        if (r106.f359927c == false) goto L27;
        if (r106.f359928d == false) goto L27;
        if (this.f359920m == true) goto L27;
        if (this.f359923p != null) goto L27;
        f(r106);     // Catch: Throwable -> L32
        this.f359922o = r106.getIdentifier();     // Catch: Throwable -> L32
        this.f359918k = r106.f359926b;     // Catch: Throwable -> L32
        this.f359920m = true;     // Catch: Throwable -> L32
        this.f359923p = r101;     // Catch: Throwable -> L32
        this.f359921n = true;     // Catch: Throwable -> L32
        this.f359909b = r100;     // Catch: Throwable -> L32
        this.f359908a = 0;     // Catch: Throwable -> L32
        com.larus.navigation.api.n.a r107 = com.larus.navigation.api.n.f359689a;     // Catch: Throwable -> L32
        com.larus.navigation.api.n.f359689a = this;     // Catch: Throwable -> L32
        monitor-exit(r105);
        int r108 = com.larus.navigation.api.c.f359656a;
        com.larus.navigation.api.c.d("locator", "promoting prewarm in place: identifier=" + r106.getIdentifier() + " navigationId=" + r100.f22280c);
        LocationService.f286873a.n(r106.getIdentifier(), r104);
        StringBuilder r109 = new StringBuilder("prewarm promoted: identifier=");
        r109.append(r106.getIdentifier());
        com.larus.navigation.api.c.d("locator", r109.toString());
        return true;
    L27:
        throw new PrewarmSessionConflictException("prepared prewarm is not a live L1 stream");     // Catch: Throwable -> L32
    L29:
        throw new PrewarmSessionConflictException("prepared prewarm was replaced before promotion");     // Catch: Throwable -> L32
    L31:
        throw new PrewarmSessionConflictException("prepared prewarm was stopped before promotion");     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        throw th;
    L36:
        throw new PrewarmSessionConflictException("prepared prewarm requires a navigation ID");
    }
}
