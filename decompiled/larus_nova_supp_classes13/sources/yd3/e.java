package yd3;

import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0004\u001a\u0004\b\u0018\u0010\u0006R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u0004\u001a\u0004\b\u001a\u0010\u0006¨\u0006\u001b"}, d2 = {"Lyd3/e;", "", "", "productId", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "productName", "getProductName", "Lcom/bytedance/android/ec/model/ECUrlModel;", "urlStruct", "Lcom/bytedance/android/ec/model/ECUrlModel;", "d", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "Lyd3/n;", "priceInfo", "Lyd3/n;", "a", "()Lyd3/n;", "sales", "getSales", "shopId", "getShopId", "shopName", "getShopName", "schema", "c", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class e {

    @SerializedName("price_info")
    private final n priceInfo;

    @SerializedName(PdpOpenThirdParam.KEY_PRODUCT_ID)
    private final String productId;

    @SerializedName("product_name")
    private final String productName;

    @SerializedName("sales")
    private final String sales;

    @SerializedName("schema")
    private final String schema;

    @SerializedName("shop_id")
    private final String shopId;

    @SerializedName("shop_name")
    private final String shopName;

    @SerializedName("img")
    private final ECUrlModel urlStruct;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof e) == false) goto L22;
        e r4 = (e) r3;
        if (Intrinsics.areEqual(this.productId, r4.productId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.productName, r4.productName) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.urlStruct, r4.urlStruct) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.priceInfo, r4.priceInfo) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.sales, r4.sales) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.shopId, r4.shopId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.shopName, r4.shopName) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.schema, r4.schema) == true) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    public final int hashCode() {
        String r0 = this.productId;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.productName;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        ECUrlModel r7 = this.urlStruct;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        n r10 = this.priceInfo;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.sales;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.shopId;
        if (r16 == null) goto L25;
        int r17 = r16.hashCode();
    L26:
        int r18 = (r15 + r17) * 31;
        String r19 = this.shopName;
        if (r19 == null) goto L29;
        int r20 = r19.hashCode();
    L30:
        int r21 = (r18 + r20) * 31;
        String r22 = this.schema;
        if (r22 == null) goto L34;
        r1 = r22.hashCode();
    L34:
        return r21 + r1;
    L29:
        r20 = 0;
        goto L30
    L25:
        r17 = 0;
        goto L26
    L21:
        r14 = 0;
        goto L22
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
