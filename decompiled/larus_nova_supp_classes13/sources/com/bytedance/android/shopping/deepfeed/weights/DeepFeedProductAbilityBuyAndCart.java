package com.bytedance.android.shopping.deepfeed.weights;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.bytedance.android.ec.core.utils.d2;
import com.bytedance.android.shopping.deepfeed.weights.common.ProductTextOrImageView;
import com.bytedance.android.shopping.deepfeed.weights.common.ProductTextView;
import he3.f1;
import he3.h1;
import he3.p0;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\r\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/shopping/deepfeed/weights/DeepFeedProductAbilityBuyAndCart;", "Landroid/widget/LinearLayout;", "Lcom/bytedance/android/shopping/deepfeed/weights/common/ProductTextView;", "a", "Lcom/bytedance/android/shopping/deepfeed/weights/common/ProductTextView;", "getAbilityBuy", "()Lcom/bytedance/android/shopping/deepfeed/weights/common/ProductTextView;", "abilityBuy", "Lcom/bytedance/android/shopping/deepfeed/weights/common/ProductTextOrImageView;", "b", "Lcom/bytedance/android/shopping/deepfeed/weights/common/ProductTextOrImageView;", "getAbilityAddCart", "()Lcom/bytedance/android/shopping/deepfeed/weights/common/ProductTextOrImageView;", "abilityAddCart", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DeepFeedProductAbilityBuyAndCart extends LinearLayout {
    public final ProductTextView a;
    public final ProductTextOrImageView b;
    public final com.bytedance.android.shopping.deepfeed.ui.view.a c;

    public DeepFeedProductAbilityBuyAndCart(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public DeepFeedProductAbilityBuyAndCart(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final ProductTextOrImageView getAbilityAddCart() {
        return this.b;
    }

    public final ProductTextView getAbilityBuy() {
        return this.a;
    }

    public final void a(p0 r7, boolean r8) {
        Intrinsics.checkNotNullParameter(r7, "product");
        h1 r0 = r7.d();
        if (r0 == null) goto L5;
        Boolean r1 = r0.b();
    L6:
        boolean r2 = Intrinsics.areEqual(r1, Boolean.TRUE);
        h1 r9 = r7.d();
        if (r9 == null) goto L11;
        f1 r10 = r9.a();
        if (r10 == null) goto L11;
        String r11 = r10.a();
    L13:
        if (tc3.f.a() == false) goto L17;
        ProductTextView r3 = this.a;
        com.bytedance.android.shopping.deepfeed.ui.view.a r4 = com.bytedance.android.shopping.deepfeed.ui.view.a.e;
        r3.setTextSize(0, com.bytedance.android.shopping.deepfeed.ui.view.a.C0061a.a(getContext(), 16));
    L17:
        if (r2 == false) goto L39;
        if (r11 != null) goto L20;
    L23:
        boolean r12 = true;
    L24:
        if (r12 == true) goto L39;
        this.b.setVisibility(0);
        if (tc3.f.a() == false) goto L29;
        this.b.R5(null, 2131248101);
        ViewGroup.LayoutParams r13 = this.b.getLayoutParams();
        com.bytedance.android.shopping.deepfeed.ui.view.a r5 = com.bytedance.android.shopping.deepfeed.ui.view.a.e;
        r13.width = com.bytedance.android.shopping.deepfeed.ui.view.a.C0061a.a(getContext(), 80);
        this.b.getLayoutParams().height = com.bytedance.android.shopping.deepfeed.ui.view.a.C0061a.a(getContext(), 38);
        this.a.getLayoutParams().width = com.bytedance.android.shopping.deepfeed.ui.view.a.C0061a.a(getContext(), 132);
        this.a.getLayoutParams().height = com.bytedance.android.shopping.deepfeed.ui.view.a.C0061a.a(getContext(), 38);
    L30:
        if (r8 == false) goto L36;
        if (tc3.f.a() == false) goto L34;
        this.a.setBackgroundResource(2131247860);
    L47:
        Integer r14 = tc3.f.c();
        if (r14 != null) goto L51;
        return;
    L51:
        if (r14.intValue() != 1) goto L54;
        d2.d(this, 0, com.bytedance.android.shopping.deepfeed.ui.view.a.C0061a.a(getContext(), 14), 0, 0);
        return;
    L54:
        return;
    L34:
        this.a.setBackgroundResource(2131247858);
        goto L47
    L36:
        if (tc3.f.a() == false) goto L38;
        this.a.setBackgroundResource(2131247867);
        goto L47
    L38:
        this.a.setBackgroundResource(2131247866);
        goto L47
    L29:
        this.b.R5("加入购物车", null);
        ViewGroup.LayoutParams r15 = this.b.getLayoutParams();
        com.bytedance.android.shopping.deepfeed.ui.view.a r6 = com.bytedance.android.shopping.deepfeed.ui.view.a.e;
        r15.width = com.bytedance.android.shopping.deepfeed.ui.view.a.C0061a.a(getContext(), 117);
        this.a.getLayoutParams().width = com.bytedance.android.shopping.deepfeed.ui.view.a.C0061a.a(getContext(), 108);
        goto L30
    L20:
        if (r11.length() == 0) goto L23;
        r12 = false;
    L39:
        this.b.setVisibility(8);
        if (r8 == false) goto L42;
        this.a.setBackgroundResource(2131247859);
    L44:
        if (tc3.f.a() == false) goto L46;
        ViewGroup.LayoutParams r16 = this.a.getLayoutParams();
        com.bytedance.android.shopping.deepfeed.ui.view.a r17 = com.bytedance.android.shopping.deepfeed.ui.view.a.e;
        r16.width = com.bytedance.android.shopping.deepfeed.ui.view.a.C0061a.a(getContext(), 212);
        this.a.getLayoutParams().height = com.bytedance.android.shopping.deepfeed.ui.view.a.C0061a.a(getContext(), 38);
        goto L47
    L46:
        ViewGroup.LayoutParams r18 = this.a.getLayoutParams();
        com.bytedance.android.shopping.deepfeed.ui.view.a r19 = com.bytedance.android.shopping.deepfeed.ui.view.a.e;
        r18.width = com.bytedance.android.shopping.deepfeed.ui.view.a.C0061a.a(getContext(), 225);
        goto L47
    L42:
        this.a.setBackgroundResource(2131247868);
    L11:
        r11 = null;
        goto L13
    L5:
        r1 = null;
        goto L6
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r2, int r3) {
        com.bytedance.android.shopping.deepfeed.ui.view.a r0 = this.c;
        if (r0 == null) goto L5;
        Pair<Integer, Integer> r1 = r0.b(r2, r3);
    L6:
        if (r1 == null) goto L8;
        super.onMeasure(((Number) r1.getFirst()).intValue(), ((Number) r1.getSecond()).intValue());
        return;
    L8:
        super.onMeasure(r2, r3);
        return;
    L5:
        r1 = null;
        goto L6
    }

    public DeepFeedProductAbilityBuyAndCart(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.c = com.bytedance.android.shopping.deepfeed.ui.view.a.e;
        LinearLayout.inflate(r2, 2131564638, this);
        this.b = (ProductTextOrImageView) findViewById(2131375253);
        ProductTextView r5 = (ProductTextView) findViewById(2131375251);
        this.a = r5;
        r5.setTextSize(0, com.bytedance.android.shopping.deepfeed.ui.view.a.C0061a.a(r2, 13));
    }

    public /* synthetic */ DeepFeedProductAbilityBuyAndCart(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
