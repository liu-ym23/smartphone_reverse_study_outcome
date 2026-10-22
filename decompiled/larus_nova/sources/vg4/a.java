package vg4;

import com.larus.utils.logger.FLogger;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f554694a;

    @JvmStatic
    public static void a() {
        Intrinsics.checkNotNullParameter("bdzstd", "libName");
        FLogger r100 = FLogger.f375446a;
        r100.i("Librarian_loadLib", "loadLibrary start libName -> bdzstd");
        com.bytedance.librarian.a.c("bdzstd");
        r100.i("Librarian_loadLib", "loadLibrary success by librarian -> bdzstd");
    }

    public static synchronized void b() {
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (f554694a == false) goto L8;
        monitor-exit(a.class);
        return;
    L8:
        a();     // Catch: Throwable -> L11
        f554694a = true;     // Catch: Throwable -> L11
        monitor-exit(a.class);
    }
}
