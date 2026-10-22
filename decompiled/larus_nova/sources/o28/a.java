package o28;

import com.larksuite.framework.thread.CoreThreadPool;
import com.larksuite.framework.thread.k;
import com.larksuite.framework.thread.t;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Objects;

/* JADX INFO: loaded from: classes24.dex */
public final class a extends k {
    @Override // com.larksuite.framework.thread.k, java.lang.Runnable
    public final void run() {
    L14:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L18;
        return;
    L18:
        throw th;
    L3:
        if (this.f285778g > 50) goto L5;
    L12:
        super.run();     // Catch: Throwable -> L14
        return;
    L5:
        if (CoreThreadPool.getDefault().isDuringCoreScene() == false) goto L12;
        Objects.toString(this.f285773b);     // Catch: Throwable -> L14
        Thread.sleep(1000);     // Catch: InterruptedException -> L10 Throwable -> L14
    L10:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L14
        goto L5
    }

    public a(Runnable r100, t r101) {
        super(r100, r101);
    }
}
