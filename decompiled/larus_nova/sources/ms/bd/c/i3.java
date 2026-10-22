package ms.bd.c;

import com.larus.utils.logger.FLogger;
import java.util.HashSet;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class i3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashSet f515164a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c4 f515165b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final h f515166c;

    public i3() {
        c4 r100 = new c4();
        h r101 = new h();
        this.f515164a = new HashSet();
        this.f515165b = r100;
        this.f515166c = r101;
    }

    @JvmStatic
    public static void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "libName");
        FLogger r101 = FLogger.f375446a;
        r101.i("Librarian_loadLib", "loadLibrary start libName -> " + r100);
        com.bytedance.librarian.a.c(r100);
        r101.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r100);
    }
}
