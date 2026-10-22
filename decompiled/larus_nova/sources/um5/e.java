package um5;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.vfs.VFSFile;

/* JADX INFO: loaded from: classes18.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f550689a;

    public e(b r100) {
        this.f550689a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f550689a.b();     // Catch: Throwable -> L11
        VFSFile r100 = this.f550689a.f550667c.toFile();     // Catch: Throwable -> L11
        if (r100.exists() == false) goto L7;
        a r101 = this.f550689a.f550677m;     // Catch: Throwable -> L11
        if (r101 == null) goto L16;
        r101.a(r100);     // Catch: Throwable -> L11
    L16:
        return;
    L7:
        a r102 = this.f550689a.f550677m;     // Catch: Throwable -> L11
        if (r102 == null) goto L16;
        r102.onFail("notExistFile");     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L19;
        throw th;
    }
}
