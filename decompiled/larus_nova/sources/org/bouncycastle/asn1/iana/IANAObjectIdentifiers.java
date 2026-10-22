package org.bouncycastle.asn1.iana;

import org.bouncycastle.asn1.ASN1ObjectIdentifier;

/* JADX INFO: loaded from: classes42.dex */
public interface IANAObjectIdentifiers {
    public static final ASN1ObjectIdentifier SNMPv2 = null;
    public static final ASN1ObjectIdentifier _private = null;
    public static final ASN1ObjectIdentifier directory = null;
    public static final ASN1ObjectIdentifier experimental = null;
    public static final ASN1ObjectIdentifier hmacMD5 = null;
    public static final ASN1ObjectIdentifier hmacRIPEMD160 = null;
    public static final ASN1ObjectIdentifier hmacSHA1 = null;
    public static final ASN1ObjectIdentifier hmacTIGER = null;
    public static final ASN1ObjectIdentifier internet = null;
    public static final ASN1ObjectIdentifier ipsec = null;
    public static final ASN1ObjectIdentifier isakmpOakley = null;
    public static final ASN1ObjectIdentifier mail = null;
    public static final ASN1ObjectIdentifier mgmt = null;
    public static final ASN1ObjectIdentifier pkix = null;

    /* JADX INFO: renamed from: security, reason: collision with root package name */
    public static final ASN1ObjectIdentifier f525047security = null;
    public static final ASN1ObjectIdentifier security_mechanisms = null;
    public static final ASN1ObjectIdentifier security_nametypes = null;

    static {
        ASN1ObjectIdentifier r100 = new ASN1ObjectIdentifier("1.3.6.1");
        internet = r100;
        directory = r100.branch("1");
        mgmt = r100.branch("2");
        experimental = r100.branch("3");
        _private = r100.branch("4");
        ASN1ObjectIdentifier r101 = r100.branch("5");
        f525047security = r101;
        SNMPv2 = r100.branch("6");
        mail = r100.branch("7");
        ASN1ObjectIdentifier r102 = r101.branch("5");
        security_mechanisms = r102;
        security_nametypes = r101.branch("6");
        pkix = r102.branch("6");
        ASN1ObjectIdentifier r103 = r102.branch("8");
        ipsec = r103;
        ASN1ObjectIdentifier r104 = r103.branch("1");
        isakmpOakley = r104;
        hmacMD5 = r104.branch("1");
        hmacSHA1 = r104.branch("2");
        hmacTIGER = r104.branch("3");
        hmacRIPEMD160 = r104.branch("4");
    }
}
