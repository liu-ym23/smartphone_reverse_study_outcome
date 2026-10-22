package org.bouncycastle.asn1.microsoft;

import org.bouncycastle.asn1.ASN1ObjectIdentifier;

/* JADX INFO: loaded from: classes42.dex */
public interface MicrosoftObjectIdentifiers {
    public static final ASN1ObjectIdentifier microsoft = null;
    public static final ASN1ObjectIdentifier microsoftAppPolicies = null;
    public static final ASN1ObjectIdentifier microsoftCaVersion = null;
    public static final ASN1ObjectIdentifier microsoftCertTemplateV1 = null;
    public static final ASN1ObjectIdentifier microsoftCertTemplateV2 = null;
    public static final ASN1ObjectIdentifier microsoftCrlNextPublish = null;
    public static final ASN1ObjectIdentifier microsoftPrevCaCertHash = null;

    static {
        ASN1ObjectIdentifier r100 = new ASN1ObjectIdentifier("1.3.6.1.4.1.311");
        microsoft = r100;
        microsoftCertTemplateV1 = r100.branch("20.2");
        microsoftCaVersion = r100.branch("21.1");
        microsoftPrevCaCertHash = r100.branch("21.2");
        microsoftCrlNextPublish = r100.branch("21.4");
        microsoftCertTemplateV2 = r100.branch("21.7");
        microsoftAppPolicies = r100.branch("21.10");
    }
}
