package com.google.common.collect;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes23.dex */
public final class j1 extends v2<Map.Entry<Object, Object>, Object> {
    public j1(Iterator r100) {
        super(r100);
    }

    @Override // com.google.common.collect.v2
    @ParametricNullness
    public final Object a(Map.Entry<Object, Object> r100) {
        return r100.getValue();
    }
}
