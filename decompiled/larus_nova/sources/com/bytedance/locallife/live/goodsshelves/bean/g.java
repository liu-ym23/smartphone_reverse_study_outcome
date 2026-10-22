package com.bytedance.locallife.live.goodsshelves.bean;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.passport.signinsdk_api.base.log.UniContext;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0016\u0010\u0012R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u000b\u001a\u0004\b\u0018\u0010\rR\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u00198\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u001b\u001a\u0004\b\u001f\u0010\u001d¨\u0006 "}, d2 = {"Lcom/bytedance/locallife/live/goodsshelves/bean/g;", "", "", "cardId", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "productId", "c", "", "isShowing", "Ljava/lang/Boolean;", "e", "()Ljava/lang/Boolean;", "", "status", "Ljava/lang/Integer;", "getStatus", "()Ljava/lang/Integer;", "bizCode", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "industryBizType", "getIndustryBizType", "hasLottery", "getHasLottery", "", "productType", "Ljava/lang/Long;", "getProductType", "()Ljava/lang/Long;", "productSubType", "d", "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3})
public final class g {

    @SerializedName(UniContext.KEY_OF_BIZ_CODE)
    private final String bizCode;

    @SerializedName("card_id")
    private final String cardId;

    @SerializedName("has_lottery")
    private final Boolean hasLottery;

    @SerializedName("industry_biz_type")
    private final Integer industryBizType;

    @SerializedName("is_showing")
    private final Boolean isShowing;

    @SerializedName("product_id")
    private final String productId;

    @SerializedName("product_sub_type")
    private final Long productSubType;

    @SerializedName("product_type")
    private final Long productType;

    @SerializedName("status")
    private final Integer status;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L8;
        return false;
    L8:
        g r101 = (g) r100;
        if (Intrinsics.areEqual(this.cardId, r101.cardId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.productId, r101.productId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.isShowing, r101.isShowing) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.status, r101.status) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.bizCode, r101.bizCode) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.industryBizType, r101.industryBizType) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.hasLottery, r101.hasLottery) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.productType, r101.productType) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.productSubType, r101.productSubType) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        String r100 = this.cardId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.productId;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Boolean r107 = this.isShowing;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.status;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.bizCode;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Integer r116 = this.industryBizType;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        Boolean r119 = this.hasLottery;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        Long r122 = this.productType;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        Long r125 = this.productSubType;
        if (r125 == null) goto L39;
        r101 = r125.hashCode();
    L39:
        return r124 + r101;
    L33:
        r123 = r122.hashCode();
        goto L34
    L29:
        r120 = r119.hashCode();
        goto L30
    L25:
        r117 = r116.hashCode();
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "LiveLifeBFFCardBasicInfo(cardId=" + this.cardId + ", productId=" + this.productId + ", isShowing=" + this.isShowing + ", status=" + this.status + ", bizCode=" + this.bizCode + ", industryBizType=" + this.industryBizType + ", hasLottery=" + this.hasLottery + ", productType=" + this.productType + ", productSubType=" + this.productSubType + ')';
    }

    public final String a() {
        return this.bizCode;
    }

    public final String b() {
        return this.cardId;
    }

    public final String c() {
        return this.productId;
    }

    public final Long d() {
        return this.productSubType;
    }

    public final Boolean e() {
        return this.isShowing;
    }
}
