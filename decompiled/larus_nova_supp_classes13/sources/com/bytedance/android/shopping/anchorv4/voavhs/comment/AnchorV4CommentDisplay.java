package com.bytedance.android.shopping.anchorv4.voavhs.comment;

import com.bytedance.android.shopping.anchorv4.dto.components.LongContentLabelComponent;
import com.bytedance.android.shopping.anchorv4.dto.components.MediaScrollBoxComponent;
import com.bytedance.android.shopping.anchorv4.dto.components.TagsScrollBoxComponent;
import com.bytedance.android.shopping.anchorv4.dto.elements.KolReviewElement;
import com.bytedance.android.shopping.anchorv4.dto.elements.MediaBoxElement;
import com.bytedance.android.shopping.anchorv4.dto.elements.TextElement;
import com.bytedance.android.shopping.anchorv4.dto.elements.TextWithOneIconElement;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b.\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B÷\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\b\u0012\u0010\b\u0002\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018\u0012\u0010\b\u0002\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u000f\u0012\u0012\b\u0002\u0010\u001b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001c\u0018\u00010\u000f¢\u0006\u0002\u0010\u001dJ\u000b\u00107\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0014HÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0011\u0010=\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u000fHÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0018HÆ\u0003J\u0011\u0010?\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u000fHÆ\u0003J\u0013\u0010@\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001c\u0018\u00010\u000fHÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010F\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010H\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000fHÆ\u0003Jû\u0001\u0010I\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\b2\u0010\b\u0002\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u000f2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0010\b\u0002\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u000f2\u0012\b\u0002\u0010\u001b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001c\u0018\u00010\u000fHÆ\u0001J\u0013\u0010J\u001a\u00020K2\b\u0010L\u001a\u0004\u0018\u00010MHÖ\u0003J\t\u0010N\u001a\u00020OHÖ\u0001J\t\u0010P\u001a\u00020QHÖ\u0001R\u001e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0018\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0018\u0010\f\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010!R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0018\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010#R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010!R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010)R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010&R\u001e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u001fR\u001e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u001fR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u0010!R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00188\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R \u0010\u001b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001c\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u0010\u001fR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b5\u0010)R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b6\u0010!¨\u0006R"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/comment/AnchorV4CommentDisplay;", "Ljava/io/Serializable;", "commentTitle", "Lcom/bytedance/android/shopping/anchorv4/dto/components/LongContentLabelComponent;", "commentTags", "Lcom/bytedance/android/shopping/anchorv4/dto/components/TagsScrollBoxComponent;", "commentUser", "commentDesc", "Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextElement;", "commentMedias", "Lcom/bytedance/android/shopping/anchorv4/dto/components/MediaScrollBoxComponent;", "buyersShowTitle", "buyersShowMedias", "askAroundTitle", "askAroundItems", "", "otherGoodsReviewTitle", "otherGoodsReviewTags", "kolReviewTitle", "kolReviewUser", "Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextWithOneIconElement;", "kolReviewContent", "kolReviewStatistics", "kolReviewVideo", "Lcom/bytedance/android/shopping/anchorv4/dto/elements/MediaBoxElement;", "kolReviewList", "Lcom/bytedance/android/shopping/anchorv4/dto/elements/KolReviewElement;", "multiComments", "Lcom/bytedance/android/shopping/anchorv4/voavhs/comment/MultiCommentComponent;", "(Lcom/bytedance/android/shopping/anchorv4/dto/components/LongContentLabelComponent;Lcom/bytedance/android/shopping/anchorv4/dto/components/TagsScrollBoxComponent;Lcom/bytedance/android/shopping/anchorv4/dto/components/TagsScrollBoxComponent;Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextElement;Lcom/bytedance/android/shopping/anchorv4/dto/components/MediaScrollBoxComponent;Lcom/bytedance/android/shopping/anchorv4/dto/components/LongContentLabelComponent;Lcom/bytedance/android/shopping/anchorv4/dto/components/MediaScrollBoxComponent;Lcom/bytedance/android/shopping/anchorv4/dto/components/LongContentLabelComponent;Ljava/util/List;Lcom/bytedance/android/shopping/anchorv4/dto/components/LongContentLabelComponent;Lcom/bytedance/android/shopping/anchorv4/dto/components/TagsScrollBoxComponent;Lcom/bytedance/android/shopping/anchorv4/dto/components/LongContentLabelComponent;Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextWithOneIconElement;Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextElement;Ljava/util/List;Lcom/bytedance/android/shopping/anchorv4/dto/elements/MediaBoxElement;Ljava/util/List;Ljava/util/List;)V", "getAskAroundItems", "()Ljava/util/List;", "getAskAroundTitle", "()Lcom/bytedance/android/shopping/anchorv4/dto/components/LongContentLabelComponent;", "getBuyersShowMedias", "()Lcom/bytedance/android/shopping/anchorv4/dto/components/MediaScrollBoxComponent;", "getBuyersShowTitle", "getCommentDesc", "()Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextElement;", "getCommentMedias", "getCommentTags", "()Lcom/bytedance/android/shopping/anchorv4/dto/components/TagsScrollBoxComponent;", "getCommentTitle", "getCommentUser", "getKolReviewContent", "getKolReviewList", "getKolReviewStatistics", "getKolReviewTitle", "getKolReviewUser", "()Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextWithOneIconElement;", "getKolReviewVideo", "()Lcom/bytedance/android/shopping/anchorv4/dto/elements/MediaBoxElement;", "getMultiComments", "getOtherGoodsReviewTags", "getOtherGoodsReviewTitle", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV4CommentDisplay implements Serializable {

    @SerializedName("ask_around_items")
    private final List<LongContentLabelComponent> askAroundItems;

    @SerializedName("ask_around_title")
    private final LongContentLabelComponent askAroundTitle;

    @SerializedName("buyers_show_medias")
    private final MediaScrollBoxComponent buyersShowMedias;

    @SerializedName("buyers_show_title")
    private final LongContentLabelComponent buyersShowTitle;

    @SerializedName("comment_desc")
    private final TextElement commentDesc;

    @SerializedName("comment_medias")
    private final MediaScrollBoxComponent commentMedias;

    @SerializedName("comment_tags")
    private final TagsScrollBoxComponent commentTags;

    @SerializedName("comment_title")
    private final LongContentLabelComponent commentTitle;

    @SerializedName("comment_user")
    private final TagsScrollBoxComponent commentUser;

    @SerializedName("kol_review_content")
    private final TextElement kolReviewContent;

    @SerializedName("kol_review_list")
    private final List<KolReviewElement> kolReviewList;

    @SerializedName("kol_review_statistics")
    private final List<TextWithOneIconElement> kolReviewStatistics;

    @SerializedName("kol_review_title")
    private final LongContentLabelComponent kolReviewTitle;

    @SerializedName("kol_review_user")
    private final TextWithOneIconElement kolReviewUser;

    @SerializedName("kol_review_video")
    private final MediaBoxElement kolReviewVideo;

    @SerializedName("multi_comments")
    private final List<MultiCommentComponent> multiComments;

    @SerializedName("other_goods_review_tags")
    private final TagsScrollBoxComponent otherGoodsReviewTags;

    @SerializedName("other_goods_review_title")
    private final LongContentLabelComponent otherGoodsReviewTitle;

    public AnchorV4CommentDisplay() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 262143, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AnchorV4CommentDisplay copy$default(AnchorV4CommentDisplay r17, LongContentLabelComponent r18, TagsScrollBoxComponent r19, TagsScrollBoxComponent r20, TextElement r21, MediaScrollBoxComponent r22, LongContentLabelComponent r23, MediaScrollBoxComponent r24, LongContentLabelComponent r25, List r26, LongContentLabelComponent r27, TagsScrollBoxComponent r28, LongContentLabelComponent r29, TextWithOneIconElement r30, TextElement r31, List r32, MediaBoxElement r33, List r34, List r35, int r36, Object r37) {
        if ((r36 & 1) == 0) goto L5;
        LongContentLabelComponent r2 = r17.commentTitle;
    L7:
        if ((r36 & 2) == 0) goto L9;
        TagsScrollBoxComponent r3 = r17.commentTags;
    L11:
        if ((r36 & 4) == 0) goto L13;
        TagsScrollBoxComponent r4 = r17.commentUser;
    L15:
        if ((r36 & 8) == 0) goto L17;
        TextElement r5 = r17.commentDesc;
    L19:
        if ((r36 & 16) == 0) goto L21;
        MediaScrollBoxComponent r6 = r17.commentMedias;
    L23:
        if ((r36 & 32) == 0) goto L25;
        LongContentLabelComponent r7 = r17.buyersShowTitle;
    L27:
        if ((r36 & 64) == 0) goto L29;
        MediaScrollBoxComponent r8 = r17.buyersShowMedias;
    L31:
        if ((r36 & 128) == 0) goto L33;
        LongContentLabelComponent r9 = r17.askAroundTitle;
    L35:
        if ((r36 & 256) == 0) goto L37;
        List r10 = r17.askAroundItems;
    L39:
        if ((r36 & 512) == 0) goto L41;
        LongContentLabelComponent r11 = r17.otherGoodsReviewTitle;
    L43:
        if ((r36 & 1024) == 0) goto L45;
        TagsScrollBoxComponent r12 = r17.otherGoodsReviewTags;
    L47:
        if ((r36 & 2048) == 0) goto L49;
        LongContentLabelComponent r13 = r17.kolReviewTitle;
    L51:
        if ((r36 & 4096) == 0) goto L53;
        TextWithOneIconElement r14 = r17.kolReviewUser;
    L55:
        if ((r36 & 8192) == 0) goto L57;
        TextElement r15 = r17.kolReviewContent;
    L58:
        TextElement r38 = r15;
        if ((r36 & 16384) == 0) goto L61;
        List r16 = r17.kolReviewStatistics;
    L62:
        List r39 = r16;
        if ((r36 & 32768) == 0) goto L65;
        MediaBoxElement r110 = r17.kolReviewVideo;
    L66:
        MediaBoxElement r310 = r110;
        if ((r36 & 65536) == 0) goto L69;
        List r111 = r17.kolReviewList;
    L71:
        if ((r36 & 131072) == 0) goto L73;
        List r1 = r17.multiComments;
    L75:
        return r17.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r38, r39, r310, r111, r1);
    L73:
        r1 = r35;
        goto L75
    L69:
        r111 = r34;
        goto L71
    L65:
        r110 = r33;
        goto L66
    L61:
        r16 = r32;
        goto L62
    L57:
        r15 = r31;
        goto L58
    L53:
        r14 = r30;
        goto L55
    L49:
        r13 = r29;
        goto L51
    L45:
        r12 = r28;
        goto L47
    L41:
        r11 = r27;
        goto L43
    L37:
        r10 = r26;
        goto L39
    L33:
        r9 = r25;
        goto L35
    L29:
        r8 = r24;
        goto L31
    L25:
        r7 = r23;
        goto L27
    L21:
        r6 = r22;
        goto L23
    L17:
        r5 = r21;
        goto L19
    L13:
        r4 = r20;
        goto L15
    L9:
        r3 = r19;
        goto L11
    L5:
        r2 = r18;
        goto L7
    }

    public final LongContentLabelComponent component1() {
        return this.commentTitle;
    }

    public final LongContentLabelComponent component10() {
        return this.otherGoodsReviewTitle;
    }

    public final TagsScrollBoxComponent component11() {
        return this.otherGoodsReviewTags;
    }

    public final LongContentLabelComponent component12() {
        return this.kolReviewTitle;
    }

    public final TextWithOneIconElement component13() {
        return this.kolReviewUser;
    }

    public final TextElement component14() {
        return this.kolReviewContent;
    }

    public final List<TextWithOneIconElement> component15() {
        return this.kolReviewStatistics;
    }

    public final MediaBoxElement component16() {
        return this.kolReviewVideo;
    }

    public final List<KolReviewElement> component17() {
        return this.kolReviewList;
    }

    public final List<MultiCommentComponent> component18() {
        return this.multiComments;
    }

    public final TagsScrollBoxComponent component2() {
        return this.commentTags;
    }

    public final TagsScrollBoxComponent component3() {
        return this.commentUser;
    }

    public final TextElement component4() {
        return this.commentDesc;
    }

    public final MediaScrollBoxComponent component5() {
        return this.commentMedias;
    }

    public final LongContentLabelComponent component6() {
        return this.buyersShowTitle;
    }

    public final MediaScrollBoxComponent component7() {
        return this.buyersShowMedias;
    }

    public final LongContentLabelComponent component8() {
        return this.askAroundTitle;
    }

    public final List<LongContentLabelComponent> component9() {
        return this.askAroundItems;
    }

    public final AnchorV4CommentDisplay copy(LongContentLabelComponent r21, TagsScrollBoxComponent r22, TagsScrollBoxComponent r23, TextElement r24, MediaScrollBoxComponent r25, LongContentLabelComponent r26, MediaScrollBoxComponent r27, LongContentLabelComponent r28, List<? extends LongContentLabelComponent> r29, LongContentLabelComponent r30, TagsScrollBoxComponent r31, LongContentLabelComponent r32, TextWithOneIconElement r33, TextElement r34, List<TextWithOneIconElement> r35, MediaBoxElement r36, List<KolReviewElement> r37, List<MultiCommentComponent> r38) {
        return new AnchorV4CommentDisplay(r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof AnchorV4CommentDisplay) == false) goto L42;
        AnchorV4CommentDisplay r4 = (AnchorV4CommentDisplay) r3;
        if (Intrinsics.areEqual(this.commentTitle, r4.commentTitle) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.commentTags, r4.commentTags) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.commentUser, r4.commentUser) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.commentDesc, r4.commentDesc) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.commentMedias, r4.commentMedias) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.buyersShowTitle, r4.buyersShowTitle) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.buyersShowMedias, r4.buyersShowMedias) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.askAroundTitle, r4.askAroundTitle) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.askAroundItems, r4.askAroundItems) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.otherGoodsReviewTitle, r4.otherGoodsReviewTitle) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.otherGoodsReviewTags, r4.otherGoodsReviewTags) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.kolReviewTitle, r4.kolReviewTitle) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.kolReviewUser, r4.kolReviewUser) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.kolReviewContent, r4.kolReviewContent) == true) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.kolReviewStatistics, r4.kolReviewStatistics) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.kolReviewVideo, r4.kolReviewVideo) == true) goto L38;
        return false;
    L38:
        if (Intrinsics.areEqual(this.kolReviewList, r4.kolReviewList) == true) goto L40;
        return false;
    L40:
        if (Intrinsics.areEqual(this.multiComments, r4.multiComments) == true) goto L64;
        return false;
    L64:
        return true;
    L42:
        return false;
    }

    public int hashCode() {
        LongContentLabelComponent r0 = this.commentTitle;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        TagsScrollBoxComponent r4 = this.commentTags;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        TagsScrollBoxComponent r7 = this.commentUser;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        TextElement r10 = this.commentDesc;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        MediaScrollBoxComponent r13 = this.commentMedias;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        LongContentLabelComponent r16 = this.buyersShowTitle;
        if (r16 == null) goto L25;
        int r17 = r16.hashCode();
    L26:
        int r18 = (r15 + r17) * 31;
        MediaScrollBoxComponent r19 = this.buyersShowMedias;
        if (r19 == null) goto L29;
        int r20 = r19.hashCode();
    L30:
        int r21 = (r18 + r20) * 31;
        LongContentLabelComponent r22 = this.askAroundTitle;
        if (r22 == null) goto L33;
        int r23 = r22.hashCode();
    L34:
        int r24 = (r21 + r23) * 31;
        List<LongContentLabelComponent> r25 = this.askAroundItems;
        if (r25 == null) goto L37;
        int r26 = r25.hashCode();
    L38:
        int r27 = (r24 + r26) * 31;
        LongContentLabelComponent r28 = this.otherGoodsReviewTitle;
        if (r28 == null) goto L41;
        int r29 = r28.hashCode();
    L42:
        int r30 = (r27 + r29) * 31;
        TagsScrollBoxComponent r31 = this.otherGoodsReviewTags;
        if (r31 == null) goto L45;
        int r32 = r31.hashCode();
    L46:
        int r33 = (r30 + r32) * 31;
        LongContentLabelComponent r34 = this.kolReviewTitle;
        if (r34 == null) goto L49;
        int r35 = r34.hashCode();
    L50:
        int r36 = (r33 + r35) * 31;
        TextWithOneIconElement r37 = this.kolReviewUser;
        if (r37 == null) goto L53;
        int r38 = r37.hashCode();
    L54:
        int r39 = (r36 + r38) * 31;
        TextElement r40 = this.kolReviewContent;
        if (r40 == null) goto L57;
        int r41 = r40.hashCode();
    L58:
        int r42 = (r39 + r41) * 31;
        List<TextWithOneIconElement> r43 = this.kolReviewStatistics;
        if (r43 == null) goto L61;
        int r44 = r43.hashCode();
    L62:
        int r45 = (r42 + r44) * 31;
        MediaBoxElement r46 = this.kolReviewVideo;
        if (r46 == null) goto L65;
        int r47 = r46.hashCode();
    L66:
        int r48 = (r45 + r47) * 31;
        List<KolReviewElement> r49 = this.kolReviewList;
        if (r49 == null) goto L69;
        int r50 = r49.hashCode();
    L70:
        int r51 = (r48 + r50) * 31;
        List<MultiCommentComponent> r52 = this.multiComments;
        if (r52 == null) goto L74;
        r1 = r52.hashCode();
    L74:
        return r51 + r1;
    L69:
        r50 = 0;
        goto L70
    L65:
        r47 = 0;
        goto L66
    L61:
        r44 = 0;
        goto L62
    L57:
        r41 = 0;
        goto L58
    L53:
        r38 = 0;
        goto L54
    L49:
        r35 = 0;
        goto L50
    L45:
        r32 = 0;
        goto L46
    L41:
        r29 = 0;
        goto L42
    L37:
        r26 = 0;
        goto L38
    L33:
        r23 = 0;
        goto L34
    L29:
        r20 = 0;
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
        return "AnchorV4CommentDisplay(commentTitle=" + this.commentTitle + ", commentTags=" + this.commentTags + ", commentUser=" + this.commentUser + ", commentDesc=" + this.commentDesc + ", commentMedias=" + this.commentMedias + ", buyersShowTitle=" + this.buyersShowTitle + ", buyersShowMedias=" + this.buyersShowMedias + ", askAroundTitle=" + this.askAroundTitle + ", askAroundItems=" + this.askAroundItems + ", otherGoodsReviewTitle=" + this.otherGoodsReviewTitle + ", otherGoodsReviewTags=" + this.otherGoodsReviewTags + ", kolReviewTitle=" + this.kolReviewTitle + ", kolReviewUser=" + this.kolReviewUser + ", kolReviewContent=" + this.kolReviewContent + ", kolReviewStatistics=" + this.kolReviewStatistics + ", kolReviewVideo=" + this.kolReviewVideo + ", kolReviewList=" + this.kolReviewList + ", multiComments=" + this.multiComments + ")";
    }

    public final List<LongContentLabelComponent> getAskAroundItems() {
        return this.askAroundItems;
    }

    public final LongContentLabelComponent getAskAroundTitle() {
        return this.askAroundTitle;
    }

    public final MediaScrollBoxComponent getBuyersShowMedias() {
        return this.buyersShowMedias;
    }

    public final LongContentLabelComponent getBuyersShowTitle() {
        return this.buyersShowTitle;
    }

    public final TextElement getCommentDesc() {
        return this.commentDesc;
    }

    public final MediaScrollBoxComponent getCommentMedias() {
        return this.commentMedias;
    }

    public final TagsScrollBoxComponent getCommentTags() {
        return this.commentTags;
    }

    public final LongContentLabelComponent getCommentTitle() {
        return this.commentTitle;
    }

    public final TagsScrollBoxComponent getCommentUser() {
        return this.commentUser;
    }

    public final TextElement getKolReviewContent() {
        return this.kolReviewContent;
    }

    public final List<KolReviewElement> getKolReviewList() {
        return this.kolReviewList;
    }

    public final List<TextWithOneIconElement> getKolReviewStatistics() {
        return this.kolReviewStatistics;
    }

    public final LongContentLabelComponent getKolReviewTitle() {
        return this.kolReviewTitle;
    }

    public final TextWithOneIconElement getKolReviewUser() {
        return this.kolReviewUser;
    }

    public final MediaBoxElement getKolReviewVideo() {
        return this.kolReviewVideo;
    }

    public final List<MultiCommentComponent> getMultiComments() {
        return this.multiComments;
    }

    public final TagsScrollBoxComponent getOtherGoodsReviewTags() {
        return this.otherGoodsReviewTags;
    }

    public final LongContentLabelComponent getOtherGoodsReviewTitle() {
        return this.otherGoodsReviewTitle;
    }

    public AnchorV4CommentDisplay(LongContentLabelComponent r3, TagsScrollBoxComponent r4, TagsScrollBoxComponent r5, TextElement r6, MediaScrollBoxComponent r7, LongContentLabelComponent r8, MediaScrollBoxComponent r9, LongContentLabelComponent r10, List<? extends LongContentLabelComponent> r11, LongContentLabelComponent r12, TagsScrollBoxComponent r13, LongContentLabelComponent r14, TextWithOneIconElement r15, TextElement r16, List<TextWithOneIconElement> r17, MediaBoxElement r18, List<KolReviewElement> r19, List<MultiCommentComponent> r20) {
        this.commentTitle = r3;
        this.commentTags = r4;
        this.commentUser = r5;
        this.commentDesc = r6;
        this.commentMedias = r7;
        this.buyersShowTitle = r8;
        this.buyersShowMedias = r9;
        this.askAroundTitle = r10;
        this.askAroundItems = r11;
        this.otherGoodsReviewTitle = r12;
        this.otherGoodsReviewTags = r13;
        this.kolReviewTitle = r14;
        this.kolReviewUser = r15;
        this.kolReviewContent = r16;
        this.kolReviewStatistics = r17;
        this.kolReviewVideo = r18;
        this.kolReviewList = r19;
        this.multiComments = r20;
    }

    public /* synthetic */ AnchorV4CommentDisplay(LongContentLabelComponent r20, TagsScrollBoxComponent r21, TagsScrollBoxComponent r22, TextElement r23, MediaScrollBoxComponent r24, LongContentLabelComponent r25, MediaScrollBoxComponent r26, LongContentLabelComponent r27, List r28, LongContentLabelComponent r29, TagsScrollBoxComponent r30, LongContentLabelComponent r31, TextWithOneIconElement r32, TextElement r33, List r34, MediaBoxElement r35, List r36, List r37, int r38, DefaultConstructorMarker r39) {
        if ((r38 & 1) == 0) goto L5;
        LongContentLabelComponent r1 = null;
    L7:
        if ((r38 & 2) == 0) goto L9;
        TagsScrollBoxComponent r3 = null;
    L11:
        if ((r38 & 4) == 0) goto L13;
        TagsScrollBoxComponent r4 = null;
    L15:
        if ((r38 & 8) == 0) goto L17;
        TextElement r5 = null;
    L19:
        if ((r38 & 16) == 0) goto L21;
        MediaScrollBoxComponent r6 = null;
    L23:
        if ((r38 & 32) == 0) goto L25;
        LongContentLabelComponent r7 = null;
    L27:
        if ((r38 & 64) == 0) goto L29;
        MediaScrollBoxComponent r8 = null;
    L31:
        if ((r38 & 128) == 0) goto L33;
        LongContentLabelComponent r9 = null;
    L35:
        if ((r38 & 256) == 0) goto L37;
        List r10 = null;
    L39:
        if ((r38 & 512) == 0) goto L41;
        LongContentLabelComponent r11 = null;
    L43:
        if ((r38 & 1024) == 0) goto L45;
        TagsScrollBoxComponent r12 = null;
    L47:
        if ((r38 & 2048) == 0) goto L49;
        LongContentLabelComponent r13 = null;
    L51:
        if ((r38 & 4096) == 0) goto L53;
        TextWithOneIconElement r14 = null;
    L55:
        if ((r38 & 8192) == 0) goto L57;
        TextElement r15 = null;
    L59:
        if ((r38 & 16384) == 0) goto L61;
        List r2 = null;
    L63:
        if ((r38 & 32768) == 0) goto L65;
        MediaBoxElement r16 = null;
    L67:
        if ((r38 & 65536) == 0) goto L69;
        List r17 = null;
    L71:
        if ((r38 & 131072) == 0) goto L73;
        List r0 = null;
    L74:
        this(r1, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r2, r16, r17, r0);
        return;
    L73:
        r0 = r37;
        goto L74
    L69:
        r17 = r36;
        goto L71
    L65:
        r16 = r35;
        goto L67
    L61:
        r2 = r34;
        goto L63
    L57:
        r15 = r33;
        goto L59
    L53:
        r14 = r32;
        goto L55
    L49:
        r13 = r31;
        goto L51
    L45:
        r12 = r30;
        goto L47
    L41:
        r11 = r29;
        goto L43
    L37:
        r10 = r28;
        goto L39
    L33:
        r9 = r27;
        goto L35
    L29:
        r8 = r26;
        goto L31
    L25:
        r7 = r25;
        goto L27
    L21:
        r6 = r24;
        goto L23
    L17:
        r5 = r23;
        goto L19
    L13:
        r4 = r22;
        goto L15
    L9:
        r3 = r21;
        goto L11
    L5:
        r1 = r20;
        goto L7
    }
}
