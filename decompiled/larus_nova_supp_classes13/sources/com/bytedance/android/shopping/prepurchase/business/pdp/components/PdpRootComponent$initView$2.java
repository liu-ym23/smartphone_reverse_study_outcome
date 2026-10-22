package com.bytedance.android.shopping.prepurchase.business.pdp.components;

import com.bytedance.android.shopping.anchorv3.compat.CompatFrameLayout;
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
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lvg3/s;", "it", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.shopping.prepurchase.business.pdp.components.PdpRootComponent$initView$2", f = "PdpRootComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class PdpRootComponent$initView$2 extends SuspendLambda implements Function3<CoroutineScope, vg3.s, Continuation<? super Unit>, Object> {
    final /* synthetic */ CompatFrameLayout $rootView;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ PdpRootComponent this$0;

    public static final class a<T> implements com.bytedance.android.shopping.prepurchase.arch.container.state.g {
        public final /* synthetic */ PdpRootComponent$initView$2 a;

        public a(PdpRootComponent$initView$2 r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.shopping.prepurchase.arch.container.state.g
        public final void onChanged(Object r2) {
            boolean r3 = ((Boolean) r2).booleanValue();
            this.a.$rootView.setForbiddenDrag(r3);
        }
    }

    public PdpRootComponent$initView$2(PdpRootComponent r1, CompatFrameLayout r2, Continuation r3) {
        this.this$0 = r1;
        this.$rootView = r2;
        super(3, r3);
    }

    public final Continuation<Unit> create(CoroutineScope r3, vg3.s r4, Continuation<? super Unit> r5) {
        Intrinsics.checkNotNullParameter(r3, "$this$create");
        Intrinsics.checkNotNullParameter(r4, "it");
        Intrinsics.checkNotNullParameter(r5, "continuation");
        PdpRootComponent$initView$2 r6 = new PdpRootComponent$initView$2(this.this$0, this.$rootView, r5);
        r6.L$0 = r4;
        return r6;
    }

    public final Object invoke(Object r1, Object r2, Object r3) {
        return create((CoroutineScope) r1, (vg3.s) r2, (Continuation) r3).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r3);
        com.bytedance.android.shopping.prepurchase.arch.container.state.e.a.a(((vg3.s) this.L$0).a0(), this.this$0, new a(this));
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
