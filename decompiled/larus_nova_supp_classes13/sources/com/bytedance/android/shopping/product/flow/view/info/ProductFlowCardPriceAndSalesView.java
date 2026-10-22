package com.bytedance.android.shopping.product.flow.view.info;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncCacheInflater;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.core.utils.g1;
import com.bytedance.android.ec.model.PromotionDepositPresaleActivity;
import com.bytedance.android.ec.model.PromotionDiscountPrice;
import com.bytedance.android.ec.model.n;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductBaseStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPriceStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductStruct;
import com.bytedance.android.ec.model.response.anchorv3.SalesInfoStruct;
import com.bytedance.android.ec.model.response.anchorv3.SpecDetail;
import com.bytedance.android.shopping.anchorv3.activities.vo.ActivityVO;
import com.bytedance.android.shopping.extensions.f;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.android.shopping.utils.k0;
import d63.j;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u000fB'\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\f\u001a\u00020\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/shopping/product/flow/view/info/ProductFlowCardPriceAndSalesView;", "Landroid/widget/FrameLayout;", "", "style", "", "setStyle", "marginLeft", "setSalesMarginLeft", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ProductFlowCardPriceAndSalesView extends FrameLayout {
    public final ViewGroup a;
    public final TextView b;
    public ProductFlowCardPrefixActivityIconPriceView c;
    public ProductFlowCardDiscountOrMarketPriceView d;
    public Integer e;

    public static final class a {
    }

    static {
    }

    public ProductFlowCardPriceAndSalesView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ProductFlowCardPriceAndSalesView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final void a(PromotionProductStruct r21) {
        Intrinsics.checkNotNullParameter(r21, "promotionProductStruct");
        Integer r3 = this.e;
        Unit r9 = null;
        if (r3 != null) goto L6;
    L36:
        if (r3 != null) goto L39;
    L66:
        PromotionProductBaseStruct r2 = r21.getBaseInfo();
        if (r2 == null) goto L69;
        SalesInfoStruct r4 = r2.getSalesInfo();
    L70:
        if (r4 == null) goto L79;
        String r5 = r4.getText();
        if (r5 == null) goto L79;
        if (k.c(r5) == true) goto L77;
        r5 = null;
    L77:
        if (r5 == null) goto L79;
        this.b.setText(r5);
        this.b.setVisibility(0);
        r9 = Unit.INSTANCE;
    L92:
        if (r9 != null) goto L95;
        this.b.setVisibility(8);
        Unit r1 = Unit.INSTANCE;
        return;
    L95:
        return;
    L79:
        PromotionProductBaseStruct r6 = r21.getBaseInfo();
        if (r6 == null) goto L92;
        Long r7 = r6.getSales();
        if (r7 == null) goto L92;
        if (r7.longValue() <= 0) goto L86;
        boolean r8 = true;
    L87:
        if (r8 == true) goto L90;
        r7 = null;
    L90:
        if (r7 == null) goto L92;
        this.b.setText(th.a.h(getContext(), 2131913958, new Object[]{k0.a(r7.longValue())}));
        this.b.setVisibility(0);
        r9 = Unit.INSTANCE;
        goto L92
    L86:
        r8 = false;
        goto L87
    L69:
        r4 = null;
        goto L70
    L39:
        if (r3.intValue() != 1) goto L66;
        ProductFlowCardPrefixActivityIconPriceView r10 = this.c;
        if (r10 == null) goto L66;
        Intrinsics.checkNotNullParameter(r21, "promotionProductStruct");
        r10.e = r21;
        r10.h = d63.k.a(r21);
        ActivityVO r11 = f53.a.c(r21);
        r10.g = r11;
        PromotionProductPriceStruct r12 = r21.getProductPrice();
        if (r12 == null) goto L48;
        PromotionDiscountPrice r13 = r12.getDiscountPrice();
        if (r13 == null) goto L48;
        String r14 = r13.getHeader();
        if (r14 == null) goto L48;
    L53:
        if (cg4.a.a(r14) == false) goto L55;
        r10.a.setVisibility(0);
        r10.a.setText(r14);
    L57:
        if (r11.getActivityType() != 8) goto L65;
        PromotionDepositPresaleActivity r15 = r11.getDepositPresaleActivity();
        if (r15 == null) goto L65;
        if (n.b(r15) != true) goto L65;
        if (a53.a.a() != 1) goto L65;
        TextView r16 = r10.a;
        int r17 = g1.a;
        r16.setTextColor(g1.a.a(r10.getContext(), 2131101767));
        r10.a.setBackgroundResource(2131234596);
    L65:
        r21.setActivityLabel(r14);
        r10.a();
        goto L66
    L55:
        r10.a.setVisibility(8);
    L48:
        PromotionProductPriceStruct r18 = r21.getProductPrice();
        if (r18 == null) goto L51;
        r14 = r18.getHeader();
        goto L53
    L51:
        r14 = null;
        goto L53
    L6:
        if (r3.intValue() != 0) goto L36;
        ProductFlowCardDiscountOrMarketPriceView r19 = this.d;
        if (r19 == null) goto L66;
        Intrinsics.checkNotNullParameter(r21, "promotionProductStruct");
        r19.g = d63.k.a(r21);
        r19.h = f53.a.c(r21);
        j r20 = r19.g;
        if (r20 == null) goto L14;
        Long r22 = r20.c;
        if (r22 == null) goto L14;
        long r110 = r22.longValue();
    L15:
        j r23 = r19.g;
        if (r23 == null) goto L20;
        Long r24 = r23.d;
        if (r24 == null) goto L20;
        long r111 = r24.longValue();
    L21:
        j r25 = r19.g;
        if (r25 == null) goto L26;
        Long r26 = r25.e;
        if (r26 == null) goto L26;
        long r112 = r26.longValue();
    L27:
        j r27 = r19.g;
        if (r27 == null) goto L34;
        PromotionDiscountPrice r28 = r27.q;
        if (r28 == null) goto L34;
        Long r29 = r28.getMinPrice();
        if (r29 == null) goto L34;
        long r113 = r29.longValue();
    L35:
        r19.a(r110, r111, r113, r112);
    L34:
        r113 = 0;
    L26:
        r112 = 0;
    L20:
        r111 = 0;
    L14:
        r110 = 0;
        goto L15
    }

    public final void b(SpecDetail r15) {
        Integer r0 = this.e;
        long r1 = 0;
        if (r0 != null) goto L6;
    L60:
        if (r0 != null) goto L63;
        return;
    L63:
        if (r0.intValue() != 1) goto L91;
        ProductFlowCardPrefixActivityIconPriceView r2 = this.c;
        if (r2 == null) goto L92;
        if (r15 == null) goto L86;
        Long r3 = r15.getEffectivePrice();
        if (r3 == null) goto L70;
        long r4 = r3.longValue();
    L72:
        if (r4 <= 0) goto L86;
        Long r5 = r15.getMarketPrice();
        if (r5 == null) goto L77;
        long r11 = r5.longValue();
    L78:
        Long r6 = r15.getEffectivePrice();
        if (r6 == null) goto L81;
        long r7 = r6.longValue();
    L82:
        Long r16 = r15.getDiscountPrice();
        if (r16 == null) goto L85;
        r1 = r16.longValue();
    L85:
        r2.b(r1, r7, 0, r11);
        r2.c.C(ProductFlowCardPrefixActivityIconPriceView$updateSpecPrice$1.INSTANCE);
        return;
    L81:
        r7 = 0;
        goto L82
    L77:
        r11 = 0;
        goto L78
    L70:
        r4 = 0;
    L86:
        r2.a();
        return;
    L92:
        return;
    L91:
        return;
    L6:
        if (r0.intValue() != 0) goto L60;
        ProductFlowCardDiscountOrMarketPriceView r8 = this.d;
        if (r8 == null) goto L88;
        j r9 = r8.g;
        if (r9 == null) goto L14;
        Long r10 = r9.c;
        if (r10 == null) goto L14;
        long r12 = r10.longValue();
    L15:
        j r13 = r8.g;
        if (r13 == null) goto L20;
        Long r14 = r13.d;
        if (r14 == null) goto L20;
        long r17 = r14.longValue();
    L21:
        j r18 = r8.g;
        if (r18 == null) goto L26;
        Long r19 = r18.e;
        if (r19 == null) goto L26;
        long r20 = r19.longValue();
    L27:
        j r21 = r8.g;
        if (r21 == null) goto L34;
        PromotionDiscountPrice r22 = r21.q;
        if (r22 == null) goto L34;
        Long r23 = r22.getMinPrice();
        if (r23 == null) goto L34;
        long r24 = r23.longValue();
    L35:
        if (r15 == null) goto L39;
        Long r110 = r15.getEffectivePrice();
        if (r110 == null) goto L39;
        long r111 = r110.longValue();
    L40:
        if (r15 != null) goto L42;
    L56:
        long r112 = r20;
        long r25 = r17;
    L57:
        r8.a(r12, r25, r24, r112);
        if (r15 == null) goto L89;
        r8.a.C(ProductFlowCardDiscountOrMarketPriceView$updateSpecPrice$1.INSTANCE);
        r8.d.C(ProductFlowCardDiscountOrMarketPriceView$updateSpecPrice$2.INSTANCE);
        return;
    L89:
        return;
    L42:
        if (r111 <= 0) goto L56;
        Long r26 = r15.getEffectivePrice();
        if (r26 == null) goto L46;
        r12 = r26.longValue();
    L47:
        Long r27 = r15.getMarketPrice();
        if (r27 == null) goto L50;
        long r28 = r27.longValue();
    L51:
        Long r29 = r15.getDiscountPrice();
        if (r29 == null) goto L54;
        long r30 = r29.longValue();
    L55:
        r112 = r28;
        r24 = r30;
        r25 = 0;
        goto L57
    L54:
        r30 = 0;
        goto L55
    L50:
        r28 = 0;
        goto L51
    L46:
        r12 = 0;
    L39:
        r111 = 0;
    L34:
        r24 = 0;
    L26:
        r20 = 0;
    L20:
        r17 = 0;
    L14:
        r12 = 0;
        goto L15
    }

    public final void setSalesMarginLeft(int r5) {
        ViewGroup.LayoutParams r0 = this.b.getLayoutParams();
        if (r0 == null) goto L7;
        ViewGroup.MarginLayoutParams r1 = (ViewGroup.MarginLayoutParams) r0;
        r1.setMargins(r5, r1.topMargin, r1.rightMargin, r1.bottomMargin);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }

    public final void setStyle(int r6) {
        this.a.removeAllViews();
        this.e = Integer.valueOf(r6);
        if (r6 != 0) goto L5;
        int r7 = ProductFlowCardDiscountOrMarketPriceView.i;
        Context r8 = getContext();
        Intrinsics.checkNotNullParameter(r8, "context");
        if (ld3.b.a() == false) goto L15;
        Map r0 = ShoppingAsyncCacheInflater.d;
        ProductFlowCardDiscountOrMarketPriceView r9 = (ProductFlowCardDiscountOrMarketPriceView) ShoppingAsyncCacheInflater.a.a(r8).b("ec_product_flow_card_price_view", new com.bytedance.android.shopping.product.flow.view.info.a());
    L16:
        this.d = r9;
        f.b(this.a, r9);
        return;
    L15:
        r9 = new ProductFlowCardDiscountOrMarketPriceView(r8, null, 6, 0);
        goto L16
    L5:
        if (r6 != 1) goto L19;
        int r10 = ProductFlowCardPrefixActivityIconPriceView.i;
        Context r11 = getContext();
        Intrinsics.checkNotNullParameter(r11, "context");
        if (ld3.b.a() == false) goto L10;
        Map r1 = ShoppingAsyncCacheInflater.d;
        ProductFlowCardPrefixActivityIconPriceView r12 = (ProductFlowCardPrefixActivityIconPriceView) ShoppingAsyncCacheInflater.a.a(r11).b("ec_product_flow_card_price_and_activity_view", new b());
    L11:
        this.c = r12;
        f.b(this.a, r12);
        return;
    L10:
        r12 = new ProductFlowCardPrefixActivityIconPriceView(r11, null, 6, 0);
        goto L11
    }

    public ProductFlowCardPriceAndSalesView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        if (ld3.b.a() == false) goto L5;
        Map r5 = ShoppingAsyncCacheInflater.d;
        ShoppingAsyncCacheInflater.a.a(r2).aU(2131560807, this, true);
    L6:
        this.a = (ViewGroup) findViewById(2131383015);
        this.b = (TextView) findViewById(2131383164);
        return;
    L5:
        ShoppingAsyncInflater.e.getClass();
        ShoppingAsyncInflater.a.a(r2).aU(2131560807, this, true);
        goto L6
    }

    public /* synthetic */ ProductFlowCardPriceAndSalesView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
