package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import vg3.d0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lvg3/d0;", "it", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.LivingIconComponent$bindEventOnce$2", f = "LivingIconComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class LivingIconComponent$bindEventOnce$2 extends SuspendLambda implements Function3<CoroutineScope, d0, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ LivingIconComponent this$0;

    public static final class a<T> implements com.bytedance.android.shopping.prepurchase.arch.container.state.g {
        public final /* synthetic */ LivingIconComponent$bindEventOnce$2 a;

        public a(LivingIconComponent$bindEventOnce$2 r1) {
            this.a = r1;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [android.view.View, android.widget.FrameLayout, com.bytedance.android.shopping.prepurchase.business.pdp.view.AnchorV4PlaybackAreaV2] */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // com.bytedance.android.shopping.prepurchase.arch.container.state.g
        public final void onChanged(Object r3) {
            int r4 = ((Number) r3).intValue();
            ?? r0 = this.a.this$0.m;
            if (r0 != 0) goto L5;
            return;
        L5:
            if (r0.p == true) goto L12;
            if (r0.x == true) goto L9;
            return;
        L9:
            if (r0.getVisibility() != 0) goto L18;
            r0.setTranslationY(-r4);
            return;
        L18:
            return;
        L12:
            if (r4 <= 1000) goto L14;
            r0.setVisibility(4);
            return;
        L14:
            r0.setVisibility(0);
        }
    }

    public LivingIconComponent$bindEventOnce$2(LivingIconComponent r1, Continuation r2) {
        this.this$0 = r1;
        super(3, r2);
    }

    public final Continuation<Unit> create(CoroutineScope r2, d0 r3, Continuation<? super Unit> r4) {
        Intrinsics.checkNotNullParameter(r2, "$this$create");
        Intrinsics.checkNotNullParameter(r3, "it");
        Intrinsics.checkNotNullParameter(r4, "continuation");
        LivingIconComponent$bindEventOnce$2 r5 = new LivingIconComponent$bindEventOnce$2(this.this$0, r4);
        r5.L$0 = r3;
        return r5;
    }

    public final Object invoke(Object r1, Object r2, Object r3) {
        return create((CoroutineScope) r1, (d0) r2, (Continuation) r3).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r3);
        com.bytedance.android.shopping.prepurchase.arch.container.state.e.a.a(((d0) this.L$0).R(), this.this$0, new a(this));
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
