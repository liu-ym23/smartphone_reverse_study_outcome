package i2;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.core.os.HandlerCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.ai.model.AppletRuntimeManager;
import com.bytedance.ai.model.objects.PageInfo;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import k2.s;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class f extends g implements Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Lazy<f> f488023i = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public i2.a f488024a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public FrameLayout f488025b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f488026c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public WeakReference<FrameLayout> f488027d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public WeakReference<Activity> f488028e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public s f488029f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f488030g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f488031h;

    public static final class a {
        public static f a() {
            return f.f488023i.getValue();
        }
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f488032a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Activity f488033b;

        public b(f r100, Activity r101) {
            this.f488032a = r100;
            this.f488033b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f488032a.p(this.f488033b);     // Catch: Throwable -> L4
            this.f488032a.k(this.f488033b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "p0");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "p0");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        Intrinsics.checkNotNullParameter(r101, "p1");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "p0");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "p0");
    }

    static {
        f488023i = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, new c());
    }

    @Override // i2.j
    public final boolean e() {
        WeakReference<FrameLayout> r100 = this.f488027d;
        if (r100 == null) goto L11;
        FrameLayout r101 = r100.get();
        if (r101 == null) goto L11;
        i2.a r102 = this.f488024a;
        if (r102 == null) goto L11;
        if (r101.indexOfChild(r102) == (-1)) goto L11;
        return true;
    L11:
        return false;
    }

    @Override // i2.j
    public final boolean h() {
        if (this.f488029f == null) goto L5;
        return true;
    L5:
        return false;
    }

    public f() {
        this.f488026c = true;
        this.f488030g = LazyKt.lazy(new e());
        AtomicBoolean r100 = f2.b.f475097a;
        h2.a r101 = f2.b.f475099c;
        Application r102 = null;
        if (r101 == null) goto L5;
        Context r103 = r101.f483562a;
    L7:
        if ((r103 instanceof Application) == false) goto L9;
        r102 = (Application) r103;
    L9:
        if (r102 == null) goto L11;
        r102.registerActivityLifecycleCallbacks(this);
    L11:
        this.f488031h = R.layout.layout_floating_view;
        return;
    L5:
        r103 = null;
        goto L7
    }

    @Override // i2.j
    public final s j() {
        return this.f488029f;
    }

    public static FrameLayout o(Activity r100) {
        if (r100 != null) goto L46;
        return null;
    L46:
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L24
        if ((r100 instanceof FragmentActivity) == false) goto L8;
        FragmentActivity r102 = (FragmentActivity) r100;     // Catch: Throwable -> L24
    L9:
        if (r102 == null) goto L17;
        FragmentManager r103 = r102.getSupportFragmentManager();     // Catch: Throwable -> L24
        if (r103 == null) goto L17;
        List<Fragment> r104 = r103.getFragments();     // Catch: Throwable -> L24
        if (r104 == null) goto L17;
        Fragment r105 = (Fragment) CollectionsKt.lastOrNull(r104);     // Catch: Throwable -> L24
        if (r105 == null) goto L17;
        View r106 = r105.getView();     // Catch: Throwable -> L24
    L19:
        if ((r106 instanceof FrameLayout) == false) goto L21;
        FrameLayout r107 = (FrameLayout) r106;     // Catch: Throwable -> L24
    L22:
        Object r108 = Result.m9449constructorimpl(r107);     // Catch: Throwable -> L24
    L27:
        if (Result.m9455isFailureimpl(r108) == false) goto L29;
        r108 = null;
    L29:
        FrameLayout r109 = (FrameLayout) r108;
        if (r109 == null) goto L44;
        return r109;
    L44:
        View r110 = r100.getWindow().getDecorView();     // Catch: ClassCastException -> L39
        if (com.larus.home.impl.utils.c.f346345e == false) goto L37;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");     // Catch: ClassCastException -> L39
        Thread r111 = ThreadMethodProxy.currentThread();     // Catch: ClassCastException -> L39
        if (r111 == com.larus.home.impl.utils.c.f346341a) goto L37;
        com.larus.home.impl.utils.c.a(r111, "getDecorView");     // Catch: ClassCastException -> L39
    L37:
        Intrinsics.checkNotNull(r110, "null cannot be cast to non-null type android.widget.FrameLayout");     // Catch: ClassCastException -> L39
        return (FrameLayout) r110;
    L39:
        e = move-exception;
        String r112 = e.getMessage();
        if (r112 == null) goto L43;
        com.bytedance.ai.utils.g.f37637a.e("WebViewFloatingPage", r112);
    L43:
        return null;
    L21:
        r107 = null;
    L17:
        r106 = null;
        goto L19
    L8:
        r102 = null;
    L24:
        th = move-exception;
        Result.Companion r113 = Result.Companion;
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L27
    }

    @Override // i2.j
    public final boolean g(String r100) {
        Intrinsics.checkNotNullParameter(r100, "viewId");
        s r101 = this.f488029f;
        if (r101 == null) goto L5;
        String r102 = r101.getPageID();
    L7:
        if (Intrinsics.areEqual(r100, r102) == true) goto L10;
        return false;
    L10:
        WeakReference<Activity> r103 = this.f488028e;
        if (r103 == null) goto L15;
        Activity r104 = r103.get();
        if (r104 == null) goto L15;
        m(r104, true);
    L15:
        s r105 = this.f488029f;
        if (r105 == null) goto L18;
        r105.e();
    L18:
        this.f488029f = null;
        return true;
    L5:
        r102 = null;
        goto L7
    }

    public final boolean k(Activity r100) {
        if (this.f488028e != null) goto L6;
        if (r100 == null) goto L6;
        p(r100);
    L6:
        FrameLayout r101 = o(r100);
        i2.a r102 = this.f488024a;
        if (r102 != null) goto L10;
        if (r101 == null) goto L10;
        this.f488027d = new WeakReference(r101);
        return false;
    L10:
        ViewParent r103 = null;
        if (r102 == null) goto L13;
        ViewParent r104 = r102.getParent();
    L14:
        if (r104 != r101) goto L17;
        return false;
    L17:
        if (r101 != null) goto L19;
        com.bytedance.ai.utils.g.f37637a.e("WebViewFloatingPage", "FloatingViewManager attach FloatingView fail, container is null");
        return false;
    L19:
        i2.a r105 = this.f488024a;
        if (r105 == null) goto L22;
        ViewParent r106 = r105.getParent();
    L23:
        ViewGroup r107 = (ViewGroup) r106;
        if (r107 == null) goto L26;
        r107.removeView(this.f488024a);
    L26:
        FrameLayout r108 = this.f488025b;
        if (r108 == null) goto L29;
        r103 = r108.getParent();
    L29:
        ViewGroup r109 = (ViewGroup) r103;
        if (r109 == null) goto L32;
        r109.removeView(this.f488025b);
    L32:
        this.f488027d = new WeakReference(r101);
        FrameLayout r110 = this.f488025b;     // Catch: IllegalArgumentException -> L43 IllegalStateException -> L45
        if (r110 == null) goto L36;
        r101.addView(r110);     // Catch: IllegalArgumentException -> L43 IllegalStateException -> L45
    L36:
        i2.a r111 = this.f488024a;     // Catch: IllegalArgumentException -> L43 IllegalStateException -> L45
        if (r111 != null) goto L39;
    L41:
        com.bytedance.ai.utils.g.f37637a.d("WebViewFloatingPage", "FloatingViewManager attach FloatingView success");     // Catch: IllegalArgumentException -> L43 IllegalStateException -> L45
        return true;
    L39:
        if (this.f488026c == false) goto L41;
        r111.d();     // Catch: IllegalArgumentException -> L43 IllegalStateException -> L45
        r101.addView(r111);     // Catch: IllegalArgumentException -> L43 IllegalStateException -> L45
        r111.setVisibility(0);     // Catch: IllegalArgumentException -> L43 IllegalStateException -> L45
    L43:
        e = move-exception;
        com.bytedance.ai.utils.g.f37637a.e("WebViewFloatingPage", "FloatingViewManager attach FloatingView fail, msg=" + e.getMessage(), e);
        return false;
    L45:
        e = move-exception;
        com.bytedance.ai.utils.g.f37637a.e("WebViewFloatingPage", "FloatingViewManager attach FloatingView fail, msg=" + e.getMessage(), e);
        return false;
    L22:
        r106 = null;
        goto L23
    L13:
        r104 = null;
        goto L14
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        ((Handler) this.f488030g.getValue()).removeCallbacksAndMessages(r100);
        m(r100, false);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        HandlerCompat.postDelayed((Handler) this.f488030g.getValue(), new b(this, r100), r100, 100);
    }

    public final void p(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        this.f488028e = new WeakReference(r100);
        AppletRuntimeManager.INSTANCE.getClass();
        g2.b r101 = AppletRuntimeManager.f36749d;
        if (r101 == null) goto L10;
        Pair<Integer, Integer> r102 = r101.L(r100);
        if (r102 == null) goto L11;
        i2.a r103 = this.f488024a;
        if (r103 == null) goto L12;
        r103.e(r102);
        return;
    L12:
        return;
    L11:
        return;
    }

    @Override // i2.j
    public final boolean a(String r100, boolean r110) {
        Intrinsics.checkNotNullParameter(r100, "viewId");
        s r101 = this.f488029f;
        Unit r102 = null;
        if (r101 == null) goto L5;
        String r103 = r101.getPageID();
    L7:
        if (Intrinsics.areEqual(r100, r103) == true) goto L9;
        return false;
    L9:
        WeakReference<FrameLayout> r104 = this.f488027d;
        if (r104 == null) goto L38;
        FrameLayout r105 = r104.get();
        if (r105 == null) goto L38;
        i2.a r106 = this.f488024a;
        if (r106 == null) goto L36;
        com.bytedance.ai.utils.g r107 = com.bytedance.ai.utils.g.f37637a;
        r107.d("WebViewFloatingPage", "setFloatingWidgetVisible viewId=" + r100 + ", show=" + r110);
        if (r110 == true) goto L18;
        r105.removeView(r106);
        this.f488026c = false;
        s r111 = this.f488029f;
        if (r111 == null) goto L33;
        r111.i();
        r102 = Unit.INSTANCE;
    L33:
        if (r102 == null) goto L36;
        return true;
    L18:
        if (r105.indexOfChild(r106) == (-1)) goto L20;
        boolean r112 = true;
    L21:
        if (r112 == false) goto L24;
        r107.d("WebViewFloatingPage", "floating view already show, visible=" + r106.getVisibility() + ", top=" + r106.getTop() + ", left=" + r106.getLeft() + ", right=" + r106.getRight() + ", bottom=" + r106.getBottom());
        return true;
    L24:
        ViewGroup r113 = (ViewGroup) r106.getParent();
        if (r113 == null) goto L27;
        r113.removeView(r106);
    L27:
        r106.d();
        r105.addView(r106);
        this.f488026c = true;
        s r114 = this.f488029f;
        if (r114 == null) goto L33;
        r114.a();
        r102 = Unit.INSTANCE;
        goto L33
    L20:
        r112 = false;
    L36:
        IllegalStateException r108 = new IllegalStateException("FloatingView is null");
        com.bytedance.ai.utils.g.f37637a.e("WebViewFloatingPage", r108.getMessage(), r108);
        return false;
    L38:
        IllegalStateException r109 = new IllegalStateException("Container is null");
        com.bytedance.ai.utils.g.f37637a.e("WebViewFloatingPage", r109.getMessage(), r109);
        return false;
    L5:
        r103 = null;
        goto L7
    }

    @Override // i2.j
    public final boolean c(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "pageName");
        Intrinsics.checkNotNullParameter(r101, "packageName");
        s r102 = this.f488029f;
        if (r102 == null) goto L11;
        PageInfo r103 = r102.getPageInfo();
        if (r103 == null) goto L11;
        if (Intrinsics.areEqual(r103.getPageName(), r100) == false) goto L11;
        if (Intrinsics.areEqual(r103.getPackageName(), r101) == false) goto L11;
        return true;
    L11:
        return false;
    }

    public final f m(Activity r100, boolean r101) {
        FrameLayout r102 = o(r100);
        i2.a r103 = this.f488024a;     // Catch: IllegalArgumentException -> L30
        if (r103 != null) goto L6;
    L12:
        FrameLayout r104 = this.f488025b;     // Catch: IllegalArgumentException -> L30
        if (r104 != null) goto L15;
    L21:
        WeakReference<FrameLayout> r105 = this.f488027d;     // Catch: IllegalArgumentException -> L30
        if (r105 == null) goto L24;
        FrameLayout r106 = r105.get();     // Catch: IllegalArgumentException -> L30
    L25:
        if (r106 != r102) goto L27;
        this.f488027d = null;     // Catch: IllegalArgumentException -> L30
    L27:
        if (r101 == false) goto L34;
        this.f488024a = null;     // Catch: IllegalArgumentException -> L30
        this.f488025b = null;     // Catch: IllegalArgumentException -> L30
    L34:
        return this;
    L24:
        r106 = null;
        goto L25
    L15:
        if (ViewCompat.isAttachedToWindow(r104) == true) goto L18;
        r104 = null;
    L18:
        if (r104 == null) goto L21;
        if (r102 == null) goto L21;
        r102.removeView(r104);     // Catch: IllegalArgumentException -> L30
        goto L21
    L6:
        if (ViewCompat.isAttachedToWindow(r103) == true) goto L9;
        r103 = null;
    L9:
        if (r103 == null) goto L12;
        if (r102 == null) goto L12;
        r102.removeView(r103);     // Catch: IllegalArgumentException -> L30
    L30:
        e = move-exception;
        String r107 = e.getMessage();
        if (r107 == null) goto L34;
        com.bytedance.ai.utils.g.f37637a.e("WebViewFloatingPage", r107);
        goto L34
    }

    public final boolean n(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "viewId");
        s r102 = this.f488029f;
        if (r102 == null) goto L5;
        String r103 = r102.getPageID();
    L7:
        if (Intrinsics.areEqual(r100, r103) == true) goto L9;
        return false;
    L9:
        FrameLayout r104 = this.f488025b;
        if (r104 == null) goto L16;
        if (r101 == false) goto L13;
        r104.setVisibility(0);
        return true;
    L13:
        r104.setVisibility(8);
        return true;
    L16:
        return true;
    L5:
        r103 = null;
        goto L7
    }

    @Override // i2.j
    public final int d(s r100, PageInfo r101, FragmentActivity r110) {
        Intrinsics.checkNotNullParameter(r100, "page");
        Intrinsics.checkNotNullParameter(r101, "pageInfo");
        double r102 = r101.getPos();
        boolean r103 = r101.getAlignLeft();
        Intrinsics.checkNotNullParameter(r100, "webViewFloatingPage");
        monitor-enter(this);
        h2.a r104 = f2.b.f475099c;     // Catch: Throwable -> L51
        if (r104 == null) goto L7;
        Context r105 = r104.f483562a;     // Catch: Throwable -> L51
    L9:
        if (this.f488024a != null) goto L35;
        if (r105 == null) goto L35;
        i2.a r106 = new i2.a(r105, this.f488031h);     // Catch: Throwable -> L51
        this.f488024a = r106;     // Catch: Throwable -> L51
        r106.setFirstPos(r102);     // Catch: Throwable -> L51
        FrameLayout.LayoutParams r107 = new FrameLayout.LayoutParams(-2, -2);     // Catch: Throwable -> L51
        if (r103 == false) goto L15;
        int r108 = GravityCompat.START;
    L16:
        r107.gravity = r108 | 48;     // Catch: Throwable -> L51
        r107.setMargins(0, r107.topMargin, 0, r107.bottomMargin);     // Catch: Throwable -> L51
        r106.setLayoutParams(r107);     // Catch: Throwable -> L51
        FrameLayout r109 = new FrameLayout(r105);     // Catch: Throwable -> L51
        this.f488025b = r109;     // Catch: Throwable -> L51
        r109.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));     // Catch: Throwable -> L51
        FrameLayout r111 = this.f488025b;     // Catch: Throwable -> L51
        if (r111 == null) goto L19;
        r111.setBackgroundColor(-16777216);     // Catch: Throwable -> L51
    L19:
        FrameLayout r112 = this.f488025b;     // Catch: Throwable -> L51
        if (r112 == null) goto L24;
        Drawable r113 = r112.getBackground();     // Catch: Throwable -> L51
        if (r113 == null) goto L24;
        r113.setAlpha(40);     // Catch: Throwable -> L51
    L24:
        FrameLayout r114 = this.f488025b;     // Catch: Throwable -> L51
        if (r114 == null) goto L27;
        r114.setVisibility(4);     // Catch: Throwable -> L51
    L27:
        FrameLayout r115 = this.f488025b;     // Catch: Throwable -> L51
        if (r115 == null) goto L30;
        r115.setClickable(true);     // Catch: Throwable -> L51
    L30:
        FrameLayout r116 = this.f488025b;     // Catch: Throwable -> L51
        if (r116 == null) goto L33;
        r116.setOnClickListener(new d(this));     // Catch: Throwable -> L51
    L33:
        monitor-exit(this);
        boolean r117 = true;
    L38:
        if (r117 == true) goto L40;
        com.bytedance.ai.utils.g.f37637a.e("WebViewFloatingPage", "floating view already exist");
        boolean r118 = false;
    L46:
        boolean r119 = k(r110);
        r100.a();
        if (r118 == false) goto L55;
        if (r119 == false) goto L56;
        return 1;
    L56:
        return 0;
    L55:
        return 0;
    L40:
        View r120 = r100.realView();
        if (r120 == null) goto L45;
        r120.setVisibility(0);
        i2.a r121 = this.f488024a;
        if (r121 == null) goto L45;
        r121.f488020q.addView(r120);
    L45:
        this.f488029f = r100;
        r118 = true;
        goto L46
    L15:
        r108 = GravityCompat.END;
    L35:
        IllegalStateException r122 = new IllegalStateException("ensureFloatingView: mFloatingView=" + this.f488024a + ", context=" + r105);     // Catch: Throwable -> L51
        com.bytedance.ai.utils.g.f37637a.e("WebViewFloatingPage", r122.getMessage(), r122);     // Catch: Throwable -> L51
        monitor-exit(this);
        r117 = false;
        goto L38
    L7:
        r105 = null;
    L51:
        th = move-exception;
        throw th;
    }

    @Override // i2.j
    public final void f(s r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "page");
        i2.a r103 = this.f488024a;
        if (r103 == null) goto L6;
        r103.setRealWidth(r101);
        return;
    }
}
