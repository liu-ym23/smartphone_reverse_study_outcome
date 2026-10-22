package com.google.common.collect;

import java.util.NoSuchElementException;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public abstract class g<T> extends z2<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @CheckForNull
    public T f275464a;

    @CheckForNull
    public abstract T a(T r100);

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.f275464a == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.Iterator
    public final T next() {
        T r100 = this.f275464a;
        if (r100 == null) goto L7;
        this.f275464a = a(r100);
        return r100;
    L7:
        throw new NoSuchElementException();
    }

    public g(@CheckForNull T r100) {
        this.f275464a = r100;
    }
}
