package com.ss.android.lark.monitor;

import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.log.Log;
import java.io.IOException;
import javax.net.ssl.SSLException;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.BufferedSource;
import okio.Okio;

/* JADX INFO: loaded from: classes36.dex */
public class OkHttpMonitorInterceptor implements Interceptor {
    private static final String TAG = "OkHttpInterceptor";

    public class a implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f432330a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f432331b;

        public a(String r100, long r101) {
            this.f432330a = r100;
            this.f432331b = r101;
        }
    }

    public interface b {
    }

    public class c extends ResponseBody {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ResponseBody f432332a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public BufferedSource f432333b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f432334c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final b f432335d;

        @Override // okhttp3.ResponseBody
        public final long contentLength() {
            return this.f432332a.contentLength();
        }

        @Override // okhttp3.ResponseBody
        public final MediaType contentType() {
            return this.f432332a.contentType();
        }

        @Override // okhttp3.ResponseBody
        public final BufferedSource source() {
            if (this.f432333b != null) goto L6;
            this.f432333b = Okio.buffer(new x(this, this.f432332a.source()));
        L6:
            return this.f432333b;
        }

        public c(Response r100, a r101) {
            this.f432334c = 0;
            this.f432332a = r100.body();
            this.f432335d = r101;
        }
    }

    public OkHttpMonitorInterceptor() {
    }

    private long requestBytes(Request r100) {
        if (r100 != null) goto L5;
    L21:
        return 0;
    L5:
        if (r100.url() == null) goto L21;
        long r101 = r100.url().toString().getBytes().length;
        if (r101 > 0) goto L10;
        return r101;
    L10:
        RequestBody r102 = r100.body();
        if (r102 != null) goto L22;
        return r101;
    L22:
        long r103 = r102.contentLength();     // Catch: IOException -> L15
    L17:
        if (r103 > 0) goto L20;
        return r101;
    L20:
        return r103;
    L15:
        r103 = 0;
        goto L17
    }

    private long responseBytes(Response r100) {
        if (r100 != null) goto L4;
        return 0;
    L4:
        if (r100.isSuccessful() == true) goto L6;
        return 0;
    L6:
        if (r100.body() != null) goto L9;
        return 0;
    L9:
        return r100.body().contentLength();
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain r110) throws IOException {
        String r100 = "unknown";
        Request r101 = r110.request();
        long r102 = requestBytes(r101);
        Response r111 = r110.proceed(r101);     // Catch: RuntimeException -> L18
        long r103 = responseBytes(r111);
        if (r101.url() == null) goto L7;
        r100 = r101.url().host();
    L7:
        String r104 = r100;
        if (r103 > 0) goto L14;
        if (r111 == null) goto L14;
        if (r111.body() == null) goto L14;
        return r111.newBuilder().body(new c(r111, new a(r104, r102))).build();
    L14:
        com.ss.android.lark.monitor.traffic.j r105 = LarkMetrics.a.f432318a.f432312f;
        if (r105 == null) goto L17;
        r105.b(r104, r103, r102);
    L17:
        return r111;
    L18:
        e = move-exception;
        boolean r106 = false;
        boolean r107 = FeatureGatingModule.getFeatureGatingService().isEnable("lark.android.monitor.disable_conscrypt_ssl_new_crash_fix");     // Catch: Throwable -> L22
    L25:
        if (r107 == true) goto L57;
        Throwable r108 = e.getCause();
        if ((r108 instanceof SSLException) == false) goto L57;
        String r109 = r108.getMessage();
        if (r109 == null) goto L57;
        if (r109.contains("Unable to create application data") == false) goto L57;
        StackTraceElement[] r112 = e.getStackTrace();
        int r113 = r112.length;
        int r114 = 0;
        boolean r115 = false;
        boolean r116 = false;
        boolean r117 = false;
    L36:
        if (r114 >= r113) goto L53;
        StackTraceElement r118 = r112[r114];
        if ("com.android.org.conscrypt.ConscryptEngine".equals(r118.getClassName()) == false) goto L43;
        if ("newSsl".equals(r118.getMethodName()) == false) goto L43;
        r115 = true;
    L52:
        r114 = r114 + 1;
    L43:
        if ("com.android.org.conscrypt.OpenSSLSocketFactoryImpl".equals(r118.getClassName()) == false) goto L48;
        if ("createSocket".equals(r118.getMethodName()) == false) goto L48;
        r116 = true;
    L48:
        if ("okhttp3.internal.connection.RealConnection".equals(r118.getClassName()) == false) goto L52;
        if ("connectTls".equals(r118.getMethodName()) == false) goto L52;
        r117 = true;
        goto L52
    L53:
        if (r115 == false) goto L57;
        if (r116 == false) goto L57;
        if (r117 == false) goto L57;
        r106 = true;
    L57:
        if (r106 == false) goto L68;
        if (r101 != null) goto L60;
    L62:
        String r119 = "unknown";
    L63:
        Log.e("ConscryptSslNewCrashFix", "custom_error=lark_conscrypt_ssl_new_runtime_exception, convertedToIOException=true, host=" + r100 + ", path=" + r119 + ", fgDisable=lark.android.monitor.disable_conscrypt_ssl_new_crash_fix", e, true);
        Throwable r120 = e.getCause();
        if ((r120 instanceof IOException) == true) goto L79;
        IOException r121 = new IOException("Converted Conscrypt SSL_new RuntimeException: " + e.getMessage());
        r121.initCause(e);
        throw r121;
    L79:
        throw ((IOException) r120);
    L60:
        if (r101.url() == null) goto L62;
        r100 = r101.url().host();
        r119 = r101.url().encodedPath();
        goto L63
    L68:
        throw e;
    L22:
        th = move-exception;
        Log.e("ConscryptSslNewCrashFix", "check lark.android.monitor.disable_conscrypt_ssl_new_crash_fix failed", th);
        r107 = false;
        goto L25
    }
}
