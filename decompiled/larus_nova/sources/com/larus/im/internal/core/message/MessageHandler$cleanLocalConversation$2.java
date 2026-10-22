package com.larus.im.internal.core.message;

import android.os.SystemClock;
import com.ss.android.dypay.api.DyPayConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.im.internal.core.message.MessageHandler$cleanLocalConversation$2", f = "MessageHandler.kt", i = {0, 1, 1, 2, 2, 3}, l = {133, 138, 139, 140}, m = "invokeSuspend", n = {DyPayConstant.KEY_START_TIME, "localConversations", DyPayConstant.KEY_START_TIME, "localConversations", DyPayConstant.KEY_START_TIME, DyPayConstant.KEY_START_TIME}, s = {"J$0", "L$0", "J$0", "L$0", "J$0", "J$0"})
final class MessageHandler$cleanLocalConversation$2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    long J$0;
    Object L$0;
    int label;

    public MessageHandler$cleanLocalConversation$2(Continuation<? super MessageHandler$cleanLocalConversation$2> r100) {
        super(1, r100);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> r100) {
        return new MessageHandler$cleanLocalConversation$2(r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Continuation<? super Unit> r100) {
        return invoke2(r100);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Continuation<? super Unit> r100) {
        return ((MessageHandler$cleanLocalConversation$2) create(r100)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r101 = this.label;
        if (r101 == 0) goto L14;
        if (r101 == 1) goto L13;
        if (r101 == 2) goto L12;
        if (r101 == 3) goto L11;
        if (r101 != 4) goto L10;
        long r102 = this.J$0;
        ResultKt.throwOnFailure(r110);
    L34:
        com.larus.im.internal.delegate.a.f348188b.i("MessageHandler", "cleanLocalConversation duration = " + (SystemClock.elapsedRealtime() - r102));
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        long r103 = this.J$0;
        List<String> r104 = (List) this.L$0;
        ResultKt.throwOnFailure(r110);
    L30:
        be9.e r111 = ae9.h.a();
        this.L$0 = null;
        this.J$0 = r103;
        this.label = 4;
        if (r111.w(r104, this) != r100) goto L33;
        return r100;
    L33:
        r102 = r103;
        goto L34
    L12:
        long r105 = this.J$0;
        r104 = (List) this.L$0;
        ResultKt.throwOnFailure(r110);
    L26:
        be9.d r112 = ae9.e.a();
        this.L$0 = r104;
        this.J$0 = r105;
        this.label = 3;
        if (r112.o(r104, this) != r100) goto L29;
        return r100;
    L29:
        r103 = r105;
        goto L30
    L13:
        long r106 = this.J$0;
        ResultKt.throwOnFailure(r110);
    L18:
        List<String> r113 = (List) r110;
        com.larus.im.internal.delegate.a.f348188b.i("MessageHandler", "cleanLocalConversation size = " + r113.size());
        if (r113.isEmpty() == true) goto L21;
        be9.b r107 = ae9.b.a();
        this.L$0 = r113;
        this.J$0 = r106;
        this.label = 2;
        if (r107.q(r113, this) != r100) goto L25;
        return r100;
    L25:
        r104 = r113;
        r105 = r106;
        goto L26
    L21:
        return Unit.INSTANCE;
    L14:
        ResultKt.throwOnFailure(r110);
        long r108 = SystemClock.elapsedRealtime();
        be9.b r114 = ae9.b.a();
        this.J$0 = r108;
        this.label = 1;
        r110 = r114.m(100, this);
        if (r110 != r100) goto L17;
        return r100;
    L17:
        r106 = r108;
        goto L18
    }
}
