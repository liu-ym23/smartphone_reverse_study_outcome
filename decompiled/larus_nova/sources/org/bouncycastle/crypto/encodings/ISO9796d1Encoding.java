package org.bouncycastle.crypto.encodings;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import java.math.BigInteger;
import kotlin.UByte;
import kotlin.jvm.internal.ByteCompanionObject;
import org.bouncycastle.crypto.AsymmetricBlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.crypto.params.RSAKeyParameters;

/* JADX INFO: loaded from: classes42.dex */
public class ISO9796d1Encoding implements AsymmetricBlockCipher {
    private static final BigInteger SIX = null;
    private static final BigInteger SIXTEEN = null;
    private static byte[] inverse;
    private static byte[] shadows;
    private int bitSize;
    private AsymmetricBlockCipher engine;
    private boolean forEncryption;
    private BigInteger modulus;
    private int padBits;

    static {
        SIXTEEN = BigInteger.valueOf(16);
        SIX = BigInteger.valueOf(6);
        shadows = new byte[]{14, 3, 5, 8, 9, 4, 2, 15, 0, HTTP.CR, 11, 6, 7, 10, 12, 1};
        inverse = new byte[]{8, 15, 6, 1, 5, 2, 11, 12, 3, 4, HTTP.CR, 10, 14, 9, 0, 7};
    }

    public ISO9796d1Encoding(AsymmetricBlockCipher r100) {
        this.padBits = 0;
        this.engine = r100;
    }

    private static byte[] convertOutputDecryptOnly(BigInteger r100) {
        byte[] r101 = r100.toByteArray();
        if (r101[0] != 0) goto L6;
        int r102 = r101.length - 1;
        byte[] r103 = new byte[r102];
        System.arraycopy(r101, 1, r103, 0, r102);
        return r103;
    L6:
        return r101;
    }

    private byte[] decodeBlock(byte[] r110, int r111, int r112) throws InvalidCipherTextException {
        byte[] r113 = this.engine.processBlock(r110, r111, r112);
        int r114 = (this.bitSize + 13) / 16;
        BigInteger r115 = new BigInteger(1, r113);
        BigInteger r116 = SIXTEEN;
        BigInteger r100 = r115.mod(r116);
        BigInteger r101 = SIX;
        if (r100.equals(r101) == false) goto L6;
    L8:
        byte[] r117 = convertOutputDecryptOnly(r115);
        if ((r117[r117.length - 1] & 15) != 6) goto L26;
        r117[r117.length - 1] = (byte) (((r117[r117.length - 1] & UByte.MAX_VALUE) >>> 4) | (inverse[(r117[r117.length - 2] & UByte.MAX_VALUE) >> 4] << 4));
        byte[] r118 = shadows;
        byte r102 = r117[1];
        byte r119 = (byte) (r118[r102 & 15] | (r118[(r102 & UByte.MAX_VALUE) >>> 4] << 4));
        int r103 = 0;
        r117[0] = r119;
        int r120 = r117.length - 1;
        int r104 = 0;
        boolean r105 = false;
        int r106 = 1;
    L12:
        if (r120 < (r117.length - (r114 * 2))) goto L20;
        byte[] r107 = shadows;
        byte r108 = r117[r120];
        int r109 = r107[r108 & 15] | (r107[(r108 & UByte.MAX_VALUE) >>> 4] << 4);
        int r121 = r120 - 1;
        byte r122 = r117[r121];
        if (((r122 ^ r109) & 255) == 0) goto L19;
        if (r105 == true) goto L18;
        r106 = (r122 ^ r109) & 255;
        r104 = r121;
        r105 = true;
        goto L19
    L18:
        throw new InvalidCipherTextException("invalid tsums in block");
    L19:
        r120 = r120 - 2;
        goto L12
    L20:
        r117[r104] = 0;
        int r123 = (r117.length - r104) / 2;
        byte[] r124 = new byte[r123];
    L21:
        if (r103 >= r123) goto L23;
        r124[r103] = r117[((r103 * 2) + r104) + 1];
        r103 = r103 + 1;
        goto L21
    L23:
        this.padBits = r106 - 1;
        return r124;
    L26:
        throw new InvalidCipherTextException("invalid forcing byte in block");
    L6:
        if (this.modulus.subtract(r115).mod(r116).equals(r101) == false) goto L28;
        r115 = this.modulus.subtract(r115);
        goto L8
    L28:
        throw new InvalidCipherTextException("resulting integer iS or (modulus - iS) is not congruent to 6 mod 16");
    }

