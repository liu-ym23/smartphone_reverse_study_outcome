package com.bytedance.android.shopping.feed.productcard.doublefeedproductcard.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.core.utils.g1;
import com.bytedance.android.ec.core.utils.k1;
import com.bytedance.android.ec.core.utils.y;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.inflowfeed.Promotion;
import com.bytedance.android.ec.model.response.anchorv3.PromotionMarketFloor;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductActivitiesStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductBaseStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductStruct;
import com.bytedance.android.shopping.anchorv3.detail.widget.InflowFeedServiceView;
import com.bytedance.android.shopping.feed.widget.SellPointView;
import com.bytedance.android.shopping.feed.widget.TinyCardPriceView;
import com.bytedance.android.shopping.product.flow.view.info.ProductFlowCardTitleView;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import rd3.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010Q\u001a\u00020P\u0012\n\b\u0002\u0010S\u001a\u0004\u0018\u00010R\u0012\b\b\u0002\u0010T\u001a\u00020\u0002¢\u0006\u0004\bU\u0010VR\u001a\u0010\u0007\u001a\u00020\u00028\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R$\u0010\u000f\u001a\u0004\u0018\u00010\b8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u0017\u001a\u0004\u0018\u00010\u00108\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u001f\u001a\u0004\u0018\u00010\u00188\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR$\u0010'\u001a\u0004\u0018\u00010 8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\"\u0010/\u001a\u00020(8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R$\u00107\u001a\u0004\u0018\u0001008\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R$\u0010?\u001a\u0004\u0018\u0001088\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R$\u0010G\u001a\u0004\u0018\u00010@8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\bA\u0010B\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\"\u0010O\u001a\u00020H8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\bI\u0010J\u001a\u0004\bK\u0010L\"\u0004\bM\u0010N¨\u0006W"}, d2 = {"Lcom/bytedance/android/shopping/feed/productcard/doublefeedproductcard/view/BaseDoubleFeedProductCardView;", "Landroid/widget/FrameLayout;", "", "a", "I", "getImageSize", "()I", "imageSize", "Landroid/view/View;", "b", "Landroid/view/View;", "getProductCardRootView", "()Landroid/view/View;", "setProductCardRootView", "(Landroid/view/View;)V", "productCardRootView", "Lcom/bytedance/android/ui/ec/widget/ecdraweeview/ECDraweeView;", "c", "Lcom/bytedance/android/ui/ec/widget/ecdraweeview/ECDraweeView;", "getProductImage", "()Lcom/bytedance/android/ui/ec/widget/ecdraweeview/ECDraweeView;", "setProductImage", "(Lcom/bytedance/android/ui/ec/widget/ecdraweeview/ECDraweeView;)V", "productImage", "Lcom/bytedance/android/shopping/product/flow/view/info/ProductFlowCardTitleView;", "d", "Lcom/bytedance/android/shopping/product/flow/view/info/ProductFlowCardTitleView;", "getProductTitle", "()Lcom/bytedance/android/shopping/product/flow/view/info/ProductFlowCardTitleView;", "setProductTitle", "(Lcom/bytedance/android/shopping/product/flow/view/info/ProductFlowCardTitleView;)V", "productTitle", "Lcom/bytedance/android/shopping/feed/widget/SellPointView;", "e", "Lcom/bytedance/android/shopping/feed/widget/SellPointView;", "getSellPointView", "()Lcom/bytedance/android/shopping/feed/widget/SellPointView;", "setSellPointView", "(Lcom/bytedance/android/shopping/feed/widget/SellPointView;)V", "sellPointView", "Lcom/bytedance/android/shopping/anchorv3/detail/widget/InflowFeedServiceView;", "f", "Lcom/bytedance/android/shopping/anchorv3/detail/widget/InflowFeedServiceView;", "getServiceView", "()Lcom/bytedance/android/shopping/anchorv3/detail/widget/InflowFeedServiceView;", "setServiceView", "(Lcom/bytedance/android/shopping/anchorv3/detail/widget/InflowFeedServiceView;)V", "serviceView", "Lcom/bytedance/android/shopping/feed/widget/TinyCardPriceView;", "g", "Lcom/bytedance/android/shopping/feed/widget/TinyCardPriceView;", "getPriceView", "()Lcom/bytedance/android/shopping/feed/widget/TinyCardPriceView;", "setPriceView", "(Lcom/bytedance/android/shopping/feed/widget/TinyCardPriceView;)V", "priceView", "Landroid/widget/TextView;", "h", "Landroid/widget/TextView;", "getBuyButtonView", "()Landroid/widget/TextView;", "setBuyButtonView", "(Landroid/widget/TextView;)V", "buyButtonView", "Lrd3/a;", "i", "Lrd3/a;", "getAnchorInflowFeedItem", "()Lrd3/a;", "setAnchorInflowFeedItem", "(Lrd3/a;)V", "anchorInflowFeedItem", "", "j", "Ljava/lang/String;", "getTestText", "()Ljava/lang/String;", "setTestText", "(Ljava/lang/String;)V", "testText", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class BaseDoubleFeedProductCardView extends FrameLayout {
    public final int a;
    public View b;
    public ECDraweeView c;
    public ProductFlowCardTitleView d;
    public SellPointView e;
    public InflowFeedServiceView f;
    public TinyCardPriceView g;
    public TextView h;
    public a i;
    public String j;

    public BaseDoubleFeedProductCardView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public BaseDoubleFeedProductCardView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final a getAnchorInflowFeedItem() {
        return this.i;
    }

    public final TextView getBuyButtonView() {
        return this.h;
    }

    public final int getImageSize() {
        return this.a;
    }

    public final TinyCardPriceView getPriceView() {
        return this.g;
    }

    public final View getProductCardRootView() {
        return this.b;
    }

    public final ECDraweeView getProductImage() {
        return this.c;
    }

    public final ProductFlowCardTitleView getProductTitle() {
        return this.d;
    }

    public final SellPointView getSellPointView() {
        return this.e;
    }

    public final InflowFeedServiceView getServiceView() {
        return this.f;
    }

    public final String getTestText() {
        return this.j;
    }

    public void a(a r6) {
        this.i = r6;
        ECUrlModel r0 = null;
        if (r6 == null) goto L13;
        Promotion r1 = r6.f();
        if (r1 == null) goto L13;
        PromotionProductStruct r2 = r1.getPromotionInfo();
        if (r2 == null) goto L13;
        PromotionProductBaseStruct r3 = r2.getBaseInfo();
        if (r3 == null) goto L13;
        List r4 = r3.getImages();
        if (r4 == null) goto L13;
        ECUrlModel r5 = (ECUrlModel) CollectionsKt.firstOrNull(r4);
    L14:
        y.a(this.c, r5);
        if (r6 == null) goto L34;
        Promotion r7 = r6.f();
        if (r7 == null) goto L34;
        PromotionProductStruct r8 = r7.getPromotionInfo();
        if (r8 == null) goto L34;
        ProductFlowCardTitleView r9 = this.d;
        if (r9 == null) goto L34;
        r9.setArrowStyleVisible(false);
        PromotionProductBaseStruct r10 = r8.getBaseInfo();
        if (r10 == null) goto L25;
        String r11 = r10.getTitle();
    L26:
        PromotionProductPrivilegesStruct r12 = r8.getPrivilegeInfo();
        if (r12 == null) goto L33;
        PromotionProductActivitiesStruct r13 = r12.getActivities();
        if (r13 == null) goto L33;
        PromotionMarketFloor r14 = r13.getPlatformTextActivity();
        if (r14 == null) goto L33;
        r0 = r14.getIcon();
    L33:
        int r15 = com.bytedance.android.shopping.anchorv3.utils.y.a;
        r9.a(r11, r0, com.bytedance.android.shopping.anchorv3.utils.y.c(r8));
        goto L34
    L25:
        r11 = null;
    L34:
        if (r6 == null) goto L44;
        SellPointView r16 = this.e;
        if (r16 == null) goto L45;
        Intrinsics.checkNotNullParameter(r6, "anchorInflowFeedItem");
        Promotion r17 = r6.f();
        if (r17 == null) goto L46;
        PromotionProductStruct r18 = r17.getPromotionInfo();
        if (r18 == null) goto L47;
        r16.a(r18);
        return;
    L47:
        return;
    L46:
        return;
    L45:
        return;
    L44:
        return;
    L13:
        r5 = null;
        goto L14
    }

    public final void setAnchorInflowFeedItem(a r1) {
        this.i = r1;
    }

    public final void setBuyButtonView(TextView r1) {
        this.h = r1;
    }

    public final void setPriceView(TinyCardPriceView r1) {
        this.g = r1;
    }

    public final void setProductCardRootView(View r1) {
        this.b = r1;
    }

    public final void setProductImage(ECDraweeView r1) {
        this.c = r1;
    }

    public final void setProductTitle(ProductFlowCardTitleView r1) {
        this.d = r1;
    }

    public final void setSellPointView(SellPointView r1) {
        this.e = r1;
    }

    public final void setServiceView(InflowFeedServiceView r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.f = r2;
    }

    public final void setTestText(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.j = r2;
    }

    public BaseDoubleFeedProductCardView(Context r5, AttributeSet r6, int r7) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r6, r7);
        int r8 = k1.m(r5);
        Resources r9 = Resources.getSystem();
        int r10 = r8 - (MathKt.roundToInt(TypedValue.applyDimension(1, 12.0f, WindowDisplayMetricsOverride.apply(r9, r9.getDisplayMetrics()))) * 2);
        Resources r11 = Resources.getSystem();
        int r12 = (r10 - MathKt.roundToInt(TypedValue.applyDimension(1, 9.0f, WindowDisplayMetricsOverride.apply(r11, r11.getDisplayMetrics())))) / 2;
        this.a = r12;
        this.j = "Nike AirJordan联帆蝉翼半透明情侣运动篮球鞋";
        ShoppingAsyncInflater.e.getClass();
        ShoppingAsyncInflater.a.a(r5).aU(2131560573, this, true);
        this.b = findViewById(2131370115);
        this.c = findViewById(2131370637);
        ProductFlowCardTitleView r13 = (ProductFlowCardTitleView) findViewById(2131370639);
        this.d = r13;
        if (r13 == null) goto L5;
        r13.setTextAndIconSizeDP(14.0f);
    L5:
        ProductFlowCardTitleView r14 = this.d;
        if (r14 == null) goto L8;
        r14.setTextStyle(false);
    L8:
        ProductFlowCardTitleView r15 = this.d;
        if (r15 == null) goto L11;
        Resources r2 = Resources.getSystem();
        r15.setLineSpacingExtra(MathKt.roundToInt(TypedValue.applyDimension(1, 1, WindowDisplayMetricsOverride.apply(r2, r2.getDisplayMetrics()))));
    L11:
        this.e = (SellPointView) findViewById(2131385890);
        InflowFeedServiceView r16 = findViewById(2131385952);
        this.f = r16;
        Resources r3 = Resources.getSystem();
        r16.setDesiredChildHeight(MathKt.roundToInt(TypedValue.applyDimension(1, 12, WindowDisplayMetricsOverride.apply(r3, r3.getDisplayMetrics()))));
        this.f.setTextSizeDP(10.0f);
        InflowFeedServiceView r17 = this.f;
        int r0 = g1.a;
        r17.setTextColor(g1.a.a(r5, 2131101176));
        this.g = (TinyCardPriceView) findViewById(2131370638);
        this.h = (TextView) findViewById(2131370114);
        ECDraweeView r18 = this.c;
        ViewGroup.LayoutParams r19 = null;
        if (r18 == null) goto L14;
        ViewGroup.LayoutParams r20 = r18.getLayoutParams();
    L16:
        if ((r20 instanceof ViewGroup.LayoutParams) == false) goto L19;
        r19 = r20;
    L19:
        if (r19 == null) goto L24;
        r19.width = r12;
        r19.height = r12;
        ECDraweeView r21 = this.c;
        if (r21 == null) goto L25;
        r21.setLayoutParams(r19);
        return;
    L25:
        return;
    L24:
        return;
    L14:
        r20 = null;
        goto L16
    }

    public /* synthetic */ BaseDoubleFeedProductCardView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
