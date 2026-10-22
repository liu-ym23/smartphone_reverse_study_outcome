package org.bouncycastle.crypto.signers;

import java.io.IOException;
import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Encoding;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes42.dex */
public class StandardDSAEncoding implements DSAEncoding {
    public static final StandardDSAEncoding INSTANCE = null;

    static {
        INSTANCE = new StandardDSAEncoding();
    }

    public StandardDSAEncoding() {
    }

    public BigInteger checkValue(BigInteger r100, BigInteger r101) {
        if (r101.signum() < 0) goto L9;
        if (r100 != null) goto L6;
    L7:
        return r101;
    L6:
        if (r101.compareTo(r100) < 0) goto L7;
    L9:
        throw new IllegalArgumentException("Value out of range");
    }

    @Override // org.bouncycastle.crypto.signers.DSAEncoding
    public BigInteger[] decode(BigInteger r100, byte[] r101) throws IOException {
        ASN1Sequence r102 = (ASN1Sequence) ASN1Primitive.fromByteArray(r101);
        if (r102.size() != 2) goto L9;
        BigInteger r103 = decodeValue(r100, r102, 0);
        BigInteger r104 = decodeValue(r100, r102, 1);
        if (Arrays.areEqual(encode(r100, r103, r104), r101) == false) goto L9;
        return new BigInteger[]{r103, r104};
    L9:
        throw new IllegalArgumentException("Malformed signature");
    }

    public BigInteger decodeValue(BigInteger r100, ASN1Sequence r101, int r102) {
        return checkValue(r100, ((ASN1Integer) r101.getObjectAt(r102)).getValue());
    }

    @Override // org.bouncycastle.crypto.signers.DSAEncoding
    public byte[] encode(BigInteger r100, BigInteger r101, BigInteger r102) throws IOException {
        ASN1EncodableVector r103 = new ASN1EncodableVector();
        encodeValue(r100, r103, r101);
        encodeValue(r100, r103, r102);
        return new DERSequence(r103).getEncoded(ASN1Encoding.DER);
    }

    public void encodeValue(BigInteger r100, ASN1EncodableVector r101, BigInteger r102) {
        r101.add(new ASN1Integer(checkValue(r100, r102)));
    }
}
