package krc;

import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: classes41.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static a f505900a;

    public static void a(String r100, String r101) {
        if (f505900a != null) goto L5;
        return;
    L5:
        Log.e(r100, r101);
    }

    public static void c(String r100, String r101) {
        if (f505900a != null) goto L5;
        return;
    L5:
        Log.i(r100, r101);
    }

    public static void b(String r100, String r101, Throwable r102) {
        if (f505900a != null) goto L5;
        return;
    L5:
        Log.e(r100, r101, r102, true);
    }
}
