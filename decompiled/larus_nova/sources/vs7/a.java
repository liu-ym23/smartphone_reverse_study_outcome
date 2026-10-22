package vs7;

import com.dtf.face.log.RecordService;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes22.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f557061a;

    @Override // java.lang.Runnable
    public final void run() {
        f r100 = this.f557061a;     // Catch: Throwable -> L4
        r100.f557068c.removeView(r100.f557066a);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        RecordService.getInstance().recordException(th);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L11;
        return;
    L11:
        throw th;
    }

    public a(f r100) {
        this.f557061a = r100;
    }
}
