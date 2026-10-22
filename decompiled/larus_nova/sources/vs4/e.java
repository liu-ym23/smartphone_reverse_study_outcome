package vs4;

import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;

/* JADX INFO: loaded from: classes15.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f557004a;

    public e(long r100) {
        this.f557004a = r100;
    }

    public final void a() {
        long r100 = this.f557004a;
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L5
        lc5.f.a r102 = lc5.f.f508440a;     // Catch: Throwable -> L5
        lc5.f.a.o(Long.valueOf(r100));     // Catch: Throwable -> L5
        Object r103 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r104 = Result.m9452exceptionOrNullimpl(r103);
        if (r104 == null) goto L13;
        tt5.a.e("BitableRecommendBizReporter", "reportBitableFeedStayDurationStatus error", r104, false);
        return;
    L13:
        return;
    L5:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
