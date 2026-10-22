package kotlinx.coroutines;

import kotlin.Result;
import kotlin.ResultKt;

/* JADX INFO: loaded from: classes.dex */
public final class v {
    public static final Object a(Object r100) {
        if ((r100 instanceof t) == false) goto L6;
        Result.Companion r101 = Result.Companion;
        return Result.m9449constructorimpl(ResultKt.createFailure(((t) r100).f505148a));
    L6:
        return Result.m9449constructorimpl(r100);
    }
}
