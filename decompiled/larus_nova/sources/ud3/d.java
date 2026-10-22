package ud3;

import com.google.gson.annotations.SerializedName;
import com.ss.ttvideoengine.model.VideoThumbInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006¨\u0006\u0014"}, d2 = {"Lud3/d;", "", "", "productId", "Ljava/lang/String;", "getProductId", "()Ljava/lang/String;", "shopId", "getShopId", "skuId", "getSkuId", "imgUrl", "getImgUrl", "", "price", "Ljava/lang/Long;", "getPrice", "()Ljava/lang/Long;", "authorId", "getAuthorId", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class d {

    @SerializedName("author_id")
    private final String authorId;

    @SerializedName(VideoThumbInfo.KEY_IMG_URL)
    private final String imgUrl;

    @SerializedName("price")
    private final Long price;

    @SerializedName("product_id")
    private final String productId;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_SHOP_ID)
    private final String shopId;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_SKU_ID)
    private final String skuId;

    public d() {
        this(null, null, null, null, null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == false) goto L18;
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.productId, r101.productId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.shopId, r101.shopId) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.skuId, r101.skuId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.imgUrl, r101.imgUrl) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.price, r101.price) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.authorId, r101.authorId) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public final int hashCode() {
        String r100 = this.productId;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.shopId;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.skuId;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.imgUrl;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        Long r113 = this.price;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.authorId;
        if (r116 == null) goto L26;
        r101 = r116.hashCode();
    L26:
        return r115 + r101;
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
        return "BaseProduct(productId=" + this.productId + ", shopId=" + this.shopId + ", skuId=" + this.skuId + ", imgUrl=" + this.imgUrl + ", price=" + this.price + ", authorId=" + this.authorId + ")";
    }

    public d(String r100, String r101, String r102, String r103, Long r104, String r105) {
        this.productId = r100;
        this.shopId = r101;
        this.skuId = r102;
        this.imgUrl = r103;
        this.price = r104;
        this.authorId = r105;
    }
}
