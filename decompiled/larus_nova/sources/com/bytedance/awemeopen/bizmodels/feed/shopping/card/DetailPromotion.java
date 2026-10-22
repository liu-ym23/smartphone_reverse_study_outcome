package com.bytedance.awemeopen.bizmodels.feed.shopping.card;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0015\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b`\u0010aR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR$\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\"\u0010\u0016\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR*\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R$\u0010%\u001a\u0004\u0018\u00010$8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R$\u0010,\u001a\u0004\u0018\u00010+8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R*\u00102\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b2\u0010\u001f\u001a\u0004\b3\u0010!\"\u0004\b4\u0010#R$\u00105\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b5\u0010\u0004\u001a\u0004\b6\u0010\u0006\"\u0004\b7\u0010\bR$\u00109\u001a\u0004\u0018\u0001088\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R$\u0010@\u001a\u0004\u0018\u00010?8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b@\u0010A\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER$\u0010G\u001a\u0004\u0018\u00010F8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bG\u0010H\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR$\u0010N\u001a\u0004\u0018\u00010M8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bN\u0010O\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR$\u0010T\u001a\u0004\u0018\u00010+8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bT\u0010-\u001a\u0004\bU\u0010/\"\u0004\bV\u00101R$\u0010W\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bW\u0010X\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\R$\u0010]\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b]\u0010\u0004\u001a\u0004\b^\u0010\u0006\"\u0004\b_\u0010\b¨\u0006b"}, d2 = {"Lcom/bytedance/awemeopen/bizmodels/feed/shopping/card/DetailPromotion;", "Lcom/bytedance/awemeopen/bizmodels/feed/shopping/card/BaseDetailPromotion;", "", "originMediaId", "Ljava/lang/String;", "getOriginMediaId", "()Ljava/lang/String;", "setOriginMediaId", "(Ljava/lang/String;)V", "originUserId", "getOriginUserId", "setOriginUserId", "secOriginUserId", "getSecOriginUserId", "setSecOriginUserId", "rankUrl", "getRankUrl", "setRankUrl", "rankText", "getRankText", "setRankText", "", "rank", "I", "getRank", "()I", "setRank", "(I)V", "", "Lcom/bytedance/awemeopen/bizmodels/feed/shopping/card/PromotionMarketFloor;", "marketFloors", "Ljava/util/List;", "getMarketFloors", "()Ljava/util/List;", "setMarketFloors", "(Ljava/util/List;)V", "Lcom/bytedance/awemeopen/bizmodels/feed/shopping/card/PromotionActivity;", "activity", "Lcom/bytedance/awemeopen/bizmodels/feed/shopping/card/PromotionActivity;", "getActivity", "()Lcom/bytedance/awemeopen/bizmodels/feed/shopping/card/PromotionActivity;", "setActivity", "(Lcom/bytedance/awemeopen/bizmodels/feed/shopping/card/PromotionActivity;)V", "", "hasGuessULike", "Ljava/lang/Boolean;", "getHasGuessULike", "()Ljava/lang/Boolean;", "setHasGuessULike", "(Ljava/lang/Boolean;)V", "consumerComment", "getConsumerComment", "setConsumerComment", "priceTag", "getPriceTag", "setPriceTag", "Lcom/bytedance/awemeopen/bizmodels/feed/shopping/card/CommerceButton;", "couponBuyBtn", "Lcom/bytedance/awemeopen/bizmodels/feed/shopping/card/CommerceButton;", "getCouponBuyBtn", "()Lcom/bytedance/awemeopen/bizmodels/feed/shopping/card/CommerceButton;", "setCouponBuyBtn", "(Lcom/bytedance/awemeopen/bizmodels/feed/shopping/card/CommerceButton;)V", "Lcom/bytedance/awemeopen/bizmodels/feed/shopping/card/e;", "moduleControl", "Lcom/bytedance/awemeopen/bizmodels/feed/shopping/card/e;", "getModuleControl", "()Lcom/bytedance/awemeopen/bizmodels/feed/shopping/card/e;", "setModuleControl", "(Lcom/bytedance/awemeopen/bizmodels/feed/shopping/card/e;)V", "Lcom/bytedance/awemeopen/bizmodels/feed/shopping/card/ThirdCoupon;", "thirdCoupon", "Lcom/bytedance/awemeopen/bizmodels/feed/shopping/card/ThirdCoupon;", "getThirdCoupon", "()Lcom/bytedance/awemeopen/bizmodels/feed/shopping/card/ThirdCoupon;", "setThirdCoupon", "(Lcom/bytedance/awemeopen/bizmodels/feed/shopping/card/ThirdCoupon;)V", "Lt14/a;", "platformTextActivity", "Lt14/a;", "getPlatformTextActivity", "()Lt14/a;", "setPlatformTextActivity", "(Lt14/a;)V", "showInternalFlow", "getShowInternalFlow", "setShowInternalFlow", "inflowRecommendType", "Ljava/lang/Integer;", "getInflowRecommendType", "()Ljava/lang/Integer;", "setInflowRecommendType", "(Ljava/lang/Integer;)V", "anchorContent", "getAnchorContent", "setAnchorContent", "<init>", "()V", "ao_biz_models_release"}, k = 1, mv = {1, 7, 1})
public final class DetailPromotion extends BaseDetailPromotion {

    @SerializedName("activity")
    private PromotionActivity activity;

    @SerializedName("anchor_content")
    private String anchorContent;

    @SerializedName("consumer_comment")
    private List<String> consumerComment;

    @SerializedName("apply_coupon_button")
    private CommerceButton couponBuyBtn;

    @SerializedName("has_gyl")
    private Boolean hasGuessULike;

    @SerializedName("inflow_recommend_type")
    private Integer inflowRecommendType;

    @SerializedName("marketing_floors")
    private List<PromotionMarketFloor> marketFloors;

    @SerializedName("module_control")
    private e moduleControl;

    @SerializedName("origin_media_id")
    private String originMediaId;

    @SerializedName("origin_user_id")
    private String originUserId;

    @SerializedName("platform_text_activity")
    private t14.a platformTextActivity;

    @SerializedName(BdpAppEventConstant.PARAMS_PRICE_TAG)
    private String priceTag;

    @SerializedName("rank")
    private int rank;

    @SerializedName("rank_text")
    private String rankText;

    @SerializedName("rank_url")
    private String rankUrl;

    @SerializedName("sec_origin_user_id")
    private String secOriginUserId;

    @SerializedName("show_internal_flow")
    private Boolean showInternalFlow;

    @SerializedName("third_platform")
    private ThirdCoupon thirdCoupon;

    public DetailPromotion() {
        this.originMediaId = "";
        this.originUserId = "";
        this.secOriginUserId = "";
        this.rankUrl = "";
        this.rankText = "";
        this.marketFloors = CollectionsKt.emptyList();
        this.hasGuessULike = Boolean.TRUE;
    }

    public final PromotionActivity getActivity() {
        return this.activity;
    }

    public final String getAnchorContent() {
        return this.anchorContent;
    }

    public final List<String> getConsumerComment() {
        return this.consumerComment;
    }

    public final CommerceButton getCouponBuyBtn() {
        return this.couponBuyBtn;
    }

    public final Boolean getHasGuessULike() {
        return this.hasGuessULike;
    }

    public final Integer getInflowRecommendType() {
        return this.inflowRecommendType;
    }

    public final List<PromotionMarketFloor> getMarketFloors() {
        return this.marketFloors;
    }

    public final e getModuleControl() {
        return this.moduleControl;
    }

    public final String getOriginMediaId() {
        return this.originMediaId;
    }

    public final String getOriginUserId() {
        return this.originUserId;
    }

    public final t14.a getPlatformTextActivity() {
        return this.platformTextActivity;
    }

    public final String getPriceTag() {
        return this.priceTag;
    }

    public final int getRank() {
        return this.rank;
    }

    public final String getRankText() {
        return this.rankText;
    }

    public final String getRankUrl() {
        return this.rankUrl;
    }

    public final String getSecOriginUserId() {
        return this.secOriginUserId;
    }

    public final Boolean getShowInternalFlow() {
        return this.showInternalFlow;
    }

    public final ThirdCoupon getThirdCoupon() {
        return this.thirdCoupon;
    }

    public final void setActivity(PromotionActivity r100) {
        this.activity = r100;
    }

    public final void setAnchorContent(String r100) {
        this.anchorContent = r100;
    }

    public final void setConsumerComment(List<String> r100) {
        this.consumerComment = r100;
    }

    public final void setCouponBuyBtn(CommerceButton r100) {
        this.couponBuyBtn = r100;
    }

    public final void setHasGuessULike(Boolean r100) {
        this.hasGuessULike = r100;
    }

    public final void setInflowRecommendType(Integer r100) {
        this.inflowRecommendType = r100;
    }

    public final void setMarketFloors(List<PromotionMarketFloor> r100) {
        this.marketFloors = r100;
    }

    public final void setModuleControl(e r100) {
        this.moduleControl = r100;
    }

    public final void setOriginMediaId(String r100) {
        this.originMediaId = r100;
    }

    public final void setOriginUserId(String r100) {
        this.originUserId = r100;
    }

    public final void setPlatformTextActivity(t14.a r100) {
        this.platformTextActivity = r100;
    }

    public final void setPriceTag(String r100) {
        this.priceTag = r100;
    }

    public final void setRank(int r100) {
        this.rank = r100;
    }

    public final void setRankText(String r100) {
        this.rankText = r100;
    }

    public final void setRankUrl(String r100) {
        this.rankUrl = r100;
    }

    public final void setSecOriginUserId(String r100) {
        this.secOriginUserId = r100;
    }

    public final void setShowInternalFlow(Boolean r100) {
        this.showInternalFlow = r100;
    }

    public final void setThirdCoupon(ThirdCoupon r100) {
        this.thirdCoupon = r100;
    }
}
