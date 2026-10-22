package org.bouncycastle.asn1.cms;

import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;

/* JADX INFO: loaded from: classes42.dex */
public interface CMSObjectIdentifiers {
    public static final ASN1ObjectIdentifier authEnvelopedData = null;
    public static final ASN1ObjectIdentifier authenticatedData = null;
    public static final ASN1ObjectIdentifier compressedData = null;
    public static final ASN1ObjectIdentifier data = null;
    public static final ASN1ObjectIdentifier digestedData = null;
    public static final ASN1ObjectIdentifier encryptedData = null;
    public static final ASN1ObjectIdentifier envelopedData = null;
    public static final ASN1ObjectIdentifier id_ri = null;
    public static final ASN1ObjectIdentifier id_ri_ocsp_response = null;
    public static final ASN1ObjectIdentifier id_ri_scvp = null;
    public static final ASN1ObjectIdentifier signedAndEnvelopedData = null;
    public static final ASN1ObjectIdentifier signedData = null;
    public static final ASN1ObjectIdentifier timestampedData = null;

    static {
        data = PKCSObjectIdentifiers.data;
        signedData = PKCSObjectIdentifiers.signedData;
        envelopedData = PKCSObjectIdentifiers.envelopedData;
        signedAndEnvelopedData = PKCSObjectIdentifiers.signedAndEnvelopedData;
        digestedData = PKCSObjectIdentifiers.digestedData;
        encryptedData = PKCSObjectIdentifiers.encryptedData;
        authenticatedData = PKCSObjectIdentifiers.id_ct_authData;
        compressedData = PKCSObjectIdentifiers.id_ct_compressedData;
        authEnvelopedData = PKCSObjectIdentifiers.id_ct_authEnvelopedData;
        timestampedData = PKCSObjectIdentifiers.id_ct_timestampedData;
        ASN1ObjectIdentifier r100 = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.16");
        id_ri = r100;
        id_ri_ocsp_response = r100.branch("2");
        id_ri_scvp = r100.branch("4");
    }
}
