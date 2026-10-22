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
import androidx.core.view.ViewCompat;
import androidx.customview.widget.ViewDragHelper;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003:\u0002\n\u000bB\u0019\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/bytedance/locallife/dito/interact/ImmerseBottomBehavior;", "Landroid/view/View;", "V", "Lcom/bytedance/locallife/dito/interact/AbstractInteractBehavior;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "dito-core-saas_release"}, k = 1, mv = {1, 4, 3})
public final class ImmerseBottomBehavior<V extends View> extends AbstractInteractBehavior<V> {
    public static final /* synthetic */ int A = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final float f258418j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f258419k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f258420l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f258421m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f258422n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f258423o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public WeakReference<V> f258424p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public WeakReference<View> f258425q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public ViewDragHelper f258426r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public VelocityTracker f258427s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public ImmerseBottomBehavior<V>.b f258428t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f258429u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f258430v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f258431w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final boolean f258432x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final float f258433y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final ImmerseBottomBehavior$dragCallback$1 f258434z;

    public static final class a {
    }

    public final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f258435a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f258436b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f258437c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ ImmerseBottomBehavior<V> f258438d;

        @Override // java.lang.Runnable
        public final void run() {
            ViewDragHelper r100 = this.f258438d.f258426r;     // Catch: Throwable -> L13
            if (r100 == null) goto L7;
            boolean r101 = true;
            if (r100.continueSettling(true) != true) goto L7;
        L8:
            if (r101 == false) goto L10;
            ViewCompat.postOnAnimation(this.f258435a, this);     // Catch: Throwable -> L13
        L11:
            this.f258437c = false;     // Catch: Throwable -> L13
            return;
        L10:
            this.f258438d.setStateInternal(this.f258436b);     // Catch: Throwable -> L13
        L7:
            r101 = false;
        L13:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L17;
            return;
        L17:
            throw th;
        }

