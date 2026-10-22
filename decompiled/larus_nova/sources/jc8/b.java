package jc8;

import android.view.View;
import android.view.ViewGroup;
import com.larus.im.FlowRuntime;
import jc8.a;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public abstract class b<T extends a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public k f498153a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f498154b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f498155c;

    public b() {
    }

    public void a() {
    }

    public void g(T r100) {
        Intrinsics.checkNotNullParameter(r100, "blockModel");
    }

    public void i() {
    }

    public String c() {
        return getClass().getSimpleName();
    }

    public final void b(a r100) {
        Intrinsics.checkNotNullParameter(r100, "blockModel");
        this.f498154b = r100.h();
        if (FlowRuntime.a().isDebug() == false) goto L12;
        g(r100);
    L10:
        a();
        return;
    L12:
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L7
        g(r100);     // Catch: Throwable -> L7
        Object r102 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L7
    L9:
        Result.m9448boximpl(r102);
    L7:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L9
    }

    public final d e(a r100) {
        Intrinsics.checkNotNullParameter(r100, "blockModel");
        if (FlowRuntime.a().isDebug() == false) goto L15;
        d r101 = f(r100);
    L14:
        return e.a(r100, r101);
    L15:
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L7
        Object r103 = Result.m9449constructorimpl(f(r100));     // Catch: Throwable -> L7
    L9:
        d r104 = new d(0, 0, 0, 0);
        if (Result.m9455isFailureimpl(r103) == false) goto L12;
        r103 = r104;
    L12:
        r101 = (d) r103;
    L7:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L9
    }

    public d f(T r100) {
        Intrinsics.checkNotNullParameter(r100, "blockModel");
        return new d(0, 0, 0, 0);
    }

    public View h(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "viewGroup");
        return new View(r100.getContext());
    }
}
