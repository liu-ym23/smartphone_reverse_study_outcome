package com.bytedance.ee.bear.middleground.comment.card.aside;

import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import com.bytedance.ee.bear.middleground.comment.uitls.p;
import com.bytedance.ee.util.ui.n;
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
@DebugMetadata(c = "com.bytedance.ee.bear.middleground.comment.card.aside.AsidePageAdapter$clickItem$1", f = "AsidePageAdapter.kt", i = {0, 0, 0, 0, 0}, l = {282, 285, 288}, m = "invokeSuspend", n = {"currentIndex", "height", "commentId", "commentUUID", "commentType"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"})
final class AsidePageAdapter$clickItem$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ int $position;
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ AsidePageAdapter this$0;

    public AsidePageAdapter$clickItem$1(int r1, AsidePageAdapter r2, Continuation<? super AsidePageAdapter$clickItem$1> r3) {
        this.$position = r1;
        this.this$0 = r2;
        super(1, r3);
    }

    public final Continuation<Unit> create(Continuation<?> r4) {
        return new AsidePageAdapter$clickItem$1(this.$position, this.this$0, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((Continuation) r1);
    }

    public final Object invoke(Continuation<? super Unit> r2) {
        return create(r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r18) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L12;
        if (r2 == 1) goto L11;
        if (r2 == 2) goto L10;
        if (r2 != 3) goto L9;
        ResultKt.throwOnFailure(r18);
    L71:
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        ResultKt.throwOnFailure(r18);
    L66:
        return Unit.INSTANCE;
    L11:
        int r3 = this.I$0;
        String r4 = (String) this.L$3;
        String r5 = (String) this.L$2;
        Integer r7 = (Integer) this.L$1;
        Integer r8 = (Integer) this.L$0;
        ResultKt.throwOnFailure(r18);
        Integer r9 = r8;
        Integer r10 = r7;
        String r11 = r5;
        Object r6 = r18;
    L55:
        Boolean r12 = (Boolean) r6;
        int r13 = r3;
        String r14 = r4;
        String r15 = r11;
        Integer r16 = r10;
        Integer r17 = r9;
    L57:
        p r19 = this.this$0.d;
        if (r19 != null) goto L60;
        Intrinsics.throwUninitializedPropertyAccessException("config");
        r19 = null;
    L60:
        r19.N.a(new ef5.j(Boxing.boxInt(this.$position), r13, r15, r14, r15, r16));
        AlignAndScrollManager r20 = this.this$0.s;
        if (r20 == null) goto L66;
        int r21 = r17.intValue();
        this.L$0 = null;
        this.L$1 = null;
        this.L$2 = null;
        this.L$3 = null;
        this.label = 2;
        if (r20.f(r21, this) != r1) goto L66;
        return r1;
    L12:
        ResultKt.throwOnFailure(r18);
        tt5.a.h("Comment#CommentPagerAdapter2", "onPageSelected()... position = " + this.$position + ", currentIndex = " + this.this$0.o);
        r17 = this.this$0.o;
        int r22 = this.$position;
        if (r17 != null) goto L16;
    L67:
        AsidePageAdapter r23 = this.this$0;
        Integer r24 = Boxing.boxInt(this.$position);
        this.label = 3;
        if (r23.G2(r24, true, null, this) != r1) goto L71;
        return r1;
    L16:
        if (r17.intValue() != r22) goto L67;
        this.this$0.B2();
        AlignAndScrollManager r25 = this.this$0.s;
        if (r25 == null) goto L20;
        Integer r26 = r25.a(this.$position);
    L21:
        if (r26 == null) goto L23;
        r26 = Boxing.boxInt(n.E(r26.intValue()));
    L23:
        Integer r27 = r26;
        com.bytedance.ee.bear.middleground.comment.card.d r28 = this.this$0.j;
        if (r28 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("cardDataViewModel");
        r28 = null;
    L26:
        CommentBean r29 = r28.e(Boxing.boxInt(this.$position));
        if (r29 == null) goto L29;
        String r30 = r29.getComment_id();
    L31:
        if (r30 != null) goto L33;
        r30 = "";
    L33:
        int r110 = 0;
        if (r29 == null) goto L36;
        int r111 = r29.getCommentType();
    L37:
        if (r29 == null) goto L39;
        String r31 = r29.getCommentUUID();
    L40:
        if (r31 != null) goto L42;
        r31 = "";
    L42:
        AlignAndScrollManager r32 = this.this$0.s;
        if (r32 == null) goto L48;
        Integer r33 = r32.a(this.$position);
        if (r33 == null) goto L48;
        r110 = r33.intValue();
    L48:
        if (r110 <= this.this$0.a.getHeight()) goto L56;
        AlignAndScrollManager r34 = this.this$0.s;
        if (r34 == null) goto L56;
        int r112 = this.$position;
        this.L$0 = r17;
        this.L$1 = r27;
        this.L$2 = r30;
        this.L$3 = r31;
        this.I$0 = r111;
        this.label = 1;
        r6 = r34.b(r112, this);
        if (r6 != r1) goto L54;
        return r1;
    L54:
        r9 = r17;
        r10 = r27;
        r11 = r30;
        r4 = r31;
        r3 = r111;
    L56:
        r14 = r31;
        r15 = r30;
        r16 = r27;
        r13 = r111;
        goto L57
    L39:
        r31 = null;
        goto L40
    L36:
        r111 = 0;
        goto L37
    L29:
        r30 = null;
        goto L31
    L20:
        r26 = null;
        goto L21
    }
}
