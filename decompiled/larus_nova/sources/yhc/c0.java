package yhc;

import android.os.Message;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes40.dex */
public final class c0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.ss.android.update.d f567688a;

    @Override // java.lang.Runnable
    public final void run() {
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    L13:
        return;
    L3:
        if (this.f567688a.l() == false) goto L9;
        Message r100 = this.f567688a.f455260e.obtainMessage(17);     // Catch: Throwable -> L6
        r100.arg1 = 2;     // Catch: Throwable -> L6
        r100.sendToTarget();     // Catch: Throwable -> L6
        return;
    }

    public c0(com.ss.android.update.d r100) {
        this.f567688a = r100;
    }
}
