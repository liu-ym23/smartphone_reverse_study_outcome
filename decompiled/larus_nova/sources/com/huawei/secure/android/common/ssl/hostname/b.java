package com.huawei.secure.android.common.ssl.hostname;

import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.huawei.secure.android.common.ssl.util.e;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import com.ss.ttvideoengine.superresolution.SRStrategy;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import javax.net.ssl.SSLException;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes23.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Pattern f278158a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String[] f278159b = null;

    static {
        f278158a = PatternProtector.compile("^(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3}$");
        String[] r100 = {TTVideoEngineInterface.PLAY_API_KEY_AC, "co", "com", "ed", "edu", "go", "gouv", "gov", "info", "lg", "ne", com.alipay.sdk.m.k.b.f25406k, SRStrategy.KEY_ORIGIN_RESOLUTION, "org"};
        f278159b = r100;
        Arrays.sort(r100);
    }

    public b() {
    }

    public static boolean a(String r100) {
        int r101 = r100.length();
        if (r101 >= 7) goto L5;
        return true;
    L5:
        if (r101 > 9) goto L14;
        int r102 = r101 - 3;
        if (r100.charAt(r102) == '.') goto L9;
        return true;
    L9:
        if (Arrays.binarySearch(f278159b, r100.substring(2, r102)) < 0) goto L16;
        return false;
    L16:
        return true;
    L14:
        return true;
    }

    public static String[] b(X509Certificate r100) {
        LinkedList r101 = new LinkedList();
        Collection<List<?>> r102 = r100.getSubjectAlternativeNames();     // Catch: CertificateParsingException -> L5
    L7:
        if (r102 == null) goto L15;
        Iterator<List<?>> r103 = r102.iterator();
    L10:
        if (r103.hasNext() == false) goto L15;
        List<?> r104 = r103.next();
        if (((Integer) ListProtector.get(r104, 0)).intValue() != 2) goto L10;
        r101.add((String) ListProtector.get(r104, 1));
    L15:
        if (r101.isEmpty() == true) goto L18;
        String[] r105 = new String[r101.size()];
        r101.toArray(r105);
        return r105;
    L18:
        return null;
    L5:
        e = move-exception;
        e.a("", "Error parsing certificate.", e);
        r102 = null;
        goto L7
    }

    private static boolean c(String r100) {
        return f278158a.matcher(r100).matches();
    }

    public static String[] a(X509Certificate r100) {
        List<String> r101 = new a(r100.getSubjectX500Principal()).b("cn");
        if (r101.isEmpty() == true) goto L6;
        String[] r102 = new String[r101.size()];
        r101.toArray(r102);
        return r102;
    L6:
        return null;
    }

    public static int b(String r100) {
        int r101 = 0;
        int r102 = 0;
    L4:
        if (r101 >= r100.length()) goto L9;
        if (r100.charAt(r101) != '.') goto L8;
        r102 = r102 + 1;
    L8:
        r101 = r101 + 1;
        goto L4
    L9:
        return r102;
    }

    public static final void a(String r100, X509Certificate r101, boolean r102) throws SSLException {
        String[] r103 = a(r101);
        String[] r104 = b(r101);
        e.a("", "cn is : " + Arrays.toString(r103));
        e.a("", "san is : " + Arrays.toString(r104));
        a(r100, r103, r104, r102);
    }

    public static final void a(String r100, String[] r101, String[] r102, boolean r103) throws SSLException {
        LinkedList r104 = new LinkedList();
        if (r101 != null) goto L5;
    L9:
        if (r102 == null) goto L17;
        int r105 = r102.length;
        int r106 = 0;
    L11:
        if (r106 >= r105) goto L17;
        String r107 = r102[r106];
        if (r107 == null) goto L15;
        r104.add(r107);
    L15:
        r106 = r106 + 1;
    L17:
        if (r104.isEmpty() == true) goto L50;
        StringBuffer r108 = new StringBuffer();
        String r109 = r100.trim().toLowerCase(Locale.ENGLISH);
        Iterator r110 = r104.iterator();
        boolean r111 = false;
    L20:
        if (r110.hasNext() == false) goto L45;
        String r112 = ((String) r110.next()).toLowerCase(Locale.ENGLISH);
        r108.append(" <");
        r108.append(r112);
        r108.append(Typography.greater);
        if (r110.hasNext() == false) goto L25;
        r108.append(" OR");
    L25:
        if (r112.startsWith("*.") == true) goto L27;
    L33:
        boolean r113 = false;
    L34:
        if (r113 == false) goto L43;
        boolean r114 = r109.endsWith(r112.substring(1));
        if (r114 == false) goto L42;
        if (r103 == false) goto L42;
        if (b(r109) != b(r112)) goto L41;
        r111 = true;
    L44:
        if (r111 == false) goto L20;
    L41:
        r111 = false;
    L42:
        r111 = r114;
        goto L44
    L43:
        r111 = r109.equals(r112);
        goto L44
    L27:
        if (r112.indexOf(46, 2) == (-1)) goto L33;
        if (a(r112) == false) goto L33;
        if (c(r100) == true) goto L33;
        r113 = true;
    L45:
        if (r111 == false) goto L48;
        return;
    L48:
        throw new SSLException("hostname in certificate didn't match: <" + r100 + "> !=" + r108);
    L50:
        throw new SSLException("Certificate for <" + r100 + "> doesn't contain CN or DNS subjectAlt");
    L5:
        if (r101.length <= 0) goto L9;
        String r115 = r101[0];
        if (r115 == null) goto L9;
        r104.add(r115);
        goto L9
    }
}
