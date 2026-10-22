package com.google.common.collect;

import java.util.Map;

/* JADX INFO: loaded from: classes23.dex */
public final class h1 implements com.google.common.base.g<Map.Entry<Object, Object>, Map.Entry<Object, Object>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Maps.d f275469a;

    public h1(Maps.d r100) {
        this.f275469a = r100;
    }

    @Override // com.google.common.base.g
    public final Map.Entry<Object, Object> apply(Map.Entry<Object, Object> r100) {
        Map.Entry<Object, Object> r101 = r100;
        Maps.d r102 = this.f275469a;
        r102.getClass();
        r101.getClass();
        return new g1(r101, r102);
    }
}
