package com.bytedance.android.shopping.store.home.entity;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\"\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0018\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\"\u0010\u000e\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u000f\u0010\u0006\"\u0004\b\u0010\u0010\bR\"\u0010\u0011\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0012\u0010\u0006\"\u0004\b\u0013\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/shopping/store/home/entity/CartCtrlInfo;", "Ljava/io/Serializable;", "()V", "latencySeconds", "", "getLatencySeconds", "()Ljava/lang/Integer;", "setLatencySeconds", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "nativeStorage", "", "getNativeStorage", "()Ljava/lang/String;", "remainMilliseconds", "getRemainMilliseconds", "setRemainMilliseconds", "shopCartStatus", "getShopCartStatus", "setShopCartStatus", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CartCtrlInfo implements Serializable {

    @SerializedName("slide_latency_milliseconds")
    private Integer latencySeconds;

    @SerializedName("native_storage")
    private final String nativeStorage;

    @SerializedName("slide_remain_milliseconds")
    private Integer remainMilliseconds;

    @SerializedName("status")
    private Integer shopCartStatus;

    public CartCtrlInfo() {
        this.shopCartStatus = 0;
        this.remainMilliseconds = 0;
        this.latencySeconds = 0;
    }

    public final Integer getLatencySeconds() {
        return this.latencySeconds;
    }

    public final String getNativeStorage() {
        return this.nativeStorage;
    }

    public final Integer getRemainMilliseconds() {
        return this.remainMilliseconds;
    }

    public final Integer getShopCartStatus() {
        return this.shopCartStatus;
    }

    public final void setLatencySeconds(Integer r1) {
        this.latencySeconds = r1;
    }

    public final void setRemainMilliseconds(Integer r1) {
        this.remainMilliseconds = r1;
    }

    public final void setShopCartStatus(Integer r1) {
        this.shopCartStatus = r1;
    }
}
