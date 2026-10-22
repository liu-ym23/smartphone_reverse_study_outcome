package com.google.common.collect;

import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes23.dex */
public final class d1 extends z2<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f275455a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f275456b;

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return !this.f275455a;
    }

    @Override // java.util.Iterator
    @ParametricNullness
    public final Object next() {
        if (this.f275455a == true) goto L7;
        this.f275455a = true;
        return this.f275456b;
    L7:
        throw new NoSuchElementException();
    }

    public d1(Object r100) {
        this.f275456b = r100;
    }
}
