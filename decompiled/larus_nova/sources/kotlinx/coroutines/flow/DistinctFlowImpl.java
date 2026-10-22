package kotlinx.coroutines.flow;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes42.dex */
public final class DistinctFlowImpl<T> implements Flow<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Flow<T> f504742a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<T, Object> f504743b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function2<Object, Object, Boolean> f504744c;

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.DistinctFlowImpl$collect$2, reason: invalid class name */
    public static final class AnonymousClass2<T> implements FlowCollector {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DistinctFlowImpl<T> f504745a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Ref.ObjectRef<Object> f504746b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ FlowCollector<T> f504747c;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass2(DistinctFlowImpl<T> r100, Ref.ObjectRef<Object> r101, FlowCollector<? super T> r102) {
            this.f504745a = r100;
            this.f504746b = r101;
            this.f504747c = r102;
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
        @Override // kotlinx.coroutines.flow.FlowCollector
        public final Object emit(T r100, Continuation<? super Unit> r101) {
            if ((r101 instanceof DistinctFlowImpl$collect$2$emit$1) == false) goto L7;
            DistinctFlowImpl$collect$2$emit$1 r102 = (DistinctFlowImpl$collect$2$emit$1) r101;
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
        L25:
            return Unit.INSTANCE;
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            ResultKt.throwOnFailure(r104);
            T r107 = (T) this.f504745a.f504743b.invoke(r100);
            Object r108 = this.f504746b.element;
            if (r108 != kotlinx.coroutines.flow.internal.o.f504892a) goto L17;
        L21:
            this.f504746b.element = r107;
            FlowCollector<T> r109 = this.f504747c;
            r102.label = 1;
            if (r109.emit(r100, r102) != r105) goto L25;
            return r105;
        L17:
            if (this.f504745a.f504744c.invoke(r108, r107).booleanValue() == false) goto L21;
            return Unit.INSTANCE;
        L7:
            r102 = new DistinctFlowImpl$collect$2$emit$1(this, r101);
            goto L8
        }
    }

    @Override // kotlinx.coroutines.flow.Flow
    public final Object collect(FlowCollector<? super T> r100, Continuation<? super Unit> r101) {
        Ref.ObjectRef r102 = new Ref.ObjectRef();
        r102.element = (T) kotlinx.coroutines.flow.internal.o.f504892a;
        Object r103 = this.f504742a.collect(new AnonymousClass2(this, r102, r100), r101);
        if (r103 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r103;
    L6:
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DistinctFlowImpl(Flow<? extends T> r100, Function1<? super T, ? extends Object> r101, Function2<Object, Object, Boolean> r102) {
        this.f504742a = r100;
        this.f504743b = r101;
        this.f504744c = r102;
    }
}
