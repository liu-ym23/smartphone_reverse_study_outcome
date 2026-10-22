package nv6;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lnv6/g0;", "", "", "anchorProductId", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "couponIds", "b", "Lnv6/q0;", "showGoodsDetailMp", "Lnv6/q0;", "d", "()Lnv6/q0;", "Lnv6/p0;", "showGoodsDetail", "Lnv6/p0;", "c", "()Lnv6/p0;", "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3})
public final class g0 {

    @SerializedName("anchor_product_id")
    private final String anchorProductId;

    @SerializedName("coupon_ids")
    private final String couponIds;

    @SerializedName("show_goods_detail")
    private final p0 showGoodsDetail;

    @SerializedName("show_goods_detail_mp")
    private final q0 showGoodsDetailMp;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g0) == true) goto L8;
        return false;
    L8:
        g0 r101 = (g0) r100;
        if (Intrinsics.areEqual(this.anchorProductId, r101.anchorProductId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.couponIds, r101.couponIds) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.showGoodsDetailMp, r101.showGoodsDetailMp) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.showGoodsDetail, r101.showGoodsDetail) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        String r100 = this.anchorProductId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.couponIds;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        q0 r107 = this.showGoodsDetailMp;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        p0 r110 = this.showGoodsDetail;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return r109 + r101;
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
        return "OpenShelfParams(anchorProductId=" + this.anchorProductId + ", couponIds=" + this.couponIds + ", showGoodsDetailMp=" + this.showGoodsDetailMp + ", showGoodsDetail=" + this.showGoodsDetail + ')';
    }

    public g0() {
        this.anchorProductId = "";
        this.couponIds = "";
        this.showGoodsDetailMp = null;
        this.showGoodsDetail = null;
    }

    public final String a() {
        return this.anchorProductId;
    }

    public final String b() {
        return this.couponIds;
    }

    public final p0 c() {
        return this.showGoodsDetail;
    }

    public final q0 d() {
        return this.showGoodsDetailMp;
    }
}
