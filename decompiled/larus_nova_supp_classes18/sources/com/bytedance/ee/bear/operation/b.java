package com.bytedance.ee.bear.operation;

import com.bytedance.ee.bear.contract.b0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b implements zk5.a {
    public final b0 a;

    public b() {
        this.a = (b0) org.koin.java.a.a(b0.class);
    }

    @Override // zk5.a
    public final void a(final int r3, final String r4, final String r5) {
        fo5.d.c().scheduleDirect(new a(this, r3, r4, r5));
    }
}
