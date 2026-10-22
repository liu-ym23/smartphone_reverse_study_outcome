package z4a;

import com.larus.utils.logger.FLogger;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f570043a;

    @JvmStatic
    public static void a() {
        Intrinsics.checkNotNullParameter("basedevtool", "libName");
        FLogger r100 = FLogger.f375446a;
        r100.i("Librarian_loadLib", "loadLibrary start libName -> basedevtool");
        com.bytedance.librarian.a.c("basedevtool");
        r100.i("Librarian_loadLib", "loadLibrary success by librarian -> basedevtool");
    }
}
