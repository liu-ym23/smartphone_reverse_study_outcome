package yd3;

import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.response.anchorv3.SalesInfoStruct;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0004\u001a\u0004\b\u0018\u0010\u0006R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u0004\u001a\u0004\b\u001a\u0010\u0006¨\u0006\u001b"}, d2 = {"Lyd3/e;", "", "", "productId", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "productName", "getProductName", "Lcom/bytedance/android/ec/model/ECUrlModel;", "urlStruct", "Lcom/bytedance/android/ec/model/ECUrlModel;", "d", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "Lyd3/n;", "priceInfo", "Lyd3/n;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lyd3/n;", SalesInfoStruct.SALES, "getSales", "shopId", "getShopId", "shopName", "getShopName", "schema", "c", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class e {

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_PRICE_INFO)
    private final n priceInfo;

    @SerializedName("product_id")
    private final String productId;

    @SerializedName("product_name")
    private final String productName;

    @SerializedName(SalesInfoStruct.SALES)
    private final String sales;

    @SerializedName("schema")
    private final String schema;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_SHOP_ID)
    private final String shopId;

    @SerializedName("shop_name")
    private final String shopName;

    @SerializedName("img")
    private final ECUrlModel urlStruct;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof e) == false) goto L22;
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.productId, r101.productId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.productName, r101.productName) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.urlStruct, r101.urlStruct) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.priceInfo, r101.priceInfo) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.sales, r101.sales) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.shopId, r101.shopId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.shopName, r101.shopName) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.schema, r101.schema) == true) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    public final int hashCode() {
        String r100 = this.productId;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.productName;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        ECUrlModel r107 = this.urlStruct;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        n r110 = this.priceInfo;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.sales;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.shopId;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.shopName;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.schema;
        if (r122 == null) goto L34;
        r101 = r122.hashCode();
    L34:
        return r121 + r101;
    L29:
        r120 = 0;
        goto L30
    L25:
        r117 = 0;
        goto L26
    L21:
        r114 = 0;
        goto L22
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
        return "GoodPriceProd(productId=" + this.productId + ", productName=" + this.productName + ", urlStruct=" + this.urlStruct + ", priceInfo=" + this.priceInfo + ", sales=" + this.sales + ", shopId=" + this.shopId + ", shopName=" + this.shopName + ", schema=" + this.schema + ")";
    }

    public e() {
        this.productId = null;
        this.productName = null;
        this.urlStruct = null;
        this.priceInfo = null;
        this.sales = null;
        this.shopId = null;
        this.shopName = null;
        this.schema = null;
    }

    public final n a() {
        return this.priceInfo;
    }

    public final String b() {
        return this.productId;
    }

    public final String c() {
        return this.schema;
    }

    public final ECUrlModel d() {
        return this.urlStruct;
    }
}
