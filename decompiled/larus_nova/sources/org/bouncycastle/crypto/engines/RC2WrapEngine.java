package org.bouncycastle.crypto.engines;

import java.security.SecureRandom;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.CryptoServicesRegistrar;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.Wrapper;
import org.bouncycastle.crypto.modes.CBCBlockCipher;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.crypto.util.DigestFactory;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes42.dex */
public class RC2WrapEngine implements Wrapper {
    private static final byte[] IV2 = null;
    byte[] digest;
    private CBCBlockCipher engine;
    private boolean forWrapping;

    /* JADX INFO: renamed from: iv, reason: collision with root package name */
    private byte[] f525195iv;
    private CipherParameters param;
    private ParametersWithIV paramPlusIV;
    Digest sha1;

    /* JADX INFO: renamed from: sr, reason: collision with root package name */
    private SecureRandom f525196sr;

    static {
        IV2 = new byte[]{74, -35, -94, 44, 121, -24, 33, 5};
    }

    public RC2WrapEngine() {
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

    @Override // org.bouncycastle.crypto.Wrapper
    public String getAlgorithmName() {
        return "RC2";
    }

    @Override // org.bouncycastle.crypto.Wrapper
    public void init(boolean r100, CipherParameters r101) {
        this.forWrapping = r100;
        this.engine = new CBCBlockCipher(new RC2Engine());
        if ((r101 instanceof ParametersWithRandom) == false) goto L5;
        ParametersWithRandom r102 = (ParametersWithRandom) r101;
        this.f525196sr = r102.getRandom();
        r101 = r102.getParameters();
    L7:
        if ((r101 instanceof ParametersWithIV) == false) goto L19;
        ParametersWithIV r103 = (ParametersWithIV) r101;
        this.paramPlusIV = r103;
        this.f525195iv = r103.getIV();
        this.param = this.paramPlusIV.getParameters();
        if (this.forWrapping == false) goto L18;
        byte[] r104 = this.f525195iv;
        if (r104 == null) goto L16;
        if (r104.length != 8) goto L16;
        return;
    L16:
        throw new IllegalArgumentException("IV is not 8 octets");
    L18:
        throw new IllegalArgumentException("You should not supply an IV for unwrapping");
    L19:
        this.param = r101;
        if (this.forWrapping == false) goto L23;
        byte[] r105 = new byte[8];
        this.f525195iv = r105;
        this.f525196sr.nextBytes(r105);
        this.paramPlusIV = new ParametersWithIV(this.param, this.f525195iv);
        return;
    L23:
        return;
    L5:
        this.f525196sr = CryptoServicesRegistrar.getSecureRandom();
        goto L7
    }

    @Override // org.bouncycastle.crypto.Wrapper
    public byte[] unwrap(byte[] r100, int r101, int r102) throws InvalidCipherTextException {
        if (this.forWrapping == true) goto L33;
        if (r100 == null) goto L31;
        if ((r102 % this.engine.getBlockSize()) != 0) goto L29;
        this.engine.init(false, new ParametersWithIV(this.param, IV2));
        byte[] r103 = new byte[r102];
        System.arraycopy(r100, r101, r103, 0, r102);
        int r104 = 0;
    L9:
        if (r104 >= (r102 / this.engine.getBlockSize())) goto L11;
        int r105 = this.engine.getBlockSize() * r104;
        this.engine.processBlock(r103, r105, r103, r105);
        r104 = r104 + 1;
        goto L9
    L11:
        byte[] r106 = new byte[r102];
        int r107 = 0;
    L12:
        if (r107 >= r102) goto L14;
        int r108 = r107 + 1;
        r106[r107] = r103[r102 - r108];
        r107 = r108;
        goto L12
    L14:
        byte[] r109 = new byte[8];
        this.f525195iv = r109;
        int r110 = r102 - 8;
        byte[] r111 = new byte[r110];
        System.arraycopy(r106, 0, r109, 0, 8);
        System.arraycopy(r106, 8, r111, 0, r110);
        ParametersWithIV r112 = new ParametersWithIV(this.param, this.f525195iv);
        this.paramPlusIV = r112;
        this.engine.init(false, r112);
        byte[] r113 = new byte[r110];
        System.arraycopy(r111, 0, r113, 0, r110);
        int r114 = 0;
    L16:
        if (r114 >= (r110 / this.engine.getBlockSize())) goto L18;
        int r115 = this.engine.getBlockSize() * r114;
        this.engine.processBlock(r113, r115, r113, r115);
        r114 = r114 + 1;
        goto L16
    L18:
        int r116 = r110 - 8;
        byte[] r117 = new byte[r116];
        byte[] r118 = new byte[8];
        System.arraycopy(r113, 0, r117, 0, r116);
        System.arraycopy(r113, r116, r118, 0, 8);
        if (checkCMSKeyChecksum(r117, r118) == false) goto L27;
        int r119 = r117[0];
        if ((r116 - ((r119 & 255) + 1)) > 7) goto L25;
        byte[] r120 = new byte[r119];
        System.arraycopy(r117, 1, r120, 0, r119);
        return r120;
    L25:
        throw new InvalidCipherTextException("too many pad bytes (" + (r116 - ((r117[0] & 255) + 1)) + ")");
    L27:
        throw new InvalidCipherTextException("Checksum inside ciphertext is corrupted");
    L29:
        throw new InvalidCipherTextException("Ciphertext not multiple of " + this.engine.getBlockSize());
    L31:
        throw new InvalidCipherTextException("Null pointer as ciphertext");
    L33:
        throw new IllegalStateException("Not set for unwrapping");
    }

    @Override // org.bouncycastle.crypto.Wrapper
    public byte[] wrap(byte[] r100, int r101, int r102) {
        if (this.forWrapping == false) goto L27;
        int r103 = r102 + 1;
        int r104 = r103 % 8;
        if (r104 == 0) goto L7;
        int r105 = (8 - r104) + r103;
    L8:
        byte[] r106 = new byte[r105];
        int r107 = 0;
        r106[0] = (byte) r102;
        System.arraycopy(r100, r101, r106, 1, r102);
        int r108 = (r105 - r102) - 1;
        byte[] r109 = new byte[r108];
        if (r108 <= 0) goto L11;
        this.f525196sr.nextBytes(r109);
        System.arraycopy(r109, 0, r106, r103, r108);
    L11:
        byte[] r110 = calculateCMSKeyChecksum(r106);
        int r111 = r110.length + r105;
        byte[] r112 = new byte[r111];
        System.arraycopy(r106, 0, r112, 0, r105);
        System.arraycopy(r110, 0, r112, r105, r110.length);
        byte[] r113 = new byte[r111];
        System.arraycopy(r112, 0, r113, 0, r111);
        int r114 = r111 / this.engine.getBlockSize();
        if ((r111 % this.engine.getBlockSize()) != 0) goto L25;
        this.engine.init(true, this.paramPlusIV);
        int r115 = 0;
    L14:
        if (r115 >= r114) goto L16;
        int r116 = this.engine.getBlockSize() * r115;
        this.engine.processBlock(r113, r116, r113, r116);
        r115 = r115 + 1;
        goto L14
    L16:
        byte[] r117 = this.f525195iv;
        int r118 = r117.length + r111;
        byte[] r119 = new byte[r118];
        System.arraycopy(r117, 0, r119, 0, r117.length);
        System.arraycopy(r113, 0, r119, this.f525195iv.length, r111);
        byte[] r120 = new byte[r118];
        int r121 = 0;
    L17:
        if (r121 >= r118) goto L19;
        int r122 = r121 + 1;
        r120[r121] = r119[r118 - r122];
        r121 = r122;
        goto L17
    L19:
        ParametersWithIV r123 = new ParametersWithIV(this.param, IV2);
        this.engine.init(true, r123);
    L21:
        if (r107 >= (r114 + 1)) goto L23;
        int r124 = this.engine.getBlockSize() * r107;
        this.engine.processBlock(r120, r124, r120, r124);
        r107 = r107 + 1;
        goto L21
    L23:
        return r120;
    L25:
        throw new IllegalStateException("Not multiple of block length");
    L7:
        r105 = r103;
        goto L8
    L27:
        throw new IllegalStateException("Not initialized for wrapping");
    }
}
