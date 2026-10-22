package com.xiaomi.push;

import java.io.ByteArrayOutputStream;

/* JADX INFO: loaded from: classes41.dex */
public class hu {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private hz f464084a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final ig f942a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final ByteArrayOutputStream f943a;

    public hu() {
        this(new hv.a());
    }

    public hu(ib r100) {
        ByteArrayOutputStream r101 = new ByteArrayOutputStream();
        this.f943a = r101;
        ig r102 = new ig(r101);
        this.f942a = r102;
        this.f464084a = r100.a(r102);
    }

    public byte[] a(hp r100) {
        this.f943a.reset();
        r100.b(this.f464084a);
        return this.f943a.toByteArray();
    }
}
