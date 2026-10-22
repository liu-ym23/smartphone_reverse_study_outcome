package retrofit2;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import javax.annotation.Nullable;
import kotlin.Unit;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okio.Buffer;
import retrofit2.http.Streaming;

/* JADX INFO: loaded from: classes41.dex */
public final class a extends g.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f537472a;

    /* JADX INFO: renamed from: retrofit2.a$a, reason: collision with other inner class name */
    public static final class C7472a implements g<ResponseBody, ResponseBody> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C7472a f537473a = null;

        public C7472a() {
        }

        static {
            f537473a = new C7472a();
        }

        @Override // retrofit2.g
        public final ResponseBody convert(ResponseBody r100) throws IOException {
            ResponseBody r101 = r100;
            Buffer r102 = new Buffer();     // Catch: Throwable -> L6
            r101.source().readAll(r102);     // Catch: Throwable -> L6
            ResponseBody r103 = ResponseBody.create(r101.contentType(), r101.contentLength(), r102);     // Catch: Throwable -> L6
            r101.close();
            return r103;
        L6:
            th = move-exception;
            r101.close();
            throw th;
        }
    }

    public static final class b implements g<RequestBody, RequestBody> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f537474a = null;

        public b() {
        }

        static {
            f537474a = new b();
        }

        @Override // retrofit2.g
        public final RequestBody convert(RequestBody r100) throws IOException {
            return r100;
        }
    }

    public static final class c implements g<ResponseBody, ResponseBody> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f537475a = null;

        public c() {
        }

        static {
            f537475a = new c();
        }

        @Override // retrofit2.g
        public final ResponseBody convert(ResponseBody r100) throws IOException {
            return r100;
        }
    }

    public static final class d implements g<Object, String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f537476a = null;

        public d() {
        }

        static {
            f537476a = new d();
        }

        @Override // retrofit2.g
        public final String convert(Object r100) throws IOException {
            return r100.toString();
        }
    }

    public static final class e implements g<ResponseBody, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f537477a = null;

        public e() {
        }

        static {
            f537477a = new e();
        }

        @Override // retrofit2.g
        public final Unit convert(ResponseBody r100) throws IOException {
            r100.close();
            return Unit.INSTANCE;
        }
    }

    public static final class f implements g<ResponseBody, Void> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final f f537478a = null;

        public f() {
        }

        static {
            f537478a = new f();
        }

        @Override // retrofit2.g
        public final Void convert(ResponseBody r100) throws IOException {
            r100.close();
            return null;
        }
    }

    public a() {
        this.f537472a = true;
    }

    @Override // retrofit2.g.a
    @Nullable
    public final g<ResponseBody, ?> responseBodyConverter(Type r100, Annotation[] r101, Retrofit r102) {
        boolean r103 = false;
        if (r100 != ResponseBody.class) goto L15;
        int r104 = r101.length;
        int r105 = 0;
    L5:
        if (r105 >= r104) goto L10;
        if (Streaming.class.isInstance(r101[r105]) == true) goto L8;
        r105 = r105 + 1;
        goto L5
    L8:
        r103 = true;
    L10:
        if (r103 == false) goto L13;
        return c.f537475a;
    L13:
        return C7472a.f537473a;
    L15:
        if (r100 != Void.class) goto L19;
        return f.f537478a;
    L19:
        if (this.f537472a == true) goto L21;
        return null;
    L21:
        if (r100 != Unit.class) goto L33;
        return e.f537477a;
    L24:
        this.f537472a = false;
        return null;
    L33:
        return null;
    }

    @Override // retrofit2.g.a
    @Nullable
    public final g<?, RequestBody> requestBodyConverter(Type r100, Annotation[] r101, Annotation[] r102, Retrofit r103) {
        if (RequestBody.class.isAssignableFrom(u.f(r100)) == true) goto L5;
        return null;
    L5:
        return b.f537474a;
    }
}
