package org.bouncycastle.crypto.engines;

import java.security.SecureRandom;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.CryptoServicesRegistrar;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.Wrapper;
import org.bouncycastle.crypto.modes.CBCBlockCipher;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.crypto.util.DigestFactory;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes42.dex */
public class DESedeWrapEngine implements Wrapper {
    private static final byte[] IV2 = null;
    byte[] digest;
    private CBCBlockCipher engine;
    private boolean forWrapping;

    /* JADX INFO: renamed from: iv, reason: collision with root package name */
    private byte[] f525180iv;
    private KeyParameter param;
    private ParametersWithIV paramPlusIV;
    Digest sha1;

    static {
        IV2 = new byte[]{74, -35, -94, 44, 121, -24, 33, 5};
    }

    public DESedeWrapEngine() {
        this.sha1 = DigestFactory.createSHA1();
        this.digest = new byte[20];
    }

    private byte[] calculateCMSKeyChecksum(byte[] r100) {
        byte[] r101 = new byte[8];
        this.sha1.update(r100, 0, r100.length);
        this.sha1.doFinal(this.digest, 0);
        System.arraycopy(this.digest, 0, r101, 0, 8);
        return r101;
    }

    private boolean checkCMSKeyChecksum(byte[] r100, byte[] r101) {
        return Arrays.constantTimeAreEqual(calculateCMSKeyChecksum(r100), r101);
    }

    private static byte[] reverse(byte[] r100) {
        byte[] r101 = new byte[r100.length];
        int r102 = 0;
    L4:
        if (r102 >= r100.length) goto L6;
        int r103 = r102 + 1;
        r101[r102] = r100[r100.length - r103];
        r102 = r103;
        goto L4
    L6:
        return r101;
    }

    @Override // org.bouncycastle.crypto.Wrapper
    public String getAlgorithmName() {
        return "DESede";
    }

    @Override // org.bouncycastle.crypto.Wrapper
    public void init(boolean r100, CipherParameters r101) {
        this.forWrapping = r100;
        this.engine = new CBCBlockCipher(new DESedeEngine());
        if ((r101 instanceof ParametersWithRandom) == false) goto L5;
        ParametersWithRandom r102 = (ParametersWithRandom) r101;
        CipherParameters r103 = r102.getParameters();
        SecureRandom r104 = r102.getRandom();
        r101 = r103;
        SecureRandom r105 = r104;
    L7:
        if ((r101 instanceof KeyParameter) == false) goto L12;
        this.param = (KeyParameter) r101;
        if (this.forWrapping == false) goto L24;
        byte[] r106 = new byte[8];
        this.f525180iv = r106;
        r105.nextBytes(r106);
        this.paramPlusIV = new ParametersWithIV(this.param, this.f525180iv);
        return;
    L24:
        return;
    L12:
        if ((r101 instanceof ParametersWithIV) == false) goto L26;
        ParametersWithIV r107 = (ParametersWithIV) r101;
        this.paramPlusIV = r107;
        this.f525180iv = r107.getIV();
        this.param = (KeyParameter) this.paramPlusIV.getParameters();
        if (this.forWrapping == false) goto L23;
        byte[] r108 = this.f525180iv;
        if (r108 == null) goto L21;
        if (r108.length != 8) goto L21;
        return;
    L21:
        throw new IllegalArgumentException("IV is not 8 octets");
    L23:
        throw new IllegalArgumentException("You should not supply an IV for unwrapping");
    L26:
        return;
    L5:
        r105 = CryptoServicesRegistrar.getSecureRandom();
        goto L7
    }

    @Override // org.bouncycastle.crypto.Wrapper
    public byte[] unwrap(byte[] r100, int r101, int r102) throws InvalidCipherTextException {
        if (this.forWrapping == true) goto L23;
        if (r100 == null) goto L21;
        int r103 = this.engine.getBlockSize();
        if ((r102 % r103) != 0) goto L19;
        this.engine.init(false, new ParametersWithIV(this.param, IV2));
        byte[] r104 = new byte[r102];
        int r105 = 0;
    L8:
        if (r105 == r102) goto L10;
        this.engine.processBlock(r100, r101 + r105, r104, r105);
        r105 = r105 + r103;
        goto L8
    L10:
        byte[] r106 = reverse(r104);
        byte[] r107 = new byte[8];
        this.f525180iv = r107;
        int r108 = r106.length - 8;
        byte[] r109 = new byte[r108];
        System.arraycopy(r106, 0, r107, 0, 8);
        System.arraycopy(r106, 8, r109, 0, r106.length - 8);
        ParametersWithIV r110 = new ParametersWithIV(this.param, this.f525180iv);
        this.paramPlusIV = r110;
        this.engine.init(false, r110);
        byte[] r111 = new byte[r108];
        int r112 = 0;
    L11:
        if (r112 == r108) goto L13;
        this.engine.processBlock(r109, r112, r111, r112);
        r112 = r112 + r103;
        goto L11
    L13:
        int r113 = r108 - 8;
        byte[] r114 = new byte[r113];
        byte[] r115 = new byte[8];
        System.arraycopy(r111, 0, r114, 0, r113);
        System.arraycopy(r111, r113, r115, 0, 8);
        if (checkCMSKeyChecksum(r114, r115) == false) goto L17;
        return r114;
    L17:
        throw new InvalidCipherTextException("Checksum inside ciphertext is corrupted");
    L19:
        throw new InvalidCipherTextException("Ciphertext not multiple of " + r103);
    L21:
        throw new InvalidCipherTextException("Null pointer as ciphertext");
    L23:
        throw new IllegalStateException("Not set for unwrapping");
    }

    @Override // org.bouncycastle.crypto.Wrapper
    public byte[] wrap(byte[] r100, int r101, int r102) {
        if (this.forWrapping == false) goto L17;
        byte[] r103 = new byte[r102];
        int r104 = 0;
        System.arraycopy(r100, r101, r103, 0, r102);
        byte[] r105 = calculateCMSKeyChecksum(r103);
        int r106 = r105.length + r102;
        byte[] r107 = new byte[r106];
        System.arraycopy(r103, 0, r107, 0, r102);
        System.arraycopy(r105, 0, r107, r102, r105.length);
        int r108 = this.engine.getBlockSize();
        if ((r106 % r108) != 0) goto L15;
        this.engine.init(true, this.paramPlusIV);
        byte[] r109 = new byte[r106];
        int r110 = 0;
    L7:
        if (r110 == r106) goto L9;
        this.engine.processBlock(r107, r110, r109, r110);
        r110 = r110 + r108;
        goto L7
    L9:
        byte[] r111 = this.f525180iv;
        byte[] r112 = new byte[r111.length + r106];
        System.arraycopy(r111, 0, r112, 0, r111.length);
        System.arraycopy(r109, 0, r112, this.f525180iv.length, r106);
        byte[] r113 = reverse(r112);
        ParametersWithIV r114 = new ParametersWithIV(this.param, IV2);
        this.engine.init(true, r114);
    L11:
        if (r104 == r113.length) goto L13;
        this.engine.processBlock(r113, r104, r113, r104);
        r104 = r104 + r108;
        goto L11
    L13:
        return r113;
    L15:
        throw new IllegalStateException("Not multiple of block length");
    L17:
        throw new IllegalStateException("Not initialized for wrapping");
    }
}
