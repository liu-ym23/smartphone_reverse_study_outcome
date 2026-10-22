package lr5;

import android.os.SystemClock;
import android.util.LruCache;
import com.bytedance.ee.eenet.util.HttpChannel;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class d extends okhttp3.i {
    public final LruCache<Call, a> a;

    public static class a {
        public okhttp3.i a;
        public final b b;

        public a() {
            this.b = new b();
        }
    }

    public static class b {
        public long a;
        public long b;
        public long c;
        public long d;
        public long e;
        public long f;
        public long g;
        public long h;
        public long i;
        public long j;
        public long k;
        public long l;
        public long m;
        public long n;
        public String o;
        public IOException p;

        public b() {
        }
    }

    public d() {
        this.a = new LruCache(10);
    }

    public static long a(long r3) {
        if (r3 != 0) goto L6;
        return 0;
    L6:
        return SystemClock.elapsedRealtime() - r3;
    }

    public final void callEnd(Call r5) {
        a r0 = this.a.remove(r5);
        if (r0 != null) goto L5;
        return;
    L5:
        r0.a.callEnd(r5);
        b r1 = r0.b;
        r1.m = a(r1.a);
        b(r5, r0.b, false);
    }

    public final void callStart(Call r3) {
        a r0 = this.a.get(r3);
        if (r0 != null) goto L5;
        return;
    L5:
        r0.a.callStart(r3);
        b r4 = r0.b;
        r4.a = SystemClock.elapsedRealtime();
    }

    public final void requestBodyStart(Call r3) {
        a r0 = this.a.get(r3);
        if (r0 != null) goto L5;
        return;
    L5:
        r0.a.requestBodyStart(r3);
        b r4 = r0.b;
        r4.g = SystemClock.elapsedRealtime();
    }

    public final void requestHeadersStart(Call r3) {
        a r0 = this.a.get(r3);
        if (r0 != null) goto L5;
        return;
    L5:
        r0.a.requestHeadersStart(r3);
        b r4 = r0.b;
        r4.f = SystemClock.elapsedRealtime();
    }

    public final void responseBodyStart(Call r3) {
        a r0 = this.a.get(r3);
        if (r0 != null) goto L5;
        return;
    L5:
        r0.a.responseBodyStart(r3);
        b r4 = r0.b;
        r4.i = SystemClock.elapsedRealtime();
    }

    public final void responseHeadersStart(Call r3) {
        a r0 = this.a.get(r3);
        if (r0 != null) goto L5;
        return;
    L5:
        r0.a.responseHeadersStart(r3);
        b r4 = r0.b;
        r4.h = SystemClock.elapsedRealtime();
    }

    public final void secureConnectStart(Call r3) {
        a r0 = this.a.get(r3);
        if (r0 != null) goto L5;
        return;
    L5:
        r0.a.secureConnectStart(r3);
        b r4 = r0.b;
        r4.d = SystemClock.elapsedRealtime();
    }

    public final void callFailed(Call r5, IOException r6) {
        a r0 = this.a.remove(r5);
        if (r0 != null) goto L5;
        return;
    L5:
        r0.a.callFailed(r5, r6);
        b r1 = r0.b;
        r1.p = r6;
        r1.m = a(r1.a);
        b(r5, r0.b, true);
    }

    public final void connectionAcquired(Call r3, Connection r4) {
        a r0 = this.a.get(r3);
        if (r0 != null) goto L5;
        return;
    L5:
        r0.a.connectionAcquired(r3, r4);
        b r5 = r0.b;
        r5.e = SystemClock.elapsedRealtime();
    }

    public final void connectionReleased(Call r3, Connection r4) {
        a r0 = this.a.get(r3);
        if (r0 != null) goto L5;
        return;
    L5:
        r0.a.connectionReleased(r3, r4);
        a(r0.b.e);
    }

    public final void dnsStart(Call r3, String r4) {
        a r0 = this.a.get(r3);
        if (r0 != null) goto L5;
        return;
    L5:
        r0.a.dnsStart(r3, r4);
        b r5 = r0.b;
        r5.b = SystemClock.elapsedRealtime();
    }

    public final void requestBodyEnd(Call r3, long r4) {
        a r0 = this.a.get(r3);
        if (r0 != null) goto L5;
        return;
    L5:
        r0.a.requestBodyEnd(r3, r4);
        b r5 = r0.b;
        a(r5.g);
        r5.getClass();
    }

    public final void requestHeadersEnd(Call r3, Request r4) {
        a r0 = this.a.get(r3);
        if (r0 != null) goto L5;
        return;
    L5:
        r0.a.requestHeadersEnd(r3, r4);
        b r5 = r0.b;
        a(r5.f);
        r5.getClass();
    }

    public final void responseBodyEnd(Call r3, long r4) {
        a r0 = this.a.get(r3);
        if (r0 != null) goto L5;
        return;
    L5:
        r0.a.responseBodyEnd(r3, r4);
        b r5 = r0.b;
        r5.n = r4;
        a(r5.i);
        r5.getClass();
    }

    public final void responseHeadersEnd(Call r3, Response r4) {
        a r0 = this.a.get(r3);
        if (r0 != null) goto L5;
        return;
    L5:
        r0.a.responseHeadersEnd(r3, r4);
        b r5 = r0.b;
        a(r5.h);
        r5.getClass();
    }

    public final void secureConnectEnd(Call r3, j r4) {
        a r0 = this.a.get(r3);
        if (r0 != null) goto L5;
        return;
    L5:
        r0.a.secureConnectEnd(r3, r4);
        b r5 = r0.b;
        r5.l = a(r5.d);
    }

    public static void b(Call r7, b r8, boolean r9) {
        if ((r7 instanceof nr5.b) == false) goto L5;
        return;
    L5:
        ak5.g r0 = rr5.b.a;
        if (r0 != null) goto L8;
        return;
    L8:
        kr5.a r4 = new kr5.a();
        r4.f = HttpChannel.OkHttpChannel.toString();
        r4.d = r8.o;
        long r1 = r8.k;
        long r5 = r8.l;
        r4.b = (int) (r1 - r5);
        r4.c = (int) r5;
        r4.a = (int) r8.j;
        r4.l = r8.n;
        Request r10 = r7.request();
        if (r10 == null) goto L18;
        r4.e = r10.url().toString();
        r10.url().host();
        r10.url().topPrivateDomain();
        String r2 = r10.header("request-id");
        String r3 = "";
        if (r2 != null) goto L14;
        r2 = "";
    L14:
        r4.g = r2;
        String r6 = r10.header("EENet-Request-Tag");
        if (r6 == null) goto L17;
        r3 = r6;
    L17:
        r4.j = r3;
        r4.i = r10.method();
        r4.k = qr5.a.a(r10);
    L18:
        if (r9 == true) goto L20;
        ak5.g r11 = r0;
        r11.a(r8.m, r4, 0, null);
        return;
    L20:
        ak5.g r12 = r0;
        r12.a(r8.m, r4, -1, r8.p);
    }

    public final void connectStart(Call r3, InetSocketAddress r4, Proxy r5) {
        a r0 = this.a.get(r3);
        if (r0 != null) goto L5;
        return;
    L5:
        r0.a.connectStart(r3, r4, r5);
        b r6 = r0.b;
        r6.c = SystemClock.elapsedRealtime();
    }

    public final void dnsEnd(Call r3, String r4, List<InetAddress> r5) {
        a r0 = this.a.get(r3);
        if (r0 != null) goto L5;
        return;
    L5:
        r0.a.dnsEnd(r3, r4, r5);
        b r6 = r0.b;
        r6.j = a(r6.b);
    }

    public final void connectEnd(Call r3, InetSocketAddress r4, Proxy r5, Protocol r6) {
        a r0 = this.a.get(r3);
        if (r0 != null) goto L5;
        return;
    L5:
        r0.a.connectEnd(r3, r4, r5, r6);
        b r7 = r0.b;
        r7.k = a(r7.c);
        b r8 = r0.b;
        if (r6 != null) goto L8;
        String r9 = " ";
    L9:
        r8.o = r9;
        return;
    L8:
        r9 = r6.toString();
        goto L9
    }

    public final void connectFailed(Call r8, InetSocketAddress r9, Proxy r10, Protocol r11, IOException r12) {
        a r0 = this.a.get(r8);
        if (r0 != null) goto L5;
        return;
    L5:
        r0.a.connectFailed(r8, r9, r10, r11, r12);
        b r13 = r0.b;
        r13.k = a(r13.c);
        b r14 = r0.b;
        if (r11 != null) goto L8;
        String r16 = " ";
    L9:
        r14.o = r16;
        return;
    L8:
        r16 = r11.toString();
        goto L9
    }
}
