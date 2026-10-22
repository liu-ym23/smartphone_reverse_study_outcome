package org.bouncycastle.asn1.crmf;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.cms.IssuerAndSerialNumber;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes42.dex */
public class DhSigStatic extends ASN1Object {
    private final ASN1OctetString hashValue;
    private final IssuerAndSerialNumber issuerAndSerial;

    private DhSigStatic(ASN1Sequence r100) {
        if (r100.size() != 1) goto L7;
        this.issuerAndSerial = null;
        ASN1Encodable r101 = r100.getObjectAt(0);
    L5:
        this.hashValue = ASN1OctetString.getInstance(r101);
        return;
    L7:
        if (r100.size() != 2) goto L11;
        this.issuerAndSerial = IssuerAndSerialNumber.getInstance(r100.getObjectAt(0));
        r101 = r100.getObjectAt(1);
        goto L5
    L11:
        throw new IllegalArgumentException("sequence wrong length for DhSigStatic");
    }

    public DhSigStatic(IssuerAndSerialNumber r100, byte[] r101) {
        this.issuerAndSerial = r100;
        this.hashValue = new DEROctetString(Arrays.clone(r101));
    }

    public DhSigStatic(byte[] r100) {
        this(null, r100);
    }

    public static DhSigStatic getInstance(Object r100) {
        if ((r100 instanceof DhSigStatic) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new DhSigStatic(ASN1Sequence.getInstance(r100));
    L5:
        return (DhSigStatic) r100;
    }

    public byte[] getHashValue() {
        return Arrays.clone(this.hashValue.getOctets());
    }

    public IssuerAndSerialNumber getIssuerAndSerial() {
        return this.issuerAndSerial;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(2);
        IssuerAndSerialNumber r101 = this.issuerAndSerial;
        if (r101 == null) goto L5;
        r100.add(r101);
    L5:
        r100.add(this.hashValue);
        return new DERSequence(r100);
    }
}
