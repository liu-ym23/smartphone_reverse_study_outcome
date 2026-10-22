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
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.crypto.util.DigestFactory;
import org.bouncycastle.pqc.crypto.mceliece.McElieceCCA2KeyParameters;
import org.bouncycastle.pqc.crypto.mceliece.McEliecePointchevalCipher;
import org.bouncycastle.pqc.jcajce.provider.util.AsymmetricHybridCipher;

/* JADX INFO: loaded from: classes42.dex */
public class McEliecePointchevalCipherSpi extends AsymmetricHybridCipher implements PKCSObjectIdentifiers, X509ObjectIdentifiers {
    private ByteArrayOutputStream buf;
    private McEliecePointchevalCipher cipher;
    private Digest digest;

    public static class McEliecePointcheval extends McEliecePointchevalCipherSpi {
        public McEliecePointcheval() {
            super(DigestFactory.createSHA1(), new McEliecePointchevalCipher());
        }
    }

    public static class McEliecePointcheval224 extends McEliecePointchevalCipherSpi {
        public McEliecePointcheval224() {
            super(DigestFactory.createSHA224(), new McEliecePointchevalCipher());
        }
    }

    public static class McEliecePointcheval256 extends McEliecePointchevalCipherSpi {
        public McEliecePointcheval256() {
            super(DigestFactory.createSHA256(), new McEliecePointchevalCipher());
        }
    }

    public static class McEliecePointcheval384 extends McEliecePointchevalCipherSpi {
        public McEliecePointcheval384() {
            super(DigestFactory.createSHA384(), new McEliecePointchevalCipher());
        }
    }

    public static class McEliecePointcheval512 extends McEliecePointchevalCipherSpi {
        public McEliecePointcheval512() {
            super(DigestFactory.createSHA512(), new McEliecePointchevalCipher());
        }
    }

    public McEliecePointchevalCipherSpi(Digest r100, McEliecePointchevalCipher r101) {
        this.buf = new ByteArrayOutputStream();
        this.digest = r100;
        this.cipher = r101;
        this.buf = new ByteArrayOutputStream();
    }

    @Override // org.bouncycastle.pqc.jcajce.provider.util.AsymmetricHybridCipher
    public int decryptOutputSize(int r100) {
        return 0;
    }

    @Override // org.bouncycastle.pqc.jcajce.provider.util.AsymmetricHybridCipher, org.bouncycastle.pqc.jcajce.provider.util.CipherSpiExt
    public byte[] doFinal(byte[] r100, int r101, int r102) throws BadPaddingException {
        update(r100, r101, r102);
        byte[] r103 = this.buf.toByteArray();
        this.buf.reset();
        int r104 = this.opMode;
        if (r104 != 1) goto L7;
        return this.cipher.messageEncrypt(r103);
    L7:
        if (r104 == 2) goto L15;
        return null;
    L15:
        return this.cipher.messageDecrypt(r103);
    L10:
        e = move-exception;
        throw new BadPaddingException(e.getMessage());
    }

    @Override // org.bouncycastle.pqc.jcajce.provider.util.AsymmetricHybridCipher
    public int encryptOutputSize(int r100) {
        return 0;
    }

    @Override // org.bouncycastle.pqc.jcajce.provider.util.CipherSpiExt
    public int getKeySize(Key r100) throws InvalidKeyException {
        if ((r100 instanceof PublicKey) == false) goto L5;
        AsymmetricKeyParameter r101 = McElieceCCA2KeysToParams.generatePublicKeyParameter((PublicKey) r100);
    L6:
        McEliecePointchevalCipher r102 = this.cipher;
        return r102.getKeySize((McElieceCCA2KeyParameters) r101);
    L5:
        r101 = McElieceCCA2KeysToParams.generatePrivateKeyParameter((PrivateKey) r100);
        goto L6
    }

    @Override // org.bouncycastle.pqc.jcajce.provider.util.CipherSpiExt
    public String getName() {
        return "McEliecePointchevalCipher";
    }

    @Override // org.bouncycastle.pqc.jcajce.provider.util.AsymmetricHybridCipher
    public void initCipherDecrypt(Key r100, AlgorithmParameterSpec r101) throws InvalidKeyException, InvalidAlgorithmParameterException {
        AsymmetricKeyParameter r102 = McElieceCCA2KeysToParams.generatePrivateKeyParameter((PrivateKey) r100);
        this.digest.reset();
        this.cipher.init(false, r102);
    }

    @Override // org.bouncycastle.pqc.jcajce.provider.util.AsymmetricHybridCipher
    public void initCipherEncrypt(Key r100, AlgorithmParameterSpec r101, SecureRandom r102) throws InvalidKeyException, InvalidAlgorithmParameterException {
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
