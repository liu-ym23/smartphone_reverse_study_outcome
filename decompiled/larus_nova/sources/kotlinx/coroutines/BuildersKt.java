package kotlinx.coroutines;

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

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"kotlinx/coroutines/BuildersKt__BuildersKt", "kotlinx/coroutines/BuildersKt__Builders_commonKt"}, k = 4, mv = {1, 9, 0}, xi = 48)
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
    public static final <T> T runBlocking(CoroutineContext r100, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> r101) throws InterruptedException {
        Thread r102 = ThreadMethodProxy.currentThread();
        ContinuationInterceptor r103 = (ContinuationInterceptor) r100.get(ContinuationInterceptor.Key);
        if (r103 != null) goto L6;
        q0 r104 = v1.a();
        CoroutineContext r105 = CoroutineContextKt.c(GlobalScope.INSTANCE, r100.plus(r104));
    L9:
        d r106 = new d(r105, r102, r104);
        CoroutineStart.DEFAULT.invoke(r101, r106, r106);
        q0 r107 = r106.f504705e;     // Catch: Throwable -> L41
        if (r107 == null) goto L44;
        int r108 = q0.f505003d;     // Catch: Throwable -> L41
        r107.i(false);     // Catch: Throwable -> L41
    L44:
    L36:
        th = move-exception;
        q0 r109 = r106.f504705e;     // Catch: Throwable -> L41
        if (r109 == null) goto L40;
        int r110 = q0.f505003d;     // Catch: Throwable -> L41
        r109.d(false);     // Catch: Throwable -> L41
    L40:
        throw th;     // Catch: Throwable -> L41
    L14:
        if (Thread.interrupted() == true) goto L34;
        q0 r111 = r106.f504705e;     // Catch: Throwable -> L36
        if (r111 == null) goto L18;
        long r112 = r111.m();     // Catch: Throwable -> L36
    L20:
        if (r106.isCompleted() == true) goto L23;
        LockSupport.parkNanos(r106, r112);     // Catch: Throwable -> L36
        goto L44
    L23:
        q0 r113 = r106.f504705e;     // Catch: Throwable -> L41
        if (r113 == null) goto L26;
        int r114 = q0.f505003d;     // Catch: Throwable -> L41
        r113.d(false);     // Catch: Throwable -> L41
    L26:
        T r115 = (T) g1.a(r106.M());
        if ((r115 instanceof t) == false) goto L29;
        t r116 = (t) r115;
    L30:
        if (r116 != null) goto L33;
        return r115;
    L33:
        throw r116.f505148a;
    L29:
        r116 = null;
        goto L30
    L18:
        r112 = Long.MAX_VALUE;
        goto L20
    L34:
        InterruptedException r117 = new InterruptedException();     // Catch: Throwable -> L36
        r106.s(r117);     // Catch: Throwable -> L36
        throw r117;     // Catch: Throwable -> L36
    L41:
        th = move-exception;
        throw th;
    L6:
        if ((r103 instanceof q0) == false) goto L8;
        q0 r118 = (q0) r103;
    L8:
        r104 = v1.f505154a.get();
        r105 = CoroutineContextKt.c(GlobalScope.INSTANCE, r100);
        goto L9
    }

    public static final <T> Object invoke(CoroutineDispatcher r100, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> r101, Continuation<? super T> r102) {
        return withContext(r100, r101, r102);
    }

    public static final <T> Object withContext(CoroutineContext r100, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> r101, Continuation<? super T> r102) {
        CoroutineContext r103 = r102.getContext();
        boolean r104 = false;
        if (((Boolean) r100.fold(Boolean.FALSE, CoroutineContextKt$hasCopyableElements$1.INSTANCE)).booleanValue() == true) goto L5;
        CoroutineContext r105 = r103.plus(r100);
    L6:
        JobKt.ensureActive(r105);
        if (r105 != r103) goto L9;
        kotlinx.coroutines.internal.x r106 = new kotlinx.coroutines.internal.x(r105, r102);
        Object r107 = cuc.b.a(r106, r106, r101);
    L33:
        if (r107 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L35;
        DebugProbesKt.probeCoroutineSuspended(r102);
    L35:
        return r107;
    L9:
        ContinuationInterceptor.Key r108 = ContinuationInterceptor.Key;
        if (Intrinsics.areEqual(r105.get(r108), r103.get(r108)) == false) goto L17;
        b2 r109 = new b2(r105, r102);
        CoroutineContext r110 = r109.getContext();
        Object r111 = ThreadContextKt.c(r110, null);
        Object r112 = cuc.b.a(r109, r109, r101);     // Catch: Throwable -> L14
        ThreadContextKt.a(r110, r111);
        r107 = r112;
    L14:
        th = move-exception;
        ThreadContextKt.a(r110, r111);
        throw th;
    L17:
        h0 r113 = new h0(r105, r102);
        cuc.a.b(r101, r113, r113);
        AtomicIntegerFieldUpdater r114 = h0.f504920e;
    L18:
        int r115 = r114.get(r113);
        if (r115 != 0) goto L21;
        if (h0.f504920e.compareAndSet(r113, 0, 1) == false) goto L18;
        r104 = true;
    L28:
        if (r104 == false) goto L30;
        r107 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        goto L33
    L30:
        r107 = g1.a(r113.M());
        if ((r107 instanceof t) == false) goto L33;
        throw ((t) r107).f505148a;
    L21:
        if (r115 == 2) goto L28;
        throw new IllegalStateException("Already suspended".toString());
    L5:
        r105 = CoroutineContextKt.a(r103, r100, false);
        goto L6
    }

    public static final <T> Deferred<T> async(CoroutineScope r100, CoroutineContext r101, CoroutineStart r102, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> r103) {
        CoroutineContext r104 = CoroutineContextKt.c(r100, r101);
        if (r102.isLazy() == false) goto L5;
        Deferred<T> r105 = new h1(r104, r103);
    L6:
        r102.invoke(r103, r105, r105);
        return r105;
    L5:
        r105 = new e0(r104, true);
        goto L6
    }

    public static final Job launch(CoroutineScope r100, CoroutineContext r101, CoroutineStart r102, Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> r103) {
        CoroutineContext r104 = CoroutineContextKt.c(r100, r101);
        if (r102.isLazy() == false) goto L5;
        Job r105 = new i1(r104, r103);
    L6:
        r102.invoke(r103, r105, r105);
        return r105;
    L5:
        r105 = new r1(r104, true);
        goto L6
    }

    public static /* synthetic */ Object runBlocking$default(CoroutineContext r100, Function2 r101, int r102, Object r103) throws InterruptedException {
        if ((r102 & 1) == 0) goto L6;
        r100 = EmptyCoroutineContext.INSTANCE;
    L6:
        return runBlocking(r100, r101);
    }

    public static /* synthetic */ Deferred async$default(CoroutineScope r100, CoroutineContext r101, CoroutineStart r102, Function2 r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = EmptyCoroutineContext.INSTANCE;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = CoroutineStart.DEFAULT;
    L9:
        return async(r100, r101, r102, r103);
    }

    public static /* synthetic */ Job launch$default(CoroutineScope r100, CoroutineContext r101, CoroutineStart r102, Function2 r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = EmptyCoroutineContext.INSTANCE;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = CoroutineStart.DEFAULT;
    L9:
        return launch(r100, r101, r102, r103);
    }
}
