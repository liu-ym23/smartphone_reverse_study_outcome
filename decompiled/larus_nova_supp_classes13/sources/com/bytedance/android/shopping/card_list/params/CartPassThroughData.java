package com.bytedance.android.shopping.card_list.params;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b#\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B{\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010-\u001a\u00020\fHÆ\u0003J\u007f\u0010.\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u000102HÖ\u0003J\t\u00103\u001a\u00020\fHÖ\u0001J\t\u00104\u001a\u00020\u0003HÖ\u0001R \u0010\t\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R \u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0012R \u0010\r\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0010\"\u0004\b\u0016\u0010\u0012R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R\u001e\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0010R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0010R \u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0010\"\u0004\b\u001f\u0010\u0012R \u0010\b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0010\"\u0004\b!\u0010\u0012R \u0010\n\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0010\"\u0004\b#\u0010\u0012¨\u00065"}, d2 = {"Lcom/bytedance/android/shopping/card_list/params/CartPassThroughData;", "Ljava/io/Serializable;", "newSourceType", "", "historyPath", "enterFromLiveSaas", "cartIds", "shopIds", "showShopIds", "anchorCartId", "transparentParams", "heightPercent", "", "deliverySessionId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V", "getAnchorCartId", "()Ljava/lang/String;", "setAnchorCartId", "(Ljava/lang/String;)V", "getCartIds", "setCartIds", "getDeliverySessionId", "setDeliverySessionId", "getEnterFromLiveSaas", "getHeightPercent", "()I", "setHeightPercent", "(I)V", "getHistoryPath", "getNewSourceType", "getShopIds", "setShopIds", "getShowShopIds", "setShowShopIds", "getTransparentParams", "setTransparentParams", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "", "hashCode", "toString", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CartPassThroughData implements Serializable {

    @SerializedName("anchor_cart_id")
    private String anchorCartId;

    @SerializedName("cart_ids")
    private String cartIds;

    @SerializedName("delivery_session_id")
    private String deliverySessionId;

    @SerializedName("enter_from_live_saas")
    private final String enterFromLiveSaas;

    @SerializedName("cart_height_percent")
    private int heightPercent;

    @SerializedName("history_path")
    private final String historyPath;

    @SerializedName("new_source_type")
    private final String newSourceType;

    @SerializedName("shop_ids")
    private String shopIds;

    @SerializedName("show_shop_ids")
    private String showShopIds;

    @SerializedName("transparent_params")
    private String transparentParams;

    public CartPassThroughData() {
        this(null, null, null, null, null, null, null, null, 0, null, 1023, null);
    }

    public static /* synthetic */ CartPassThroughData copy$default(CartPassThroughData r11, String r12, String r13, String r14, String r15, String r16, String r17, String r18, String r19, int r20, String r21, int r22, Object r23) {
        if ((r22 & 1) == 0) goto L5;
        String r2 = r11.newSourceType;
    L7:
        if ((r22 & 2) == 0) goto L9;
        String r3 = r11.historyPath;
    L11:
        if ((r22 & 4) == 0) goto L13;
        String r4 = r11.enterFromLiveSaas;
    L15:
        if ((r22 & 8) == 0) goto L17;
        String r5 = r11.cartIds;
    L19:
        if ((r22 & 16) == 0) goto L21;
        String r6 = r11.shopIds;
    L23:
        if ((r22 & 32) == 0) goto L25;
        String r7 = r11.showShopIds;
    L27:
        if ((r22 & 64) == 0) goto L29;
        String r8 = r11.anchorCartId;
    L31:
        if ((r22 & 128) == 0) goto L33;
        String r9 = r11.transparentParams;
    L35:
        if ((r22 & 256) == 0) goto L37;
        int r10 = r11.heightPercent;
    L39:
        if ((r22 & 512) == 0) goto L41;
        String r1 = r11.deliverySessionId;
    L43:
        return r11.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r1);
    L41:
        r1 = r21;
        goto L43
    L37:
        r10 = r20;
        goto L39
    L33:
        r9 = r19;
        goto L35
    L29:
        r8 = r18;
        goto L31
    L25:
        r7 = r17;
        goto L27
    L21:
        r6 = r16;
        goto L23
    L17:
        r5 = r15;
        goto L19
    L13:
        r4 = r14;
        goto L15
    L9:
        r3 = r13;
        goto L11
    L5:
        r2 = r12;
        goto L7
    }

    public final String component1() {
        return this.newSourceType;
    }

    public final String component10() {
        return this.deliverySessionId;
    }

    public final String component2() {
        return this.historyPath;
    }

    public final String component3() {
        return this.enterFromLiveSaas;
    }

    public final String component4() {
        return this.cartIds;
    }

    public final String component5() {
        return this.shopIds;
    }

    public final String component6() {
        return this.showShopIds;
    }

    public final String component7() {
        return this.anchorCartId;
    }

    public final String component8() {
        return this.transparentParams;
    }

    public final int component9() {
        return this.heightPercent;
    }

    public final CartPassThroughData copy(String r13, String r14, String r15, String r16, String r17, String r18, String r19, String r20, int r21, String r22) {
        return new CartPassThroughData(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof CartPassThroughData) == false) goto L26;
        CartPassThroughData r4 = (CartPassThroughData) r3;
        if (Intrinsics.areEqual(this.newSourceType, r4.newSourceType) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.historyPath, r4.historyPath) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.enterFromLiveSaas, r4.enterFromLiveSaas) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.cartIds, r4.cartIds) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.shopIds, r4.shopIds) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.showShopIds, r4.showShopIds) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.anchorCartId, r4.anchorCartId) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.transparentParams, r4.transparentParams) == true) goto L22;
        return false;
    L22:
        if (this.heightPercent == r4.heightPercent) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.deliverySessionId, r4.deliverySessionId) == true) goto L40;
        return false;
    L40:
        return true;
    L26:
        return false;
    }

    public int hashCode() {
        String r0 = this.newSourceType;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.historyPath;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.enterFromLiveSaas;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.cartIds;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.shopIds;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.showShopIds;
        if (r16 == null) goto L25;
        int r17 = r16.hashCode();
    L26:
        int r18 = (r15 + r17) * 31;
        String r19 = this.anchorCartId;
        if (r19 == null) goto L29;
        int r20 = r19.hashCode();
    L30:
        int r21 = (r18 + r20) * 31;
        String r22 = this.transparentParams;
        if (r22 == null) goto L33;
        int r23 = r22.hashCode();
    L34:
        int r24 = (((r21 + r23) * 31) + this.heightPercent) * 31;
        String r25 = this.deliverySessionId;
        if (r25 == null) goto L38;
        r1 = r25.hashCode();
    L38:
        return r24 + r1;
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
        return "CartPassThroughData(newSourceType=" + this.newSourceType + ", historyPath=" + this.historyPath + ", enterFromLiveSaas=" + this.enterFromLiveSaas + ", cartIds=" + this.cartIds + ", shopIds=" + this.shopIds + ", showShopIds=" + this.showShopIds + ", anchorCartId=" + this.anchorCartId + ", transparentParams=" + this.transparentParams + ", heightPercent=" + this.heightPercent + ", deliverySessionId=" + this.deliverySessionId + ")";
    }

    public final String getAnchorCartId() {
        return this.anchorCartId;
    }

    public final String getCartIds() {
        return this.cartIds;
    }

    public final String getDeliverySessionId() {
        return this.deliverySessionId;
    }

    public final String getEnterFromLiveSaas() {
        return this.enterFromLiveSaas;
    }

    public final int getHeightPercent() {
        return this.heightPercent;
    }

    public final String getHistoryPath() {
        return this.historyPath;
    }

    public final String getNewSourceType() {
        return this.newSourceType;
    }

    public final String getShopIds() {
        return this.shopIds;
    }

    public final String getShowShopIds() {
        return this.showShopIds;
    }

    public final String getTransparentParams() {
        return this.transparentParams;
    }

    public final void setAnchorCartId(String r1) {
        this.anchorCartId = r1;
    }

    public final void setCartIds(String r1) {
        this.cartIds = r1;
    }

    public final void setDeliverySessionId(String r1) {
        this.deliverySessionId = r1;
    }

    public final void setHeightPercent(int r1) {
        this.heightPercent = r1;
    }

    public final void setShopIds(String r1) {
        this.shopIds = r1;
    }

    public final void setShowShopIds(String r1) {
        this.showShopIds = r1;
    }

    public final void setTransparentParams(String r1) {
        this.transparentParams = r1;
    }

    public CartPassThroughData(String r1, String r2, String r3, String r4, String r5, String r6, String r7, String r8, int r9, String r10) {
        this.newSourceType = r1;
        this.historyPath = r2;
        this.enterFromLiveSaas = r3;
        this.cartIds = r4;
        this.shopIds = r5;
        this.showShopIds = r6;
        this.anchorCartId = r7;
        this.transparentParams = r8;
        this.heightPercent = r9;
        this.deliverySessionId = r10;
    }

    public /* synthetic */ CartPassThroughData(String r12, String r13, String r14, String r15, String r16, String r17, String r18, String r19, int r20, String r21, int r22, DefaultConstructorMarker r23) {
        String r2 = null;
        if ((r22 & 1) == 0) goto L5;
        String r1 = null;
    L7:
        if ((r22 & 2) == 0) goto L9;
        String r3 = null;
    L11:
        if ((r22 & 4) == 0) goto L13;
        String r4 = null;
    L15:
        if ((r22 & 8) == 0) goto L17;
        String r5 = null;
    L19:
        if ((r22 & 16) == 0) goto L21;
        String r6 = null;
    L23:
        if ((r22 & 32) == 0) goto L25;
        String r7 = null;
    L27:
        if ((r22 & 64) == 0) goto L29;
        String r8 = null;
    L31:
        if ((r22 & 128) == 0) goto L33;
        String r9 = null;
    L35:
        if ((r22 & 256) == 0) goto L37;
        int r10 = 0;
    L39:
        if ((r22 & 512) != 0) goto L42;
        r2 = r21;
    L42:
        this(r1, r3, r4, r5, r6, r7, r8, r9, r10, r2);
        return;
    L37:
        r10 = r20;
        goto L39
    L33:
        r9 = r19;
        goto L35
    L29:
        r8 = r18;
        goto L31
    L25:
        r7 = r17;
        goto L27
    L21:
        r6 = r16;
        goto L23
    L17:
        r5 = r15;
        goto L19
    L13:
        r4 = r14;
        goto L15
    L9:
        r3 = r13;
        goto L11
    L5:
        r1 = r12;
        goto L7
    }
}
