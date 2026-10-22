package com.bytedance.android.shopping.inflow.product.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u0000 \t2\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/shopping/inflow/product/model/FeedCardCartInfo;", "Ljava/io/Serializable;", "", "cartUrl", "Ljava/lang/String;", "getCartUrl", "()Ljava/lang/String;", "<init>", "()V", "Companion", "a", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FeedCardCartInfo implements Serializable {
    public static final a Companion = null;
    private static final long serialVersionUID = -23713;

    @SerializedName("cart_url")
    private final String cartUrl;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public FeedCardCartInfo() {
    }

    public final String getCartUrl() {
        return this.cartUrl;
    }
}
