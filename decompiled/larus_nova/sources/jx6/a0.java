package jx6;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\"\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Ljx6/a0;", "", "Ljx6/d;", "buyerSHowVO", "Ljx6/d;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljx6/d;", "Ljx6/x;", "recDishVO", "Ljx6/x;", "c", "()Ljx6/x;", "Ljx6/d0;", "superDiscountVO", "Ljx6/d0;", "d", "()Ljx6/d0;", "", "Ljx6/z;", "marqueeVO", "Ljava/util/List;", "b", "()Ljava/util/List;", "locallife-pdp-impl_release"}, k = 1, mv = {1, 4, 3})
public final class a0 {

    @SerializedName("comment")
    private final d buyerSHowVO;

    @SerializedName("marquee")
    private final List<z> marqueeVO;

    @SerializedName("explain")
    private final x recDishVO;

    @SerializedName("selected_info")
    private final d0 superDiscountVO;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a0) == true) goto L8;
        return false;
    L8:
        a0 r101 = (a0) r100;
        if (Intrinsics.areEqual(this.buyerSHowVO, r101.buyerSHowVO) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.recDishVO, r101.recDishVO) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.superDiscountVO, r101.superDiscountVO) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.marqueeVO, r101.marqueeVO) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        d r100 = this.buyerSHowVO;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        x r104 = this.recDishVO;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        d0 r107 = this.superDiscountVO;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        List<z> r110 = this.marqueeVO;
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
        return "SinglePointData(buyerSHowVO=" + this.buyerSHowVO + ", recDishVO=" + this.recDishVO + ", superDiscountVO=" + this.superDiscountVO + ", marqueeVO=" + this.marqueeVO + ')';
    }

    public a0() {
        this.buyerSHowVO = null;
        this.recDishVO = null;
        this.superDiscountVO = null;
        this.marqueeVO = null;
    }

    public final d a() {
        return this.buyerSHowVO;
    }

    public final List<z> b() {
        return this.marqueeVO;
    }

    public final x c() {
        return this.recDishVO;
    }

    public final d0 d() {
        return this.superDiscountVO;
    }
}
