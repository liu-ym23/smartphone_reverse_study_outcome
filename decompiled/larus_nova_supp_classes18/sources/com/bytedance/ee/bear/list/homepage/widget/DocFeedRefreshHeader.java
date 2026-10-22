package com.bytedance.ee.bear.list.homepage.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.airbnb.lottie.LottieAnimationView;
import com.bytedance.ee.bear.facade.common.widget.BearLottieView;
import com.bytedance.ee.util.ui.n;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import cqa.e;
import cqa.g;
import cqa.h;
import dqa.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 D2\u00020\u00012\u00020\u0002:\u0001DB\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0005\u0010\tB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\u0005\u0010\fJ\u001a\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0002J\b\u0010\u0019\u001a\u00020\u0018H\u0014J\u0006\u0010\u001a\u001a\u00020\u0018J\u0018\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u000bH\u0014J\u0006\u0010\u001e\u001a\u00020\u0018J\u0006\u0010\u001f\u001a\u00020\u0018J\u0018\u0010 \u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0017J \u0010%\u001a\u00020\u00182\u0006\u0010&\u001a\u00020\u00132\u0006\u0010'\u001a\u00020\u000b2\u0006\u0010(\u001a\u00020\u000bH\u0017J0\u0010)\u001a\u00020\u00182\u0006\u0010*\u001a\u00020$2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u000b2\u0006\u0010'\u001a\u00020\u000b2\u0006\u0010.\u001a\u00020\u000bH\u0017J\u0014\u0010/\u001a\u00020\u00182\n\u00100\u001a\u000201\"\u00020\u000bH\u0017J\u0012\u00102\u001a\u00020\u00002\b\b\u0001\u00103\u001a\u00020\u000bH\u0002J\b\u00104\u001a\u00020\u0010H\u0016J\b\u00105\u001a\u000206H\u0016J\b\u00107\u001a\u00020$H\u0016J \u00108\u001a\u00020\u00182\u0006\u00109\u001a\u00020,2\u0006\u0010:\u001a\u00020\u000b2\u0006\u0010;\u001a\u00020\u000bH\u0017J \u0010<\u001a\u00020\u00182\u0006\u0010!\u001a\u00020\"2\u0006\u0010'\u001a\u00020\u000b2\u0006\u0010(\u001a\u00020\u000bH\u0017J \u0010=\u001a\u00020\u00182\u0006\u0010>\u001a\u00020\"2\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020@H\u0017J \u0010B\u001a\u00020\u00182\u0006\u0010!\u001a\u00020\"2\u0006\u0010C\u001a\u00020\u000b2\u0006\u0010(\u001a\u00020\u000bH\u0017R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006E"}, d2 = {"Lcom/bytedance/ee/bear/list/homepage/widget/DocFeedRefreshHeader;", "Landroid/widget/RelativeLayout;", "Lcom/scwang/smartrefresh/layout/api/RefreshHeader;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mLottieAnimationView", "Lcom/bytedance/ee/bear/facade/common/widget/BearLottieView;", "mSpinnerStyle", "Lcom/scwang/smartrefresh/layout/constant/SpinnerStyle;", "mFinishDuration", "mRefreshKernel", "Lcom/scwang/smartrefresh/layout/api/RefreshKernel;", "mBackgroundColor", "mFooterPaddingTop", "mFooterPaddingBottom", "initView", "", "onAttachedToWindow", "init", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "startAnimation", "stopAnimation", "onFinish", "layout", "Lcom/scwang/smartrefresh/layout/api/RefreshLayout;", "success", "", "onInitialized", "kernel", "height", "extendHeight", "onMoving", "isDragging", "percent", "", "offset", "maxDragHeight", "setPrimaryColors", "colors", "", "setPrimaryColor", "primaryColor", "getSpinnerStyle", "getView", "Landroid/view/View;", "isSupportHorizontalDrag", "onHorizontalDrag", "percentX", "offsetX", "offsetMax", "onStartAnimator", "onStateChanged", "refreshLayout", "oldState", "Lcom/scwang/smartrefresh/layout/constant/RefreshState;", "newState", "onReleased", "headerHeight", "Companion", "contentmanager-list_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DocFeedRefreshHeader extends RelativeLayout implements e {
    public BearLottieView a;
    public b b;
    public int c;
    public g d;
    public int e;
    public int f;
    public int g;

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

    public final void e(h r2, RefreshState r3, RefreshState r4) {
        Intrinsics.checkNotNullParameter(r2, "refreshLayout");
        Intrinsics.checkNotNullParameter(r3, "oldState");
        Intrinsics.checkNotNullParameter(r4, "newState");
    }

    public final void f(h r1, int r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "layout");
    }

    public View getView() {
        return this;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        BearLottieView r0 = new BearLottieView(getContext());
        this.a = r0;
        r0.setAnimation("loading.json");
        LottieAnimationView r1 = this.a;
        View r2 = null;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mLottieAnimationView");
        r1 = null;
    L5:
        r1.setRepeatCount(-1);
        RelativeLayout.LayoutParams r3 = new RelativeLayout.LayoutParams(-1, n.f(getContext(), 66));
        r3.addRule(13);
        View r4 = this.a;
        if (r4 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mLottieAnimationView");
    L9:
        addView(r2, r3);
        return;
    L8:
        r2 = r4;
        goto L9
    }

    public b getSpinnerStyle() {
        return this.b;
    }

    public DocFeedRefreshHeader(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.b = b.d;
        this.c = 200;
        k(r2, null);
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
        if ((getBackground() instanceof BitmapDrawable) == true) goto L19;
        int r5 = r4[0];
        this.e = r5;
        setBackgroundColor(r5);
        g r6 = this.d;
        if (r6 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("mRefreshKernel");
        r6 = null;
    L15:
        ((SmartRefreshLayout.j) r6).c(this, this.e);
        return;
    L19:
        return;
    L7:
        r0 = false;
        goto L9
    }

    public DocFeedRefreshHeader(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        this.b = b.d;
        this.c = 200;
        k(r2, r3);
    }

    public final int j(SmartRefreshLayout r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "layout");
        BearLottieView r4 = this.a;
        ImageView r5 = null;
        if (r4 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mLottieAnimationView");
        r4 = null;
    L5:
        r4.cancelAnimation();
        ImageView r6 = this.a;
        if (r6 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mLottieAnimationView");
    L9:
        r5.setVisibility(4);
        return this.c;
    L8:
        r5 = r6;
        goto L9
    }

    public final void k(Context r4, AttributeSet r5) {
        setBackgroundColor(r4.getResources().getColor(2131103546));
        TypedArray r6 = r4.obtainStyledAttributes(r5, new int[]{2130974157, 2130974179, 2130974196, 2130974199});
        this.c = r6.getInt(1, this.c);
        this.b = b.h[r6.getInt(3, this.b.a)];
        if (r6.hasValue(2) == false) goto L8;
        int r0 = r6.getColor(2, 0);
        this.e = r0;
        setBackgroundColor(r0);
        g r1 = this.d;
        if (r1 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mRefreshKernel");
        r1 = null;
    L7:
        SmartRefreshLayout.j r2 = (SmartRefreshLayout.j) r1;
        r2.c(this, this.e);
    L8:
        r6.recycle();
        this.f = n.f(r4, this.f);
        this.g = n.f(r4, this.g);
        if (getPaddingTop() != 0) goto L15;
        if (getPaddingBottom() != 0) goto L13;
        setPadding(getPaddingLeft(), this.f, getPaddingRight(), this.g);
        return;
    L13:
        setPadding(getPaddingLeft(), this.f, getPaddingRight(), this.g);
        return;
    L15:
        if (getPaddingBottom() != 0) goto L17;
        setPadding(getPaddingLeft(), this.f, getPaddingRight(), this.g);
        return;
    L17:
        this.f = getPaddingTop();
        this.g = getPaddingBottom();
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public final void onMeasure(int r5, int r6) {
        if (View.MeasureSpec.getMode(r6) != 1073741824) goto L5;
        setPadding(getPaddingLeft(), 0, getPaddingRight(), 0);
    L6:
        super.onMeasure(r5, r6);
        return;
    L5:
        setPadding(getPaddingLeft(), this.f, getPaddingRight(), this.g);
        goto L6
    }

    public DocFeedRefreshHeader(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.b = b.d;
        this.c = 200;
        k(r2, r3);
    }

    public final void g(SmartRefreshLayout.j r1, int r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "kernel");
        this.d = r1;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mRefreshKernel");
        r1 = null;
    L5:
        r1.c(this, this.e);
    }

    public final void i(h r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "layout");
        ImageView r5 = this.a;
        BearLottieView r6 = null;
        if (r5 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mLottieAnimationView");
        r5 = null;
    L5:
        r5.setVisibility(0);
        BearLottieView r7 = this.a;
        if (r7 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mLottieAnimationView");
    L9:
        r6.playAnimation();
        return;
    L8:
        r6 = r7;
        goto L9
    }
}
