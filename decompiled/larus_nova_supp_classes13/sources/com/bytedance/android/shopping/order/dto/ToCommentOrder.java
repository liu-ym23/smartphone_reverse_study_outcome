package com.bytedance.android.shopping.order.dto;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\r"}, d2 = {"Lcom/bytedance/android/shopping/order/dto/ToCommentOrder;", "Ljava/io/Serializable;", "product", "Lcom/bytedance/android/shopping/order/dto/Product;", "orderId", "", "sku", "(Lcom/bytedance/android/shopping/order/dto/Product;Ljava/lang/String;Ljava/lang/String;)V", "getOrderId", "()Ljava/lang/String;", "getProduct", "()Lcom/bytedance/android/shopping/order/dto/Product;", "getSku", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ToCommentOrder implements Serializable {

    @SerializedName("order_id")
    private final String orderId;

    @SerializedName("product")
    private final Product product;

    @SerializedName("sku")
    private final String sku;

    public ToCommentOrder() {
        this(null, null, null, 7, null);
    }

    public final String getOrderId() {
        return this.orderId;
    }

    public final Product getProduct() {
        return this.product;
    }

    public final String getSku() {
        return this.sku;
    }

    public ToCommentOrder(Product r1, String r2, String r3) {
        this.product = r1;
        this.orderId = r2;
        this.sku = r3;
    }

    public /* synthetic */ ToCommentOrder(Product r2, String r3, String r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = "";
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = "";
    L11:
        this(r2, r3, r4);
    }
}
