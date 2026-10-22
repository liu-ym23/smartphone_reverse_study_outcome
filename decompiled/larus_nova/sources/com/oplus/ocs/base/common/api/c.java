package com.oplus.ocs.base.common.api;

import android.os.Looper;
import android.os.Message;
import com.oplus.ocs.base.common.CapabilityInfo;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;

/* JADX INFO: loaded from: classes34.dex */
class c extends com.oplus.ocs.base.common.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static volatile int f404200a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f404201b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private BaseClient f404202c;

    public static synchronized c a(BaseClient r100) {
        monitor-enter(c.class);
        StringBuilder r101 = new StringBuilder("base_client_");     // Catch: Throwable -> L12
        int r102 = f404200a;     // Catch: Throwable -> L12
        f404200a = r102 + 1;     // Catch: Throwable -> L12
        r101.append(r102);     // Catch: Throwable -> L12
        PthreadHandlerThreadV2 r103 = new PthreadHandlerThreadV2(r101.toString());     // Catch: Throwable -> L12
        ThreadMethodProxy.start(r103);     // Catch: Throwable -> L12
        if (r103.getLooper() == null) goto L9;
        c r104 = new c(r103.getLooper(), r100);     // Catch: Throwable -> L12
        monitor-exit(c.class);
        return r104;
    L9:
        c r105 = new c(Looper.getMainLooper(), r100);     // Catch: Throwable -> L12
        monitor-exit(c.class);
        return r105;
    L12:
        th = move-exception;
        throw th;
    }

    @Override // android.os.Handler
    public void handleMessage(Message r100) {
        int r101 = r100.what;
        com.oplus.ocs.base.utils.a.a(this.f404201b, "base client handler what ".concat(String.valueOf(r101)));
        if (r101 != 1) goto L5;
        BaseClient r102 = this.f404202c;
        CapabilityInfo r103 = (CapabilityInfo) r100.obj;
        String r104 = BaseClient.f404154a;
        com.oplus.ocs.base.utils.a.b(r104, "onAuthenticateSucceed");
        r102.f404155b = 1;
        r102.f404156c = r103;
        i r105 = r102.f404159f;
        if (r105 == null) goto L29;
        r105.a(r103);
    L29:
        com.oplus.ocs.base.utils.a.a(r104, "handleAuthenticateSuccess");
        if (r102.f404160g != null) goto L32;
        r102.a(null);
    L32:
        Message r106 = Message.obtain();
        r106.what = 100;
        r102.f404160g.sendMessage(r106);
        r102.disconnect();
        return;
    L5:
        if (r101 != 2) goto L7;
        BaseClient r107 = this.f404202c;
        int r108 = r100.arg1;
        r107.f404155b = 4;
        r107.disconnect();
        CapabilityInfo r109 = BaseClient.b(r108);
        r107.f404156c = r109;
        i r110 = r107.f404159f;
        if (r110 == null) goto L22;
        r110.a(r109);
    L22:
        com.oplus.ocs.base.utils.a.a(BaseClient.f404154a, "connect failed , error code is ".concat(String.valueOf(r108)));
        r107.a(r108);
        j r111 = r107.f404158e;
        if (r111 == null) goto L36;
        r111.a();
        return;
    L36:
        return;
    L7:
        if (r101 != 3) goto L9;
        this.f404202c.f404161h.d();
        return;
    L9:
        if (r101 != 5) goto L35;
        BaseClient r112 = this.f404202c;
    L13:
        if (r112.f404157d.size() <= 0) goto L15;
        com.oplus.ocs.base.utils.a.a(BaseClient.f404154a, "handleQue");
        r112.a(r112.f404157d.poll());
        goto L13
    L15:
        com.oplus.ocs.base.utils.a.a(BaseClient.f404154a, "task queue is end");
        return;
    }

    private c(Looper r100, BaseClient r101) {
        super(r100);
        this.f404201b = "c";
        this.f404202c = r101;
    }
}
