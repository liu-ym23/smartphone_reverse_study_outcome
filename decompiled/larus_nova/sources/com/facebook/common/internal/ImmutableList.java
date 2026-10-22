package com.facebook.common.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes22.dex */
public class ImmutableList<E> extends ArrayList<E> {
    private ImmutableList(int r100) {
        super(r100);
    }

    public static <E> ImmutableList<E> copyOf(List<E> r100) {
        return new ImmutableList(r100);
    }

    public static <E> ImmutableList<E> of(E... r100) {
        ImmutableList<E> r101 = new ImmutableList(r100.length);
        Collections.addAll(r101, r100);
        return r101;
    }

    private ImmutableList(List<E> r100) {
        super(r100);
    }
}
