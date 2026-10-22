package org.bouncycastle.asn1.bc;

import java.math.BigInteger;
import java.util.Date;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1GeneralizedTime;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERGeneralizedTime;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERUTF8String;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes42.dex */
public class ObjectData extends ASN1Object {
    private final String comment;
    private final ASN1GeneralizedTime creationDate;
    private final ASN1OctetString data;
    private final String identifier;
    private final ASN1GeneralizedTime lastModifiedDate;
    private final BigInteger type;

    public ObjectData(BigInteger r100, String r101, Date r102, Date r103, byte[] r104, String r105) {
        this.type = r100;
        this.identifier = r101;
        this.creationDate = new DERGeneralizedTime(r102);
        this.lastModifiedDate = new DERGeneralizedTime(r103);
        this.data = new DEROctetString(Arrays.clone(r104));
        this.comment = r105;
    }

    private ObjectData(ASN1Sequence r100) {
        this.type = ASN1Integer.getInstance(r100.getObjectAt(0)).getValue();
        this.identifier = DERUTF8String.getInstance(r100.getObjectAt(1)).getString();
        this.creationDate = ASN1GeneralizedTime.getInstance(r100.getObjectAt(2));
        this.lastModifiedDate = ASN1GeneralizedTime.getInstance(r100.getObjectAt(3));
        this.data = ASN1OctetString.getInstance(r100.getObjectAt(4));
        if (r100.size() != 6) goto L5;
        String r101 = DERUTF8String.getInstance(r100.getObjectAt(5)).getString();
    L6:
        this.comment = r101;
        return;
    L5:
        r101 = null;
        goto L6
    }

    public static ObjectData getInstance(Object r100) {
        if ((r100 instanceof ObjectData) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new ObjectData(ASN1Sequence.getInstance(r100));
    L5:
        return (ObjectData) r100;
    }

    public String getComment() {
        return this.comment;
    }

    public ASN1GeneralizedTime getCreationDate() {
        return this.creationDate;
    }

    public byte[] getData() {
        return Arrays.clone(this.data.getOctets());
    }

    public String getIdentifier() {
        return this.identifier;
    }

    public ASN1GeneralizedTime getLastModifiedDate() {
        return this.lastModifiedDate;
    }

    public BigInteger getType() {
        return this.type;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(6);
        r100.add(new ASN1Integer(this.type));
        r100.add(new DERUTF8String(this.identifier));
        r100.add(this.creationDate);
        r100.add(this.lastModifiedDate);
        r100.add(this.data);
        String r101 = this.comment;
        if (r101 == null) goto L6;
        r100.add(new DERUTF8String(r101));
    L6:
        return new DERSequence(r100);
    }
}
