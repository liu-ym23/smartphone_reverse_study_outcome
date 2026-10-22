package org.bouncycastle.crypto.agreement.kdf;

import java.io.IOException;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Encoding;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.DerivationParameters;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.DigestDerivationFunction;
import org.bouncycastle.crypto.generators.KDF2BytesGenerator;
import org.bouncycastle.crypto.params.KDFParameters;
import org.bouncycastle.util.Pack;

/* JADX INFO: loaded from: classes42.dex */
public class ECDHKEKGenerator implements DigestDerivationFunction {
    private ASN1ObjectIdentifier algorithm;
    private DigestDerivationFunction kdf;
    private int keySize;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private byte[] f525120z;

    public ECDHKEKGenerator(Digest r100) {
        this.kdf = new KDF2BytesGenerator(r100);
    }

    @Override // org.bouncycastle.crypto.DerivationFunction
    public int generateBytes(byte[] r100, int r101, int r102) throws DataLengthException, IllegalArgumentException {
        if ((r101 + r102) > r100.length) goto L12;
        ASN1EncodableVector r103 = new ASN1EncodableVector();
        r103.add(new AlgorithmIdentifier(this.algorithm, DERNull.INSTANCE));
        r103.add(new DERTaggedObject(true, 2, new DEROctetString(Pack.intToBigEndian(this.keySize))));
        this.kdf.init(new KDFParameters(this.f525120z, new DERSequence(r103).getEncoded(ASN1Encoding.DER)));     // Catch: IOException -> L8
        return this.kdf.generateBytes(r100, r101, r102);
    L8:
        e = move-exception;
        throw new IllegalArgumentException("unable to initialise kdf: " + e.getMessage());
    L12:
        throw new DataLengthException("output buffer too small");
    }

    @Override // org.bouncycastle.crypto.DigestDerivationFunction
    public Digest getDigest() {
        return this.kdf.getDigest();
    }

    @Override // org.bouncycastle.crypto.DerivationFunction
    public void init(DerivationParameters r100) {
        DHKDFParameters r101 = (DHKDFParameters) r100;
        this.algorithm = r101.getAlgorithm();
        this.keySize = r101.getKeySize();
        this.f525120z = r101.getZ();
    }
}
