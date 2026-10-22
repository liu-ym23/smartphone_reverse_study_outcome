package com.bytedance.android.shopping.prepurchase.business.pdp.components;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.shopping.prepurchase.arch.container.component.Component;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.shopping.prepurchase.business.pdp.components.PdpRootComponent$showPdpLynxToast$1", f = "PdpRootComponent.kt", i = {0}, l = {637}, m = "invokeSuspend", n = {"component"}, s = {"L$0"})
public final class PdpRootComponent$showPdpLynxToast$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Long $duration;
    final /* synthetic */ Map $queryParams;
    final /* synthetic */ String $url;
    Object L$0;
    int label;
    final /* synthetic */ PdpRootComponent this$0;

    public PdpRootComponent$showPdpLynxToast$1(PdpRootComponent r1, String r2, Map r3, Long r4, Continuation r5) {
        this.this$0 = r1;
        this.$url = r2;
        this.$queryParams = r3;
        this.$duration = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        Intrinsics.checkNotNullParameter(r8, "completion");
        return new PdpRootComponent$showPdpLynxToast$1(this.this$0, this.$url, this.$queryParams, this.$duration, r8);
    }

    public final Object invoke(Object r1, Object r2) {
        return create(r1, (Continuation) r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.e r2 = (com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.e) this.L$0;
        ResultKt.throwOnFailure(r7);
    L18:
        PdpRootComponent r8 = this.this$0;
        r8.getClass();
        Intrinsics.checkNotNullParameter(r2, "component");
        r8.d2().e(r2);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.e r9 = new com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.e(this.$url, this.$queryParams);
        PdpRootComponent r3 = this.this$0;
        View r4 = r3.e2();
        if (r4 == null) goto L21;
        FrameLayout.LayoutParams r5 = new FrameLayout.LayoutParams(-1, -1);
        r5.gravity = 17;
        Unit r6 = Unit.INSTANCE;
        Component.a2(r3, (ViewGroup) r4, r9, r5, 8);
        Long r10 = this.$duration;
        if (r10 == null) goto L13;
        long r11 = r10.longValue();
    L14:
        this.L$0 = r9;
        this.label = 1;
        if (DelayKt.delay(r11, this) != r0) goto L17;
        return r0;
    L17:
        r2 = r9;
        goto L18
    L13:
        r11 = 3000;
        goto L14
    L21:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    }
}
