package io.github.alexzhirkevich.compottie.internal.animation.expressions;

import io.github.alexzhirkevich.compottie.internal.animation.k2;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public final class o implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f490834a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f f490835b;

    public o(String r100) {
        Intrinsics.checkNotNullParameter(r100, "expr");
        d r101 = new d();
        this.f490834a = r101;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L5
        Object r103 = Result.m9449constructorimpl(new ExpressionInterpreterImpl(r100, r101).c());     // Catch: Throwable -> L5
    L8:
        if (Result.m9455isFailureimpl(r103) == false) goto L10;
        r103 = null;
    L10:
        this.f490835b = (f) r103;
        return;
    L5:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.github.alexzhirkevich.compottie.internal.animation.expressions.n
    public final Object a(k2<?> r100, prc.f r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "state");
        if (((Boolean) r101.f530401k.getValue()).booleanValue() == false) goto L17;
        f r102 = this.f490835b;
        if (r102 == null) goto L17;
        Object r103 = null;
        r102.a(r100, this.f490834a, r101);     // Catch: Throwable -> L18
        Object r104 = this.f490834a.d("$bm_rt");     // Catch: Throwable -> L18
        if (r104 == null) goto L12;
        r103 = p.b(r104);     // Catch: Throwable -> L18
    L12:
        this.f490834a.e();
        if (r103 == null) goto L15;
        return r103;
    L15:
        return r100.d(r101);
    L17:
        return r100.d(r101);
    }
}
