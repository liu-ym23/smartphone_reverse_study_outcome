package com.bytedance.awemeopen.bizmodels.feed.shopping.card;

import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.bytedance.android.ec.model.response.anchorv3.SalesInfoStruct;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.bytedance.map.api.monitor.MapMonitorConst;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\bS\u0010TJ\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002R\"\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR$\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\u0006\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\u001a\u0010\u000f\u001a\u00020\u000e8\u0006X\u0087D¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R$\u0010\u0013\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0006\u001a\u0004\b\u0014\u0010\b\"\u0004\b\u0015\u0010\nR\"\u0010\u0017\u001a\u00020\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010\u001d\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0010\u001a\u0004\b\u001e\u0010\u0012\"\u0004\b\u001f\u0010 R$\u0010!\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b!\u0010\u0006\u001a\u0004\b\"\u0010\b\"\u0004\b#\u0010\nR\"\u0010$\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b$\u0010\u0010\u001a\u0004\b%\u0010\u0012\"\u0004\b&\u0010 R$\u0010'\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b'\u0010\u0006\u001a\u0004\b(\u0010\b\"\u0004\b)\u0010\nR*\u0010+\u001a\n\u0012\u0004\u0012\u00020*\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R$\u00101\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b1\u0010\u0006\u001a\u0004\b2\u0010\b\"\u0004\b3\u0010\nR$\u00104\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b4\u0010\u0006\u001a\u0004\b5\u0010\b\"\u0004\b6\u0010\nR$\u00107\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b7\u0010\u0006\u001a\u0004\b8\u0010\b\"\u0004\b9\u0010\nR\"\u0010;\u001a\u00020:8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\"\u0010A\u001a\u00020\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bA\u0010\u0018\u001a\u0004\bB\u0010\u001a\"\u0004\bC\u0010\u001cR$\u0010D\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bD\u0010\u0006\u001a\u0004\bE\u0010\b\"\u0004\bF\u0010\nR*\u0010G\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bG\u0010,\u001a\u0004\bH\u0010.\"\u0004\bI\u00100R$\u0010J\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bJ\u0010\u0006\u001a\u0004\bK\u0010\b\"\u0004\bL\u0010\nR\u001d\u0010R\u001a\u0004\u0018\u00010M8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bN\u0010O\u001a\u0004\bP\u0010Q¨\u0006U"}, d2 = {"Lcom/bytedance/awemeopen/bizmodels/feed/shopping/card/ShoppingCardInfo;", "Ljava/io/Serializable;", "", "", "getSecondLineTags", "promotionId", "Ljava/lang/String;", "getPromotionId", "()Ljava/lang/String;", "setPromotionId", "(Ljava/lang/String;)V", "productId", "getProductId", "setProductId", "", "styleType", "I", "getStyleType", "()I", "title", "getTitle", com.alipay.sdk.m.x.d.f25925o, "", "price", "J", "getPrice", "()J", "setPrice", "(J)V", SalesInfoStruct.SALES, "getSales", "setSales", "(I)V", "elasticTitle", "getElasticTitle", "setElasticTitle", "promotionSource", "getPromotionSource", "setPromotionSource", "cardUrl", "getCardUrl", "setCardUrl", "Lt14/a;", "elasticImages", "Ljava/util/List;", "getElasticImages", "()Ljava/util/List;", "setElasticImages", "(Ljava/util/List;)V", "shopId", "getShopId", "setShopId", "productDetailSchema", "getProductDetailSchema", "setProductDetailSchema", "internalFlowSchema", "getInternalFlowSchema", "setInternalFlowSchema", "", "showInternalFlow", "Z", "getShowInternalFlow", "()Z", "setShowInternalFlow", "(Z)V", "commentCount", "getCommentCount", "setCommentCount", "anchorContent", "getAnchorContent", "setAnchorContent", PromotionProductPrivilegesStruct.TAGS, "getTags", "setTags", "extraSecondLineTag", "getExtraSecondLineTag", "setExtraSecondLineTag", "Lcom/bytedance/awemeopen/bizmodels/feed/shopping/card/a;", "anchorContentObj$delegate", "Lkotlin/Lazy;", "getAnchorContentObj", "()Lcom/bytedance/awemeopen/bizmodels/feed/shopping/card/a;", "anchorContentObj", "<init>", "()V", "ao_biz_models_release"}, k = 1, mv = {1, 7, 1})
public final class ShoppingCardInfo implements Serializable {

