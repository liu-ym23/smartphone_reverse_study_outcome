package uta;

import android.os.Handler;
import android.os.Looper;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.network.okhttp.GlobalNetworkGate;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Ref;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes34.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f551712a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f551713b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ d f551714c;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f551715a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Ref.ObjectRef f551716b;

        public a(b r100, Ref.ObjectRef r101) {
            this.f551715a = r100;
            this.f551716b = r101;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public final void run() {
            d r100 = this.f551715a.f551714c;     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            r100.b((String) this.f551716b.element);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    /* JADX INFO: renamed from: uta.b$b, reason: collision with other inner class name */
    public static final class RunnableC7932b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f551717a;

        public RunnableC7932b(b r100) {
            this.f551717a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            d r100 = this.f551717a.f551714c;     // Catch: Throwable -> L6
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

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f551718a;

        public c(b r100) {
            this.f551718a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            d r100 = this.f551718a.f551714c;     // Catch: Throwable -> L6
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

    public b(String r100, String r101, d r102) {
        this.f551712a = r100;
        this.f551713b = r101;
        this.f551714c = r102;
    }

    /* JADX WARN: Type inference failed for: r2v11, types: [T, java.lang.String] */
    public final void b() {
        Ref.ObjectRef r100 = new Ref.ObjectRef();
        r100.element = "";
        URLConnection r101 = a(new URL(this.f551712a));     // Catch: Exception -> L16
        if (r101 == null) goto L15;
        HttpURLConnection r102 = (HttpURLConnection) r101;     // Catch: Exception -> L16
        r102.setRequestMethod("POST");     // Catch: Exception -> L16
        r102.setRequestProperty("Content-Type", "application/json");     // Catch: Exception -> L16
        r102.setDoOutput(true);     // Catch: Exception -> L16
        r102.setInstanceFollowRedirects(true);     // Catch: Exception -> L16
        r102.setConnectTimeout(20000);     // Catch: Exception -> L16
        r102.setReadTimeout(20000);     // Catch: Exception -> L16
        DataOutputStream r103 = new DataOutputStream(r102.getOutputStream());     // Catch: Exception -> L16
        r103.writeBytes(this.f551713b);     // Catch: Exception -> L16
        r103.flush();     // Catch: Exception -> L16
        r103.close();     // Catch: Exception -> L16
        if (r102.getResponseCode() != 200) goto L12;
        BufferedReader r104 = new BufferedReader(new InputStreamReader(r102.getInputStream()));     // Catch: Exception -> L16
        StringBuilder r105 = new StringBuilder();     // Catch: Exception -> L16
    L8:
        String r106 = r104.readLine();     // Catch: Exception -> L16
        if (r106 == null) goto L11;
        r105.append(r106);     // Catch: Exception -> L16
        goto L8
    L11:
        r104.close();     // Catch: Exception -> L16
        r100.element = r105.toString();     // Catch: Exception -> L16
        new Handler(Looper.getMainLooper()).post(new a(this, r100));     // Catch: Exception -> L16
    L13:
        r102.disconnect();     // Catch: Exception -> L16
        return;
    L12:
        new Handler(Looper.getMainLooper()).post(new RunnableC7932b(this));     // Catch: Exception -> L16
        goto L13
    L15:
        throw new TypeCastException("null cannot be cast to non-null type java.net.HttpURLConnection");     // Catch: Exception -> L16
    L16:
        e = move-exception;
        e.printStackTrace();
        new Handler(Looper.getMainLooper()).post(new c(this));
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
