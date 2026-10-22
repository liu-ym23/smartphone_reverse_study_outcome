package org.bouncycastle.asn1.misc;

import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes42.dex */
public class ScryptParams extends ASN1Object {
    private final BigInteger blockSize;
    private final BigInteger costParameter;
    private final BigInteger keyLength;
    private final BigInteger parallelizationParameter;
    private final byte[] salt;

    private ScryptParams(ASN1Sequence r100) {
        if (r100.size() != 4) goto L5;
    L9:
        this.salt = Arrays.clone(ASN1OctetString.getInstance(r100.getObjectAt(0)).getOctets());
        this.costParameter = ASN1Integer.getInstance(r100.getObjectAt(1)).getValue();
        this.blockSize = ASN1Integer.getInstance(r100.getObjectAt(2)).getValue();
        this.parallelizationParameter = ASN1Integer.getInstance(r100.getObjectAt(3)).getValue();
        if (r100.size() != 5) goto L12;
        BigInteger r101 = ASN1Integer.getInstance(r100.getObjectAt(4)).getValue();
    L13:
        this.keyLength = r101;
        return;
    L12:
        r101 = null;
        goto L13
    L5:
        if (r100.size() == 5) goto L9;
        throw new IllegalArgumentException("invalid sequence: size = " + r100.size());
    }

    public ScryptParams(byte[] r100, int r110, int r111, int r112) {
        this(r100, BigInteger.valueOf(r110), BigInteger.valueOf(r111), BigInteger.valueOf(r112), null);
    }

    public ScryptParams(byte[] r100, int r110, int r111, int r112, int r113) {
        this(r100, BigInteger.valueOf(r110), BigInteger.valueOf(r111), BigInteger.valueOf(r112), BigInteger.valueOf(r113));
    }

    public ScryptParams(byte[] r100, BigInteger r101, BigInteger r102, BigInteger r103, BigInteger r104) {
        this.salt = Arrays.clone(r100);
        this.costParameter = r101;
        this.blockSize = r102;
        this.parallelizationParameter = r103;
        this.keyLength = r104;
    }

    public static ScryptParams getInstance(Object r100) {
        if ((r100 instanceof ScryptParams) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new ScryptParams(ASN1Sequence.getInstance(r100));
    L5:
        return (ScryptParams) r100;
    }

    public BigInteger getBlockSize() {
        return this.blockSize;
    }

    public BigInteger getCostParameter() {
        return this.costParameter;
    }

    public BigInteger getKeyLength() {
        return this.keyLength;
    }

    public BigInteger getParallelizationParameter() {
        return this.parallelizationParameter;
    }

    public byte[] getSalt() {
        return Arrays.clone(this.salt);
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(5);
        r100.add(new DEROctetString(this.salt));
        r100.add(new ASN1Integer(this.costParameter));
        r100.add(new ASN1Integer(this.blockSize));
        r100.add(new ASN1Integer(this.parallelizationParameter));
        BigInteger r101 = this.keyLength;
        if (r101 == null) goto L6;
        r100.add(new ASN1Integer(r101));
    L6:
        return new DERSequence(r100);
    }
}
