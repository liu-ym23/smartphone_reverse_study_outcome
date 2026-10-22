package retrofit2;

import java.io.IOException;
import java.util.ArrayList;
import javax.annotation.Nullable;
import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import okio.ForwardingSource;
import okio.Okio;

/* JADX INFO: loaded from: classes41.dex */
public final class l<T> implements Call<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final s f537505a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object[] f537506b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final okhttp3.Call.a f537507c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final g<ResponseBody, T> f537508d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile boolean f537509e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    public okhttp3.Call f537510f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    public Throwable f537511g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f537512h;

    public class a implements okhttp3.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Callback f537513a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ l f537514b;

        public a(l r100, Callback r101) {
            this.f537514b = r100;
            this.f537513a = r101;
        }

        @Override // okhttp3.Callback
        public final void onFailure(okhttp3.Call r100, IOException r101) {
            this.f537513a.onFailure(this.f537514b, r101);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            th.printStackTrace();
        }

        @Override // okhttp3.Callback
        public final void onResponse(okhttp3.Call r100, okhttp3.Response r101) {
            Response<T> r102 = this.f537514b.b(r101);     // Catch: Throwable -> L8
            this.f537513a.onResponse(this.f537514b, r102);     // Catch: Throwable -> L5
            return;
        L5:
            th = move-exception;
            th.printStackTrace();
            return;
        L8:
            th = move-exception;
            u.l(th);
            this.f537513a.onFailure(this.f537514b, th);     // Catch: Throwable -> L12
            return;
        L12:
            th = move-exception;
            th.printStackTrace();
        }
    }

    public static final class b extends ResponseBody {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ResponseBody f537515a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        public IOException f537516b;

        public class a extends ForwardingSource {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f537517a;

            public a(b r100, BufferedSource r101) {
                this.f537517a = r100;
                super(r101);
            }

            @Override // okio.ForwardingSource, okio.Source
            public final long read(Buffer r100, long r101) throws IOException {
                return super.read(r100, r101);
            L4:
                e = move-exception;
                this.f537517a.f537516b = e;
                throw e;
            }
        }

        @Override // okhttp3.ResponseBody, java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            this.f537515a.close();
        }

        @Override // okhttp3.ResponseBody
        public final long contentLength() {
            return this.f537515a.contentLength();
        }

        @Override // okhttp3.ResponseBody
        public final MediaType contentType() {
            return this.f537515a.contentType();
        }

        @Override // okhttp3.ResponseBody
        public final BufferedSource source() {
            return Okio.buffer(new a(this, this.f537515a.source()));
        }

        public b(ResponseBody r100) {
            this.f537515a = r100;
        }
    }

    public static final class c extends ResponseBody {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        public final MediaType f537518a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f537519b;

        @Override // okhttp3.ResponseBody
        public final BufferedSource source() {
            throw new IllegalStateException("Cannot read raw response body of a converted body.");
        }

        @Override // okhttp3.ResponseBody
        public final long contentLength() {
            return this.f537519b;
        }

        @Override // okhttp3.ResponseBody
        public final MediaType contentType() {
            return this.f537518a;
        }

        public c(@Nullable MediaType r100, long r101) {
            this.f537518a = r100;
            this.f537519b = r101;
        }
    }

    @Override // retrofit2.Call
    public final void cancel() {
        this.f537509e = true;
        monitor-enter(this);
        okhttp3.Call r100 = this.f537510f;     // Catch: Throwable -> L9
        monitor-exit(this);     // Catch: Throwable -> L9
        if (r100 == null) goto L14;
        r100.cancel();
        return;
    L14:
        return;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // retrofit2.Call
    public final Response<T> execute() throws IOException {
        monitor-enter(this);
    L36:
        th = move-exception;
        throw th;
    L4:
        if (this.f537512h == true) goto L35;
        this.f537512h = true;     // Catch: Throwable -> L36
        Throwable r100 = this.f537511g;     // Catch: Throwable -> L36
        if (r100 != null) goto L8;
        okhttp3.Call r101 = this.f537510f;     // Catch: Throwable -> L36
        if (r101 == null) goto L40;
    L28:
        monitor-exit(this);     // Catch: Throwable -> L36
        if (this.f537509e == false) goto L33;
        r101.cancel();
    L33:
        return b(r101.execute());
    L40:
        r101 = a();     // Catch: Error -> L21 RuntimeException -> L23 Throwable -> L25 Throwable -> L36
        this.f537510f = r101;     // Catch: Error -> L21 RuntimeException -> L23 Throwable -> L25 Throwable -> L36
    L25:
        e = move-exception;
        u.l(e);     // Catch: Throwable -> L36
        this.f537511g = e;     // Catch: Throwable -> L36
        throw e;     // Catch: Throwable -> L36
    L8:
        if ((r100 instanceof IOException) == true) goto L16;
        if ((r100 instanceof RuntimeException) == false) goto L14;
        throw ((RuntimeException) r100);     // Catch: Throwable -> L36
    L14:
        throw ((Error) r100);     // Catch: Throwable -> L36
    L16:
        throw ((IOException) r100);     // Catch: Throwable -> L36
    L35:
        throw new IllegalStateException("Already executed.");     // Catch: Throwable -> L36
    }

    @Override // retrofit2.Call
    public final synchronized boolean isExecuted() {
        monitor-enter(this);
        boolean r100 = this.f537512h;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // retrofit2.Call
    public final synchronized Request request() {
        monitor-enter(this);
        okhttp3.Call r100 = this.f537510f;     // Catch: Throwable -> L31
        if (r100 == null) goto L8;
        Request r101 = r100.request();     // Catch: Throwable -> L31
        monitor-exit(this);
        return r101;
    L8:
        Throwable r102 = this.f537511g;     // Catch: Throwable -> L31
        if (r102 != null) goto L11;
        okhttp3.Call r103 = a();     // Catch: IOException -> L23 Error -> L26 RuntimeException -> L28 Throwable -> L31
        this.f537510f = r103;     // Catch: IOException -> L23 Error -> L26 RuntimeException -> L28 Throwable -> L31
        Request r104 = r103.request();     // Catch: IOException -> L23 Error -> L26 RuntimeException -> L28 Throwable -> L31
        monitor-exit(this);
        return r104;
    L23:
        e = move-exception;
        this.f537511g = e;     // Catch: Throwable -> L31
        throw new RuntimeException("Unable to create request.", e);     // Catch: Throwable -> L31
    L26:
        e = e;
    L29:
        u.l(e);     // Catch: Throwable -> L31
        this.f537511g = e;     // Catch: Throwable -> L31
        throw e;     // Catch: Throwable -> L31
    L28:
        e = e;
        goto L29
    L11:
        if ((r102 instanceof IOException) == true) goto L19;
        if ((r102 instanceof RuntimeException) == false) goto L17;
        throw ((RuntimeException) r102);     // Catch: Throwable -> L31
    L17:
        throw ((Error) r102);     // Catch: Throwable -> L31
    L19:
        throw new RuntimeException("Unable to create request.", this.f537511g);     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        throw th;
    }

    public final okhttp3.Call a() throws IOException {
        okhttp3.Call.a r100 = this.f537507c;
        s r101 = this.f537505a;
        Object[] r102 = this.f537506b;
        p<?>[] r103 = r101.f537573j;
        int r104 = r102.length;
        if (r104 != r103.length) goto L36;
        r r105 = new r(r101.f537566c, r101.f537565b, r101.f537567d, r101.f537568e, r101.f537569f, r101.f537570g, r101.f537571h, r101.f537572i);
        ArrayList r106 = new ArrayList(r104);
        int r107 = 0;
    L5:
        if (r107 >= r104) goto L7;
        r106.add(r102[r107]);
        r103[r107].a(r105, r102[r107]);
        r107 = r107 + 1;
        goto L5
    L7:
        HttpUrl.a r108 = r105.f537555d;
        if (r108 == null) goto L10;
        HttpUrl r109 = r108.b();
    L12:
        RequestBody r110 = r105.f537561j;
        if (r110 != null) goto L23;
        FormBody.Builder r111 = r105.f537560i;
        if (r111 == null) goto L17;
        r110 = r111.build();
        goto L23
    L17:
        okhttp3.k.a r112 = r105.f537559h;
        if (r112 == null) goto L21;
        r110 = r112.d();
        goto L23
    L21:
        if (r105.f537558g == false) goto L23;
        r110 = RequestBody.create(null, new byte[0]);
    L23:
        MediaType r113 = r105.f537557f;
        if (r113 == null) goto L28;
        if (r110 == null) goto L27;
        r110 = new r.a(r110, r113);
        goto L28
    L27:
        r105.f537556e.addHeader("Content-Type", r113.toString());
    L28:
        okhttp3.Call r114 = r100.newCall(r105.f537556e.url(r109).method(r105.f537552a, r110).tag(k.class, new k(r101.f537564a, r106)).build());
        if (r114 == null) goto L32;
        return r114;
    L32:
        throw new NullPointerException("Call.Factory returned null.");
    L10:
        r109 = r105.f537553b.resolve(r105.f537554c);
        if (r109 != null) goto L12;
        throw new IllegalArgumentException("Malformed URL. Base: " + r105.f537553b + ", Relative: " + r105.f537554c);
    L36:
        throw new IllegalArgumentException("Argument count (" + r104 + ") doesn't match expected count (" + r103.length + ")");
    }

    public final Object clone() throws CloneNotSupportedException {
        return new l(this.f537505a, this.f537506b, this.f537507c, this.f537508d);
    }

    @Override // retrofit2.Call
    public final boolean isCanceled() {
        boolean r100 = true;
        if (this.f537509e == false) goto L5;
        return true;
    L5:
        monitor-enter(this);
        okhttp3.Call r101 = this.f537510f;     // Catch: Throwable -> L14
        if (r101 != null) goto L9;
    L11:
        r100 = false;
    L12:
        monitor-exit(this);     // Catch: Throwable -> L14
        return r100;
    L9:
        if (r101.isCanceled() == false) goto L11;
    L14:
        th = move-exception;
        throw th;
    }

    @Override // retrofit2.Call
    /* JADX INFO: renamed from: clone */
    public final Call mo11002clone() {
        return new l(this.f537505a, this.f537506b, this.f537507c, this.f537508d);
    }

    public final Response<T> b(okhttp3.Response r100) throws IOException {
        ResponseBody r101 = r100.body();
        okhttp3.Response r102 = r100.newBuilder().body(new c(r101.contentType(), r101.contentLength())).build();
        int r103 = r102.code();
        if (r103 >= 200) goto L5;
    L28:
        Buffer r104 = new Buffer();     // Catch: Throwable -> L25
        r101.source().readAll(r104);     // Catch: Throwable -> L25
        Response<T> r105 = Response.error(ResponseBody.create(r101.contentType(), r101.contentLength(), r104), r102);     // Catch: Throwable -> L25
        r101.close();
        return r105;
    L25:
        th = move-exception;
        r101.close();
        throw th;
    L5:
        if (r103 >= 300) goto L28;
        if (r103 != 204) goto L10;
    L20:
        r101.close();
        return Response.success(null, r102);
    L10:
        if (r103 == 205) goto L20;
        b r106 = new b(r101);
        return Response.success(this.f537508d.convert(r106), r102);
    L15:
        e = move-exception;
        IOException r107 = r106.f537516b;
        if (r107 != null) goto L19;
        throw e;
    L19:
        throw r107;
    }

    @Override // retrofit2.Call
    public final void enqueue(Callback<T> r100) {
        u.a(r100, "callback == null");
        monitor-enter(this);
    L24:
        th = move-exception;
        throw th;
    L5:
        if (this.f537512h == true) goto L23;
        this.f537512h = true;     // Catch: Throwable -> L24
        okhttp3.Call r101 = this.f537510f;     // Catch: Throwable -> L24
        Throwable th10 = this.f537511g;     // Catch: Throwable -> L24
        if (r101 != null) goto L13;
        if (th10 != null) goto L13;
        okhttp3.Call r102 = a();     // Catch: Throwable -> L11
        this.f537510f = r102;     // Catch: Throwable -> L11
        r101 = r102;
        goto L13
    L11:
        th10 = th;
        u.l(th10);     // Catch: Throwable -> L24
        this.f537511g = th10;     // Catch: Throwable -> L24
    L13:
        monitor-exit(this);     // Catch: Throwable -> L24
        if (th10 == null) goto L18;
        r100.onFailure(this, th10);
        return;
    L18:
        if (this.f537509e == false) goto L20;
        r101.cancel();
    L20:
        r101.enqueue(new a(this, r100));
        return;
    L23:
        throw new IllegalStateException("Already executed.");     // Catch: Throwable -> L24
    }

    public l(s r100, Object[] r101, okhttp3.Call.a r102, g<ResponseBody, T> r103) {
        this.f537505a = r100;
        this.f537506b = r101;
        this.f537507c = r102;
        this.f537508d = r103;
    }
}
