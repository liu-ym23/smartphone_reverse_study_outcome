package com.larus.home.impl.main.side_bar.layout.drawer_impl;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import androidx.core.view.GravityCompat;
import androidx.customview.widget.ViewDragHelper;
import androidx.drawerlayout.widget.DrawerLayout;
import com.larus.bmhome.c0;
import com.larus.business.debug.api.IDebugService;
import com.larus.nova.R;
import com.larus.utils.i;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0015\u0018\u0000 ;2\u00020\u00012\u00020\u00022\u00020\u0003:\u0002;<B'\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010$\u001a\u00020\u00132\u0006\u0010%\u001a\u00020&H\u0016J\b\u0010'\u001a\u00020(H\u0014J\b\u0010)\u001a\u00020\u0013H\u0016J\u0010\u0010*\u001a\u00020(2\u0006\u0010+\u001a\u00020\u0013H\u0016J\u0010\u0010,\u001a\u00020(2\u0006\u0010+\u001a\u00020\u0013H\u0016J\u0010\u0010-\u001a\u00020(2\u0006\u0010.\u001a\u00020\u0013H\u0016J\b\u0010/\u001a\u00020\u0013H\u0016J\u0012\u00100\u001a\u00020(2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u00101\u001a\u00020(H\u0016J\u0010\u00102\u001a\u00020(2\u0006\u00103\u001a\u00020\u0019H\u0016J\b\u00104\u001a\u00020(H\u0016J\b\u00105\u001a\u00020(H\u0016J\b\u00106\u001a\u00020(H\u0002J\u0010\u00107\u001a\u00020\u00132\u0006\u00108\u001a\u00020&H\u0002J\u0010\u00109\u001a\u00020\u00132\u0006\u00108\u001a\u00020&H\u0002J\u0010\u0010:\u001a\u00020\u00132\u0006\u00103\u001a\u00020\u0019H\u0002R\u000e\u0010\f\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R#\u0010\u001d\u001a\n \u001f*\u0004\u0018\u00010\u001e0\u001e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b \u0010!¨\u0006="}, d2 = {"Lcom/larus/home/impl/main/side_bar/layout/drawer_impl/DrawerSideBarLayout;", "Landroidx/drawerlayout/widget/DrawerLayout;", "Lcom/larus/home/impl/main/side_bar/layout/ISideBarLayout;", "Lcom/larus/home/impl/main/side_bar/layout/IPredictiveOpenLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "touchSlop", "draggableContainer", "Lcom/larus/home/impl/main/side_bar/layout/drawer_impl/FullDraggableContainer;", "pageContainer", "Landroid/view/ViewGroup;", "sideBarContainer", "mEnable", "", "listener", "Lcom/larus/bmhome/ISideBarLayoutListener;", "isDragging", "isRTL", "initialTouchX", "", "initialTouchY", "isSideBarContentTouch", "isPredictiveOpening", "moveDrawerToOffsetMethod", "Ljava/lang/reflect/Method;", "kotlin.jvm.PlatformType", "getMoveDrawerToOffsetMethod", "()Ljava/lang/reflect/Method;", "moveDrawerToOffsetMethod$delegate", "Lkotlin/Lazy;", "onInterceptTouchEvent", "ev", "Landroid/view/MotionEvent;", "onFinishInflate", "", "isSideBarOpen", "closeSideBar", "animate", "openSideBar", "enableSideBar", "enable", "isSideBarEnable", "setSideBarLayoutListener", "startPredictiveOpen", "updatePredictiveOpenProgress", "progress", "cancelPredictiveOpen", "finishPredictiveOpen", "setupDurationScroller", "isTouchInsideSideBarContent", "event", "isCloseDrawerDragEvent", "movePredictiveDrawerTo", "Companion", "DurationOverScroller", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DrawerSideBarLayout extends DrawerLayout implements vb9.b, vb9.a {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ int f344723n = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f344724a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public FullDraggableContainer f344725b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ViewGroup f344726c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ViewGroup f344727d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f344728e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public c0 f344729f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f344730g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f344731h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f344732i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f344733j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f344734k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f344735l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f344736m;

    public static final class a {
    }

    public final class b extends OverScroller {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f344737a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ DrawerSideBarLayout f344738b;

        public b(DrawerSideBarLayout r100, Context r101, int r102, Interpolator r103) {
            Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
            this.f344738b = r100;
            super(r101, r103);
            this.f344737a = r102;
        }

        @Override // android.widget.OverScroller
        public final void startScroll(int r100, int r101, int r110, int r111) {
            if ((!this.f344738b.f344730g) == false) goto L5;
            super.startScroll(r100, r101, r110, r111, this.f344737a);
            return;
        L5:
            super.startScroll(r100, r101, r110, r111);
        }

        @Override // android.widget.OverScroller
        public final void startScroll(int r100, int r101, int r110, int r111, int r112) {
            if ((!this.f344738b.f344730g) == false) goto L5;
            super.startScroll(r100, r101, r110, r111, this.f344737a);
            return;
        L5:
            super.startScroll(r100, r101, r110, r111, r112);
        }
    }

    static {
    }

    public DrawerSideBarLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public DrawerSideBarLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    private final Method getMoveDrawerToOffsetMethod() {
        return (Method) this.f344736m.getValue();
    }

    @Override // vb9.a
    public final void b() {
        if (this.f344735l == true) goto L5;
        return;
    L5:
        openDrawer(GravityCompat.START, false);
        this.f344735l = false;
        this.f344730g = false;
        c0 r100 = this.f344729f;
        if (r100 == null) goto L9;
        r100.H0(0);
        return;
    }

    @Override // vb9.a
    public final void d() {
        if (this.f344735l == true) goto L6;
        return;
    L6:
        if (f(0.0f) == true) goto L8;
        closeDrawer(GravityCompat.START, false);
    L8:
        this.f344735l = false;
        this.f344730g = false;
        c0 r100 = this.f344729f;
        if (r100 == null) goto L12;
        r100.H0(0);
        return;
    }

    @Override // vb9.b
    public final boolean Ga() {
        return isDrawerOpen(GravityCompat.START);
    }

    @Override // vb9.a
    public final void c() {
        if (isDrawerOpen(GravityCompat.START) == false) goto L5;
        return;
    L5:
        this.f344735l = true;
        this.f344730g = true;
        f(0.0f);
        c0 r100 = this.f344729f;
        if (r100 == null) goto L9;
        r100.H0(1);
        return;
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        this.f344725b = (FullDraggableContainer) findViewById(R.id.draggable_container);
        this.f344726c = (ViewGroup) findViewById(R.id.page_container);
        this.f344727d = (ViewGroup) findViewById(R.id.side_bar_container);
        addDrawerListener(new AnonymousClass1(this));
        FullDraggableContainer r100 = this.f344725b;
        if (r100 == null) goto L5;
        r100.setCallback(new wb9.a(this));
    L5:
        IDebugService r101 = (IDebugService) ServiceManager.get().getService(IDebugService.class);
        if (r101 == null) goto L8;
        int r102 = r101.m();
    L9:
        if (r102 <= 0) goto L42;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L27
        Field r104 = ViewDragHelper.class.getDeclaredField("sInterpolator");     // Catch: Throwable -> L27
        r104.setAccessible(true);     // Catch: Throwable -> L27
        Object r105 = r104.get(null);     // Catch: Throwable -> L27
        if ((r105 instanceof Interpolator) == false) goto L14;
        Interpolator r106 = (Interpolator) r105;     // Catch: Throwable -> L27
    L15:
        Field r107 = ViewDragHelper.class.getDeclaredField("mScroller");     // Catch: Throwable -> L27
        r107.setAccessible(true);     // Catch: Throwable -> L27
        Iterator r108 = CollectionsKt.listOf(new String[]{"mLeftDragger", "mRightDragger"}).iterator();     // Catch: Throwable -> L27
    L17:
        if (r108.hasNext() == false) goto L25;
        Field r109 = DrawerLayout.class.getDeclaredField((String) r108.next());     // Catch: Throwable -> L27
        r109.setAccessible(true);     // Catch: Throwable -> L27
        Object r110 = r109.get(this);     // Catch: Throwable -> L27
        if ((r110 instanceof ViewDragHelper) == false) goto L21;
        ViewDragHelper r111 = (ViewDragHelper) r110;     // Catch: Throwable -> L27
    L22:
        if (r111 == null) goto L17;
        r107.set(r111, new b(this, getContext(), r102, r106));     // Catch: Throwable -> L27
        goto L17
    L21:
        r111 = null;
        goto L22
    L25:
        Object r112 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L27
    L29:
        Throwable r113 = Result.m9452exceptionOrNullimpl(r112);
        if (r113 == null) goto L41;
        FLogger.f375446a.e("DrawerSideBarLayout", "setupDurationScroller failed: " + r113);
        return;
    L41:
        return;
    L14:
        r106 = null;
    L27:
        th = move-exception;
        Result.Companion r114 = Result.Companion;
        r112 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L29
    L42:
        return;
    L8:
        r102 = 0;
        goto L9
    }

    @Override // vb9.b
    public final boolean a() {
        return this.f344728e;
    }

    @Override // vb9.a
    public final void e(float r100) {
        if (this.f344735l == true) goto L5;
        return;
    L5:
        f(r100);
    }

    public final boolean f(float r100) {
        ViewGroup r101 = this.f344727d;
        if (r101 != null) goto L5;
        return false;
    L5:
        float r102 = RangesKt.coerceIn(r100, 0.0f, 1.0f);
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L12
        if (r102 <= 0.0f) goto L9;
        int r104 = 0;
    L10:
        r101.setVisibility(r104);     // Catch: Throwable -> L12
        getMoveDrawerToOffsetMethod().invoke(this, new Object[]{r101, Float.valueOf(r102)});     // Catch: Throwable -> L12
        invalidate();     // Catch: Throwable -> L12
        Object r105 = Result.m9449constructorimpl(Boolean.TRUE);     // Catch: Throwable -> L12
    L14:
        Throwable r106 = Result.m9452exceptionOrNullimpl(r105);
        if (r106 == null) goto L19;
        FLogger.f375446a.e("DrawerSideBarLayout", "movePredictiveDrawerTo failed: " + r106);
        r105 = Boolean.FALSE;
    L19:
        return ((Boolean) r105).booleanValue();
    L9:
        r104 = 4;
    L12:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L14
    }

    public final void g(boolean r100) {
        openDrawer(GravityCompat.START, r100);
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        int r101 = r100.getActionMasked();
        boolean r102 = true;
        if (r101 == 0) goto L30;
        if (r101 != 1) goto L6;
    L29:
        this.f344734k = false;
    L49:
        return super.onInterceptTouchEvent(r100);
    L6:
        if (r101 == 2) goto L11;
        if (r101 == 3) goto L29;
    L11:
        if (this.f344734k == false) goto L49;
        float r103 = r100.getX() - this.f344732i;
        float r104 = r100.getY() - this.f344733j;
        float r105 = Math.abs(r103);
        if (r105 > this.f344724a) goto L16;
    L26:
        r102 = false;
    L27:
        if (r102 == true) goto L49;
        return false;
    L16:
        if ((r105 * 0.364f) <= Math.abs(r104)) goto L26;
        if (this.f344731h == false) goto L24;
        if (r103 <= 0.0f) goto L26;
    L24:
        if (r103 >= 0.0f) goto L26;
    L30:
        this.f344732i = r100.getX();
        this.f344733j = r100.getY();
        if (isDrawerOpen(GravityCompat.START) == false) goto L46;
        ViewGroup r106 = this.f344727d;
        if (r106 == null) goto L43;
        int r107 = (((int) r100.getX()) + getScrollX()) - r106.getLeft();
        int r108 = (((int) r100.getY()) + getScrollY()) - r106.getTop();
        if (r107 < 0) goto L43;
        if (r107 >= r106.getWidth()) goto L43;
        if (r108 < 0) goto L43;
        if (r108 >= r106.getHeight()) goto L43;
        boolean r109 = true;
    L44:
        if (r109 == false) goto L46;
    L47:
        this.f344734k = r102;
    L43:
        r109 = false;
    L46:
        r102 = false;
        goto L47
    }

    @Override // vb9.b
    public void setSideBarLayoutListener(c0 r100) {
        this.f344729f = r100;
    }

    @Override // vb9.b
    public final void v7(boolean r100) {
        closeDrawer(GravityCompat.START, r100);
    }

    public DrawerSideBarLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f344724a = ViewConfiguration.get(r100).getScaledTouchSlop();
        this.f344728e = true;
        this.f344731h = i.h(r100);
        this.f344736m = LazyKt.lazy(new wb9.b());
        setScrimColor(r100.getResources().getColor(R.color.larus_color_side_bar_scrim));
    }

    public /* synthetic */ DrawerSideBarLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
