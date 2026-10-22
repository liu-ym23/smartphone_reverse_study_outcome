package emc;

import android.os.Handler;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import com.ss.ugc.live.sdk.msg.utils.i;

/* JADX INFO: loaded from: classes36.dex */
public final class b extends PthreadThreadV2 {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final d<c> f473122v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Handler f473123w;

    @Override // com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2, java.lang.Thread, java.lang.Runnable
    public final void run() {
    L15:
    L8:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L14;
        return;
    L14:
        throw th;
    L3:
        if (isInterrupted() == true) goto L21;
        c r100 = (c) this.f473122v.c();     // Catch: Throwable -> L6 InterruptedException -> L8
        r100.f473124a.toString();     // Catch: Throwable -> L6 InterruptedException -> L8
        Handler r101 = this.f473123w;     // Catch: Throwable -> L6 InterruptedException -> L8
        r101.sendMessage(r101.obtainMessage(7968, r100.f473124a));     // Catch: Throwable -> L6 InterruptedException -> L8
    }

    public b(d r100, i r101) {
        super("StreamMessageDelayThread");
        this.f473122v = r100;
        this.f473123w = r101;
    }
}
