package o17;

import android.util.Log;
import com.bytedance.lynx.webview.internal.r;
import com.larus.apm.impl.protector.RunnableProtector;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.util.List;
import java.util.Map;
import l17.k;
import l17.o;

/* JADX INFO: loaded from: classes21.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f521706a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d.a f521707b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ b f521708c;

    public final void a() {
        f r100 = new f();
        this.f521708c.getClass();
        int r101 = b.f521709c;
        HttpURLConnection r102 = null;
        r102 = b.a(this.f521708c, this.f521706a);     // Catch: Throwable -> L19 Exception -> L21
        String r103 = this.f521706a.f521717d;     // Catch: Throwable -> L19 Exception -> L21
        Map<String, List<String>> r104 = r102.getHeaderFields();     // Catch: Throwable -> L19 Exception -> L21
        o r105 = this.f521708c.f521711b;     // Catch: Throwable -> L19 Exception -> L21
        if (r105 == null) goto L6;
        r105.put(new URI(this.f521706a.f521715b), r104);     // Catch: Throwable -> L19 Exception -> L21
    L6:
        int r106 = r102.getResponseCode();     // Catch: Throwable -> L19 Exception -> L21
        d.a r107 = this.f521707b;     // Catch: Throwable -> L19 Exception -> L21
        if (r107 == null) goto L9;
        ((c) r107).f521713b = r104;     // Catch: Throwable -> L19 Exception -> L21
    L9:
        r100.f521719a = String.valueOf(r106);     // Catch: Throwable -> L19 Exception -> L21
        if (r106 >= 200) goto L12;
    L14:
        r100.f521722d = b.c(this.f521708c, r102.getErrorStream(), this.f521707b);     // Catch: Throwable -> L19 Exception -> L21
    L15:
        d.a r108 = this.f521707b;     // Catch: Throwable -> L19 Exception -> L21
        if (r108 == null) goto L33;
        ((c) r108).a(r100);     // Catch: Throwable -> L19 Exception -> L21
    L33:
        r102.disconnect();
        return;
    L12:
        if (r106 > 299) goto L14;
        r100.f521720b = b.b(this.f521708c, r102.getInputStream());     // Catch: Throwable -> L19 Exception -> L21
    L19:
        th = move-exception;
        if (r102 == null) goto L37;
        r102.disconnect();
    L37:
        throw th;
    L21:
        e = move-exception;
        r.b("DefaultHttpAdapter sendRequest" + Log.getStackTraceString(e));     // Catch: Throwable -> L19
        r100.f521719a = "-1";     // Catch: Throwable -> L19
        r100.f521721c = "-1";     // Catch: Throwable -> L19
        r100.f521722d = e.getMessage();     // Catch: Throwable -> L19
        d.a r109 = this.f521707b;     // Catch: Throwable -> L19
        if (r109 == null) goto L26;
        ((c) r109).a(r100);     // Catch: Throwable -> L19
    L26:
        if ((e instanceof IOException) == true) goto L38;
    L32:
        if (r102 != null) goto L33;
        return;
    L38:
        IOException r110 = (IOException) e;     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        k.b(new String[]{Log.getStackTraceString(th)});     // Catch: Throwable -> L19
        goto L32
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public a(b r100, e r101, c r102) {
        this.f521708c = r100;
        this.f521706a = r101;
        this.f521707b = r102;
    }
}
