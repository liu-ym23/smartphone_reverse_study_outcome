package io.ktor.util.pipeline;

import com.ss.android.lark.utils.statistics.PerfLog;
import io.ktor.util.KtorDsl;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes41.dex */
@KtorDsl
public abstract class b<TSubject, TContext> implements CoroutineScope {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TContext f491975a;

    public abstract Object a(Unit r100, Continuation r101);

    public abstract void b();

    public abstract TSubject c();

    public abstract Object d(Continuation<? super TSubject> r100);

    public abstract Object e(TSubject r100, Continuation<? super TSubject> r101);

    public final TContext getContext() {
        return this.f491975a;
    }

    public b(TContext r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f491975a = r100;
    }
}
