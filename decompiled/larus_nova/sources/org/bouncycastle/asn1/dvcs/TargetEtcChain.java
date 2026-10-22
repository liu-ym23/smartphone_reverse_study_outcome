package org.bouncycastle.asn1.dvcs;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;

/* JADX INFO: loaded from: classes42.dex */
public class TargetEtcChain extends ASN1Object {
    private ASN1Sequence chain;
    private PathProcInput pathProcInput;
    private CertEtcToken target;

    private TargetEtcChain(ASN1Sequence r100) {
        this.target = CertEtcToken.getInstance(r100.getObjectAt(0));
        if (r100.size() <= 1) goto L11;
        ASN1Encodable r101 = r100.getObjectAt(1);
        if ((r101 instanceof ASN1TaggedObject) == false) goto L7;
        extractPathProcInput(r101);
        return;
    L7:
        this.chain = ASN1Sequence.getInstance(r101);
        if (r100.size() <= 2) goto L13;
        extractPathProcInput(r100.getObjectAt(2));
        return;
    L13:
        return;
    }

    public TargetEtcChain(CertEtcToken r100) {
        this(r100, null, null);
    }

    public TargetEtcChain(CertEtcToken r100, PathProcInput r101) {
        this(r100, null, r101);
    }

    public TargetEtcChain(CertEtcToken r100, CertEtcToken[] r101) {
        this(r100, r101, null);
    }

    public TargetEtcChain(CertEtcToken r100, CertEtcToken[] r101, PathProcInput r102) {
        this.target = r100;
        if (r101 == null) goto L5;
        this.chain = new DERSequence(r101);
    L5:
        this.pathProcInput = r102;
    }

    public static TargetEtcChain[] arrayFromSequence(ASN1Sequence r100) {
        int r101 = r100.size();
        TargetEtcChain[] r102 = new TargetEtcChain[r101];
        int r103 = 0;
    L3:
        if (r103 == r101) goto L5;
        r102[r103] = getInstance(r100.getObjectAt(r103));
        r103 = r103 + 1;
        goto L3
    L5:
        return r102;
    }

    private void extractPathProcInput(ASN1Encodable r100) {
        ASN1TaggedObject r101 = ASN1TaggedObject.getInstance(r100);
        if (r101.getTagNo() != 0) goto L7;
        this.pathProcInput = PathProcInput.getInstance(r101, false);
        return;
    L7:
        throw new IllegalArgumentException("Unknown tag encountered: " + r101.getTagNo());
    }

    public static TargetEtcChain getInstance(Object r100) {
        if ((r100 instanceof TargetEtcChain) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new TargetEtcChain(ASN1Sequence.getInstance(r100));
    L5:
        return (TargetEtcChain) r100;
    }

    public static TargetEtcChain getInstance(ASN1TaggedObject r100, boolean r101) {
        return getInstance(ASN1Sequence.getInstance(r100, r101));
    }

    public CertEtcToken[] getChain() {
        ASN1Sequence r100 = this.chain;
        if (r100 != null) goto L5;
        return null;
    L5:
        return CertEtcToken.arrayFromSequence(r100);
    }

    public PathProcInput getPathProcInput() {
        return this.pathProcInput;
    }

    public CertEtcToken getTarget() {
        return this.target;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(3);
        r100.add(this.target);
        ASN1Sequence r101 = this.chain;
        if (r101 == null) goto L5;
        r100.add(r101);
    L5:
        PathProcInput r102 = this.pathProcInput;
        if (r102 == null) goto L9;
        r100.add(new DERTaggedObject(false, 0, r102));
    L9:
        return new DERSequence(r100);
    }

    public String toString() {
        StringBuffer r100 = new StringBuffer("TargetEtcChain {\n");
        r100.append("target: " + this.target + "\n");
        if (this.chain == null) goto L6;
        r100.append("chain: " + this.chain + "\n");
    L6:
        if (this.pathProcInput == null) goto L8;
        r100.append("pathProcInput: " + this.pathProcInput + "\n");
    L8:
        r100.append("}\n");
        return r100.toString();
    }
}
