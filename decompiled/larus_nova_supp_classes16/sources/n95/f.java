package n95;

import android.text.TextUtils;
import com.larus.utils.logger.FLogger;
import io.reactivex.Flowable;
import io.reactivex.disposables.CompositeDisposable;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class f {
    public final n95.a a;
    public HttpURLConnection b;
    public InputStream c;
    public volatile boolean d;

    public static class a {
        public a() {
        }
    }

    static {
        new a();
    }

    public final InputStream b() throws Exception {
        n95.a r0 = this.a;
        if (r0.d != null) goto L5;
        r0.d = new URL(r0.a());
    L5:
        URL r1 = r0.d;
        h r2 = (h) this.a.a;
        if (r2.b != null) goto L17;
        monitor-enter(r2);
    L13:
        th = move-exception;
        throw th;
    L9:
        if (r2.b != null) goto L11;
        r2.b = Collections.unmodifiableMap(r2.a());     // Catch: Throwable -> L13
    L11:
        monitor-exit(r2);     // Catch: Throwable -> L13
    L17:
        return c(r1, 0, null, r2.b);
    }

    public f(n95.a r1) {
        this.a = r1;
    }

    public final void a(CompositeDisposable r4) {
        r4.add(Flowable.fromCallable(new c(this)).subscribe(new d(), new e()));
    }

    public final InputStream c(URL r7, int r8, URL r9, Map<String, String> r10) throws IOException {
        if (r8 >= 5) goto L51;
        if (r9 == null) goto L55;
        if (r7.toURI().equals(r9.toURI()) == false) goto L55;
        throw new IOException("In re-direct loop");     // Catch: URISyntaxException -> L52
    L55:
        String r2 = r7.getHost();     // Catch: Throwable -> L16 IOException -> L48
        String r3 = r7.getPath();     // Catch: Throwable -> L16 IOException -> L48
        if (com.obric.assistant.network.okhttp.a.c(r2, r3) == false) goto L18;
        FLogger.a.i("UrlConnLancet", "openConnection drop host=" + r2 + " path=" + r3);     // Catch: Throwable -> L16 IOException -> L48
        com.obric.assistant.network.okhttp.a.b(com.obric.assistant.network.okhttp.a.a(r2, r3), r2, r3);     // Catch: Throwable -> L16 IOException -> L48
        throw new IOException("[NetGuard] dropped " + r7);     // Catch: Throwable -> L16 IOException -> L48
    L18:
        this.b = (HttpURLConnection) r7.openConnection();
        Iterator<Map.Entry<String, String>> r11 = r10.entrySet().iterator();
    L20:
        if (r11.hasNext() == false) goto L22;
        Map.Entry<String, String> r0 = r11.next();
        this.b.addRequestProperty(r0.getKey(), r0.getValue());
        goto L20
    L22:
        this.b.setConnectTimeout(30000);
        this.b.setReadTimeout(30000);
        this.b.setUseCaches(false);
        this.b.setDoInput(true);
        this.b.connect();
        if (this.d == false) goto L26;
        return null;
    L26:
        int r12 = this.b.getResponseCode();
        int r1 = r12 / 100;
        if (r1 != 2) goto L35;
        HttpURLConnection r13 = this.b;
        if (TextUtils.isEmpty(r13.getContentEncoding()) == false) goto L31;
        this.c = new q95.b(r13.getInputStream(), r13.getContentLength());
    L33:
        return this.c;
    L31:
        tt5.a.b("HttpUrlFetcher", "Got non empty content encoding: " + r13.getContentEncoding());
        this.c = r13.getInputStream();
        goto L33
    L35:
        if (r1 != 3) goto L43;
        String r14 = this.b.getHeaderField("Location");
        if (TextUtils.isEmpty(r14) == true) goto L41;
        return c(new URL(r7, r14), r8 + 1, r7, r10);
    L41:
        throw new IOException("Received empty or null redirect url");
    L43:
        if (r12 != (-1)) goto L47;
        throw new IOException("Unable to retrieve response code from HttpUrlConnection.");
    L47:
        throw new IOException("GenericRequest failed " + r12 + ": " + this.b.getResponseMessage());
    L48:
        e = move-exception;
        throw e;
    L16:
        th = move-exception;
        FLogger.a.e("UrlConnLancet", "openConnection intercept failed, fallback to origin: " + th.getMessage());
        goto L18
    L51:
        throw new IOException("Too many (> 5) redirects!");
    }
}
