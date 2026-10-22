package e19;

import android.os.Handler;
import android.view.View;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.floatwindow.manager.FloatPriority;
import com.larus.common_ui.floatwindow.view.SingleFloatWindowState;
import com.larus.utils.logger.FLogger;
import hq9.f1;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class t implements i {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static t f470740j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f470741a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final k f470742b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.larus.common_ui.floatwindow.view.c f470743c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f470744d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f470745e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f470746f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f470747g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f470748h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f470749i;

    public static final class a {
        public static t a() {
            if (t.f470740j != null) goto L16;
            monitor-enter(t.class);
        L12:
            th = move-exception;
            throw th;
        L7:
            if (t.f470740j != null) goto L9;
            t.f470740j = new t();     // Catch: Throwable -> L12
        L9:
            Unit r100 = Unit.INSTANCE;     // Catch: Throwable -> L12
            monitor-exit(t.class);
        L16:
            return t.f470740j;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final SingleFloatWindowState f470750a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f470751b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f470752c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (this.f470750a == r101.f470750a) goto L12;
            return false;
        L12:
            if (this.f470751b == r101.f470751b) goto L15;
            return false;
        L15:
            if (this.f470752c == r101.f470752c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f470750a.hashCode() * 31;
            if (this.f470751b == false) goto L5;
            int r101 = 1231;
        L6:
            int r102 = (r100 + r101) * 31;
            long r103 = this.f470752c;
            return r102 + ((int) (r103 ^ (r103 >>> 32)));
        L5:
            r101 = 1237;
            goto L6
        }

        public final String toString() {
            return "RequestFloatWindowRequirement(targetWindowState=" + this.f470750a + ", animateIfRequired=" + this.f470751b + ", autoShrinkDelayTime=" + this.f470752c + ')';
        }

        public b(SingleFloatWindowState r100, boolean r101, long r102) {
            Intrinsics.checkNotNullParameter(r100, "targetWindowState");
            this.f470750a = r100;
            this.f470751b = r101;
            this.f470752c = r102;
        }
    }

    static {
    }

    public final void b() {
        if (this.f470744d == false) goto L5;
        return;
    L5:
        FLogger r100 = FLogger.f375446a;
        r100.d("MutexFloatManager", "alphaShowFloatWindow.");
        com.larus.common_ui.floatwindow.view.c r101 = this.f470743c;
        r101.f327489c.e();
        r101.f327490d = true;
        r100.d("FloatController", "alphaShowFloatWindow");
        this.f470744d = true;
        h r102 = this.f470742b.f470733a;
        if (r102 == null) goto L9;
        r102.onWindowShow();
        return;
    }

    public final f1 f() {
        return (f1) this.f470741a.getValue();
    }

    public final ConcurrentHashMap<h, b> g() {
        return (ConcurrentHashMap) this.f470745e.getValue();
    }

    public final void h() {
        if (this.f470742b.f470733a == null) goto L6;
        FLogger.f375446a.i("MutexFloatManager", "handleNextRequest ignored due to current");
        return;
    L6:
        FLogger.f375446a.d("MutexFloatManager", "handleNextRequest.");
        i(this.f470742b.f470734b.poll());
    }

    public final void l() {
        h r100 = this.f470742b.f470733a;
        if (r100 == null) goto L5;
        FLogger.f375446a.d("MutexFloatManager", "removeCurrentRequest. contentView:" + r100.getContentView());
        this.f470743c.a(r100.getContentView());
        r100.a();
        b r101 = g().remove(r100);
    L5:
        this.f470742b.f470733a = null;
    }

    public t() {
        this.f470741a = LazyKt.lazy(new m());
        this.f470742b = new k();
        this.f470743c = new com.larus.common_ui.floatwindow.view.c(AppHost.f326268a.getApplication());
        this.f470745e = LazyKt.lazy(new n());
        this.f470746f = LazyKt.lazy(new o(this));
        this.f470747g = LazyKt.lazy(new p());
        this.f470748h = LazyKt.lazy(new q());
        this.f470749i = LazyKt.lazy(new r());
    }

    public final void d(final h r100) {
        this.f470742b.f470733a = r100;
        if (r100 == null) goto L29;
        SingleFloatWindowState r101 = null;
        k(null);
        FLogger.f375446a.d("MutexFloatManager", "handleRequest. contentView:" + r100.getContentView() + " width:" + r100.getWidth() + " height:" + r100.getHeight());
        b r102 = g().get(r100);
        if (r102 != null) goto L7;
        r102 = null;
    L12:
        g().remove(r100);
        this.f470743c.b(r100.n0());
        com.larus.common_ui.floatwindow.view.c r103 = this.f470743c;
        if (r102 == null) goto L15;
        r101 = r102.f470750a;
    L15:
        if (r102 == null) goto L17;
        boolean r104 = r102.f470751b;
    L18:
        r103.c(r100, r101, r104);
        r100.b();
        if (r100.n0() == true) goto L32;
        if (r102 == null) goto L30;
        long r105 = Long.valueOf(r102.f470752c).longValue();
        if (r105 > 0) goto L25;
        return;
    L25:
        if (r102.f470750a != SingleFloatWindowState.MAXIMIZE) goto L33;
        Runnable r106 = new s(this, r100);
        ((Map) this.f470749i.getValue()).put(r100, r106);
        ((Handler) this.f470748h.getValue()).postDelayed(r106, r105);
        return;
    L33:
        return;
    L30:
        return;
    L32:
        return;
    L17:
        r104 = false;
        goto L18
    L7:
        if (f().c() == false) goto L12;
        if (f().f() == false) goto L12;
        ((List) this.f470746f.getValue()).add(r100.k());
        goto L12
    }

    public final int e(h r110) {
        Intrinsics.checkNotNullParameter(r110, "request");
        FLogger r100 = FLogger.f375446a;
        r100.d("MutexFloatManager", "enqueueRequest. contentView:" + r110.getContentView());
        boolean r101 = false;
        if (this.f470742b.f470734b.size() < 128) goto L5;
        boolean r102 = true;
    L7:
        if (r102 == false) goto L9;
    L78:
        r100.d("MutexFloatManager", "enqueueRequest same.");
        h r103 = this.f470742b.f470733a;
        if (r103 == null) goto L82;
        r100.d("MutexFloatManager", "enqueueRequest updateView. currentView:" + r103.getContentView() + " width:" + r103.getWidth() + " height:" + r103.getHeight());
        this.f470743c.b(r103.n0());
        this.f470743c.c(r103, null, false);
    L82:
        if (Intrinsics.areEqual(this.f470742b.f470733a, r110) == true) goto L88;
        return 2;
    L88:
        return 1;
    L9:
        if (this.f470742b.f470734b.contains(r110) == false) goto L11;
    L14:
        boolean r104 = true;
    L15:
        if (r104 == true) goto L78;
        h r105 = this.f470742b.f470733a;
        if (r105 == null) goto L20;
        FloatPriority r106 = r105.getPriority();
    L21:
        FloatPriority r107 = r110.getPriority();
        long r111 = 0;
        if (f().d() == false) goto L45;
        h r112 = this.f470742b.f470733a;
        if (r112 == null) goto L26;
        String r113 = r112.k();
    L28:
        if (Intrinsics.areEqual(r113, r110.k()) == true) goto L45;
        if (((List) this.f470746f.getValue()).contains(r110.k()) == true) goto L45;
        ConcurrentHashMap<h, b> r114 = g();
        if (f().f() == false) goto L34;
        SingleFloatWindowState r115 = SingleFloatWindowState.MINIMIZE;
    L36:
        if (this.f470742b.f470733a == null) goto L38;
        boolean r116 = true;
    L40:
        if (f().f() == true) goto L43;
        r111 = f().b();
    L43:
        r114.put(r110, new b(r115, r116, r111));
    L50:
        if (r106 != null) goto L52;
    L67:
        if (r106 != null) goto L69;
    L76:
        r100.d("MutexFloatManager", "enqueueRequest put into queue.");
        this.f470742b.f470734b.add(r110);
        h();
        return 2;
    L69:
        if (Intrinsics.areEqual(r107, r106) == false) goto L76;
        r100.d("MutexFloatManager", "enqueueRequest replace current request due to same priority");
        if (this.f470744d == false) goto L75;
        h r108 = this.f470742b.f470733a;
        if (r108 == null) goto L75;
        r108.onWindowDismiss();
    L75:
        l();
        i(r110);
        return 1;
    L52:
        if (r107.compareTo(r106) <= 0) goto L67;
        r100.d("MutexFloatManager", "enqueueRequest replace current request.");
        h r109 = this.f470742b.f470733a;
        if (r109 != null) goto L56;
    L58:
        if (r101 == false) goto L65;
        r100.d("MutexFloatManager", "enqueueRequest requeue current request due to higher priority");
        h r117 = this.f470742b.f470733a;
        if (r117 == null) goto L64;
        r100.d("MutexFloatManager", "requeueCurrentRequest. contentView:" + r117.getContentView());
        this.f470743c.a(r117.getContentView());
        this.f470742b.f470734b.add(r117);
        if (this.f470744d == false) goto L64;
        r117.onWindowDismiss();
    L64:
        this.f470742b.f470733a = null;
    L66:
        i(r110);
        return 1;
    L65:
        r100.d("MutexFloatManager", "enqueueRequest replace current request due to higher priority");
        l();
        goto L66
    L56:
        if (r109.f() != true) goto L58;
        r101 = true;
        goto L58
    L38:
        r116 = false;
        goto L40
    L34:
        r115 = SingleFloatWindowState.MAXIMIZE;
        goto L36
    L26:
        r113 = null;
    L45:
        if (f().d() == false) goto L50;
        if (r106 != null) goto L50;
        if (((List) this.f470747g.getValue()).contains(r110.k()) == false) goto L50;
        g().put(r110, new b(SingleFloatWindowState.MINIMIZE, false, 0));
        goto L50
    L20:
        r106 = null;
        goto L21
    L11:
        if (Intrinsics.areEqual(this.f470742b.f470733a, r110) == true) goto L14;
        r104 = false;
        goto L15
    L5:
        r102 = false;
        goto L7
    }

    public final void i(final h r100) {
        if (r100 != null) goto L6;
        this.f470742b.f470733a = null;
        return;
    L6:
        if (this.f470744d == false) goto L11;
        if (r100.i() == false) goto L11;
        i.a.a(this, new l(this, r100), 1);
        return;
    L11:
        if (this.f470744d == true) goto L16;
        if (r100.i() == true) goto L16;
        d(r100);
        b();
        return;
    L16:
        if (this.f470744d == true) goto L18;
    L20:
        d(r100);
        return;
    L18:
        if (r100.i() == true) goto L20;
        d(r100);
        r100.onWindowShow();
    }

    public final boolean j(h r100) {
        return Intrinsics.areEqual(this.f470742b.f470733a, r100);
    }

    public final void k(h r100) {
        if (f().d() == true) goto L5;
        return;
    L5:
        if (f().f() == true) goto L16;
        if (r100 != null) goto L10;
        ((Handler) this.f470748h.getValue()).removeCallbacksAndMessages(null);
        return;
    L10:
        Runnable r101 = (Runnable) ((Map) this.f470749i.getValue()).get(r100);
        if (r101 == null) goto L15;
        ((Handler) this.f470748h.getValue()).removeCallbacks(r101);
        Runnable r102 = (Runnable) ((Map) this.f470749i.getValue()).remove(r100);
        return;
    L15:
        return;
    }

    public final void m(h r100) {
        Intrinsics.checkNotNullParameter(r100, "request");
        FLogger r101 = FLogger.f375446a;
        r101.d("MutexFloatManager", "removeRequest. contentView:" + r100.getContentView());
        k(r100);
        if (Intrinsics.areEqual(this.f470742b.f470733a, r100) == false) goto L5;
        r101.d("MutexFloatManager", "removeRequest. remove current and handle next request");
        l();
        h();
        return;
    L5:
        r101.d("MutexFloatManager", "removeRequest. remove from queue");
        g().remove(r100);
        this.f470742b.f470734b.remove(r100);
    }

    public final void n(h r100) {
        Intrinsics.checkNotNullParameter(r100, "request");
        h r101 = this.f470742b.f470733a;
        if (r101 == null) goto L5;
        View r102 = r101.getContentView();
    L7:
        if (Intrinsics.areEqual(r102, r100.getContentView()) == false) goto L10;
        FLogger.f375446a.d("MutexFloatManager", "updateRequestViewSize. currentView:" + r100.getContentView() + " width:" + r100.getWidth() + " height:" + r100.getHeight());
        this.f470743c.b(r100.n0());
        this.f470743c.c(r100, null, false);
        return;
    L10:
        return;
    L5:
        r102 = null;
        goto L7
    }

    @Override // e19.i
    public final void a(String r100, final Function0<Unit> r101) {
        if (this.f470744d == true) goto L7;
        if (r101 == null) goto L21;
        r101.invoke();
        return;
    L21:
        return;
    L7:
        if (r100 == null) goto L17;
        h r102 = this.f470742b.f470733a;
        if (r102 == null) goto L11;
        String r103 = r102.k();
    L13:
        if (Intrinsics.areEqual(r103, r100) == true) goto L17;
        if (r101 == null) goto L22;
        r101.invoke();
        return;
    L22:
        return;
    L11:
        r103 = null;
    L17:
        FLogger r104 = FLogger.f375446a;
        r104.d("MutexFloatManager", "hideFloatWindow.");
        final com.larus.common_ui.floatwindow.view.c r105 = this.f470743c;
        r105.f327489c.a(new com.larus.common_ui.floatwindow.view.a(r105, r101));
        r104.d("FloatController", "alphaHideFloatWindow");
        this.f470744d = false;
        h r106 = this.f470742b.f470733a;
        if (r106 == null) goto L23;
        r106.onWindowDismiss();
        return;
    }

    public final void c(SingleFloatWindowState r100, boolean r101) {
        FLogger r102 = FLogger.f375446a;
        r102.d("MutexFloatManager", "changeWindowState. windowState:" + r100 + " animateIfRequired:" + r101);
        com.larus.common_ui.floatwindow.view.c r103 = this.f470743c;
        r103.getClass();
        r102.d("FloatController", "changeWindowState. windowState:" + r100);
        r103.f327489c.b(r100, r101);
    }
}
