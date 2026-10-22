package org.bouncycastle.asn1.tsp;

import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

/* JADX INFO: loaded from: classes42.dex */
public class ArchiveTimeStampChain extends ASN1Object {
    private ASN1Sequence archiveTimestamps;

    private ArchiveTimeStampChain(ASN1Sequence r100) {
        ASN1EncodableVector r101 = new ASN1EncodableVector(r100.size());
        Enumeration r102 = r100.getObjects();
    L4:
        if (r102.hasMoreElements() == false) goto L6;
        r101.add(ArchiveTimeStamp.getInstance(r102.nextElement()));
        goto L4
    L6:
        this.archiveTimestamps = new DERSequence(r101);
    }

    public ArchiveTimeStampChain(ArchiveTimeStamp r100) {
        this.archiveTimestamps = new DERSequence(r100);
    }

    public ArchiveTimeStampChain(ArchiveTimeStamp[] r100) {
        this.archiveTimestamps = new DERSequence(r100);
    }

    public static ArchiveTimeStampChain getInstance(Object r100) {
        if ((r100 instanceof ArchiveTimeStampChain) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new ArchiveTimeStampChain(ASN1Sequence.getInstance(r100));
    L5:
        return (ArchiveTimeStampChain) r100;
    }

    public ArchiveTimeStampChain append(ArchiveTimeStamp r100) {
        ASN1EncodableVector r101 = new ASN1EncodableVector(this.archiveTimestamps.size() + 1);
        int r102 = 0;
    L4:
        if (r102 == this.archiveTimestamps.size()) goto L6;
        r101.add(this.archiveTimestamps.getObjectAt(r102));
        r102 = r102 + 1;
        goto L4
    L6:
        r101.add(r100);
        return new ArchiveTimeStampChain(new DERSequence(r101));
    }

    public ArchiveTimeStamp[] getArchiveTimestamps() {
        int r100 = this.archiveTimestamps.size();
        ArchiveTimeStamp[] r101 = new ArchiveTimeStamp[r100];
        int r102 = 0;
    L3:
        if (r102 == r100) goto L5;
        r101[r102] = ArchiveTimeStamp.getInstance(this.archiveTimestamps.getObjectAt(r102));
        r102 = r102 + 1;
        goto L3
    L5:
        return r101;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.archiveTimestamps;
    }
}
