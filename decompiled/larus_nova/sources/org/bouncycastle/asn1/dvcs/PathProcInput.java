package org.bouncycastle.asn1.dvcs;

import java.util.Arrays;
import org.bouncycastle.asn1.ASN1Boolean;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.x509.PolicyInformation;

/* JADX INFO: loaded from: classes42.dex */
public class PathProcInput extends ASN1Object {
    private PolicyInformation[] acceptablePolicySet;
    private boolean explicitPolicyReqd;
    private boolean inhibitAnyPolicy;
    private boolean inhibitPolicyMapping;

    public PathProcInput(PolicyInformation[] r100) {
        this.inhibitPolicyMapping = false;
        this.explicitPolicyReqd = false;
        this.inhibitAnyPolicy = false;
        this.acceptablePolicySet = copy(r100);
    }

    public PathProcInput(PolicyInformation[] r100, boolean r101, boolean r102, boolean r103) {
        this.inhibitPolicyMapping = false;
        this.explicitPolicyReqd = false;
        this.inhibitAnyPolicy = false;
        this.acceptablePolicySet = copy(r100);
        this.inhibitPolicyMapping = r101;
        this.explicitPolicyReqd = r102;
        this.inhibitAnyPolicy = r103;
    }

    private PolicyInformation[] copy(PolicyInformation[] r100) {
        int r101 = r100.length;
        PolicyInformation[] r102 = new PolicyInformation[r101];
        System.arraycopy(r100, 0, r102, 0, r101);
        return r102;
    }

    private static PolicyInformation[] fromSequence(ASN1Sequence r100) {
        int r101 = r100.size();
        PolicyInformation[] r102 = new PolicyInformation[r101];
        int r103 = 0;
    L3:
        if (r103 == r101) goto L5;
        r102[r103] = PolicyInformation.getInstance(r100.getObjectAt(r103));
        r103 = r103 + 1;
        goto L3
    L5:
        return r102;
    }

    public static PathProcInput getInstance(Object r100) {
        if ((r100 instanceof PathProcInput) == true) goto L5;
        if (r100 == null) goto L24;
        ASN1Sequence r101 = ASN1Sequence.getInstance(r100);
        PathProcInput r102 = new PathProcInput(fromSequence(ASN1Sequence.getInstance(r101.getObjectAt(0))));
        int r103 = 1;
    L9:
        if (r103 >= r101.size()) goto L23;
        ASN1Encodable r104 = r101.getObjectAt(r103);
        if ((r104 instanceof ASN1Boolean) == false) goto L14;
        r102.setInhibitPolicyMapping(ASN1Boolean.getInstance(r104).isTrue());
    L22:
        r103 = r103 + 1;
        goto L9
    L14:
        if ((r104 instanceof ASN1TaggedObject) == false) goto L22;
        ASN1TaggedObject r105 = ASN1TaggedObject.getInstance(r104);
        int r106 = r105.getTagNo();
        if (r106 == 0) goto L21;
        if (r106 != 1) goto L20;
        r102.setInhibitAnyPolicy(ASN1Boolean.getInstance(r105, false).isTrue());
        goto L22
    L20:
        throw new IllegalArgumentException("Unknown tag encountered: " + r105.getTagNo());
    L21:
        r102.setExplicitPolicyReqd(ASN1Boolean.getInstance(r105, false).isTrue());
        goto L22
    L23:
        return r102;
    L24:
        return null;
    L5:
        return (PathProcInput) r100;
    }

    public static PathProcInput getInstance(ASN1TaggedObject r100, boolean r101) {
        return getInstance(ASN1Sequence.getInstance(r100, r101));
    }

    private void setExplicitPolicyReqd(boolean r100) {
        this.explicitPolicyReqd = r100;
    }

    private void setInhibitAnyPolicy(boolean r100) {
        this.inhibitAnyPolicy = r100;
    }

    private void setInhibitPolicyMapping(boolean r100) {
        this.inhibitPolicyMapping = r100;
    }

    public PolicyInformation[] getAcceptablePolicySet() {
        return copy(this.acceptablePolicySet);
    }

    public boolean isExplicitPolicyReqd() {
        return this.explicitPolicyReqd;
    }

    public boolean isInhibitAnyPolicy() {
        return this.inhibitAnyPolicy;
    }

    public boolean isInhibitPolicyMapping() {
        return this.inhibitPolicyMapping;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(4);
        ASN1EncodableVector r101 = new ASN1EncodableVector(this.acceptablePolicySet.length);
        int r102 = 0;
    L3:
        PolicyInformation[] r103 = this.acceptablePolicySet;
        if (r102 == r103.length) goto L6;
        r101.add(r103[r102]);
        r102 = r102 + 1;
        goto L3
    L6:
        r100.add(new DERSequence(r101));
        boolean r104 = this.inhibitPolicyMapping;
        if (r104 == false) goto L9;
        r100.add(ASN1Boolean.getInstance(r104));
    L9:
        boolean r105 = this.explicitPolicyReqd;
        if (r105 == false) goto L12;
        r100.add(new DERTaggedObject(false, 0, ASN1Boolean.getInstance(r105)));
    L12:
        boolean r106 = this.inhibitAnyPolicy;
        if (r106 == false) goto L16;
        r100.add(new DERTaggedObject(false, 1, ASN1Boolean.getInstance(r106)));
    L16:
        return new DERSequence(r100);
    }

    public String toString() {
        return "PathProcInput: {\nacceptablePolicySet: " + Arrays.asList(this.acceptablePolicySet) + "\ninhibitPolicyMapping: " + this.inhibitPolicyMapping + "\nexplicitPolicyReqd: " + this.explicitPolicyReqd + "\ninhibitAnyPolicy: " + this.inhibitAnyPolicy + "\n}\n";
    }
}
