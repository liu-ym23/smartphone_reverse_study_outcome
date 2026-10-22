package com.bytedance.android.shopping.anchorv4.voavhs.car;

import com.bytedance.android.shopping.anchorv4.dto.components.LongContentLabelComponent;
import com.bytedance.android.shopping.anchorv4.dto.elements.TextElement;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J9\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/car/AnchorV4CarAddressDisplay;", "Ljava/io/Serializable;", "carTitle", "Lcom/bytedance/android/shopping/anchorv4/dto/components/LongContentLabelComponent;", "carAddress", "Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextElement;", "carDistance", "carAddressDetail", "(Lcom/bytedance/android/shopping/anchorv4/dto/components/LongContentLabelComponent;Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextElement;Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextElement;Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextElement;)V", "getCarAddress", "()Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextElement;", "getCarAddressDetail", "getCarDistance", "getCarTitle", "()Lcom/bytedance/android/shopping/anchorv4/dto/components/LongContentLabelComponent;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV4CarAddressDisplay implements Serializable {

    @SerializedName("car_address")
    private final TextElement carAddress;

    @SerializedName("car_address_detail")
    private final TextElement carAddressDetail;

    @SerializedName("car_distance")
    private final TextElement carDistance;

    @SerializedName("car_title")
    private final LongContentLabelComponent carTitle;

    public AnchorV4CarAddressDisplay() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ AnchorV4CarAddressDisplay copy$default(AnchorV4CarAddressDisplay r0, LongContentLabelComponent r1, TextElement r2, TextElement r3, TextElement r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.carTitle;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.carAddress;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.carDistance;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.carAddressDetail;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final LongContentLabelComponent component1() {
        return this.carTitle;
    }

    public final TextElement component2() {
        return this.carAddress;
    }

    public final TextElement component3() {
        return this.carDistance;
    }

    public final TextElement component4() {
        return this.carAddressDetail;
    }

    public final AnchorV4CarAddressDisplay copy(LongContentLabelComponent r2, TextElement r3, TextElement r4, TextElement r5) {
        return new AnchorV4CarAddressDisplay(r2, r3, r4, r5);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof AnchorV4CarAddressDisplay) == false) goto L14;
        AnchorV4CarAddressDisplay r4 = (AnchorV4CarAddressDisplay) r3;
        if (Intrinsics.areEqual(this.carTitle, r4.carTitle) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.carAddress, r4.carAddress) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.carDistance, r4.carDistance) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.carAddressDetail, r4.carAddressDetail) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        LongContentLabelComponent r0 = this.carTitle;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        TextElement r4 = this.carAddress;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        TextElement r7 = this.carDistance;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        TextElement r10 = this.carAddressDetail;
        if (r10 == null) goto L18;
        r1 = r10.hashCode();
    L18:
        return r9 + r1;
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
        return "AnchorV4CarAddressDisplay(carTitle=" + this.carTitle + ", carAddress=" + this.carAddress + ", carDistance=" + this.carDistance + ", carAddressDetail=" + this.carAddressDetail + ")";
    }

    public final TextElement getCarAddress() {
        return this.carAddress;
    }

    public final TextElement getCarAddressDetail() {
        return this.carAddressDetail;
    }

    public final TextElement getCarDistance() {
        return this.carDistance;
    }

    public final LongContentLabelComponent getCarTitle() {
        return this.carTitle;
    }

    public AnchorV4CarAddressDisplay(LongContentLabelComponent r1, TextElement r2, TextElement r3, TextElement r4) {
        this.carTitle = r1;
        this.carAddress = r2;
        this.carDistance = r3;
        this.carAddressDetail = r4;
    }

    public /* synthetic */ AnchorV4CarAddressDisplay(LongContentLabelComponent r2, TextElement r3, TextElement r4, TextElement r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r6 & 8) == 0) goto L14;
        r5 = null;
    L14:
        this(r2, r3, r4, r5);
    }
}
