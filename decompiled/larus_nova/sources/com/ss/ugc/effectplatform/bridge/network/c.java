package com.ss.ugc.effectplatform.bridge.network;

import java.io.InputStream;

/* JADX INFO: loaded from: classes36.dex */
public final class c extends InputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ByteReadStream f457263a;

    @Override // java.io.InputStream
    public final int read() {
        return this.f457263a.read();
    }

    public c(ByteReadStream r100) {
        this.f457263a = r100;
    }

    @Override // java.io.InputStream
    public final int read(byte[] r100, int r101, int r102) {
        return this.f457263a.read(r100, r101, r102);
    }
}
