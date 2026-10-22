package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav;

import com.bytedance.android.ec.core.anchorv3.PdpPerfOpt;
import com.bytedance.android.shopping.anchorv4.voavhs.VOIdentifier;
import java.util.Map;
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
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lvg3/d0;", "ability", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.TopNavigationComponentV2$onAttach$5", f = "TopNavigationComponentV2.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class TopNavigationComponentV2$onAttach$5 extends SuspendLambda implements Function3<CoroutineScope, d0, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ TopNavigationComponentV2 this$0;

    public static final class a<T> implements com.bytedance.android.shopping.prepurchase.arch.container.state.g {
        public final /* synthetic */ TopNavigationComponentV2$onAttach$5 a;

        public a(TopNavigationComponentV2$onAttach$5 r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.shopping.prepurchase.arch.container.state.g
        public final void onChanged(Object r2) {
            int r3 = ((Number) r2).intValue();
            this.a.this$0.l2(r3);
        }
    }

    public static final class b<T> implements com.bytedance.android.shopping.prepurchase.arch.container.state.g {
        public final /* synthetic */ TopNavigationComponentV2$onAttach$5 a;

        public b(TopNavigationComponentV2$onAttach$5 r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.shopping.prepurchase.arch.container.state.g
        public final void onChanged(Object r4) {
            VOIdentifier r5 = (com.bytedance.android.ecom.arch.slice.adapter.b) r4;
            if (r5 == null) goto L26;
            TopNavigationComponentV2 r0 = this.a.this$0;
            int r1 = TopNavigationComponentV2.A;
            r0.getClass();
            if ((r5 instanceof VOIdentifier) == false) goto L7;
            String r6 = r5.config().a;
        L19:
            if (r6 != null) goto L22;
            return;
        L22:
            if (PdpPerfOpt.c() == false) goto L24;
            r0.O1().b().e1(new h(r0, r6));
            return;
        L24:
            r0.p2(r6, false);
            return;
        L7:
            Object r2 = null;
            if ((r5 instanceof com.bytedance.android.ecom.arch.slice.slices.template.d) == false) goto L18;
            Map r7 = ((com.bytedance.android.ecom.arch.slice.slices.template.d) r5).getConfig();
            if (r7 == null) goto L12;
            Object r8 = r7.get("scroll_id");
        L14:
            if ((r8 instanceof String) == false) goto L17;
            r2 = r8;
        L17:
            r6 = (String) r2;
            goto L19
        L12:
            r8 = null;
            goto L14
        L18:
            r6 = null;
            goto L19
        }
    }

    public TopNavigationComponentV2$onAttach$5(TopNavigationComponentV2 r1, Continuation r2) {
        this.this$0 = r1;
        super(3, r2);
    }

    public final Continuation<Unit> create(CoroutineScope r2, d0 r3, Continuation<? super Unit> r4) {
        Intrinsics.checkNotNullParameter(r2, "$this$create");
        Intrinsics.checkNotNullParameter(r3, "ability");
        Intrinsics.checkNotNullParameter(r4, "continuation");
        TopNavigationComponentV2$onAttach$5 r5 = new TopNavigationComponentV2$onAttach$5(this.this$0, r4);
        r5.L$0 = r3;
        return r5;
    }

    public final Object invoke(Object r1, Object r2, Object r3) {
        return create((CoroutineScope) r1, (d0) r2, (Continuation) r3).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r4);
        d0 r5 = (d0) this.L$0;
        r5.X0(new AnonymousClass1(this));
        com.bytedance.android.shopping.prepurchase.arch.container.state.e.a.a(r5.R(), this.this$0, new a(this));
        com.bytedance.android.shopping.prepurchase.arch.container.state.e.a.a(r5.z0(), this.this$0, new b(this));
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
