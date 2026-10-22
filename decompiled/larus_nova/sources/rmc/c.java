package rmc;

import android.text.TextUtils;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static a f538620a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile boolean f538621b;

    public interface a {
        int loadLibrary(String r100) throws Exception;
    }

    public c() {
    }

    static {
        f538621b = false;
    }

    @JvmStatic
    public static void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "libName");
        FLogger r101 = FLogger.f375446a;
        r101.i("Librarian_loadLib", "loadLibrary start libName -> " + r100);
        com.bytedance.librarian.a.c(r100);
        r101.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r100);
    }

    public static int b(String r100) throws Exception {
        a r101 = f538620a;
        if (TextUtils.isEmpty(r100) == true) goto L15;
    L11:
        th = move-exception;
        th.getMessage();
        return -1;
    L5:
        if (f538621b == true) goto L8;
        if (r101 == null) goto L8;
        r101.toString();     // Catch: Throwable -> L11
        return r101.loadLibrary(r100);
    L8:
        a(r100);     // Catch: Throwable -> L11
        return 0;
    L15:
        throw new Exception("Invalid library name.");
    }
}
