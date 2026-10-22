package com.ss.android.ugc.aweme.discover.commodity.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.NestedScrollingChild2;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.NestedScrollingParentHelper;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.google.android.material.appbar.AppBarLayout;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0003\u0010\u0011\u0012B\u001d\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0014\u0010\u0007\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004H\u0016¨\u0006\u0013"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/commodity/view/NestedAppbarLayout;", "Lcom/google/android/material/appbar/AppBarLayout;", "Landroidx/core/view/NestedScrollingChild2;", "Lkotlin/Function0;", "", "needInterceptScroll", "", "setNeedInterceptScroll", "enabled", "setNestedScrollingEnabled", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", SlcElement.KEY_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Behavior", "Companion", "ProxyNestedScroller", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class NestedAppbarLayout extends AppBarLayout implements NestedScrollingChild2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final NestedScrollingChildHelper f450407a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ProxyNestedScroller f450408b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Function0<Boolean> f450409c;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007B\t\b\u0016¢\u0006\u0004\b\u0006\u0010\b¨\u0006\t"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/commodity/view/NestedAppbarLayout$Behavior;", "Lcom/google/android/material/appbar/AppBarLayout$Behavior;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "()V", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Behavior extends AppBarLayout.Behavior {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f450410a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f450411b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f450412c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f450413d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public float f450414e;

        public Behavior() {
            this.f450411b = -1;
            setDragCallback(new NestedAppbarLayout$Behavior$mDragCallback$1());
        }

        public Behavior(Context r100, AttributeSet r101) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "attrs");
            super(r100, r101);
            this.f450411b = -1;
            setDragCallback(new NestedAppbarLayout$Behavior$mDragCallback$1());
        }

        @Override // com.google.android.material.appbar.HeaderBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public final boolean onInterceptTouchEvent(CoordinatorLayout r100, View r101, MotionEvent r102) {
            AppBarLayout r103 = (AppBarLayout) r101;
            Intrinsics.checkNotNullParameter(r100, "parent");
            Intrinsics.checkNotNullParameter(r103, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
            Intrinsics.checkNotNullParameter(r102, "ev");
            if (r102.getActionMasked() != 0) goto L15;
            if ((r103 instanceof NestedAppbarLayout) == false) goto L15;
            boolean r104 = false;
            this.f450412c = false;
            this.f450413d = r102.getRawX();
            this.f450414e = r102.getRawY();
            NestedAppbarLayout r105 = (NestedAppbarLayout) r103;
            Function0<Boolean> r106 = r105.f450409c;
            if (r106 != null) goto L9;
        L11:
            this.f450410a = r104;
            this.f450411b = -1;
            if (r104 == false) goto L15;
            ProxyNestedScroller r107 = r105.f450408b;
            r107.getClass();
            r107.f450418d = r102.getRawX();
            r107.f450419e = r102.getRawY();
            r107.f450421g = -1;
            goto L15
        L9:
            if (r106.invoke().booleanValue() != true) goto L11;
            r104 = true;
        L15:
            return super.onInterceptTouchEvent(r100, r103, r102);
        }

        @Override // com.google.android.material.appbar.HeaderBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public final boolean onTouchEvent(final CoordinatorLayout r100, View r110, final MotionEvent r111) {
            final AppBarLayout r112 = (AppBarLayout) r110;
            Intrinsics.checkNotNullParameter(r100, "parent");
            Intrinsics.checkNotNullParameter(r112, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
            Intrinsics.checkNotNullParameter(r111, "ev");
            if ((r112 instanceof NestedAppbarLayout) == false) goto L53;
            Function0<Boolean> r101 = new NestedAppbarLayout$Behavior$onTouchEvent$superTouchEvent$1(this, r112, r100, r111);
            boolean r102 = false;
            if (this.f450411b != (-1)) goto L19;
            float r103 = Math.abs(r111.getRawX() - this.f450413d);
            float r104 = Math.abs(r111.getRawY() - this.f450414e);
            float r105 = (r103 * r103) + (r104 * r104);
            NestedAppbarLayout r106 = (NestedAppbarLayout) r112;
            int r107 = ViewConfiguration.get(r106.getContext()).getScaledTouchSlop();
            if (r105 <= (r107 * r107)) goto L14;
            if (r104 <= r103) goto L11;
            int r108 = 1;
        L12:
            this.f450411b = r108;
            goto L14
        L11:
            r108 = 0;
        L14:
            if (this.f450411b != 0) goto L19;
            if (this.f450410a == false) goto L19;
            r106.f450408b.f450422h.stopNestedScroll(0);
        L19:
            if (this.f450410a == true) goto L47;
            if (this.f450411b == 0) goto L47;
            NestedAppbarLayout r109 = (NestedAppbarLayout) r112;
            r109.getClass();
            float r113 = 0.0f;
            if (r109.getTotalScrollRange() == 0) goto L31;
            if (Math.abs(r109.getY() / r109.getTotalScrollRange()) == 0.0f) goto L31;
        L32:
            boolean r114 = this.f450412c;
            this.f450412c = r102;
            if (r114 == r102) goto L44;
            if (r102 == false) goto L44;
            ProxyNestedScroller r115 = r109.f450408b;
            if (r111 == null) goto L38;
            r115.getClass();
            float r116 = r111.getRawX();
        L39:
            r115.f450418d = r116;
            if (r111 == null) goto L42;
            r113 = r111.getRawY();
        L42:
            r115.f450419e = r113;
            r115.f450421g = -1;
            goto L44
        L38:
            r116 = 0.0f;
        L44:
            if (this.f450412c == false) goto L47;
            this.f450410a = r109.a(r111, NestedAppbarLayout$Behavior$onTouchEvent$1.INSTANCE);
        L31:
            r102 = true;
        L47:
            if (this.f450410a == false) goto L57;
            if (this.f450411b != 1) goto L57;
            return ((NestedAppbarLayout) r112).a(r111, NestedAppbarLayout$Behavior$onTouchEvent$2.INSTANCE);
        L57:
            return r101.invoke().booleanValue();
        L53:
            return super.onTouchEvent(r100, r112, r111);
        }

        public static final /* synthetic */ boolean a(Behavior r100, CoordinatorLayout r101, AppBarLayout r102, MotionEvent r103) {
            return super.onTouchEvent(r101, r102, r103);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/commodity/view/NestedAppbarLayout$Companion;", "", "()V", "NESTED_SCROLL_INIT", "", "NESTED_SCROLL_NO", "NESTED_SCROLL_OK", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(int r100) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/commodity/view/NestedAppbarLayout$ProxyNestedScroller;", "", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public final class ProxyNestedScroller {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public VelocityTracker f450415a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f450416b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f450417c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f450418d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public float f450419e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final float f450420f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f450421g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ NestedAppbarLayout f450422h;

        public final VelocityTracker a() {
            VelocityTracker r100 = this.f450415a;
            if (r100 != null) goto L6;
            VelocityTracker r101 = VelocityTracker.obtain();
            this.f450415a = r101;
            return r101;
        L6:
            return r100;
        }

        public ProxyNestedScroller(NestedAppbarLayout r100) {
            this.f450422h = r100;
            this.f450421g = -1;
            ViewConfiguration r101 = ViewConfiguration.get(r100.getContext());
            r101.getScaledMinimumFlingVelocity();
            this.f450420f = r101.getScaledMaximumFlingVelocity();
        }
    }

    static {
        new Companion(0);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean isNestedScrollingEnabled() {
        return this.f450407a.isNestedScrollingEnabled();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ProxyNestedScroller r100 = this.f450408b;
        VelocityTracker r101 = r100.f450415a;
        if (r101 == null) goto L5;
        r101.recycle();
    L5:
        r100.f450415a = null;
    }

    public NestedAppbarLayout(Context r100) {
        this(r100, null);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public final boolean hasNestedScrollingParent(int r100) {
        return this.f450407a.hasNestedScrollingParent();
    }

    public final void setNeedInterceptScroll(Function0<Boolean> r100) {
        Intrinsics.checkNotNullParameter(r100, "needInterceptScroll");
        this.f450409c = r100;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean r100) {
        this.f450407a.setNestedScrollingEnabled(r100);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public final void stopNestedScroll(int r100) {
        this.f450407a.stopNestedScroll(r100);
    }

    public NestedAppbarLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f450407a = new NestedScrollingChildHelper(this);
        new NestedScrollingParentHelper(this);
        this.f450408b = new ProxyNestedScroller(this);
        setNestedScrollingEnabled(true);
    }

    public final boolean a(MotionEvent r110, Function2<? super Float, ? super Float, Boolean> r111) {
        Intrinsics.checkNotNullParameter(r111, "startNestedScroll");
        ProxyNestedScroller r100 = this.f450408b;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r111, "startNestedScroll");
        if (r110 == null) goto L57;
        int r101 = r100.f450421g;
        if (r101 != (-1)) goto L18;
        float r102 = r110.getRawX() - r100.f450418d;
        float r103 = r110.getRawY() - r100.f450419e;
        float r104 = (r102 * r102) + (r103 * r103);
        int r105 = ViewConfiguration.get(r100.f450422h.getContext()).getScaledTouchSlop();
        int r106 = r105 * r105;
        if (r100.f450421g != (-1)) goto L13;
        if (r104 <= r106) goto L13;
        r100.f450421g = r111.invoke(Float.valueOf(r102), Float.valueOf(r103)).booleanValue() ? 1 : 0;
    L13:
        if (r100.f450421g != 1) goto L52;
        VelocityTracker r112 = r100.f450415a;
        if (r112 == null) goto L17;
        r112.recycle();
    L17:
        r100.f450415a = null;
        r100.f450422h.startNestedScroll(2, 0);
    L52:
        r100.f450416b = r110.getRawX();
        r100.f450417c = r110.getRawY();
        if (r100.f450421g != 1) goto L56;
        return true;
    L56:
        return false;
    L18:
        if (r101 != 1) goto L52;
        VelocityTracker r113 = r100.a();
        if (r113 == null) goto L22;
        r113.addMovement(r110);
    L22:
        int r114 = r110.getActionMasked();
        if (r114 == 1) goto L32;
        if (r114 != 2) goto L26;
        int r115 = (int) (r100.f450416b - r110.getRawX());
        int r107 = (int) (r100.f450417c - r110.getRawY());
        int[] r108 = new int[2];
        if (r100.f450422h.dispatchNestedPreScroll(r115, r107, r108, null, 0) == false) goto L31;
        r115 = r115 - r108[0];
        r107 = r107 - r108[1];
    L31:
        r100.f450422h.dispatchNestedScroll(0, 0, r115, r107, null, 0);
        goto L52
    L26:
        if (r114 != 3) goto L52;
    L32:
        VelocityTracker r116 = r100.a();
        if (r116 == null) goto L35;
        r116.addMovement(r110);
    L35:
        VelocityTracker r117 = r100.a();
        if (r117 == null) goto L38;
        r117.computeCurrentVelocity(1000, r100.f450420f);
    L38:
        VelocityTracker r118 = r100.a();
        float r109 = 0.0f;
        if (r118 == null) goto L41;
        float r119 = r118.getXVelocity();
    L42:
        VelocityTracker r120 = r100.a();
        if (r120 == null) goto L46;
        r109 = r120.getYVelocity();
    L46:
        if (r100.f450422h.dispatchNestedPreFling(r119, r109) == true) goto L48;
        r100.f450422h.dispatchNestedFling(r119, r109, false);
    L48:
        VelocityTracker r121 = r100.a();
        if (r121 == null) goto L51;
        r121.clear();
    L51:
        r100.f450422h.stopNestedScroll(0);
        goto L52
    L41:
        r119 = 0.0f;
        goto L42
    L57:
        return false;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean dispatchNestedPreFling(float r100, float r101) {
        return this.f450407a.dispatchNestedPreFling(r100, r101);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public final boolean startNestedScroll(int r100, int r101) {
        return this.f450407a.startNestedScroll(r100, r101);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean dispatchNestedFling(float r100, float r101, boolean r102) {
        return this.f450407a.dispatchNestedFling(r100, r101, r102);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public final boolean dispatchNestedPreScroll(int r100, int r101, int[] r102, int[] r110, int r111) {
        return this.f450407a.dispatchNestedPreScroll(r100, r101, r102, r110, r111);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public final boolean dispatchNestedScroll(int r100, int r101, int r110, int r111, int[] r112, int r113) {
        return this.f450407a.dispatchNestedScroll(r100, r101, r110, r111, r112, r113);
    }
}
