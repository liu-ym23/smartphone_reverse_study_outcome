package com.bytedance.ee.bear.middleground.comment.card.aside;

import com.bytedance.ee.bear.middleground.comment.export.bean.ScrollCommentBean;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ee.bear.middleground.comment.card.aside.AsideComment$commentCardScrollTo$1", f = "AsideComment.kt", i = {}, l = {340}, m = "invokeSuspend", n = {}, s = {})
public final class AsideComment$commentCardScrollTo$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ ScrollCommentBean $scrollCommentBean;
    int label;
    final /* synthetic */ AsideComment this$0;

    public AsideComment$commentCardScrollTo$1(AsideComment r1, ScrollCommentBean r2, Continuation<? super AsideComment$commentCardScrollTo$1> r3) {
        this.this$0 = r1;
        this.$scrollCommentBean = r2;
        super(1, r3);
    }

    public final Continuation<Unit> create(Continuation<?> r4) {
        return new AsideComment$commentCardScrollTo$1(this.this$0, this.$scrollCommentBean, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((Continuation) r1);
    }

    public final Object invoke(Continuation<? super Unit> r2) {
        return create(r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r7);
    L34:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        int r8 = this.this$0.n.i(this.$scrollCommentBean.cur_comment_id);
        if (this.$scrollCommentBean.replyId.equals(ScrollCommentBean.HEAD) == false) goto L11;
        int r2 = 0;
    L15:
        Integer r5 = this.this$0.m.o;
        if (r5 != null) goto L19;
    L24:
        AsidePageAdapter r3 = this.this$0.m;
        float r4 = this.$scrollCommentBean.replyPercentage;
        this.label = 1;
        AlignAndScrollManager r6 = r3.s;
        if (r6 == null) goto L30;
        Object r9 = r6.i(r8, r2, r4, this);
        if (r9 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L31;
        r9 = Unit.INSTANCE;
    L31:
        if (r9 != r0) goto L34;
        return r0;
    L30:
        r9 = Unit.INSTANCE;
        goto L31
    L19:
        if (r8 != r5.intValue()) goto L24;
        if (this.$scrollCommentBean.replyId.equals(ScrollCommentBean.HEAD) == false) goto L24;
        tt5.a.h("Comment#AsideComment", "outPosition == currentPos and replyId is HEAD");
        return Unit.INSTANCE;
    L11:
        r2 = this.this$0.n.h(r8, this.$scrollCommentBean.replyId);
        if (r2 >= 0) goto L15;
        tt5.a.h("Comment#AsideComment", "commentCardScrollTo: replyId fail");
        return Unit.INSTANCE;
    }
}
