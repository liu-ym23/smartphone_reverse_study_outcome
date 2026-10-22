package com.bytedance.android.shopping.anchorv4.voavhs.logistics;

import com.bytedance.android.shopping.anchorv4.dto.base.Background;
import com.bytedance.android.shopping.anchorv4.dto.base.Padding;
import com.bytedance.android.shopping.anchorv4.dto.components.LongContentLabelComponent;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BE\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rJ\u0011\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u0010\u001b\u001a\u00020\nHÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\fHÆ\u0003JI\u0010\u001d\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020\nHÖ\u0001J\t\u0010#\u001a\u00020$HÖ\u0001R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006%"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/logistics/AnchorV4LogisticsAndCouponDisplay;", "Ljava/io/Serializable;", "serviceDetail", "", "Lcom/bytedance/android/shopping/anchorv4/voavhs/logistics/ServiceComponent;", "guaranteeHeader", "Lcom/bytedance/android/shopping/anchorv4/dto/components/LongContentLabelComponent;", "background", "Lcom/bytedance/android/shopping/anchorv4/dto/base/Background;", "space", "", "padding", "Lcom/bytedance/android/shopping/anchorv4/dto/base/Padding;", "(Ljava/util/List;Lcom/bytedance/android/shopping/anchorv4/dto/components/LongContentLabelComponent;Lcom/bytedance/android/shopping/anchorv4/dto/base/Background;ILcom/bytedance/android/shopping/anchorv4/dto/base/Padding;)V", "getBackground", "()Lcom/bytedance/android/shopping/anchorv4/dto/base/Background;", "getGuaranteeHeader", "()Lcom/bytedance/android/shopping/anchorv4/dto/components/LongContentLabelComponent;", "getPadding", "()Lcom/bytedance/android/shopping/anchorv4/dto/base/Padding;", "getServiceDetail", "()Ljava/util/List;", "getSpace", "()I", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "toString", "", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV4LogisticsAndCouponDisplay implements Serializable {

    @SerializedName("service_background")
    private final Background background;

    @SerializedName("guarantee_header")
    private final LongContentLabelComponent guaranteeHeader;

    @SerializedName("padding")
    private final Padding padding;

    @SerializedName("service_detail")
    private final List<ServiceComponent> serviceDetail;

    @SerializedName("space")
    private final int space;

    public AnchorV4LogisticsAndCouponDisplay() {
        this(null, null, null, 0, null, 31, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AnchorV4LogisticsAndCouponDisplay copy$default(AnchorV4LogisticsAndCouponDisplay r3, List r4, LongContentLabelComponent r5, Background r6, int r7, Padding r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.serviceDetail;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.guaranteeHeader;
    L8:
        LongContentLabelComponent r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.background;
    L11:
        Background r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.space;
    L14:
        int r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.padding;
    L17:
        List r12 = r4;
        return r3.copy(r12, r11, r0, r1, r8);
    }

    public final List<ServiceComponent> component1() {
        return this.serviceDetail;
    }

    public final LongContentLabelComponent component2() {
        return this.guaranteeHeader;
    }

    public final Background component3() {
        return this.background;
    }

    public final int component4() {
        return this.space;
    }

    public final Padding component5() {
        return this.padding;
    }

    public final AnchorV4LogisticsAndCouponDisplay copy(List<ServiceComponent> r8, LongContentLabelComponent r9, Background r10, int r11, Padding r12) {
        return new AnchorV4LogisticsAndCouponDisplay(r8, r9, r10, r11, r12);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof AnchorV4LogisticsAndCouponDisplay) == false) goto L16;
        AnchorV4LogisticsAndCouponDisplay r4 = (AnchorV4LogisticsAndCouponDisplay) r3;
        if (Intrinsics.areEqual(this.serviceDetail, r4.serviceDetail) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.guaranteeHeader, r4.guaranteeHeader) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.background, r4.background) == true) goto L12;
        return false;
    L12:
        if (this.space == r4.space) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.padding, r4.padding) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        List<ServiceComponent> r0 = this.serviceDetail;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        LongContentLabelComponent r4 = this.guaranteeHeader;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        Background r7 = this.background;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (((r6 + r8) * 31) + this.space) * 31;
        Padding r10 = this.padding;
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
        return "AnchorV4LogisticsAndCouponDisplay(serviceDetail=" + this.serviceDetail + ", guaranteeHeader=" + this.guaranteeHeader + ", background=" + this.background + ", space=" + this.space + ", padding=" + this.padding + ")";
    }

    public final Background getBackground() {
        return this.background;
    }

    public final LongContentLabelComponent getGuaranteeHeader() {
        return this.guaranteeHeader;
    }

    public final Padding getPadding() {
        return this.padding;
    }

    public final List<ServiceComponent> getServiceDetail() {
        return this.serviceDetail;
    }

    public final int getSpace() {
        return this.space;
    }

    public AnchorV4LogisticsAndCouponDisplay(List<ServiceComponent> r1, LongContentLabelComponent r2, Background r3, int r4, Padding r5) {
        this.serviceDetail = r1;
        this.guaranteeHeader = r2;
        this.background = r3;
        this.space = r4;
        this.padding = r5;
    }

    public /* synthetic */ AnchorV4LogisticsAndCouponDisplay(List r5, LongContentLabelComponent r6, Background r7, int r8, Padding r9, int r10, DefaultConstructorMarker r11) {
        if ((r10 & 1) == 0) goto L5;
        List r12 = null;
    L7:
        if ((r10 & 2) == 0) goto L9;
        LongContentLabelComponent r1 = null;
    L11:
        if ((r10 & 4) == 0) goto L13;
        Background r2 = null;
    L15:
        if ((r10 & 8) == 0) goto L17;
        int r3 = 0;
    L19:
        if ((r10 & 16) == 0) goto L21;
        Padding r13 = null;
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
