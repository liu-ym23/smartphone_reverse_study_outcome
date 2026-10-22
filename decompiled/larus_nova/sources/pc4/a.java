package pc4;

import com.larus.utils.logger.FLogger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile boolean f528497a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile boolean f528498b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lock f528499c = null;

    public static boolean b() {
        Lock r100 = f528499c;     // Catch: Error -> L6 Throwable -> L12
        ((ReentrantLock) r100).lock();     // Catch: Error -> L6 Throwable -> L12
        if (f528498b == true) goto L9;
        a("ttcrypto");     // Catch: Error -> L6 Throwable -> L12
        f528498b = true;     // Catch: Error -> L6 Throwable -> L12
    L9:
        if (f528497a == true) goto L11;
        a("ttboringssl");     // Catch: Error -> L6 Throwable -> L12
        f528497a = true;     // Catch: Error -> L6 Throwable -> L12
    L11:
        ((ReentrantLock) r100).unlock();
        if (f528497a == true) goto L19;
    L21:
        return false;
    L19:
        if (f528498b == false) goto L21;
        return true;
    L12:
        th = move-exception;
        ((ReentrantLock) f528499c).unlock();
        throw th;
    L6:
        e = move-exception;
        e.toString();     // Catch: Throwable -> L12
        r100 = f528499c;
        goto L11
    }

    static {
        f528499c = new ReentrantLock();
    }

    @JvmStatic
    public static void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "libName");
        FLogger r101 = FLogger.f375446a;
        r101.i("Librarian_loadLib", "loadLibrary start libName -> ".concat(r100));
        com.bytedance.librarian.a.c(r100);
        r101.i("Librarian_loadLib", "loadLibrary success by librarian -> ".concat(r100));
    }
}
