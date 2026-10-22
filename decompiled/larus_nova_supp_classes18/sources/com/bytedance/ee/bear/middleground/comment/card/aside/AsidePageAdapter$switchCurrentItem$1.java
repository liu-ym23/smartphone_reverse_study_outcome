package com.bytedance.ee.bear.middleground.comment.card.aside;

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
@DebugMetadata(c = "com.bytedance.ee.bear.middleground.comment.card.aside.AsidePageAdapter$switchCurrentItem$1", f = "AsidePageAdapter.kt", i = {}, l = {136}, m = "invokeSuspend", n = {}, s = {})
final class AsidePageAdapter$switchCurrentItem$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ String $commentId;
    final /* synthetic */ boolean $smooth;
    int label;
    final /* synthetic */ AsidePageAdapter this$0;

    public AsidePageAdapter$switchCurrentItem$1(AsidePageAdapter r1, String r2, boolean r3, Continuation<? super AsidePageAdapter$switchCurrentItem$1> r4) {
        this.this$0 = r1;
        this.$commentId = r2;
        this.$smooth = r3;
        super(1, r4);
    }

    public final Continuation<Unit> create(Continuation<?> r5) {
        return new AsidePageAdapter$switchCurrentItem$1(this.this$0, this.$commentId, this.$smooth, r5);
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
        ResultKt.throwOnFailure(r6);
    L19:
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
        int r8 = r7.i(this.$commentId);
        if (r8 != (-2)) goto L15;
        tt5.a.k("Comment#CommentPagerAdapter2", "switchCurrentItem commentId not found position = " + r8);
        return Unit.INSTANCE;
    L15:
        AsidePageAdapter r3 = this.this$0;
        Integer r9 = Boxing.boxInt(r8);
        boolean r4 = this.$smooth;
        this.label = 1;
        if (r3.G2(r9, r4, null, this) != r0) goto L19;
        return r0;
    }
}
