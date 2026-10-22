package com.bytedance.locallife.pdp.settings;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/locallife/pdp/settings/l;", "", "", "enable", "Z", "getEnable", "()Z", "", "pageStructExpiredDelayTime", "J", "getPageStructExpiredDelayTime", "()J", "locallife-pdp-impl_release"}, k = 1, mv = {1, 4, 3})
public final class l {

    @SerializedName("enable")
    private final boolean enable;

    @SerializedName("page_struct_expired_delay_time")
    private final long pageStructExpiredDelayTime;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof l) == true) goto L8;
        return false;
    L8:
        l r101 = (l) r100;
        if (this.enable == r101.enable) goto L12;
        return false;
    L12:
        if (this.pageStructExpiredDelayTime == r101.pageStructExpiredDelayTime) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        if (this.enable == false) goto L5;
        int r100 = 1231;
    L6:
        long r101 = this.pageStructExpiredDelayTime;
        return (r100 * 31) + ((int) (r101 ^ (r101 >>> 32)));
    L5:
        r100 = 1237;
        goto L6
    }

    public final String toString() {
        return "DeliveryGoodsDetailPrefetchCacheExpirationConfig(enable=" + this.enable + ", pageStructExpiredDelayTime=" + this.pageStructExpiredDelayTime + ')';
    }

    public l() {
        this.enable = false;
        this.pageStructExpiredDelayTime = 259200000;
    }
}
