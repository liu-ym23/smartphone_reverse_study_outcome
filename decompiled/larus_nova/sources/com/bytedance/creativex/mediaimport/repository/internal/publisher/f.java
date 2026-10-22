package com.bytedance.creativex.mediaimport.repository.internal.publisher;

import oi4.s;

/* JADX INFO: loaded from: classes15.dex */
public final class f implements s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DefaultMaterialPublisher<Object, Object> f203672a;

    @Override // oi4.s
    public final void release() {
        this.f203672a.f203659c.clear();
    }

    public f(DefaultMaterialPublisher<Object, Object> r100) {
        this.f203672a = r100;
    }
}
