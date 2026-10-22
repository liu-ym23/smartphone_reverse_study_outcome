package com.lynx.tasm.utils;

import androidx.camera.video.AudioStats;
import com.lynx.tasm.base.LLog;
import java.lang.reflect.Array;

/* JADX INFO: loaded from: classes32.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final double[][] f384087a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final double[] f384088b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final double[][] f384089c = null;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final double[] f384090a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final double[] f384091b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final double[] f384092c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final double[] f384093d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final double[] f384094e;

        public final void a() {
            b(this.f384090a);
            b(this.f384091b);
            b(this.f384092c);
            b(this.f384093d);
            b(this.f384094e);
        }

        public a() {
            this.f384090a = new double[4];
            this.f384091b = new double[3];
            this.f384092c = new double[3];
            this.f384093d = new double[3];
            this.f384094e = new double[3];
        }

        public static void b(double[] r100) {
            int r101 = 0;
        L4:
            if (r101 >= r100.length) goto L6;
            r100[r101] = 0.0d;
            r101 = r101 + 1;
            goto L4
        }
    }

    static {
        Class r100 = Double.TYPE;
        f384087a = (double[][]) Array.newInstance(r100, new int[]{4, 4});
        f384088b = new double[16];
        Class r101 = Double.TYPE;
        f384089c = (double[][]) Array.newInstance(r101, new int[]{3, 3});
    }

    public h() {
    }

    public static double b(double r100) {
        return (r100 * 3.141592653589793d) / 180.0d;
    }

    public static double c(double[] r410) {
        double r100 = r410[0];
        double r101 = r410[1];
        double r102 = r410[2];
        double r103 = r410[3];
        double r104 = r410[4];
        double r110 = r410[5];
        double r111 = r410[6];
        double r112 = r410[7];
        double r113 = r410[8];
        double r114 = r410[9];
        double r210 = r410[10];
        double r211 = r410[11];
        double r212 = r410[12];
        double r213 = r410[13];
        double r214 = r410[14];
        double r310 = r410[15];
        double r311 = r103 * r111;
        double r312 = r102 * r112;
        double r313 = ((r311 * r114) * r212) - ((r312 * r114) * r212);
        double r314 = r103 * r110;
        double r315 = r313 - ((r314 * r210) * r212);
        double r411 = r101 * r112;
        double r316 = r315 + ((r411 * r210) * r212);
        double r412 = r102 * r110;
        double r317 = r316 + ((r412 * r211) * r212);
        double r413 = r101 * r111;
        double r105 = r103 * r104;
        double r115 = r112 * r100;
        double r106 = r102 * r104;
        double r116 = r111 * r100;
        double r107 = r101 * r104;
        double r108 = r100 * r110;
        return ((((((((((((((((((r317 - ((r413 * r211) * r212)) - ((r311 * r113) * r213)) + ((r312 * r113) * r213)) + ((r105 * r210) * r213)) - ((r115 * r210) * r213)) - ((r106 * r211) * r213)) + ((r116 * r211) * r213)) + ((r314 * r113) * r214)) - ((r411 * r113) * r214)) - ((r105 * r114) * r214)) + ((r115 * r114) * r214)) + ((r107 * r211) * r214)) - ((r211 * r108) * r214)) - ((r412 * r113) * r310)) + ((r413 * r113) * r310)) + ((r106 * r114) * r310)) - ((r116 * r114) * r310)) - ((r107 * r210) * r310)) + ((r108 * r210) * r310);
    }

    public static boolean d(double r100) {
        if (Double.isNaN(r100) == false) goto L6;
        return false;
    L6:
        if (Math.abs(r100) >= 1.0E-5d) goto L9;
        return true;
    L9:
        return false;
    }

    public static double e(double r100) {
        return Math.round(r100 * 1000.0d) * 0.001d;
    }

    public static double h(double[] r100) {
        double r101 = r100[0];
        double r102 = r100[1];
        double r103 = (r101 * r101) + (r102 * r102);
        double r104 = r100[2];
        return Math.sqrt(r103 + (r104 * r104));
    }

    public static void a(double[] r110, a r111) {
        if (r110.length >= 16) goto L5;
        boolean r100 = false;
    L6:
        if (r100 == true) goto L9;
        LLog.e("lynx", "Decompose transform matrix error! transformMatrix's length less than 16!");
        return;
    L9:
        double[] r101 = r111.f384090a;
        double[] r102 = r111.f384091b;
        double[] r103 = r111.f384092c;
        double[] r104 = r111.f384093d;
        double[] r105 = r111.f384094e;
        if (d(r110[15]) == false) goto L12;
        return;
    L12:
        double[][] r112 = f384087a;
        double[] r113 = f384088b;
        int r114 = 0;
    L14:
        if (r114 >= 4) goto L22;
        int r115 = 0;
    L16:
        if (r115 >= 4) goto L21;
        int r116 = (r114 * 4) + r115;
        double r117 = r110[r116] / r110[15];
        r112[r114][r115] = r117;
        if (r115 != 3) goto L20;
        r117 = AudioStats.AUDIO_AMPLITUDE_NONE;
    L20:
        r113[r116] = r117;
        r115 = r115 + 1;
        goto L16
    L21:
        r114 = r114 + 1;
        goto L14
    L22:
        r113[15] = 1.0d;
        if (d(c(r113)) == false) goto L26;
        return;
    L26:
        if (d(r112[0][3]) == true) goto L28;
    L33:
        double[] r106 = {r112[0][3], r112[1][3], r112[2][3], r112[3][3]};
        double r118 = c(r113);
        if (d(r118) == true) goto L37;
        double r310 = r113[0];
        double r311 = r113[1];
        double r312 = r113[2];
        double r313 = r113[3];
        double r314 = r113[4];
        double r410 = r113[5];
        double r411 = r113[6];
        double r412 = r113[7];
        double r413 = r113[8];
        double r414 = r113[9];
        double r510 = r113[10];
        double r511 = r113[11];
        double r512 = r113[12];
        double r513 = r113[13];
        double r514 = r113[14];
        double r610 = r113[15];
        double r611 = r411 * r511;
        double r612 = r412 * r510;
        double r613 = r412 * r414;
        double r710 = r410 * r511;
        double r711 = r411 * r414;
        double r614 = ((((r611 * r513) - (r612 * r513)) + (r613 * r514)) - (r710 * r514)) - (r711 * r610);
        double r712 = r410 * r510;
        double r615 = r313 * r510;
        double r713 = r312 * r511;
        double r810 = r313 * r414;
        double r811 = r311 * r511;
        double r812 = r312 * r414;
        double r714 = ((((r615 * r513) - (r713 * r513)) - (r810 * r514)) + (r811 * r514)) + (r812 * r610);
        double r813 = r311 * r510;
        double r715 = r312 * r412;
        double r910 = r313 * r411;
        double r911 = r313 * r410;
        double r912 = r311 * r412;
        double r913 = r312 * r410;
        double r814 = ((((r715 * r513) - (r910 * r513)) + (r911 * r514)) - (r912 * r514)) - (r913 * r610);
        double r914 = r311 * r411;
        double r616 = (r612 * r512) - (r611 * r512);
        double r617 = r412 * r413;
        double r815 = r314 * r511;
        double r107 = r411 * r413;
        double r618 = ((r616 - (r617 * r514)) + (r815 * r514)) + (r107 * r610);
        double r108 = r314 * r510;
        double r716 = (r713 * r512) - (r615 * r512);
        double r619 = r313 * r413;
        double r620 = r310 * r511;
        double r109 = r312 * r413;
        double r1010 = r310 * r510;
        double r315 = r313 * r314;
        double r415 = r412 * r310;
        double r316 = r312 * r314;
        double r416 = r411 * r310;
        double r717 = (((r710 * r512) - (r613 * r512)) + (r617 * r513)) - (r815 * r513);
        double r621 = r410 * r413;
        double r622 = r314 * r414;
        double r816 = (((r810 * r512) - (r811 * r512)) - (r619 * r513)) + (r620 * r513);
        double r623 = r311 * r413;
        double r624 = r310 * r414;
        double r317 = r311 * r314;
        double r318 = r310 * r410;
        r113 = new double[]{(r614 + (r712 * r610)) / r118, (r714 - (r813 * r610)) / r118, (r814 + (r914 * r610)) / r118, ((((((r910 * r414) - (r715 * r414)) - (r911 * r510)) + (r912 * r510)) + (r913 * r511)) - (r914 * r511)) / r118, (r618 - (r108 * r610)) / r118, ((((r716 + (r619 * r514)) - (r620 * r514)) - (r109 * r610)) + (r1010 * r610)) / r118, ((((((r910 * r512) - (r715 * r512)) - (r315 * r514)) + (r415 * r514)) + (r316 * r610)) - (r416 * r610)) / r118, ((((((r715 * r413) - (r910 * r413)) + (r315 * r510)) - (r415 * r510)) - (r316 * r511)) + (r416 * r511)) / r118, ((r717 - (r621 * r610)) + (r622 * r610)) / r118, ((r816 + (r623 * r610)) - (r624 * r610)) / r118, ((((((r912 * r512) - (r911 * r512)) + (r315 * r513)) - (r415 * r513)) - (r317 * r610)) + (r610 * r318)) / r118, ((((((r911 * r413) - (r912 * r413)) - (r315 * r414)) + (r415 * r414)) + (r317 * r511)) - (r511 * r318)) / r118, ((((((r711 * r512) - (r712 * r512)) - (r107 * r513)) + (r108 * r513)) + (r621 * r514)) - (r622 * r514)) / r118, ((((((r813 * r512) - (r812 * r512)) + (r109 * r513)) - (r1010 * r513)) - (r623 * r514)) + (r624 * r514)) / r118, ((((((r913 * r512) - (r512 * r914)) - (r316 * r513)) + (r513 * r416)) + (r317 * r514)) - (r514 * r318)) / r118, ((((((r914 * r413) - (r913 * r413)) + (r316 * r414)) - (r416 * r414)) - (r317 * r510)) + (r318 * r510)) / r118};
    L37:
        double r119 = r113[0];
        double r319 = r113[4];
        double r320 = r113[8];
        double r321 = r113[12];
        double r322 = r113[1];
        double r323 = r113[5];
        double r210 = r113[9];
        double r211 = r113[13];
        double r417 = r113[2];
        double r212 = r113[6];
        double r418 = r113[10];
        double r120 = r113[14];
        double r419 = r113[3];
        double r420 = r113[7];
        double r213 = r113[11];
        double r421 = r113[15];
        double r515 = r106[0];
        double r516 = r106[1];
        double r517 = r106[2];
        double r518 = r106[3];
        r101[0] = (((r119 * r515) + (r322 * r516)) + (r417 * r517)) + (r419 * r518);
        r101[1] = (((r319 * r515) + (r323 * r516)) + (r212 * r517)) + (r420 * r518);
        r101[2] = (((r320 * r515) + (r210 * r516)) + (r418 * r517)) + (r213 * r518);
        r101[3] = (((r515 * r321) + (r516 * r211)) + (r517 * r120)) + (r518 * r421);
    L38:
        int r121 = 0;
    L39:
        if (r121 >= 3) goto L41;
        r104[r121] = r112[3][r121];
        r121 = r121 + 1;
        goto L39
    L41:
        double[][] r122 = f384089c;
        int r123 = 0;
    L42:
        if (r123 >= 3) goto L44;
        double[] r124 = r122[r123];
        double[] r125 = r112[r123];
        r124[0] = r125[0];
        r124[1] = r125[1];
        r124[2] = r125[2];
        r123 = r123 + 1;
        goto L42
    L44:
        double r126 = h(r122[0]);
        r102[0] = r126;
        double[] r127 = i(r122[0], r126);
        r122[0] = r127;
        double r128 = g(r127, r122[1]);
        r103[0] = r128;
        double[] r129 = f(r122[1], r122[0], -r128);
        r122[1] = r129;
        double r130 = h(r129);
        r102[1] = r130;
        r122[1] = i(r122[1], r130);
        r103[0] = r103[0] / r102[1];
        double r131 = g(r122[0], r122[2]);
        r103[1] = r131;
        double[] r132 = f(r122[2], r122[0], -r131);
        r122[2] = r132;
        double r133 = g(r122[1], r132);
        r103[2] = r133;
        double[] r134 = f(r122[2], r122[1], -r133);
        r122[2] = r134;
        double r135 = h(r134);
        r102[2] = r135;
        double[] r136 = i(r122[2], r135);
        r122[2] = r136;
        double r137 = r103[1];
        double r138 = r102[2];
        r103[1] = r137 / r138;
        r103[2] = r103[2] / r138;
        double[] r139 = r122[1];
        double r140 = r139[1];
        double r141 = r136[2];
        double r142 = r139[2];
        double r143 = r136[0];
        double r144 = r139[0];
        if (g(r122[0], new double[]{(r140 * r141) - (r136[1] * r142), (r142 * r143) - (r141 * r144), (r144 * r136[1]) - (r139[1] * r143)}) >= AudioStats.AUDIO_AMPLITUDE_NONE) goto L49;
        int r145 = 0;
    L47:
        if (r145 >= 3) goto L49;
        r102[r145] = r102[r145] * (-1.0d);
        double[] r146 = r122[r145];
        r146[0] = r146[0] * (-1.0d);
        r146[1] = r146[1] * (-1.0d);
        r146[2] = r146[2] * (-1.0d);
        r145 = r145 + 1;
    L49:
        double[] r147 = r122[2];
        r105[0] = e((-Math.atan2(r147[1], r147[2])) * 57.29577951308232d);
        double[] r148 = r122[2];
        double r149 = -r148[0];
        double r150 = r148[1];
        double r151 = r148[2];
        r105[1] = e((-Math.atan2(r149, Math.sqrt((r150 * r150) + (r151 * r151)))) * 57.29577951308232d);
        r105[2] = e((-Math.atan2(r122[1][0], r122[0][0])) * 57.29577951308232d);
        return;
    L28:
        if (d(r112[1][3]) == false) goto L33;
        if (d(r112[2][3]) == false) goto L33;
        r101[2] = 0.0d;
        r101[1] = 0.0d;
        r101[0] = 0.0d;
        r101[3] = 1.0d;
        goto L38
    L5:
        r100 = true;
        goto L6
    }

    public static double g(double[] r100, double[] r101) {
        return ((r100[0] * r101[0]) + (r100[1] * r101[1])) + (r100[2] * r101[2]);
    }

    public static double[] i(double[] r100, double r101) {
        if (d(r101) == false) goto L5;
        r101 = h(r100);
    L5:
        double r102 = 1.0d / r101;
        return new double[]{r100[0] * r102, r100[1] * r102, r100[2] * r102};
    }

    public static double[] f(double[] r100, double[] r101, double r110) {
        return new double[]{(r100[0] * 1.0d) + (r101[0] * r110), (r100[1] * 1.0d) + (r101[1] * r110), (1.0d * r100[2]) + (r110 * r101[2])};
    }
}
