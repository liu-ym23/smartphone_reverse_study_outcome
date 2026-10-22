package org.bouncycastle.asn1.cryptopro;

import com.bytedance.bdlocation.exception.BDLocationException;
import com.tencent.connect.common.Constants;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;

/* JADX INFO: loaded from: classes42.dex */
public interface CryptoProObjectIdentifiers {
    public static final ASN1ObjectIdentifier GOST_id = null;
    public static final ASN1ObjectIdentifier gostR28147_gcfb = null;
    public static final ASN1ObjectIdentifier gostR3410_2001 = null;
    public static final ASN1ObjectIdentifier gostR3410_2001DH = null;
    public static final ASN1ObjectIdentifier gostR3410_2001_CryptoPro_A = null;
    public static final ASN1ObjectIdentifier gostR3410_2001_CryptoPro_B = null;
    public static final ASN1ObjectIdentifier gostR3410_2001_CryptoPro_C = null;
    public static final ASN1ObjectIdentifier gostR3410_2001_CryptoPro_ESDH = null;
    public static final ASN1ObjectIdentifier gostR3410_2001_CryptoPro_XchA = null;
    public static final ASN1ObjectIdentifier gostR3410_2001_CryptoPro_XchB = null;
    public static final ASN1ObjectIdentifier gostR3410_94 = null;
    public static final ASN1ObjectIdentifier gostR3410_94_CryptoPro_A = null;
    public static final ASN1ObjectIdentifier gostR3410_94_CryptoPro_B = null;
    public static final ASN1ObjectIdentifier gostR3410_94_CryptoPro_C = null;
    public static final ASN1ObjectIdentifier gostR3410_94_CryptoPro_D = null;
    public static final ASN1ObjectIdentifier gostR3410_94_CryptoPro_XchA = null;
    public static final ASN1ObjectIdentifier gostR3410_94_CryptoPro_XchB = null;
    public static final ASN1ObjectIdentifier gostR3410_94_CryptoPro_XchC = null;
    public static final ASN1ObjectIdentifier gostR3411 = null;
    public static final ASN1ObjectIdentifier gostR3411Hmac = null;
    public static final ASN1ObjectIdentifier gostR3411_94_CryptoProParamSet = null;
    public static final ASN1ObjectIdentifier gostR3411_94_with_gostR3410_2001 = null;
    public static final ASN1ObjectIdentifier gostR3411_94_with_gostR3410_94 = null;
    public static final ASN1ObjectIdentifier gost_ElSgDH3410_1 = null;
    public static final ASN1ObjectIdentifier gost_ElSgDH3410_default = null;
    public static final ASN1ObjectIdentifier id_Gost28147_89_CryptoPro_A_ParamSet = null;
    public static final ASN1ObjectIdentifier id_Gost28147_89_CryptoPro_B_ParamSet = null;
    public static final ASN1ObjectIdentifier id_Gost28147_89_CryptoPro_C_ParamSet = null;
    public static final ASN1ObjectIdentifier id_Gost28147_89_CryptoPro_D_ParamSet = null;
    public static final ASN1ObjectIdentifier id_Gost28147_89_CryptoPro_KeyWrap = null;
    public static final ASN1ObjectIdentifier id_Gost28147_89_CryptoPro_TestParamSet = null;
    public static final ASN1ObjectIdentifier id_Gost28147_89_None_KeyWrap = null;

    static {
        ASN1ObjectIdentifier r100 = new ASN1ObjectIdentifier("1.2.643.2.2");
        GOST_id = r100;
        gostR3411 = r100.branch(Constants.VIA_SHARE_TYPE_MINI_PROGRAM);
        gostR3411Hmac = r100.branch(Constants.VIA_REPORT_TYPE_SHARE_TO_QQ);
        id_Gost28147_89_None_KeyWrap = r100.branch("13.0");
        id_Gost28147_89_CryptoPro_KeyWrap = r100.branch("13.1");
        gostR28147_gcfb = r100.branch("21");
        id_Gost28147_89_CryptoPro_TestParamSet = r100.branch("31.0");
        id_Gost28147_89_CryptoPro_A_ParamSet = r100.branch("31.1");
        id_Gost28147_89_CryptoPro_B_ParamSet = r100.branch("31.2");
        id_Gost28147_89_CryptoPro_C_ParamSet = r100.branch("31.3");
        id_Gost28147_89_CryptoPro_D_ParamSet = r100.branch("31.4");
        gostR3410_94 = r100.branch("20");
        gostR3410_2001 = r100.branch(Constants.VIA_ACT_TYPE_NINETEEN);
        gostR3411_94_with_gostR3410_94 = r100.branch("4");
        gostR3411_94_with_gostR3410_2001 = r100.branch("3");
        gostR3411_94_CryptoProParamSet = r100.branch("30.1");
        gostR3410_94_CryptoPro_A = r100.branch("32.2");
        gostR3410_94_CryptoPro_B = r100.branch("32.3");
        gostR3410_94_CryptoPro_C = r100.branch("32.4");
        gostR3410_94_CryptoPro_D = r100.branch("32.5");
        gostR3410_94_CryptoPro_XchA = r100.branch("33.1");
        gostR3410_94_CryptoPro_XchB = r100.branch("33.2");
        gostR3410_94_CryptoPro_XchC = r100.branch("33.3");
        gostR3410_2001_CryptoPro_A = r100.branch("35.1");
        gostR3410_2001_CryptoPro_B = r100.branch("35.2");
        gostR3410_2001_CryptoPro_C = r100.branch("35.3");
        gostR3410_2001_CryptoPro_XchA = r100.branch("36.0");
        gostR3410_2001_CryptoPro_XchB = r100.branch("36.1");
        gost_ElSgDH3410_default = r100.branch("36.0");
        gost_ElSgDH3410_1 = r100.branch("36.1");
        gostR3410_2001_CryptoPro_ESDH = r100.branch(BDLocationException.ERROR_BEACON_NOT_ALLOW_USE);
        gostR3410_2001DH = r100.branch(BDLocationException.ERROR_BEACON_INFO_NULL);
    }
}
