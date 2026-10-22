package ytc;

import com.larus.utils.logger.FLogger;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f569211a;

    @JvmStatic
    public static void a() {
        Intrinsics.checkNotNullParameter("zkfv_tj", "libName");
        FLogger r100 = FLogger.f375446a;
        r100.i("Librarian_loadLib", "loadLibrary start libName -> zkfv_tj");
        com.bytedance.librarian.a.c("zkfv_tj");
        r100.i("Librarian_loadLib", "loadLibrary success by librarian -> zkfv_tj");
    }

    public static void b() {
        if (f569211a == false) goto L10;
        return;
    L10:
        System.out.println("java2jni java.library.path is: " + System.getProperty("java.library.path"));     // Catch: UnsatisfiedLinkError -> L7
        a();     // Catch: UnsatisfiedLinkError -> L7
        f569211a = true;     // Catch: UnsatisfiedLinkError -> L7
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
    }
}
