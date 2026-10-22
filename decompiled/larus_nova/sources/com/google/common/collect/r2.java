package com.google.common.collect;

import java.util.Map;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
public final class r2 extends l0<Object, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Map.Entry f275500a;

    @Override // com.google.common.collect.o0
    public final Object delegate() {
        return this.f275500a;
    }

    @Override // com.google.common.collect.l0
    public final Map.Entry<Object, Object> e() {
        return this.f275500a;
    }

    public r2(Map.Entry r100) {
        this.f275500a = r100;
    }

    @Override // com.google.common.collect.l0, java.util.Map.Entry
    public final boolean equals(@CheckForNull Object r100) {
        if ((r100 instanceof Map.Entry) == false) goto L9;
        Map.Entry r101 = (Map.Entry) r100;
        if (com.google.common.base.k.a(getKey(), r101.getKey()) == false) goto L9;
        if (com.google.common.base.k.a(getValue(), r101.getValue()) == false) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // com.google.common.collect.l0, java.util.Map.Entry
    public final Object setValue(Object r100) {
        r100.getClass();
        return super.setValue(r100);
    }
}
