package com.bytedance.android.shopping.prepurchase.business.pdp.services;

import com.bytedance.android.shopping.anchorv3.repository.api.PdpPackRequestParam;
import com.bytedance.android.shopping.anchorv4.dto.meta.CommonMeta;
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
import vg3.m0;
import vg3.x;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lvg3/x;", "it", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.shopping.prepurchase.business.pdp.services.PdpCommonBridgeService$registerNetworkInterceptor$1", f = "PdpCommonBridgeService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class PdpCommonBridgeService$registerNetworkInterceptor$1 extends SuspendLambda implements Function3<CoroutineScope, x, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ d this$0;

    public static final class a<T> implements com.bytedance.android.shopping.prepurchase.arch.container.state.g {
        public final /* synthetic */ PdpCommonBridgeService$registerNetworkInterceptor$1 a;

        public a(PdpCommonBridgeService$registerNetworkInterceptor$1 r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.shopping.prepurchase.arch.container.state.g
        public final void onChanged(Object r2) {
            CommonMeta r3 = (CommonMeta) r2;
            d r0 = this.a.this$0;
            if (r3 == null) goto L5;
            String r4 = r3.getUserAddrId();
        L6:
            r0.i = r4;
            return;
        L5:
            r4 = null;
            goto L6
        }
    }

    public static final class b implements m0 {
        public final /* synthetic */ PdpCommonBridgeService$registerNetworkInterceptor$1 a;

        public b(PdpCommonBridgeService$registerNetworkInterceptor$1 r1) {
            this.a = r1;
        }

        @Override // vg3.m0
        public final void a(PdpPackRequestParam r3) {
            Intrinsics.checkNotNullParameter(r3, "param");
            d r0 = this.a.this$0;
            r3.updateAddressId(r0.i, r0.j);
        }
    }

    public PdpCommonBridgeService$registerNetworkInterceptor$1(d r1, Continuation r2) {
        this.this$0 = r1;
        super(3, r2);
    }

    public final Continuation<Unit> create(CoroutineScope r2, x r3, Continuation<? super Unit> r4) {
        Intrinsics.checkNotNullParameter(r2, "$this$create");
        Intrinsics.checkNotNullParameter(r3, "it");
        Intrinsics.checkNotNullParameter(r4, "continuation");
        PdpCommonBridgeService$registerNetworkInterceptor$1 r5 = new PdpCommonBridgeService$registerNetworkInterceptor$1(this.this$0, r4);
        r5.L$0 = r3;
        return r5;
    }

    public final Object invoke(Object r1, Object r2, Object r3) {
        return create((CoroutineScope) r1, (x) r2, (Continuation) r3).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r4);
        x r5 = (x) this.L$0;
        com.bytedance.android.shopping.prepurchase.arch.container.state.e.a.a(r5.getData().a(), this.this$0, new a(this));
        r5.w1(new b(this));
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
