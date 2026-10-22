package org.bouncycastle.crypto;

/* JADX INFO: loaded from: classes42.dex */
public abstract class StreamBlockCipher implements BlockCipher, StreamCipher {
    private final BlockCipher cipher;

    public StreamBlockCipher(BlockCipher r100) {
        this.cipher = r100;
    }

    public abstract byte calculateByte(byte r100);

    public BlockCipher getUnderlyingCipher() {
        return this.cipher;
    }

    @Override // org.bouncycastle.crypto.StreamCipher
    public int processBytes(byte[] r100, int r101, int r102, byte[] r103, int r104) throws DataLengthException {
        int r105 = r101 + r102;
        if (r105 > r100.length) goto L12;
        if ((r104 + r102) > r103.length) goto L10;
    L6:
        if (r101 >= r105) goto L8;
        int r106 = r101 + 1;
        r103[r104] = calculateByte(r100[r101]);
        r104 = r104 + 1;
        r101 = r106;
        goto L6
    L8:
        return r102;
    L10:
        throw new OutputLengthException("output buffer too short");
    L12:
        throw new DataLengthException("input buffer too small");
    }

    @Override // org.bouncycastle.crypto.StreamCipher
    public final byte returnByte(byte r100) {
        return calculateByte(r100);
    }
}
