package com.bytedance.android.shopping.dto;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u0006\"\u0004\b\n\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/shopping/dto/VirtualPromotionBean;", "Ljava/io/Serializable;", "()V", "alreadyBuy", "", "getAlreadyBuy", "()Z", "setAlreadyBuy", "(Z)V", "isVirtualGoods", "setVirtualGoods", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VirtualPromotionBean implements Serializable {

    @SerializedName("already_buy")
    private boolean alreadyBuy;

    @SerializedName("is")
    private boolean isVirtualGoods;

    public VirtualPromotionBean() {
    }

    public final boolean getAlreadyBuy() {
        return this.alreadyBuy;
    }

    public final boolean isVirtualGoods() {
        return this.isVirtualGoods;
    }

    public final void setAlreadyBuy(boolean r1) {
        this.alreadyBuy = r1;
    }

    public final void setVirtualGoods(boolean r1) {
        this.isVirtualGoods = r1;
    }
}
