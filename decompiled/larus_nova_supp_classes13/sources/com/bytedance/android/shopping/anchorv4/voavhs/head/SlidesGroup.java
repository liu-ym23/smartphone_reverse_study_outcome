package com.bytedance.android.shopping.anchorv4.voavhs.head;

import com.bytedance.android.shopping.anchorv4.dto.base.ImageModel;
import com.bytedance.android.shopping.anchorv4.dto.base.VideoModel;
import com.bytedance.android.shopping.anchorv4.dto.elements.KolReviewElement;
import com.bytedance.android.shopping.anchorv4.dto.elements.TextElement;
import com.bytedance.android.shopping.anchorv4.voavhs.head.base.GaussianBlurConfig;
import com.bytedance.android.shopping.anchorv4.voavhs.head.vo.CommentVideoInfo;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u0000\n\u0002\b3\b\u0086\b\u0018\u00002\u00020\u0001BÝ\u0001\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010%\u001a\u00020\u0006\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\b\u0012\u0010\b\u0002\u0010'\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u0018\u0012\u0012\b\u0002\u0010/\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001a\u0018\u00010\n\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u001c\u0012\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u001e\u0012\b\b\u0002\u00102\u001a\u00020\u0014\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u00010!¢\u0006\u0004\bi\u0010jJ\u000b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010\u0007\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0011\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nHÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÆ\u0003J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0018HÆ\u0003J\u0013\u0010\u001b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001a\u0018\u00010\nHÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u001cHÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u001eHÆ\u0003J\t\u0010 \u001a\u00020\u0014HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010!HÆ\u0003Jæ\u0001\u00104\u001a\u00020\u00002\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010%\u001a\u00020\u00062\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\b2\u0010\b\u0002\u0010'\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u00182\u0012\b\u0002\u0010/\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001a\u0018\u00010\n2\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u001e2\b\b\u0002\u00102\u001a\u00020\u00142\n\b\u0002\u00103\u001a\u0004\u0018\u00010!HÆ\u0001¢\u0006\u0004\b4\u00105J\t\u00106\u001a\u00020\u0004HÖ\u0001J\t\u00107\u001a\u00020\u0006HÖ\u0001J\u0013\u0010:\u001a\u00020\u00142\b\u00109\u001a\u0004\u0018\u000108HÖ\u0003R\u001c\u0010#\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b#\u0010;\u001a\u0004\b<\u0010=R\u001c\u0010$\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b$\u0010>\u001a\u0004\b?\u0010@R\u001a\u0010%\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b%\u0010A\u001a\u0004\bB\u0010CR\u001c\u0010&\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b&\u0010D\u001a\u0004\bE\u0010FR\"\u0010'\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b'\u0010G\u001a\u0004\bH\u0010IR\u001c\u0010(\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b(\u0010J\u001a\u0004\bK\u0010LR\u001c\u0010)\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b)\u0010M\u001a\u0004\bN\u0010OR\u001c\u0010*\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b*\u0010P\u001a\u0004\bQ\u0010RR\u001c\u0010+\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b+\u0010S\u001a\u0004\bT\u0010UR\u001c\u0010,\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\f\n\u0004\b,\u0010V\u001a\u0004\bW\u0010\u0016R\u001c\u0010-\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b-\u0010>\u001a\u0004\bX\u0010@R\u001c\u0010.\u001a\u0004\u0018\u00010\u00188\u0006X\u0087\u0004¢\u0006\f\n\u0004\b.\u0010Y\u001a\u0004\bZ\u0010[R$\u0010/\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001a\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b/\u0010G\u001a\u0004\b\\\u0010IR\u001c\u00100\u001a\u0004\u0018\u00010\u001c8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b0\u0010]\u001a\u0004\b^\u0010_R\u001c\u00101\u001a\u0004\u0018\u00010\u001e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b1\u0010`\u001a\u0004\ba\u0010bR\u001a\u00102\u001a\u00020\u00148\u0006X\u0087\u0004¢\u0006\f\n\u0004\b2\u0010c\u001a\u0004\bd\u0010eR\u001c\u00103\u001a\u0004\u0018\u00010!8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b3\u0010f\u001a\u0004\bg\u0010h¨\u0006k"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/head/SlidesGroup;", "Ljava/io/Serializable;", "Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextElement;", "component1", "", "component2", "", "component3", "Lcom/bytedance/android/shopping/anchorv4/dto/base/VideoModel;", "component4", "", "Lcom/bytedance/android/shopping/anchorv4/dto/base/ImageModel;", "component5", "Lcom/bytedance/android/shopping/anchorv4/voavhs/head/CombinationElement;", "component6", "component7", "Lcom/bytedance/android/shopping/anchorv4/voavhs/head/i;", "component8", "Lcom/bytedance/android/shopping/anchorv4/voavhs/head/h;", "component9", "", "component10", "()Ljava/lang/Boolean;", "component11", "Lcom/bytedance/android/shopping/anchorv4/voavhs/head/CommonFindSameElement;", "component12", "Lcom/bytedance/android/shopping/anchorv4/dto/elements/KolReviewElement;", "component13", "Lcom/bytedance/android/shopping/anchorv4/voavhs/head/base/GaussianBlurConfig;", "component14", "Lcom/bytedance/android/shopping/anchorv4/voavhs/head/vo/CommentVideoInfo;", "component15", "component16", "Lcom/bytedance/android/shopping/anchorv4/voavhs/head/p;", "component17", "title", "tabTypeName", "type", "video", "images", "combinationElement", "entryIcon", "headCommentInfo", "goodGoodsComment", "supportPreview", "findSameGoodsSchema", "findSameGoodsTab", "pioneerElement", "backgroundControl", "kolAuthorInfo", "supportKolVideoDetail", "slice", "copy", "(Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextElement;Ljava/lang/String;ILcom/bytedance/android/shopping/anchorv4/dto/base/VideoModel;Ljava/util/List;Lcom/bytedance/android/shopping/anchorv4/voavhs/head/CombinationElement;Lcom/bytedance/android/shopping/anchorv4/dto/base/ImageModel;Lcom/bytedance/android/shopping/anchorv4/voavhs/head/i;Lcom/bytedance/android/shopping/anchorv4/voavhs/head/h;Ljava/lang/Boolean;Ljava/lang/String;Lcom/bytedance/android/shopping/anchorv4/voavhs/head/CommonFindSameElement;Ljava/util/List;Lcom/bytedance/android/shopping/anchorv4/voavhs/head/base/GaussianBlurConfig;Lcom/bytedance/android/shopping/anchorv4/voavhs/head/vo/CommentVideoInfo;ZLcom/bytedance/android/shopping/anchorv4/voavhs/head/p;)Lcom/bytedance/android/shopping/anchorv4/voavhs/head/SlidesGroup;", "toString", "hashCode", "", "other", "equals", "Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextElement;", "getTitle", "()Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextElement;", "Ljava/lang/String;", "getTabTypeName", "()Ljava/lang/String;", "I", "getType", "()I", "Lcom/bytedance/android/shopping/anchorv4/dto/base/VideoModel;", "getVideo", "()Lcom/bytedance/android/shopping/anchorv4/dto/base/VideoModel;", "Ljava/util/List;", "getImages", "()Ljava/util/List;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/head/CombinationElement;", "getCombinationElement", "()Lcom/bytedance/android/shopping/anchorv4/voavhs/head/CombinationElement;", "Lcom/bytedance/android/shopping/anchorv4/dto/base/ImageModel;", "getEntryIcon", "()Lcom/bytedance/android/shopping/anchorv4/dto/base/ImageModel;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/head/i;", "getHeadCommentInfo", "()Lcom/bytedance/android/shopping/anchorv4/voavhs/head/i;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/head/h;", "getGoodGoodsComment", "()Lcom/bytedance/android/shopping/anchorv4/voavhs/head/h;", "Ljava/lang/Boolean;", "getSupportPreview", "getFindSameGoodsSchema", "Lcom/bytedance/android/shopping/anchorv4/voavhs/head/CommonFindSameElement;", "getFindSameGoodsTab", "()Lcom/bytedance/android/shopping/anchorv4/voavhs/head/CommonFindSameElement;", "getPioneerElement", "Lcom/bytedance/android/shopping/anchorv4/voavhs/head/base/GaussianBlurConfig;", "getBackgroundControl", "()Lcom/bytedance/android/shopping/anchorv4/voavhs/head/base/GaussianBlurConfig;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/head/vo/CommentVideoInfo;", "getKolAuthorInfo", "()Lcom/bytedance/android/shopping/anchorv4/voavhs/head/vo/CommentVideoInfo;", "Z", "getSupportKolVideoDetail", "()Z", "Lcom/bytedance/android/shopping/anchorv4/voavhs/head/p;", "getSlice", "()Lcom/bytedance/android/shopping/anchorv4/voavhs/head/p;", "<init>", "(Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextElement;Ljava/lang/String;ILcom/bytedance/android/shopping/anchorv4/dto/base/VideoModel;Ljava/util/List;Lcom/bytedance/android/shopping/anchorv4/voavhs/head/CombinationElement;Lcom/bytedance/android/shopping/anchorv4/dto/base/ImageModel;Lcom/bytedance/android/shopping/anchorv4/voavhs/head/i;Lcom/bytedance/android/shopping/anchorv4/voavhs/head/h;Ljava/lang/Boolean;Ljava/lang/String;Lcom/bytedance/android/shopping/anchorv4/voavhs/head/CommonFindSameElement;Ljava/util/List;Lcom/bytedance/android/shopping/anchorv4/voavhs/head/base/GaussianBlurConfig;Lcom/bytedance/android/shopping/anchorv4/voavhs/head/vo/CommentVideoInfo;ZLcom/bytedance/android/shopping/anchorv4/voavhs/head/p;)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SlidesGroup implements Serializable {

    @SerializedName("gaussian_config")
    private final GaussianBlurConfig backgroundControl;

    @SerializedName("combination_element")
    private final CombinationElement combinationElement;

    @SerializedName("entry_icon")
    private final ImageModel entryIcon;

    @SerializedName("find_same_goods_schema")
    private final String findSameGoodsSchema;

    @SerializedName("find_same_goods_tab")
    private final CommonFindSameElement findSameGoodsTab;

    @SerializedName("good_goods_comment")
    private final h goodGoodsComment;

    @SerializedName("comment_info")
    private final i headCommentInfo;

    @SerializedName("image_list")
    private final List<ImageModel> images;

    @SerializedName("kol_author_info")
    private final CommentVideoInfo kolAuthorInfo;

    @SerializedName("kol_review_list")
    private final List<KolReviewElement> pioneerElement;

    @SerializedName("slice")
    private final p slice;

    @SerializedName("support_kol_video_detail")
    private final boolean supportKolVideoDetail;

    @SerializedName("support_preview")
    private final Boolean supportPreview;

    @SerializedName("tab_type_name")
    private final String tabTypeName;

    @SerializedName("title")
    private final TextElement title;

    @SerializedName("type")
    private final int type;

    @SerializedName("video_player_box")
    private final VideoModel video;

    public SlidesGroup() {
        this(null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, false, null, 131071, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SlidesGroup copy$default(SlidesGroup r17, TextElement r18, String r19, int r20, VideoModel r21, List r22, CombinationElement r23, ImageModel r24, i r25, h r26, Boolean r27, String r28, CommonFindSameElement r29, List r30, GaussianBlurConfig r31, CommentVideoInfo r32, boolean r33, p r34, int r35, Object r36) {
        if ((r35 & 1) == 0) goto L5;
        TextElement r2 = r17.title;
    L7:
        if ((r35 & 2) == 0) goto L9;
        String r3 = r17.tabTypeName;
    L11:
        if ((r35 & 4) == 0) goto L13;
        int r4 = r17.type;
    L15:
        if ((r35 & 8) == 0) goto L17;
        VideoModel r5 = r17.video;
    L19:
        if ((r35 & 16) == 0) goto L21;
        List r6 = r17.images;
    L23:
        if ((r35 & 32) == 0) goto L25;
        CombinationElement r7 = r17.combinationElement;
    L27:
        if ((r35 & 64) == 0) goto L29;
        ImageModel r8 = r17.entryIcon;
    L31:
        if ((r35 & 128) == 0) goto L33;
        i r9 = r17.headCommentInfo;
    L35:
        if ((r35 & 256) == 0) goto L37;
        h r10 = r17.goodGoodsComment;
    L39:
        if ((r35 & 512) == 0) goto L41;
        Boolean r11 = r17.supportPreview;
    L43:
        if ((r35 & 1024) == 0) goto L45;
        String r12 = r17.findSameGoodsSchema;
    L47:
        if ((r35 & 2048) == 0) goto L49;
        CommonFindSameElement r13 = r17.findSameGoodsTab;
    L51:
        if ((r35 & 4096) == 0) goto L53;
        List r14 = r17.pioneerElement;
    L55:
        if ((r35 & 8192) == 0) goto L57;
        GaussianBlurConfig r15 = r17.backgroundControl;
    L58:
        GaussianBlurConfig r37 = r15;
        if ((r35 & 16384) == 0) goto L61;
        CommentVideoInfo r16 = r17.kolAuthorInfo;
    L62:
        CommentVideoInfo r38 = r16;
        if ((r35 & 32768) == 0) goto L65;
        boolean r110 = r17.supportKolVideoDetail;
    L67:
        if ((r35 & 65536) == 0) goto L69;
        p r1 = r17.slice;
    L71:
        return r17.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r37, r38, r110, r1);
    L69:
        r1 = r34;
        goto L71
    L65:
        r110 = r33;
        goto L67
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

    public final TextElement component1() {
        return this.title;
    }

    public final Boolean component10() {
        return this.supportPreview;
    }

    public final String component11() {
        return this.findSameGoodsSchema;
    }

    public final CommonFindSameElement component12() {
        return this.findSameGoodsTab;
    }

    public final List<KolReviewElement> component13() {
        return this.pioneerElement;
    }

    public final GaussianBlurConfig component14() {
        return this.backgroundControl;
    }

    public final CommentVideoInfo component15() {
        return this.kolAuthorInfo;
    }

    public final boolean component16() {
        return this.supportKolVideoDetail;
    }

    public final p component17() {
        return this.slice;
    }

    public final String component2() {
        return this.tabTypeName;
    }

    public final int component3() {
        return this.type;
    }

    public final VideoModel component4() {
        return this.video;
    }

    public final List<ImageModel> component5() {
        return this.images;
    }

    public final CombinationElement component6() {
        return this.combinationElement;
    }

    public final ImageModel component7() {
        return this.entryIcon;
    }

    public final i component8() {
        return this.headCommentInfo;
    }

    public final h component9() {
        return this.goodGoodsComment;
    }

    public final SlidesGroup copy(TextElement r20, String r21, int r22, VideoModel r23, List<ImageModel> r24, CombinationElement r25, ImageModel r26, i r27, h r28, Boolean r29, String r30, CommonFindSameElement r31, List<KolReviewElement> r32, GaussianBlurConfig r33, CommentVideoInfo r34, boolean r35, p r36) {
        return new SlidesGroup(r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof SlidesGroup) == false) goto L40;
        SlidesGroup r4 = (SlidesGroup) r3;
        if (Intrinsics.areEqual(this.title, r4.title) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.tabTypeName, r4.tabTypeName) == true) goto L10;
        return false;
    L10:
        if (this.type == r4.type) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.video, r4.video) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.images, r4.images) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.combinationElement, r4.combinationElement) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.entryIcon, r4.entryIcon) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.headCommentInfo, r4.headCommentInfo) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.goodGoodsComment, r4.goodGoodsComment) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.supportPreview, r4.supportPreview) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.findSameGoodsSchema, r4.findSameGoodsSchema) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.findSameGoodsTab, r4.findSameGoodsTab) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.pioneerElement, r4.pioneerElement) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.backgroundControl, r4.backgroundControl) == true) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.kolAuthorInfo, r4.kolAuthorInfo) == true) goto L36;
        return false;
    L36:
        if (this.supportKolVideoDetail == r4.supportKolVideoDetail) goto L38;
        return false;
    L38:
        if (Intrinsics.areEqual(this.slice, r4.slice) == true) goto L61;
        return false;
    L61:
        return true;
    L40:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v41, types: [int] */
    /* JADX WARN: Type inference failed for: r2v43 */
    /* JADX WARN: Type inference failed for: r2v57 */
    public int hashCode() {
        TextElement r0 = this.title;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.tabTypeName;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (((r3 + r5) * 31) + this.type) * 31;
        VideoModel r7 = this.video;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        List<ImageModel> r10 = this.images;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        CombinationElement r13 = this.combinationElement;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        ImageModel r16 = this.entryIcon;
        if (r16 == null) goto L25;
        int r17 = r16.hashCode();
    L26:
        int r18 = (r15 + r17) * 31;
        i r19 = this.headCommentInfo;
        if (r19 == null) goto L29;
        int r20 = r19.hashCode();
    L30:
        int r21 = (r18 + r20) * 31;
        h r22 = this.goodGoodsComment;
        if (r22 == null) goto L33;
        int r23 = r22.hashCode();
    L34:
        int r24 = (r21 + r23) * 31;
        Boolean r25 = this.supportPreview;
        if (r25 == null) goto L37;
        int r26 = r25.hashCode();
    L38:
        int r27 = (r24 + r26) * 31;
        String r28 = this.findSameGoodsSchema;
        if (r28 == null) goto L41;
        int r29 = r28.hashCode();
    L42:
        int r30 = (r27 + r29) * 31;
        CommonFindSameElement r31 = this.findSameGoodsTab;
        if (r31 == null) goto L45;
        int r32 = r31.hashCode();
    L46:
        int r33 = (r30 + r32) * 31;
        List<KolReviewElement> r34 = this.pioneerElement;
        if (r34 == null) goto L49;
        int r35 = r34.hashCode();
    L50:
        int r36 = (r33 + r35) * 31;
        GaussianBlurConfig r37 = this.backgroundControl;
        if (r37 == null) goto L53;
        int r38 = r37.hashCode();
    L54:
        int r39 = (r36 + r38) * 31;
        CommentVideoInfo r40 = this.kolAuthorInfo;
        if (r40 == null) goto L57;
        int r41 = r40.hashCode();
    L58:
        int r42 = (r39 + r41) * 31;
        boolean r43 = this.supportKolVideoDetail;
        ?? r44 = r43;
        if (r43 == false) goto L61;
        r44 = 1;
    L61:
        int r45 = (r42 + r44) * 31;
        p r46 = this.slice;
        if (r46 == null) goto L65;
        r1 = r46.hashCode();
    L65:
        return r45 + r1;
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
        return "SlidesGroup(title=" + this.title + ", tabTypeName=" + this.tabTypeName + ", type=" + this.type + ", video=" + this.video + ", images=" + this.images + ", combinationElement=" + this.combinationElement + ", entryIcon=" + this.entryIcon + ", headCommentInfo=" + this.headCommentInfo + ", goodGoodsComment=" + this.goodGoodsComment + ", supportPreview=" + this.supportPreview + ", findSameGoodsSchema=" + this.findSameGoodsSchema + ", findSameGoodsTab=" + this.findSameGoodsTab + ", pioneerElement=" + this.pioneerElement + ", backgroundControl=" + this.backgroundControl + ", kolAuthorInfo=" + this.kolAuthorInfo + ", supportKolVideoDetail=" + this.supportKolVideoDetail + ", slice=" + this.slice + ")";
    }

    public final GaussianBlurConfig getBackgroundControl() {
        return this.backgroundControl;
    }

    public final CombinationElement getCombinationElement() {
        return this.combinationElement;
    }

    public final ImageModel getEntryIcon() {
        return this.entryIcon;
    }

    public final String getFindSameGoodsSchema() {
        return this.findSameGoodsSchema;
    }

    public final CommonFindSameElement getFindSameGoodsTab() {
        return this.findSameGoodsTab;
    }

    public final h getGoodGoodsComment() {
        return this.goodGoodsComment;
    }

    public final i getHeadCommentInfo() {
        return this.headCommentInfo;
    }

    public final List<ImageModel> getImages() {
        return this.images;
    }

    public final CommentVideoInfo getKolAuthorInfo() {
        return this.kolAuthorInfo;
    }

    public final List<KolReviewElement> getPioneerElement() {
        return this.pioneerElement;
    }

    public final p getSlice() {
        return this.slice;
    }

    public final boolean getSupportKolVideoDetail() {
        return this.supportKolVideoDetail;
    }

    public final Boolean getSupportPreview() {
        return this.supportPreview;
    }

    public final String getTabTypeName() {
        return this.tabTypeName;
    }

    public final TextElement getTitle() {
        return this.title;
    }

    public final int getType() {
        return this.type;
    }

    public final VideoModel getVideo() {
        return this.video;
    }

    public SlidesGroup(TextElement r3, String r4, int r5, VideoModel r6, List<ImageModel> r7, CombinationElement r8, ImageModel r9, i r10, h r11, Boolean r12, String r13, CommonFindSameElement r14, List<KolReviewElement> r15, GaussianBlurConfig r16, CommentVideoInfo r17, boolean r18, p r19) {
        this.title = r3;
        this.tabTypeName = r4;
        this.type = r5;
        this.video = r6;
        this.images = r7;
        this.combinationElement = r8;
        this.entryIcon = r9;
        this.headCommentInfo = r10;
        this.goodGoodsComment = r11;
        this.supportPreview = r12;
        this.findSameGoodsSchema = r13;
        this.findSameGoodsTab = r14;
        this.pioneerElement = r15;
        this.backgroundControl = r16;
        this.kolAuthorInfo = r17;
        this.supportKolVideoDetail = r18;
        this.slice = r19;
    }

    public /* synthetic */ SlidesGroup(TextElement r19, String r20, int r21, VideoModel r22, List r23, CombinationElement r24, ImageModel r25, i r26, h r27, Boolean r28, String r29, CommonFindSameElement r30, List r31, GaussianBlurConfig r32, CommentVideoInfo r33, boolean r34, p r35, int r36, DefaultConstructorMarker r37) {
        if ((r36 & 1) == 0) goto L5;
        TextElement r1 = null;
    L7:
        if ((r36 & 2) == 0) goto L9;
        String r3 = null;
    L11:
        if ((r36 & 4) == 0) goto L13;
        int r4 = 0;
    L15:
        if ((r36 & 8) == 0) goto L17;
        VideoModel r6 = null;
    L19:
        if ((r36 & 16) == 0) goto L21;
        List r7 = null;
    L23:
        if ((r36 & 32) == 0) goto L25;
        CombinationElement r8 = null;
    L27:
        if ((r36 & 64) == 0) goto L29;
        ImageModel r9 = null;
    L31:
        if ((r36 & 128) == 0) goto L33;
        i r10 = null;
    L35:
        if ((r36 & 256) == 0) goto L37;
        h r11 = null;
    L39:
        if ((r36 & 512) == 0) goto L41;
        Boolean r12 = null;
    L43:
        if ((r36 & 1024) == 0) goto L45;
        String r13 = null;
    L47:
        if ((r36 & 2048) == 0) goto L49;
        CommonFindSameElement r14 = null;
    L51:
        if ((r36 & 4096) == 0) goto L53;
        List r15 = null;
    L55:
        if ((r36 & 8192) == 0) goto L57;
        GaussianBlurConfig r2 = null;
    L59:
        if ((r36 & 16384) == 0) goto L61;
        CommentVideoInfo r5 = null;
    L63:
        if ((r36 & 32768) == 0) goto L65;
        boolean r16 = false;
    L67:
        if ((r36 & 65536) == 0) goto L69;
        p r0 = null;
    L70:
        this(r1, r3, r4, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r2, r5, r16, r0);
        return;
    L69:
        r0 = r35;
        goto L70
    L65:
        r16 = r34;
        goto L67
    L61:
        r5 = r33;
        goto L63
    L57:
        r2 = r32;
        goto L59
    L53:
        r15 = r31;
        goto L55
    L49:
        r14 = r30;
        goto L51
    L45:
        r13 = r29;
        goto L47
    L41:
        r12 = r28;
        goto L43
    L37:
        r11 = r27;
        goto L39
    L33:
        r10 = r26;
        goto L35
    L29:
        r9 = r25;
        goto L31
    L25:
        r8 = r24;
        goto L27
    L21:
        r7 = r23;
        goto L23
    L17:
        r6 = r22;
        goto L19
    L13:
        r4 = r21;
        goto L15
    L9:
        r3 = r20;
        goto L11
    L5:
        r1 = r19;
        goto L7
    }
}
