package kotlinx.coroutines;

import kotlin.Result;
import kotlin.ResultKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class v {
    public static final Object a(Object r1) {
        if ((r1 instanceof t) == false) goto L6;
        Result.Companion r0 = Result.Companion;
        return Result.m49constructorimpl(ResultKt.createFailure(((t) r1).a));
    L6:
        return Result.m49constructorimpl(r1);
    }
}
