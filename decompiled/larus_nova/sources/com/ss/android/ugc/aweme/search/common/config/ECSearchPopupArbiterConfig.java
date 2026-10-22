package com.ss.android.ugc.aweme.search.common.config;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/config/ECSearchPopupArbiterConfig;", "", "", "arbiterWindowTime", "J", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()J", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECSearchPopupArbiterConfig {

    @SerializedName("ec_search_popup_arbiter_window")
    private final long arbiterWindowTime;

    public ECSearchPopupArbiterConfig() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ECSearchPopupArbiterConfig) == true) goto L6;
        return false;
    L6:
        if (this.arbiterWindowTime == ((ECSearchPopupArbiterConfig) r100).arbiterWindowTime) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        long r100 = this.arbiterWindowTime;
        return (int) (r100 ^ (r100 >>> 32));
    }

    public final String toString() {
        return "ECSearchPopupArbiterConfig(arbiterWindowTime=" + this.arbiterWindowTime + ")";
    }

    public final long a() {
        return this.arbiterWindowTime;
    }

    public ECSearchPopupArbiterConfig(int r100) {
        this.arbiterWindowTime = 200;
    }
}
