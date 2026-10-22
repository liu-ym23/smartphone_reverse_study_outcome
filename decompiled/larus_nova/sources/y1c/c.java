package y1c;

import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: classes37.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static b f565683a;

    public static g5c.a a() {
        if (f565683a != null) goto L16;
        monitor-enter(b.class);
    L12:
        th = move-exception;
        throw th;
    L7:
        if (b.f565681b != null) goto L9;
        b.f565681b = new b();     // Catch: Throwable -> L12
    L9:
        b r100 = b.f565681b;     // Catch: Throwable -> L12
        monitor-exit(b.class);
        f565683a = r100;
    L16:
        return f565683a;
    }

    public static <T> void b(String r100, String r101, T r102) {
        Log.e("SPHelperImpl", "save error name = " + r100 + ", type = " + r101 + ", t = " + r102);
    }
}
