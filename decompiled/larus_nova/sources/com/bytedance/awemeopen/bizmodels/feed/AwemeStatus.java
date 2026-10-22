package com.bytedance.awemeopen.bizmodels.feed;

import com.bytedance.android.shopping.searchsimilar.model.SimilarProductParam;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.internal.Intrinsics;
import r14.i0;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u001a\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0002GHB\u0007¢\u0006\u0004\bF\u00102R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u000f\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\"\u0010\u0012\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u000b\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\"\u0010\u0016\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010\u001c\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u0017\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001bR\"\u0010\u001f\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u000b\u001a\u0004\b \u0010\f\"\u0004\b!\u0010\u000eR\"\u0010\"\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u0017\u001a\u0004\b#\u0010\u0019\"\u0004\b$\u0010\u001bR\"\u0010%\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b%\u0010\u000b\u001a\u0004\b&\u0010\f\"\u0004\b'\u0010\u000eR\"\u0010(\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b(\u0010\u000b\u001a\u0004\b)\u0010\f\"\u0004\b*\u0010\u000eR\"\u0010+\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b+\u0010\u000b\u001a\u0004\b,\u0010\f\"\u0004\b-\u0010\u000eR(\u0010.\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\b.\u0010\u0017\u0012\u0004\b1\u00102\u001a\u0004\b/\u0010\u0019\"\u0004\b0\u0010\u001bR(\u00104\u001a\b\u0018\u000103R\u00020\u00008\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\"\u0010:\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b:\u0010\u0017\u001a\u0004\b;\u0010\u0019\"\u0004\b<\u0010\u001bR\"\u0010=\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b=\u0010\u0017\u001a\u0004\b>\u0010\u0019\"\u0004\b?\u0010\u001bR(\u0010B\u001a\u0004\u0018\u00010@2\b\u0010A\u001a\u0004\u0018\u00010@8\u0006@BX\u0087\u000e¢\u0006\f\n\u0004\bB\u0010C\u001a\u0004\bD\u0010E¨\u0006I"}, d2 = {"Lcom/bytedance/awemeopen/bizmodels/feed/AwemeStatus;", "", "", "aid", "Ljava/lang/String;", "getAid", "()Ljava/lang/String;", "setAid", "(Ljava/lang/String;)V", "", "isDelete", "Z", "()Z", "setDelete", "(Z)V", "allowShare", "getAllowShare", "setAllowShare", "allowComment", "getAllowComment", "setAllowComment", "", "privateStatus", "I", "b", "()I", "setPrivateStatus", "(I)V", "showGoodDelayTime", "getShowGoodDelayTime", "setShowGoodDelayTime", "inReviewing", "getInReviewing", "setInReviewing", "reviewed", "getReviewed", "setReviewed", "selfSee", "getSelfSee", "setSelfSee", "isProhibited", "c", "setProhibited", "withFusionGoods", "getWithFusionGoods", "setWithFusionGoods", "downloadStatus", "getDownloadStatus", "setDownloadStatus", "getDownloadStatus$annotations", "()V", "Lcom/bytedance/awemeopen/bizmodels/feed/AwemeStatus$a;", "reviewResult", "Lcom/bytedance/awemeopen/bizmodels/feed/AwemeStatus$a;", "getReviewResult", "()Lcom/bytedance/awemeopen/bizmodels/feed/AwemeStatus$a;", "setReviewResult", "(Lcom/bytedance/awemeopen/bizmodels/feed/AwemeStatus$a;)V", "excludeStatus", "getExcludeStatus", "setExcludeStatus", "allowRecommend", "getAllowRecommend", "setAllowRecommend", "Lr14/i0;", "<set-?>", "videoMuteInfo", "Lr14/i0;", "getVideoMuteInfo", "()Lr14/i0;", "<init>", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ao_biz_models_release"}, k = 1, mv = {1, 7, 1})
public final class AwemeStatus implements Cloneable {

    @SerializedName(SimilarProductParam.AWEME_ID)
    private String aid;

    @SerializedName("allow_comment")
    private boolean allowComment;

    @SerializedName("video_hide_search")
    private int allowRecommend;

    @SerializedName("allow_share")
    private boolean allowShare;

    @SerializedName("download_status")
    private int downloadStatus;

    @SerializedName("dont_share_status")
    private int excludeStatus;

    @SerializedName("in_reviewing")
    private boolean inReviewing;

    @SerializedName("is_delete")
    private boolean isDelete;

    @SerializedName("is_prohibited")
    private boolean isProhibited;

    @SerializedName("private_status")
    private int privateStatus;

    @SerializedName("review_result")
    private a reviewResult;

    @SerializedName("reviewed")
    private int reviewed;

    @SerializedName("self_see")
    private boolean selfSee;

    @SerializedName("show_good_delay_time")
    private int showGoodDelayTime;

    @SerializedName("video_mute")
    private i0 videoMuteInfo;

    @SerializedName("with_fusion_goods")
    private boolean withFusionGoods;

    public static final class Companion {

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000¨\u0006\u0004"}, d2 = {"Lcom/bytedance/awemeopen/bizmodels/feed/AwemeStatus$Companion$DownloadStatus;", "", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ao_biz_models_release"}, k = 1, mv = {1, 7, 1})
        @Retention(RetentionPolicy.SOURCE)
        @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
        public @interface DownloadStatus {
            public static final int AD_PREVENT = 1;
            public static final int ALLOW_DOWNLOAD = 0;
            public static final a Companion = null;
            public static final int GEO_FENCING_PREVENT = 2;

            public static final class a {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public static final /* synthetic */ a f198172a = null;

                static {
                    f198172a = new a();
                }

                public a() {
                }
            }

            static {
                Companion = a.f198172a;
            }
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0086\u0004\u0018\u00002\u00020\u0001R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0017\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R$\u0010\u001a\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0012\u001a\u0004\b\u001b\u0010\u0014\"\u0004\b\u001c\u0010\u0016R$\u0010\u001d\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0012\u001a\u0004\b\u001e\u0010\u0014\"\u0004\b\u001f\u0010\u0016¨\u0006 "}, d2 = {"Lcom/bytedance/awemeopen/bizmodels/feed/AwemeStatus$a;", "", "", "reviewStatus", "I", "getReviewStatus", "()I", "setReviewStatus", "(I)V", "", "shouldTell", "Z", "getShouldTell", "()Z", "setShouldTell", "(Z)V", "", "detailUrl", "Ljava/lang/String;", "getDetailUrl", "()Ljava/lang/String;", "setDetailUrl", "(Ljava/lang/String;)V", "videoDetailNoticeBottom", "getVideoDetailNoticeBottom", "setVideoDetailNoticeBottom", "videoDetailNotice", "getVideoDetailNotice", "setVideoDetailNotice", "coverNotice", "getCoverNotice", "setCoverNotice", "ao_biz_models_release"}, k = 1, mv = {1, 7, 1})
    public final class a {

        @SerializedName("cover_notice")
        private String coverNotice;

        @SerializedName("detail_url")
        private String detailUrl;

        @SerializedName("review_status")
        private int reviewStatus;

        @SerializedName("should_tell")
        private boolean shouldTell;

        @SerializedName("video_detail_notice")
        private String videoDetailNotice;

        @SerializedName("video_detail_notice_bottom")
        private String videoDetailNoticeBottom;

        public final String toString() {
            return "review_result{review_status=" + this.reviewStatus + "should_tell=" + this.shouldTell + "detail_url=" + this.detailUrl + '}';
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (this.reviewStatus == r101.reviewStatus) goto L11;
        L15:
            return false;
        L11:
            if (this.shouldTell != r101.shouldTell) goto L15;
            if (Intrinsics.areEqual(this.detailUrl, r101.detailUrl) == false) goto L15;
            return true;
        }
    }

    static {
    }

    public final AwemeStatus a() {
        AwemeStatus r100 = new AwemeStatus();
        r100.aid = this.aid;
        r100.isDelete = this.isDelete;
        r100.allowShare = this.allowShare;
        r100.allowComment = this.allowComment;
        r100.privateStatus = this.privateStatus;
        r100.showGoodDelayTime = this.showGoodDelayTime;
        r100.inReviewing = this.inReviewing;
        r100.reviewed = this.reviewed;
        r100.selfSee = this.selfSee;
        r100.isProhibited = this.isProhibited;
        r100.downloadStatus = this.downloadStatus;
        r100.reviewResult = this.reviewResult;
        r100.excludeStatus = this.excludeStatus;
        r100.allowRecommend = this.allowRecommend;
        return r100;
    }

    public final int hashCode() {
        return Objects.hash(new Object[]{this.aid, Boolean.valueOf(this.isDelete), Boolean.valueOf(this.allowShare), Boolean.valueOf(this.allowComment), Integer.valueOf(this.privateStatus), Integer.valueOf(this.showGoodDelayTime), Boolean.valueOf(this.inReviewing), Integer.valueOf(this.reviewed), Boolean.valueOf(this.selfSee), Boolean.valueOf(this.isProhibited), Integer.valueOf(this.downloadStatus), this.reviewResult, Integer.valueOf(this.allowRecommend), Integer.valueOf(this.excludeStatus)});
    }

    public final String toString() {
        a r100 = this.reviewResult;
        if (r100 == null) goto L5;
        String r101 = String.valueOf(r100);
    L7:
        return "AwemeStatus{aid='" + this.aid + "', isDelete=" + this.isDelete + ", allowShare=" + this.allowShare + ", allowComment=" + this.allowComment + ", privateStatus=" + this.privateStatus + ", showGoodDelayTime=" + this.showGoodDelayTime + ", inReviewing=" + this.inReviewing + ", reviewed=" + this.reviewed + ", selfSee=" + this.selfSee + ", isProhibited=" + this.isProhibited + ", downloadStatus=" + this.downloadStatus + ", reviewStatus=" + r101 + ", excludeStatus=" + this.excludeStatus + ", allowRecommend=" + this.allowRecommend + '}';
    L5:
        r101 = "";
        goto L7
    }

    public AwemeStatus() {
        this.showGoodDelayTime = 2000;
    }

    public final /* bridge */ /* synthetic */ Object clone() {
        return a();
    }

    public final int b() {
        return this.privateStatus;
    }

    public final boolean c() {
        return this.isProhibited;
    }

    public final boolean d() {
        return this.withFusionGoods;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof AwemeStatus) == true) goto L8;
        return false;
    L8:
        AwemeStatus r101 = (AwemeStatus) r100;
        if (this.isDelete == r101.isDelete) goto L11;
    L37:
        return false;
    L11:
        if (this.allowShare != r101.allowShare) goto L37;
        if (this.allowComment != r101.allowComment) goto L37;
        if (this.privateStatus != r101.privateStatus) goto L37;
        if (this.showGoodDelayTime != r101.showGoodDelayTime) goto L37;
        if (this.inReviewing != r101.inReviewing) goto L37;
        if (this.reviewed != r101.reviewed) goto L37;
        if (this.selfSee != r101.selfSee) goto L37;
        if (this.isProhibited != r101.isProhibited) goto L37;
        if (this.downloadStatus != r101.downloadStatus) goto L37;
        if (Intrinsics.areEqual(this.aid, r101.aid) == false) goto L37;
        if (Intrinsics.areEqual(this.reviewResult, r101.reviewResult) == false) goto L37;
        if (this.allowRecommend != r101.allowRecommend) goto L37;
        if (this.excludeStatus != r101.excludeStatus) goto L37;
        return true;
    }
}
