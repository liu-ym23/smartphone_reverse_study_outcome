package okhttp3;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import java.io.IOException;
import java.security.cert.Certificate;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;

/* JADX INFO: loaded from: classes42.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TlsVersion f523919a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f523920b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<Certificate> f523921c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<Certificate> f523922d;

    public final int hashCode() {
        return ((((((TTVideoEngineInterface.PLAYER_OPTION_ABR_STALL_PENALTY_PARAMETER + this.f523919a.hashCode()) * 31) + this.f523920b.hashCode()) * 31) + this.f523921c.hashCode()) * 31) + this.f523922d.hashCode();
    }

    public static j a(SSLSession r100) throws IOException {
        String r101 = r100.getCipherSuite();
        if (r101 == null) goto L30;
        if ("SSL_NULL_WITH_NULL_NULL".equals(r101) == true) goto L28;
        e r102 = e.a(r101);
        String r103 = r100.getProtocol();
        if (r103 == null) goto L26;
        if (UserProfileEvent.POSITION_NONE.equals(r103) == true) goto L24;
        TlsVersion r104 = TlsVersion.forJavaName(r103);
        Certificate[] r105 = r100.getPeerCertificates();     // Catch: SSLPeerUnverifiedException -> L13
    L14:
        if (r105 == null) goto L16;
        List r106 = cvc.c.o(r105);
    L17:
        Certificate[] r107 = r100.getLocalCertificates();
        if (r107 == null) goto L20;
        List r108 = cvc.c.o(r107);
    L22:
        return new j(r104, r102, r106, r108);
    L20:
        r108 = Collections.emptyList();
        goto L22
    L16:
        r106 = Collections.emptyList();
    L13:
        r105 = null;
        goto L14
    L24:
        throw new IOException("tlsVersion == NONE");
    L26:
        throw new IllegalStateException("tlsVersion == null");
    L28:
        throw new IOException("cipherSuite == SSL_NULL_WITH_NULL_NULL");
    L30:
        throw new IllegalStateException("cipherSuite == null");
    }

    public final boolean equals(@Nullable Object r100) {
        if ((r100 instanceof j) == true) goto L5;
        return false;
    L5:
        j r101 = (j) r100;
        if (this.f523919a.equals(r101.f523919a) == true) goto L8;
        return false;
    L8:
        if (this.f523920b.equals(r101.f523920b) == true) goto L10;
        return false;
    L10:
        if (this.f523921c.equals(r101.f523921c) == true) goto L12;
        return false;
    L12:
        if (this.f523922d.equals(r101.f523922d) == false) goto L18;
        return true;
    L18:
        return false;
    }

    public j(TlsVersion r100, e r101, List<Certificate> r102, List<Certificate> r103) {
        this.f523919a = r100;
        this.f523920b = r101;
        this.f523921c = r102;
        this.f523922d = r103;
    }
}
