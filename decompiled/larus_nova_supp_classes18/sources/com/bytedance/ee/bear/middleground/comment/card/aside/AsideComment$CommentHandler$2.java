package com.bytedance.ee.bear.middleground.comment.card.aside;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.ChannelIterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ee.bear.middleground.comment.card.aside.AsideComment$CommentHandler$2", f = "AsideComment.kt", i = {1}, l = {471, 474, 476}, m = "invokeSuspend", n = {"task"}, s = {"L$1"})
final class AsideComment$CommentHandler$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ AsideComment.a this$0;

    public AsideComment$CommentHandler$2(AsideComment.a r1, Continuation<? super AsideComment$CommentHandler$2> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new AsideComment$CommentHandler$2(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r12) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L20;
        if (r1 == 1) goto L19;
        if (r1 == 2) goto L14;
        if (r1 != 3) goto L13;
        ChannelIterator r2 = (ChannelIterator) this.L$0;
        ResultKt.throwOnFailure(r12);     // Catch: Exception -> L10
        ChannelIterator r13 = r2;
    L21:
        AsideComment$CommentHandler$2 r3 = this;
    L22:
        r3.L$0 = r13;
        r3.L$1 = null;
        r3.label = 1;
        Object r7 = r13.hasNext(r3);
        if (r7 != r0) goto L25;
        return r0;
    L25:
        AsideComment$CommentHandler$2 r10 = r3;
        ChannelIterator r4 = r13;
        r12 = r7;
        AsideComment$CommentHandler$2 r8 = r10;
    L27:
        if (((Boolean) r12).booleanValue() == false) goto L44;
        AsideComment.a.C0058a r14 = (AsideComment.a.C0058a) r4.next();
        AsideComment.a r9 = r8.this$0;     // Catch: Exception -> L39
        r8.L$0 = r4;     // Catch: Exception -> L39
        r8.L$1 = r14;     // Catch: Exception -> L39
        r8.label = 2;     // Catch: Exception -> L39
        if (AsideComment.a.a(r9, r8) != r0) goto L32;
        return r0;
    L32:
        ChannelIterator r11 = r4;
        AsideComment.a.C0058a r5 = r14;
        AsideComment$CommentHandler$2 r15 = r8;
        ChannelIterator r16 = r11;
    L49:
        tt5.a.h("Comment#AsideComment", "next task is " + r5.a);     // Catch: Exception -> L37
        Function1<Continuation<? super Unit>, Object> r6 = r5.b;     // Catch: Exception -> L37
        r15.L$0 = r16;     // Catch: Exception -> L37
        r15.L$1 = null;     // Catch: Exception -> L37
        r15.label = 3;     // Catch: Exception -> L37
        if (r6.invoke(r15) != r0) goto L36;
        return r0;
    L36:
        r3 = r15;
        r13 = r16;
    L37:
        e = move-exception;
        r3 = r15;
        Exception e = e;
    L41:
        tt5.a.e("Comment#AsideComment", "CommentHandler enqueue error", e, false);
        r13 = r16;
    L39:
        e = e;
        AsideComment$CommentHandler$2 r17 = r8;
        r16 = r4;
        r3 = r17;
        goto L41
    L44:
        return Unit.INSTANCE;
    L10:
        e = e;
        r16 = r2;
    L18:
        r3 = this;
        goto L41
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        r5 = (AsideComment.a.C0058a) this.L$1;
        r16 = (ChannelIterator) this.L$0;
        ResultKt.throwOnFailure(r12);     // Catch: Exception -> L17
        r15 = this;
    L17:
        e = e;
        goto L18
    L19:
        r4 = (ChannelIterator) this.L$0;
        ResultKt.throwOnFailure(r12);
        r8 = this;
        goto L27
    L20:
        ResultKt.throwOnFailure(r12);
        r13 = this.this$0.b.iterator();
        goto L21
    }
}
