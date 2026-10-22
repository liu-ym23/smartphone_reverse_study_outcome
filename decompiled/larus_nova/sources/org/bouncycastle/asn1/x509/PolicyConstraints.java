package org.bouncycastle.asn1.x509;

import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;

/* JADX INFO: loaded from: classes42.dex */
public class PolicyConstraints extends ASN1Object {
    private BigInteger inhibitPolicyMapping;
    private BigInteger requireExplicitPolicyMapping;

    public PolicyConstraints(BigInteger r100, BigInteger r101) {
        this.requireExplicitPolicyMapping = r100;
        this.inhibitPolicyMapping = r101;
    }

    private PolicyConstraints(ASN1Sequence r100) {
        int r101 = 0;
    L4:
        if (r101 == r100.size()) goto L14;
        ASN1TaggedObject r102 = ASN1TaggedObject.getInstance(r100.getObjectAt(r101));
        if (r102.getTagNo() != 0) goto L9;
        this.requireExplicitPolicyMapping = ASN1Integer.getInstance(r102, false).getValue();
    L11:
        r101 = r101 + 1;
        goto L4
    L9:
        if (r102.getTagNo() != 1) goto L13;
        this.inhibitPolicyMapping = ASN1Integer.getInstance(r102, false).getValue();
        goto L11
    L13:
        throw new IllegalArgumentException("Unknown tag encountered.");
    }

    public static PolicyConstraints fromExtensions(Extensions r100) {
        return getInstance(Extensions.getExtensionParsedValue(r100, Extension.policyConstraints));
    }

    public static PolicyConstraints getInstance(Object r100) {
        if ((r100 instanceof PolicyConstraints) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new PolicyConstraints(ASN1Sequence.getInstance(r100));
    L5:
        return (PolicyConstraints) r100;
    }

    public BigInteger getInhibitPolicyMapping() {
        return this.inhibitPolicyMapping;
    }

    public BigInteger getRequireExplicitPolicyMapping() {
        return this.requireExplicitPolicyMapping;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(2);
        BigInteger r101 = this.requireExplicitPolicyMapping;
        if (r101 == null) goto L5;
        r100.add(new DERTaggedObject(false, 0, new ASN1Integer(r101)));
    L5:
        BigInteger r102 = this.inhibitPolicyMapping;
        if (r102 == null) goto L9;
        r100.add(new DERTaggedObject(false, 1, new ASN1Integer(r102)));
    L9:
        return new DERSequence(r100);
    }
}
