package com.squareup.wire.internal;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes5.dex */
final class ImmutableList<T> extends AbstractList<T> implements RandomAccess, Serializable {
    private final ArrayList<T> list;

    private Object writeReplace() throws ObjectStreamException {
        return Collections.unmodifiableList(this.list);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.list.size();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public Object[] toArray() {
        return this.list.toArray();
    }

    public ImmutableList(List<T> r100) {
        this.list = new ArrayList(r100);
    }

    @Override // java.util.AbstractList, java.util.List
    public T get(int r100) {
        return (T) ListProtector.get(this.list, r100);
    }
}
