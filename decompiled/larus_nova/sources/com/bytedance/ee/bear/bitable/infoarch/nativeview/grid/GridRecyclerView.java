package com.bytedance.ee.bear.bitable.infoarch.nativeview.grid;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.byted.cast.common.CastMonitor;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u0000 T2\u00020\u0001:\u0002TUB\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u00104\u001a\u00020-2\u0006\u0010,\u001a\u00020\u001bJ\u0018\u00105\u001a\u00020-2\u0006\u00106\u001a\u00020\u000e2\u0006\u00107\u001a\u00020\u000eH\u0014J0\u00108\u001a\u00020-2\u0006\u00109\u001a\u00020\u001b2\u0006\u0010:\u001a\u00020\u000e2\u0006\u0010;\u001a\u00020\u000e2\u0006\u0010<\u001a\u00020\u000e2\u0006\u0010=\u001a\u00020\u000eH\u0014J\u0010\u0010>\u001a\u00020-2\u0006\u0010?\u001a\u00020@H\u0014J\u0010\u0010A\u001a\u00020-2\b\b\u0002\u0010!\u001a\u00020\u001bJ\u0010\u0010B\u001a\u00020-2\u0006\u0010C\u001a\u00020DH\u0002J(\u0010E\u001a\u00020-2\u0006\u0010F\u001a\u00020\u000e2\u0006\u0010G\u001a\u00020\u000e2\u0006\u0010H\u001a\u00020\u000e2\u0006\u0010I\u001a\u00020\u000eH\u0014J\u0010\u0010J\u001a\u00020\u001b2\u0006\u0010C\u001a\u00020DH\u0016J\u0010\u0010K\u001a\u00020\u001b2\u0006\u0010C\u001a\u00020DH\u0016J\u0010\u0010L\u001a\u00020\u001b2\u0006\u0010M\u001a\u00020\tH\u0002J\u0010\u0010N\u001a\u00020\u001b2\u0006\u0010O\u001a\u00020\u000eH\u0002J\u0012\u0010P\u001a\u00020-2\b\b\u0002\u0010Q\u001a\u00020\u001bH\u0002J\b\u0010R\u001a\u00020\u001bH\u0002J\b\u0010S\u001a\u00020\u001bH\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001a\u001a\u00020\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u000e\u0010 \u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\"\u001a\u00020#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R7\u0010(\u001a\u001f\u0012\u0013\u0012\u00110\u001b¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(,\u0012\u0004\u0012\u00020-\u0018\u00010)X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001a\u00102\u001a\u00020\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u001d\"\u0004\b3\u0010\u001f¨\u0006V"}, d2 = {"Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/grid/GridRecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "downX", "", "downY", "lastY", "lastX", "scrollLock", "", "velocityTracker", "Landroid/view/VelocityTracker;", "scaledTouchSlop", "touchSlop", "maxFlingVelocity", "scroller", "Landroid/widget/OverScroller;", "flingRunnable", "Ljava/lang/Runnable;", "sQuinticInterpolator", "Landroid/view/animation/Interpolator;", "openHorizontalScroll", "", "getOpenHorizontalScroll", "()Z", "setOpenHorizontalScroll", "(Z)V", "openNestedVerticalScroll", "disallowParentIntercept", "rowScrollManager", "Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/grid/row/RowScrollManager;", "getRowScrollManager", "()Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/grid/row/RowScrollManager;", "setRowScrollManager", "(Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/grid/row/RowScrollManager;)V", "horizontalScrollListener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "isScrolling", "", "getHorizontalScrollListener", "()Lkotlin/jvm/functions/Function1;", "setHorizontalScrollListener", "(Lkotlin/jvm/functions/Function1;)V", "isHorizontalScrolling", "setHorizontalScrolling", "toggleHorizontalScrollState", "onMeasure", "widthSpec", "heightSpec", "onLayout", CastMonitor.EVENT_PARAM_BYTECAST_NETWORK_STATE_CHANGED, "l", "t", "r", "b", "dispatchDraw", "canvas", "Landroid/graphics/Canvas;", "setScrollInLinkTable", "initInDownEvent", "e", "Landroid/view/MotionEvent;", "onSizeChanged", "w", "h", "oldw", "oldh", "onInterceptTouchEvent", "onTouchEvent", "onHorizontalFling", "velocityX", "scrollToTheEnd", "x", "stopHorizontalFling", "isDragging", "isAtTop", "isAtBottom", "Companion", "FlingRunnable", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GridRecyclerView extends RecyclerView {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final /* synthetic */ int f213507r = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f213508a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f213509b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f213510c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f213511d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final VelocityTracker f213512e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f213513f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f213514g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f213515h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public OverScroller f213516i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public b f213517j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final f f213518k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f213519l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f213520m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f213521n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public mt4.d f213522o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Function1<? super Boolean, Unit> f213523p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f213524q;

    public static final class a {
    }

    public final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f213526a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ GridRecyclerView f213527b;

        public final void a() {
            GridRecyclerView r100 = this.f213527b;
            OverScroller r101 = r100.f213516i;
            if (r101 != null) goto L5;
            return;
        L5:
            if (r101.computeScrollOffset() == false) goto L17;
            int r102 = -(r101.getCurrX() - this.f213526a);
            mt4.e r103 = r100.f213522o.f515638b;
            if (r102 <= 0) goto L12;
            if (r103.f515643e == 0) goto L13;
        L14:
            boolean r104 = false;
        L15:
            if (r104 == true) goto L17;
            int r105 = r101.getCurrX() - this.f213526a;
            int r106 = GridRecyclerView.f213507r;
            tt5.a.b("GridRecyclerView", "onFling>>> compute:" + r101.getCurrX() + ". dx:" + r105);
            r100.getRowScrollManager().b(r105);
            this.f213526a = r101.getCurrX();
            ViewCompat.postOnAnimation(r100, this);
            return;
        L13:
            r104 = true;
            goto L15
        L12:
            if (r103.f515643e != r103.f515641c) goto L14;
        L17:
            int r107 = GridRecyclerView.f213507r;
            tt5.a.b("GridRecyclerView", "onFling>>> End");
            r100.stopScroll();
            r100.y(false);
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

        public b(GridRecyclerView r100) {
            this.f213527b = r100;
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GridRecyclerView f213528a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Canvas f213529b;

        public c(GridRecyclerView r100, Canvas r101) {
            this.f213528a = r100;
            this.f213529b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            GridRecyclerView.r(this.f213528a, this.f213529b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GridRecyclerView f213530a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f213531b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f213532c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f213533d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ int f213534e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ int f213535f;

        public d(GridRecyclerView r100, boolean r101, int r102, int r103, int r104, int r105) {
            this.f213530a = r100;
            this.f213531b = r101;
            this.f213532c = r102;
            this.f213533d = r103;
            this.f213534e = r104;
            this.f213535f = r105;
        }

        @Override // java.lang.Runnable
        public final void run() {
            GridRecyclerView.t(this.f213530a, this.f213531b, this.f213532c, this.f213533d, this.f213534e, this.f213535f);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GridRecyclerView f213536a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f213537b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f213538c;

        public e(GridRecyclerView r100, int r101, int r102) {
            this.f213536a = r100;
            this.f213537b = r101;
            this.f213538c = r102;
        }

        @Override // java.lang.Runnable
        public final void run() {
            GridRecyclerView.u(this.f213536a, this.f213537b, this.f213538c);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class f implements Interpolator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final f f213539a = null;

        static {
            f213539a = new f();
        }

        public f() {
        }

        @Override // android.animation.TimeInterpolator
        public final float getInterpolation(float r100) {
            float r101 = r100 - 1.0f;
            return ((((r101 * r101) * r101) * r101) * r101) + 1.0f;
        }
    }

    static {
    }

    public final boolean v() {
        if (getChildCount() != 0) goto L5;
        return true;
    L5:
        View r100 = getChildAt(getChildCount() - 1);
        RecyclerView.Adapter r101 = getAdapter();
        if (r101 == null) goto L10;
        int r102 = r101.getItemCount();
        if (getChildAdapterPosition(r100) != (r102 - 1)) goto L10;
        boolean r103 = true;
    L11:
        if (r103 == true) goto L13;
    L15:
        return false;
    L13:
        if (r100.getBottom() > (getHeight() - getPaddingBottom())) goto L15;
        return true;
    L10:
        r103 = false;
        goto L11
    }

    public final boolean w() {
        if (getChildCount() != 0) goto L5;
        return true;
    L5:
        View r100 = getChildAt(0);
        if (getChildAdapterPosition(r100) == 0) goto L8;
    L10:
        return false;
    L8:
        if (r100.getTop() != getPaddingTop()) goto L10;
        return true;
    }

    public final Function1<Boolean, Unit> getHorizontalScrollListener() {
        return this.f213523p;
    }

    public final boolean getOpenHorizontalScroll() {
        return this.f213519l;
    }

    public final mt4.d getRowScrollManager() {
        return this.f213522o;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        int r101 = ht4.b.f487130a;
        c r102 = new c(this, r100);
        Intrinsics.checkNotNullParameter(r102, "runnable");
        r102.run();
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "e");
        tt5.a.b("GridRecyclerView", "onInterceptTouchEvent e: " + r100.getX() + ", " + r100.getY() + ", " + r100.getAction());
        boolean r101 = false;
        if (isLayoutSuppressed() == false) goto L5;
        return false;
    L5:
        this.f213512e.addMovement(r100);
        int r102 = r100.getAction();
        if (r102 == 0) goto L27;
        if (r102 != 1) goto L9;
        this.f213512e.clear();
    L30:
        boolean r103 = false;
    L32:
        if (super.onInterceptTouchEvent(r100) == true) goto L34;
        if (r103 == true) goto L34;
    L35:
        tt5.a.b("GridRecyclerView", "onInterceptTouchEvent result:" + r101 + ". needIntercept:" + r103 + ". state:" + getScrollState());
        return r101;
    L34:
        r101 = true;
        goto L35
    L9:
        if (r102 != 2) goto L30;
        float r104 = r100.getX() - this.f213508a;
        float r105 = r100.getY() - this.f213509b;
        tt5.a.b("GridRecyclerView", "onInterceptTouchEvent dx:" + r104 + ", dy:" + r105 + ", touchSlop:" + this.f213514g + ", openInnerVerticalScroll:" + this.f213520m);
        if (Math.abs(r104) > this.f213514g) goto L18;
        if (Math.abs(r105) <= this.f213514g) goto L30;
        if (this.f213520m == false) goto L30;
    L18:
        if (this.f213511d == 0) goto L20;
    L25:
        r103 = true;
        goto L32
    L20:
        if (Math.abs(r104) <= Math.abs(r105)) goto L23;
        this.f213511d = 1;
        y(true);
        goto L25
    L23:
        if (this.f213520m == false) goto L25;
        this.f213511d = 2;
        getParent().requestDisallowInterceptTouchEvent(true);
        goto L25
    L27:
        this.f213508a = r100.getX();
        this.f213509b = r100.getY();
        this.f213510c = r100.getX();
        r100.getY();
        this.f213511d = 0;
        if (this.f213521n == false) goto L30;
        getParent().requestDisallowInterceptTouchEvent(true);
        goto L30
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public final boolean onTouchEvent(MotionEvent r210) {
        Intrinsics.checkNotNullParameter(r210, "e");
        tt5.a.b("GridRecyclerView", "onTouchEvent e: " + r210.getX() + ", " + r210.getY() + ", " + r210.getAction());
        if (this.f213519l == false) goto L5;
        boolean r100 = false;
        if (isLayoutSuppressed() == false) goto L9;
        return false;
    L9:
        MotionEvent r101 = MotionEvent.obtain(r210);
        int r102 = r210.getAction();
        if (r102 == 0) goto L89;
        if (r102 != 1) goto L13;
        this.f213512e.addMovement(r101);
        this.f213512e.computeCurrentVelocity(1000, this.f213515h);
        if (this.f213511d != 1) goto L87;
        float r103 = this.f213512e.getXVelocity();
        tt5.a.b("GridRecyclerView", "onFling>>> " + r103);
        if (this.f213511d != 1) goto L88;
        b r104 = this.f213517j;
        if (r104 == null) goto L63;
        removeCallbacks(r104);
        this.f213517j = null;
    L63:
        if (this.f213516i != null) goto L65;
        this.f213516i = new OverScroller(getContext(), this.f213518k);
    L65:
        OverScroller r110 = this.f213516i;
        if (r110 == null) goto L68;
        int r105 = this.f213515h;
        r110.fling(0, 0, -((int) r103), 0, -r105, r105, 0, 0);
    L68:
        OverScroller r106 = this.f213516i;
        if (r106 != null) goto L71;
    L73:
        boolean r107 = false;
    L74:
        if (r107 == false) goto L86;
        int r108 = (int) r103;
        mt4.e r109 = this.f213522o.f515638b;
        if (r108 <= 0) goto L81;
        if (r109.f515643e == 0) goto L82;
    L83:
        boolean r111 = false;
    L84:
        if (r111 == true) goto L86;
        b r112 = new b(this);
        ViewCompat.postOnAnimation(this, r112);
        this.f213517j = r112;
    L82:
        r111 = true;
        goto L84
    L81:
        if (r109.f515643e != r109.f515641c) goto L83;
    L86:
        tt5.a.b("GridRecyclerView", "GridRecyclerView GestureDetector onFling onStart.");
        stopScroll();
        y(false);
        goto L88
    L71:
        if (r106.computeScrollOffset() != true) goto L73;
        r107 = true;
    L88:
        r100 = true;
    L90:
        if (r100 == true) goto L92;
        this.f213512e.addMovement(r101);
    L92:
        r101.recycle();
        if (this.f213511d != 1) goto L96;
        return true;
    L96:
        return super.onTouchEvent(r210);
    L87:
        x(false);
        goto L88
    L13:
        if (r102 != 2) goto L15;
        float r113 = Math.abs(r210.getX() - this.f213508a);
        float r114 = Math.abs(r210.getY() - this.f213509b);
        if (this.f213511d != 0) goto L33;
        float r115 = this.f213514g;
        if (r113 > r115) goto L25;
        if (r114 <= r115) goto L33;
    L25:
        if (r113 <= r114) goto L27;
        int r116 = 1;
    L28:
        this.f213511d = r116;
        tt5.a.b("GridRecyclerView", "scrollLock: abxX:" + r113 + ", absY:" + r114);
        if (this.f213511d != 1) goto L31;
        boolean r117 = true;
    L32:
        y(r117);
        goto L33
    L31:
        r117 = false;
        goto L32
    L27:
        r116 = 2;
    L33:
        int r118 = this.f213511d;
        if (r118 != 1) goto L36;
        float r119 = this.f213510c;
        float r120 = r119 - r210.getX();
        this.f213510c -= MathKt.roundToInt(r120);
        tt5.a.b("GridRecyclerView", "onScrollX: lastX:" + r119 + ", dx:" + r120 + ", changeLastX:" + this.f213510c);
        this.f213522o.b(MathKt.roundToInt(r120));
        getParent().requestDisallowInterceptTouchEvent(true);
        x(true);
        goto L90
    L36:
        if (r118 != 2) goto L90;
        if (this.f213520m == false) goto L53;
        float r121 = r210.getY() - this.f213509b;
        boolean r122 = v();
        boolean r123 = w();
        if (r121 >= 0.0f) goto L44;
        if (v() == false) goto L44;
    L47:
        boolean r124 = true;
    L49:
        tt5.a.b("GridRecyclerView", "scrollLock:" + this.f213511d + ", dy:" + r121 + ", isAtBottom:" + r122 + ", isAtTop:" + r123 + ", allowParentIntercept:" + r124);
        if (r124 == false) goto L52;
        getParent().requestDisallowInterceptTouchEvent(false);
        goto L53
    L52:
        getParent().requestDisallowInterceptTouchEvent(true);
    L44:
        if (r121 > 0.0f) goto L46;
    L48:
        r124 = false;
        goto L49
    L46:
        if (w() == false) goto L48;
    L53:
        x(false);
        goto L90
    L15:
        if (r102 != 3) goto L90;
        x(false);
        goto L90
    L89:
        this.f213508a = r210.getX();
        this.f213509b = r210.getY();
        this.f213510c = r210.getX();
        r210.getY();
        this.f213511d = 0;
        goto L90
    L5:
        return super.onTouchEvent(r210);
    }

    public final void setHorizontalScrollListener(Function1<? super Boolean, Unit> r100) {
        this.f213523p = r100;
    }

    public final void setHorizontalScrolling(boolean r100) {
        this.f213524q = r100;
    }

    public final void setOpenHorizontalScroll(boolean r100) {
        this.f213519l = r100;
    }

    public final void setRowScrollManager(mt4.d r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f213522o = r100;
    }

    public final void setScrollInLinkTable(boolean r100) {
        this.f213514g = RangesKt.coerceAtMost(this.f213513f / 2, 5);
        this.f213520m = true;
        this.f213521n = r100;
    }

    public final void x(boolean r100) {
        OverScroller r101 = this.f213516i;
        if (r101 == null) goto L5;
        r101.abortAnimation();
    L5:
        if (r100 == true) goto L8;
        y(false);
        return;
    }

    public final void y(boolean r100) {
        if (this.f213524q != r100) goto L5;
        return;
    L5:
        this.f213524q = r100;
        Function1<? super Boolean, Unit> r101 = this.f213523p;
        if (r101 == null) goto L9;
        r101.invoke(Boolean.valueOf(r100));
        return;
    }

    public GridRecyclerView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f213511d = 0;
        this.f213512e = VelocityTracker.obtain();
        this.f213518k = f.f213539a;
        this.f213522o = new mt4.d();
        ViewConfiguration r102 = ViewConfiguration.get(getContext());
        int r103 = r102.getScaledTouchSlop();
        this.f213513f = r103;
        this.f213514g = r103;
        this.f213515h = r102.getScaledMaximumFlingVelocity();
        addOnScrollListener(new AnonymousClass1(this));
    }

    public static final /* synthetic */ void r(GridRecyclerView r100, Canvas r101) {
        super.dispatchDraw(r101);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public final void onMeasure(int r100, int r101) {
        int r102 = ht4.b.f487130a;
        e r103 = new e(this, r100, r101);
        Intrinsics.checkNotNullParameter(r103, "runnable");
        r103.run();
    }

    public static final /* synthetic */ void u(GridRecyclerView r100, int r101, int r102) {
        super.onMeasure(r101, r102);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        mt4.e r104 = this.f213522o.f515638b;
        int r105 = getMeasuredWidth();
        r104.f515641c = r104.f515640b - r105;
        mt4.d r106 = this.f213522o;
        Iterator<mt4.b> r107 = r106.f515637a.iterator();
    L4:
        if (r107.hasNext() == false) goto L6;
        r107.next().a(r106.f515638b.f515641c);
        goto L4
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r110, int r111, int r112, int r113) {
        int r101 = ht4.b.f487130a;
        d r102 = new d(this, r100, r110, r111, r112, r113);
        Intrinsics.checkNotNullParameter(r102, "runnable");
        r102.run();
    }

    public static final /* synthetic */ void t(GridRecyclerView r100, boolean r101, int r102, int r103, int r104, int r105) {
        super.onLayout(r101, r102, r103, r104, r105);
    }
}
