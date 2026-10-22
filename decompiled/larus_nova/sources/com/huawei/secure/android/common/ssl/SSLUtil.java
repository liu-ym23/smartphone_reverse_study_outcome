package com.huawei.secure.android.common.ssl;

import android.os.Build;
import com.huawei.secure.android.common.ssl.util.e;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;

/* JADX INFO: loaded from: classes23.dex */
public abstract class SSLUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f278078a = "SSLUtil";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f278079b = "TLSv1.3";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f278080c = "TLSv1.2";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f278081d = "TLS";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f278082e = "TLSv1";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String[] f278083f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String[] f278084g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final String[] f278085h = null;

    static {
        f278083f = new String[]{"TLS_DHE_DSS_WITH_AES_128_CBC_SHA", "TLS_DHE_RSA_WITH_AES_128_CBC_SHA", "TLS_DHE_DSS_WITH_AES_256_CBC_SHA", "TLS_DHE_RSA_WITH_AES_256_CBC_SHA", "TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA", "TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA", "TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA", "TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA"};
        f278084g = new String[]{"TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256", "TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384", "TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256", "TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384", "TLS_DHE_RSA_WITH_AES_128_GCM_SHA256", "TLS_DHE_RSA_WITH_AES_256_GCM_SHA384", "TLS_DHE_DSS_WITH_AES_128_GCM_SHA256", "TLS_DHE_DSS_WITH_AES_256_GCM_SHA384"};
        f278085h = new String[]{"TLS_RSA", "CBC", "TEA", "SHA0", "MD2", "MD4", "RIPEMD", "NULL", "RC4", "DES", "DESX", "DES40", "RC2", "MD5", "ANON", "TLS_EMPTY_RENEGOTIATION_INFO_SCSV"};
    }

    public static SSLContext setSSLContext() throws NoSuchAlgorithmException {
        if (Build.VERSION.SDK_INT < 29) goto L6;
        return SSLContext.getInstance(f278079b);
    L6:
        return SSLContext.getInstance(f278080c);
    }

    public SSLUtil() {
    }

    public static String[] getEnabledCipherSuites(SSLSocket r100) {
        return r100.getEnabledCipherSuites();
    }

    public static String[] getEnabledProtocols(SSLSocket r100) {
        return r100.getEnabledProtocols();
    }

    public static void printTLSAndCipher(SSLSocket r100) {
        String[] r101 = r100.getEnabledProtocols();
        int r102 = r101.length;
        int r103 = 0;
        int r104 = 0;
    L4:
        if (r104 >= r102) goto L6;
        e.c(f278078a, "new enable protocols is : " + r101[r104]);
        r104 = r104 + 1;
        goto L4
    L6:
        String[] r105 = r100.getEnabledCipherSuites();
        int r106 = r105.length;
    L7:
        if (r103 >= r106) goto L9;
        e.c(f278078a, "new cipher suites is : " + r105[r103]);
        r103 = r103 + 1;
        goto L7
    }

    public static boolean setBlackListCipherSuites(SSLSocket r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        return setBlackListCipherSuites(r100, f278085h);
    }

    public static void setEnableSafeCipherSuites(SSLSocket r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (setWhiteListCipherSuites(r100) == true) goto L8;
        setBlackListCipherSuites(r100);
        return;
    }

    public static void setEnabledProtocols(SSLSocket r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        int r101 = Build.VERSION.SDK_INT;
        if (r101 < 29) goto L7;
        r100.setEnabledProtocols(new String[]{f278079b, f278080c});
    L7:
        if (r101 >= 29) goto L10;
        r100.setEnabledProtocols(new String[]{f278080c});
        return;
    }

    public static void setSSLSocketOptions(SSLSocket r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        setEnabledProtocols(r100);
        setEnableSafeCipherSuites(r100);
    }

    public static boolean setWhiteListCipherSuites(SSLSocket r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        return setWhiteListCipherSuites(r100, f278084g);
    }

    public static boolean setBlackListCipherSuites(SSLSocket r110, String[] r111) {
        if (r110 != null) goto L5;
        return false;
    L5:
        String[] r100 = r110.getEnabledCipherSuites();
        ArrayList r101 = new ArrayList();
        int r102 = r100.length;
        int r103 = 0;
    L6:
        boolean r104 = true;
        if (r103 >= r102) goto L19;
        String r105 = r100[r103];
        String r106 = r105.toUpperCase(Locale.ENGLISH);
        int r107 = r111.length;
        int r108 = 0;
    L9:
        if (r108 >= r107) goto L14;
        if (r106.contains(r111[r108].toUpperCase(Locale.ENGLISH)) == true) goto L15;
        r108 = r108 + 1;
    L15:
        if (r104 == true) goto L17;
        r101.add(r105);
    L17:
        r103 = r103 + 1;
        goto L6
    L14:
        r104 = false;
        goto L15
    L19:
        if (r101.isEmpty() == true) goto L22;
        r110.setEnabledCipherSuites((String[]) r101.toArray(new String[r101.size()]));
        return true;
    L22:
        return false;
    }

    public static boolean setEnabledProtocols(SSLSocket r100, String[] r101) {
        if (r100 == null) goto L11;
        if (r101 == null) goto L11;
        r100.setEnabledProtocols(r101);     // Catch: Exception -> L9
        return true;
    L9:
        e = move-exception;
        e.b(f278078a, "setEnabledProtocols: exception : " + e.getMessage());
    L11:
        return false;
    }

    public static boolean setWhiteListCipherSuites(SSLSocket r100, String[] r101) {
        if (r100 != null) goto L5;
        return false;
    L5:
        String[] r102 = r100.getEnabledCipherSuites();
        ArrayList r103 = new ArrayList();
        List r104 = Arrays.asList(r101);
        int r105 = r102.length;
        int r106 = 0;
    L6:
        if (r106 >= r105) goto L12;
        String r107 = r102[r106];
        if (r104.contains(r107.toUpperCase(Locale.ENGLISH)) == false) goto L10;
        r103.add(r107);
    L10:
        r106 = r106 + 1;
        goto L6
    L12:
        if (r103.isEmpty() == true) goto L15;
        r100.setEnabledCipherSuites((String[]) r103.toArray(new String[r103.size()]));
        return true;
    L15:
        return false;
    }
}
