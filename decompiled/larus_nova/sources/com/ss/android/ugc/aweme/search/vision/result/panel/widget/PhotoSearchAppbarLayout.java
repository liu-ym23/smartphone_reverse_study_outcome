package com.ss.android.ugc.aweme.search.vision.result.panel.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.NestedScrollingChild2;
import androidx.core.view.NestedScrollingChildHelper;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.google.android.material.appbar.AppBarLayout;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0003 !\"B\u001d\b\u0007\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001c¢\u0006\u0004\b\u001e\u0010\u001fJ\u0014\u0010\u0007\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003J\u000e\u0010\t\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0004H\u0016J\u0010\u0010\u000e\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\fR\"\u0010\u0015\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0019\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0010\u001a\u0004\b\u0017\u0010\u0012\"\u0004\b\u0018\u0010\u0014¨\u0006#"}, d2 = {"Lcom/ss/android/ugc/aweme/search/vision/result/panel/widget/PhotoSearchAppbarLayout;", "Lcom/google/android/material/appbar/AppBarLayout;", "Landroidx/core/view/NestedScrollingChild2;", "Lkotlin/Function0;", "", "needInterceptScroll", "", "setNeedInterceptScroll", "canDrag", "setCanDrag", "enabled", "setNestedScrollingEnabled", "Landroid/view/View;", "pinView", "setPinView", "e", "Z", "getStopTouchEventWhenDown", "()Z", "setStopTouchEventWhenDown", "(Z)V", "stopTouchEventWhenDown", "f", "getCanConsumeNestedScroll", "setCanConsumeNestedScroll", "canConsumeNestedScroll", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", SlcElement.KEY_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Behavior", "Companion", "ProxyNestedScroller", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PhotoSearchAppbarLayout extends AppBarLayout implements NestedScrollingChild2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final NestedScrollingChildHelper f453726a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ProxyNestedScroller f453727b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Function0<Boolean> f453728c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f453729d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f453730e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f453731f;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007B\t\b\u0016¢\u0006\u0004\b\u0006\u0010\b¨\u0006\t"}, d2 = {"Lcom/ss/android/ugc/aweme/search/vision/result/panel/widget/PhotoSearchAppbarLayout$Behavior;", "Lcom/google/android/material/appbar/AppBarLayout$Behavior;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "()V", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Behavior extends AppBarLayout.Behavior {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f453732a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f453733b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f453734c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f453735d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public float f453736e;

        public Behavior() {
            this.f453733b = -1;
            setDragCallback(new PhotoSearchAppbarLayout$Behavior$mDragCallback$1());
        }

        public Behavior(Context r100, AttributeSet r101) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "attrs");
            super(r100, r101);
            this.f453733b = -1;
            setDragCallback(new PhotoSearchAppbarLayout$Behavior$mDragCallback$1());
        }

        @Override // com.google.android.material.appbar.HeaderBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public final boolean onInterceptTouchEvent(CoordinatorLayout r100, View r101, MotionEvent r102) {
            AppBarLayout r103 = (AppBarLayout) r101;
            Intrinsics.checkNotNullParameter(r100, "parent");
            Intrinsics.checkNotNullParameter(r103, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
            Intrinsics.checkNotNullParameter(r102, "ev");
            if (r102.getActionMasked() != 0) goto L15;
            if ((r103 instanceof PhotoSearchAppbarLayout) == false) goto L15;
            boolean r104 = false;
            this.f453734c = false;
            this.f453735d = r102.getRawX();
            this.f453736e = r102.getRawY();
            PhotoSearchAppbarLayout r105 = (PhotoSearchAppbarLayout) r103;
            Function0<Boolean> r106 = r105.f453728c;
            if (r106 != null) goto L9;
        L11:
            this.f453732a = r104;
            this.f453733b = -1;
            if (r104 == false) goto L15;
            ProxyNestedScroller r107 = r105.f453727b;
            r107.getClass();
            r107.f453740d = r102.getRawX();
            r107.f453741e = r102.getRawY();
            r107.f453743g = -1;
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
            if ((r112 instanceof PhotoSearchAppbarLayout) == false) goto L43;
            Function0<Boolean> r101 = new PhotoSearchAppbarLayout$Behavior$onTouchEvent$superTouchEvent$1(this, r112, r100, r111);
            if (this.f453733b != (-1)) goto L19;
            float r102 = Math.abs(r111.getRawX() - this.f453735d);
            float r103 = Math.abs(r111.getRawY() - this.f453736e);
            float r104 = (r102 * r102) + (r103 * r103);
            PhotoSearchAppbarLayout r105 = (PhotoSearchAppbarLayout) r112;
            int r106 = ViewConfiguration.get(r105.getContext()).getScaledTouchSlop();
            if (r104 <= (r106 * r106)) goto L14;
            if (r103 <= r102) goto L11;
            int r107 = 1;
        L12:
            this.f453733b = r107;
            goto L14
        L11:
            r107 = 0;
        L14:
            if (this.f453733b != 0) goto L19;
            if (this.f453732a == false) goto L19;
            r105.f453727b.f453744h.stopNestedScroll(0);
        L19:
            if (this.f453732a == true) goto L37;
            if (this.f453733b == 0) goto L37;
            PhotoSearchAppbarLayout r108 = (PhotoSearchAppbarLayout) r112;
            boolean r109 = r108.a();
            boolean r113 = this.f453734c;
            this.f453734c = r109;
            if (r113 == r109) goto L34;
            if (r109 == false) goto L34;
            ProxyNestedScroller r114 = r108.f453727b;
            float r115 = 0.0f;
            if (r111 == null) goto L28;
            r114.getClass();
            float r116 = r111.getRawX();
        L29:
            r114.f453740d = r116;
            if (r111 == null) goto L32;
            r115 = r111.getRawY();
        L32:
            r114.f453741e = r115;
            r114.f453743g = -1;
            goto L34
        L28:
            r116 = 0.0f;
        L34:
            if (this.f453734c == false) goto L37;
            this.f453732a = r108.b(r111, PhotoSearchAppbarLayout$Behavior$onTouchEvent$1.INSTANCE);
        L37:
            if (this.f453732a == false) goto L45;
            if (this.f453733b != 1) goto L45;
            return ((PhotoSearchAppbarLayout) r112).b(r111, PhotoSearchAppbarLayout$Behavior$onTouchEvent$2.INSTANCE);
        L45:
            return r101.invoke().booleanValue();
        L43:
            return super.onTouchEvent(r100, r112, r111);
        }

        public static final /* synthetic */ boolean a(Behavior r100, CoordinatorLayout r101, AppBarLayout r102, MotionEvent r103) {
            return super.onTouchEvent(r101, r102, r103);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.Behavior, com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public final void onNestedPreScroll(CoordinatorLayout r100, AppBarLayout r101, View r102, int r103, int r104, int[] r105, int r106) {
            Intrinsics.checkNotNullParameter(r100, "coordinatorLayout");
            Intrinsics.checkNotNullParameter(r101, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
            Intrinsics.checkNotNullParameter(r102, PickerReporterConstants.KEY.TARGET);
            Intrinsics.checkNotNullParameter(r105, "consumed");
            if ((r101 instanceof PhotoSearchAppbarLayout) == false) goto L8;
            if (r104 < 0) goto L6;
        L7:
            super.onNestedPreScroll(r100, r101, r102, r103, r104, r105, r106);
            return;
        L6:
            if (((PhotoSearchAppbarLayout) r101).getCanConsumeNestedScroll() == true) goto L7;
            return;
        L8:
            super.onNestedPreScroll(r100, r101, r102, r103, r104, r105, r106);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public final /* bridge */ /* synthetic */ void onNestedPreScroll(CoordinatorLayout r100, View r101, View r102, int r103, int r104, int[] r105, int r106) {
            onNestedPreScroll(r100, (AppBarLayout) r101, r102, r103, r104, r105, r106);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/ss/android/ugc/aweme/search/vision/result/panel/widget/PhotoSearchAppbarLayout$Companion;", "", "()V", "NESTED_SCROLL_INIT", "", "NESTED_SCROLL_NO", "NESTED_SCROLL_OK", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(int r100) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/ss/android/ugc/aweme/search/vision/result/panel/widget/PhotoSearchAppbarLayout$ProxyNestedScroller;", "", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public final class ProxyNestedScroller {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public VelocityTracker f453737a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f453738b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f453739c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f453740d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public float f453741e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final float f453742f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f453743g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ PhotoSearchAppbarLayout f453744h;

        public final VelocityTracker a() {
            VelocityTracker r100 = this.f453737a;
            if (r100 != null) goto L6;
            VelocityTracker r101 = VelocityTracker.obtain();
            this.f453737a = r101;
            return r101;
        L6:
            return r100;
        }

        public ProxyNestedScroller(PhotoSearchAppbarLayout r100) {
            this.f453744h = r100;
            this.f453743g = -1;
            ViewConfiguration r101 = ViewConfiguration.get(r100.getContext());
            r101.getScaledMinimumFlingVelocity();
            this.f453742f = r101.getScaledMaximumFlingVelocity();
        }
    }

    static {
        new Companion(0);
    }

    public final boolean a() {
        if (getTotalScrollRange() == 0) goto L15;
        if (Math.abs(getY() / getTotalScrollRange()) == 0.0f) goto L16;
        return false;
    L16:
        return true;
    L15:
        return true;
    L17:
        return true;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean isNestedScrollingEnabled() {
        return this.f453726a.isNestedScrollingEnabled();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ProxyNestedScroller r100 = this.f453727b;
        VelocityTracker r101 = r100.f453737a;
        if (r101 == null) goto L5;
        r101.recycle();
    L5:
        r100.f453737a = null;
    }

    public final boolean getCanConsumeNestedScroll() {
        return this.f453731f;
    }

    public final boolean getStopTouchEventWhenDown() {
        return this.f453730e;
    }

    public PhotoSearchAppbarLayout(Context r100) {
        this(r100, null);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public final boolean hasNestedScrollingParent(int r100) {
        return this.f453726a.hasNestedScrollingParent();
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        if (r100 == null) goto L9;
        if (r100.getActionMasked() != 0) goto L9;
        if (this.f453730e == false) goto L9;
        this.f453727b.f453744h.stopNestedScroll(0);
    L9:
        return super.onInterceptTouchEvent(r100);
    }

    public final void setCanConsumeNestedScroll(boolean r100) {
        this.f453731f = r100;
    }

    public final void setCanDrag(boolean r100) {
        this.f453729d = r100;
    }

    public final void setNeedInterceptScroll(Function0<Boolean> r100) {
        Intrinsics.checkNotNullParameter(r100, "needInterceptScroll");
        this.f453728c = r100;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean r100) {
        this.f453726a.setNestedScrollingEnabled(r100);
    }

    public final void setPinView(final View r100) {
        addOnOffsetChangedListener(new AnonymousClass1(r100));
    }

    public final void setStopTouchEventWhenDown(boolean r100) {
        this.f453730e = r100;
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public final void stopNestedScroll(int r100) {
        this.f453726a.stopNestedScroll(r100);
    }

    public PhotoSearchAppbarLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f453726a = new NestedScrollingChildHelper(this);
        this.f453727b = new ProxyNestedScroller(this);
        this.f453729d = true;
        setNestedScrollingEnabled(true);
        this.f453731f = true;
    }

    public final boolean b(MotionEvent r110, Function2<? super Float, ? super Float, Boolean> r111) {
        Intrinsics.checkNotNullParameter(r111, "startNestedScroll");
        ProxyNestedScroller r100 = this.f453727b;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r111, "startNestedScroll");
        if (r110 == null) goto L57;
        int r101 = r100.f453743g;
        if (r101 != (-1)) goto L18;
        float r102 = r110.getRawX() - r100.f453740d;
        float r103 = r110.getRawY() - r100.f453741e;
        float r104 = (r102 * r102) + (r103 * r103);
        int r105 = ViewConfiguration.get(r100.f453744h.getContext()).getScaledTouchSlop();
        int r106 = r105 * r105;
        if (r100.f453743g != (-1)) goto L13;
        if (r104 <= r106) goto L13;
        r100.f453743g = r111.invoke(Float.valueOf(r102), Float.valueOf(r103)).booleanValue() ? 1 : 0;
    L13:
        if (r100.f453743g != 1) goto L52;
        VelocityTracker r112 = r100.f453737a;
        if (r112 == null) goto L17;
        r112.recycle();
    L17:
        r100.f453737a = null;
        r100.f453744h.startNestedScroll(2, 0);
    L52:
        r100.f453738b = r110.getRawX();
        r100.f453739c = r110.getRawY();
        if (r100.f453743g != 1) goto L56;
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
        int r115 = (int) (r100.f453738b - r110.getRawX());
        int r107 = (int) (r100.f453739c - r110.getRawY());
        int[] r108 = new int[2];
        if (r100.f453744h.dispatchNestedPreScroll(r115, r107, r108, null, 0) == false) goto L31;
        r115 = r115 - r108[0];
        r107 = r107 - r108[1];
    L31:
        r100.f453744h.dispatchNestedScroll(0, 0, r115, r107, null, 0);
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
        r117.computeCurrentVelocity(1000, r100.f453742f);
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
        if (r100.f453744h.dispatchNestedPreFling(r119, r109) == true) goto L48;
        r100.f453744h.dispatchNestedFling(r119, r109, false);
    L48:
        VelocityTracker r121 = r100.a();
        if (r121 == null) goto L51;
        r121.clear();
    L51:
        r100.f453744h.stopNestedScroll(0);
        goto L52
    L41:
        r119 = 0.0f;
        goto L42
    L57:
        return false;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean dispatchNestedPreFling(float r100, float r101) {
        return this.f453726a.dispatchNestedPreFling(r100, r101);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public final boolean startNestedScroll(int r100, int r101) {
        return this.f453726a.startNestedScroll(r100, r101);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean dispatchNestedFling(float r100, float r101, boolean r102) {
        return this.f453726a.dispatchNestedFling(r100, r101, r102);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public final boolean dispatchNestedPreScroll(int r100, int r101, int[] r102, int[] r110, int r111) {
        return this.f453726a.dispatchNestedPreScroll(r100, r101, r102, r110, r111);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public final boolean dispatchNestedScroll(int r100, int r101, int r110, int r111, int[] r112, int r113) {
        return this.f453726a.dispatchNestedScroll(r100, r101, r110, r111, r112, r113);
    }
}