    @SerializedName("anchor_content")
    private String anchorContent;
    private final Lazy anchorContentObj$delegate;

    @SerializedName("card_url")
    private String cardUrl;

    @SerializedName("comment_count")
    private long commentCount;

    @SerializedName("elastic_images")
    private List<? extends t14.a> elasticImages;

    @SerializedName("elastic_title")
    private String elasticTitle;
    private transient String extraSecondLineTag;

    @SerializedName("internal_flow_schema")
    private String internalFlowSchema;

    @SerializedName("price")
    private long price;

    @SerializedName("product_detail_schema")
    private String productDetailSchema;

    @SerializedName("product_id")
    private String productId;

    @SerializedName("promotion_id")
    private String promotionId;

    @SerializedName(PdpOpenThirdParam.KEY_PROMOTION_SOURCE)
    private int promotionSource;

    @SerializedName(SalesInfoStruct.SALES)
    private int sales;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_SHOP_ID)
    private String shopId;

    @SerializedName("show_internal_flow")
    private boolean showInternalFlow;

    @SerializedName(MapMonitorConst.STYLE_TYPE)
    private final int styleType;

    @SerializedName(PromotionProductPrivilegesStruct.TAGS)
    private List<String> tags;

    @SerializedName("title")
    private String title;

    public final a getAnchorContentObj() {
        return (a) this.anchorContentObj$delegate.getValue();
    }

    public final List<String> getSecondLineTags() {
        String r100 = this.extraSecondLineTag;
        List<String> r101 = this.tags;
        if (r101 != null) goto L5;
        r101 = CollectionsKt.emptyList();
    L5:
        if (r100 != null) goto L8;
        return r101;
    L8:
        return CollectionsKt.plus(CollectionsKt.listOf(r100), r101);
    }

    public ShoppingCardInfo() {
        this.promotionId = "";
        this.anchorContentObj$delegate = LazyKt.lazy(new ShoppingCardInfo$anchorContentObj$2(this));
    }

    public final String getAnchorContent() {
        return this.anchorContent;
    }

    public final String getCardUrl() {
        return this.cardUrl;
    }

    public final long getCommentCount() {
        return this.commentCount;
    }

    public final List<t14.a> getElasticImages() {
        return this.elasticImages;
    }

    public final String getElasticTitle() {
        return this.elasticTitle;
    }

    public final String getExtraSecondLineTag() {
        return this.extraSecondLineTag;
    }

    public final String getInternalFlowSchema() {
        return this.internalFlowSchema;
    }

    public final long getPrice() {
        return this.price;
    }

    public final String getProductDetailSchema() {
        return this.productDetailSchema;
    }

    public final String getProductId() {
        return this.productId;
    }

    public final String getPromotionId() {
        return this.promotionId;
    }

    public final int getPromotionSource() {
        return this.promotionSource;
    }

    public final int getSales() {
        return this.sales;
    }

    public final String getShopId() {
        return this.shopId;
    }

    public final boolean getShowInternalFlow() {
        return this.showInternalFlow;
    }

    public final int getStyleType() {
        return this.styleType;
    }

    public final List<String> getTags() {
        return this.tags;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setAnchorContent(String r100) {
        this.anchorContent = r100;
    }

    public final void setCardUrl(String r100) {
        this.cardUrl = r100;
    }

    public final void setCommentCount(long r100) {
        this.commentCount = r100;
    }

    public final void setElasticImages(List<? extends t14.a> r100) {
        this.elasticImages = r100;
    }

    public final void setElasticTitle(String r100) {
        this.elasticTitle = r100;
    }

    public final void setExtraSecondLineTag(String r100) {
        this.extraSecondLineTag = r100;
    }

    public final void setInternalFlowSchema(String r100) {
        this.internalFlowSchema = r100;
    }

    public final void setPrice(long r100) {
        this.price = r100;
    }

    public final void setProductDetailSchema(String r100) {
        this.productDetailSchema = r100;
    }

    public final void setProductId(String r100) {
        this.productId = r100;
    }

    public final void setPromotionId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.promotionId = r100;
    }

    public final void setPromotionSource(int r100) {
        this.promotionSource = r100;
    }

    public final void setSales(int r100) {
        this.sales = r100;
    }

    public final void setShopId(String r100) {
        this.shopId = r100;
    }

    public final void setShowInternalFlow(boolean r100) {
        this.showInternalFlow = r100;
    }

    public final void setTags(List<String> r100) {
        this.tags = r100;
    }

    public final void setTitle(String r100) {
        this.title = r100;
    }
}
