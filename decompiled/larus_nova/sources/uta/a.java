package uta;

import android.os.Handler;
import android.os.Looper;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.network.okhttp.GlobalNetworkGate;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import kotlin.TypeCastException;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes34.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f551708a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c f551709b;

    /* JADX INFO: renamed from: uta.a$a, reason: collision with other inner class name */
    public static final class RunnableC7931a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f551710a;

        public RunnableC7931a(a r100) {
            this.f551710a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            c r100 = this.f551710a.f551709b;     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            r100.a();     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f551711a;

        public b(a r100) {
            this.f551711a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            c r100 = this.f551711a.f551709b;     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            r100.a();     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public a(String r100, c r101) {
        this.f551708a = r100;
        this.f551709b = r101;
    }

    public final void b() {
        URLConnection r100 = a(new URL(this.f551708a));     // Catch: Exception -> L13
        if (r100 == null) goto L12;
        HttpURLConnection r101 = (HttpURLConnection) r100;     // Catch: Exception -> L13
        r101.setRequestMethod("GET");     // Catch: Exception -> L13
        r101.setInstanceFollowRedirects(true);     // Catch: Exception -> L13
        r101.setConnectTimeout(20000);     // Catch: Exception -> L13
        r101.setReadTimeout(20000);     // Catch: Exception -> L13
        r101.setRequestProperty("User-Agent", "Mozilla/4.76");     // Catch: Exception -> L13
        if (r101.getResponseCode() != 200) goto L9;
        InputStream r102 = r101.getInputStream();     // Catch: Exception -> L13
        c r103 = this.f551709b;     // Catch: Exception -> L13
        if (r103 == null) goto L10;
        r103.a(r102);     // Catch: Exception -> L13
    L10:
        r101.disconnect();     // Catch: Exception -> L13
        return;
    L9:
        new Handler(Looper.getMainLooper()).post(new RunnableC7931a(this));     // Catch: Exception -> L13
        goto L10
    L12:
        throw new TypeCastException("null cannot be cast to non-null type java.net.HttpURLConnection");     // Catch: Exception -> L13
    L13:
        e = move-exception;
        e.printStackTrace();
        new Handler(Looper.getMainLooper()).post(new b(this));
    }

    @Override // java.lang.Runnable
    public final void run() {
        b();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    @Skip({"com.obric.assistant.network.okhttp"})
    public static URLConnection a(URL r100) throws IOException {
        String r101 = r100.getHost();     // Catch: Throwable -> L8 IOException -> L12
        String r102 = r100.getPath();     // Catch: Throwable -> L8 IOException -> L12
        if (com.obric.assistant.network.okhttp.a.c(r101, r102) == false) goto L11;
        FLogger.f375446a.i("UrlConnLancet", "openConnection drop host=" + r101 + " path=" + r102);     // Catch: Throwable -> L8 IOException -> L12
        com.obric.assistant.network.okhttp.a.b(GlobalNetworkGate.a(r101, r102), r101, r102);     // Catch: Throwable -> L8 IOException -> L12
        throw new IOException("[NetGuard] dropped " + r100);     // Catch: Throwable -> L8 IOException -> L12
    L11:
        return r100.openConnection();
    L12:
        e = move-exception;
        throw e;
    L8:
        th = move-exception;
        FLogger.f375446a.e("UrlConnLancet", "openConnection intercept failed, fallback to origin: " + th.getMessage());
        goto L11
    }
}
