package uoa;

import android.content.Context;
import android.util.Base64;
import com.larus.nova.R;
import com.privacy.azerothprivacy.AzerothPrivacy;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Objects;

/* JADX INFO: loaded from: classes34.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static X509Certificate f550962a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static X509Certificate f550963b;

    public static X509Certificate a(Context r100) throws GeneralSecurityException {
        X509Certificate r101 = f550962a;
        if (r101 == null) goto L57;
        return r101;
    L57:
        String r102 = new URL(AzerothPrivacy.getSdkConfig().f530152b.f530153a).getHost();     // Catch: MalformedURLException -> L51
        boolean r103 = Objects.equals(r102, "alice-boe.bytedance.net");     // Catch: MalformedURLException -> L51
        int r104 = R.raw.boe_server_pk;
        if (r103 == true) goto L56;
        boolean r105 = true;
        if (Objects.equals(r102, "www.doubao.com") == false) goto L11;
    L16:
        boolean r106 = true;
    L17:
        if (r106 == false) goto L19;
        r104 = R.raw.online_server_pk;
        goto L56
    L19:
        if (r102 != null) goto L21;
    L27:
        r105 = false;
    L28:
        if (r105 == false) goto L31;
        r104 = R.raw.oversea_server_pk;
        goto L56
    L31:
        if (Objects.equals(r102, "tgw-boe.byted.org") == true) goto L56;
        throw new GeneralSecurityException("key agreement config is invalid" + AzerothPrivacy.getSdkConfig().f530152b.f530153a);     // Catch: MalformedURLException -> L51
    L21:
        if (r102.contains("i18n") == true) goto L28;
        if (r102.contains("dola") == true) goto L28;
        if (r102.contains("cici") == false) goto L27;
    L11:
        if (Objects.equals(r102, "inhouse.doubao.com") == true) goto L16;
        if (Objects.equals(r102, "api-normal.doubao.com") == true) goto L16;
        r106 = false;
    L56:
        InputStream r107 = r100.getResources().openRawResource(r104);     // Catch: IOException -> L46
        byte[] r108 = new byte[r107.available()];     // Catch: Throwable -> L37
        r107.read(r108);     // Catch: Throwable -> L37
        String r109 = new String(r108, StandardCharsets.UTF_8);     // Catch: Throwable -> L37
        r107.close();     // Catch: IOException -> L46
        f550962a = (X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(Base64.decode(r109, 0)));     // Catch: MalformedURLException -> L51
        apa.a.a("CRYPTO", "num iis" + f550962a.getSerialNumber().toString(10));     // Catch: MalformedURLException -> L51
        return f550962a;
    L37:
        th = move-exception;
        throw th;     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        if (r107 != null) goto L54;
    L45:
        throw th;     // Catch: IOException -> L46
    L54:
        r107.close();     // Catch: Throwable -> L43
    L43:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L46
    L46:
        e = move-exception;
        throw new GeneralSecurityException(e);     // Catch: MalformedURLException -> L51
    L51:
        e = move-exception;
        throw new GeneralSecurityException(e);
    }

    public static boolean b(String r100) {
        f550963b = (X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(Base64.decode(r100, 0)));
        apa.a.a("crypto", "root cert_sn is " + f550962a.getSerialNumber().toString());     // Catch: NoSuchProviderException -> L8 Throwable -> L10 SignatureException -> L12 NoSuchAlgorithmException -> L14 CertificateException -> L16
        apa.a.a("crypto", "sign cert_sn is " + f550963b.getSerialNumber().toString());     // Catch: NoSuchProviderException -> L8 Throwable -> L10 SignatureException -> L12 NoSuchAlgorithmException -> L14 CertificateException -> L16
        f550963b.verify(f550962a.getPublicKey());     // Catch: NoSuchProviderException -> L8 Throwable -> L10 SignatureException -> L12 NoSuchAlgorithmException -> L14 CertificateException -> L16
        return true;
    L10:
        e = move-exception;
        e.printStackTrace();
        return false;
    L19:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public static boolean c(String r100, byte[] r101) {
        Signature r102 = Signature.getInstance("SHA256withECDSA");     // Catch: Throwable -> L4 SignatureException -> L6 NoSuchAlgorithmException -> L8
        r102.initVerify(f550963b.getPublicKey());     // Catch: Throwable -> L4 SignatureException -> L6 NoSuchAlgorithmException -> L8
        r102.update(r101);     // Catch: Throwable -> L4 SignatureException -> L6 NoSuchAlgorithmException -> L8
        return r102.verify(Base64.decode(r100, 0));
    L4:
        e = move-exception;
        throw new RuntimeException(e);
    }
}
