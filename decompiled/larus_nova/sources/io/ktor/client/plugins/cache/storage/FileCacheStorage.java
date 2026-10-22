package io.ktor.client.plugins.cache.storage;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import io.ktor.client.plugins.cache.HttpCacheKt;
import io.ktor.http.Url;
import io.ktor.http.l0;
import io.ktor.http.n;
import io.ktor.http.o;
import io.ktor.http.w;
import io.ktor.http.x;
import io.ktor.util.j;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.core.CloseableJVMKt;
import io.ktor.utils.io.jvm.javaio.e;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.InputStream;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.ExceptionsKt;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: classes41.dex */
public final class FileCacheStorage implements a {
    public static String e(Url r100) {
        return j.b(MessageDigest.getInstance("MD5").digest(StringsKt.encodeToByteArray(r100.f491823h)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 11, insn: 0x0199: MOVE (r1 I:??[OBJECT, ARRAY]) = (r11 I:??[OBJECT, ARRAY]) (LINE:16777625), block:B:87:0x0199 */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v10 */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r14v0 */
    /* JADX WARN: Type inference failed for: r14v2 */
    /* JADX WARN: Type inference failed for: r14v3 */
    /* JADX WARN: Type inference failed for: r14v5, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r14v6 */
    /* JADX WARN: Type inference failed for: r16v0 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v16, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v19 */
    /* JADX WARN: Type inference failed for: r4v20, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r4v21 */
    /* JADX WARN: Type inference failed for: r4v23, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r4v25 */
    /* JADX WARN: Type inference failed for: r4v28, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r4v30 */
    /* JADX WARN: Type inference failed for: r4v31 */
    /* JADX WARN: Type inference failed for: r4v32 */
    /* JADX WARN: Type inference failed for: r4v33 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7, types: [java.io.InputStream, java.lang.Object] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:53:0x0120 -> B:54:0x0128). Please report as a decompilation issue!!! */
    public final Object g(Continuation r110) {
        if ((r110 instanceof FileCacheStorage$readCache$1) == false) goto L7;
        FileCacheStorage$readCache$1 r100 = (FileCacheStorage$readCache$1) r110;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        if (r104 == 0) goto L90;
        int r105 = 0;
        if (r104 == 1) goto L32;
        if (r104 == 2) goto L27;
        if (r104 == 3) goto L22;
        if (r104 != 4) goto L21;
        Set r106 = (Set) r100.L$2;
        ?? r107 = (Closeable) r100.L$1;
        kotlinx.coroutines.sync.a r108 = (kotlinx.coroutines.sync.a) r100.L$0;
        ResultKt.throwOnFailure(r102);     // Catch: Throwable -> L18
        ?? r109 = r107;
    L108:
        r109.close();     // Catch: Throwable -> L63 Exception -> L65
        r108.unlock(null);
        return r106;
    L65:
        e = e;
        kotlinx.coroutines.sync.a r111 = r108;
    L84:
        HttpCacheKt.f491672a.trace("Exception during cache lookup in a file: " + ExceptionsKt.stackTraceToString(e));     // Catch: Throwable -> L81
        Set r112 = SetsKt.emptySet();     // Catch: Throwable -> L81
        r111.unlock(null);
        return r112;
    L63:
        th = th;
    L88:
        r108.unlock(null);
        throw th;
    L18:
        th = th;
    L72:
        r111 = r108;
        Throwable r113 = th;
        ?? r114 = r107;
    L94:
        r114.close();     // Catch: Throwable -> L75
    L110:
        throw r113;     // Catch: Throwable -> L79
    L79:
        th = move-exception;
        throw th;     // Catch: Throwable -> L81 Exception -> L83
    L83:
        e = e;
    L75:
        th = move-exception;
        CloseableJVMKt.a(r113, th);     // Catch: Throwable -> L79
        throw r113;     // Catch: Throwable -> L79
    L21:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L22:
        int r115 = r100.I$2;
        int r116 = r100.I$1;
        int r117 = r100.I$0;
        Set r118 = (Set) r100.L$5;
        Set r119 = (Set) r100.L$4;
        ByteReadChannel r120 = (ByteReadChannel) r100.L$3;
        ?? r121 = (Closeable) r100.L$2;
        kotlinx.coroutines.sync.a r122 = (kotlinx.coroutines.sync.a) r100.L$1;
        FileCacheStorage r123 = (FileCacheStorage) r100.L$0;
        ResultKt.throwOnFailure(r102);     // Catch: Throwable -> L25
        int r124 = r116;
        int r125 = r117;
        r121 = r121;
    L54:
        r118.add(r102);     // Catch: Throwable -> L25
        int r126 = r115 + 1;
        r107 = r121;
        r111 = r122;
        int r127 = r125;
        r105 = r126;
        Object r128 = r103;
        r106 = r119;
        int r129 = r127;
    L49:
        if (r105 >= r124) goto L56;
        r100.L$0 = r123;     // Catch: Throwable -> L67
        r100.L$1 = r111;     // Catch: Throwable -> L67
        r100.L$2 = r107;     // Catch: Throwable -> L67
        r100.L$3 = r120;     // Catch: Throwable -> L67
        r100.L$4 = r106;     // Catch: Throwable -> L67
        r100.L$5 = r106;     // Catch: Throwable -> L67
        r100.I$0 = r129;     // Catch: Throwable -> L67
        r100.I$1 = r124;     // Catch: Throwable -> L67
        r100.I$2 = r105;     // Catch: Throwable -> L67
        r100.label = 3;     // Catch: Throwable -> L67
        Object r130 = r123.f(r120, r100);     // Catch: Throwable -> L67
        if (r130 != r128) goto L53;
        return r128;
    L53:
        r122 = r111;
        r118 = r106;
        r103 = r128;
        r102 = r130;
        r121 = r107;
        r115 = r105;
        r125 = r129;
        r119 = r118;
        goto L54
    L56:
        r100.L$0 = r111;     // Catch: Throwable -> L67
        r100.L$1 = r107;     // Catch: Throwable -> L67
        r100.L$2 = r106;     // Catch: Throwable -> L67
        r100.L$3 = null;     // Catch: Throwable -> L67
        r100.L$4 = null;     // Catch: Throwable -> L67
        r100.L$5 = null;     // Catch: Throwable -> L67
        r100.I$0 = r129;     // Catch: Throwable -> L67
        r100.label = 4;     // Catch: Throwable -> L67
        if (r120.p(Long.MAX_VALUE, r100) != r128) goto L59;
        return r128;
    L59:
        r108 = r111;
        r109 = r107;
    L67:
        th = th;
    L71:
        r108 = r111;
    L25:
        th = th;
        r107 = r121;
        r108 = r122;
        goto L72
    L27:
        int r131 = r100.I$0;
        ByteReadChannel r132 = (ByteReadChannel) r100.L$3;
        Closeable r133 = (Closeable) r100.L$2;
        r111 = (kotlinx.coroutines.sync.a) r100.L$1;
        FileCacheStorage r134 = (FileCacheStorage) r100.L$0;
        ResultKt.throwOnFailure(r102);     // Catch: Throwable -> L30
        ?? r135 = r133;
    L96:
        ?? r136 = r135;
        r124 = ((Number) r102).intValue();     // Catch: Throwable -> L69
        r128 = r103;
        r106 = new LinkedHashSet();     // Catch: Throwable -> L69
        r120 = r132;
        r123 = r134;
        r129 = r131;
        r107 = r136;
    L69:
        th = th;
        r107 = r135;
    L30:
        th = move-exception;
        r113 = th;
        r114 = r133;
        goto L94
    L32:
        r111 = (kotlinx.coroutines.sync.a) r100.L$2;
        String r137 = (String) r100.L$1;
        r134 = (FileCacheStorage) r100.L$0;
        ResultKt.throwOnFailure(r102);
        r134.getClass();     // Catch: Throwable -> L81
        PolarisFileWrapper r138 = new PolarisFileWrapper(null, r137);     // Catch: Throwable -> L81
        if (r138.exists() == true) goto L105;
        Set r139 = SetsKt.emptySet();     // Catch: Throwable -> L81
        r111.unlock(null);
        return r139;
    L105:
        InputStream r140 = new PolarisFileInputStreamWrapper(r138);     // Catch: Throwable -> L81 Exception -> L83
        if ((r140 instanceof BufferedInputStream) == false) goto L42;
        r107 = (BufferedInputStream) r140;     // Catch: Throwable -> L81 Exception -> L83
    L92:
        r132 = e.a(r107);     // Catch: Throwable -> L67
        r100.L$0 = r134;     // Catch: Throwable -> L67
        r100.L$1 = r111;     // Catch: Throwable -> L67
        r100.L$2 = r107;     // Catch: Throwable -> L67
        r100.L$3 = r132;     // Catch: Throwable -> L67
        r100.I$0 = 0;     // Catch: Throwable -> L67
        r100.label = 2;     // Catch: Throwable -> L67
        r102 = r132.F(r100);     // Catch: Throwable -> L67
        if (r102 != r103) goto L46;
        return r103;
    L46:
        r135 = r107;
        r131 = 0;
        goto L96
    L42:
        r107 = new BufferedInputStream(r140, 8192);     // Catch: Throwable -> L81 Exception -> L83
    L81:
        th = th;
        r108 = r11;
        goto L88
    L90:
        ResultKt.throwOnFailure(r102);
        FileCacheStorage$readCache$mutex$1 r141 = FileCacheStorage$readCache$mutex$1.INSTANCE;
        throw null;
    L7:
        r100 = new FileCacheStorage$readCache$1(this, r110);
        goto L8
    }

    @Override // io.ktor.client.plugins.cache.storage.a
    public final Object c(Url r100, Continuation<? super Set<b>> r101) {
        if ((r101 instanceof FileCacheStorage$findAll$1) == false) goto L7;
        FileCacheStorage$findAll$1 r102 = (FileCacheStorage$findAll$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        ResultKt.throwOnFailure(r104);
    L18:
        return CollectionsKt.toSet((Iterable) r104);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        e(r100);
        r102.label = 1;
        r104 = g(r102);
        if (r104 != r105) goto L18;
        return r105;
    L7:
        r102 = new FileCacheStorage$findAll$1(this, r101);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:73:0x037b -> B:21:0x01c7). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:99:0x0482 -> B:100:0x0492). Please report as a decompilation issue!!! */
    public final Object f(ByteReadChannel r210, Continuation<? super b> r211) {
        ByteReadChannel r100 = r210;
        if ((r211 instanceof FileCacheStorage$readCache$3) == false) goto L7;
        FileCacheStorage$readCache$3 r101 = (FileCacheStorage$readCache$3) r211;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = 0;
        switch(r101.label) {
            case 0: goto L28;
            case 1: goto L27;
            case 2: goto L26;
            case 3: goto L25;
            case 4: goto L24;
            case 5: goto L23;
            case 6: goto L22;
            case 7: goto L20;
            case 8: goto L19;
            case 9: goto L18;
            case 10: goto L17;
            case 11: goto L16;
            case 12: goto L15;
            case 13: goto L14;
            case 14: goto L13;
            case 15: goto L12;
            default: goto L11;
        };
    L12:
        byte[] r106 = (byte[]) r101.L$8;
        Map r107 = (Map) r101.L$7;
        hsc.a r108 = (hsc.a) r101.L$6;
        hsc.a r109 = (hsc.a) r101.L$5;
        hsc.a r110 = (hsc.a) r101.L$4;
        o r111 = (o) r101.L$3;
        w r112 = (w) r101.L$2;
        x r113 = (x) r101.L$1;
        String r114 = (String) r101.L$0;
        ResultKt.throwOnFailure(r103);
        byte[] r212 = r106;
        Map r213 = r107;
        hsc.a r214 = r108;
        hsc.a r115 = r109;
        hsc.a r116 = r110;
        w r117 = r112;
        x r118 = r113;
    L113:
        return new b(l0.b(r114), r118, r116, r115, r117, r214, r111.l(), r213, r212);
    L13:
        Map r119 = (Map) r101.L$8;
        hsc.a r120 = (hsc.a) r101.L$7;
        hsc.a r121 = (hsc.a) r101.L$6;
        hsc.a r122 = (hsc.a) r101.L$5;
        r111 = (o) r101.L$4;
        w r123 = (w) r101.L$3;
        x r124 = (x) r101.L$2;
        String r125 = (String) r101.L$1;
        ByteReadChannel r126 = (ByteReadChannel) r101.L$0;
        ResultKt.throwOnFailure(r103);
        Map r127 = r119;
        Object r128 = r104;
    L105:
        int r129 = ((Number) r103).intValue();
        byte[] r130 = new byte[r129];
        r101.L$0 = r125;
        r101.L$1 = r124;
        r101.L$2 = r123;
        r101.L$3 = r111;
        r101.L$4 = r122;
        r101.L$5 = r121;
        r101.L$6 = r120;
        r101.L$7 = r127;
        r101.L$8 = r130;
        r101.label = 15;
        Object r131 = r126.u(r130, r129, r101);
        if (r131 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L109;
        r131 = Unit.INSTANCE;
    L109:
        if (r131 != r128) goto L111;
        return r128;
    L111:
        r213 = r127;
        r214 = r120;
        r115 = r121;
        r116 = r122;
        r117 = r123;
        r118 = r124;
        r114 = r125;
        r212 = r130;
        goto L113
    L14:
        int r132 = r101.I$1;
        int r133 = r101.I$0;
        String r134 = (String) r101.L$10;
        Map r135 = (Map) r101.L$9;
        Map r136 = (Map) r101.L$8;
        hsc.a r137 = (hsc.a) r101.L$7;
        hsc.a r138 = (hsc.a) r101.L$6;
        hsc.a r139 = (hsc.a) r101.L$5;
        o r140 = (o) r101.L$4;
        w r141 = (w) r101.L$3;
        x r142 = (x) r101.L$2;
        String r143 = (String) r101.L$1;
        ByteReadChannel r144 = (ByteReadChannel) r101.L$0;
        ResultKt.throwOnFailure(r103);
        int r145 = r132;
        FileCacheStorage$readCache$3 r215 = r101;
        Map r146 = r135;
        r123 = r141;
        Map r147 = r136;
        r124 = r142;
        hsc.a r148 = r139;
        String r149 = r143;
        o r150 = r140;
        ByteReadChannel r151 = r144;
    L100:
        Intrinsics.checkNotNull(r103);
        r146.put(r134, (String) r103);
        r105 = r145 + 1;
        int r152 = r133;
        hsc.a r153 = r137;
        hsc.a r154 = r138;
        r125 = r149;
        r126 = r151;
        Map r155 = r147;
        Map r156 = r146;
        r101 = r215;
    L91:
        if (r105 >= r152) goto L101;
        r101.L$0 = r126;
        r101.L$1 = r125;
        r101.L$2 = r124;
        r101.L$3 = r123;
        r101.L$4 = r150;
        r101.L$5 = r148;
        r101.L$6 = r154;
        r101.L$7 = r153;
        r101.L$8 = r155;
        r101.L$9 = r156;
        r101.L$10 = null;
        r101.I$0 = r152;
        r101.I$1 = r105;
        r101.label = 12;
        Object r157 = r126.n(r101);
        if (r157 != r104) goto L95;
        return r104;
    L95:
        String r216 = r125;
        r137 = r153;
        ByteReadChannel r158 = r126;
        r138 = r154;
        r133 = r152;
        r103 = r157;
        w r159 = r123;
        Map r160 = r156;
        o r161 = r150;
        String r162 = r216;
        Map r217 = r155;
        hsc.a r163 = r148;
        x r164 = r124;
        Map r165 = r217;
    L96:
        Intrinsics.checkNotNull(r103);
        String r166 = (String) r103;
        r101.L$0 = r158;
        r101.L$1 = r162;
        r101.L$2 = r164;
        r101.L$3 = r159;
        r101.L$4 = r161;
        r101.L$5 = r163;
        r101.L$6 = r138;
        r101.L$7 = r137;
        r101.L$8 = r165;
        r101.L$9 = r160;
        r101.L$10 = r166;
        r101.I$0 = r133;
        r101.I$1 = r105;
        r101.label = 13;
        r103 = r158.n(r101);
        if (r103 != r104) goto L99;
        return r104;
    L99:
        int r218 = r105;
        r134 = r166;
        r215 = r101;
        r146 = r160;
        r123 = r159;
        r147 = r165;
        r124 = r164;
        r148 = r163;
        r149 = r162;
        r150 = r161;
        r151 = r158;
        r145 = r218;
        goto L100
    L101:
        Map r167 = MapsKt.build(r155);
        r101.L$0 = r126;
        r101.L$1 = r125;
        r101.L$2 = r124;
        r101.L$3 = r123;
        r101.L$4 = r150;
        r101.L$5 = r148;
        r101.L$6 = r154;
        r101.L$7 = r153;
        r101.L$8 = r167;
        r101.L$9 = null;
        r101.L$10 = null;
        r101.label = 14;
        Object r168 = r126.F(r101);
        if (r168 != r104) goto L104;
        return r104;
    L104:
        hsc.a r219 = r154;
        r120 = r153;
        r128 = r104;
        r127 = r167;
        r103 = r168;
        r111 = r150;
        r122 = r148;
        r121 = r219;
        goto L105
    L15:
        int r169 = r101.I$1;
        r133 = r101.I$0;
        Map r170 = (Map) r101.L$9;
        Map r171 = (Map) r101.L$8;
        hsc.a r172 = (hsc.a) r101.L$7;
        hsc.a r173 = (hsc.a) r101.L$6;
        hsc.a r174 = (hsc.a) r101.L$5;
        o r175 = (o) r101.L$4;
        w r176 = (w) r101.L$3;
        x r177 = (x) r101.L$2;
        String r178 = (String) r101.L$1;
        ByteReadChannel r179 = (ByteReadChannel) r101.L$0;
        ResultKt.throwOnFailure(r103);
        r105 = r169;
        r158 = r179;
        r159 = r176;
        r138 = r173;
        r160 = r170;
        r164 = r177;
        r163 = r174;
        r165 = r171;
        r162 = r178;
        r161 = r175;
        r137 = r172;
        goto L96
    L16:
        r153 = (hsc.a) r101.L$7;
        r154 = (hsc.a) r101.L$6;
        r148 = (hsc.a) r101.L$5;
        r150 = (o) r101.L$4;
        r123 = (w) r101.L$3;
        r124 = (x) r101.L$2;
        r125 = (String) r101.L$1;
        r126 = (ByteReadChannel) r101.L$0;
        ResultKt.throwOnFailure(r103);
    L90:
        r152 = ((Number) r103).intValue();
        r155 = MapsKt.createMapBuilder();
        r156 = r155;
        goto L91
    L17:
        hsc.a r180 = (hsc.a) r101.L$6;
        hsc.a r181 = (hsc.a) r101.L$5;
        o r182 = (o) r101.L$4;
        w r183 = (w) r101.L$3;
        x r184 = (x) r101.L$2;
        String r185 = (String) r101.L$1;
        ByteReadChannel r186 = (ByteReadChannel) r101.L$0;
        ResultKt.throwOnFailure(r103);
        r126 = r186;
        r125 = r185;
        r124 = r184;
        r123 = r183;
        r150 = r182;
        r148 = r181;
        r154 = r180;
    L87:
        r153 = io.ktor.util.date.a.b((Long) r103);
        r101.L$0 = r126;
        r101.L$1 = r125;
        r101.L$2 = r124;
        r101.L$3 = r123;
        r101.L$4 = r150;
        r101.L$5 = r148;
        r101.L$6 = r154;
        r101.L$7 = r153;
        r101.label = 11;
        r103 = r126.F(r101);
        if (r103 != r104) goto L90;
        return r104;
    L18:
        hsc.a r187 = (hsc.a) r101.L$5;
        o r188 = (o) r101.L$4;
        w r189 = (w) r101.L$3;
        x r190 = (x) r101.L$2;
        String r191 = (String) r101.L$1;
        ByteReadChannel r192 = (ByteReadChannel) r101.L$0;
        ResultKt.throwOnFailure(r103);
    L83:
        hsc.a r193 = io.ktor.util.date.a.b((Long) r103);
        r101.L$0 = r192;
        r101.L$1 = r191;
        r101.L$2 = r190;
        r101.L$3 = r189;
        r101.L$4 = r188;
        r101.L$5 = r187;
        r101.L$6 = r193;
        r101.label = 10;
        Object r194 = r192.j(r101);
        if (r194 != r104) goto L86;
        return r104;
    L86:
        r126 = r192;
        r124 = r190;
        r150 = r188;
        r154 = r193;
        r103 = r194;
        r125 = r191;
        r123 = r189;
        r148 = r187;
        goto L87
    L19:
        o r195 = (o) r101.L$4;
        w r196 = (w) r101.L$3;
        x r197 = (x) r101.L$2;
        String r198 = (String) r101.L$1;
        ByteReadChannel r199 = (ByteReadChannel) r101.L$0;
        ResultKt.throwOnFailure(r103);
        r192 = r199;
        r191 = r198;
        r190 = r197;
        r189 = r196;
        r188 = r195;
    L80:
        r187 = io.ktor.util.date.a.b((Long) r103);
        r101.L$0 = r192;
        r101.L$1 = r191;
        r101.L$2 = r190;
        r101.L$3 = r189;
        r101.L$4 = r188;
        r101.L$5 = r187;
        r101.label = 9;
        r103 = r192.j(r101);
        if (r103 != r104) goto L83;
        return r104;
    L20:
        int r200 = r101.I$1;
        int r201 = r101.I$0;
        String r202 = (String) r101.L$5;
        o r203 = (o) r101.L$4;
        w r204 = (w) r101.L$3;
        x r1100 = (x) r101.L$2;
        String r1101 = (String) r101.L$1;
        ByteReadChannel r1102 = (ByteReadChannel) r101.L$0;
        ResultKt.throwOnFailure(r103);
    L21:
        ByteReadChannel r220 = r1102;
        o r1103 = r203;
        ByteReadChannel r205 = r220;
        Intrinsics.checkNotNull(r103);
        r1103.e(r202, (String) r103);
        int r206 = r201;
        x r207 = r1100;
        String r208 = r1101;
        int r1104 = r200 + 1;
        w r209 = r204;
        o r221 = r1103;
    L67:
        if (r1104 >= r206) goto L76;
        r101.L$0 = r205;
        r101.L$1 = r208;
        r101.L$2 = r207;
        r101.L$3 = r209;
        r101.L$4 = r221;
        r101.L$5 = null;
        r101.I$0 = r206;
        r101.I$1 = r1104;
        r101.label = 6;
        Object r1105 = r205.n(r101);
        if (r1105 != r104) goto L71;
        return r104;
    L71:
        r1102 = r205;
        r203 = r221;
        r204 = r209;
        r200 = r1104;
        r1100 = r207;
        r201 = r206;
        r103 = r1105;
        r1101 = r208;
    L72:
        Intrinsics.checkNotNull(r103);
        r202 = (String) r103;
        r101.L$0 = r1102;
        r101.L$1 = r1101;
        r101.L$2 = r1100;
        r101.L$3 = r204;
        r101.L$4 = r203;
        r101.L$5 = r202;
        r101.I$0 = r201;
        r101.I$1 = r200;
        r101.label = 7;
        r103 = r1102.n(r101);
        if (r103 != r104) goto L21;
        return r104;
    L76:
        r101.L$0 = r205;
        r101.L$1 = r208;
        r101.L$2 = r207;
        r101.L$3 = r209;
        r101.L$4 = r221;
        r101.L$5 = null;
        r101.label = 8;
        r103 = r205.j(r101);
        if (r103 != r104) goto L79;
        return r104;
    L79:
        r192 = r205;
        r190 = r207;
        r188 = r221;
        r191 = r208;
        r189 = r209;
        goto L80
    L22:
        r200 = r101.I$1;
        r201 = r101.I$0;
        o r222 = (o) r101.L$4;
        w r223 = (w) r101.L$3;
        x r224 = (x) r101.L$2;
        String r1106 = (String) r101.L$1;
        ByteReadChannel r1107 = (ByteReadChannel) r101.L$0;
        ResultKt.throwOnFailure(r103);
        r1102 = r1107;
        r1101 = r1106;
        r1100 = r224;
        r204 = r223;
        r203 = r222;
        goto L72
    L23:
        r209 = (w) r101.L$3;
        r207 = (x) r101.L$2;
        r208 = (String) r101.L$1;
        r205 = (ByteReadChannel) r101.L$0;
        ResultKt.throwOnFailure(r103);
    L66:
        r206 = ((Number) r103).intValue();
        r221 = new o(0);
        r1104 = 0;
        goto L67
    L24:
        w.a r225 = (w.a) r101.L$3;
        r207 = (x) r101.L$2;
        r208 = (String) r101.L$1;
        r205 = (ByteReadChannel) r101.L$0;
        ResultKt.throwOnFailure(r103);
    L42:
        Intrinsics.checkNotNull(r103);
        CharSequence r226 = (CharSequence) r103;
        r225.getClass();
        Intrinsics.checkNotNullParameter(r226, "value");
        List r227 = StringsKt.split$default(r226, new String[]{HTTP.URL_DEFAULT, "."}, false, 0, 6, null);
        if (r227.size() != 3) goto L45;
        boolean r228 = true;
    L46:
        if (r228 == false) goto L115;
        String r229 = (String) ListProtector.get(r227, 0);
        String r1108 = (String) ListProtector.get(r227, 1);
        String r230 = (String) ListProtector.get(r227, 2);
        int r1109 = CastIntegerProtector.parseInt(r1108);
        int r231 = CastIntegerProtector.parseInt(r230);
        Intrinsics.checkNotNullParameter(r229, "name");
        if (Intrinsics.areEqual(r229, "HTTP") == false) goto L53;
        if (r1109 != 1) goto L53;
        if (r231 != 0) goto L53;
        r209 = w.f491912g;
    L63:
        r101.L$0 = r205;
        r101.L$1 = r208;
        r101.L$2 = r207;
        r101.L$3 = r209;
        r101.label = 5;
        r103 = r205.F(r101);
        if (r103 != r104) goto L66;
        return r104;
    L53:
        if (Intrinsics.areEqual(r229, "HTTP") == false) goto L58;
        if (r1109 != 1) goto L58;
        if (r231 != 1) goto L58;
        r209 = w.f491911f;
    L58:
        if (Intrinsics.areEqual(r229, "HTTP") == false) goto L62;
        if (r1109 != 2) goto L62;
        if (r231 != 0) goto L62;
        r209 = w.f491910e;
    L62:
        r209 = new w(r229, r1109, r231);
        goto L63
    L115:
        throw new IllegalStateException(("Failed to parse HttpProtocolVersion. Expected format: protocol/major.minor, but actual: " + r226).toString());
    L45:
        r228 = false;
        goto L46
    L25:
        int r232 = r101.I$0;
        String r233 = (String) r101.L$1;
        ByteReadChannel r234 = (ByteReadChannel) r101.L$0;
        ResultKt.throwOnFailure(r103);
    L38:
        Intrinsics.checkNotNull(r103);
        x r235 = new x(r232, (String) r103);
        r225 = w.f491909d;
        r101.L$0 = r234;
        r101.L$1 = r233;
        r101.L$2 = r235;
        r101.L$3 = r225;
        r101.label = 4;
        r103 = r234.n(r101);
        if (r103 != r104) goto L41;
        return r104;
    L41:
        ByteReadChannel r236 = r234;
        r208 = r233;
        r207 = r235;
        r205 = r236;
        goto L42
    L26:
        String r237 = (String) r101.L$1;
        ByteReadChannel r238 = (ByteReadChannel) r101.L$0;
        ResultKt.throwOnFailure(r103);
        r234 = r238;
        r233 = r237;
    L35:
        r232 = ((Number) r103).intValue();
        r101.L$0 = r234;
        r101.L$1 = r233;
        r101.I$0 = r232;
        r101.label = 3;
        r103 = r234.n(r101);
        if (r103 != r104) goto L38;
        return r104;
    L27:
        r100 = (ByteReadChannel) r101.L$0;
        ResultKt.throwOnFailure(r103);
    L31:
        Intrinsics.checkNotNull(r103);
        String r239 = (String) r103;
        r101.L$0 = r100;
        r101.L$1 = r239;
        r101.label = 2;
        Object r240 = r100.F(r101);
        if (r240 != r104) goto L34;
        return r104;
    L34:
        r234 = r100;
        r233 = r239;
        r103 = r240;
        goto L35
    L28:
        ResultKt.throwOnFailure(r103);
        r101.L$0 = r100;
        r101.label = 1;
        r103 = r100.n(r101);
        if (r103 != r104) goto L31;
        return r104;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L7:
        r101 = new FileCacheStorage$readCache$3(this, r211);
        goto L8
    }

    @Override // io.ktor.client.plugins.cache.storage.a
    public final Object a(Url r100, Map<String, String> r101, Continuation<? super b> r102) {
        if ((r102 instanceof FileCacheStorage$find$1) == false) goto L7;
        FileCacheStorage$find$1 r103 = (FileCacheStorage$find$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L14;
        if (r107 != 1) goto L13;
        r101 = (Map) r103.L$0;
        ResultKt.throwOnFailure(r105);
    L17:
        Iterator r108 = ((Set) r105).iterator();
    L19:
        if (r108.hasNext() == false) goto L32;
        Object r109 = r108.next();
        b r110 = (b) r109;
        if (r101.isEmpty() == true) goto L29;
        Iterator<Map.Entry<String, String>> r111 = r101.entrySet().iterator();
    L25:
        if (r111.hasNext() == false) goto L29;
        Map.Entry<String, String> r112 = r111.next();
        String r113 = r112.getKey();
        String r114 = r112.getValue();
        if (Intrinsics.areEqual(r110.f491705h.get(r113), r114) == true) goto L25;
        boolean r115 = false;
    L30:
        if (r115 == false) goto L19;
        return r109;
    L29:
        r115 = true;
        goto L30
    L32:
        return null;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r105);
        e(r100);
        r103.L$0 = r101;
        r103.label = 1;
        r105 = g(r103);
        if (r105 != r106) goto L17;
        return r106;
    L7:
        r103 = new FileCacheStorage$find$1(this, r102);
        goto L8
    }

    @Override // io.ktor.client.plugins.cache.storage.a
    public final Object b(Url r100, b r101, ContinuationImpl r102) {
        Object r103 = BuildersKt.withContext(null, new FileCacheStorage$store$2(this, r100, r101, null), r102);
        if (r103 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r103;
    L6:
        return Unit.INSTANCE;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:62:0x0250 -> B:53:0x01f0). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:86:0x0316 -> B:77:0x02b5). Please report as a decompilation issue!!! */
    public static final Object d(FileCacheStorage r110, io.ktor.utils.io.b r111, b r112, Continuation r113) {
        r110.getClass();
        if ((r113 instanceof FileCacheStorage$writeCache$3) == false) goto L7;
        FileCacheStorage$writeCache$3 r100 = (FileCacheStorage$writeCache$3) r113;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r114 = r100.result;
        Object r115 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(r100.label) {
            case 0: goto L27;
            case 1: goto L26;
            case 2: goto L25;
            case 3: goto L24;
            case 4: goto L23;
            case 5: goto L22;
            case 6: goto L21;
            case 7: goto L20;
            case 8: goto L19;
            case 9: goto L18;
            case 10: goto L17;
            case 11: goto L16;
            case 12: goto L15;
            case 13: goto L14;
            case 14: goto L13;
            case 15: goto L12;
            default: goto L11;
        };
    L12:
        ResultKt.throwOnFailure(r114);
    L98:
        return Unit.INSTANCE;
    L13:
        b r116 = (b) r100.L$1;
        io.ktor.utils.io.b r117 = (io.ktor.utils.io.b) r100.L$0;
        ResultKt.throwOnFailure(r114);
    L91:
        byte[] r118 = r116.f491706i;
        r100.L$0 = null;
        r100.L$1 = null;
        r100.label = 15;
        Object r119 = r117.t(r118, 0, r118.length, r100);
        if (r119 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L95;
        r119 = Unit.INSTANCE;
    L95:
        if (r119 != r115) goto L98;
        return r115;
    L14:
        Iterator<Map.Entry<String, String>> r120 = (Iterator) r100.L$2;
        b r121 = (b) r100.L$1;
        io.ktor.utils.io.b r102 = (io.ktor.utils.io.b) r100.L$0;
        ResultKt.throwOnFailure(r114);
    L78:
        if (r120.hasNext() == false) goto L87;
        Map.Entry<String, String> r122 = r120.next();
        String r103 = r122.getKey();
        String r123 = r122.getValue();
        String r104 = r103 + '\n';
        r100.L$0 = r102;
        r100.L$1 = r121;
        r100.L$2 = r120;
        r100.L$3 = r123;
        r100.label = 12;
        if (io.ktor.utils.io.e.b(r102, r104, r100) == r115) goto L112;
        io.ktor.utils.io.b r105 = r102;
        b r106 = r121;
        Iterator<Map.Entry<String, String>> r124 = r120;
        String r125 = r123;
    L83:
        String r126 = r125 + '\n';
        r100.L$0 = r105;
        r100.L$1 = r106;
        r100.L$2 = r124;
        r100.L$3 = null;
        r100.label = 13;
        if (io.ktor.utils.io.e.b(r105, r126, r100) == r115) goto L113;
        r120 = r124;
        r121 = r106;
        r102 = r105;
        goto L78
    L113:
        return r115;
    L112:
        return r115;
    L87:
        int r127 = r121.f491706i.length;
        r100.L$0 = r102;
        r100.L$1 = r121;
        r100.L$2 = null;
        r100.label = 14;
        if (r102.v(r127, r100) == r115) goto L114;
        r116 = r121;
        r117 = r102;
        goto L91
    L114:
        return r115;
    L15:
        r125 = (String) r100.L$3;
        r124 = (Iterator) r100.L$2;
        r106 = (b) r100.L$1;
        r105 = (io.ktor.utils.io.b) r100.L$0;
        ResultKt.throwOnFailure(r114);
        goto L83
    L16:
        b r128 = (b) r100.L$1;
        io.ktor.utils.io.b r129 = (io.ktor.utils.io.b) r100.L$0;
        ResultKt.throwOnFailure(r114);
    L76:
        r102 = r129;
        r121 = r128;
        r120 = r128.f491705h.entrySet().iterator();
        goto L78
    L17:
        r128 = (b) r100.L$1;
        r129 = (io.ktor.utils.io.b) r100.L$0;
        ResultKt.throwOnFailure(r114);
    L73:
        int r130 = r128.f491705h.size();
        r100.L$0 = r129;
        r100.L$1 = r128;
        r100.label = 11;
        if (r129.v(r130, r100) != r115) goto L76;
        return r115;
    L18:
        r128 = (b) r100.L$1;
        r129 = (io.ktor.utils.io.b) r100.L$0;
        ResultKt.throwOnFailure(r114);
    L70:
        long r107 = r128.f491703f.f487089i;
        r100.L$0 = r129;
        r100.L$1 = r128;
        r100.label = 10;
        if (r129.q(r107, r100) != r115) goto L73;
        return r115;
    L19:
        r128 = (b) r100.L$1;
        r129 = (io.ktor.utils.io.b) r100.L$0;
        ResultKt.throwOnFailure(r114);
    L67:
        long r108 = r128.f491701d.f487089i;
        r100.L$0 = r129;
        r100.L$1 = r128;
        r100.label = 9;
        if (r129.q(r108, r100) != r115) goto L70;
        return r115;
    L20:
        Iterator r131 = (Iterator) r100.L$2;
        b r132 = (b) r100.L$1;
        io.ktor.utils.io.b r109 = (io.ktor.utils.io.b) r100.L$0;
        ResultKt.throwOnFailure(r114);
    L54:
        if (r131.hasNext() == false) goto L63;
        Pair r133 = (Pair) r131.next();
        String r134 = (String) r133.component1();
        String r135 = (String) r133.component2();
        String r136 = r134 + '\n';
        r100.L$0 = r109;
        r100.L$1 = r132;
        r100.L$2 = r131;
        r100.L$3 = r135;
        r100.label = 6;
        if (io.ktor.utils.io.e.b(r109, r136, r100) == r115) goto L106;
        io.ktor.utils.io.b r137 = r109;
        b r138 = r132;
        Iterator r139 = r131;
        String r140 = r135;
    L59:
        String r141 = r140 + '\n';
        r100.L$0 = r137;
        r100.L$1 = r138;
        r100.L$2 = r139;
        r100.L$3 = null;
        r100.label = 7;
        if (io.ktor.utils.io.e.b(r137, r141, r100) == r115) goto L107;
        r131 = r139;
        r132 = r138;
        r109 = r137;
        goto L54
    L107:
        return r115;
    L106:
        return r115;
    L63:
        long r142 = r132.f491700c.f487089i;
        r100.L$0 = r109;
        r100.L$1 = r132;
        r100.L$2 = null;
        r100.label = 8;
        if (r109.q(r142, r100) == r115) goto L108;
        r128 = r132;
        r129 = r109;
        goto L67
    L108:
        return r115;
    L21:
        r140 = (String) r100.L$3;
        r139 = (Iterator) r100.L$2;
        r138 = (b) r100.L$1;
        r137 = (io.ktor.utils.io.b) r100.L$0;
        ResultKt.throwOnFailure(r114);
        goto L59
    L22:
        List r143 = (List) r100.L$2;
        r132 = (b) r100.L$1;
        r109 = (io.ktor.utils.io.b) r100.L$0;
        ResultKt.throwOnFailure(r114);
    L52:
        r131 = r143.iterator();
        goto L54
    L23:
        b r144 = (b) r100.L$1;
        io.ktor.utils.io.b r145 = (io.ktor.utils.io.b) r100.L$0;
        ResultKt.throwOnFailure(r114);
    L40:
        n r146 = r144.f491704g;
        Intrinsics.checkNotNullParameter(r146, "<this>");
        Set<Map.Entry<String, List<String>>> r147 = r146.entries();
        ArrayList r148 = new ArrayList();
        Iterator<T> r149 = r147.iterator();
    L42:
        if (r149.hasNext() == false) goto L48;
        Map.Entry r150 = (Map.Entry) r149.next();
        Iterable r151 = (Iterable) r150.getValue();
        ArrayList r152 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r151, 10));
        Iterator r153 = r151.iterator();
    L45:
        if (r153.hasNext() == false) goto L47;
        r152.add(TuplesKt.to(r150.getKey(), (String) r153.next()));
        goto L45
    L47:
        CollectionsKt.addAll(r148, r152);
        goto L42
    L48:
        int r154 = r148.size();
        r100.L$0 = r145;
        r100.L$1 = r144;
        r100.L$2 = r148;
        r100.label = 5;
        if (r145.v(r154, r100) == r115) goto L105;
        io.ktor.utils.io.b r155 = r145;
        r132 = r144;
        r143 = r148;
        r109 = r155;
        goto L52
    L105:
        return r115;
    L24:
        r144 = (b) r100.L$1;
        r145 = (io.ktor.utils.io.b) r100.L$0;
        ResultKt.throwOnFailure(r114);
    L37:
        StringBuilder r156 = new StringBuilder();
        r156.append(r144.f491702e);
        r156.append('\n');
        String r157 = r156.toString();
        r100.L$0 = r145;
        r100.L$1 = r144;
        r100.label = 4;
        if (io.ktor.utils.io.e.b(r145, r157, r100) != r115) goto L40;
        return r115;
    L25:
        r144 = (b) r100.L$1;
        r145 = (io.ktor.utils.io.b) r100.L$0;
        ResultKt.throwOnFailure(r114);
    L34:
        String r158 = r144.f491699b.f491928b + '\n';
        r100.L$0 = r145;
        r100.L$1 = r144;
        r100.label = 3;
        if (io.ktor.utils.io.e.b(r145, r158, r100) != r115) goto L37;
        return r115;
    L26:
        r112 = (b) r100.L$1;
        r111 = (io.ktor.utils.io.b) r100.L$0;
        ResultKt.throwOnFailure(r114);
    L30:
        int r159 = r112.f491699b.f491927a;
        r100.L$0 = r111;
        r100.L$1 = r112;
        r100.label = 2;
        if (r111.v(r159, r100) == r115) goto L102;
        b r160 = r112;
        r145 = r111;
        r144 = r160;
        goto L34
    L102:
        return r115;
    L27:
        ResultKt.throwOnFailure(r114);
        StringBuilder r161 = new StringBuilder();
        r161.append(r112.f491698a);
        r161.append('\n');
        String r162 = r161.toString();
        r100.L$0 = r111;
        r100.L$1 = r112;
        r100.label = 1;
        if (io.ktor.utils.io.e.b(r111, r162, r100) != r115) goto L30;
        return r115;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L7:
        r100 = new FileCacheStorage$writeCache$3(r110, r113);
        goto L8
    }
}
