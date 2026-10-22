package com.bytedance.android.shopping.deepfeed.weights.common;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import tc3.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/deepfeed/weights/common/ProductPriceView;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ProductPriceView extends LinearLayout {
    public final ProductTextView a;
    public final ProductTextView b;
    public final ProductTextView c;

    public ProductPriceView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ProductPriceView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v1, types: [android.view.View, android.widget.TextView, androidx.appcompat.widget.AppCompatTextView, com.bytedance.android.shopping.deepfeed.weights.common.ProductTextView] */
    /* JADX WARN: Type inference failed for: r4v2, types: [android.view.View, android.widget.TextView, androidx.appcompat.widget.AppCompatTextView, com.bytedance.android.shopping.deepfeed.weights.common.ProductTextView] */
    /* JADX WARN: Type inference failed for: r5v2, types: [android.view.View, android.widget.TextView, androidx.appcompat.widget.AppCompatTextView, com.bytedance.android.shopping.deepfeed.weights.common.ProductTextView] */
    /* JADX WARN: Type inference failed for: r6v2, types: [android.view.View, android.widget.TextView, androidx.appcompat.widget.AppCompatTextView, com.bytedance.android.shopping.deepfeed.weights.common.ProductTextView] */
    public ProductPriceView(Context r9, AttributeSet r10, int r11) {
        Intrinsics.checkNotNullParameter(r9, "context");
        super(r9, r10, r11);
        ViewGroup.LayoutParams r12 = null;
        ?? r13 = new ProductTextView(r9, null, 6, 0);
        r13.setText("¥");
        r13.setMaxLines(1);
        r13.setTextSize(1, 14.0f);
        r13.setWeight(500);
        r13.setTextColor(ColorProtector.parseColor("#FFFF003C"));
        r13.setIncludeFontPadding(false);
        Unit r4 = Unit.INSTANCE;
        ?? r5 = new ProductTextView(r9, null, 6, 0);
        r5.setMaxLines(1);
        r5.setTextSize(1, 24.0f);
        r5.setTextColor(ColorProtector.parseColor("#FFFF003C"));
        r5.setIncludeFontPadding(false);
        this.a = r5;
        ?? r6 = new ProductTextView(r9, null, 6, 0);
        r6.setMaxLines(1);
        r6.setTextSize(1, 16.0f);
        r6.setTextColor(ColorProtector.parseColor("#FFFF003C"));
        r6.setIncludeFontPadding(false);
        this.b = r6;
        ?? r7 = new ProductTextView(r9, null, 6, 0);
        r7.setMaxLines(1);
        r7.setTextSize(1, 12.0f);
        r7.setTextColor(ColorProtector.parseColor("#FFFF003C"));
        r7.setIncludeFontPadding(false);
        this.c = r7;
        LinearLayout.LayoutParams r0 = new LinearLayout.LayoutParams(-2, -2);
        r0.gravity = 80;
        addView(r13, r0);
        LinearLayout.LayoutParams r1 = new LinearLayout.LayoutParams(-2, -2);
        r1.setMarginStart(com.bytedance.android.shopping.extensions.b.b(1));
        r1.gravity = 80;
        addView(r5, r1);
        LinearLayout.LayoutParams r2 = new LinearLayout.LayoutParams(-2, -2);
        r2.gravity = 80;
        addView(r6, r2);
        LinearLayout.LayoutParams r3 = new LinearLayout.LayoutParams(-2, -2);
        r3.leftMargin = com.bytedance.android.shopping.extensions.b.b(2);
        r3.gravity = 80;
        addView(r7, r3);
        if (f.e() == false) goto L32;
        r13.setTextSize(1, 12.0f);
        Integer r14 = f.c();
        if (r14 != null) goto L9;
    L18:
        Integer r15 = f.c();
        if (r15 != null) goto L22;
    L31:
        r5.setTypeface(Typeface.defaultFromStyle(1));
        r7.setTextSize(1, 13.0f);
        r7.setWeight(600);
        goto L32
    L22:
        if (r15.intValue() != 2) goto L31;
        r5.setTextSize(1, 22.0f);
        ViewGroup.LayoutParams r16 = r5.getLayoutParams();
        if ((r16 instanceof LinearLayout.LayoutParams) == false) goto L27;
        r12 = r16;
    L27:
        LinearLayout.LayoutParams r17 = (LinearLayout.LayoutParams) r12;
        if (r17 == null) goto L30;
        com.bytedance.android.shopping.deepfeed.ui.view.a r18 = com.bytedance.android.shopping.deepfeed.ui.view.a.e;
        r17.height = com.bytedance.android.shopping.deepfeed.ui.view.a.C0061a.a(r5.getContext(), 23);
    L30:
        r5.setLayoutParams(r17);
        goto L31
    L9:
        if (r14.intValue() != 1) goto L18;
        r5.setTextSize(1, 28.0f);
        ViewGroup.LayoutParams r19 = r5.getLayoutParams();
        if ((r19 instanceof LinearLayout.LayoutParams) == false) goto L14;
        r12 = r19;
    L14:
        LinearLayout.LayoutParams r110 = (LinearLayout.LayoutParams) r12;
        if (r110 == null) goto L17;
        com.bytedance.android.shopping.deepfeed.ui.view.a r20 = com.bytedance.android.shopping.deepfeed.ui.view.a.e;
        r110.height = com.bytedance.android.shopping.deepfeed.ui.view.a.C0061a.a(r5.getContext(), 29);
    L17:
        r5.setLayoutParams(r110);
    L32:
        setVisibility(8);
    }

    public /* synthetic */ ProductPriceView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
