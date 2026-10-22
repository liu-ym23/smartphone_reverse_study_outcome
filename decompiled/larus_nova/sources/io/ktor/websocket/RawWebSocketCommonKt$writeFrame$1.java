package io.ktor.websocket;

import com.ss.ttm.player.MediaPlayer;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.random.Random;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.websocket.RawWebSocketCommonKt", f = "RawWebSocketCommon.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4}, l = {174, 184, 187, 188, MediaPlayer.MEDIA_PLAYER_OPTION_PRE_DECODE_AUTO_PAUSE, 201}, m = "writeFrame", n = {"$this$writeFrame", "frame", "masking", "length", "$this$writeFrame", "frame", "masking", "length", "formattedLength", "$this$writeFrame", "frame", "masking", "$this$writeFrame", "frame", "masking", "$this$writeFrame", "data", "maskKey"}, s = {"L$0", "L$1", "Z$0", "I$0", "L$0", "L$1", "Z$0", "I$0", "I$1", "L$0", "L$1", "Z$0", "L$0", "L$1", "Z$0", "L$0", "L$1", "I$0"})
final class RawWebSocketCommonKt$writeFrame$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;

    public RawWebSocketCommonKt$writeFrame$1(Continuation<? super RawWebSocketCommonKt$writeFrame$1> r100) {
        super(r100);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        this.result = r110;
        int r111 = this.label | Integer.MIN_VALUE;
        this.label = r111;
        if ((r111 & Integer.MIN_VALUE) == 0) goto L5;
        this.label = r111 - Integer.MIN_VALUE;
        RawWebSocketCommonKt$writeFrame$1 r112 = this;
    L6:
        Object r100 = r112.result;
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(r112.label) {
            case 0: goto L53;
            case 1: goto L14;
            case 2: goto L13;
            case 3: goto L12;
            case 4: goto L12;
            case 5: goto L11;
            case 6: goto L10;
            default: goto L9;
        };
    L10:
        ResultKt.throwOnFailure(r100);
    L50:
        return Unit.INSTANCE;
    L11:
        int r102 = r112.I$0;
        io.ktor.utils.io.core.k r103 = (io.ktor.utils.io.core.k) r112.L$1;
        io.ktor.utils.io.d r104 = (io.ktor.utils.io.d) r112.L$0;
        ResultKt.throwOnFailure(r100);
    L44:
        r103 = h.a(r103, r102);
    L46:
        r112.L$0 = null;
        r112.L$1 = null;
        r112.label = 6;
        if (r104.l(r103, r112) != r101) goto L50;
        return r101;
    L12:
        boolean r105 = r112.Z$0;
        c r106 = (c) r112.L$1;
        r104 = (io.ktor.utils.io.d) r112.L$0;
        ResultKt.throwOnFailure(r100);
    L38:
        boolean r107 = r105;
        c r108 = r106;
    L39:
        final byte[] r109 = r108.f492170c;
        r103 = io.ktor.utils.io.core.l.a(ByteBuffer.wrap(r109, 0, r109.length), new RawWebSocketCommonKt$writeFrame$$inlined$ByteReadPacket$default$1(r109));
        if (r107 != true) goto L45;
        r102 = Random.Default.nextInt();
        r112.L$0 = r104;
        r112.L$1 = r103;
        r112.I$0 = r102;
        r112.label = 5;
        if (r104.v(r102, r112) != r101) goto L44;
        return r101;
    L45:
        if (r107 == false) goto L46;
        throw new NoWhenBranchMatchedException();
    L13:
        int r113 = r112.I$1;
        int r114 = r112.I$0;
        r107 = r112.Z$0;
        r108 = (c) r112.L$1;
        io.ktor.utils.io.d r115 = (io.ktor.utils.io.d) r112.L$0;
        ResultKt.throwOnFailure(r100);
    L28:
        if (r113 == 126) goto L34;
        if (r113 == 127) goto L31;
        r104 = r115;
        goto L39
    L31:
        r112.L$0 = r115;
        r112.L$1 = r108;
        r112.Z$0 = r107;
        r112.label = 4;
        if (r115.q(r114, r112) == r101) goto L56;
    L37:
        r105 = r107;
        r106 = r108;
        r104 = r115;
        goto L38
    L56:
        return r101;
    L34:
        r112.L$0 = r115;
        r112.L$1 = r108;
        r112.Z$0 = r107;
        r112.label = 3;
        if (r115.o((short) r114, r112) != r101) goto L37;
        return r101;
    L14:
        r114 = r112.I$0;
        boolean r116 = r112.Z$0;
        c r117 = (c) r112.L$1;
        io.ktor.utils.io.d r118 = (io.ktor.utils.io.d) r112.L$0;
        ResultKt.throwOnFailure(r100);
        if (r114 >= 126) goto L18;
        int r119 = r114;
    L21:
        if (r116 == false) goto L23;
        int r120 = 128;
    L24:
        r112.L$0 = r118;
        r112.L$1 = r117;
        r112.Z$0 = r116;
        r112.I$0 = r114;
        r112.I$1 = r119;
        r112.label = 2;
        if (r118.A((byte) (r120 | r119), r112) == r101) goto L55;
        r115 = r118;
        r108 = r117;
        r107 = r116;
        r113 = r119;
        goto L28
    L55:
        return r101;
    L23:
        r120 = 0;
        goto L24
    L18:
        if (r114 > 65535) goto L20;
        r119 = 126;
        goto L21
    L20:
        r119 = 127;
        goto L21
    L53:
        ResultKt.throwOnFailure(r100);
        throw null;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L5:
        r112 = new RawWebSocketCommonKt$writeFrame$1(this);
        goto L6
    }
}
