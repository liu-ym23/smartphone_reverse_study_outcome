package org.bouncycastle.crypto.generators;

import kotlin.UByte;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.ExtendedDigest;
import org.bouncycastle.crypto.PBEParametersGenerator;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;

/* JADX INFO: loaded from: classes42.dex */
public class PKCS12ParametersGenerator extends PBEParametersGenerator {
    public static final int IV_MATERIAL = 2;
    public static final int KEY_MATERIAL = 1;
    public static final int MAC_MATERIAL = 3;
    private Digest digest;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f525220u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f525221v;

    public PKCS12ParametersGenerator(Digest r100) {
        this.digest = r100;
        if ((r100 instanceof ExtendedDigest) == false) goto L7;
        this.f525220u = r100.getDigestSize();
        this.f525221v = ((ExtendedDigest) r100).getByteLength();
        return;
    L7:
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
        int r100 = this.f525221v;
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
        int r113 = this.f525221v;
        byte[] r114 = new byte[r113];
        int r115 = this.f525220u;
        int r116 = ((r111 + r115) - 1) / r115;
        byte[] r117 = new byte[r115];
        int r118 = 1;
    L22:
        if (r118 > r116) goto L38;
        this.digest.update(r101, r103, r100);
        this.digest.update(r112, r103, r109);
        this.digest.doFinal(r117, r103);
        int r119 = 1;
    L25:
        if (r119 >= this.iterationCount) goto L27;
        this.digest.update(r117, r103, r115);
        this.digest.doFinal(r117, r103);
        r119 = r119 + 1;
        goto L25
    L27:
        int r120 = 0;
    L28:
        if (r120 == r113) goto L30;
        r114[r120] = r117[r120 % r115];
        r120 = r120 + 1;
        goto L28
    L30:
        int r121 = 0;
    L31:
        int r122 = this.f525221v;
        if (r121 == (r109 / r122)) goto L34;
        adjust(r112, r122 * r121, r114);
        r121 = r121 + 1;
        goto L31
    L34:
        if (r118 != r116) goto L36;
        int r123 = r118 - 1;
        int r124 = this.f525220u;
        System.arraycopy(r117, 0, r102, r123 * r124, r111 - (r123 * r124));
    L37:
        r118 = r118 + 1;
        r103 = 0;
        goto L22
    L36:
        System.arraycopy(r117, 0, r102, (r118 - 1) * this.f525220u, r115);
        goto L37
    L38:
        return r102;
    L16:
        if (r107.length == 0) goto L20;
        int r125 = this.f525221v;
        int r126 = r125 * (((r107.length + r125) - 1) / r125);
        r108 = new byte[r126];
        int r127 = 0;
    L18:
        if (r127 == r126) goto L21;
        byte[] r128 = this.password;
        r108[r127] = r128[r127 % r128.length];
        r127 = r127 + 1;
        goto L18
    L8:
        if (r105.length == 0) goto L12;
        int r129 = this.f525221v;
        int r130 = r129 * (((r105.length + r129) - 1) / r129);
        r106 = new byte[r130];
        int r131 = 0;
    L10:
        if (r131 == r130) goto L13;
        byte[] r132 = this.salt;
        r106[r131] = r132[r131 % r132.length];
        r131 = r131 + 1;
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
