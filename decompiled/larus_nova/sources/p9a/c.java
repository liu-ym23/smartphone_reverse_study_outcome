package p9a;

import com.obric.aiagent.assistant_card.provider_core.ICardProviderService;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.i;

/* JADX INFO: loaded from: classes32.dex */
public final class c {
    public static final void a(i r100, ICardProviderService r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L8
        if (r100.isActive() == false) goto L6;
        r100.resumeWith(Result.m9449constructorimpl(r101));     // Catch: Throwable -> L8
    L6:
        Object r103 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L10:
        Throwable r104 = Result.m9452exceptionOrNullimpl(r103);
        if (r104 == null) goto L16;
        e r105 = b.f528329a;
        b.c("ContinuationEx", "safeResume error: " + r104.getMessage(), r104);
        return;
    L16:
        return;
    L8:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L10
    }
}
