package cxc;

import android.content.Context;
import android.text.TextUtils;
import java.util.UUID;

/* JADX INFO: loaded from: classes41.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f465756a = "";

    public static synchronized void b(String r100) {
        monitor-enter(e.class);
        f465756a = r100;     // Catch: Throwable -> L7
        monitor-exit(e.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static String a(Context r100, int r101) {
        if (r101 < 2) goto L5;
        return "NULL";
    L5:
        int r102 = r101 + 1;
        if (TextUtils.isEmpty(f465756a) == false) goto L21;
        String r103 = gxc.a.a(r100).b("UUID");
        monitor-enter(e.class);
        f465756a = r103;     // Catch: Throwable -> L17
        monitor-exit(e.class);
        if (TextUtils.isEmpty(r103) == false) goto L21;
        b(UUID.randomUUID().toString());
        if (TextUtils.isEmpty(f465756a) == false) goto L16;
        return "NULL";
    L16:
        gxc.a.a(r100).d("UUID", f465756a);
    L17:
        th = move-exception;
        throw th;
    L21:
        if (TextUtils.isEmpty(f465756a) == true) goto L28;
        if (f465756a.length() <= 40) goto L25;
    L26:
        f465756a = "";
        gxc.a.a(r100).c("UUID");
        f465756a = a(r100, r102);
        goto L28
    L25:
        if (ow7.a.e(f465756a) == false) goto L26;
    L28:
        return f465756a;
    }
}
