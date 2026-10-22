package org.bouncycastle.asn1.teletrust;

import com.tencent.connect.common.Constants;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;

/* JADX INFO: loaded from: classes42.dex */
public interface TeleTrusTObjectIdentifiers {
    public static final ASN1ObjectIdentifier brainpoolP160r1 = null;
    public static final ASN1ObjectIdentifier brainpoolP160t1 = null;
    public static final ASN1ObjectIdentifier brainpoolP192r1 = null;
    public static final ASN1ObjectIdentifier brainpoolP192t1 = null;
    public static final ASN1ObjectIdentifier brainpoolP224r1 = null;
    public static final ASN1ObjectIdentifier brainpoolP224t1 = null;
    public static final ASN1ObjectIdentifier brainpoolP256r1 = null;
    public static final ASN1ObjectIdentifier brainpoolP256t1 = null;
    public static final ASN1ObjectIdentifier brainpoolP320r1 = null;
    public static final ASN1ObjectIdentifier brainpoolP320t1 = null;
    public static final ASN1ObjectIdentifier brainpoolP384r1 = null;
    public static final ASN1ObjectIdentifier brainpoolP384t1 = null;
    public static final ASN1ObjectIdentifier brainpoolP512r1 = null;
    public static final ASN1ObjectIdentifier brainpoolP512t1 = null;
    public static final ASN1ObjectIdentifier ecSign = null;
    public static final ASN1ObjectIdentifier ecSignWithRipemd160 = null;
    public static final ASN1ObjectIdentifier ecSignWithSha1 = null;
    public static final ASN1ObjectIdentifier ecc_brainpool = null;
    public static final ASN1ObjectIdentifier ellipticCurve = null;
    public static final ASN1ObjectIdentifier ripemd128 = null;
    public static final ASN1ObjectIdentifier ripemd160 = null;
    public static final ASN1ObjectIdentifier ripemd256 = null;
    public static final ASN1ObjectIdentifier rsaSignatureWithripemd128 = null;
    public static final ASN1ObjectIdentifier rsaSignatureWithripemd160 = null;
    public static final ASN1ObjectIdentifier rsaSignatureWithripemd256 = null;
    public static final ASN1ObjectIdentifier teleTrusTAlgorithm = null;
    public static final ASN1ObjectIdentifier teleTrusTRSAsignatureAlgorithm = null;
    public static final ASN1ObjectIdentifier versionOne = null;

    static {
        ASN1ObjectIdentifier r100 = new ASN1ObjectIdentifier("1.3.36.3");
        teleTrusTAlgorithm = r100;
        ripemd160 = r100.branch("2.1");
        ripemd128 = r100.branch("2.2");
        ripemd256 = r100.branch("2.3");
        ASN1ObjectIdentifier r101 = r100.branch("3.1");
        teleTrusTRSAsignatureAlgorithm = r101;
        rsaSignatureWithripemd160 = r101.branch("2");
        rsaSignatureWithripemd128 = r101.branch("3");
        rsaSignatureWithripemd256 = r101.branch("4");
        ASN1ObjectIdentifier r102 = r100.branch("3.2");
        ecSign = r102;
        ecSignWithSha1 = r102.branch("1");
        ecSignWithRipemd160 = r102.branch("2");
        ASN1ObjectIdentifier r103 = r100.branch("3.2.8");
        ecc_brainpool = r103;
        ASN1ObjectIdentifier r104 = r103.branch("1");
        ellipticCurve = r104;
        ASN1ObjectIdentifier r105 = r104.branch("1");
        versionOne = r105;
        brainpoolP160r1 = r105.branch("1");
        brainpoolP160t1 = r105.branch("2");
        brainpoolP192r1 = r105.branch("3");
        brainpoolP192t1 = r105.branch("4");
        brainpoolP224r1 = r105.branch("5");
        brainpoolP224t1 = r105.branch("6");
        brainpoolP256r1 = r105.branch("7");
        brainpoolP256t1 = r105.branch("8");
        brainpoolP320r1 = r105.branch(Constants.VIA_SHARE_TYPE_MINI_PROGRAM);
        brainpoolP320t1 = r105.branch(Constants.VIA_REPORT_TYPE_SHARE_TO_QQ);
        brainpoolP384r1 = r105.branch("11");
        brainpoolP384t1 = r105.branch("12");
        brainpoolP512r1 = r105.branch("13");
        brainpoolP512t1 = r105.branch(Constants.VIA_REPORT_TYPE_MAKE_FRIEND);
    }
}
