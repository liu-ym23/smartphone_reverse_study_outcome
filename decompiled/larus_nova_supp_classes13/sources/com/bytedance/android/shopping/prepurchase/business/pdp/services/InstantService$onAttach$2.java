package com.bytedance.android.shopping.prepurchase.business.pdp.services;

import com.bytedance.android.ecom.arch.slice.action.IAction;
import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature.slice.o;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import vg3.d0;
import vg3.o0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lvg3/d0;", "it", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.shopping.prepurchase.business.pdp.services.InstantService$onAttach$2", f = "InstantService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class InstantService$onAttach$2 extends SuspendLambda implements Function3<CoroutineScope, d0, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ InstantService this$0;

    public static final class a<T> implements com.bytedance.android.shopping.prepurchase.arch.container.state.g {
        public final /* synthetic */ InstantService$onAttach$2 a;

        public a(InstantService$onAttach$2 r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.shopping.prepurchase.arch.container.state.g
        public final void onChanged(Object r6) {
            o0 r7 = (o0) r6;
            Intrinsics.checkNotNullParameter(r7, "it");
            InstantService r0 = this.a.this$0;
            int r1 = InstantService.r;
            r0.getClass();
            int r2 = r7.b;
            if (r2 > 3) goto L5;
            return;
        L5:
            if (((r2 - 1) - r7.a[0]) <= 3) goto L7;
            return;
        L7:
            if (r0.l == false) goto L33;
            Map r8 = MapsKt.toMap(r0.j);
            if ((!r8.isEmpty()) == false) goto L32;
            o r3 = r0.O1().e().r();
            Iterator<T> r4 = r3.F().iterator();
        L13:
            if (r4.hasNext() == false) goto L34;
            com.bytedance.android.ecom.arch.slice.slices.template.d r5 = (com.bytedance.android.ecom.arch.slice.g) r4.next();
            if ((r5 instanceof com.bytedance.android.ecom.arch.slice.slices.template.d) == false) goto L13;
            HashMap r9 = r5.a();
            if (r9 == null) goto L13;
            if (((IAction) r9.get("async_fetch_data_action")) == null) goto L13;
            int r10 = fi3.o.a;
            Intrinsics.checkNotNullParameter(r8, "incomingData");
            r3.O0(r5, new SlcCommonAction("AsyncFetchData", r8), null, null);
            goto L13
        L34:
            return;
        L32:
            return;
        }
    }

    public InstantService$onAttach$2(InstantService r1, Continuation r2) {
        this.this$0 = r1;
        super(3, r2);
    }

    public final Continuation<Unit> create(CoroutineScope r2, d0 r3, Continuation<? super Unit> r4) {
        Intrinsics.checkNotNullParameter(r2, "$this$create");
        Intrinsics.checkNotNullParameter(r3, "it");
        Intrinsics.checkNotNullParameter(r4, "continuation");
        InstantService$onAttach$2 r5 = new InstantService$onAttach$2(this.this$0, r4);
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
        com.bytedance.android.shopping.prepurchase.arch.container.state.e.a.a(((d0) this.L$0).x1(), this.this$0, new a(this));
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
