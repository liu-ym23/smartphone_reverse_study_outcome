package com.bytedance.android.shopping.mall.homepage.card.product;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup;
import com.bytedance.android.ec.hybrid.list.util.c;
import com.bytedance.android.shopping.api.mall.common.homepage.card.common.ProductStyle;
import com.bytedance.android.shopping.api.mall.common.homepage.card.common.Shape;
import com.bytedance.android.shopping.api.mall.common.homepage.card.common.TextBaseUIParams;
import com.bytedance.android.shopping.api.mall.common.tools.b0;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p93.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0004\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/shopping/mall/homepage/card/product/ProductTextView;", "Lcom/bytedance/android/shopping/mall/homepage/card/product/BreakLineFeedText;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public class ProductTextView extends BreakLineFeedText {
    public ProductTextView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void x(ProductStyle r8) {
        Intrinsics.checkNotNullParameter(r8, "uiParams");
        b.d.getClass();
        Intrinsics.checkNotNullParameter(this, "$this$updatePadding");
        Float r0 = r8.getPaddingLeft();
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = b.f(r0, getContext());
    L6:
        Float r3 = r8.getPaddingTop();
        if (r3 == null) goto L9;
        int r4 = b.f(r3, getContext());
    L10:
        Float r5 = r8.getPaddingRight();
        if (r5 == null) goto L13;
        int r6 = b.f(r5, getContext());
    L14:
        Float r7 = r8.getPaddingBottom();
        if (r7 == null) goto L17;
        int r9 = b.f(r7, getContext());
    L18:
        setPadding(r2, r4, r6, r9);
        ViewGroup.LayoutParams r10 = getLayoutParams();
        Context r11 = getContext();
        Intrinsics.checkNotNullParameter(r10, "$this$updateMargin");
        Intrinsics.checkNotNullParameter(r11, "context");
        if ((r10 instanceof ViewGroup.MarginLayoutParams) == true) goto L21;
        ViewGroup.LayoutParams r12 = null;
    L22:
        ViewGroup.MarginLayoutParams r13 = (ViewGroup.MarginLayoutParams) r12;
        if (r13 == null) goto L40;
        Float r14 = r8.getMarginLeft();
        if (r14 == null) goto L27;
        int r15 = b.f(r14, r11);
    L28:
        Float r16 = r8.getMarginTop();
        if (r16 == null) goto L31;
        int r17 = b.f(r16, r11);
    L32:
        Float r18 = r8.getMarginRight();
        if (r18 == null) goto L35;
        int r19 = b.f(r18, r11);
    L36:
        Float r20 = r8.getMarginBottom();
        if (r20 == null) goto L39;
        r1 = b.f(r20, r11);
    L39:
        r13.setMargins(r15, r17, r19, r1);
        goto L40
    L35:
        r19 = 0;
        goto L36
    L31:
        r17 = 0;
        goto L32
    L27:
        r15 = 0;
    L40:
        setLayoutParams(r10);
        return;
    L21:
        r12 = r10;
        goto L22
    L17:
        r9 = 0;
        goto L18
    L13:
        r6 = 0;
        goto L14
    L9:
        r4 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void y(TextBaseUIParams r3) {
        if (r3 == null) goto L16;
        String r0 = r3.getContent();
        if (r0 != null) goto L6;
    L9:
        boolean r1 = true;
    L10:
        if (r1 == true) goto L16;
        setVisibility(0);
        setText(r3.getContent());
        ProductStyle r4 = r3.getStyle();
        if (r4 == null) goto L18;
        z(r4);
        x(r4);
        return;
    L18:
        return;
    L6:
        if (r0.length() == 0) goto L9;
        r1 = false;
    L16:
        setVisibility(8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void z(ProductStyle r9) {
        Intrinsics.checkNotNullParameter(r9, "uiParams");
        Float r0 = r9.getFontSize();
        if (r0 == null) goto L5;
        float r1 = r0.floatValue();
        int r2 = c.a;
        setTextSize(1, c.b(Float.valueOf(r1), getContext()));
    L5:
        String r3 = r9.getEllipsize();
        if (r3 == null) goto L25;
        b.d.getClass();
        Intrinsics.checkNotNullParameter(r3, "$this$toEllipsize");
        switch(r3.hashCode()) {
            case -1074341483: goto L20;
            case 100571: goto L17;
            case 109757538: goto L14;
            case 839444514: goto L11;
            default: goto L22;
        };
    L22:
        TextUtils.TruncateAt r4 = null;
    L23:
        if (r4 == null) goto L25;
        setEllipsize(r4);
        goto L25
    L11:
        if (r3.equals("marquee") == false) goto L22;
        r4 = TextUtils.TruncateAt.MARQUEE;
        goto L23
    L14:
        if (r3.equals("start") == false) goto L22;
        r4 = TextUtils.TruncateAt.START;
        goto L23
    L17:
        if (r3.equals("end") == false) goto L22;
        r4 = TextUtils.TruncateAt.END;
        goto L23
    L20:
        if (r3.equals("middle") == false) goto L22;
        r4 = TextUtils.TruncateAt.MIDDLE;
    L25:
        String r5 = r9.getFontFamily();
        Integer r6 = r9.getFontWeight();
        if (r5 != null) goto L29;
        if (r6 != null) goto L29;
    L37:
        String r7 = r9.getColor();
        if (r7 == null) goto L43;
        b.d.getClass();
        Integer r8 = b.e(r7);
        if (r8 == null) goto L43;
        setTextColor(r8.intValue());
    L43:
        if (r9.getShape() == null) goto L63;
        Shape r10 = r9.getShape();
        if (r10 == null) goto L68;
        b r11 = b.d;
        String r12 = r10.getShapeColor();
        r11.getClass();
        Integer r13 = b.e(r12);
        Integer r14 = b.e(r10.getStrokeColor());
        float[] r15 = new float[4];
        List<Float> r16 = r10.getShapeRadius();
        if (r16 == null) goto L50;
        r15[0] = b0.c(Float.valueOf(b.c(r16, 0)));
        r15[1] = b0.c(Float.valueOf(b.c(r16, 1)));
        r15[2] = b0.c(Float.valueOf(b.c(r16, 2)));
        r15[3] = b0.c(Float.valueOf(b.c(r16, 3)));
    L50:
        Float r17 = r10.getStrokeWidth();
        if (r17 == null) goto L53;
        float r18 = r17.floatValue();
    L54:
        int r19 = -1;
        if (r13 == null) goto L57;
        int r20 = r13.intValue();
    L58:
        if (r14 == null) goto L60;
        r19 = r14.intValue();
    L60:
        GradientDrawable r21 = b.a(r20, r19, (int) r18, r15);
        if (r21 == null) goto L68;
        setBackground(r21);
        goto L68
    L57:
        r20 = -1;
        goto L58
    L53:
        r18 = 0.0f;
    L68:
        Integer r22 = r9.getMaxLine();
        if (r22 == null) goto L72;
        setMaxLines(r22.intValue());
        return;
    L72:
        return;
    L63:
        String r23 = r9.getBackGround();
        if (r23 == null) goto L68;
        b.d.getClass();
        Integer r24 = b.e(r23);
        if (r24 == null) goto L68;
        setBackgroundColor(r24.intValue());
    L29:
        if (r5 == null) goto L33;
        b r25 = b.d;
        Context r26 = getContext();
        r25.getClass();
        Typeface r27 = b.d(r5, r26, r6);
        if (r27 == null) goto L37;
        setTypeface(r27);
        goto L37
    L33:
        if (r6 == null) goto L37;
        int r28 = r6.intValue();
        if (Build.VERSION.SDK_INT < 28) goto L37;
        setTypeface(Typeface.create(getTypeface(), r28, getTypeface().isItalic()));
        goto L37
    }

    public ProductTextView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
    }

    public ProductTextView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
    }
}
