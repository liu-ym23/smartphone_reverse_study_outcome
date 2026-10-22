package com.ss.ugc.effectplatform.download;

import com.ss.ugc.effectplatform.bridge.network.ByteReadStream;

/* JADX INFO: loaded from: classes6.dex */
public final class d extends bytekn.foundation.io.file.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ByteReadStream f457373b;

    @Override // bytekn.foundation.io.file.b, bytekn.foundation.io.file.g
    public final void close() {
        this.f457373b.close();
    }

    public d(ByteReadStream r100) {
        this.f457373b = r100;
    }

    @Override // bytekn.foundation.io.file.b
    public final int a(byte[] r100, int r101) {
        return this.f457373b.read(r100, 0, r101);
    }
}
