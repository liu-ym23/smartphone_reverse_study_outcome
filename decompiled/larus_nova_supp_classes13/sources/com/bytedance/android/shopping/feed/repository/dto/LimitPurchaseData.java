package com.bytedance.android.shopping.feed.repository.dto;

import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0017\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u001a\u0010\f\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\f\u0010\nR\u0018\u0010\r\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0006R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0006R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0006R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0006R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0006R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0006R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0006¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/shopping/feed/repository/dto/LimitPurchaseData;", "Ljava/io/Serializable;", "()V", "cumulativeMax", "", "getCumulativeMax", "()Ljava/lang/String;", "hasUnpaidOrder", "", "getHasUnpaidOrder", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "isLimit", "limitMsg", "getLimitMsg", "maxNum", "getMaxNum", "minNum", "getMinNum", "orderId", "getOrderId", "productId", "getProductId", "skuId", "getSkuId", "surplusNum", "getSurplusNum", "unpaidOrderUrl", "getUnpaidOrderUrl", "usedNum", "getUsedNum", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LimitPurchaseData implements Serializable {

    @SerializedName("cumulative_max")
    private final String cumulativeMax;

    @SerializedName("has_unpay_order")
    private final Boolean hasUnpaidOrder;

    @SerializedName("is_limit")
    private final Boolean isLimit;

    @SerializedName("limit_msg")
    private final String limitMsg;

    @SerializedName("max_num")
    private final String maxNum;

    @SerializedName("min_num")
    private final String minNum;

    @SerializedName("order_id")
    private final String orderId;

    @SerializedName(PdpOpenThirdParam.KEY_PRODUCT_ID)
    private final String productId;

    @SerializedName("sku_id")
    private final String skuId;

    @SerializedName("surplus_num")
    private final String surplusNum;

    @SerializedName("url")
    private final String unpaidOrderUrl;

    @SerializedName("used_num")
    private final String usedNum;

    public LimitPurchaseData() {
    }

    public final String getCumulativeMax() {
        return this.cumulativeMax;
    }

    public final Boolean getHasUnpaidOrder() {
        return this.hasUnpaidOrder;
    }

    public final String getLimitMsg() {
        return this.limitMsg;
    }

    public final String getMaxNum() {
        return this.maxNum;
    }

    public final String getMinNum() {
        return this.minNum;
    }

    public final String getOrderId() {
        return this.orderId;
    }

    public final String getProductId() {
        return this.productId;
    }

    public final String getSkuId() {
        return this.skuId;
    }

    public final String getSurplusNum() {
        return this.surplusNum;
    }

    public final String getUnpaidOrderUrl() {
        return this.unpaidOrderUrl;
    }

    public final String getUsedNum() {
        return this.usedNum;
    }

    public final Boolean isLimit() {
        return this.isLimit;
    }
}
