package com.bytedance.android.shopping.dto;

import android.text.TextUtils;
import com.bytedance.android.ec.model.response.anchorv3.PromotionMarketFloor;
import com.google.gson.annotations.SerializedName;
import hd3.b;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\bO\u0010PJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002R$\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\f\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0007\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR$\u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0007\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000bR$\u0010\u0012\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0007\u001a\u0004\b\u0013\u0010\t\"\u0004\b\u0014\u0010\u000bR$\u0010\u0015\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0007\u001a\u0004\b\u0016\u0010\t\"\u0004\b\u0017\u0010\u000bR\"\u0010\u0019\u001a\u00020\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR*\u0010!\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R$\u0010(\u001a\u0004\u0018\u00010'8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R$\u0010.\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R*\u00104\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b4\u0010\"\u001a\u0004\b5\u0010$\"\u0004\b6\u0010&R$\u00107\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b7\u0010\u0007\u001a\u0004\b8\u0010\t\"\u0004\b9\u0010\u000bR$\u0010;\u001a\u0004\u0018\u00010:8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R$\u0010B\u001a\u0004\u0018\u00010A8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bB\u0010C\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR$\u0010I\u001a\u0004\u0018\u00010H8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bI\u0010J\u001a\u0004\bK\u0010L\"\u0004\bM\u0010N¨\u0006Q"}, d2 = {"Lcom/bytedance/android/shopping/dto/DetailPromotion;", "Lcom/bytedance/android/shopping/dto/BaseDetailPromotion;", "", "isSelf", "hasGoodRankInfo", "", "originMediaId", "Ljava/lang/String;", "getOriginMediaId", "()Ljava/lang/String;", "setOriginMediaId", "(Ljava/lang/String;)V", "originUserId", "getOriginUserId", "setOriginUserId", "secOriginUserId", "getSecOriginUserId", "setSecOriginUserId", "rankUrl", "getRankUrl", "setRankUrl", "rankText", "getRankText", "setRankText", "", "rank", "I", "getRank", "()I", "setRank", "(I)V", "", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionMarketFloor;", "marketFloors", "Ljava/util/List;", "getMarketFloors", "()Ljava/util/List;", "setMarketFloors", "(Ljava/util/List;)V", "Lcom/bytedance/android/shopping/dto/PromotionActivity;", "activity", "Lcom/bytedance/android/shopping/dto/PromotionActivity;", "getActivity", "()Lcom/bytedance/android/shopping/dto/PromotionActivity;", "setActivity", "(Lcom/bytedance/android/shopping/dto/PromotionActivity;)V", "hasGuessULike", "Ljava/lang/Boolean;", "getHasGuessULike", "()Ljava/lang/Boolean;", "setHasGuessULike", "(Ljava/lang/Boolean;)V", "consumerComment", "getConsumerComment", "setConsumerComment", "priceTag", "getPriceTag", "setPriceTag", "Lcom/bytedance/android/shopping/dto/CommerceButton;", "couponBuyBtn", "Lcom/bytedance/android/shopping/dto/CommerceButton;", "getCouponBuyBtn", "()Lcom/bytedance/android/shopping/dto/CommerceButton;", "setCouponBuyBtn", "(Lcom/bytedance/android/shopping/dto/CommerceButton;)V", "Lhd3/b;", "moduleControl", "Lhd3/b;", "getModuleControl", "()Lhd3/b;", "setModuleControl", "(Lhd3/b;)V", "Lcom/bytedance/android/shopping/dto/ThirdCoupon;", "thirdCoupon", "Lcom/bytedance/android/shopping/dto/ThirdCoupon;", "getThirdCoupon", "()Lcom/bytedance/android/shopping/dto/ThirdCoupon;", "setThirdCoupon", "(Lcom/bytedance/android/shopping/dto/ThirdCoupon;)V", "<init>", "()V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DetailPromotion extends BaseDetailPromotion {

    @SerializedName("activity")
    private PromotionActivity activity;

    @SerializedName("consumer_comment")
    private List<String> consumerComment;

    @SerializedName("apply_coupon_button")
    private CommerceButton couponBuyBtn;

    @SerializedName("has_gyl")
    private Boolean hasGuessULike;

    @SerializedName("marketing_floors")
    private List<PromotionMarketFloor> marketFloors;

    @SerializedName("module_control")
    private b moduleControl;

    @SerializedName("origin_media_id")
    private String originMediaId;

    @SerializedName("origin_user_id")
    private String originUserId;

    @SerializedName("price_tag")
    private String priceTag;

    @SerializedName("rank")
    private int rank;

    @SerializedName("rank_text")
    private String rankText;

    @SerializedName("rank_url")
    private String rankUrl;

    @SerializedName("sec_origin_user_id")
    private String secOriginUserId;

    @SerializedName("third_platform")
    private ThirdCoupon thirdCoupon;

    public final boolean hasGoodRankInfo() {
        List<PromotionMarketFloor> r0 = this.marketFloors;
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.isEmpty() == true) goto L9;
        return true;
    L9:
        return false;
    }

    public final boolean isSelf() {
        return TextUtils.isEmpty(this.originUserId);
    }

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

    public final List<String> getConsumerComment() {
        return this.consumerComment;
    }

    public final CommerceButton getCouponBuyBtn() {
        return this.couponBuyBtn;
    }

    public final Boolean getHasGuessULike() {
        return this.hasGuessULike;
    }

    public final List<PromotionMarketFloor> getMarketFloors() {
        return this.marketFloors;
    }

    public final b getModuleControl() {
        return this.moduleControl;
    }

    public final String getOriginMediaId() {
        return this.originMediaId;
    }

    public final String getOriginUserId() {
        return this.originUserId;
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

    public final ThirdCoupon getThirdCoupon() {
        return this.thirdCoupon;
    }

    public final void setActivity(PromotionActivity r1) {
        this.activity = r1;
    }

    public final void setConsumerComment(List<String> r1) {
        this.consumerComment = r1;
    }

    public final void setCouponBuyBtn(CommerceButton r1) {
        this.couponBuyBtn = r1;
    }

    public final void setHasGuessULike(Boolean r1) {
        this.hasGuessULike = r1;
    }

    public final void setMarketFloors(List<PromotionMarketFloor> r1) {
        this.marketFloors = r1;
    }

    public final void setModuleControl(b r1) {
        this.moduleControl = r1;
    }

    public final void setOriginMediaId(String r1) {
        this.originMediaId = r1;
    }

    public final void setOriginUserId(String r1) {
        this.originUserId = r1;
    }

    public final void setPriceTag(String r1) {
        this.priceTag = r1;
    }

    public final void setRank(int r1) {
        this.rank = r1;
    }

    public final void setRankText(String r1) {
        this.rankText = r1;
    }

    public final void setRankUrl(String r1) {
        this.rankUrl = r1;
    }

    public final void setSecOriginUserId(String r1) {
        this.secOriginUserId = r1;
    }

    public final void setThirdCoupon(ThirdCoupon r1) {
        this.thirdCoupon = r1;
    }
}
