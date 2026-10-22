package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.lynx;

import com.android.ttcjpaysdk.base.ktextension.KtSafeMethodExtensionKt;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.shopping.prepurchase.arch.container.state.g;
import java.util.Iterator;
import java.util.Map;
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
import ti.l;
import vg3.i0;
import vg3.n0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lvg3/i0;", "it", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.lynx.LynxPendentComponent$onAttach$4", f = "LynxPendentComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class LynxPendentComponent$onAttach$4 extends SuspendLambda implements Function3<CoroutineScope, i0, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ LynxPendentComponent this$0;

    public static final class a<T> implements g {
        public final /* synthetic */ LynxPendentComponent$onAttach$4 a;

        public a(LynxPendentComponent$onAttach$4 r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.shopping.prepurchase.arch.container.state.g
        public final void onChanged(Object r8) {
            n0 r9 = (n0) r8;
            Intrinsics.checkNotNullParameter(r9, "it");
            com.bytedance.android.shopping.prepurchase.arch.container.component.b.a(this.a.this$0, "elevatorLobby: " + r9.b);
            c r0 = LynxPendentComponent.h2(this.a.this$0);
            String r10 = r9.b;
            if (r0.a == null) goto L36;
            if (r10 == null) goto L37;
            Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L20
            if ((!Intrinsics.areEqual(r0.d, r10)) == false) goto L18;
            Iterator<Map.Entry<String, com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.c>> r2 = r0.b.entrySet().iterator();     // Catch: Throwable -> L20
        L11:
            if (r2.hasNext() == false) goto L17;
            com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.c r3 = r2.next().getValue();     // Catch: Throwable -> L20
            if (r3 == null) goto L11;
            l r4 = r3.b;     // Catch: Throwable -> L20
            if (r4 == null) goto L11;
            JSONObject r5 = new JSONObject();     // Catch: Throwable -> L20
            KtSafeMethodExtensionKt.safePut(r5, "identifier", r0.e);     // Catch: Throwable -> L20
            KtSafeMethodExtensionKt.safePut(r5, "current_section", r10);     // Catch: Throwable -> L20
            Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L20
            r4.sendJsEvent("pdp_page_scroll", r5);     // Catch: Throwable -> L20
            goto L11
        L17:
            r0.d = r10;     // Catch: Throwable -> L20
        L18:
            Object r11 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L20
        L22:
            Throwable r12 = Result.exceptionOrNull-impl(r11);
            if (r12 == null) goto L35;
            ECExceptionMonitor.e(r12);
            return;
        L35:
            return;
        L20:
            th = move-exception;
            Result.Companion r7 = Result.Companion;
            r11 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L22
        L37:
            return;
        }
    }

    public LynxPendentComponent$onAttach$4(LynxPendentComponent r1, Continuation r2) {
        this.this$0 = r1;
        super(3, r2);
    }

    public final Continuation<Unit> create(CoroutineScope r2, i0 r3, Continuation<? super Unit> r4) {
        Intrinsics.checkNotNullParameter(r2, "$this$create");
        Intrinsics.checkNotNullParameter(r3, "it");
        Intrinsics.checkNotNullParameter(r4, "continuation");
        LynxPendentComponent$onAttach$4 r5 = new LynxPendentComponent$onAttach$4(this.this$0, r4);
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
