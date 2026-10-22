package zf7;

import com.ss.android.agilelogger.ALog;
import yf7.e;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static e f571757a;

    static {
        f571757a = new a();
    }

    public static void a(String r100) {
        e r101 = f571757a;
        if (r101 == null) goto L10;
        ((a) r101).getClass();
        ALog.i("SyncSDKLog", r100);     // Catch: Throwable -> L7
        return;
    L11:
        return;
    }

    public static void b(String r100) {
        e r101 = f571757a;
        if (r101 == null) goto L10;
        ((a) r101).getClass();
        ALog.e("SyncSDKLog", r100);     // Catch: Throwable -> L7
        return;
    L11:
        return;
    }

    public static void c(String r100) {
        e r101 = f571757a;
        if (r101 == null) goto L10;
        ((a) r101).getClass();
        ALog.i("SyncSDKLog", r100);     // Catch: Throwable -> L7
        return;
    L11:
        return;
    }

    public static void d(String r100) {
        e r101 = f571757a;
        if (r101 == null) goto L10;
        ((a) r101).getClass();
        ALog.v("SyncSDKLog", r100);     // Catch: Throwable -> L7
        return;
    L11:
        return;
    }
}
