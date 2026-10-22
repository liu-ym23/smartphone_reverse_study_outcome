package l18;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.larksuite.framework.apiplugin.LKEvent;
import com.ss.android.lark.log.Log;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;

/* JADX INFO: loaded from: classes24.dex */
public final class b implements j18.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static b f507017b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f507018a;

    public static class a extends Handler {
        public a(Looper r100) {
            super(r100);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message r100) {
            super.handleMessage(r100);
            if (r100.what != 100) goto L8;
            Object r101 = r100.obj;
            if (r101 == null) goto L9;
            ((Runnable) r101).run();
            Log.i("LKDefaultAsyncHandleEve", "success run");
            return;
        L9:
            return;
        }
    }

    public b() {
        if (this.f507018a == null) goto L5;
        return;
    L5:
        monitor-enter(LKEvent.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (this.f507018a != null) goto L9;
        PthreadHandlerThreadV2 r100 = new PthreadHandlerThreadV2("innerDefaultAsyncHandler");     // Catch: Throwable -> L11
        ThreadMethodProxy.start(r100);     // Catch: Throwable -> L11
        this.f507018a = new a(r100.getLooper());     // Catch: Throwable -> L11
    L9:
        monitor-exit(LKEvent.class);     // Catch: Throwable -> L11
    }

    @Override // j18.a
    public final void a(String r100, i18.a r101) {
        this.f507018a.obtainMessage(100, r101).sendToTarget();
    }
}
