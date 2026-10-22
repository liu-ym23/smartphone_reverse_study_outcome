package com.bytedance.locallife.dito.core;

import androidx.camera.video.AudioStats;
import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import java.util.Map;
import java.util.Stack;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h0 f257929a = null;

    static {
        f257929a = new h0();
    }

    public h0() {
    }

    public static double a(String r110, Map r111) throws IllegalArgumentException, ArithmeticException {
        int r100 = r110.length();
        int r101 = 0;
    L4:
        if (r101 >= r100) goto L15;
        char r102 = r110.charAt(r101);
        if (Intrinsics.compare(r102, 48) >= 0) goto L8;
    L9:
        if (r102 != '.') goto L11;
    L10:
        boolean r103 = true;
    L12:
        if (r103 == false) goto L13;
        r101 = r101 + 1;
        goto L4
    L13:
        boolean r104 = false;
    L16:
        if (r104 == true) goto L18;
        Stack r105 = new Stack();
        String r106 = "";
        int r107 = 0;
        char r112 = '+';
        boolean r113 = false;
    L21:
        if (r107 >= r110.length()) goto L93;
        char r114 = r110.charAt(r107);
        if (r114 == ' ') goto L24;
        if (Character.isDigit(r114) == true) goto L78;
        if (r114 == '.') goto L78;
        if (Character.isLetter(r114) == false) goto L50;
        StringBuilder r108 = new StringBuilder();
        r108.append(r114);
    L32:
        r107 = r107 + 1;
        if (r107 >= r110.length()) goto L37;
        if (Character.isLetterOrDigit(r110.charAt(r107)) == false) goto L37;
        r108.append(r110.charAt(r107));
    L37:
        Double r115 = (Double) r111.get(r108.toString());
        if (r115 == null) goto L48;
        double r116 = r115.doubleValue();
        if (r106.length() <= 0) goto L42;
        boolean r109 = true;
    L43:
        if (r109 == false) goto L45;
        String r117 = String.valueOf(CastDoubleProtector.parseDouble(r106) * r116);
    L46:
        r107 = r107 - 1;
    L90:
        r106 = r117;
    L91:
        r107 = r107 + 1;
        goto L21
    L45:
        r117 = String.valueOf(r116);
        goto L46
    L42:
        r109 = false;
        goto L43
    L48:
        throw new IllegalArgumentException("未定义的变量：" + r108 + ",dataContext:" + r111);
    L50:
        if (r114 != '(') goto L64;
        int r118 = r107;
        int r119 = 0;
    L53:
        if (r118 >= r110.length()) goto L62;
        if (r110.charAt(r118) != '(') goto L58;
        r119 = r119 + 1;
    L58:
        if (r110.charAt(r118) != ')') goto L60;
        r119 = r119 - 1;
    L60:
        if (r119 == 0) goto L62;
        r118 = r118 + 1;
    L62:
        r117 = String.valueOf(a(r110.substring(r107 + 1, r118), r111));
        r107 = r118;
        goto L90
    L64:
        if (r106.length() <= 0) goto L66;
        boolean r120 = true;
    L67:
        if (r120 == false) goto L77;
        if (r112 == '*') goto L76;
        if (r112 == '+') goto L75;
        if (r112 == '-') goto L74;
        if (r112 != '/') goto L77;
        r105.push(Double.valueOf(((Number) r105.pop()).doubleValue() / CastDoubleProtector.parseDouble(r106)));
        goto L77
    L74:
        r105.push(Double.valueOf(-CastDoubleProtector.parseDouble(r106)));
        goto L77
    L75:
        r105.push(Double.valueOf(CastDoubleProtector.parseDouble(r106)));
        goto L77
    L76:
        r105.push(Double.valueOf(((Number) r105.pop()).doubleValue() * CastDoubleProtector.parseDouble(r106)));
    L77:
        r106 = "";
        r112 = r114;
        r113 = false;
        goto L91
    L66:
        r120 = false;
    L78:
        if (r114 != '.') goto L89;
        if (r113 == true) goto L88;
        if (r106.length() != 0) goto L83;
        boolean r121 = true;
    L84:
        if (r121 == false) goto L86;
        r106 = "0";
    L86:
        r113 = true;
        goto L89
    L83:
        r121 = false;
        goto L84
    L88:
        throw new IllegalArgumentException("非法的小数点位置：".concat(r110));
    L89:
        r117 = r106 + r114;
        goto L90
    L24:
        r107 = r107 + 1;
        goto L21
    L93:
        if (r106.length() <= 0) goto L95;
        boolean r122 = true;
    L97:
        if (r122 == false) goto L109;
        if (r112 == '*') goto L107;
        if (r112 == '+') goto L106;
        if (r112 == '-') goto L105;
        if (r112 != '/') goto L104;
        double r123 = ((Number) r105.pop()).doubleValue() / CastDoubleProtector.parseDouble(r106);
    L108:
        r105.push(Double.valueOf(r123));
        goto L109
    L104:
        throw new IllegalArgumentException("非法的表达式结尾 sign:" + r112 + ",expression:" + r110 + ",variables:" + r111);
    L105:
        r123 = -CastDoubleProtector.parseDouble(r106);
        goto L108
    L106:
        r123 = CastDoubleProtector.parseDouble(r106);
        goto L108
    L107:
        r123 = ((Number) r105.pop()).doubleValue() * CastDoubleProtector.parseDouble(r106);
    L109:
        double r124 = AudioStats.AUDIO_AMPLITUDE_NONE;
    L111:
        if (r105.isEmpty() == true) goto L114;
        r124 = r124 + ((Number) r105.pop()).doubleValue();
        goto L111
    L114:
        if (Double.isInfinite(r124) == true) goto L119;
        if (Double.isNaN(r124) == true) goto L119;
        return r124;
    L119:
        throw new ArithmeticException("表达计算结果为非数或无穷大 " + r124 + " ,expression:" + r110 + ",variables:" + r111);
    L95:
        r122 = false;
        goto L97
    L18:
        return CastDoubleProtector.parseDouble(r110);
    L11:
        r103 = false;
        goto L12
    L8:
        if (Intrinsics.compare(r102, 57) <= 0) goto L10;
    L15:
        r104 = true;
        goto L16
    }

    public final double call(Object r100, Map<String, Double> r101) throws IllegalArgumentException, ArithmeticException {
        Intrinsics.checkNotNullParameter(r100, "size");
        Intrinsics.checkNotNullParameter(r101, "dataContext");
        if ((r100 instanceof Number) == false) goto L7;
        return ((Number) r100).doubleValue();
    L7:
        if ((r100 instanceof String) == false) goto L11;
        long r102 = System.nanoTime();
        double r103 = a((String) r100, r101);
        long r104 = System.nanoTime() - r102;
        rq6.a.f538927a.a("SimpleSizeConfigCalculator", "expression:" + r100 + ",result:" + r103 + " calculator nano cost :" + r104);
        return r103;
    L11:
        throw new IllegalArgumentException("not support this size " + r100.getClass().getSimpleName() + " type yet");
    }
}
