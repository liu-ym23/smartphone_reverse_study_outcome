package com.bytedance.android.shopping.anchorv4.voavhs.shop;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\t\n\u0002\b\u001d\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u008d\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\n\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\n\u0012\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\n\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0010J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\nHÆ\u0003J\u0011\u0010$\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\nHÆ\u0003J\u0011\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\nHÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0091\u0001\u0010'\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\n2\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\n2\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\n2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010(\u001a\u00020\u00072\b\u0010)\u001a\u0004\u0018\u00010*HÖ\u0003J\t\u0010+\u001a\u00020,HÖ\u0001J\t\u0010-\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0011R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u001e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u001e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0013R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0013R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0013R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0013¨\u0006."}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/shop/AnchorV4ShopAndStoreBusinessMeta;", "Ljava/io/Serializable;", "shopNavLink", "", "shopAvatarLink", "shopPortfolioUrl", "isStore", "", "shopAuthorId", "shopCouponUrl", "", "shopCouponType", "", "shopCouponEntranceLocation", "shopRankList", "shopReputationLink", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "()Z", "getShopAuthorId", "()Ljava/lang/String;", "getShopAvatarLink", "getShopCouponEntranceLocation", "()Ljava/util/List;", "getShopCouponType", "getShopCouponUrl", "getShopNavLink", "getShopPortfolioUrl", "getShopRankList", "getShopReputationLink", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "", "hashCode", "", "toString", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV4ShopAndStoreBusinessMeta implements Serializable {

    @SerializedName("is_store")
    private final boolean isStore;

    @SerializedName("shop_author_id")
    private final String shopAuthorId;

    @SerializedName("shop_avatar_link")
    private final String shopAvatarLink;

    @SerializedName("shop_coupon_entrance_location")
    private final List<String> shopCouponEntranceLocation;

    @SerializedName("shop_coupon_type")
    private final List<Long> shopCouponType;

    @SerializedName("shop_coupon_url")
    private final List<String> shopCouponUrl;

    @SerializedName("shop_nav_link")
    private final String shopNavLink;

    @SerializedName("shop_portfolio_url")
    private final String shopPortfolioUrl;

    @SerializedName("shop_rank_list")
    private final String shopRankList;

    @SerializedName("shop_reputation_link")
    private final String shopReputationLink;

    public AnchorV4ShopAndStoreBusinessMeta() {
        this(null, null, null, false, null, null, null, null, null, null, 1023, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AnchorV4ShopAndStoreBusinessMeta copy$default(AnchorV4ShopAndStoreBusinessMeta r11, String r12, String r13, String r14, boolean r15, String r16, List r17, List r18, List r19, String r20, String r21, int r22, Object r23) {
        if ((r22 & 1) == 0) goto L5;
        String r2 = r11.shopNavLink;
    L7:
        if ((r22 & 2) == 0) goto L9;
        String r3 = r11.shopAvatarLink;
    L11:
        if ((r22 & 4) == 0) goto L13;
        String r4 = r11.shopPortfolioUrl;
    L15:
        if ((r22 & 8) == 0) goto L17;
        boolean r5 = r11.isStore;
    L19:
        if ((r22 & 16) == 0) goto L21;
        String r6 = r11.shopAuthorId;
    L23:
        if ((r22 & 32) == 0) goto L25;
        List r7 = r11.shopCouponUrl;
    L27:
        if ((r22 & 64) == 0) goto L29;
        List r8 = r11.shopCouponType;
    L31:
        if ((r22 & 128) == 0) goto L33;
        List r9 = r11.shopCouponEntranceLocation;
    L35:
        if ((r22 & 256) == 0) goto L37;
        String r10 = r11.shopRankList;
    L39:
        if ((r22 & 512) == 0) goto L41;
        String r1 = r11.shopReputationLink;
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
        return this.shopNavLink;
    }

    public final String component10() {
        return this.shopReputationLink;
    }

    public final String component2() {
        return this.shopAvatarLink;
    }

    public final String component3() {
        return this.shopPortfolioUrl;
    }

    public final boolean component4() {
        return this.isStore;
    }

    public final String component5() {
        return this.shopAuthorId;
    }

    public final List<String> component6() {
        return this.shopCouponUrl;
    }

    public final List<Long> component7() {
        return this.shopCouponType;
    }

    public final List<String> component8() {
        return this.shopCouponEntranceLocation;
    }

    public final String component9() {
        return this.shopRankList;
    }

    public final AnchorV4ShopAndStoreBusinessMeta copy(String r13, String r14, String r15, boolean r16, String r17, List<String> r18, List<Long> r19, List<String> r20, String r21, String r22) {
        return new AnchorV4ShopAndStoreBusinessMeta(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof AnchorV4ShopAndStoreBusinessMeta) == false) goto L26;
        AnchorV4ShopAndStoreBusinessMeta r4 = (AnchorV4ShopAndStoreBusinessMeta) r3;
        if (Intrinsics.areEqual(this.shopNavLink, r4.shopNavLink) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.shopAvatarLink, r4.shopAvatarLink) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.shopPortfolioUrl, r4.shopPortfolioUrl) == true) goto L12;
        return false;
    L12:
        if (this.isStore == r4.isStore) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.shopAuthorId, r4.shopAuthorId) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.shopCouponUrl, r4.shopCouponUrl) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.shopCouponType, r4.shopCouponType) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.shopCouponEntranceLocation, r4.shopCouponEntranceLocation) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.shopRankList, r4.shopRankList) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.shopReputationLink, r4.shopReputationLink) == true) goto L40;
        return false;
    L40:
        return true;
    L26:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r2v29 */
    /* JADX WARN: Type inference failed for: r2v32 */
    /* JADX WARN: Type inference failed for: r2v7, types: [int] */
    public int hashCode() {
        String r0 = this.shopNavLink;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.shopAvatarLink;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.shopPortfolioUrl;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        boolean r10 = this.isStore;
        ?? r11 = r10;
        if (r10 == false) goto L17;
        r11 = 1;
    L17:
        int r12 = (r9 + r11) * 31;
        String r13 = this.shopAuthorId;
        if (r13 == null) goto L20;
        int r14 = r13.hashCode();
    L21:
        int r15 = (r12 + r14) * 31;
        List<String> r16 = this.shopCouponUrl;
        if (r16 == null) goto L24;
        int r17 = r16.hashCode();
    L25:
        int r18 = (r15 + r17) * 31;
        List<Long> r19 = this.shopCouponType;
        if (r19 == null) goto L28;
        int r20 = r19.hashCode();
    L29:
        int r21 = (r18 + r20) * 31;
        List<String> r22 = this.shopCouponEntranceLocation;
        if (r22 == null) goto L32;
        int r23 = r22.hashCode();
    L33:
        int r24 = (r21 + r23) * 31;
        String r25 = this.shopRankList;
        if (r25 == null) goto L36;
        int r26 = r25.hashCode();
    L37:
        int r27 = (r24 + r26) * 31;
        String r28 = this.shopReputationLink;
        if (r28 == null) goto L41;
        r1 = r28.hashCode();
    L41:
        return r27 + r1;
    L36:
        r26 = 0;
        goto L37
    L32:
        r23 = 0;
        goto L33
    L28:
        r20 = 0;
        goto L29
    L24:
        r17 = 0;
        goto L25
    L20:
        r14 = 0;
        goto L21
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
        return "AnchorV4ShopAndStoreBusinessMeta(shopNavLink=" + this.shopNavLink + ", shopAvatarLink=" + this.shopAvatarLink + ", shopPortfolioUrl=" + this.shopPortfolioUrl + ", isStore=" + this.isStore + ", shopAuthorId=" + this.shopAuthorId + ", shopCouponUrl=" + this.shopCouponUrl + ", shopCouponType=" + this.shopCouponType + ", shopCouponEntranceLocation=" + this.shopCouponEntranceLocation + ", shopRankList=" + this.shopRankList + ", shopReputationLink=" + this.shopReputationLink + ")";
    }

    public final String getShopAuthorId() {
        return this.shopAuthorId;
    }

    public final String getShopAvatarLink() {
        return this.shopAvatarLink;
    }

    public final List<String> getShopCouponEntranceLocation() {
        return this.shopCouponEntranceLocation;
    }

    public final List<Long> getShopCouponType() {
        return this.shopCouponType;
    }

    public final List<String> getShopCouponUrl() {
        return this.shopCouponUrl;
    }

    public final String getShopNavLink() {
        return this.shopNavLink;
    }

    public final String getShopPortfolioUrl() {
        return this.shopPortfolioUrl;
    }

    public final String getShopRankList() {
        return this.shopRankList;
    }

    public final String getShopReputationLink() {
        return this.shopReputationLink;
    }

    public final boolean isStore() {
        return this.isStore;
    }

    public AnchorV4ShopAndStoreBusinessMeta(String r1, String r2, String r3, boolean r4, String r5, List<String> r6, List<Long> r7, List<String> r8, String r9, String r10) {
        this.shopNavLink = r1;
        this.shopAvatarLink = r2;
        this.shopPortfolioUrl = r3;
        this.isStore = r4;
        this.shopAuthorId = r5;
        this.shopCouponUrl = r6;
        this.shopCouponType = r7;
        this.shopCouponEntranceLocation = r8;
        this.shopRankList = r9;
        this.shopReputationLink = r10;
    }

    public /* synthetic */ AnchorV4ShopAndStoreBusinessMeta(String r12, String r13, String r14, boolean r15, String r16, List r17, List r18, List r19, String r20, String r21, int r22, DefaultConstructorMarker r23) {
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
        boolean r5 = false;
    L19:
        if ((r22 & 16) == 0) goto L21;
        String r6 = null;
    L23:
        if ((r22 & 32) == 0) goto L25;
        List r7 = null;
    L27:
        if ((r22 & 64) == 0) goto L29;
        List r8 = null;
    L31:
        if ((r22 & 128) == 0) goto L33;
        List r9 = null;
    L35:
        if ((r22 & 256) == 0) goto L37;
        String r10 = null;
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
