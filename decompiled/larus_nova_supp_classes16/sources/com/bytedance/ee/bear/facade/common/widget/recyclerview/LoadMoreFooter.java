package com.bytedance.ee.bear.facade.common.widget.recyclerview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.airbnb.lottie.LottieAnimationView;
import com.bytedance.ee.bear.facade.common.widget.BearLottieView;
import com.bytedance.ee.util.ui.n;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import cqa.d;
import cqa.g;
import cqa.h;
import dqa.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u0015\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 D2\u00020\u00012\u00020\u0002:\u0001DB\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0005\u0010\tB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\u0005\u0010\fJ\"\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0006\u0010\u001b\u001a\u00020\u000eJ\u0018\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u000bH\u0014J\u0018\u0010\u001f\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0013H\u0017J \u0010#\u001a\u00020\u001a2\u0006\u0010$\u001a\u00020\u00152\u0006\u0010%\u001a\u00020\u000b2\u0006\u0010&\u001a\u00020\u000bH\u0017J0\u0010'\u001a\u00020\u001a2\u0006\u0010(\u001a\u00020\u00132\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020\u000b2\u0006\u0010,\u001a\u00020\u000bH\u0017J \u0010-\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020!2\u0006\u0010.\u001a\u00020\u000b2\u0006\u0010&\u001a\u00020\u000bH\u0017J \u0010/\u001a\u00020\u001a2\u0006\u00100\u001a\u00020!2\u0006\u0010%\u001a\u00020\u000b2\u0006\u0010,\u001a\u00020\u000bH\u0017J\u0014\u00101\u001a\u00020\u001a2\n\u00102\u001a\u000203\"\u00020\u000bH\u0017J\u0012\u00104\u001a\u00020\u00002\b\b\u0001\u00105\u001a\u00020\u000bH\u0002J\u0010\u00106\u001a\u00020\u00132\u0006\u00107\u001a\u00020\u0013H\u0017J\b\u00108\u001a\u00020\u0010H\u0016J\b\u00109\u001a\u00020:H\u0016J\b\u0010;\u001a\u00020\u0013H\u0016J \u0010<\u001a\u00020\u001a2\u0006\u0010=\u001a\u00020*2\u0006\u0010>\u001a\u00020\u000b2\u0006\u0010?\u001a\u00020\u000bH\u0017J \u0010@\u001a\u00020\u001a2\u0006\u00100\u001a\u00020!2\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020BH\u0017R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006E"}, d2 = {"Lcom/bytedance/ee/bear/facade/common/widget/recyclerview/LoadMoreFooter;", "Landroid/widget/RelativeLayout;", "Lcom/scwang/smartrefresh/layout/api/RefreshFooter;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mLottieAnimationView", "Lcom/bytedance/ee/bear/facade/common/widget/BearLottieView;", "mSpinnerStyle", "Lcom/scwang/smartrefresh/layout/constant/SpinnerStyle;", "mFinishDuration", "mLoadMoreFinished", "", "mRefreshKernel", "Lcom/scwang/smartrefresh/layout/api/RefreshKernel;", "mBackgroundColor", "mFooterPaddingTop", "mFooterPaddingBottom", "initView", "", "getBearLottieView", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onFinish", "layout", "Lcom/scwang/smartrefresh/layout/api/RefreshLayout;", "success", "onInitialized", "kernel", "height", "extendHeight", "onMoving", "isDragging", "percent", "", "offset", "maxDragHeight", "onReleased", "footerHeight", "onStartAnimator", "refreshLayout", "setPrimaryColors", "colors", "", "setPrimaryColor", "primaryColor", "setNoMoreData", "finished", "getSpinnerStyle", "getView", "Landroid/view/View;", "isSupportHorizontalDrag", "onHorizontalDrag", "percentX", "offsetX", "offsetMax", "onStateChanged", "oldState", "Lcom/scwang/smartrefresh/layout/constant/RefreshState;", "newState", "Companion", "base-widget_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LoadMoreFooter extends RelativeLayout implements d {
    public BearLottieView a;
    public b b;
    public int c;
    public boolean d;
    public g e;
    public int f;
    public int g;
    public int h;

    public static final class a {
    }

    static {
    }

    public final boolean a() {
        return false;
    }

    public final void b(boolean r1, float r2, int r3, int r4, int r5) {
    }

    public final void d(float r1, int r2, int r3) {
    }

    public View getView() {
        return this;
    }

    public final void i(h r1, int r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "layout");
    }

    public final BearLottieView getBearLottieView() {
        BearLottieView r0 = this.a;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mLottieAnimationView");
        return null;
    L6:
        return r0;
    }

    public b getSpinnerStyle() {
        return this.b;
    }

    public LoadMoreFooter(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.b = b.d;
        this.c = 200;
        k(r2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2, types: [android.widget.ImageView] */
    public final boolean c(boolean r4) {
        if (this.d == r4) goto L14;
        this.d = r4;
        if (r4 == false) goto L14;
        BearLottieView r0 = this.a;
        ?? r1 = 0;
        if (r0 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("mLottieAnimationView");
        r0 = null;
    L9:
        r0.cancelAnimation();
        BearLottieView r2 = this.a;
        if (r2 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("mLottieAnimationView");
    L13:
        r1.setVisibility(8);
        goto L14
    L12:
        r1 = r2;
    L14:
        return r4;
    }

    public final void l(int r2) {
        this.f = r2;
        setBackgroundColor(r2);
        if (this.e != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mRefreshKernel");
    L5:
        g r3 = this.e;
        if (r3 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mRefreshKernel");
        r3 = null;
    L8:
        SmartRefreshLayout.j r4 = (SmartRefreshLayout.j) r3;
        r4.c(this, this.f);
    }

    public void setPrimaryColors(int... r4) {
        Intrinsics.checkNotNullParameter(r4, "colors");
        if (Intrinsics.areEqual(this.b, b.e) == true) goto L5;
        return;
    L5:
        if (r4.length != 0) goto L7;
        boolean r0 = true;
    L9:
        if ((!r0) == true) goto L11;
        return;
    L11:
        if ((getBackground() instanceof BitmapDrawable) == true) goto L16;
        l(r4[0]);
        return;
    L16:
        return;
    L7:
        r0 = false;
        goto L9
    }

    public LoadMoreFooter(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        this.b = b.d;
        this.c = 200;
        k(r2, r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4, types: [android.widget.ImageView] */
    public final int j(SmartRefreshLayout r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "layout");
        if (this.d == true) goto L13;
        BearLottieView r4 = this.a;
        ?? r5 = 0;
        if (r4 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mLottieAnimationView");
        r4 = null;
    L7:
        r4.cancelAnimation();
        BearLottieView r6 = this.a;
        if (r6 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("mLottieAnimationView");
    L11:
        r5.setVisibility(8);
        return this.c;
    L10:
        r5 = r6;
        goto L11
    L13:
        return 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r6v0, types: [android.widget.RelativeLayout, com.bytedance.ee.bear.facade.common.widget.recyclerview.LoadMoreFooter] */
    public final void k(Context r7, AttributeSet r8) {
        setBackgroundColor(r7.getResources().getColor(2131103546));
        BearLottieView r0 = new BearLottieView(r7);
        this.a = r0;
        r0.setAnimation("loading.json");
        BearLottieView r1 = this.a;
        ?? r2 = 0;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mLottieAnimationView");
        r1 = null;
    L5:
        r1.setRepeatCount(-1);
        BearLottieView r3 = this.a;
        if (r3 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mLottieAnimationView");
        r3 = null;
    L8:
        r3.cancelAnimation();
        LottieAnimationView r4 = this.a;
        if (r4 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mLottieAnimationView");
        r4 = null;
    L11:
        r4.setVisibility(0);
        RelativeLayout.LayoutParams r5 = new RelativeLayout.LayoutParams(-1, n.f(r7, 66));
        r5.addRule(13);
        BearLottieView r6 = this.a;
        if (r6 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mLottieAnimationView");
    L15:
        addView(r2, r5);
        TypedArray r9 = r7.obtainStyledAttributes(r8, new int[]{2130974157, 2130974179, 2130974196, 2130974199});
        this.c = r9.getInt(1, this.c);
        this.b = b.h[r9.getInt(3, this.b.a)];
        if (r9.hasValue(2) == false) goto L18;
        l(r9.getColor(2, 0));
    L18:
        r9.recycle();
        this.g = n.f(r7, this.g);
        this.h = n.f(r7, this.h);
        if (getPaddingTop() != 0) goto L25;
        if (getPaddingBottom() != 0) goto L23;
        setPadding(getPaddingLeft(), this.g, getPaddingRight(), this.h);
        return;
    L23:
        setPadding(getPaddingLeft(), this.g, getPaddingRight(), this.h);
        return;
    L25:
        if (getPaddingBottom() != 0) goto L27;
        setPadding(getPaddingLeft(), this.g, getPaddingRight(), this.h);
        return;
    L27:
        this.g = getPaddingTop();
        this.h = getPaddingBottom();
        return;
    L14:
        r2 = r6;
        goto L15
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public final void onMeasure(int r5, int r6) {
        if (View.MeasureSpec.getMode(r6) != 1073741824) goto L5;
        setPadding(getPaddingLeft(), 0, getPaddingRight(), 0);
    L6:
        super.onMeasure(r5, r6);
        return;
    L5:
        setPadding(getPaddingLeft(), this.g, getPaddingRight(), this.h);
        goto L6
    }

    public LoadMoreFooter(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.b = b.d;
        this.c = 200;
        k(r2, r3);
    }

    public final void e(h r2, RefreshState r3, RefreshState r4) {
        Intrinsics.checkNotNullParameter(r2, "refreshLayout");
        Intrinsics.checkNotNullParameter(r3, "oldState");
        Intrinsics.checkNotNullParameter(r4, "newState");
        if (r4 != RefreshState.None) goto L15;
        BearLottieView r5 = this.a;
        BearLottieView r6 = null;
        if (r5 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mLottieAnimationView");
        r5 = null;
    L8:
        if (r5.isAnimating() == false) goto L16;
        BearLottieView r7 = this.a;
        if (r7 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("mLottieAnimationView");
    L13:
        r6.cancelAnimation();
        return;
    L12:
        r6 = r7;
        goto L13
    L16:
        return;
    }

    public final void f(h r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "refreshLayout");
        if (this.d == true) goto L13;
        LottieAnimationView r5 = this.a;
        BearLottieView r6 = null;
        if (r5 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mLottieAnimationView");
        r5 = null;
    L7:
        r5.setVisibility(0);
        BearLottieView r7 = this.a;
        if (r7 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("mLottieAnimationView");
    L11:
        r6.playAnimation();
        return;
    L10:
        r6 = r7;
        goto L11
    }

    public final void g(SmartRefreshLayout.j r1, int r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "kernel");
        this.e = r1;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mRefreshKernel");
        r1 = null;
    L5:
        r1.c(this, this.f);
    }
}
