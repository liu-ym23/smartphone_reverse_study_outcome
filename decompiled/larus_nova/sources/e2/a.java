package e2;

import android.content.Context;
import android.provider.Settings;

/* JADX INFO: loaded from: classes43.dex */
public final class a {
    public static boolean a(Context r100) {
        monitor-enter(c2.a.class);
        int r101 = c2.a.f22118a;     // Catch: Throwable -> L27
        boolean r102 = true;
        if (r101 == (-1)) goto L9;
        monitor-exit(c2.a.class);
    L17:
        if (r101 != 0) goto L19;
        return false;
    L19:
        if (r100 != null) goto L22;
        return false;
    L22:
        if (Settings.Secure.getInt(r100.getContentResolver(), "robots_protocol_enabled", 1) == 1) goto L26;
        r102 = false;
    L26:
        return r102;
    L9:
        int r103 = c2.a.a();     // Catch: Throwable -> L27
        if (r103 < 10) goto L12;
        r101 = 2;
    L15:
        c2.a.f22118a = r101;     // Catch: Throwable -> L27
        monitor-exit(c2.a.class);
        goto L17
    L12:
        if (r103 < 0) goto L14;
        r101 = 1;
        goto L15
    L14:
        r101 = 0;
    L27:
        th = move-exception;
        throw th;
    }
}
