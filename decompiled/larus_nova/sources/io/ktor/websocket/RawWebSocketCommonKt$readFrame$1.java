package io.ktor.websocket;

import androidx.collection.SieveCacheKt;
import com.ss.ttvideoengine.model.VideoRef;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.core.v;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.ByteCompanionObject;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.websocket.RawWebSocketCommonKt", f = "RawWebSocketCommon.kt", i = {0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5}, l = {212, 213, VideoRef.VALUE_VIDEO_REF_CATEGORY, 233, 241, 249}, m = "readFrame", n = {"$this$readFrame", "maxFrameSize", "lastOpcode", "$this$readFrame", "maxFrameSize", "lastOpcode", "flagsAndOpcode", "$this$readFrame", "frameType", "maxFrameSize", "flagsAndOpcode", "maskAndLength", "fin", "$this$readFrame", "frameType", "maxFrameSize", "flagsAndOpcode", "maskAndLength", "fin", "$this$readFrame", "frameType", "maxFrameSize", "flagsAndOpcode", "fin", "length", "frameType", "flagsAndOpcode", "fin", "maskKey"}, s = {"L$0", "J$0", "I$0", "L$0", "J$0", "I$0", "B$0", "L$0", "L$1", "J$0", "B$0", "B$1", "I$0", "L$0", "L$1", "J$0", "B$0", "B$1", "I$0", "L$0", "L$1", "J$0", "B$0", "I$0", "J$1", "L$0", "B$0", "I$0", "I$1"})
final class RawWebSocketCommonKt$readFrame$1 extends ContinuationImpl {
    byte B$0;
    byte B$1;
    int I$0;
    int I$1;
    long J$0;
    long J$1;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    public RawWebSocketCommonKt$readFrame$1(Continuation<? super RawWebSocketCommonKt$readFrame$1> r100) {
        super(r100);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r210) {
        this.result = r210;
        int r100 = this.label | Integer.MIN_VALUE;
        this.label = r100;
        if ((r100 & Integer.MIN_VALUE) == 0) goto L5;
        this.label = r100 - Integer.MIN_VALUE;
        RawWebSocketCommonKt$readFrame$1 r101 = this;
    L6:
        Object r102 = r101.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(r101.label) {
            case 0: goto L125;
            case 1: goto L15;
            case 2: goto L14;
            case 3: goto L13;
            case 4: goto L12;
            case 5: goto L11;
            case 6: goto L10;
            default: goto L9;
        };
    L10:
        int r104 = r101.I$1;
        int r105 = r101.I$0;
        byte r106 = r101.B$0;
        FrameType r107 = (FrameType) r101.L$0;
        ResultKt.throwOnFailure(r102);
        FrameType r110 = r107;
    L97:
        io.ktor.utils.io.core.k r108 = (io.ktor.utils.io.core.k) r102;
        if (r104 == (-1)) goto L101;
        r108 = h.a(r108, r104);
    L101:
        byte[] r109 = c.f492167h;
        if (r105 == 0) goto L104;
        boolean r111 = true;
    L105:
        byte[] r112 = v.b(r108);
        if ((r106 & 64) == 0) goto L108;
        boolean r113 = true;
    L110:
        if ((r106 & 32) == 0) goto L112;
        boolean r211 = true;
    L114:
        if ((r106 & 16) == 0) goto L116;
        boolean r212 = true;
    L118:
        return c.C6315c.a(r111, r110, r112, r113, r211, r212);
    L116:
        r212 = false;
        goto L118
    L112:
        r211 = false;
        goto L114
    L108:
        r113 = false;
        goto L110
    L104:
        r111 = false;
        goto L105
    L11:
        long r114 = r101.J$1;
        r105 = r101.I$0;
        byte r115 = r101.B$0;
        long r116 = r101.J$0;
        FrameType r117 = (FrameType) r101.L$1;
        ByteReadChannel r118 = (ByteReadChannel) r101.L$0;
        ResultKt.throwOnFailure(r102);
    L86:
        int r119 = ((Number) r102).intValue();
    L90:
        if (r114 > SieveCacheKt.NodeLinkMask) goto L120;
        if (r114 > r116) goto L120;
        r101.L$0 = r117;
        r101.L$1 = null;
        r101.B$0 = r115;
        r101.I$0 = r105;
        r101.I$1 = r119;
        r101.label = 6;
        Object r120 = r118.e((int) r114, r101);
        if (r120 == r103) goto L131;
        r104 = r119;
        r106 = r115;
        r110 = r117;
        r102 = r120;
        goto L97
    L131:
        return r103;
    L120:
        throw new FrameTooBigException(r114);
    L12:
        r105 = r101.I$0;
        byte r121 = r101.B$1;
        byte r122 = r101.B$0;
        long r123 = r101.J$0;
        FrameType r124 = (FrameType) r101.L$1;
        ByteReadChannel r125 = (ByteReadChannel) r101.L$0;
        ResultKt.throwOnFailure(r102);
    L64:
        long r126 = ((Number) r102).longValue();
    L70:
        byte r127 = r121;
        r118 = r125;
        r117 = r124;
        r116 = r123;
        r115 = r122;
        r114 = r126;
    L72:
        if (r117.getControlFrame() == false) goto L79;
        if (r114 <= 125) goto L79;
        throw new ProtocolViolationException("control frames can't be larger than 125 bytes");
    L79:
        if ((r127 & ByteCompanionObject.MIN_VALUE) == 0) goto L81;
        boolean r128 = true;
    L82:
        if (r128 != true) goto L87;
        r101.L$0 = r118;
        r101.L$1 = r117;
        r101.J$0 = r116;
        r101.B$0 = r115;
        r101.I$0 = r105;
        r101.J$1 = r114;
        r101.label = 5;
        r102 = r118.F(r101);
        if (r102 != r103) goto L86;
        return r103;
    L87:
        if (r128 == true) goto L122;
        r119 = -1;
        goto L90
    L122:
        throw new NoWhenBranchMatchedException();
    L81:
        r128 = false;
        goto L82
    L13:
        r105 = r101.I$0;
        r121 = r101.B$1;
        r122 = r101.B$0;
        r123 = r101.J$0;
        r124 = (FrameType) r101.L$1;
        r125 = (ByteReadChannel) r101.L$0;
        ResultKt.throwOnFailure(r102);
    L69:
        r126 = ((long) ((Number) r102).shortValue()) & 65535;
        goto L70
    L14:
        byte r129 = r101.B$0;
        int r130 = r101.I$0;
        long r131 = r101.J$0;
        ByteReadChannel r132 = (ByteReadChannel) r101.L$0;
        ResultKt.throwOnFailure(r102);
        r125 = r132;
        r123 = r131;
        r122 = r129;
    L19:
        r127 = ((Number) r102).byteValue();
        int r133 = r122 & 15;
        if (r133 != 0) goto L25;
        if (r130 != 0) goto L25;
        throw new ProtocolViolationException("Can't continue finished frames");
    L25:
        if (r133 != 0) goto L27;
        int r134 = r130;
    L28:
        FrameType.Companion.getClass();
        if (r134 >= 0) goto L31;
    L33:
        boolean r135 = false;
    L34:
        if (r135 == false) goto L36;
        FrameType r136 = FrameType.access$getByOpcodeArray$cp()[r134];
    L37:
        if (r136 == null) goto L124;
        if (r133 == 0) goto L46;
        if (r130 == 0) goto L46;
        if (r136.getControlFrame() == true) goto L46;
        throw new ProtocolViolationException("Can't start new data frame before finishing previous one");
    L46:
        if ((r122 & ByteCompanionObject.MIN_VALUE) == 0) goto L48;
        r105 = 1;
    L50:
        if (r136.getControlFrame() == false) goto L55;
        if (r105 != 0) goto L55;
        throw new ProtocolViolationException("control frames can't be fragmented");
    L55:
        int r137 = r127 & ByteCompanionObject.MAX_VALUE;
        if (r137 != 126) goto L58;
        r101.L$0 = r125;
        r101.L$1 = r136;
        r101.J$0 = r123;
        r101.B$0 = r122;
        r101.B$1 = r127;
        r101.I$0 = r105;
        r101.label = 3;
        Object r138 = r125.s(r101);
        if (r138 == r103) goto L129;
        r121 = r127;
        r102 = r138;
        r124 = r136;
        goto L69
    L129:
        return r103;
    L58:
        if (r137 == 127) goto L60;
        r116 = r123;
        r115 = r122;
        r114 = r137;
        FrameType r213 = r136;
        r118 = r125;
        r117 = r213;
        goto L72
    L60:
        r101.L$0 = r125;
        r101.L$1 = r136;
        r101.J$0 = r123;
        r101.B$0 = r122;
        r101.B$1 = r127;
        r101.I$0 = r105;
        r101.label = 4;
        Object r139 = r125.j(r101);
        if (r139 == r103) goto L128;
        r121 = r127;
        r102 = r139;
        r124 = r136;
        goto L64
    L128:
        return r103;
    L48:
        r105 = 0;
        goto L50
    L124:
        throw new IllegalStateException("Unsupported opcode: " + r134);
    L36:
        r136 = null;
        goto L37
    L31:
        if (r134 > FrameType.access$getMaxOpcode$cp()) goto L33;
        r135 = true;
        goto L34
    L27:
        r134 = r133;
        goto L28
    L15:
        r130 = r101.I$0;
        long r140 = r101.J$0;
        ByteReadChannel r141 = (ByteReadChannel) r101.L$0;
        ResultKt.throwOnFailure(r102);
        byte r142 = ((Number) r102).byteValue();
        r101.L$0 = r141;
        r101.J$0 = r140;
        r101.I$0 = r130;
        r101.B$0 = r142;
        r101.label = 2;
        Object r143 = r141.z(r101);
        if (r143 == r103) goto L127;
        r125 = r141;
        r122 = r142;
        r102 = r143;
        r123 = r140;
        goto L19
    L127:
        return r103;
    L125:
        ResultKt.throwOnFailure(r102);
        r101.L$0 = null;
        r101.J$0 = 0;
        r101.I$0 = 0;
        r101.label = 1;
        throw null;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L5:
        r101 = new RawWebSocketCommonKt$readFrame$1(this);
        goto L6
    }
}
