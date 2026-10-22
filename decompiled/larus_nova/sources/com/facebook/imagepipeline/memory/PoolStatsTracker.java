package com.facebook.imagepipeline.memory;

/* JADX INFO: loaded from: classes3.dex */
public interface PoolStatsTracker {
    public static final String BUCKETS_USED_PREFIX = "buckets_used_";
    public static final String FREE_BYTES = "free_bytes";
    public static final String FREE_COUNT = "free_count";
    public static final String HARD_CAP = "hard_cap";
    public static final String SOFT_CAP = "soft_cap";
    public static final String USED_BYTES = "used_bytes";
    public static final String USED_COUNT = "used_count";

    void onAlloc(int r100);

    void onFree(int r100);

    void onHardCapReached();

    void onSoftCapReached();

    void onValueRelease(int r100);

    void onValueReuse(int r100);

    void setBasePool(BasePool r100);
}
