package jvc;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

/* JADX INFO: loaded from: classes5.dex */
public final class d implements HostnameVerifier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f500646a = null;

    static {
        f500646a = new d();
    }

    public d() {
    }

    public static List<String> a(X509Certificate r100) {
        List<String> r101 = b(r100, 7);
        List<String> r102 = b(r100, 2);
        ArrayList r103 = new ArrayList(r101.size() + r102.size());
        r103.addAll(r101);
        r103.addAll(r102);
        return r103;
    }

    public static List<String> b(X509Certificate r100, int r101) {
        ArrayList r102 = new ArrayList();
        Collection<List<?>> r103 = r100.getSubjectAlternativeNames();     // Catch: CertificateParsingException -> L25
        if (r103 == null) goto L6;
        Iterator<List<?>> r104 = r103.iterator();     // Catch: CertificateParsingException -> L25
    L9:
        if (r104.hasNext() == false) goto L24;
        List<?> r105 = r104.next();     // Catch: CertificateParsingException -> L25
        if (r105 == null) goto L9;
        if (r105.size() < 2) goto L9;
        Integer r106 = (Integer) ListProtector.get(r105, 0);     // Catch: CertificateParsingException -> L25
        if (r106 == null) goto L9;
        if (r106.intValue() != r101) goto L9;
        String r107 = (String) ListProtector.get(r105, 1);     // Catch: CertificateParsingException -> L25
        if (r107 == null) goto L9;
        r102.add(r107);     // Catch: CertificateParsingException -> L25
        goto L9
    L24:
        return r102;
    L6:
        return Collections.emptyList();
    L26:
        return Collections.emptyList();
    }

    public static boolean c(String r100, X509Certificate r101) {
        if (cvc.c.x(r100) == false) goto L10;
        List<String> r102 = b(r101, 7);
        int r103 = r102.size();
        int r104 = 0;
    L5:
        if (r104 >= r103) goto L72;
        if (r100.equalsIgnoreCase((String) ListProtector.get(r102, r104)) == true) goto L62;
        r104 = r104 + 1;
    L62:
        return true;
    L72:
        return false;
    L10:
        String r105 = r100.toLowerCase(Locale.US);
        Iterator<String> r106 = b(r101, 2).iterator();
    L12:
        if (r106.hasNext() == false) goto L73;
        String r107 = r106.next();
        if (r105 != null) goto L16;
    L60:
        boolean r108 = false;
    L61:
        if (r108 == false) goto L12;
    L16:
        if (r105.length() == 0) goto L60;
        if (r105.startsWith(".") == true) goto L60;
        if (r105.endsWith(DownloadConstants.VULNERABILITY_PATH) == true) goto L60;
        if (r107 == null) goto L60;
        if (r107.length() == 0) goto L60;
        if (r107.startsWith(".") == true) goto L60;
        if (r107.endsWith(DownloadConstants.VULNERABILITY_PATH) == true) goto L60;
        if (r105.endsWith(".") == true) goto L33;
        String r109 = r105.concat(".");
    L35:
        if (r107.endsWith(".") == true) goto L37;
        r107 = r107.concat(".");
    L37:
        String r110 = r107.toLowerCase(Locale.US);
        if (r110.contains("*") == true) goto L41;
        r108 = r109.equals(r110);
        goto L61
    L41:
        if (r110.startsWith("*.") == false) goto L60;
        if (r110.indexOf(42, 1) != (-1)) goto L60;
        if (r109.length() < r110.length()) goto L60;
        if ("*.".equals(r110) == true) goto L60;
        String r111 = r110.substring(1);
        if (r109.endsWith(r111) == false) goto L60;
        int r112 = r109.length() - r111.length();
        if (r112 > 0) goto L57;
    L59:
        r108 = true;
        goto L61
    L57:
        if (r109.lastIndexOf(46, r112 - 1) == (-1)) goto L59;
    L33:
        r109 = r105;
        goto L35
    L73:
        return false;
    }

    @Override // javax.net.ssl.HostnameVerifier
    public final boolean verify(String r100, SSLSession r101) {
        return c(r100, (X509Certificate) r101.getPeerCertificates()[0]);
    L5:
        return false;
    }
}
