package zib;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.statistics.Statistics;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;

/* JADX INFO: loaded from: classes36.dex */
public final class j implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ s5c.d f572348a;

    public j(s5c.a r100) {
        this.f572348a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        s5c.d r100 = this.f572348a;     // Catch: Throwable -> L8
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L5
        Statistics.sendEvent("start_forward_mention", r100.toJson());     // Catch: Throwable -> L5
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L17:
        return;
    L5:
        th = move-exception;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L8
        Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L12;
        return;
    L12:
        throw th;
    }
}
