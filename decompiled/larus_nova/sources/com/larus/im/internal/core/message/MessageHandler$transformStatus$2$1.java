package com.larus.im.internal.core.message;

import com.larus.im.internal.database.entity.MessageEntity;
import java.util.Iterator;
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
@DebugMetadata(c = "com.larus.im.internal.core.message.MessageHandler$transformStatus$2$1", f = "MessageHandler.kt", i = {}, l = {147, 149, 155, 157, 162, 164}, m = "invokeSuspend", n = {}, s = {})
final class MessageHandler$transformStatus$2$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    Object L$0;
    int label;

    public MessageHandler$transformStatus$2$1(Continuation<? super MessageHandler$transformStatus$2$1> r100) {
        super(1, r100);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> r100) {
        return new MessageHandler$transformStatus$2$1(r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Continuation<? super Unit> r100) {
        return invoke2(r100);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Continuation<? super Unit> r100) {
        return ((MessageHandler$transformStatus$2$1) create(r100)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(this.label) {
            case 0: goto L12;
            case 1: goto L11;
            case 2: goto L10;
            case 3: goto L9;
            case 4: goto L8;
            case 5: goto L7;
            case 6: goto L6;
            default: goto L5;
        };
    L6:
        Iterator r101 = (Iterator) this.L$0;
        ResultKt.throwOnFailure(r110);
        Iterator r111 = r101;
        Object r102 = r100;
        MessageHandler$transformStatus$2$1 r103 = this;
    L37:
        if (r111.hasNext() == false) goto L42;
        MessageEntity r104 = (MessageEntity) r111.next();
        be9.d r105 = ae9.e.a();
        String r106 = r104.getLocalMessageId();
        r103.L$0 = r111;
        r103.label = 6;
        if (r105.D(r106, 12, r103) != r102) goto L37;
        return r102;
    L42:
        return Unit.INSTANCE;
    L7:
        ResultKt.throwOnFailure(r110);
        r102 = r100;
        r103 = this;
    L35:
        r111 = ((List) r110).iterator();
        goto L37
    L8:
        Iterator r107 = (Iterator) this.L$0;
        ResultKt.throwOnFailure(r110);
        Iterator r112 = r107;
        r102 = r100;
        r103 = this;
    L28:
        if (r112.hasNext() == false) goto L32;
        MessageEntity r108 = (MessageEntity) r112.next();
        be9.d r109 = ae9.e.a();
        String r113 = r108.getLocalMessageId();
        r103.L$0 = r112;
        r103.label = 4;
        if (r109.D(r113, 12, r103) != r102) goto L28;
        return r102;
    L32:
        be9.d r114 = ae9.e.a();
        r103.L$0 = null;
        r103.label = 5;
        r110 = r114.z(10, r103);
        if (r110 != r102) goto L35;
        return r102;
    L9:
        ResultKt.throwOnFailure(r110);
        r102 = r100;
        r103 = this;
    L26:
        r112 = ((List) r110).iterator();
        goto L28
    L10:
        Iterator r115 = (Iterator) this.L$0;
        ResultKt.throwOnFailure(r110);
    L18:
        if (r115.hasNext() == false) goto L22;
        MessageEntity r116 = (MessageEntity) r115.next();
        be9.d r117 = ae9.e.a();
        String r118 = r116.getLocalMessageId();
        this.L$0 = r115;
        this.label = 2;
        if (r117.D(r118, 3, this) != r100) goto L18;
        return r100;
    L22:
        be9.d r119 = ae9.e.a();
        this.L$0 = null;
        this.label = 3;
        Object r120 = r119.z(2, this);
        if (r120 != r100) goto L25;
        return r100;
    L25:
        r103 = this;
        r110 = r120;
        r102 = r100;
        goto L26
    L11:
        ResultKt.throwOnFailure(r110);
    L15:
        r115 = ((List) r110).iterator();
        goto L18
    L12:
        ResultKt.throwOnFailure(r110);
        be9.d r121 = ae9.e.a();
        this.label = 1;
        r110 = r121.z(1, this);
        if (r110 != r100) goto L15;
        return r100;
    L5:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
