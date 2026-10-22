package com.bytedance.ee.bear.drive.preload;

import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class p {
    public final g85.f a;
    public final n b;
    public final long c;
    public final a95.a d;

    public p(a95.a r3) {
        this.d = r3;
        o75.a r0 = o75.b.a();
        this.a = r0.getMimeTypeManager();
        this.b = new n(r3);
        this.c = r0.getDriveConfig().f;
        r.b(r3);
    }

    public final boolean a(f85.a r5) {
        if (((g85.b) this.a).o(((f85.a.C0229a) r5.a).k, r5.r) == true) goto L6;
        tt5.a.h("DrivePreloadExecutor", "not video preload");
        return false;
    L6:
        tt5.a.h("DrivePreloadExecutor", "add video preload  " + du5.b.g(((f85.a.C0229a) r5.a).a));
        List<Integer> r6 = r5.b;
        if (hu5.a.d(r6) == false) goto L9;
    L15:
        tt5.a.d("DrivePreloadExecutor", "server not support transform");
        return false;
    L9:
        if (r6.contains(3) == false) goto L11;
        return true;
    L11:
        if (r6.contains(20) == false) goto L15;
        return true;
    }
}
