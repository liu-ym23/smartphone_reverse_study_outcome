package org.bouncycastle.asn1.cmp;

import org.bouncycastle.asn1.ASN1ObjectIdentifier;

/* JADX INFO: loaded from: classes42.dex */
public interface CMPObjectIdentifiers {
    public static final ASN1ObjectIdentifier ct_encKeyWithID = null;
    public static final ASN1ObjectIdentifier dhBasedMac = null;
    public static final ASN1ObjectIdentifier id_pkip = null;
    public static final ASN1ObjectIdentifier id_regCtrl = null;
    public static final ASN1ObjectIdentifier id_regInfo = null;
    public static final ASN1ObjectIdentifier it_caKeyUpdateInfo = null;
    public static final ASN1ObjectIdentifier it_caProtEncCert = null;
    public static final ASN1ObjectIdentifier it_confirmWaitTime = null;
    public static final ASN1ObjectIdentifier it_currentCRL = null;
    public static final ASN1ObjectIdentifier it_encKeyPairTypes = null;
    public static final ASN1ObjectIdentifier it_implicitConfirm = null;
    public static final ASN1ObjectIdentifier it_keyPairParamRep = null;
    public static final ASN1ObjectIdentifier it_keyPairParamReq = null;
    public static final ASN1ObjectIdentifier it_origPKIMessage = null;
    public static final ASN1ObjectIdentifier it_preferredSymAlg = null;
    public static final ASN1ObjectIdentifier it_revPassphrase = null;
    public static final ASN1ObjectIdentifier it_signKeyPairTypes = null;
    public static final ASN1ObjectIdentifier it_suppLangTags = null;
    public static final ASN1ObjectIdentifier it_unsupportedOIDs = null;
    public static final ASN1ObjectIdentifier passwordBasedMac = null;
    public static final ASN1ObjectIdentifier regCtrl_altCertTemplate = null;
    public static final ASN1ObjectIdentifier regCtrl_authenticator = null;
    public static final ASN1ObjectIdentifier regCtrl_oldCertID = null;
    public static final ASN1ObjectIdentifier regCtrl_pkiArchiveOptions = null;
    public static final ASN1ObjectIdentifier regCtrl_pkiPublicationInfo = null;
    public static final ASN1ObjectIdentifier regCtrl_protocolEncrKey = null;
    public static final ASN1ObjectIdentifier regCtrl_regToken = null;
    public static final ASN1ObjectIdentifier regInfo_certReq = null;
    public static final ASN1ObjectIdentifier regInfo_utf8Pairs = null;

    static {
        passwordBasedMac = new ASN1ObjectIdentifier("1.2.840.113533.7.66.13");
        dhBasedMac = new ASN1ObjectIdentifier("1.2.840.113533.7.66.30");
        it_caProtEncCert = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.4.1");
        it_signKeyPairTypes = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.4.2");
        it_encKeyPairTypes = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.4.3");
        it_preferredSymAlg = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.4.4");
        it_caKeyUpdateInfo = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.4.5");
        it_currentCRL = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.4.6");
        it_unsupportedOIDs = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.4.7");
        it_keyPairParamReq = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.4.10");
        it_keyPairParamRep = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.4.11");
        it_revPassphrase = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.4.12");
        it_implicitConfirm = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.4.13");
        it_confirmWaitTime = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.4.14");
        it_origPKIMessage = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.4.15");
        it_suppLangTags = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.4.16");
        id_pkip = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.5");
        id_regCtrl = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.5.1");
        id_regInfo = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.5.2");
        regCtrl_regToken = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.5.1.1");
        regCtrl_authenticator = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.5.1.2");
        regCtrl_pkiPublicationInfo = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.5.1.3");
        regCtrl_pkiArchiveOptions = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.5.1.4");
        regCtrl_oldCertID = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.5.1.5");
        regCtrl_protocolEncrKey = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.5.1.6");
        regCtrl_altCertTemplate = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.5.1.7");
        regInfo_utf8Pairs = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.5.2.1");
        regInfo_certReq = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.5.2.2");
        ct_encKeyWithID = new ASN1ObjectIdentifier("1.2.840.113549.1.9.16.1.21");
    }
}
