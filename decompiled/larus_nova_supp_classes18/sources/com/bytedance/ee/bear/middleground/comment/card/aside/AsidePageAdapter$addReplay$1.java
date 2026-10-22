package com.bytedance.ee.bear.middleground.comment.card.aside;

import com.bytedance.ee.bear.middleground.comment.export.bean.CommentInputRequest;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ee.bear.middleground.comment.card.aside.AsidePageAdapter$addReplay$1", f = "AsidePageAdapter.kt", i = {0}, l = {162}, m = "invokeSuspend", n = {"position"}, s = {"I$0"})
public final class AsidePageAdapter$addReplay$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ CommentInputRequest $input;
    int I$0;
    int label;
    final /* synthetic */ AsidePageAdapter this$0;

    public AsidePageAdapter$addReplay$1(AsidePageAdapter r1, CommentInputRequest r2, Continuation<? super AsidePageAdapter$addReplay$1> r3) {
        this.this$0 = r1;
        this.$input = r2;
        super(1, r3);
    }

    public final Continuation<Unit> create(Continuation<?> r4) {
        return new AsidePageAdapter$addReplay$1(this.this$0, this.$input, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((Continuation) r1);
    }

    public final Object invoke(Continuation<? super Unit> r2) {
        return create(r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        int r2 = this.I$0;
        ResultKt.throwOnFailure(r6);
    L18:
        this.this$0.notifyItemChanged(r2, new Object());
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        com.bytedance.ee.bear.middleground.comment.card.d r7 = this.this$0.j;
        if (r7 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("cardDataViewModel");
        r7 = null;
    L11:
        int r8 = r7.i(this.$input.comment_id);
        AsidePageAdapter.ViewHolder r3 = (AsidePageAdapter.ViewHolder) ((LinkedHashMap) this.this$0.m).get(Boxing.boxInt(r8));
        if (r3 == null) goto L14;
        r3.h = this.$input;
    L14:
        AsidePageAdapter r4 = this.this$0;
        Integer r5 = Boxing.boxInt(r8);
        this.I$0 = r8;
        this.label = 1;
        if (r4.G2(r5, false, null, this) != r0) goto L17;
        return r0;
    L17:
        r2 = r8;
        goto L18
    }
}
