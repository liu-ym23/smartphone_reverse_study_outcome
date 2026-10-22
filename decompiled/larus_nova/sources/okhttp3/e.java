package okhttp3;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public final class e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f523819b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map<String, e> f523820c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final e f523821d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final e f523822e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final e f523823f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final e f523824g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final e f523825h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final e f523826i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final e f523827j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final e f523828k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final e f523829l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final e f523830m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final e f523831n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final e f523832o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final e f523833p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final e f523834q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final e f523835r = null;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final e f523836s = null;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final e f523837t = null;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final e f523838u = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f523839a;

    public static class a implements Comparator<String> {
        public a() {
        }

        @Override // java.util.Comparator
        public final int compare(String r100, String r101) {
            String r102 = r100;
            String r103 = r101;
            int r104 = Math.min(r102.length(), r103.length());
            int r105 = 4;
        L4:
            if (r105 >= r104) goto L10;
            char r106 = r102.charAt(r105);
            char r107 = r103.charAt(r105);
            if (r106 != r107) goto L7;
            r105 = r105 + 1;
            goto L4
        L7:
            if (r106 >= r107) goto L18;
        L8:
            return -1;
        L18:
            return 1;
        L10:
            int r108 = r102.length();
            int r109 = r103.length();
            if (r108 == r109) goto L14;
            if (r108 < r109) goto L8;
            return 1;
        L14:
            return 0;
        }
    }

    static {
        f523819b = new a();
        f523820c = new LinkedHashMap();
        b("SSL_RSA_WITH_NULL_MD5");
        b("SSL_RSA_WITH_NULL_SHA");
        b("SSL_RSA_EXPORT_WITH_RC4_40_MD5");
        b("SSL_RSA_WITH_RC4_128_MD5");
        b("SSL_RSA_WITH_RC4_128_SHA");
        b("SSL_RSA_EXPORT_WITH_DES40_CBC_SHA");
        b("SSL_RSA_WITH_DES_CBC_SHA");
        f523821d = b("SSL_RSA_WITH_3DES_EDE_CBC_SHA");
        b("SSL_DHE_DSS_EXPORT_WITH_DES40_CBC_SHA");
        b("SSL_DHE_DSS_WITH_DES_CBC_SHA");
        b("SSL_DHE_DSS_WITH_3DES_EDE_CBC_SHA");
        b("SSL_DHE_RSA_EXPORT_WITH_DES40_CBC_SHA");
        b("SSL_DHE_RSA_WITH_DES_CBC_SHA");
        b("SSL_DHE_RSA_WITH_3DES_EDE_CBC_SHA");
        b("SSL_DH_anon_EXPORT_WITH_RC4_40_MD5");
        b("SSL_DH_anon_WITH_RC4_128_MD5");
        b("SSL_DH_anon_EXPORT_WITH_DES40_CBC_SHA");
        b("SSL_DH_anon_WITH_DES_CBC_SHA");
        b("SSL_DH_anon_WITH_3DES_EDE_CBC_SHA");
        b("TLS_KRB5_WITH_DES_CBC_SHA");
        b("TLS_KRB5_WITH_3DES_EDE_CBC_SHA");
        b("TLS_KRB5_WITH_RC4_128_SHA");
        b("TLS_KRB5_WITH_DES_CBC_MD5");
        b("TLS_KRB5_WITH_3DES_EDE_CBC_MD5");
        b("TLS_KRB5_WITH_RC4_128_MD5");
        b("TLS_KRB5_EXPORT_WITH_DES_CBC_40_SHA");
        b("TLS_KRB5_EXPORT_WITH_RC4_40_SHA");
        b("TLS_KRB5_EXPORT_WITH_DES_CBC_40_MD5");
        b("TLS_KRB5_EXPORT_WITH_RC4_40_MD5");
        f523822e = b("TLS_RSA_WITH_AES_128_CBC_SHA");
        b("TLS_DHE_DSS_WITH_AES_128_CBC_SHA");
        b("TLS_DHE_RSA_WITH_AES_128_CBC_SHA");
        b("TLS_DH_anon_WITH_AES_128_CBC_SHA");
        f523823f = b("TLS_RSA_WITH_AES_256_CBC_SHA");
        b("TLS_DHE_DSS_WITH_AES_256_CBC_SHA");
        b("TLS_DHE_RSA_WITH_AES_256_CBC_SHA");
        b("TLS_DH_anon_WITH_AES_256_CBC_SHA");
        b("TLS_RSA_WITH_NULL_SHA256");
        b("TLS_RSA_WITH_AES_128_CBC_SHA256");
        b("TLS_RSA_WITH_AES_256_CBC_SHA256");
        b("TLS_DHE_DSS_WITH_AES_128_CBC_SHA256");
        b("TLS_RSA_WITH_CAMELLIA_128_CBC_SHA");
        b("TLS_DHE_DSS_WITH_CAMELLIA_128_CBC_SHA");
        b("TLS_DHE_RSA_WITH_CAMELLIA_128_CBC_SHA");
        b("TLS_DHE_RSA_WITH_AES_128_CBC_SHA256");
        b("TLS_DHE_DSS_WITH_AES_256_CBC_SHA256");
        b("TLS_DHE_RSA_WITH_AES_256_CBC_SHA256");
        b("TLS_DH_anon_WITH_AES_128_CBC_SHA256");
        b("TLS_DH_anon_WITH_AES_256_CBC_SHA256");
        b("TLS_RSA_WITH_CAMELLIA_256_CBC_SHA");
        b("TLS_DHE_DSS_WITH_CAMELLIA_256_CBC_SHA");
        b("TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA");
        b("TLS_PSK_WITH_RC4_128_SHA");
        b("TLS_PSK_WITH_3DES_EDE_CBC_SHA");
        b("TLS_PSK_WITH_AES_128_CBC_SHA");
        b("TLS_PSK_WITH_AES_256_CBC_SHA");
        b("TLS_RSA_WITH_SEED_CBC_SHA");
        f523824g = b("TLS_RSA_WITH_AES_128_GCM_SHA256");
        f523825h = b("TLS_RSA_WITH_AES_256_GCM_SHA384");
        b("TLS_DHE_RSA_WITH_AES_128_GCM_SHA256");
        b("TLS_DHE_RSA_WITH_AES_256_GCM_SHA384");
        b("TLS_DHE_DSS_WITH_AES_128_GCM_SHA256");
        b("TLS_DHE_DSS_WITH_AES_256_GCM_SHA384");
        b("TLS_DH_anon_WITH_AES_128_GCM_SHA256");
        b("TLS_DH_anon_WITH_AES_256_GCM_SHA384");
        b("TLS_EMPTY_RENEGOTIATION_INFO_SCSV");
        b("TLS_FALLBACK_SCSV");
        b("TLS_ECDH_ECDSA_WITH_NULL_SHA");
        b("TLS_ECDH_ECDSA_WITH_RC4_128_SHA");
        b("TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA");
        b("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA");
        b("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA");
        b("TLS_ECDHE_ECDSA_WITH_NULL_SHA");
        b("TLS_ECDHE_ECDSA_WITH_RC4_128_SHA");
        b("TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA");
        b("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA");
        b("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA");
        b("TLS_ECDH_RSA_WITH_NULL_SHA");
        b("TLS_ECDH_RSA_WITH_RC4_128_SHA");
        b("TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA");
        b("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA");
        b("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA");
        b("TLS_ECDHE_RSA_WITH_NULL_SHA");
        b("TLS_ECDHE_RSA_WITH_RC4_128_SHA");
        b("TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA");
        f523826i = b("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA");
        f523827j = b("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA");
        b("TLS_ECDH_anon_WITH_NULL_SHA");
        b("TLS_ECDH_anon_WITH_RC4_128_SHA");
        b("TLS_ECDH_anon_WITH_3DES_EDE_CBC_SHA");
        b("TLS_ECDH_anon_WITH_AES_128_CBC_SHA");
        b("TLS_ECDH_anon_WITH_AES_256_CBC_SHA");
        b("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256");
        b("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384");
        b("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA256");
        b("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA384");
        b("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256");
        b("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384");
        b("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA256");
        b("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA384");
        f523828k = b("TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256");
        f523829l = b("TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384");
        b("TLS_ECDH_ECDSA_WITH_AES_128_GCM_SHA256");
        b("TLS_ECDH_ECDSA_WITH_AES_256_GCM_SHA384");
        f523830m = b("TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256");
        f523831n = b("TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384");
        b("TLS_ECDH_RSA_WITH_AES_128_GCM_SHA256");
        b("TLS_ECDH_RSA_WITH_AES_256_GCM_SHA384");
        b("TLS_ECDHE_PSK_WITH_AES_128_CBC_SHA");
        b("TLS_ECDHE_PSK_WITH_AES_256_CBC_SHA");
        f523832o = b("TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256");
        f523833p = b("TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256");
        b("TLS_DHE_RSA_WITH_CHACHA20_POLY1305_SHA256");
        b("TLS_ECDHE_PSK_WITH_CHACHA20_POLY1305_SHA256");
        f523834q = b("TLS_AES_128_GCM_SHA256");
        f523835r = b("TLS_AES_256_GCM_SHA384");
        f523836s = b("TLS_CHACHA20_POLY1305_SHA256");
        f523837t = b("TLS_AES_128_CCM_SHA256");
        f523838u = b("TLS_AES_256_CCM_8_SHA256");
    }

    public final String toString() {
        return this.f523839a;
    }

    public e(String r100) {
        if (r100 == null) goto L7;
        this.f523839a = r100;
        return;
    L7:
        throw null;
    }

    public static synchronized e a(String r100) {
        monitor-enter(e.class);
        Map<String, e> r101 = f523820c;     // Catch: Throwable -> L19
        e r102 = (e) ((LinkedHashMap) r101).get(r100);     // Catch: Throwable -> L19
        if (r102 == null) goto L7;
    L17:
        monitor-exit(e.class);
        return r102;
    L7:
        if (r100.startsWith("TLS_") == false) goto L10;
        String r103 = "SSL_" + r100.substring(4);     // Catch: Throwable -> L19
    L13:
        r102 = (e) ((LinkedHashMap) r101).get(r103);     // Catch: Throwable -> L19
        if (r102 != null) goto L16;
        r102 = new e(r100);     // Catch: Throwable -> L19
    L16:
        r101.put(r100, r102);     // Catch: Throwable -> L19
        goto L17
    L10:
        if (r100.startsWith("SSL_") == false) goto L12;
        r103 = "TLS_" + r100.substring(4);     // Catch: Throwable -> L19
        goto L13
    L12:
        r103 = r100;
    L19:
        th = move-exception;
        throw th;
    }

    public static e b(String r100) {
        e r101 = new e(r100);
        f523820c.put(r100, r101);
        return r101;
    }
}
