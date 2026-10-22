package com.bytedance.android.shopping.anchorv4.voavhs.offerrecord;

import com.bytedance.android.shopping.anchorv4.dto.components.LongContentLabelComponent;
import com.bytedance.android.shopping.anchorv4.dto.elements.PriceElement;
import com.bytedance.android.shopping.anchorv4.dto.elements.TextElement;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0007HÆ\u0003J-\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/offerrecord/AnchorV4OfferRecordItemVO;", "Ljava/io/Serializable;", "price", "Lcom/bytedance/android/shopping/anchorv4/dto/elements/PriceElement;", "author", "Lcom/bytedance/android/shopping/anchorv4/dto/components/LongContentLabelComponent;", "dateTime", "Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextElement;", "(Lcom/bytedance/android/shopping/anchorv4/dto/elements/PriceElement;Lcom/bytedance/android/shopping/anchorv4/dto/components/LongContentLabelComponent;Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextElement;)V", "getAuthor", "()Lcom/bytedance/android/shopping/anchorv4/dto/components/LongContentLabelComponent;", "getDateTime", "()Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextElement;", "getPrice", "()Lcom/bytedance/android/shopping/anchorv4/dto/elements/PriceElement;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV4OfferRecordItemVO implements Serializable {

    @SerializedName("author")
    private final LongContentLabelComponent author;

    @SerializedName("date_time")
    private final TextElement dateTime;

    @SerializedName("price")
    private final PriceElement price;

    public AnchorV4OfferRecordItemVO() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ AnchorV4OfferRecordItemVO copy$default(AnchorV4OfferRecordItemVO r0, PriceElement r1, LongContentLabelComponent r2, TextElement r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.price;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.author;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.dateTime;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final PriceElement component1() {
        return this.price;
    }

    public final LongContentLabelComponent component2() {
        return this.author;
    }

    public final TextElement component3() {
        return this.dateTime;
    }

    public final AnchorV4OfferRecordItemVO copy(PriceElement r2, LongContentLabelComponent r3, TextElement r4) {
        return new AnchorV4OfferRecordItemVO(r2, r3, r4);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof AnchorV4OfferRecordItemVO) == false) goto L12;
        AnchorV4OfferRecordItemVO r4 = (AnchorV4OfferRecordItemVO) r3;
        if (Intrinsics.areEqual(this.price, r4.price) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.author, r4.author) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.dateTime, r4.dateTime) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        PriceElement r0 = this.price;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        LongContentLabelComponent r4 = this.author;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        TextElement r7 = this.dateTime;
        if (r7 == null) goto L14;
        r1 = r7.hashCode();
    L14:
        return r6 + r1;
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "AnchorV4OfferRecordItemVO(price=" + this.price + ", author=" + this.author + ", dateTime=" + this.dateTime + ")";
    }

    public final LongContentLabelComponent getAuthor() {
        return this.author;
    }

    public final TextElement getDateTime() {
        return this.dateTime;
    }

    public final PriceElement getPrice() {
        return this.price;
    }

    public AnchorV4OfferRecordItemVO(PriceElement r1, LongContentLabelComponent r2, TextElement r3) {
        this.price = r1;
        this.author = r2;
        this.dateTime = r3;
    }

    public /* synthetic */ AnchorV4OfferRecordItemVO(PriceElement r2, LongContentLabelComponent r3, TextElement r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = null;
    L11:
        this(r2, r3, r4);
    }
}
