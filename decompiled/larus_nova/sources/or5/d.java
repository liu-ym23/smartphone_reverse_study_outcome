package or5;

import com.bytedance.ee.eenet.httpclient.rust.exception.RustIOException;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/* JADX INFO: loaded from: classes16.dex */
public final class d implements Interceptor.Chain {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<Interceptor> f524945a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f524946b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Request f524947c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Call f524948d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f524949e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f524950f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f524951g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f524952h;

    @Override // okhttp3.Interceptor.Chain
    public final Connection connection() {
        return null;
    }

    @Override // okhttp3.Interceptor.Chain
    public final Interceptor.Chain withConnectTimeout(int r100, TimeUnit r101) {
        return null;
    }

    @Override // okhttp3.Interceptor.Chain
    public final Interceptor.Chain withReadTimeout(int r100, TimeUnit r101) {
        return null;
    }

    @Override // okhttp3.Interceptor.Chain
    public final Interceptor.Chain withWriteTimeout(int r100, TimeUnit r101) {
        return null;
    }

    @Override // okhttp3.Interceptor.Chain
    public Call call() {
        return this.f524948d;
    }

    @Override // okhttp3.Interceptor.Chain
    public final int connectTimeoutMillis() {
        return this.f524950f;
    }

    @Override // okhttp3.Interceptor.Chain
    public final int readTimeoutMillis() {
        return this.f524951g;
    }

    @Override // okhttp3.Interceptor.Chain
    public final Request request() {
        return this.f524947c;
    }

    @Override // okhttp3.Interceptor.Chain
    public final int writeTimeoutMillis() {
        return this.f524952h;
    }

    @Override // okhttp3.Interceptor.Chain
    public final Response proceed(Request r110) throws IOException {
        if (this.f524946b >= this.f524945a.size()) goto L24;
        int r100 = this.f524949e + 1;
        this.f524949e = r100;
        if (r100 <= 1) goto L12;
        Iterator<Interceptor> r101 = this.f524945a.iterator();
    L8:
        if (r101.hasNext() == false) goto L12;
        Interceptor r102 = r101.next();
        if ((r102 instanceof b) == false) goto L8;
        ((b) r102).f524939f = false;
    L12:
        List<Interceptor> r103 = this.f524945a;
        int r104 = this.f524946b;
        d r105 = new d(r103, r104 + 1, r110, this.f524948d, this.f524950f, this.f524951g, this.f524952h);
        Interceptor r111 = (Interceptor) ListProtector.get(r103, r104);
        Response r106 = r111.intercept(r105);
        if ((this.f524946b + 1) < this.f524945a.size()) goto L15;
    L19:
        if (r106 == null) goto L22;
        return r106;
    L22:
        throw new RustIOException("interceptor " + r111 + " returned null", RustIOException.REQUEST_EENET_INNER_ERROR);
    L15:
        if (r105.f524949e >= 1) goto L19;
        throw new RustIOException(new IllegalStateException("interceptor " + r111 + " must mCall proceed() at least once"), RustIOException.REQUEST_EENET_INNER_ERROR);
    L24:
        throw new AssertionError();
    }

    public d(List<Interceptor> r100, int r101, Request r102, Call r103, int r104, int r105, int r106) {
        this.f524945a = r100;
        this.f524946b = r101;
        this.f524947c = r102;
        this.f524948d = r103;
        this.f524950f = r104;
        this.f524951g = r105;
        this.f524952h = r106;
    }
}
