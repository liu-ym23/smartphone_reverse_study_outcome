package com.bytedance.android.shopping.mall.homepage.preload;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R*\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/shopping/mall/homepage/preload/j;", "", "", "Lcom/bytedance/android/shopping/mall/homepage/preload/i;", "config", "Ljava/util/List;", "a", "()Ljava/util/List;", "setConfig", "(Ljava/util/List;)V", "", "loadOpportunity", "Ljava/lang/Integer;", "getLoadOpportunity", "()Ljava/lang/Integer;", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class j {

    @SerializedName("card_config")
    private List<i> config;

    @SerializedName("preload_opportunity")
    private final Integer loadOpportunity;

    public j() {
        this(null);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof j) == false) goto L10;
        j r4 = (j) r3;
        if (Intrinsics.areEqual(this.config, r4.config) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.loadOpportunity, r4.loadOpportunity) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        List<i> r0 = this.config;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        Integer r4 = this.loadOpportunity;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "PreCreateLynxSetting(config=" + this.config + ", loadOpportunity=" + this.loadOpportunity + ")";
    }

    public final List<i> a() {
        return this.config;
    }

    public j(Object r1) {
        this.config = null;
        this.loadOpportunity = null;
    }
}
