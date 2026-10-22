package org.bouncycastle.crypto.agreement.kdf;

import java.io.IOException;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Encoding;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.DerivationFunction;
import org.bouncycastle.crypto.DerivationParameters;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.util.Pack;

/* JADX INFO: loaded from: classes42.dex */
public class DHKEKGenerator implements DerivationFunction {
    private ASN1ObjectIdentifier algorithm;
    private final Digest digest;
    private int keySize;
    private byte[] partyAInfo;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private byte[] f525119z;

    public DHKEKGenerator(Digest r100) {
        this.digest = r100;
    }

    @Override // org.bouncycastle.crypto.DerivationFunction
    public int generateBytes(byte[] r110, int r111, int r112) throws DataLengthException, IllegalArgumentException {
        int r100 = r112;
        int r101 = r111;
        if ((r110.length - r100) < r101) goto L27;
        long r102 = r100;
        int r103 = this.digest.getDigestSize();
        if (r102 > 8589934591L) goto L25;
        long r104 = r103;
        int r105 = (int) (((r102 + r104) - 1) / r104);
        byte[] r106 = new byte[this.digest.getDigestSize()];
        int r113 = 0;
        int r114 = 0;
        int r115 = 1;
    L7:
        if (r114 >= r105) goto L22;
        Digest r116 = this.digest;
        byte[] r117 = this.f525119z;
        r116.update(r117, r113, r117.length);
        ASN1EncodableVector r118 = new ASN1EncodableVector();
        ASN1EncodableVector r119 = new ASN1EncodableVector();
        r119.add(this.algorithm);
        r119.add(new DEROctetString(Pack.intToBigEndian(r115)));
        r118.add(new DERSequence(r119));
        byte[] r107 = this.partyAInfo;
        if (r107 == null) goto L11;
        DEROctetString r120 = new DEROctetString(r107);
        boolean r108 = true;
        r118.add(new DERTaggedObject(true, r113, r120));
    L12:
        r118.add(new DERTaggedObject(r108, 2, new DEROctetString(Pack.intToBigEndian(this.keySize))));
        byte[] r121 = new DERSequence(r118).getEncoded(ASN1Encoding.DER);     // Catch: IOException -> L19
        this.digest.update(r121, 0, r121.length);     // Catch: IOException -> L19
        this.digest.doFinal(r106, 0);
        if (r100 <= r103) goto L17;
        System.arraycopy(r106, 0, r110, r101, r103);
        r101 = r101 + r103;
        r100 = r100 - r103;
    L18:
        r115 = r115 + 1;
        r114 = r114 + 1;
        r113 = 0;
        goto L7
    L17:
        System.arraycopy(r106, 0, r110, r101, r100);
    L19:
        e = move-exception;
        throw new IllegalArgumentException("unable to encode parameter info: " + e.getMessage());
    L11:
        r108 = true;
        goto L12
    L22:
        this.digest.reset();
        return (int) r102;
    L25:
        throw new IllegalArgumentException("Output length too large");
    L27:
        throw new OutputLengthException("output buffer too small");
    }

    public Digest getDigest() {
        return this.digest;
    }

    @Override // org.bouncycastle.crypto.DerivationFunction
    public void init(DerivationParameters r100) {
        DHKDFParameters r101 = (DHKDFParameters) r100;
        this.algorithm = r101.getAlgorithm();
        this.keySize = r101.getKeySize();
        this.f525119z = r101.getZ();
        this.partyAInfo = r101.getExtraInfo();
    }
}
