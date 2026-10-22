package ms.bd.c;

import android.content.Context;
import android.webkit.WebSettings;

/* JADX INFO: loaded from: classes5.dex */
public abstract class i4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f515167a;

    public static synchronized String a(Context r100) {
        monitor-enter(i4.class);
        String r101 = f515167a;     // Catch: Throwable -> L11
        if (r101 == null) goto L8;
        monitor-exit(i4.class);
        return r101;
    L8:
        String r102 = WebSettings.getDefaultUserAgent(r100);     // Catch: Throwable -> L11
        f515167a = r102;     // Catch: Throwable -> L11
        monitor-exit(i4.class);
        return r102;
    L11:
        th = move-exception;
        throw th;
    }
}
