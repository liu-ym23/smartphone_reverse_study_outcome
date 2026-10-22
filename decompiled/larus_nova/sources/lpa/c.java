package lpa;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.network.okhttp.GlobalNetworkGate;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes34.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f510268a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ FutureTask f510269b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ com.lynx.clay.embedding.engine.loader.d f510270c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ a.d f510271d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f510272e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ a f510273f;

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x00fa: MOVE (r1 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]) (LINE:250), block:B:61:0x00fa */
    public final void c() {
        HttpURLConnection r100 = null;
        a.e r101 = null;
        HttpURLConnection r102 = (HttpURLConnection) a(new URL(this.f510272e));     // Catch: Throwable -> L52 Exception -> L54
        r102.setRequestMethod("GET");     // Catch: Exception -> L50 Throwable -> L60
        a r103 = this.f510273f;     // Catch: Exception -> L50 Throwable -> L60
        int r104 = r102.getResponseCode();     // Catch: Exception -> L50 Throwable -> L60
        r103.getClass();     // Catch: Exception -> L50 Throwable -> L60
        if (r104 >= 200) goto L7;
    L9:
        boolean r105 = false;
    L10:
        if (r105 == false) goto L34;
        InputStream r106 = r102.getInputStream();     // Catch: Exception -> L50 Throwable -> L60
        Map<String, List<String>> r107 = r102.getHeaderFields();     // Catch: Exception -> L50 Throwable -> L60
        if (r107 != null) goto L14;
    L31:
        b(r106);     // Catch: Exception -> L50 Throwable -> L60
        r102.disconnect();
        return;
    L14:
        if (r107.isEmpty() == true) goto L31;
        List<String> r108 = r107.get("file_path");     // Catch: Exception -> L50 Throwable -> L60
        if (r108 != null) goto L19;
    L28:
        b(r106);     // Catch: Exception -> L50 Throwable -> L60
        r102.disconnect();
        return;
    L19:
        if (r108.isEmpty() == true) goto L28;
        String r109 = r108.get(0);     // Catch: Exception -> L50 Throwable -> L60
        if (new PolarisFileWrapper(r109).exists() == true) goto L24;
        b(r106);     // Catch: Exception -> L50 Throwable -> L60
    L36:
        if (this.f510268a == false) goto L58;
        c5a.c.c("DefaultResourceLoader", "warning : maybe android.os.NetworkOnMainThreadException . Call async instead.");     // Catch: Exception -> L50 Throwable -> L60
        r101 = (a.e) this.f510269b.get(5, TimeUnit.SECONDS);     // Catch: TimeoutException -> L40 Throwable -> L42 ExecutionException -> L44 Exception -> L50 Throwable -> L60
    L46:
        if (r101 != null) goto L48;
        c5a.c.c("DefaultResourceLoader", "load sync , fail");     // Catch: Exception -> L50 Throwable -> L60
        ((h5a.a) this.f510270c).a("Can't get get meaningful response");     // Catch: Exception -> L50 Throwable -> L60
        goto L58
    L48:
        c5a.c.c("DefaultResourceLoader", "load sync, success ;");     // Catch: Exception -> L50 Throwable -> L60
        ((h5a.a) this.f510270c).b(r101.f510259a, r101.f510260b);     // Catch: Exception -> L50 Throwable -> L60
    L42:
        e = move-exception;
        ((h5a.a) this.f510270c).a("load network fail");     // Catch: Exception -> L50 Throwable -> L60
        e.printStackTrace();     // Catch: Exception -> L50 Throwable -> L60
    L58:
        r102.disconnect();
        return;
    L24:
        if (this.f510268a == false) goto L26;
        this.f510271d.setResult(new a.e(r109, r106));     // Catch: Exception -> L50 Throwable -> L60
        this.f510269b.run();     // Catch: Exception -> L50 Throwable -> L60
        goto L36
    L26:
        ((h5a.a) this.f510270c).b(r109, r106);     // Catch: Exception -> L50 Throwable -> L60
        goto L36
    L34:
        b(null);     // Catch: Exception -> L50 Throwable -> L60
        goto L36
    L7:
        if (r104 >= 300) goto L9;
        r105 = true;
    L50:
        Exception e100 = e;
    L56:
        ((h5a.a) this.f510270c).a(e100.getMessage());     // Catch: Throwable -> L60
        c5a.c.b("DefaultResourceLoader", "loadHttp exception:", e100);     // Catch: Throwable -> L60
        if (r102 != null) goto L58;
        return;
    L60:
        th = th;
        r100 = r2;
    L62:
        if (r100 == null) goto L64;
        r100.disconnect();
    L64:
        throw th;
    L54:
        e = move-exception;
        r102 = null;
        e100 = e;
    L52:
        th = th;
        goto L62
    }

    @Override // java.lang.Runnable
    public final void run() {
        c();     // Catch: Throwable -> L4
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

    public final void b(InputStream r100) {
        if (r100 != null) goto L9;
        if (this.f510268a == false) goto L6;
        this.f510269b.run();
        return;
    L6:
        ((h5a.a) this.f510270c).a("load network fail");
        return;
    L9:
        if (this.f510268a == false) goto L11;
        this.f510271d.setResult(new a.e(null, r100));
        this.f510269b.run();
        return;
    L11:
        ((h5a.a) this.f510270c).b(null, r100);
    }

    public c(a r100, boolean r101, FutureTask r102, com.lynx.clay.embedding.engine.loader.d r103, a.d r104, String r105) {
        this.f510273f = r100;
        this.f510268a = r101;
        this.f510269b = r102;
        this.f510270c = r103;
        this.f510271d = r104;
        this.f510272e = r105;
    }
}
