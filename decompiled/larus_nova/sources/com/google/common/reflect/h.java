package com.google.common.reflect;

import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes23.dex */
public final class h extends TypeToken.e.c<Object> {
    public h(TypeToken.e r100) {
        super(r100);
    }

    @Override // com.google.common.reflect.TypeToken.e
    public final ImmutableList b(ImmutableCollection r100) {
        ImmutableList.a r101 = ImmutableList.builder();
        Iterator<E> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L9;
        Object r103 = r102.next();
        if (d(r103).isInterface() == true) goto L4;
        r101.b(r103);
        goto L4
    L9:
        return super.b(r101.e());
    }

    @Override // com.google.common.reflect.TypeToken.e
    public final Iterable<Object> c(Object r100) {
        return ImmutableSet.of();
    }
}
