package io.ktor.websocket.serialization;

import io.ktor.websocket.c;
import io.ktor.websocket.m;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.channels.SendChannel;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.websocket.serialization.WebsocketChannelSerializationKt", f = "WebsocketChannelSerialization.kt", i = {0}, l = {50, 55}, m = "sendSerializedBase", n = {"$this$sendSerializedBase"}, s = {"L$0"})
final class WebsocketChannelSerializationKt$sendSerializedBase$2 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    public WebsocketChannelSerializationKt$sendSerializedBase$2(Continuation<? super WebsocketChannelSerializationKt$sendSerializedBase$2> r100) {
        super(r100);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        int r101 = this.label | Integer.MIN_VALUE;
        this.label = r101;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L5;
        this.label = r101 - Integer.MIN_VALUE;
        WebsocketChannelSerializationKt$sendSerializedBase$2 r102 = this;
    L6:
        Object r103 = r102.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r102.label;
        if (r105 != 0) goto L9;
        ResultKt.throwOnFailure(r103);
        r102.L$0 = null;
        r102.label = 1;
        throw null;
    L9:
        if (r105 == 1) goto L14;
        if (r105 != 2) goto L13;
        ResultKt.throwOnFailure(r103);
    L18:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        m r106 = (m) r102.L$0;
        ResultKt.throwOnFailure(r103);
        SendChannel<c> r107 = r106.Ec();
        r102.L$0 = null;
        r102.label = 2;
        if (r107.send((c) r103, r102) != r104) goto L18;
        return r104;
    L5:
        r102 = new WebsocketChannelSerializationKt$sendSerializedBase$2(this);
        goto L6
    }
}
