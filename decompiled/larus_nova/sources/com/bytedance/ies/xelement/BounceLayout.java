package com.bytedance.ies.xelement;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import androidx.core.view.NestedScrollingChild2;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.NestedScrollingParent2;
import androidx.core.view.NestedScrollingParentHelper;
import com.amap.api.col.s.ce;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.lynx.tasm.base.LLog;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0004\u0010\u001745B\u0011\b\u0016\u0012\u0006\u0010,\u001a\u00020+¢\u0006\u0004\b-\u0010.B\u001b\b\u0016\u0012\u0006\u0010,\u001a\u00020+\u0012\b\u00100\u001a\u0004\u0018\u00010/¢\u0006\u0004\b-\u00101B#\b\u0016\u0012\u0006\u0010,\u001a\u00020+\u0012\b\u00100\u001a\u0004\u0018\u00010/\u0012\u0006\u00102\u001a\u00020\u0004¢\u0006\u0004\b-\u00103J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\f\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nJ\u0010\u0010\u000e\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\rR\"\u0010\u0016\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u001d\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR.\u0010&\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R.\u0010*\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010!\u001a\u0004\b(\u0010#\"\u0004\b)\u0010%¨\u00066"}, d2 = {"Lcom/bytedance/ies/xelement/BounceLayout;", "Landroid/widget/FrameLayout;", "Landroidx/core/view/NestedScrollingParent2;", "Landroidx/core/view/NestedScrollingChild2;", "", "getNestedScrollAxes", "", "enabled", "", "setNestedScrollingEnabled", "Lcom/bytedance/ies/xelement/BounceLayout$c;", "listener", "setOnScrollToEndListener", "Lcom/bytedance/ies/xelement/BounceLayout$b;", "setOnBounceScrollListener", "Lcom/bytedance/ies/xelement/BounceLayout$ScrollDirection;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lcom/bytedance/ies/xelement/BounceLayout$ScrollDirection;", "getMScrollDirection", "()Lcom/bytedance/ies/xelement/BounceLayout$ScrollDirection;", "setMScrollDirection", "(Lcom/bytedance/ies/xelement/BounceLayout$ScrollDirection;)V", "mScrollDirection", "b", "Z", "getMEnableBounce", "()Z", "setMEnableBounce", "(Z)V", "mEnableBounce", "Landroid/view/View;", "value", ce.f26395j, "Landroid/view/View;", "getMContentView", "()Landroid/view/View;", "setMContentView", "(Landroid/view/View;)V", "mContentView", ce.f26396k, "getMBounceView", "setMBounceView", "mBounceView", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "c", "ScrollDirection", "x-element-scroll_release"}, k = 1, mv = {1, 6, 0})
public final class BounceLayout extends FrameLayout implements NestedScrollingParent2, NestedScrollingChild2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ScrollDirection f249585a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f249586b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final NestedScrollingParentHelper f249587c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final NestedScrollingChildHelper f249588d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f249589e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f249590f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f249591g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f249592h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final OverScroller f249593i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public View f249594j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public View f249595k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public b f249596l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public c f249597m;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ies/xelement/BounceLayout$ScrollDirection;", "", "VERTICAL_TOP", "VERTICAL_BOTTOM", "HORIZONTAL_LEFT", "HORIZONTAL_RIGHT", "x-element-scroll_release"}, k = 1, mv = {1, 6, 0})
    public static final enum ScrollDirection extends Enum<ScrollDirection> {
        public static final ScrollDirection HORIZONTAL_LEFT = null;
        public static final ScrollDirection HORIZONTAL_RIGHT = null;
        public static final ScrollDirection VERTICAL_BOTTOM = null;
        public static final ScrollDirection VERTICAL_TOP = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ScrollDirection[] f249598a = null;

        public static ScrollDirection valueOf(String r100) {
            return (ScrollDirection) r27.a.a(ScrollDirection.class, r100);
        }

        public static ScrollDirection[] values() {
            return (ScrollDirection[]) f249598a.clone();
        }

        static {
            ScrollDirection r100 = new ScrollDirection("VERTICAL_TOP", 0);
            VERTICAL_TOP = r100;
            ScrollDirection r101 = new ScrollDirection("VERTICAL_BOTTOM", 1);
            VERTICAL_BOTTOM = r101;
            ScrollDirection r102 = new ScrollDirection("HORIZONTAL_LEFT", 2);
            HORIZONTAL_LEFT = r102;
            ScrollDirection r103 = new ScrollDirection("HORIZONTAL_RIGHT", 3);
            HORIZONTAL_RIGHT = r103;
            f249598a = new ScrollDirection[]{r100, r101, r102, r103};
        }

        public ScrollDirection(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
    }

    public interface b {
        void a(int r100, int r101, int r102, int r103);
    }

    public interface c {
        void a();
    }

    public /* synthetic */ class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f249599a = null;

        static {
            int[] r100 = new int[ScrollDirection.values().length];
            r100[ScrollDirection.VERTICAL_TOP.ordinal()] = 1;
            r100[ScrollDirection.VERTICAL_BOTTOM.ordinal()] = 2;
            r100[ScrollDirection.HORIZONTAL_LEFT.ordinal()] = 3;
            r100[ScrollDirection.HORIZONTAL_RIGHT.ordinal()] = 4;
            f249599a = r100;
        }
    }

    static {
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final boolean onNestedFling(View r100, float r101, float r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final boolean onNestedPreFling(View r100, float r101, float r102) {
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
        return false;
    }

    @Override // android.view.View
    public final int computeHorizontalScrollRange() {
        ScrollDirection r100 = this.f249585a;
        if (r100 != ScrollDirection.HORIZONTAL_RIGHT) goto L16;
        if (r100 != ScrollDirection.HORIZONTAL_LEFT) goto L16;
        int r101 = getChildCount();
        int r102 = 0;
        if (r101 < 0) goto L14;
        int r103 = 0;
    L10:
        r102 = r102 + getChildAt(r103).getWidth();
        if (r103 == r101) goto L14;
        r103 = r103 + 1;
    L14:
        return r102;
    L16:
        return super.computeHorizontalScrollRange();
    }

    @Override // android.view.View
    public final void computeScroll() {
        if (this.f249593i.computeScrollOffset() == false) goto L9;
        scrollTo(this.f249593i.getCurrX(), this.f249593i.getCurrY());
        b r100 = this.f249596l;
        if (r100 == null) goto L7;
        r100.a(this.f249593i.getCurrX(), this.f249593i.getCurrY(), this.f249591g, this.f249592h);
    L7:
        this.f249591g = this.f249593i.getCurrX();
        this.f249592h = this.f249593i.getCurrY();
        postInvalidate();
        return;
    }

    @Override // android.view.View
    public final int computeVerticalScrollRange() {
        ScrollDirection r100 = this.f249585a;
        if (r100 != ScrollDirection.VERTICAL_BOTTOM) goto L16;
        if (r100 != ScrollDirection.VERTICAL_TOP) goto L16;
        int r101 = getChildCount();
        int r102 = 0;
        if (r101 < 0) goto L14;
        int r103 = 0;
    L10:
        r102 = r102 + getChildAt(r103).getHeight();
        if (r103 == r101) goto L14;
        r103 = r103 + 1;
    L14:
        return r102;
    L16:
        return super.computeVerticalScrollRange();
    }

    @Override // android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        return this.f249587c.getNestedScrollAxes();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean isNestedScrollingEnabled() {
        return this.f249588d.isNestedScrollingEnabled();
    }

    public final View getMBounceView() {
        return this.f249595k;
    }

    public final View getMContentView() {
        return this.f249594j;
    }

    public final boolean getMEnableBounce() {
        return this.f249586b;
    }

    public final ScrollDirection getMScrollDirection() {
        return this.f249585a;
    }

    public BounceLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    @Override // android.view.View
    public final boolean canScrollHorizontally(int r100) {
        ScrollDirection r101 = this.f249585a;
        if (r101 != ScrollDirection.HORIZONTAL_RIGHT) goto L5;
    L8:
        return true;
    L5:
        if (r101 == ScrollDirection.HORIZONTAL_LEFT) goto L8;
        return false;
    }

    @Override // android.view.View
    public final boolean canScrollVertically(int r100) {
        ScrollDirection r101 = this.f249585a;
        if (r101 != ScrollDirection.VERTICAL_TOP) goto L5;
    L8:
        return true;
    L5:
        if (r101 == ScrollDirection.VERTICAL_BOTTOM) goto L8;
        return false;
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public final boolean hasNestedScrollingParent(int r100) {
        return this.f249588d.hasNestedScrollingParent(r100);
    }

    public final void setMBounceView(View r100) {
        View r101 = this.f249595k;
        if (r101 == null) goto L5;
        removeView(r101);
    L5:
        if (r100 == null) goto L7;
        addView(r100);
    L7:
        this.f249595k = r100;
    }

    public final void setMContentView(View r100) {
        View r101 = this.f249594j;
        if (r101 == null) goto L5;
        removeView(r101);
    L5:
        if (r100 == null) goto L7;
        addView(r100, -1, -1);
    L7:
        this.f249594j = r100;
    }

    public final void setMEnableBounce(boolean r100) {
        this.f249586b = r100;
    }

    public final void setMScrollDirection(ScrollDirection r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f249585a = r100;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean r100) {
        this.f249588d.setNestedScrollingEnabled(r100);
    }

    public final void setOnBounceScrollListener(b r100) {
        this.f249596l = r100;
    }

    public final void setOnScrollToEndListener(c r100) {
        this.f249597m = r100;
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public final void stopNestedScroll(int r100) {
        this.f249588d.stopNestedScroll(r100);
    }

    public BounceLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean dispatchNestedPreFling(float r100, float r101) {
        return this.f249588d.dispatchNestedPreFling(r100, r101);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        View r102 = this.f249595k;
        if (r102 == null) goto L22;
        measureChildWithMargins(r102, r100, 0, r101, 0);
        ViewGroup.LayoutParams r103 = r102.getLayoutParams();
        if (r103 == null) goto L21;
        ViewGroup.MarginLayoutParams r104 = (ViewGroup.MarginLayoutParams) r103;
        ScrollDirection r105 = this.f249585a;
        int r106 = d.f249599a[r105.ordinal()];
        if (r106 != 1) goto L9;
    L18:
        int r107 = r102.getMeasuredHeight() + r104.topMargin;
        int r108 = r104.bottomMargin;
    L19:
        this.f249589e = r107 + r108;
        return;
    L9:
        if (r106 == 2) goto L18;
        if (r106 != 3) goto L13;
    L17:
        r107 = r102.getMeasuredWidth() + r104.rightMargin;
        r108 = r104.leftMargin;
        goto L19
    L13:
        if (r106 == 4) goto L17;
        throw new NoWhenBranchMatchedException();
    L21:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void onStopNestedScroll(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
        this.f249587c.onStopNestedScroll(r100, r101);
        if (r101 != 1) goto L5;
        return;
    L5:
        int r102 = d.f249599a[this.f249585a.ordinal()];
        if (r102 == 1) goto L42;
        if (r102 == 2) goto L33;
        if (r102 == 3) goto L24;
        if (r102 == 4) goto L15;
        return;
    L15:
        if (getScrollX() > 0) goto L18;
        return;
    L18:
        if (getScrollX() <= (((double) this.f249589e) * 0.88d)) goto L22;
        c r103 = this.f249597m;
        if (r103 == null) goto L22;
        r103.a();
    L22:
        a(this, -getScrollX(), 0);
        return;
    L24:
        if (getScrollX() < 0) goto L27;
        return;
    L27:
        if (Math.abs(getScrollX()) <= (((double) this.f249589e) * 0.88d)) goto L31;
        c r104 = this.f249597m;
        if (r104 == null) goto L31;
        r104.a();
    L31:
        a(this, -getScrollX(), 0);
        return;
    L33:
        if (getScrollY() > 0) goto L36;
        return;
    L36:
        if (getScrollY() <= (((double) this.f249589e) * 0.88d)) goto L40;
        c r105 = this.f249597m;
        if (r105 == null) goto L40;
        r105.a();
    L40:
        a(this, 0, -getScrollY());
        return;
    L42:
        if (getScrollY() < 0) goto L45;
        return;
    L45:
        if (Math.abs(getScrollY()) <= (((double) this.f249589e) * 0.88d)) goto L49;
        c r106 = this.f249597m;
        if (r106 == null) goto L49;
        r106.a();
    L49:
        a(this, 0, -getScrollY());
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public final boolean startNestedScroll(int r100, int r101) {
        return this.f249588d.startNestedScroll(r100, r101);
    }

    public BounceLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        new LinkedHashMap();
        super(r100, r101, r102);
        this.f249585a = ScrollDirection.HORIZONTAL_RIGHT;
        this.f249587c = new NestedScrollingParentHelper(this);
        this.f249588d = new NestedScrollingChildHelper(this);
        this.f249593i = new OverScroller(r100);
    }

    public static void a(BounceLayout r100, int r101, int r102) {
        r100.f249593i.startScroll(r100.getScrollX(), r100.getScrollY(), r101, r102);
        r100.invalidate();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean dispatchNestedFling(float r100, float r101, boolean r102) {
        return this.f249588d.dispatchNestedFling(r100, r101, r102);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void onNestedScrollAccepted(View r100, View r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        Intrinsics.checkNotNullParameter(r101, PickerReporterConstants.KEY.TARGET);
        this.f249587c.onNestedScrollAccepted(r100, r101, r102, r103);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final boolean onStartNestedScroll(View r100, View r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        Intrinsics.checkNotNullParameter(r101, PickerReporterConstants.KEY.TARGET);
        if (this.f249586b == true) goto L5;
        return false;
    L5:
        ScrollDirection r104 = this.f249585a;
        int r105 = d.f249599a[r104.ordinal()];
        if (r105 == 1) goto L17;
        if (r105 == 2) goto L17;
        if (r105 != 3) goto L11;
    L15:
        if (r102 != 1) goto L20;
    L18:
        return true;
    L20:
        return false;
    L11:
        if (r105 == 4) goto L15;
        throw new NoWhenBranchMatchedException();
    L17:
        if (r102 == 2) goto L18;
        return false;
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public final boolean dispatchNestedPreScroll(int r100, int r101, int[] r102, int[] r110, int r111) {
        return this.f249588d.dispatchNestedPreScroll(r100, r101, r102, r110, r111);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r110, int r111, int r112) {
        super.onLayout(r100, getLeft(), getTop(), getRight(), getBottom());     // Catch: IllegalStateException -> L23
        View r102 = this.f249595k;     // Catch: IllegalStateException -> L23
        if (r102 == null) goto L27;
        ViewGroup.LayoutParams r103 = r102.getLayoutParams();     // Catch: IllegalStateException -> L23
        if (r103 == null) goto L22;
        ViewGroup.MarginLayoutParams r104 = (ViewGroup.MarginLayoutParams) r103;     // Catch: IllegalStateException -> L23
        int r113 = d.f249599a[this.f249585a.ordinal()];     // Catch: IllegalStateException -> L23
        if (r113 != 1) goto L9;
        int r114 = r104.leftMargin;     // Catch: IllegalStateException -> L23
        int r105 = -(r102.getMeasuredHeight() + r104.bottomMargin);
    L19:
        int r106 = r114;
        int r115 = r105;
        int r107 = r106;
    L20:
        r102.layout(r107, r115, r102.getMeasuredWidth() + r107, r102.getMeasuredHeight() + r115);     // Catch: IllegalStateException -> L23
        return;
    L9:
        if (r113 != 2) goto L11;
        r114 = r104.leftMargin;     // Catch: IllegalStateException -> L23
        r105 = r104.topMargin + getMeasuredHeight();     // Catch: IllegalStateException -> L23
        goto L19
    L11:
        if (r113 != 3) goto L13;
        r114 = -(r102.getMeasuredWidth() + r104.rightMargin);
        r105 = r104.topMargin;     // Catch: IllegalStateException -> L23
        goto L19
    L13:
        if (r113 == 4) goto L15;
        r107 = 0;
        r115 = 0;
        goto L20
    L15:
        r114 = getMeasuredWidth() + r104.leftMargin;     // Catch: IllegalStateException -> L23
        r105 = r104.topMargin;     // Catch: IllegalStateException -> L23
        goto L19
    L22:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");     // Catch: IllegalStateException -> L23
    L27:
        return;
    L23:
        e = move-exception;
        LLog.e("BounceLayout", "Exception during layout: " + e.getMessage());
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void onNestedPreScroll(View r100, int r101, int r102, int[] r103, int r104) {
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
        Intrinsics.checkNotNullParameter(r103, "consumed");
        if (r104 == 0) goto L5;
        return;
    L5:
        ScrollDirection r105 = this.f249585a;
        int r106 = d.f249599a[r105.ordinal()];
        if (r106 == 1) goto L105;
        if (r106 == 2) goto L75;
        if (r106 == 3) goto L45;
        if (r106 == 4) goto L15;
        return;
    L15:
        if (r100.canScrollHorizontally(1) == true) goto L29;
        if (r101 <= 0) goto L29;
        int r107 = getScrollX() + r101;
        int r108 = this.f249589e;
        if (r107 <= r108) goto L23;
        b r109 = this.f249596l;
        if (r109 == null) goto L22;
        r109.a(r108, 0, getScrollX(), 0);
    L22:
        scrollTo(this.f249589e, getScrollY());
    L27:
        r103[0] = r101;
        this.f249591g = getScrollX();
        return;
    L23:
        requestDisallowInterceptTouchEvent(true);
        b r110 = this.f249596l;
        if (r110 == null) goto L26;
        r110.a(getScrollX() + r101, 0, getScrollX(), 0);
    L26:
        scrollBy(r101, 0);
    L29:
        if (r101 < 0) goto L31;
        return;
    L31:
        if (getScrollX() > 0) goto L33;
        return;
    L33:
        if (Math.abs(r101) <= getScrollX()) goto L38;
        b r111 = this.f249596l;
        if (r111 == null) goto L37;
        r111.a(0, 0, getScrollX(), 0);
    L37:
        scrollBy(-getScrollX(), 0);
    L42:
        r103[0] = r101;
        this.f249591g = getScrollX();
        return;
    L38:
        b r112 = this.f249596l;
        if (r112 == null) goto L41;
        r112.a(getScrollX() + r101, 0, getScrollX(), 0);
    L41:
        scrollBy(r101, 0);
        goto L42
    L45:
        if (r100.canScrollHorizontally(-1) == true) goto L59;
        if (r101 >= 0) goto L59;
        int r113 = Math.abs(r101) + Math.abs(getScrollX());
        int r114 = this.f249589e;
        if (r113 <= r114) goto L53;
        b r115 = this.f249596l;
        if (r115 == null) goto L52;
        r115.a(-r114, 0, getScrollX(), 0);
    L52:
        scrollTo(-this.f249589e, getScrollY());
    L57:
        r103[0] = r101;
        this.f249591g = getScrollX();
        return;
    L53:
        requestDisallowInterceptTouchEvent(true);
        b r116 = this.f249596l;
        if (r116 == null) goto L56;
        r116.a(getScrollX() + r101, 0, getScrollX(), 0);
    L56:
        scrollBy(r101, 0);
    L59:
        if (r101 > 0) goto L61;
        return;
    L61:
        if (getScrollX() < 0) goto L63;
        return;
    L63:
        if (r101 <= Math.abs(getScrollX())) goto L68;
        b r117 = this.f249596l;
        if (r117 == null) goto L67;
        r117.a(0, 0, -getScrollX(), 0);
    L67:
        scrollBy(-getScrollX(), 0);
    L72:
        r103[0] = r101;
        this.f249591g = getScrollX();
        return;
    L68:
        b r118 = this.f249596l;
        if (r118 == null) goto L71;
        r118.a(getScrollX() + r101, 0, getScrollX(), 0);
    L71:
        scrollBy(r101, 0);
        goto L72
    L75:
        if (r100.canScrollVertically(1) == true) goto L89;
        if (r102 <= 0) goto L89;
        int r119 = getScrollY() + r102;
        int r120 = this.f249589e;
        if (r119 <= r120) goto L83;
        b r121 = this.f249596l;
        if (r121 == null) goto L82;
        r121.a(0, r120, 0, getScrollY());
    L82:
        scrollTo(getScrollX(), this.f249589e);
    L87:
        r103[1] = r102;
        this.f249592h = getScrollY();
        return;
    L83:
        requestDisallowInterceptTouchEvent(true);
        b r122 = this.f249596l;
        if (r122 == null) goto L86;
        r122.a(0, getScrollY() + r102, 0, getScrollY());
    L86:
        scrollBy(0, r102);
    L89:
        if (r102 < 0) goto L91;
        return;
    L91:
        if (getScrollY() > 0) goto L93;
        return;
    L93:
        if (Math.abs(r102) <= getScrollY()) goto L98;
        b r123 = this.f249596l;
        if (r123 == null) goto L97;
        r123.a(0, 0, 0, getScrollY());
    L97:
        scrollBy(0, -getScrollY());
    L102:
        r103[1] = r102;
        this.f249592h = getScrollY();
        return;
    L98:
        b r124 = this.f249596l;
        if (r124 == null) goto L101;
        r124.a(0, getScrollY() + r102, 0, getScrollY());
    L101:
        scrollBy(0, r102);
        goto L102
    L105:
        if (r100.canScrollVertically(-1) == true) goto L119;
        if (r102 >= 0) goto L119;
        int r125 = Math.abs(r102) + Math.abs(getScrollY());
        int r126 = this.f249589e;
        if (r125 <= r126) goto L113;
        b r127 = this.f249596l;
        if (r127 == null) goto L112;
        r127.a(0, -r126, 0, getScrollY());
    L112:
        scrollTo(getScrollX(), -this.f249589e);
    L117:
        r103[1] = r102;
        this.f249592h = getScrollY();
        return;
    L113:
        requestDisallowInterceptTouchEvent(true);
        b r128 = this.f249596l;
        if (r128 == null) goto L116;
        r128.a(0, getScrollY() + r102, 0, getScrollY());
    L116:
        scrollBy(0, r102);
    L119:
        if (r102 > 0) goto L121;
        return;
    L121:
        if (getScrollY() < 0) goto L123;
        return;
    L123:
        if (r102 <= Math.abs(getScrollY())) goto L128;
        b r129 = this.f249596l;
        if (r129 == null) goto L127;
        r129.a(0, 0, 0, -getScrollY());
    L127:
        scrollBy(0, -getScrollY());
    L132:
        r103[1] = r102;
        this.f249592h = getScrollY();
        return;
    L128:
        b r130 = this.f249596l;
        if (r130 == null) goto L131;
        r130.a(0, getScrollY() + r102, 0, getScrollY());
    L131:
        scrollBy(0, r102);
        goto L132
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public final boolean dispatchNestedScroll(int r100, int r101, int r110, int r111, int[] r112, int r113) {
        return this.f249588d.dispatchNestedScroll(r100, r101, r110, r111, r112, r113);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void onNestedScroll(View r100, int r101, int r102, int r103, int r104, int r105) {
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
        if (r105 == 1) goto L5;
        return;
    L5:
        ScrollDirection r106 = this.f249585a;
        int r107 = d.f249599a[r106.ordinal()];
        if (r107 == 1) goto L39;
        if (r107 == 2) goto L31;
        if (r107 == 3) goto L23;
        if (r107 == 4) goto L15;
        return;
    L15:
        if (this.f249590f == true) goto L17;
    L19:
        if (r101 <= 0) goto L48;
        if (r103 <= 0) goto L49;
        a(this, this.f249589e, 0);
        this.f249590f = true;
        return;
    L49:
        return;
    L48:
        return;
    L17:
        if (Math.abs(getScrollX()) != this.f249589e) goto L19;
        a(this, -getScrollX(), 0);
        this.f249590f = false;
        return;
    L23:
        if (this.f249590f == true) goto L25;
    L27:
        if (r101 >= 0) goto L52;
        if (r103 >= 0) goto L53;
        a(this, -this.f249589e, 0);
        this.f249590f = true;
        return;
    L53:
        return;
    L52:
        return;
    L25:
        if (Math.abs(getScrollX()) != this.f249589e) goto L27;
        a(this, -getScrollX(), 0);
        this.f249590f = false;
        return;
    L31:
        if (this.f249590f == true) goto L33;
    L35:
        if (r102 <= 0) goto L56;
        if (r104 <= 0) goto L57;
        a(this, 0, this.f249589e);
        this.f249590f = true;
        return;
    L57:
        return;
    L56:
        return;
    L33:
        if (getScrollY() != this.f249589e) goto L35;
        a(this, 0, -getScrollY());
        this.f249590f = false;
        return;
    L39:
        if (this.f249590f == true) goto L41;
    L43:
        if (r102 <= 0) goto L60;
        if (r104 <= 0) goto L61;
        a(this, 0, -this.f249589e);
        this.f249590f = true;
        return;
    L61:
        return;
    L60:
        return;
    L41:
        if (getScrollY() != this.f249589e) goto L43;
        a(this, 0, -getScrollY());
        this.f249590f = false;
    }
}
