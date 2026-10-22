package com.bytedance.locallife.dito.interact;

import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.NestedScrollingChild2;
import androidx.core.view.ViewCompat;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003:\u0003\n\u000b\fB\u0019\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/bytedance/locallife/dito/interact/BounceBehavior;", "Landroid/view/View;", "V", "Lcom/bytedance/locallife/dito/interact/AbstractInteractBehavior;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "c", "dito-core-saas_release"}, k = 1, mv = {1, 4, 3})
public final class BounceBehavior<V extends View> extends AbstractInteractBehavior<V> {
    public static final /* synthetic */ int E = 0;
    public ValueAnimator A;
    public float B;
    public int C;
    public ValueAnimator D;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f258328j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f258329k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f258330l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f258331m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f258332n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f258333o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f258334p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f258335q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f258336r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f258337s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public WeakReference<V> f258338t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public WeakReference<View> f258339u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final c f258340v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final OverScroller f258341w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public BounceBehavior<V>.a f258342x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final int f258343y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f258344z;

    public final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f258345a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float f258346b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f258347c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f258348d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f258349e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f258350f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final Handler f258351g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ BounceBehavior<V> f258352h;

        public final void a() {
            if (this.f258350f == false) goto L5;
            return;
        L5:
            int r100 = this.f258348d + 16;
            this.f258348d = r100;
            float r101 = r100 / 1000;
            double r102 = r101;
            int r103 = (int) (((double) (this.f258347c + (this.f258346b * r101))) + (((((double) this.f258345a) * 0.5d) * r102) * r102));
            BounceBehavior<V> r104 = this.f258352h;
            int r105 = BounceBehavior.E;
            r104.m(r103);
            if (this.f258348d < this.f258349e) goto L8;
        L10:
            this.f258352h.l();
            return;
        L8:
            if (Math.abs(r103) >= (this.f258352h.f258328j * 2)) goto L10;
            this.f258351g.removeCallbacks(this);
            this.f258351g.postDelayed(this, 16);
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

        public a(BounceBehavior r100, float r101, int r102) {
            this.f258352h = r100;
            this.f258346b = r101;
            this.f258347c = r102;
            this.f258351g = new Handler(Looper.getMainLooper());
            if (r101 >= 0) goto L5;
            int r103 = 90000;
        L6:
            this.f258345a = r103;
            this.f258349e = (int) (((-r101) / r103) * 1000);
            return;
        L5:
            r103 = -90000;
            goto L6
        }
    }

    public static final class b {
    }

    public static final class c implements Interpolator {
        public c() {
        }

        @Override // android.animation.TimeInterpolator
        public final float getInterpolation(float r100) {
            return 1 - ((float) Math.pow(0.4f, r100 * 2));
        }
    }

    public static final class d implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ V f258353a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ BounceBehavior<V> f258354b;

