package com.bytedance.awemeopen.domain.share;

import com.bytedance.awemeopen.infra.support.AoThrowableResult;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import i24.c;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/awemeopen/infra/support/AoThrowableResult;", "Li24/c;", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/awemeopen/infra/support/AoThrowableResult;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
final class InternalShareDomain$showSharePanel$1$getOriginLinkShare$1 extends Lambda implements Function1<AoThrowableResult<c>, Unit> {
    final /* synthetic */ Function1<AoThrowableResult<t64.a>, Unit> $callback;

    /* JADX WARN: Multi-variable type inference failed */
    public InternalShareDomain$showSharePanel$1$getOriginLinkShare$1(Function1<? super AoThrowableResult<t64.a>, Unit> r100) {
        this.$callback = r100;
        super(1);
    }

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
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(AoThrowableResult<c> r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$getOriginLinkShare");
        this.$callback.invoke(r100.a(AnonymousClass1.INSTANCE));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(AoThrowableResult<c> r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
