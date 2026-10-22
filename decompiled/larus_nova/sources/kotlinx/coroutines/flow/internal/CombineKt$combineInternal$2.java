package kotlinx.coroutines.flow.internal;

import androidx.exifinterface.media.ExifInterface;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.IndexedValue;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.f2;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", "", "R", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2", f = "Combine.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2}, l = {51, 73, 76}, m = "invokeSuspend", n = {"latestValues", "resultChannel", "lastReceivedEpoch", "remainingAbsentValues", "currentEpoch", "latestValues", "resultChannel", "lastReceivedEpoch", "remainingAbsentValues", "currentEpoch", "latestValues", "resultChannel", "lastReceivedEpoch", "remainingAbsentValues", "currentEpoch"}, s = {"L$0", "L$1", "L$2", "I$0", "I$1", "L$0", "L$1", "L$2", "I$0", "I$1", "L$0", "L$1", "L$2", "I$0", "I$1"})
public final class CombineKt$combineInternal$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<T[]> $arrayFactory;
    final /* synthetic */ Flow<T>[] $flows;
    final /* synthetic */ FlowCollector<R> $this_combineInternal;
    final /* synthetic */ Function3<FlowCollector<? super R>, T[], Continuation<? super Unit>, Object> $transform;
    int I$0;
    int I$1;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", "", "R", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1", f = "Combine.kt", i = {}, l = {28}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Flow<T>[] $flows;
        final /* synthetic */ int $i;
        final /* synthetic */ AtomicInteger $nonClosed;
        final /* synthetic */ Channel<IndexedValue<Object>> $resultChannel;
        int label;

        /* JADX INFO: renamed from: kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C65881<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Channel<IndexedValue<Object>> f504864a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ int f504865b;

            public C65881(Channel<IndexedValue<Object>> r100, int r101) {
                this.f504864a = r100;
                this.f504865b = r101;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public final Object emit(T r100, Continuation<? super Unit> r101) {
                if ((r101 instanceof CombineKt$combineInternal$2$1$1$emit$1) == false) goto L7;
                CombineKt$combineInternal$2$1$1$emit$1 r102 = (CombineKt$combineInternal$2$1$1$emit$1) r101;
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
            L23:
                return Unit.INSTANCE;
            L14:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L15:
                ResultKt.throwOnFailure(r104);
            L19:
                r102.label = 2;
                if (f2.a(r102) != r105) goto L23;
                return r105;
            L16:
                ResultKt.throwOnFailure(r104);
                Channel<IndexedValue<Object>> r107 = this.f504864a;
                IndexedValue<Object> r108 = new IndexedValue(this.f504865b, r100);
                r102.label = 1;
                if (r107.send(r108, r102) != r105) goto L19;
                return r105;
            L7:
                r102 = new CombineKt$combineInternal$2$1$1$emit$1(this, r101);
                goto L8
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(Flow<? extends T>[] r100, int r101, AtomicInteger r102, Channel<IndexedValue<Object>> r103, Continuation<? super AnonymousClass1> r104) {
            this.$flows = r100;
            this.$i = r101;
            this.$nonClosed = r102;
            this.$resultChannel = r103;
            super(2, r104);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass1(this.$flows, this.$i, this.$nonClosed, this.$resultChannel, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((AnonymousClass1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r102 = this.label;
            if (r102 == 0) goto L9;
            if (r102 != 1) goto L8;
            ResultKt.throwOnFailure(r100);     // Catch: Throwable -> L18
        L13:
            if (this.$nonClosed.decrementAndGet() != 0) goto L17;
            SendChannel.a.a(this.$resultChannel);
        L17:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r100);
            Flow[] r103 = this.$flows;     // Catch: Throwable -> L18
            int r104 = this.$i;     // Catch: Throwable -> L18
            Flow r105 = r103[r104];     // Catch: Throwable -> L18
            C65881 r106 = new C65881(this.$resultChannel, r104);     // Catch: Throwable -> L18
            this.label = 1;     // Catch: Throwable -> L18
            if (r105.collect(r106, this) != r101) goto L13;
            return r101;
        L18:
            th = move-exception;
            if (this.$nonClosed.decrementAndGet() != 0) goto L22;
            SendChannel.a.a(this.$resultChannel);
        L22:
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CombineKt$combineInternal$2(Flow<? extends T>[] r100, Function0<T[]> r101, Function3<? super FlowCollector<? super R>, ? super T[], ? super Continuation<? super Unit>, ? extends Object> r102, FlowCollector<? super R> r103, Continuation<? super CombineKt$combineInternal$2> r104) {
        this.$flows = r100;
        this.$arrayFactory = r101;
        this.$transform = r102;
        this.$this_combineInternal = r103;
        super(2, r104);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        CombineKt$combineInternal$2 r102 = new CombineKt$combineInternal$2(this.$flows, this.$arrayFactory, this.$transform, this.$this_combineInternal, r101);
        r102.L$0 = r100;
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((CombineKt$combineInternal$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

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
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:41:0x012b -> B:20:0x00c0). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r210) {
        Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r101 = this.label;
        int r102 = 2;
        if (r101 == 0) goto L12;
        if (r101 == 1) goto L11;
        if (r101 == 2) goto L10;
        if (r101 != 3) goto L9;
        int r103 = this.I$1;
        int r104 = this.I$0;
        byte[] r105 = (byte[]) this.L$2;
        Channel r106 = (Channel) this.L$1;
        Object[] r107 = (Object[]) this.L$0;
        ResultKt.throwOnFailure(r210);
        int r211 = r103;
        byte[] r108 = r105;
        Channel r109 = r106;
        Object[] r110 = r107;
        CombineKt$combineInternal$2 r111 = this;
    L45:
        r102 = 2;
    L20:
        byte r112 = (byte) (r211 + 1);
        r111.L$0 = r110;
        r111.L$1 = r109;
        r111.L$2 = r108;
        r111.I$0 = r104;
        r111.I$1 = r112;
        r111.label = 1;
        Object r113 = r109.mo10963receiveCatchingJP2dKIU(r111);
        if (r113 != r100) goto L23;
        return r100;
    L23:
        int r114 = r112;
        Object[] r115 = r110;
    L24:
        IndexedValue r116 = (IndexedValue) kotlinx.coroutines.channels.g.b(r113);
        if (r116 == null) goto L27;
    L28:
        int r117 = r116.getIndex();
        Object r118 = r115[r117];
        r115[r117] = r116.getValue();
        if (r118 != o.f504893b) goto L32;
        r104 = r104 - 1;
    L32:
        if (r108[r117] == r114) goto L35;
        r108[r117] = (byte) r114;
        r116 = (IndexedValue) kotlinx.coroutines.channels.g.b(r109.mo10964tryReceivePtdJZtk());
        if (r116 != null) goto L28;
    L35:
        if (r104 != 0) goto L48;
        Object[] r119 = (Object[]) r111.$arrayFactory.invoke();
        if (r119 != null) goto L42;
        Function3<FlowCollector<? super R>, T[], Continuation<? super Unit>, Object> r120 = r111.$transform;
        Object r121 = r111.$this_combineInternal;
        r111.L$0 = r115;
        r111.L$1 = r109;
        r111.L$2 = r108;
        r111.I$0 = r104;
        r111.I$1 = r114;
        r111.label = r102;
        if (r120.invoke(r121, r115, r111) != r100) goto L41;
        return r100;
    L41:
        r110 = r115;
        r211 = r114;
        goto L20
    L42:
        int r122 = r114;
        ArraysKt.copyInto$default(r115, r119, 0, 0, 0, 14, null);
        Function3<FlowCollector<? super R>, T[], Continuation<? super Unit>, Object> r123 = r111.$transform;
        Object r124 = r111.$this_combineInternal;
        r111.L$0 = r115;
        r111.L$1 = r109;
        r111.L$2 = r108;
        r111.I$0 = r104;
        r111.I$1 = r122;
        r111.label = 3;
        if (r123.invoke(r124, r119, r111) != r100) goto L47;
        return r100;
    L47:
        r211 = r122;
        r110 = r115;
        goto L45
    L48:
        r211 = r114;
        r110 = r115;
        goto L45
    L27:
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        int r125 = this.I$1;
        r104 = this.I$0;
        byte[] r126 = (byte[]) this.L$2;
        Channel r127 = (Channel) this.L$1;
        Object[] r128 = (Object[]) this.L$0;
        ResultKt.throwOnFailure(r210);
        r211 = r125;
        r108 = r126;
        r109 = r127;
        r110 = r128;
        r111 = this;
        goto L20
    L11:
        int r129 = this.I$1;
        r104 = this.I$0;
        byte[] r130 = (byte[]) this.L$2;
        Channel r131 = (Channel) this.L$1;
        r115 = (Object[]) this.L$0;
        ResultKt.throwOnFailure(r210);
        r113 = ((kotlinx.coroutines.channels.g) r210).f504697a;
        r114 = r129;
        r108 = r130;
        r109 = r131;
        r111 = this;
        goto L24
    L12:
        ResultKt.throwOnFailure(r210);
        CoroutineScope r132 = (CoroutineScope) this.L$0;
        int r133 = this.$flows.length;
        if (r133 == 0) goto L15;
        r110 = new Object[r133];
        ArraysKt.fill$default(r110, o.f504893b, 0, 0, 6, null);
        Channel r212 = ChannelKt.Channel$default(r133, null, null, 6, null);
        AtomicInteger r134 = new AtomicInteger(r133);
        r211 = 0;
        int r135 = 0;
    L17:
        if (r135 >= r133) goto L19;
        int r136 = r135;
        BuildersKt.launch$default(r132, null, null, new AnonymousClass1(this.$flows, r136, r134, r212, null), 3, null);
        r135 = r136 + 1;
        r134 = r134;
        goto L17
    L19:
        r108 = new byte[r133];
        r111 = this;
        r104 = r133;
        r109 = r212;
        goto L20
    L15:
        return Unit.INSTANCE;
    }
}
