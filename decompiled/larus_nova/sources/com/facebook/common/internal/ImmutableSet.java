package com.facebook.common.internal;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes22.dex */
public class ImmutableSet<E> extends HashSet<E> {
    private ImmutableSet(Set<E> r100) {
        super(r100);
    }

    public static <E> ImmutableSet<E> copyOf(Set<E> r100) {
        return new ImmutableSet(r100);
    }

    public static <E> ImmutableSet<E> of(E... r100) {
        HashSet r101 = new HashSet(r100.length);
        Collections.addAll(r101, r100);
        return new ImmutableSet(r101);
    }
}
