package org.bouncycastle.asn1.esf;

import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;

/* JADX INFO: loaded from: classes42.dex */
public interface CommitmentTypeIdentifier {
    public static final ASN1ObjectIdentifier proofOfApproval = null;
    public static final ASN1ObjectIdentifier proofOfCreation = null;
    public static final ASN1ObjectIdentifier proofOfDelivery = null;
    public static final ASN1ObjectIdentifier proofOfOrigin = null;
    public static final ASN1ObjectIdentifier proofOfReceipt = null;
    public static final ASN1ObjectIdentifier proofOfSender = null;

    static {
        proofOfOrigin = PKCSObjectIdentifiers.id_cti_ets_proofOfOrigin;
        proofOfReceipt = PKCSObjectIdentifiers.id_cti_ets_proofOfReceipt;
        proofOfDelivery = PKCSObjectIdentifiers.id_cti_ets_proofOfDelivery;
        proofOfSender = PKCSObjectIdentifiers.id_cti_ets_proofOfSender;
        proofOfApproval = PKCSObjectIdentifiers.id_cti_ets_proofOfApproval;
        proofOfCreation = PKCSObjectIdentifiers.id_cti_ets_proofOfCreation;
    }
}
