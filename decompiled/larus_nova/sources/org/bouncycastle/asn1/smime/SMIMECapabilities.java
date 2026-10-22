package org.bouncycastle.asn1.smime;

import java.util.Enumeration;
import java.util.Vector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.cms.Attribute;
import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;

/* JADX INFO: loaded from: classes42.dex */
public class SMIMECapabilities extends ASN1Object {
    public static final ASN1ObjectIdentifier aes128_CBC = null;
    public static final ASN1ObjectIdentifier aes192_CBC = null;
    public static final ASN1ObjectIdentifier aes256_CBC = null;
    public static final ASN1ObjectIdentifier canNotDecryptAny = null;
    public static final ASN1ObjectIdentifier cast5_CBC = null;
    public static final ASN1ObjectIdentifier dES_CBC = null;
    public static final ASN1ObjectIdentifier dES_EDE3_CBC = null;
    public static final ASN1ObjectIdentifier idea_CBC = null;
    public static final ASN1ObjectIdentifier preferSignedData = null;
    public static final ASN1ObjectIdentifier rC2_CBC = null;
    public static final ASN1ObjectIdentifier sMIMECapabilitesVersions = null;
    private ASN1Sequence capabilities;

    static {
        preferSignedData = PKCSObjectIdentifiers.preferSignedData;
        canNotDecryptAny = PKCSObjectIdentifiers.canNotDecryptAny;
        sMIMECapabilitesVersions = PKCSObjectIdentifiers.sMIMECapabilitiesVersions;
        aes256_CBC = NISTObjectIdentifiers.id_aes256_CBC;
        aes192_CBC = NISTObjectIdentifiers.id_aes192_CBC;
        aes128_CBC = NISTObjectIdentifiers.id_aes128_CBC;
        idea_CBC = new ASN1ObjectIdentifier("1.3.6.1.4.1.188.7.1.1.2");
        cast5_CBC = new ASN1ObjectIdentifier("1.2.840.113533.7.66.10");
        dES_CBC = new ASN1ObjectIdentifier("1.3.14.3.2.7");
        dES_EDE3_CBC = PKCSObjectIdentifiers.des_EDE3_CBC;
        rC2_CBC = PKCSObjectIdentifiers.RC2_CBC;
    }

    public SMIMECapabilities(ASN1Sequence r100) {
        this.capabilities = r100;
    }

    public static SMIMECapabilities getInstance(Object r100) {
        if (r100 == null) goto L17;
        if ((r100 instanceof SMIMECapabilities) == true) goto L17;
        if ((r100 instanceof ASN1Sequence) == false) goto L11;
        return new SMIMECapabilities((ASN1Sequence) r100);
    L11:
        if ((r100 instanceof Attribute) == false) goto L15;
        return new SMIMECapabilities((ASN1Sequence) ((Attribute) r100).getAttrValues().getObjectAt(0));
    L15:
        throw new IllegalArgumentException("unknown object in factory: ".concat(r100.getClass().getName()));
    L17:
        return (SMIMECapabilities) r100;
    }

    public Vector getCapabilities(ASN1ObjectIdentifier r100) {
        Enumeration r101 = this.capabilities.getObjects();
        Vector r102 = new Vector();
        if (r100 != null) goto L8;
    L5:
        if (r101.hasMoreElements() == false) goto L12;
        r102.addElement(SMIMECapability.getInstance(r101.nextElement()));
    L12:
        return r102;
    L8:
        if (r101.hasMoreElements() == false) goto L12;
        SMIMECapability r103 = SMIMECapability.getInstance(r101.nextElement());
        if (r100.equals(r103.getCapabilityID()) == false) goto L8;
        r102.addElement(r103);
        goto L8
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.capabilities;
    }
}
