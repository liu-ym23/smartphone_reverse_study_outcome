package org.bouncycastle.asn1.icao;

import org.bouncycastle.asn1.ASN1ObjectIdentifier;

/* JADX INFO: loaded from: classes42.dex */
public interface ICAOObjectIdentifiers {
    public static final ASN1ObjectIdentifier id_icao = null;
    public static final ASN1ObjectIdentifier id_icao_aaProtocolObject = null;
    public static final ASN1ObjectIdentifier id_icao_cscaMasterList = null;
    public static final ASN1ObjectIdentifier id_icao_cscaMasterListSigningKey = null;
    public static final ASN1ObjectIdentifier id_icao_documentTypeList = null;
    public static final ASN1ObjectIdentifier id_icao_extensions = null;
    public static final ASN1ObjectIdentifier id_icao_extensions_namechangekeyrollover = null;
    public static final ASN1ObjectIdentifier id_icao_ldsSecurityObject = null;
    public static final ASN1ObjectIdentifier id_icao_mrtd = null;
    public static final ASN1ObjectIdentifier id_icao_mrtd_security = null;

    static {
        ASN1ObjectIdentifier r100 = new ASN1ObjectIdentifier("2.23.136");
        id_icao = r100;
        ASN1ObjectIdentifier r101 = r100.branch("1");
        id_icao_mrtd = r101;
        ASN1ObjectIdentifier r102 = r101.branch("1");
        id_icao_mrtd_security = r102;
        id_icao_ldsSecurityObject = r102.branch("1");
        id_icao_cscaMasterList = r102.branch("2");
        id_icao_cscaMasterListSigningKey = r102.branch("3");
        id_icao_documentTypeList = r102.branch("4");
        id_icao_aaProtocolObject = r102.branch("5");
        ASN1ObjectIdentifier r103 = r102.branch("6");
        id_icao_extensions = r103;
        id_icao_extensions_namechangekeyrollover = r103.branch("1");
    }
}
