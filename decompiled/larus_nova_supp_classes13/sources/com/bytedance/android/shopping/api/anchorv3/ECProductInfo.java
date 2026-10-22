package com.bytedance.android.shopping.api.anchorv3;

import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.response.anchorv3.SourceType;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b)\u0018\u00002\u00020\u0001B\u0097\u0002\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\t\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001b¢\u0006\u0002\u0010\u001fR\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010!R\u0015\u0010\u0019\u001a\u0004\u0018\u00010\u0010¢\u0006\n\n\u0002\u0010%\u001a\u0004\b#\u0010$R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010!\"\u0004\b)\u0010*R\u0015\u0010\u0016\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010-\u001a\u0004\b+\u0010,R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b.\u0010!R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b/\u0010!R\u0015\u0010\u0014\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010-\u001a\u0004\b0\u0010,R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b1\u0010!R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0015\u0010\u001a\u001a\u0004\u0018\u00010\u001b¢\u0006\n\n\u0002\u00105\u001a\u0004\b\u001a\u00104R\u0015\u0010\u001e\u001a\u0004\u0018\u00010\u001b¢\u0006\n\n\u0002\u00105\u001a\u0004\b\u001e\u00104R\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b6\u0010!R\u0015\u0010\u0013\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010-\u001a\u0004\b7\u0010,R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b8\u0010!R\"\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u0011\u0010\u000e\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b=\u0010'R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b>\u0010!R\u0015\u0010\u0012\u001a\u0004\u0018\u00010\u0010¢\u0006\n\n\u0002\u0010%\u001a\u0004\b?\u0010$R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b@\u0010!R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\bA\u0010BR\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bC\u0010!¨\u0006D"}, d2 = {"Lcom/bytedance/android/shopping/api/anchorv3/ECProductInfo;", "Ljava/io/Serializable;", "currentPromotionId", "", "productId", "rankId", "promotionIds", "", "commodityType", "", "headImg", "Lcom/bytedance/android/ec/model/ECUrlModel;", "frameCovImage", "shopId", "promotionSource", "status", "", "title", "salesNum", "price", "frontCategoryId", "frontCategoryName", "firstCategoryId", "firstCategoryName", "channelId", "channelType", "isDirectSubmitOrder", "", "bizCampaignType", "nGroupBuyToken", "isOptCode", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;JLcom/bytedance/android/ec/model/ECUrlModel;Ljava/lang/String;Ljava/lang/String;JILjava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "getBizCampaignType", "()Ljava/lang/String;", "getChannelId", "getChannelType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getCommodityType", "()J", "getCurrentPromotionId", "setCurrentPromotionId", "(Ljava/lang/String;)V", "getFirstCategoryId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getFirstCategoryName", "getFrameCovImage", "getFrontCategoryId", "getFrontCategoryName", "getHeadImg", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getNGroupBuyToken", "getPrice", "getProductId", "getPromotionIds", "()Ljava/util/List;", "setPromotionIds", "(Ljava/util/List;)V", "getPromotionSource", "getRankId", "getSalesNum", "getShopId", "getStatus", "()I", "getTitle", "ec-shopping-api_release"}, k = 1, mv = {1, 4, 3})
public final class ECProductInfo implements Serializable {
    private final String bizCampaignType;
    private final String channelId;
    private final Integer channelType;
    private final long commodityType;
    private String currentPromotionId;
    private final Long firstCategoryId;
    private final String firstCategoryName;
    private final String frameCovImage;
    private final Long frontCategoryId;
    private final String frontCategoryName;
    private final ECUrlModel headImg;
    private final Boolean isDirectSubmitOrder;
    private final Boolean isOptCode;
    private final String nGroupBuyToken;
    private final Long price;
    private final String productId;
    private List<String> promotionIds;
    private final long promotionSource;
    private final String rankId;
    private final Integer salesNum;
    private final String shopId;
    private final int status;
    private final String title;

    public ECProductInfo() {
        this(null, null, null, null, 0, null, null, null, 0, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, 8388607, null);
    }

    public final String getBizCampaignType() {
        return this.bizCampaignType;
    }

    public final String getChannelId() {
        return this.channelId;
    }

    public final Integer getChannelType() {
        return this.channelType;
    }

    public final long getCommodityType() {
        return this.commodityType;
    }

    public final String getCurrentPromotionId() {
        return this.currentPromotionId;
    }

    public final Long getFirstCategoryId() {
        return this.firstCategoryId;
    }

    public final String getFirstCategoryName() {
        return this.firstCategoryName;
    }

    public final String getFrameCovImage() {
        return this.frameCovImage;
    }

    public final Long getFrontCategoryId() {
        return this.frontCategoryId;
    }

    public final String getFrontCategoryName() {
        return this.frontCategoryName;
    }

    public final ECUrlModel getHeadImg() {
        return this.headImg;
    }

    public final String getNGroupBuyToken() {
        return this.nGroupBuyToken;
    }

    public final Long getPrice() {
        return this.price;
    }

    public final String getProductId() {
        return this.productId;
    }

    public final List<String> getPromotionIds() {
        return this.promotionIds;
    }

    public final long getPromotionSource() {
        return this.promotionSource;
    }

    public final String getRankId() {
        return this.rankId;
    }

    public final Integer getSalesNum() {
        return this.salesNum;
    }

    public final String getShopId() {
        return this.shopId;
    }

    public final int getStatus() {
        return this.status;
    }

    public final String getTitle() {
        return this.title;
    }

