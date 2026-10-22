package com.bytedance.locallife.pdp.settings;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R0\u0010\t\u001a\u0018\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\b\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0005\u001a\u0004\b\n\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/bytedance/locallife/pdp/settings/j;", "", "", "", "composeParamsPageKey", "Ljava/util/List;", "b", "()Ljava/util/List;", "", "cacheBlockRulesList", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "locallife-pdp-impl_release"}, k = 1, mv = {1, 4, 3})
public final class j {

    @SerializedName("block_rules_list")
    private final List<Map<String, String>> cacheBlockRulesList;

    @SerializedName("compose_params_page_key")
    private final List<String> composeParamsPageKey;

    public j() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof j) == true) goto L8;
        return false;
    L8:
        j r101 = (j) r100;
        if (Intrinsics.areEqual(this.composeParamsPageKey, r101.composeParamsPageKey) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.cacheBlockRulesList, r101.cacheBlockRulesList) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        List<String> r100 = this.composeParamsPageKey;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        List<Map<String, String>> r104 = this.cacheBlockRulesList;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "DeliveryGoodsDetailCacheSettingInfo(composeParamsPageKey=" + this.composeParamsPageKey + ", cacheBlockRulesList=" + this.cacheBlockRulesList + ')';
    }

    public final List<Map<String, String>> a() {
        return this.cacheBlockRulesList;
    }

    public final List<String> b() {
        return this.composeParamsPageKey;
    }

    public j(Object r100) {
        this.composeParamsPageKey = null;
        this.cacheBlockRulesList = null;
    }
}
