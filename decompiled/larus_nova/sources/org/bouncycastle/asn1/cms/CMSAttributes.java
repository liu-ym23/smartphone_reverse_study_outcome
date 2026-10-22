package org.bouncycastle.asn1.cms;

import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;

/* JADX INFO: loaded from: classes42.dex */
public interface CMSAttributes {
    public static final ASN1ObjectIdentifier cmsAlgorithmProtect = null;
    public static final ASN1ObjectIdentifier contentHint = null;
    public static final ASN1ObjectIdentifier contentType = null;
    public static final ASN1ObjectIdentifier counterSignature = null;
    public static final ASN1ObjectIdentifier messageDigest = null;
    public static final ASN1ObjectIdentifier signingTime = null;

    static {
        contentType = PKCSObjectIdentifiers.pkcs_9_at_contentType;
        messageDigest = PKCSObjectIdentifiers.pkcs_9_at_messageDigest;
        signingTime = PKCSObjectIdentifiers.pkcs_9_at_signingTime;
        counterSignature = PKCSObjectIdentifiers.pkcs_9_at_counterSignature;
        contentHint = PKCSObjectIdentifiers.id_aa_contentHint;
        cmsAlgorithmProtect = PKCSObjectIdentifiers.id_aa_cmsAlgorithmProtect;
    }
}
