package com.bytedance.locallife.dito.interact;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.NestedScrollingChild2;
import androidx.core.view.ViewCompat;
import androidx.customview.widget.ViewDragHelper;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.locallife.dito.Dito;
import com.bytedance.locallife.dito.utils.l;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003:\u0002\n\u000bB\u0019\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/bytedance/locallife/dito/interact/CustomBottomBehavior;", "Landroid/view/View;", "V", "Lcom/bytedance/locallife/dito/interact/AbstractInteractBehavior;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "dito-core-saas_release"}, k = 1, mv = {1, 4, 3})
public final class CustomBottomBehavior<V extends View> extends AbstractInteractBehavior<V> {

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public static final /* synthetic */ int f258389p0 = 0;
    public boolean A;
    public HeadUnfoldState B;
    public int C;
    public boolean D;
    public final boolean E;
    public int F;
    public boolean G;
    public boolean H;
    public boolean I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public boolean f258390J;
    public boolean K;
    public int L;
    public boolean M;
    public boolean N;
    public float O;
    public boolean P;
    public boolean Q;
    public int R;
    public boolean S;
    public boolean T;
    public int U;
    public boolean V;
    public f W;
    public g X;
    public boolean Y;
    public boolean Z;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final float f258391j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f258392k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public final CustomBottomBehavior$dragCallback$1 f258393k0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f258394l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f258395m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f258396n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f258397o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f258398p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public ViewDragHelper f258399q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public VelocityTracker f258400r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public CustomBottomBehavior<V>.b f258401s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f258402t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f258403u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f258404v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public WeakReference<V> f258405w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public WeakReference<View> f258406x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f258407y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f258408z;

    public static final class a {
    }

    public final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f258409a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f258410b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f258411c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ CustomBottomBehavior<V> f258412d;

