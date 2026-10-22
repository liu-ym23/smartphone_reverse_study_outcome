package org.bouncycastle.asn1.cmc;

import com.bytedance.bdlocation.exception.BDLocationException;
import com.tencent.connect.common.Constants;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;

/* JADX INFO: loaded from: classes42.dex */
public interface CMCObjectIdentifiers {
    public static final ASN1ObjectIdentifier id_cct = null;
    public static final ASN1ObjectIdentifier id_cct_PKIData = null;
    public static final ASN1ObjectIdentifier id_cct_PKIResponse = null;
    public static final ASN1ObjectIdentifier id_cmc = null;
    public static final ASN1ObjectIdentifier id_cmc_addExtensions = null;
    public static final ASN1ObjectIdentifier id_cmc_authData = null;
    public static final ASN1ObjectIdentifier id_cmc_batchRequests = null;
    public static final ASN1ObjectIdentifier id_cmc_batchResponses = null;
    public static final ASN1ObjectIdentifier id_cmc_confirmCertAcceptance = null;
    public static final ASN1ObjectIdentifier id_cmc_controlProcessed = null;
    public static final ASN1ObjectIdentifier id_cmc_dataReturn = null;
    public static final ASN1ObjectIdentifier id_cmc_decryptedPOP = null;
    public static final ASN1ObjectIdentifier id_cmc_encryptedPOP = null;
    public static final ASN1ObjectIdentifier id_cmc_getCRL = null;
    public static final ASN1ObjectIdentifier id_cmc_getCert = null;
    public static final ASN1ObjectIdentifier id_cmc_identification = null;
    public static final ASN1ObjectIdentifier id_cmc_identityProof = null;
    public static final ASN1ObjectIdentifier id_cmc_identityProofV2 = null;
    public static final ASN1ObjectIdentifier id_cmc_lraPOPWitness = null;
    public static final ASN1ObjectIdentifier id_cmc_modCertTemplate = null;
    public static final ASN1ObjectIdentifier id_cmc_popLinkRandom = null;
    public static final ASN1ObjectIdentifier id_cmc_popLinkWitness = null;
    public static final ASN1ObjectIdentifier id_cmc_popLinkWitnessV2 = null;
    public static final ASN1ObjectIdentifier id_cmc_publishCert = null;
    public static final ASN1ObjectIdentifier id_cmc_queryPending = null;
    public static final ASN1ObjectIdentifier id_cmc_recipientNonce = null;
    public static final ASN1ObjectIdentifier id_cmc_regInfo = null;
    public static final ASN1ObjectIdentifier id_cmc_responseInfo = null;
    public static final ASN1ObjectIdentifier id_cmc_revokeRequest = null;
    public static final ASN1ObjectIdentifier id_cmc_senderNonce = null;
    public static final ASN1ObjectIdentifier id_cmc_statusInfo = null;
    public static final ASN1ObjectIdentifier id_cmc_statusInfoV2 = null;
    public static final ASN1ObjectIdentifier id_cmc_transactionId = null;
    public static final ASN1ObjectIdentifier id_cmc_trustedAnchors = null;
    public static final ASN1ObjectIdentifier id_pkix = null;

    static {
        ASN1ObjectIdentifier r100 = new ASN1ObjectIdentifier("1.3.6.1.5.5.7");
        id_pkix = r100;
        ASN1ObjectIdentifier r101 = r100.branch("7");
        id_cmc = r101;
        ASN1ObjectIdentifier r102 = r100.branch("12");
        id_cct = r102;
        id_cmc_identityProof = r101.branch("3");
        id_cmc_dataReturn = r101.branch("4");
        id_cmc_regInfo = r101.branch("18");
        id_cmc_responseInfo = r101.branch(Constants.VIA_ACT_TYPE_NINETEEN);
        id_cmc_queryPending = r101.branch("21");
        id_cmc_popLinkRandom = r101.branch("22");
        id_cmc_popLinkWitness = r101.branch(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR);
        id_cmc_identification = r101.branch("2");
        id_cmc_transactionId = r101.branch("5");
        id_cmc_senderNonce = r101.branch("6");
        id_cmc_recipientNonce = r101.branch("7");
        id_cct_PKIData = r102.branch("2");
        id_cct_PKIResponse = r102.branch("3");
        id_cmc_statusInfo = r101.branch("1");
        id_cmc_addExtensions = r101.branch("8");
        id_cmc_encryptedPOP = r101.branch(Constants.VIA_SHARE_TYPE_MINI_PROGRAM);
        id_cmc_decryptedPOP = r101.branch(Constants.VIA_REPORT_TYPE_SHARE_TO_QQ);
        id_cmc_lraPOPWitness = r101.branch("11");
        id_cmc_getCert = r101.branch(Constants.VIA_REPORT_TYPE_WPA_STATE);
        id_cmc_getCRL = r101.branch(Constants.VIA_REPORT_TYPE_START_WAP);
        id_cmc_revokeRequest = r101.branch(Constants.VIA_REPORT_TYPE_START_GROUP);
        id_cmc_confirmCertAcceptance = r101.branch("24");
        id_cmc_statusInfoV2 = r101.branch(Constants.VIA_REPORT_TYPE_CHAT_AUDIO);
        id_cmc_trustedAnchors = r101.branch("26");
        id_cmc_authData = r101.branch("27");
        id_cmc_batchRequests = r101.branch("28");
        id_cmc_batchResponses = r101.branch("29");
        id_cmc_publishCert = r101.branch(BDLocationException.ERROR_SDK_NO_PERMISSION);
        id_cmc_modCertTemplate = r101.branch("31");
        id_cmc_controlProcessed = r101.branch(BDLocationException.ERROR_CONNECT_GOOGLE_FAIL);
        id_cmc_identityProofV2 = r101.branch(BDLocationException.ERROR_ABNORMAL_NETWORK);
        id_cmc_popLinkWitnessV2 = r101.branch("33");
    }
}
