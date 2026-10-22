package com.bytedance.android.livesdk.livecommerce.network.response;

import com.bytedance.bdlocation.network.model.DeviceStatus$DiffDimension;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001b\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001Bo\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010!\u001a\u00020\nHÆ\u0003J\u0010\u0010\"\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u0014J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jx\u0010$\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010%J\u0013\u0010&\u001a\u00020\f2\b\u0010'\u001a\u0004\u0018\u00010(HÖ\u0003J\t\u0010)\u001a\u00020\nHÖ\u0001J\t\u0010*\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0016\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u000b\u0010\u0014R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0010R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0010R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0010¨\u0006+"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/network/response/ECCartItemBasicInfo;", "Ljava/io/Serializable;", "cartId", "", "productId", "name", "specPic", "specDesc", "comboId", "comboNum", "", "isMultiSku", "", "shopId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/Boolean;Ljava/lang/String;)V", "getCartId", "()Ljava/lang/String;", "getComboId", "getComboNum", "()I", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getName", "getProductId", "getShopId", "getSpecDesc", "getSpecPic", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/Boolean;Ljava/lang/String;)Lcom/bytedance/android/livesdk/livecommerce/network/response/ECCartItemBasicInfo;", "equals", "other", "", "hashCode", "toString", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECCartItemBasicInfo implements Serializable {

    @SerializedName("cart_id")
    private final String cartId;

    @SerializedName("combo_id")
    private final String comboId;

    @SerializedName("combo_num")
    private final int comboNum;

    @SerializedName("is_multi_sku")
    private final Boolean isMultiSku;

    @SerializedName("name")
    private final String name;

    @SerializedName("product_id")
    private final String productId;

    @SerializedName("shop_id")
    private final String shopId;

    @SerializedName("spec_desc")
    private final String specDesc;

    @SerializedName("spec_pic")
    private final String specPic;

    public ECCartItemBasicInfo() {
        this(null, null, null, null, null, null, 0, null, null, 511, null);
    }

    public static /* synthetic */ ECCartItemBasicInfo copy$default(ECCartItemBasicInfo r10, String r11, String r12, String r13, String r14, String r15, String r16, int r17, Boolean r18, String r19, int r20, Object r21) {
        if ((r20 & 1) == 0) goto L5;
        String r2 = r10.cartId;
    L7:
        if ((r20 & 2) == 0) goto L9;
        String r3 = r10.productId;
    L11:
        if ((r20 & 4) == 0) goto L13;
        String r4 = r10.name;
    L15:
        if ((r20 & 8) == 0) goto L17;
        String r5 = r10.specPic;
    L19:
        if ((r20 & 16) == 0) goto L21;
        String r6 = r10.specDesc;
    L23:
        if ((r20 & 32) == 0) goto L25;
        String r7 = r10.comboId;
    L27:
        if ((r20 & 64) == 0) goto L29;
        int r8 = r10.comboNum;
    L31:
        if ((r20 & DeviceStatus$DiffDimension.DIFF_RESTRICTED_MODE) == 0) goto L33;
        Boolean r9 = r10.isMultiSku;
    L35:
        if ((r20 & DeviceStatus$DiffDimension.DIFF_LOCATION_MODE) == 0) goto L37;
        String r1 = r10.shopId;
    L39:
        return r10.copy(r2, r3, r4, r5, r6, r7, r8, r9, r1);
    L37:
        r1 = r19;
        goto L39
    L33:
        r9 = r18;
        goto L35
    L29:
        r8 = r17;
        goto L31
    L25:
        r7 = r16;
        goto L27
    L21:
        r6 = r15;
        goto L23
    L17:
        r5 = r14;
        goto L19
    L13:
        r4 = r13;
        goto L15
    L9:
        r3 = r12;
        goto L11
    L5:
        r2 = r11;
        goto L7
    }

    public final String component1() {
        return this.cartId;
    }

    public final String component2() {
        return this.productId;
    }

    public final String component3() {
        return this.name;
    }

    public final String component4() {
        return this.specPic;
    }

    public final String component5() {
        return this.specDesc;
    }

    public final String component6() {
        return this.comboId;
    }

    public final int component7() {
        return this.comboNum;
    }

    public final Boolean component8() {
        return this.isMultiSku;
    }

    public final String component9() {
        return this.shopId;
    }

    public final ECCartItemBasicInfo copy(String r12, String r13, String r14, String r15, String r16, String r17, int r18, Boolean r19, String r20) {
        return new ECCartItemBasicInfo(r12, r13, r14, r15, r16, r17, r18, r19, r20);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof ECCartItemBasicInfo) == false) goto L24;
        ECCartItemBasicInfo r4 = (ECCartItemBasicInfo) r3;
        if (Intrinsics.areEqual(this.cartId, r4.cartId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.productId, r4.productId) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.name, r4.name) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.specPic, r4.specPic) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.specDesc, r4.specDesc) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.comboId, r4.comboId) == true) goto L18;
        return false;
    L18:
        if (this.comboNum == r4.comboNum) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.isMultiSku, r4.isMultiSku) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.shopId, r4.shopId) == true) goto L37;
        return false;
    L37:
        return true;
    L24:
        return false;
    }

    public int hashCode() {
        String r0 = this.cartId;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.productId;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.name;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.specPic;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.specDesc;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.comboId;
        if (r16 == null) goto L25;
        int r17 = r16.hashCode();
    L26:
        int r18 = (((r15 + r17) * 31) + this.comboNum) * 31;
        Boolean r19 = this.isMultiSku;
        if (r19 == null) goto L29;
        int r20 = r19.hashCode();
    L30:
        int r21 = (r18 + r20) * 31;
        String r22 = this.shopId;
        if (r22 == null) goto L34;
        r1 = r22.hashCode();
    L34:
        return r21 + r1;
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
        return "ECCartItemBasicInfo(cartId=" + this.cartId + ", productId=" + this.productId + ", name=" + this.name + ", specPic=" + this.specPic + ", specDesc=" + this.specDesc + ", comboId=" + this.comboId + ", comboNum=" + this.comboNum + ", isMultiSku=" + this.isMultiSku + ", shopId=" + this.shopId + ")";
    }

    public final String getCartId() {
        return this.cartId;
    }

    public final String getComboId() {
        return this.comboId;
    }

    public final int getComboNum() {
        return this.comboNum;
    }

    public final String getName() {
        return this.name;
    }

    public final String getProductId() {
        return this.productId;
    }

    public final String getShopId() {
        return this.shopId;
    }

    public final String getSpecDesc() {
        return this.specDesc;
    }

    public final String getSpecPic() {
        return this.specPic;
    }

    public final Boolean isMultiSku() {
        return this.isMultiSku;
    }

    public ECCartItemBasicInfo(String r1, String r2, String r3, String r4, String r5, String r6, int r7, Boolean r8, String r9) {
        this.cartId = r1;
        this.productId = r2;
        this.name = r3;
        this.specPic = r4;
        this.specDesc = r5;
        this.comboId = r6;
        this.comboNum = r7;
        this.isMultiSku = r8;
        this.shopId = r9;
    }

    public /* synthetic */ ECCartItemBasicInfo(String r11, String r12, String r13, String r14, String r15, String r16, int r17, Boolean r18, String r19, int r20, DefaultConstructorMarker r21) {
        String r2 = null;
        if ((r20 & 1) == 0) goto L5;
        String r1 = null;
    L7:
        if ((r20 & 2) == 0) goto L9;
        String r3 = null;
    L11:
        if ((r20 & 4) == 0) goto L13;
        String r4 = null;
    L15:
        if ((r20 & 8) == 0) goto L17;
        String r5 = null;
    L19:
        if ((r20 & 16) == 0) goto L21;
        String r6 = null;
    L23:
        if ((r20 & 32) == 0) goto L25;
        String r7 = null;
    L27:
        if ((r20 & 64) == 0) goto L29;
        int r8 = 0;
    L31:
        if ((r20 & DeviceStatus$DiffDimension.DIFF_RESTRICTED_MODE) == 0) goto L33;
        Boolean r9 = null;
    L35:
        if ((r20 & DeviceStatus$DiffDimension.DIFF_LOCATION_MODE) != 0) goto L38;
        r2 = r19;
    L38:
        this(r1, r3, r4, r5, r6, r7, r8, r9, r2);
        return;
    L33:
        r9 = r18;
        goto L35
    L29:
        r8 = r17;
        goto L31
    L25:
        r7 = r16;
        goto L27
    L21:
        r6 = r15;
        goto L23
    L17:
        r5 = r14;
        goto L19
    L13:
        r4 = r13;
        goto L15
    L9:
        r3 = r12;
        goto L11
    L5:
        r1 = r11;
        goto L7
    }
}
