package org.bouncycastle.crypto.prng.drbg;

import com.bytedance.crypto.utils.CryptoConst;
import kotlin.UByte;
import kotlin.jvm.internal.ByteCompanionObject;
import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.prng.EntropySource;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.encoders.Hex;

/* JADX INFO: loaded from: classes42.dex */
public class CTRSP800DRBG implements SP80090DRBG {
    private static final int AES_MAX_BITS_REQUEST = 262144;
    private static final long AES_RESEED_MAX = 140737488355328L;
    private static final byte[] K_BITS = null;
    private static final int TDEA_MAX_BITS_REQUEST = 4096;
    private static final long TDEA_RESEED_MAX = 2147483648L;
    private byte[] _Key;
    private byte[] _V;
    private BlockCipher _engine;
    private EntropySource _entropySource;
    private boolean _isTDEA;
    private int _keySizeInBits;
    private long _reseedCounter;
    private int _securityStrength;
    private int _seedLength;

    static {
        K_BITS = Hex.decodeStrict("000102030405060708090A0B0C0D0E0F101112131415161718191A1B1C1D1E1F");
    }

    public CTRSP800DRBG(BlockCipher r100, int r101, int r102, EntropySource r103, byte[] r104, byte[] r105) {
        this._reseedCounter = 0;
        this._isTDEA = false;
        this._entropySource = r103;
        this._engine = r100;
        this._keySizeInBits = r101;
        this._securityStrength = r102;
        this._seedLength = (r100.getBlockSize() * 8) + r101;
        this._isTDEA = isTDEA(r100);
        if (r102 > 256) goto L15;
        if (getMaxSecurityStrength(r100, r101) < r102) goto L13;
        if (r103.entropySize() < r102) goto L11;
        CTR_DRBG_Instantiate_algorithm(getEntropy(), r105, r104);
        return;
    L11:
        throw new IllegalArgumentException("Not enough entropy for security strength required");
    L13:
        throw new IllegalArgumentException("Requested security strength is not supported by block cipher and key size");
    L15:
        throw new IllegalArgumentException("Requested security strength is not supported by the derivation function");
    }

    private void BCC(byte[] r100, byte[] r101, byte[] r102, byte[] r110) {
        int r103 = this._engine.getBlockSize();
        byte[] r104 = new byte[r103];
        int r105 = r110.length / r103;
        byte[] r106 = new byte[r103];
        this._engine.init(true, new KeyParameter(expandKey(r101)));
        this._engine.processBlock(r102, 0, r104, 0);
        int r107 = 0;
    L3:
        if (r107 >= r105) goto L5;
        XOR(r106, r104, r110, r107 * r103);
        this._engine.processBlock(r106, 0, r104, 0);
        r107 = r107 + 1;
        goto L3
    L5:
        System.arraycopy(r104, 0, r100, 0, r100.length);
    }

    private byte[] Block_Cipher_df(byte[] r110, int r111) {
        int r100 = this._engine.getBlockSize();
        int r101 = r110.length;
        int r102 = r111 / 8;
        int r103 = r101 + 8;
        byte[] r104 = new byte[((((r103 + 1) + r100) - 1) / r100) * r100];
        copyIntToByteArray(r104, r101, 0);
        copyIntToByteArray(r104, r102, 4);
        System.arraycopy(r110, 0, r104, 8, r101);
        r104[r103] = ByteCompanionObject.MIN_VALUE;
        int r105 = this._keySizeInBits;
        int r106 = (r105 / 8) + r100;
        byte[] r107 = new byte[r106];
        byte[] r112 = new byte[r100];
        byte[] r113 = new byte[r100];
        int r108 = r105 / 8;
        byte[] r109 = new byte[r108];
        System.arraycopy(K_BITS, 0, r109, 0, r108);
        int r114 = 0;
    L3:
        int r115 = r114 * r100;
        if ((r115 * 8) >= (this._keySizeInBits + (r100 * 8))) goto L9;
        copyIntToByteArray(r113, r114, 0);
        BCC(r112, r109, r113, r104);
        int r116 = r106 - r115;
        if (r116 <= r100) goto L8;
        r116 = r100;
    L8:
        System.arraycopy(r112, 0, r107, r115, r116);
        r114 = r114 + 1;
        goto L3
    L9:
        byte[] r117 = new byte[r100];
        System.arraycopy(r107, 0, r109, 0, r108);
        System.arraycopy(r107, r108, r117, 0, r100);
        byte[] r118 = new byte[r102];
        this._engine.init(true, new KeyParameter(expandKey(r109)));
        int r119 = 0;
    L10:
        int r120 = r119 * r100;
        if (r120 >= r102) goto L16;
        this._engine.processBlock(r117, 0, r117, 0);
        int r121 = r102 - r120;
        if (r121 <= r100) goto L15;
        r121 = r100;
    L15:
        System.arraycopy(r117, 0, r118, r120, r121);
        r119 = r119 + 1;
        goto L10
    L16:
        return r118;
    }

