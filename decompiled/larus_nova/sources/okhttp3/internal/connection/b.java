package okhttp3.internal.connection;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.io.IOException;
import java.net.UnknownServiceException;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;
import okhttp3.OkHttpClient;

/* JADX INFO: loaded from: classes42.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<okhttp3.f> f523877a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f523878b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f523879c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f523880d;

    public b(List<okhttp3.f> r100) {
        this.f523878b = 0;
        this.f523877a = r100;
    }

    public final okhttp3.f a(SSLSocket r110) throws IOException {
        int r100 = this.f523878b;
        int r101 = this.f523877a.size();
    L4:
        if (r100 >= r101) goto L9;
        okhttp3.f r102 = (okhttp3.f) ListProtector.get(this.f523877a, r100);
        if (r102.a(r110) == true) goto L7;
        r100 = r100 + 1;
        goto L4
    L7:
        this.f523878b = r100 + 1;
    L10:
        if (r102 == null) goto L46;
        int r103 = this.f523878b;
    L13:
        if (r103 >= this.f523877a.size()) goto L18;
        if (((okhttp3.f) ListProtector.get(this.f523877a, r103)).a(r110) == true) goto L16;
        r103 = r103 + 1;
        goto L13
    L16:
        boolean r104 = true;
    L19:
        this.f523879c = r104;
        OkHttpClient.a r105 = cvc.a.f465511a;
        boolean r106 = this.f523880d;
        r105.getClass();
        if (r102.f523845c == null) goto L22;
        String[] r107 = cvc.c.p(okhttp3.e.f523819b, r110.getEnabledCipherSuites(), r102.f523845c);
    L24:
        if (r102.f523846d == null) goto L26;
        String[] r108 = cvc.c.p(cvc.c.f465529q, r110.getEnabledProtocols(), r102.f523846d);
    L27:
        String[] r109 = r110.getSupportedCipherSuites();
        okhttp3.e.a r111 = okhttp3.e.f523819b;
        byte[] r112 = cvc.c.f465513a;
        int r113 = r109.length;
        int r114 = 0;
    L29:
        if (r114 >= r113) goto L34;
        if (r111.compare(r109[r114], "TLS_FALLBACK_SCSV") == 0) goto L35;
        r114 = r114 + 1;
    L35:
        if (r106 == false) goto L38;
        if (r114 == (-1)) goto L38;
        String r115 = r109[r114];
        int r116 = r107.length + 1;
        String[] r117 = new String[r116];
        System.arraycopy(r107, 0, r117, 0, r107.length);
        r117[r116 - 1] = r115;
        r107 = r117;
    L38:
        okhttp3.f.a r118 = new okhttp3.f.a(r102);
        r118.a(r107);
        r118.c(r108);
        okhttp3.f r119 = new okhttp3.f(r118);
        String[] r120 = r119.f523846d;
        if (r120 == null) goto L41;
        r110.setEnabledProtocols(r120);
    L41:
        String[] r121 = r119.f523845c;
        if (r121 == null) goto L44;
        r110.setEnabledCipherSuites(r121);
    L44:
        return r102;
    L34:
        r114 = -1;
        goto L35
    L26:
        r108 = r110.getEnabledProtocols();
        goto L27
    L22:
        r107 = r110.getEnabledCipherSuites();
        goto L24
    L18:
        r104 = false;
        goto L19
    L46:
        throw new UnknownServiceException("Unable to find acceptable protocols. isFallback=" + this.f523880d + ", modes=" + this.f523877a + ", supported protocols=" + Arrays.toString(r110.getEnabledProtocols()));
    L9:
        r102 = null;
        goto L10
    }
}
