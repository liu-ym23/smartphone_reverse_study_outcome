package org.bouncycastle.asn1.x509;

import com.tencent.connect.common.Constants;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;

/* JADX INFO: loaded from: classes42.dex */
public interface X509AttributeIdentifiers {
    public static final ASN1ObjectIdentifier RoleSyntax = null;
    public static final ASN1ObjectIdentifier id_aca = null;
    public static final ASN1ObjectIdentifier id_aca_accessIdentity = null;
    public static final ASN1ObjectIdentifier id_aca_authenticationInfo = null;
    public static final ASN1ObjectIdentifier id_aca_chargingIdentity = null;
    public static final ASN1ObjectIdentifier id_aca_encAttrs = null;
    public static final ASN1ObjectIdentifier id_aca_group = null;
    public static final ASN1ObjectIdentifier id_at_clearance = null;
    public static final ASN1ObjectIdentifier id_at_role = null;
    public static final ASN1ObjectIdentifier id_ce_targetInformation = null;
    public static final ASN1ObjectIdentifier id_pe_aaControls = null;
    public static final ASN1ObjectIdentifier id_pe_ac_auditIdentity = null;
    public static final ASN1ObjectIdentifier id_pe_ac_proxying = null;

    static {
        RoleSyntax = new ASN1ObjectIdentifier("2.5.4.72");
        ASN1ObjectIdentifier r100 = X509ObjectIdentifiers.id_pe;
        id_pe_ac_auditIdentity = r100.branch("4");
        id_pe_aaControls = r100.branch("6");
        id_pe_ac_proxying = r100.branch(Constants.VIA_REPORT_TYPE_SHARE_TO_QQ);
        id_ce_targetInformation = X509ObjectIdentifiers.id_ce.branch("55");
        ASN1ObjectIdentifier r101 = X509ObjectIdentifiers.id_pkix.branch(Constants.VIA_REPORT_TYPE_SHARE_TO_QQ);
        id_aca = r101;
        id_aca_authenticationInfo = r101.branch("1");
        id_aca_accessIdentity = r101.branch("2");
        id_aca_chargingIdentity = r101.branch("3");
        id_aca_group = r101.branch("4");
        id_aca_encAttrs = r101.branch("6");
        id_at_role = new ASN1ObjectIdentifier("2.5.4.72");
        id_at_clearance = new ASN1ObjectIdentifier("2.5.1.5.55");
    }
}
