package mp7;

import com.larus.utils.logger.FLogger;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile boolean f514722a;

    @JvmStatic
    public static void a() {
        Intrinsics.checkNotNullParameter("preload", "libName");
        FLogger r100 = FLogger.f375446a;
        r100.i("Librarian_loadLib", "loadLibrary start libName -> preload");
        com.bytedance.librarian.a.c("preload");
        r100.i("Librarian_loadLib", "loadLibrary success by librarian -> preload");
    }
}
