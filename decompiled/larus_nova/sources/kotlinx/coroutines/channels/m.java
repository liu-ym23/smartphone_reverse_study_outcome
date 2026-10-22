package kotlinx.coroutines.channels;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.internal.b0;
import kotlinx.coroutines.t0;

/* JADX INFO: loaded from: classes6.dex */
public final class m {
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x007c -> B:28:0x007f). Please report as a decompilation issue!!! */
    public static final Object a(long r100, long r101, SendChannel r110, Continuation r111) {
        if ((r111 instanceof TickerChannelsKt$fixedDelayTicker$1) == false) goto L7;
        TickerChannelsKt$fixedDelayTicker$1 r102 = (TickerChannelsKt$fixedDelayTicker$1) r111;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r112 = r102.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r102.label;
        if (r105 == 0) goto L18;
        if (r105 == 1) goto L17;
        if (r105 == 2) goto L16;
        if (r105 != 3) goto L15;
        r100 = r102.J$0;
        SendChannel r106 = (SendChannel) r102.L$0;
        ResultKt.throwOnFailure(r112);
    L28:
        r110 = r106;
    L21:
        Unit r107 = Unit.INSTANCE;
        r102.L$0 = r110;
        r102.J$0 = r100;
        r102.label = 2;
        if (r110.send(r107, r102) == r104) goto L27;
        r106 = r110;
    L25:
        r102.L$0 = r106;
        r102.J$0 = r100;
        r102.label = 3;
        if (DelayKt.delay(r100, r102) != r104) goto L28;
    L27:
        return r104;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        r100 = r102.J$0;
        r106 = (SendChannel) r102.L$0;
        ResultKt.throwOnFailure(r112);
        goto L25
    L17:
        r100 = r102.J$0;
        r110 = (SendChannel) r102.L$0;
        ResultKt.throwOnFailure(r112);
        goto L21
    L18:
        ResultKt.throwOnFailure(r112);
        r102.L$0 = r110;
        r102.J$0 = r100;
        r102.label = 1;
        if (DelayKt.delay(r101, r102) != r104) goto L21;
    L7:
        r102 = new TickerChannelsKt$fixedDelayTicker$1(r111);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x00ce -> B:36:0x00d1). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x00e7 -> B:36:0x00d1). Please report as a decompilation issue!!! */
    public static final Object b(long r210, long r211, SendChannel r212, Continuation r213) {
        if ((r213 instanceof TickerChannelsKt$fixedPeriodTicker$1) == false) goto L7;
        TickerChannelsKt$fixedPeriodTicker$1 r100 = (TickerChannelsKt$fixedPeriodTicker$1) r213;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        int r105 = 2;
        if (r104 == 0) goto L20;
        if (r104 == 1) goto L19;
        if (r104 == 2) goto L18;
        if (r104 == 3) goto L17;
        if (r104 == 4) goto L17;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        long r106 = r100.J$1;
        long r107 = r100.J$0;
        SendChannel r108 = (SendChannel) r100.L$0;
        ResultKt.throwOnFailure(r102);
    L36:
        long r110 = r106;
        long r109 = r107;
        long r111 = r110;
        SendChannel r112 = r108;
        r105 = 2;
    L25:
        long r113 = r109 + r111;
        Unit r114 = Unit.INSTANCE;
        r100.L$0 = r112;
        r100.J$0 = r113;
        r100.J$1 = r111;
        r100.label = r105;
        if (r112.send(r114, r100) == r103) goto L39;
        r108 = r112;
        r106 = r111;
        r107 = r113;
    L29:
        long r115 = System.nanoTime();
        long r116 = RangesKt.coerceAtLeast(r107 - r115, 0);
        if (r116 == 0) goto L32;
    L37:
        b0 r117 = t0.f505149a;
        r100.L$0 = r108;
        r100.J$0 = r107;
        r100.J$1 = r106;
        r100.label = 4;
        if (DelayKt.delay(r116 / 1000000, r100) != r103) goto L36;
    L32:
        if (r106 == 0) goto L37;
        long r118 = r106 - ((r115 - r107) % r106);
        r107 = r115 + r118;
        b0 r119 = t0.f505149a;
        r100.L$0 = r108;
        r100.J$0 = r107;
        r100.J$1 = r106;
        r100.label = 3;
        if (DelayKt.delay(r118 / 1000000, r100) != r103) goto L36;
    L39:
        return r103;
    L18:
        r106 = r100.J$1;
        r107 = r100.J$0;
        r108 = (SendChannel) r100.L$0;
        ResultKt.throwOnFailure(r102);
        goto L29
    L19:
        r109 = r100.J$1;
        long r120 = r100.J$0;
        SendChannel r121 = (SendChannel) r100.L$0;
        ResultKt.throwOnFailure(r102);
        r112 = r121;
        long r122 = r120;
    L24:
        r111 = t0.a(r122);
        goto L25
    L20:
        ResultKt.throwOnFailure(r102);
        long r123 = System.nanoTime() + t0.a(r211);
        r112 = r212;
        r100.L$0 = r112;
        r122 = r210;
        r100.J$0 = r122;
        r100.J$1 = r123;
        r100.label = 1;
        if (DelayKt.delay(r211, r100) == r103) goto L39;
        r109 = r123;
    L7:
        r100 = new TickerChannelsKt$fixedPeriodTicker$1(r213);
        goto L8
    }
}
