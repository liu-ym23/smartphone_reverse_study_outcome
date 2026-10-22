package com.bytedance.bdp.appbase.network.preconnect;

import com.bytedance.bdp.appbase.context.BdpAppContext;
import com.bytedance.bdp.appbase.network.BdpFromSource;
import com.bytedance.bdp.appbase.network.wrapper.BdpHostCallWrapper;
import com.bytedance.bdp.bdpbase.util.k;
import com.larus.utils.logger.FLogger;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.ConnectionPool;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;
import okhttp3.c;
import okhttp3.internal.connection.d;
import okio.j0;

/* JADX INFO: loaded from: classes11.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C2897a f200905a = null;

    /* JADX INFO: renamed from: com.bytedance.bdp.appbase.network.preconnect.a$a, reason: collision with other inner class name */
    public static final class C2897a implements Call {
        public C2897a() {
        }

        @Override // okhttp3.Call
        public final void cancel() {
        }

        public final Object clone() {
            return this;
        }

        @Override // okhttp3.Call
        /* JADX INFO: renamed from: clone */
        public final Call mo7964clone() {
            return this;
        }

        @Override // okhttp3.Call
        public final Response execute() {
            throw null;     // Catch: Throwable -> L4
        L4:
            th = move-exception;
            FLogger.f375446a.e("OkHttp3CallLancet", "execute intercept failed, fallback to origin: " + th.getMessage());
            return null;
        }

        @Override // okhttp3.Call
        public final boolean isCanceled() {
            return false;
        }

        @Override // okhttp3.Call
        public final boolean isExecuted() {
            return false;
        }

        @Override // okhttp3.Call
        public final Request request() {
            return null;
        }

        @Override // okhttp3.Call
        public final j0 timeout() {
            return null;
        }

        @Override // okhttp3.Call
        public final void enqueue(Callback r100) {
            throw null;
        }
    }

    public interface b {
    }

    public a() {
    }

    static {
        f200905a = new C2897a();
    }

    public static final okhttp3.a a(OkHttpClient r110, HttpUrl r111) {
        if (r111.isHttps() == false) goto L5;
        SSLSocketFactory r100 = r110.sslSocketFactory();
        SSLSocketFactory r101 = r100;
        HostnameVerifier r102 = r110.hostnameVerifier();
        c r103 = r110.certificatePinner();
    L7:
        return new okhttp3.a(r111.host(), r111.port(), r110.dns(), r110.socketFactory(), r101, r102, r103, r110.proxyAuthenticator(), r110.proxy(), r110.protocols(), r110.connectionSpecs(), r110.proxySelector());
    L5:
        r101 = null;
        r102 = null;
        r103 = null;
        goto L7
    }

    public static final Map b(BdpAppContext r100, BdpFromSource r101) {
        gb4.c.a r102 = new gb4.c.a();
        BdpHostCallWrapper.a r103 = BdpHostCallWrapper.f200935e;
        if (r100 == null) goto L7;
        com.bytedance.bdp.appbase.core.a r104 = r100.b();
        if (r104 == null) goto L7;
        r104.getAppId();
    L7:
        r103.getClass();
        BdpHostCallWrapper.a.a(r102, null, r101);
        gb4.c r105 = r102.b();
        HashMap r106 = new HashMap();
        Iterator<T> r107 = r105.f480684a.iterator();
    L9:
        if (r107.hasNext() == false) goto L11;
        gb4.c.C6004c r108 = (gb4.c.C6004c) r107.next();
        String r109 = r108.f480686a.toLowerCase(Locale.getDefault());
        String r110 = (String) r106.get(r109);
        r106.put(r109, r108.f480687b);
        goto L9
    L11:
        return r106;
    }

    public static final boolean c(ConnectionPool r100, okhttp3.a r101, Route r102) {
        monitor-enter(r100);
        Object r103 = k.c(r100, "connections");     // Catch: IllegalAccessException -> L6 NoSuchFieldException -> L8 Throwable -> L21
    L11:
        Iterator r104 = ((Deque) r103).iterator();     // Catch: Throwable -> L21
    L12:
        if (r104.hasNext() == false) goto L18;
        if (((d) r104.next()).g(r101, r102) == false) goto L12;
        monitor-exit(r100);
        return true;
    L18:
        monitor-exit(r100);
        return false;
    L21:
        th = move-exception;
        throw th;
    L8:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L21
    L10:
        r103 = null;
    L6:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L21
        goto L10
    }
}
