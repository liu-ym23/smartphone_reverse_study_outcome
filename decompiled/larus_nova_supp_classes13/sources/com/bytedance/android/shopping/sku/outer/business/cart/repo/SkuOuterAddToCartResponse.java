package com.bytedance.android.shopping.sku.outer.business.cart.repo;

import com.bytedance.android.ec.model.api.CommerceBaseResponse;
import com.bytedance.android.ec.model.sku.CartNumWithBusinessLine;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001e\u0010\u0007\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\u0006\"\u0004\b\t\u0010\nR&\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0012\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\nR$\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001c8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"Lcom/bytedance/android/shopping/sku/outer/business/cart/repo/SkuOuterAddToCartResponse;", "Lcom/bytedance/android/ec/model/api/CommerceBaseResponse;", "()V", "addCartNextSchema", "", "getAddCartNextSchema", "()Ljava/lang/String;", "cartId", "getCartId", "setCartId", "(Ljava/lang/String;)V", "cartNumWithBusinessLine", "", "Lcom/bytedance/android/ec/model/sku/CartNumWithBusinessLine;", "getCartNumWithBusinessLine", "()Ljava/util/List;", "setCartNumWithBusinessLine", "(Ljava/util/List;)V", "count", "", "getCount", "()I", "setCount", "(I)V", "logId", "getLogId", "setLogId", "toastBar", "", "", "getToastBar", "()Ljava/util/Map;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SkuOuterAddToCartResponse extends CommerceBaseResponse {

    @SerializedName("after_add_jump_url")
    private final String addCartNextSchema;

    @SerializedName("cart_id")
    private String cartId;

    @SerializedName("cart_num_with_business_line")
    private List<CartNumWithBusinessLine> cartNumWithBusinessLine;

    @SerializedName("count")
    private int count;
    private String logId;

    @SerializedName("toast_bar")
    private final Map<String, Object> toastBar;

    public SkuOuterAddToCartResponse() {
        this.cartId = "";
    }

    public final String getAddCartNextSchema() {
        return this.addCartNextSchema;
    }

    public final String getCartId() {
        return this.cartId;
    }

    public final List<CartNumWithBusinessLine> getCartNumWithBusinessLine() {
        return this.cartNumWithBusinessLine;
    }

    public final int getCount() {
        return this.count;
    }

    public final String getLogId() {
        return this.logId;
    }

    public final Map<String, Object> getToastBar() {
        return this.toastBar;
    }

    public final void setCartId(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.cartId = r2;
    }

    public final void setCartNumWithBusinessLine(List<CartNumWithBusinessLine> r1) {
        this.cartNumWithBusinessLine = r1;
    }

    public final void setCount(int r1) {
        this.count = r1;
    }

    public final void setLogId(String r1) {
        this.logId = r1;
    }
}
