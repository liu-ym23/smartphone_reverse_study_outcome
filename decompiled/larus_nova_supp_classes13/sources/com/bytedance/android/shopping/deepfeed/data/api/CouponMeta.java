package com.bytedance.android.shopping.deepfeed.data.api;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b.\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B¡\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0012J\u0010\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0016J\u000b\u0010*\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010.\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u0010/\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u00102\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0016Jª\u0001\u00104\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u00105J\u0013\u00106\u001a\u0002072\b\u00108\u001a\u0004\u0018\u000109HÖ\u0003J\t\u0010:\u001a\u00020\bHÖ\u0001J\t\u0010;\u001a\u00020\u0005HÖ\u0001R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u001a\u0010\f\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u001c\u0010\u001aR\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u001d\u0010\u0016R\u001a\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u001e\u0010\u0016R\u001a\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u001f\u0010\u0016R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0014\"\u0004\b!\u0010\"R\u001a\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b#\u0010\u0016R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b$\u0010\u001aR\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b%\u0010\u0016R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0014¨\u0006<"}, d2 = {"Lcom/bytedance/android/shopping/deepfeed/data/api/CouponMeta;", "Ljava/io/Serializable;", "couponMetaId", "", "couponMetaName", "", "couponMetaDesc", "status", "", "couponType", "shopId", "limitKolId", "couponSubType", "discount", "threshold", "credit", "thresholdText", "productId", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;)V", "getCouponMetaDesc", "()Ljava/lang/String;", "getCouponMetaId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getCouponMetaName", "getCouponSubType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getCouponType", "getCredit", "getDiscount", "getLimitKolId", "getProductId", "setProductId", "(Ljava/lang/String;)V", "getShopId", "getStatus", "getThreshold", "getThresholdText", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;)Lcom/bytedance/android/shopping/deepfeed/data/api/CouponMeta;", "equals", "", "other", "", "hashCode", "toString", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CouponMeta implements Serializable {

    @SerializedName("coupon_meta_desc")
    private final String couponMetaDesc;

    @SerializedName("coupon_meta_id")
    private final Long couponMetaId;

    @SerializedName("coupon_meta_name")
    private final String couponMetaName;

    @SerializedName("coupon_sub_type")
    private final Integer couponSubType;

    @SerializedName("coupon_type")
    private final Integer couponType;

    @SerializedName("credit")
    private final Long credit;

    @SerializedName("discount")
    private final Long discount;

    @SerializedName("limit_kol_id")
    private final Long limitKolId;
    private String productId;

    @SerializedName("shop_id")
    private final Long shopId;

    @SerializedName("status")
    private final Integer status;

    @SerializedName("threshold")
    private final Long threshold;

    @SerializedName("threshold_text")
    private final String thresholdText;

    public CouponMeta() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, 8191, null);
    }

    public static /* synthetic */ CouponMeta copy$default(CouponMeta r14, Long r15, String r16, String r17, Integer r18, Integer r19, Long r20, Long r21, Integer r22, Long r23, Long r24, Long r25, String r26, String r27, int r28, Object r29) {
        if ((r28 & 1) == 0) goto L5;
        Long r2 = r14.couponMetaId;
    L7:
        if ((r28 & 2) == 0) goto L9;
        String r3 = r14.couponMetaName;
    L11:
        if ((r28 & 4) == 0) goto L13;
        String r4 = r14.couponMetaDesc;
    L15:
        if ((r28 & 8) == 0) goto L17;
        Integer r5 = r14.status;
    L19:
        if ((r28 & 16) == 0) goto L21;
        Integer r6 = r14.couponType;
    L23:
        if ((r28 & 32) == 0) goto L25;
        Long r7 = r14.shopId;
    L27:
        if ((r28 & 64) == 0) goto L29;
        Long r8 = r14.limitKolId;
    L31:
        if ((r28 & 128) == 0) goto L33;
        Integer r9 = r14.couponSubType;
    L35:
        if ((r28 & 256) == 0) goto L37;
        Long r10 = r14.discount;
    L39:
        if ((r28 & 512) == 0) goto L41;
        Long r11 = r14.threshold;
    L43:
        if ((r28 & 1024) == 0) goto L45;
        Long r12 = r14.credit;
    L47:
        if ((r28 & 2048) == 0) goto L49;
        String r13 = r14.thresholdText;
    L51:
        if ((r28 & 4096) == 0) goto L53;
        String r1 = r14.productId;
    L55:
        return r14.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r1);
    L53:
        r1 = r27;
        goto L55
    L49:
        r13 = r26;
        goto L51
    L45:
        r12 = r25;
        goto L47
    L41:
        r11 = r24;
        goto L43
    L37:
        r10 = r23;
        goto L39
    L33:
        r9 = r22;
        goto L35
    L29:
        r8 = r21;
        goto L31
    L25:
        r7 = r20;
        goto L27
    L21:
        r6 = r19;
        goto L23
    L17:
        r5 = r18;
        goto L19
    L13:
        r4 = r17;
        goto L15
    L9:
        r3 = r16;
        goto L11
    L5:
        r2 = r15;
        goto L7
    }

    public final Long component1() {
        return this.couponMetaId;
    }

    public final Long component10() {
        return this.threshold;
    }

    public final Long component11() {
        return this.credit;
    }

    public final String component12() {
        return this.thresholdText;
    }

    public final String component13() {
        return this.productId;
    }

    public final String component2() {
        return this.couponMetaName;
    }

    public final String component3() {
        return this.couponMetaDesc;
    }

    public final Integer component4() {
        return this.status;
    }

    public final Integer component5() {
        return this.couponType;
    }

    public final Long component6() {
        return this.shopId;
    }

    public final Long component7() {
        return this.limitKolId;
    }

    public final Integer component8() {
        return this.couponSubType;
    }

    public final Long component9() {
        return this.discount;
    }

    public final CouponMeta copy(Long r16, String r17, String r18, Integer r19, Integer r20, Long r21, Long r22, Integer r23, Long r24, Long r25, Long r26, String r27, String r28) {
        return new CouponMeta(r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof CouponMeta) == false) goto L32;
        CouponMeta r4 = (CouponMeta) r3;
        if (Intrinsics.areEqual(this.couponMetaId, r4.couponMetaId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.couponMetaName, r4.couponMetaName) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.couponMetaDesc, r4.couponMetaDesc) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.status, r4.status) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.couponType, r4.couponType) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.shopId, r4.shopId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.limitKolId, r4.limitKolId) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.couponSubType, r4.couponSubType) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.discount, r4.discount) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.threshold, r4.threshold) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.credit, r4.credit) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.thresholdText, r4.thresholdText) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.productId, r4.productId) == true) goto L49;
        return false;
    L49:
        return true;
    L32:
        return false;
    }

    public int hashCode() {
        Long r0 = this.couponMetaId;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.couponMetaName;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.couponMetaDesc;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        Integer r10 = this.status;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        Integer r13 = this.couponType;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        Long r16 = this.shopId;
        if (r16 == null) goto L25;
        int r17 = r16.hashCode();
    L26:
        int r18 = (r15 + r17) * 31;
        Long r19 = this.limitKolId;
        if (r19 == null) goto L29;
        int r20 = r19.hashCode();
    L30:
        int r21 = (r18 + r20) * 31;
        Integer r22 = this.couponSubType;
        if (r22 == null) goto L33;
        int r23 = r22.hashCode();
    L34:
        int r24 = (r21 + r23) * 31;
        Long r25 = this.discount;
        if (r25 == null) goto L37;
        int r26 = r25.hashCode();
    L38:
        int r27 = (r24 + r26) * 31;
        Long r28 = this.threshold;
        if (r28 == null) goto L41;
        int r29 = r28.hashCode();
    L42:
        int r30 = (r27 + r29) * 31;
        Long r31 = this.credit;
        if (r31 == null) goto L45;
        int r32 = r31.hashCode();
    L46:
        int r33 = (r30 + r32) * 31;
        String r34 = this.thresholdText;
        if (r34 == null) goto L49;
        int r35 = r34.hashCode();
    L50:
        int r36 = (r33 + r35) * 31;
        String r37 = this.productId;
        if (r37 == null) goto L54;
        r1 = r37.hashCode();
    L54:
        return r36 + r1;
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
        return "CouponMeta(couponMetaId=" + this.couponMetaId + ", couponMetaName=" + this.couponMetaName + ", couponMetaDesc=" + this.couponMetaDesc + ", status=" + this.status + ", couponType=" + this.couponType + ", shopId=" + this.shopId + ", limitKolId=" + this.limitKolId + ", couponSubType=" + this.couponSubType + ", discount=" + this.discount + ", threshold=" + this.threshold + ", credit=" + this.credit + ", thresholdText=" + this.thresholdText + ", productId=" + this.productId + ")";
    }

    public final String getCouponMetaDesc() {
        return this.couponMetaDesc;
    }

    public final Long getCouponMetaId() {
        return this.couponMetaId;
    }

    public final String getCouponMetaName() {
        return this.couponMetaName;
    }

    public final Integer getCouponSubType() {
        return this.couponSubType;
    }

    public final Integer getCouponType() {
        return this.couponType;
    }

    public final Long getCredit() {
        return this.credit;
    }

    public final Long getDiscount() {
        return this.discount;
    }

    public final Long getLimitKolId() {
        return this.limitKolId;
    }

    public final String getProductId() {
        return this.productId;
    }

    public final Long getShopId() {
        return this.shopId;
    }

    public final Integer getStatus() {
        return this.status;
    }

    public final Long getThreshold() {
        return this.threshold;
    }

    public final String getThresholdText() {
        return this.thresholdText;
    }

    public final void setProductId(String r1) {
        this.productId = r1;
    }

    public CouponMeta(Long r1, String r2, String r3, Integer r4, Integer r5, Long r6, Long r7, Integer r8, Long r9, Long r10, Long r11, String r12, String r13) {
        this.couponMetaId = r1;
        this.couponMetaName = r2;
        this.couponMetaDesc = r3;
        this.status = r4;
        this.couponType = r5;
        this.shopId = r6;
        this.limitKolId = r7;
        this.couponSubType = r8;
        this.discount = r9;
        this.threshold = r10;
        this.credit = r11;
        this.thresholdText = r12;
        this.productId = r13;
    }

    public /* synthetic */ CouponMeta(Long r15, String r16, String r17, Integer r18, Integer r19, Long r20, Long r21, Integer r22, Long r23, Long r24, Long r25, String r26, String r27, int r28, DefaultConstructorMarker r29) {
        String r2 = null;
        if ((r28 & 1) == 0) goto L5;
        Long r1 = null;
    L7:
        if ((r28 & 2) == 0) goto L9;
        String r3 = null;
    L11:
        if ((r28 & 4) == 0) goto L13;
        String r4 = null;
    L15:
        if ((r28 & 8) == 0) goto L17;
        Integer r5 = null;
    L19:
        if ((r28 & 16) == 0) goto L21;
        Integer r6 = null;
    L23:
        if ((r28 & 32) == 0) goto L25;
        Long r7 = null;
    L27:
        if ((r28 & 64) == 0) goto L29;
        Long r8 = null;
    L31:
        if ((r28 & 128) == 0) goto L33;
        Integer r9 = null;
    L35:
        if ((r28 & 256) == 0) goto L37;
        Long r10 = null;
    L39:
        if ((r28 & 512) == 0) goto L41;
        Long r11 = null;
    L43:
        if ((r28 & 1024) == 0) goto L45;
        Long r12 = null;
    L47:
        if ((r28 & 2048) == 0) goto L49;
        String r13 = null;
    L51:
        if ((r28 & 4096) != 0) goto L54;
        r2 = r27;
    L54:
        this(r1, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r2);
        return;
    L49:
        r13 = r26;
        goto L51
    L45:
        r12 = r25;
        goto L47
    L41:
        r11 = r24;
        goto L43
    L37:
        r10 = r23;
        goto L39
    L33:
        r9 = r22;
        goto L35
    L29:
        r8 = r21;
        goto L31
    L25:
        r7 = r20;
        goto L27
    L21:
        r6 = r19;
        goto L23
    L17:
        r5 = r18;
        goto L19
    L13:
        r4 = r17;
        goto L15
    L9:
        r3 = r16;
        goto L11
    L5:
        r1 = r15;
        goto L7
    }
}
