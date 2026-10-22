package com.bytedance.jedi.model.guava.collect;

import com.bytedance.jedi.model.guava.annotations.NullableDecl;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes19.dex */
public abstract class AbstractSequentialIterator<T> implements Iterator<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NullableDecl
    public T f251181a;

    @NullableDecl
    public abstract T a(T r100);

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.f251181a == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.Iterator
    public final T next() {
        if (hasNext() == false) goto L11;
        T r100 = this.f251181a;     // Catch: Throwable -> L7
        this.f251181a = a(r100);
        return r100;
    L7:
        th = move-exception;
        this.f251181a = a(this.f251181a);
        throw th;
    L11:
        throw new NoSuchElementException();
    }

    public AbstractSequentialIterator(@NullableDecl T r100) {
        this.f251181a = r100;
    }
}
