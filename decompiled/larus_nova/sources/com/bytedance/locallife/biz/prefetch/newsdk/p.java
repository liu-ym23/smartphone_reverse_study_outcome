package com.bytedance.locallife.biz.prefetch.newsdk;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/locallife/biz/prefetch/newsdk/p;", "", "", "prefetchDataMaxSize", "I", "b", "()I", "prefetchResultMaxSize", "c", "Lcom/bytedance/locallife/biz/prefetch/newsdk/g;", "demoteConfig", "Lcom/bytedance/locallife/biz/prefetch/newsdk/g;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/bytedance/locallife/biz/prefetch/newsdk/g;", "locallife-biz-common_release"}, k = 1, mv = {1, 4, 3})
public final class p {

    @SerializedName("demote_config")
    private final g demoteConfig;

    @SerializedName("prefetch_data_max_size")
    private final int prefetchDataMaxSize;

    @SerializedName("lru_capacity")
    private final int prefetchResultMaxSize;

    public p() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof p) == true) goto L8;
        return false;
    L8:
        p r101 = (p) r100;
        if (this.prefetchDataMaxSize == r101.prefetchDataMaxSize) goto L12;
        return false;
    L12:
        if (this.prefetchResultMaxSize == r101.prefetchResultMaxSize) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.demoteConfig, r101.demoteConfig) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.prefetchDataMaxSize * 31) + this.prefetchResultMaxSize) * 31;
        g r101 = this.demoteConfig;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "PrefetchSettingData(prefetchDataMaxSize=" + this.prefetchDataMaxSize + ", prefetchResultMaxSize=" + this.prefetchResultMaxSize + ", demoteConfig=" + this.demoteConfig + ')';
    }

    public final g a() {
        return this.demoteConfig;
    }

    public final int b() {
        return this.prefetchDataMaxSize;
    }

    public final int c() {
        return this.prefetchResultMaxSize;
    }

    public p(int r100) {
        g r101 = new g(0);
        this.prefetchDataMaxSize = 20;
        this.prefetchResultMaxSize = 20;
        this.demoteConfig = r101;
    }
}
