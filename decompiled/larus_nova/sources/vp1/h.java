package vp1;

import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;

/* JADX INFO: loaded from: classes8.dex */
public final class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g.b f556605a;

    public h(g.b r100) {
        this.f556605a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L4
        g.b r101 = this.f556605a;     // Catch: Throwable -> L4
        g r102 = r101.f556592a;     // Catch: Throwable -> L4
        boolean r103 = r101.f556593b;     // Catch: Throwable -> L4
        boolean r104 = r101.f556594c;     // Catch: Throwable -> L4
        boolean r105 = r101.f556595d;     // Catch: Throwable -> L4
        int r106 = g.f556578n;     // Catch: Throwable -> L4
        r102.f(r103, r104, r105);     // Catch: Throwable -> L4
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        Result.Companion r107 = Result.Companion;     // Catch: Throwable -> L7
        Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L11;
        return;
    L11:
        throw th;
    }
}
