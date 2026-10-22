package oo7;

import android.app.Activity;
import android.os.Build;
import android.view.View;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;

/* JADX INFO: loaded from: classes22.dex */
public final class v implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ x f524644a;

    public final void a() {
        x r100 = this.f524644a;
        Activity r101 = eo7.a.b.f473353a.h();
        if (r101 != null) goto L30;
    L13:
        boolean r102 = false;
    L14:
        if (r101 == null) goto L27;
        if (r102 == true) goto L27;
        if (Build.VERSION.SDK_INT < 29) goto L27;
        k.e("WindowFocusUtils", "has no focus! topActivity = " + r101);     // Catch: Exception -> L11
        View r103 = r101.getWindow().getDecorView();     // Catch: Exception -> L11
        if (com.larus.home.impl.utils.c.f346345e == false) goto L23;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");     // Catch: Exception -> L11
        Thread r104 = ThreadMethodProxy.currentThread();     // Catch: Exception -> L11
        if (r104 == com.larus.home.impl.utils.c.f346341a) goto L23;
        com.larus.home.impl.utils.c.a(r104, "getDecorView");     // Catch: Exception -> L11
    L23:
        if (r103 == null) goto L27;
        r103.getViewTreeObserver().addOnWindowFocusChangeListener(new w(r100, r103));     // Catch: Exception -> L11
        return;
    L11:
        e = move-exception;
        k.e("WindowFocusUtils", "error on handle focus e = " + e.getLocalizedMessage());
    L27:
        if (r100 == null) goto L32;
        ((com.bytedance.ug.sdk.share.impl.manager.j.b) r100).a();
        return;
    L32:
        return;
    L30:
        boolean r105 = r101.hasWindowFocus();     // Catch: Exception -> L11
        if (com.larus.home.impl.utils.c.f346345e == false) goto L9;
        FLogger.f375446a.i("DecorViewLancet", "hasWindowFocus");     // Catch: Exception -> L11
        Thread r106 = ThreadMethodProxy.currentThread();     // Catch: Exception -> L11
        if (r106 == com.larus.home.impl.utils.c.f346341a) goto L9;
        com.larus.home.impl.utils.c.a(r106, "hasWindowFocus");     // Catch: Exception -> L11
    L9:
        if (r105 == false) goto L13;
        r102 = true;
        goto L14
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

    public v(com.bytedance.ug.sdk.share.impl.manager.j.b r100) {
        this.f524644a = r100;
    }
}
