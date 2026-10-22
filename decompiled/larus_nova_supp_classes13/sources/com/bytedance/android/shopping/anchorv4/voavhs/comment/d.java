package com.bytedance.android.shopping.anchorv4.voavhs.comment;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0010\b\n\u0002\b\u0017\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\u000b\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\"\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\"\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0014\u0010\u0012R\"\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0016\u0010\u0012R\"\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0010\u001a\u0004\b\u0018\u0010\u0012R\"\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u0010\u001a\u0004\b\u001a\u0010\u0012R\u001a\u0010\u001b\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u0004\u001a\u0004\b\u001c\u0010\u0006R\"\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u0010\u001a\u0004\b\u001e\u0010\u0012R\"\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u0010\u0010\u001a\u0004\b \u0010\u0012R\"\u0010!\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b!\u0010\u0010\u001a\u0004\b\"\u0010\u0012R\"\u0010#\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b#\u0010\u0010\u001a\u0004\b$\u0010\u0012R\u001a\u0010%\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b%\u0010\u0004\u001a\u0004\b&\u0010\u0006R\u001a\u0010(\u001a\u00020'8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\"\u0010,\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b,\u0010\u0010\u001a\u0004\b-\u0010\u0012R\u001c\u0010.\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R\u001a\u00102\u001a\u00020'8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b2\u0010)\u001a\u0004\b3\u0010+R\u001c\u00104\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u00107R\u001c\u00108\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b8\u00105\u001a\u0004\b9\u00107R\u001c\u0010:\u001a\u0004\u0018\u00010'8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=¨\u0006>"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/comment/d;", "", "", "commentCount", "J", "c", "()J", "commentId", "d", "storeCommentCount", "n", "buyerShowCount", "a", "", "", "buyerShowIdList", "Ljava/util/List;", "b", "()Ljava/util/List;", "commentTagSentiments", "h", "commentTagNum", "f", "commentTagRealNum", "g", "commentTagName", "e", "commentTagsCount", "i", "storeCommentTagSentiments", "r", "storeCommentTagNum", "p", "storeCommentTagRealNum", "q", "storeCommentTagName", "o", "storeCommentTagsCount", "s", "", "questionNum", "I", "m", "()I", "questionIdList", "l", "userCommentLevel", "Ljava/lang/Long;", "t", "()Ljava/lang/Long;", "kolAllVideoCnt", "j", "videoGroupType", "Ljava/lang/String;", "u", "()Ljava/lang/String;", "productCommentModule", "k", "withSameComment", "Ljava/lang/Integer;", "v", "()Ljava/lang/Integer;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class d {

    @SerializedName("buyer_show_count")
    private final long buyerShowCount;

    @SerializedName("buyer_show_id_list")
    private final List<String> buyerShowIdList;

    @SerializedName("comment_count")
    private final long commentCount;

    @SerializedName("comment_id")
    private final long commentId;

    @SerializedName("comment_tag_name")
    private final List<String> commentTagName;

    @SerializedName("comment_tag_num")
    private final List<String> commentTagNum;

    @SerializedName("comment_tag_real_num")
    private final List<String> commentTagRealNum;

    @SerializedName("comment_tag_sentiments")
    private final List<String> commentTagSentiments;

    @SerializedName("comment_tags_count")
    private final long commentTagsCount;

    @SerializedName("kol_all_video_cnt")
    private final int kolAllVideoCnt;

    @SerializedName("product_comment_module")
    private final String productCommentModule;

    @SerializedName("question_id_list")
    private final List<Long> questionIdList;

    @SerializedName("question_num")
    private final int questionNum;

    @SerializedName("store_comment_count")
    private final long storeCommentCount;

    @SerializedName("store_comment_tag_name")
    private final List<String> storeCommentTagName;

    @SerializedName("store_comment_tag_num")
    private final List<String> storeCommentTagNum;

    @SerializedName("store_comment_tag_real_num")
    private final List<String> storeCommentTagRealNum;

    @SerializedName("store_comment_tag_sentiments")
    private final List<String> storeCommentTagSentiments;

    @SerializedName("store_comment_tags_count")
    private final long storeCommentTagsCount;

    @SerializedName("comment_rank")
    private final Long userCommentLevel;

    @SerializedName("video_group_type")
    private final String videoGroupType;

    @SerializedName("with_same_comment")
    private final Integer withSameComment;

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof d) == false) goto L50;
        d r7 = (d) r6;
        if (this.commentCount == r7.commentCount) goto L8;
        return false;
    L8:
        if (this.commentId == r7.commentId) goto L10;
        return false;
    L10:
        if (this.storeCommentCount == r7.storeCommentCount) goto L12;
        return false;
    L12:
        if (this.buyerShowCount == r7.buyerShowCount) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.buyerShowIdList, r7.buyerShowIdList) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.commentTagSentiments, r7.commentTagSentiments) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.commentTagNum, r7.commentTagNum) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.commentTagRealNum, r7.commentTagRealNum) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.commentTagName, r7.commentTagName) == true) goto L24;
        return false;
    L24:
        if (this.commentTagsCount == r7.commentTagsCount) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.storeCommentTagSentiments, r7.storeCommentTagSentiments) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.storeCommentTagNum, r7.storeCommentTagNum) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.storeCommentTagRealNum, r7.storeCommentTagRealNum) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.storeCommentTagName, r7.storeCommentTagName) == true) goto L34;
        return false;
    L34:
        if (this.storeCommentTagsCount == r7.storeCommentTagsCount) goto L36;
        return false;
    L36:
        if (this.questionNum == r7.questionNum) goto L38;
        return false;
    L38:
        if (Intrinsics.areEqual(this.questionIdList, r7.questionIdList) == true) goto L40;
        return false;
    L40:
        if (Intrinsics.areEqual(this.userCommentLevel, r7.userCommentLevel) == true) goto L42;
        return false;
    L42:
        if (this.kolAllVideoCnt == r7.kolAllVideoCnt) goto L44;
        return false;
    L44:
        if (Intrinsics.areEqual(this.videoGroupType, r7.videoGroupType) == true) goto L46;
        return false;
    L46:
        if (Intrinsics.areEqual(this.productCommentModule, r7.productCommentModule) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.withSameComment, r7.withSameComment) == true) goto L76;
        return false;
    L76:
        return true;
    L50:
        return false;
    }

    public final int hashCode() {
        long r0 = this.commentCount;
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        long r3 = this.commentId;
        int r2 = (r1 + ((int) (r3 ^ (r3 >>> 32)))) * 31;
        long r4 = this.storeCommentCount;
        int r5 = (r2 + ((int) (r4 ^ (r4 >>> 32)))) * 31;
        long r6 = this.buyerShowCount;
        int r7 = (r5 + ((int) (r6 ^ (r6 >>> 32)))) * 31;
        List<String> r8 = this.buyerShowIdList;
        int r9 = 0;
        if (r8 == null) goto L5;
        int r10 = r8.hashCode();
    L6:
        int r11 = (r7 + r10) * 31;
        List<String> r12 = this.commentTagSentiments;
        if (r12 == null) goto L9;
        int r13 = r12.hashCode();
    L10:
        int r14 = (r11 + r13) * 31;
        List<String> r15 = this.commentTagNum;
        if (r15 == null) goto L13;
        int r16 = r15.hashCode();
    L14:
        int r17 = (r14 + r16) * 31;
        List<String> r18 = this.commentTagRealNum;
        if (r18 == null) goto L17;
        int r19 = r18.hashCode();
    L18:
        int r20 = (r17 + r19) * 31;
        List<String> r21 = this.commentTagName;
        if (r21 == null) goto L21;
        int r22 = r21.hashCode();
    L22:
        long r23 = this.commentTagsCount;
        int r24 = (((r20 + r22) * 31) + ((int) (r23 ^ (r23 >>> 32)))) * 31;
        List<String> r25 = this.storeCommentTagSentiments;
        if (r25 == null) goto L25;
        int r26 = r25.hashCode();
    L26:
        int r27 = (r24 + r26) * 31;
        List<String> r28 = this.storeCommentTagNum;
        if (r28 == null) goto L29;
        int r29 = r28.hashCode();
    L30:
        int r30 = (r27 + r29) * 31;
        List<String> r31 = this.storeCommentTagRealNum;
        if (r31 == null) goto L33;
        int r32 = r31.hashCode();
    L34:
        int r33 = (r30 + r32) * 31;
        List<String> r34 = this.storeCommentTagName;
        if (r34 == null) goto L37;
        int r35 = r34.hashCode();
    L38:
        long r36 = this.storeCommentTagsCount;
        int r37 = (((((r33 + r35) * 31) + ((int) (r36 ^ (r36 >>> 32)))) * 31) + this.questionNum) * 31;
        List<Long> r38 = this.questionIdList;
        if (r38 == null) goto L41;
        int r39 = r38.hashCode();
    L42:
        int r40 = (r37 + r39) * 31;
        Long r41 = this.userCommentLevel;
        if (r41 == null) goto L45;
        int r42 = r41.hashCode();
    L46:
        int r43 = (((r40 + r42) * 31) + this.kolAllVideoCnt) * 31;
        String r44 = this.videoGroupType;
        if (r44 == null) goto L49;
        int r45 = r44.hashCode();
    L50:
        int r46 = (r43 + r45) * 31;
        String r47 = this.productCommentModule;
        if (r47 == null) goto L53;
        int r48 = r47.hashCode();
    L54:
        int r49 = (r46 + r48) * 31;
        Integer r50 = this.withSameComment;
        if (r50 == null) goto L58;
        r9 = r50.hashCode();
    L58:
        return r49 + r9;
    L53:
        r48 = 0;
        goto L54
    L49:
        r45 = 0;
        goto L50
    L45:
        r42 = 0;
        goto L46
    L41:
        r39 = 0;
        goto L42
    L37:
        r35 = 0;
        goto L38
    L33:
        r32 = 0;
        goto L34
    L29:
        r29 = 0;
        goto L30
    L25:
        r26 = 0;
        goto L26
    L21:
        r22 = 0;
        goto L22
    L17:
        r19 = 0;
        goto L18
    L13:
        r16 = 0;
        goto L14
    L9:
        r13 = 0;
        goto L10
    L5:
        r10 = 0;
        goto L6
    }

    public final String toString() {
        return "AnchorV4CommentTrackMeta(commentCount=" + this.commentCount + ", commentId=" + this.commentId + ", storeCommentCount=" + this.storeCommentCount + ", buyerShowCount=" + this.buyerShowCount + ", buyerShowIdList=" + this.buyerShowIdList + ", commentTagSentiments=" + this.commentTagSentiments + ", commentTagNum=" + this.commentTagNum + ", commentTagRealNum=" + this.commentTagRealNum + ", commentTagName=" + this.commentTagName + ", commentTagsCount=" + this.commentTagsCount + ", storeCommentTagSentiments=" + this.storeCommentTagSentiments + ", storeCommentTagNum=" + this.storeCommentTagNum + ", storeCommentTagRealNum=" + this.storeCommentTagRealNum + ", storeCommentTagName=" + this.storeCommentTagName + ", storeCommentTagsCount=" + this.storeCommentTagsCount + ", questionNum=" + this.questionNum + ", questionIdList=" + this.questionIdList + ", userCommentLevel=" + this.userCommentLevel + ", kolAllVideoCnt=" + this.kolAllVideoCnt + ", videoGroupType=" + this.videoGroupType + ", productCommentModule=" + this.productCommentModule + ", withSameComment=" + this.withSameComment + ")";
    }

    public d() {
        this.commentCount = 0;
        this.commentId = 0;
        this.storeCommentCount = 0;
        this.buyerShowCount = 0;
        this.buyerShowIdList = null;
        this.commentTagSentiments = null;
        this.commentTagNum = null;
        this.commentTagRealNum = null;
        this.commentTagName = null;
        this.commentTagsCount = 0;
        this.storeCommentTagSentiments = null;
        this.storeCommentTagNum = null;
        this.storeCommentTagRealNum = null;
        this.storeCommentTagName = null;
        this.storeCommentTagsCount = 0;
        this.questionNum = 0;
        this.questionIdList = null;
        this.userCommentLevel = null;
        this.kolAllVideoCnt = 0;
        this.videoGroupType = null;
        this.productCommentModule = null;
        this.withSameComment = null;
    }

    public final long a() {
        return this.buyerShowCount;
    }

    public final List<String> b() {
        return this.buyerShowIdList;
    }

    public final long c() {
        return this.commentCount;
    }

    public final long d() {
        return this.commentId;
    }

    public final List<String> e() {
        return this.commentTagName;
    }

    public final List<String> f() {
        return this.commentTagNum;
    }

    public final List<String> g() {
        return this.commentTagRealNum;
    }

    public final List<String> h() {
        return this.commentTagSentiments;
    }

    public final long i() {
        return this.commentTagsCount;
    }

    public final int j() {
        return this.kolAllVideoCnt;
    }

    public final String k() {
        return this.productCommentModule;
    }

    public final List<Long> l() {
        return this.questionIdList;
    }

    public final int m() {
        return this.questionNum;
    }

    public final long n() {
        return this.storeCommentCount;
    }

    public final List<String> o() {
        return this.storeCommentTagName;
    }

    public final List<String> p() {
        return this.storeCommentTagNum;
    }

    public final List<String> q() {
        return this.storeCommentTagRealNum;
    }

    public final List<String> r() {
        return this.storeCommentTagSentiments;
    }

    public final long s() {
        return this.storeCommentTagsCount;
    }

    public final Long t() {
        return this.userCommentLevel;
    }

    public final String u() {
        return this.videoGroupType;
    }

    public final Integer v() {
        return this.withSameComment;
    }
}
