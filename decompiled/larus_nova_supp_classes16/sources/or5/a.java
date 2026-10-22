package or5;

import android.text.TextUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import evc.e;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.g;
import okhttp3.h;
import okio.Okio;
import okio.q;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a implements Interceptor {
    public final h a;

    public a(h r1) {
        this.a = r1;
    }

    public final Response intercept(Interceptor.Chain r16) throws IOException {
        Request r0 = r16.request();
        Request.Builder r1 = r0.newBuilder();
        RequestBody r2 = r0.body();
        if (r2 == null) goto L12;
        MediaType r7 = r2.contentType();
        if (r7 == null) goto L7;
        r1.header("Content-Type", r7.toString());
    L7:
        long r8 = r2.contentLength();
        if (r8 == (-1)) goto L10;
        r1.header("Content-Length", Long.toString(r8));
        r1.removeHeader("Transfer-Encoding");
        goto L12
    L10:
        r1.header("Transfer-Encoding", "chunked");
        r1.removeHeader("Content-Length");
    L12:
        if (r0.header("Connection") != null) goto L14;
        r1.header("Connection", "Keep-Alive");
    L14:
        int r9 = 0;
        if (r0.header("x-command") != null) goto L32;
        String r10 = r0.url().url().getPath();     // Catch: Throwable -> L29
        Iterator r11 = r0.url().pathSegments().iterator();     // Catch: Throwable -> L29
    L18:
        if (r11.hasNext() == false) goto L24;
        String r12 = (String) r11.next();     // Catch: Throwable -> L29
        if (TextUtils.isEmpty(r12) == true) goto L18;
        if (r12.length() < 22) goto L18;
        r10 = r10.replace(r12, "");     // Catch: Throwable -> L29
        goto L18
    L24:
        int r13 = r10.indexOf("?");     // Catch: Throwable -> L29
        if (r13 < 0) goto L27;
        r10 = r10.substring(0, r13);     // Catch: Throwable -> L29
    L27:
        r1.header("x-command", r10.replace("/", "."));     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        tt5.a.e("BridgeInterceptor", "add x-command error", th, false);
    L32:
        if (r0.header("Accept-Encoding") == null) goto L34;
    L36:
        boolean r3 = false;
    L37:
        List r14 = this.a.a(r0.url());
        if (r14.isEmpty() == true) goto L45;
        StringBuilder r17 = new StringBuilder();
        int r18 = r14.size();
    L40:
        if (r9 >= r18) goto L44;
        if (r9 <= 0) goto L43;
        r17.append("; ");
    L43:
        g r19 = (g) ListProtector.get(r14, r9);
        r17.append(r19.a);
        r17.append('=');
        r17.append(r19.b);
        r9 = r9 + 1;
        goto L40
    L44:
        r1.header("Cookie", r17.toString());
    L45:
        Response r110 = r16.proceed(r1.build());
        e.e(this.a, r0.url(), r110.headers());
        Response.Builder r4 = r110.newBuilder().request(r0);
        if (r3 == false) goto L53;
        if ("gzip".equalsIgnoreCase(r110.header("Content-Encoding")) == false) goto L53;
        if (e.b(r110) == false) goto L53;
        q r5 = new q(r110.body().source());
        r4.headers(r110.headers().newBuilder().removeAll("Content-Encoding").removeAll("Content-Length").build());
        r4.body(new evc.g(r110.header("Content-Type"), -1, Okio.buffer(r5)));
    L53:
        return r4.build();
    L34:
        if (r0.header("Range") != null) goto L36;
        r1.header("Accept-Encoding", "gzip");
        r3 = true;
        goto L37
    }
}
