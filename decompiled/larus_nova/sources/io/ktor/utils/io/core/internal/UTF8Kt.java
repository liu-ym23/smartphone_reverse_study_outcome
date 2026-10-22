package io.ktor.utils.io.core.internal;

import io.ktor.utils.io.charsets.TooLongLineException;
import io.ktor.utils.io.core.n;
import java.io.EOFException;
import java.nio.ByteBuffer;
import kotlin.ResultKt;
import kotlin.UByte;
import kotlin.UShort;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.CharCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes41.dex */
public final class UTF8Kt {
    public static final void c(int r100) {
        throw new IllegalArgumentException("Malformed code-point " + r100 + " found");
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x00ac -> B:23:0x00b1). Please report as a decompilation issue!!! */
    public static final Object a(Appendable r210, int r211, Function2<? super Integer, ? super Continuation<? super n>, ? extends Object> r310, Function1<? super Integer, Unit> r311, Continuation<? super Boolean> r312) {
        if ((r312 instanceof UTF8Kt$decodeUTF8LineLoopSuspend$1) == false) goto L7;
        UTF8Kt$decodeUTF8LineLoopSuspend$1 r100 = (UTF8Kt$decodeUTF8LineLoopSuspend$1) r312;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        int r105 = 1;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        int r106 = r100.I$0;
        Ref.BooleanRef r107 = (Ref.BooleanRef) r100.L$6;
        Ref.BooleanRef r108 = (Ref.BooleanRef) r100.L$5;
        Ref.IntRef r109 = (Ref.IntRef) r100.L$4;
        Ref.IntRef r110 = (Ref.IntRef) r100.L$3;
        Function1<? super Integer, Unit> r111 = (Function1) r100.L$2;
        Function2<? super Integer, ? super Continuation<? super n>, ? extends Object> r112 = (Function2) r100.L$1;
        Appendable r113 = (Appendable) r100.L$0;
        ResultKt.throwOnFailure(r102);
        UTF8Kt$decodeUTF8LineLoopSuspend$1 r114 = r100;
        int r115 = r106;
        Function1<? super Integer, Unit> r116 = r111;
        Ref.IntRef r117 = r109;
        Ref.BooleanRef r118 = r107;
        Object r119 = r103;
        Function2<? super Integer, ? super Continuation<? super n>, ? extends Object> r120 = r112;
        Ref.IntRef r121 = r110;
        Ref.BooleanRef r122 = r108;
    L23:
        n r123 = (n) r102;
        if (r123 == null) goto L200;
        long r124 = r123.k();
        String r125 = "<this>";
        Intrinsics.checkNotNullParameter(r123, "<this>");
        a r126 = r123.m(r105);
        if (r126 != null) goto L29;
        Function2<? super Integer, ? super Continuation<? super n>, ? extends Object> r212 = r120;
        r116 = r116;
        UTF8Kt$decodeUTF8LineLoopSuspend$1 r213 = r114;
        r119 = r119;
        n r127 = r123;
        r124 = r124;
    L190:
        Function1<? super Integer, Unit> r128 = r116;
        r128.invoke(Boxing.boxInt((int) (r124 - r127.k())));
        r120 = r212;
        r119 = r119;
        r116 = r128;
        Appendable r129 = r113;
        r105 = 1;
        r114 = r213;
    L16:
        if (r118.element == true) goto L200;
        int r130 = r117.element;
        if (r130 == 0) goto L200;
        Integer r131 = Boxing.boxInt(r130);
        r114.L$0 = r129;
        r114.L$1 = r120;
        r114.L$2 = r116;
        r114.L$3 = r121;
        r114.L$4 = r117;
        r114.L$5 = r122;
        r114.L$6 = r118;
        r114.I$0 = r115;
        r114.label = r105;
        Object r132 = r120.invoke(r131, r114);
        if (r132 != r119) goto L22;
        return r119;
    L22:
        r113 = r129;
        r102 = r132;
        goto L23
    L29:
        a r133 = r126;
    L30:
        r212 = r120;
        r213 = r114;
        int r134 = r133.f492022c - r133.f492021b;
        if (r134 >= r105) goto L223;
        n r214 = r123;
        boolean r135 = false;
    L173:
        if (r134 != 0) goto L176;
        r127 = r214;
        a r136 = c.b(r127, r133);     // Catch: Throwable -> L192
    L182:
        a r137 = r136;
        r125 = r125;
    L184:
        if (r137 == null) goto L185;
        if (r105 <= 0) goto L187;
        r114 = r213;
        r119 = r119;
        r133 = r137;
        r123 = r127;
        r124 = r124;
        r120 = r212;
        r116 = r116;
        goto L30
    L187:
        r133 = r137;
        boolean r138 = true;
    L188:
        if (r138 == false) goto L190;
        c.a(r127, r133);
        goto L190
    L185:
        r138 = false;
    L192:
        th = th;
    L197:
        if (r135 == false) goto L199;
        c.a(r127, r133);
    L199:
        throw th;
    L176:
        r127 = r214;
        if (r134 >= r105) goto L179;
    L183:
        c.a(r127, r133);     // Catch: Throwable -> L192
        r125 = r125;
        Intrinsics.checkNotNullParameter(r127, r125);     // Catch: Throwable -> L192
        r137 = r127.m(r105);     // Catch: Throwable -> L192
        goto L184
    L179:
        if ((r133.f492025f - r133.f492024e) < 8) goto L183;
        r136 = r133;
        goto L182
    L223:
        Ref.IntRef r139 = new Ref.IntRef();     // Catch: Throwable -> L167
        Ref.IntRef r140 = new Ref.IntRef();     // Catch: Throwable -> L167
        Ref.IntRef r141 = new Ref.IntRef();     // Catch: Throwable -> L167
        Ref.IntRef r142 = new Ref.IntRef();     // Catch: Throwable -> L167
        ByteBuffer r143 = r133.f492020a;     // Catch: Throwable -> L167
        int r144 = r133.f492021b;     // Catch: Throwable -> L167
        int r145 = r133.f492022c;     // Catch: Throwable -> L167
        int r146 = r144;
    L36:
        if (r146 >= r145) goto L157;
        r214 = r123;
    L66:
        th = move-exception;
        throw th;     // Catch: Throwable -> L170
    L39:
        int r147 = r143.get(r146) & UByte.MAX_VALUE;
        ByteBuffer r215 = r143;
        int r216 = -1;
        Ref.IntRef r217 = r117;
        int r218 = r145;
        if ((r147 & 128) != 0) goto L68;
        int r148 = r140.element;     // Catch: Throwable -> L66
        if (r148 != 0) goto L65;
        char r149 = (char) r147;     // Catch: Throwable -> L66
        if (r149 == '\r') goto L46;
        Ref.IntRef r219 = r142;
        if (r149 != '\n') goto L53;
        r118.element = true;     // Catch: Throwable -> L66
        r139.element = 1;     // Catch: Throwable -> L66
    L55:
        boolean r150 = false;
    L59:
        if (r150 == false) goto L60;
        r142 = r219;
        Ref.IntRef r220 = r140;
    L156:
        r146 = r146 + 1;     // Catch: Throwable -> L66
        r123 = r214;
        r143 = r215;
        r117 = r217;
        r145 = r218;
        r140 = r220;
        goto L36
    L60:
        r133.c(r146 - r144);     // Catch: Throwable -> L66
    L104:
        int r151 = r216;
        r117 = r217;
        r135 = false;
    L158:
        r117.element = r151;     // Catch: Throwable -> L66
        int r152 = r139.element;     // Catch: Throwable -> L66
        if (r152 <= 0) goto L162;
        r133.c(r152);     // Catch: Throwable -> L66
    L162:
        if (r118.element == false) goto L164;
        r105 = 0;
    L165:
        r117.element = r105;     // Catch: Throwable -> L66
        r134 = r133.f492022c - r133.f492021b;     // Catch: Throwable -> L170
    L170:
        th = th;
        r127 = r214;
    L196:
        r135 = true;
        goto L197
    L164:
        r105 = RangesKt.coerceAtLeast(r117.element, 1);     // Catch: Throwable -> L66
        goto L165
    L53:
        if (r122.element == false) goto L56;
        r118.element = true;     // Catch: Throwable -> L66
        goto L55
    L56:
        int r153 = r121.element;     // Catch: Throwable -> L66
        if (r153 == r115) goto L63;
        r121.element = r153 + 1;     // Catch: Throwable -> L66
        r113.append(r149);     // Catch: Throwable -> L66
        r150 = true;
        goto L59
    L63:
        throw new TooLongLineException("Too many characters in line: limit " + r115 + " exceeded");     // Catch: Throwable -> L66
    L46:
        if (r122.element == false) goto L48;
        r118.element = true;     // Catch: Throwable -> L66
        r219 = r142;
        goto L55
    L48:
        r150 = true;
        r122.element = true;     // Catch: Throwable -> L66
        r219 = r142;
        goto L59
    L65:
        throw new MalformedUTF8InputException("Expected " + r148 + " more character bytes");     // Catch: Throwable -> L66
    L68:
        Ref.IntRef r221 = r142;
        if (r140.element != 0) goto L79;
        r141.element = r147;     // Catch: Throwable -> L66
        int r154 = 128;
        int r155 = 1;
    L72:
        if (r155 >= 7) goto L76;
        int r156 = r141.element;     // Catch: Throwable -> L66
        if ((r156 & r154) == 0) goto L76;
        r141.element = r156 & (~r154);     // Catch: Throwable -> L66
        r154 = r154 >> 1;     // Catch: Throwable -> L66
        r140.element++;     // Catch: Throwable -> L66
        r155 = r155 + 1;     // Catch: Throwable -> L66
    L76:
        r142 = r221;
        r142.element = r140.element;     // Catch: Throwable -> L66
        r140.element--;     // Catch: Throwable -> L66
        if (r142.element > (r218 - r146)) goto L78;
    L155:
        r220 = r140;
        goto L156
    L78:
        r133.c(r146 - r144);     // Catch: Throwable -> L66
        r216 = r142.element;     // Catch: Throwable -> L66
        goto L104
    L79:
        r142 = r221;
        r141.element = (r141.element << 6) | (r147 & 127);     // Catch: Throwable -> L66
        int r157 = r140.element - 1;     // Catch: Throwable -> L66
        r140.element = r157;     // Catch: Throwable -> L66
        if (r157 != 0) goto L155;
        int r158 = r141.element;     // Catch: Throwable -> L66
        if ((r158 >>> 16) != 0) goto L84;
        boolean r159 = true;
    L85:
        if (r159 == false) goto L107;
        char r160 = (char) r158;     // Catch: Throwable -> L66
        if (r160 == '\r') goto L89;
        r220 = r140;
        if (r160 != '\n') goto L96;
        r118.element = true;     // Catch: Throwable -> L66
        r139.element = 1;     // Catch: Throwable -> L66
    L98:
        boolean r161 = false;
    L102:
        if (r161 == false) goto L103;
    L147:
        r141.element = 0;     // Catch: Throwable -> L66
        goto L156
    L103:
        r133.c(((r146 - r144) - r142.element) + 1);     // Catch: Throwable -> L66
        goto L104
    L96:
        if (r122.element == false) goto L99;
        r118.element = true;     // Catch: Throwable -> L66
        goto L98
    L99:
        int r162 = r121.element;     // Catch: Throwable -> L66
        if (r162 == r115) goto L106;
        r121.element = r162 + 1;     // Catch: Throwable -> L66
        r113.append(r160);     // Catch: Throwable -> L66
        r161 = true;
        goto L102
    L106:
        throw new TooLongLineException("Too many characters in line: limit " + r115 + " exceeded");     // Catch: Throwable -> L66
    L89:
        if (r122.element == false) goto L91;
        r118.element = true;     // Catch: Throwable -> L66
        r220 = r140;
        goto L98
    L91:
        r161 = true;
        r122.element = true;     // Catch: Throwable -> L66
        r220 = r140;
        goto L102
    L107:
        r220 = r140;
        if (r158 > 1114111) goto L110;
        boolean r163 = true;
    L111:
        if (r163 == false) goto L153;
        char r164 = (char) ((r158 >>> 10) + 55232);     // Catch: Throwable -> L66
        if (r164 != '\r') goto L119;
        if (r122.element == false) goto L117;
        r118.element = true;     // Catch: Throwable -> L66
    L124:
        boolean r165 = false;
    L128:
        if (r165 == false) goto L150;
        char r166 = (char) ((r141.element & 1023) + 56320);     // Catch: Throwable -> L66
        if (r166 != '\r') goto L136;
        if (r122.element == false) goto L134;
        r118.element = true;     // Catch: Throwable -> L66
    L141:
        boolean r167 = false;
    L145:
        if (r167 == true) goto L147;
    L134:
        r167 = true;
        r122.element = true;     // Catch: Throwable -> L66
        goto L145
    L136:
        if (r166 != '\n') goto L139;
        r118.element = true;     // Catch: Throwable -> L66
        r139.element = 1;     // Catch: Throwable -> L66
        goto L141
    L139:
        if (r122.element == false) goto L142;
        r118.element = true;     // Catch: Throwable -> L66
        goto L141
    L142:
        int r168 = r121.element;     // Catch: Throwable -> L66
        if (r168 == r115) goto L149;
        r121.element = r168 + 1;     // Catch: Throwable -> L66
        r113.append(r166);     // Catch: Throwable -> L66
        r167 = true;
        goto L145
    L149:
        throw new TooLongLineException("Too many characters in line: limit " + r115 + " exceeded");     // Catch: Throwable -> L66
    L150:
        r135 = false;
        r133.c(((r146 - r144) - r142.element) + 1);     // Catch: Throwable -> L66
        r117 = r217;
        r151 = -1;
        goto L158
    L117:
        r165 = true;
        r122.element = true;     // Catch: Throwable -> L66
        goto L128
    L119:
        if (r164 != '\n') goto L122;
        r118.element = true;     // Catch: Throwable -> L66
        r139.element = 1;     // Catch: Throwable -> L66
        goto L124
    L122:
        if (r122.element == false) goto L125;
        r118.element = true;     // Catch: Throwable -> L66
        goto L124
    L125:
        int r169 = r121.element;     // Catch: Throwable -> L66
        if (r169 == r115) goto L152;
        r121.element = r169 + 1;     // Catch: Throwable -> L66
        r113.append(r164);     // Catch: Throwable -> L66
        r165 = true;
        goto L128
    L152:
        throw new TooLongLineException("Too many characters in line: limit " + r115 + " exceeded");     // Catch: Throwable -> L66
    L153:
        c(r158);     // Catch: Throwable -> L66
        throw null;     // Catch: Throwable -> L66
    L110:
        r163 = false;
        goto L111
    L84:
        r159 = false;
        goto L85
    L157:
        r214 = r123;
        r135 = false;
        r133.c(r145 - r144);     // Catch: Throwable -> L66
        r117 = r117;
        r151 = 0;
    L167:
        th = move-exception;
        r214 = r123;
        throw th;     // Catch: Throwable -> L170
    L194:
        th = th;
        r127 = r123;
    L200:
        int r170 = r117.element;
        if (r170 > 1) goto L215;
        if (r122.element == false) goto L206;
        r118.element = true;
    L206:
        if (r121.element <= 0) goto L208;
    L211:
        boolean r171 = true;
    L213:
        return Boxing.boxBoolean(r171);
    L208:
        if (r118.element == true) goto L211;
        r171 = false;
        goto L213
    L215:
        throw new EOFException("Premature end of stream: expected " + r170 + " bytes to decode UTF-8 char");
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r102);
        Ref.IntRef r172 = new Ref.IntRef();
        Ref.IntRef r173 = new Ref.IntRef();
        r173.element = 1;
        r121 = r172;
        r117 = r173;
        r122 = new Ref.BooleanRef();
        r118 = new Ref.BooleanRef();
        r129 = r210;
        r116 = r311;
        r114 = r100;
        r119 = r103;
        r115 = r211;
        r120 = r310;
    L7:
        r100 = new UTF8Kt$decodeUTF8LineLoopSuspend$1(r312);
        goto L8
    }

    public static final int b(ByteBuffer r110, CharSequence r111, int r210, int r211, int r212, int r213) {
        Intrinsics.checkNotNullParameter(r110, "$this$encodeUTF8");
        Intrinsics.checkNotNullParameter(r111, "text");
        int r100 = Math.min(r211, r210 + 65535);
        int r101 = RangesKt.coerceAtMost(r213, 65535);
        int r102 = r210;
        int r103 = r212;
    L3:
        if (r103 >= r101) goto L122;
        if (r102 >= r100) goto L122;
        int r104 = r102 + 1;
        int r105 = r111.charAt(r102) & CharCompanionObject.MAX_VALUE;
        if ((65408 & r105) != 0) goto L9;
        r110.put(r103, (byte) r105);
        r102 = r104;
        r103 = r103 + 1;
        goto L3
    L9:
        int r106 = r104 - 1;
        int r107 = r101 - 3;
    L10:
        int r108 = r107 - r103;
        char r109 = CharCompanionObject.MIN_LOW_SURROGATE;
        boolean r112 = false;
        if (r108 <= 0) goto L48;
        if (r106 >= r100) goto L48;
        int r113 = r106 + 1;
        char r114 = r111.charAt(r106);
        boolean r115 = Character.isHighSurrogate(r114);
        int r116 = r114;
        if (r115 == false) goto L22;
        if (r113 != r100) goto L18;
    L21:
        r116 = 63;
        goto L22
    L18:
        if (Character.isLowSurrogate(r111.charAt(r113)) == false) goto L21;
        int r117 = ((r114 - 55232) << 10) | (r111.charAt(r113) - CharCompanionObject.MIN_LOW_SURROGATE);
        r113 = r113 + 1;
        r116 = r117;
    L22:
        if (r116 < 0) goto L25;
        if (r116 >= 128) goto L25;
        boolean r118 = true;
    L26:
        if (r118 == false) goto L28;
        r110.put(r103, (byte) r116);
        int r119 = 1;
    L45:
        r103 = r103 + r119;
        r106 = r113;
        goto L10
    L28:
        if (128 > r116) goto L31;
        if (r116 >= 2048) goto L31;
        boolean r120 = true;
    L32:
        if (r120 == false) goto L34;
        r110.put(r103, (byte) (((r116 >> 6) & 31) | 192));
        r110.put(r103 + 1, (byte) ((r116 & 63) | 128));
        r119 = 2;
        goto L45
    L34:
        if (2048 > r116) goto L37;
        if (r116 >= 65536) goto L37;
        boolean r121 = true;
    L38:
        if (r121 == false) goto L40;
        r110.put(r103, (byte) (((r116 >> 12) & 15) | 224));
        r110.put(r103 + 1, (byte) (((r116 >> 6) & 63) | 128));
        r110.put(r103 + 2, (byte) ((r116 & 63) | 128));
        r119 = 3;
        goto L45
    L40:
        if (65536 > r116) goto L43;
        if (r116 >= 1114112) goto L43;
        r112 = true;
    L43:
        if (r112 == false) goto L46;
        r110.put(r103, (byte) (((r116 >> 18) & 7) | 240));
        r110.put(r103 + 1, (byte) (((r116 >> 12) & 63) | 128));
        r110.put(r103 + 2, (byte) (((r116 >> 6) & 63) | 128));
        r110.put(r103 + 3, (byte) ((r116 & 63) | 128));
        r119 = 4;
        goto L45
    L46:
        c(r116);
        throw null;
    L37:
        r121 = false;
    L31:
        r120 = false;
    L25:
        r118 = false;
    L48:
        if (r103 != r107) goto L119;
    L49:
        int r122 = r101 - r103;
        if (r122 <= 0) goto L117;
        if (r106 >= r100) goto L117;
        int r123 = r106 + 1;
        char r124 = r111.charAt(r106);
        boolean r125 = Character.isHighSurrogate(r124);
        int r126 = r124;
        if (r125 == true) goto L56;
    L55:
        int r127 = 1;
        if (1 > r126) goto L65;
        if (r126 >= 128) goto L65;
        boolean r128 = true;
    L66:
        if (r128 == true) goto L86;
        if (128 > r126) goto L71;
        if (r126 >= 2048) goto L71;
        boolean r129 = true;
    L72:
        if (r129 == false) goto L74;
        r127 = 2;
        goto L86
    L74:
        if (2048 > r126) goto L77;
        if (r126 >= 65536) goto L77;
        boolean r130 = true;
    L78:
        if (r130 == false) goto L80;
        r127 = 3;
        goto L86
    L80:
        if (65536 > r126) goto L83;
        if (r126 >= 1114112) goto L83;
        boolean r131 = true;
    L84:
        if (r131 == false) goto L115;
        r127 = 4;
        goto L86
    L115:
        c(r126);
        throw null;
    L83:
        r131 = false;
    L77:
        r130 = false;
    L71:
        r129 = false;
    L86:
        if (r127 > r122) goto L87;
        if (r126 < 0) goto L91;
        if (r126 >= 128) goto L91;
        boolean r132 = true;
    L92:
        if (r132 == false) goto L94;
        r110.put(r103, (byte) r126);
        int r133 = 1;
    L112:
        r103 = r103 + r133;
        r106 = r123;
        r109 = CharCompanionObject.MIN_LOW_SURROGATE;
        goto L49
    L94:
        if (128 > r126) goto L97;
        if (r126 >= 2048) goto L97;
        boolean r134 = true;
    L98:
        if (r134 == false) goto L100;
        r110.put(r103, (byte) (((r126 >> 6) & 31) | 192));
        r110.put(r103 + 1, (byte) ((r126 & 63) | 128));
        r133 = 2;
        goto L112
    L100:
        if (2048 > r126) goto L103;
        if (r126 >= 65536) goto L103;
        boolean r135 = true;
    L104:
        if (r135 == false) goto L106;
        r110.put(r103, (byte) (((r126 >> 12) & 15) | 224));
        r110.put(r103 + 1, (byte) (((r126 >> 6) & 63) | 128));
        r110.put(r103 + 2, (byte) ((r126 & 63) | 128));
        r133 = 3;
        goto L112
    L106:
        if (65536 > r126) goto L109;
        if (r126 >= 1114112) goto L109;
        boolean r136 = true;
    L110:
        if (r136 == false) goto L113;
        r110.put(r103, (byte) (((r126 >> 18) & 7) | 240));
        r110.put(r103 + 1, (byte) (((r126 >> 12) & 63) | 128));
        r110.put(r103 + 2, (byte) (((r126 >> 6) & 63) | 128));
        r110.put(r103 + 3, (byte) ((r126 & 63) | 128));
        r133 = 4;
        goto L112
    L113:
        c(r126);
        throw null;
    L109:
        r136 = false;
    L103:
        r135 = false;
    L97:
        r134 = false;
    L91:
        r132 = false;
        goto L92
    L87:
        r106 = r123 - 1;
    L65:
        r128 = false;
        goto L66
    L56:
        if (r123 != r100) goto L58;
    L61:
        r126 = 63;
        goto L55
    L58:
        if (Character.isLowSurrogate(r111.charAt(r123)) == false) goto L61;
        int r137 = ((r124 - 55232) << 10) | (r111.charAt(r123) - r109);
        r123 = r123 + 1;
        r126 = r137;
    L117:
        short r138 = UShort.m9730constructorimpl((short) (r106 - r210));
        short r139 = UShort.m9730constructorimpl((short) (r103 - r212));
    L120:
        return ((r138 & 65535) << 16) | (r139 & 65535);
    L119:
        r138 = UShort.m9730constructorimpl((short) (r106 - r210));
        r139 = UShort.m9730constructorimpl((short) (r103 - r212));
    L122:
        return ((UShort.m9730constructorimpl((short) (r102 - r210)) & 65535) << 16) | (UShort.m9730constructorimpl((short) (r103 - r212)) & 65535);
    }
}
