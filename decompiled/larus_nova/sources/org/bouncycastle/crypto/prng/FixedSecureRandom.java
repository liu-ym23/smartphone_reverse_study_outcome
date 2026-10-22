package org.bouncycastle.crypto.prng;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.SecureRandom;
import kotlin.UByte;

/* JADX INFO: loaded from: classes42.dex */
public class FixedSecureRandom extends SecureRandom {
    private byte[] _data;
    private int _index;
    private int _intPad;

    public FixedSecureRandom(boolean r100, byte[] r101) {
        this(r100, new byte[][]{r101});
    }

    public FixedSecureRandom(boolean r100, byte[][] r101) {
        ByteArrayOutputStream r102 = new ByteArrayOutputStream();
        int r103 = 0;
    L4:
        if (r103 == r101.length) goto L9;
        r102.write(r101[r103]);     // Catch: IOException -> L7
        r103 = r103 + 1;
    L8:
        throw new IllegalArgumentException("can't save value array.");
    L9:
        byte[] r104 = r102.toByteArray();
        this._data = r104;
        if (r100 == false) goto L16;
        this._intPad = r104.length % 4;
        return;
    }

    public FixedSecureRandom(byte[] r100) {
        this(false, new byte[][]{r100});
    }

    public FixedSecureRandom(byte[][] r100) {
        this(false, r100);
    }

    private int nextValue() {
        byte[] r100 = this._data;
        int r101 = this._index;
        this._index = r101 + 1;
        return r100[r101] & UByte.MAX_VALUE;
    }

    @Override // java.security.SecureRandom
    public byte[] generateSeed(int r100) {
        byte[] r101 = new byte[r100];
        nextBytes(r101);
        return r101;
    }

    public boolean isExhausted() {
        if (this._index != this._data.length) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.security.SecureRandom, java.util.Random
    public void nextBytes(byte[] r100) {
        System.arraycopy(this._data, this._index, r100, 0, r100.length);
        this._index += r100.length;
    }

    @Override // java.util.Random
    public int nextInt() {
        int r100 = ((nextValue() << 24) | 0) | (nextValue() << 16);
        int r101 = this._intPad;
        if (r101 != 2) goto L5;
        this._intPad = r101 - 1;
    L6:
        int r102 = this._intPad;
        if (r102 != 1) goto L10;
        this._intPad = r102 - 1;
        return r100;
    L10:
        return r100 | nextValue();
    L5:
        r100 = r100 | (nextValue() << 8);
        goto L6
    }

    @Override // java.util.Random
    public long nextLong() {
        return ((((((((((long) nextValue()) << 56) | 0) | (((long) nextValue()) << 48)) | (((long) nextValue()) << 40)) | (((long) nextValue()) << 32)) | (((long) nextValue()) << 24)) | (((long) nextValue()) << 16)) | (((long) nextValue()) << 8)) | ((long) nextValue());
    }
}
