package org.bouncycastle.asn1.tsp;

import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

/* JADX INFO: loaded from: classes42.dex */
public class ArchiveTimeStampSequence extends ASN1Object {
    private ASN1Sequence archiveTimeStampChains;

    private ArchiveTimeStampSequence(ASN1Sequence r100) throws IllegalArgumentException {
        ASN1EncodableVector r101 = new ASN1EncodableVector(r100.size());
        Enumeration r102 = r100.getObjects();
    L4:
        if (r102.hasMoreElements() == false) goto L6;
        r101.add(ArchiveTimeStampChain.getInstance(r102.nextElement()));
        goto L4
    L6:
        this.archiveTimeStampChains = new DERSequence(r101);
    }

    public ArchiveTimeStampSequence(ArchiveTimeStampChain r100) {
        this.archiveTimeStampChains = new DERSequence(r100);
    }

    public ArchiveTimeStampSequence(ArchiveTimeStampChain[] r100) {
        this.archiveTimeStampChains = new DERSequence(r100);
    }

    public static ArchiveTimeStampSequence getInstance(Object r100) {
        if ((r100 instanceof ArchiveTimeStampChain) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new ArchiveTimeStampSequence(ASN1Sequence.getInstance(r100));
    L5:
        return (ArchiveTimeStampSequence) r100;
    }

    public ArchiveTimeStampSequence append(ArchiveTimeStampChain r100) {
        ASN1EncodableVector r101 = new ASN1EncodableVector(this.archiveTimeStampChains.size() + 1);
        int r102 = 0;
    L4:
        if (r102 == this.archiveTimeStampChains.size()) goto L6;
        r101.add(this.archiveTimeStampChains.getObjectAt(r102));
        r102 = r102 + 1;
        goto L4
    L6:
        r101.add(r100);
        return new ArchiveTimeStampSequence(new DERSequence(r101));
    }

    public ArchiveTimeStampChain[] getArchiveTimeStampChains() {
        int r100 = this.archiveTimeStampChains.size();
        ArchiveTimeStampChain[] r101 = new ArchiveTimeStampChain[r100];
        int r102 = 0;
    L3:
        if (r102 == r100) goto L5;
        r101[r102] = ArchiveTimeStampChain.getInstance(this.archiveTimeStampChains.getObjectAt(r102));
        r102 = r102 + 1;
        goto L3
    L5:
        return r101;
    }

    public int size() {
        return this.archiveTimeStampChains.size();
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.archiveTimeStampChains;
    }
}
