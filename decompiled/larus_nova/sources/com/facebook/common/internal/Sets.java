package com.facebook.common.internal;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes3.dex */
public final class Sets {
    private Sets() {
    }

    public static <E> CopyOnWriteArraySet<E> newCopyOnWriteArraySet() {
        return new CopyOnWriteArraySet();
    }

    public static <E> HashSet<E> newHashSet() {
        return new HashSet();
    }

    public static <E> Set<E> newIdentityHashSet() {
        return newSetFromMap(new IdentityHashMap());
    }

    public static <E> LinkedHashSet<E> newLinkedHashSet() {
        return new LinkedHashSet();
    }

    public static <E> HashSet<E> newHashSet(Iterable<? extends E> r100) {
        if ((r100 instanceof Collection) == false) goto L6;
        return new HashSet((Collection) r100);
    L6:
        return newHashSet(r100.iterator());
    }

    public static <E> HashSet<E> newHashSetWithCapacity(int r100) {
        return new HashSet(r100);
    }

    public static <E> Set<E> newSetFromMap(Map<E, Boolean> r100) {
        return Collections.newSetFromMap(r100);
    }

    public static <E> HashSet<E> newHashSet(Iterator<? extends E> r100) {
        HashSet<E> r101 = newHashSet();
    L4:
        if (r100.hasNext() == false) goto L6;
        r101.add(r100.next());
        goto L4
    L6:
        return r101;
    }

    public static <E> HashSet<E> newHashSet(E... r100) {
        HashSet<E> r101 = newHashSetWithCapacity(r100.length);
        Collections.addAll(r101, r100);
        return r101;
    }
}
