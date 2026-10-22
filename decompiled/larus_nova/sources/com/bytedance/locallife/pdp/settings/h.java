package com.bytedance.locallife.pdp.settings;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R$\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0010\u001a\u00020\u000f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/bytedance/locallife/pdp/settings/h;", "", "", "enableCache", "Z", "c", "()Z", "enableLivePrefetch", "d", "", "", "allowList", "[Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()[Ljava/lang/String;", "", "dataExpiredDelayTime", "J", "b", "()J", "locallife-pdp-impl_release"}, k = 1, mv = {1, 4, 3})
public final class h {

    @SerializedName("allow_cache_node_tag_list")
    private final String[] allowList;

    @SerializedName("data_expired_delay_time")
    private final long dataExpiredDelayTime;

    @SerializedName("enable_cache")
    private final boolean enableCache;

    @SerializedName("enable_live_prefetch")
    private final boolean enableLivePrefetch;

    public h() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h) == true) goto L8;
        return false;
    L8:
        h r101 = (h) r100;
        if (this.enableCache == r101.enableCache) goto L12;
        return false;
    L12:
        if (this.enableLivePrefetch == r101.enableLivePrefetch) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.allowList, r101.allowList) == true) goto L18;
        return false;
    L18:
        if (this.dataExpiredDelayTime == r101.dataExpiredDelayTime) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.enableCache == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.enableLivePrefetch == true) goto L10;
        r100 = 1237;
    L10:
        int r103 = (r102 + r100) * 31;
        String[] r104 = this.allowList;
        if (r104 != null) goto L13;
        int r105 = 0;
    L14:
        int r106 = (r103 + r105) * 31;
        long r107 = this.dataExpiredDelayTime;
        return r106 + ((int) (r107 ^ (r107 >>> 32)));
    L13:
        r105 = Arrays.hashCode(r104);
        goto L14
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "DeliveryGoodsDetailCacheConfig(enableCache=" + this.enableCache + ", enableLivePrefetch=" + this.enableLivePrefetch + ", allowList=" + Arrays.toString(this.allowList) + ", dataExpiredDelayTime=" + this.dataExpiredDelayTime + ')';
    }

    public final String[] a() {
        return this.allowList;
    }

    public final long b() {
        return this.dataExpiredDelayTime;
    }

    public final boolean c() {
        return this.enableCache;
    }

    public final boolean d() {
        return this.enableLivePrefetch;
    }

    public h(int r100) {
        this.enableCache = false;
        this.enableLivePrefetch = false;
        this.allowList = null;
        this.dataExpiredDelayTime = 300000;
    }
}
