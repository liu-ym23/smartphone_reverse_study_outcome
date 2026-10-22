package com.bytedance.android.shopping.prepurchase.business.pdp.services.slice;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.ec.core.anchorv3.PdpPerfOpt;
import com.bytedance.android.ec.core.utils.UIUtils;
import com.bytedance.android.shopping.anchorv4.helper.PdpIndexActionHelper;
import com.larus.apm.impl.protector.RunnableProtector;
import fi3.c0;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import vg3.x;
import vg3.y;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lvg3/x;", "ability", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.shopping.prepurchase.business.pdp.services.slice.PdpDynamicFeatureService$initActionStorage$1", f = "PdpDynamicFeatureService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class PdpDynamicFeatureService$initActionStorage$1 extends SuspendLambda implements Function3<CoroutineScope, x, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ PdpDynamicFeatureService this$0;

    public static final class a<T> implements com.bytedance.android.shopping.prepurchase.arch.container.state.g {
        public final /* synthetic */ PdpDynamicFeatureService$initActionStorage$1 a;

        public a(PdpDynamicFeatureService$initActionStorage$1 r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.shopping.prepurchase.arch.container.state.g
        public final void onChanged(Object r2) {
            Map r3 = (Map) r2;
            if (r3 == null) goto L7;
            ((PdpIndexActionHelper) this.a.this$0.u.getValue()).update(r3);
            return;
        }
    }

    public static final class b<T> implements com.bytedance.android.shopping.prepurchase.arch.container.state.g {
        public final /* synthetic */ PdpDynamicFeatureService$initActionStorage$1 a;
        public final /* synthetic */ x b;

        public b(PdpDynamicFeatureService$initActionStorage$1 r1, x r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // com.bytedance.android.shopping.prepurchase.arch.container.state.g
        public final void onChanged(Object r3) {
            com.bytedance.android.shopping.prepurchase.arch.container.intf.k r4 = (com.bytedance.android.shopping.prepurchase.arch.container.intf.k) r3;
            Intrinsics.checkNotNullParameter(r4, "it");
            PdpDynamicFeatureService r0 = this.a.this$0;
            if (r0.m == true) goto L6;
            return;
        L6:
            if ((r4 instanceof com.bytedance.android.shopping.prepurchase.arch.container.intf.k.d.a) == false) goto L8;
        L13:
            r0.m = false;
        L14:
            r0.n = this.b.getData().b().a();
            return;
        L8:
            if ((r4 instanceof com.bytedance.android.shopping.prepurchase.arch.container.intf.k.d.c) == true) goto L13;
            if ((r4 instanceof com.bytedance.android.shopping.prepurchase.arch.container.intf.k.d.b) == false) goto L14;
            com.bytedance.android.shopping.prepurchase.arch.container.intf.k.d.b r5 = (com.bytedance.android.shopping.prepurchase.arch.container.intf.k.d.b) r4;
            if (r5.b != (r5.c - 1)) goto L14;
            goto L13
        }
    }

    public static final class c<T> implements com.bytedance.android.shopping.prepurchase.arch.container.state.g {
        public final /* synthetic */ PdpDynamicFeatureService$initActionStorage$1 a;

        public c(PdpDynamicFeatureService$initActionStorage$1 r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.shopping.prepurchase.arch.container.state.g
        public final void onChanged(Object r9) {
            e73.a r10 = (e73.a) r9;
            if (r10 == null) goto L22;
            PdpDynamicFeatureService r0 = this.a.this$0;
            if (r0.o != null) goto L8;
            FragmentActivity r1 = r0.O1().getContainerAbility().mo2525getContext();
            PdpDynamicFeatureService r2 = this.a.this$0;
            r2.o = new com.bytedance.android.shopping.prepurchase.business.pdp.services.slice.c(r1, r2, r2.R1(), this.a.this$0.b2());
        L8:
            com.bytedance.android.shopping.prepurchase.business.pdp.services.slice.c r3 = this.a.this$0.o;
            if (r3 == null) goto L11;
            Intrinsics.checkNotNullParameter(r10, "group");
            r3.a = r10;
        L11:
            com.bytedance.android.shopping.prepurchase.business.pdp.services.slice.c r11 = this.a.this$0.o;
            if (r11 == null) goto L21;
            e73.a r4 = r11.a;
            if (r4 != null) goto L17;
            return;
        L17:
            if (PdpPerfOpt.c() == true) goto L19;
            r11.a(r4);
        L19:
            BuildersKt.launch$default(com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.f.a(r11.e.getLifecycle()), Dispatchers.getMain().getImmediate(), null, new GlobalActionHandlerV2$tryHandleActionOpt$1(r11, r4, null), 2, null);
            return;
        L21:
            return;
        }
    }

    public static final class d<T> implements com.bytedance.android.shopping.prepurchase.arch.container.state.g {
        public final /* synthetic */ PdpDynamicFeatureService$initActionStorage$1 a;

        public d(PdpDynamicFeatureService$initActionStorage$1 r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.shopping.prepurchase.arch.container.state.g
        public final void onChanged(Object r4) {
            float r5 = ((Number) r4).floatValue();
            if (this.a.this$0.q == false) goto L5;
            return;
        L5:
            if (r5 < 0) goto L10;
            int r0 = c0.e;
            this.a.this$0.b2().y0(c0.a.a("BaseInfoOffset", MapsKt.mapOf(TuplesKt.to("offset", Float.valueOf(r5))), null, 10), new com.bytedance.android.ecom.arch.slice.action.c(null, null), null);
            return;
        }
    }

    public static final class e implements Runnable {
        public final /* synthetic */ PdpDynamicFeatureService$initActionStorage$1 a;
        public final /* synthetic */ x b;

        public e(PdpDynamicFeatureService$initActionStorage$1 r1, x r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            PdpDynamicFeatureService r0 = this.a.this$0;     // Catch: Throwable -> L4
            x r1 = this.b;     // Catch: Throwable -> L4
            int r2 = PdpDynamicFeatureService.v;     // Catch: Throwable -> L4
            r0.getClass();     // Catch: Throwable -> L4
            r0.Z1(y.class, new PdpDynamicFeatureService$lazyInit$1(r0, r1, null));     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public PdpDynamicFeatureService$initActionStorage$1(PdpDynamicFeatureService r1, Continuation r2) {
        this.this$0 = r1;
        super(3, r2);
    }

    public final Continuation<Unit> create(CoroutineScope r2, x r3, Continuation<? super Unit> r4) {
        Intrinsics.checkNotNullParameter(r2, "$this$create");
        Intrinsics.checkNotNullParameter(r3, "ability");
        Intrinsics.checkNotNullParameter(r4, "continuation");
        PdpDynamicFeatureService$initActionStorage$1 r5 = new PdpDynamicFeatureService$initActionStorage$1(this.this$0, r4);
        r5.L$0 = r3;
        return r5;
    }

    public final Object invoke(Object r1, Object r2, Object r3) {
        return create((CoroutineScope) r1, (x) r2, (Continuation) r3).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r5);
        x r6 = (x) this.L$0;
        com.bytedance.android.shopping.prepurchase.arch.container.state.e.a.a((com.bytedance.android.shopping.prepurchase.arch.container.state.e) r6.getData().B.getValue(), this.this$0, new a(this));
        com.bytedance.android.shopping.prepurchase.arch.container.state.e.a.a(r6.q0(), this.this$0, new b(this, r6));
        com.bytedance.android.shopping.prepurchase.arch.container.state.e.a.a((com.bytedance.android.shopping.prepurchase.arch.container.state.e) r6.getData().C.getValue(), this.this$0, new c(this));
        ((com.bytedance.android.shopping.prepurchase.business.pdp.e) com.bytedance.android.shopping.prepurchase.arch.container.e.a(this.this$0.O1())).b.c.b(this.this$0, com.bytedance.android.shopping.prepurchase.arch.container.state.j.a(), new d(this));
        e r0 = new e(this, r6);
        this.this$0.r = r0;
        Lazy r7 = UIUtils.a;
        UIUtils.c().postAtFrontOfQueue(r0);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
