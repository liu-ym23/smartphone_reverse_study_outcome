package e11;

import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static a f470689a;

    public static final b a(b.a r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$get");
        if (f470689a != null) goto L12;
        b.a r101 = b.f470687a;
        monitor-enter(r101);
        f470689a = new a();     // Catch: Throwable -> L9
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L9
        monitor-exit(r101);
    L9:
        th = move-exception;
        throw th;
    L12:
        a r103 = f470689a;
        Intrinsics.checkNotNull(r103);
        return r103;
    }
}
