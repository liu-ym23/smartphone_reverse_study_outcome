package com.bytedance.android.shopping.prepurchase.arch.container.component;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\t\u001a\u00020\u0006\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0003*\u00020\u0002\"\u0004\b\u0002\u0010\u0004*\u00020\u0005H\u008a@¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lcom/bytedance/android/shopping/prepurchase/arch/container/ability/a;", "T", "Lcom/bytedance/android/shopping/prepurchase/arch/container/state/h;", "STATE", "STORE", "Lkotlinx/coroutines/CoroutineScope;", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent$whenAbilityAvailable$1", f = "AbsComponent.kt", i = {}, l = {132, 132}, m = "invokeSuspend", n = {}, s = {})
public final class AbsComponent$whenAbilityAvailable$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function3 $block;
    final /* synthetic */ Class $service;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ AbsComponent this$0;

    public AbsComponent$whenAbilityAvailable$1(AbsComponent r1, Function3 r2, Class r3, Continuation r4) {
        this.this$0 = r1;
        this.$block = r2;
        this.$service = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
        Intrinsics.checkNotNullParameter(r6, "completion");
        AbsComponent$whenAbilityAvailable$1 r0 = new AbsComponent$whenAbilityAvailable$1(this.this$0, this.$block, this.$service, r6);
        r0.L$0 = r5;
        return r0;
    }

    public final Object invoke(Object r1, Object r2) {
        return create(r1, (Continuation) r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r8);
    L18:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        CoroutineScope r2 = (CoroutineScope) this.L$1;
        Function3 r3 = (Function3) this.L$0;
        ResultKt.throwOnFailure(r8);
    L14:
        this.L$0 = null;
        this.L$1 = null;
        this.label = 2;
        if (r3.invoke(r2, r8, this) != r0) goto L18;
        return r0;
    L10:
        ResultKt.throwOnFailure(r8);
        r2 = (CoroutineScope) this.L$0;
        Function3 r9 = this.$block;
        j r4 = this.this$0.R1();
        Class r5 = this.$service;
        this.L$0 = r9;
        this.L$1 = r2;
        this.label = 1;
        Object r6 = r4.e(r5, this);
        if (r6 != r0) goto L13;
        return r0;
    L13:
        r3 = r9;
        r8 = r6;
        goto L14
    }
}
