package lr5;

import android.text.TextUtils;
import com.bytedance.common.utility.reflect.Reflect;
import com.bytedance.ee.bear.contract.i0;
import com.bytedance.ee.bear.contract.offline.OfflineDoc;
import com.bytedance.ee.bear.document.imageviewer.diagram.DiagramData$RESULT;
import com.bytedance.ee.util.debug.HeaderAppendHelper;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import okhttp3.Connection;
import okhttp3.ConnectionPool;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class e {
    public static int b;
    public OkHttpClient a;

    public class a implements Interceptor {
        public a() {
        }

        public final Response intercept(Interceptor.Chain r16) throws IOException {
            Request r0 = r16.request();
            mr5.a r1 = (mr5.a) r0.tag(mr5.a.class);
            if (r1 != null) goto L5;
            r1 = new mr5.a();
            r0 = r0.newBuilder().tag(mr5.a.class, r1).build();
        L5:
            Headers r2 = r0.headers();
            ak5.f.a r3 = qr5.a.a;
            if (r3 != null) goto L8;
            HashMap r4 = new HashMap();
        L31:
            if (r4.isEmpty() == true) goto L41;
            Request.Builder r5 = r0.newBuilder();
            Iterator r6 = r4.keySet().iterator();
        L34:
            if (r6.hasNext() == false) goto L40;
            String r7 = (String) r6.next();
            String r8 = (String) r4.get(r7);
            if (TextUtils.isEmpty(r7) == true) goto L34;
            if (TextUtils.isEmpty(r8) == true) goto L34;
            r5.removeHeader(r7);
            r5.addHeader(r7, r8);
            goto L34
        L40:
            r0 = r5.build();
        L41:
            InetSocketAddress r9 = null;
            Connection r10 = r16.connection();     // Catch: Throwable -> L63
            if (r10 == null) goto L45;
            Route r11 = r10.route();     // Catch: Throwable -> L63
        L46:
            if (r11 == null) goto L48;
            r9 = r11.socketAddress();     // Catch: Throwable -> L63
        L48:
            tt5.a.b("OkHttp3Builder", "-call- get res -  req: " + r0.hashCode() + " conn: " + r10 + " route: " + r11 + " addr: " + r9);     // Catch: Throwable -> L63
            goto L75
        L45:
            r11 = null;
        L75:
            Response r17 = r16.proceed(r0);     // Catch: IOException -> L53
            if (r9 == null) goto L84;
            Response.Builder r12 = r17.newBuilder();     // Catch: Throwable -> L64
            r12.addHeader("EENet-info.remoteaddr", r9.getAddress().getHostAddress());     // Catch: Throwable -> L64
            return r12.build();
        L85:
            return r17;
        L84:
            return r17;
        L53:
            e = move-exception;
            if (r9 != null) goto L69;
        L62:
            throw e;
        L69:
            String r13 = e.getMessage();     // Catch: Throwable -> L60
            StringBuilder r14 = new StringBuilder();     // Catch: Throwable -> L60
            r14.append(r9.getAddress().getHostAddress());     // Catch: Throwable -> L60
            r14.append("|");     // Catch: Throwable -> L60
            if (r13 != null) goto L58;
            r13 = "null";
        L58:
            r14.append(r13);     // Catch: Throwable -> L60
            Reflect.on(e).set("detailMessage", r14.toString());     // Catch: Throwable -> L60
        L60:
            th = move-exception;
            th.printStackTrace();
            goto L62
        L8:
            ak5.f.a r18 = r3;
            HashMap r19 = new HashMap(r18.a);
            String r20 = r2.get("request-id");
            if (TextUtils.isEmpty(r20) == false) goto L11;
            r20 = du5.b.c(12) + "-" + r18.b.getUid();
        L11:
            r19.put("request-id", r20);
            r19.put("x-tt-trace-id", r20);
            if (TextUtils.isEmpty(r2.get("x-tt-logid")) == false) goto L19;
            String r21 = r18.b.getUid();
            long r22 = System.currentTimeMillis();     // Catch: Throwable -> L16
            String r23 = new SimpleDateFormat("yyyyMMddHHmmss", Locale.US).format(Long.valueOf(r22)) + r21 + r22 + du5.b.c(3);     // Catch: Throwable -> L16
        L18:
            r19.put("x-tt-logid", r23);
        L16:
            th = move-exception;
            tt5.a.f("NetUtils", th, false);
            r23 = "";
        L19:
            ak5.g r24 = r18.e.a;
            if (r24.f != null) goto L22;
            r24.f = (i0) org.koin.java.a.a(i0.class);
        L22:
            Locale r26 = r24.f.c();
            r19.put("locale", r26.getLanguage() + OfflineDoc.DASH_DELIMITER + r26.getCountry().toUpperCase());
            if (r18.c == false) goto L71;
            String r27 = r20 + r18.d;
            r19.put("request-id", r27);
            r19.put("x-request-id", r27);
        L71:
            r19.put("x-docs-add-csrf-token", DiagramData$RESULT.SUCCESS);     // Catch: Exception -> L27
            r1.a = true;     // Catch: Exception -> L27
            r1.b = CastLongProtector.valueOf(jl5.a.b());     // Catch: Exception -> L27
        L29:
            HeaderAppendHelper.a(r19);
            r4 = r19;
        L27:
            e = move-exception;
            tt5.a.e("HttpConfig", "setIsolateUserId error", e, false);
            goto L29
        }
    }

    public final OkHttpClient a() {
        OkHttpClient r0 = this.a;
        if (r0 == null) goto L10;
        int r2 = b;
        if (r2 <= 0) goto L9;
        if (r2 >= 4) goto L9;
        OkHttpClient.Builder r1 = r0.newBuilder();
        b(r1);
        r1.build();
    L9:
        return this.a;
    L10:
        OkHttpClient.Builder r3 = new OkHttpClient.Builder();
        int r4 = b;
        if (r4 <= 0) goto L14;
        if (r4 >= 4) goto L14;
        b(r3);
    L14:
        r3.pingInterval(10, TimeUnit.SECONDS);
        TimeUnit r5 = TimeUnit.MILLISECONDS;
        r3.connectionPool(new ConnectionPool(15, 180000, r5));
        r3.connectTimeout(10000, r5);
        r3.readTimeout(101000, r5);
        r3.writeTimeout(101000, r5);
        r3.addNetworkInterceptor(new a());
        r3.cookieJar(okhttp3.h.a);
        OkHttpClient r6 = r3.build();
        this.a = r6;
        return r6;
    }

    public e() {
    }

    public static void b(OkHttpClient.Builder r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        ArrayList r0 = new ArrayList();
        int r1 = b;
        if (r1 != 1) goto L7;
        r0.add(Protocol.HTTP_2);
    L13:
        b = 4;
        r0.add(Protocol.HTTP_1_1);
        r3.protocols(Collections.unmodifiableList(r0));
        return;
    L7:
        if (r1 != 2) goto L9;
        r0.add(Protocol.SPDY_3);
        goto L13
    L9:
        if (r1 == 3) goto L13;
        r0.add(Protocol.HTTP_2);
        r0.add(Protocol.SPDY_3);
        goto L13
    }
}
