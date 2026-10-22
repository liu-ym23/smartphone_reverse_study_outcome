package org.bouncycastle.asn1.esf;

import org.bouncycastle.asn1.ASN1Choice;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.oiw.OIWObjectIdentifiers;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

/* JADX INFO: loaded from: classes42.dex */
public class OtherHash extends ASN1Object implements ASN1Choice {
    private OtherHashAlgAndValue otherHash;
    private ASN1OctetString sha1Hash;

    private OtherHash(ASN1OctetString r100) {
        this.sha1Hash = r100;
    }

    public OtherHash(OtherHashAlgAndValue r100) {
        this.otherHash = r100;
    }

    public OtherHash(byte[] r100) {
        this.sha1Hash = new DEROctetString(r100);
    }

    public static OtherHash getInstance(Object r100) {
        if ((r100 instanceof OtherHash) == false) goto L7;
        return (OtherHash) r100;
    L7:
        if ((r100 instanceof ASN1OctetString) == false) goto L11;
        return new OtherHash((ASN1OctetString) r100);
    L11:
        return new OtherHash(OtherHashAlgAndValue.getInstance(r100));
    }

    public AlgorithmIdentifier getHashAlgorithm() {
        OtherHashAlgAndValue r100 = this.otherHash;
        if (r100 != null) goto L7;
        return new AlgorithmIdentifier(OIWObjectIdentifiers.idSHA1);
    L7:
        return r100.getHashAlgorithm();
    }

    public byte[] getHashValue() {
        OtherHashAlgAndValue r100 = this.otherHash;
        if (r100 != null) goto L7;
        ASN1OctetString r101 = this.sha1Hash;
    L6:
        return r101.getOctets();
    L7:
        r101 = r100.getHashValue();
        goto L6
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        OtherHashAlgAndValue r100 = this.otherHash;
        if (r100 != null) goto L7;
        return this.sha1Hash;
    L7:
        return r100.toASN1Primitive();
    }
}
