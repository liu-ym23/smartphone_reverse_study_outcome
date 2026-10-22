package yl2;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lyl2/e;", "", "", "from", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "action", "a", "anchorProductId", "getAnchorProductId", "Lyl2/a;", "groupPurchaseCardParams", "Lyl2/a;", "c", "()Lyl2/a;", "Lyl2/f;", "openShelfParams", "Lyl2/f;", "d", "()Lyl2/f;", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
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

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof e) == false) goto L16;
        e r4 = (e) r3;
        if (Intrinsics.areEqual(this.from, r4.from) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.action, r4.action) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.anchorProductId, r4.anchorProductId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.groupPurchaseCardParams, r4.groupPurchaseCardParams) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.openShelfParams, r4.openShelfParams) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        String r0 = this.from;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.action;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.anchorProductId;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        a r10 = this.groupPurchaseCardParams;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        f r13 = this.openShelfParams;
        if (r13 == null) goto L22;
        r1 = r13.hashCode();
    L22:
        return r12 + r1;
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
