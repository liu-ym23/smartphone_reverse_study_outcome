package o57;

import android.os.Message;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes21.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Message f522101a;

    @Override // java.lang.Runnable
    public final void run() {
        this.f522101a.sendToTarget();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public a(Message r100) {
        this.f522101a = r100;
    }
}
