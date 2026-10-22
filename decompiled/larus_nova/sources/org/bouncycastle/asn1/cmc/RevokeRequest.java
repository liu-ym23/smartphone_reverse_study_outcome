package org.bouncycastle.asn1.cmc;

import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1GeneralizedTime;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERUTF8String;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x509.CRLReason;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes42.dex */
public class RevokeRequest extends ASN1Object {
    private DERUTF8String comment;
    private ASN1GeneralizedTime invalidityDate;
    private final X500Name name;
    private ASN1OctetString passphrase;
    private final CRLReason reason;
    private final ASN1Integer serialNumber;

    private RevokeRequest(ASN1Sequence r100) {
        int r101 = 3;
        if (r100.size() < 3) goto L23;
        if (r100.size() > 6) goto L23;
        this.name = X500Name.getInstance(r100.getObjectAt(0));
        this.serialNumber = ASN1Integer.getInstance(r100.getObjectAt(1));
        this.reason = CRLReason.getInstance(r100.getObjectAt(2));
        if (r100.size() <= 3) goto L12;
        if ((r100.getObjectAt(3).toASN1Primitive() instanceof ASN1GeneralizedTime) == false) goto L12;
        this.invalidityDate = ASN1GeneralizedTime.getInstance(r100.getObjectAt(3));
        r101 = 4;
    L12:
        if (r100.size() <= r101) goto L17;
        if ((r100.getObjectAt(r101).toASN1Primitive() instanceof ASN1OctetString) == false) goto L17;
        int r102 = r101 + 1;
        this.passphrase = ASN1OctetString.getInstance(r100.getObjectAt(r101));
        r101 = r102;
    L17:
        if (r100.size() > r101) goto L19;
        return;
    L19:
        if ((r100.getObjectAt(r101).toASN1Primitive() instanceof DERUTF8String) == false) goto L25;
        this.comment = DERUTF8String.getInstance(r100.getObjectAt(r101));
        return;
    L25:
        return;
    L23:
        throw new IllegalArgumentException("incorrect sequence size");
    }

    public RevokeRequest(X500Name r100, ASN1Integer r101, CRLReason r102, ASN1GeneralizedTime r103, ASN1OctetString r104, DERUTF8String r105) {
        this.name = r100;
        this.serialNumber = r101;
        this.reason = r102;
        this.invalidityDate = r103;
        this.passphrase = r104;
        this.comment = r105;
    }

    public static RevokeRequest getInstance(Object r100) {
        if ((r100 instanceof RevokeRequest) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new RevokeRequest(ASN1Sequence.getInstance(r100));
    L5:
        return (RevokeRequest) r100;
    }

    public DERUTF8String getComment() {
        return this.comment;
    }

    public ASN1GeneralizedTime getInvalidityDate() {
        return this.invalidityDate;
    }

    public X500Name getName() {
        return this.name;
    }

    public byte[] getPassPhrase() {
        ASN1OctetString r100 = this.passphrase;
        if (r100 != null) goto L5;
        return null;
    L5:
        return Arrays.clone(r100.getOctets());
    }

    public ASN1OctetString getPassphrase() {
        return this.passphrase;
    }

    public CRLReason getReason() {
        return this.reason;
    }

    public BigInteger getSerialNumber() {
        return this.serialNumber.getValue();
    }

    public void setComment(DERUTF8String r100) {
        this.comment = r100;
    }

    public void setInvalidityDate(ASN1GeneralizedTime r100) {
        this.invalidityDate = r100;
    }

    public void setPassphrase(ASN1OctetString r100) {
        this.passphrase = r100;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(6);
        r100.add(this.name);
        r100.add(this.serialNumber);
        r100.add(this.reason);
        ASN1GeneralizedTime r101 = this.invalidityDate;
        if (r101 == null) goto L5;
        r100.add(r101);
    L5:
        ASN1OctetString r102 = this.passphrase;
        if (r102 == null) goto L8;
        r100.add(r102);
    L8:
        DERUTF8String r103 = this.comment;
        if (r103 == null) goto L12;
        r100.add(r103);
    L12:
        return new DERSequence(r100);
    }
}
