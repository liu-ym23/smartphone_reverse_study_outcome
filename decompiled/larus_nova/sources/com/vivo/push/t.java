package com.vivo.push;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;

/* JADX INFO: loaded from: classes41.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Handler f462517a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final HandlerThread f462518b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Handler f462519c = null;

    static {
        f462517a = new Handler(Looper.getMainLooper());
        PthreadHandlerThreadV2 r100 = new PthreadHandlerThreadV2("push_client_thread");
        f462518b = r100;
        ThreadMethodProxy.start(r100);
        f462519c = new u(r100.getLooper());
    }

    public static void a(r r100) {
        Handler r101 = f462519c;
        r101.removeCallbacks(r100);
        r101.postDelayed(r100, 15000);
    }

    public static void b(Runnable r100) {
        Handler r101 = f462519c;
        if (r101 == null) goto L6;
        r101.post(r100);
        return;
    }

    public static void a(Runnable r100) {
        f462517a.post(r100);
    }

    public static void a(s r100, long r101) {
        if (r100 != null) goto L5;
        com.vivo.push.util.t.a("PushClientThread", "client thread error, task is null!");
        return;
    L5:
        int r102 = r100.a();
        if (r101 <= 0) goto L8;
        f462519c.removeMessages(r102);
    L8:
        Message r103 = new Message();
        r103.what = r102;
        r103.obj = r100;
        f462519c.sendMessageDelayed(r103, r101);
    }
}
