package kotlinx.coroutines.rx2;

import androidx.exifinterface.media.ExifInterface;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.selects.l;

/* JADX INFO: loaded from: classes42.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.rx2.RxObservableCoroutine$registerSelectForSend$1", f = "RxObservable.kt", i = {}, l = {89}, m = "invokeSuspend", n = {}, s = {})
final class RxObservableCoroutine$registerSelectForSend$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ l<?> $select;
    int label;
    final /* synthetic */ RxObservableCoroutine<Object> this$0;

    public RxObservableCoroutine$registerSelectForSend$1(RxObservableCoroutine<Object> r100, l<?> r101, Continuation<? super RxObservableCoroutine$registerSelectForSend$1> r102) {
        this.this$0 = r100;
        this.$select = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new RxObservableCoroutine$registerSelectForSend$1(this.this$0, this.$select, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((RxObservableCoroutine$registerSelectForSend$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r101 = this.label;
        if (r101 == 0) goto L12;
        if (r101 != 1) goto L11;
        ResultKt.throwOnFailure(r100);
        l<?> r102 = this.$select;
        RxObservableCoroutine<Object> r103 = this.this$0;
        Unit r104 = Unit.INSTANCE;
        if (r102.f(r103, r104) == false) goto L8;
        return r104;
    L8:
        RxObservableCoroutine<Object> r105 = this.this$0;
        AtomicIntegerFieldUpdater r106 = RxObservableCoroutine.f505052d;
        r105.getClass();
        throw null;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        ResultKt.throwOnFailure(r100);
        RxObservableCoroutine<Object> r107 = this.this$0;
        AtomicIntegerFieldUpdater r108 = RxObservableCoroutine.f505052d;
        r107.getClass();
        this.label = 1;
        throw null;
    }
}
