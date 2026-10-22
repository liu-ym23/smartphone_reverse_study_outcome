package yl2;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lyl2/d;", "", "", "anchorProductId", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "Lyl2/h;", "showGoodsDetailMp", "Lyl2/h;", "c", "()Lyl2/h;", "Lyl2/g;", "showGoodsDetail", "Lyl2/g;", "b", "()Lyl2/g;", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class d {

    @SerializedName("anchor_product_id")
    private final String anchorProductId;

    @SerializedName("show_goods_detail")
    private final g showGoodsDetail;

    @SerializedName("show_goods_detail_mp")
    private final h showGoodsDetailMp;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == false) goto L12;
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.anchorProductId, r101.anchorProductId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.showGoodsDetailMp, r101.showGoodsDetailMp) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.showGoodsDetail, r101.showGoodsDetail) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        String r100 = this.anchorProductId;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        h r104 = this.showGoodsDetailMp;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        g r107 = this.showGoodsDetail;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
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