    public final Boolean isDirectSubmitOrder() {
        return this.isDirectSubmitOrder;
    }

    public final Boolean isOptCode() {
        return this.isOptCode;
    }

    public final void setCurrentPromotionId(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.currentPromotionId = r2;
    }

    public final void setPromotionIds(List<String> r1) {
        this.promotionIds = r1;
    }

    public ECProductInfo(String r4, String r5, String r6, List<String> r7, long r8, ECUrlModel r10, String r11, String r12, long r13, int r15, String r16, Integer r17, Long r18, Long r19, String r20, Long r21, String r22, String r23, Integer r24, Boolean r25, String r26, String r27, Boolean r28) {
        Intrinsics.checkNotNullParameter(r4, "currentPromotionId");
        this.currentPromotionId = r4;
        this.productId = r5;
        this.rankId = r6;
        this.promotionIds = r7;
        this.commodityType = r8;
        this.headImg = r10;
        this.frameCovImage = r11;
        this.shopId = r12;
        this.promotionSource = r13;
        this.status = r15;
        this.title = r16;
        this.salesNum = r17;
        this.price = r18;
        this.frontCategoryId = r19;
        this.frontCategoryName = r20;
        this.firstCategoryId = r21;
        this.firstCategoryName = r22;
        this.channelId = r23;
        this.channelType = r24;
        this.isDirectSubmitOrder = r25;
        this.bizCampaignType = r26;
        this.nGroupBuyToken = r27;
        this.isOptCode = r28;
    }

    public /* synthetic */ ECProductInfo(String r26, String r27, String r28, List r29, long r30, ECUrlModel r32, String r33, String r34, long r35, int r37, String r38, Integer r39, Long r40, Long r41, String r42, Long r43, String r44, String r45, Integer r46, Boolean r47, String r48, String r49, Boolean r50, int r51, DefaultConstructorMarker r52) {
        if ((r51 & 1) == 0) goto L5;
        String r1 = "";
    L7:
        if ((r51 & 2) == 0) goto L9;
        String r2 = null;
    L11:
        if ((r51 & 4) == 0) goto L13;
        String r4 = null;
    L15:
        if ((r51 & 8) == 0) goto L17;
        List r5 = null;
    L19:
        if ((r51 & 16) == 0) goto L21;
        long r9 = 0;
    L23:
        if ((r51 & 32) == 0) goto L25;
        ECUrlModel r6 = null;
    L27:
        if ((r51 & 64) == 0) goto L29;
        String r11 = null;
    L31:
        if ((r51 & 128) == 0) goto L33;
        String r12 = null;
    L35:
        if ((r51 & 256) == 0) goto L37;
        long r13 = SourceType.UNKNOWN.getType();
    L39:
        if ((r51 & 512) == 0) goto L41;
        int r15 = 1;
    L43:
        if ((r51 & 1024) == 0) goto L45;
        String r3 = null;
    L47:
        if ((r51 & 2048) == 0) goto L49;
        Integer r7 = 0;
    L51:
        if ((r51 & 4096) == 0) goto L53;
        Long r8 = 0L;
    L54:
        Long r53 = r8;
        if ((r51 & 8192) == 0) goto L57;
        Long r10 = null;
    L58:
        Long r16 = r10;
        if ((r51 & 16384) == 0) goto L61;
        String r14 = null;
    L63:
        if ((r51 & 32768) == 0) goto L65;
        Long r17 = null;
    L67:
        if ((r51 & 65536) == 0) goto L69;
        String r18 = null;
    L71:
        if ((r51 & 131072) == 0) goto L73;
        String r19 = null;
    L75:
        if ((r51 & 262144) == 0) goto L77;
        Integer r20 = 0;
    L79:
        if ((r51 & 524288) == 0) goto L81;
        Boolean r21 = Boolean.FALSE;
    L83:
        if ((r51 & 1048576) == 0) goto L85;
        String r22 = null;
    L87:
        if ((r51 & 2097152) == 0) goto L89;
        String r23 = null;
    L91:
        if ((r51 & 4194304) == 0) goto L93;
        Boolean r0 = Boolean.FALSE;
    L94:
        this(r1, r2, r4, r5, r9, r6, r11, r12, r13, r15, r3, r7, r53, r16, r14, r17, r18, r19, r20, r21, r22, r23, r0);
        return;
    L93:
        r0 = r50;
        goto L94
    L89:
        r23 = r49;
        goto L91
    L85:
        r22 = r48;
        goto L87
    L81:
        r21 = r47;
        goto L83
    L77:
        r20 = r46;
        goto L79
    L73:
        r19 = r45;
        goto L75
    L69:
        r18 = r44;
        goto L71
    L65:
        r17 = r43;
        goto L67
    L61:
        r14 = r42;
        goto L63
    L57:
        r10 = r41;
        goto L58
    L53:
        r8 = r40;
        goto L54
    L49:
        r7 = r39;
        goto L51
    L45:
        r3 = r38;
        goto L47
    L41:
        r15 = r37;
        goto L43
    L37:
        r13 = r35;
        goto L39
    L33:
        r12 = r34;
        goto L35
    L29:
        r11 = r33;
        goto L31
    L25:
        r6 = r32;
        goto L27
    L21:
        r9 = r30;
        goto L23
    L17:
        r5 = r29;
        goto L19
    L13:
        r4 = r28;
        goto L15
    L9:
        r2 = r27;
        goto L11
    L5:
        r1 = r26;
        goto L7
    }
}
