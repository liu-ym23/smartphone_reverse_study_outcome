package vs4;

import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;

/* JADX INFO: loaded from: classes15.dex */
public final class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f557005a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f557006b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f557007c;

    public f(String r100, String r101, long r102) {
        this.f557005a = r100;
        this.f557006b = r101;
        this.f557007c = r102;
    }

    public final void a() {
        String r100 = this.f557005a;
        String r101 = this.f557006b;
        long r102 = this.f557007c;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L5
        lc5.f.a r104 = lc5.f.f508440a;     // Catch: Throwable -> L5
        lc5.f.a.p(r100, r101, Long.valueOf(r102));     // Catch: Throwable -> L5
        Object r105 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r106 = Result.m9452exceptionOrNullimpl(r105);
        if (r106 == null) goto L13;
        tt5.a.e("BitableRecommendBizReporter", "reportBitableFeedStayDurationStatus error", r106, false);
        return;
    L13:
        return;
    L5:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
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
