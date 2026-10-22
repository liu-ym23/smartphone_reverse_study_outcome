package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent;

import com.bytedance.android.shopping.prepurchase.business.pdp.services.event.ProductDetailEventService;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
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
import vg3.i0;
import vg3.n0;
import vg3.w;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lvg3/i0;", "it", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.BackToTopEntryComponent$onAttach$2", f = "BackToTopEntryComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class BackToTopEntryComponent$onAttach$2 extends SuspendLambda implements Function3<CoroutineScope, i0, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ BackToTopEntryComponent this$0;

    public static final class a<T> implements com.bytedance.android.shopping.prepurchase.arch.container.state.g {
        public final /* synthetic */ BackToTopEntryComponent$onAttach$2 a;

        public a(BackToTopEntryComponent$onAttach$2 r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.shopping.prepurchase.arch.container.state.g
        public final void onChanged(Object r7) {
            n0 r8 = (n0) r7;
            Intrinsics.checkNotNullParameter(r8, "info");
            BackToTopEntryComponent r0 = this.a.this$0;
            int r1 = r8.a;
            r0.getClass();
            String r9 = r8.b;
            ECDraweeView r2 = r0.m;
            if (r2 != null) goto L6;
            return;
        L6:
            if (r1 < 2) goto L8;
        L11:
            boolean r10 = true;
        L12:
            if (r10 == false) goto L18;
            r2.setVisibility(0);
            w r11 = (w) r0.N1(w.class);
            if (r11 == null) goto L20;
            ProductDetailEventService.b r3 = r11.m();
            if (r3 == null) goto L21;
            com.bytedance.android.shopping.prepurchase.arch.container.ability.m.a.a(r3, "back_to_top_button_show", false, null, null, 12);
            return;
        L21:
            return;
        L20:
            return;
        L18:
            r2.setVisibility(8);
            return;
        L8:
            if (Intrinsics.areEqual(r9, "id_recommend") == true) goto L11;
            r10 = false;
            goto L12
        }
    }

    public BackToTopEntryComponent$onAttach$2(BackToTopEntryComponent r1, Continuation r2) {
        this.this$0 = r1;
        super(3, r2);
    }

    public final Continuation<Unit> create(CoroutineScope r2, i0 r3, Continuation<? super Unit> r4) {
        Intrinsics.checkNotNullParameter(r2, "$this$create");
        Intrinsics.checkNotNullParameter(r3, "it");
        Intrinsics.checkNotNullParameter(r4, "continuation");
        BackToTopEntryComponent$onAttach$2 r5 = new BackToTopEntryComponent$onAttach$2(this.this$0, r4);
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
