package ppa;

import com.larus.utils.logger.FLogger;
import java.util.concurrent.Callable;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class a implements Callable<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f530236a;

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.concurrent.Callable
    public Boolean call() {
        a(this.f530236a);     // Catch: Exception -> L4
        boolean r100 = true;
    L7:
        return Boolean.valueOf(r100);
    L4:
        e = move-exception;
        e.getMessage();
        r100 = false;
        goto L7
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Boolean call() throws Exception {
        return call();
    }

    public a(String r100) {
        this.f530236a = r100;
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
