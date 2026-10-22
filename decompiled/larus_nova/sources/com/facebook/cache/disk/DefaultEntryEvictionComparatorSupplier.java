package com.facebook.cache.disk;

/* JADX INFO: loaded from: classes3.dex */
public class DefaultEntryEvictionComparatorSupplier implements EntryEvictionComparatorSupplier {
    public DefaultEntryEvictionComparatorSupplier() {
    }

    @Override // com.facebook.cache.disk.EntryEvictionComparatorSupplier
    public EntryEvictionComparator get() {
        return new AnonymousClass1(this);
    }
}
