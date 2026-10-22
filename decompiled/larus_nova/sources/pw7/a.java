package pw7;

import android.content.Context;
import exc.e;

/* JADX INFO: loaded from: classes23.dex */
public abstract class a {
    public static qw7.a a(Context r100) {
        monitor-enter(qw7.a.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (qw7.a.f535032a != null) goto L7;
        e.a(r100);     // Catch: Throwable -> L10
        qw7.a.f535032a = new qw7.a();     // Catch: Throwable -> L10
        qw7.a.a(r100);     // Catch: Throwable -> L10
    L7:
        qw7.a r101 = qw7.a.f535032a;     // Catch: Throwable -> L10
        monitor-exit(qw7.a.class);
        return r101;
    }
}
