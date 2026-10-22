package com.facebook.cache.disk;

/* JADX INFO: loaded from: classes22.dex */
public class ScoreBasedEvictionComparatorSupplier implements EntryEvictionComparatorSupplier {
    private final float mAgeWeight;
    private final float mSizeWeight;

    @Override // com.facebook.cache.disk.EntryEvictionComparatorSupplier
    public EntryEvictionComparator get() {
        return new AnonymousClass1(this);
    }

    public ScoreBasedEvictionComparatorSupplier(float r100, float r101) {
        this.mAgeWeight = r100;
        this.mSizeWeight = r101;
    }

    public float calculateScore(DiskStorage.Entry r100, long r101) {
        return (this.mAgeWeight * (r101 - r100.getTimestamp())) + (this.mSizeWeight * r100.getSize());
    }
}
