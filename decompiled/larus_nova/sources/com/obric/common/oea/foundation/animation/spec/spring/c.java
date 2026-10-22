package com.obric.common.oea.foundation.animation.spec.spring;

import androidx.camera.video.AudioStats;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes33.dex */
public final class c {
    public static final a a(double r100) {
        if (r100 >= AudioStats.AUDIO_AMPLITUDE_NONE) goto L6;
        return new a(AudioStats.AUDIO_AMPLITUDE_NONE, Math.sqrt(Math.abs(r100)));
    L6:
        return new a(Math.sqrt(r100), AudioStats.AUDIO_AMPLITUDE_NONE);
    }

    public static final long b(float r310, float r311, float r312, float r410, float r411) {
        if (r311 != 0.0f) goto L6;
        return 9223372036854L;
    L6:
        double r100 = r310;
        double r101 = r311;
        double r102 = r312;
        double r103 = r410;
        double r104 = r411;
        double r110 = (r101 * 2.0d) * Math.sqrt(r100);
        double r111 = (r110 * r110) - (r100 * 4.0d);
        double r105 = -r110;
        a r106 = a(r111);
        r106.f396387a = (r106.f396387a + r105) * 0.5d;
        r106.f396388b *= 0.5d;
        a r112 = a(r111);
        double r113 = -1;
        double r114 = r112.f396387a * r113;
        double r107 = r112.f396388b * r113;
        r112.f396387a = (r114 + r105) * 0.5d;
        r112.f396388b = r107 * 0.5d;
        if (r103 == AudioStats.AUDIO_AMPLITUDE_NONE) goto L9;
    L11:
        int r108 = 0;
        double r115 = 0;
        if (r103 >= r115) goto L14;
        r102 = -r102;
    L14:
        double r109 = Math.abs(r103);
        double r116 = Double.MAX_VALUE;
        if (r101 <= 1.0d) goto L62;
        final double r117 = r106.f396387a;
        final double r118 = r112.f396387a;
        double r119 = r117 - r118;
        final double r120 = ((r117 * r109) - r102) / r119;
        final double r121 = r109 - r120;
        double r122 = r104;
        double r123 = Math.log(Math.abs(r122 / r121)) / r117;
        double r124 = Math.log(Math.abs(r122 / r120)) / r118;
        if (Double.isInfinite(r123) == false) goto L19;
    L21:
        boolean r125 = false;
    L23:
        if ((!r125) == false) goto L26;
    L36:
        double r126 = r121 * r117;
        double r313 = r124;
        final double r127 = Math.log(r126 / ((-r120) * r118)) / (r118 - r117);
        Function0<Double> r128 = new FloatSpringSpecKt$estimateOverDamped$1(r121, r117, r127, r120, r118);
        if (Double.isNaN(r127) == false) goto L39;
    L51:
        double r314 = r313;
    L52:
        r122 = -r122;
        double r129 = r314;
    L53:
        double r210 = r120 * r118;
        if (Math.abs((Math.exp(r117 * r129) * r126) + (Math.exp(r118 * r129) * r210)) < 1.0E-4d) goto L112;
        double r130 = 0.001d;
    L58:
        if (r116 <= r130) goto L112;
        if (r108 >= 100) goto L112;
        r108 = r108 + 1;
        double r131 = r117 * r129;
        double r211 = r118 * r129;
        double r132 = r129 - ((((Math.exp(r131) * r121) + (Math.exp(r211) * r120)) + r122) / ((Math.exp(r131) * r126) + (Math.exp(r211) * r210)));
        double r133 = Math.abs(r129 - r132);
        r130 = 0.001d;
        r129 = r132;
        r116 = r133;
    L112:
        return (long) (r129 * 1000.0d);
    L39:
        if (r127 <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L51;
        if (r127 > AudioStats.AUDIO_AMPLITUDE_NONE) goto L44;
    L50:
        r129 = Math.log((-((r120 * r118) * r118)) / (r126 * r117)) / r119;
        goto L53
    L44:
        if ((-r128.invoke2()) >= r122) goto L50;
        if (r120 <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L51;
        if (r121 >= AudioStats.AUDIO_AMPLITUDE_NONE) goto L51;
        r314 = AudioStats.AUDIO_AMPLITUDE_NONE;
        goto L52
    L26:
        if (Double.isInfinite(r124) == false) goto L28;
    L30:
        boolean r134 = false;
    L32:
        if ((!r134) == true) goto L35;
        r123 = Math.max(r123, r124);
    L35:
        r124 = r123;
        goto L36
    L28:
        if (Double.isNaN(r124) == true) goto L30;
        r134 = true;
        goto L32
    L19:
        if (Double.isNaN(r123) == true) goto L21;
        r125 = true;
        goto L23
    L62:
        double r135 = r104;
        if (r101 >= 1.0d) goto L65;
        double r136 = r106.f396387a;
        double r137 = (r102 - (r136 * r109)) / r106.f396388b;
        r129 = Math.log(r135 / Math.sqrt((r109 * r109) + (r137 * r137))) / r136;
        goto L112
    L65:
        double r138 = r106.f396387a;
        double r139 = r138 * r109;
        double r140 = r102 - r139;
        double r141 = Math.log(Math.abs(r135 / r109)) / r138;
        double r142 = Math.log(Math.abs(r135 / r140));
        double r212 = r142;
        int r143 = 0;
    L67:
        if (r143 > 5) goto L69;
        r212 = r142 - Math.log(Math.abs(r212 / r138));
        r143 = r143 + 1;
        goto L67
    L69:
        double r144 = r212 / r138;
        if (Double.isInfinite(r141) == false) goto L72;
    L74:
        boolean r145 = false;
    L76:
        if ((!r145) == false) goto L79;
        r141 = r144;
    L88:
        double r146 = (-(r139 + r140)) / (r138 * r140);
        double r147 = r138 * r146;
        double r213 = Math.exp(r147) * r109;
        double r214 = (r140 * r146) * Math.exp(r147);
        double r148 = r141;
        double r149 = r213 + r214;
        if (Double.isNaN(r146) == false) goto L91;
    L103:
        r135 = -r135;
        double r150 = r148;
    L104:
        double r151 = r150;
        int r152 = 0;
    L106:
        if (r116 <= 0.001d) goto L110;
        if (r152 >= 100) goto L110;
        r152 = r152 + 1;
        double r153 = r138 * r151;
        double r154 = r151 - (((((r140 * r151) + r109) * Math.exp(r153)) + r135) / ((((((double) 1) + r153) * r140) + r139) * Math.exp(r153)));
        r116 = Math.abs(r151 - r154);
        r151 = r154;
    L110:
        r129 = r151;
        goto L112
    L91:
        if (r146 <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L103;
        if (r146 > AudioStats.AUDIO_AMPLITUDE_NONE) goto L96;
    L102:
        r150 = (-(2.0d / r138)) - (r109 / r140);
        goto L104
    L96:
        if ((-r149) >= r135) goto L102;
        if (r140 >= r115) goto L103;
        if (r109 <= r115) goto L103;
        r148 = 0.0d;
        goto L103
    L79:
        if (Double.isInfinite(r144) == false) goto L81;
    L83:
        boolean r155 = false;
    L85:
        if ((!r155) == true) goto L88;
        r141 = Math.max(r141, r144);
        goto L88
    L81:
        if (Double.isNaN(r144) == true) goto L83;
        r155 = true;
        goto L85
    L72:
        if (Double.isNaN(r141) == true) goto L74;
        r145 = true;
        goto L76
    L9:
        if (r102 != AudioStats.AUDIO_AMPLITUDE_NONE) goto L11;
        return 0;
    }
}
