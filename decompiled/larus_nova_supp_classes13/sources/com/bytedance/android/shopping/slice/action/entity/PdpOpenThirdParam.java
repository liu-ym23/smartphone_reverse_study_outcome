package com.bytedance.android.shopping.slice.action.entity;

import com.bytedance.android.ec.model.ECAdLogExtra;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001a\b\u0086\b\u0018\u0000 B2\u00020\u0001:\u0001CB¯\u0001\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b@\u0010AJ\u000b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u0004\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÆ\u0003J¸\u0001\u0010$\u001a\u00020\u00002\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0014HÆ\u0001¢\u0006\u0004\b$\u0010%J\t\u0010&\u001a\u00020\u0002HÖ\u0001J\t\u0010'\u001a\u00020\u000eHÖ\u0001J\u0013\u0010+\u001a\u00020*2\b\u0010)\u001a\u0004\u0018\u00010(HÖ\u0003R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010,\u001a\u0004\b-\u0010.R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010,\u001a\u0004\b/\u0010.R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010,\u001a\u0004\b0\u0010.R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u00101\u001a\u0004\b2\u0010\bR\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010,\u001a\u0004\b3\u0010.R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010,\u001a\u0004\b4\u0010.R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010,\u001a\u0004\b5\u0010.R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010,\u001a\u0004\b6\u0010.R\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010,\u001a\u0004\b7\u0010.R\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u00108\u001a\u0004\b9\u0010\u0010R\u001c\u0010 \u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b \u0010,\u001a\u0004\b:\u0010.R\u001c\u0010!\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b!\u0010,\u001a\u0004\b;\u0010.R\u001c\u0010\"\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\"\u0010,\u001a\u0004\b<\u0010.R\u001c\u0010#\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\f\n\u0004\b#\u0010=\u001a\u0004\b>\u0010?¨\u0006D"}, d2 = {"Lcom/bytedance/android/shopping/slice/action/entity/PdpOpenThirdParam;", "Ljava/io/Serializable;", "", "component1", "component2", "component3", "", "component4", "()Ljava/lang/Long;", "component5", "component6", "component7", "component8", "component9", "", "component10", "()Ljava/lang/Integer;", "component11", "component12", "component13", "Lcom/bytedance/android/ec/model/ECAdLogExtra;", "component14", "orderUrl", "smallAppUrl", "openAppUrl", "promotionSource", "promotionId", "productId", "itemId", "secAuthorId", "authorId", "followStatus", "sourcePage", "pageName", "carrierType", "adLogExtra", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/android/ec/model/ECAdLogExtra;)Lcom/bytedance/android/shopping/slice/action/entity/PdpOpenThirdParam;", "toString", "hashCode", "", "other", "", "equals", "Ljava/lang/String;", "getOrderUrl", "()Ljava/lang/String;", "getSmallAppUrl", "getOpenAppUrl", "Ljava/lang/Long;", "getPromotionSource", "getPromotionId", "getProductId", "getItemId", "getSecAuthorId", "getAuthorId", "Ljava/lang/Integer;", "getFollowStatus", "getSourcePage", "getPageName", "getCarrierType", "Lcom/bytedance/android/ec/model/ECAdLogExtra;", "getAdLogExtra", "()Lcom/bytedance/android/ec/model/ECAdLogExtra;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/android/ec/model/ECAdLogExtra;)V", "Companion", "a", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PdpOpenThirdParam implements Serializable {
    public static final a Companion = null;
    public static final String KEY_AD_LOG_EXTRA = "ad_log_extra";
    public static final String KEY_AUTHOR_ID = "author_id";
    public static final String KEY_CARRIER_TYPE = "carrier_type";
    public static final String KEY_FOLLOW_STATUS = "follow_status";
    public static final String KEY_ITEM_ID = "item_id";
    public static final String KEY_OPEN_APP_URL = "open_app_url";
    public static final String KEY_ORDER_URL = "order_url";
    public static final String KEY_PAGE_NAME = "page_name";
    public static final String KEY_PRODUCT_ID = "product_id";
    public static final String KEY_PROMOTION_ID = "promotion_id";
    public static final String KEY_PROMOTION_SOURCE = "promotion_source";
    public static final String KEY_SEC_AUTHOR_ID = "sec_author_id";
    public static final String KEY_SMALL_APP_URL = "small_app_url";
    public static final String KEY_SOURCE_PAGE = "source_page";

    @SerializedName(KEY_AD_LOG_EXTRA)
    private final ECAdLogExtra adLogExtra;

    @SerializedName("author_id")
    private final String authorId;

    @SerializedName(KEY_CARRIER_TYPE)
    private final String carrierType;

    @SerializedName(KEY_FOLLOW_STATUS)
    private final Integer followStatus;

    @SerializedName(KEY_ITEM_ID)
    private final String itemId;

    @SerializedName(KEY_OPEN_APP_URL)
    private final String openAppUrl;

    @SerializedName(KEY_ORDER_URL)
    private final String orderUrl;

    @SerializedName(KEY_PAGE_NAME)
    private final String pageName;

    @SerializedName(KEY_PRODUCT_ID)
    private final String productId;

    @SerializedName(KEY_PROMOTION_ID)
    private final String promotionId;

    @SerializedName(KEY_PROMOTION_SOURCE)
    private final Long promotionSource;

    @SerializedName(KEY_SEC_AUTHOR_ID)
    private final String secAuthorId;

    @SerializedName("small_app_url")
    private final String smallAppUrl;

    @SerializedName(KEY_SOURCE_PAGE)
    private final String sourcePage;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public PdpOpenThirdParam() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, 16383, null);
    }

    public static /* synthetic */ PdpOpenThirdParam copy$default(PdpOpenThirdParam r15, String r16, String r17, String r18, Long r19, String r20, String r21, String r22, String r23, String r24, Integer r25, String r26, String r27, String r28, ECAdLogExtra r29, int r30, Object r31) {
        if ((r30 & 1) == 0) goto L5;
        String r2 = r15.orderUrl;
    L7:
        if ((r30 & 2) == 0) goto L9;
        String r3 = r15.smallAppUrl;
    L11:
        if ((r30 & 4) == 0) goto L13;
        String r4 = r15.openAppUrl;
    L15:
        if ((r30 & 8) == 0) goto L17;
        Long r5 = r15.promotionSource;
    L19:
        if ((r30 & 16) == 0) goto L21;
        String r6 = r15.promotionId;
    L23:
        if ((r30 & 32) == 0) goto L25;
        String r7 = r15.productId;
    L27:
        if ((r30 & 64) == 0) goto L29;
        String r8 = r15.itemId;
    L31:
        if ((r30 & 128) == 0) goto L33;
        String r9 = r15.secAuthorId;
    L35:
        if ((r30 & 256) == 0) goto L37;
        String r10 = r15.authorId;
    L39:
        if ((r30 & 512) == 0) goto L41;
        Integer r11 = r15.followStatus;
    L43:
        if ((r30 & 1024) == 0) goto L45;
        String r12 = r15.sourcePage;
    L47:
        if ((r30 & 2048) == 0) goto L49;
        String r13 = r15.pageName;
    L51:
        if ((r30 & 4096) == 0) goto L53;
        String r14 = r15.carrierType;
    L55:
        if ((r30 & 8192) == 0) goto L57;
        ECAdLogExtra r1 = r15.adLogExtra;
    L59:
        return r15.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r1);
    L57:
        r1 = r29;
        goto L59
    L53:
        r14 = r28;
        goto L55
    L49:
        r13 = r27;
        goto L51
    L45:
        r12 = r26;
        goto L47
    L41:
        r11 = r25;
        goto L43
    L37:
        r10 = r24;
        goto L39
    L33:
        r9 = r23;
        goto L35
    L29:
        r8 = r22;
        goto L31
    L25:
        r7 = r21;
        goto L27
    L21:
        r6 = r20;
        goto L23
    L17:
        r5 = r19;
        goto L19
    L13:
        r4 = r18;
        goto L15
    L9:
        r3 = r17;
        goto L11
    L5:
        r2 = r16;
        goto L7
    }

    public final String component1() {
        return this.orderUrl;
    }

    public final Integer component10() {
        return this.followStatus;
    }

    public final String component11() {
        return this.sourcePage;
    }

    public final String component12() {
        return this.pageName;
    }

    public final String component13() {
        return this.carrierType;
    }

    public final ECAdLogExtra component14() {
        return this.adLogExtra;
    }

    public final String component2() {
        return this.smallAppUrl;
    }

    public final String component3() {
        return this.openAppUrl;
    }

    public final Long component4() {
        return this.promotionSource;
    }

    public final String component5() {
        return this.promotionId;
    }

    public final String component6() {
        return this.productId;
    }

    public final String component7() {
        return this.itemId;
    }

    public final String component8() {
        return this.secAuthorId;
    }

    public final String component9() {
        return this.authorId;
    }

    public final PdpOpenThirdParam copy(String r17, String r18, String r19, Long r20, String r21, String r22, String r23, String r24, String r25, Integer r26, String r27, String r28, String r29, ECAdLogExtra r30) {
        return new PdpOpenThirdParam(r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof PdpOpenThirdParam) == false) goto L34;
        PdpOpenThirdParam r4 = (PdpOpenThirdParam) r3;
        if (Intrinsics.areEqual(this.orderUrl, r4.orderUrl) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.smallAppUrl, r4.smallAppUrl) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.openAppUrl, r4.openAppUrl) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.promotionSource, r4.promotionSource) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.promotionId, r4.promotionId) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.productId, r4.productId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.itemId, r4.itemId) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.secAuthorId, r4.secAuthorId) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.authorId, r4.authorId) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.followStatus, r4.followStatus) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.sourcePage, r4.sourcePage) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.pageName, r4.pageName) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.carrierType, r4.carrierType) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.adLogExtra, r4.adLogExtra) == true) goto L52;
        return false;
    L52:
        return true;
    L34:
        return false;
    }

    public int hashCode() {
        String r0 = this.orderUrl;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.smallAppUrl;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.openAppUrl;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        Long r10 = this.promotionSource;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.promotionId;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.productId;
        if (r16 == null) goto L25;
        int r17 = r16.hashCode();
    L26:
        int r18 = (r15 + r17) * 31;
        String r19 = this.itemId;
        if (r19 == null) goto L29;
        int r20 = r19.hashCode();
    L30:
        int r21 = (r18 + r20) * 31;
        String r22 = this.secAuthorId;
        if (r22 == null) goto L33;
        int r23 = r22.hashCode();
    L34:
        int r24 = (r21 + r23) * 31;
        String r25 = this.authorId;
        if (r25 == null) goto L37;
        int r26 = r25.hashCode();
    L38:
        int r27 = (r24 + r26) * 31;
        Integer r28 = this.followStatus;
        if (r28 == null) goto L41;
        int r29 = r28.hashCode();
    L42:
        int r30 = (r27 + r29) * 31;
        String r31 = this.sourcePage;
        if (r31 == null) goto L45;
        int r32 = r31.hashCode();
    L46:
        int r33 = (r30 + r32) * 31;
        String r34 = this.pageName;
        if (r34 == null) goto L49;
        int r35 = r34.hashCode();
    L50:
        int r36 = (r33 + r35) * 31;
        String r37 = this.carrierType;
        if (r37 == null) goto L53;
        int r38 = r37.hashCode();
    L54:
        int r39 = (r36 + r38) * 31;
        ECAdLogExtra r40 = this.adLogExtra;
        if (r40 == null) goto L58;
        r1 = r40.hashCode();
    L58:
        return r39 + r1;
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
        return "PdpOpenThirdParam(orderUrl=" + this.orderUrl + ", smallAppUrl=" + this.smallAppUrl + ", openAppUrl=" + this.openAppUrl + ", promotionSource=" + this.promotionSource + ", promotionId=" + this.promotionId + ", productId=" + this.productId + ", itemId=" + this.itemId + ", secAuthorId=" + this.secAuthorId + ", authorId=" + this.authorId + ", followStatus=" + this.followStatus + ", sourcePage=" + this.sourcePage + ", pageName=" + this.pageName + ", carrierType=" + this.carrierType + ", adLogExtra=" + this.adLogExtra + ")";
    }

    public final ECAdLogExtra getAdLogExtra() {
        return this.adLogExtra;
    }

    public final String getAuthorId() {
        return this.authorId;
    }

    public final String getCarrierType() {
        return this.carrierType;
    }

    public final Integer getFollowStatus() {
        return this.followStatus;
    }

    public final String getItemId() {
        return this.itemId;
    }

    public final String getOpenAppUrl() {
        return this.openAppUrl;
    }

    public final String getOrderUrl() {
        return this.orderUrl;
    }

    public final String getPageName() {
        return this.pageName;
    }

    public final String getProductId() {
        return this.productId;
    }

    public final String getPromotionId() {
        return this.promotionId;
    }

    public final Long getPromotionSource() {
        return this.promotionSource;
    }

    public final String getSecAuthorId() {
        return this.secAuthorId;
    }

    public final String getSmallAppUrl() {
        return this.smallAppUrl;
    }

    public final String getSourcePage() {
        return this.sourcePage;
    }

    public PdpOpenThirdParam(String r1, String r2, String r3, Long r4, String r5, String r6, String r7, String r8, String r9, Integer r10, String r11, String r12, String r13, ECAdLogExtra r14) {
        this.orderUrl = r1;
        this.smallAppUrl = r2;
        this.openAppUrl = r3;
        this.promotionSource = r4;
        this.promotionId = r5;
        this.productId = r6;
        this.itemId = r7;
        this.secAuthorId = r8;
        this.authorId = r9;
        this.followStatus = r10;
        this.sourcePage = r11;
        this.pageName = r12;
        this.carrierType = r13;
        this.adLogExtra = r14;
    }

    public /* synthetic */ PdpOpenThirdParam(String r16, String r17, String r18, Long r19, String r20, String r21, String r22, String r23, String r24, Integer r25, String r26, String r27, String r28, ECAdLogExtra r29, int r30, DefaultConstructorMarker r31) {
        ECAdLogExtra r2 = null;
        if ((r30 & 1) == 0) goto L5;
        String r1 = null;
    L7:
        if ((r30 & 2) == 0) goto L9;
        String r3 = null;
    L11:
        if ((r30 & 4) == 0) goto L13;
        String r4 = null;
    L15:
        if ((r30 & 8) == 0) goto L17;
        Long r5 = null;
    L19:
        if ((r30 & 16) == 0) goto L21;
        String r6 = null;
    L23:
        if ((r30 & 32) == 0) goto L25;
        String r7 = null;
    L27:
        if ((r30 & 64) == 0) goto L29;
        String r8 = null;
    L31:
        if ((r30 & 128) == 0) goto L33;
        String r9 = null;
    L35:
        if ((r30 & 256) == 0) goto L37;
        String r10 = null;
    L39:
        if ((r30 & 512) == 0) goto L41;
        Integer r11 = null;
    L43:
        if ((r30 & 1024) == 0) goto L45;
        String r12 = null;
    L47:
        if ((r30 & 2048) == 0) goto L49;
        String r13 = null;
    L51:
        if ((r30 & 4096) == 0) goto L53;
        String r14 = null;
    L55:
        if ((r30 & 8192) != 0) goto L58;
        r2 = r29;
    L58:
        this(r1, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r2);
        return;
    L53:
        r14 = r28;
        goto L55
    L49:
        r13 = r27;
        goto L51
    L45:
        r12 = r26;
        goto L47
    L41:
        r11 = r25;
        goto L43
    L37:
        r10 = r24;
        goto L39
    L33:
        r9 = r23;
        goto L35
    L29:
        r8 = r22;
        goto L31
    L25:
        r7 = r21;
        goto L27
    L21:
        r6 = r20;
        goto L23
    L17:
        r5 = r19;
        goto L19
    L13:
        r4 = r18;
        goto L15
    L9:
        r3 = r17;
        goto L11
    L5:
        r1 = r16;
        goto L7
    }
}
