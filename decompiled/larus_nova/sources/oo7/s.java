package oo7;

import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class s implements Runnable {
    public s() {
    }

    public static void a() {
        JSONObject r100 = new JSONObject();     // Catch: Exception -> L14
        eo7.a r101 = eo7.a.b.f473353a;     // Catch: Exception -> L14
        if (r101.h() == null) goto L11;
        boolean r102 = r101.h().hasWindowFocus();     // Catch: Exception -> L14
        if (com.larus.home.impl.utils.c.f346345e == false) goto L9;
        FLogger.f375446a.i("DecorViewLancet", "hasWindowFocus");     // Catch: Exception -> L14
        Thread r103 = ThreadMethodProxy.currentThread();     // Catch: Exception -> L14
        if (r103 == com.larus.home.impl.utils.c.f346341a) goto L9;
        com.larus.home.impl.utils.c.a(r103, "hasWindowFocus");     // Catch: Exception -> L14
    L9:
        if (r102 == false) goto L11;
        boolean r104 = true;
    L12:
        r100.put("is_focus", r104);     // Catch: Exception -> L14
        r.c("clipboard text is null", "reflow", r100, r.f524639a);     // Catch: Exception -> L14
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
