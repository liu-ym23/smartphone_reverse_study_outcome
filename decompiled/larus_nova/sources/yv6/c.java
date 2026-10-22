package yv6;

import com.bytedance.ai.api.navi.AppletNaviType;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001R$\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R$\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0005\u001a\u0004\b\t\u0010\u0007R$\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007R$\u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0005\u001a\u0004\b\r\u0010\u0007R$\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0005\u001a\u0004\b\u000f\u0010\u0007¨\u0006\u0010"}, d2 = {"Lyv6/c;", "", "", "Lyv6/d;", "mall", "Ljava/util/List;", "c", "()Ljava/util/List;", AppletNaviType.POI, "d", "goodsDetail", "b", "confirmOrderPage", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "tradeOrderDetail", "e", "locallife-saas-model_release"}, k = 1, mv = {1, 4, 3})
public final class c {

    @SerializedName("confirmOrderPage")
    private final List<d> confirmOrderPage;

    @SerializedName("goodsDetail")
    private final List<d> goodsDetail;

    @SerializedName("mall")
    private final List<d> mall;

    @SerializedName(AppletNaviType.POI)
    private final List<d> poi;

    @SerializedName("tradeOrderDetail")
    private final List<d> tradeOrderDetail;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.mall, r101.mall) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.poi, r101.poi) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.goodsDetail, r101.goodsDetail) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.confirmOrderPage, r101.confirmOrderPage) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.tradeOrderDetail, r101.tradeOrderDetail) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        List<d> r100 = this.mall;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        List<d> r104 = this.poi;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        List<d> r107 = this.goodsDetail;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        List<d> r110 = this.confirmOrderPage;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        List<d> r113 = this.tradeOrderDetail;
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
        return "OptStrategy(mall=" + this.mall + ", poi=" + this.poi + ", goodsDetail=" + this.goodsDetail + ", confirmOrderPage=" + this.confirmOrderPage + ", tradeOrderDetail=" + this.tradeOrderDetail + ')';
    }

    public c() {
        this.mall = null;
        this.poi = null;
        this.goodsDetail = null;
        this.confirmOrderPage = null;
        this.tradeOrderDetail = null;
    }

    public final List<d> a() {
        return this.confirmOrderPage;
    }

    public final List<d> b() {
        return this.goodsDetail;
    }

    public final List<d> c() {
        return this.mall;
    }

    public final List<d> d() {
        return this.poi;
    }

    public final List<d> e() {
        return this.tradeOrderDetail;
    }
}
