package com.bytedance.android.shopping.order.dto;

import com.bytedance.android.shopping.searchsimilar.model.SimilarProductParam;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R&\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R \u0010\u0017\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\r\"\u0004\b\u0019\u0010\u000fR\u001e\u0010\u001a\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010\u001e\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u001f\u0010\u0013\"\u0004\b \u0010\u0015R\"\u0010!\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\"\u0010\u0013\"\u0004\b#\u0010\u0015R\"\u0010$\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b%\u0010\u0013\"\u0004\b&\u0010\u0015R \u0010'\u001a\u0004\u0018\u00010(8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,¨\u0006-"}, d2 = {"Lcom/bytedance/android/shopping/order/dto/CommentInfoStruct;", "Ljava/io/Serializable;", "()V", "comments", "", "Lcom/bytedance/android/shopping/order/dto/PostCommentInfoV2;", "getComments", "()Ljava/util/List;", "setComments", "(Ljava/util/List;)V", "couponMetaId", "", "getCouponMetaId", "()Ljava/lang/String;", "setCouponMetaId", "(Ljava/lang/String;)V", "dealType", "", "getDealType", "()Ljava/lang/Long;", "setDealType", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "enterFrom", "getEnterFrom", "setEnterFrom", "isAnonymous", "()J", "setAnonymous", "(J)V", "rankKol", "getRankKol", "setRankKol", "rankLogistic", "getRankLogistic", "setRankLogistic", "rankShop", "getRankShop", "setRankShop", "survey", "Lcom/bytedance/android/shopping/order/dto/SurveyRequest;", "getSurvey", "()Lcom/bytedance/android/shopping/order/dto/SurveyRequest;", "setSurvey", "(Lcom/bytedance/android/shopping/order/dto/SurveyRequest;)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommentInfoStruct implements Serializable {

    @SerializedName("comments")
    private List<PostCommentInfoV2> comments;

    @SerializedName("coupon_meta_id")
    private String couponMetaId;

    @SerializedName("deal_type")
    private Long dealType;

    @SerializedName(SimilarProductParam.ENTER_FROM)
    private String enterFrom;

    @SerializedName("anonymous")
    private long isAnonymous;

    @SerializedName("rank_kol")
    private Long rankKol;

    @SerializedName("rank_logistic")
    private Long rankLogistic;

    @SerializedName("rank_shop")
    private Long rankShop;

    @SerializedName("survey")
    private SurveyRequest survey;

    public CommentInfoStruct() {
    }

    public final List<PostCommentInfoV2> getComments() {
        return this.comments;
    }

    public final String getCouponMetaId() {
        return this.couponMetaId;
    }

    public final Long getDealType() {
        return this.dealType;
    }

    public final String getEnterFrom() {
        return this.enterFrom;
    }

    public final Long getRankKol() {
        return this.rankKol;
    }

    public final Long getRankLogistic() {
        return this.rankLogistic;
    }

    public final Long getRankShop() {
        return this.rankShop;
    }

    public final SurveyRequest getSurvey() {
        return this.survey;
    }

    public final long isAnonymous() {
        return this.isAnonymous;
    }

    public final void setAnonymous(long r1) {
        this.isAnonymous = r1;
    }

    public final void setComments(List<PostCommentInfoV2> r1) {
        this.comments = r1;
    }

    public final void setCouponMetaId(String r1) {
        this.couponMetaId = r1;
    }

    public final void setDealType(Long r1) {
        this.dealType = r1;
    }

    public final void setEnterFrom(String r1) {
        this.enterFrom = r1;
    }

    public final void setRankKol(Long r1) {
        this.rankKol = r1;
    }

    public final void setRankLogistic(Long r1) {
        this.rankLogistic = r1;
    }

    public final void setRankShop(Long r1) {
        this.rankShop = r1;
    }

    public final void setSurvey(SurveyRequest r1) {
        this.survey = r1;
    }
}
