package com.bytedance.android.shopping.anchorv4.voavhs.baseinfo;

import com.bytedance.android.shopping.anchorv4.dto.components.LongContentLabelComponent;
import com.bytedance.android.shopping.anchorv4.dto.components.LongTitleComponent;
import com.bytedance.android.shopping.anchorv4.dto.components.SkuBaseInfoComponent;
import com.bytedance.android.shopping.anchorv4.dto.components.TagsScrollBoxComponent;
import com.bytedance.android.shopping.anchorv4.dto.elements.PriceElement;
import com.bytedance.android.shopping.anchorv4.dto.elements.TextElement;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B}\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0002\u0010\u0012J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0011\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\u0081\u0001\u0010+\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÆ\u0001J\u0013\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010/HÖ\u0003J\t\u00100\u001a\u000201HÖ\u0001J\t\u00102\u001a\u000203HÖ\u0001R\u001e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0018\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0018\u0010\r\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u001e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0014R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!¨\u00064"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/baseinfo/BaseInfoVO;", "Ljava/io/Serializable;", "skuInfo", "Lcom/bytedance/android/shopping/anchorv4/dto/components/SkuBaseInfoComponent;", "tagsList", "", "Lcom/bytedance/android/shopping/anchorv4/dto/components/LongContentLabelComponent;", "goodsTitle", "Lcom/bytedance/android/shopping/anchorv4/dto/components/LongTitleComponent;", "bottomTagsList", "marketPrice", "Lcom/bytedance/android/shopping/anchorv4/dto/elements/PriceElement;", "discountPrice", "price", "sales", "Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextElement;", "userLike", "Lcom/bytedance/android/shopping/anchorv4/dto/components/TagsScrollBoxComponent;", "(Lcom/bytedance/android/shopping/anchorv4/dto/components/SkuBaseInfoComponent;Ljava/util/List;Lcom/bytedance/android/shopping/anchorv4/dto/components/LongTitleComponent;Ljava/util/List;Lcom/bytedance/android/shopping/anchorv4/dto/elements/PriceElement;Lcom/bytedance/android/shopping/anchorv4/dto/elements/PriceElement;Lcom/bytedance/android/shopping/anchorv4/dto/elements/PriceElement;Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextElement;Lcom/bytedance/android/shopping/anchorv4/dto/components/TagsScrollBoxComponent;)V", "getBottomTagsList", "()Ljava/util/List;", "getDiscountPrice", "()Lcom/bytedance/android/shopping/anchorv4/dto/elements/PriceElement;", "getGoodsTitle", "()Lcom/bytedance/android/shopping/anchorv4/dto/components/LongTitleComponent;", "getMarketPrice", "getPrice", "getSales", "()Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextElement;", "getSkuInfo", "()Lcom/bytedance/android/shopping/anchorv4/dto/components/SkuBaseInfoComponent;", "getTagsList", "getUserLike", "()Lcom/bytedance/android/shopping/anchorv4/dto/components/TagsScrollBoxComponent;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BaseInfoVO implements Serializable {

    @SerializedName("bottom_tag_list")
    private final List<LongContentLabelComponent> bottomTagsList;

    @SerializedName("discount_price")
    private final PriceElement discountPrice;

    @SerializedName("goods_title")
    private final LongTitleComponent goodsTitle;

    @SerializedName("market_price")
    private final PriceElement marketPrice;

    @SerializedName("price")
    private final PriceElement price;

    @SerializedName("sales")
    private final TextElement sales;

    @SerializedName("sku_info")
    private final SkuBaseInfoComponent skuInfo;

    @SerializedName("tags_list")
    private final List<LongContentLabelComponent> tagsList;

    @SerializedName("user_like")
    private final TagsScrollBoxComponent userLike;

    public BaseInfoVO() {
        this(null, null, null, null, null, null, null, null, null, 511, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BaseInfoVO copy$default(BaseInfoVO r10, SkuBaseInfoComponent r11, List r12, LongTitleComponent r13, List r14, PriceElement r15, PriceElement r16, PriceElement r17, TextElement r18, TagsScrollBoxComponent r19, int r20, Object r21) {
        if ((r20 & 1) == 0) goto L5;
        SkuBaseInfoComponent r2 = r10.skuInfo;
    L7:
        if ((r20 & 2) == 0) goto L9;
        List r3 = r10.tagsList;
    L11:
        if ((r20 & 4) == 0) goto L13;
        LongTitleComponent r4 = r10.goodsTitle;
    L15:
        if ((r20 & 8) == 0) goto L17;
        List r5 = r10.bottomTagsList;
    L19:
        if ((r20 & 16) == 0) goto L21;
        PriceElement r6 = r10.marketPrice;
    L23:
        if ((r20 & 32) == 0) goto L25;
        PriceElement r7 = r10.discountPrice;
    L27:
        if ((r20 & 64) == 0) goto L29;
        PriceElement r8 = r10.price;
    L31:
        if ((r20 & 128) == 0) goto L33;
        TextElement r9 = r10.sales;
    L35:
        if ((r20 & 256) == 0) goto L37;
        TagsScrollBoxComponent r1 = r10.userLike;
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

    public final SkuBaseInfoComponent component1() {
        return this.skuInfo;
    }

    public final List<LongContentLabelComponent> component2() {
        return this.tagsList;
    }

    public final LongTitleComponent component3() {
        return this.goodsTitle;
    }

    public final List<LongContentLabelComponent> component4() {
        return this.bottomTagsList;
    }

    public final PriceElement component5() {
        return this.marketPrice;
    }

    public final PriceElement component6() {
        return this.discountPrice;
    }

    public final PriceElement component7() {
        return this.price;
    }

    public final TextElement component8() {
        return this.sales;
    }

    public final TagsScrollBoxComponent component9() {
        return this.userLike;
    }

    public final BaseInfoVO copy(SkuBaseInfoComponent r12, List<? extends LongContentLabelComponent> r13, LongTitleComponent r14, List<? extends LongContentLabelComponent> r15, PriceElement r16, PriceElement r17, PriceElement r18, TextElement r19, TagsScrollBoxComponent r20) {
        return new BaseInfoVO(r12, r13, r14, r15, r16, r17, r18, r19, r20);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof BaseInfoVO) == false) goto L24;
        BaseInfoVO r4 = (BaseInfoVO) r3;
        if (Intrinsics.areEqual(this.skuInfo, r4.skuInfo) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.tagsList, r4.tagsList) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.goodsTitle, r4.goodsTitle) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.bottomTagsList, r4.bottomTagsList) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.marketPrice, r4.marketPrice) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.discountPrice, r4.discountPrice) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.price, r4.price) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.sales, r4.sales) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.userLike, r4.userLike) == true) goto L37;
        return false;
    L37:
        return true;
    L24:
        return false;
    }

    public int hashCode() {
        SkuBaseInfoComponent r0 = this.skuInfo;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        List<LongContentLabelComponent> r4 = this.tagsList;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        LongTitleComponent r7 = this.goodsTitle;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        List<LongContentLabelComponent> r10 = this.bottomTagsList;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        PriceElement r13 = this.marketPrice;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        PriceElement r16 = this.discountPrice;
        if (r16 == null) goto L25;
        int r17 = r16.hashCode();
    L26:
        int r18 = (r15 + r17) * 31;
        PriceElement r19 = this.price;
        if (r19 == null) goto L29;
        int r20 = r19.hashCode();
    L30:
        int r21 = (r18 + r20) * 31;
        TextElement r22 = this.sales;
        if (r22 == null) goto L33;
        int r23 = r22.hashCode();
    L34:
        int r24 = (r21 + r23) * 31;
        TagsScrollBoxComponent r25 = this.userLike;
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
        return "BaseInfoVO(skuInfo=" + this.skuInfo + ", tagsList=" + this.tagsList + ", goodsTitle=" + this.goodsTitle + ", bottomTagsList=" + this.bottomTagsList + ", marketPrice=" + this.marketPrice + ", discountPrice=" + this.discountPrice + ", price=" + this.price + ", sales=" + this.sales + ", userLike=" + this.userLike + ")";
    }

    public final List<LongContentLabelComponent> getBottomTagsList() {
        return this.bottomTagsList;
    }

    public final PriceElement getDiscountPrice() {
        return this.discountPrice;
    }

    public final LongTitleComponent getGoodsTitle() {
        return this.goodsTitle;
    }

    public final PriceElement getMarketPrice() {
        return this.marketPrice;
    }

    public final PriceElement getPrice() {
        return this.price;
    }

    public final TextElement getSales() {
        return this.sales;
    }

    public final SkuBaseInfoComponent getSkuInfo() {
        return this.skuInfo;
    }

    public final List<LongContentLabelComponent> getTagsList() {
        return this.tagsList;
    }

    public final TagsScrollBoxComponent getUserLike() {
        return this.userLike;
    }

    public BaseInfoVO(SkuBaseInfoComponent r1, List<? extends LongContentLabelComponent> r2, LongTitleComponent r3, List<? extends LongContentLabelComponent> r4, PriceElement r5, PriceElement r6, PriceElement r7, TextElement r8, TagsScrollBoxComponent r9) {
        this.skuInfo = r1;
        this.tagsList = r2;
        this.goodsTitle = r3;
        this.bottomTagsList = r4;
        this.marketPrice = r5;
        this.discountPrice = r6;
        this.price = r7;
        this.sales = r8;
        this.userLike = r9;
    }

    public /* synthetic */ BaseInfoVO(SkuBaseInfoComponent r11, List r12, LongTitleComponent r13, List r14, PriceElement r15, PriceElement r16, PriceElement r17, TextElement r18, TagsScrollBoxComponent r19, int r20, DefaultConstructorMarker r21) {
        TagsScrollBoxComponent r2 = null;
        if ((r20 & 1) == 0) goto L5;
        SkuBaseInfoComponent r1 = null;
    L7:
        if ((r20 & 2) == 0) goto L9;
        List r3 = null;
    L11:
        if ((r20 & 4) == 0) goto L13;
        LongTitleComponent r4 = null;
    L15:
        if ((r20 & 8) == 0) goto L17;
        List r5 = null;
    L19:
        if ((r20 & 16) == 0) goto L21;
        PriceElement r6 = null;
    L23:
        if ((r20 & 32) == 0) goto L25;
        PriceElement r7 = null;
    L27:
        if ((r20 & 64) == 0) goto L29;
        PriceElement r8 = null;
    L31:
        if ((r20 & 128) == 0) goto L33;
        TextElement r9 = null;
    L35:
        if ((r20 & 256) != 0) goto L38;
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
