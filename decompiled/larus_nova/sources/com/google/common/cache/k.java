package com.google.common.cache;

import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public interface k<K, V> {
    long getAccessTime();

    int getHash();

    @CheckForNull
    K getKey();

    @CheckForNull
    k<K, V> getNext();

    k<K, V> getNextInAccessQueue();

    k<K, V> getNextInWriteQueue();

    k<K, V> getPreviousInAccessQueue();

    k<K, V> getPreviousInWriteQueue();

    @CheckForNull
    LocalCache.s<K, V> getValueReference();

    long getWriteTime();

    void setAccessTime(long r100);

    void setNextInAccessQueue(k<K, V> r100);

    void setNextInWriteQueue(k<K, V> r100);

    void setPreviousInAccessQueue(k<K, V> r100);

    void setPreviousInWriteQueue(k<K, V> r100);

    void setValueReference(LocalCache.s<K, V> r100);

    void setWriteTime(long r100);
}
