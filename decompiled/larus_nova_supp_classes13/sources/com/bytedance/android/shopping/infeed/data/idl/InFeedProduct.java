package com.bytedance.android.shopping.infeed.data.idl;

import com.bytedance.android.shopping.inflow.product.model.FeedCardExtra;
import com.bytedance.android.shopping.inflow.product.model.FeedCardUser;
import com.bytedance.android.shopping.model.FeedCardProduct;
import com.google.gson.annotations.SerializedName;
import he3.z0;
import java.io.Serializable;
import kotlin.Metadata;
import qe3.e;
import tf3.f;
import tf3.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 62\u00020\u0001:\u00017B\u0007¢\u0006\u0004\b4\u00105R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR$\u0010 \u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R$\u0010'\u001a\u0004\u0018\u00010&8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R$\u0010.\u001a\u0004\u0018\u00010-8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103¨\u00068"}, d2 = {"Lcom/bytedance/android/shopping/infeed/data/idl/InFeedProduct;", "Ljava/io/Serializable;", "", "type", "Ljava/lang/Integer;", "getType", "()Ljava/lang/Integer;", "setType", "(Ljava/lang/Integer;)V", "Lcom/bytedance/android/shopping/model/FeedCardProduct;", "promotion", "Lcom/bytedance/android/shopping/model/FeedCardProduct;", "getPromotion", "()Lcom/bytedance/android/shopping/model/FeedCardProduct;", "setPromotion", "(Lcom/bytedance/android/shopping/model/FeedCardProduct;)V", "Ltf3/h;", "store", "Ltf3/h;", "getStore", "()Ltf3/h;", "Ltf3/f;", "coupon", "Ltf3/f;", "getCoupon", "()Ltf3/f;", "Lcom/bytedance/android/shopping/inflow/product/model/FeedCardUser;", "user", "Lcom/bytedance/android/shopping/inflow/product/model/FeedCardUser;", "getUser", "()Lcom/bytedance/android/shopping/inflow/product/model/FeedCardUser;", "Lcom/bytedance/android/shopping/inflow/product/model/FeedCardExtra;", "extra", "Lcom/bytedance/android/shopping/inflow/product/model/FeedCardExtra;", "getExtra", "()Lcom/bytedance/android/shopping/inflow/product/model/FeedCardExtra;", "setExtra", "(Lcom/bytedance/android/shopping/inflow/product/model/FeedCardExtra;)V", "Lqe3/e;", "product", "Lqe3/e;", "getProduct", "()Lqe3/e;", "setProduct", "(Lqe3/e;)V", "Lhe3/z0;", "respExtra", "Lhe3/z0;", "getRespExtra", "()Lhe3/z0;", "setRespExtra", "(Lhe3/z0;)V", "<init>", "()V", "Companion", "a", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class InFeedProduct implements Serializable {
    public static final a Companion = null;
    public static final int TYPE_LIVE = 1;
    public static final int TYPE_PRODUCT = 2;
    public static final int TYPE_VIDEO = 4;

    @SerializedName("coupon")
    private final f coupon;

    @SerializedName("extra")
    private FeedCardExtra extra;

    @SerializedName("product")
    private e product;

    @SerializedName("promotion")
    private FeedCardProduct promotion;
    private z0 respExtra;

    @SerializedName("shop")
    private final h store;

    @SerializedName("type")
    private Integer type;

    @SerializedName("user")
    private final FeedCardUser user;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public InFeedProduct() {
    }

    public final f getCoupon() {
        return this.coupon;
    }

    public final FeedCardExtra getExtra() {
        return this.extra;
    }

    public final e getProduct() {
        return this.product;
    }

    public final FeedCardProduct getPromotion() {
        return this.promotion;
    }

    public final z0 getRespExtra() {
        return this.respExtra;
    }

    public final h getStore() {
        return this.store;
    }

    public final Integer getType() {
        return this.type;
    }

    public final FeedCardUser getUser() {
        return this.user;
    }

    public final void setExtra(FeedCardExtra r1) {
        this.extra = r1;
    }

    public final void setProduct(e r1) {
        this.product = r1;
    }

    public final void setPromotion(FeedCardProduct r1) {
        this.promotion = r1;
    }

    public final void setRespExtra(z0 r1) {
        this.respExtra = r1;
    }

    public final void setType(Integer r1) {
        this.type = r1;
    }
}
