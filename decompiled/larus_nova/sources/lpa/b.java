package lpa;

import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.utils.logger.FLogger;
import com.lynx.clay.embedding.engine.loader.ResourceLoaderCallback;
import com.obric.assistant.network.okhttp.GlobalNetworkGate;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.FutureTask;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes34.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f510261a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Map f510262b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f510263c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ a.c f510264d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ FutureTask f510265e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ ResourceLoaderCallback f510266f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ a f510267g;

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x00cd: MOVE (r1 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]) (LINE:205), block:B:36:0x00cd */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void b() {
        HttpURLConnection r100 = null;
        byte[] r101 = null;
        HttpURLConnection r102 = (HttpURLConnection) a(new URL(this.f510261a));     // Catch: Throwable -> L27 Exception -> L29
        r102.setRequestMethod("GET");     // Catch: Exception -> L17 Throwable -> L35
        Iterator r103 = this.f510262b.entrySet().iterator();     // Catch: Exception -> L17 Throwable -> L35
    L6:
        if (r103.hasNext() == false) goto L8;
        Map.Entry r104 = (Map.Entry) r103.next();     // Catch: Exception -> L17 Throwable -> L35
        r102.setRequestProperty((String) r104.getKey(), (String) r104.getValue());     // Catch: Exception -> L17 Throwable -> L35
        goto L6
    L8:
        a r105 = this.f510267g;     // Catch: Exception -> L17 Throwable -> L35
        int r106 = r102.getResponseCode();     // Catch: Exception -> L17 Throwable -> L35
        r105.getClass();     // Catch: Exception -> L17 Throwable -> L35
        if (r106 >= 200) goto L11;
    L13:
        boolean r107 = false;
    L15:
        if (r107 == false) goto L19;
        a r108 = this.f510267g;     // Catch: Exception -> L17 Throwable -> L35
        InputStream r109 = r102.getInputStream();     // Catch: Exception -> L17 Throwable -> L35
        r108.getClass();     // Catch: Exception -> L17 Throwable -> L35
        r101 = a.b(r109);     // Catch: Exception -> L17 Throwable -> L35
    L21:
        if (this.f510263c == false) goto L23;
        this.f510264d.f510257a = r101;     // Catch: Exception -> L17 Throwable -> L35
        this.f510265e.run();     // Catch: Exception -> L17 Throwable -> L35
    L33:
        r102.disconnect();
        return;
    L23:
        if (r101 != null) goto L25;
        c5a.c.d(5, "DefaultResourceLoader", "load async, fail");     // Catch: Exception -> L17 Throwable -> L35
        this.f510266f.onFailed("load network fail");     // Catch: Exception -> L17 Throwable -> L35
        goto L33
    L25:
        c5a.c.c("DefaultResourceLoader", "load async, success : len: " + r101.length);     // Catch: Exception -> L17 Throwable -> L35
        this.f510266f.onSucceeded(r101);     // Catch: Exception -> L17 Throwable -> L35
        goto L33
    L19:
        c5a.c.d(5, "DefaultResourceLoader", "Request failed, status code: " + r102.getResponseCode());     // Catch: Exception -> L17 Throwable -> L35
        goto L21
    L11:
        if (r106 >= 300) goto L13;
        r107 = true;
    L17:
        Exception e100 = e;
    L31:
        this.f510266f.onFailed(e100.getMessage());     // Catch: Throwable -> L35
        c5a.c.b("DefaultResourceLoader", "loadHttp exception:", e100);     // Catch: Throwable -> L35
        if (r102 != null) goto L33;
        return;
    L35:
        th = th;
        r100 = r2;
    L37:
        if (r100 == null) goto L39;
        r100.disconnect();
    L39:
        throw th;
    L29:
        e = move-exception;
        r102 = null;
        e100 = e;
    L27:
        th = th;
        goto L37
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

    public b(a r100, String r101, Map r102, boolean r103, a.c r104, FutureTask r105, ResourceLoaderCallback r106) {
        this.f510267g = r100;
        this.f510261a = r101;
        this.f510262b = r102;
        this.f510263c = r103;
        this.f510264d = r104;
        this.f510265e = r105;
        this.f510266f = r106;
    }
}
