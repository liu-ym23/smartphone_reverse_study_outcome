package com.cmic.sso.sdk.e;

import android.util.Base64;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;

/* JADX INFO: loaded from: classes22.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f273500a = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static i f273501d;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private PublicKey f273502b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private PublicKey f273503c;

    static {
        f273500a = RXScreenCaptureService.KEY_INDEX;
        f273501d = null;
    }

    public static i a() {
        if (f273501d != null) goto L6;
        f273501d = new i();
    L6:
        return f273501d;
    }

    private void b() throws Exception {
        byte[] r100 = Base64.decode("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDNFGdEpQ1d8cPqekvvEDQyBGnI\nKwvjX9o3OmnnqWMGbIiFYIpc21QeG7aqizuWdXlgS5M9rstDfHQfG/AaPElJ7Yix\nBCau4hdVwFpRmb9NIuqavDeHKP9BKPZ01Ra5/666NGKBqmkRRer3lBCe6EKNUc2U\n/DZg6U/Q3CTPiORt/wIDAQAB", 0);     // Catch: NullPointerException -> L4
        this.f273502b = KeyFactory.getInstance(com.alipay.sdk.m.n.d.f25615a).generatePublic(new X509EncodedKeySpec(r100));     // Catch: NullPointerException -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    private void c() throws Exception {
        byte[] r100 = Base64.decode("MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAuyqBGJVxu+5Z2ZwItIhl\noxI53CVpYUR3OWAQyAQNcMhDDf3nGsxLLHP8kGWqrpLn1uAIgI+EIAl0sM+i1leD\nFD+sYU2rkUVZgpwO7ly+THBFw/YcZNwS094NBdhzxmCCFbCKHVNzDLirlV9T2q4k\nJhjaEmyCOtSU6+mdjcHhbcbF6lKYx8tfQlpPmyM5suFY138qtEoB4b+q/j8q22MI\naUotg1Av257RuMh97hAwoi5D7HS5LH0piLIN/au/X08rxbXnWNdgQtFtUeCNy3vw\nkO0ykg5qH942X8poQ+a9GgBUeDBpY4GSIv6/qq+zJxiJxpoL0SGKAP3FlcuLr07f\nxwIDAQAB", 0);     // Catch: NullPointerException -> L4
        this.f273503c = KeyFactory.getInstance(com.alipay.sdk.m.n.d.f25615a).generatePublic(new X509EncodedKeySpec(r100));     // Catch: NullPointerException -> L4
        return;
    L5:
        throw new Exception("公钥输入流为空");
    }

    private i() {
        this.f273502b = null;
        this.f273503c = null;
        b();     // Catch: Exception -> L7
        if (this.f273503c != null) goto L12;
        c();     // Catch: Exception -> L7
        return;
    L12:
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
    }

    public String a(byte[] r100) {
        if (this.f273502b != null) goto L11;
        c.a(f273500a, "mServerPublicKey == null");
        return "";
    L11:
        Cipher r101 = Cipher.getInstance("RSA/ECB/OAEPWithSHA256AndMGF1Padding");     // Catch: Exception -> L8
        r101.init(1, this.f273502b);     // Catch: Exception -> L8
        return q.a(r101.doFinal(r100));
    L8:
        e = move-exception;
        e.printStackTrace();
        return "";
    }

    public String b(byte[] r100) {
        if (this.f273502b != null) goto L11;
        c.a(f273500a, "mServerPublicKey == null");
        return null;
    L11:
        Cipher r101 = Cipher.getInstance("RSA/ECB/OAEPWithSHA256AndMGF1Padding");     // Catch: Exception -> L8
        r101.init(1, this.f273503c);     // Catch: Exception -> L8
        return Base64.encodeToString(r101.doFinal(r100), 0);
    L8:
        e = move-exception;
        e.printStackTrace();
        return "";
    }
}
