package com.obric.oui.constraintlayout.motion.widget;

import com.obric.oui.constraintlayout.widget.ConstraintAttribute;
import java.util.Iterator;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes34.dex */
public final class p implements Comparable<p> {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final String[] f400140r = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public tla.c f400141a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f400142b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f400143c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f400144d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f400145e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f400146f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f400147g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f400148h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f400149i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f400150j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f400151k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f400152l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public n f400153m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final LinkedHashMap<String, ConstraintAttribute> f400154n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f400155o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public double[] f400156p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public double[] f400157q;

    static {
        f400140r = new String[]{"position", "x", "y", "width", "height", "pathRotate"};
    }

    public p() {
        this.f400142b = 0;
        this.f400149i = Float.NaN;
        this.f400150j = -1;
        this.f400151k = -1;
        this.f400152l = Float.NaN;
        this.f400153m = null;
        this.f400154n = new LinkedHashMap();
        this.f400155o = 0;
        this.f400156p = new double[18];
        this.f400157q = new double[18];
    }

    public final void a(com.obric.oui.constraintlayout.widget.a.C4670a r100) {
        this.f400141a = tla.c.c(r100.f400489d.f400554d);
        com.obric.oui.constraintlayout.widget.a.c r101 = r100.f400489d;
        this.f400150j = r101.f400555e;
        this.f400151k = r101.f400552b;
        this.f400149i = r101.f400558h;
        this.f400142b = r101.f400556f;
        float r102 = r100.f400488c.f400568e;
        this.f400152l = r100.f400490e.C;
        Iterator<String> r103 = r100.f400492g.keySet().iterator();
    L4:
        if (r103.hasNext() == false) goto L17;
        String r104 = r103.next();
        ConstraintAttribute r105 = r100.f400492g.get(r104);
        if (r105 == null) goto L4;
        int r106 = ConstraintAttribute.a.f400376a[r105.f400369c.ordinal()];
        boolean r107 = true;
        if (r106 != 1) goto L10;
    L14:
        r107 = false;
    L15:
        if (r107 == false) goto L4;
        this.f400154n.put(r104, r105);
        goto L4
    L10:
        if (r106 == 2) goto L14;
        if (r106 == 3) goto L14;
    }

    @Override // java.lang.Comparable
    public final int compareTo(p r100) {
        return Float.compare(this.f400144d, r100.f400144d);
    }

    public static boolean b(float r100, float r101) {
        if (Float.isNaN(r100) == true) goto L12;
        if (Float.isNaN(r101) == true) goto L12;
        if (Math.abs(r100 - r101) <= 1.0E-6f) goto L15;
        return true;
    L15:
        return false;
    L12:
        if (Float.isNaN(r100) == Float.isNaN(r101)) goto L16;
        return true;
    L16:
        return false;
    }

    public final void f(n r100, p r101) {
        double r102 = ((this.f400145e + (this.f400147g / 2.0f)) - r101.f400145e) - (r101.f400147g / 2.0f);
        double r103 = ((this.f400146f + (this.f400148h / 2.0f)) - r101.f400146f) - (r101.f400148h / 2.0f);
        this.f400153m = r100;
        this.f400145e = (float) Math.hypot(r103, r102);
        if (Float.isNaN(this.f400152l) == false) goto L5;
        this.f400146f = (float) (Math.atan2(r103, r102) + 1.5707963267948966d);
        return;
    L5:
        this.f400146f = (float) Math.toRadians(this.f400152l);
    }

    public final void d(float r100, float r101, float r102, float r103) {
        this.f400145e = r100;
        this.f400146f = r101;
        this.f400147g = r102;
        this.f400148h = r103;
    }

