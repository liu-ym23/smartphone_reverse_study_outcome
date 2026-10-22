package hs2;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f486950a = 0;

    static {
    }

    public static void a(String r100) {
        Intrinsics.checkNotNullParameter("TASK_MONITOR", "tag");
        Intrinsics.checkNotNullParameter(r100, "msg");
        pm0.b r101 = om0.c.f();
        if (r101 == null) goto L6;
        r101.i("TASK_MONITOR", r100);
        return;
    }

    public static void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "errorMsg");
        pm0.b r101 = om0.c.f();
        if (r101 == null) goto L6;
        r101.e("LIVE_TASK_LOG", r100);
        return;
    }
}
