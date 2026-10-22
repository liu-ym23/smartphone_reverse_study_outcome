package zib;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.statistics.Statistics;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import z5c.u3;

/* JADX INFO: loaded from: classes36.dex */
public final class i implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f572345a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f572346b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ s5c.d f572347c;

    public i(boolean r100, long r101, s5c.a r102) {
        this.f572345a = r100;
        this.f572346b = r101;
        this.f572347c = r102;
    }

    public final void a() {
        boolean r100 = this.f572345a;
        long r101 = this.f572346b;
        s5c.d r102 = this.f572347c;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L5
        s5c.a r104 = l.f572350c.a(String.valueOf(r100));     // Catch: Throwable -> L5
        s5c.a r105 = u3.f570385c.a(String.valueOf(r101));     // Catch: Throwable -> L5
        Statistics.sendEvent("forward_mention_request", r102.plus(r104).plus(r105).toJson());     // Catch: Throwable -> L5
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
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