    private void CTR_DRBG_Instantiate_algorithm(byte[] r100, byte[] r101, byte[] r102) {
        byte[] r103 = Block_Cipher_df(Arrays.concatenate(r100, r101, r102), this._seedLength);
        int r104 = this._engine.getBlockSize();
        byte[] r105 = new byte[(this._keySizeInBits + 7) / 8];
        this._Key = r105;
        byte[] r106 = new byte[r104];
        this._V = r106;
        CTR_DRBG_Update(r103, r105, r106);
        this._reseedCounter = 1;
    }

    private void CTR_DRBG_Reseed_algorithm(byte[] r100) {
        CTR_DRBG_Update(Block_Cipher_df(Arrays.concatenate(getEntropy(), r100), this._seedLength), this._Key, this._V);
        this._reseedCounter = 1;
    }

    private void CTR_DRBG_Update(byte[] r100, byte[] r110, byte[] r111) {
        int r101 = r100.length;
        byte[] r102 = new byte[r101];
        byte[] r103 = new byte[this._engine.getBlockSize()];
        int r104 = this._engine.getBlockSize();
        this._engine.init(true, new KeyParameter(expandKey(r110)));
        int r105 = 0;
    L3:
        int r106 = r105 * r104;
        if (r106 >= r100.length) goto L9;
        addOneTo(r111);
        this._engine.processBlock(r111, 0, r103, 0);
        int r107 = r101 - r106;
        if (r107 <= r104) goto L8;
        r107 = r104;
    L8:
        System.arraycopy(r103, 0, r102, r106, r107);
        r105 = r105 + 1;
        goto L3
    L9:
        XOR(r102, r100, r102, 0);
        System.arraycopy(r102, 0, r110, 0, r110.length);
        System.arraycopy(r102, r110.length, r111, 0, r111.length);
    }

    private void XOR(byte[] r100, byte[] r101, byte[] r102, int r103) {
        int r104 = 0;
    L4:
        if (r104 >= r100.length) goto L6;
        r100[r104] = (byte) (r101[r104] ^ r102[r104 + r103]);
        r104 = r104 + 1;
        goto L4
    }

    private void addOneTo(byte[] r100) {
        int r101 = 1;
        int r102 = 1;
    L4:
        if (r101 > r100.length) goto L10;
        int r103 = (r100[r100.length - r101] & UByte.MAX_VALUE) + r102;
        if (r103 <= 255) goto L8;
        r102 = 1;
    L9:
        r100[r100.length - r101] = (byte) r103;
        r101 = r101 + 1;
        goto L4
    L8:
        r102 = 0;
        goto L9
    }

    private void copyIntToByteArray(byte[] r100, int r101, int r102) {
        r100[r102 + 0] = (byte) (r101 >> 24);
        r100[r102 + 1] = (byte) (r101 >> 16);
        r100[r102 + 2] = (byte) (r101 >> 8);
        r100[r102 + 3] = (byte) r101;
    }

    private byte[] getEntropy() {
        byte[] r100 = this._entropySource.getEntropy();
        if (r100.length < ((this._securityStrength + 7) / 8)) goto L6;
        return r100;
    L6:
        throw new IllegalStateException("Insufficient entropy provided by entropy source");
    }

    private int getMaxSecurityStrength(BlockCipher r100, int r101) {
        if (isTDEA(r100) == false) goto L9;
        if (r101 != 168) goto L9;
        return 112;
    L9:
        if (r100.getAlgorithmName().equals(CryptoConst.ALGORITHM_AES) == false) goto L11;
        return r101;
    L11:
        return -1;
    }

    private boolean isTDEA(BlockCipher r100) {
        if (r100.getAlgorithmName().equals("DESede") == false) goto L5;
    L8:
        return true;
    L5:
        if (r100.getAlgorithmName().equals("TDEA") == true) goto L8;
        return false;
    }

