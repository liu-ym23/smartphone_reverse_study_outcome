package eb6;

import id6.b;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f471798a = null;

    static {
        f471798a = new a();
    }

    public a() {
    }

    public static void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L5
        b.f489337c.e("Klay", r100);     // Catch: Throwable -> L5
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        int r102 = cb6.b.f23003a;
        return;
    L5:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    public static void a(a r100, String r101) {
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "msg");
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L5
        b.f489337c.Y2("Klay", r101, false);     // Catch: Throwable -> L5
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }
}
