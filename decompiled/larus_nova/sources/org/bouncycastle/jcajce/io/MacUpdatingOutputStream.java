package org.bouncycastle.jcajce.io;

import java.io.IOException;
import java.io.OutputStream;
import javax.crypto.Mac;

/* JADX INFO: loaded from: classes42.dex */
class MacUpdatingOutputStream extends OutputStream {

    /* JADX INFO: renamed from: mac, reason: collision with root package name */
    private Mac f525351mac;

    public MacUpdatingOutputStream(Mac r100) {
        this.f525351mac = r100;
    }

    @Override // java.io.OutputStream
    public void write(int r100) throws IOException {
        this.f525351mac.update((byte) r100);
    }

    @Override // java.io.OutputStream
    public void write(byte[] r100) throws IOException {
        this.f525351mac.update(r100);
    }

    @Override // java.io.OutputStream
    public void write(byte[] r100, int r101, int r102) throws IOException {
        this.f525351mac.update(r100, r101, r102);
    }
}
