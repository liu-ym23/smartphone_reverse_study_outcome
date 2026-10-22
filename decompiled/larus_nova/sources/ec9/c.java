package ec9;

import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class c implements Runnable {
    public /* synthetic */ c() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        List r100 = l.d();
        monitor-enter(r100);
    L14:
        th = move-exception;
        throw th;
    L5:
        if ((!l.d().isEmpty()) == false) goto L11;
        FLogger.f375446a.i("InitPeriodWrapper", "execute pending tasks");     // Catch: Throwable -> L14
        Iterator r101 = l.d().iterator();     // Catch: Throwable -> L14
    L8:
        if (r101.hasNext() == false) goto L10;
        ((Runnable) r101.next()).run();     // Catch: Throwable -> L14
        goto L8
    L10:
        l.d().clear();     // Catch: Throwable -> L14
    L11:
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L14
        monitor-exit(r100);
    }
}
