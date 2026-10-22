package e73;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR$\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\b¨\u0006\u0016"}, d2 = {"Le73/c;", "", "", "productId", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "setProductId", "(Ljava/lang/String;)V", "", "comboNum", "I", "b", "()I", "setComboNum", "(I)V", "cartId", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setCartId", "extra", "getExtra", "setExtra", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class c {

    @SerializedName("cart_id")
    private String cartId;

    @SerializedName("combo_num")
    private int comboNum;

    @SerializedName("extra")
    private String extra;

    @SerializedName("product_id")
    private String productId;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L14;
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.productId, r101.productId) == true) goto L8;
        return false;
    L8:
        if (this.comboNum == r101.comboNum) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.cartId, r101.cartId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.extra, r101.extra) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        String r100 = this.productId;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = ((r102 * 31) + this.comboNum) * 31;
        String r104 = this.cartId;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.extra;
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
        return "CartItem(productId=" + this.productId + ", comboNum=" + this.comboNum + ", cartId=" + this.cartId + ", extra=" + this.extra + ")";
    }

    public c() {
        this.productId = null;
        this.comboNum = 0;
        this.cartId = null;
        this.extra = null;
    }

    public final String a() {
        return this.cartId;
    }

    public final int b() {
        return this.comboNum;
    }

    public final String c() {
        return this.productId;
    }
}
