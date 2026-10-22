package kotlinx.coroutines;

import androidx.exifinterface.media.ExifInterface;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes42.dex */
@Metadata(d1 = {"\u0000\b\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.InterruptibleKt$runInterruptible$2", f = "Interruptible.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class InterruptibleKt$runInterruptible$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<Object>, Object> {
    final /* synthetic */ Function0<Object> $block;
    private /* synthetic */ Object L$0;
    int label;

    public InterruptibleKt$runInterruptible$2(Function0<Object> r100, Continuation<? super InterruptibleKt$runInterruptible$2> r101) {
        this.$block = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        InterruptibleKt$runInterruptible$2 r102 = new InterruptibleKt$runInterruptible$2(this.$block, r101);
        r102.L$0 = r100;
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<Object> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<Object> r101) {
        return ((InterruptibleKt$runInterruptible$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L27;
        ResultKt.throwOnFailure(r100);
        CoroutineContext r101 = ((CoroutineScope) this.L$0).getCoroutineContext();
        Function0<Object> r102 = this.$block;
        Job r103 = JobKt.getJob(r101);     // Catch: InterruptedException -> L23
        y1 r104 = new y1(r103);     // Catch: InterruptedException -> L23
        r104.f505163c = JobKt.invokeOnCompletion(r103, true, true, r104);     // Catch: InterruptedException -> L23
        AtomicIntegerFieldUpdater r105 = y1.f505160d;     // Catch: InterruptedException -> L23
    L6:
        int r106 = r105.get(r104);     // Catch: InterruptedException -> L23
        if (r106 != 0) goto L9;
        if (y1.f505160d.compareAndSet(r104, r106, 0) == false) goto L6;
    L29:
        Object r107 = r102.invoke();     // Catch: Throwable -> L20
        r104.b();     // Catch: InterruptedException -> L23
        return r107;
    L20:
        th = move-exception;
        r104.b();     // Catch: InterruptedException -> L23
        throw th;     // Catch: InterruptedException -> L23
    L9:
        if (r106 == 2) goto L29;
        if (r106 == 3) goto L29;
        y1.c(r106);     // Catch: InterruptedException -> L23
        throw null;     // Catch: InterruptedException -> L23
    L23:
        e = move-exception;
        throw new CancellationException("Blocking call was interrupted due to parent cancellation").initCause(e);
    L27:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
