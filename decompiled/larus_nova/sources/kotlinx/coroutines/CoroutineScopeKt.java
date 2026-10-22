package kotlinx.coroutines;

import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000F\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\b\u001a\u0006\u0010\t\u001a\u00020\u0002\u001aJ\u0010\n\u001a\u0002H\u000b\"\u0004\b\u0000\u0010\u000b2'\u0010\f\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000b0\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\r¢\u0006\u0002\b\u0010H\u0086@\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\u0011\u001a\u000e\u0010\u0012\u001a\u00020\bH\u0086H¢\u0006\u0002\u0010\u0013\u001a\u001e\u0010\u0014\u001a\u00020\u0015*\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u001a\u001c\u0010\u0014\u001a\u00020\u0015*\u00020\u00022\u0010\b\u0002\u0010\u0018\u001a\n\u0018\u00010\u001aj\u0004\u0018\u0001`\u001b\u001a\n\u0010\u001c\u001a\u00020\u0015*\u00020\u0002\u001a\u0015\u0010\u001d\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\bH\u0086\u0002\"\u001b\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0000\u0010\u0005¨\u0006\u001e"}, d2 = {"isActive", "", "Lkotlinx/coroutines/CoroutineScope;", "isActive$annotations", "(Lkotlinx/coroutines/CoroutineScope;)V", "(Lkotlinx/coroutines/CoroutineScope;)Z", "CoroutineScope", PerfLog.PARAM_KEY_CONTEXT_ID, "Lkotlin/coroutines/CoroutineContext;", "MainScope", "coroutineScope", "R", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "currentCoroutineContext", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cancel", "", "message", "", "cause", "", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "ensureActive", "plus", "kotlinx-coroutines-core"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class CoroutineScopeKt {
    public static /* synthetic */ void isActive$annotations(CoroutineScope r100) {
    }

    public static final CoroutineScope MainScope() {
        return new kotlinx.coroutines.internal.f(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getMain()));
    }

    public static final CoroutineScope CoroutineScope(CoroutineContext r100) {
        if (r100.get(Job.Key) != null) goto L7;
        r100 = r100.plus(JobKt.Job$default(null, 1, null));
    L7:
        return new kotlinx.coroutines.internal.f(r100);
    }

    public static final Object currentCoroutineContext(Continuation<? super CoroutineContext> r100) {
        return r100.getContext();
    }

    private static final Object currentCoroutineContext$$forInline(Continuation<? super CoroutineContext> r100) {
        InlineMarker.mark(3);
        throw null;
    }

    public static final void ensureActive(CoroutineScope r100) {
        JobKt.ensureActive(r100.getCoroutineContext());
    }

    public static final boolean isActive(CoroutineScope r100) {
        Job r101 = (Job) r100.getCoroutineContext().get(Job.Key);
        if (r101 != null) goto L7;
        return true;
    L7:
        return r101.isActive();
    }

    public static final void cancel(CoroutineScope r100, CancellationException r101) {
        Job r102 = (Job) r100.getCoroutineContext().get(Job.Key);
        if (r102 == null) goto L7;
        r102.cancel(r101);
        return;
    L7:
        throw new IllegalStateException(("Scope cannot be cancelled because it does not have a job: " + r100).toString());
    }

    public static final <R> Object coroutineScope(Function2<? super CoroutineScope, ? super Continuation<? super R>, ? extends Object> r100, Continuation<? super R> r101) {
        kotlinx.coroutines.internal.x r102 = new kotlinx.coroutines.internal.x(r101.getContext(), r101);
        Object r103 = cuc.b.a(r102, r102, r100);
        if (r103 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r101);
    L5:
        return r103;
    }

    public static final CoroutineScope plus(CoroutineScope r100, CoroutineContext r101) {
        return new kotlinx.coroutines.internal.f(r100.getCoroutineContext().plus(r101));
    }

    public static final void cancel(CoroutineScope r100, String r101, Throwable r102) {
        cancel(r100, u0.a(r101, r102));
    }

    public static /* synthetic */ void cancel$default(CoroutineScope r100, CancellationException r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L5;
        r101 = null;
    L5:
        cancel(r100, r101);
    }

    public static /* synthetic */ void cancel$default(CoroutineScope r100, String r101, Throwable r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L5;
        r102 = null;
    L5:
        cancel(r100, r101, r102);
    }
}
