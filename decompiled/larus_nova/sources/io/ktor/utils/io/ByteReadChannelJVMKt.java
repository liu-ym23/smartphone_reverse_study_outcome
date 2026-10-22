package io.ktor.utils.io;

import io.ktor.utils.io.internal.SequentialCopyToKt;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;

/* JADX INFO: loaded from: classes41.dex */
public final class ByteReadChannelJVMKt {
    public static final Object a(ByteReadChannel r100, d r101, long r102, Continuation<? super Long> r103) {
        if (r100 == r101) goto L4;
        boolean r104 = true;
    L5:
        if (r104 == false) goto L25;
        if (r102 != 0) goto L11;
        return Boxing.boxLong(0);
    L11:
        if ((r100 instanceof ByteBufferChannel) == false) goto L17;
        if ((r101 instanceof ByteBufferChannel) == false) goto L17;
        return ((ByteBufferChannel) r101).W((ByteBufferChannel) r100, r102, r103);
    L17:
        if ((r100 instanceof ByteChannelSequentialBase) == false) goto L23;
        if ((r101 instanceof ByteChannelSequentialBase) == false) goto L23;
        return SequentialCopyToKt.a((ByteChannelSequentialBase) r100, (ByteChannelSequentialBase) r101, Long.MAX_VALUE, r103);
    L23:
        return b(r100, r101, r102, r103);
    L25:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L4:
        r104 = false;
        goto L5
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0 */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v2, types: [int] */
    /* JADX WARN: Type inference failed for: r11v3 */
    /* JADX WARN: Type inference failed for: r11v5 */
    /* JADX WARN: Type inference failed for: r11v6 */
    /* JADX WARN: Type inference failed for: r3v3, types: [int] */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x00e4 -> B:35:0x00ee). Please report as a decompilation issue!!! */
    public static final Object b(ByteReadChannel r210, d r211, long r212, Continuation<? super Long> r213) {
        if ((r213 instanceof ByteReadChannelJVMKt$copyToImpl$1) == false) goto L7;
        ByteReadChannelJVMKt$copyToImpl$1 r100 = (ByteReadChannelJVMKt$copyToImpl$1) r213;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        long r105 = 0;
        if (r104 == 0) goto L22;
        if (r104 == 1) goto L17;
        if (r104 != 2) goto L16;
        int r106 = r100.I$1;
        long r107 = r100.J$1;
        int r110 = r100.I$0;
        long r111 = r100.J$0;
        io.ktor.utils.io.core.internal.a r112 = (io.ktor.utils.io.core.internal.a) r100.L$2;
        d r113 = (d) r100.L$1;
        ByteReadChannel r114 = (ByteReadChannel) r100.L$0;
        ResultKt.throwOnFailure(r102);     // Catch: Throwable -> L20
        ByteReadChannelJVMKt$copyToImpl$1 r108 = r100;
        int r109 = r106;
        d r115 = r113;
        ByteReadChannel r116 = r114;
        Object r117 = r103;
        long r118 = r111;
        ?? r119 = r110;
    L35:
        long r120 = r107 + ((long) r109);
        if (r119 != 0) goto L61;
    L43:
        ByteReadChannelJVMKt$copyToImpl$1 r121 = r108;
        io.ktor.utils.io.core.internal.a r122 = r112;
        r105 = 0;
        long r123 = r120;
        ?? r124 = r119;
    L23:
        long r125 = r118 - r123;
        if (r125 != r105) goto L65;
        d r126 = r115;
    L63:
        Long r127 = Boxing.boxLong(r123);     // Catch: Throwable -> L51
        AtomicReferenceFieldUpdater r128 = io.ktor.utils.io.core.internal.a.f492027j;
        r122.k(io.ktor.utils.io.core.c.f492026a);
        return r127;
    L51:
        th = th;
        r112 = r122;
    L53:
        r122 = r112;
        r115 = r126;
    L59:
        r115.close(th);     // Catch: Throwable -> L56
        throw th;     // Catch: Throwable -> L56
    L56:
        th = move-exception;
        AtomicReferenceFieldUpdater r129 = io.ktor.utils.io.core.internal.a.f492027j;
        r122.k(io.ktor.utils.io.core.c.f492026a);
        throw th;
    L65:
        r122.f((int) Math.min(r122.f492025f, r125));     // Catch: Throwable -> L45
        r121.L$0 = r116;     // Catch: Throwable -> L45
        r121.L$1 = r115;     // Catch: Throwable -> L45
        r121.L$2 = r122;     // Catch: Throwable -> L45
        r121.J$0 = r118;     // Catch: Throwable -> L45
        r121.I$0 = r124;     // Catch: Throwable -> L45
        r121.J$1 = r123;     // Catch: Throwable -> L45
        r121.label = 1;     // Catch: Throwable -> L45
        Object r130 = r116.D(r122, r121);     // Catch: Throwable -> L45
        if (r130 != r117) goto L28;
        return r117;
    L28:
        r126 = r115;
        r100 = r121;
        long r131 = r123;
        ByteReadChannel r132 = r116;
        r102 = r130;
        r112 = r122;
        r107 = r131;
        long r133 = r118;
        r103 = r117;
        ?? r134 = r124;
        long r135 = r133;
    L29:
        int r136 = ((Number) r102).intValue();     // Catch: Throwable -> L20
        if (r136 == (-1)) goto L44;
        r100.L$0 = r132;     // Catch: Throwable -> L20
        r100.L$1 = r126;     // Catch: Throwable -> L20
        r100.L$2 = r112;     // Catch: Throwable -> L20
        r100.J$0 = r135;     // Catch: Throwable -> L20
        r100.I$0 = r134;     // Catch: Throwable -> L20
        r100.J$1 = r107;     // Catch: Throwable -> L20
        r100.I$1 = r136;     // Catch: Throwable -> L20
        r100.label = 2;     // Catch: Throwable -> L20
        if (r126.y(r112, r100) != r103) goto L34;
        return r103;
    L34:
        r109 = r136;
        r108 = r100;
        r116 = r132;
        r115 = r126;
        long r137 = r135;
        r117 = r103;
        r119 = r134;
        r118 = r137;
        goto L35
    L44:
        long r138 = r107;
        r122 = r112;
        r123 = r138;
    L45:
        th = th;
        goto L59
    L61:
    L41:
        th = th;
        r122 = r112;
        goto L59
    L38:
        if (r116.w() != 0) goto L43;
        r115.flush();     // Catch: Throwable -> L41
        goto L43
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        r107 = r100.J$1;
        int r139 = r100.I$0;
        r135 = r100.J$0;
        r112 = (io.ktor.utils.io.core.internal.a) r100.L$2;
        r126 = (d) r100.L$1;
        r132 = (ByteReadChannel) r100.L$0;
        ResultKt.throwOnFailure(r102);     // Catch: Throwable -> L20
        r134 = r139;
        goto L29
    L22:
        ResultKt.throwOnFailure(r102);
        AtomicReferenceFieldUpdater r140 = io.ktor.utils.io.core.internal.a.f492027j;
        r122 = io.ktor.utils.io.core.c.f492026a.Q5();
        r121 = r100;
        r117 = r103;
        r124 = !r211.J();
        r123 = 0;
        r116 = r210;
        r115 = r211;
        r118 = r212;
    L20:
        th = th;
    L7:
        r100 = new ByteReadChannelJVMKt$copyToImpl$1(r213);
        goto L8
    }
}
