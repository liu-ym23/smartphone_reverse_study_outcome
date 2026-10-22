package com.bytedance.android.shopping.mall.homepage.card.product;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.bytedance.android.ec.hybrid.list.util.c;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0013\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u001d\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0004\u0010\bB%\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0004\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/shopping/mall/homepage/card/product/ProductPriceView;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ProductPriceView extends LinearLayout {
    public int a;
    public final ProductTextView b;
    public final ProductTextView c;
    public final ProductTextView d;
    public final ProductTextView e;
    public final ProductTextView f;
    public final ProductTextView g;
    public final ProductTextView h;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [android.view.View, android.widget.TextView, com.bytedance.android.shopping.mall.homepage.card.product.ProductTextView] */
    /* JADX WARN: Type inference failed for: r2v1, types: [android.view.View, android.widget.TextView, com.bytedance.android.shopping.mall.homepage.card.product.ProductTextView] */
    /* JADX WARN: Type inference failed for: r3v1, types: [android.view.View, android.widget.TextView, com.bytedance.android.shopping.mall.homepage.card.product.ProductTextView] */
    /* JADX WARN: Type inference failed for: r4v1, types: [android.view.View, android.widget.TextView, com.bytedance.android.shopping.mall.homepage.card.product.ProductTextView] */
    /* JADX WARN: Type inference failed for: r5v1, types: [android.view.View, android.widget.TextView, com.bytedance.android.shopping.mall.homepage.card.product.ProductTextView] */
    /* JADX WARN: Type inference failed for: r6v1, types: [android.view.View, android.widget.TextView, com.bytedance.android.shopping.mall.homepage.card.product.ProductTextView] */
    /* JADX WARN: Type inference failed for: r9v1, types: [android.view.View, android.widget.TextView, com.bytedance.android.shopping.mall.homepage.card.product.ProductTextView] */
    public ProductPriceView(Context r9) {
        super(r9);
        ?? r10 = new ProductTextView(getContext());
        r10.setText("¥");
        r10.setMaxLines(1);
        Unit r1 = Unit.INSTANCE;
        this.b = r10;
        ?? r2 = new ProductTextView(getContext());
        r2.setMaxLines(1);
        this.c = r2;
        ?? r3 = new ProductTextView(getContext());
        r3.setMaxLines(1);
        this.d = r3;
        ?? r4 = new ProductTextView(getContext());
        r4.setMaxLines(1);
        this.e = r4;
        ?? r5 = new ProductTextView(getContext());
        r5.setMaxLines(1);
        this.f = r5;
        ?? r6 = new ProductTextView(getContext());
        r6.setMaxLines(1);
        this.g = r6;
        ?? r7 = new ProductTextView(getContext());
        r7.setMaxLines(1);
        this.h = r7;
        addView(r10, new LinearLayout.LayoutParams(-2, -2));
        addView(r2, new LinearLayout.LayoutParams(-2, -2));
        addView(r3, new LinearLayout.LayoutParams(-2, -2));
        addView(r4, new LinearLayout.LayoutParams(-2, -2));
        addView(r5, new LinearLayout.LayoutParams(-2, -2));
        addView(r6, new LinearLayout.LayoutParams(-2, -2));
        addView(r7, new LinearLayout.LayoutParams(-2, -2));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [android.view.View, android.widget.TextView, com.bytedance.android.shopping.mall.homepage.card.product.ProductTextView] */
    /* JADX WARN: Type inference failed for: r1v1, types: [android.view.View, android.widget.TextView, com.bytedance.android.shopping.mall.homepage.card.product.ProductTextView] */
    /* JADX WARN: Type inference failed for: r2v1, types: [android.view.View, android.widget.TextView, com.bytedance.android.shopping.mall.homepage.card.product.ProductTextView] */
    /* JADX WARN: Type inference failed for: r3v1, types: [android.view.View, android.widget.TextView, com.bytedance.android.shopping.mall.homepage.card.product.ProductTextView] */
    /* JADX WARN: Type inference failed for: r4v1, types: [android.view.View, android.widget.TextView, com.bytedance.android.shopping.mall.homepage.card.product.ProductTextView] */
    /* JADX WARN: Type inference failed for: r5v1, types: [android.view.View, android.widget.TextView, com.bytedance.android.shopping.mall.homepage.card.product.ProductTextView] */
    /* JADX WARN: Type inference failed for: r8v1, types: [android.view.View, android.widget.TextView, com.bytedance.android.shopping.mall.homepage.card.product.ProductTextView] */
    public ProductPriceView(Context r8, AttributeSet r9) {
        super(r8, r9);
        ?? r10 = new ProductTextView(getContext());
        r10.setText("¥");
        r10.setMaxLines(1);
        Unit r0 = Unit.INSTANCE;
        this.b = r10;
        ?? r1 = new ProductTextView(getContext());
        r1.setMaxLines(1);
        this.c = r1;
        ?? r2 = new ProductTextView(getContext());
        r2.setMaxLines(1);
        this.d = r2;
        ?? r3 = new ProductTextView(getContext());
        r3.setMaxLines(1);
        this.e = r3;
        ?? r4 = new ProductTextView(getContext());
        r4.setMaxLines(1);
        this.f = r4;
        ?? r5 = new ProductTextView(getContext());
        r5.setMaxLines(1);
        this.g = r5;
        ?? r6 = new ProductTextView(getContext());
        r6.setMaxLines(1);
        this.h = r6;
        addView(r10, new LinearLayout.LayoutParams(-2, -2));
        addView(r1, new LinearLayout.LayoutParams(-2, -2));
        addView(r2, new LinearLayout.LayoutParams(-2, -2));
        addView(r3, new LinearLayout.LayoutParams(-2, -2));
        addView(r4, new LinearLayout.LayoutParams(-2, -2));
        addView(r5, new LinearLayout.LayoutParams(-2, -2));
        addView(r6, new LinearLayout.LayoutParams(-2, -2));
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r3, int r4) {
        super.onMeasure(r3, r4);
        if (getChildCount() > 0) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(getChildAt(getChildCount() - 1), this.h) == true) goto L7;
        return;
    L7:
        if (this.a < 10) goto L23;
        if (this.h.getPaint().measureText(this.h.getText().toString()) <= this.h.getMeasuredWidth()) goto L24;
        int r5 = this.a - 1;
        this.a = r5;
        if (r5 < 10) goto L12;
        ProductTextView r0 = this.h;
        int r1 = c.a;
        r0.setTextSize(1, c.b(Integer.valueOf(r5), getContext()));
        goto L7
    L12:
        this.h.setVisibility(8);
        goto L7
    L24:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [android.view.View, android.widget.TextView, com.bytedance.android.shopping.mall.homepage.card.product.ProductTextView] */
    /* JADX WARN: Type inference failed for: r1v1, types: [android.view.View, android.widget.TextView, com.bytedance.android.shopping.mall.homepage.card.product.ProductTextView] */
    /* JADX WARN: Type inference failed for: r2v1, types: [android.view.View, android.widget.TextView, com.bytedance.android.shopping.mall.homepage.card.product.ProductTextView] */
    /* JADX WARN: Type inference failed for: r3v1, types: [android.view.View, android.widget.TextView, com.bytedance.android.shopping.mall.homepage.card.product.ProductTextView] */
    /* JADX WARN: Type inference failed for: r4v1, types: [android.view.View, android.widget.TextView, com.bytedance.android.shopping.mall.homepage.card.product.ProductTextView] */
    /* JADX WARN: Type inference failed for: r7v1, types: [android.view.View, android.widget.TextView, com.bytedance.android.shopping.mall.homepage.card.product.ProductTextView] */
    /* JADX WARN: Type inference failed for: r9v2, types: [android.view.View, android.widget.TextView, com.bytedance.android.shopping.mall.homepage.card.product.ProductTextView] */
    public ProductPriceView(Context r7, AttributeSet r8, int r9) {
        super(r7, r8, r9);
        ?? r10 = new ProductTextView(getContext());
        r10.setText("¥");
        r10.setMaxLines(1);
        Unit r11 = Unit.INSTANCE;
        this.b = r10;
        ?? r12 = new ProductTextView(getContext());
        r12.setMaxLines(1);
        this.c = r12;
        ?? r0 = new ProductTextView(getContext());
        r0.setMaxLines(1);
        this.d = r0;
        ?? r1 = new ProductTextView(getContext());
        r1.setMaxLines(1);
        this.e = r1;
        ?? r2 = new ProductTextView(getContext());
        r2.setMaxLines(1);
        this.f = r2;
        ?? r3 = new ProductTextView(getContext());
        r3.setMaxLines(1);
        this.g = r3;
        ?? r4 = new ProductTextView(getContext());
        r4.setMaxLines(1);
        this.h = r4;
        addView(r10, new LinearLayout.LayoutParams(-2, -2));
        addView(r12, new LinearLayout.LayoutParams(-2, -2));
        addView(r0, new LinearLayout.LayoutParams(-2, -2));
        addView(r1, new LinearLayout.LayoutParams(-2, -2));
        addView(r2, new LinearLayout.LayoutParams(-2, -2));
        addView(r3, new LinearLayout.LayoutParams(-2, -2));
        addView(r4, new LinearLayout.LayoutParams(-2, -2));
    }
}
