package org.bouncycastle.asn1.esf;

import com.bytedance.bdlocation.exception.BDLocationException;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;

/* JADX INFO: loaded from: classes42.dex */
public interface ESFAttributes {
    public static final ASN1ObjectIdentifier archiveTimestamp = null;
    public static final ASN1ObjectIdentifier archiveTimestampV2 = null;
    public static final ASN1ObjectIdentifier certCRLTimestamp = null;
    public static final ASN1ObjectIdentifier certValues = null;
    public static final ASN1ObjectIdentifier certificateRefs = null;
    public static final ASN1ObjectIdentifier commitmentType = null;
    public static final ASN1ObjectIdentifier contentTimestamp = null;
    public static final ASN1ObjectIdentifier escTimeStamp = null;
    public static final ASN1ObjectIdentifier otherSigCert = null;
    public static final ASN1ObjectIdentifier revocationRefs = null;
    public static final ASN1ObjectIdentifier revocationValues = null;
    public static final ASN1ObjectIdentifier sigPolicyId = null;
    public static final ASN1ObjectIdentifier signerAttr = null;
    public static final ASN1ObjectIdentifier signerLocation = null;

    static {
        sigPolicyId = PKCSObjectIdentifiers.id_aa_ets_sigPolicyId;
        commitmentType = PKCSObjectIdentifiers.id_aa_ets_commitmentType;
        signerLocation = PKCSObjectIdentifiers.id_aa_ets_signerLocation;
        signerAttr = PKCSObjectIdentifiers.id_aa_ets_signerAttr;
        otherSigCert = PKCSObjectIdentifiers.id_aa_ets_otherSigCert;
        contentTimestamp = PKCSObjectIdentifiers.id_aa_ets_contentTimestamp;
        certificateRefs = PKCSObjectIdentifiers.id_aa_ets_certificateRefs;
        revocationRefs = PKCSObjectIdentifiers.id_aa_ets_revocationRefs;
        certValues = PKCSObjectIdentifiers.id_aa_ets_certValues;
        revocationValues = PKCSObjectIdentifiers.id_aa_ets_revocationValues;
        escTimeStamp = PKCSObjectIdentifiers.id_aa_ets_escTimeStamp;
        certCRLTimestamp = PKCSObjectIdentifiers.id_aa_ets_certCRLTimestamp;
        archiveTimestamp = PKCSObjectIdentifiers.id_aa_ets_archiveTimestamp;
        archiveTimestampV2 = PKCSObjectIdentifiers.id_aa.branch(BDLocationException.ERROR_BYTE_NO_CHANGE_WIFI_STATE_PERMISSION);
    }
}
