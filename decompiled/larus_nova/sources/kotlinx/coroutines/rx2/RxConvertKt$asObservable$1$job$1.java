package kotlinx.coroutines.rx2;

import androidx.exifinterface.media.ExifInterface;
import io.reactivex.ObservableEmitter;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: classes42.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.rx2.RxConvertKt$asObservable$1$job$1", f = "RxConvert.kt", i = {0}, l = {110}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
final class RxConvertKt$asObservable$1$job$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ObservableEmitter<Object> $emitter;
    final /* synthetic */ Flow<Object> $this_asObservable;
    private /* synthetic */ Object L$0;
    int label;

    public static final class a<T> implements FlowCollector {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ObservableEmitter<T> f505051a;

        public a(ObservableEmitter<T> r100) {
            this.f505051a = r100;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        public final Object emit(T r100, Continuation<? super Unit> r101) {
            this.f505051a.onNext(r100);
            return Unit.INSTANCE;
        }
    }

    public RxConvertKt$asObservable$1$job$1(Flow<Object> r100, ObservableEmitter<Object> r101, Continuation<? super RxConvertKt$asObservable$1$job$1> r102) {
        this.$this_asObservable = r100;
        this.$emitter = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        RxConvertKt$asObservable$1$job$1 r102 = new RxConvertKt$asObservable$1$job$1(this.$this_asObservable, this.$emitter, r101);
        r102.L$0 = r100;
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((RxConvertKt$asObservable$1$job$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L12;
        if (r102 != 1) goto L11;
        CoroutineScope r103 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r100);     // Catch: Throwable -> L8
    L17:
        this.$emitter.onComplete();     // Catch: Throwable -> L8
    L28:
        return Unit.INSTANCE;
    L8:
        Throwable th10 = th;
    L22:
        if ((th10 instanceof CancellationException) == false) goto L24;
        this.$emitter.onComplete();
        goto L28
    L24:
        if (this.$emitter.tryOnError(th10) == true) goto L28;
        b.a(th10, r103.getCoroutineContext());
        goto L28
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        ResultKt.throwOnFailure(r100);
        CoroutineScope r104 = (CoroutineScope) this.L$0;
        Flow<Object> r105 = this.$this_asObservable;     // Catch: Throwable -> L19
        a r106 = new a(this.$emitter);     // Catch: Throwable -> L19
        this.L$0 = r104;     // Catch: Throwable -> L19
        this.label = 1;     // Catch: Throwable -> L19
        if (r105.collect(r106, this) != r101) goto L16;
        return r101;
    L16:
        r103 = r104;
    L19:
        th = move-exception;
        r103 = r104;
        th10 = th;
        goto L22
    }
}