    private byte[] encodeBlock(byte[] r110, int r111, int r112) throws InvalidCipherTextException {
        int r100 = this.bitSize;
        int r101 = (r100 + 7) / 8;
        byte[] r102 = new byte[r101];
        int r103 = 1;
        int r104 = this.padBits + 1;
        int r105 = (r100 + 13) / 16;
        int r106 = 0;
    L3:
        if (r106 >= r105) goto L9;
        if (r106 <= (r105 - r112)) goto L7;
        int r107 = r105 - r106;
        System.arraycopy(r110, (r111 + r112) - r107, r102, r101 - r105, r107);
    L8:
        r106 = r106 + r112;
        goto L3
    L7:
        System.arraycopy(r110, r111, r102, r101 - (r106 + r112), r112);
        goto L8
    L9:
        int r113 = r101 - (r105 * 2);
    L10:
        if (r113 == r101) goto L12;
        byte r114 = r102[(r101 - r105) + (r113 / 2)];
        byte[] r108 = shadows;
        r102[r113] = (byte) (r108[r114 & 15] | (r108[(r114 & UByte.MAX_VALUE) >>> 4] << 4));
        r102[r113 + 1] = r114;
        r113 = r113 + 2;
        goto L10
    L12:
        int r115 = r101 - (r112 * 2);
        r102[r115] = (byte) (r102[r115] ^ r104);
        int r116 = r101 - 1;
        r102[r116] = (byte) ((r102[r116] << 4) | 6);
        int r117 = 8 - ((this.bitSize - 1) % 8);
        if (r117 == 8) goto L15;
        byte r118 = (byte) (r102[0] & (255 >>> r117));
        r102[0] = r118;
        r102[0] = (byte) ((128 >>> r117) | r118);
        r103 = 0;
    L17:
        return this.engine.processBlock(r102, r103, r101 - r103);
    L15:
        r102[0] = 0;
        r102[1] = (byte) (r102[1] | ByteCompanionObject.MIN_VALUE);
        goto L17
    }

    @Override // org.bouncycastle.crypto.AsymmetricBlockCipher
    public int getInputBlockSize() {
        int r100 = this.engine.getInputBlockSize();
        if (this.forEncryption == true) goto L5;
        return r100;
    L5:
        return (r100 + 1) / 2;
    }

    @Override // org.bouncycastle.crypto.AsymmetricBlockCipher
    public int getOutputBlockSize() {
        int r100 = this.engine.getOutputBlockSize();
        if (this.forEncryption == false) goto L6;
        return r100;
    L6:
        return (r100 + 1) / 2;
    }

    public int getPadBits() {
        return this.padBits;
    }

    public AsymmetricBlockCipher getUnderlyingCipher() {
        return this.engine;
    }

    @Override // org.bouncycastle.crypto.AsymmetricBlockCipher
    public void init(boolean r100, CipherParameters r101) {
        if ((r101 instanceof ParametersWithRandom) == false) goto L5;
        RSAKeyParameters r102 = (RSAKeyParameters) ((ParametersWithRandom) r101).getParameters();
    L6:
        this.engine.init(r100, r101);
        BigInteger r103 = r102.getModulus();
        this.modulus = r103;
        this.bitSize = r103.bitLength();
        this.forEncryption = r100;
        return;
    L5:
        r102 = (RSAKeyParameters) r101;
        goto L6
    }

    @Override // org.bouncycastle.crypto.AsymmetricBlockCipher
    public byte[] processBlock(byte[] r100, int r101, int r102) throws InvalidCipherTextException {
        if (this.forEncryption == false) goto L7;
        return encodeBlock(r100, r101, r102);
    L7:
        return decodeBlock(r100, r101, r102);
    }

    public void setPadBits(int r100) {
        if (r100 > 7) goto L7;
        this.padBits = r100;
        return;
    L7:
        throw new IllegalArgumentException("padBits > 7");
    }
}
