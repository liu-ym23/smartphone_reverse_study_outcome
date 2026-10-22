package org.bouncycastle.crypto.digests;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import kotlin.UByte;
import kotlin.io.encoding.Base64;
import kotlin.jvm.internal.ByteCompanionObject;
import org.bouncycastle.crypto.ExtendedDigest;
import org.bouncycastle.crypto.signers.PSSSigner;
import org.bouncycastle.util.Memoable;

/* JADX INFO: loaded from: classes42.dex */
public class MD2Digest implements ExtendedDigest, Memoable {
    private static final int DIGEST_LENGTH = 16;
    private static final byte[] S = null;
    private byte[] C;
    private int COff;
    private byte[] M;
    private byte[] X;
    private int mOff;
    private int xOff;

    static {
        S = new byte[]{41, 46, 67, -55, -94, -40, 124, 1, Base64.padSymbol, 54, 84, -95, -20, -16, 6, 19, 98, -89, 5, -13, -64, -57, 115, -116, -104, -109, 43, -39, PSSSigner.TRAILER_IMPLICIT, 76, -126, -54, 30, -101, 87, 60, -3, -44, -32, 22, 103, 66, 111, 24, -118, 23, -27, 18, -66, 78, -60, -42, -38, -98, -34, 73, -96, -5, -11, -114, -69, 47, -18, 122, -87, 104, 121, -111, 21, -78, 7, 63, -108, -62, 16, -119, 11, 34, 95, 33, ByteCompanionObject.MIN_VALUE, ByteCompanionObject.MAX_VALUE, 93, -102, 90, -112, 50, 39, 53, 62, -52, -25, -65, -9, -105, 3, -1, 25, 48, -77, 72, -91, -75, -47, -41, 94, -110, 42, -84, 86, -86, -58, 79, -72, 56, -46, -106, -92, 125, -74, 118, -4, 107, -30, -100, 116, 4, -15, 69, -99, 112, 89, 100, 113, -121, 32, -122, 91, -49, 101, -26, 45, -88, 2, 27, 96, 37, -83, -82, -80, -71, -10, 28, 70, 97, 105, 52, 64, 126, 15, 85, 71, -93, 35, -35, 81, -81, 58, -61, 92, -7, -50, -70, -59, -22, 38, 44, 83, HTTP.CR, 110, -123, 40, -124, 9, -45, -33, -51, -12, 65, -127, 77, 82, 106, -36, 55, -56, 108, -63, -85, -6, 36, -31, 123, 8, 12, -67, -79, 74, 120, -120, -107, -117, -29, 99, -24, 109, -23, -53, -43, -2, 59, 0, 29, 57, -14, -17, -73, 14, 102, 88, -48, -28, -90, 119, 114, -8, -21, 117, 75, 10, 49, 68, 80, -76, -113, -19, 31, 26, -37, -103, -115, 51, -97, 17, -125, 20};
    }

    public MD2Digest() {
        this.X = new byte[48];
        this.M = new byte[16];
        this.C = new byte[16];
        reset();
    }

    public MD2Digest(MD2Digest r100) {
        this.X = new byte[48];
        this.M = new byte[16];
        this.C = new byte[16];
        copyIn(r100);
    }

    private void copyIn(MD2Digest r100) {
        byte[] r101 = r100.X;
        System.arraycopy(r101, 0, this.X, 0, r101.length);
        this.xOff = r100.xOff;
        byte[] r102 = r100.M;
        System.arraycopy(r102, 0, this.M, 0, r102.length);
        this.mOff = r100.mOff;
        byte[] r103 = r100.C;
        System.arraycopy(r103, 0, this.C, 0, r103.length);
        this.COff = r100.COff;
    }

    @Override // org.bouncycastle.util.Memoable
    public Memoable copy() {
        return new MD2Digest(this);
    }

