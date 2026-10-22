package vs4;

import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;

/* JADX INFO: loaded from: classes15.dex */
public final class p implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f557028a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f557029b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f557030c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f557031d;

    public p(String r100, String r101) {
        this.f557028a = r100;
        this.f557029b = "recommend";
        this.f557030c = "hp_v2";
        this.f557031d = r101;
    }

    public final void a() {
        String r100 = this.f557028a;
        String r101 = this.f557029b;
        String r102 = this.f557030c;
        String r103 = this.f557031d;
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L5
        lc5.f.a r105 = lc5.f.f508440a;     // Catch: Throwable -> L5
        lc5.f.a.z(r100, r101, r102, r103);     // Catch: Throwable -> L5
        Object r106 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r107 = Result.m9452exceptionOrNullimpl(r106);
        if (r107 == null) goto L13;
        tt5.a.e("BitableRecommendBizReporter", "reportBitableLandingView error", r107, false);
        return;
    L13:
        return;
    L5:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
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
