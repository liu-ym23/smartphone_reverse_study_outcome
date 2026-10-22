package om9;

import android.content.Context;
import com.larus.settings.coldboot.c;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class a {
    public static final a a = null;

    static {
        a = new a();
    }

    public a() {
    }

    public static int a(Context r2) {
        c.a.getClass();
        int r0 = Runtime.getRuntime().availableProcessors() * 2;
        if (r0 <= 6) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L8;
        Intrinsics.checkNotNullParameter(r2, "context");
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L12
        Object r4 = Result.m49constructorimpl(c.a(r2, r0));     // Catch: Throwable -> L12
    L14:
        Result.m52exceptionOrNullimpl(r4);
        if (Result.m55isFailureimpl(r4) == false) goto L17;
        r4 = null;
    L17:
        Integer r5 = (Integer) r4;
        if (r5 == null) goto L22;
        r0 = r5.intValue();
    L22:
        return r0;
    L12:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r4 = Result.m49constructorimpl(ResultKt.createFailure(th));
        goto L14
    L8:
        return r0;
    L5:
        r1 = false;
        goto L6
    }
}