    private void padKey(byte[] r100, int r101, byte[] r102, int r103) {
        int r104 = r101 + 0;
        r102[r103 + 0] = (byte) (r100[r104] & 254);
        int r105 = r101 + 1;
        r102[r103 + 1] = (byte) ((r100[r104] << 7) | ((r100[r105] & 252) >>> 1));
        int r106 = r100[r105] << 6;
        int r107 = r101 + 2;
        r102[r103 + 2] = (byte) (r106 | ((r100[r107] & 248) >>> 2));
        int r108 = r100[r107] << 5;
        int r109 = r101 + 3;
        r102[r103 + 3] = (byte) (r108 | ((r100[r109] & 240) >>> 3));
        int r110 = r100[r109] << 4;
        int r111 = r101 + 4;
        r102[r103 + 4] = (byte) (r110 | ((r100[r111] & 224) >>> 4));
        int r112 = r100[r111] << 3;
        int r113 = r101 + 5;
        r102[r103 + 5] = (byte) (r112 | ((r100[r113] & 192) >>> 5));
        int r114 = r101 + 6;
        r102[r103 + 6] = (byte) ((r100[r113] << 2) | ((r100[r114] & ByteCompanionObject.MIN_VALUE) >>> 6));
        int r115 = r103 + 7;
        r102[r115] = (byte) (r100[r114] << 1);
    L3:
        if (r103 > r115) goto L5;
        byte r116 = r102[r103];
        int r117 = r116 & 254;
        int r118 = (((((r116 >> 1) ^ (r116 >> 2)) ^ (r116 >> 3)) ^ (r116 >> 4)) ^ (r116 >> 5)) ^ (r116 >> 6);
        r102[r103] = (byte) (((((r116 >> 7) ^ r118) ^ 1) & 1) | r117);
        r103 = r103 + 1;
        goto L3
    }

    public byte[] expandKey(byte[] r100) {
        if (this._isTDEA == false) goto L6;
        byte[] r101 = new byte[24];
        padKey(r100, 0, r101, 0);
        padKey(r100, 7, r101, 8);
        padKey(r100, 14, r101, 16);
        return r101;
    L6:
        return r100;
    }

    @Override // org.bouncycastle.crypto.prng.drbg.SP80090DRBG
    public int generate(byte[] r100, byte[] r101, boolean r110) {
        boolean r102 = this._isTDEA;
        long r103 = this._reseedCounter;
        if (r102 == false) goto L13;
        if (r103 <= 2147483648L) goto L8;
        return -1;
    L8:
        if (Utils.isTooLarge(r100, 512) == true) goto L11;
    L17:
        if (r110 == false) goto L19;
        CTR_DRBG_Reseed_algorithm(r101);
        r101 = null;
    L19:
        if (r101 == null) goto L21;
        byte[] r104 = Block_Cipher_df(r101, this._seedLength);
        CTR_DRBG_Update(r104, this._Key, this._V);
    L22:
        int r111 = this._V.length;
        byte[] r105 = new byte[r111];
        this._engine.init(true, new KeyParameter(expandKey(this._Key)));
        int r106 = 0;
    L24:
        if (r106 > (r100.length / r111)) goto L32;
        int r107 = r106 * r111;
        if ((r100.length - r107) <= r111) goto L28;
        int r108 = r111;
    L29:
        if (r108 == 0) goto L31;
        addOneTo(this._V);
        this._engine.processBlock(this._V, 0, r105, 0);
        System.arraycopy(r105, 0, r100, r107, r108);
    L31:
        r106 = r106 + 1;
        goto L24
    L28:
        r108 = r100.length - (this._V.length * r106);
        goto L29
    L32:
        CTR_DRBG_Update(r104, this._Key, this._V);
        this._reseedCounter++;
        return r100.length * 8;
    L21:
        r104 = new byte[this._seedLength / 8];
        goto L22
    L11:
        throw new IllegalArgumentException("Number of bits per request limited to 4096");
    L13:
        if (r103 <= AES_RESEED_MAX) goto L16;
        return -1;
    L16:
        if (Utils.isTooLarge(r100, 32768) == false) goto L17;
        throw new IllegalArgumentException("Number of bits per request limited to 262144");
    }

    @Override // org.bouncycastle.crypto.prng.drbg.SP80090DRBG
    public int getBlockSize() {
        return this._V.length * 8;
    }

    @Override // org.bouncycastle.crypto.prng.drbg.SP80090DRBG
    public void reseed(byte[] r100) {
        CTR_DRBG_Reseed_algorithm(r100);
    }
}
