package rmc;

import android.os.Handler;
import android.os.Looper;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import com.ss.videoarch.live.LiveIOManager;

/* JADX INFO: loaded from: classes38.dex */
public final class d extends PthreadThreadV2 {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ Handler.Callback f538622v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ LiveIOManager f538623w;

    @Override // com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2, java.lang.Thread, java.lang.Runnable
    public final void run() {
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L11;
        return;
    L11:
        throw th;
    L3:
        if (Looper.myLooper() != null) goto L5;
        Looper.prepare();     // Catch: Throwable -> L7
    L5:
        LiveIOManager r100 = this.f538623w;     // Catch: Throwable -> L7
        new Handler(this.f538622v);     // Catch: Throwable -> L7
        r100.getClass();     // Catch: Throwable -> L7
        Looper.loop();     // Catch: Throwable -> L7
    }

    public d(LiveIOManager r100, Handler.Callback r101) {
        this.f538623w = r100;
        this.f538622v = r101;
        super("LiveIOManager$1");
    }
}