    public p(int r210, int r211, h r212, p r213, p r214) {
        this.f400142b = 0;
        this.f400149i = Float.NaN;
        this.f400150j = -1;
        this.f400151k = -1;
        this.f400152l = Float.NaN;
        this.f400153m = null;
        this.f400154n = new LinkedHashMap();
        this.f400155o = 0;
        this.f400156p = new double[18];
        this.f400157q = new double[18];
        if (r213.f400151k == (-1)) goto L34;
        float r100 = r212.f400004a / 100.0f;
        this.f400143c = r100;
        this.f400142b = r212.f400048h;
        this.f400155o = r212.f400055o;
        if (Float.isNaN(r212.f400049i) == false) goto L7;
        float r101 = r100;
    L9:
        if (Float.isNaN(r212.f400050j) == false) goto L11;
        float r102 = r100;
    L12:
        float r103 = r214.f400147g;
        float r104 = r213.f400147g;
        float r110 = r214.f400148h;
        float r111 = r213.f400148h;
        this.f400144d = this.f400143c;
        this.f400147g = (int) (r104 + ((r103 - r104) * r101));
        this.f400148h = (int) (r111 + ((r110 - r111) * r102));
        if (r212.f400055o == 2) goto L24;
        if (Float.isNaN(r212.f400051k) == false) goto L17;
        float r105 = r100;
    L18:
        float r106 = r214.f400145e;
        float r107 = r213.f400145e;
        this.f400145e = (r105 * (r106 - r107)) + r107;
        if (Float.isNaN(r212.f400052l) == true) goto L22;
        r100 = r212.f400052l;
    L22:
        float r108 = r214.f400146f;
        float r109 = r213.f400146f;
        this.f400146f = (r100 * (r108 - r109)) + r109;
    L32:
        this.f400151k = r213.f400151k;
        this.f400141a = tla.c.c(r212.f400046f);
        this.f400150j = r212.f400047g;
        return;
    L17:
        r105 = r212.f400051k;
        goto L18
    L24:
        if (Float.isNaN(r212.f400051k) == false) goto L26;
        float r112 = r214.f400145e;
        float r113 = r213.f400145e;
        float r114 = ((r112 - r113) * r100) + r113;
    L27:
        this.f400145e = r114;
        if (Float.isNaN(r212.f400052l) == false) goto L30;
        float r115 = r214.f400146f;
        float r116 = r213.f400146f;
        float r117 = (r100 * (r115 - r116)) + r116;
    L31:
        this.f400146f = r117;
        goto L32
    L30:
        r117 = r212.f400052l;
        goto L31
    L26:
        r114 = Math.min(r102, r101) * r212.f400051k;
        goto L27
    L11:
        r102 = r212.f400050j;
        goto L12
    L7:
        r101 = r212.f400049i;
        goto L9
    L34:
        int r118 = r212.f400055o;
        if (r118 == 1) goto L115;
        if (r118 != 2) goto L38;
        float r119 = r212.f400004a / 100.0f;
        this.f400143c = r119;
        this.f400142b = r212.f400048h;
        if (Float.isNaN(r212.f400049i) == false) goto L102;
        float r120 = r119;
    L104:
        if (Float.isNaN(r212.f400050j) == false) goto L106;
        float r121 = r119;
    L107:
        float r122 = r214.f400147g;
        float r123 = r213.f400147g;
        float r124 = r214.f400148h;
        float r125 = r213.f400148h;
        this.f400144d = this.f400143c;
        float r126 = r213.f400145e;
        float r127 = r213.f400146f;
        float r128 = r214.f400145e + (r122 / 2.0f);
        float r129 = r214.f400146f + (r124 / 2.0f);
        float r130 = (r122 - r123) * r120;
        this.f400145e = (int) ((r126 + ((r128 - ((r123 / 2.0f) + r126)) * r119)) - (r130 / 2.0f));
        float r131 = (r124 - r125) * r121;
        this.f400146f = (int) ((r127 + ((r129 - (r127 + (r125 / 2.0f))) * r119)) - (r131 / 2.0f));
        this.f400147g = (int) (r123 + r130);
        this.f400148h = (int) (r125 + r131);
        this.f400155o = 2;
        if (Float.isNaN(r212.f400051k) == true) goto L111;
        this.f400145e = (int) (r212.f400051k * (r210 - ((int) this.f400147g)));
    L111:
        if (Float.isNaN(r212.f400052l) == true) goto L113;
        this.f400146f = (int) (r212.f400052l * (r211 - ((int) this.f400148h)));
    L113:
        this.f400151k = this.f400151k;
        this.f400141a = tla.c.c(r212.f400046f);
        this.f400150j = r212.f400047g;
        return;
    L106:
        r121 = r212.f400050j;
        goto L107
    L102:
        r120 = r212.f400049i;
        goto L104
    L38:
        if (r118 == 3) goto L65;
        float r132 = r212.f400004a / 100.0f;
        this.f400143c = r132;
        this.f400142b = r212.f400048h;
        if (Float.isNaN(r212.f400049i) == false) goto L42;
        float r133 = r132;
    L44:
        if (Float.isNaN(r212.f400050j) == false) goto L46;
        float r134 = r132;
    L47:
        float r135 = r214.f400147g;
        float r136 = r213.f400147g;
        float r137 = r214.f400148h;
        float r138 = r213.f400148h;
        this.f400144d = this.f400143c;
        float r139 = r213.f400145e;
        float r140 = r213.f400146f;
        float r141 = r214.f400145e + (r135 / 2.0f);
        float r142 = r141 - ((r136 / 2.0f) + r139);
        float r143 = (r214.f400146f + (r137 / 2.0f)) - (r140 + (r138 / 2.0f));
        float r144 = (r135 - r136) * r133;
        float r145 = r144 / 2.0f;
        this.f400145e = (int) ((r139 + (r142 * r132)) - r145);
        float r146 = (r137 - r138) * r134;
        float r147 = r146 / 2.0f;
        this.f400146f = (int) ((r140 + (r143 * r132)) - r147);
        this.f400147g = (int) (r136 + r144);
        this.f400148h = (int) (r138 + r146);
        if (Float.isNaN(r212.f400051k) == false) goto L50;
        float r148 = r132;
    L52:
        if (Float.isNaN(r212.f400054n) == false) goto L54;
        float r149 = 0.0f;
    L56:
        if (Float.isNaN(r212.f400052l) == true) goto L60;
        r132 = r212.f400052l;
    L60:
        if (Float.isNaN(r212.f400053m) == false) goto L62;
        int r150 = 0;
        float r151 = 0.0f;
    L63:
        this.f400155o = r150;
        this.f400145e = (int) (((r213.f400145e + (r148 * r142)) + (r151 * r143)) - r145);
        this.f400146f = (int) (((r213.f400146f + (r142 * r149)) + (r143 * r132)) - r147);
        this.f400141a = tla.c.c(r212.f400046f);
        this.f400150j = r212.f400047g;
        return;
    L62:
        r151 = r212.f400053m;
        r150 = 0;
        goto L63
    L54:
        r149 = r212.f400054n;
        goto L56
    L50:
        r148 = r212.f400051k;
        goto L52
    L46:
        r134 = r212.f400050j;
        goto L47
    L42:
        r133 = r212.f400049i;
        goto L44
    L65:
        float r152 = r212.f400004a / 100.0f;
        this.f400143c = r152;
        this.f400142b = r212.f400048h;
        if (Float.isNaN(r212.f400049i) == false) goto L68;
        float r153 = r152;
    L70:
        if (Float.isNaN(r212.f400050j) == false) goto L72;
        float r154 = r152;
    L73:
        float r155 = r214.f400147g;
        float r156 = r213.f400147g;
        float r157 = r155 - r156;
        float r158 = r214.f400148h;
        float r159 = r213.f400148h;
        float r160 = r158 - r159;
        this.f400144d = this.f400143c;
        float r161 = r213.f400145e;
        float r162 = (r156 / 2.0f) + r161;
        float r163 = r213.f400146f;
        float r164 = r163 + (r159 / 2.0f);
        float r165 = r214.f400145e + (r155 / 2.0f);
        float r166 = r214.f400146f + (r158 / 2.0f);
        if (r162 > r165) goto L78;
        r162 = r165;
        r165 = r162;
    L78:
        if (r164 > r166) goto L81;
        r164 = r166;
        r166 = r164;
    L81:
        float r167 = r162 - r165;
        float r168 = r164 - r166;
        float r169 = r157 * r153;
        float r170 = r169 / 2.0f;
        this.f400145e = (int) ((r161 + (r167 * r152)) - r170);
        float r171 = r160 * r154;
        float r172 = r171 / 2.0f;
        this.f400146f = (int) ((r163 + (r168 * r152)) - r172);
        this.f400147g = (int) (r156 + r169);
        this.f400148h = (int) (r159 + r171);
        if (Float.isNaN(r212.f400051k) == false) goto L84;
        float r173 = r152;
    L86:
        if (Float.isNaN(r212.f400054n) == false) goto L88;
        float r174 = 0.0f;
    L90:
        if (Float.isNaN(r212.f400052l) == true) goto L94;
        r152 = r212.f400052l;
    L94:
        if (Float.isNaN(r212.f400053m) == false) goto L96;
        int r175 = 0;
        float r176 = 0.0f;
    L97:
        this.f400155o = r175;
        this.f400145e = (int) (((r213.f400145e + (r173 * r167)) + (r176 * r168)) - r170);
        this.f400146f = (int) (((r213.f400146f + (r167 * r174)) + (r168 * r152)) - r172);
        this.f400141a = tla.c.c(r212.f400046f);
        this.f400150j = r212.f400047g;
        return;
    L96:
        r176 = r212.f400053m;
        r175 = 0;
        goto L97
    L88:
        r174 = r212.f400054n;
        goto L90
    L84:
        r173 = r212.f400051k;
        goto L86
    L72:
        r154 = r212.f400050j;
        goto L73
    L68:
        r153 = r212.f400049i;
        goto L70
    L115:
        float r177 = r212.f400004a / 100.0f;
        this.f400143c = r177;
        this.f400142b = r212.f400048h;
        if (Float.isNaN(r212.f400049i) == false) goto L118;
        float r178 = r177;
    L120:
        if (Float.isNaN(r212.f400050j) == false) goto L122;
        float r179 = r177;
    L123:
        float r180 = r214.f400147g - r213.f400147g;
        float r181 = r214.f400148h - r213.f400148h;
        this.f400144d = this.f400143c;
        if (Float.isNaN(r212.f400051k) == true) goto L127;
        r177 = r212.f400051k;
    L127:
        float r182 = r213.f400145e;
        float r183 = r213.f400147g;
        float r184 = r213.f400146f;
        float r185 = r213.f400148h;
        float r186 = r214.f400145e + (r214.f400147g / 2.0f);
        float r187 = r186 - ((r183 / 2.0f) + r182);
        float r188 = (r214.f400146f + (r214.f400148h / 2.0f)) - ((r185 / 2.0f) + r184);
        float r189 = r187 * r177;
        float r190 = r180 * r178;
        float r191 = r190 / 2.0f;
        this.f400145e = (int) ((r182 + r189) - r191);
        float r192 = r177 * r188;
        float r193 = r181 * r179;
        float r194 = r193 / 2.0f;
        this.f400146f = (int) ((r184 + r192) - r194);
        this.f400147g = (int) (r183 + r190);
        this.f400148h = (int) (r185 + r193);
        if (Float.isNaN(r212.f400052l) == false) goto L130;
        float r195 = 0.0f;
    L131:
        this.f400155o = 1;
        float r196 = (int) ((r213.f400145e + r189) - r191);
        float r197 = (int) ((r213.f400146f + r192) - r194);
        this.f400145e = r196 + ((-r188) * r195);
        this.f400146f = r197 + (r187 * r195);
        this.f400151k = this.f400151k;
        this.f400141a = tla.c.c(r212.f400046f);
        this.f400150j = r212.f400047g;
        return;
    L130:
        r195 = r212.f400052l;
        goto L131
    L122:
        r179 = r212.f400050j;
        goto L123
    L118:
        r178 = r212.f400049i;
        goto L120
    }

