package com.google.common.reflect;

import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes23.dex */
public final class f extends d.e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ TypeVariable f275699c;

    @Override // com.google.common.reflect.d.e
    public final TypeVariable<?> b(Type[] r100) {
        LinkedHashSet r101 = new LinkedHashSet(Arrays.asList(r100));
        r101.addAll(Arrays.asList(this.f275699c.getBounds()));
        if (r101.size() <= 1) goto L6;
        r101.remove(Object.class);
    L6:
        return super.b((Type[]) r101.toArray(new Type[0]));
    }

    public f(AtomicInteger r100, TypeVariable r101) {
        this.f275699c = r101;
        super(r100);
    }
}
