package com.bytedance.android.shopping.prepurchase.business.pdp.services.slice;

import com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature.LynxAbilityImpl;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;
import vg3.x;
import vg3.y;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lvg3/y;", "prefAbility", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.shopping.prepurchase.business.pdp.services.slice.PdpDynamicFeatureService$lazyInit$1", f = "PdpDynamicFeatureService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class PdpDynamicFeatureService$lazyInit$1 extends SuspendLambda implements Function3<CoroutineScope, y, Continuation<? super Unit>, Object> {
    final /* synthetic */ x $ability;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ PdpDynamicFeatureService this$0;

    public static final class a extends com.bytedance.android.shopping.prepurchase.arch.container.ability.b {
        public final /* synthetic */ PdpDynamicFeatureService$lazyInit$1 c;

        /* JADX INFO: renamed from: com.bytedance.android.shopping.prepurchase.business.pdp.services.slice.PdpDynamicFeatureService$lazyInit$1$a$a, reason: collision with other inner class name */
        public static final class C0173a<T> implements com.bytedance.android.shopping.prepurchase.arch.container.state.g {
            public final /* synthetic */ a a;

            public C0173a(a r1) {
                this.a = r1;
            }

            @Override // com.bytedance.android.shopping.prepurchase.arch.container.state.g
            public final void onChanged(Object r4) {
                JSONObject r5 = (JSONObject) r4;
                if (r5 == null) goto L14;
                LynxAbilityImpl r0 = this.a.c.this$0.a2();
                JSONObject r1 = new JSONObject();
                Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L8
                r1.put("pdp_lynx_data", r5);     // Catch: Throwable -> L8
                Result.constructor-impl(r1.put("identifier", this.a.c.this$0.O1().f().a.b));     // Catch: Throwable -> L8
            L10:
                Unit r6 = Unit.INSTANCE;
                r0.B("pdp_update_lynx_data", r1);
                return;
            L8:
                th = move-exception;
                Result.Companion r3 = Result.Companion;
                Result.constructor-impl(ResultKt.createFailure(th));
                goto L10
            }
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.bytedance.android.shopping.prepurchase.arch.container.state.e.a.a((com.bytedance.android.shopping.prepurchase.arch.container.state.e) this.c.$ability.getData().D.getValue(), this.c.this$0, new C0173a(this));
        }

        public a(PdpDynamicFeatureService$lazyInit$1 r1) {
            this.c = r1;
            super("pdpLynxDataAfterPackObservable");
        }
    }

    public PdpDynamicFeatureService$lazyInit$1(PdpDynamicFeatureService r1, x r2, Continuation r3) {
        this.this$0 = r1;
        this.$ability = r2;
        super(3, r3);
    }

    public final Continuation<Unit> create(CoroutineScope r3, y r4, Continuation<? super Unit> r5) {
        Intrinsics.checkNotNullParameter(r3, "$this$create");
        Intrinsics.checkNotNullParameter(r4, "prefAbility");
        Intrinsics.checkNotNullParameter(r5, "continuation");
        PdpDynamicFeatureService$lazyInit$1 r6 = new PdpDynamicFeatureService$lazyInit$1(this.this$0, this.$ability, r5);
        r6.L$0 = r4;
        return r6;
    }

    public final Object invoke(Object r1, Object r2, Object r3) {
        return create((CoroutineScope) r1, (y) r2, (Continuation) r3).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r2) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r2);
        ((y) this.L$0).e1(new a(this));
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
