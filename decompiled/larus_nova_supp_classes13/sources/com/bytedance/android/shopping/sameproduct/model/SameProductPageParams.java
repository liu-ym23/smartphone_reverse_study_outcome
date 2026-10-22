package com.bytedance.android.shopping.sameproduct.model;

import com.bytedance.android.shopping.anchorv3.repository.api.AnchorV3PromotionRequestParam;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\"\u0018\u00002\u00020\u0001B\u009f\u0002\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006\u0012\b\b\u0002\u0010\n\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u001e¢\u0006\u0002\u0010\u001fR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010!R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010!R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010!\"\u0004\b%\u0010&R\u0019\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u001e¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0015\u0010\u0012\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010+\u001a\u0004\b)\u0010*R\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010,R\u0011\u0010\n\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010,R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010!R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b1\u0010!R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b2\u0010,R\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b3\u0010!R\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b4\u0010!R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b5\u0010!R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b6\u0010!R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b7\u0010!R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b8\u00109R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b:\u0010!R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b;\u0010!R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b<\u0010!R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b=\u0010!R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b>\u0010!R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b?\u0010!¨\u0006@"}, d2 = {"Lcom/bytedance/android/shopping/sameproduct/model/SameProductPageParams;", "Ljava/io/Serializable;", "mainProductId", "", "mainPromotionId", "mainProductIsValid", "", "sameProductStyle", "", "isFromFlowGuessULike", "isFullScreenFlowPage", "authorId", "secAuthorId", "userId", "secUserId", "videoId", "shopId", "enterFrom", "followStatus", "ecomEntranceForm", "metaParams", "entranceInfo", "requestAdditions", "v3EventsAdditions", "isReceptor", "mainCardRequestParam", "Lcom/bytedance/android/shopping/anchorv3/repository/api/AnchorV3PromotionRequestParam;", "mainProductRequestId", "mainProductRecommendInfo", "filterProductIds", "", "(Ljava/lang/String;Ljava/lang/String;ZIZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/android/shopping/anchorv3/repository/api/AnchorV3PromotionRequestParam;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getAuthorId", "()Ljava/lang/String;", "getEcomEntranceForm", "getEnterFrom", "getEntranceInfo", "setEntranceInfo", "(Ljava/lang/String;)V", "getFilterProductIds", "()Ljava/util/List;", "getFollowStatus", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "()Z", "getMainCardRequestParam", "()Lcom/bytedance/android/shopping/anchorv3/repository/api/AnchorV3PromotionRequestParam;", "setMainCardRequestParam", "(Lcom/bytedance/android/shopping/anchorv3/repository/api/AnchorV3PromotionRequestParam;)V", "getMainProductId", "getMainProductIsValid", "getMainProductRecommendInfo", "getMainProductRequestId", "getMainPromotionId", "getMetaParams", "getRequestAdditions", "getSameProductStyle", "()I", "getSecAuthorId", "getSecUserId", "getShopId", "getUserId", "getV3EventsAdditions", "getVideoId", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SameProductPageParams implements Serializable {
    private final String authorId;
    private final String ecomEntranceForm;
    private final String enterFrom;
    private String entranceInfo;
    private final List<String> filterProductIds;
    private final Integer followStatus;
    private final boolean isFromFlowGuessULike;
    private final boolean isFullScreenFlowPage;
    private final String isReceptor;
    private AnchorV3PromotionRequestParam mainCardRequestParam;
    private final String mainProductId;
    private final boolean mainProductIsValid;
    private final String mainProductRecommendInfo;
    private final String mainProductRequestId;
    private final String mainPromotionId;
    private final String metaParams;
    private final String requestAdditions;
    private final int sameProductStyle;
    private final String secAuthorId;
    private final String secUserId;
    private final String shopId;
    private final String userId;
    private final String v3EventsAdditions;
    private final String videoId;

    public SameProductPageParams() {
        this(null, null, false, 0, false, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 16777215, null);
    }

    public final String getAuthorId() {
        return this.authorId;
    }

    public final String getEcomEntranceForm() {
        return this.ecomEntranceForm;
    }

    public final String getEnterFrom() {
        return this.enterFrom;
    }

    public final String getEntranceInfo() {
        return this.entranceInfo;
    }

    public final List<String> getFilterProductIds() {
        return this.filterProductIds;
    }

    public final Integer getFollowStatus() {
        return this.followStatus;
    }

    public final AnchorV3PromotionRequestParam getMainCardRequestParam() {
        return this.mainCardRequestParam;
    }

    public final String getMainProductId() {
        return this.mainProductId;
    }

    public final boolean getMainProductIsValid() {
        return this.mainProductIsValid;
    }

    public final String getMainProductRecommendInfo() {
        return this.mainProductRecommendInfo;
    }

    public final String getMainProductRequestId() {
        return this.mainProductRequestId;
    }

    public final String getMainPromotionId() {
        return this.mainPromotionId;
    }

    public final String getMetaParams() {
        return this.metaParams;
    }

    public final String getRequestAdditions() {
        return this.requestAdditions;
    }

    public final int getSameProductStyle() {
        return this.sameProductStyle;
    }

    public final String getSecAuthorId() {
        return this.secAuthorId;
    }

    public final String getSecUserId() {
        return this.secUserId;
    }

    public final String getShopId() {
        return this.shopId;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final String getV3EventsAdditions() {
        return this.v3EventsAdditions;
    }

    public final String getVideoId() {
        return this.videoId;
    }

    public final boolean isFromFlowGuessULike() {
        return this.isFromFlowGuessULike;
    }

    public final boolean isFullScreenFlowPage() {
        return this.isFullScreenFlowPage;
    }

    public final String isReceptor() {
        return this.isReceptor;
    }

    public final void setEntranceInfo(String r1) {
        this.entranceInfo = r1;
    }

    public final void setMainCardRequestParam(AnchorV3PromotionRequestParam r1) {
        this.mainCardRequestParam = r1;
    }

    public SameProductPageParams(String r5, String r6, boolean r7, int r8, boolean r9, boolean r10, String r11, String r12, String r13, String r14, String r15, String r16, String r17, Integer r18, String r19, String r20, String r21, String r22, String r23, String r24, AnchorV3PromotionRequestParam r25, String r26, String r27, List<String> r28) {
        Intrinsics.checkNotNullParameter(r5, "mainProductId");
        Intrinsics.checkNotNullParameter(r6, "mainPromotionId");
        this.mainProductId = r5;
        this.mainPromotionId = r6;
        this.mainProductIsValid = r7;
        this.sameProductStyle = r8;
        this.isFromFlowGuessULike = r9;
        this.isFullScreenFlowPage = r10;
        this.authorId = r11;
        this.secAuthorId = r12;
        this.userId = r13;
        this.secUserId = r14;
        this.videoId = r15;
        this.shopId = r16;
        this.enterFrom = r17;
        this.followStatus = r18;
        this.ecomEntranceForm = r19;
        this.metaParams = r20;
        this.entranceInfo = r21;
        this.requestAdditions = r22;
        this.v3EventsAdditions = r23;
        this.isReceptor = r24;
        this.mainCardRequestParam = r25;
        this.mainProductRequestId = r26;
        this.mainProductRecommendInfo = r27;
        this.filterProductIds = r28;
    }

    public /* synthetic */ SameProductPageParams(String r27, String r28, boolean r29, int r30, boolean r31, boolean r32, String r33, String r34, String r35, String r36, String r37, String r38, String r39, Integer r40, String r41, String r42, String r43, String r44, String r45, String r46, AnchorV3PromotionRequestParam r47, String r48, String r49, List r50, int r51, DefaultConstructorMarker r52) {
        if ((r51 & 1) == 0) goto L5;
        String r1 = "";
    L7:
        if ((r51 & 2) == 0) goto L9;
        String r3 = "";
    L10:
        boolean r5 = false;
        if ((r51 & 4) == 0) goto L13;
        boolean r4 = false;
    L15:
        if ((r51 & 8) == 0) goto L17;
        int r6 = 0;
    L19:
        if ((r51 & 16) == 0) goto L21;
        boolean r7 = false;
    L23:
        if ((r51 & 32) != 0) goto L27;
        r5 = r32;
    L27:
        if ((r51 & 64) == 0) goto L29;
        String r8 = "";
    L31:
        if ((r51 & 128) == 0) goto L33;
        String r9 = "";
    L35:
        if ((r51 & 256) == 0) goto L37;
        String r10 = "";
    L39:
        if ((r51 & 512) == 0) goto L41;
        String r11 = "";
    L43:
        if ((r51 & 1024) == 0) goto L45;
        String r12 = "";
    L47:
        if ((r51 & 2048) == 0) goto L49;
        String r13 = "";
    L51:
        if ((r51 & 4096) == 0) goto L53;
        String r14 = "";
    L54:
        List r16 = null;
        if ((r51 & 8192) == 0) goto L57;
        Integer r15 = null;
    L59:
        if ((r51 & 16384) == 0) goto L61;
        String r2 = "";
    L63:
        if ((r51 & 32768) == 0) goto L65;
        String r17 = null;
    L67:
        if ((r51 & 65536) == 0) goto L69;
        String r18 = null;
    L71:
        if ((r51 & 131072) == 0) goto L73;
        String r19 = null;
    L75:
        if ((r51 & 262144) == 0) goto L77;
        String r20 = null;
    L79:
        if ((r51 & 524288) == 0) goto L81;
        String r21 = null;
    L83:
        if ((r51 & 1048576) == 0) goto L85;
        AnchorV3PromotionRequestParam r22 = null;
    L87:
        if ((r51 & 2097152) == 0) goto L89;
        String r23 = null;
    L91:
        if ((r51 & 4194304) == 0) goto L93;
        String r24 = null;
    L95:
        if ((r51 & 8388608) != 0) goto L98;
        r16 = r50;
    L98:
        this(r1, r3, r4, r6, r7, r5, r8, r9, r10, r11, r12, r13, r14, r15, r2, r17, r18, r19, r20, r21, r22, r23, r24, r16);
        return;
    L93:
        r24 = r49;
        goto L95
    L89:
        r23 = r48;
        goto L91
    L85:
        r22 = r47;
        goto L87
    L81:
        r21 = r46;
        goto L83
    L77:
        r20 = r45;
        goto L79
    L73:
        r19 = r44;
        goto L75
    L69:
        r18 = r43;
        goto L71
    L65:
        r17 = r42;
        goto L67
    L61:
        r2 = r41;
        goto L63
    L57:
        r15 = r40;
        goto L59
    L53:
        r14 = r39;
        goto L54
    L49:
        r13 = r38;
        goto L51
    L45:
        r12 = r37;
        goto L47
    L41:
        r11 = r36;
        goto L43
    L37:
        r10 = r35;
        goto L39
    L33:
        r9 = r34;
        goto L35
    L29:
        r8 = r33;
        goto L31
    L21:
        r7 = r31;
        goto L23
    L17:
        r6 = r30;
        goto L19
    L13:
        r4 = r29;
        goto L15
    L9:
        r3 = r28;
        goto L10
    L5:
        r1 = r27;
        goto L7
    }
}
