package com.bytedance.locallife.biz.prefetch.newsdk;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/bytedance/locallife/biz/prefetch/newsdk/g;", "", "", "banPrefetch", "Z", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Z", "", "sameFrequency", "I", "b", "()I", "totalFrequency", "c", "locallife-biz-common_release"}, k = 1, mv = {1, 4, 3})
public final class g {

    @SerializedName("should_ban_prefetch")
    private final boolean banPrefetch;

    @SerializedName("same_frequency")
    private final int sameFrequency;

    @SerializedName("total_frequency")
    private final int totalFrequency;

    public g() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L8;
        return false;
    L8:
        g r101 = (g) r100;
        if (this.banPrefetch == r101.banPrefetch) goto L12;
        return false;
    L12:
        if (this.sameFrequency == r101.sameFrequency) goto L15;
        return false;
    L15:
        if (this.totalFrequency == r101.totalFrequency) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        if (this.banPrefetch == false) goto L5;
        int r100 = 1231;
    L7:
        return (((r100 * 31) + this.sameFrequency) * 31) + this.totalFrequency;
    L5:
        r100 = 1237;
        goto L7
    }

    public final String toString() {
        return "PrefetchDemoteConfig(banPrefetch=" + this.banPrefetch + ", sameFrequency=" + this.sameFrequency + ", totalFrequency=" + this.totalFrequency + ')';
    }

    public final boolean a() {
        return this.banPrefetch;
    }

    public final int b() {
        return this.sameFrequency;
    }

    public final int c() {
        return this.totalFrequency;
    }

    public g(int r100) {
        this.banPrefetch = false;
        this.sameFrequency = 3;
        this.totalFrequency = 10;
    }
}
