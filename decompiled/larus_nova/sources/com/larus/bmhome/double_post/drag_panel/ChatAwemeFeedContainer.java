package com.larus.bmhome.double_post.drag_panel;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;
import android.widget.OverScroller;
import androidx.core.view.NestedScrollingParent2;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.larus.platform.service.z2;
import com.larus.utils.CubicBezierInterpolator;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import v19.c7;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0015\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0012\u0018\u0000 H2\u00020\u00012\u00020\u0002:\u0002HIB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\b\u0010!\u001a\u00020\"H\u0014J(\u0010#\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020\b2\u0006\u0010(\u001a\u00020\bH\u0016J(\u0010)\u001a\u00020\"2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020\b2\u0006\u0010(\u001a\u00020\bH\u0016J0\u0010*\u001a\u00020\"2\u0006\u0010&\u001a\u00020%2\u0006\u0010+\u001a\u00020\b2\u0006\u0010,\u001a\u00020\b2\u0006\u0010-\u001a\u00020.2\u0006\u0010(\u001a\u00020\bH\u0016J8\u0010/\u001a\u00020\"2\u0006\u0010&\u001a\u00020%2\u0006\u00100\u001a\u00020\b2\u0006\u00101\u001a\u00020\b2\u0006\u00102\u001a\u00020\b2\u0006\u00103\u001a\u00020\b2\u0006\u0010(\u001a\u00020\bH\u0016J\u0018\u00104\u001a\u00020\"2\u0006\u0010&\u001a\u00020%2\u0006\u0010(\u001a\u00020\bH\u0016J\b\u00105\u001a\u00020\bH\u0016J\u0010\u00106\u001a\u00020\"2\u0006\u0010,\u001a\u00020\bH\u0002J\u0010\u00107\u001a\u0002082\u0006\u0010,\u001a\u00020\bH\u0002J\b\u00109\u001a\u00020\"H\u0002J \u0010:\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020%2\u0006\u0010;\u001a\u0002082\u0006\u0010<\u001a\u000208H\u0016J(\u0010=\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020%2\u0006\u0010;\u001a\u0002082\u0006\u0010<\u001a\u0002082\u0006\u0010-\u001a\u00020\u001cH\u0016J\u0018\u0010>\u001a\u00020\"2\u0006\u0010?\u001a\u00020\b2\u0006\u0010@\u001a\u00020\bH\u0016J\u000e\u0010A\u001a\u00020\"2\u0006\u0010B\u001a\u00020\u001cJ\u0006\u0010C\u001a\u00020\u001cJ\u000e\u0010D\u001a\u00020\"2\u0006\u0010E\u001a\u00020\bJ\u000e\u0010F\u001a\u00020\"2\u0006\u0010G\u001a\u00020\u001eR\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006J"}, d2 = {"Lcom/larus/bmhome/double_post/drag_panel/ChatAwemeFeedContainer;", "Landroid/widget/LinearLayout;", "Landroidx/core/view/NestedScrollingParent2;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "awemeContainer", "Landroid/view/ViewGroup;", "mScrollThreshold", "mRangeOffset", "mScrollRange", "getMScrollRange", "()I", "mFlingAllY", "mRecyclerConsumedFlingY", "mInterpolator", "Landroid/view/animation/DecelerateInterpolator;", "mEndAnimator", "Landroid/animation/ValueAnimator;", "mFlingAnimator", "mEnable", "", "mListener", "Lcom/larus/bmhome/double_post/drag_panel/ChatAwemeFeedContainer$IScrollListener;", "mNestedScrollingParentHelper", "Landroidx/core/view/NestedScrollingParentHelper;", "onFinishInflate", "", "onStartNestedScroll", MapBundleKey.OfflineMapKey.OFFLINE_CHILD, "Landroid/view/View;", PickerReporterConstants.KEY.TARGET, "axes", "type", "onNestedScrollAccepted", "onNestedPreScroll", "dx", "dy", "consumed", "", "onNestedScroll", "dxConsumed", "dyConsumed", "dxUnconsumed", "dyUnconsumed", "onStopNestedScroll", "getNestedScrollAxes", "flingAnimation", "dampingFactor", "", "end", "onNestedPreFling", "velocityX", "velocityY", "onNestedFling", "scrollTo", "x", "y", "setEnable", "enable", "getEnable", "setScrollRangeOffset", "offset", "setScrollListener", "listener", "Companion", "IScrollListener", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatAwemeFeedContainer extends LinearLayout implements NestedScrollingParent2 {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ int f311462l = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RecyclerView f311463a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ViewGroup f311464b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f311465c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f311466d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f311467e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f311468f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final DecelerateInterpolator f311469g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ValueAnimator f311470h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ValueAnimator f311471i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f311472j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final NestedScrollingParentHelper f311473k;

    public static final class a {
    }

    public interface b {
    }

    static {
    }

    public ChatAwemeFeedContainer(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ChatAwemeFeedContainer(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final void setScrollListener(b r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
    }

    @Override // android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        if (this.f311472j == true) goto L7;
        return super.getNestedScrollAxes();
    L7:
        return this.f311473k.getNestedScrollAxes();
    }

    private final int getMScrollRange() {
        return getMeasuredHeight() + this.f311466d;
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        View r100 = getChildAt(0);
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        this.f311463a = (RecyclerView) r100;
        View r101 = getChildAt(1);
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type android.view.ViewGroup");
        this.f311464b = (ViewGroup) r101;
    }

    public final boolean getEnable() {
        return this.f311472j;
    }

    public final void setEnable(boolean r100) {
        this.f311472j = r100;
    }

    public final void setScrollRangeOffset(int r100) {
        this.f311466d = r100;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void onStopNestedScroll(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
        FLogger.f375446a.i("ChatAwemeFeedContainer", "onStopNestedScroll, type: " + r101);
        this.f311473k.onStopNestedScroll(r100, r101);
        if (r101 == 0) goto L5;
        return;
    L5:
        if (getScrollY() < this.f311465c) goto L7;
        boolean r102 = true;
    L8:
        if (r102 == false) goto L10;
        int r103 = getMScrollRange();
    L11:
        ValueAnimator r104 = ValueAnimator.ofInt(new int[]{getScrollY(), r103});
        r104.setDuration(RangesKt.coerceAtMost(RangesKt.coerceAtLeast((long) ((getScrollY() / getMScrollRange()) * 400), 300), 400));
        r104.setInterpolator(new CubicBezierInterpolator(0.24f, 0.0f, 0.58f));
        r104.addUpdateListener(new g0(this));
        r104.addListener(new h0(r102, this, r104));
        r104.start();
        this.f311470h = r104;
        return;
    L10:
        r103 = 0;
        goto L11
    L7:
        r102 = false;
        goto L8
    }

    @Override // android.view.View
    public final void scrollTo(int r100, int r101) {
        if (this.f311472j == true) goto L5;
        super.scrollTo(r100, r101);
        return;
    L5:
        if (r101 >= 0) goto L7;
        r101 = 0;
    L7:
        super.scrollTo(r100, r101);
    }

    public ChatAwemeFeedContainer(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f311465c = c7.b(Integer.valueOf(z2.f365865a.getAwemeVideoFeedConfig().a()));
        this.f311469g = new DecelerateInterpolator();
        this.f311473k = new NestedScrollingParentHelper(this);
        setOrientation(1);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final boolean onNestedPreFling(View r110, float r111, float r112) {
        Intrinsics.checkNotNullParameter(r110, PickerReporterConstants.KEY.TARGET);
        if (this.f311472j == false) goto L5;
        OverScroller r100 = new OverScroller(r110.getContext());
        r100.fling(0, 0, (int) r111, (int) r112, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
        this.f311467e = r100.getFinalY();
        this.f311468f = 0;
        FLogger.f375446a.i("ChatAwemeFeedContainer", "onNestedPreFling, mFlingAllY = " + this.f311467e);
        return false;
    L5:
        return super.onNestedPreFling(r110, r111, r112);
    }

    public /* synthetic */ ChatAwemeFeedContainer(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final boolean onNestedFling(View r100, float r101, float r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
        if (this.f311472j == false) goto L5;
        FLogger.f375446a.i("ChatAwemeFeedContainer", "onNestedFling");
        return false;
    L5:
        return super.onNestedFling(r100, r101, r102, r103);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void onNestedScrollAccepted(View r100, View r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        Intrinsics.checkNotNullParameter(r101, PickerReporterConstants.KEY.TARGET);
        FLogger.f375446a.i("ChatAwemeFeedContainer", "onNestedScrollAccepted, type: " + r103);
        this.f311473k.onNestedScrollAccepted(r100, r101, r102, r103);
        ValueAnimator r104 = this.f311470h;
        if (r104 == null) goto L5;
        r104.cancel();
    L5:
        ValueAnimator r105 = this.f311471i;
        if (r105 == null) goto L9;
        r105.cancel();
        return;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final boolean onStartNestedScroll(View r100, View r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        Intrinsics.checkNotNullParameter(r101, PickerReporterConstants.KEY.TARGET);
        if (this.f311472j == true) goto L5;
    L7:
        return false;
    L5:
        if (r102 != 2) goto L7;
        return true;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void onNestedPreScroll(View r100, int r101, int r102, int[] r103, int r104) {
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
        Intrinsics.checkNotNullParameter(r103, "consumed");
        if (r104 != 0) goto L9;
        if (r102 < 0) goto L6;
        return;
    L6:
        if (getScrollY() <= 0) goto L11;
        scrollBy(0, (int) (r102 * RangesKt.coerceAtLeast(1 - this.f311469g.getInterpolation(getScrollY() / getMScrollRange()), 0.4f)));
        r103[1] = r102;
        return;
    L11:
        return;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void onNestedScroll(View r100, int r101, int r102, int r110, int r111, int r112) {
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
        if (r112 != 0) goto L7;
        if (r111 <= 0) goto L38;
        requestDisallowInterceptTouchEvent(true);
        scrollBy(0, (int) (r111 * RangesKt.coerceAtLeast(1 - this.f311469g.getInterpolation(getScrollY() / getMScrollRange()), 0.4f)));
        return;
    L38:
        return;
    L7:
        if (r102 <= 0) goto L14;
        int r103 = this.f311468f + r102;
        this.f311468f = r103;
        if (r111 <= 0) goto L14;
        int r104 = this.f311467e - r103;
        FLogger.f375446a.i("ChatAwemeFeedContainer", "do fling animation, allUnConsumedY = " + r104);
        if (r104 > 0) goto L13;
        return;
    L13:
        int r105 = r104 / 6;
        ValueAnimator r106 = ValueAnimator.ofInt(new int[]{0, r105, 0});
        r106.setDuration(RangesKt.coerceAtMost(RangesKt.coerceAtLeast((long) ((r105 / getMScrollRange()) * 700), 500), 700));
        r106.setInterpolator(new CubicBezierInterpolator(0.0f, 0.0f, 0.58f));
        r106.addUpdateListener(new f0(this));
        r106.start();
        this.f311471i = r106;
    L14:
        RecyclerView r107 = null;
        if (r111 <= 0) goto L21;
        RecyclerView r108 = this.f311463a;
        if (r108 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        r108 = null;
    L20:
        if (r108.canScrollVertically(1) == true) goto L21;
    L27:
        RecyclerView r109 = this.f311463a;
        if (r109 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        r109 = null;
    L31:
        if (r109.getScrollState() != 2) goto L42;
        FLogger.f375446a.w("ChatAwemeFeedContainer", "force make RecyclerView stop scroll");
        RecyclerView r113 = this.f311463a;
        if (r113 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
    L36:
        r107.stopScroll();
        return;
    L35:
        r107 = r113;
        goto L36
    L42:
        return;
    L21:
        if (r111 >= 0) goto L40;
        RecyclerView r114 = this.f311463a;
        if (r114 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        r114 = null;
    L26:
        if (r114.canScrollVertically(-1) == false) goto L27;
        return;
    }
}
