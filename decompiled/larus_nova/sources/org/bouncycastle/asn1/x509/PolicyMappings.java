package org.bouncycastle.asn1.x509;

import java.util.Enumeration;
import java.util.Hashtable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

/* JADX INFO: loaded from: classes42.dex */
public class PolicyMappings extends ASN1Object {
    ASN1Sequence seq;

    public PolicyMappings(Hashtable r100) {
        this.seq = null;
        ASN1EncodableVector r101 = new ASN1EncodableVector(r100.size());
        Enumeration r102 = r100.keys();
    L4:
        if (r102.hasMoreElements() == false) goto L6;
        String r103 = (String) r102.nextElement();
        String r104 = (String) r100.get(r103);
        ASN1EncodableVector r105 = new ASN1EncodableVector(2);
        r105.add(new ASN1ObjectIdentifier(r103));
        r105.add(new ASN1ObjectIdentifier(r104));
        r101.add(new DERSequence(r105));
        goto L4
    L6:
        this.seq = new DERSequence(r101);
    }

    private PolicyMappings(ASN1Sequence r100) {
        this.seq = r100;
    }

    public PolicyMappings(CertPolicyId r100, CertPolicyId r101) {
        this.seq = null;
        ASN1EncodableVector r102 = new ASN1EncodableVector(2);
        r102.add(r100);
        r102.add(r101);
        this.seq = new DERSequence(new DERSequence(r102));
    }

    public PolicyMappings(CertPolicyId[] r100, CertPolicyId[] r101) {
        this.seq = null;
        ASN1EncodableVector r102 = new ASN1EncodableVector(r100.length);
        int r103 = 0;
    L4:
        if (r103 == r100.length) goto L6;
        ASN1EncodableVector r104 = new ASN1EncodableVector(2);
        r104.add(r100[r103]);
        r104.add(r101[r103]);
        r102.add(new DERSequence(r104));
        r103 = r103 + 1;
        goto L4
    L6:
        this.seq = new DERSequence(r102);
    }

    public static PolicyMappings getInstance(Object r100) {
        if ((r100 instanceof PolicyMappings) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new PolicyMappings(ASN1Sequence.getInstance(r100));
    L5:
        return (PolicyMappings) r100;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.seq;
    }
}
