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

/* JADX INFO: loaded from: classes16.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n95.a f518402a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public HttpURLConnection f518403b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public InputStream f518404c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile boolean f518405d;

    public static class a {
        public a() {
        }
    }

    static {
        new a();
    }

    public final InputStream b() throws Exception {
        n95.a r100 = this.f518402a;
        if (r100.f518400d != null) goto L5;
        r100.f518400d = new URL(r100.a());
    L5:
        URL r101 = r100.f518400d;
        h r102 = (h) this.f518402a.f518397a;
        if (r102.f518407b != null) goto L17;
        monitor-enter(r102);
    L13:
        th = move-exception;
        throw th;
    L9:
        if (r102.f518407b != null) goto L11;
        r102.f518407b = Collections.unmodifiableMap(r102.a());     // Catch: Throwable -> L13
    L11:
        monitor-exit(r102);     // Catch: Throwable -> L13
    L17:
        return c(r101, 0, null, r102.f518407b);
    }

    public f(n95.a r100) {
        this.f518402a = r100;
    }

    public final void a(CompositeDisposable r100) {
        r100.add(Flowable.fromCallable(new c(this)).subscribe(new d(), new e()));
    }

    public final InputStream c(URL r100, int r101, URL r102, Map<String, String> r110) throws IOException {
        if (r101 >= 5) goto L51;
        if (r102 == null) goto L55;
        if (r100.toURI().equals(r102.toURI()) == false) goto L55;
        throw new IOException("In re-direct loop");     // Catch: URISyntaxException -> L52
    L55:
        String r103 = r100.getHost();     // Catch: Throwable -> L16 IOException -> L48
        String r104 = r100.getPath();     // Catch: Throwable -> L16 IOException -> L48
        if (com.obric.assistant.network.okhttp.a.c(r103, r104) == false) goto L18;
        FLogger.f375446a.i("UrlConnLancet", "openConnection drop host=" + r103 + " path=" + r104);     // Catch: Throwable -> L16 IOException -> L48
        com.obric.assistant.network.okhttp.a.b(com.obric.assistant.network.okhttp.a.a(r103, r104), r103, r104);     // Catch: Throwable -> L16 IOException -> L48
        throw new IOException("[NetGuard] dropped " + r100);     // Catch: Throwable -> L16 IOException -> L48
    L18:
        this.f518403b = (HttpURLConnection) r100.openConnection();
        Iterator<Map.Entry<String, String>> r105 = r110.entrySet().iterator();
    L20:
        if (r105.hasNext() == false) goto L22;
        Map.Entry<String, String> r106 = r105.next();
        this.f518403b.addRequestProperty(r106.getKey(), r106.getValue());
        goto L20
    L22:
        this.f518403b.setConnectTimeout(30000);
        this.f518403b.setReadTimeout(30000);
        this.f518403b.setUseCaches(false);
        this.f518403b.setDoInput(true);
        this.f518403b.connect();
        if (this.f518405d == false) goto L26;
        return null;
    L26:
        int r107 = this.f518403b.getResponseCode();
        int r108 = r107 / 100;
        if (r108 != 2) goto L35;
        HttpURLConnection r109 = this.f518403b;
        if (TextUtils.isEmpty(r109.getContentEncoding()) == false) goto L31;
        this.f518404c = new q95.b(r109.getInputStream(), r109.getContentLength());
    L33:
        return this.f518404c;
    L31:
        tt5.a.b("HttpUrlFetcher", "Got non empty content encoding: " + r109.getContentEncoding());
        this.f518404c = r109.getInputStream();
        goto L33
    L35:
        if (r108 != 3) goto L43;
        String r111 = this.f518403b.getHeaderField("Location");
        if (TextUtils.isEmpty(r111) == true) goto L41;
        return c(new URL(r100, r111), r101 + 1, r100, r110);
    L41:
        throw new IOException("Received empty or null redirect url");
    L43:
        if (r107 != (-1)) goto L47;
        throw new IOException("Unable to retrieve response code from HttpUrlConnection.");
    L47:
        throw new IOException("GenericRequest failed " + r107 + ": " + this.f518403b.getResponseMessage());
    L48:
        e = move-exception;
        throw e;
    L16:
        th = move-exception;
        FLogger.f375446a.e("UrlConnLancet", "openConnection intercept failed, fallback to origin: " + th.getMessage());
        goto L18
    L51:
        throw new IOException("Too many (> 5) redirects!");
    }
}
