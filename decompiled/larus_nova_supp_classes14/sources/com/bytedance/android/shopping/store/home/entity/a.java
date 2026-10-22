package com.bytedance.android.shopping.store.home.entity;

import com.bytedance.android.ec.model.ECUrlModel;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\t\u001a\u0004\b\u0011\u0010\u000bR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/shopping/store/home/entity/a;", "", "Lcom/bytedance/android/ec/model/ECUrlModel;", "flagShipIcon", "Lcom/bytedance/android/ec/model/ECUrlModel;", "getFlagShipIcon", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "", "flagShipDesc", "Ljava/lang/String;", "getFlagShipDesc", "()Ljava/lang/String;", "flagShipColor", "getFlagShipColor", "flagShipBackground", "getFlagShipBackground", "flagShipDescColor", "getFlagShipDescColor", "", "flagShipVersion", "Ljava/lang/Integer;", "getFlagShipVersion", "()Ljava/lang/Integer;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a {

    @SerializedName("flagship_band_icon")
    private final ECUrlModel flagShipBackground;

    @SerializedName("flagship_color")
    private final String flagShipColor;

    @SerializedName("flagship_desc")
    private final String flagShipDesc;

    @SerializedName("flagship_desc_color")
    private final String flagShipDescColor;

    @SerializedName("flagship_icon")
    private final ECUrlModel flagShipIcon;

    @SerializedName("flagship_version")
    private final Integer flagShipVersion;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof a) == false) goto L18;
        a r4 = (a) r3;
        if (Intrinsics.areEqual(this.flagShipIcon, r4.flagShipIcon) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.flagShipDesc, r4.flagShipDesc) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.flagShipColor, r4.flagShipColor) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.flagShipBackground, r4.flagShipBackground) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.flagShipDescColor, r4.flagShipDescColor) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.flagShipVersion, r4.flagShipVersion) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public final int hashCode() {
        ECUrlModel r0 = this.flagShipIcon;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.flagShipDesc;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.flagShipColor;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        ECUrlModel r10 = this.flagShipBackground;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.flagShipDescColor;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        Integer r16 = this.flagShipVersion;
        if (r16 == null) goto L26;
        r1 = r16.hashCode();
    L26:
        return r15 + r1;
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

    public final String toString() {
        return "AwemeFlagshipShopStyle(flagShipIcon=" + this.flagShipIcon + ", flagShipDesc=" + this.flagShipDesc + ", flagShipColor=" + this.flagShipColor + ", flagShipBackground=" + this.flagShipBackground + ", flagShipDescColor=" + this.flagShipDescColor + ", flagShipVersion=" + this.flagShipVersion + ")";
    }

    public a() {
        this.flagShipIcon = null;
        this.flagShipDesc = null;
        this.flagShipColor = null;
        this.flagShipBackground = null;
        this.flagShipDescColor = null;
        this.flagShipVersion = null;
    }
}
