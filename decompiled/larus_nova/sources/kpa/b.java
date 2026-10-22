package kpa;

import com.larus.utils.logger.FLogger;
import com.relax.embedding.LLog;
import com.relax.loader.LibraryLoader;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class b implements LibraryLoader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f505566a;

    public b() {
    }

    public static void b() {
        if (f505566a == false) goto L10;
        return;
    L10:
        LLog.i("Load relax.so by internal library loader");     // Catch: Throwable -> L7
        new b().loadLibrary("relax");     // Catch: Throwable -> L7
        f505566a = true;     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        LLog.e("Load relax.so exception: " + th.getMessage());
        f505566a = false;
    }

    @JvmStatic
    public static void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "libName");
        FLogger r101 = FLogger.f375446a;
        r101.i("Librarian_loadLib", "loadLibrary start libName -> " + r100);
        com.bytedance.librarian.a.c(r100);
        r101.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r100);
    }

    @Override // com.relax.loader.LibraryLoader
    public final void loadLibrary(String r100) {
        a(r100);     // Catch: Throwable -> L5
        LLog.i("Load " + r100 + " async by System");     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        LLog.e("Load " + r100 + " async by System exception: " + th.getMessage());
    }
}