    public final void c(double r110, int[] r111, double[] r112, float[] r210, int r211) {
        float r100 = this.f400145e;
        float r101 = this.f400146f;
        float r102 = this.f400147g;
        float r103 = this.f400148h;
        int r104 = 0;
    L4:
        if (r104 >= r111.length) goto L18;
        float r105 = (float) r112[r104];
        int r113 = r111[r104];
        if (r113 == 1) goto L16;
        if (r113 != 2) goto L9;
        r101 = r105;
    L17:
        r104 = r104 + 1;
        goto L4
    L9:
        if (r113 != 3) goto L11;
        r102 = r105;
        goto L17
    L11:
        if (r113 != 4) goto L17;
        r103 = r105;
        goto L17
    L16:
        r100 = r105;
        goto L17
    L18:
        n r106 = this.f400153m;
        if (r106 == null) goto L21;
        float[] r107 = new float[2];
        r106.c(r110, r107, new float[2]);
        float r108 = r107[0];
        float r109 = r107[1];
        double r114 = r108;
        double r115 = r100;
        double r116 = r101;
        r100 = (float) ((r114 + (Math.sin(r116) * r115)) - ((double) (r102 / 2.0f)));
        r101 = (float) ((((double) r109) - (r115 * Math.cos(r116))) - ((double) (r103 / 2.0f)));
    L21:
        r210[r211] = (r100 + (r102 / 2.0f)) + 0.0f;
        r210[r211 + 1] = (r101 + (r103 / 2.0f)) + 0.0f;
    }

