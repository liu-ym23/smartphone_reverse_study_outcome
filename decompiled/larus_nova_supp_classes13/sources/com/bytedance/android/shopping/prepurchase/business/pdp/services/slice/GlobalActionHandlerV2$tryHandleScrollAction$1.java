package com.bytedance.android.shopping.prepurchase.business.pdp.services.slice;

import com.bytedance.android.ecom.arch.slice.action.IAction;
import com.bytedance.android.shopping.anchorv4.dto.Control;
import com.bytedance.android.shopping.anchorv4.dto.ScrollNode;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.shopping.prepurchase.business.pdp.services.slice.GlobalActionHandlerV2$tryHandleScrollAction$1", f = "GlobalActionHandlerV2.kt", i = {}, l = {77}, m = "invokeSuspend", n = {}, s = {})
final class GlobalActionHandlerV2$tryHandleScrollAction$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Control $control;
    final /* synthetic */ int $scrollDy;
    final /* synthetic */ List $scrollNodes;
    final /* synthetic */ int $tabIndex;
    int label;
    final /* synthetic */ c this$0;

    public GlobalActionHandlerV2$tryHandleScrollAction$1(c r1, int r2, Control r3, List r4, int r5, Continuation r6) {
        this.this$0 = r1;
        this.$scrollDy = r2;
        this.$control = r3;
        this.$scrollNodes = r4;
        this.$tabIndex = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        Intrinsics.checkNotNullParameter(r9, "completion");
        return new GlobalActionHandlerV2$tryHandleScrollAction$1(this.this$0, this.$scrollDy, this.$control, this.$scrollNodes, this.$tabIndex, r9);
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
    L12:
        if (((com.bytedance.android.shopping.prepurchase.arch.container.ability.l) r4).e0() == false) goto L14;
        e73.a r5 = this.this$0.a;
        if (r5 != null) goto L20;
        return Unit.INSTANCE;
    L20:
        if (r5.f() == null) goto L28;
        int r2 = this.$scrollDy;
        Control r3 = this.$control;
        if (r3 == null) goto L24;
        int r6 = r3.getPageSlideActionsOffset();
    L25:
        if (r2 <= r6) goto L28;
        IAction r7 = r5.f();
    L39:
        if (r7 == null) goto L41;
        this.this$0.b(r7);
        return Unit.INSTANCE;
    L41:
        return Unit.INSTANCE;
    L24:
        r6 = 0;
    L28:
        if (r5.g() == null) goto L38;
        List r8 = this.$scrollNodes;
        if (r8 == null) goto L34;
        ScrollNode r9 = (ScrollNode) CollectionsKt.getOrNull(r8, this.$tabIndex);
        if (r9 == null) goto L34;
        String r10 = r9.getId();
    L36:
        if (Intrinsics.areEqual(r10, "id_comments") == false) goto L38;
        r7 = r5.g();
    L34:
        r10 = null;
    L38:
        r7 = null;
        goto L39
    L14:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        com.bytedance.android.shopping.prepurchase.arch.container.component.j r11 = this.this$0.f;
        this.label = 1;
        r4 = r11.e(com.bytedance.android.shopping.prepurchase.arch.container.ability.l.class, this);
        if (r4 != r0) goto L12;
        return r0;
    }
}
