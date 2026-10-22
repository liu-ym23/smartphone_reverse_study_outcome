package vs4;

import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;

/* JADX INFO: loaded from: classes15.dex */
public final class o implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f557027a;

    public o(String r100) {
        this.f557027a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String r100 = this.f557027a;     // Catch: Throwable -> L11
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L5
        lc5.f.a r102 = lc5.f.f508440a;     // Catch: Throwable -> L5
        lc5.f.a.y(r100);     // Catch: Throwable -> L5
        Object r103 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r104 = Result.m9452exceptionOrNullimpl(r103);     // Catch: Throwable -> L11
        if (r104 == null) goto L14;
        tt5.a.e("BitableRecommendBizReporter", "reportBitableLandingView error", r104, false);     // Catch: Throwable -> L11
        return;
    L14:
        return;
    L5:
        th = move-exception;
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L11
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L20;
        throw th;
    }
}
