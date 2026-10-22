package com.bytedance.android.livesdk.livecommerce.room.widgets.floatwindow.pannel.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import com.bytedance.android.livesdk.livecommerce.room.widgets.floatwindow.pannel.utils.PagerSnapScrollListener;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.ui.base.widget.round.BackgroundDrawable;
import com.bytedance.android.ui.base.widget.round.RoundView;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u0013\b\u0016\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\f\u0010\rB\u001d\b\u0016\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\f\u0010\u0010B%\b\u0016\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\u0006\u0010\u0011\u001a\u00020\u0003¢\u0006\u0004\b\f\u0010\u0012J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u000e\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/room/widgets/floatwindow/pannel/view/ECCarouselIndicatorView;", "Landroid/widget/LinearLayout;", "Lcom/bytedance/android/livesdk/livecommerce/room/widgets/floatwindow/pannel/utils/PagerSnapScrollListener$a;", "", "position", "", "setSelected", "", "unSelectedDotAlpha", "setUnSelectDotAlpha", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECCarouselIndicatorView extends LinearLayout implements PagerSnapScrollListener.a {
    public final FastOutSlowInInterpolator a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public float f;
    public final int g;
    public int h;

    public ECCarouselIndicatorView(Context r2) {
        super(r2);
        setGravity(17);
        this.a = new FastOutSlowInInterpolator();
        this.b = UtilityKotlinExtentionsKt.d(4);
        this.c = UtilityKotlinExtentionsKt.d(12);
        this.d = UtilityKotlinExtentionsKt.d(4);
        this.e = -1;
        this.f = 0.8f;
        this.g = 253106211;
    }

    private final void setSelected(int r5) {
        if (getChildCount() != 0) goto L5;
        return;
    L5:
        this.h = r5;
        int r6 = getChildCount();
        int r0 = 0;
        int r1 = 0;
    L6:
        if (r1 >= r6) goto L12;
        View r2 = getChildAt(r1);
        if (this.h != r1) goto L10;
        boolean r3 = true;
    L11:
        e(r2, r3);
        r1 = r1 + 1;
        goto L6
    L10:
        r3 = false;
        goto L11
    L12:
        int r7 = getChildCount();
    L13:
        if (r0 >= r7) goto L15;
        f(getChildAt(r0), r0);
        r0 = r0 + 1;
        goto L13
    L15:
        invalidate();
    }

    public final void c(int r5) {
        if (r5 != getChildCount()) goto L5;
        return;
    L5:
        removeAllViews();
        int r1 = 0;
    L6:
        if (r1 >= r5) goto L12;
        RoundView r2 = new RoundView(getContext());
        if (this.h != r1) goto L10;
        boolean r3 = true;
    L11:
        e(r2, r3);
        f(r2, r1);
        addView(r2);
        r1 = r1 + 1;
        goto L6
    L10:
        r3 = false;
        goto L11
    L12:
        setSelected(this.h);
    }

    public final int d(float r5) {
        return Color.argb((int) Math.floor(((double) r5) * ((double) 255)), Color.red(this.e), Color.green(this.e), Color.blue(this.e));
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.floatwindow.pannel.utils.PagerSnapScrollListener.a
    public final void onPageScrollStateChanged(int r1) {
        if (r1 != 0) goto L5;
        setSelected(this.h);
        return;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.floatwindow.pannel.utils.PagerSnapScrollListener.a
    public final void onPageSelected(int r1) {
        setSelected(r1);
    }

    public final void setUnSelectDotAlpha(float r5) {
        this.f = r5;
        int r6 = getChildCount();
        int r1 = 0;
    L3:
        if (r1 >= r6) goto L9;
        View r2 = getChildAt(r1);
        if (this.h != r1) goto L7;
        boolean r3 = true;
    L8:
        e(r2, r3);
        r1 = r1 + 1;
        goto L3
    L7:
        r3 = false;
        goto L8
    }

    public ECCarouselIndicatorView(Context r1, AttributeSet r2) {
        super(r1, r2);
        setGravity(17);
        this.a = new FastOutSlowInInterpolator();
        this.b = UtilityKotlinExtentionsKt.d(4);
        this.c = UtilityKotlinExtentionsKt.d(12);
        this.d = UtilityKotlinExtentionsKt.d(4);
        this.e = -1;
        this.f = 0.8f;
        this.g = 253106211;
    }

    public static final /* synthetic */ void b(ECCarouselIndicatorView r0, int r1) {
        r0.setSelected(r1);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.floatwindow.pannel.utils.PagerSnapScrollListener.a
    public final void a(int r14, float r15) {
        if (r15 != 0.0f) goto L5;
        return;
    L5:
        if (getChildCount() == 0) goto L23;
        float r16 = this.a.getInterpolation(r15);
        View r1 = getChildAt(r14);
        int r6 = r14 + 1;
        View r8 = getChildAt(r6);
        if (r1 == null) goto L10;
        int r0 = this.c;
        int r3 = this.b;
        float r5 = ((this.f - 1.0f) * r16) + 1.0f;
        g(r1, (int) (r0 + ((r3 - r0) * r16)), r3, this.d, r5);
    L10:
        if (r8 == null) goto L12;
        int r10 = this.b;
        float r2 = r10 + ((this.c - r10) * r16);
        float r4 = this.f;
        g(r8, (int) r2, r10, this.d, ((1.0f - r4) * r16) + r4);
    L12:
        int r17 = getChildCount();
        int r7 = 0;
    L13:
        if (r7 >= r17) goto L24;
        if (r7 == r14) goto L17;
        if (r7 == r6) goto L17;
        View r9 = getChildAt(r7);
        int r11 = this.b;
        g(r9, r11, r11, this.d, this.f);
    L17:
        r7 = r7 + 1;
        goto L13
    L24:
        return;
    }

    public final void e(View r5, boolean r6) {
        BackgroundDrawable r1 = null;
        if ((r5 instanceof RoundView) == true) goto L5;
        r5 = null;
    L5:
        RoundView r7 = (RoundView) r5;
        if (r7 != null) goto L8;
        return;
    L8:
        if (r6 == false) goto L10;
        float r8 = 1.0f;
    L11:
        int r9 = d(r8);
        Lazy r0 = UtilityKotlinExtentionsKt.a;
        Intrinsics.checkNotNullParameter(r7, "$this$setBgColor");
        Drawable r2 = r7.getBackground();
        if ((r2 instanceof BackgroundDrawable) == true) goto L14;
        r2 = null;
    L14:
        BackgroundDrawable r3 = (BackgroundDrawable) r2;
        if (r3 == null) goto L17;
        r3.setBgColor(r9);
    L17:
        int r10 = this.g;
        Intrinsics.checkNotNullParameter(r7, "$this$setStrokeColor");
        Drawable r4 = r7.getBackground();
        if ((r4 instanceof BackgroundDrawable) == true) goto L20;
        r4 = null;
    L20:
        BackgroundDrawable r11 = (BackgroundDrawable) r4;
        if (r11 == null) goto L23;
        r11.setStrokeColor(r10);
    L23:
        int r12 = UtilityKotlinExtentionsKt.d(Double.valueOf(0.5d));
        Intrinsics.checkNotNullParameter(r7, "$this$setStrokeWidth");
        Drawable r13 = r7.getBackground();
        if ((r13 instanceof BackgroundDrawable) == true) goto L26;
        r13 = null;
    L26:
        BackgroundDrawable r14 = (BackgroundDrawable) r13;
        if (r14 == null) goto L29;
        r14.setStrokeWidth(r12);
    L29:
        Intrinsics.checkNotNullParameter(r7, "$this$makeDrawable");
        BackgroundDrawable r15 = r7.getBackground();
        if ((r15 instanceof BackgroundDrawable) == false) goto L33;
        r1 = r15;
    L33:
        BackgroundDrawable r16 = r1;
        if (r16 == null) goto L37;
        r16.invalidate();
        return;
    L37:
        return;
    L10:
        r8 = this.f;
        goto L11
    }

    public final void f(View r7, int r8) {
        if ((r7 instanceof RoundView) == true) goto L5;
        r7 = null;
    L5:
        RoundView r1 = (RoundView) r7;
        if (r1 != null) goto L8;
        return;
    L8:
        int r9 = this.h;
        boolean r0 = true;
        if (r9 != r8) goto L11;
        boolean r3 = true;
    L12:
        if (r3 == false) goto L14;
        int r4 = this.c;
    L15:
        int r5 = this.b;
        int r6 = this.d;
        if (r9 == r8) goto L19;
        r0 = false;
    L19:
        if (r0 == false) goto L21;
        float r10 = 1.0f;
    L22:
        g(r1, r4, r5, r6, r10);
        return;
    L21:
        r10 = this.f;
        goto L22
    L14:
        r4 = this.b;
        goto L15
    L11:
        r3 = false;
        goto L12
    }

    public ECCarouselIndicatorView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        setGravity(17);
        this.a = new FastOutSlowInInterpolator();
        this.b = UtilityKotlinExtentionsKt.d(4);
        this.c = UtilityKotlinExtentionsKt.d(12);
        this.d = UtilityKotlinExtentionsKt.d(4);
        this.e = -1;
        this.f = 0.8f;
        this.g = 253106211;
    }

    public final void g(View r5, int r6, int r7, int r8, float r9) {
        Drawable r1 = null;
        if ((r5 instanceof RoundView) == true) goto L5;
        r5 = null;
    L5:
        RoundView r10 = (RoundView) r5;
        if (r10 != null) goto L8;
        return;
    L8:
        float r0 = r7;
        Lazy r2 = UtilityKotlinExtentionsKt.a;
        Intrinsics.checkNotNullParameter(r10, "$this$setCornerRadius");
        Drawable r3 = r10.getBackground();
        if ((r3 instanceof BackgroundDrawable) == true) goto L11;
        r3 = null;
    L11:
        BackgroundDrawable r4 = (BackgroundDrawable) r3;
        if (r4 == null) goto L14;
        r4.setCornerRadius(r0);
    L14:
        Intrinsics.checkNotNullParameter(r10, "$this$makeDrawable");
        Drawable r11 = r10.getBackground();
        if ((r11 instanceof BackgroundDrawable) == true) goto L17;
        r11 = null;
    L17:
        BackgroundDrawable r12 = (BackgroundDrawable) r11;
        if (r12 == null) goto L20;
        r12.invalidate();
    L20:
        ViewGroup.LayoutParams r13 = r10.getLayoutParams();
        if (r13 == null) goto L26;
        r13.width = r6;
        r13.height = r7;
        if ((r13 instanceof ViewGroup.MarginLayoutParams) == false) goto L25;
        ((ViewGroup.MarginLayoutParams) r13).setMarginStart(r8);
    L25:
        requestLayout();
    L27:
        int r14 = d(r9);
        Intrinsics.checkNotNullParameter(r10, "$this$setBgColor");
        Drawable r15 = r10.getBackground();
        if ((r15 instanceof BackgroundDrawable) == false) goto L31;
        r1 = r15;
    L31:
        BackgroundDrawable r16 = (BackgroundDrawable) r1;
        if (r16 == null) goto L35;
        r16.setBgColor(r14);
        return;
    L35:
        return;
    L26:
        LinearLayout.LayoutParams r17 = new LinearLayout.LayoutParams(r6, r7);
        r17.setMarginStart(r8);
        Unit r18 = Unit.INSTANCE;
        r10.setLayoutParams(r17);
        goto L27
    }
}
