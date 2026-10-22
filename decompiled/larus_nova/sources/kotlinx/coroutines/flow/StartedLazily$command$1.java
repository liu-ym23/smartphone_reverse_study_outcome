package kotlinx.coroutines.flow;

import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lkotlinx/coroutines/flow/SharingCommand;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.StartedLazily$command$1", f = "SharingStarted.kt", i = {}, l = {151}, m = "invokeSuspend", n = {}, s = {})
public final class StartedLazily$command$1 extends SuspendLambda implements Function2<FlowCollector<? super SharingCommand>, Continuation<? super Unit>, Object> {
    final /* synthetic */ i1<Integer> $subscriptionCount;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.StartedLazily$command$1$1, reason: invalid class name */
    /* JADX INFO: loaded from: classes42.dex */
    public static final class AnonymousClass1<T> implements FlowCollector {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Ref.BooleanRef f504824a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ FlowCollector<SharingCommand> f504825b;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(Ref.BooleanRef r100, FlowCollector<? super SharingCommand> r101) {
            this.f504824a = r100;
            this.f504825b = r101;
        }

        public final Object a(int r100, Continuation<? super Unit> r101) {
            if ((r101 instanceof StartedLazily$command$1$1$emit$1) == false) goto L7;
            StartedLazily$command$1$1$emit$1 r102 = (StartedLazily$command$1$1$emit$1) r101;
            int r103 = r102.label;
            if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
            r102.label = r103 - Integer.MIN_VALUE;
        L8:
            Object r104 = r102.result;
            Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r106 = r102.label;
            if (r106 == 0) goto L14;
            if (r106 != 1) goto L13;
            ResultKt.throwOnFailure(r104);
        L22:
            return Unit.INSTANCE;
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            ResultKt.throwOnFailure(r104);
            if (r100 <= 0) goto L24;
            Ref.BooleanRef r107 = this.f504824a;
            if (r107.element == true) goto L24;
            r107.element = true;
            FlowCollector<SharingCommand> r108 = this.f504825b;
            SharingCommand r109 = SharingCommand.START;
            r102.label = 1;
            if (r108.emit(r109, r102) != r105) goto L22;
            return r105;
        L24:
            return Unit.INSTANCE;
        L7:
            r102 = new StartedLazily$command$1$1$emit$1(this, r101);
            goto L8
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        public final /* bridge */ /* synthetic */ Object emit(Object r100, Continuation r101) {
            return a(((Number) r100).intValue(), r101);
        }
    }

    public StartedLazily$command$1(i1<Integer> r100, Continuation<? super StartedLazily$command$1> r101) {
        this.$subscriptionCount = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        StartedLazily$command$1 r102 = new StartedLazily$command$1(this.$subscriptionCount, r101);
        r102.L$0 = r100;
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super SharingCommand> r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(FlowCollector<? super SharingCommand> r100, Continuation<? super Unit> r101) {
        return ((StartedLazily$command$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L6;
        ResultKt.throwOnFailure(r100);
    L12:
        throw new KotlinNothingValueException();
    L6:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        FlowCollector r103 = (FlowCollector) this.L$0;
        Ref.BooleanRef r104 = new Ref.BooleanRef();
        i1<Integer> r105 = this.$subscriptionCount;
        AnonymousClass1 r106 = new AnonymousClass1(r104, r103);
        this.label = 1;
        if (r105.collect(r106, this) != r101) goto L12;
        return r101;
    }
}
