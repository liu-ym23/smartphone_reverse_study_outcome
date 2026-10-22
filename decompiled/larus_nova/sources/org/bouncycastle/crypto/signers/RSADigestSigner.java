package org.bouncycastle.crypto.signers;

import java.io.IOException;
import java.util.Hashtable;
import org.bouncycastle.asn1.ASN1Encoding;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.teletrust.TeleTrusTObjectIdentifiers;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.DigestInfo;
import org.bouncycastle.asn1.x509.X509ObjectIdentifiers;
import org.bouncycastle.crypto.AsymmetricBlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.CryptoException;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.Signer;
import org.bouncycastle.crypto.encodings.PKCS1Encoding;
import org.bouncycastle.crypto.engines.RSABlindedEngine;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.pqc.crypto.sphincs.SPHINCSKeyParameters;
import org.bouncycastle.pqc.jcajce.spec.McElieceCCA2KeyGenParameterSpec;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes42.dex */
public class RSADigestSigner implements Signer {
    private static final Hashtable oidMap = null;
    private final AlgorithmIdentifier algId;
    private final Digest digest;
    private boolean forSigning;
    private final AsymmetricBlockCipher rsaEngine;

    static {
        Hashtable r100 = new Hashtable();
        oidMap = r100;
        r100.put("RIPEMD128", TeleTrusTObjectIdentifiers.ripemd128);
        r100.put("RIPEMD160", TeleTrusTObjectIdentifiers.ripemd160);
        r100.put("RIPEMD256", TeleTrusTObjectIdentifiers.ripemd256);
        r100.put("SHA-1", X509ObjectIdentifiers.id_SHA1);
        r100.put(McElieceCCA2KeyGenParameterSpec.SHA224, NISTObjectIdentifiers.id_sha224);
        r100.put("SHA-256", NISTObjectIdentifiers.id_sha256);
        r100.put(McElieceCCA2KeyGenParameterSpec.SHA384, NISTObjectIdentifiers.id_sha384);
        r100.put("SHA-512", NISTObjectIdentifiers.id_sha512);
        r100.put("SHA-512/224", NISTObjectIdentifiers.id_sha512_224);
        r100.put(SPHINCSKeyParameters.SHA512_256, NISTObjectIdentifiers.id_sha512_256);
        r100.put("SHA3-224", NISTObjectIdentifiers.id_sha3_224);
        r100.put("SHA3-256", NISTObjectIdentifiers.id_sha3_256);
        r100.put("SHA3-384", NISTObjectIdentifiers.id_sha3_384);
        r100.put("SHA3-512", NISTObjectIdentifiers.id_sha3_512);
        r100.put("MD2", PKCSObjectIdentifiers.f525056md2);
        r100.put("MD4", PKCSObjectIdentifiers.f525057md4);
        r100.put("MD5", PKCSObjectIdentifiers.f525058md5);
    }

    public RSADigestSigner(Digest r100) {
        this(r100, (ASN1ObjectIdentifier) oidMap.get(r100.getAlgorithmName()));
    }

    public RSADigestSigner(Digest r100, ASN1ObjectIdentifier r101) {
        this.rsaEngine = new PKCS1Encoding(new RSABlindedEngine());
        this.digest = r100;
        if (r101 == null) goto L5;
        AlgorithmIdentifier r102 = new AlgorithmIdentifier(r101, DERNull.INSTANCE);
    L6:
        this.algId = r102;
        return;
    L5:
        r102 = null;
        goto L6
    }

    private byte[] derEncode(byte[] r100) throws IOException {
        AlgorithmIdentifier r101 = this.algId;
        if (r101 != null) goto L10;
        DigestInfo.getInstance(r100);     // Catch: IllegalArgumentException -> L6
        return r100;
    L6:
        e = move-exception;
        throw new IOException("malformed DigestInfo for NONEwithRSA hash: " + e.getMessage());
    L10:
        return new DigestInfo(r101, r100).getEncoded(ASN1Encoding.DER);
    }

    @Override // org.bouncycastle.crypto.Signer
    public byte[] generateSignature() throws CryptoException, DataLengthException {
        if (this.forSigning == false) goto L11;
        byte[] r100 = new byte[this.digest.getDigestSize()];
        this.digest.doFinal(r100, 0);
        byte[] r101 = derEncode(r100);     // Catch: IOException -> L7
        return this.rsaEngine.processBlock(r101, 0, r101.length);
    L7:
        e = move-exception;
        throw new CryptoException("unable to encode signature: " + e.getMessage(), e);
    L11:
        throw new IllegalStateException("RSADigestSigner not initialised for signature generation.");
    }

    public String getAlgorithmName() {
        return this.digest.getAlgorithmName() + "withRSA";
    }

    @Override // org.bouncycastle.crypto.Signer
    public void init(boolean r100, CipherParameters r101) {
        this.forSigning = r100;
        if ((r101 instanceof ParametersWithRandom) == false) goto L5;
        AsymmetricKeyParameter r102 = (AsymmetricKeyParameter) ((ParametersWithRandom) r101).getParameters();
    L6:
        if (r100 == true) goto L8;
    L12:
        if (r100 == false) goto L14;
    L18:
        reset();
        this.rsaEngine.init(r100, r101);
        return;
    L14:
        if (r102.isPrivate() == false) goto L18;
        throw new IllegalArgumentException("verification requires public key");
    L8:
        if (r102.isPrivate() == true) goto L12;
        throw new IllegalArgumentException("signing requires private key");
    L5:
        r102 = (AsymmetricKeyParameter) r101;
        goto L6
    }

    @Override // org.bouncycastle.crypto.Signer
    public void reset() {
        this.digest.reset();
    }

    @Override // org.bouncycastle.crypto.Signer
    public void update(byte r100) {
        this.digest.update(r100);
    }

    @Override // org.bouncycastle.crypto.Signer
    public void update(byte[] r100, int r101, int r102) {
        this.digest.update(r100, r101, r102);
    }

    @Override // org.bouncycastle.crypto.Signer
    public boolean verifySignature(byte[] r110) {
        if (this.forSigning == true) goto L24;
        int r100 = this.digest.getDigestSize();
        byte[] r101 = new byte[r100];
        this.digest.doFinal(r101, 0);
        byte[] r111 = this.rsaEngine.processBlock(r110, 0, r110.length);     // Catch: Exception -> L25
        byte[] r102 = derEncode(r101);     // Catch: Exception -> L25
        if (r111.length != r102.length) goto L11;
        return Arrays.constantTimeAreEqual(r111, r102);
    L11:
        if (r111.length != (r102.length - 2)) goto L21;
        int r103 = (r111.length - r100) - 2;
        int r104 = (r102.length - r100) - 2;
        r102[1] = (byte) (r102[1] - 2);
        r102[3] = (byte) (r102[3] - 2);
        int r105 = 0;
        int r106 = 0;
    L13:
        if (r105 >= r100) goto L15;
        r106 = r106 | (r111[r103 + r105] ^ r102[r104 + r105]);
        r105 = r105 + 1;
        goto L13
    L15:
        int r107 = 0;
    L16:
        if (r107 >= r103) goto L18;
        r106 = r106 | (r111[r107] ^ r102[r107]);
        r107 = r107 + 1;
        goto L16
    L18:
        if (r106 != 0) goto L30;
        return true;
    L30:
        return false;
    L21:
        Arrays.constantTimeAreEqual(r102, r102);
    L22:
        return false;
    L24:
        throw new IllegalStateException("RSADigestSigner not initialised for verification");
    }
}
