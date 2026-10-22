package tyb;

import android.os.SystemClock;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.passport.base.core.log.PassportLog;

/* JADX INFO: loaded from: classes37.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a.b f548029a;

    public c(a.b r100) {
        this.f548029a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L15;
        throw th;
    L15:
        return;
    L3:
        if (a.f548023e == null) goto L5;
        PassportLog.b("n_action_bdturing", "ignore turing request because another request is waiting");     // Catch: Throwable -> L7
    L12:
        return;
    L5:
        a.f548023e = this.f548029a;     // Catch: Throwable -> L7
        a.b(a.f548019a, this.f548029a, SystemClock.elapsedRealtime());     // Catch: Throwable -> L7
        goto L12
    }
}
