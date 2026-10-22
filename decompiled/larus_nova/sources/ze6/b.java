package ze6;

import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicReference<xe6.b> f571544a = null;

    static {
        f571544a = new AtomicReference();
    }

    @JvmStatic
    public static final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        xe6.b r101 = f571544a.get();
        if (r101 == null) goto L9;
        r101.d(r100);     // Catch: Throwable -> L6
        return;
    L10:
        return;
    }

    @JvmStatic
    public static final void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        xe6.b r101 = f571544a.get();
        if (r101 == null) goto L9;
        r101.i(r100);     // Catch: Throwable -> L6
        return;
    L10:
        return;
    }

    @JvmStatic
    public static final void c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        xe6.b r101 = f571544a.get();
        if (r101 == null) goto L9;
        r101.w(r100);     // Catch: Throwable -> L6
        return;
    L10:
        return;
    }
}
