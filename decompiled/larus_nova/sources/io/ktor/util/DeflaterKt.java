package io.ktor.util;

import io.ktor.utils.io.ByteReadChannel;
import java.nio.ByteBuffer;
import java.util.zip.CRC32;
import java.util.zip.Checksum;
import java.util.zip.Deflater;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public final class DeflaterKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final byte[] f491939a = null;

    static {
        f491939a = new byte[7];
    }

    public static final Object c(io.ktor.utils.io.d r100, Continuation<? super Unit> r101) {
        if ((r101 instanceof DeflaterKt$putGzipHeader$1) == false) goto L7;
        DeflaterKt$putGzipHeader$1 r102 = (DeflaterKt$putGzipHeader$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L18;
        if (r106 == 1) goto L17;
        if (r106 == 2) goto L16;
        if (r106 != 3) goto L15;
        ResultKt.throwOnFailure(r104);
    L31:
        return Unit.INSTANCE;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        r100 = (io.ktor.utils.io.d) r102.L$0;
        ResultKt.throwOnFailure(r104);
    L24:
        byte[] r107 = f491939a;
        r102.L$0 = null;
        r102.label = 3;
        Object r108 = r100.t(r107, 0, 7, r102);
        if (r108 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L28;
        r108 = Unit.INSTANCE;
    L28:
        if (r108 != r105) goto L31;
        return r105;
    L17:
        r100 = (io.ktor.utils.io.d) r102.L$0;
        ResultKt.throwOnFailure(r104);
    L21:
        r102.L$0 = r100;
        r102.label = 2;
        if (r100.A((byte) 8, r102) != r105) goto L24;
        return r105;
    L18:
        ResultKt.throwOnFailure(r104);
        short r109 = Short.reverseBytes((short) (-29921));
        r102.L$0 = r100;
        r102.label = 1;
        if (r100.o(r109, r102) != r105) goto L21;
        return r105;
    L7:
        r102 = new DeflaterKt$putGzipHeader$1(r101);
        goto L8
    }

    public static final void e(Checksum r100, ByteBuffer r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "buffer");
        if (r101.hasArray() == false) goto L7;
        r100.update(r101.array(), r101.arrayOffset() + r101.position(), r101.remaining());
        return;
    L7:
        throw new IllegalArgumentException("buffer need to be array-backed".toString());
    }

    public static final Object d(io.ktor.utils.io.d r100, Checksum r101, Deflater r102, Continuation<? super Unit> r110) {
        if ((r110 instanceof DeflaterKt$putGzipTrailer$1) == false) goto L7;
        DeflaterKt$putGzipTrailer$1 r103 = (DeflaterKt$putGzipTrailer$1) r110;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r111 = r103.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r103.label;
        if (r106 == 0) goto L16;
        if (r106 == 1) goto L15;
        if (r106 != 2) goto L14;
        ResultKt.throwOnFailure(r111);
    L23:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r102 = (Deflater) r103.L$1;
        r100 = (io.ktor.utils.io.d) r103.L$0;
        ResultKt.throwOnFailure(r111);
    L19:
        int r107 = Integer.reverseBytes(r102.getTotalIn());
        r103.L$0 = null;
        r103.L$1 = null;
        r103.label = 2;
        if (r100.v(r107, r103) != r105) goto L23;
        return r105;
    L16:
        ResultKt.throwOnFailure(r111);
        int r108 = Integer.reverseBytes((int) r101.getValue());
        r103.L$0 = r100;
        r103.L$1 = r102;
        r103.label = 1;
        if (r100.v(r108, r103) != r105) goto L19;
        return r105;
    L7:
        r103 = new DeflaterKt$putGzipTrailer$1(r110);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v27 */
    /* JADX WARN: Type inference failed for: r0v32 */
    /* JADX WARN: Type inference failed for: r11v0 */
    /* JADX WARN: Type inference failed for: r11v10 */
    /* JADX WARN: Type inference failed for: r11v11 */
    /* JADX WARN: Type inference failed for: r11v12 */
    /* JADX WARN: Type inference failed for: r11v13, types: [java.util.zip.Deflater] */
    /* JADX WARN: Type inference failed for: r11v14, types: [java.lang.Object, java.util.zip.Deflater] */
    /* JADX WARN: Type inference failed for: r11v16 */
    /* JADX WARN: Type inference failed for: r11v17 */
    /* JADX WARN: Type inference failed for: r11v18, types: [java.lang.Object, java.util.zip.Deflater] */
    /* JADX WARN: Type inference failed for: r11v20 */
    /* JADX WARN: Type inference failed for: r11v21 */
    /* JADX WARN: Type inference failed for: r11v23 */
    /* JADX WARN: Type inference failed for: r11v24 */
    /* JADX WARN: Type inference failed for: r11v25 */
    /* JADX WARN: Type inference failed for: r11v7, types: [java.util.zip.Deflater] */
    /* JADX WARN: Type inference failed for: r12v11 */
    /* JADX WARN: Type inference failed for: r12v4 */
    /* JADX WARN: Type inference failed for: r12v7, types: [java.lang.Object, java.util.zip.Deflater] */
    /* JADX WARN: Type inference failed for: r14v10 */
    /* JADX WARN: Type inference failed for: r14v11 */
    /* JADX WARN: Type inference failed for: r14v12, types: [io.ktor.utils.io.ByteReadChannel, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r14v14 */
    /* JADX WARN: Type inference failed for: r14v15 */
    /* JADX WARN: Type inference failed for: r14v17 */
    /* JADX WARN: Type inference failed for: r14v2 */
    /* JADX WARN: Type inference failed for: r14v8 */
    /* JADX WARN: Type inference failed for: r15v14 */
    /* JADX WARN: Type inference failed for: r15v6, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r15v9 */
    /* JADX WARN: Type inference failed for: r1v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v17, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v18, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v19, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v20, types: [boolean] */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v24, types: [boolean] */
    /* JADX WARN: Type inference failed for: r1v25 */
    /* JADX WARN: Type inference failed for: r1v26 */
    /* JADX WARN: Type inference failed for: r1v27 */
    /* JADX WARN: Type inference failed for: r1v28 */
    /* JADX WARN: Type inference failed for: r1v29 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v30 */
    /* JADX WARN: Type inference failed for: r1v31 */
    /* JADX WARN: Type inference failed for: r1v32 */
    /* JADX WARN: Type inference failed for: r1v33 */
    /* JADX WARN: Type inference failed for: r1v34 */
    /* JADX WARN: Type inference failed for: r1v35 */
    /* JADX WARN: Type inference failed for: r1v36 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v10, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v12, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v14, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v17 */
    /* JADX WARN: Type inference failed for: r4v18 */
    /* JADX WARN: Type inference failed for: r4v20, types: [java.lang.Object, java.nio.ByteBuffer] */
    /* JADX WARN: Type inference failed for: r4v22 */
    /* JADX WARN: Type inference failed for: r4v23 */
    /* JADX WARN: Type inference failed for: r4v24 */
    /* JADX WARN: Type inference failed for: r4v27 */
    /* JADX WARN: Type inference failed for: r4v28 */
    /* JADX WARN: Type inference failed for: r4v29 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v30 */
    /* JADX WARN: Type inference failed for: r4v31 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    /* JADX WARN: Type inference failed for: r5v0, types: [int] */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v14 */
    /* JADX WARN: Type inference failed for: r5v15 */
    /* JADX WARN: Type inference failed for: r5v17 */
    /* JADX WARN: Type inference failed for: r5v19, types: [java.util.zip.Deflater] */
    /* JADX WARN: Type inference failed for: r5v20, types: [java.lang.Object, java.nio.ByteBuffer] */
    /* JADX WARN: Type inference failed for: r5v21 */
    /* JADX WARN: Type inference failed for: r5v25 */
    /* JADX WARN: Type inference failed for: r5v31 */
    /* JADX WARN: Type inference failed for: r5v32 */
    /* JADX WARN: Type inference failed for: r5v33 */
    /* JADX WARN: Type inference failed for: r5v34 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:71:0x01f5 -> B:96:0x0165). Please report as a decompilation issue!!! */
    public static final Object a(ByteReadChannel r110, io.ktor.utils.io.d r210, boolean r211, io.ktor.utils.io.pool.e r212, Continuation r213) {
        io.ktor.utils.io.d r100 = r210;
        ?? r101 = r211;
        if ((r213 instanceof DeflaterKt$deflateTo$1) == false) goto L7;
        DeflaterKt$deflateTo$1 r102 = (DeflaterKt$deflateTo$1) r213;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ?? r106 = r102.label;
        int r111 = 2;
        final ?? r112 = 1;
        if (r106 != 0) goto L107;
        ResultKt.throwOnFailure(r104);
        CRC32 r113 = new CRC32();
        Deflater r107 = new Deflater(-1, true);
        ByteBuffer r108 = (ByteBuffer) r212.Q5();
        ByteBuffer r114 = (ByteBuffer) r212.Q5();
        if (r101 == 0) goto L53;
        ByteReadChannel r115 = r110;
        r102.L$0 = r115;     // Catch: Throwable -> L50
        r102.L$1 = r100;     // Catch: Throwable -> L50
        io.ktor.utils.io.pool.e r116 = r212;
        r102.L$2 = r116;     // Catch: Throwable -> L48
        r102.L$3 = r113;     // Catch: Throwable -> L48
        r102.L$4 = r107;     // Catch: Throwable -> L48
        r102.L$5 = r108;     // Catch: Throwable -> L48
        r102.L$6 = r114;     // Catch: Throwable -> L48
        r102.Z$0 = r101;     // Catch: Throwable -> L48
        r102.label = 1;     // Catch: Throwable -> L48
        if (c(r100, r102) == r105) goto L113;
        r112 = r107;
        ByteBuffer r109 = r108;
        ByteBuffer r117 = r114;
        io.ktor.utils.io.pool.e r118 = r116;
        r101 = r101;
        ?? r119 = r115;
    L47:
        ByteBuffer r120 = r109;
        Object r121 = r105;
        ?? r122 = r120;
    L96:
    L91:
        th = th;
        r101 = r117;
    L93:
        ?? r123 = r112;
        ?? r124 = r101;
        ?? r125 = r122;
    L94:
        r123.end();
        r118.Rl(r125);
        r118.Rl(r124);
        throw th;
    L55:
        if (r119.E() == true) goto L74;
        r122.clear();     // Catch: Throwable -> L91
        r102.L$0 = r119;     // Catch: Throwable -> L91
        r102.L$1 = r100;     // Catch: Throwable -> L91
        r102.L$2 = r118;     // Catch: Throwable -> L91
        r102.L$3 = r113;     // Catch: Throwable -> L91
        r102.L$4 = r112;     // Catch: Throwable -> L91
        r102.L$5 = r122;     // Catch: Throwable -> L91
        r102.L$6 = r117;     // Catch: Throwable -> L91
        r102.Z$0 = r101;     // Catch: Throwable -> L91
        r102.label = r111;     // Catch: Throwable -> L91
        Object r126 = r119.B(r122, r102);     // Catch: Throwable -> L91
        if (r126 == r121) goto L112;
        DeflaterKt$deflateTo$1 r127 = r102;
        ByteBuffer r128 = r117;
        r104 = r126;
        ?? r129 = r119;
        io.ktor.utils.io.pool.e r130 = r118;
        CRC32 r131 = r113;
        final ?? r132 = r112;
        Object r133 = r121;
        ?? r134 = r122;
        DeflaterKt$deflateTo$1 r135 = r127;
        r101 = r101;
    L108:
    L72:
        th = th;
        r124 = r128;
        r125 = r134;
        r123 = r132;
        r118 = r130;
        goto L94
    L61:
        if (((Number) r104).intValue() <= 0) goto L71;
        r134.flip();     // Catch: Throwable -> L72
        e(r131, r134);     // Catch: Throwable -> L72
        if (r134.hasArray() == false) goto L70;
        r132.setInput(r134.array(), r134.arrayOffset() + r134.position(), r134.remaining());     // Catch: Throwable -> L72
        Function0<Boolean> r136 = new DeflaterKt$deflateTo$2(r132);     // Catch: Throwable -> L72
        r135.L$0 = r129;     // Catch: Throwable -> L72
        r135.L$1 = r100;     // Catch: Throwable -> L72
        r135.L$2 = r130;     // Catch: Throwable -> L72
        r135.L$3 = r131;     // Catch: Throwable -> L72
        r135.L$4 = r132;     // Catch: Throwable -> L72
        r135.L$5 = r134;     // Catch: Throwable -> L72
        r135.L$6 = r128;     // Catch: Throwable -> L72
        r135.Z$0 = r101;     // Catch: Throwable -> L72
        r135.label = 3;     // Catch: Throwable -> L72
        if (b(r100, r132, r128, r136, r135) == r133) goto L111;
        r117 = r128;
        r102 = r135;
        r122 = r134;
        r121 = r133;
        r112 = r132;
        r113 = r131;
        r118 = r130;
        r119 = r129;
        r111 = 2;
        goto L96
    L111:
        return r133;
    L70:
        throw new IllegalArgumentException("buffer need to be array-backed".toString());     // Catch: Throwable -> L72
    L71:
        r117 = r128;
        r102 = r135;
        r122 = r134;
        r121 = r133;
        r112 = r132;
        r113 = r131;
        r118 = r130;
        r119 = r129;
    L112:
        return r121;
    L74:
        Throwable r137 = r119.d();     // Catch: Throwable -> L91
        if (r137 != null) goto L90;
        r112.finish();     // Catch: Throwable -> L91
        Function0<Boolean> r138 = new DeflaterKt$deflateTo$4(r112);     // Catch: Throwable -> L91
        r102.L$0 = r100;     // Catch: Throwable -> L91
        r102.L$1 = r118;     // Catch: Throwable -> L91
        r102.L$2 = r113;     // Catch: Throwable -> L91
        r102.L$3 = r112;     // Catch: Throwable -> L91
        r102.L$4 = r122;     // Catch: Throwable -> L91
        r102.L$5 = r117;     // Catch: Throwable -> L91
        r102.L$6 = null;     // Catch: Throwable -> L91
        r102.Z$0 = r101;     // Catch: Throwable -> L91
        r102.label = 4;     // Catch: Throwable -> L91
        if (b(r100, r112, r117, r138, r102) == r121) goto L112;
        CRC32 r139 = r113;
        ByteBuffer r140 = r117;
        io.ktor.utils.io.d r141 = r100;
        ?? r142 = r101;
        r101 = r140;
        r122 = r122;
        r112 = r112;
    L80:
        if (r142 != 0) goto L101;
    L88:
        r112.end();
        r118.Rl(r122);
        r118.Rl(r101);
        return Unit.INSTANCE;
    L101:
        r102.L$0 = r118;     // Catch: Throwable -> L86
        r102.L$1 = r112;     // Catch: Throwable -> L86
        r102.L$2 = r122;     // Catch: Throwable -> L86
        r102.L$3 = r101;     // Catch: Throwable -> L86
        r102.L$4 = null;     // Catch: Throwable -> L86
        r102.L$5 = null;     // Catch: Throwable -> L86
        r102.label = 5;     // Catch: Throwable -> L86
        if (d(r141, r139, r112, r102) == r121) goto L112;
        ?? r143 = r112;
        io.ktor.utils.io.pool.e r144 = r118;
        r101 = r101;
        r122 = r122;
    L85:
        r118 = r144;
        r112 = r143;
    L86:
        th = th;
        goto L93
    L90:
        throw r137;     // Catch: Throwable -> L91
    L113:
        return r105;
    L48:
        th = th;
    L52:
        r125 = r108;
        r124 = r114;
        r118 = r116;
        r123 = r107;
    L50:
        th = th;
        r116 = r212;
        goto L52
    L53:
        r119 = r110;
        r112 = r107;
        r121 = r105;
        r122 = r108;
        r117 = r114;
        r118 = r212;
        goto L96
    L107:
        if (r106 == 1) goto L33;
        if (r106 == 2) goto L30;
        if (r106 == 3) goto L27;
        if (r106 == 4) goto L22;
        if (r106 != 5) goto L21;
        ByteBuffer r145 = (ByteBuffer) r102.L$3;
        ByteBuffer r146 = (ByteBuffer) r102.L$2;
        Deflater r147 = (Deflater) r102.L$1;
        r144 = (io.ktor.utils.io.pool.e) r102.L$0;
        ResultKt.throwOnFailure(r104);     // Catch: Throwable -> L18
        r101 = r145;
        r122 = r146;
        r143 = r147;
    L18:
        th = th;
        r118 = r144;
        r124 = r145;
        r125 = r146;
        r123 = r147;
        goto L94
    L21:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L22:
        boolean r148 = r102.Z$0;
        ByteBuffer r149 = (ByteBuffer) r102.L$5;
        ByteBuffer r150 = (ByteBuffer) r102.L$4;
        Deflater r151 = (Deflater) r102.L$3;
        r139 = (CRC32) r102.L$2;
        io.ktor.utils.io.pool.e r152 = (io.ktor.utils.io.pool.e) r102.L$1;
        io.ktor.utils.io.d r153 = (io.ktor.utils.io.d) r102.L$0;
        ResultKt.throwOnFailure(r104);     // Catch: Throwable -> L25
        r118 = r152;
        r141 = r153;
        r112 = r151;
        r121 = r105;
        r122 = r150;
        r142 = r148;
        r101 = r149;
    L25:
        th = th;
        r125 = r150;
        r123 = r151;
        r118 = r152;
        r124 = r149;
        goto L94
    L27:
        boolean r154 = r102.Z$0;
        ByteBuffer r155 = (ByteBuffer) r102.L$6;
        ByteBuffer r156 = (ByteBuffer) r102.L$5;
        r112 = (Deflater) r102.L$4;
        r113 = (CRC32) r102.L$3;
        r118 = (io.ktor.utils.io.pool.e) r102.L$2;
        io.ktor.utils.io.d r157 = (io.ktor.utils.io.d) r102.L$1;
        ByteReadChannel r158 = (ByteReadChannel) r102.L$0;
        ResultKt.throwOnFailure(r104);     // Catch: Throwable -> L36
        r117 = r155;
        r101 = r154;
        r100 = r157;
        r119 = r158;
        r121 = r105;
        r122 = r156;
        r111 = 2;
        goto L96
    L30:
        boolean r159 = r102.Z$0;
        ByteBuffer r160 = (ByteBuffer) r102.L$6;
        ByteBuffer r161 = (ByteBuffer) r102.L$5;
        Deflater r162 = (Deflater) r102.L$4;
        CRC32 r163 = (CRC32) r102.L$3;
        io.ktor.utils.io.pool.e r164 = (io.ktor.utils.io.pool.e) r102.L$2;
        io.ktor.utils.io.d r165 = (io.ktor.utils.io.d) r102.L$1;
        ByteReadChannel r166 = (ByteReadChannel) r102.L$0;
        ResultKt.throwOnFailure(r104);     // Catch: Throwable -> L36
        r101 = r159;
        r100 = r165;
        r130 = r164;
        r131 = r163;
        r132 = r162;
        r133 = r105;
        r135 = r102;
        r128 = r160;
        r134 = r161;
        r129 = r166;
        goto L108
    L33:
        boolean r167 = r102.Z$0;
        ByteBuffer r168 = (ByteBuffer) r102.L$6;
        r109 = (ByteBuffer) r102.L$5;
        Deflater r169 = (Deflater) r102.L$4;
        r113 = (CRC32) r102.L$3;
        r118 = (io.ktor.utils.io.pool.e) r102.L$2;
        io.ktor.utils.io.d r170 = (io.ktor.utils.io.d) r102.L$1;
        ByteReadChannel r171 = (ByteReadChannel) r102.L$0;
        ResultKt.throwOnFailure(r104);     // Catch: Throwable -> L36
        r117 = r168;
        r101 = r167;
        r100 = r170;
        r119 = r171;
        r112 = r169;
    L36:
        th = th;
        r122 = r106;
    L7:
        r102 = new DeflaterKt$deflateTo$1(r213);
        goto L8
    }

    public static final Object b(io.ktor.utils.io.d r100, Deflater r101, ByteBuffer r102, Function0<Boolean> r103, Continuation<? super Unit> r104) {
        if ((r104 instanceof DeflaterKt$deflateWhile$1) == false) goto L7;
        DeflaterKt$deflateWhile$1 r105 = (DeflaterKt$deflateWhile$1) r104;
        int r106 = r105.label;
        if ((r106 & Integer.MIN_VALUE) == 0) goto L7;
        r105.label = r106 - Integer.MIN_VALUE;
    L8:
        Object r107 = r105.result;
        Object r108 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r109 = r105.label;
        if (r109 == 0) goto L14;
        if (r109 != 1) goto L13;
        r103 = (Function0) r105.L$3;
        r102 = (ByteBuffer) r105.L$2;
        r101 = (Deflater) r105.L$1;
        r100 = (io.ktor.utils.io.d) r105.L$0;
        goto L14
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r107);
    L16:
        if (r103.invoke().booleanValue() == false) goto L24;
        r102.clear();
        if (r102.hasRemaining() == false) goto L20;
        int r110 = r101.deflate(r102.array(), r102.arrayOffset() + r102.position(), r102.remaining());
        r102.position(r102.position() + r110);
    L20:
        r102.flip();
        r105.L$0 = r100;
        r105.L$1 = r101;
        r105.L$2 = r102;
        r105.L$3 = r103;
        r105.label = 1;
        if (r100.x(r102, r105) != r108) goto L16;
        return r108;
    L24:
        return Unit.INSTANCE;
    L7:
        r105 = new DeflaterKt$deflateWhile$1(r104);
        goto L8
    }
}
