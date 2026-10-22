package okhttp3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public final enum TlsVersion extends Enum<TlsVersion> {
    public static final TlsVersion SSL_3_0 = null;
    public static final TlsVersion TLS_1_0 = null;
    public static final TlsVersion TLS_1_1 = null;
    public static final TlsVersion TLS_1_2 = null;
    public static final TlsVersion TLS_1_3 = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TlsVersion[] f523800a = null;
    final String javaName;

    static {
        TlsVersion r100 = new TlsVersion("TLS_1_3", 0, "TLSv1.3");
        TLS_1_3 = r100;
        TlsVersion r101 = new TlsVersion("TLS_1_2", 1, "TLSv1.2");
        TLS_1_2 = r101;
        TlsVersion r102 = new TlsVersion("TLS_1_1", 2, "TLSv1.1");
        TLS_1_1 = r102;
        TlsVersion r103 = new TlsVersion("TLS_1_0", 3, "TLSv1");
        TLS_1_0 = r103;
        TlsVersion r104 = new TlsVersion("SSL_3_0", 4, "SSLv3");
        SSL_3_0 = r104;
        f523800a = new TlsVersion[]{r100, r101, r102, r103, r104};
    }

    public static TlsVersion[] values() {
        return (TlsVersion[]) f523800a.clone();
    }

    public String javaName() {
        return this.javaName;
    }

    public static TlsVersion forJavaName(String r100) {
        r100.getClass();
        byte r101 = -1;
        switch(r100.hashCode()) {
            case -503070503: goto L22;
            case -503070502: goto L18;
            case -503070501: goto L14;
            case 79201641: goto L10;
            case 79923350: goto L6;
            default: goto L25;
        };
    L25:
        switch(r101) {
            case 0: goto L37;
            case 1: goto L35;
            case 2: goto L33;
            case 3: goto L31;
            case 4: goto L29;
            default: goto L27;
        };
    L27:
        throw new IllegalArgumentException("Unexpected TLS version: ".concat(r100));
    L29:
        return TLS_1_0;
    L31:
        return SSL_3_0;
    L33:
        return TLS_1_3;
    L35:
        return TLS_1_2;
    L37:
        return TLS_1_1;
    L6:
        if (r100.equals("TLSv1") == false) goto L25;
        r101 = 4;
        goto L25
    L10:
        if (r100.equals("SSLv3") == false) goto L25;
        r101 = 3;
        goto L25
    L14:
        if (r100.equals("TLSv1.3") == false) goto L25;
        r101 = 2;
        goto L25
    L18:
        if (r100.equals("TLSv1.2") == false) goto L25;
        r101 = 1;
        goto L25
    L22:
        if (r100.equals("TLSv1.1") == false) goto L25;
        r101 = 0;
        goto L25
    }

    public static List<TlsVersion> forJavaNames(String... r100) {
        ArrayList r101 = new ArrayList(r100.length);
        int r102 = r100.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L6;
        r101.add(forJavaName(r100[r103]));
        r103 = r103 + 1;
        goto L3
    L6:
        return Collections.unmodifiableList(r101);
    }

    public static TlsVersion valueOf(String r100) {
        return (TlsVersion) r27.a.a(TlsVersion.class, r100);
    }

    public TlsVersion(String r100, int r101, String r102) {
        super(r100, r101);
        this.javaName = r102;
    }
}
