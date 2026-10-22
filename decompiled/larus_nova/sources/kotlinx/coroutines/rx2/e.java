package kotlinx.coroutines.rx2;

import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.plugins.RxJavaPlugins;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.a1;

/* JADX INFO: loaded from: classes42.dex */
public final class e {
    /* JADX WARN: Type inference failed for: r5v4, types: [T, kotlinx.coroutines.m0] */
    public static final Disposable a(CoroutineScope r100, Runnable r101, long r102, Function1 r103) {
        CoroutineContext r104 = r100.getCoroutineContext();
        final Ref.ObjectRef r105 = new Ref.ObjectRef();
        Disposable r106 = Disposables.fromRunnable(new d(r105));
        Runnable r107 = (Runnable) r103.invoke(new RxSchedulerKt$scheduleTask$toSchedule$1(r106, r104, RxJavaPlugins.onSchedule(r101)));
        if (CoroutineScopeKt.isActive(r100) == true) goto L6;
        return Disposables.disposed();
    L6:
        if (r102 > 0) goto L8;
        r107.run();
        return r106;
    L8:
        r105.element = DelayKt.getDelay(r104).invokeOnTimeout(r102, r107, r104);
        return r106;
    }

    public static final Object b(Disposable r100, CoroutineContext r101, final Runnable r102, Continuation r103) {
        if ((r103 instanceof RxSchedulerKt$scheduleTask$task$1) == false) goto L7;
        RxSchedulerKt$scheduleTask$task$1 r104 = (RxSchedulerKt$scheduleTask$task$1) r103;
        int r105 = r104.label;
        if ((r105 & Integer.MIN_VALUE) == 0) goto L7;
        r104.label = r105 - Integer.MIN_VALUE;
    L8:
        Object r106 = r104.result;
        Object r107 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r108 = r104.label;
        if (r108 == 0) goto L16;
        if (r108 != 1) goto L15;
        r101 = (CoroutineContext) r104.L$0;
        ResultKt.throwOnFailure(r106);     // Catch: Throwable -> L22
    L26:
    L25:
        return Unit.INSTANCE;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r106);
        if (r100.isDisposed() == true) goto L29;
        Function0<Unit> r109 = new RxSchedulerKt$scheduleTask$task$2(r102);     // Catch: Throwable -> L22
        r104.L$0 = r101;     // Catch: Throwable -> L22
        r104.label = 1;     // Catch: Throwable -> L22
        if (a1.a(r109, r104) != r107) goto L26;
        return r107;
    L29:
        return Unit.INSTANCE;
    L22:
        th = move-exception;
        b.a(th, r101);
    L7:
        r104 = new RxSchedulerKt$scheduleTask$task$1(r103);
        goto L8
    }
}
