package com.bytedance.android.shopping.prepurchase.business.pdp.services.slice;

import com.bytedance.android.ec.core.anchorv3.PdpPerfOpt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.shopping.prepurchase.business.pdp.services.slice.GlobalActionHandlerV2$tryHandleActionOpt$1", f = "GlobalActionHandlerV2.kt", i = {}, l = {105}, m = "invokeSuspend", n = {}, s = {})
final class GlobalActionHandlerV2$tryHandleActionOpt$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ e73.a $actions;
    int label;
    final /* synthetic */ c this$0;

    public static final class a extends com.bytedance.android.shopping.prepurchase.arch.container.ability.b {
        public final /* synthetic */ GlobalActionHandlerV2$tryHandleActionOpt$1 c;

        @Override // java.lang.Runnable
        public final void run() {
            if (PdpPerfOpt.c() == false) goto L5;
            GlobalActionHandlerV2$tryHandleActionOpt$1 r0 = this.c;
            r0.this$0.a(r0.$actions);
        L5:
            GlobalActionHandlerV2$tryHandleActionOpt$1 r1 = this.c;
            c r2 = r1.this$0;
            e73.a r3 = r1.$actions;
            if (r2.c == true) goto L10;
            r2.c = true;
            r2.b(r3.a());
            return;
        }

        public a(GlobalActionHandlerV2$tryHandleActionOpt$1 r1) {
            this.c = r1;
            super("handle_global_action");
        }
    }

    public GlobalActionHandlerV2$tryHandleActionOpt$1(c r1, e73.a r2, Continuation r3) {
        this.this$0 = r1;
        this.$actions = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        Intrinsics.checkNotNullParameter(r4, "completion");
        return new GlobalActionHandlerV2$tryHandleActionOpt$1(this.this$0, this.$actions, r4);
    }

    public final Object invoke(Object r1, Object r2) {
        return create(r1, (Continuation) r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r4);
    L11:
        ((com.bytedance.android.shopping.prepurchase.arch.container.ability.l) r4).e1(new a(this));
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        com.bytedance.android.shopping.prepurchase.arch.container.component.j r5 = this.this$0.f;
        this.label = 1;
        r4 = r5.e(com.bytedance.android.shopping.prepurchase.arch.container.ability.l.class, this);
        if (r4 != r0) goto L11;
        return r0;
    }
}
