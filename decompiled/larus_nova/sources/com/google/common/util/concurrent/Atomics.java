package com.google.common.util.concurrent;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public final class Atomics {
    private Atomics() {
    }

    public static <V> AtomicReference<V> newReference() {
        return new AtomicReference();
    }

    public static <V> AtomicReference<V> newReference(@ParametricNullness V r100) {
        return new AtomicReference(r100);
    }

    public static <E> AtomicReferenceArray<E> newReferenceArray(int r100) {
        return new AtomicReferenceArray(r100);
    }

    public static <E> AtomicReferenceArray<E> newReferenceArray(E[] r100) {
        return new AtomicReferenceArray(r100);
    }
}
