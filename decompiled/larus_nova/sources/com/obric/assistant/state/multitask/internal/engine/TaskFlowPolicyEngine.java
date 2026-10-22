package com.obric.assistant.state.multitask.internal.engine;

import android.os.SystemClock;
import com.obric.assistant.state.multitask.core.TaskFlowAsyncObserver;
import com.obric.assistant.state.multitask.core.TaskFlowCriticalResolver;
import com.obric.assistant.state.multitask.core.TaskFlowInterceptor;
import java.util.Iterator;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CopyOnWriteArrayList;
import jha.g;
import jha.q;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.internal.e0;

/* JADX INFO: loaded from: classes4.dex */
public final class TaskFlowPolicyEngine {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f393310e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CopyOnWriteArrayList<TaskFlowInterceptor> f393311a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CopyOnWriteArrayList<TaskFlowCriticalResolver> f393312b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CopyOnWriteArrayList<TaskFlowAsyncObserver> f393313c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CoroutineScope f393314d;

    public static final class a {
    }

    static {
    }

    public TaskFlowPolicyEngine() {
        this.f393311a = new CopyOnWriteArrayList();
        this.f393312b = new CopyOnWriteArrayList();
        this.f393313c = new CopyOnWriteArrayList();
        this.f393314d = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getDefault()));
    }

    public final void a(g<?> r110, q<?> r111, long r112) {
        Intrinsics.checkNotNullParameter(r110, "id");
        Intrinsics.checkNotNullParameter(r111, "event");
        if (this.f393313c.isEmpty() == false) goto L5;
        return;
    L5:
        BuildersKt.launch$default(this.f393314d, null, null, new TaskFlowPolicyEngine$executeAsyncObservers$1(this, r110, r111, r112, null), 3, null);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x00ae -> B:54:0x00bc). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x00e1 -> B:39:0x00f2). Please report as a decompilation issue!!! */
    public final Object b(g<?> r210, q<?> r211, long r212, Continuation<? super Boolean> r310) {
        if ((r310 instanceof TaskFlowPolicyEngine$executeCriticalResolvers$1) == false) goto L7;
        TaskFlowPolicyEngine$executeCriticalResolvers$1 r100 = (TaskFlowPolicyEngine$executeCriticalResolvers$1) r310;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        if (r104 == 0) goto L20;
        if (r104 != 1) goto L19;
        long r105 = r100.J$1;
        long r106 = r100.J$0;
        TaskFlowCriticalResolver r107 = (TaskFlowCriticalResolver) r100.L$4;
        Iterator<TaskFlowCriticalResolver> r110 = (Iterator) r100.L$3;
        Ref.BooleanRef r111 = (Ref.BooleanRef) r100.L$2;
        q<?> r112 = (q) r100.L$1;
        g<?> r113 = (g) r100.L$0;
        ResultKt.throwOnFailure(r102);     // Catch: Throwable -> L14 CancellationException -> L16
    L54:
        Result.Companion r108 = Result.Companion;     // Catch: CancellationException -> L16 Throwable -> L32
        Object r109 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: CancellationException -> L16 Throwable -> L32
        TaskFlowPolicyEngine$executeCriticalResolvers$1 r114 = r100;
        TaskFlowCriticalResolver r115 = r107;
        Ref.BooleanRef r116 = r111;
        g<?> r117 = r113;
        Iterator<TaskFlowCriticalResolver> r118 = r110;
        Object r119 = r103;
        q<?> r120 = r112;
    L39:
        long r121 = SystemClock.elapsedRealtime() - r105;
        Intrinsics.checkNotNull(r115);
        Object r122 = r109;
        c("critical_submit_completed", r115, r122, Boxing.boxLong(r121), r120, r106);
        if (r116.element == true) goto L42;
    L44:
        boolean r123 = false;
    L45:
        r116.element = r123;
        long r124 = r106;
        Object r125 = r119;
        r110 = r118;
        TaskFlowPolicyEngine$executeCriticalResolvers$1 r126 = r114;
    L22:
        if (r110.hasNext() == false) goto L48;
        TaskFlowCriticalResolver r127 = r110.next();
        long r128 = SystemClock.elapsedRealtime();
        jha.b r129 = jha.b.f499120a;     // Catch: CancellationException -> L16 Throwable -> L36
        ThreadLocal<Boolean> r130 = jha.b.f499122c;     // Catch: CancellationException -> L16 Throwable -> L36
        CoroutineContext r131 = CoroutineContext.Element.DefaultImpls.plus(r129, new e0(Boolean.TRUE, r130));     // Catch: CancellationException -> L16 Throwable -> L36
        TaskFlowPolicyEngine$executeCriticalResolvers$2$outcome$1 r132 = new TaskFlowPolicyEngine$executeCriticalResolvers$2$outcome$1(r127, r117, r120, null);     // Catch: CancellationException -> L16 Throwable -> L36
        r126.L$0 = r117;     // Catch: CancellationException -> L16 Throwable -> L36
        r126.L$1 = r120;     // Catch: CancellationException -> L16 Throwable -> L36
        r126.L$2 = r116;     // Catch: CancellationException -> L16 Throwable -> L36
        r126.L$3 = r110;     // Catch: CancellationException -> L16 Throwable -> L36
        r126.L$4 = r127;     // Catch: CancellationException -> L16 Throwable -> L36
        r126.J$0 = r124;     // Catch: CancellationException -> L16 Throwable -> L36
        r126.J$1 = r128;     // Catch: CancellationException -> L16 Throwable -> L36
        r126.label = 1;     // Catch: CancellationException -> L16 Throwable -> L34
        if (BuildersKt.withContext(r131, r132, r126) != r125) goto L29;
        return r125;
    L29:
        r113 = r117;
        r112 = r120;
        r100 = r126;
        r103 = r125;
        r106 = r124;
        r105 = r128;
        r111 = r116;
        r107 = r127;
    L34:
        Throwable th10 = th;
    L38:
        Result.Companion r133 = Result.Companion;
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th10));
        r114 = r126;
        r115 = r127;
        r118 = r110;
        r119 = r125;
        r106 = r124;
        r105 = r128;
    L36:
        th10 = th;
        goto L38
    L48:
        return Boxing.boxBoolean(r116.element);
    L42:
        if (Result.m9456isSuccessimpl(r109) == false) goto L44;
        r123 = true;
        goto L45
    L32:
        th10 = th;
    L33:
        long r213 = r106;
        r126 = r100;
        r125 = r103;
        r120 = r112;
        r117 = r113;
        r128 = r105;
        r124 = r213;
        Ref.BooleanRef r214 = r111;
        r127 = r107;
        r116 = r214;
    L16:
        e = move-exception;
        throw e;
    L14:
        th10 = th;
        goto L33
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L20:
        ResultKt.throwOnFailure(r102);
        Ref.BooleanRef r134 = new Ref.BooleanRef();
        r134.element = true;
        r124 = r212;
        r126 = r100;
        r125 = r103;
        r110 = this.f393312b.iterator();
        r117 = r210;
        r120 = r211;
        r116 = r134;
    L7:
        r100 = new TaskFlowPolicyEngine$executeCriticalResolvers$1(this, r310);
        goto L8
    }

    public static void c(final String r100, Object r110, Object r111, Long r112, final q r113, final long r114) {
        if (Result.m9456isSuccessimpl(r111) == false) goto L14;
        StringBuilder r101 = new StringBuilder("success:");
        r101.append(r110.getClass().getName());
        if (r112 == null) goto L12;
        r101.append(":");
        r101.append(r112.longValue());
        r101.append("ms");
        if (r112.longValue() < 5) goto L10;
        r101.append(":slow_error");
        goto L12
    L10:
        if (r112.longValue() < 2) goto L12;
        r101.append(":slow_warn");
    L12:
        String r115 = r101.toString();
    L13:
        final String r102 = r115;
        Function0 r116 = new c(r100, r102, r114, r113);
        if (Result.m9455isFailureimpl(r111) == true) goto L26;
        if (r112 != null) goto L23;
    L25:
        com.obric.assistant.state.multitask.b.f393276a.getClass();
        com.obric.assistant.state.multitask.b.a.a(r116);
        return;
    L23:
        if (r112.longValue() < 5) goto L25;
    L26:
        com.obric.assistant.state.multitask.b.f393276a.getClass();
        Intrinsics.checkNotNullParameter(r116, "eventBuilder");
        com.obric.assistant.state.multitask.b r103 = com.obric.assistant.state.multitask.c.f393279a;
        com.obric.assistant.state.multitask.b r104 = com.obric.assistant.state.multitask.c.f393279a;
        if (r104.isEnabled() == false) goto L31;
        r104.b((com.obric.assistant.state.multitask.a) r116.invoke());
        return;
    L31:
        return;
    L14:
        StringBuilder r105 = new StringBuilder("failure:");
        r105.append(r110.getClass().getName());
        r105.append(':');
        Throwable r117 = Result.m9452exceptionOrNullimpl(r111);
        if (r117 == null) goto L17;
        String r118 = r117.getClass().getSimpleName();
    L18:
        r105.append(r118);
        r115 = r105.toString();
        goto L13
    L17:
        r118 = null;
        goto L18
    }
}
