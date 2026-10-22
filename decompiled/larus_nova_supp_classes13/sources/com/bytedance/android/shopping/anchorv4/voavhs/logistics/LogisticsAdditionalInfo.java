package com.bytedance.android.shopping.anchorv4.voavhs.logistics;

import com.bytedance.android.shopping.anchorv4.dto.base.Padding;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BE\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\u0011\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\nHÆ\u0003J\t\u0010\u001c\u001a\u00020\fHÆ\u0003JI\u0010\u001d\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\fHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020\fHÖ\u0001J\t\u0010#\u001a\u00020$HÖ\u0001R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u000b\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006%"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/logistics/LogisticsAdditionalInfo;", "Ljava/io/Serializable;", "qualityEmphasize", "", "Lcom/bytedance/android/shopping/anchorv4/voavhs/logistics/QualityEmphasizeElement;", "brand", "Lcom/bytedance/android/shopping/anchorv4/voavhs/logistics/BrandIllustrationElement;", "delivery", "Lcom/bytedance/android/shopping/anchorv4/voavhs/logistics/DeliveryDetailElement;", "padding", "Lcom/bytedance/android/shopping/anchorv4/dto/base/Padding;", "space", "", "(Ljava/util/List;Lcom/bytedance/android/shopping/anchorv4/voavhs/logistics/BrandIllustrationElement;Lcom/bytedance/android/shopping/anchorv4/voavhs/logistics/DeliveryDetailElement;Lcom/bytedance/android/shopping/anchorv4/dto/base/Padding;I)V", "getBrand", "()Lcom/bytedance/android/shopping/anchorv4/voavhs/logistics/BrandIllustrationElement;", "getDelivery", "()Lcom/bytedance/android/shopping/anchorv4/voavhs/logistics/DeliveryDetailElement;", "getPadding", "()Lcom/bytedance/android/shopping/anchorv4/dto/base/Padding;", "getQualityEmphasize", "()Ljava/util/List;", "getSpace", "()I", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "toString", "", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LogisticsAdditionalInfo implements Serializable {

    @SerializedName("brand")
    private final BrandIllustrationElement brand;

    @SerializedName("delivery")
    private final DeliveryDetailElement delivery;

    @SerializedName("padding")
    private final Padding padding;

    @SerializedName("quality_emphasize")
    private final List<QualityEmphasizeElement> qualityEmphasize;

    @SerializedName("space")
    private final int space;

    public LogisticsAdditionalInfo() {
        this(null, null, null, null, 0, 31, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LogisticsAdditionalInfo copy$default(LogisticsAdditionalInfo r3, List r4, BrandIllustrationElement r5, DeliveryDetailElement r6, Padding r7, int r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.qualityEmphasize;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.brand;
    L8:
        BrandIllustrationElement r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.delivery;
    L11:
        DeliveryDetailElement r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.padding;
    L14:
        Padding r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.space;
    L17:
        List r12 = r4;
        return r3.copy(r12, r11, r0, r1, r8);
    }

    public final List<QualityEmphasizeElement> component1() {
        return this.qualityEmphasize;
    }

    public final BrandIllustrationElement component2() {
        return this.brand;
    }

    public final DeliveryDetailElement component3() {
        return this.delivery;
    }

    public final Padding component4() {
        return this.padding;
    }

    public final int component5() {
        return this.space;
    }

    public final LogisticsAdditionalInfo copy(List<QualityEmphasizeElement> r8, BrandIllustrationElement r9, DeliveryDetailElement r10, Padding r11, int r12) {
        return new LogisticsAdditionalInfo(r8, r9, r10, r11, r12);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof LogisticsAdditionalInfo) == false) goto L16;
        LogisticsAdditionalInfo r4 = (LogisticsAdditionalInfo) r3;
        if (Intrinsics.areEqual(this.qualityEmphasize, r4.qualityEmphasize) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.brand, r4.brand) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.delivery, r4.delivery) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.padding, r4.padding) == true) goto L14;
        return false;
    L14:
        if (this.space == r4.space) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        List<QualityEmphasizeElement> r0 = this.qualityEmphasize;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        BrandIllustrationElement r4 = this.brand;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        DeliveryDetailElement r7 = this.delivery;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        Padding r10 = this.padding;
        if (r10 == null) goto L18;
        r1 = r10.hashCode();
    L18:
        return ((r9 + r1) * 31) + this.space;
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
        return "LogisticsAdditionalInfo(qualityEmphasize=" + this.qualityEmphasize + ", brand=" + this.brand + ", delivery=" + this.delivery + ", padding=" + this.padding + ", space=" + this.space + ")";
    }

    public final BrandIllustrationElement getBrand() {
        return this.brand;
    }

    public final DeliveryDetailElement getDelivery() {
        return this.delivery;
    }

    public final Padding getPadding() {
        return this.padding;
    }

    public final List<QualityEmphasizeElement> getQualityEmphasize() {
        return this.qualityEmphasize;
    }

    public final int getSpace() {
        return this.space;
    }

    public LogisticsAdditionalInfo(List<QualityEmphasizeElement> r1, BrandIllustrationElement r2, DeliveryDetailElement r3, Padding r4, int r5) {
        this.qualityEmphasize = r1;
        this.brand = r2;
        this.delivery = r3;
        this.padding = r4;
        this.space = r5;
    }

    public /* synthetic */ LogisticsAdditionalInfo(List r4, BrandIllustrationElement r5, DeliveryDetailElement r6, Padding r7, int r8, int r9, DefaultConstructorMarker r10) {
        Padding r0 = null;
        if ((r9 & 1) == 0) goto L5;
        List r11 = null;
    L7:
        if ((r9 & 2) == 0) goto L9;
        BrandIllustrationElement r1 = null;
    L11:
        if ((r9 & 4) == 0) goto L13;
        DeliveryDetailElement r2 = null;
    L15:
        if ((r9 & 8) != 0) goto L19;
        r0 = r7;
    L19:
        if ((r9 & 16) == 0) goto L21;
        int r12 = 0;
    L22:
        this(r11, r1, r2, r0, r12);
        return;
    L21:
        r12 = r8;
        goto L22
    L13:
        r2 = r6;
        goto L15
    L9:
        r1 = r5;
        goto L11
    L5:
        r11 = r4;
        goto L7
    }
}
