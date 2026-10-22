package okhttp3;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.Nullable;
import javax.net.ssl.SSLPeerUnverifiedException;
import okio.ByteString;

/* JADX INFO: loaded from: classes5.dex */
public final class c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final c f523814c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set<a> f523815a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public final jvc.c f523816b;

    /* JADX INFO: loaded from: classes42.dex */
    public static final class a {
        public final String toString() {
            throw null;
        }

        public final int hashCode() {
            throw null;
        }

        public final boolean equals(Object r100) {
            if ((r100 instanceof a) == true) goto L6;
            return false;
        L6:
            ((a) r100).getClass();
            throw null;
        }
    }

    static {
        f523814c = new c(new LinkedHashSet(new ArrayList()), null);
    }

    public final int hashCode() {
        jvc.c r100 = this.f523816b;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L7:
        return (r101 * 31) + this.f523815a.hashCode();
    L5:
        r101 = 0;
        goto L7
    }

    public static String b(Certificate r100) {
        if ((r100 instanceof X509Certificate) == false) goto L7;
        return "sha256/" + ByteString.of(((X509Certificate) r100).getPublicKey().getEncoded()).sha256().base64();
    L7:
        throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
    }

    public final boolean equals(@Nullable Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == false) goto L12;
        c r101 = (c) r100;
        if (cvc.c.k(this.f523816b, r101.f523816b) == false) goto L12;
        if (this.f523815a.equals(r101.f523815a) == false) goto L12;
        return true;
    L12:
        return false;
    }

    public c(Set<a> r100, @Nullable jvc.c r101) {
        this.f523815a = r100;
        this.f523816b = r101;
    }

    public final void a(String r100, List<Certificate> r101) throws SSLPeerUnverifiedException {
        List r102 = Collections.emptyList();
        Iterator<a> r103 = this.f523815a.iterator();
        if (r103.hasNext() == false) goto L5;
        r103.next().getClass();
        throw null;
    L5:
        if (r102.isEmpty() == false) goto L7;
        return;
    L7:
        jvc.c r104 = this.f523816b;
        if (r104 == null) goto L10;
        r101 = r104.a(r101, r100);
    L10:
        int r105 = r101.size();
        int r106 = 0;
        int r107 = 0;
    L11:
        if (r107 >= r105) goto L17;
        X509Certificate r108 = (X509Certificate) ListProtector.get(r101, r107);
        if (r102.size() > 0) goto L15;
        r107 = r107 + 1;
        goto L11
    L15:
        ((a) ListProtector.get(r102, 0)).getClass();
        throw null;
    L17:
        StringBuilder r109 = new StringBuilder("Certificate pinning failure!\n  Peer certificate chain:");
        int r110 = r101.size();
        int r111 = 0;
    L19:
        if (r111 >= r110) goto L21;
        X509Certificate r112 = (X509Certificate) ListProtector.get(r101, r111);
        r109.append("\n    ");
        r109.append(b(r112));
        r109.append(": ");
        r109.append(r112.getSubjectDN().getName());
        r111 = r111 + 1;
        goto L19
    L21:
        r109.append("\n  Pinned certificates for ");
        r109.append(r100);
        r109.append(":");
        int r113 = r102.size();
    L22:
        if (r106 >= r113) goto L25;
        a r114 = (a) ListProtector.get(r102, r106);
        r109.append("\n    ");
        r109.append(r114);
        r106 = r106 + 1;
        goto L22
    L25:
        throw new SSLPeerUnverifiedException(r109.toString());
    }
}
