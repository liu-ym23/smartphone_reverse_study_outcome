package rk4;

import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.BufferedSource;
import okio.Okio;

/* JADX INFO: loaded from: classes15.dex */
public final class c implements Interceptor {

    public static class a extends ResponseBody {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ResponseBody f538254a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public BufferedSource f538255b;

        @Override // okhttp3.ResponseBody
        public final long contentLength() {
            return this.f538254a.contentLength();
        }

        @Override // okhttp3.ResponseBody
        public final MediaType contentType() {
            return this.f538254a.contentType();
        }

        @Override // okhttp3.ResponseBody
        public final BufferedSource source() {
            if (this.f538255b != null) goto L6;
            this.f538255b = Okio.buffer(new b(this, this.f538254a.source()));
        L6:
            return this.f538255b;
        }

        public a(ResponseBody r100) {
            this.f538254a = r100;
        }
    }

    public c() {
    }

    @Override // okhttp3.Interceptor
    public final Response intercept(Interceptor.Chain r100) throws IOException {
        Response r101 = r100.proceed(r100.request());
        return r101.newBuilder().body(new a(r101.body())).build();
    }
}