        public d(V r100, BounceBehavior<V> r101) {
            this.f258353a = r100;
            this.f258354b = r101;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            Object r101 = r100.getAnimatedValue();
            Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type kotlin.Int");
            int r102 = ((Integer) r101).intValue();
            V r103 = this.f258353a;
            ViewCompat.offsetTopAndBottom(r103, r102 - r103.getTop());
            BounceBehavior<V> r104 = this.f258354b;
            V r105 = this.f258353a;
            int r106 = BounceBehavior.E;
            r104.getClass();
            r104.h(r105, r105.getTop());
        }
    }

    public static final class e implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BounceBehavior<V> f258355a;

        public e(BounceBehavior<V> r100) {
            this.f258355a = r100;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            BounceBehavior<V> r101 = this.f258355a;
            Object r102 = r100.getAnimatedValue();
            Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type kotlin.Int");
            int r103 = ((Integer) r102).intValue();
            int r104 = BounceBehavior.E;
            r101.m(r103);
        }
    }

    static {
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onNestedFling(CoordinatorLayout r100, V r101, View r102, float r103, float r104, boolean r105) {
        Intrinsics.checkNotNullParameter(r100, "coordinatorLayout");
        Intrinsics.checkNotNullParameter(r101, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        Intrinsics.checkNotNullParameter(r102, PickerReporterConstants.KEY.TARGET);
        return false;
    }

    @Override // com.bytedance.locallife.dito.interact.AbstractInteractBehavior
    public final boolean b() {
        if (this.f258320e != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.locallife.dito.interact.AbstractInteractBehavior
    public final void e() {
        WeakReference<V> r100 = this.f258338t;
        if (r100 == null) goto L9;
        V r101 = r100.get();
        if (r101 == null) goto L10;
        ViewCompat.offsetTopAndBottom(r101, 0 - r101.getTop());
        h(r101, r101.getTop());
        return;
    L10:
        return;
    }

    @Override // com.bytedance.locallife.dito.interact.AbstractInteractBehavior
    public final void f() {
        ValueAnimator r100 = this.D;
        if (r100 == null) goto L5;
        r100.cancel();
    L5:
        this.D = null;
        WeakReference<V> r101 = this.f258338t;
        if (r101 == null) goto L28;
        V r102 = r101.get();
        if (r102 != null) goto L11;
        return;
    L11:
        if (r102.getTop() != this.f258333o) goto L13;
        return;
    L13:
        ValueAnimator r103 = ValueAnimator.ofInt(new int[]{r102.getTop(), this.f258333o});
        this.D = r103;
        if (r103 == null) goto L17;
        r103.setInterpolator(new DecelerateInterpolator());
    L17:
        ValueAnimator r104 = this.D;
        if (r104 == null) goto L21;
        r104.setDuration(200);
    L21:
        ValueAnimator r105 = this.D;
        if (r105 == null) goto L24;
        r105.addUpdateListener(new d(r102, this));
    L24:
        ValueAnimator r106 = this.D;
        if (r106 == null) goto L29;
        r106.start();
        return;
    L29:
        return;
    }

    public final void l() {
        ValueAnimator r100 = this.A;
        if (r100 == null) goto L5;
        r100.cancel();
    L5:
        ValueAnimator r101 = ValueAnimator.ofInt(new int[]{this.f258344z, 0});
        this.A = r101;
        if (r101 == null) goto L9;
        r101.setInterpolator(new DecelerateInterpolator());
    L9:
        ValueAnimator r102 = this.A;
        if (r102 == null) goto L13;
        r102.setDuration(250);
    L13:
        ValueAnimator r103 = this.A;
        if (r103 == null) goto L16;
        r103.addUpdateListener(new e(this));
    L16:
        ValueAnimator r104 = this.A;
        if (r104 == null) goto L20;
        r104.start();
        return;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final void onDetachedFromLayoutParams() {
        super.onDetachedFromLayoutParams();
        this.f258338t = null;
    }

    public final View findScrollingChild(View r100) {
        Intrinsics.checkNotNull(r100);
        if (ViewCompat.isNestedScrollingEnabled(r100) == false) goto L6;
        return r100;
    L6:
        if ((r100 instanceof ViewGroup) == false) goto L13;
        ViewGroup r101 = (ViewGroup) r100;
        int r102 = r101.getChildCount();
        int r103 = 0;
    L8:
        if (r103 >= r102) goto L17;
        View r104 = findScrollingChild(r101.getChildAt(r103));
        if (r104 != null) goto L11;
        r103 = r103 + 1;
        goto L8
    L11:
        return r104;
    L17:
        return null;
    L13:
        return null;
    }

    public final void m(int r100) {
        WeakReference<V> r101 = this.f258338t;
        if (r101 == null) goto L13;
        V r102 = r101.get();
        if (r102 == null) goto L14;
        int r103 = r102.getTop();
        this.f258344z = r100;
        if (this.f258336r != 0) goto L10;
        ViewCompat.offsetTopAndBottom(r102, (((int) (this.f258328j * this.f258340v.getInterpolation(Math.abs(r100 / this.f258343y)))) + this.f258333o) - r103);
    L11:
        h(r102, r102.getTop());
        return;
    L10:
        ViewCompat.offsetTopAndBottom(r102, ((int) ((-this.f258328j) * this.f258340v.getInterpolation(Math.abs(r100 / this.f258343y)))) - r103);
        goto L11
    L14:
        return;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final void onAttachedToLayoutParams(CoordinatorLayout.LayoutParams r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        super.onAttachedToLayoutParams(r100);
        this.f258338t = null;
    }

    public BounceBehavior(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f258328j = 1500;
        this.f258329k = true;
        this.f258330l = true;
        this.f258332n = true;
        this.f258340v = new c();
        this.f258341w = new OverScroller(r100.getApplicationContext(), new com.bytedance.locallife.dito.interact.e());
        ViewConfiguration.get(r100).getScaledMaximumFlingVelocity();
        this.f258343y = this.f258328j * 3;
    }

    public final void k(V r100, int r101) {
        int r102 = r100.getTop();
        if (r101 < 0) goto L5;
        int r103 = (r101 - r102) + this.f258333o;
    L6:
        float r104 = r103 / this.f258328j;
        c r105 = this.f258340v;
        float r106 = Math.abs(r104);
        r105.getClass();
        int r107 = (int) (((((float) Math.log(1 - r106)) / ((float) Math.log(0.4f))) / 2) * this.f258343y);
        this.f258344z = r107;
        if (r104 >= 0) goto L9;
        r107 = -r107;
    L9:
        this.f258344z = r107;
        ViewCompat.offsetTopAndBottom(r100, -r101);
        return;
    L5:
        r103 = r101 - r102;
        goto L6
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onLayoutChild(CoordinatorLayout r100, V r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        Intrinsics.checkNotNullParameter(r101, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        if (ViewCompat.getFitsSystemWindows(r100) == false) goto L8;
        if (ViewCompat.getFitsSystemWindows(r101) == true) goto L8;
        r101.setFitsSystemWindows(true);
    L8:
        if (this.f258338t != null) goto L12;
        this.f258338t = new WeakReference(r101);
        if (ViewCompat.getImportantForAccessibility(r101) != 0) goto L12;
        ViewCompat.setImportantForAccessibility(r101, 1);
    L12:
        int r103 = r101.getTop();
        r100.onLayoutChild(r101, r102);
        if (this.f258335q == true) goto L17;
        int r104 = this.f258333o;
        if (r104 <= 0) goto L17;
        this.f258335q = true;
        ViewCompat.offsetTopAndBottom(r101, r104);
    L18:
        this.f258334p = this.f258333o;
        this.f258320e = r101.getTop();
        this.f258339u = new WeakReference(findScrollingChild(r101));
        return true;
    L17:
        ViewCompat.offsetTopAndBottom(r101, r103 - r101.getTop());
        goto L18
    }

    public final void j(int r100, V r101, int[] r102, int r103) {
        if (r100 >= 0) goto L8;
        if (r103 >= 0) goto L8;
        if (r100 > r103) goto L7;
        r102[1] = r103;
        k(r101, r103);
        return;
    L7:
        r102[1] = r100;
        k(r101, r100);
        return;
    L8:
        int r104 = this.f258333o;
        if (r100 <= r104) goto L18;
        if (r103 > 0) goto L12;
        return;
    L12:
        if ((r100 - r104) < r103) goto L14;
        r102[1] = r103;
        k(r101, r103);
        return;
    L14:
        r102[1] = r100 - r104;
        k(r101, r100 - r104);
        return;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final void onStopNestedScroll(CoordinatorLayout r100, V r101, View r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, "coordinatorLayout");
        Intrinsics.checkNotNullParameter(r101, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        Intrinsics.checkNotNullParameter(r102, PickerReporterConstants.KEY.TARGET);
        super.onStopNestedScroll(r100, r101, r102, r103);
        if (this.f258344z == 0) goto L6;
        l();
        return;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onNestedPreFling(CoordinatorLayout r110, V r111, View r112, float r113, float r114) {
        Intrinsics.checkNotNullParameter(r110, "coordinatorLayout");
        Intrinsics.checkNotNullParameter(r111, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        Intrinsics.checkNotNullParameter(r112, PickerReporterConstants.KEY.TARGET);
        if (this.f258332n == true) goto L5;
    L11:
        return false;
    L5:
        if (this.f258329k == false) goto L11;
        if (r114 >= 0) goto L9;
        int r115 = -1;
    L10:
        this.C = r115;
        this.B = r115 * r114;
        this.f258341w.forceFinished(true);
        this.f258341w.fling(0, 0, 0, (int) r114, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
        goto L11
    L9:
        r115 = 1;
        goto L10
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onStartNestedScroll(CoordinatorLayout r100, V r101, View r102, View r103, int r104, int r105) {
        Intrinsics.checkNotNullParameter(r100, "coordinatorLayout");
        Intrinsics.checkNotNullParameter(r101, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        Intrinsics.checkNotNullParameter(r102, "directTargetChild");
        Intrinsics.checkNotNullParameter(r103, PickerReporterConstants.KEY.TARGET);
        this.f258337s = r104;
        ValueAnimator r106 = this.A;
        if (r106 == null) goto L5;
        r106.cancel();
    L5:
        BounceBehavior<V>.a r107 = this.f258342x;
        if (r107 == null) goto L9;
        r107.f258350f = true;
        r107.f258351g.removeCallbacks(r107);
    L9:
        if ((r104 & 2) != 0) goto L13;
        return false;
    L13:
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final void onNestedPreScroll(CoordinatorLayout r100, V r101, View r102, int r103, int r104, int[] r105, int r106) {
        Intrinsics.checkNotNullParameter(r100, "coordinatorLayout");
        Intrinsics.checkNotNullParameter(r101, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        Intrinsics.checkNotNullParameter(r102, PickerReporterConstants.KEY.TARGET);
        Intrinsics.checkNotNullParameter(r105, "consumed");
        WeakReference<View> r107 = this.f258339u;
        if (r107 == null) goto L5;
        View r108 = r107.get();
    L6:
        int r109 = r101.getTop();
        if (r102 != r108) goto L28;
        if (r109 == 0) goto L29;
        if (r109 <= 0) goto L25;
        int r110 = this.f258333o;
        if (r109 > r110) goto L17;
        if (r104 <= 0) goto L17;
        if (r109 > r104) goto L16;
        r105[1] = r109;
        ViewCompat.offsetTopAndBottom(r101, -r109);
    L26:
        h(r101, r101.getTop());
        return;
    L16:
        r105[1] = r104;
        ViewCompat.offsetTopAndBottom(r101, -r104);
    L17:
        if (r109 <= r110) goto L26;
        if (r104 <= 0) goto L26;
        j(r109, r101, r105, r104);
        int r111 = r104 - r105[1];
        if (r111 <= 0) goto L26;
        int r112 = r101.getTop();
        if (r112 > r111) goto L24;
        ViewCompat.offsetTopAndBottom(r101, -r112);
        r105[1] = r105[1] + r112;
        goto L26
    L24:
        ViewCompat.offsetTopAndBottom(r101, -r111);
        r105[1] = r104;
        goto L26
    L25:
        j(r109, r101, r105, r104);
        goto L26
    L29:
        return;
    L28:
        return;
    L5:
        r108 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final void onNestedScroll(CoordinatorLayout r100, V r101, View r102, int r103, int r104, int r105, int r106, int r107) {
        Intrinsics.checkNotNullParameter(r100, "coordinatorLayout");
        Intrinsics.checkNotNullParameter(r101, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        Intrinsics.checkNotNullParameter(r102, PickerReporterConstants.KEY.TARGET);
        WeakReference<View> r108 = this.f258339u;
        NestedScrollingChild2 r109 = null;
        if (r108 == null) goto L5;
        View r110 = r108.get();
    L6:
        if (r102 == r110) goto L8;
        return;
    L8:
        if (this.f258337s != 2) goto L66;
        if (r106 == 0) goto L69;
        int r111 = r101.getTop();
        int r112 = this.f258333o;
        int r113 = 0;
        if (r111 >= r112) goto L19;
        if (r106 >= 0) goto L19;
        if ((r111 - r112) > r106) goto L17;
        ViewCompat.offsetTopAndBottom(r101, -r106);
        r106 = 0;
    L18:
        h(r101, r101.getTop());
        goto L19
    L17:
        ViewCompat.offsetTopAndBottom(r101, r112 - r111);
        r106 = r106 - (r111 - this.f258333o);
    L19:
        if (r106 != 0) goto L22;
        return;
    L22:
        if (this.f258332n == true) goto L24;
    L56:
        if (r107 == 1) goto L58;
        return;
    L58:
        if ((r102 instanceof NestedScrollingChild2) == false) goto L60;
        r109 = (NestedScrollingChild2) r102;
    L60:
        if (r109 == null) goto L68;
        r109.stopNestedScroll(1);
        return;
    L68:
        return;
    L24:
        if (this.f258330l == true) goto L27;
        if (r106 < 0) goto L56;
    L27:
        if (this.f258331m == true) goto L30;
        if (r106 > 0) goto L56;
    L30:
        if (r106 >= 0) goto L32;
        int r114 = 0;
    L33:
        this.f258336r = r114;
        if (r107 != 0) goto L37;
        m(this.f258344z + r106);
        return;
    L37:
        if (this.f258329k == false) goto L64;
        int r115 = this.f258344z;
        if (r115 != 0) goto L53;
        this.f258341w.computeScrollOffset();
        float r116 = this.f258341w.getCurrVelocity();
        this.f258341w.forceFinished(true);
        float r117 = r116 * this.C;
        if (Math.abs(r117) < this.B) goto L43;
    L54:
        ViewCompat.stopNestedScroll(r102, r107);
        return;
    L43:
        if (Math.abs(r117) < 1500) goto L54;
        if (r117 < 0) goto L49;
        r113 = 1;
    L49:
        this.f258336r = r113;
        BounceBehavior<V>.a r118 = this.f258342x;
        if (r118 == null) goto L52;
        r118.f258350f = true;
        r118.f258351g.removeCallbacks(r118);
    L52:
        BounceBehavior<V>.a r119 = new a(this, r117, this.f258344z);
        this.f258342x = r119;
        r119.f258351g.postDelayed(r119, 16);
        goto L54
    L53:
        m(r115 + r106);
        goto L54
    L64:
        return;
    L32:
        r114 = 1;
        goto L33
    L69:
        return;
    L66:
        return;
    L5:
        r110 = null;
        goto L6
    }
}
