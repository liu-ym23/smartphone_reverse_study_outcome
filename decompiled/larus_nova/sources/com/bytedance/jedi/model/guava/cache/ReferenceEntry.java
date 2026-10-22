package com.bytedance.jedi.model.guava.cache;

import com.bytedance.jedi.model.guava.annotations.NullableDecl;

/* JADX INFO: loaded from: classes19.dex */
interface ReferenceEntry<K, V> {
    long getAccessTime();

    int getHash();

    @NullableDecl
    K getKey();

    @NullableDecl
    ReferenceEntry<K, V> getNext();

    ReferenceEntry<K, V> getNextInAccessQueue();

    ReferenceEntry<K, V> getNextInWriteQueue();

    ReferenceEntry<K, V> getPreviousInAccessQueue();

    ReferenceEntry<K, V> getPreviousInWriteQueue();

    LocalCache.ValueReference<K, V> getValueReference();

    long getWriteTime();

    void setAccessTime(long r100);

    void setNextInAccessQueue(ReferenceEntry<K, V> r100);

    void setNextInWriteQueue(ReferenceEntry<K, V> r100);

    void setPreviousInAccessQueue(ReferenceEntry<K, V> r100);

    void setPreviousInWriteQueue(ReferenceEntry<K, V> r100);

    void setValueReference(LocalCache.ValueReference<K, V> r100);

    void setWriteTime(long r100);
}
