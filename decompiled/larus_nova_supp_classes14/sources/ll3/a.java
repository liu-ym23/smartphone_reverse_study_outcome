package ll3;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        Intrinsics.checkNotNullParameter(r3, "msg");
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L5
        dm.a.b r4 = dm.a.a;     // Catch: Throwable -> L5
        dm.a.a("yata_business_".concat(r2)).i(r3);     // Catch: Throwable -> L5
        Object r5 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r6 = Result.exceptionOrNull-impl(r5);
        if (r6 == null) goto L13;
        ECExceptionMonitor.e(r6);
        return;
    L13:
        return;
    L5:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }
}
