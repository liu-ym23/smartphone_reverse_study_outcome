package kotlinx.coroutines.selects;

import kotlin.Result;
import kotlin.ResultKt;
import kotlinx.coroutines.CoroutineDispatcher;

/* JADX INFO: loaded from: classes6.dex */
public final class n {
    public static final void a(kotlinx.coroutines.j r100, Throwable r101) {
        CoroutineDispatcher r102 = (CoroutineDispatcher) r100.getContext().get(CoroutineDispatcher.Key);
        if (r102 == null) goto L5;
        r100.J(r102, r101);
        return;
    L5:
        Result.Companion r103 = Result.Companion;
        r100.resumeWith(Result.m9449constructorimpl(ResultKt.createFailure(r101)));
    }
}
