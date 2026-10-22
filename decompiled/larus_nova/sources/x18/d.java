package x18;

import android.content.Context;
import com.franmontiel.persistentcookiejar.cache.SetCookieCache;
import com.larksuite.framework.utils.Reflect;
import com.larksuite.framework.utils.z;
import com.ss.android.lark.log.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import okhttp3.Dispatcher;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.g;
import okhttp3.h;

/* JADX INFO: loaded from: classes24.dex */
public final class d implements b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b28.a f562144b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final OkHttpClient f562145c;

    public final b28.a d() {
        if (this.f562144b != null) goto L21;
        Dispatcher r100 = this.f562145c.dispatcher();
        b28.a r101 = new b28.a(r100.executorService());
        int r102 = r100.getMaxRequests();
        if (r102 < 1) goto L19;
        monitor-enter(r101);
        r101.f17069a = r102;     // Catch: Throwable -> L15
        monitor-exit(r101);     // Catch: Throwable -> L15
        r101.f();
        r101.i(r100.getMaxRequestsPerHost());
        r101.h((Runnable) new Reflect(r100).e("idleCallback", new Class[]{Runnable.class}).f285916a);     // Catch: Reflect.ReflectException -> L12
        this.f562144b = r101;
    L12:
        e = move-exception;
        Log.e("DispatcherAdapter", e);
        throw e;
    L15:
        th = move-exception;
        throw th;
    L19:
        throw new IllegalArgumentException("max < 1: " + r102);
    L21:
        return this.f562144b;
    }

    public d(b.a r100) {
        OkHttpClient.Builder r101 = new OkHttpClient.Builder();
        if (r100.f562136c == false) goto L5;
        Context r102 = r100.f562134a;
        r101.cookieJar(new d28.c(r102, new SetCookieCache(), new d28.d(r102, d28.a.b(r102, "CookiePersistence_" + z.b(r102)), d28.a.b(r102, "CookiePersistence"))));
    L5:
        List<y18.b> r103 = r100.f562135b;
        ArrayList r104 = new ArrayList();
        Iterator r105 = ((ArrayList) r103).iterator();
    L7:
        if (r105.hasNext() == false) goto L12;
        y18.b r106 = (y18.b) r105.next();
        if ((r106 instanceof y18.a) == false) goto L7;
        r104.add(new c((y18.a) r106));
        goto L7
    L12:
        if (r104.size() <= 0) goto L17;
        Iterator r107 = r104.iterator();
    L15:
        if (r107.hasNext() == false) goto L17;
        r101.addInterceptor((Interceptor) r107.next());
    L17:
        r101.connectTimeout(r100.f562137d, r100.f562138e).readTimeout(r100.f562139f, r100.f562140g).writeTimeout(r100.f562141h, r100.f562142i);
        this.f562145c = r101.build();
    }

    @Override // x18.b
    public final List<a28.a> a(String r100) {
        List<g> r101 = this.f562145c.cookieJar().a(HttpUrl.parse(r100));
        ArrayList r102 = new ArrayList();
        Iterator<g> r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L18;
        g r104 = r103.next();
        a28.a.C0006a r105 = new a28.a.C0006a();
        r105.c(r104.f523855a);
        r105.e(r104.f523856b);
        r105.b(r104.f523857c);
        r105.a(r104.f523858d);
        r105.d(r104.f523859e);
        if (r104.f523860f == false) goto L9;
        r105.f1434f = true;
    L9:
        if (r104.f523861g == false) goto L12;
        r105.f1435g = true;
    L12:
        if (r104.f523863i == false) goto L15;
        r105.f1435g = true;
    L15:
        if (r104.f523862h == false) goto L17;
        r105.f1435g = true;
    L17:
        r102.add(new a28.a(r105));
        goto L4
    L18:
        return r102;
    }

    @Override // x18.b
    public final com.larksuite.framework.http.call.b c(z18.a r100) {
        return new com.larksuite.framework.http.call.b(this, r100);
    }

    @Override // x18.b
    public final b28.b newCall(Request r100) {
        return b28.b.c(this, r100, false);
    }

    @Override // x18.b
    public final void b(String r100, List<a28.a> r101) {
        HttpUrl r102 = HttpUrl.parse(r100);
        if (r102 != null) goto L5;
        Log.w("OkHttpClientImpl", "saveCookie: failed to get http url");
    L5:
        h r103 = this.f562145c.cookieJar();
        ArrayList r104 = new ArrayList();
        Iterator<a28.a> r105 = r101.iterator();
    L7:
        if (r105.hasNext() == false) goto L18;
        a28.a r106 = r105.next();
        g.a r107 = new g.a();
        r107.c(r106.f1421a);
        r107.e(r106.f1422b);
        r107.b(r106.f1423c);
        r107.a(r106.f1424d, false);
        r107.d(r106.f1425e);
        if (r106.f1426f == false) goto L12;
        r107.f523869f = true;
    L12:
        if (r106.f1427g == false) goto L15;
        r107.f523870g = true;
    L15:
        if (r106.f1428h == false) goto L17;
        r107.f523870g = true;
    L17:
        r104.add(new g(r107));
        goto L7
    L18:
        r103.b(r102, r104);
    }
}
