package zib;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.statistics.Statistics;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import z5c.o1;
import z5c.p1;

/* JADX INFO: loaded from: classes36.dex */
public final class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f572343a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f572344b;

    public h(boolean r100) {
        this.f572343a = r100;
        this.f572344b = true;
    }

    public final void a() {
        boolean r100 = this.f572343a;
        boolean r101 = this.f572344b;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L5
        Statistics.sendEvent("im_msg_select_forward_mention_click", s5c.d.b.b(p1.f570280c.a(String.valueOf(r100)), o1.f570269c.a(String.valueOf(r101))).toJson());     // Catch: Throwable -> L5
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
