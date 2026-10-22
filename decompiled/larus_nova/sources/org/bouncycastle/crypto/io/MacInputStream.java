package org.bouncycastle.crypto.io;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.crypto.Mac;

/* JADX INFO: loaded from: classes42.dex */
public class MacInputStream extends FilterInputStream {

    /* JADX INFO: renamed from: mac, reason: collision with root package name */
    protected Mac f525222mac;

    public MacInputStream(InputStream r100, Mac r101) {
        super(r100);
        this.f525222mac = r101;
    }

    public Mac getMac() {
        return this.f525222mac;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        int r100 = ((FilterInputStream) this).in.read();
        if (r100 < 0) goto L5;
        this.f525222mac.update((byte) r100);
    L5:
        return r100;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] r100, int r101, int r102) throws IOException {
        int r103 = ((FilterInputStream) this).in.read(r100, r101, r102);
        if (r103 < 0) goto L5;
        this.f525222mac.update(r100, r101, r103);
    L5:
        return r103;
    }
}
