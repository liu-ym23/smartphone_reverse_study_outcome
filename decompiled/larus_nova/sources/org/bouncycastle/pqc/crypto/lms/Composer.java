package org.bouncycastle.pqc.crypto.lms;

import java.io.ByteArrayOutputStream;
import org.bouncycastle.util.Encodable;

/* JADX INFO: loaded from: classes42.dex */
public class Composer {
    private final ByteArrayOutputStream bos;

    private Composer() {
        this.bos = new ByteArrayOutputStream();
    }

    public static Composer compose() {
        return new Composer();
    }

    public Composer bool(boolean r100) {
        this.bos.write(r100 ? 1 : 0);
        return this;
    }

    public byte[] build() {
        return this.bos.toByteArray();
    }

    public Composer bytes(Encodable r100) {
        this.bos.write(r100.getEncoded());     // Catch: Exception -> L4
        return this;
    L4:
        e = move-exception;
        throw new RuntimeException(e.getMessage(), e);
    }

    public Composer bytes(byte[] r100) {
        this.bos.write(r100);     // Catch: Exception -> L4
        return this;
    L4:
        e = move-exception;
        throw new RuntimeException(e.getMessage(), e);
    }

    public Composer bytes(byte[] r100, int r101, int r102) {
        this.bos.write(r100, r101, r102);     // Catch: Exception -> L4
        return this;
    L4:
        e = move-exception;
        throw new RuntimeException(e.getMessage(), e);
    }

    public Composer bytes(Encodable[] r100) {
        int r101 = r100.length;     // Catch: Exception -> L7
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L6;
        Encodable r103 = r100[r102];     // Catch: Exception -> L7
        this.bos.write(r103.getEncoded());     // Catch: Exception -> L7
        r102 = r102 + 1;
        goto L3
    L6:
        return this;
    L7:
        e = move-exception;
        throw new RuntimeException(e.getMessage(), e);
    }

    public Composer bytes(byte[][] r100) {
        int r101 = r100.length;     // Catch: Exception -> L7
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L6;
        byte[] r103 = r100[r102];     // Catch: Exception -> L7
        this.bos.write(r103);     // Catch: Exception -> L7
        r102 = r102 + 1;
        goto L3
    L6:
        return this;
    L7:
        e = move-exception;
        throw new RuntimeException(e.getMessage(), e);
    }

    public Composer bytes(byte[][] r100, int r101, int r102) {
    L2:
        if (r101 == r102) goto L8;
        this.bos.write(r100[r101]);     // Catch: Exception -> L5
        r101 = r101 + 1;
    L5:
        e = move-exception;
        throw new RuntimeException(e.getMessage(), e);
    L8:
        return this;
    }

    public Composer pad(int r100, int r101) {
    L2:
        if (r101 < 0) goto L8;
        this.bos.write(r100);     // Catch: Exception -> L5
        r101 = r101 - 1;
    L5:
        e = move-exception;
        throw new RuntimeException(e.getMessage(), e);
    L8:
        return this;
    }

    public Composer padUntil(int r100, int r101) {
    L3:
        if (this.bos.size() >= r101) goto L5;
        this.bos.write(r100);
        goto L3
    L5:
        return this;
    }

    public Composer u16str(int r100) {
        int r101 = r100 & 65535;
        this.bos.write((byte) (r101 >>> 8));
        this.bos.write((byte) r101);
        return this;
    }

    public Composer u32str(int r100) {
        this.bos.write((byte) (r100 >>> 24));
        this.bos.write((byte) (r100 >>> 16));
        this.bos.write((byte) (r100 >>> 8));
        this.bos.write((byte) r100);
        return this;
    }

    public Composer u64str(long r100) {
        u32str((int) (r100 >>> 32));
        u32str((int) r100);
        return this;
    }
}
