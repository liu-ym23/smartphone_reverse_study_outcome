package kotlinx.coroutines.flow;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes42.dex */
public final class FlowKt__LimitKt$dropWhile$1$1<T> implements FlowCollector {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref.BooleanRef f504774a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ FlowCollector<T> f504775b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Function2<T, Continuation<? super Boolean>, Object> f504776c;

    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__LimitKt$dropWhile$1$1(Ref.BooleanRef r100, FlowCollector<? super T> r101, Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> r102) {
        this.f504774a = r100;
        this.f504775b = r101;
        this.f504776c = r102;
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
        if ((r101 instanceof FlowKt__LimitKt$dropWhile$1$1$emit$1) == false) goto L7;
        FlowKt__LimitKt$dropWhile$1$1$emit$1 r102 = (FlowKt__LimitKt$dropWhile$1$1$emit$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L18;
        if (r106 == 1) goto L17;
        if (r106 == 2) goto L16;
        if (r106 != 3) goto L15;
        ResultKt.throwOnFailure(r104);
    L35:
        return Unit.INSTANCE;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        r100 = (T) r102.L$1;
        FlowKt__LimitKt$dropWhile$1$1<T> r107 = (FlowKt__LimitKt$dropWhile$1$1) r102.L$0;
        ResultKt.throwOnFailure(r104);
    L30:
        if (((Boolean) r104).booleanValue() == true) goto L37;
        r107.f504774a.element = true;
        FlowCollector<T> r108 = r107.f504775b;
        r102.L$0 = null;
        r102.L$1 = null;
        r102.label = 3;
        if (r108.emit(r100, r102) != r105) goto L35;
        return r105;
    L37:
        return Unit.INSTANCE;
    L17:
        ResultKt.throwOnFailure(r104);
    L24:
        return Unit.INSTANCE;
    L18:
        ResultKt.throwOnFailure(r104);
        if (this.f504774a.element == false) goto L25;
        FlowCollector<T> r109 = this.f504775b;
        r102.label = 1;
        if (r109.emit(r100, r102) != r105) goto L24;
        return r105;
    L25:
        Function2<T, Continuation<? super Boolean>, Object> r110 = this.f504776c;
        r102.L$0 = this;
        r102.L$1 = r100;
        r102.label = 2;
        r104 = r110.invoke(r100, r102);
        if (r104 != r105) goto L28;
        return r105;
    L28:
        r107 = this;
    L7:
        r102 = new FlowKt__LimitKt$dropWhile$1$1$emit$1(this, r101);
        goto L8
    }
}
