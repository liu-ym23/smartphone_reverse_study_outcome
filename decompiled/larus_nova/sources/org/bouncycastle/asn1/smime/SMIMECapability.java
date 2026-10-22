package org.bouncycastle.asn1.smime;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;

/* JADX INFO: loaded from: classes42.dex */
public class SMIMECapability extends ASN1Object {
    public static final ASN1ObjectIdentifier aES128_CBC = null;
    public static final ASN1ObjectIdentifier aES192_CBC = null;
    public static final ASN1ObjectIdentifier aES256_CBC = null;
    public static final ASN1ObjectIdentifier canNotDecryptAny = null;
    public static final ASN1ObjectIdentifier dES_CBC = null;
    public static final ASN1ObjectIdentifier dES_EDE3_CBC = null;
    public static final ASN1ObjectIdentifier preferSignedData = null;
    public static final ASN1ObjectIdentifier rC2_CBC = null;
    public static final ASN1ObjectIdentifier sMIMECapabilitiesVersions = null;
    private ASN1ObjectIdentifier capabilityID;
    private ASN1Encodable parameters;

    static {
        preferSignedData = PKCSObjectIdentifiers.preferSignedData;
        canNotDecryptAny = PKCSObjectIdentifiers.canNotDecryptAny;
        sMIMECapabilitiesVersions = PKCSObjectIdentifiers.sMIMECapabilitiesVersions;
        dES_CBC = new ASN1ObjectIdentifier("1.3.14.3.2.7");
        dES_EDE3_CBC = PKCSObjectIdentifiers.des_EDE3_CBC;
        rC2_CBC = PKCSObjectIdentifiers.RC2_CBC;
        aES128_CBC = NISTObjectIdentifiers.id_aes128_CBC;
        aES192_CBC = NISTObjectIdentifiers.id_aes192_CBC;
        aES256_CBC = NISTObjectIdentifiers.id_aes256_CBC;
    }

    public SMIMECapability(ASN1ObjectIdentifier r100, ASN1Encodable r101) {
        this.capabilityID = r100;
        this.parameters = r101;
    }

    public SMIMECapability(ASN1Sequence r100) {
        this.capabilityID = (ASN1ObjectIdentifier) r100.getObjectAt(0);
        if (r100.size() <= 1) goto L6;
        this.parameters = (ASN1Primitive) r100.getObjectAt(1);
        return;
    }

    public static SMIMECapability getInstance(Object r100) {
        if (r100 == null) goto L13;
        if ((r100 instanceof SMIMECapability) == true) goto L13;
        if ((r100 instanceof ASN1Sequence) == false) goto L11;
        return new SMIMECapability((ASN1Sequence) r100);
    L11:
        throw new IllegalArgumentException("Invalid SMIMECapability");
    L13:
        return (SMIMECapability) r100;
    }

    public ASN1ObjectIdentifier getCapabilityID() {
        return this.capabilityID;
    }

    public ASN1Encodable getParameters() {
        return this.parameters;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(2);
        r100.add(this.capabilityID);
        ASN1Encodable r101 = this.parameters;
        if (r101 == null) goto L6;
        r100.add(r101);
    L6:
        return new DERSequence(r100);
    }
}
