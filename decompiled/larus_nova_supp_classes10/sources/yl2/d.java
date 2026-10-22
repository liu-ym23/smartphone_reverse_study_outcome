package yl2;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lyl2/d;", "", "", "anchorProductId", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "Lyl2/h;", "showGoodsDetailMp", "Lyl2/h;", "c", "()Lyl2/h;", "Lyl2/g;", "showGoodsDetail", "Lyl2/g;", "b", "()Lyl2/g;", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class d {

    @SerializedName("anchor_product_id")
    private final String anchorProductId;

    @SerializedName("show_goods_detail")
    private final g showGoodsDetail;

    @SerializedName("show_goods_detail_mp")
    private final h showGoodsDetailMp;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof d) == false) goto L12;
        d r4 = (d) r3;
        if (Intrinsics.areEqual(this.anchorProductId, r4.anchorProductId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.showGoodsDetailMp, r4.showGoodsDetailMp) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.showGoodsDetail, r4.showGoodsDetail) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        String r0 = this.anchorProductId;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        h r4 = this.showGoodsDetailMp;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        g r7 = this.showGoodsDetail;
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

    public final String toString() {
        return "OpenShelfParams(anchorProductId=" + this.anchorProductId + ", showGoodsDetailMp=" + this.showGoodsDetailMp + ", showGoodsDetail=" + this.showGoodsDetail + ")";
    }

    public d() {
        this.anchorProductId = "";
        this.showGoodsDetailMp = null;
        this.showGoodsDetail = null;
    }

    public final String a() {
        return this.anchorProductId;
    }

    public final g b() {
        return this.showGoodsDetail;
    }

    public final h c() {
        return this.showGoodsDetailMp;
    }
}
