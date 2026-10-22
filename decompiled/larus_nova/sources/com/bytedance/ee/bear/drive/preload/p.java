package com.bytedance.ee.bear.drive.preload;

import java.util.List;

/* JADX INFO: loaded from: classes16.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g85.f f224555a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final n f224556b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f224557c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a95.a f224558d;

    public p(a95.a r100) {
        this.f224558d = r100;
        o75.a r101 = o75.b.a();
        this.f224555a = r101.getMimeTypeManager();
        this.f224556b = new n(r100);
        this.f224557c = r101.getDriveConfig().f531963f;
        r.b(r100);
    }

    public final boolean a(f85.a r100) {
        if (((g85.b) this.f224555a).o(((f85.a.C5868a) r100.f558532a).f558567k, r100.f558549r) == true) goto L6;
        tt5.a.h("DrivePreloadExecutor", "not video preload");
        return false;
    L6:
        tt5.a.h("DrivePreloadExecutor", "add video preload  " + du5.b.g(((f85.a.C5868a) r100.f558532a).f558557a));
        List<Integer> r101 = r100.f558533b;
        if (hu5.a.d(r101) == false) goto L9;
    L15:
        tt5.a.d("DrivePreloadExecutor", "server not support transform");
        return false;
    L9:
        if (r101.contains(3) == false) goto L11;
        return true;
    L11:
        if (r101.contains(20) == false) goto L15;
        return true;
    }
}
