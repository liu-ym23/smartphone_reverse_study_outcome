package org.bouncycastle.crypto.engines;

import kotlin.UByte;
import kotlin.jvm.internal.ByteCompanionObject;
import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.signers.PSSSigner;
import org.bouncycastle.util.Integers;
import org.bouncycastle.util.Pack;

/* JADX INFO: loaded from: classes42.dex */
public class NoekeonEngine implements BlockCipher {
    private static final int SIZE = 16;
    private static final byte[] roundConstants = null;
    private boolean _forEncryption;
    private boolean _initialised;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final int[] f525194k;

    static {
        roundConstants = new byte[]{ByteCompanionObject.MIN_VALUE, 27, 54, 108, -40, -85, 77, -102, 47, 94, PSSSigner.TRAILER_IMPLICIT, 99, -58, -105, 53, 106, -44};
    }

    public NoekeonEngine() {
        this.f525194k = new int[4];
        this._initialised = false;
    }

    private int decryptBlock(byte[] r210, int r211, byte[] r212, int r213) {
        int r100 = Pack.bigEndianToInt(r210, r211);
        int r101 = Pack.bigEndianToInt(r210, r211 + 4);
        int r102 = Pack.bigEndianToInt(r210, r211 + 8);
        int r103 = Pack.bigEndianToInt(r210, r211 + 12);
        int[] r104 = this.f525194k;
        int r105 = r104[0];
        int r110 = r104[1];
        int r111 = r104[2];
        int r106 = r104[3];
        int r112 = 16;
    L3:
        int r113 = r100 ^ r102;
        int r114 = r113 ^ (Integers.rotateLeft(r113, 8) ^ Integers.rotateLeft(r113, 24));
        int r107 = (r101 ^ r114) ^ r110;
        int r108 = (r103 ^ r114) ^ r106;
        int r115 = r107 ^ r108;
        int r109 = (Integers.rotateLeft(r115, 24) ^ Integers.rotateLeft(r115, 8)) ^ r115;
        int r116 = (r102 ^ r111) ^ r109;
        int r117 = ((r100 ^ r105) ^ r109) ^ (roundConstants[r112] & UByte.MAX_VALUE);
        r112 = r112 - 1;
        if (r112 < 0) goto L5;
        int r118 = Integers.rotateLeft(r107, 1);
        int r119 = Integers.rotateLeft(r116, 5);
        int r120 = Integers.rotateLeft(r108, 2);
        int r121 = r118 ^ ((~r119) & (~r120));
        int r122 = r117 ^ (r119 & r121);
        int r123 = r119 ^ ((r120 ^ r121) ^ r122);
        int r124 = r121 ^ ((~r122) & (~r123));
        int r125 = r120 ^ (r123 & r124);
        r101 = Integers.rotateLeft(r124, 31);
        r102 = Integers.rotateLeft(r123, 27);
        int r126 = Integers.rotateLeft(r122, 30);
        r100 = r125;
        r103 = r126;
        goto L3
    L5:
        Pack.intToBigEndian(r117, r212, r213);
        Pack.intToBigEndian(r107, r212, r213 + 4);
        Pack.intToBigEndian(r116, r212, r213 + 8);
        Pack.intToBigEndian(r108, r212, r213 + 12);
        return 16;
    }

    private int encryptBlock(byte[] r210, int r211, byte[] r212, int r213) {
        int r100 = Pack.bigEndianToInt(r210, r211);
        int r101 = Pack.bigEndianToInt(r210, r211 + 4);
        int r102 = Pack.bigEndianToInt(r210, r211 + 8);
        int r103 = Pack.bigEndianToInt(r210, r211 + 12);
        int[] r104 = this.f525194k;
        int r105 = 0;
        int r106 = r104[0];
        int r110 = r104[1];
        int r111 = r104[2];
        int r107 = r104[3];
    L3:
        int r108 = r100 ^ (roundConstants[r105] & UByte.MAX_VALUE);
        int r112 = r108 ^ r102;
        int r113 = r112 ^ (Integers.rotateLeft(r112, 8) ^ Integers.rotateLeft(r112, 24));
        int r109 = (r101 ^ r113) ^ r110;
        int r114 = (r103 ^ r113) ^ r107;
        int r115 = r109 ^ r114;
        int r116 = Integers.rotateLeft(r115, 8);
        int r117 = (Integers.rotateLeft(r115, 24) ^ r116) ^ r115;
        int r118 = (r108 ^ r106) ^ r117;
        int r119 = (r102 ^ r111) ^ r117;
        r105 = r105 + 1;
        if (r105 > 16) goto L5;
        int r120 = Integers.rotateLeft(r109, 1);
        int r121 = Integers.rotateLeft(r119, 5);
        int r122 = Integers.rotateLeft(r114, 2);
        int r123 = r120 ^ ((~r122) & (~r121));
        int r124 = r118 ^ (r121 & r123);
        int r125 = r121 ^ ((r122 ^ r123) ^ r124);
        int r126 = r123 ^ ((~r124) & (~r125));
        int r127 = r122 ^ (r125 & r126);
        r101 = Integers.rotateLeft(r126, 31);
        r102 = Integers.rotateLeft(r125, 27);
        int r128 = Integers.rotateLeft(r124, 30);
        r100 = r127;
        r103 = r128;
        goto L3
    L5:
        Pack.intToBigEndian(r118, r212, r213);
        Pack.intToBigEndian(r109, r212, r213 + 4);
        Pack.intToBigEndian(r119, r212, r213 + 8);
        Pack.intToBigEndian(r114, r212, r213 + 12);
        return 16;
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public String getAlgorithmName() {
        return "Noekeon";
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public int getBlockSize() {
        return 16;
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public void init(boolean r110, CipherParameters r111) {
        if ((r111 instanceof KeyParameter) == false) goto L9;
        this._forEncryption = r110;
        this._initialised = true;
        Pack.bigEndianToInt(((KeyParameter) r111).getKey(), 0, this.f525194k, 0, 4);
        if (r110 == true) goto L10;
        int[] r112 = this.f525194k;
        int r113 = r112[0];
        int r100 = r112[1];
        int r101 = r112[2];
        int r114 = r112[3];
        int r102 = r113 ^ r101;
        int r103 = r102 ^ (Integers.rotateLeft(r102, 8) ^ Integers.rotateLeft(r102, 24));
        int r104 = r100 ^ r103;
        int r115 = r114 ^ r103;
        int r105 = r104 ^ r115;
        int r106 = r105 ^ (Integers.rotateLeft(r105, 8) ^ Integers.rotateLeft(r105, 24));
        int r116 = r113 ^ r106;
        int r107 = r101 ^ r106;
        int[] r108 = this.f525194k;
        r108[0] = r116;
        r108[1] = r104;
        r108[2] = r107;
        r108[3] = r115;
        return;
    L10:
        return;
    L9:
        throw new IllegalArgumentException("invalid parameter passed to Noekeon init - ".concat(r111.getClass().getName()));
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public int processBlock(byte[] r100, int r101, byte[] r102, int r103) {
        if (this._initialised == false) goto L18;
        if (r101 > (r100.length - 16)) goto L16;
        if (r103 > (r102.length - 16)) goto L14;
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
