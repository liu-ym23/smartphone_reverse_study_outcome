package com.bytedance.android.window.shop.innerflow.entity.dto;

import com.bytedance.android.ec.model.api.CommerceBaseResponse;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import up3.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u0001BE\u0012\b\b\u0002\u0010\f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\r\u001a\u00020\u0004\u0012\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b%\u0010&J\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0005\u001a\u00020\u0004HÆ\u0003J\u0011\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\tHÆ\u0003JG\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00042\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\tHÆ\u0001J\t\u0010\u0012\u001a\u00020\tHÖ\u0001J\t\u0010\u0014\u001a\u00020\u0013HÖ\u0001J\u0013\u0010\u0017\u001a\u00020\u00022\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015HÖ\u0003R\u001a\u0010\f\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\r\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\"\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010!\u001a\u0004\b\"\u0010#R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010!\u001a\u0004\b$\u0010#¨\u0006'"}, d2 = {"Lcom/bytedance/android/window/shop/innerflow/entity/dto/ECShopInnerFlowDTO;", "Lcom/bytedance/android/ec/model/api/CommerceBaseResponse;", "", "component1", "", "component2", "", "Lup3/g;", "component3", "", "component4", "component5", "hasMore", "cursor", "mixCards", "shopCartUrl", "cartProductNumber", "copy", "toString", "", "hashCode", "", "other", "equals", "Z", "getHasMore", "()Z", "J", "getCursor", "()J", "Ljava/util/List;", "getMixCards", "()Ljava/util/List;", "Ljava/lang/String;", "getShopCartUrl", "()Ljava/lang/String;", "getCartProductNumber", "<init>", "(ZJLjava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECShopInnerFlowDTO extends CommerceBaseResponse {

    @SerializedName("cart_product_num")
    private final String cartProductNumber;

    @SerializedName("cursor")
    private final long cursor;

    @SerializedName("has_more")
    private final boolean hasMore;

    @SerializedName("mix_full_cards")
    private final List<g> mixCards;

    @SerializedName("shop_cart_url")
    private final String shopCartUrl;

    public ECShopInnerFlowDTO() {
        this(false, 0, null, null, null, 31, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ECShopInnerFlowDTO copy$default(ECShopInnerFlowDTO r4, boolean r5, long r6, List r8, String r9, String r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = r4.hasMore;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r6 = r4.cursor;
    L8:
        long r0 = r6;
        if ((r11 & 4) == 0) goto L11;
        r8 = r4.mixCards;
    L11:
        List r13 = r8;
        if ((r11 & 8) == 0) goto L14;
        r9 = r4.shopCartUrl;
    L14:
        String r2 = r9;
        if ((r11 & 16) == 0) goto L17;
        r10 = r4.cartProductNumber;
    L17:
        boolean r7 = r5;
        return r4.copy(r7, r0, r13, r2, r10);
    }

    public final boolean component1() {
        return this.hasMore;
    }

    public final long component2() {
        return this.cursor;
    }

    public final List<g> component3() {
        return this.mixCards;
    }

    public final String component4() {
        return this.shopCartUrl;
    }

    public final String component5() {
        return this.cartProductNumber;
    }

    public final ECShopInnerFlowDTO copy(boolean r9, long r10, List<g> r12, String r13, String r14) {
        return new ECShopInnerFlowDTO(r9, r10, r12, r13, r14);
    }

    public boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof ECShopInnerFlowDTO) == false) goto L16;
        ECShopInnerFlowDTO r7 = (ECShopInnerFlowDTO) r6;
        if (this.hasMore == r7.hasMore) goto L8;
        return false;
    L8:
        if (this.cursor == r7.cursor) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.mixCards, r7.mixCards) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.shopCartUrl, r7.shopCartUrl) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.cartProductNumber, r7.cartProductNumber) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    public int hashCode() {
        boolean r0 = this.hasMore;
        ?? r1 = r0;
        if (r0 == false) goto L5;
        r1 = 1;
    L5:
        long r2 = this.cursor;
        int r3 = ((r1 * 31) + ((int) (r2 ^ (r2 >>> 32)))) * 31;
        List<g> r4 = this.mixCards;
        int r5 = 0;
        if (r4 == null) goto L8;
        int r6 = r4.hashCode();
    L9:
        int r7 = (r3 + r6) * 31;
        String r8 = this.shopCartUrl;
        if (r8 == null) goto L12;
        int r9 = r8.hashCode();
    L13:
        int r10 = (r7 + r9) * 31;
        String r11 = this.cartProductNumber;
        if (r11 == null) goto L17;
        r5 = r11.hashCode();
    L17:
        return r10 + r5;
    L12:
        r9 = 0;
        goto L13
    L8:
        r6 = 0;
        goto L9
    }

    public String toString() {
        return "ECShopInnerFlowDTO(hasMore=" + this.hasMore + ", cursor=" + this.cursor + ", mixCards=" + this.mixCards + ", shopCartUrl=" + this.shopCartUrl + ", cartProductNumber=" + this.cartProductNumber + ")";
    }

    public final String getCartProductNumber() {
        return this.cartProductNumber;
    }

    public final long getCursor() {
        return this.cursor;
    }

    public final boolean getHasMore() {
        return this.hasMore;
    }

    public final List<g> getMixCards() {
        return this.mixCards;
    }

    public final String getShopCartUrl() {
        return this.shopCartUrl;
    }

    public ECShopInnerFlowDTO(boolean r1, long r2, List<g> r4, String r5, String r6) {
        this.hasMore = r1;
        this.cursor = r2;
        this.mixCards = r4;
        this.shopCartUrl = r5;
        this.cartProductNumber = r6;
    }

    public /* synthetic */ ECShopInnerFlowDTO(boolean r5, long r6, List r8, String r9, String r10, int r11, DefaultConstructorMarker r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = false;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r6 = 0;
    L8:
        long r0 = r6;
        if ((r11 & 4) == 0) goto L11;
        List r13 = null;
    L13:
        if ((r11 & 8) == 0) goto L15;
        String r2 = null;
    L17:
        if ((r11 & 16) == 0) goto L19;
        String r3 = null;
    L20:
        this(r5, r0, r13, r2, r3);
        return;
    L19:
        r3 = r10;
        goto L20
    L15:
        r2 = r9;
        goto L17
    L11:
        r13 = r8;
        goto L13
    }
}
