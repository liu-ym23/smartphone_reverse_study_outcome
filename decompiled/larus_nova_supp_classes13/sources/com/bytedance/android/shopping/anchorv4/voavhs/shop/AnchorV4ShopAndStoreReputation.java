package com.bytedance.android.shopping.anchorv4.voavhs.shop;

import com.bytedance.android.shopping.anchorv4.dto.components.LynxCardComponent;
import com.bytedance.android.shopping.anchorv4.dto.components.TagsScrollBoxComponent;
import com.bytedance.android.shopping.anchorv4.dto.elements.TextElement;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BS\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fJ\u0011\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u000bHÆ\u0003JW\u0010\u001a\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\tHÖ\u0001R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u001e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012¨\u0006\""}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/shop/AnchorV4ShopAndStoreReputation;", "Ljava/io/Serializable;", "shopFollowerCount", "", "Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextElement;", "shopSellNum", "subScoreList", "Lcom/bytedance/android/shopping/anchorv4/dto/components/TagsScrollBoxComponent;", "dividerColor", "", "lynxReputation", "Lcom/bytedance/android/shopping/anchorv4/dto/components/LynxCardComponent;", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Lcom/bytedance/android/shopping/anchorv4/dto/components/LynxCardComponent;)V", "getDividerColor", "()Ljava/lang/String;", "getLynxReputation", "()Lcom/bytedance/android/shopping/anchorv4/dto/components/LynxCardComponent;", "getShopFollowerCount", "()Ljava/util/List;", "getShopSellNum", "getSubScoreList", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "", "toString", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV4ShopAndStoreReputation implements Serializable {

    @SerializedName("divider_color")
    private final String dividerColor;

    @SerializedName("lynx_reputation")
    private final LynxCardComponent lynxReputation;

    @SerializedName("shop_follower_section")
    private final List<TextElement> shopFollowerCount;

    @SerializedName("shop_sell_section")
    private final List<TextElement> shopSellNum;

    @SerializedName("shop_score_section")
    private final List<TagsScrollBoxComponent> subScoreList;

    public AnchorV4ShopAndStoreReputation() {
        this(null, null, null, null, null, 31, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AnchorV4ShopAndStoreReputation copy$default(AnchorV4ShopAndStoreReputation r3, List r4, List r5, List r6, String r7, LynxCardComponent r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.shopFollowerCount;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.shopSellNum;
    L8:
        List r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.subScoreList;
    L11:
        List r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.dividerColor;
    L14:
        String r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.lynxReputation;
    L17:
        List r12 = r4;
        return r3.copy(r12, r11, r0, r1, r8);
    }

    public final List<TextElement> component1() {
        return this.shopFollowerCount;
    }

    public final List<TextElement> component2() {
        return this.shopSellNum;
    }

    public final List<TagsScrollBoxComponent> component3() {
        return this.subScoreList;
    }

    public final String component4() {
        return this.dividerColor;
    }

    public final LynxCardComponent component5() {
        return this.lynxReputation;
    }

    public final AnchorV4ShopAndStoreReputation copy(List<TextElement> r8, List<TextElement> r9, List<TagsScrollBoxComponent> r10, String r11, LynxCardComponent r12) {
        return new AnchorV4ShopAndStoreReputation(r8, r9, r10, r11, r12);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof AnchorV4ShopAndStoreReputation) == false) goto L16;
        AnchorV4ShopAndStoreReputation r4 = (AnchorV4ShopAndStoreReputation) r3;
        if (Intrinsics.areEqual(this.shopFollowerCount, r4.shopFollowerCount) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.shopSellNum, r4.shopSellNum) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.subScoreList, r4.subScoreList) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.dividerColor, r4.dividerColor) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.lynxReputation, r4.lynxReputation) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        List<TextElement> r0 = this.shopFollowerCount;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        List<TextElement> r4 = this.shopSellNum;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        List<TagsScrollBoxComponent> r7 = this.subScoreList;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.dividerColor;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        LynxCardComponent r13 = this.lynxReputation;
        if (r13 == null) goto L22;
        r1 = r13.hashCode();
    L22:
        return r12 + r1;
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
        return "AnchorV4ShopAndStoreReputation(shopFollowerCount=" + this.shopFollowerCount + ", shopSellNum=" + this.shopSellNum + ", subScoreList=" + this.subScoreList + ", dividerColor=" + this.dividerColor + ", lynxReputation=" + this.lynxReputation + ")";
    }

    public final String getDividerColor() {
        return this.dividerColor;
    }

    public final LynxCardComponent getLynxReputation() {
        return this.lynxReputation;
    }

    public final List<TextElement> getShopFollowerCount() {
        return this.shopFollowerCount;
    }

    public final List<TextElement> getShopSellNum() {
        return this.shopSellNum;
    }

    public final List<TagsScrollBoxComponent> getSubScoreList() {
        return this.subScoreList;
    }

    public AnchorV4ShopAndStoreReputation(List<TextElement> r1, List<TextElement> r2, List<TagsScrollBoxComponent> r3, String r4, LynxCardComponent r5) {
        this.shopFollowerCount = r1;
        this.shopSellNum = r2;
        this.subScoreList = r3;
        this.dividerColor = r4;
        this.lynxReputation = r5;
    }

    public /* synthetic */ AnchorV4ShopAndStoreReputation(List r5, List r6, List r7, String r8, LynxCardComponent r9, int r10, DefaultConstructorMarker r11) {
        if ((r10 & 1) == 0) goto L5;
        List r12 = null;
    L7:
        if ((r10 & 2) == 0) goto L9;
        List r1 = null;
    L11:
        if ((r10 & 4) == 0) goto L13;
        List r2 = null;
    L15:
        if ((r10 & 8) == 0) goto L17;
        String r3 = null;
    L19:
        if ((r10 & 16) == 0) goto L21;
        LynxCardComponent r13 = null;
    L22:
        this(r12, r1, r2, r3, r13);
        return;
    L21:
        r13 = r9;
        goto L22
    L17:
        r3 = r8;
        goto L19
    L13:
        r2 = r7;
        goto L15
    L9:
        r1 = r6;
        goto L11
    L5:
        r12 = r5;
        goto L7
    }
}
