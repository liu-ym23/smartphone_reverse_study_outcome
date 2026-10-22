package com.volcengine.zeus.signature;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.security.DigestException;

/* JADX INFO: loaded from: classes41.dex */
public final class i implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ByteBuffer f462905a;

    @Override // com.volcengine.zeus.signature.k
    public final long size() {
        return this.f462905a.capacity();
    }

    public i(ByteBuffer r100) {
        this.f462905a = r100.slice();
    }

    @Override // com.volcengine.zeus.signature.k
    public final void a(j r100, long r101, int r102) throws IOException, DigestException {
        ByteBuffer r103 = this.f462905a;
        monitor-enter(r103);
        this.f462905a.position(0);     // Catch: Throwable -> L8
        int r104 = (int) r101;     // Catch: Throwable -> L8
        this.f462905a.limit(r102 + r104);     // Catch: Throwable -> L8
        this.f462905a.position(r104);     // Catch: Throwable -> L8
        ByteBuffer r105 = this.f462905a.slice();     // Catch: Throwable -> L8
        monitor-exit(r103);     // Catch: Throwable -> L8
        r100.consume(r105);
        return;
    L8:
        th = move-exception;
        throw th;
    }
}
