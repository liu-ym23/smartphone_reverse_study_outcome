package kotlinx.coroutines;

import android.util.EventsUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.ThreadContextKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"kotlinx/coroutines/BuildersKt__BuildersKt", "kotlinx/coroutines/BuildersKt__Builders_commonKt"}, k = 4, mv = {1, 9, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
public final class BuildersKt {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public static final <T> T runBlocking(CoroutineContext r3, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> r4) throws InterruptedException {
        Thread r0 = ThreadMethodProxy.currentThread();
        ContinuationInterceptor r1 = (ContinuationInterceptor) r3.get(ContinuationInterceptor.Key);
        if (r1 != null) goto L6;
        q0 r2 = v1.a();
        CoroutineContext r5 = CoroutineContextKt.c(GlobalScope.INSTANCE, r3.plus(r2));
    L9:
        d r6 = new d(r5, r0, r2);
        CoroutineStart.DEFAULT.invoke(r4, r6, r6);
        q0 r7 = r6.e;     // Catch: Throwable -> L41
        if (r7 == null) goto L44;
        int r8 = q0.d;     // Catch: Throwable -> L41
        r7.i(false);     // Catch: Throwable -> L41
    L44:
    L36:
        th = move-exception;
        q0 r9 = r6.e;     // Catch: Throwable -> L41
        if (r9 == null) goto L40;
        int r10 = q0.d;     // Catch: Throwable -> L41
        r9.d(false);     // Catch: Throwable -> L41
    L40:
        throw th;     // Catch: Throwable -> L41
    L14:
        if (Thread.interrupted() == true) goto L34;
        q0 r11 = r6.e;     // Catch: Throwable -> L36
        if (r11 == null) goto L18;
        long r12 = r11.m();     // Catch: Throwable -> L36
    L20:
        if (r6.isCompleted() == true) goto L23;
        LockSupport.parkNanos(r6, r12);     // Catch: Throwable -> L36
        goto L44
    L23:
        q0 r13 = r6.e;     // Catch: Throwable -> L41
        if (r13 == null) goto L26;
        int r14 = q0.d;     // Catch: Throwable -> L41
        r13.d(false);     // Catch: Throwable -> L41
    L26:
        T r15 = (T) g1.a(r6.M());
        if ((r15 instanceof t) == false) goto L29;
        t r16 = (t) r15;
    L30:
        if (r16 != null) goto L33;
        return r15;
    L33:
        throw r16.a;
    L29:
        r16 = null;
        goto L30
    L18:
        r12 = Long.MAX_VALUE;
        goto L20
    L34:
        InterruptedException r17 = new InterruptedException();     // Catch: Throwable -> L36
        r6.s(r17);     // Catch: Throwable -> L36
        throw r17;     // Catch: Throwable -> L36
    L41:
        th = move-exception;
        throw th;
    L6:
        if ((r1 instanceof q0) == false) goto L8;
        q0 r18 = (q0) r1;
    L8:
        r2 = v1.a.get();
        r5 = CoroutineContextKt.c(GlobalScope.INSTANCE, r3);
        goto L9
    }

    public static final <T> Object invoke(CoroutineDispatcher r0, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> r1, Continuation<? super T> r2) {
        return withContext(r0, r1, r2);
    }

    public static final <T> Object withContext(CoroutineContext r4, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> r5, Continuation<? super T> r6) {
        CoroutineContext r0 = r6.getContext();
        boolean r2 = false;
        if (((Boolean) r4.fold(Boolean.FALSE, CoroutineContextKt$hasCopyableElements$1.INSTANCE)).booleanValue() == true) goto L5;
        CoroutineContext r7 = r0.plus(r4);
    L6:
        JobKt.ensureActive(r7);
        if (r7 != r0) goto L9;
        kotlinx.coroutines.internal.x r1 = new kotlinx.coroutines.internal.x(r7, r6);
        Object r8 = cuc.b.a(r1, r1, r5);
    L33:
        if (r8 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L35;
        DebugProbesKt.probeCoroutineSuspended(r6);
    L35:
        return r8;
    L9:
        ContinuationInterceptor.Key r3 = ContinuationInterceptor.Key;
        if (Intrinsics.areEqual(r7.get(r3), r0.get(r3)) == false) goto L17;
        b2 r9 = new b2(r7, r6);
        CoroutineContext r10 = r9.getContext();
        Object r11 = ThreadContextKt.c(r10, null);
        Object r12 = cuc.b.a(r9, r9, r5);     // Catch: Throwable -> L14
        ThreadContextKt.a(r10, r11);
        r8 = r12;
    L14:
        th = move-exception;
        ThreadContextKt.a(r10, r11);
        throw th;
    L17:
        h0 r13 = new h0(r7, r6);
        cuc.a.b(r5, r13, r13);
        AtomicIntegerFieldUpdater r14 = h0.e;
    L18:
        int r15 = r14.get(r13);
        if (r15 != 0) goto L21;
        if (h0.e.compareAndSet(r13, 0, 1) == false) goto L18;
        r2 = true;
    L28:
        if (r2 == false) goto L30;
        r8 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        goto L33
    L30:
        r8 = g1.a(r13.M());
        if ((r8 instanceof t) == false) goto L33;
        throw ((t) r8).a;
    L21:
        if (r15 == 2) goto L28;
        throw new IllegalStateException("Already suspended".toString());
    L5:
        r7 = CoroutineContextKt.a(r0, r4, false);
        goto L6
    }

    public static final <T> Deferred<T> async(CoroutineScope r1, CoroutineContext r2, CoroutineStart r3, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> r4) {
        CoroutineContext r5 = CoroutineContextKt.c(r1, r2);
        if (r3.isLazy() == false) goto L5;
        h1 r6 = new h1(r5, r4);
    L6:
        r3.invoke(r4, r6, r6);
        return r6;
    L5:
        r6 = new e0(r5, true);
        goto L6
    }

    public static final Job launch(CoroutineScope r1, CoroutineContext r2, CoroutineStart r3, Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> r4) {
        CoroutineContext r5 = CoroutineContextKt.c(r1, r2);
        if (r3.isLazy() == false) goto L5;
        i1 r6 = new i1(r5, r4);
    L6:
        r3.invoke(r4, r6, r6);
        return r6;
    L5:
        r6 = new r1(r5, true);
        goto L6
    }

    public static /* synthetic */ Object runBlocking$default(CoroutineContext r0, Function2 r1, int r2, Object r3) throws InterruptedException {
        if ((r2 & 1) == 0) goto L6;
        r0 = EmptyCoroutineContext.INSTANCE;
    L6:
        return runBlocking(r0, r1);
    }

    public static /* synthetic */ Deferred async$default(CoroutineScope r0, CoroutineContext r1, CoroutineStart r2, Function2 r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = EmptyCoroutineContext.INSTANCE;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = CoroutineStart.DEFAULT;
    L9:
        return async(r0, r1, r2, r3);
    }

    public static /* synthetic */ Job launch$default(CoroutineScope r0, CoroutineContext r1, CoroutineStart r2, Function2 r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = EmptyCoroutineContext.INSTANCE;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = CoroutineStart.DEFAULT;
    L9:
        return launch(r0, r1, r2, r3);
    }
}
