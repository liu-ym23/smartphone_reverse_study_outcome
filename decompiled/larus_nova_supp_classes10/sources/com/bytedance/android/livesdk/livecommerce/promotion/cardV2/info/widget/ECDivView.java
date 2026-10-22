package com.bytedance.android.livesdk.livecommerce.promotion.cardV2.info.widget;

import android.content.Context;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.ec.core.utils.c0;
import com.bytedance.android.ec.core.widget.VerticalDashLineView;
import com.bytedance.android.ec.model.DivLinePattern;
import com.bytedance.android.ec.model.DivLineStyle;
import com.bytedance.android.ec.model.PromotionBenefitLabel;
import com.bytedance.android.ec.model.TextPattern;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0005B'\b\u0007\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\u0006\u0010\u0003\u001a\u00020\u0002R\u001b\u0010\t\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000e\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/promotion/cardV2/info/widget/ECDivView;", "Landroid/widget/FrameLayout;", "", "getViewWidth", "Lcom/bytedance/android/ec/core/widget/VerticalDashLineView;", "a", "Lkotlin/Lazy;", "getDivLineView", "()Lcom/bytedance/android/ec/core/widget/VerticalDashLineView;", "divLineView", "Landroid/widget/TextView;", "b", "getDivTextView", "()Landroid/widget/TextView;", "divTextView", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECDivView extends FrameLayout {
    public final Lazy a;
    public final Lazy b;

    public static final class a {
    }

    static {
    }

    public ECDivView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ECDivView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    private final VerticalDashLineView getDivLineView() {
        return (VerticalDashLineView) this.a.getValue();
    }

    private final TextView getDivTextView() {
        return (TextView) this.b.getValue();
    }

    public final float getViewWidth() {
        View r0 = getChildAt(0);
        if ((r0 instanceof VerticalDashLineView) == false) goto L6;
        return UtilityKotlinExtentionsKt.c(2);
    L6:
        if ((r0 instanceof TextView) == true) goto L22;
        return 0.0f;
    L22:
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L14
        ((TextView) r0).getPaddingLeft();     // Catch: Throwable -> L14
        ((TextView) r0).getPaddingRight();     // Catch: Throwable -> L14
        TextPaint r2 = getDivTextView().getPaint();     // Catch: Throwable -> L14
        CharSequence r3 = getDivTextView().getText();     // Catch: Throwable -> L14
        if (r3 == null) goto L11;
        String r4 = r3.toString();     // Catch: Throwable -> L14
        if (r4 == null) goto L11;
    L12:
        Object r5 = Result.constructor-impl(Float.valueOf(r2.measureText(r4)));     // Catch: Throwable -> L14
    L16:
        Float r6 = Float.valueOf(0.0f);
        if (Result.isFailure-impl(r5) == false) goto L25;
        r5 = r6;
    L25:
        return ((Number) r5).floatValue();
    L11:
        r4 = "";
    L14:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L16
    }

    public final void a(PromotionBenefitLabel r9) {
        Intrinsics.checkNotNullParameter(r9, "label");
        DivLinePattern r0 = r9.getDivLinePattern();
        int r1 = 0;
        View r2 = getChildAt(0);
        if (r0 == null) goto L5;
        boolean r5 = true;
        if (r0.getStyle() != DivLineStyle.CHARACTER_LINE.getStyle()) goto L28;
        if ((r2 instanceof TextView) == true) goto L13;
        removeAllViews();
        addView(getDivTextView());
    L13:
        TextView r10 = getDivTextView();
        String r3 = r0.getDivLineCharacter();
        if (r3 != null) goto L17;
        r3 = "";
    L17:
        r10.setText(r3);
        Integer r4 = r0.getDivLineFontSize();
        if (r4 == null) goto L20;
        r10.setTextSize(1, r4.intValue());
    L20:
        int r6 = com.bytedance.android.ec.core.utils.s.a;
        Integer r7 = com.bytedance.android.ec.core.utils.s.b(r0.getDivLineColor());
        if (r7 == null) goto L23;
        r10.setTextColor(r7.intValue());
    L23:
        Integer r8 = r0.getDivLineFontWeight();
        if (r8 == null) goto L26;
        c0.b(r10, r8.intValue());
    L26:
        r10.setPadding(UtilityKotlinExtentionsKt.d(Integer.valueOf(r0.getDivLinePadding())), 0, UtilityKotlinExtentionsKt.d(Integer.valueOf(r0.getDivLinePadding())), 0);
        return;
    L28:
        if ((r2 instanceof VerticalDashLineView) == true) goto L30;
        removeAllViews();
        addView(getDivLineView());
    L30:
        VerticalDashLineView r11 = getDivLineView();
        if (r0.getStyle() == 1) goto L34;
        r5 = false;
    L34:
        float r12 = 0.0f;
        if (r5 == false) goto L37;
        float r13 = UtilityKotlinExtentionsKt.c(Double.valueOf(0.5d));
    L38:
        if (r5 == false) goto L40;
        r12 = UtilityKotlinExtentionsKt.c(Double.valueOf(0.5d));
    L40:
        float r14 = 2;
        r11.a(2.0f, r13, r12, (UtilityKotlinExtentionsKt.c(Double.valueOf(0.5d)) / r14) + r14);
        int r15 = com.bytedance.android.ec.core.utils.s.a;
        Integer r16 = com.bytedance.android.ec.core.utils.s.b(r0.getDivLineColor());
        if (r16 == null) goto L45;
        int r17 = r16.intValue();
        r11.setDashLineColor(r17);
        if (r17 != 0) goto L45;
        getDivLineView().setVisibility(8);
    L45:
        int r18 = r0.getDivLineHeight();
        TextPattern r19 = r9.getTextPattern();
        if (r19 != null) goto L48;
    L50:
        getLayoutParams().height = UtilityKotlinExtentionsKt.d(Integer.valueOf(r0.getDivLineHeight())) - r1;
        requestLayout();
        return;
    L48:
        if (r18 != r19.getHeight()) goto L50;
        r1 = 4;
        goto L50
    L37:
        r13 = 0.0f;
        goto L38
    L5:
        if ((r2 instanceof VerticalDashLineView) == true) goto L52;
        removeAllViews();
        addView(getDivLineView());
        return;
    }

    public ECDivView(final Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = LazyKt.lazy(new ECDivView$divLineView$2(r2));
        this.b = LazyKt.lazy(new ECDivView$divTextView$2(r2));
    }

    public /* synthetic */ ECDivView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
