package wpc;

import android.net.http.X509TrustManagerExtensions;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import javax.security.auth.x500.X500Principal;

/* JADX INFO: loaded from: classes41.dex */
public final class a implements X509TrustManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final X509TrustManager f560671a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final X509TrustManagerExtensions f560672b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f560673c;

    public a(String r100) {
        this.f560672b = null;
        this.f560673c = r100;
        TrustManagerFactory r101 = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        r101.init(null);
        TrustManager[] r102 = r101.getTrustManagers();
        if (r102.length == 0) goto L9;
        X509TrustManager r103 = (X509TrustManager) r102[0];
        this.f560671a = r103;
        if (Build.VERSION.SDK_INT <= 23) goto L10;
        this.f560672b = new X509TrustManagerExtensions(r103);
        return;
    L10:
        return;
    L9:
        throw new NoSuchAlgorithmException("no trust manager found");
    }

    @Override // javax.net.ssl.X509TrustManager
    public final void checkClientTrusted(X509Certificate[] r100, String r101) {
        X509TrustManager r102 = this.f560671a;
        if (r102 == null) goto L6;
        r102.checkClientTrusted(r100, r101);
        return;
    }

    @Override // javax.net.ssl.X509TrustManager
    public final void checkServerTrusted(X509Certificate[] r100, String r101) {
        if (Build.VERSION.SDK_INT <= 23) goto L7;
        X509TrustManagerExtensions r102 = this.f560672b;
        if (r102 == null) goto L7;
        r102.checkServerTrusted(r100, r101, "");
    L10:
        boolean r103 = false;
        X500Principal r104 = r100[0].getIssuerX500Principal();     // Catch: Exception -> L36
        ArrayList r105 = new ArrayList(0);     // Catch: Exception -> L36
        r105.add(".*(GeoTrust|VeriSign|Symantec|GlobalSign|CFCA|Entrust|Thawte|DigiCert).*");     // Catch: Exception -> L36
        if (TextUtils.isEmpty(this.f560673c) == true) goto L14;
        r105.add(this.f560673c);     // Catch: Exception -> L36
    L14:
        int r106 = 0;
    L16:
        if (r106 >= r105.size()) goto L21;
        if (PatternProtector.compile((String) ListProtector.get(r105, r106), 2).matcher(r104.getName()).matches() == true) goto L19;
        r106 = r106 + 1;     // Catch: Exception -> L36
        goto L16
    L19:
        boolean r107 = true;
    L22:
        if (r107 == false) goto L35;
        X500Principal r108 = r100[0].getSubjectX500Principal();     // Catch: Exception -> L36
        ArrayList r109 = new ArrayList(0);     // Catch: Exception -> L36
        r109.add(".*CN=.*(\\.cup\\.com\\.cn|\\.95516\\.com|\\.chinaunionpay\\.com|\\.unionpay\\.com|\\.unionpaysecure\\.com|\\.95516\\.net)(,.*|$)");     // Catch: Exception -> L36
        int r110 = 0;
    L25:
        if (r110 >= r109.size()) goto L30;
        if (PatternProtector.compile((String) ListProtector.get(r109, r110), 2).matcher(r108.getName()).matches() == true) goto L28;
        r110 = r110 + 1;     // Catch: Exception -> L36
        goto L25
    L28:
        r103 = true;
    L30:
        if (r103 == false) goto L33;
        return;
    L33:
        throw new CertificateException();     // Catch: Exception -> L36
    L35:
        throw new CertificateException();     // Catch: Exception -> L36
    L21:
        r107 = false;
        goto L22
    L37:
        throw new CertificateException();
    L7:
        X509TrustManager r111 = this.f560671a;
        if (r111 == null) goto L10;
        r111.checkServerTrusted(r100, r101);
        goto L10
    }

    @Override // javax.net.ssl.X509TrustManager
    public final X509Certificate[] getAcceptedIssuers() {
        return this.f560671a.getAcceptedIssuers();
    }
}
