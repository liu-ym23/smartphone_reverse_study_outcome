package com.google.common.collect;

import java.util.Iterator;

/* JADX INFO: loaded from: classes23.dex */
public final class z1 extends v2<y1.a<Object>, Object> {
    public z1(Iterator r100) {
        super(r100);
    }

    @Override // com.google.common.collect.v2
    @ParametricNullness
    public final Object a(y1.a<Object> r100) {
        return r100.getElement();
    }
}
