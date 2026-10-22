package com.google.common.collect;

import java.util.Collection;
import java.util.Map;

/* JADX INFO: loaded from: classes23.dex */
public final /* synthetic */ class w implements com.google.common.base.n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.google.common.base.n f275534a;

    public /* synthetic */ w(com.google.common.base.n r100) {
        this.f275534a = r100;
    }

    @Override // com.google.common.base.n
    public final boolean apply(Object r100) {
        Map.Entry r101 = (Map.Entry) r100;
        return this.f275534a.apply(new Multisets.ImmutableEntry(r101.getKey(), ((Collection) r101.getValue()).size()));
    }
}
