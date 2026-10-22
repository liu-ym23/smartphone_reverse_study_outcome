package com.bytedance.android.shopping.deepfeed.slice.view.customview;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Paint;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.bytedance.android.ec.core.utils.s;
import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.bytedance.android.ecom.arch.slice.render.util.SlcDimensExtensionsKt;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import java.math.BigDecimal;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class h extends com.bytedance.android.ecom.arch.slice.render.elements.b<c> {
    public final SlcTemplateContext H3;

    public h(SlcTemplateContext r2) {
        Intrinsics.checkNotNullParameter(r2, "slcTemplateContext");
        super(r2);
        this.H3 = r2;
    }

    public final void H0(Map<String, ? extends Object> r18) {
        Intrinsics.checkNotNullParameter(r18, "props");
        c r1 = (c) l1();
        String r2 = i.a(r18, new String[]{"integer_text"});
        String r11 = "";
        if (r2 != null) goto L5;
        r2 = "";
    L5:
        String r4 = i.a(r18, new String[]{"last_integer_text"});
        Object r5 = r18.get("integer_font_size");
        if ((r5 instanceof Number) == false) goto L9;
        Float r6 = Float.valueOf(((Number) r5).floatValue());
    L12:
        Object r7 = r18.get("integer_font_weight");
        if ((r7 instanceof Number) == false) goto L16;
        Integer r8 = Integer.valueOf(((Number) r7).intValue());
    L19:
        j r3 = new j(r2, r4, r6, r8);
        String r9 = i.a(r18, new String[]{"decimal_text"});
        if (r9 != null) goto L22;
        r9 = "";
    L22:
        String r10 = i.a(r18, new String[]{"last_decimal_text"});
        Object r12 = r18.get("decimal_font_size");
        if ((r12 instanceof Number) == false) goto L26;
        Float r13 = Float.valueOf(((Number) r12).floatValue());
    L29:
        Object r14 = r18.get("decimal_font_weight");
        if ((r14 instanceof Number) == false) goto L33;
        Integer r15 = Integer.valueOf(((Number) r14).intValue());
    L36:
        j r16 = new j(r9, r10, r13, r15);
        Object r17 = r18.get("animate");
        if ((r17 instanceof Boolean) == false) goto L40;
        boolean r19 = ((Boolean) r17).booleanValue();
    L55:
        String r20 = i.a(r18, new String[]{"text_color", "color"});
        String r21 = i.a(r18, new String[]{"text_align", "align"});
        Object r0 = r18.get("delay");
        if ((r0 instanceof Number) == false) goto L59;
        Double r22 = Double.valueOf(((Number) r0).doubleValue());
    L63:
        if (r22 == null) goto L65;
        long r110 = RangesKt.coerceAtLeast((long) (1000 * r22.doubleValue()), 0);
    L66:
        g r111 = new g(r3, r16, r19, r20, r21, r110);
        Intrinsics.checkNotNullParameter(r111, "config");
        if (Intrinsics.areEqual(r111, r1.y) == true) goto L263;
        r1.y = r111;
        if (r111.a.b == null) goto L72;
    L82:
        boolean r23 = true;
    L83:
        String r24 = c.m(r111.a.a);
        String r25 = r111.b.a;
        if (r25 == null) goto L86;
        String r26 = StringsKt.trim(r25).toString();
    L87:
        if (r26 != null) goto L89;
        r26 = "";
    L89:
        String r27 = StringsKt.take(StringsKt.removePrefix(r26, "."), 2);
        String r28 = r111.a.b;
        if (r28 == null) goto L92;
        String r29 = c.m(r28);
    L93:
        String r30 = r111.b.b;
        if (r30 == null) goto L100;
        String r31 = StringsKt.trim(r30).toString();
        if (r31 != null) goto L98;
        r31 = "";
    L98:
        String r32 = StringsKt.take(StringsKt.removePrefix(r31, "."), 2);
        if (r32 == null) goto L100;
    L101:
        BigDecimal r33 = c.b(r29, r32);
        if (r33 != null) goto L104;
        r33 = BigDecimal.ZERO;
    L104:
        BigDecimal r34 = c.b(r24, r27);
        if (r34 != null) goto L108;
        r34 = BigDecimal.ZERO;
    L108:
        if (r34.compareTo(r33) < 0) goto L110;
        boolean r35 = true;
    L111:
        r1.u = r35;
        int r36 = s.a;
        Integer r37 = s.b(r111.d);
        if (r37 == null) goto L114;
        int r38 = r37.intValue();
    L115:
        r1.a.setColor(r38);
        r1.b.setColor(r38);
        Paint r39 = r1.a;
        Float r40 = r111.a.c;
        float r41 = 14.0f;
        if (r40 == null) goto L118;
        float r42 = r40.floatValue();
    L119:
        r39.setTextSize(SlcDimensExtensionsKt.a(Double.valueOf(r42), r1.z.m()));
        Paint r43 = r1.b;
        Float r44 = r111.b.c;
        if (r44 != null) goto L122;
        r44 = r111.a.c;
    L122:
        if (r44 == null) goto L124;
        r41 = r44.floatValue();
    L124:
        r43.setTextSize(SlcDimensExtensionsKt.a(Double.valueOf(r41), r1.z.m()));
        c.p(r1.a, r111.a.d);
        c.p(r1.b, r111.b.d);
        String r45 = r111.e;
        if (r45 != null) goto L128;
    L142:
        Paint.Align r46 = Paint.Align.CENTER;
    L143:
        r1.v = r46;
        r1.o();
        int r47 = Math.max(r29.length(), r24.length());
        int r48 = RangesKt.coerceAtMost(Math.max(r32.length(), r27.length()), 2);
        if (r27.length() != 0) goto L146;
        boolean r49 = true;
    L147:
        if (r49 == true) goto L149;
    L154:
        ValueAnimator r50 = r1.w;
        if (r50 == null) goto L157;
        r50.cancel();
    L157:
        r1.c = r24;
        r1.d = r27;
        r1.e = r29;
        r1.f = r32;
        if (r32.length() <= 0) goto L160;
        boolean r51 = true;
    L161:
        r1.k = r51;
        if (r27.length() <= 0) goto L164;
        boolean r52 = true;
    L165:
        r1.l = r52;
        if (r47 > 0) goto L168;
        String r53 = "";
    L169:
        r1.g = r53;
        if (r47 > 0) goto L172;
        String r54 = "";
    L173:
        r1.h = r54;
        boolean r55 = r1.k;
        if (r48 > 0) goto L176;
        String r56 = "";
    L180:
        r1.i = r56;
        boolean r57 = r1.l;
        if (r48 <= 0) goto L188;
        String r58 = StringsKt.take(r27, r48);
        if (r57 == false) goto L186;
        String r59 = StringsKt.padEnd(r58, r48, '0');
    L187:
        r11 = r59;
        goto L188
    L186:
        r59 = StringsKt.repeat(String.valueOf(0), r48);
    L188:
        r1.j = r11;
        if ((!Intrinsics.areEqual(r1.g, r1.h)) == false) goto L191;
    L196:
        boolean r60 = true;
    L197:
        String r61 = r1.g + r1.i;
        String r62 = r1.h + r1.j;
        if (r111.c == false) goto L253;
        if (r23 == false) goto L253;
        if (r60 == false) goto L253;
        int r63 = 0;
    L203:
        if (r63 >= r61.length()) goto L208;
        if (Character.isDigit(r61.charAt(r63)) == true) goto L206;
        r63 = r63 + 1;
        goto L203
    L206:
        boolean r64 = true;
    L209:
        if (r64 == false) goto L220;
        int r65 = 0;
    L212:
        if (r65 >= r62.length()) goto L217;
        if (Character.isDigit(r62.charAt(r65)) == true) goto L215;
        r65 = r65 + 1;
        goto L212
    L215:
        boolean r66 = true;
    L218:
        if (r66 == false) goto L220;
        boolean r67 = true;
    L221:
        if (r67 == false) goto L253;
        r1.s = 0.0f;
        r1.t = 0;
        if (r111.f > 0) goto L225;
        boolean r112 = true;
    L226:
        r1.x = r112;
        r1.invalidate();
        int r68 = Math.max(r61.length(), r62.length());
        String r69 = StringsKt.padStart(r61, r68, 0);
        String r70 = StringsKt.padStart(r62, r68, 0);
        IntIterator r71 = RangesKt.until(0, r68).iterator();
        long r72 = 1;
        if (r71.hasNext() == true) goto L229;
        Long r113 = null;
    L250:
        if (r113 == null) goto L252;
        r72 = r113.longValue();
    L252:
        long r73 = Math.max(r72 * 100, 270);
        ValueAnimator r74 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r74.setDuration(r73);
        r74.setStartDelay(r111.f);
        r74.setInterpolator(new LinearInterpolator());
        r74.addUpdateListener(new e(r1));
        r74.addListener(new f(r1));
        r74.start();
        Unit r75 = Unit.INSTANCE;
        r1.w = r74;
    L254:
        r1.requestLayout();
        return;
    L229:
        IntIterator r76 = r71;
        int r77 = r76.nextInt();
        char r78 = r69.charAt(r77);
        char r79 = r70.charAt(r77);
        if (Character.isDigit(r78) == true) goto L232;
    L235:
        long r80 = 1;
    L236:
        Long r81 = Long.valueOf(r80);
    L237:
        r113 = r81;
    L239:
        if (r71.hasNext() == false) goto L250;
        int r82 = r76.nextInt();
        char r84 = r69.charAt(r82);
        char r85 = r70.charAt(r82);
        if (Character.isDigit(r84) == true) goto L243;
    L246:
        long r86 = 1;
    L247:
        r81 = Long.valueOf(r86);
        if (r113.compareTo(r81) >= 0) goto L239;
    L243:
        if (Character.isDigit(r85) == false) goto L246;
        if (r84 == r85) goto L246;
        r86 = r1.h(r84, r85).size();
        goto L247
    L232:
        if (Character.isDigit(r79) == false) goto L235;
        if (r78 == r79) goto L235;
        r80 = r1.h(r78, r79).size();
        goto L236
    L225:
        r112 = false;
        goto L226
    L217:
        r66 = false;
    L220:
        r67 = false;
        goto L221
    L208:
        r64 = false;
    L253:
        r1.x = true;
        r1.s = 1.0f;
        r1.t = Long.MAX_VALUE;
        r1.invalidate();
        goto L254
    L191:
        if ((!Intrinsics.areEqual(r1.i, r1.j)) == true) goto L196;
        if (r1.k != r1.l) goto L196;
        r60 = false;
        goto L197
    L176:
        String r87 = StringsKt.take(r32, r48);
        if (r55 == false) goto L179;
        r56 = StringsKt.padEnd(r87, r48, '0');
        goto L180
    L179:
        r56 = StringsKt.repeat(String.valueOf(0), r48);
        goto L180
    L172:
        r54 = StringsKt.padStart(StringsKt.takeLast(r24, r47), r47, 0);
        goto L173
    L168:
        r53 = StringsKt.padStart(StringsKt.takeLast(r29, r47), r47, 0);
        goto L169
    L164:
        r52 = false;
        goto L165
    L160:
        r51 = false;
        goto L161
    L149:
        if (r32.length() <= 0) goto L151;
        boolean r88 = true;
    L152:
        if (r88 == false) goto L154;
        r27 = StringsKt.repeat("0", r48);
        goto L154
    L151:
        r88 = false;
        goto L152
    L146:
        r49 = false;
        goto L147
    L128:
        switch(r45.hashCode()) {
            case 100571: goto L140;
            case 3317767: goto L137;
            case 108511772: goto L134;
            case 109757538: goto L131;
            default: goto L142;
        };
    L131:
        if (r45.equals("start") == false) goto L142;
    L138:
        r46 = Paint.Align.LEFT;
        goto L143
    L134:
        if (r45.equals("right") == false) goto L142;
    L141:
        r46 = Paint.Align.RIGHT;
        goto L143
    L137:
        if (r45.equals("left") == false) goto L142;
    L140:
        if (r45.equals("end") == false) goto L142;
    L118:
        r42 = 14.0f;
        goto L119
    L114:
        r38 = ColorProtector.parseColor("#FF161823");
        goto L115
    L110:
        r35 = false;
    L100:
        r32 = r1.d;
        goto L101
    L92:
        r29 = r1.c;
        goto L93
    L86:
        r26 = null;
        goto L87
    L72:
        if (r111.b.b != null) goto L82;
        if (r1.c.length() <= 0) goto L76;
        boolean r89 = true;
    L77:
        if (r89 == true) goto L82;
        if (r1.l == true) goto L82;
        r23 = false;
        goto L83
    L76:
        r89 = false;
        goto L77
    L263:
        return;
    L65:
        r110 = 0;
        goto L66
    L59:
        if ((r0 instanceof String) == false) goto L61;
        r22 = StringsKt.toDoubleOrNull((String) r0);
        goto L63
    L61:
        r22 = null;
        goto L63
    L40:
        if ((r17 instanceof String) == false) goto L54;
        String r90 = (String) r17;
        if (r90 == null) goto L53;
        String r91 = StringsKt.trim(r90).toString();
        int r92 = r91.hashCode();
        if (r92 != 3569038) goto L46;
        r91.equals("true");
        goto L54
    L46:
        if (r92 != 97196323) goto L54;
        if (r91.equals("false") == false) goto L54;
        r19 = false;
        goto L55
    L53:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
    L54:
        r19 = true;
        goto L55
    L33:
        if ((r14 instanceof String) == false) goto L35;
        r15 = StringsKt.toIntOrNull((String) r14);
        goto L36
    L35:
        r15 = null;
        goto L36
    L26:
        if ((r12 instanceof String) == false) goto L28;
        r13 = StringsKt.toFloatOrNull((String) r12);
        goto L29
    L28:
        r13 = null;
        goto L29
    L16:
        if ((r7 instanceof String) == false) goto L18;
        r8 = StringsKt.toIntOrNull((String) r7);
        goto L19
    L18:
        r8 = null;
        goto L19
    L9:
        if ((r5 instanceof String) == false) goto L11;
        r6 = StringsKt.toFloatOrNull((String) r5);
        goto L12
    L11:
        r6 = null;
        goto L12
    }

    public final View n1(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        return new c(r3, this.H3);
    }
}
