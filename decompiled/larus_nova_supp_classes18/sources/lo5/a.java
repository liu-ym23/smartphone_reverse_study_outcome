package lo5;

import android.text.TextUtils;
import com.bytedance.ee.bear.contract.b0;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import ho5.c;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import ko5.b;
import okhttp3.Call;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a {
    public static final List<b> f = null;
    public final ThumbGlideUrl a;
    public final Call.a b;
    public volatile boolean c;
    public volatile Call d;
    public ResponseBody e;

    static {
        ArrayList r0 = new ArrayList();
        f = r0;
        r0.add(new ko5.a());
    }

    public a(Call.a r1, ThumbGlideUrl r2) {
        this.b = r1;
        this.a = r2;
    }

    public final InputStream a(URL r14, int r15, URL r16, String r17, boolean r18) throws IOException {
        if (r15 >= 5) goto L81;
        if (r16 != null) goto L86;
    L10:
        Request.Builder r3 = new Request.Builder().url(r14);
        Iterator r4 = this.a.getHeaders().entrySet().iterator();
    L12:
        if (r4.hasNext() == false) goto L14;
        Map.Entry r5 = (Map.Entry) r4.next();
        r3.addHeader((String) r5.getKey(), (String) r5.getValue());
        goto L12
    L14:
        b0 r6 = (b0) org.koin.java.a.a(b0.class);
        r3.addHeader("If-None-Match", r17);
        r3.addHeader("User-Agent", r6.h());
        r3.addHeader("use-new-default-thumbnail", "true");
        this.d = this.b.newCall(r3.build());
        Response r7 = this.d.execute();
        if (this.c == false) goto L22;
        if (r7 != null) goto L84;
    L21:
        return null;
    L84:
        r7.close();     // Catch: Exception -> L19
    L19:
        e = move-exception;
        tt5.a.f("ThumbDownloadTask", e, false);
        goto L21
    L22:
        this.a.setResponseHeaders(r7.headers().toMultimap());
        this.a.setStatusCode(r7.code());
        if (r7.code() != 200) goto L25;
    L27:
        String r8 = r7.header("etag", "");
        if (TextUtils.isEmpty(r8) == true) goto L48;
        c r9 = c.d();
        String r10 = r14.toString();
        String r11 = this.a.getVersion();
        monitor-enter(r9);
    L45:
        th = move-exception;
        throw th;
    L32:
        if (c.b == null) goto L44;
        if (TextUtils.isEmpty(r10) == false) goto L36;
    L41:
        monitor-exit(r9);
    L42:
        this.a.setETag(r8);
        goto L48
    L36:
        if (TextUtils.isEmpty(r8) == true) goto L41;
        String r12 = r9.e(r10, r11);     // Catch: Throwable -> L45
        tt5.a.b("ETagCache", "saveETag, new Key:" + r12);     // Catch: Throwable -> L45
        c.b.b(du5.b.e(r12), du5.b.e(r8));     // Catch: Throwable -> L45
        c.c.put(r12, r8);     // Catch: Throwable -> L45
        monitor-exit(r9);
        goto L42
    L44:
        throw new RuntimeException("you must call init first");     // Catch: Throwable -> L45
    L48:
        Iterator r13 = ((ArrayList) f).iterator();
    L50:
        if (r13.hasNext() == false) goto L60;
        b r19 = (b) r13.next();
        if (r19.a(r7) == false) goto L50;
        this.a.setIcon(true);
        c.d().g(this.a.getUrl(), true, this.a.getVersion());
        InputStream r1 = r19.b(this.a, r7, r18);
        r7.close();     // Catch: Exception -> L56
    L58:
        return r1;
    L56:
        e = move-exception;
        tt5.a.f("ThumbDownloadTask", e, false);
        goto L58
    L60:
        this.a.setIcon(false);
        c.d().g(this.a.getUrl(), false, this.a.getVersion());
        int r20 = r7.code();
        ResponseBody r21 = r7.body();
        this.e = r21;
        int r22 = r20 / 100;
        if (r22 != 2) goto L65;
        return r21.byteStream();
    L65:
        if (r22 != 3) goto L75;
        String r23 = r7.header("Location");
        if (TextUtils.equals(r8, r17) == false) goto L69;
    L73:
        return null;
    L69:
        if (TextUtils.isEmpty(r23) == true) goto L73;
        return a(new URL(r14, r23), r15 + 1, r14, "", r18);
    L75:
        if (r20 != (-1)) goto L79;
        throw new IOException("Unable to retrieve response code from OkHttpClient.");
    L79:
        throw new IOException("Request failed " + r20 + ": " + r7.message());
    L25:
        if (r7.body() == null) goto L27;
        this.a.setErrorBody(r7.body().string());
        goto L27
    L86:
        if (r14.toURI().equals(r16.toURI()) == false) goto L10;
        throw new IOException("In re-direct loop");     // Catch: URISyntaxException -> L82
    L81:
        throw new IOException("Too many (> 5) redirects!");
    }
}
