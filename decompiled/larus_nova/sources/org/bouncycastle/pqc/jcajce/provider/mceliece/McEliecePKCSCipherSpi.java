package org.bouncycastle.pqc.jcajce.provider.mceliece;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.x509.X509ObjectIdentifiers;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.pqc.crypto.mceliece.McElieceCipher;
import org.bouncycastle.pqc.crypto.mceliece.McElieceKeyParameters;
import org.bouncycastle.pqc.jcajce.provider.util.AsymmetricBlockCipher;

/* JADX INFO: loaded from: classes42.dex */
public class McEliecePKCSCipherSpi extends AsymmetricBlockCipher implements PKCSObjectIdentifiers, X509ObjectIdentifiers {
    private McElieceCipher cipher;

    public static class McEliecePKCS extends McEliecePKCSCipherSpi {
        public McEliecePKCS() {
            super(new McElieceCipher());
        }
    }

    public McEliecePKCSCipherSpi(McElieceCipher r100) {
        this.cipher = r100;
    }

    @Override // org.bouncycastle.pqc.jcajce.provider.util.CipherSpiExt
    public int getKeySize(Key r100) throws InvalidKeyException {
        if ((r100 instanceof PublicKey) == false) goto L5;
        AsymmetricKeyParameter r101 = McElieceKeysToParams.generatePublicKeyParameter((PublicKey) r100);
    L6:
        McElieceCipher r102 = this.cipher;
        return r102.getKeySize((McElieceKeyParameters) r101);
    L5:
        r101 = McElieceKeysToParams.generatePrivateKeyParameter((PrivateKey) r100);
        goto L6
    }

    @Override // org.bouncycastle.pqc.jcajce.provider.util.CipherSpiExt
    public String getName() {
        return "McEliecePKCS";
    }

    @Override // org.bouncycastle.pqc.jcajce.provider.util.AsymmetricBlockCipher
    public void initCipherDecrypt(Key r100, AlgorithmParameterSpec r101) throws InvalidKeyException, InvalidAlgorithmParameterException {
        AsymmetricKeyParameter r102 = McElieceKeysToParams.generatePrivateKeyParameter((PrivateKey) r100);
        this.cipher.init(false, r102);
        McElieceCipher r103 = this.cipher;
        this.maxPlainTextSize = r103.maxPlainTextSize;
        this.cipherTextSize = r103.cipherTextSize;
    }

    @Override // org.bouncycastle.pqc.jcajce.provider.util.AsymmetricBlockCipher
    public void initCipherEncrypt(Key r100, AlgorithmParameterSpec r101, SecureRandom r102) throws InvalidKeyException, InvalidAlgorithmParameterException {
        ParametersWithRandom r103 = new ParametersWithRandom(McElieceKeysToParams.generatePublicKeyParameter((PublicKey) r100), r102);
        this.cipher.init(true, r103);
        McElieceCipher r104 = this.cipher;
        this.maxPlainTextSize = r104.maxPlainTextSize;
        this.cipherTextSize = r104.cipherTextSize;
    }

    @Override // org.bouncycastle.pqc.jcajce.provider.util.AsymmetricBlockCipher
    public byte[] messageDecrypt(byte[] r100) throws IllegalBlockSizeException, BadPaddingException {
        return this.cipher.messageDecrypt(r100);
    L4:
        e = move-exception;
        throw new IllegalBlockSizeException(e.getMessage());
    }

    @Override // org.bouncycastle.pqc.jcajce.provider.util.AsymmetricBlockCipher
    public byte[] messageEncrypt(byte[] r100) throws IllegalBlockSizeException, BadPaddingException {
        return this.cipher.messageEncrypt(r100);
    L4:
        e = move-exception;
        throw new IllegalBlockSizeException(e.getMessage());
    }
}
