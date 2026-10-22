package nv6;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lnv6/n;", "", "Lnv6/p;", "cardRawData", "Lnv6/p;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lnv6/p;", "Lnv6/s;", "controlData", "Lnv6/s;", "b", "()Lnv6/s;", "Lnv6/s0;", "stickerData", "Lnv6/s0;", "c", "()Lnv6/s0;", "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3})
public final class n {

    @SerializedName("CardRawData")
    private final p cardRawData;

    @SerializedName("ControlData")
    private final s controlData;

    @SerializedName("StickerData")
    private final s0 stickerData;

    public n() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof n) == true) goto L8;
        return false;
    L8:
        n r101 = (n) r100;
        if (Intrinsics.areEqual(this.cardRawData, r101.cardRawData) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.controlData, r101.controlData) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.stickerData, r101.stickerData) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        p r100 = this.cardRawData;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        s r104 = this.controlData;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        s0 r107 = this.stickerData;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "GroupPurchaseCardInfo(cardRawData=" + this.cardRawData + ", controlData=" + this.controlData + ", stickerData=" + this.stickerData + ')';
    }

    public final p a() {
        return this.cardRawData;
    }

    public final s b() {
        return this.controlData;
    }

    public final s0 c() {
        return this.stickerData;
    }

    public n(int r100) {
        this.cardRawData = null;
        this.controlData = null;
        this.stickerData = null;
    }
}
