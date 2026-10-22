package com.bytedance.android.shopping.prepurchase.arch.standard.component.pref;

import com.bytedance.android.shopping.prepurchase.arch.container.intf.j;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\t\u001a\u00020\u0006\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\u0004\b\u0001\u0010\u0002*\u00020\u00032\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0004H\u008a@¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lcom/bytedance/android/shopping/prepurchase/arch/container/state/h;", "STATE", "STORE", "Lkotlinx/coroutines/CoroutineScope;", "Lcom/bytedance/android/shopping/prepurchase/arch/container/intf/j;", "it", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.shopping.prepurchase.arch.standard.component.pref.StandardPrefService$onAttach$1", f = "StandardPrefService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class StandardPrefService$onAttach$1 extends SuspendLambda implements Function3<CoroutineScope, j<?>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ StandardPrefService this$0;

    public StandardPrefService$onAttach$1(StandardPrefService r1, Continuation r2) {
        this.this$0 = r1;
        super(3, r2);
    }

    public final Continuation<Unit> create(CoroutineScope r2, j<?> r3, Continuation<? super Unit> r4) {
        Intrinsics.checkNotNullParameter(r2, "$this$create");
        Intrinsics.checkNotNullParameter(r3, "it");
        Intrinsics.checkNotNullParameter(r4, "continuation");
        StandardPrefService$onAttach$1 r5 = new StandardPrefService$onAttach$1(this.this$0, r4);
        r5.L$0 = r3;
        return r5;
    }

    public final Object invoke(Object r1, Object r2, Object r3) {
        return create((CoroutineScope) r1, (j) r2, (Continuation) r3).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r4);
        j r5 = (j) this.L$0;
        xg3.d r0 = (xg3.d) this.this$0;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r5, "dataFetchAbility");
        Intrinsics.checkNotNullParameter(r5, "dataFetchAbility");
        com.bytedance.android.shopping.prepurchase.arch.container.state.e.a.a(r5.q0(), r0, new c(r0));
        com.bytedance.android.shopping.prepurchase.arch.container.state.e.a.a(r5.q0(), r0, new xg3.e(r0));
        r0.s1(new xg3.f(r0));
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
