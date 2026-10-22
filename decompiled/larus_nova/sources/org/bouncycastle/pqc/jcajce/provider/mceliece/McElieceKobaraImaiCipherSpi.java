package org.bouncycastle.pqc.jcajce.provider.mceliece;

import java.io.ByteArrayOutputStream;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.BadPaddingException;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.x509.X509ObjectIdentifiers;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.crypto.util.DigestFactory;
import org.bouncycastle.pqc.crypto.mceliece.McElieceCCA2KeyParameters;
import org.bouncycastle.pqc.crypto.mceliece.McElieceKobaraImaiCipher;
import org.bouncycastle.pqc.jcajce.provider.util.AsymmetricHybridCipher;

/* JADX INFO: loaded from: classes42.dex */
public class McElieceKobaraImaiCipherSpi extends AsymmetricHybridCipher implements PKCSObjectIdentifiers, X509ObjectIdentifiers {
    private ByteArrayOutputStream buf;
    private McElieceKobaraImaiCipher cipher;
    private Digest digest;

    public static class McElieceKobaraImai extends McElieceKobaraImaiCipherSpi {
        public McElieceKobaraImai() {
            super(DigestFactory.createSHA1(), new McElieceKobaraImaiCipher());
        }
    }

    public static class McElieceKobaraImai224 extends McElieceKobaraImaiCipherSpi {
        public McElieceKobaraImai224() {
            super(DigestFactory.createSHA224(), new McElieceKobaraImaiCipher());
        }
    }

    public static class McElieceKobaraImai256 extends McElieceKobaraImaiCipherSpi {
        public McElieceKobaraImai256() {
            super(DigestFactory.createSHA256(), new McElieceKobaraImaiCipher());
        }
    }

    public static class McElieceKobaraImai384 extends McElieceKobaraImaiCipherSpi {
        public McElieceKobaraImai384() {
            super(DigestFactory.createSHA384(), new McElieceKobaraImaiCipher());
        }
    }

    public static class McElieceKobaraImai512 extends McElieceKobaraImaiCipherSpi {
        public McElieceKobaraImai512() {
            super(DigestFactory.createSHA512(), new McElieceKobaraImaiCipher());
        }
    }

    public McElieceKobaraImaiCipherSpi() {
        this.buf = new ByteArrayOutputStream();
        this.buf = new ByteArrayOutputStream();
    }

    public McElieceKobaraImaiCipherSpi(Digest r100, McElieceKobaraImaiCipher r101) {
        this.buf = new ByteArrayOutputStream();
        this.digest = r100;
        this.cipher = r101;
        this.buf = new ByteArrayOutputStream();
    }

    private byte[] pad() {
        this.buf.write(1);
        byte[] r100 = this.buf.toByteArray();
        this.buf.reset();
        return r100;
    }

    private byte[] unpad(byte[] r100) throws BadPaddingException {
        int r101 = r100.length - 1;
    L3:
        if (r101 < 0) goto L8;
        if (r100[r101] != 0) goto L8;
        r101 = r101 - 1;
    L8:
        if (r100[r101] != 1) goto L12;
        byte[] r102 = new byte[r101];
        System.arraycopy(r100, 0, r102, 0, r101);
        return r102;
    L12:
        throw new BadPaddingException("invalid ciphertext");
    }

    @Override // org.bouncycastle.pqc.jcajce.provider.util.AsymmetricHybridCipher
    public int decryptOutputSize(int r100) {
        return 0;
    }

    @Override // org.bouncycastle.pqc.jcajce.provider.util.AsymmetricHybridCipher, org.bouncycastle.pqc.jcajce.provider.util.CipherSpiExt
    public byte[] doFinal(byte[] r100, int r101, int r102) throws BadPaddingException {
        update(r100, r101, r102);
        int r103 = this.opMode;
        if (r103 != 1) goto L7;
        return this.cipher.messageEncrypt(pad());
    L7:
        if (r103 != 2) goto L14;
        byte[] r104 = this.buf.toByteArray();     // Catch: InvalidCipherTextException -> L10
        this.buf.reset();     // Catch: InvalidCipherTextException -> L10
        return unpad(this.cipher.messageDecrypt(r104));
    L10:
        e = move-exception;
        throw new BadPaddingException(e.getMessage());
    L14:
        throw new IllegalStateException("unknown mode in doFinal");
    }

    @Override // org.bouncycastle.pqc.jcajce.provider.util.AsymmetricHybridCipher
    public int encryptOutputSize(int r100) {
        return 0;
    }

    @Override // org.bouncycastle.pqc.jcajce.provider.util.CipherSpiExt
    public int getKeySize(Key r100) throws InvalidKeyException {
        if ((r100 instanceof PublicKey) == false) goto L8;
        AsymmetricKeyParameter r101 = McElieceCCA2KeysToParams.generatePublicKeyParameter((PublicKey) r100);
    L5:
        McElieceKobaraImaiCipher r102 = this.cipher;
        return r102.getKeySize((McElieceCCA2KeyParameters) r101);
    L8:
        if ((r100 instanceof PrivateKey) == false) goto L11;
        r101 = McElieceCCA2KeysToParams.generatePrivateKeyParameter((PrivateKey) r100);
        goto L5
    L11:
        throw new InvalidKeyException();
    }

    @Override // org.bouncycastle.pqc.jcajce.provider.util.CipherSpiExt
    public String getName() {
        return "McElieceKobaraImaiCipher";
    }

    @Override // org.bouncycastle.pqc.jcajce.provider.util.AsymmetricHybridCipher
    public void initCipherDecrypt(Key r100, AlgorithmParameterSpec r101) throws InvalidKeyException, InvalidAlgorithmParameterException {
        this.buf.reset();
        AsymmetricKeyParameter r102 = McElieceCCA2KeysToParams.generatePrivateKeyParameter((PrivateKey) r100);
        this.digest.reset();
        this.cipher.init(false, r102);
    }

    @Override // org.bouncycastle.pqc.jcajce.provider.util.AsymmetricHybridCipher
    public void initCipherEncrypt(Key r100, AlgorithmParameterSpec r101, SecureRandom r102) throws InvalidKeyException, InvalidAlgorithmParameterException {
        this.buf.reset();
        ParametersWithRandom r103 = new ParametersWithRandom(McElieceCCA2KeysToParams.generatePublicKeyParameter((PublicKey) r100), r102);
        this.digest.reset();
        this.cipher.init(true, r103);
    }

    @Override // org.bouncycastle.pqc.jcajce.provider.util.AsymmetricHybridCipher, org.bouncycastle.pqc.jcajce.provider.util.CipherSpiExt
    public byte[] update(byte[] r100, int r101, int r102) {
        this.buf.write(r100, r101, r102);
        return new byte[0];
    }
}
