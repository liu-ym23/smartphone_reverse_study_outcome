package zib;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.statistics.Statistics;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import z5c.z2;

/* JADX INFO: loaded from: classes36.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f572326a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ s5c.d f572327b;

    public c(String r100, s5c.a r101) {
        this.f572326a = r100;
        this.f572327b = r101;
    }

    public final void a() {
        String r100 = this.f572326a;
        s5c.d r101 = this.f572327b;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L5
        Statistics.sendEvent("forward_entrance", s5c.d.b.b(z2.f570438k.a(r100), r101).toJson());     // Catch: Throwable -> L5
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
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
