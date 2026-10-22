package com.bytedance.android.shopping.anchorv4.voavhs.shop;

import com.bytedance.android.shopping.anchorv4.dto.elements.TextElement;
import com.bytedance.android.shopping.anchorv4.dto.elements.TextWithOneIconElement;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005HÆ\u0003J)\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR \u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/shop/AnchorV4ShopDetailMainInfo;", "Ljava/io/Serializable;", "shopRating", "Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextWithOneIconElement;", "textArray", "", "Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextElement;", "(Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextWithOneIconElement;Ljava/util/List;)V", "getShopRating", "()Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextWithOneIconElement;", "getTextArray", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV4ShopDetailMainInfo implements Serializable {

    @SerializedName("shop_rating")
    private final TextWithOneIconElement shopRating;

    @SerializedName("text_array")
    private final List<TextElement> textArray;

    public AnchorV4ShopDetailMainInfo() {
        TextWithOneIconElement r0 = null;
        this(r0, r0, 3, r0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AnchorV4ShopDetailMainInfo copy$default(AnchorV4ShopDetailMainInfo r0, TextWithOneIconElement r1, List r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.shopRating;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.textArray;
    L9:
        return r0.copy(r1, r2);
    }

    public final TextWithOneIconElement component1() {
        return this.shopRating;
    }

    public final List<TextElement> component2() {
        return this.textArray;
    }

    public final AnchorV4ShopDetailMainInfo copy(TextWithOneIconElement r2, List<TextElement> r3) {
        return new AnchorV4ShopDetailMainInfo(r2, r3);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof AnchorV4ShopDetailMainInfo) == false) goto L10;
        AnchorV4ShopDetailMainInfo r4 = (AnchorV4ShopDetailMainInfo) r3;
        if (Intrinsics.areEqual(this.shopRating, r4.shopRating) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.textArray, r4.textArray) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        TextWithOneIconElement r0 = this.shopRating;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        List<TextElement> r4 = this.textArray;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "AnchorV4ShopDetailMainInfo(shopRating=" + this.shopRating + ", textArray=" + this.textArray + ")";
    }

    public final TextWithOneIconElement getShopRating() {
        return this.shopRating;
    }

    public final List<TextElement> getTextArray() {
        return this.textArray;
    }

    public AnchorV4ShopDetailMainInfo(TextWithOneIconElement r1, List<TextElement> r2) {
        this.shopRating = r1;
        this.textArray = r2;
    }

    public /* synthetic */ AnchorV4ShopDetailMainInfo(TextWithOneIconElement r2, List r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }
}
