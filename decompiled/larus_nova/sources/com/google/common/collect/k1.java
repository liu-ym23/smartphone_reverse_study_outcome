package com.google.common.collect;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes23.dex */
public final class k1 extends v2<Object, Map.Entry<Object, Object>> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.google.common.base.g f275482b;

    @Override // com.google.common.collect.v2
    public final Map.Entry<Object, Object> a(@ParametricNullness Object r100) {
        return new ImmutableEntry(r100, this.f275482b.apply(r100));
    }

    public k1(Iterator r100, com.google.common.base.g r101) {
        this.f275482b = r101;
        super(r100);
    }
}
