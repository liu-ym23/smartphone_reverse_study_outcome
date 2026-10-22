package com.bytedance.locallife.groupon.struct.refresh;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/bytedance/locallife/groupon/struct/refresh/PrefetchConfig;", "", "enablePrefetch", "", "enableUseCache", "(ZZ)V", "getEnablePrefetch", "()Z", "getEnableUseCache", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "locallife-groupon-api_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class PrefetchConfig {

    @SerializedName("enable_prefetch")
    private final boolean enablePrefetch;

    @SerializedName("enable_use_cache")
    private final boolean enableUseCache;

    public PrefetchConfig() {
        boolean r100 = false;
        this(r100, r100, 3, null);
    }

    public static /* synthetic */ PrefetchConfig copy$default(PrefetchConfig r100, boolean r101, boolean r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.enablePrefetch;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.enableUseCache;
    L9:
        return r100.copy(r101, r102);
    }

    public final boolean component1() {
        return this.enablePrefetch;
    }

    public final boolean component2() {
        return this.enableUseCache;
    }

    public final PrefetchConfig copy(boolean r100, boolean r101) {
        return new PrefetchConfig(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PrefetchConfig) == true) goto L8;
        return false;
    L8:
        PrefetchConfig r101 = (PrefetchConfig) r100;
        if (this.enablePrefetch == r101.enablePrefetch) goto L12;
        return false;
    L12:
        if (this.enableUseCache == r101.enableUseCache) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        int r100 = 1231;
        if (this.enablePrefetch == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.enableUseCache == true) goto L11;
        r100 = 1237;
    L11:
        return r102 + r100;
    L5:
        r101 = 1237;
        goto L6
    }

    public String toString() {
        return "PrefetchConfig(enablePrefetch=" + this.enablePrefetch + ", enableUseCache=" + this.enableUseCache + ')';
    }

    public final boolean getEnablePrefetch() {
        return this.enablePrefetch;
    }

    public final boolean getEnableUseCache() {
        return this.enableUseCache;
    }

    public PrefetchConfig(boolean r100, boolean r101) {
        this.enablePrefetch = r100;
        this.enableUseCache = r101;
    }

    public /* synthetic */ PrefetchConfig(boolean r100, boolean r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = true;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = true;
    L8:
        this(r100, r101);
    }
}
