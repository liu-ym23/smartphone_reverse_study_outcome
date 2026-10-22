package vp1;

import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;

/* JADX INFO: loaded from: classes8.dex */
public final class j implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g.e f556607a;

    public j(g.e r100) {
        this.f556607a = r100;
    }

    public final void a() {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L4
        g.e r101 = this.f556607a;     // Catch: Throwable -> L4
        g r102 = r101.f556601a;     // Catch: Throwable -> L4
        boolean r103 = r101.f556602b;     // Catch: Throwable -> L4
        boolean r104 = r101.f556603c;     // Catch: Throwable -> L4
        boolean r105 = r101.f556604d;     // Catch: Throwable -> L4
        int r106 = g.f556578n;     // Catch: Throwable -> L4
        r102.h(r103, r104, r105);     // Catch: Throwable -> L4
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
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
