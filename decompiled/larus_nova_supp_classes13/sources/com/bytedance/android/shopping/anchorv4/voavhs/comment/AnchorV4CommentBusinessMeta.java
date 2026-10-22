package com.bytedance.android.shopping.anchorv4.voavhs.comment;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b \b\u0086\b\u0018\u00002\u00020\u0001Bã\u0001\u0012\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0006\u0012\u0012\b\u0002\u0010\u001b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\u001e\u001a\u00020\f\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010 \u001a\u00020\u000f\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\t\u0012\u0010\b\u0002\u0010$\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010%\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010&\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0002¢\u0006\u0004\bI\u0010JJ\u0011\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002HÆ\u0003J\u0011\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0013\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0002HÆ\u0003J\u0011\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\tHÆ\u0003J\t\u0010\r\u001a\u00020\fHÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\tHÆ\u0003J\t\u0010\u0010\u001a\u00020\u000fHÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0011\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0002HÆ\u0003J\u0011\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0002HÆ\u0003J\u0011\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0002HÆ\u0003Jå\u0001\u0010'\u001a\u00020\u00002\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0010\b\u0002\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00062\u0012\b\u0002\u0010\u001b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00022\u0010\b\u0002\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00022\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\u001e\u001a\u00020\f2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010 \u001a\u00020\u000f2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\t2\u0010\b\u0002\u0010$\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00022\u0010\b\u0002\u0010%\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00022\u0010\b\u0002\u0010&\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0002HÆ\u0001J\t\u0010(\u001a\u00020\tHÖ\u0001J\t\u0010*\u001a\u00020)HÖ\u0001J\u0013\u0010-\u001a\u00020\u000f2\b\u0010,\u001a\u0004\u0018\u00010+HÖ\u0003R\"\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010.\u001a\u0004\b/\u00100R\"\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010.\u001a\u0004\b1\u00100R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u00102\u001a\u0004\b3\u00104R$\u0010\u001b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010.\u001a\u0004\b5\u00100R\"\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010.\u001a\u0004\b6\u00100R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u00107\u001a\u0004\b8\u00109R\u001a\u0010\u001e\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010:\u001a\u0004\b;\u0010<R\u001c\u0010\u001f\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u00107\u001a\u0004\b=\u00109R\u001a\u0010 \u001a\u00020\u000f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b \u0010>\u001a\u0004\b?\u0010@R\u001c\u0010!\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b!\u0010A\u001a\u0004\bB\u0010CR\u001c\u0010\"\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\"\u00107\u001a\u0004\bD\u00109R\u001c\u0010#\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b#\u00107\u001a\u0004\bE\u00109R\"\u0010$\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b$\u0010.\u001a\u0004\bF\u00100R\"\u0010%\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b%\u0010.\u001a\u0004\bG\u00100R\"\u0010&\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b&\u0010.\u001a\u0004\bH\u00100¨\u0006K"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/comment/AnchorV4CommentBusinessMeta;", "Ljava/io/Serializable;", "", "Lcom/bytedance/android/shopping/anchorv4/voavhs/comment/AnchorV4CommentTagStruct;", "component1", "component2", "Lcom/bytedance/android/shopping/anchorv4/voavhs/comment/AnchorV4CommentMediaMeta;", "component3", "component4", "", "component5", "component6", "", "component7", "component8", "", "component9", "Lcom/bytedance/android/shopping/anchorv4/voavhs/comment/a;", "component10", "component11", "component12", "component13", "component14", "component15", "tagJump", "storeTagJump", "commentMediaJump", "commentMediaJumpList", "buyerShowMediaJump", "kolReviewVideoLink", "kolReviewAuthorId", "kolReviewVideoId", "hasProductComment", "askAroundLink", "kolVideoPlaySchema", "kolVideoListSchema", "kolAwemeIdList", "kolAuthorIdList", "kolVideoTypeList", "copy", "toString", "", "hashCode", "", "other", "equals", "Ljava/util/List;", "getTagJump", "()Ljava/util/List;", "getStoreTagJump", "Lcom/bytedance/android/shopping/anchorv4/voavhs/comment/AnchorV4CommentMediaMeta;", "getCommentMediaJump", "()Lcom/bytedance/android/shopping/anchorv4/voavhs/comment/AnchorV4CommentMediaMeta;", "getCommentMediaJumpList", "getBuyerShowMediaJump", "Ljava/lang/String;", "getKolReviewVideoLink", "()Ljava/lang/String;", "J", "getKolReviewAuthorId", "()J", "getKolReviewVideoId", "Z", "getHasProductComment", "()Z", "Lcom/bytedance/android/shopping/anchorv4/voavhs/comment/a;", "getAskAroundLink", "()Lcom/bytedance/android/shopping/anchorv4/voavhs/comment/a;", "getKolVideoPlaySchema", "getKolVideoListSchema", "getKolAwemeIdList", "getKolAuthorIdList", "getKolVideoTypeList", "<init>", "(Ljava/util/List;Ljava/util/List;Lcom/bytedance/android/shopping/anchorv4/voavhs/comment/AnchorV4CommentMediaMeta;Ljava/util/List;Ljava/util/List;Ljava/lang/String;JLjava/lang/String;ZLcom/bytedance/android/shopping/anchorv4/voavhs/comment/a;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV4CommentBusinessMeta implements Serializable {

    @SerializedName("ask_around_link")
    private final a askAroundLink;

    @SerializedName("buyer_show_media_jump")
    private final List<String> buyerShowMediaJump;

    @SerializedName("comment_media_jump")
    private final AnchorV4CommentMediaMeta commentMediaJump;

    @SerializedName("comment_media_jump_list")
    private final List<AnchorV4CommentMediaMeta> commentMediaJumpList;

    @SerializedName("has_product_comment")
    private final boolean hasProductComment;

    @SerializedName("kol_author_id_list")
    private final List<String> kolAuthorIdList;

    @SerializedName("kol_aweme_id_list")
    private final List<String> kolAwemeIdList;

    @SerializedName("kol_review_author_id")
    private final long kolReviewAuthorId;

    @SerializedName("kol_review_video_id")
    private final String kolReviewVideoId;

    @SerializedName("kol_review_video_link")
    private final String kolReviewVideoLink;

    @SerializedName("kol_video_list_schema")
    private final String kolVideoListSchema;

    @SerializedName("kol_video_play_schema")
    private final String kolVideoPlaySchema;

    @SerializedName("kol_video_type_list")
    private final List<String> kolVideoTypeList;

    @SerializedName("store_tag_jump")
    private final List<AnchorV4CommentTagStruct> storeTagJump;

    @SerializedName("tag_jump")
    private final List<AnchorV4CommentTagStruct> tagJump;

    public AnchorV4CommentBusinessMeta() {
        this(null, null, null, null, null, null, 0, null, false, null, null, null, null, null, null, 32767, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AnchorV4CommentBusinessMeta copy$default(AnchorV4CommentBusinessMeta r16, List r17, List r18, AnchorV4CommentMediaMeta r19, List r20, List r21, String r22, long r23, String r25, boolean r26, a r27, String r28, String r29, List r30, List r31, List r32, int r33, Object r34) {
        if ((r33 & 1) == 0) goto L5;
        List r2 = r16.tagJump;
    L7:
        if ((r33 & 2) == 0) goto L9;
        List r3 = r16.storeTagJump;
    L11:
        if ((r33 & 4) == 0) goto L13;
        AnchorV4CommentMediaMeta r4 = r16.commentMediaJump;
    L15:
        if ((r33 & 8) == 0) goto L17;
        List r5 = r16.commentMediaJumpList;
    L19:
        if ((r33 & 16) == 0) goto L21;
        List r6 = r16.buyerShowMediaJump;
    L23:
        if ((r33 & 32) == 0) goto L25;
        String r7 = r16.kolReviewVideoLink;
    L27:
        if ((r33 & 64) == 0) goto L29;
        long r8 = r16.kolReviewAuthorId;
    L31:
        if ((r33 & 128) == 0) goto L33;
        String r10 = r16.kolReviewVideoId;
    L35:
        if ((r33 & 256) == 0) goto L37;
        boolean r11 = r16.hasProductComment;
    L39:
        if ((r33 & 512) == 0) goto L41;
        a r12 = r16.askAroundLink;
    L43:
        if ((r33 & 1024) == 0) goto L45;
        String r13 = r16.kolVideoPlaySchema;
    L47:
        if ((r33 & 2048) == 0) goto L49;
        String r14 = r16.kolVideoListSchema;
    L51:
        if ((r33 & 4096) == 0) goto L53;
        List r15 = r16.kolAwemeIdList;
    L54:
        List r35 = r15;
        if ((r33 & 8192) == 0) goto L57;
        List r110 = r16.kolAuthorIdList;
    L59:
        if ((r33 & 16384) == 0) goto L61;
        List r1 = r16.kolVideoTypeList;
    L63:
        return r16.copy(r2, r3, r4, r5, r6, r7, r8, r10, r11, r12, r13, r14, r35, r110, r1);
    L61:
        r1 = r32;
        goto L63
    L57:
        r110 = r31;
        goto L59
    L53:
        r15 = r30;
        goto L54
    L49:
        r14 = r29;
        goto L51
    L45:
        r13 = r28;
        goto L47
    L41:
        r12 = r27;
        goto L43
    L37:
        r11 = r26;
        goto L39
    L33:
        r10 = r25;
        goto L35
    L29:
        r8 = r23;
        goto L31
    L25:
        r7 = r22;
        goto L27
    L21:
        r6 = r21;
        goto L23
    L17:
        r5 = r20;
        goto L19
    L13:
        r4 = r19;
        goto L15
    L9:
        r3 = r18;
        goto L11
    L5:
        r2 = r17;
        goto L7
    }

    public final List<AnchorV4CommentTagStruct> component1() {
        return this.tagJump;
    }

    public final a component10() {
        return this.askAroundLink;
    }

    public final String component11() {
        return this.kolVideoPlaySchema;
    }

    public final String component12() {
        return this.kolVideoListSchema;
    }

    public final List<String> component13() {
        return this.kolAwemeIdList;
    }

    public final List<String> component14() {
        return this.kolAuthorIdList;
    }

    public final List<String> component15() {
        return this.kolVideoTypeList;
    }

    public final List<AnchorV4CommentTagStruct> component2() {
        return this.storeTagJump;
    }

    public final AnchorV4CommentMediaMeta component3() {
        return this.commentMediaJump;
    }

    public final List<AnchorV4CommentMediaMeta> component4() {
        return this.commentMediaJumpList;
    }

    public final List<String> component5() {
        return this.buyerShowMediaJump;
    }

    public final String component6() {
        return this.kolReviewVideoLink;
    }

    public final long component7() {
        return this.kolReviewAuthorId;
    }

    public final String component8() {
        return this.kolReviewVideoId;
    }

    public final boolean component9() {
        return this.hasProductComment;
    }

    public final AnchorV4CommentBusinessMeta copy(List<AnchorV4CommentTagStruct> r19, List<AnchorV4CommentTagStruct> r20, AnchorV4CommentMediaMeta r21, List<AnchorV4CommentMediaMeta> r22, List<String> r23, String r24, long r25, String r27, boolean r28, a r29, String r30, String r31, List<String> r32, List<String> r33, List<String> r34) {
        return new AnchorV4CommentBusinessMeta(r19, r20, r21, r22, r23, r24, r25, r27, r28, r29, r30, r31, r32, r33, r34);
    }

    public boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof AnchorV4CommentBusinessMeta) == false) goto L36;
        AnchorV4CommentBusinessMeta r7 = (AnchorV4CommentBusinessMeta) r6;
        if (Intrinsics.areEqual(this.tagJump, r7.tagJump) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.storeTagJump, r7.storeTagJump) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.commentMediaJump, r7.commentMediaJump) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.commentMediaJumpList, r7.commentMediaJumpList) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.buyerShowMediaJump, r7.buyerShowMediaJump) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.kolReviewVideoLink, r7.kolReviewVideoLink) == true) goto L18;
        return false;
    L18:
        if (this.kolReviewAuthorId == r7.kolReviewAuthorId) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.kolReviewVideoId, r7.kolReviewVideoId) == true) goto L22;
        return false;
    L22:
        if (this.hasProductComment == r7.hasProductComment) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.askAroundLink, r7.askAroundLink) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.kolVideoPlaySchema, r7.kolVideoPlaySchema) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.kolVideoListSchema, r7.kolVideoListSchema) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.kolAwemeIdList, r7.kolAwemeIdList) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.kolAuthorIdList, r7.kolAuthorIdList) == true) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.kolVideoTypeList, r7.kolVideoTypeList) == true) goto L55;
        return false;
    L55:
        return true;
    L36:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v21, types: [int] */
    /* JADX WARN: Type inference failed for: r2v43 */
    /* JADX WARN: Type inference failed for: r2v50 */
    public int hashCode() {
        List<AnchorV4CommentTagStruct> r0 = this.tagJump;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        List<AnchorV4CommentTagStruct> r4 = this.storeTagJump;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        AnchorV4CommentMediaMeta r7 = this.commentMediaJump;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        List<AnchorV4CommentMediaMeta> r10 = this.commentMediaJumpList;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        List<String> r13 = this.buyerShowMediaJump;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.kolReviewVideoLink;
        if (r16 == null) goto L25;
        int r17 = r16.hashCode();
    L26:
        int r18 = (r15 + r17) * 31;
        long r19 = this.kolReviewAuthorId;
        int r20 = (r18 + ((int) (r19 ^ (r19 >>> 32)))) * 31;
        String r21 = this.kolReviewVideoId;
        if (r21 == null) goto L29;
        int r22 = r21.hashCode();
    L30:
        int r23 = (r20 + r22) * 31;
        boolean r24 = this.hasProductComment;
        ?? r25 = r24;
        if (r24 == false) goto L33;
        r25 = 1;
    L33:
        int r26 = (r23 + r25) * 31;
        a r27 = this.askAroundLink;
        if (r27 == null) goto L36;
        int r28 = r27.hashCode();
    L37:
        int r29 = (r26 + r28) * 31;
        String r30 = this.kolVideoPlaySchema;
        if (r30 == null) goto L40;
        int r31 = r30.hashCode();
    L41:
        int r32 = (r29 + r31) * 31;
        String r33 = this.kolVideoListSchema;
        if (r33 == null) goto L44;
        int r34 = r33.hashCode();
    L45:
        int r35 = (r32 + r34) * 31;
        List<String> r36 = this.kolAwemeIdList;
        if (r36 == null) goto L48;
        int r37 = r36.hashCode();
    L49:
        int r38 = (r35 + r37) * 31;
        List<String> r39 = this.kolAuthorIdList;
        if (r39 == null) goto L52;
        int r40 = r39.hashCode();
    L53:
        int r41 = (r38 + r40) * 31;
        List<String> r42 = this.kolVideoTypeList;
        if (r42 == null) goto L57;
        r1 = r42.hashCode();
    L57:
        return r41 + r1;
    L52:
        r40 = 0;
        goto L53
    L48:
        r37 = 0;
        goto L49
    L44:
        r34 = 0;
        goto L45
    L40:
        r31 = 0;
        goto L41
    L36:
        r28 = 0;
        goto L37
    L29:
        r22 = 0;
        goto L30
    L25:
        r17 = 0;
        goto L26
    L21:
        r14 = 0;
        goto L22
    L17:
        r11 = 0;
        goto L18
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "AnchorV4CommentBusinessMeta(tagJump=" + this.tagJump + ", storeTagJump=" + this.storeTagJump + ", commentMediaJump=" + this.commentMediaJump + ", commentMediaJumpList=" + this.commentMediaJumpList + ", buyerShowMediaJump=" + this.buyerShowMediaJump + ", kolReviewVideoLink=" + this.kolReviewVideoLink + ", kolReviewAuthorId=" + this.kolReviewAuthorId + ", kolReviewVideoId=" + this.kolReviewVideoId + ", hasProductComment=" + this.hasProductComment + ", askAroundLink=" + this.askAroundLink + ", kolVideoPlaySchema=" + this.kolVideoPlaySchema + ", kolVideoListSchema=" + this.kolVideoListSchema + ", kolAwemeIdList=" + this.kolAwemeIdList + ", kolAuthorIdList=" + this.kolAuthorIdList + ", kolVideoTypeList=" + this.kolVideoTypeList + ")";
    }

    public final a getAskAroundLink() {
        return this.askAroundLink;
    }

    public final List<String> getBuyerShowMediaJump() {
        return this.buyerShowMediaJump;
    }

    public final AnchorV4CommentMediaMeta getCommentMediaJump() {
        return this.commentMediaJump;
    }

    public final List<AnchorV4CommentMediaMeta> getCommentMediaJumpList() {
        return this.commentMediaJumpList;
    }

    public final boolean getHasProductComment() {
        return this.hasProductComment;
    }

    public final List<String> getKolAuthorIdList() {
        return this.kolAuthorIdList;
    }

    public final List<String> getKolAwemeIdList() {
        return this.kolAwemeIdList;
    }

    public final long getKolReviewAuthorId() {
        return this.kolReviewAuthorId;
    }

    public final String getKolReviewVideoId() {
        return this.kolReviewVideoId;
    }

    public final String getKolReviewVideoLink() {
        return this.kolReviewVideoLink;
    }

    public final String getKolVideoListSchema() {
        return this.kolVideoListSchema;
    }

    public final String getKolVideoPlaySchema() {
        return this.kolVideoPlaySchema;
    }

    public final List<String> getKolVideoTypeList() {
        return this.kolVideoTypeList;
    }

    public final List<AnchorV4CommentTagStruct> getStoreTagJump() {
        return this.storeTagJump;
    }

    public final List<AnchorV4CommentTagStruct> getTagJump() {
        return this.tagJump;
    }

    public AnchorV4CommentBusinessMeta(List<AnchorV4CommentTagStruct> r4, List<AnchorV4CommentTagStruct> r5, AnchorV4CommentMediaMeta r6, List<AnchorV4CommentMediaMeta> r7, List<String> r8, String r9, long r10, String r12, boolean r13, a r14, String r15, String r16, List<String> r17, List<String> r18, List<String> r19) {
        this.tagJump = r4;
        this.storeTagJump = r5;
        this.commentMediaJump = r6;
        this.commentMediaJumpList = r7;
        this.buyerShowMediaJump = r8;
        this.kolReviewVideoLink = r9;
        this.kolReviewAuthorId = r10;
        this.kolReviewVideoId = r12;
        this.hasProductComment = r13;
        this.askAroundLink = r14;
        this.kolVideoPlaySchema = r15;
        this.kolVideoListSchema = r16;
        this.kolAwemeIdList = r17;
        this.kolAuthorIdList = r18;
        this.kolVideoTypeList = r19;
    }

    public /* synthetic */ AnchorV4CommentBusinessMeta(List r17, List r18, AnchorV4CommentMediaMeta r19, List r20, List r21, String r22, long r23, String r25, boolean r26, a r27, String r28, String r29, List r30, List r31, List r32, int r33, DefaultConstructorMarker r34) {
        if ((r33 & 1) == 0) goto L5;
        List r1 = null;
    L7:
        if ((r33 & 2) == 0) goto L9;
        List r3 = null;
    L11:
        if ((r33 & 4) == 0) goto L13;
        AnchorV4CommentMediaMeta r4 = null;
    L15:
        if ((r33 & 8) == 0) goto L17;
        List r5 = null;
    L19:
        if ((r33 & 16) == 0) goto L21;
        List r6 = null;
    L23:
        if ((r33 & 32) == 0) goto L25;
        String r7 = null;
    L27:
        if ((r33 & 64) == 0) goto L29;
        long r8 = 0;
    L31:
        if ((r33 & 128) == 0) goto L33;
        String r10 = null;
    L35:
        if ((r33 & 256) == 0) goto L37;
        boolean r11 = false;
    L39:
        if ((r33 & 512) == 0) goto L41;
        a r12 = null;
    L43:
        if ((r33 & 1024) == 0) goto L45;
        String r13 = null;
    L47:
        if ((r33 & 2048) == 0) goto L49;
        String r14 = null;
    L51:
        if ((r33 & 4096) == 0) goto L53;
        List r15 = null;
    L55:
        if ((r33 & 8192) == 0) goto L57;
        List r2 = null;
    L59:
        if ((r33 & 16384) == 0) goto L61;
        List r0 = null;
    L62:
        this(r1, r3, r4, r5, r6, r7, r8, r10, r11, r12, r13, r14, r15, r2, r0);
        return;
    L61:
        r0 = r32;
        goto L62
    L57:
        r2 = r31;
        goto L59
    L53:
        r15 = r30;
        goto L55
    L49:
        r14 = r29;
        goto L51
    L45:
        r13 = r28;
        goto L47
    L41:
        r12 = r27;
        goto L43
    L37:
        r11 = r26;
        goto L39
    L33:
        r10 = r25;
        goto L35
    L29:
        r8 = r23;
        goto L31
    L25:
        r7 = r22;
        goto L27
    L21:
        r6 = r21;
        goto L23
    L17:
        r5 = r20;
        goto L19
    L13:
        r4 = r19;
        goto L15
    L9:
        r3 = r18;
        goto L11
    L5:
        r1 = r17;
        goto L7
    }
}
