package org.bouncycastle.crypto.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes42.dex */
class SSHBuilder {
    private final ByteArrayOutputStream bos;

    public SSHBuilder() {
        this.bos = new ByteArrayOutputStream();
    }

    public byte[] getBytes() {
        return this.bos.toByteArray();
    }

    public byte[] getPaddedBytes() {
        return getPaddedBytes(8);
    }

    public byte[] getPaddedBytes(int r100) {
        int r101 = this.bos.size() % r100;
        if (r101 == 0) goto L8;
        int r102 = r100 - r101;
        int r103 = 1;
    L5:
        if (r103 > r102) goto L8;
        this.bos.write(r103);
        r103 = r103 + 1;
    L8:
        return this.bos.toByteArray();
    }

    public void u32(int r100) {
        this.bos.write((r100 >>> 24) & 255);
        this.bos.write((r100 >>> 16) & 255);
        this.bos.write((r100 >>> 8) & 255);
        this.bos.write(r100 & 255);
    }

    public void writeBigNum(BigInteger r100) {
        writeBlock(r100.toByteArray());
    }

    public void writeBlock(byte[] r100) {
        u32(r100.length);
        this.bos.write(r100);     // Catch: IOException -> L5
        return;
    L5:
        e = move-exception;
        throw new IllegalStateException(e.getMessage(), e);
    }

    public void writeBytes(byte[] r100) {
        this.bos.write(r100);     // Catch: IOException -> L4
        return;
    L4:
        e = move-exception;
        throw new IllegalStateException(e.getMessage(), e);
    }

    public void writeString(String r100) {
        writeBlock(Strings.toByteArray(r100));
    }
}
