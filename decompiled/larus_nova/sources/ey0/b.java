package ey0;

import java.util.concurrent.CancellationException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class b {
    public static final <T> void a(Continuation<? super T> r100, T r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$checkCancellationAndResume");
        CoroutineContext r102 = r100.getContext();
        Intrinsics.checkNotNullParameter(r102, "$this$isCancelled");
        a r103 = (a) r102.get(a.f474782b);
        if (r103 == null) goto L5;
        boolean r104 = r103.f474783a;
    L6:
        if (r104 == false) goto L8;
        CancellationException r105 = new CancellationException("Continuation is cancelled");
        Result.Companion r106 = Result.Companion;
        r100.resumeWith(Result.m9449constructorimpl(ResultKt.createFailure(r105)));
        return;
    L8:
        r100.resumeWith(Result.m9449constructorimpl(r101));
        return;
    L5:
        r104 = false;
        goto L6
    }
}
