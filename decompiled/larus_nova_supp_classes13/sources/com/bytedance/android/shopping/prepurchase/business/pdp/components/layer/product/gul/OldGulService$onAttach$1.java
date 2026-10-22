package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.product.gul;

import com.bytedance.android.shopping.prepurchase.arch.container.state.e;
import com.bytedance.android.shopping.prepurchase.arch.container.state.g;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import vg3.d0;
import vg3.o0;
import vg3.x;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lvg3/d0;", "it", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.product.gul.OldGulService$onAttach$1", f = "OldGulService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class OldGulService$onAttach$1 extends SuspendLambda implements Function3<CoroutineScope, d0, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ OldGulService this$0;

    public static final class a<T> implements g {
        public final /* synthetic */ OldGulService$onAttach$1 a;

        public a(OldGulService$onAttach$1 r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.shopping.prepurchase.arch.container.state.g
        public final void onChanged(Object r4) {
            o0 r5 = (o0) r4;
            Intrinsics.checkNotNullParameter(r5, "it");
            OldGulService r0 = this.a.this$0;
            int r1 = OldGulService.i;
            r0.getClass();
            Integer r2 = ArraysKt.max(r5.a);
            if (r2 == null) goto L5;
            int r3 = r2.intValue();
        L6:
            int r6 = r5.b;
            if (r6 > 3) goto L9;
            return;
        L9:
            if (((r6 - 1) - r3) > 3) goto L13;
            r0.Z1(x.class, new OldGulService$tryLoadGul$1(r0, null));
            return;
        L13:
            return;
        L5:
            r3 = 0;
            goto L6
        }
    }

    public OldGulService$onAttach$1(OldGulService r1, Continuation r2) {
        this.this$0 = r1;
        super(3, r2);
    }

    public final Continuation<Unit> create(CoroutineScope r2, d0 r3, Continuation<? super Unit> r4) {
        Intrinsics.checkNotNullParameter(r2, "$this$create");
        Intrinsics.checkNotNullParameter(r3, "it");
        Intrinsics.checkNotNullParameter(r4, "continuation");
        OldGulService$onAttach$1 r5 = new OldGulService$onAttach$1(this.this$0, r4);
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
        e.a.a(((d0) this.L$0).x1(), this.this$0, new a(this));
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
