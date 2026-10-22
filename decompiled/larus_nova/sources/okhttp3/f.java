package okhttp3;

import com.ss.ttvideoengine.TTVideoEngineInterface;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLSocket;
import okhttp3.ttnet.TTConfigManager;

/* JADX INFO: loaded from: classes5.dex */
public final class f {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final f f523840e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final f f523841f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final f f523842g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f523843a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f523844b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public final String[] f523845c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public final String[] f523846d;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f523847a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        public String[] f523848b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        public String[] f523849c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f523850d;

        public a(f r100) {
            this.f523847a = r100.f523843a;
            this.f523848b = r100.f523845c;
            this.f523849c = r100.f523846d;
            this.f523850d = r100.f523844b;
        }

        public final void a(String... r100) {
            if (this.f523847a == false) goto L11;
            if (r100.length == 0) goto L9;
            this.f523848b = (String[]) r100.clone();
            return;
        L9:
            throw new IllegalArgumentException("At least one cipher suite is required");
        L11:
            throw new IllegalStateException("no cipher suites for cleartext connections");
        }

        public final void b(e... r100) {
            if (this.f523847a == false) goto L11;
            String[] r101 = new String[r100.length];
            int r102 = 0;
        L6:
            if (r102 >= r100.length) goto L8;
            r101[r102] = r100[r102].f523839a;
            r102 = r102 + 1;
            goto L6
        L8:
            a(r101);
            return;
        L11:
            throw new IllegalStateException("no cipher suites for cleartext connections");
        }

        public final void c(String... r100) {
            if (this.f523847a == false) goto L11;
            if (r100.length == 0) goto L9;
            this.f523849c = (String[]) r100.clone();
            return;
        L9:
            throw new IllegalArgumentException("At least one TLS version is required");
        L11:
            throw new IllegalStateException("no TLS versions for cleartext connections");
        }

        public final void d(TlsVersion... r100) {
            if (this.f523847a == false) goto L11;
            String[] r101 = new String[r100.length];
            int r102 = 0;
        L6:
            if (r102 >= r100.length) goto L8;
            r101[r102] = r100[r102].javaName;
            r102 = r102 + 1;
            goto L6
        L8:
            c(r101);
            return;
        L11:
            throw new IllegalStateException("no TLS versions for cleartext connections");
        }

        public a(boolean r100) {
            this.f523847a = r100;
        }
    }

    static {
        e r100 = e.f523834q;
        e r101 = e.f523835r;
        e r102 = e.f523836s;
        e r103 = e.f523837t;
        e r110 = e.f523838u;
        e r111 = e.f523828k;
        e r112 = e.f523830m;
        e r113 = e.f523829l;
        e r114 = e.f523831n;
        e r210 = e.f523833p;
        e r211 = e.f523832o;
        e[] r104 = {r100, r101, r102, r103, r110, r111, r112, r113, r114, r210, r211};
        e[] r105 = {r100, r101, r102, r103, r110, r111, r112, r113, r114, r210, r211, e.f523826i, e.f523827j, e.f523824g, e.f523825h, e.f523822e, e.f523823f, e.f523821d};
        a r106 = new a(true);
        r106.b(r104);
        TlsVersion r107 = TlsVersion.TLS_1_3;
        TlsVersion r108 = TlsVersion.TLS_1_2;
        r106.d(new TlsVersion[]{r107, r108});
        r106.f523850d = true;
        new f(r106);
        TlsVersion r109 = TlsVersion.TLS_1_0;
        TlsVersion[] r115 = {r107, r108, TlsVersion.TLS_1_1, r109};
        TlsVersion[] r116 = {r107, r108};
        a r117 = new a(true);
        r117.b(r105);
        if (TTConfigManager.inst().enableTls1_1() == true) goto L6;
        r115 = r116;
    L6:
        r117.d(r115);
        r117.f523850d = true;
        f523840e = new f(r117);
        a r118 = new a(true);
        r118.b(r105);
        r118.d(new TlsVersion[]{r109});
        r118.f523850d = true;
        f523841f = new f(r118);
        f523842g = new f(new a(false));
    }

    public final int hashCode() {
        if (this.f523843a == true) goto L7;
        return 17;
    L7:
        return ((((TTVideoEngineInterface.PLAYER_OPTION_ABR_STALL_PENALTY_PARAMETER + Arrays.hashCode(this.f523845c)) * 31) + Arrays.hashCode(this.f523846d)) * 31) + (!this.f523844b ? 1 : 0);
    }

    public final String toString() {
        if (this.f523843a == true) goto L6;
        return "ConnectionSpec()";
    L6:
        String[] r100 = this.f523845c;
        List<TlsVersion> r101 = null;
        String r102 = "[all enabled]";
        if (r100 == null) goto L15;
        if (r100 == null) goto L13;
        ArrayList r103 = new ArrayList(r100.length);
        int r104 = r100.length;
        int r105 = 0;
    L10:
        if (r105 >= r104) goto L12;
        r103.add(e.a(r100[r105]));
        r105 = r105 + 1;
        goto L10
    L12:
        List r106 = Collections.unmodifiableList(r103);
    L14:
        String r107 = r106.toString();
    L16:
        String[] r108 = this.f523846d;
        if (r108 == null) goto L22;
        if (r108 == null) goto L20;
        r101 = TlsVersion.forJavaNames(r108);
    L20:
        r102 = r101.toString();
    L22:
        return "ConnectionSpec(cipherSuites=" + r107 + ", tlsVersions=" + r102 + ", supportsTlsExtensions=" + this.f523844b + ")";
    L13:
        r106 = null;
        goto L14
    L15:
        r107 = "[all enabled]";
        goto L16
    }

    public f(a r100) {
        this.f523843a = r100.f523847a;
        this.f523845c = r100.f523848b;
        this.f523846d = r100.f523849c;
        this.f523844b = r100.f523850d;
    }

    public final boolean a(SSLSocket r100) {
        if (this.f523843a == true) goto L5;
        return false;
    L5:
        String[] r101 = this.f523846d;
        if (r101 != null) goto L8;
    L10:
        String[] r102 = this.f523845c;
        if (r102 != null) goto L13;
        return true;
    L13:
        if (cvc.c.r(e.f523819b, r102, r100.getEnabledCipherSuites()) == true) goto L17;
        return false;
    L17:
        return true;
    L8:
        if (cvc.c.r(cvc.c.f465529q, r101, r100.getEnabledProtocols()) == true) goto L10;
        return false;
    }

    public final boolean equals(@Nullable Object r100) {
        if ((r100 instanceof f) == true) goto L6;
        return false;
    L6:
        if (r100 != this) goto L8;
        return true;
    L8:
        f r101 = (f) r100;
        boolean r102 = this.f523843a;
        if (r102 == r101.f523843a) goto L11;
        return false;
    L11:
        if (r102 == true) goto L13;
    L21:
        return true;
    L13:
        if (Arrays.equals(this.f523845c, r101.f523845c) == true) goto L16;
        return false;
    L16:
        if (Arrays.equals(this.f523846d, r101.f523846d) == true) goto L19;
        return false;
    L19:
        if (this.f523844b == r101.f523844b) goto L21;
        return false;
    }
}
