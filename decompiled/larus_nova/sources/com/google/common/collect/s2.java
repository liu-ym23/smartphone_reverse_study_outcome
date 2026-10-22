package com.google.common.collect;

import java.util.Collection;
import java.util.Map;

/* JADX INFO: loaded from: classes23.dex */
public final class s2 extends l0<Object, Collection<Object>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Map.Entry f275503a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Synchronized.SynchronizedAsMapEntries.a f275504b;

    @Override // com.google.common.collect.l0, java.util.Map.Entry
    public final Object getValue() {
        return Synchronized.b((Collection) this.f275503a.getValue(), this.f275504b.f275358b.mutex);
    }

    @Override // com.google.common.collect.o0
    public final Object delegate() {
        return this.f275503a;
    }

    @Override // com.google.common.collect.l0
    public final Map.Entry<Object, Collection<Object>> e() {
        return this.f275503a;
    }

    public s2(Synchronized.SynchronizedAsMapEntries.a r100, Map.Entry r101) {
        this.f275504b = r100;
        this.f275503a = r101;
    }
}
