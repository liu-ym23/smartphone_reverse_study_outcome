package com.bytedance.ee.bear.operation;

import com.bytedance.ee.bear.contract.b0;

/* JADX INFO: loaded from: classes18.dex */
public final class b implements zk5.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b0 f236205a;

    public b() {
        this.f236205a = (b0) org.koin.java.a.a(b0.class);
    }

    @Override // zk5.a
    public final void a(final int r100, final String r101, final String r102) {
        fo5.d.c().scheduleDirect(new a(this, r100, r101, r102));
    }
}
