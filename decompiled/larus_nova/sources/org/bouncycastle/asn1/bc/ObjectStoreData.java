package org.bouncycastle.asn1.bc;

import java.math.BigInteger;
import java.util.Date;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1GeneralizedTime;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERGeneralizedTime;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERUTF8String;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

/* JADX INFO: loaded from: classes42.dex */
public class ObjectStoreData extends ASN1Object {
    private final String comment;
    private final ASN1GeneralizedTime creationDate;
    private final AlgorithmIdentifier integrityAlgorithm;
    private final ASN1GeneralizedTime lastModifiedDate;
    private final ObjectDataSequence objectDataSequence;
    private final BigInteger version;

    private ObjectStoreData(ASN1Sequence r100) {
        this.version = ASN1Integer.getInstance(r100.getObjectAt(0)).getValue();
        this.integrityAlgorithm = AlgorithmIdentifier.getInstance(r100.getObjectAt(1));
        this.creationDate = ASN1GeneralizedTime.getInstance(r100.getObjectAt(2));
        this.lastModifiedDate = ASN1GeneralizedTime.getInstance(r100.getObjectAt(3));
        this.objectDataSequence = ObjectDataSequence.getInstance(r100.getObjectAt(4));
        if (r100.size() != 6) goto L5;
        String r101 = DERUTF8String.getInstance(r100.getObjectAt(5)).getString();
    L6:
        this.comment = r101;
        return;
    L5:
        r101 = null;
        goto L6
    }

    public ObjectStoreData(AlgorithmIdentifier r100, Date r101, Date r102, ObjectDataSequence r103, String r104) {
        this.version = BigInteger.valueOf(1);
        this.integrityAlgorithm = r100;
        this.creationDate = new DERGeneralizedTime(r101);
        this.lastModifiedDate = new DERGeneralizedTime(r102);
        this.objectDataSequence = r103;
        this.comment = r104;
    }

    public static ObjectStoreData getInstance(Object r100) {
        if ((r100 instanceof ObjectStoreData) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new ObjectStoreData(ASN1Sequence.getInstance(r100));
    L5:
        return (ObjectStoreData) r100;
    }

    public String getComment() {
        return this.comment;
    }

    public ASN1GeneralizedTime getCreationDate() {
        return this.creationDate;
    }

    public AlgorithmIdentifier getIntegrityAlgorithm() {
        return this.integrityAlgorithm;
    }

    public ASN1GeneralizedTime getLastModifiedDate() {
        return this.lastModifiedDate;
    }

    public ObjectDataSequence getObjectDataSequence() {
        return this.objectDataSequence;
    }

    public BigInteger getVersion() {
        return this.version;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(6);
        r100.add(new ASN1Integer(this.version));
        r100.add(this.integrityAlgorithm);
        r100.add(this.creationDate);
        r100.add(this.lastModifiedDate);
        r100.add(this.objectDataSequence);
        String r101 = this.comment;
        if (r101 == null) goto L6;
        r100.add(new DERUTF8String(r101));
    L6:
        return new DERSequence(r100);
    }
}
