package com.bytedance.android.shopping.product.flow;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.android.ec.core.widget.RoundedFrameLayout;
import com.bytedance.android.ec.model.order.ECOrderTrackerData;
import com.bytedance.android.shopping.product.flow.banner.BannerView;
import com.bytedance.android.shopping.product.flow.view.bottom.ProductFlowCardAbilityBarView;
import com.bytedance.android.shopping.product.flow.view.bottom.ProductFlowCardBuyButton;
import com.bytedance.android.shopping.product.flow.view.bottom.ProductFlowCardCartView;
import com.bytedance.android.shopping.product.flow.view.info.ProductFlowCardExtraInfoContainer;
import com.bytedance.android.shopping.product.flow.view.info.ProductFlowCardPriceAndSalesView;
import com.bytedance.android.shopping.product.flow.view.info.ProductFlowCardTitleView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010?\u001a\u00020>\u0012\n\b\u0002\u0010A\u001a\u0004\u0018\u00010@\u0012\b\b\u0002\u0010C\u001a\u00020B¢\u0006\u0004\bD\u0010EJ\b\u0010\u0003\u001a\u00020\u0002H\u0014R\u0017\u0010\t\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\u000f\u001a\u00020\n8\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0012\u001a\u00020\n8\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\u0010\u0010\f\u001a\u0004\b\u0011\u0010\u000eR\u001a\u0010\u0018\u001a\u00020\u00138\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u001e\u001a\u00020\u00198\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010$\u001a\u00020\u001f8\u0004X\u0084\u0004¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u001a\u0010*\u001a\u00020%8\u0004X\u0084\u0004¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u001a\u00100\u001a\u00020+8\u0004X\u0084\u0004¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R\u001a\u00106\u001a\u0002018\u0004X\u0084\u0004¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105R$\u00108\u001a\u0004\u0018\u0001078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=¨\u0006F"}, d2 = {"Lcom/bytedance/android/shopping/product/flow/ECAbsProductFlowCard;", "Lcom/bytedance/android/ec/core/widget/RoundedFrameLayout;", "Lcom/bytedance/android/ec/model/order/ECOrderTrackerData;", "getECOrderTrackerData", "Lcom/bytedance/android/shopping/product/flow/banner/BannerView;", "b", "Lcom/bytedance/android/shopping/product/flow/banner/BannerView;", "getBannerView", "()Lcom/bytedance/android/shopping/product/flow/banner/BannerView;", "bannerView", "Landroid/widget/FrameLayout;", "c", "Landroid/widget/FrameLayout;", "getProductTopActivityContainer", "()Landroid/widget/FrameLayout;", "productTopActivityContainer", "d", "getProductBottomActivityContainer", "productBottomActivityContainer", "Lcom/bytedance/android/shopping/product/flow/view/info/ProductFlowCardPriceAndSalesView;", "e", "Lcom/bytedance/android/shopping/product/flow/view/info/ProductFlowCardPriceAndSalesView;", "getPriceAndSalesView", "()Lcom/bytedance/android/shopping/product/flow/view/info/ProductFlowCardPriceAndSalesView;", "priceAndSalesView", "Lcom/bytedance/android/shopping/product/flow/view/info/ProductFlowCardTitleView;", "f", "Lcom/bytedance/android/shopping/product/flow/view/info/ProductFlowCardTitleView;", "getProductTitleView", "()Lcom/bytedance/android/shopping/product/flow/view/info/ProductFlowCardTitleView;", "productTitleView", "Lcom/bytedance/android/shopping/product/flow/view/info/ProductFlowCardExtraInfoContainer;", "g", "Lcom/bytedance/android/shopping/product/flow/view/info/ProductFlowCardExtraInfoContainer;", "getProductExtraInfoContainer", "()Lcom/bytedance/android/shopping/product/flow/view/info/ProductFlowCardExtraInfoContainer;", "productExtraInfoContainer", "Lcom/bytedance/android/shopping/product/flow/view/bottom/ProductFlowCardAbilityBarView;", "h", "Lcom/bytedance/android/shopping/product/flow/view/bottom/ProductFlowCardAbilityBarView;", "getAbilityBarView", "()Lcom/bytedance/android/shopping/product/flow/view/bottom/ProductFlowCardAbilityBarView;", "abilityBarView", "Lcom/bytedance/android/shopping/product/flow/view/bottom/ProductFlowCardCartView;", "i", "Lcom/bytedance/android/shopping/product/flow/view/bottom/ProductFlowCardCartView;", "getCartView", "()Lcom/bytedance/android/shopping/product/flow/view/bottom/ProductFlowCardCartView;", "cartView", "Lcom/bytedance/android/shopping/product/flow/view/bottom/ProductFlowCardBuyButton;", "j", "Lcom/bytedance/android/shopping/product/flow/view/bottom/ProductFlowCardBuyButton;", "getBuyButton", "()Lcom/bytedance/android/shopping/product/flow/view/bottom/ProductFlowCardBuyButton;", "buyButton", "Lcom/bytedance/android/shopping/product/flow/c;", "interactionHelper", "Lcom/bytedance/android/shopping/product/flow/c;", "getInteractionHelper", "()Lcom/bytedance/android/shopping/product/flow/c;", "setInteractionHelper", "(Lcom/bytedance/android/shopping/product/flow/c;)V", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class ECAbsProductFlowCard extends RoundedFrameLayout {
    public final BannerView b;
    public final FrameLayout c;
    public final FrameLayout d;
    public final ProductFlowCardPriceAndSalesView e;
    public final ProductFlowCardTitleView f;
    public final ProductFlowCardExtraInfoContainer g;
    public final ProductFlowCardAbilityBarView h;
    public final ProductFlowCardCartView i;
    public final ProductFlowCardBuyButton j;

    public static final class a implements yg3.d {
        public final /* synthetic */ ECAbsProductFlowCard a;

        public a(ECAbsProductFlowCard r1) {
            this.a = r1;
        }

        @Override // yg3.d
        public final void a(int r1, View r2) {
            Intrinsics.checkNotNullParameter(r2, "v");
            this.a.getInteractionHelper();
            ECAbsProductFlowCard r3 = this.a;
            r3.y(r3.getBannerView());
        }
    }

    public static final class b extends com.bytedance.android.ec.core.widget.d {
        public final /* synthetic */ ECAbsProductFlowCard g;

        public b(ECAbsProductFlowCard r2) {
            this.g = r2;
            super(null, null, 3);
        }

        public final void a(View r2) {
            Intrinsics.checkNotNullParameter(r2, "v");
            View r3 = this.g.getProductTopActivityContainer().getChildAt(0);
            if (r3 != null) goto L5;
            return;
        L5:
            this.g.getInteractionHelper();
            this.g.getClass();
            Intrinsics.checkNotNullParameter(r3, "activityView");
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ ECAbsProductFlowCard a;

        public static final class a extends com.bytedance.android.ec.core.widget.d {
            public final /* synthetic */ c g;

            public a(c r2) {
                this.g = r2;
                super(null, null, 3);
            }

            public final void a(View r2) {
                Intrinsics.checkNotNullParameter(r2, "v");
                View r3 = this.g.a.getProductTopActivityContainer().getChildAt(0);
                if (r3 != null) goto L5;
                return;
            L5:
                this.g.a.getInteractionHelper();
                this.g.a.getClass();
                Intrinsics.checkNotNullParameter(r3, "activityView");
            }
        }

        public c(ECAbsProductFlowCard r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            new a(this);
        }
    }

    public static final class d extends com.bytedance.android.ec.core.widget.d {
        public final /* synthetic */ ECAbsProductFlowCard g;

        public d(ECAbsProductFlowCard r2) {
            this.g = r2;
            super(null, null, 3);
        }

        public final void a(View r2) {
            Intrinsics.checkNotNullParameter(r2, "v");
            View r3 = this.g.getProductExtraInfoContainer().getChildAt(0);
            if (r3 != null) goto L5;
            return;
        L5:
            this.g.getInteractionHelper();
            this.g.getClass();
            Intrinsics.checkNotNullParameter(r3, "extraView");
        }
    }

    public static final class e extends com.bytedance.android.ec.core.widget.d {
        public final /* synthetic */ ECAbsProductFlowCard g;

        public e(ECAbsProductFlowCard r2) {
            this.g = r2;
            super(null, null, 3);
        }

        public final void a(View r2) {
            Intrinsics.checkNotNullParameter(r2, "v");
            this.g.getInteractionHelper();
            ECAbsProductFlowCard r3 = this.g;
            r3.D(r3.getPriceAndSalesView());
        }
    }

    public static final class f extends com.bytedance.android.ec.core.widget.d {
        public final /* synthetic */ ECAbsProductFlowCard g;

        public f(ECAbsProductFlowCard r2) {
            this.g = r2;
            super(null, null, 3);
        }

        public final void a(View r2) {
            Intrinsics.checkNotNullParameter(r2, "v");
            this.g.getInteractionHelper();
            ECAbsProductFlowCard r3 = this.g;
            r3.E(r3.getProductTitleView());
        }
    }

    public static final class g extends com.bytedance.android.ec.core.widget.d {
        public final /* synthetic */ ECAbsProductFlowCard g;

        public g(ECAbsProductFlowCard r2) {
            this.g = r2;
            super(null, null, 3);
        }

        public final void a(View r2) {
            Intrinsics.checkNotNullParameter(r2, "v");
            this.g.getInteractionHelper();
            ECAbsProductFlowCard r3 = this.g;
            r3.C(r3.getCartView());
        }
    }

    public static final class h extends com.bytedance.android.ec.core.widget.d {
        public final /* synthetic */ ECAbsProductFlowCard g;

        public h(ECAbsProductFlowCard r2) {
            this.g = r2;
            super(null, null, 3);
        }

        public final void a(View r2) {
            Intrinsics.checkNotNullParameter(r2, "v");
            this.g.getInteractionHelper();
            ECAbsProductFlowCard r3 = this.g;
            r3.B(r3.getBuyButton());
        }
    }

    public ECAbsProductFlowCard(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ECAbsProductFlowCard(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public void B(ProductFlowCardBuyButton r2) {
        Intrinsics.checkNotNullParameter(r2, "buyButton");
    }

    public void C(ProductFlowCardCartView r2) {
        Intrinsics.checkNotNullParameter(r2, "cartView");
    }

    public void D(ProductFlowCardPriceAndSalesView r2) {
        Intrinsics.checkNotNullParameter(r2, "priceAndSalesView");
    }

    public void E(ProductFlowCardTitleView r2) {
        Intrinsics.checkNotNullParameter(r2, "titleView");
    }

    public final com.bytedance.android.shopping.product.flow.c getInteractionHelper() {
        return null;
    }

    public final void setInteractionHelper(com.bytedance.android.shopping.product.flow.c r1) {
    }

    public void y(BannerView r2) {
        Intrinsics.checkNotNullParameter(r2, "bannerBannerView");
    }

    public ECOrderTrackerData getECOrderTrackerData() {
        return new ECOrderTrackerData(null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, 262143, null);
    }

    public final ProductFlowCardAbilityBarView getAbilityBarView() {
        return this.h;
    }

    public final BannerView getBannerView() {
        return this.b;
    }

    public final ProductFlowCardBuyButton getBuyButton() {
        return this.j;
    }

    public final ProductFlowCardCartView getCartView() {
        return this.i;
    }

    public final ProductFlowCardPriceAndSalesView getPriceAndSalesView() {
        return this.e;
    }

    public final FrameLayout getProductBottomActivityContainer() {
        return this.d;
    }

    public final ProductFlowCardExtraInfoContainer getProductExtraInfoContainer() {
        return this.g;
    }

    public final ProductFlowCardTitleView getProductTitleView() {
        return this.f;
    }

    public final FrameLayout getProductTopActivityContainer() {
        return this.c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2, types: [android.widget.Button, com.bytedance.android.shopping.product.flow.view.bottom.ProductFlowCardBuyButton] */
    public ECAbsProductFlowCard(Context r7, AttributeSet r8, int r9) {
        Intrinsics.checkNotNullParameter(r7, "context");
        super(r7, r8, r9);
        setRadius(com.bytedance.android.shopping.extensions.b.b(10));
        LayoutInflater.from(r7).inflate(2131560374, this);
        BannerView r10 = (BannerView) findViewById(2131370807);
        this.b = r10;
        ProductFlowCardExtraInfoContainer r11 = (ProductFlowCardExtraInfoContainer) findViewById(2131370813);
        this.g = r11;
        FrameLayout r12 = (FrameLayout) findViewById(2131370812);
        this.c = r12;
        ProductFlowCardPriceAndSalesView r0 = (ProductFlowCardPriceAndSalesView) findViewById(2131370810);
        this.e = r0;
        this.h = (ProductFlowCardAbilityBarView) findViewById(2131383159);
        ProductFlowCardCartView r1 = (ProductFlowCardCartView) findViewById(2131383163);
        this.i = r1;
        ?? r2 = (ProductFlowCardBuyButton) findViewById(2131383162);
        this.j = r2;
        ProductFlowCardTitleView r3 = (ProductFlowCardTitleView) findViewById(2131370814);
        this.f = r3;
        FrameLayout r4 = (FrameLayout) findViewById(2131370811);
        this.d = r4;
        r10.setOnItemClickListener(new a(this));
        r12.setOnClickListener(new b(this));
        r4.setOnClickListener(new c(this));
        r11.setOnClickListener(new d(this));
        r0.setOnClickListener(new e(this));
        r3.setOnClickListener(new f(this));
        r1.setOnClickListener(new g(this));
        r2.setOnClickListener(new h(this));
    }

    public /* synthetic */ ECAbsProductFlowCard(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
