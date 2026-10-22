package com.google.common.collect;

import java.util.Collection;
import java.util.Map;

/* JADX INFO: loaded from: classes23.dex */
public final class w1 extends Multisets.a<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Map.Entry f275536a;

    @Override // com.google.common.collect.y1.a
    public final int getCount() {
        return ((Collection) this.f275536a.getValue()).size();
    }

    @Override // com.google.common.collect.y1.a
    @ParametricNullness
    public final Object getElement() {
        return this.f275536a.getKey();
    }

    public w1(Map.Entry r100) {
        this.f275536a = r100;
    }
}