    public static void e(float r110, float r111, float[] r112, int[] r113, double[] r114, double[] r115) {
        int r100 = 0;
        float r101 = 0.0f;
        float r102 = 0.0f;
        float r103 = 0.0f;
        float r104 = 0.0f;
    L4:
        if (r100 >= r113.length) goto L19;
        float r105 = (float) r114[r100];
        double r116 = r115[r100];
        int r117 = r113[r100];
        if (r117 != 1) goto L8;
        r102 = r105;
    L18:
        r100 = r100 + 1;
        goto L4
    L8:
        if (r117 != 2) goto L10;
        r104 = r105;
        goto L18
    L10:
        if (r117 != 3) goto L12;
        r101 = r105;
        goto L18
    L12:
        if (r117 != 4) goto L18;
        r103 = r105;
        goto L18
    L19:
        float r106 = r102 - ((0.0f * r101) / 2.0f);
        float r107 = r104 - ((0.0f * r103) / 2.0f);
        float r108 = (r101 * 1.0f) + r106;
        float r109 = (r103 * 1.0f) + r107;
        r112[0] = ((r106 * (1.0f - r110)) + (r108 * r110)) + 0.0f;
        r112[1] = ((r107 * (1.0f - r111)) + (r109 * r111)) + 0.0f;
    }
}
