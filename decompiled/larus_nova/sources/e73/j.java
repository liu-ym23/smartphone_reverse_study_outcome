package e73;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import fi3.z0;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\"\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006¨\u0006\u0011"}, d2 = {"Le73/j;", "", "", "skuSchema", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "ultimateBuySchema", "c", "", "Lfi3/z0;", "ultimateUpdateParams", "Ljava/util/List;", "d", "()Ljava/util/List;", "orderSchema", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class j {

    @SerializedName("order_schema")
    private final String orderSchema;

    @SerializedName("sku_schema")
    private final String skuSchema;

    @SerializedName("ultimate_buy_schema")
    private final String ultimateBuySchema;

    @SerializedName("ultimate_params_from_sku")
    private final List<z0> ultimateUpdateParams;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof j) == false) goto L14;
        j r101 = (j) r100;
        if (Intrinsics.areEqual(this.skuSchema, r101.skuSchema) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.ultimateBuySchema, r101.ultimateBuySchema) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.ultimateUpdateParams, r101.ultimateUpdateParams) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.orderSchema, r101.orderSchema) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        String r100 = this.skuSchema;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.ultimateBuySchema;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        List<z0> r107 = this.ultimateUpdateParams;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.orderSchema;
        if (r110 == null) goto L18;
        r101 = r110.hashCode();
    L18:
        return r109 + r101;
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
        return "SchemaUnion(skuSchema=" + this.skuSchema + ", ultimateBuySchema=" + this.ultimateBuySchema + ", ultimateUpdateParams=" + this.ultimateUpdateParams + ", orderSchema=" + this.orderSchema + ")";
    }

    public j() {
        this.skuSchema = null;
        this.ultimateBuySchema = null;
        this.ultimateUpdateParams = null;
        this.orderSchema = null;
    }

    public final String a() {
        return this.orderSchema;
    }

    public final String b() {
        return this.skuSchema;
    }

    public final String c() {
        return this.ultimateBuySchema;
    }

    public final List<z0> d() {
        return this.ultimateUpdateParams;
    }
}
