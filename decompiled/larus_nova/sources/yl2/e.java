package yl2;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lyl2/e;", "", "", "from", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "action", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "anchorProductId", "getAnchorProductId", "Lyl2/a;", "groupPurchaseCardParams", "Lyl2/a;", "c", "()Lyl2/a;", "Lyl2/f;", "openShelfParams", "Lyl2/f;", "d", "()Lyl2/f;", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class e {

    @SerializedName("action")
    private final String action;

    @SerializedName("anchor_product_id")
    private final String anchorProductId;

    @SerializedName("from")
    private final String from;

    @SerializedName("group_purchase_card_params")
    private final a groupPurchaseCardParams;

    @SerializedName("open_shelf_params")
    private final f openShelfParams;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof e) == false) goto L16;
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.from, r101.from) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.action, r101.action) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.anchorProductId, r101.anchorProductId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.groupPurchaseCardParams, r101.groupPurchaseCardParams) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.openShelfParams, r101.openShelfParams) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        String r100 = this.from;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.action;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.anchorProductId;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        a r110 = this.groupPurchaseCardParams;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        f r113 = this.openShelfParams;
        if (r113 == null) goto L22;
        r101 = r113.hashCode();
    L22:
        return r112 + r101;
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "PreviewParams(from=" + this.from + ", action=" + this.action + ", anchorProductId=" + this.anchorProductId + ", groupPurchaseCardParams=" + this.groupPurchaseCardParams + ", openShelfParams=" + this.openShelfParams + ")";
    }

    public e() {
        this.from = "";
        this.action = "";
        this.anchorProductId = "";
        this.groupPurchaseCardParams = null;
        this.openShelfParams = null;
    }

    public final String a() {
        return this.action;
    }

    public final String b() {
        return this.from;
    }

    public final a c() {
        return this.groupPurchaseCardParams;
    }

    public final f d() {
        return this.openShelfParams;
    }
}
