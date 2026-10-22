package io.ktor.util.pipeline;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.ktor.utils.io.ExceptionUtilsJvmKt;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public final class g<TSubject, TContext> extends b<TSubject, TContext> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<Function3<b<TSubject, TContext>, TSubject, Continuation<? super Unit>, Object>> f491981b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final f f491982c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TSubject f491983d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Continuation<TSubject>[] f491984e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f491985f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f491986g;

    @Override // io.ktor.util.pipeline.b
    public final void b() {
        this.f491986g = this.f491981b.size();
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public final CoroutineContext getCoroutineContext() {
        return this.f491982c.getContext();
    }

    @Override // io.ktor.util.pipeline.b
    public final TSubject c() {
        return this.f491983d;
    }

    @Override // io.ktor.util.pipeline.b
    public final Object d(Continuation<? super TSubject> r100) {
        if (this.f491986g != this.f491981b.size()) goto L5;
        Object r101 = this.f491983d;
    L14:
        if (r101 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L16;
        DebugProbesKt.probeCoroutineSuspended(r100);
    L16:
        return r101;
    L5:
        Continuation<TSubject> r102 = IntrinsicsKt.intercepted(r100);
        Intrinsics.checkNotNullParameter(r102, "continuation");
        Continuation<TSubject>[] r103 = this.f491984e;
        int r104 = this.f491985f + 1;
        this.f491985f = r104;
        r103[r104] = r102;
        if (f(true) == false) goto L12;
        int r105 = this.f491985f;
        if (r105 < 0) goto L11;
        Continuation<TSubject>[] r106 = this.f491984e;
        this.f491985f = r105 - 1;
        r106[r105] = null;
        r101 = this.f491983d;
        goto L14
    L11:
        throw new IllegalStateException("No more continuations to resume");
    L12:
        r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        goto L14
    }

    public final boolean f(boolean r100) {
    L2:
        int r101 = this.f491986g;
        if (r101 == this.f491981b.size()) goto L4;
        this.f491986g = r101 + 1;
        Function3 r102 = (Function3) ListProtector.get(this.f491981b, r101);
        if (r102.invoke(this, this.f491983d, this.f491982c) != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L2;
        return false;
    L13:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        g(Result.m9449constructorimpl(ResultKt.createFailure(th)));
        return false;
    L4:
        if (r100 == true) goto L7;
        Result.Companion r104 = Result.Companion;
        g(Result.m9449constructorimpl(this.f491983d));
        return false;
    L7:
        return true;
    }

    public final void g(Object r100) {
        int r101 = this.f491985f;
        if (r101 < 0) goto L21;
        Continuation<TSubject> r102 = this.f491984e[r101];
        Intrinsics.checkNotNull(r102);
        Continuation<TSubject>[] r103 = this.f491984e;
        int r104 = this.f491985f;
        this.f491985f = r104 - 1;
        r103[r104] = null;
        if (Result.m9455isFailureimpl(r100) == true) goto L7;
        r102.resumeWith(r100);
        return;
    L7:
        Throwable r105 = Result.m9452exceptionOrNullimpl(r100);
        Intrinsics.checkNotNull(r105);
        Intrinsics.checkNotNullParameter(r105, com.bytedance.android.ec.core.event.a.KEY_EXCEPTION);
        Intrinsics.checkNotNullParameter(r102, "continuation");
        Throwable r106 = r105.getCause();     // Catch: Throwable -> L22
        Intrinsics.checkNotNullParameter(r105, "<this>");     // Catch: Throwable -> L22
        if (r106 == null) goto L18;
        if (Intrinsics.areEqual(r105.getCause(), r106) == true) goto L18;
        Throwable r107 = ExceptionUtilsJvmKt.b(r105, r106);     // Catch: Throwable -> L22
        if (r107 == null) goto L18;
        r107.setStackTrace(r105.getStackTrace());     // Catch: Throwable -> L22
        r105 = r107;
    L18:
        Result.Companion r108 = Result.Companion;
        r102.resumeWith(Result.m9449constructorimpl(ResultKt.createFailure(r105)));
        return;
    L21:
        throw new IllegalStateException("No more continuations to resume".toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.ktor.util.pipeline.b
    public final Object a(Unit r100, Continuation r101) {
        this.f491986g = 0;
        if (this.f491981b.size() != 0) goto L5;
        return r100;
    L5:
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f491983d = r100;
        if (this.f491985f >= 0) goto L10;
        return d(r101);
    L10:
        throw new IllegalStateException("Already started");
    }

    @Override // io.ktor.util.pipeline.b
    public final Object e(TSubject r100, Continuation<? super TSubject> r101) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f491983d = r100;
        return d(r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public g(Unit r100, Object r101, List r102) {
        Intrinsics.checkNotNullParameter(r100, "initial");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "blocks");
        super(r101);
        this.f491981b = r102;
        this.f491982c = new f(this);
        this.f491983d = r100;
        this.f491984e = new Continuation[r102.size()];
        this.f491985f = -1;
    }
}
