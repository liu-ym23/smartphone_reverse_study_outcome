package com.bytedance.android.shopping.store.home.entity;

import com.google.gson.JsonElement;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/shopping/store/home/entity/CouponRedPackEntryInfo;", "Lcom/bytedance/android/shopping/store/home/entity/ToolEntryInfo;", "()V", "couponInfoList", "Lcom/google/gson/JsonElement;", "getCouponInfoList", "()Lcom/google/gson/JsonElement;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CouponRedPackEntryInfo extends ToolEntryInfo {

    @SerializedName("coupon_info_list")
    private final JsonElement couponInfoList;

    public CouponRedPackEntryInfo() {
    }

    public final JsonElement getCouponInfoList() {
        return this.couponInfoList;
    }
}
