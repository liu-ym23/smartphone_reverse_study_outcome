package com.bytedance.android.livesdk.livecommerce.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@ProtoMessage("live.UpdatedSkuInfo")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R$\u0010\u0007\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/model/ECV2UpdatedSkuInfo;", "", "()V", "couponPrice", "", "maxPrice", "minPrice", "skus", "", "", "Lcom/bytedance/android/livesdk/livecommerce/model/ECV2SkuInfo;", "unUseMinPrice", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECV2UpdatedSkuInfo {

    @SerializedName("coupon_price")
    public long couponPrice;

    @SerializedName("max_price")
    public long maxPrice;

    @SerializedName("min_price")
    public long minPrice;

    @SerializedName("skus")
    public Map<String, ECV2SkuInfo> skus;

    @SerializedName("unuse_min_price")
    public long unUseMinPrice;

    public ECV2UpdatedSkuInfo() {
    }
}
