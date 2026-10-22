package org.bouncycastle.jce.provider;

import kotlin.UByte;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.PBEParametersGenerator;
import org.bouncycastle.crypto.digests.MD5Digest;
import org.bouncycastle.crypto.digests.RIPEMD160Digest;
import org.bouncycastle.crypto.digests.SHA1Digest;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;

/* JADX INFO: loaded from: classes42.dex */
class OldPKCS12ParametersGenerator extends PBEParametersGenerator {
    public static final int IV_MATERIAL = 2;
    public static final int KEY_MATERIAL = 1;
    public static final int MAC_MATERIAL = 3;
    private Digest digest;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f525399u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f525400v;

    public OldPKCS12ParametersGenerator(Digest r100) {
        this.digest = r100;
        if ((r100 instanceof MD5Digest) == false) goto L7;
        this.f525399u = 16;
    L5:
        this.f525400v = 64;
        return;
    L7:
        if ((r100 instanceof SHA1Digest) == false) goto L10;
    L8:
        this.f525399u = 20;
        goto L5
    L10:
        if ((r100 instanceof RIPEMD160Digest) == true) goto L8;
        throw new IllegalArgumentException("Digest " + r100.getAlgorithmName() + " unsupported");
    }

    private void adjust(byte[] r100, int r101, byte[] r102) {
        int r103 = ((r102[r102.length - 1] & UByte.MAX_VALUE) + (r100[(r102.length + r101) - 1] & UByte.MAX_VALUE)) + 1;
        r100[(r102.length + r101) - 1] = (byte) r103;
        int r104 = r103 >>> 8;
        int r105 = r102.length - 2;
    L3:
        if (r105 < 0) goto L5;
        int r106 = r101 + r105;
        int r107 = r104 + ((r102[r105] & UByte.MAX_VALUE) + (r100[r106] & UByte.MAX_VALUE));
        r100[r106] = (byte) r107;
        r104 = r107 >>> 8;
        r105 = r105 - 1;
        goto L3
    }

    private byte[] generateDerivedKey(int r110, int r111) {
        int r100 = this.f525400v;
        byte[] r101 = new byte[r100];
        byte[] r102 = new byte[r111];
        int r103 = 0;
        int r104 = 0;
    L3:
        if (r104 == r100) goto L5;
        r101[r104] = (byte) r110;
        r104 = r104 + 1;
        goto L3
    L5:
        byte[] r105 = this.salt;
        if (r105 != null) goto L8;
    L12:
        byte[] r106 = new byte[0];
    L13:
        byte[] r107 = this.password;
        if (r107 != null) goto L16;
    L20:
        byte[] r108 = new byte[0];
    L21:
        int r109 = r106.length + r108.length;
        byte[] r112 = new byte[r109];
        System.arraycopy(r106, 0, r112, 0, r106.length);
        System.arraycopy(r108, 0, r112, r106.length, r108.length);
        int r113 = this.f525400v;
        byte[] r114 = new byte[r113];
        int r115 = this.f525399u;
        int r116 = ((r111 + r115) - 1) / r115;
        int r117 = 1;
    L22:
        if (r117 > r116) goto L38;
        int r118 = this.f525399u;
        byte[] r119 = new byte[r118];
        this.digest.update(r101, r103, r100);
        this.digest.update(r112, r103, r109);
        this.digest.doFinal(r119, r103);
        int r120 = 1;
    L25:
        if (r120 == this.iterationCount) goto L27;
        this.digest.update(r119, r103, r118);
        this.digest.doFinal(r119, r103);
        r120 = r120 + 1;
        goto L25
    L27:
        int r121 = 0;
    L28:
        if (r121 == r113) goto L30;
        r114[r117] = r119[r121 % r118];
        r121 = r121 + 1;
        goto L28
    L30:
        int r122 = 0;
    L31:
        int r123 = this.f525400v;
        if (r122 == (r109 / r123)) goto L34;
        adjust(r112, r123 * r122, r114);
        r122 = r122 + 1;
        goto L31
    L34:
        if (r117 != r116) goto L36;
        int r124 = r117 - 1;
        int r125 = this.f525399u;
        System.arraycopy(r119, 0, r102, r124 * r125, r111 - (r124 * r125));
    L37:
        r117 = r117 + 1;
        r103 = 0;
        goto L22
    L36:
        System.arraycopy(r119, 0, r102, (r117 - 1) * this.f525399u, r118);
        goto L37
    L38:
        return r102;
    L16:
        if (r107.length == 0) goto L20;
        int r126 = this.f525400v;
        int r127 = r126 * (((r107.length + r126) - 1) / r126);
        r108 = new byte[r127];
        int r128 = 0;
    L18:
        if (r128 == r127) goto L21;
        byte[] r129 = this.password;
        r108[r128] = r129[r128 % r129.length];
        r128 = r128 + 1;
        goto L18
    L8:
        if (r105.length == 0) goto L12;
        int r130 = this.f525400v;
        int r131 = r130 * (((r105.length + r130) - 1) / r130);
        r106 = new byte[r131];
        int r132 = 0;
    L10:
        if (r132 == r131) goto L13;
        byte[] r133 = this.salt;
        r106[r132] = r133[r132 % r133.length];
        r132 = r132 + 1;
        goto L10
    }

    @Override // org.bouncycastle.crypto.PBEParametersGenerator
    public CipherParameters generateDerivedMacParameters(int r100) {
        int r101 = r100 / 8;
        return new KeyParameter(generateDerivedKey(3, r101), 0, r101);
    }

    @Override // org.bouncycastle.crypto.PBEParametersGenerator
    public CipherParameters generateDerivedParameters(int r100) {
        int r101 = r100 / 8;
        return new KeyParameter(generateDerivedKey(1, r101), 0, r101);
    }

    @Override // org.bouncycastle.crypto.PBEParametersGenerator
    public CipherParameters generateDerivedParameters(int r100, int r101) {
        int r102 = r100 / 8;
        int r103 = r101 / 8;
        byte[] r104 = generateDerivedKey(1, r102);
        byte[] r105 = generateDerivedKey(2, r103);
        return new ParametersWithIV(new KeyParameter(r104, 0, r102), r105, 0, r103);
    }
}