        public b(ImmerseBottomBehavior r100, View r101, int r102) {
            Intrinsics.checkNotNullParameter(r101, "view");
            this.f258438d = r100;
            this.f258435a = r101;
            this.f258436b = r102;
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ImmerseBottomBehavior<V> f258439a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ V f258440b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f258441c;

        public c(ImmerseBottomBehavior<V> r100, V r101, int r102) {
            this.f258439a = r100;
            this.f258440b = r101;
            this.f258441c = r102;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ImmerseBottomBehavior<V> r100 = this.f258439a;     // Catch: Throwable -> L4
            V r101 = this.f258440b;     // Catch: Throwable -> L4
            int r102 = this.f258441c;     // Catch: Throwable -> L4
            int r103 = ImmerseBottomBehavior.A;     // Catch: Throwable -> L4
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
    }

    @Override // com.bytedance.locallife.dito.interact.AbstractInteractBehavior
    public final boolean b() {
        int r100 = this.f258320e;
        if (r100 >= 0) goto L5;
        return false;
    L5:
        if (r100 > 0) goto L8;
        return true;
    L8:
        return false;
    }

    @Override // com.bytedance.locallife.dito.interact.AbstractInteractBehavior
    public final void e() {
        WeakReference<V> r100 = this.f258424p;
        if (r100 == null) goto L9;
        V r101 = r100.get();
        if (r101 == null) goto L10;
        int r102 = 0 - r101.getTop();
        setStateInternal(7);
        ViewCompat.offsetTopAndBottom(r101, r102);
        j();
        return;
    L10:
        return;
    }

    public final void j() {
        WeakReference<V> r100 = this.f258424p;
        if (r100 == null) goto L8;
        V r101 = r100.get();
        if (r101 == null) goto L9;
        h(r101, r101.getTop());
        return;
    L9:
        return;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final void onDetachedFromLayoutParams() {
        super.onDetachedFromLayoutParams();
        this.f258424p = null;
        this.f258426r = null;
    }

    public final View findScrollingChild(View r100) {
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

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final void onAttachedToLayoutParams(CoordinatorLayout.LayoutParams r100) {
        Intrinsics.checkNotNullParameter(r100, "layoutParams");
        super.onAttachedToLayoutParams(r100);
        this.f258424p = null;
        this.f258426r = null;
    }

    @Override // com.bytedance.locallife.dito.interact.AbstractInteractBehavior
    public final void setState(final int r100) {
        if (r100 != this.f258318c) goto L6;
        return;
    L6:
        if (this.f258424p != null) goto L12;
        if (r100 == 4) goto L10;
        if (r100 == 5) goto L10;
        return;
    L10:
        this.f258318c = r100;
        return;
    L12:
        com.bytedance.locallife.dito.interact.c r101 = this.f258321f;
        if (r101 != null) goto L15;
    L24:
        settleToStatePendingLayout(r100);
        return;
    L15:
        if (this.f258316a == true) goto L20;
        if (r100 != 4) goto L20;
        r101.b(new AnonymousClass1(this, r100));
        return;
    L20:
        if (this.f258317b == true) goto L24;
        if (r100 != 5) goto L24;
        r101.a(new AnonymousClass2(this, r100));
    }

    public final void setStateInternal(int r100) {
        if (this.f258318c != r100) goto L5;
        return;
    L5:
        this.f258318c = r100;
        WeakReference<V> r101 = this.f258424p;
        if (r101 == null) goto L12;
        V r102 = r101.get();
        if (r102 == null) goto L13;
        i(r102, r100);
        return;
    L13:
        return;
    }

    public final void settleToStatePendingLayout(int r100) {
        WeakReference<V> r101 = this.f258424p;
        if (r101 == null) goto L16;
        V r102 = r101.get();
        if (r102 == null) goto L18;
        ViewParent r103 = r102.getParent();
        if (r103 != null) goto L10;
    L14:
        settleToState(r102, r100);
        return;
    L10:
        if (r103.isLayoutRequested() == false) goto L14;
        if (ViewCompat.isAttachedToWindow(r102) == false) goto L14;
        r102.post(new c(this, r102, r100));
        return;
    L18:
        return;
    }

    /* JADX WARN: Type inference failed for: r2v6, types: [com.bytedance.locallife.dito.interact.ImmerseBottomBehavior$dragCallback$1] */
    public ImmerseBottomBehavior(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f258418j = ViewConfiguration.get(r100).getScaledMaximumFlingVelocity();
        this.f258432x = true;
        this.f258433y = 0.5f;
        this.f258434z = new ImmerseBottomBehavior$dragCallback$1(this);
    }

    public final boolean k(V r100, MotionEvent r101) {
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
        ViewDragHelper r105 = this.f258426r;
        if (r105 == null) goto L14;
        r105.processTouchEvent(r101);
    L14:
        if (r104 != 0) goto L20;
        this.f258429u = -1;
        VelocityTracker r106 = this.f258427s;
        if (r106 == null) goto L18;
        r106.recycle();
    L18:
        this.f258427s = null;
    L20:
        if (this.f258427s != null) goto L22;
        this.f258427s = VelocityTracker.obtain();
    L22:
        VelocityTracker r107 = this.f258427s;
        if (r107 == null) goto L26;
        r107.addMovement(r101);
    L26:
        if (this.f258426r == null) goto L39;
        if (r104 != 2) goto L39;
        if (this.f258421m == true) goto L39;
        float r108 = Math.abs(this.f258430v - r101.getY());
        ViewDragHelper r109 = this.f258426r;
        if (r109 == null) goto L34;
        r103 = r109.getTouchSlop();
    L34:
        if (r108 <= r103) goto L39;
        ViewDragHelper r110 = this.f258426r;
        if (r110 == null) goto L39;
        r110.captureChildView(r100, r101.getPointerId(r101.getActionIndex()));
    L39:
        return !this.f258421m;
    }

    public final void settleToState(View r100, int r101) {
        if (r101 != 4) goto L5;
        int r102 = this.f258420l;
    L10:
        startSettlingAnimation(r100, r101, r102, false);
        return;
    L5:
        if (r101 != 5) goto L8;
        r102 = this.f258419k;
        goto L10
    L8:
        throw new IllegalArgumentException("Illegal state argument: " + r101);
    }

    public final boolean shouldHide(View r100, float r101) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        if (r100.getTop() > this.f258420l) goto L5;
        return false;
    L5:
        float r102 = 0;
        if (r100.getTop() <= ((int) (this.f258419k - (this.f258433y * r102)))) goto L9;
        return true;
    L9:
        if (this.f258422n < (-15)) goto L11;
        return false;
    L11:
        if (r101 <= 2000) goto L21;
        float r103 = r100.getTop();
        float r104 = this.f258322g;
        if (r104 > r102) goto L17;
        r104 = 0.25f;
    L17:
        if ((Math.abs((r103 + (r101 * r104)) - this.f258420l) / r102) <= 0.75f) goto L22;
        return true;
    L22:
        return false;
    L21:
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onInterceptTouchEvent(CoordinatorLayout r100, V r110, MotionEvent r111) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        Intrinsics.checkNotNullParameter(r110, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        Intrinsics.checkNotNullParameter(r111, "event");
        if (r110.isShown() == true) goto L5;
    L77:
        this.f258421m = true;
        return false;
    L5:
        if (this.f258319d != 1) goto L77;
        int r101 = r111.getActionMasked();
        View r102 = null;
        if (r101 != 0) goto L14;
        this.f258429u = -1;
        VelocityTracker r103 = this.f258427s;
        if (r103 == null) goto L12;
        r103.recycle();
    L12:
        this.f258427s = null;
    L14:
        if (this.f258427s != null) goto L16;
        this.f258427s = VelocityTracker.obtain();
    L16:
        VelocityTracker r104 = this.f258427s;
        if (r104 == null) goto L20;
        r104.addMovement(r111);
    L20:
        if (r101 == 0) goto L28;
        if (r101 == 1) goto L24;
        if (r101 == 3) goto L24;
    L46:
        if (this.f258421m == true) goto L55;
        ViewDragHelper r112 = this.f258426r;
        if (r112 != null) goto L50;
    L52:
        boolean r113 = false;
    L53:
        if (r113 == false) goto L55;
        return true;
    L50:
        if (r112.shouldInterceptTouchEvent(r111) != true) goto L52;
        r113 = true;
    L55:
        WeakReference<View> r114 = this.f258425q;
        if (r114 == null) goto L59;
        r102 = r114.get();
    L59:
        if (r101 != 2) goto L79;
        if (r102 != null) goto L62;
        return false;
    L62:
        if (this.f258421m == false) goto L64;
        return false;
    L64:
        if (this.f258318c != 2) goto L66;
        return false;
    L66:
        if (r100.isPointInChildBounds(r102, (int) r111.getX(), (int) r111.getY()) == false) goto L68;
        return false;
    L68:
        if (this.f258426r == null) goto L84;
        float r105 = Math.abs(this.f258430v - r111.getY());
        ViewDragHelper r115 = this.f258426r;
        if (r115 == null) goto L72;
        int r116 = r115.getTouchSlop();
    L74:
        if (r105 <= r116) goto L85;
        return true;
    L85:
        return false;
    L72:
        r116 = 0;
        goto L74
    L84:
        return false;
    L79:
        return false;
    L24:
        this.f258431w = false;
        this.f258429u = -1;
        if (this.f258421m == false) goto L46;
        this.f258421m = false;
        return false;
    L28:
        int r106 = (int) r111.getX();
        this.f258430v = (int) r111.getY();
        if (this.f258318c == 3) goto L39;
        WeakReference<View> r107 = this.f258425q;
        if (r107 == null) goto L33;
        View r108 = r107.get();
    L34:
        if (r108 == null) goto L39;
        if (r100.isPointInChildBounds(r108, r106, this.f258430v) == false) goto L39;
        this.f258429u = r111.getPointerId(r111.getActionIndex());
        this.f258431w = true;
        goto L39
    L33:
        r108 = null;
    L39:
        if (this.f258429u == (-1)) goto L41;
    L43:
        boolean r117 = false;
    L44:
        this.f258421m = r117;
        goto L46
    L41:
        if (r100.isPointInChildBounds(r110, r106, this.f258430v) == true) goto L43;
        r117 = true;
        goto L44
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onLayoutChild(CoordinatorLayout r100, V r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        Intrinsics.checkNotNullParameter(r101, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        if (ViewCompat.getFitsSystemWindows(r100) == false) goto L8;
        if (ViewCompat.getFitsSystemWindows(r101) == true) goto L8;
        r101.setFitsSystemWindows(true);
    L8:
        if (this.f258424p != null) goto L13;
        this.f258424p = new WeakReference(r101);
        if (ViewCompat.getImportantForAccessibility(r101) != 0) goto L13;
        ViewCompat.setImportantForAccessibility(r101, 1);
    L13:
        if (this.f258426r != null) goto L15;
        this.f258426r = ViewDragHelper.create(r100, this.f258434z);
    L15:
        int r103 = r101.getTop();
        r100.onLayoutChild(r101, r102);
        int r104 = this.f258419k;
        int r105 = r100.getHeight();
        this.f258419k = r105;
        int r106 = 0;
        int r107 = r105 + 0;
        if (this.f258420l == r107) goto L20;
        this.f258420l = r107;
        int r108 = this.f258324i.size();
    L18:
        if (r106 >= r108) goto L20;
        ((com.bytedance.locallife.dito.interact.b) ListProtector.get(this.f258324i, r106)).a(r107);
        r106 = r106 + 1;
    L20:
        int r109 = this.f258318c;
        if (r109 != 5) goto L24;
        ViewCompat.offsetTopAndBottom(r101, this.f258419k);
    L34:
        this.f258425q = new WeakReference(findScrollingChild(r101));
        return true;
    L24:
        if (r109 != 4) goto L28;
        ViewCompat.offsetTopAndBottom(r101, this.f258420l);
        if (r104 == this.f258419k) goto L34;
        j();
        goto L34
    L28:
        if (r109 != 1) goto L30;
    L33:
        ViewCompat.offsetTopAndBottom(r101, r103 - r101.getTop());
        goto L34
    L30:
        if (r109 == 2) goto L33;
        if (r109 != 3) goto L34;
        goto L33
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onTouchEvent(CoordinatorLayout r100, V r101, MotionEvent r102) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        Intrinsics.checkNotNullParameter(r101, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        Intrinsics.checkNotNullParameter(r102, "event");
        if (r101.isShown() == true) goto L5;
        return false;
    L5:
        if (this.f258319d != 1) goto L13;
        return k(r101, r102);
    L14:
        return false;
    L13:
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final void onStopNestedScroll(CoordinatorLayout r100, V r101, View r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, "coordinatorLayout");
        Intrinsics.checkNotNullParameter(r101, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        Intrinsics.checkNotNullParameter(r102, PickerReporterConstants.KEY.TARGET);
        int r104 = r101.getTop();
        WeakReference<View> r105 = this.f258425q;
        if (r105 == null) goto L40;
        if (r105 == null) goto L6;
        View r106 = r105.get();
    L7:
        if (r102 == r106) goto L9;
        return;
    L9:
        if (this.f258423o == true) goto L11;
        return;
    L11:
        if (r103 == 1) goto L44;
        setStateInternal(1);
        int r107 = this.f258420l;
        if (r104 >= r107) goto L16;
        return;
    L16:
        int r108 = 4;
        if (this.f258422n <= 0) goto L22;
        if (r104 > r107) goto L34;
        r107 = -1;
        r108 = -1;
    L34:
        if (r107 == (-1)) goto L36;
        startSettlingAnimation(r101, r108, r107, false);
    L36:
        this.f258423o = false;
        Iterator r109 = ((ArrayList) this.f258323h).iterator();
    L38:
        if (r109.hasNext() == false) goto L45;
        ((d) r109.next()).b();
        goto L38
    L45:
        return;
    L22:
        if (this.f258432x == false) goto L32;
        VelocityTracker r110 = this.f258427s;
        float r111 = 0.0f;
        if (r110 == null) goto L30;
        r110.computeCurrentVelocity(1000, this.f258418j);
        VelocityTracker r112 = this.f258427s;
        if (r112 == null) goto L30;
        r111 = r112.getYVelocity(this.f258429u);
    L30:
        if (shouldHide(r101, r111) == false) goto L32;
        r107 = this.f258419k;
        r108 = 5;
    L32:
        r107 = this.f258420l;
        goto L34
    L44:
        return;
    L6:
        r106 = null;
        goto L7
    }

    public final void startSettlingAnimation(View r100, int r101, int r102, boolean r103) {
        if (r103 == false) goto L6;
        ViewDragHelper r104 = this.f258426r;
        if (r104 == null) goto L9;
        Boolean r105 = Boolean.valueOf(r104.settleCapturedViewAt(r100.getLeft(), r102));
    L10:
        int r106 = 0;
        if (r101 != 4) goto L18;
        if (this.f258316a == true) goto L18;
        this.f258316a = true;
        int r107 = this.f258324i.size();
        int r108 = 0;
    L15:
        if (r108 >= r107) goto L18;
        ((com.bytedance.locallife.dito.interact.b) ListProtector.get(this.f258324i, r108)).g();
        r108 = r108 + 1;
    L18:
        if (r101 != 5) goto L23;
        int r109 = this.f258324i.size();
    L20:
        if (r106 >= r109) goto L23;
        ((com.bytedance.locallife.dito.interact.b) ListProtector.get(this.f258324i, r106)).f();
        r106 = r106 + 1;
    L23:
        if (Intrinsics.areEqual(r105, Boolean.TRUE) == false) goto L33;
        setStateInternal(3);
        if (this.f258428t != null) goto L27;
        this.f258428t = new b(this, r100, r101);
    L27:
        ImmerseBottomBehavior<V>.b r110 = this.f258428t;
        if (r110 != null) goto L30;
        return;
    L30:
        if (r110.f258437c == true) goto L32;
        r110.f258436b = r101;
        ViewCompat.postOnAnimation(r100, r110);
        r110.f258437c = true;
        return;
    L32:
        r110.f258436b = r101;
        return;
    L33:
        setStateInternal(r101);
        return;
    L9:
        r105 = null;
        goto L10
    L6:
        ViewDragHelper r111 = this.f258426r;
        if (r111 == null) goto L9;
        r105 = Boolean.valueOf(r111.smoothSlideViewTo(r100, r100.getLeft(), r102));
        goto L10
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onNestedPreFling(CoordinatorLayout r100, V r101, View r102, float r103, float r104) {
        Intrinsics.checkNotNullParameter(r100, "coordinatorLayout");
        Intrinsics.checkNotNullParameter(r101, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        Intrinsics.checkNotNullParameter(r102, PickerReporterConstants.KEY.TARGET);
        int r105 = r101.getTop();
        WeakReference<View> r106 = this.f258425q;
        if (r106 == null) goto L13;
        if (r106 == null) goto L6;
        View r107 = r106.get();
    L8:
        if (Intrinsics.areEqual(r102, r107) == true) goto L10;
        return false;
    L10:
        if (r105 < this.f258420l) goto L15;
        return true;
    L15:
        return false;
    L6:
        r107 = null;
        goto L8
    L13:
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onStartNestedScroll(CoordinatorLayout r100, V r101, View r102, View r103, int r104, int r105) {
        Intrinsics.checkNotNullParameter(r100, "coordinatorLayout");
        Intrinsics.checkNotNullParameter(r101, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        Intrinsics.checkNotNullParameter(r102, "directTargetChild");
        Intrinsics.checkNotNullParameter(r103, PickerReporterConstants.KEY.TARGET);
        this.f258422n = 0;
        this.f258423o = false;
        if ((r104 & 2) == 0) goto L6;
        return true;
    L6:
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final void onNestedPreScroll(CoordinatorLayout r100, V r101, View r102, int r103, int r110, int[] r111, int r112) {
        Intrinsics.checkNotNullParameter(r100, "coordinatorLayout");
        Intrinsics.checkNotNullParameter(r101, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        Intrinsics.checkNotNullParameter(r102, PickerReporterConstants.KEY.TARGET);
        Intrinsics.checkNotNullParameter(r111, "consumed");
        int r104 = this.f258319d;
        if (r104 != 2) goto L6;
        return;
    L6:
        if (r104 != 3) goto L9;
        if (r110 <= 0) goto L9;
        return;
    L9:
        WeakReference<View> r105 = this.f258425q;
        if (r105 == null) goto L12;
        View r106 = r105.get();
    L14:
        if (Intrinsics.areEqual(r102, r106) == true) goto L16;
        return;
    L16:
        int r107 = r101.getTop();
        int r108 = r107 - r110;
        if (r112 != 0) goto L32;
        if (r110 <= 0) goto L22;
        if (r108 > 0) goto L21;
        int r109 = r107 + 0;
        r111[1] = r109;
        ViewCompat.offsetTopAndBottom(r101, -r109);
        setStateInternal(7);
    L48:
        j();
        this.f258423o = true;
        this.f258422n = r110;
        Iterator r113 = ((ArrayList) this.f258323h).iterator();
    L50:
        if (r113.hasNext() == false) goto L52;
        ((d) r113.next()).a();
        goto L50
    L52:
        return;
    L21:
        r111[1] = r110;
        ViewCompat.offsetTopAndBottom(r101, -r110);
        setStateInternal(2);
        goto L48
    L22:
        if (r110 >= 0) goto L48;
        if (r102.canScrollVertically(-1) == true) goto L48;
        if (this.f258432x == false) goto L28;
    L30:
        r111[1] = r110;
        ViewCompat.offsetTopAndBottom(r101, -r110);
        setStateInternal(2);
        goto L48
    L28:
        if (r107 < this.f258420l) goto L30;
        r111[1] = r110;
        setStateInternal(4);
        goto L48
    L32:
        if (r107 < this.f258420l) goto L34;
        return;
    L34:
        if (r110 <= 0) goto L37;
        if (r107 > 0) goto L37;
        return;
    L37:
        if (r110 <= 0) goto L41;
        if (r108 > 0) goto L40;
        int r114 = r107 + 0;
        r111[1] = r114;
        ViewCompat.offsetTopAndBottom(r101, -r114);
        setStateInternal(7);
        goto L48
    L40:
        r111[1] = r110;
        ViewCompat.offsetTopAndBottom(r101, -r110);
        setStateInternal(2);
        goto L48
    L41:
        if (r110 >= 0) goto L48;
        if (r102.canScrollVertically(-1) == true) goto L48;
        int r115 = this.f258420l;
        if (r108 > r115) goto L47;
        r111[1] = r110;
        ViewCompat.offsetTopAndBottom(r101, -r110);
        setStateInternal(2);
        goto L48
    L47:
        int r116 = r107 - r115;
        r111[1] = r116;
        ViewCompat.offsetTopAndBottom(r101, -r116);
        setStateInternal(4);
        goto L48
    L12:
        r106 = null;
        goto L14
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final void onNestedScroll(CoordinatorLayout r100, V r101, View r102, int r103, int r104, int r105, int r106, int r107) {
        Intrinsics.checkNotNullParameter(r100, "coordinatorLayout");
        Intrinsics.checkNotNullParameter(r101, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        Intrinsics.checkNotNullParameter(r102, PickerReporterConstants.KEY.TARGET);
        WeakReference<View> r108 = this.f258425q;
        if (r108 == null) goto L5;
        View r109 = r108.get();
    L6:
        if (r102 != r109) goto L22;
        if (r107 == 0) goto L24;
        int r110 = r101.getTop();
        if (r110 >= this.f258420l) goto L23;
        if (r110 < 0) goto L25;
        if (r106 >= 0) goto L20;
        int r111 = r110 - r106;
        if (r102.canScrollVertically(-1) == true) goto L20;
        int r112 = this.f258420l;
        if (r111 >= r112) goto L19;
        ViewCompat.offsetTopAndBottom(r101, -r106);
        setStateInternal(2);
        goto L20
    L19:
        ViewCompat.offsetTopAndBottom(r101, -(r110 - r112));
        setStateInternal(4);
    L20:
        j();
        return;
    L25:
        return;
    L23:
        return;
    L24:
        return;
    L22:
        return;
    L5:
        r109 = null;
        goto L6
    }
}
