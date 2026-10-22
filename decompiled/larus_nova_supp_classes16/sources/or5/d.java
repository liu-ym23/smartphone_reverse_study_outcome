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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class d implements Interceptor.Chain {
    public final List<Interceptor> a;
    public final int b;
    public final Request c;
    public final Call d;
    public int e;
    public final int f;
    public final int g;
    public final int h;

    public final Connection connection() {
        return null;
    }

    public final Interceptor.Chain withConnectTimeout(int r1, TimeUnit r2) {
        return null;
    }

    public final Interceptor.Chain withReadTimeout(int r1, TimeUnit r2) {
        return null;
    }

    public final Interceptor.Chain withWriteTimeout(int r1, TimeUnit r2) {
        return null;
    }

    public Call call() {
        return this.d;
    }

    public final int connectTimeoutMillis() {
        return this.f;
    }

    public final int readTimeoutMillis() {
        return this.g;
    }

    public final Request request() {
        return this.c;
    }

    public final int writeTimeoutMillis() {
        return this.h;
    }

    public final Response proceed(Request r13) throws IOException {
        if (this.b >= this.a.size()) goto L24;
        int r0 = this.e + 1;
        this.e = r0;
        if (r0 <= 1) goto L12;
        Iterator<Interceptor> r1 = this.a.iterator();
    L8:
        if (r1.hasNext() == false) goto L12;
        Interceptor r2 = r1.next();
        if ((r2 instanceof b) == false) goto L8;
        ((b) r2).f = false;
    L12:
        List<Interceptor> r3 = this.a;
        int r4 = this.b;
        d r5 = new d(r3, r4 + 1, r13, this.d, this.f, this.g, this.h);
        Interceptor r14 = (Interceptor) ListProtector.get(r3, r4);
        Response r6 = r14.intercept(r5);
        if ((this.b + 1) < this.a.size()) goto L15;
    L19:
        if (r6 == null) goto L22;
        return r6;
    L22:
        throw new RustIOException("interceptor " + r14 + " returned null", RustIOException.REQUEST_EENET_INNER_ERROR);
    L15:
        if (r5.e >= 1) goto L19;
        throw new RustIOException(new IllegalStateException("interceptor " + r14 + " must mCall proceed() at least once"), RustIOException.REQUEST_EENET_INNER_ERROR);
    L24:
        throw new AssertionError();
    }

    public d(List<Interceptor> r1, int r2, Request r3, Call r4, int r5, int r6, int r7) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.f = r5;
        this.g = r6;
        this.h = r7;
    }
}
