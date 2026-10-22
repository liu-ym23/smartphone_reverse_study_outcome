package org.bouncycastle.asn1.cmp;

import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

/* JADX INFO: loaded from: classes42.dex */
public class PollReqContent extends ASN1Object {
    private ASN1Sequence content;

    public PollReqContent(BigInteger r100) {
        this(new ASN1Integer(r100));
    }

    public PollReqContent(ASN1Integer r100) {
        this(new DERSequence(new DERSequence(r100)));
    }

    private PollReqContent(ASN1Sequence r100) {
        this.content = r100;
    }

    public PollReqContent(BigInteger[] r100) {
        this(intsToASN1(r100));
    }

    public PollReqContent(ASN1Integer[] r100) {
        this(new DERSequence(intsToSequence(r100)));
    }

    public static PollReqContent getInstance(Object r100) {
        if ((r100 instanceof PollReqContent) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new PollReqContent(ASN1Sequence.getInstance(r100));
    L5:
        return (PollReqContent) r100;
    }

    private static ASN1Integer[] intsToASN1(BigInteger[] r100) {
        int r101 = r100.length;
        ASN1Integer[] r102 = new ASN1Integer[r101];
        int r103 = 0;
    L3:
        if (r103 == r101) goto L5;
        r102[r103] = new ASN1Integer(r100[r103]);
        r103 = r103 + 1;
        goto L3
    L5:
        return r102;
    }

    private static DERSequence[] intsToSequence(ASN1Integer[] r100) {
        int r101 = r100.length;
        DERSequence[] r102 = new DERSequence[r101];
        int r103 = 0;
    L3:
        if (r103 == r101) goto L5;
        r102[r103] = new DERSequence(r100[r103]);
        r103 = r103 + 1;
        goto L3
    L5:
        return r102;
    }

    private static ASN1Integer[] sequenceToASN1IntegerArray(ASN1Sequence r100) {
        int r101 = r100.size();
        ASN1Integer[] r102 = new ASN1Integer[r101];
        int r103 = 0;
    L3:
        if (r103 == r101) goto L5;
        r102[r103] = ASN1Integer.getInstance(r100.getObjectAt(r103));
        r103 = r103 + 1;
        goto L3
    L5:
        return r102;
    }

    public BigInteger[] getCertReqIdValues() {
        int r100 = this.content.size();
        BigInteger[] r101 = new BigInteger[r100];
        int r102 = 0;
    L3:
        if (r102 == r100) goto L5;
        r101[r102] = ASN1Integer.getInstance(ASN1Sequence.getInstance(this.content.getObjectAt(r102)).getObjectAt(0)).getValue();
        r102 = r102 + 1;
        goto L3
    L5:
        return r101;
    }

    public ASN1Integer[][] getCertReqIds() {
        int r100 = this.content.size();
        ASN1Integer[][] r101 = new ASN1Integer[r100][];
        int r102 = 0;
    L3:
        if (r102 == r100) goto L5;
        r101[r102] = sequenceToASN1IntegerArray((ASN1Sequence) this.content.getObjectAt(r102));
        r102 = r102 + 1;
        goto L3
    L5:
        return r101;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.content;
    }
}
