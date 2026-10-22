package com.bytedance.mira.signature;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.security.DigestException;

/* JADX INFO: loaded from: classes21.dex */
class ByteBufferDataSource implements DataSource {
    private final ByteBuffer mBuf;

    @Override // com.bytedance.mira.signature.DataSource
    public long size() {
        return this.mBuf.capacity();
    }

    public ByteBufferDataSource(ByteBuffer r100) {
        this.mBuf = r100.slice();
    }

    @Override // com.bytedance.mira.signature.DataSource
    public void feedIntoDataDigester(DataDigester r100, long r101, int r102) throws IOException, DigestException {
        ByteBuffer r103 = this.mBuf;
        monitor-enter(r103);
        this.mBuf.position(0);     // Catch: Throwable -> L8
        int r104 = (int) r101;     // Catch: Throwable -> L8
        this.mBuf.limit(r102 + r104);     // Catch: Throwable -> L8
        this.mBuf.position(r104);     // Catch: Throwable -> L8
        ByteBuffer r105 = this.mBuf.slice();     // Catch: Throwable -> L8
        monitor-exit(r103);     // Catch: Throwable -> L8
        r100.consume(r105);
        return;
    L8:
        th = move-exception;
        throw th;
    }
}
