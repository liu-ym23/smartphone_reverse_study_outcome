package kotlinx.coroutines.future;

import java.util.concurrent.CompletionException;
import java.util.function.BiFunction;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes42.dex */
public final class a<T> implements BiFunction<T, Throwable, Unit> {
    public volatile Continuation<? super T> cont;

    @Override // java.util.function.BiFunction
    public final Unit apply(Object r100, Throwable r101) {
        Throwable r102 = r101;
        Continuation<? super T> r103 = this.cont;
        if (r103 == null) goto L18;
        if (r102 != null) goto L8;
        r103.resumeWith(Result.m9449constructorimpl(r100));
        goto L18
    L8:
        if ((r102 instanceof CompletionException) == false) goto L10;
        CompletionException r104 = (CompletionException) r102;
    L11:
        if (r104 == null) goto L16;
        Throwable r105 = r104.getCause();
        if (r105 == null) goto L16;
        r102 = r105;
    L16:
        Result.Companion r106 = Result.Companion;
        r103.resumeWith(Result.m9449constructorimpl(ResultKt.createFailure(r102)));
        goto L18
    L10:
        r104 = null;
    L18:
        return Unit.INSTANCE;
    }
}
