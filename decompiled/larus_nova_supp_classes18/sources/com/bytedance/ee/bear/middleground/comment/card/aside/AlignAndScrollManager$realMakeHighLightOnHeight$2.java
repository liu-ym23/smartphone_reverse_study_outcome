package com.bytedance.ee.bear.middleground.comment.card.aside;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ee.bear.middleground.comment.card.aside.AlignAndScrollManager$realMakeHighLightOnHeight$2", f = "AlignAndScrollManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class AlignAndScrollManager$realMakeHighLightOnHeight$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ int $height;
    final /* synthetic */ int $position;
    int label;
    final /* synthetic */ AlignAndScrollManager this$0;

    public AlignAndScrollManager$realMakeHighLightOnHeight$2(AlignAndScrollManager r1, int r2, int r3, Continuation<? super AlignAndScrollManager$realMakeHighLightOnHeight$2> r4) {
        this.this$0 = r1;
        this.$position = r2;
        this.$height = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new AlignAndScrollManager$realMakeHighLightOnHeight$2(this.this$0, this.$position, this.$height, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Boolean> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L15;
        ResultKt.throwOnFailure(r5);
        Integer r6 = this.this$0.a(this.$position);
        boolean r0 = false;
        if (r6 == null) goto L13;
        int r7 = r6.intValue();
        StringBuilder r1 = new StringBuilder("realMakeHighLightOnHeight position:");
        r1.append(this.$position);
        r1.append(" height:");
        r1.append(this.$height);
        r1.append(" currHeight:");
        r1.append(r7);
        r1.append(", (");
        int r2 = this.$height;
        int r3 = AsidePageAdapter.u;
        int r4 = AsidePageAdapter.u;
        r1.append(r2 - r4);
        r1.append(", ");
        r1.append(this.$height + r4);
        r1.append(')');
        tt5.a.h("Comment#AlignAndScrollManager", r1.toString());
        int r8 = this.$height;
        int r9 = r8 - r4;
        int r10 = r8 + r4;
        if (r9 > r7) goto L11;
        if (r7 > r10) goto L11;
        r0 = true;
    L11:
        return Boxing.boxBoolean(r0);
    L13:
        return Boxing.boxBoolean(false);
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
