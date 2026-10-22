package um5;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.vfs.VFSFile;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e implements Runnable {
    public final /* synthetic */ b a;

    public e(b r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.b();     // Catch: Throwable -> L11
        VFSFile r0 = this.a.c.toFile();     // Catch: Throwable -> L11
        if (r0.exists() == false) goto L7;
        a r1 = this.a.m;     // Catch: Throwable -> L11
        if (r1 == null) goto L16;
        r1.a(r0);     // Catch: Throwable -> L11
    L16:
        return;
    L7:
        a r2 = this.a.m;     // Catch: Throwable -> L11
        if (r2 == null) goto L16;
        r2.onFail("notExistFile");     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L19;
        throw th;
    }
}
