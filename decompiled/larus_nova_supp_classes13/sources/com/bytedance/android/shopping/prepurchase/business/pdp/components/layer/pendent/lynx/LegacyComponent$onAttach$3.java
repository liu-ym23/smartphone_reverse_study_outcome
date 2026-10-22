package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.lynx;

import com.bytedance.android.shopping.prepurchase.arch.container.state.g;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import vg3.i0;
import vg3.n0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lvg3/i0;", "it", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.lynx.LegacyComponent$onAttach$3", f = "LegacyComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class LegacyComponent$onAttach$3 extends SuspendLambda implements Function3<CoroutineScope, i0, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.IntRef $currentIndex;
    final /* synthetic */ Ref.IntRef $currentOffset;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.lynx.a this$0;

    public static final class a<T> implements g {
        public final /* synthetic */ LegacyComponent$onAttach$3 a;

        public a(LegacyComponent$onAttach$3 r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.shopping.prepurchase.arch.container.state.g
        public final void onChanged(Object r3) {
            n0 r4 = (n0) r3;
            Intrinsics.checkNotNullParameter(r4, "it");
            LegacyComponent$onAttach$3 r0 = this.a;
            Ref.IntRef r1 = r0.$currentIndex;
            r1.element = r4.a;
            int r5 = r0.$currentOffset.element;
            throw null;
        }
    }

    public LegacyComponent$onAttach$3(com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.lynx.a r1, Ref.IntRef r2, Ref.IntRef r3, Continuation r4) {
        this.$currentIndex = r2;
        this.$currentOffset = r3;
        super(3, r4);
    }

    public final Continuation<Unit> create(CoroutineScope r4, i0 r5, Continuation<? super Unit> r6) {
        Intrinsics.checkNotNullParameter(r4, "$this$create");
        Intrinsics.checkNotNullParameter(r5, "it");
        Intrinsics.checkNotNullParameter(r6, "continuation");
        LegacyComponent$onAttach$3 r7 = new LegacyComponent$onAttach$3(null, this.$currentIndex, this.$currentOffset, r6);
        r7.L$0 = r5;
        return r7;
    }

    public final Object invoke(Object r1, Object r2, Object r3) {
        return create((CoroutineScope) r1, (i0) r2, (Continuation) r3).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r3);
        com.bytedance.android.shopping.prepurchase.arch.container.state.e.a.a(((i0) this.L$0).q1(), null, new a(this));
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
