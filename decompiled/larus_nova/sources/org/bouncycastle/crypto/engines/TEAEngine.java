package org.bouncycastle.crypto.engines;

import kotlin.UByte;
import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.params.KeyParameter;

/* JADX INFO: loaded from: classes42.dex */
public class TEAEngine implements BlockCipher {
    private static final int block_size = 8;
    private static final int d_sum = -957401312;
    private static final int delta = -1640531527;
    private static final int rounds = 32;
    private int _a;
    private int _b;
    private int _c;
    private int _d;
    private boolean _forEncryption;
    private boolean _initialised;

    public TEAEngine() {
        this._initialised = false;
    }

    private int bytesToInt(byte[] r100, int r101) {
        int r102 = r101 + 1;
        int r103 = r102 + 1;
        int r104 = (r100[r101] << 24) | ((r100[r102] & UByte.MAX_VALUE) << 16);
        int r105 = r103 + 1;
        int r106 = r104 | ((r100[r103] & UByte.MAX_VALUE) << 8);
        return (r100[r105] & UByte.MAX_VALUE) | r106;
    }

    private int decryptBlock(byte[] r100, int r101, byte[] r102, int r103) {
        int r104 = bytesToInt(r100, r101);
        int r105 = bytesToInt(r100, r101 + 4);
        int r106 = d_sum;
        int r107 = 0;
    L4:
        if (r107 == 32) goto L6;
        r105 = r105 - ((((r104 << 4) + this._c) ^ (r104 + r106)) ^ ((r104 >>> 5) + this._d));
        r104 = r104 - ((((r105 << 4) + this._a) ^ (r105 + r106)) ^ ((r105 >>> 5) + this._b));
        r106 = r106 + 1640531527;
        r107 = r107 + 1;
        goto L4
    L6:
        unpackInt(r104, r102, r103);
        unpackInt(r105, r102, r103 + 4);
        return 8;
    }

    private int encryptBlock(byte[] r100, int r101, byte[] r102, int r103) {
        int r104 = bytesToInt(r100, r101);
        int r105 = bytesToInt(r100, r101 + 4);
        int r106 = 0;
        int r107 = r104;
        int r108 = 0;
    L4:
        if (r106 == 32) goto L6;
        r108 = r108 - 1640531527;
        r107 = r107 + ((((r105 << 4) + this._a) ^ (r105 + r108)) ^ ((r105 >>> 5) + this._b));
        r105 = r105 + ((((r107 << 4) + this._c) ^ (r107 + r108)) ^ ((r107 >>> 5) + this._d));
        r106 = r106 + 1;
        goto L4
    L6:
        unpackInt(r107, r102, r103);
        unpackInt(r105, r102, r103 + 4);
        return 8;
    }

    private void setKey(byte[] r100) {
        if (r100.length != 16) goto L7;
        this._a = bytesToInt(r100, 0);
        this._b = bytesToInt(r100, 4);
        this._c = bytesToInt(r100, 8);
        this._d = bytesToInt(r100, 12);
        return;
    L7:
        throw new IllegalArgumentException("Key size must be 128 bits.");
    }

    private void unpackInt(int r100, byte[] r101, int r102) {
        int r103 = r102 + 1;
        r101[r102] = (byte) (r100 >>> 24);
        int r104 = r103 + 1;
        r101[r103] = (byte) (r100 >>> 16);
        r101[r104] = (byte) (r100 >>> 8);
        r101[r104 + 1] = (byte) r100;
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public String getAlgorithmName() {
        return "TEA";
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public int getBlockSize() {
        return 8;
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public void init(boolean r100, CipherParameters r101) {
        if ((r101 instanceof KeyParameter) == false) goto L7;
        this._forEncryption = r100;
        this._initialised = true;
        setKey(((KeyParameter) r101).getKey());
        return;
    L7:
        throw new IllegalArgumentException("invalid parameter passed to TEA init - ".concat(r101.getClass().getName()));
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public int processBlock(byte[] r100, int r101, byte[] r102, int r103) {
        if (this._initialised == false) goto L18;
        if ((r101 + 8) > r100.length) goto L16;
        if ((r103 + 8) > r102.length) goto L14;
        if (this._forEncryption == false) goto L12;
        return encryptBlock(r100, r101, r102, r103);
    L12:
        return decryptBlock(r100, r101, r102, r103);
    L14:
        throw new OutputLengthException("output buffer too short");
    L16:
        throw new DataLengthException("input buffer too short");
    L18:
        throw new IllegalStateException(getAlgorithmName() + " not initialised");
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public void reset() {
    }
}
