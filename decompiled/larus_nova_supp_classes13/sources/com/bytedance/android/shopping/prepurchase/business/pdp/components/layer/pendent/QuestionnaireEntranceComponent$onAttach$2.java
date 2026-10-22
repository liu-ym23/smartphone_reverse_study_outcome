package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent;

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
import org.json.JSONObject;
import vg3.i0;
import vg3.n0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lvg3/i0;", "it", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.QuestionnaireEntranceComponent$onAttach$2", f = "QuestionnaireEntranceComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class QuestionnaireEntranceComponent$onAttach$2 extends SuspendLambda implements Function3<CoroutineScope, i0, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ QuestionnaireEntranceComponent this$0;

    public static final class a<T> implements com.bytedance.android.shopping.prepurchase.arch.container.state.g {
        public final /* synthetic */ QuestionnaireEntranceComponent$onAttach$2 a;

        public a(QuestionnaireEntranceComponent$onAttach$2 r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.shopping.prepurchase.arch.container.state.g
        public final void onChanged(Object r8) {
            n0 r9 = (n0) r8;
            Intrinsics.checkNotNullParameter(r9, "info");
            QuestionnaireEntranceComponent r0 = this.a.this$0;
            String r10 = r9.b;
            if (r0.m == null) goto L15;
            if (r10 != null) goto L8;
            return;
        L8:
            if (Intrinsics.areEqual(r0.o, r10) == true) goto L17;
            ti.l r1 = r0.n;
            if (r1 == null) goto L13;
            JSONObject r2 = new JSONObject();
            r2.put("identifier", r0.g2().getSessionId());
            r2.put("current_section", r10);
            r2.put("timestamp", System.currentTimeMillis() / ((long) 1000));
            Unit r3 = Unit.INSTANCE;
            r1.sendJsEvent("pdp_page_scroll", r2);
        L13:
            r0.o = r10;
            return;
        L17:
            return;
        }
    }

    public QuestionnaireEntranceComponent$onAttach$2(QuestionnaireEntranceComponent r1, Continuation r2) {
        this.this$0 = r1;
        super(3, r2);
    }

    public final Continuation<Unit> create(CoroutineScope r2, i0 r3, Continuation<? super Unit> r4) {
        Intrinsics.checkNotNullParameter(r2, "$this$create");
        Intrinsics.checkNotNullParameter(r3, "it");
        Intrinsics.checkNotNullParameter(r4, "continuation");
        QuestionnaireEntranceComponent$onAttach$2 r5 = new QuestionnaireEntranceComponent$onAttach$2(this.this$0, r4);
        r5.L$0 = r3;
        return r5;
    }

    public final Object invoke(Object r1, Object r2, Object r3) {
        return create((CoroutineScope) r1, (i0) r2, (Continuation) r3).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r3);
        com.bytedance.android.shopping.prepurchase.arch.container.state.e.a.a(((i0) this.L$0).q1(), this.this$0, new a(this));
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
