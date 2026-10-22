package ey0;

import com.bytedance.live.datacontext.h;
import io.reactivex.disposables.Disposable;
import io.reactivex.k;
import java.util.concurrent.CancellationException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class c implements k<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Continuation f474784a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ h f474785b;

    @Override // io.reactivex.k
    public final void onSubscribe(Disposable r100) {
        Intrinsics.checkNotNullParameter(r100, "d");
    }

    @Override // io.reactivex.k
    public final void onComplete() {
        Continuation r100 = this.f474784a;
        CancellationException r101 = new CancellationException("DataContext is cleared");
        Result.Companion r102 = Result.Companion;
        r100.resumeWith(Result.m9449constructorimpl(ResultKt.createFailure(r101)));
    }

    @Override // io.reactivex.k
    public final void onError(Throwable r100) {
        Intrinsics.checkNotNullParameter(r100, "e");
        Continuation r101 = this.f474784a;
        Result.Companion r102 = Result.Companion;
        r101.resumeWith(Result.m9449constructorimpl(ResultKt.createFailure(r100)));
    }

    @Override // io.reactivex.k
    public final void onSuccess(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "t");
        b.a(this.f474784a, sh6.c.b((sh6.b) r100));
    }

    public c(SafeContinuation r100, h r101) {
        this.f474784a = r100;
        this.f474785b = r101;
    }
}
