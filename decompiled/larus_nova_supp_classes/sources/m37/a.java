package m37;

import android.app.Application;
import android.content.Context;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class a {
    public static volatile Context a;

    public static Context getContext() {
        if (a != null) goto L16;
        monitor-enter(a.class);
    L12:
        th = move-exception;
        throw th;
    L7:
        if (a == null) goto L11;
        monitor-exit(a.class);     // Catch: Throwable -> L12
        goto L16
    L11:
        throw new IllegalStateException("SettingsManager尚未被配置");     // Catch: Throwable -> L12
    L16:
        return a;
    }

    public a() {
    }

    public static synchronized void a(Context r2) {
        monitor-enter(a.class);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (a == null) goto L7;
    L10:
        monitor-exit(a.class);
        return;
    L7:
        if ((r2 instanceof Application) == false) goto L9;
        a = r2;     // Catch: Throwable -> L12
        goto L10
    L9:
        a = r2.getApplicationContext();     // Catch: Throwable -> L12
        goto L10
    }
}
