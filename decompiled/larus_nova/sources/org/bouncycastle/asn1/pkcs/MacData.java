package org.bouncycastle.asn1.pkcs;

import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x509.DigestInfo;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes42.dex */
public class MacData extends ASN1Object {
    private static final BigInteger ONE = null;
    DigestInfo digInfo;
    BigInteger iterationCount;
    byte[] salt;

    static {
        ONE = BigInteger.valueOf(1);
    }

    private MacData(ASN1Sequence r100) {
        this.digInfo = DigestInfo.getInstance(r100.getObjectAt(0));
        this.salt = Arrays.clone(ASN1OctetString.getInstance(r100.getObjectAt(1)).getOctets());
        if (r100.size() != 3) goto L5;
        BigInteger r101 = ASN1Integer.getInstance(r100.getObjectAt(2)).getValue();
    L6:
        this.iterationCount = r101;
        return;
    L5:
        r101 = ONE;
        goto L6
    }

    public MacData(DigestInfo r100, byte[] r101, int r102) {
        this.digInfo = r100;
        this.salt = Arrays.clone(r101);
        this.iterationCount = BigInteger.valueOf(r102);
    }

    public static MacData getInstance(Object r100) {
        if ((r100 instanceof MacData) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new MacData(ASN1Sequence.getInstance(r100));
    L5:
        return (MacData) r100;
    }

    public BigInteger getIterationCount() {
        return this.iterationCount;
    }

    public DigestInfo getMac() {
        return this.digInfo;
    }

    public byte[] getSalt() {
        return Arrays.clone(this.salt);
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(3);
        r100.add(this.digInfo);
        r100.add(new DEROctetString(this.salt));
        if (this.iterationCount.equals(ONE) == true) goto L6;
        r100.add(new ASN1Integer(this.iterationCount));
    L6:
        return new DERSequence(r100);
    }
}
