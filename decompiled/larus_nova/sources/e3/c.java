package e3;

import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;

/* JADX INFO: loaded from: classes43.dex */
public final class c<T> implements f<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public T f470894a;

    @Override // e3.f
    public final void release() {
        T r100 = this.f470894a;
        if ((r100 instanceof b) == true) goto L10;
    L8:
        this.f470894a = null;
        return;
    L10:
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L6
        ((b) r100).a();     // Catch: Throwable -> L6
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        Result.Companion r102 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    @Override // e3.f
    public final T provideInstance() {
        return this.f470894a;
    }

    public c(T r100) {
        this.f470894a = r100;
    }
}
