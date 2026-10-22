package m37;

import android.app.Application;
import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile Context f511766a;

    public static Context getContext() {
        if (f511766a != null) goto L16;
        monitor-enter(a.class);
    L12:
        th = move-exception;
        throw th;
    L7:
        if (f511766a == null) goto L11;
        monitor-exit(a.class);     // Catch: Throwable -> L12
        goto L16
    L11:
        throw new IllegalStateException("SettingsManager尚未被配置");     // Catch: Throwable -> L12
    L16:
        return f511766a;
    }

    public a() {
    }

    public static synchronized void a(Context r100) {
        monitor-enter(a.class);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (f511766a == null) goto L7;
    L10:
        monitor-exit(a.class);
        return;
    L7:
        if ((r100 instanceof Application) == false) goto L9;
        f511766a = r100;     // Catch: Throwable -> L12
        goto L10
    L9:
        f511766a = r100.getApplicationContext();     // Catch: Throwable -> L12
        goto L10
    }
}
