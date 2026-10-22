package org.bouncycastle.crypto.io;

import java.io.IOException;
import java.io.OutputStream;
import org.bouncycastle.crypto.Mac;

/* JADX INFO: loaded from: classes42.dex */
public class MacOutputStream extends OutputStream {

    /* JADX INFO: renamed from: mac, reason: collision with root package name */
    protected Mac f525223mac;

    public MacOutputStream(Mac r100) {
        this.f525223mac = r100;
    }

    public byte[] getMac() {
        byte[] r100 = new byte[this.f525223mac.getMacSize()];
        this.f525223mac.doFinal(r100, 0);
        return r100;
    }

    @Override // java.io.OutputStream
    public void write(int r100) throws IOException {
        this.f525223mac.update((byte) r100);
    }

    @Override // java.io.OutputStream
    public void write(byte[] r100, int r101, int r102) throws IOException {
        this.f525223mac.update(r100, r101, r102);
    }
}
