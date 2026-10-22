package mi7;

import ci7.z;
import com.bytedance.ug.sdk.deeplink.interfaces.IExecutor;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class l implements Runnable {
    public l() {
    }

    public static void a() {
        JSONObject r100 = new JSONObject();     // Catch: Exception -> L19
        gi7.c r101 = gi7.c.b.f481465a;     // Catch: Exception -> L19
        if (r101.b() == null) goto L11;
        boolean r102 = r101.b().hasWindowFocus();     // Catch: Exception -> L19
        if (com.larus.home.impl.utils.c.f346345e == false) goto L9;
        FLogger.f375446a.i("DecorViewLancet", "hasWindowFocus");     // Catch: Exception -> L19
        Thread r103 = ThreadMethodProxy.currentThread();     // Catch: Exception -> L19
        if (r103 == com.larus.home.impl.utils.c.f346341a) goto L9;
        com.larus.home.impl.utils.c.a(r103, "hasWindowFocus");     // Catch: Exception -> L19
    L9:
        if (r102 == false) goto L11;
        boolean r104 = true;
    L12:
        r100.put("is_focus", r104);     // Catch: Exception -> L19
        j r105 = new j("clipboard_invoke", "clipboard text is null", r100, m.f514108a);     // Catch: Exception -> L19
        IExecutor r106 = (IExecutor) z.a(IExecutor.class);     // Catch: Exception -> L19
        if (r106 == null) goto L24;
        r106.executeWithSingleThread(r105);     // Catch: Throwable -> L16
        goto L26
    L25:
        return;
    L16:
        th = move-exception;
        th.printStackTrace();     // Catch: Exception -> L19
        return;
    L24:
        return;
    L11:
        r104 = false;
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
}
