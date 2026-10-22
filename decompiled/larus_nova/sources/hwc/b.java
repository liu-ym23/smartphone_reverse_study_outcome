package hwc;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes42.dex */
public final class b {
    public static void a(Function1 r100) {
        a r101 = a.f487464a;
        Intrinsics.checkNotNullParameter(r101, "koinContext");
        Intrinsics.checkNotNullParameter(r100, "appDeclaration");
        Intrinsics.checkNotNullParameter(r101, "koinContext");
        Intrinsics.checkNotNullParameter(r100, "appDeclaration");
        monitor-enter(r101);
        int r102 = org.koin.core.b.f526126b;     // Catch: Throwable -> L7
        org.koin.core.b r103 = org.koin.core.b.a.a();     // Catch: Throwable -> L7
        r101.b(r103);     // Catch: Throwable -> L7
        r100.invoke(r103);     // Catch: Throwable -> L7
        r103.a();     // Catch: Throwable -> L7
        monitor-exit(r101);
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
