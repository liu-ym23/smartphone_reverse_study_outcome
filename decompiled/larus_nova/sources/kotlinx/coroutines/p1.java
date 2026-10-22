package kotlinx.coroutines;

import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes42.dex */
public final class p1 extends f1 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Continuation<Unit> f505002e;

    public p1(j r100) {
        this.f505002e = r100;
    }

    @Override // kotlinx.coroutines.z0
    public final void a(Throwable r100) {
        Continuation<Unit> r101 = this.f505002e;
        Result.Companion r102 = Result.Companion;
        r101.resumeWith(Result.m9449constructorimpl(Unit.INSTANCE));
    }
}
