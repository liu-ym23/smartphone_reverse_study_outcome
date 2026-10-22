package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;

/* JADX INFO: loaded from: classes5.dex */
public final class FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1 implements Flow<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Flow f504799a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function2 f504800b;

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1$2, reason: invalid class name */
    public static final class AnonymousClass2<T> implements FlowCollector {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FlowCollector f504801a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function2 f504802b;

        /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1$2$1, reason: invalid class name */
        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1$2", f = "Transform.kt", i = {0, 0}, l = {219, 220}, m = "emit", n = {"value", "$this$onEach_u24lambda_u248"}, s = {"L$0", "L$1"})
        public static final class AnonymousClass1 extends ContinuationImpl {
            Object L$0;
            Object L$1;
            int label;
            /* synthetic */ Object result;
            final /* synthetic */ AnonymousClass2 this$0;

            public AnonymousClass1(AnonymousClass2 r100, Continuation r101) {
                this.this$0 = r100;
                super(r101);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r100) {
                this.result = r100;
                this.label |= Integer.MIN_VALUE;
                return this.this$0.emit(null, this);
            }
        }

        public AnonymousClass2(FlowCollector r100, Function2 r101) {
            this.f504801a = r100;
            this.f504802b = r101;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlinx.coroutines.flow.FlowCollector
        public final Object emit(T r100, Continuation<? super Unit> r101) {
            if ((r101 instanceof AnonymousClass1) == false) goto L7;
            AnonymousClass1 r102 = (AnonymousClass1) r101;
            int r103 = r102.label;
            if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
            r102.label = r103 - Integer.MIN_VALUE;
        L8:
            Object r104 = r102.result;
            Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r106 = r102.label;
            if (r106 == 0) goto L16;
            if (r106 == 1) goto L15;
            if (r106 != 2) goto L14;
            ResultKt.throwOnFailure(r104);
        L24:
            return Unit.INSTANCE;
        L14:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L15:
            FlowCollector r107 = (FlowCollector) r102.L$1;
            Object r108 = r102.L$0;
            ResultKt.throwOnFailure(r104);
            FlowCollector r109 = r107;
        L20:
            r102.L$0 = null;
            r102.L$1 = null;
            r102.label = 2;
            if (r109.emit(r108, r102) != r105) goto L24;
            return r105;
        L16:
            ResultKt.throwOnFailure(r104);
            FlowCollector r110 = this.f504801a;
            Function2 r111 = this.f504802b;
            r102.L$0 = r100;
            r102.L$1 = r110;
            r102.label = 1;
            InlineMarker.mark(6);
            Object r112 = r111.invoke(r100, r102);
            InlineMarker.mark(7);
            if (r112 != r105) goto L19;
            return r105;
        L19:
            r108 = r100;
            r109 = r110;
        L7:
            r102 = new AnonymousClass1(this, r101);
            goto L8
        }
    }

    public FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(Flow r100, Function2 r101) {
        this.f504799a = r100;
        this.f504800b = r101;
    }

    @Override // kotlinx.coroutines.flow.Flow
    public final Object collect(FlowCollector<? super Object> r100, Continuation r101) {
        Object r102 = this.f504799a.collect(new AnonymousClass2(r100, this.f504800b), r101);
        if (r102 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r102;
    L6:
        return Unit.INSTANCE;
    }
}
