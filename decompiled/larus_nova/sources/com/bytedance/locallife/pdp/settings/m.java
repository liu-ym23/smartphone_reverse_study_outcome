package com.bytedance.locallife.pdp.settings;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR.\u0010\u000f\u001a\u0016\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u000e\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R(\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0013\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0010\u001a\u0004\b\u0015\u0010\u0012R\"\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u0004\u001a\u0004\b\u001b\u0010\u0006¨\u0006\u001c"}, d2 = {"Lcom/bytedance/locallife/pdp/settings/m;", "", "", "enable", "Z", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Z", "", "prefetchExpiredDelayTime", "J", "getPrefetchExpiredDelayTime", "()J", "", "", "", "supportLayout", "Ljava/util/Map;", "getSupportLayout", "()Ljava/util/Map;", "Lcom/bytedance/locallife/pdp/settings/n0;", "supportLynxNodes", "b", "deliveryShelfTags", "Ljava/util/List;", "getDeliveryShelfTags", "()Ljava/util/List;", "pageStructOpt", "getPageStructOpt", "locallife-pdp-impl_release"}, k = 1, mv = {1, 4, 3})
public final class m {

    @SerializedName("delivery_shelf_tags")
    private final List<String> deliveryShelfTags;

    @SerializedName("enable")
    private final boolean enable;

    @SerializedName("page_struct_opt")
    private final boolean pageStructOpt;

    @SerializedName("prefetch_expired_delay_time")
    private final long prefetchExpiredDelayTime;

    @SerializedName("support_layout")
    private final Map<String, List<String>> supportLayout;

    @SerializedName("support_lynx_nodes")
    private final Map<String, n0> supportLynxNodes;

    public m() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof m) == true) goto L8;
        return false;
    L8:
        m r101 = (m) r100;
        if (this.enable == r101.enable) goto L12;
        return false;
    L12:
        if (this.prefetchExpiredDelayTime == r101.prefetchExpiredDelayTime) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.supportLayout, r101.supportLayout) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.supportLynxNodes, r101.supportLynxNodes) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.deliveryShelfTags, r101.deliveryShelfTags) == true) goto L24;
        return false;
    L24:
        if (this.pageStructOpt == r101.pageStructOpt) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.enable == false) goto L5;
        int r101 = 1231;
    L6:
        long r102 = this.prefetchExpiredDelayTime;
        int r103 = ((r101 * 31) + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        Map<String, List<String>> r104 = this.supportLayout;
        int r105 = 0;
        if (r104 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r103 + r106) * 31;
        Map<String, n0> r108 = this.supportLynxNodes;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        List<String> r111 = this.deliveryShelfTags;
        if (r111 == null) goto L18;
        r105 = r111.hashCode();
    L18:
        int r112 = (r110 + r105) * 31;
        if (this.pageStructOpt == true) goto L23;
        r100 = 1237;
    L23:
        return r112 + r100;
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r104.hashCode();
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "DeliveryGoodsDetailPrefetchConfig(enable=" + this.enable + ", prefetchExpiredDelayTime=" + this.prefetchExpiredDelayTime + ", supportLayout=" + this.supportLayout + ", supportLynxNodes=" + this.supportLynxNodes + ", deliveryShelfTags=" + this.deliveryShelfTags + ", pageStructOpt=" + this.pageStructOpt + ')';
    }

    public final boolean a() {
        return this.enable;
    }

    public final Map<String, n0> b() {
        return this.supportLynxNodes;
    }

    public m(Object r100) {
        this.enable = false;
        this.prefetchExpiredDelayTime = 300000;
        this.supportLayout = null;
        this.supportLynxNodes = null;
        this.deliveryShelfTags = null;
        this.pageStructOpt = false;
    }
}
