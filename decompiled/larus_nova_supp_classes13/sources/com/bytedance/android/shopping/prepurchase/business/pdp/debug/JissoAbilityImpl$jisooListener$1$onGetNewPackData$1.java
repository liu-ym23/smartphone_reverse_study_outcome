package com.bytedance.android.shopping.prepurchase.business.pdp.debug;

import com.bytedance.android.shopping.anchorv4.dto.PackResponseDTO;
import com.bytedance.android.shopping.prepurchase.arch.container.component.j;
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
import vg3.x;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.shopping.prepurchase.business.pdp.debug.JissoAbilityImpl$jisooListener$1$onGetNewPackData$1", f = "JissoAbilityImpl.kt", i = {}, l = {18}, m = "invokeSuspend", n = {}, s = {})
public final class JissoAbilityImpl$jisooListener$1$onGetNewPackData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ PackResponseDTO $dto;
    int label;
    final /* synthetic */ JissoAbilityImpl$jisooListener$1 this$0;

    public JissoAbilityImpl$jisooListener$1$onGetNewPackData$1(JissoAbilityImpl$jisooListener$1 r1, PackResponseDTO r2, Continuation r3) {
        this.this$0 = r1;
        this.$dto = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        Intrinsics.checkNotNullParameter(r4, "completion");
        return new JissoAbilityImpl$jisooListener$1$onGetNewPackData$1(this.this$0, this.$dto, r4);
    }

    public final Object invoke(Object r1, Object r2) {
        return create(r1, (Continuation) r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r4);
    L11:
        ((x) r4).D1(this.$dto);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        j r5 = this.this$0.a.b;
        this.label = 1;
        r4 = r5.e(x.class, this);
        if (r4 != r0) goto L11;
        return r0;
    }
}
