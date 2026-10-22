package yt;

import xr.s;

/* JADX INFO: loaded from: classes44.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile int f569006a;

    public static void a() {
        f569006a++;
        mw.a r100 = (mw.a) s.a(mw.a.class);
        if (r100 == null) goto L6;
        r100.onDialogVisibilityChange(true);
        return;
    }

    public static void b() {
        f569006a--;
        if (f569006a >= 0) goto L5;
        f569006a = 0;
    L5:
        mw.a r100 = (mw.a) s.a(mw.a.class);
        if (r100 == null) goto L9;
        r100.onDialogVisibilityChange(false);
        return;
    }

    static {
    }
}