        public final void a() {
            ViewDragHelper r100 = this.f258412d.f258399q;
            if (r100 == null) goto L7;
            boolean r101 = true;
            if (r100.continueSettling(true) != true) goto L7;
        L8:
            if (r101 == false) goto L10;
            ViewCompat.postOnAnimation(this.f258409a, this);
        L16:
            this.f258411c = false;
            return;
        L10:
            CustomBottomBehavior<V> r102 = this.f258412d;
            if (r102.Y == true) goto L13;
        L15:
            this.f258412d.setStateInternal(this.f258410b);
            goto L16
        L13:
            if (r102.B != HeadUnfoldState.STATE_HEAD_UNFOLD) goto L15;
            r102.Y = false;
            r102.j();
        L7:
            r101 = false;
            goto L8
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

        public b(CustomBottomBehavior r100, View r101, int r102) {
            Intrinsics.checkNotNullParameter(r101, "view");
            this.f258412d = r100;
            this.f258409a = r101;
            this.f258410b = r102;
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CustomBottomBehavior<V> f258413a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ V f258414b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f258415c;

        public c(CustomBottomBehavior<V> r100, V r101, int r102) {
            this.f258413a = r100;
            this.f258414b = r101;
            this.f258415c = r102;
        }

        @Override // java.lang.Runnable
        public final void run() {
            CustomBottomBehavior<V> r100 = this.f258413a;     // Catch: Throwable -> L4
            V r101 = this.f258414b;     // Catch: Throwable -> L4
            int r102 = this.f258415c;     // Catch: Throwable -> L4
            int r103 = CustomBottomBehavior.f258389p0;     // Catch: Throwable -> L4
            r100.settleToState(r101, r102);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    @Override // com.bytedance.locallife.dito.interact.AbstractInteractBehavior
    public final void f() {
        setState(6);
    }

    @Override // com.bytedance.locallife.dito.interact.AbstractInteractBehavior
    public final boolean b() {
        int r100 = this.f258320e;
        if (r100 >= 0) goto L6;
        return false;
    L6:
        if (this.M == false) goto L11;
        if (r100 > this.f258396n) goto L14;
    L12:
        return true;
    L14:
        return false;
    L11:
        if (r100 <= this.f258392k) goto L12;
        return false;
    }

    @Override // com.bytedance.locallife.dito.interact.AbstractInteractBehavior
    public final void e() {
        WeakReference<V> r100 = this.f258405w;
        if (r100 != null) goto L5;
        return;
    L5:
        if (this.M == true) goto L15;
        if (r100 == null) goto L14;
        V r101 = r100.get();
        if (r101 == null) goto L16;
        int r102 = r101.getTop();
        int r103 = this.f258392k - r102;
        setStateInternal(7);
        ViewCompat.offsetTopAndBottom(r101, r103);
        j();
        return;
    L16:
        return;
    L14:
        return;
    }

    public final float getYVelocity() {
        VelocityTracker r100 = this.f258400r;
        if (r100 != null) goto L5;
        return 0.0f;
    L5:
        if (r100 == null) goto L7;
        r100.computeCurrentVelocity(1000, this.f258391j);
    L7:
        VelocityTracker r101 = this.f258400r;
        if (r101 != null) goto L10;
        return 0.0f;
    L10:
        return r101.getYVelocity(this.f258407y);
    }

    public final void j() {
        WeakReference<V> r100 = this.f258405w;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100 == null) goto L7;
        V r101 = r100.get();
    L8:
        if (r101 != null) goto L10;
        return;
    L10:
        if (this.H == false) goto L12;
    L14:
        h(r101, r101.getTop());
        return;
    L12:
        if (r101.getTop() >= (this.f258397o + 20)) goto L14;
        this.H = true;
        goto L14
    L7:
        r101 = null;
        goto L8
    }

    public final void k() {
        if (this.V == true) goto L5;
        return;
    L5:
        this.Y = true;
        n(HeadUnfoldState.STATE_HEAD_UNFOLD);
        if (this.f258398p != (-1)) goto L8;
        this.f258398p = this.f258397o;
    L8:
        setStateInternal(3);
        m(this.U);
        settleToStatePendingLayout(6);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final void onDetachedFromLayoutParams() {
        super.onDetachedFromLayoutParams();
        this.f258405w = null;
        this.f258399q = null;
    }

    @Override // com.bytedance.locallife.dito.interact.AbstractInteractBehavior
    public final boolean c() {
        return this.S;
    }

    @Override // com.bytedance.locallife.dito.interact.AbstractInteractBehavior
    public final int d() {
        return this.R;
    }

    public final View findScrollingChild(View r100) {
        if (ViewCompat.isNestedScrollingEnabled(r100) == false) goto L10;
        if (this.T == true) goto L7;
    L8:
        return r100;
    L7:
        if (r100.getId() == R.id.ditoList) goto L8;
    L10:
        if ((r100 instanceof ViewGroup) == false) goto L17;
        ViewGroup r101 = (ViewGroup) r100;
        int r102 = r101.getChildCount();
        int r103 = 0;
    L12:
        if (r103 >= r102) goto L21;
        View r104 = findScrollingChild(r101.getChildAt(r103));
        if (r104 != null) goto L15;
        r103 = r103 + 1;
        goto L12
    L15:
        return r104;
    L21:
        return null;
    L17:
        return null;
    }

    public final void m(int r100) {
        if (r100 < 0) goto L4;
        boolean r101 = true;
    L5:
        if (r101 == false) goto L9;
        this.f258397o = r100;
        g(r100);
        return;
    L9:
        throw new IllegalArgumentException(("offset must be greater than or equal to 0, got " + r100 + ", stack: " + ExceptionsKt.stackTraceToString(new Throwable())).toString());
    L4:
        r101 = false;
        goto L5
    }

    public final void n(HeadUnfoldState r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        HeadUnfoldState r101 = this.B;
        if (r100 != r101) goto L5;
        return;
    L5:
        if (this.V == false) goto L13;
        this.B = r100;
        g r102 = this.X;
        if (r102 == null) goto L12;
        r102.a(r101, r100);
        return;
    L12:
        return;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final void onAttachedToLayoutParams(CoordinatorLayout.LayoutParams r100) {
        Intrinsics.checkNotNullParameter(r100, "layoutParams");
        super.onAttachedToLayoutParams(r100);
        this.f258405w = null;
        this.f258399q = null;
    }

    @Override // com.bytedance.locallife.dito.interact.AbstractInteractBehavior
    public final void setState(final int r100) {
        if (r100 != this.f258318c) goto L6;
        return;
    L6:
        if (this.M == false) goto L10;
        if (r100 < 6) goto L10;
        return;
    L10:
        if (this.f258405w != null) goto L17;
        if (r100 == 4) goto L15;
        if (r100 == 5) goto L15;
        if (r100 == 6) goto L15;
        return;
    L15:
        this.f258318c = r100;
        return;
    L17:
        com.bytedance.locallife.dito.interact.c r101 = this.f258321f;
        if (r101 != null) goto L20;
    L29:
        settleToStatePendingLayout(r100);
        return;
    L20:
        if (this.f258316a == true) goto L25;
        if (r100 != 4) goto L25;
        r101.b(new AnonymousClass1(this, r100));
        return;
    L25:
        if (this.f258317b == true) goto L29;
        if (r100 != 5) goto L29;
        r101.a(new AnonymousClass2(this, r100));
    }

    public final void setStateInternal(int r100) {
        if (this.f258318c != r100) goto L6;
        return;
    L6:
        if (r100 != 4) goto L8;
    L10:
        this.F = r100;
    L11:
        this.f258318c = r100;
        WeakReference<V> r101 = this.f258405w;
        if (r101 != null) goto L14;
        return;
    L14:
        if (r101 == null) goto L20;
        V r102 = r101.get();
        if (r102 == null) goto L21;
        i(r102, r100);
        return;
    L21:
        return;
    L20:
        return;
    L8:
        if (r100 == 6) goto L10;
        goto L10
    }

    public final void settleToStatePendingLayout(int r100) {
        WeakReference<V> r101 = this.f258405w;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101 == null) goto L18;
        V r102 = r101.get();
        if (r102 == null) goto L20;
        ViewParent r103 = r102.getParent();
        if (r103 != null) goto L12;
    L16:
        settleToState(r102, r100);
        return;
    L12:
        if (r103.isLayoutRequested() == false) goto L16;
        if (ViewCompat.isAttachedToWindow(r102) == false) goto L16;
        r102.post(new c(this, r102, r100));
        return;
    L20:
        return;
    }

    /* JADX WARN: Type inference failed for: r2v9, types: [com.bytedance.locallife.dito.interact.CustomBottomBehavior$dragCallback$1] */
    public CustomBottomBehavior(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f258391j = ViewConfiguration.get(r100).getScaledMaximumFlingVelocity();
        this.f258397o = -1;
        this.f258398p = -1;
        this.B = HeadUnfoldState.STATE_HEAD_FOLD;
        this.D = true;
        Dito r102 = Dito.f257280a;
        this.E = l.k().getFixHalfScreenStuckOnScrollStop();
        this.F = 5;
        this.G = true;
        this.f258390J = true;
        this.L = this.f258392k;
        this.O = 0.5f;
        this.f258393k0 = new CustomBottomBehavior$dragCallback$1(this);
    }

    public final boolean l(V r100, MotionEvent r101) {
        int r102 = r101.getActionIndex();
        int r103 = 0;
        if (r102 >= 0) goto L5;
    L40:
        return false;
    L5:
        if (r102 >= r101.getPointerCount()) goto L40;
        int r104 = r101.getActionMasked();
        if (this.f258318c != 2) goto L11;
        if (r104 != 0) goto L11;
        return true;
    L11:
        ViewDragHelper r105 = this.f258399q;
        if (r105 == null) goto L14;
        r105.processTouchEvent(r101);
    L14:
        if (r104 != 0) goto L20;
        this.f258407y = -1;
        VelocityTracker r106 = this.f258400r;
        if (r106 == null) goto L18;
        r106.recycle();
    L18:
        this.f258400r = null;
    L20:
        if (this.f258400r != null) goto L22;
        this.f258400r = VelocityTracker.obtain();
    L22:
        VelocityTracker r107 = this.f258400r;
        if (r107 == null) goto L26;
        r107.addMovement(r101);
    L26:
        if (this.f258399q == null) goto L39;
        if (r104 != 2) goto L39;
        if (this.f258402t == true) goto L39;
        float r108 = Math.abs(this.f258408z - r101.getY());
        ViewDragHelper r109 = this.f258399q;
        if (r109 == null) goto L34;
        r103 = r109.getTouchSlop();
    L34:
        if (r108 <= r103) goto L39;
        ViewDragHelper r110 = this.f258399q;
        if (r110 == null) goto L39;
        r110.captureChildView(r100, r101.getPointerId(r101.getActionIndex()));
    L39:
        return !this.f258402t;
    }

    public final void setPeekHeight(int r100, boolean r101) {
        int r102 = 0;
        if (this.f258395m == r100) goto L5;
        this.f258395m = Math.max(0, r100);
        boolean r103 = true;
    L6:
        if (r103 == true) goto L8;
        return;
    L8:
        if (this.f258405w != null) goto L10;
        return;
    L10:
        if (0.0f <= 0) goto L14;
        int r104 = (int) (this.f258394l * 0.0f);
        if (r104 == this.f258395m) goto L14;
        this.f258395m = r104;
    L14:
        int r105 = this.f258394l - this.f258395m;
        if (r105 >= 0) goto L18;
        r105 = 0;
    L18:
        if (this.f258396n == r105) goto L23;
        this.f258396n = r105;
        this.P = true;
        int r106 = this.f258324i.size();
    L20:
        if (r102 >= r106) goto L23;
        ((com.bytedance.locallife.dito.interact.b) ListProtector.get(this.f258324i, r102)).a(r105);
        r102 = r102 + 1;
    L23:
        if (this.f258318c != 4) goto L36;
        WeakReference<V> r107 = this.f258405w;
        if (r107 == null) goto L27;
        V r108 = r107.get();
    L28:
        if (r108 == null) goto L37;
        if (r101 == false) goto L31;
        settleToStatePendingLayout(this.f258318c);
        return;
    L31:
        r108.requestLayout();
        return;
    L37:
        return;
    L27:
        r108 = null;
        goto L28
    L36:
        return;
    L5:
        r103 = false;
        goto L6
    }

    public final void settleToState(View r100, int r101) {
        if (r101 != 4) goto L5;
        int r102 = this.f258396n;
    L13:
        startSettlingAnimation(r100, r101, r102, false);
        return;
    L5:
        if (r101 != 5) goto L7;
        r102 = this.f258394l;
        goto L13
    L7:
        if (r101 != 6) goto L10;
        r102 = this.f258397o;
        goto L13
    L10:
        throw new IllegalArgumentException("Illegal state argument: " + r101);
    }

    public final boolean shouldHide(View r100, float r101) {
        if (this.f258319d != 2) goto L6;
        return false;
    L6:
        if (this.F != 6) goto L11;
        if (this.I == false) goto L11;
        return false;
    L11:
        if (r100.getTop() > this.f258396n) goto L13;
        return false;
    L13:
        float r102 = 0;
        if (0.0f <= r102) goto L18;
        int r103 = (int) (this.f258394l * 0.0f);
        if (r103 == this.f258395m) goto L18;
        this.f258395m = r103;
    L18:
        int r104 = this.f258395m;
        if (r100.getTop() <= ((int) (this.f258394l - (this.O * r104)))) goto L22;
        return true;
    L22:
        if (this.f258403u < (-15)) goto L24;
        return false;
    L24:
        if (r101 <= 2000) goto L34;
        float r105 = r100.getTop();
        float r106 = this.f258322g;
        if (r106 > r102) goto L30;
        r106 = 0.25f;
    L30:
        if ((Math.abs((r105 + (r101 * r106)) - this.f258396n) / r104) <= 0.75f) goto L35;
        return true;
    L35:
        return false;
    L34:
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onInterceptTouchEvent(CoordinatorLayout r100, V r110, MotionEvent r111) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        Intrinsics.checkNotNullParameter(r110, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        Intrinsics.checkNotNullParameter(r111, "event");
        int r101 = r111.getActionMasked();
        if (this.Q == false) goto L9;
        int r102 = this.f258319d;
        if (r102 == 1) goto L11;
        if (r102 == 3) goto L11;
    L10:
        boolean r103 = true;
    L13:
        if (r110.isShown() == false) goto L89;
        if (r103 == true) goto L89;
        View r104 = null;
        if (r101 != 0) goto L23;
        this.f258407y = -1;
        VelocityTracker r105 = this.f258400r;
        if (r105 == null) goto L21;
        r105.recycle();
    L21:
        this.f258400r = null;
    L23:
        if (this.f258400r != null) goto L25;
        this.f258400r = VelocityTracker.obtain();
    L25:
        VelocityTracker r106 = this.f258400r;
        if (r106 == null) goto L28;
        r106.addMovement(r111);
    L28:
        if (r101 == 0) goto L36;
        if (r101 == 1) goto L32;
        if (r101 == 3) goto L32;
    L54:
        if (this.M == false) goto L56;
    L65:
        WeakReference<View> r112 = this.f258406x;
        if (r112 == null) goto L69;
        r104 = r112.get();
    L69:
        if (r101 == 2) goto L71;
        return false;
    L71:
        if (this.M == true) goto L92;
        if (r104 != null) goto L74;
        return false;
    L74:
        if (this.f258402t == false) goto L76;
        return false;
    L76:
        if (this.f258318c != 2) goto L78;
        return false;
    L78:
        if (r100.isPointInChildBounds(r104, (int) r111.getX(), (int) r111.getY()) == false) goto L80;
        return false;
    L80:
        if (this.f258399q == null) goto L97;
        float r107 = Math.abs(this.f258408z - r111.getY());
        ViewDragHelper r113 = this.f258399q;
        if (r113 == null) goto L84;
        int r114 = r113.getTouchSlop();
    L86:
        if (r107 <= r114) goto L98;
        return true;
    L98:
        return false;
    L84:
        r114 = 0;
        goto L86
    L97:
        return false;
    L92:
        return false;
    L56:
        if (this.f258402t == true) goto L65;
        ViewDragHelper r115 = this.f258399q;
        if (r115 != null) goto L60;
    L62:
        boolean r116 = false;
    L63:
        if (r116 == false) goto L65;
        return true;
    L60:
        if (r115.shouldInterceptTouchEvent(r111) != true) goto L62;
        r116 = true;
    L32:
        this.A = false;
        this.f258407y = -1;
        if (this.f258402t == false) goto L54;
        this.f258402t = false;
        return false;
    L36:
        int r108 = (int) r111.getX();
        this.f258408z = (int) r111.getY();
        if (this.f258318c == 3) goto L47;
        WeakReference<View> r109 = this.f258406x;
        if (r109 == null) goto L41;
        View r117 = r109.get();
    L42:
        if (r117 == null) goto L47;
        if (r100.isPointInChildBounds(r117, r108, this.f258408z) == false) goto L47;
        this.f258407y = r111.getPointerId(r111.getActionIndex());
        this.A = true;
        goto L47
    L41:
        r117 = null;
    L47:
        if (this.f258407y == (-1)) goto L49;
    L51:
        boolean r118 = false;
    L52:
        this.f258402t = r118;
        goto L54
    L49:
        if (r100.isPointInChildBounds(r110, r108, this.f258408z) == true) goto L51;
        r118 = true;
    L89:
        this.f258402t = true;
        return false;
    L11:
        r103 = false;
        goto L13
    L9:
        if (this.f258319d == 1) goto L11;
        goto L10
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onLayoutChild(CoordinatorLayout r100, V r110, int r111) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        Intrinsics.checkNotNullParameter(r110, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        if (ViewCompat.getFitsSystemWindows(r100) == false) goto L8;
        if (ViewCompat.getFitsSystemWindows(r110) == true) goto L8;
        r110.setFitsSystemWindows(true);
    L8:
        if (this.f258405w != null) goto L13;
        this.f258405w = new WeakReference(r110);
        if (ViewCompat.getImportantForAccessibility(r110) != 0) goto L13;
        ViewCompat.setImportantForAccessibility(r110, 1);
    L13:
        if (this.f258399q != null) goto L15;
        this.f258399q = ViewDragHelper.create(r100, this.f258393k0);
    L15:
        int r101 = r110.getTop();
        r100.onLayoutChild(r110, r111);
        int r112 = this.f258394l;
        int r102 = r100.getHeight();
        this.f258394l = r102;
        float r103 = 0;
        if (0.0f <= r103) goto L20;
        int r104 = (int) (r102 * 0.0f);
        if (r104 == this.f258395m) goto L20;
        this.f258395m = r104;
    L20:
        int r105 = r102 - this.f258395m;
        if (r105 >= 0) goto L24;
        r105 = 0;
    L24:
        if (this.f258396n == r105) goto L29;
        this.f258396n = r105;
        this.P = true;
        int r106 = this.f258324i.size();
        int r107 = 0;
    L26:
        if (r107 >= r106) goto L29;
        ((com.bytedance.locallife.dito.interact.b) ListProtector.get(this.f258324i, r107)).a(r105);
        r107 = r107 + 1;
    L29:
        if (this.B == HeadUnfoldState.STATE_HEAD_FOLD) goto L31;
        g(this.f258397o);
    L43:
        int r108 = this.f258318c;
        if (r108 != 7) goto L47;
        ViewCompat.offsetTopAndBottom(r110, this.f258392k);
    L65:
        this.f258406x = new WeakReference(findScrollingChild(r110));
        if (this.N == false) goto L68;
        this.N = false;
        r110.requestLayout();
    L68:
        return true;
    L47:
        if (r108 != 6) goto L50;
        ViewCompat.offsetTopAndBottom(r110, this.f258397o);
        goto L65
    L50:
        if (r108 != 5) goto L53;
        ViewCompat.offsetTopAndBottom(r110, this.f258394l);
        goto L65
    L53:
        if (r108 != 4) goto L59;
        ViewCompat.offsetTopAndBottom(r110, this.f258396n);
        if (this.P == false) goto L57;
    L58:
        this.P = false;
        j();
        goto L65
    L57:
        if (r112 == this.f258394l) goto L65;
    L59:
        if (r108 != 1) goto L61;
    L64:
        ViewCompat.offsetTopAndBottom(r110, r101 - r110.getTop());
        goto L65
    L61:
        if (r108 == 2) goto L64;
        if (r108 != 3) goto L65;
    L31:
        if (0.0f <= r103) goto L37;
        int r109 = (int) (this.f258394l * (1 - 0.0f));
        if (r109 <= 0) goto L37;
        if (r109 == this.f258397o) goto L37;
        this.f258397o = r109;
    L37:
        int r113 = this.f258397o;
        int r114 = this.f258396n;
        if (r113 < r114) goto L42;
        int r115 = r114 - 50;
        if (r115 < 0) goto L42;
        this.f258397o = r115;
    L42:
        g(this.f258397o);
        goto L43
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onTouchEvent(CoordinatorLayout r100, V r101, MotionEvent r102) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        Intrinsics.checkNotNullParameter(r101, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        Intrinsics.checkNotNullParameter(r102, "event");
        if (r101.isShown() == true) goto L8;
        return false;
    L8:
        return l(r101, r102);
    L10:
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final void onStopNestedScroll(CoordinatorLayout r100, V r101, View r110, int r111) {
        Intrinsics.checkNotNullParameter(r100, "coordinatorLayout");
        Intrinsics.checkNotNullParameter(r101, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        Intrinsics.checkNotNullParameter(r110, PickerReporterConstants.KEY.TARGET);
        WeakReference<View> r102 = this.f258406x;
        if (r102 == null) goto L105;
        if (r102 == null) goto L6;
        View r103 = r102.get();
    L8:
        if (Intrinsics.areEqual(r110, r103) == false) goto L108;
        int r104 = r101.getTop();
        if (r104 != this.f258392k) goto L13;
    L20:
        boolean r105 = true;
    L22:
        if (this.f258404v == true) goto L27;
        if (r105 == false) goto L25;
        return;
    L25:
        if (this.E == true) goto L27;
        return;
    L27:
        int r112 = 5;
        if (this.M == false) goto L38;
        if (r111 != 1) goto L32;
    L101:
        this.f258404v = false;
        Iterator r106 = ((ArrayList) this.f258323h).iterator();
    L103:
        if (r106.hasNext() == false) goto L109;
        ((d) r106.next()).b();
        goto L103
    L109:
        return;
    L32:
        if (this.D == true) goto L34;
    L36:
        int r107 = this.f258396n;
        r112 = 4;
    L37:
        startSettlingAnimation(r101, r112, r107, false);
        goto L101
    L34:
        if (shouldHide(r101, getYVelocity()) == false) goto L36;
        r107 = this.f258394l;
        goto L37
    L38:
        int r108 = r101.getTop();
        getYVelocity();
        HeadUnfoldState r109 = this.B;
        HeadUnfoldState r113 = HeadUnfoldState.STATE_HEAD_TRANSITION;
        if (r109 != r113) goto L44;
        f r114 = this.W;
        if (r114 == null) goto L43;
        r114.a(0.0f);
    L43:
        r101.setTranslationY(0.0f);
    L44:
        HeadUnfoldState r115 = this.B;
        if (r115 == r113) goto L53;
        int r116 = this.f258397o;
        if (r108 > r116) goto L53;
        if (r108 != r116) goto L51;
        setStateInternal(6);
        goto L101
    L51:
        if (r108 != this.f258392k) goto L101;
        setStateInternal(7);
    L53:
        if (r111 == 0) goto L55;
        if (r111 != 1) goto L93;
        if (r115 != r113) goto L93;
        if (Math.abs(r108 - this.f258397o) >= Math.abs(r108 - this.f258396n)) goto L91;
        n(HeadUnfoldState.STATE_HEAD_UNFOLD);
        k();
        goto L101
    L91:
        n(HeadUnfoldState.STATE_HEAD_FOLD);
        m(this.f258398p);
        startSettlingAnimation(r101, 4, this.f258396n, false);
    L93:
        if (this.E == false) goto L101;
        if (r111 != 1) goto L101;
        int r117 = this.f258397o;
        if (r108 <= r117) goto L101;
        if (Math.abs(r108 - r117) >= Math.abs(r108 - this.f258396n)) goto L100;
        startSettlingAnimation(r101, 6, this.f258397o, false);
        goto L101
    L100:
        startSettlingAnimation(r101, 4, this.f258396n, false);
        goto L101
    L55:
        if (this.f258403u <= 0) goto L63;
        if (r108 >= this.f258396n) goto L63;
        if (r115 != r113) goto L60;
        n(HeadUnfoldState.STATE_HEAD_UNFOLD);
        k();
        goto L101
    L60:
        int r118 = this.f258397o;
    L61:
        r112 = 6;
    L85:
        startSettlingAnimation(r101, r112, r118, false);
    L63:
        if (this.D == false) goto L68;
        if (shouldHide(r101, getYVelocity()) == false) goto L68;
        r118 = this.f258394l;
    L68:
        if (this.G == true) goto L76;
        if (this.H == false) goto L76;
        int r119 = this.f258394l;
        if (r108 > ((int) (r119 * 0.2f))) goto L74;
        r118 = this.f258397o;
        goto L61
    L74:
        r118 = r119;
    L76:
        if (Math.abs(r108 - this.f258397o) < Math.abs(r108 - this.f258396n)) goto L78;
        r118 = this.f258396n;
        if (this.B != r113) goto L84;
        n(HeadUnfoldState.STATE_HEAD_FOLD);
        m(this.f258398p);
    L84:
        r112 = 4;
        goto L85
    L78:
        if (this.B != r113) goto L80;
        n(HeadUnfoldState.STATE_HEAD_UNFOLD);
        k();
        goto L101
    L80:
        r118 = this.f258397o;
        goto L61
    L13:
        if (r104 == this.f258397o) goto L20;
        if (r104 == this.f258396n) goto L20;
        if (r104 == this.f258394l) goto L20;
        r105 = false;
        goto L22
    L108:
        return;
    L6:
        r103 = null;
        goto L8
    }

    public final void startSettlingAnimation(View r100, int r101, int r102, boolean r103) {
        if (this.f258317b == false) goto L5;
        return;
    L5:
        if (r103 == false) goto L9;
        ViewDragHelper r104 = this.f258399q;
        if (r104 == null) goto L12;
        Boolean r105 = Boolean.valueOf(r104.settleCapturedViewAt(r100.getLeft(), r102));
    L13:
        int r106 = 0;
        if (r101 != 4) goto L21;
        if (this.f258316a == true) goto L21;
        this.f258316a = true;
        int r107 = this.f258324i.size();
        int r108 = 0;
    L18:
        if (r108 >= r107) goto L21;
        ((com.bytedance.locallife.dito.interact.b) ListProtector.get(this.f258324i, r108)).g();
        r108 = r108 + 1;
    L21:
        if (r101 != 5) goto L26;
        this.f258317b = true;
        int r109 = this.f258324i.size();
    L23:
        if (r106 >= r109) goto L26;
        ((com.bytedance.locallife.dito.interact.b) ListProtector.get(this.f258324i, r106)).f();
        r106 = r106 + 1;
    L26:
        if (Intrinsics.areEqual(r105, Boolean.TRUE) == false) goto L36;
        setStateInternal(3);
        if (this.f258401s != null) goto L30;
        this.f258401s = new b(this, r100, r101);
    L30:
        CustomBottomBehavior<V>.b r110 = this.f258401s;
        if (r110 != null) goto L33;
        return;
    L33:
        if (r110.f258411c == true) goto L35;
        r110.f258410b = r101;
        ViewCompat.postOnAnimation(r100, r110);
        r110.f258411c = true;
        return;
    L35:
        r110.f258410b = r101;
        return;
    L36:
        setStateInternal(r101);
        return;
    L12:
        r105 = null;
        goto L13
    L9:
        ViewDragHelper r111 = this.f258399q;
        if (r111 == null) goto L12;
        r105 = Boolean.valueOf(r111.smoothSlideViewTo(r100, r100.getLeft(), r102));
        goto L13
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onNestedPreFling(CoordinatorLayout r100, V r101, View r102, float r103, float r104) {
        Intrinsics.checkNotNullParameter(r100, "coordinatorLayout");
        Intrinsics.checkNotNullParameter(r101, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        Intrinsics.checkNotNullParameter(r102, PickerReporterConstants.KEY.TARGET);
        int r105 = r101.getTop();
        View r106 = null;
        if (this.M == false) goto L12;
        WeakReference<View> r107 = this.f258406x;
        if (r107 == null) goto L8;
        r106 = r107.get();
    L8:
        if (Intrinsics.areEqual(r102, r106) == true) goto L10;
        return false;
    L10:
        if (r105 <= this.f258396n) goto L24;
        return true;
    L24:
        return false;
    L12:
        WeakReference<View> r108 = this.f258406x;
        if (r108 == null) goto L16;
        r106 = r108.get();
    L16:
        if (Intrinsics.areEqual(r102, r106) == true) goto L18;
        return false;
    L18:
        if ((r105 - this.f258392k) <= this.f258397o) goto L20;
    L21:
        return true;
    L20:
        if (this.K == true) goto L21;
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onMeasureChild(CoordinatorLayout r100, V r110, int r111, int r112, int r113, int r114) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        Intrinsics.checkNotNullParameter(r110, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        if (this.M == false) goto L12;
        if (this.f258395m != 0) goto L7;
        this.N = true;
        goto L12
    L7:
        ViewGroup.LayoutParams r101 = r110.getLayoutParams();
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams");
        if (((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.LayoutParams) r101)).height != (-1)) goto L12;
        r100.onMeasureChild(r110, r111, r112, View.MeasureSpec.makeMeasureSpec(this.f258395m, 1073741824), r114);
        return true;
    L12:
        return super.onMeasureChild(r100, r110, r111, r112, r113, r114);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onStartNestedScroll(CoordinatorLayout r100, V r101, View r102, View r103, int r104, int r105) {
        Intrinsics.checkNotNullParameter(r100, "coordinatorLayout");
        Intrinsics.checkNotNullParameter(r101, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        Intrinsics.checkNotNullParameter(r102, "directTargetChild");
        Intrinsics.checkNotNullParameter(r103, PickerReporterConstants.KEY.TARGET);
        this.f258403u = 0;
        this.f258404v = false;
        if (this.f258390J == true) goto L5;
    L9:
        boolean r106 = false;
    L10:
        this.K = r106;
        if (r106 == false) goto L13;
        int r107 = this.f258397o;
    L14:
        this.L = r107;
        if ((r104 & 2) == 0) goto L18;
        return true;
    L18:
        return false;
    L13:
        r107 = this.f258392k;
        goto L14
    L5:
        if (this.B != HeadUnfoldState.STATE_HEAD_FOLD) goto L9;
        if (r101.getTop() < this.f258396n) goto L9;
        r106 = true;
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final void onNestedPreScroll(CoordinatorLayout r100, V r110, View r111, int r112, int r113, int[] r114, int r115) {
        Intrinsics.checkNotNullParameter(r100, "coordinatorLayout");
        Intrinsics.checkNotNullParameter(r110, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        Intrinsics.checkNotNullParameter(r111, PickerReporterConstants.KEY.TARGET);
        Intrinsics.checkNotNullParameter(r114, "consumed");
        int r101 = this.f258319d;
        if (r101 != 2) goto L5;
        return;
    L5:
        if (r101 != 3) goto L8;
        if (r113 <= 0) goto L8;
        return;
    L8:
        WeakReference<View> r102 = this.f258406x;
        NestedScrollingChild2 r103 = null;
        if (r102 == null) goto L11;
        View r104 = r102.get();
    L12:
        if (r111 == r104) goto L14;
        return;
    L14:
        int r105 = r110.getTop();
        int r106 = r105 - r113;
        int r107 = this.f258397o;
        int r108 = this.f258392k;
        if (r107 == r108) goto L20;
        if (r105 > r108) goto L20;
        if (r113 <= 0) goto L20;
        return;
    L20:
        if (this.M == false) goto L35;
        if (r115 == 1) goto L108;
        if (r113 <= 0) goto L28;
        int r116 = this.f258396n;
        if (r106 >= r116) goto L27;
        r114[1] = r105 - r116;
        ViewCompat.offsetTopAndBottom(r110, r116 - r105);
        setStateInternal(4);
        goto L108
    L27:
        r114[1] = r113;
        ViewCompat.offsetTopAndBottom(r110, -r113);
        setStateInternal(2);
        goto L108
    L28:
        if (r113 >= 0) goto L108;
        if (this.D == false) goto L108;
        if (r111.canScrollVertically(-1) == true) goto L108;
        ViewCompat.offsetTopAndBottom(r110, -r113);
        setStateInternal(2);
    L108:
        j();
        this.f258403u = r113;
        this.f258404v = true;
        Iterator r109 = ((ArrayList) this.f258323h).iterator();
    L110:
        if (r109.hasNext() == false) goto L115;
        ((d) r109.next()).a();
        goto L110
    L115:
        return;
    L35:
        if (r115 != 0) goto L81;
        boolean r117 = this.K;
        if (r117 == true) goto L39;
    L41:
        if (r113 <= 0) goto L56;
        int r118 = this.L;
        if (r106 >= r118) goto L48;
        if (r117 == false) goto L46;
        r114[1] = r113;
    L47:
        ViewCompat.offsetTopAndBottom(r110, r118 - r105);
    L49:
        int r119 = r110.getTop();
        int r120 = this.f258392k;
        if (r119 <= r120) goto L52;
        setStateInternal(2);
        goto L108
    L52:
        if (this.f258397o != r120) goto L54;
        setStateInternal(6);
        goto L108
    L54:
        setStateInternal(7);
        goto L108
    L46:
        r114[1] = r105 - r118;
        goto L47
    L48:
        r114[1] = r113;
        ViewCompat.offsetTopAndBottom(r110, -r113);
        goto L49
    L56:
        if (r113 >= 0) goto L108;
        if (r111.canScrollVertically(-1) == true) goto L108;
        if (this.V == true) goto L62;
    L69:
        boolean r121 = this.D;
        if (r121 == false) goto L72;
    L74:
        if (r121 == true) goto L78;
        int r122 = this.f258396n;
        if (r106 <= r122) goto L78;
        r114[1] = r113;
        ViewCompat.offsetTopAndBottom(r110, r122 - r105);
    L79:
        setStateInternal(2);
    L78:
        r114[1] = r113;
        ViewCompat.offsetTopAndBottom(r110, -r113);
        goto L79
    L72:
        if (r105 < this.f258396n) goto L74;
        r114[1] = r113;
        goto L79
    L62:
        if (this.B != HeadUnfoldState.STATE_HEAD_UNFOLD) goto L69;
        if (r106 <= this.f258397o) goto L69;
        r114[1] = r113;
        ViewCompat.offsetTopAndBottom(r110, this.f258396n - r105);
        m(this.f258398p);
        r110.setTranslationY((-this.f258396n) + this.C);
        f r123 = this.W;
        if (r123 == null) goto L68;
        r123.a(r110.getTranslationY());
    L68:
        n(HeadUnfoldState.STATE_HEAD_TRANSITION);
        goto L79
    L39:
        if (r105 > this.L) goto L41;
        r114[1] = r113;
        goto L108
    L81:
        if (this.f258318c == 3) goto L108;
        if (r113 >= 0) goto L91;
        if (r105 < r107) goto L91;
        if (this.Z == false) goto L108;
        if ((r111 instanceof NestedScrollingChild2) == false) goto L89;
        r103 = (NestedScrollingChild2) r111;
    L89:
        if (r103 == null) goto L108;
        r103.stopNestedScroll(1);
    L91:
        if (r113 <= 0) goto L95;
        if (r106 > r108) goto L94;
        int r124 = r105 - r108;
        r114[1] = r124;
        ViewCompat.offsetTopAndBottom(r110, -r124);
        setStateInternal(7);
        goto L108
    L94:
        r114[1] = r113;
        ViewCompat.offsetTopAndBottom(r110, -r113);
        setStateInternal(2);
        goto L108
    L95:
        if (r113 >= 0) goto L108;
        if (r111.canScrollVertically(-1) == true) goto L108;
        if (this.D == false) goto L101;
    L103:
        int r125 = this.f258397o;
        if (r106 > r125) goto L106;
        r114[1] = r113;
        ViewCompat.offsetTopAndBottom(r110, -r113);
    L107:
        setStateInternal(2);
        goto L108
    L106:
        int r126 = r105 - r125;
        r114[1] = r126;
        ViewCompat.offsetTopAndBottom(r110, -r126);
        goto L107
    L101:
        if (r105 < this.f258396n) goto L103;
        r114[1] = r113;
        goto L107
    L11:
        r104 = null;
        goto L12
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final void onNestedScroll(CoordinatorLayout r100, V r101, View r102, int r103, int r104, int r105, int r106, int r107) {
        Intrinsics.checkNotNullParameter(r100, "coordinatorLayout");
        Intrinsics.checkNotNullParameter(r101, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        Intrinsics.checkNotNullParameter(r102, PickerReporterConstants.KEY.TARGET);
        WeakReference<View> r108 = this.f258406x;
        if (r108 == null) goto L5;
        View r109 = r108.get();
    L6:
        if (r102 != r109) goto L22;
        if (r107 == 0) goto L23;
        if (r106 > 0) goto L26;
        int r110 = r101.getTop();
        if (r110 >= this.f258397o) goto L24;
        if (r110 < 0) goto L27;
        int r111 = r110 - r106;
        if (r102.canScrollVertically(-1) == true) goto L25;
        int r112 = this.f258397o;
        if (r111 >= r112) goto L19;
        ViewCompat.offsetTopAndBottom(r101, -r106);
        setStateInternal(2);
    L20:
        j();
        return;
    L19:
        ViewCompat.offsetTopAndBottom(r101, -(r110 - r112));
        setStateInternal(6);
        goto L20
    L25:
        return;
    L27:
        return;
    L24:
        return;
    L26:
        return;
    L23:
        return;
    L22:
        return;
    L5:
        r109 = null;
        goto L6
    }
}
