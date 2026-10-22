package com.ss.android.lark.audio.opus;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.log.Log;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: loaded from: classes34.dex */
public final class d extends PthreadThreadV2 {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ e f409005v;

    public final void l() {
    L30:
        e.b r100 = (e.b) ((LinkedBlockingQueue) this.f409005v.f409009c).take();     // Catch: Throwable -> L16 InterruptedException -> L18
        Log.d("AudioPlayer", "initPlayerWorker1:" + r100);     // Catch: Throwable -> L10 InterruptedException -> L12
        this.f409005v.k(r100);     // Catch: Throwable -> L10 InterruptedException -> L12
    L6:
        if (r100.b() == true) goto L14;
        e.a r101 = r100.f409027c;     // Catch: Throwable -> L10 InterruptedException -> L12
        if (r101 == null) goto L15;
        r101.a();     // Catch: Throwable -> L10 InterruptedException -> L12
    L15:
        this.f409005v.k(null);
    L23:
        r100.c();
        goto L30
    L14:
        Log.d("AudioPlayer", "initPlayerWorker2:" + r100);     // Catch: Throwable -> L10 InterruptedException -> L12
        r100.run();     // Catch: Throwable -> L10 InterruptedException -> L12
    L10:
        th = th;
    L24:
        this.f409005v.k(null);
        if (r100 == null) goto L27;
        r100.c();
    L27:
        throw th;
    L12:
        InterruptedException e100 = e;
    L20:
        e100.printStackTrace();     // Catch: Throwable -> L10
        this.f409005v.k(null);
        if (r100 == null) goto L30;
    L18:
        e = move-exception;
        e100 = e;
        r100 = null;
    L16:
        th = th;
        r100 = null;
        goto L24
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2, java.lang.Thread, java.lang.Runnable
    public final void run() {
        l();     // Catch: Throwable -> L4
        throw null;     // Catch: Throwable -> L4
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public d(e r100) {
        this.f409005v = r100;
        super("opus_player");
    }
}
