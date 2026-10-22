package nv6;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lnv6/i0;", "", "", "from", "Ljava/lang/String;", "getFrom", "()Ljava/lang/String;", "action", "getAction", "anchorProductId", "getAnchorProductId", "Lnv6/o;", "groupPurchaseCardParams", "Lnv6/o;", "getGroupPurchaseCardParams", "()Lnv6/o;", "Lnv6/o0;", "openShelfParams", "Lnv6/o0;", "getOpenShelfParams", "()Lnv6/o0;", "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3})
public final class i0 {

    @SerializedName("action")
    private final String action;

    @SerializedName("anchor_product_id")
    private final String anchorProductId;

    @SerializedName("from")
    private final String from;

    @SerializedName("group_purchase_card_params")
    private final o groupPurchaseCardParams;

    @SerializedName("open_shelf_params")
    private final o0 openShelfParams;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i0) == true) goto L8;
        return false;
    L8:
        i0 r101 = (i0) r100;
        if (Intrinsics.areEqual(this.from, r101.from) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.action, r101.action) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.anchorProductId, r101.anchorProductId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.groupPurchaseCardParams, r101.groupPurchaseCardParams) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.openShelfParams, r101.openShelfParams) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        String r100 = this.from;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.action;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.anchorProductId;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        o r110 = this.groupPurchaseCardParams;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        o0 r113 = this.openShelfParams;
        if (r113 == null) goto L23;
        r101 = r113.hashCode();
    L23:
        return r112 + r101;
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "PreviewParams(from=" + this.from + ", action=" + this.action + ", anchorProductId=" + this.anchorProductId + ", groupPurchaseCardParams=" + this.groupPurchaseCardParams + ", openShelfParams=" + this.openShelfParams + ')';
    }

    public i0() {
        this.from = "";
        this.action = "";
        this.anchorProductId = "";
        this.groupPurchaseCardParams = null;
        this.openShelfParams = null;
    }
}
