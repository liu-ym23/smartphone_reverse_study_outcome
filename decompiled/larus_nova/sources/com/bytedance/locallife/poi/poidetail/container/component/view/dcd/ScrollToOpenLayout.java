package com.bytedance.locallife.poi.poidetail.container.component.view.dcd;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.LinearLayout;
import android.widget.OverScroller;
import androidx.core.view.NestedScrollingChild2;
import androidx.core.view.NestedScrollingParent2;
import androidx.core.view.NestedScrollingParentHelper;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002:\u0002\n\u001aB\u0011\b\u0016\u0012\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014B\u001b\b\u0016\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b\u0013\u0010\u0017B#\b\u0016\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\u0006\u0010\u0018\u001a\u00020\u0003¢\u0006\u0004\b\u0013\u0010\u0019J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005R\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/bytedance/locallife/poi/poidetail/container/component/view/dcd/ScrollToOpenLayout;", "Landroid/widget/LinearLayout;", "Landroidx/core/view/NestedScrollingParent2;", "", "getNestedScrollAxes", "Lcom/bytedance/locallife/poi/poidetail/container/component/view/dcd/ScrollToOpenLayout$b;", "listener", "", "setOnScrollToEndListener", "", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Z", "getEnable", "()Z", "setEnable", "(Z)V", "enable", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "b", "locallife-poi-impl_release"}, k = 1, mv = {1, 4, 3})
public final class ScrollToOpenLayout extends LinearLayout implements NestedScrollingParent2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f263813a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final NestedScrollingParentHelper f263814b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f263815c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f263816d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f263817e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public b f263818f;

    public static final class a {
    }

    public interface b {
        void a();
    }

    static {
    }

    public final double a() {
        return Math.max(0.05d, ((double) 1) - Math.pow(((double) getScrollX()) / ((double) this.f263815c), 0.9d));
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final boolean onNestedFling(View r100, float r101, float r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
        return false;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final boolean onStartNestedScroll(View r100, View r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        Intrinsics.checkNotNullParameter(r101, PickerReporterConstants.KEY.TARGET);
        if (r102 == 1) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // android.view.View
    public final int computeHorizontalScrollRange() {
        if (this.f263813a == false) goto L5;
        int r100 = getChildCount();
        int r101 = 0;
        int r102 = 0;
    L7:
        if (r101 >= r100) goto L9;
        r102 = r102 + getChildAt(r101).getWidth();
        r101 = r101 + 1;
        goto L7
    L9:
        return r102;
    L5:
        return super.computeHorizontalScrollRange();
    }

    @Override // android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        return this.f263814b.getNestedScrollAxes();
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        if (getChildCount() != 2) goto L11;
        if ((getChildAt(0) instanceof NestedScrollingChild2) == false) goto L9;
        View r100 = getChildAt(0);
        ViewGroup.LayoutParams r101 = r100.getLayoutParams();
        r101.width = -1;
        r100.setLayoutParams(r101);
        return;
    L9:
        throw new IllegalArgumentException("first child must be an instance of NestedScrollingChild2");
    L11:
        throw new IllegalArgumentException("ScrollToOpenLayout must have two child");
    }

    public final boolean getEnable() {
        return this.f263813a;
    }

    public ScrollToOpenLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public final void setEnable(boolean r100) {
        this.f263813a = r100;
    }

    public final void setOnScrollToEndListener(b r100) {
        this.f263818f = r100;
    }

    public ScrollToOpenLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        this.f263815c = getChildAt(1).getMeasuredWidth();
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void onStopNestedScroll(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
        this.f263814b.onStopNestedScroll(r100, r101);
        if (r101 == 0) goto L5;
        return;
    L5:
        if (getScrollX() > 0) goto L8;
        return;
    L8:
        if (getScrollX() <= (((double) this.f263815c) * 0.88d)) goto L12;
        b r102 = this.f263818f;
        if (r102 == null) goto L12;
        r102.a();
    L12:
        ValueAnimator r103 = ValueAnimator.ofInt(new int[]{getScrollX(), 0});
        r103.setDuration((long) ((((double) getScrollX()) / ((double) this.f263815c)) * ((double) 200)));
        r103.addUpdateListener(new e(this));
        r103.start();
    }

    public ScrollToOpenLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f263813a = true;
        this.f263814b = new NestedScrollingParentHelper(this);
        setOrientation(0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final boolean onNestedPreFling(View r110, float r111, float r112) {
        Intrinsics.checkNotNullParameter(r110, PickerReporterConstants.KEY.TARGET);
        if (this.f263813a == true) goto L5;
        return false;
    L5:
        OverScroller r100 = new OverScroller(r110.getContext());
        r100.fling(0, 0, (int) r111, (int) r112, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
        this.f263816d = r100.getFinalX();
        this.f263817e = 0;
        return false;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void onNestedScrollAccepted(View r100, View r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        Intrinsics.checkNotNullParameter(r101, PickerReporterConstants.KEY.TARGET);
        this.f263814b.onNestedScrollAccepted(r100, r101, r102, r103);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void onNestedPreScroll(View r100, int r101, int r102, int[] r103, int r104) {
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
        Intrinsics.checkNotNullParameter(r103, "consumed");
        if (this.f263813a == true) goto L5;
        return;
    L5:
        if (r104 != 0) goto L11;
        if (r101 < 0) goto L8;
        return;
    L8:
        if (getScrollX() <= 0) goto L13;
        scrollBy(Math.max((int) (r101 * a()), -getScrollX()), 0);
        r103[0] = r101;
        return;
    L13:
        return;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void onNestedScroll(View r100, int r101, int r102, int r103, int r104, int r105) {
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
        if (this.f263813a == true) goto L6;
        return;
    L6:
        if (r105 != 0) goto L9;
        if (r103 <= 0) goto L24;
        requestDisallowInterceptTouchEvent(true);
        scrollBy(Math.min((int) (((double) r103) * a()), this.f263815c - getScrollX()), 0);
        return;
    L24:
        return;
    L9:
        if (r101 <= 0) goto L26;
        int r106 = this.f263817e + r101;
        this.f263817e = r106;
        if (r103 <= 0) goto L27;
        int r107 = this.f263816d - r106;
        Resources r108 = getContext().getResources();
        float r109 = TypedValue.applyDimension(1, 800.0f, WindowDisplayMetricsOverride.apply(r108, r108.getDisplayMetrics()));
        Float r110 = Float.valueOf(Math.min(r107, r109) / r109);
        if (r110.floatValue() < 0) goto L15;
        boolean r111 = true;
    L16:
        if (r111 == true) goto L19;
        r110 = null;
    L19:
        if (r110 == null) goto L21;
        float r112 = r110.floatValue();
    L22:
        ValueAnimator r113 = ValueAnimator.ofInt(new int[]{0, (int) ((((double) this.f263815c) * 0.66d) * ((double) r112)), 0});
        r113.setDuration((long) (600 * r112));
        r113.setInterpolator(new LinearInterpolator());
        r113.addUpdateListener(new f(this));
        r113.start();
        return;
    L21:
        r112 = 0.0f;
        goto L22
    L15:
        r111 = false;
        goto L16
    L27:
        return;
    }
}
