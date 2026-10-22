package com.ss.ttvideoengine.utils;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes35.dex */
public final class ValueWeakReference<T> extends WeakReference<T> {
    public ValueWeakReference(T r100) {
        super(r100);
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof ValueWeakReference) == true) goto L5;
        return false;
    L5:
        T r101 = get();
        if (r101 != null) goto L9;
        return false;
    L9:
        return r101.equals(((ValueWeakReference) r100).get());
    }

    public ValueWeakReference(T r100, ReferenceQueue<? super T> r101) {
        super(r100, r101);
    }
}
