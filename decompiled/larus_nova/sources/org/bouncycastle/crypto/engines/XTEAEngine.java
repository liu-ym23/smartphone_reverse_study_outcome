package org.bouncycastle.crypto.engines;

import kotlin.UByte;
import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.params.KeyParameter;

/* JADX INFO: loaded from: classes42.dex */
public class XTEAEngine implements BlockCipher {
    private static final int block_size = 8;
    private static final int delta = -1640531527;
    private static final int rounds = 32;
    private int[] _S;
    private boolean _forEncryption;
    private boolean _initialised;
    private int[] _sum0;
    private int[] _sum1;

    public XTEAEngine() {
        this._S = new int[4];
        this._sum0 = new int[32];
        this._sum1 = new int[32];
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
        int r106 = 31;
    L3:
        if (r106 < 0) goto L5;
        r105 = r105 - ((((r104 << 4) ^ (r104 >>> 5)) + r104) ^ this._sum1[r106]);
        r104 = r104 - ((((r105 << 4) ^ (r105 >>> 5)) + r105) ^ this._sum0[r106]);
        r106 = r106 - 1;
        goto L3
    L5:
        unpackInt(r104, r102, r103);
        unpackInt(r105, r102, r103 + 4);
        return 8;
    }

    private int encryptBlock(byte[] r100, int r101, byte[] r102, int r103) {
        int r104 = bytesToInt(r100, r101);
        int r105 = bytesToInt(r100, r101 + 4);
        int r106 = 0;
    L4:
        if (r106 >= 32) goto L6;
        r104 = r104 + ((((r105 << 4) ^ (r105 >>> 5)) + r105) ^ this._sum0[r106]);
        r105 = r105 + ((((r104 << 4) ^ (r104 >>> 5)) + r104) ^ this._sum1[r106]);
        r106 = r106 + 1;
        goto L4
    L6:
        unpackInt(r104, r102, r103);
        unpackInt(r105, r102, r103 + 4);
        return 8;
    }

    private void setKey(byte[] r100) {
        if (r100.length != 16) goto L14;
        int r101 = 0;
        int r102 = 0;
        int r103 = 0;
    L6:
        if (r102 >= 4) goto L8;
        this._S[r102] = bytesToInt(r100, r103);
        r102 = r102 + 1;
        r103 = r103 + 4;
        goto L6
    L8:
        int r104 = 0;
    L10:
        if (r101 >= 32) goto L12;
        int[] r105 = this._sum0;
        int[] r106 = this._S;
        r105[r101] = r106[r104 & 3] + r104;
        r104 = r104 - 1640531527;
        this._sum1[r101] = r106[(r104 >>> 11) & 3] + r104;
        r101 = r101 + 1;
        goto L10
    L12:
        return;
    L14:
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
        return "XTEA";
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