    @Override // org.bouncycastle.crypto.Digest
    public int doFinal(byte[] r100, int r101) {
        int r102 = this.M.length;
        int r103 = this.mOff;
        byte r104 = (byte) (r102 - r103);
    L3:
        byte[] r105 = this.M;
        if (r103 >= r105.length) goto L6;
        r105[r103] = r104;
        r103 = r103 + 1;
        goto L3
    L6:
        processCheckSum(r105);
        processBlock(this.M);
        processBlock(this.C);
        System.arraycopy(this.X, this.xOff, r100, r101, 16);
        reset();
        return 16;
    }

    @Override // org.bouncycastle.crypto.Digest
    public String getAlgorithmName() {
        return "MD2";
    }

    @Override // org.bouncycastle.crypto.ExtendedDigest
    public int getByteLength() {
        return 16;
    }

    @Override // org.bouncycastle.crypto.Digest
    public int getDigestSize() {
        return 16;
    }

    public void processBlock(byte[] r100) {
        int r101 = 0;
    L4:
        if (r101 >= 16) goto L6;
        byte[] r102 = this.X;
        r102[r101 + 16] = r100[r101];
        r102[r101 + 32] = (byte) (r100[r101] ^ r102[r101]);
        r101 = r101 + 1;
        goto L4
    L6:
        int r103 = 0;
        int r104 = 0;
    L8:
        if (r103 >= 18) goto L14;
        int r105 = 0;
    L11:
        if (r105 >= 48) goto L13;
        byte[] r106 = this.X;
        byte r107 = r106[r105];
        byte r108 = (byte) (S[r104] ^ r107);
        r106[r105] = r108;
        r104 = r108 & UByte.MAX_VALUE;
        r105 = r105 + 1;
        goto L11
    L13:
        r104 = (r104 + r103) % 256;
        r103 = r103 + 1;
        goto L8
    }

    public void processCheckSum(byte[] r100) {
        byte r101 = this.C[15];
        int r102 = 0;
    L4:
        if (r102 >= 16) goto L6;
        byte[] r103 = this.C;
        byte r104 = r103[r102];
        r101 = (byte) (S[(r101 ^ r100[r102]) & 255] ^ r104);
        r103[r102] = r101;
        r102 = r102 + 1;
        goto L4
    }

    @Override // org.bouncycastle.crypto.Digest
    public void reset() {
        this.xOff = 0;
        int r100 = 0;
    L3:
        byte[] r101 = this.X;
        if (r100 == r101.length) goto L6;
        r101[r100] = 0;
        r100 = r100 + 1;
        goto L3
    L6:
        this.mOff = 0;
        int r102 = 0;
    L7:
        byte[] r103 = this.M;
        if (r102 == r103.length) goto L10;
        r103[r102] = 0;
        r102 = r102 + 1;
        goto L7
    L10:
        this.COff = 0;
        int r104 = 0;
    L11:
        byte[] r105 = this.C;
        if (r104 == r105.length) goto L14;
        r105[r104] = 0;
        r104 = r104 + 1;
        goto L11
    }

    @Override // org.bouncycastle.util.Memoable
    public void reset(Memoable r100) {
        copyIn((MD2Digest) r100);
    }

    @Override // org.bouncycastle.crypto.Digest
    public void update(byte r100) {
        byte[] r101 = this.M;
        int r102 = this.mOff;
        int r103 = r102 + 1;
        this.mOff = r103;
        r101[r102] = r100;
        if (r103 != 16) goto L6;
        processCheckSum(r101);
        processBlock(this.M);
        this.mOff = 0;
        return;
    }

    @Override // org.bouncycastle.crypto.Digest
    public void update(byte[] r100, int r101, int r102) {
    L3:
        if (this.mOff == 0) goto L7;
        if (r102 <= 0) goto L7;
        update(r100[r101]);
        r101 = r101 + 1;
        r102 = r102 - 1;
    L7:
        if (r102 <= 16) goto L9;
        System.arraycopy(r100, r101, this.M, 0, 16);
        processCheckSum(this.M);
        processBlock(this.M);
        r102 = r102 - 16;
        r101 = r101 + 16;
    L9:
        if (r102 <= 0) goto L11;
        update(r100[r101]);
        r101 = r101 + 1;
        r102 = r102 - 1;
        goto L9
    }
}
