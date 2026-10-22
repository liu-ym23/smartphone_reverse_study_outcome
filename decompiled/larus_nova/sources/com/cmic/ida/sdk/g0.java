package com.cmic.ida.sdk;

import android.util.Base64;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;

/* JADX INFO: loaded from: classes22.dex */
public class g0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f273121d = "g0";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static g0 f273122e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private PublicKey f273123a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private PublicKey f273124b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private PublicKey f273125c;

    private void a() throws Exception {
        byte[] r100 = Base64.decode("MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAsYInrEDF5bV8tVYuJn67i8AWlArY/PqoZ55nID8qNbhQbohwUQXk2JHDW+i8WI5doQCLLAhnRdLVQtqxDhS3OEOpClRkhd79iWJs5jknAl6/rbb+JzOcSAbvG31ReXXhbkaIqGffpg0iQ7HnCG9fQRA7mo7lFfavM/V+18/TiF+woqL3NVduX58u18GgbS6SeGvRYfV+Xd2j7dBJyUFx4DRkiC0TPKgH8+a/bPfe2GAK80DSkxbwi0EbDJgVZdmKszbnC+OWtD7Y18ySbB/zc5K6bEFNaG5gakmQIzhu6h2t3MHSzQnaYrkint7i8iQLqJHScDY54wrcahjg8/8YUQIDAQAB", 0);     // Catch: NullPointerException -> L4
        this.f273125c = KeyFactory.getInstance(com.alipay.sdk.m.n.d.f25615a).generatePublic(new X509EncodedKeySpec(r100));     // Catch: NullPointerException -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    private void b() throws Exception {
        byte[] r100 = Base64.decode("MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAuyqBGJVxu+5Z2ZwItIhl\noxI53CVpYUR3OWAQyAQNcMhDDf3nGsxLLHP8kGWqrpLn1uAIgI+EIAl0sM+i1leD\nFD+sYU2rkUVZgpwO7ly+THBFw/YcZNwS094NBdhzxmCCFbCKHVNzDLirlV9T2q4k\nJhjaEmyCOtSU6+mdjcHhbcbF6lKYx8tfQlpPmyM5suFY138qtEoB4b+q/j8q22MI\naUotg1Av257RuMh97hAwoi5D7HS5LH0piLIN/au/X08rxbXnWNdgQtFtUeCNy3vw\nkO0ykg5qH942X8poQ+a9GgBUeDBpY4GSIv6/qq+zJxiJxpoL0SGKAP3FlcuLr07f\nxwIDAQAB", 0);     // Catch: NullPointerException -> L4
        this.f273124b = KeyFactory.getInstance(com.alipay.sdk.m.n.d.f25615a).generatePublic(new X509EncodedKeySpec(r100));     // Catch: NullPointerException -> L4
        return;
    L5:
        throw new Exception("公钥输入流为空");
    }

    private void c() throws Exception {
        byte[] r100 = Base64.decode("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDNFGdEpQ1d8cPqekvvEDQyBGnI\nKwvjX9o3OmnnqWMGbIiFYIpc21QeG7aqizuWdXlgS5M9rstDfHQfG/AaPElJ7Yix\nBCau4hdVwFpRmb9NIuqavDeHKP9BKPZ01Ra5/666NGKBqmkRRer3lBCe6EKNUc2U\n/DZg6U/Q3CTPiORt/wIDAQAB", 0);     // Catch: NullPointerException -> L4
        this.f273123a = KeyFactory.getInstance(com.alipay.sdk.m.n.d.f25615a).generatePublic(new X509EncodedKeySpec(r100));     // Catch: NullPointerException -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public static g0 d() {
        if (f273122e != null) goto L6;
        f273122e = new g0();
    L6:
        return f273122e;
    }

    private g0() {
        this.f273123a = null;
        this.f273124b = null;
        this.f273125c = null;
        c();     // Catch: Exception -> L10
        if (this.f273124b != null) goto L7;
        b();     // Catch: Exception -> L10
    L7:
        if (this.f273125c != null) goto L15;
        a();     // Catch: Exception -> L10
        return;
    L15:
        return;
    L10:
        e = move-exception;
        e.printStackTrace();
    }

    public String a(byte[] r100) {
        if (this.f273125c != null) goto L11;
        u.b(f273121d, "mJSServerPublicKey == null");
        return "";
    L11:
        Cipher r101 = Cipher.getInstance("RSA/ECB/OAEPWithSHA256AndMGF1Padding");     // Catch: Exception -> L8
        r101.init(1, this.f273125c);     // Catch: Exception -> L8
        return Base64.encodeToString(r101.doFinal(r100), 2);
    L8:
        e = move-exception;
        e.printStackTrace();
        return "";
    }
}
