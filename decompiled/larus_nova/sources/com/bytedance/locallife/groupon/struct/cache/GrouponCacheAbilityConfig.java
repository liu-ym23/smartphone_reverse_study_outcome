package com.bytedance.locallife.groupon.struct.cache;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/bytedance/locallife/groupon/struct/cache/GrouponCacheAbilityConfig;", "", "maxCount", "", "maxUnuseTime", "", "(IJ)V", "getMaxCount", "()I", "getMaxUnuseTime", "()J", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "locallife-groupon-api_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class GrouponCacheAbilityConfig {

    @SerializedName("max_cache_count")
    private final int maxCount;

    @SerializedName("max_unuse_time")
    private final long maxUnuseTime;

    public GrouponCacheAbilityConfig() {
        this(0, 0, 3, null);
    }

    public static /* synthetic */ GrouponCacheAbilityConfig copy$default(GrouponCacheAbilityConfig r100, int r101, long r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.maxCount;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.maxUnuseTime;
    L9:
        return r100.copy(r101, r102);
    }

    public final int component1() {
        return this.maxCount;
    }

    public final long component2() {
        return this.maxUnuseTime;
    }

    public final GrouponCacheAbilityConfig copy(int r100, long r101) {
        return new GrouponCacheAbilityConfig(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof GrouponCacheAbilityConfig) == true) goto L8;
        return false;
    L8:
        GrouponCacheAbilityConfig r101 = (GrouponCacheAbilityConfig) r100;
        if (this.maxCount == r101.maxCount) goto L12;
        return false;
    L12:
        if (this.maxUnuseTime == r101.maxUnuseTime) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        int r100 = this.maxCount * 31;
        long r101 = this.maxUnuseTime;
        return r100 + ((int) (r101 ^ (r101 >>> 32)));
    }

    public String toString() {
        return "GrouponCacheAbilityConfig(maxCount=" + this.maxCount + ", maxUnuseTime=" + this.maxUnuseTime + ')';
    }

    public final int getMaxCount() {
        return this.maxCount;
    }

    public final long getMaxUnuseTime() {
        return this.maxUnuseTime;
    }

    public GrouponCacheAbilityConfig(int r100, long r101) {
        this.maxCount = r100;
        this.maxUnuseTime = r101;
    }

    public /* synthetic */ GrouponCacheAbilityConfig(int r100, long r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = 10;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = 168;
    L8:
        this(r100, r101);
    }
}
