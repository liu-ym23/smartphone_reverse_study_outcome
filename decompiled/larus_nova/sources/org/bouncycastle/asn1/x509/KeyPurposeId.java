package org.bouncycastle.asn1.x509;

import com.tencent.connect.common.Constants;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;

/* JADX INFO: loaded from: classes42.dex */
public class KeyPurposeId extends ASN1Object {
    public static final KeyPurposeId anyExtendedKeyUsage = null;
    private static final ASN1ObjectIdentifier id_kp = null;
    public static final KeyPurposeId id_kp_OCSPSigning = null;
    public static final KeyPurposeId id_kp_capwapAC = null;
    public static final KeyPurposeId id_kp_capwapWTP = null;
    public static final KeyPurposeId id_kp_clientAuth = null;
    public static final KeyPurposeId id_kp_codeSigning = null;
    public static final KeyPurposeId id_kp_dvcs = null;
    public static final KeyPurposeId id_kp_eapOverLAN = null;
    public static final KeyPurposeId id_kp_eapOverPPP = null;
    public static final KeyPurposeId id_kp_emailProtection = null;
    public static final KeyPurposeId id_kp_ipsecEndSystem = null;
    public static final KeyPurposeId id_kp_ipsecIKE = null;
    public static final KeyPurposeId id_kp_ipsecTunnel = null;
    public static final KeyPurposeId id_kp_ipsecUser = null;
    public static final KeyPurposeId id_kp_macAddress = null;
    public static final KeyPurposeId id_kp_msSGC = null;
    public static final KeyPurposeId id_kp_nsSGC = null;
    public static final KeyPurposeId id_kp_sbgpCertAAServerAuth = null;
    public static final KeyPurposeId id_kp_scvpClient = null;
    public static final KeyPurposeId id_kp_scvpServer = null;
    public static final KeyPurposeId id_kp_scvp_responder = null;
    public static final KeyPurposeId id_kp_serverAuth = null;
    public static final KeyPurposeId id_kp_smartcardlogon = null;
    public static final KeyPurposeId id_kp_timeStamping = null;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private ASN1ObjectIdentifier f525083id;

    static {
        ASN1ObjectIdentifier r100 = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.3");
        id_kp = r100;
        anyExtendedKeyUsage = new KeyPurposeId(Extension.extendedKeyUsage.branch("0"));
        id_kp_serverAuth = new KeyPurposeId(r100.branch("1"));
        id_kp_clientAuth = new KeyPurposeId(r100.branch("2"));
        id_kp_codeSigning = new KeyPurposeId(r100.branch("3"));
        id_kp_emailProtection = new KeyPurposeId(r100.branch("4"));
        id_kp_ipsecEndSystem = new KeyPurposeId(r100.branch("5"));
        id_kp_ipsecTunnel = new KeyPurposeId(r100.branch("6"));
        id_kp_ipsecUser = new KeyPurposeId(r100.branch("7"));
        id_kp_timeStamping = new KeyPurposeId(r100.branch("8"));
        id_kp_OCSPSigning = new KeyPurposeId(r100.branch(Constants.VIA_SHARE_TYPE_MINI_PROGRAM));
        id_kp_dvcs = new KeyPurposeId(r100.branch(Constants.VIA_REPORT_TYPE_SHARE_TO_QQ));
        id_kp_sbgpCertAAServerAuth = new KeyPurposeId(r100.branch("11"));
        id_kp_scvp_responder = new KeyPurposeId(r100.branch("12"));
        id_kp_eapOverPPP = new KeyPurposeId(r100.branch("13"));
        id_kp_eapOverLAN = new KeyPurposeId(r100.branch(Constants.VIA_REPORT_TYPE_MAKE_FRIEND));
        id_kp_scvpServer = new KeyPurposeId(r100.branch(Constants.VIA_REPORT_TYPE_WPA_STATE));
        id_kp_scvpClient = new KeyPurposeId(r100.branch(Constants.VIA_REPORT_TYPE_START_WAP));
        id_kp_ipsecIKE = new KeyPurposeId(r100.branch(Constants.VIA_REPORT_TYPE_START_GROUP));
        id_kp_capwapAC = new KeyPurposeId(r100.branch("18"));
        id_kp_capwapWTP = new KeyPurposeId(r100.branch(Constants.VIA_ACT_TYPE_NINETEEN));
        id_kp_smartcardlogon = new KeyPurposeId(new ASN1ObjectIdentifier("1.3.6.1.4.1.311.20.2.2"));
        id_kp_macAddress = new KeyPurposeId(new ASN1ObjectIdentifier("1.3.6.1.1.1.1.22"));
        id_kp_msSGC = new KeyPurposeId(new ASN1ObjectIdentifier("1.3.6.1.4.1.311.10.3.3"));
        id_kp_nsSGC = new KeyPurposeId(new ASN1ObjectIdentifier("2.16.840.1.113730.4.1"));
    }

    public KeyPurposeId(String r100) {
        this(new ASN1ObjectIdentifier(r100));
    }

    private KeyPurposeId(ASN1ObjectIdentifier r100) {
        this.f525083id = r100;
    }

    public static KeyPurposeId getInstance(Object r100) {
        if ((r100 instanceof KeyPurposeId) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new KeyPurposeId(ASN1ObjectIdentifier.getInstance(r100));
    L5:
        return (KeyPurposeId) r100;
    }

    public String getId() {
        return this.f525083id.getId();
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.f525083id;
    }

    public ASN1ObjectIdentifier toOID() {
        return this.f525083id;
    }

    public String toString() {
        return this.f525083id.toString();
    }
}
