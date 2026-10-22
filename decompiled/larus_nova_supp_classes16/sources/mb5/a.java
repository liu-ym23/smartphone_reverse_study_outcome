package mb5;

import com.bytedance.ee.bear.contract.DebugRequest;
import com.bytedance.ee.bear.contract.o0;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a implements Interceptor {
    public static final /* synthetic */ int a = 0;

    /* JADX INFO: renamed from: mb5.a$a, reason: collision with other inner class name */
    public static final class C0255a {
    }

    static {
    }

    public a() {
    }

    public final Response intercept(Interceptor.Chain r14) {
        Intrinsics.checkNotNullParameter(r14, "chain");
        Request r0 = r14.request();
        Response r16 = r14.proceed(r0);
        long r3 = System.currentTimeMillis();     // Catch: Throwable -> L39
        String r5 = r0.url().url().toString();     // Catch: Throwable -> L39
        RequestBody r2 = r0.body();     // Catch: Throwable -> L39
        BufferedSource r6 = null;
        if (r2 == null) goto L6;
        MediaType r4 = r2.contentType();     // Catch: Throwable -> L39
    L7:
        Buffer r7 = new Buffer();     // Catch: Throwable -> L39
        RequestBody r8 = r0.body();     // Catch: Throwable -> L39
        if (r8 == null) goto L11;
        r8.writeTo(r7);     // Catch: Throwable -> L39
    L11:
        if (r4 == null) goto L16;
        Charset r9 = r4.charset(Charset.forName("UTF-8"));     // Catch: Throwable -> L39
        if (r9 != null) goto L15;
        r9 = Charset.forName("UTF-8");     // Catch: Throwable -> L39
    L15:
        Intrinsics.checkNotNull(r9);     // Catch: Throwable -> L39
        String r10 = r7.readString(r9);     // Catch: Throwable -> L39
    L17:
        Map r1 = r0.headers().toMultimap();     // Catch: Throwable -> L39
        String r11 = r16.header("x-tt-logid");     // Catch: Throwable -> L39
        if (r11 != null) goto L20;
        String r12 = "";
    L21:
        ResponseBody r13 = r16.body();     // Catch: Throwable -> L39
        if (r13 == null) goto L24;
        r6 = r13.source();     // Catch: Throwable -> L39
    L24:
        if (r6 == null) goto L26;
        r6.request(Long.MAX_VALUE);     // Catch: Throwable -> L39
    L26:
        if (r6 == null) goto L35;
        Buffer r17 = r6.buffer();     // Catch: Throwable -> L39
        if (r17 == null) goto L35;
        Buffer r18 = r17.clone();     // Catch: Throwable -> L39
        if (r18 == null) goto L35;
        String r19 = r18.readString(Charset.forName("UTF-8"));     // Catch: Throwable -> L39
        if (r19 == null) goto L35;
        String r110 = r19;
    L36:
        Map r20 = r16.headers().toMultimap();     // Catch: Throwable -> L39
        Intrinsics.checkNotNull(r1);     // Catch: Throwable -> L39
        Intrinsics.checkNotNull(r20);     // Catch: Throwable -> L39
        DebugRequest r111 = new DebugRequest(r3, r5, r10, r1, r12, r20, r110);     // Catch: Throwable -> L39
        ArrayList<DebugRequest> r21 = o0.a;     // Catch: Throwable -> L39
        Intrinsics.checkNotNullParameter(r111, "request");     // Catch: Throwable -> L39
        ArrayList<DebugRequest> r22 = o0.a;     // Catch: Throwable -> L39
        if (r22.size() < 10000) goto L41;
        ListProtector.remove(r22, 9999);     // Catch: Throwable -> L39
    L41:
        ListProtector.add(r22, 0, r111);     // Catch: Throwable -> L39
    L44:
        Intrinsics.checkNotNull(r16);
        return r16;
    L35:
        r110 = "";
        goto L36
    L20:
        r12 = r11;
        goto L21
    L16:
        r10 = "";
        goto L17
    L6:
        r4 = null;
    L39:
        th = move-exception;
        tt5.a.f("PacketCaptureInterceptor", th, false);
        goto L44
    }
}
