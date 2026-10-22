package com.larus.dora.impl.nl;

import android.content.Intent;
import android.util.Log;
import com.obric.assistant.spi.dora.IObricDoraService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class m implements Runnable {
    public /* synthetic */ m() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        IObricDoraService r100 = (IObricDoraService) ServiceManager.get().getService(IObricDoraService.class);
        boolean r101 = true;
        if (r100 != null) goto L5;
    L7:
        boolean r102 = false;
    L8:
        com.larus.dora.impl.util.x.f338160a.getClass();
        com.larus.dora.impl.network.f0 r103 = com.larus.dora.impl.util.x.a();
        boolean r104 = n.c();
        if (r103 != null) goto L11;
    L13:
        boolean r105 = false;
    L14:
        g49.d.d("NLUtils", "shouldEnableNLService, aiState: " + r105 + ", nlState: " + r104);
        if (r105 == true) goto L19;
        if (r104 == true) goto L19;
        boolean r106 = false;
    L20:
        if (r106 == true) goto L24;
        if (r102 == true) goto L24;
        boolean r107 = false;
    L25:
        g49.d.d("NLUtils", "initNLService, shouldEnableNLService: " + r106 + ", useObricNotificationLogic: " + r102 + ", shouldStartNLService: " + r107);
        if (r107 == false) goto L44;
        AtomicBoolean r108 = n.f336286a;
        if (r108.get() == false) goto L30;
        g49.d.d("NLUtils", "NLService already started");
        return;
    L30:
        r108.set(true);
        g49.d.d("NLUtils", "start");     // Catch: Throwable -> L42
        IObricDoraService r109 = (IObricDoraService) ServiceManager.get().getService(IObricDoraService.class);     // Catch: Throwable -> L42
        if (r109 != null) goto L34;
    L36:
        r101 = false;
    L37:
        if (r101 == false) goto L39;
        g49.d.d("NLUtils", "skip toggleNLService in obric smart notification logic");     // Catch: Throwable -> L42
    L40:
        pk4.n.f529659c.startService(new Intent(pk4.n.f529659c, NLService.class));     // Catch: Throwable -> L42
        return;
    L39:
        n.f();     // Catch: Throwable -> L42
        goto L40
    L34:
        if (r109.m() == false) goto L36;
    L42:
        th = move-exception;
        g49.d.b("NLUtils", "start: " + Log.getStackTraceString(th));
        return;
    L44:
        AtomicBoolean r110 = n.f336286a;
        if (r110.get() == true) goto L47;
        g49.d.d("NLUtils", "NLService already stopped");
        return;
    L47:
        r110.set(false);
        g49.d.d("NLUtils", "stop");     // Catch: Throwable -> L50
        pk4.n.f529659c.stopService(new Intent(pk4.n.f529659c, NLService.class));     // Catch: Throwable -> L50
        return;
    L50:
        th = move-exception;
        g49.d.b("NLUtils", "stop: " + Log.getStackTraceString(th));
        return;
    L24:
        r107 = true;
    L19:
        r106 = true;
        goto L20
    L11:
        if (r103.d() == null) goto L13;
        r105 = "1".equals(r103.d().j());
        goto L14
    L5:
        if (r100.m() == false) goto L7;
        r102 = true;
        goto L8
    }
}
