package com.obric.oui.constraintlayout.motion.widget;

import android.graphics.Rect;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import androidx.camera.video.AudioStats;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.oui.constraintlayout.widget.ConstraintAttribute;
import com.obric.oui.constraintlayout.widget.ConstraintLayout;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes34.dex */
public final class n {
    public k[] A;
    public int B;
    public int C;
    public View D;
    public int E;
    public float F;
    public Interpolator G;
    public boolean H;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Rect f400114a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f400115b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f400116c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f400117d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f400118e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final p f400119f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final p f400120g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final l f400121h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final l f400122i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public tla.b[] f400123j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public tla.a f400124k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f400125l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f400126m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f400127n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int[] f400128o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public double[] f400129p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public double[] f400130q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String[] f400131r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int[] f400132s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final float[] f400133t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final ArrayList<p> f400134u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final float[] f400135v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final ArrayList<d> f400136w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public HashMap<String, vla.e> f400137x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public HashMap<String, vla.d> f400138y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public HashMap<String, vla.c> f400139z;

    public final String toString() {
        return " start: x: " + this.f400119f.f400145e + " y: " + this.f400119f.f400146f + " end: x: " + this.f400120g.f400145e + " y: " + this.f400120g.f400146f;
    }

    public final void h(int r410, int r510, long r511) {
        n r100 = this;
        new HashSet();
        HashSet<String> r101 = new HashSet();
        HashSet<String> r102 = new HashSet();
        HashSet<String> r103 = new HashSet();
        HashMap<String, Integer> r104 = new HashMap();
        int r105 = r100.B;
        if (r105 == (-1)) goto L5;
        r100.f400119f.f400150j = r105;
    L5:
        l r106 = r100.f400121h;
        l r107 = r100.f400122i;
        String r108 = "alpha";
        if (l.c(r106.f400100e, r107.f400100e) == false) goto L8;
        r102.add("alpha");
    L8:
        String r110 = "elevation";
        if (l.c(r106.f400101f, r107.f400101f) == false) goto L11;
        r102.add("elevation");
    L11:
        int r109 = r106.f400098c;
        int r111 = r107.f400098c;
        if (r109 != r111) goto L14;
    L18:
        String r112 = "rotation";
        if (l.c(r106.f400102g, r107.f400102g) == false) goto L22;
        r102.add("rotation");
    L22:
        if (Float.isNaN(r106.f400111p) == true) goto L24;
    L25:
        r102.add("transitionPathRotate");
    L27:
        if (Float.isNaN(r106.f400112q) == true) goto L29;
    L30:
        r102.add("progress");
    L32:
        if (l.c(r106.f400103h, r107.f400103h) == false) goto L35;
        r102.add("rotationX");
    L35:
        if (l.c(r106.f400096a, r107.f400096a) == false) goto L37;
        r102.add("rotationY");
    L37:
        String r113 = "transformPivotX";
        if (l.c(r106.f400106k, r107.f400106k) == false) goto L40;
        r102.add("transformPivotX");
    L40:
        Object r114 = "rotationX";
        String r115 = "transformPivotY";
        if (l.c(r106.f400107l, r107.f400107l) == false) goto L43;
        r102.add("transformPivotY");
    L43:
        Object r116 = "rotationY";
        if (l.c(r106.f400104i, r107.f400104i) == false) goto L46;
        r102.add(LiveDegradeFpsAnimator.SCALE_X);
    L46:
        Object r117 = "progress";
        boolean r118 = l.c(r106.f400105j, r107.f400105j);
        String r119 = LiveDegradeFpsAnimator.SCALE_Y;
        if (r118 == false) goto L49;
        r102.add(LiveDegradeFpsAnimator.SCALE_Y);
    L49:
        float r120 = r106.f400108m;
        Object r210 = LiveDegradeFpsAnimator.SCALE_X;
        if (l.c(r120, r107.f400108m) == false) goto L52;
        r102.add(LiveDegradeFpsAnimator.TRANSLATION_X);
    L52:
        float r121 = r106.f400109n;
        Object r211 = LiveDegradeFpsAnimator.TRANSLATION_X;
        boolean r122 = l.c(r121, r107.f400109n);
        String r123 = LiveDegradeFpsAnimator.TRANSLATION_Y;
        if (r122 == false) goto L55;
        r102.add(LiveDegradeFpsAnimator.TRANSLATION_Y);
    L55:
        String r124 = "translationZ";
        if (l.c(r106.f400110o, r107.f400110o) == false) goto L58;
        r102.add("translationZ");
    L58:
        ArrayList<d> r125 = r100.f400136w;
        if (r125 == null) goto L86;
        Iterator<d> r126 = r125.iterator();
        ArrayList r212 = null;
    L62:
        if (r126.hasNext() == false) goto L85;
        d r127 = r126.next();
        Iterator<d> r213 = r126;
        if ((r127 instanceof h) == false) goto L71;
        h r128 = (h) r127;
        String r310 = r123;
        String r311 = r124;
        p r129 = new p(r410, r510, r128, r100.f400119f, r100.f400120g);
        int r130 = Collections.binarySearch(r100.f400134u, r129);
        if (r130 == 0) goto L68;
    L68:
        String r214 = r119;
        ListProtector.add(r100.f400134u, (-r130) - 1, r129);
        int r131 = r128.f400057e;
        if (r131 == (-1)) goto L84;
        r100.f400118e = r131;
    L84:
        r126 = r213;
        r119 = r214;
        r123 = r310;
        r124 = r311;
        goto L62
    L71:
        r311 = r124;
        r214 = r119;
        r310 = r123;
        if ((r127 instanceof f) == false) goto L75;
        r127.d(r103);
        goto L84
    L75:
        if ((r127 instanceof j) == false) goto L78;
        r127.d(r101);
        goto L84
    L78:
        if ((r127 instanceof k) == false) goto L83;
        if (r212 != null) goto L81;
        ArrayList r132 = new ArrayList();
    L82:
        r132.add((k) r127);
        r212 = r132;
        goto L84
    L81:
        r132 = r212;
        goto L82
    L83:
        r127.f(r104);
        r127.d(r102);
        goto L84
    L85:
        String r312 = r124;
        String r215 = r119;
        String r313 = r123;
        ArrayList r133 = r212;
    L88:
        if (r133 == null) goto L90;
        r100.A = (k[]) r133.toArray(new k[0]);
    L90:
        String r134 = "waveOffset";
        String r135 = "waveVariesBy";
        String r136 = ",";
        String r137 = "CUSTOM,";
        if (r102.isEmpty() == true) goto L223;
        r100.f400138y = new HashMap();
        Iterator<String> r138 = r102.iterator();
    L94:
        if (r138.hasNext() == false) goto L202;
        String r139 = r138.next();
        if (r139.startsWith(r137) == false) goto L108;
        SparseArray r140 = new SparseArray();
        String r141 = r139.split(r136)[1];
        Iterator<d> r142 = r100.f400136w.iterator();
    L99:
        if (r142.hasNext() == false) goto L107;
        Iterator<d> r411 = r142;
        d r143 = r142.next();
        String r314 = r137;
        HashMap<String, ConstraintAttribute> r144 = r143.f400007d;
        if (r144 == null) goto L106;
        ConstraintAttribute r145 = r144.get(r141);
        if (r145 == null) goto L106;
        r140.append(r143.f400004a, r145);
    L106:
        r137 = r314;
        r142 = r411;
        goto L99
    L107:
        r137 = r137;
        vla.d.b r146 = new vla.d.b(r139, r140);
        r117 = r117;
        r210 = r210;
        r312 = r312;
        r113 = r113;
        r115 = r115;
        r211 = r211;
        r313 = r313;
        r135 = r135;
        Object r147 = r116;
        r134 = r134;
        vla.d r148 = r146;
        r215 = r215;
        r114 = r114;
    L199:
        if (r148 == null) goto L200;
        r148.f546715e = r139;
        r100.f400138y.put(r139, r148);
        r116 = r147;
        goto L94
    L200:
        r116 = r147;
        goto L94
    L108:
        r137 = r137;
        switch(r139.hashCode()) {
            case -1249320806: goto L175;
            case -1249320805: goto L171;
            case -1225497657: goto L167;
            case -1225497656: goto L163;
            case -1225497655: goto L159;
            case -1001078227: goto L155;
            case -908189618: goto L151;
            case -908189617: goto L147;
            case -797520672: goto L144;
            case -760884510: goto L140;
            case -760884509: goto L136;
            case -40300674: goto L132;
            case -4379043: goto L128;
            case 37232917: goto L124;
            case 92909918: goto L120;
            case 156108012: goto L116;
            default: goto L110;
        };
    L110:
        r117 = r117;
        r215 = r215;
    L111:
        r312 = r312;
    L112:
        r113 = r113;
        r115 = r115;
        r211 = r211;
        r313 = r313;
    L113:
        r135 = r135;
        r147 = r116;
    L114:
        r134 = r134;
        Object r149 = r114;
    L179:
        byte r150 = -1;
    L180:
        switch(r150) {
            case 0: goto L197;
            case 1: goto L196;
            case 2: goto L195;
            case 3: goto L194;
            case 4: goto L193;
            case 5: goto L192;
            case 6: goto L191;
            case 7: goto L190;
            case 8: goto L189;
            case 9: goto L188;
            case 10: goto L187;
            case 11: goto L186;
            case 12: goto L185;
            case 13: goto L184;
            case 14: goto L183;
            case 15: goto L182;
            default: goto L181;
        };
    L181:
        vla.d r151 = null;
    L198:
        r114 = r149;
        r148 = r151;
        goto L199
    L182:
        r151 = new vla.d.a();
        goto L198
    L183:
        r151 = new vla.d.a();
        goto L198
    L184:
        r151 = new vla.d.C8019d();
        goto L198
    L185:
        r151 = new vla.d.c();
        goto L198
    L186:
        r151 = new vla.d.h();
        goto L198
    L187:
        r151 = new vla.d.f();
        goto L198
    L188:
        r151 = new vla.d.e();
        goto L198
    L189:
        r151 = new vla.d.a();
        goto L198
    L190:
        r151 = new vla.d.l();
        goto L198
    L191:
        r151 = new vla.d.k();
        goto L198
    L192:
        r151 = new vla.d.g();
        goto L198
    L193:
        r151 = new vla.d.o();
        goto L198
    L194:
        r151 = new vla.d.n();
        goto L198
    L195:
        r151 = new vla.d.m();
        goto L198
    L196:
        r151 = new vla.d.j();
        goto L198
    L197:
        r151 = new vla.d.i();
        goto L198
    L147:
        r215 = r215;
        r117 = r117;
        if (r139.equals(r215) == false) goto L111;
        r210 = r210;
        r312 = r312;
        r113 = r113;
        r115 = r115;
        r211 = r211;
        r313 = r313;
        r135 = r135;
        r147 = r116;
        r134 = r134;
        r149 = r114;
        r150 = 7;
        goto L180
    L151:
        r210 = r210;
        r215 = r215;
        r115 = r115;
        if (r139.equals(r210) == true) goto L154;
        r117 = r117;
        r211 = r211;
        r312 = r312;
        r113 = r113;
        r135 = r135;
        r147 = r116;
        r313 = r313;
        goto L114
    L154:
        r117 = r117;
        r211 = r211;
        r312 = r312;
        r113 = r113;
        r135 = r135;
        r147 = r116;
        r313 = r313;
        r134 = r134;
        r149 = r114;
        r150 = 6;
        goto L180
    L155:
        r117 = r117;
        r210 = r210;
        r215 = r215;
        r113 = r113;
        r115 = r115;
        r211 = r211;
        r313 = r313;
        if (r139.equals(r117) == true) goto L158;
        r312 = r312;
        goto L113
    L158:
        r312 = r312;
        r135 = r135;
        r147 = r116;
        r134 = r134;
        r149 = r114;
        r150 = 5;
        goto L180
    L159:
        r117 = r117;
        r210 = r210;
        r215 = r215;
        r312 = r312;
        if (r139.equals(r312) == false) goto L112;
        r113 = r113;
        r115 = r115;
        r211 = r211;
        r313 = r313;
        r135 = r135;
        r147 = r116;
        r134 = r134;
        r149 = r114;
        r150 = 4;
        goto L180
    L163:
        r117 = r117;
        r210 = r210;
        r215 = r215;
        r312 = r312;
        r113 = r113;
        r313 = r313;
        if (r139.equals(r313) == true) goto L166;
        r115 = r115;
        r211 = r211;
        goto L113
    L166:
        r115 = r115;
        r211 = r211;
        r135 = r135;
        r147 = r116;
        r134 = r134;
        r149 = r114;
        r150 = 3;
        goto L180
    L167:
        r117 = r117;
        r210 = r210;
        r215 = r215;
        r312 = r312;
        r113 = r113;
        r115 = r115;
        r211 = r211;
        r313 = r313;
        if (r139.equals(r211) == false) goto L113;
        r135 = r135;
        r147 = r116;
        r134 = r134;
        r149 = r114;
        r150 = 2;
        goto L180
    L171:
        r117 = r117;
        r210 = r210;
        r215 = r215;
        r312 = r312;
        r113 = r113;
        r115 = r115;
        r211 = r211;
        r313 = r313;
        r135 = r135;
        r147 = r116;
        if (r139.equals(r147) == false) goto L114;
        r134 = r134;
        r149 = r114;
        r150 = 1;
        goto L180
    L175:
        r117 = r117;
        r210 = r210;
        r215 = r215;
        r312 = r312;
        r113 = r113;
        r115 = r115;
        r211 = r211;
        r313 = r313;
        r135 = r135;
        r147 = r116;
        r134 = r134;
        r149 = r114;
        if (r139.equals(r149) == false) goto L179;
        r150 = 0;
        goto L180
    L116:
        if (r139.equals(r134) == false) goto L110;
        r117 = r117;
        r210 = r210;
        r215 = r215;
        r312 = r312;
        r113 = r113;
        r115 = r115;
        r211 = r211;
        r313 = r313;
        r135 = r135;
        r147 = r116;
        r134 = r134;
        r149 = r114;
        r150 = 15;
        goto L180
    L120:
        if (r139.equals("alpha") == false) goto L110;
        r117 = r117;
        r210 = r210;
        r215 = r215;
        r312 = r312;
        r113 = r113;
        r115 = r115;
        r211 = r211;
        r313 = r313;
        r135 = r135;
        r147 = r116;
        r134 = r134;
        r149 = r114;
        r150 = 14;
        goto L180
    L124:
        if (r139.equals("transitionPathRotate") == false) goto L110;
        r117 = r117;
        r210 = r210;
        r215 = r215;
        r312 = r312;
        r113 = r113;
        r115 = r115;
        r211 = r211;
        r313 = r313;
        r135 = r135;
        r147 = r116;
        r134 = r134;
        r149 = r114;
        r150 = HTTP.CR;
        goto L180
    L128:
        if (r139.equals("elevation") == false) goto L110;
        r117 = r117;
        r210 = r210;
        r215 = r215;
        r312 = r312;
        r113 = r113;
        r115 = r115;
        r211 = r211;
        r313 = r313;
        r135 = r135;
        r147 = r116;
        r134 = r134;
        r149 = r114;
        r150 = 12;
        goto L180
    L132:
        if (r139.equals("rotation") == false) goto L110;
        r117 = r117;
        r210 = r210;
        r215 = r215;
        r312 = r312;
        r113 = r113;
        r115 = r115;
        r211 = r211;
        r313 = r313;
        r135 = r135;
        r147 = r116;
        r134 = r134;
        r149 = r114;
        r150 = 11;
        goto L180
    L136:
        if (r139.equals(r115) == false) goto L110;
        r117 = r117;
        r210 = r210;
        r215 = r215;
        r312 = r312;
        r113 = r113;
        r115 = r115;
        r211 = r211;
        r313 = r313;
        r135 = r135;
        r147 = r116;
        r134 = r134;
        r149 = r114;
        r150 = 10;
        goto L180
    L140:
        if (r139.equals(r113) == false) goto L110;
        r117 = r117;
        r210 = r210;
        r215 = r215;
        r312 = r312;
        r113 = r113;
        r115 = r115;
        r211 = r211;
        r313 = r313;
        r135 = r135;
        r147 = r116;
        r134 = r134;
        r149 = r114;
        r150 = 9;
        goto L180
    L144:
        if (r139.equals(r135) == false) goto L110;
        r117 = r117;
        r210 = r210;
        r215 = r215;
        r312 = r312;
        r113 = r113;
        r115 = r115;
        r211 = r211;
        r313 = r313;
        r135 = r135;
        r147 = r116;
        r134 = r134;
        r149 = r114;
        r150 = 8;
        goto L180
    L202:
        HashSet<String> r315 = r102;
        String r316 = r136;
        String r317 = r137;
        Object r152 = r117;
        Object r153 = r210;
        Object r154 = r211;
        String r155 = r215;
        String r156 = r313;
        String r157 = r312;
        String r216 = r135;
        Object r217 = r114;
        Object r158 = r116;
        String r159 = r134;
        ArrayList<d> r160 = r100.f400136w;
        if (r160 == null) goto L210;
        Iterator<d> r161 = r160.iterator();
    L206:
        if (r161.hasNext() == false) goto L210;
        d r162 = r161.next();
        if ((r162 instanceof e) == false) goto L206;
        r162.a(r100.f400138y);
    L210:
        r100.f400121h.a(r100.f400138y, 0);
        r100.f400122i.a(r100.f400138y, 100);
        Iterator<String> r163 = r100.f400138y.keySet().iterator();
    L212:
        if (r163.hasNext() == false) goto L225;
        String r164 = r163.next();
        if (r104.containsKey(r164) == false) goto L218;
        Integer r165 = r104.get(r164);
        if (r165 == null) goto L218;
        int r166 = r165.intValue();
    L219:
        vla.d r167 = r100.f400138y.get(r164);
        if (r167 == null) goto L222;
        r167.c(r166);
    L222:
        r163 = r163;
    L218:
        r166 = 0;
    L225:
        if (r101.isEmpty() == false) goto L227;
        n r168 = r100;
        String r169 = r156;
        Object r170 = r154;
        Object r318 = r158;
        Object r171 = r217;
    L441:
        int r172 = r168.f400134u.size() + 2;
        p[] r173 = new p[r172];
        r173[0] = r168.f400119f;
        r173[r172 - 1] = r168.f400120g;
        if (r168.f400134u.size() > 0) goto L444;
    L446:
        Iterator<p> r174 = r168.f400134u.iterator();
        int r175 = 1;
    L448:
        if (r174.hasNext() == false) goto L450;
        r173[r175] = r174.next();
        r175 = r175 + 1;
        goto L448
    L450:
        HashSet r176 = new HashSet();
        Iterator<String> r177 = r168.f400120g.f400154n.keySet().iterator();
    L452:
        if (r177.hasNext() == false) goto L460;
        String r178 = r177.next();
        Iterator<String> r512 = r177;
        if (r168.f400119f.f400154n.containsKey(r178) == false) goto L458;
        Object r179 = r170;
        HashSet<String> r180 = r315;
        if (r180.contains(r317 + r178) == true) goto L459;
        r176.add(r178);
    L459:
        r177 = r512;
        r315 = r180;
        r170 = r179;
        goto L452
    L458:
        r179 = r170;
        r180 = r315;
        goto L459
    L460:
        Object r181 = r170;
        String[] r182 = (String[]) r176.toArray(new String[0]);
        r168.f400131r = r182;
        r168.f400132s = new int[r182.length];
        int r183 = 0;
    L461:
        String[] r184 = r168.f400131r;
        if (r183 >= r184.length) goto L473;
        String r185 = r184[r183];
        r168.f400132s[r183] = 0;
        int r186 = 0;
    L464:
        if (r186 >= r172) goto L471;
        if (r173[r186].f400154n.containsKey(r185) == false) goto L470;
        ConstraintAttribute r187 = r173[r186].f400154n.get(r185);
        if (r187 == null) goto L470;
        int[] r188 = r168.f400132s;
        r188[r183] = r188[r183] + r187.c();
    L470:
        r186 = r186 + 1;
    L471:
        r183 = r183 + 1;
        goto L461
    L473:
        if (r173[0].f400150j == (-1)) goto L475;
        boolean r189 = true;
    L476:
        int r190 = r184.length + 18;
        boolean[] r191 = new boolean[r190];
        int r192 = 1;
    L477:
        if (r192 >= r172) goto L479;
        String r319 = r169;
        p r193 = r173[r192];
        String r320 = r157;
        p r194 = r173[r192 - 1];
        Object r218 = r153;
        boolean r195 = p.b(r193.f400145e, r194.f400145e);
        String r321 = r155;
        boolean r196 = p.b(r193.f400146f, r194.f400146f);
        r191[0] = r191[0] | p.b(r193.f400144d, r194.f400144d);
        boolean r197 = (r196 | r195) | r189;
        r191[1] = r191[1] | r197;
        r191[2] = r197 | r191[2];
        r191[3] = r191[3] | p.b(r193.f400147g, r194.f400147g);
        r191[4] = p.b(r193.f400148h, r194.f400148h) | r191[4];
        r192 = r192 + 1;
        r152 = r152;
        r153 = r218;
        r157 = r320;
        r169 = r319;
        r155 = r321;
        r112 = r112;
        goto L477
    L479:
        String r322 = r169;
        String r323 = r155;
        Object r219 = r153;
        Object r220 = r152;
        String r324 = r112;
        String r325 = r157;
        int r198 = 0;
        int r199 = 1;
    L480:
        if (r199 >= r190) goto L485;
        if (r191[r199] == false) goto L484;
        r198 = r198 + 1;
    L484:
        r199 = r199 + 1;
        goto L480
    L485:
        r168.f400128o = new int[r198];
        int r200 = Math.max(2, r198);
        r168.f400129p = new double[r200];
        r168.f400130q = new double[r200];
        int r201 = 0;
        int r202 = 1;
    L486:
        if (r202 >= r190) goto L491;
        if (r191[r202] == false) goto L490;
        r168.f400128o[r201] = r202;
        r201 = r201 + 1;
    L490:
        r202 = r202 + 1;
        goto L486
    L491:
        double[][] r203 = (double[][]) Array.newInstance(Double.TYPE, new int[]{r172, r168.f400128o.length});
        double[] r204 = new double[r172];
        int r205 = 0;
    L492:
        if (r205 >= r172) goto L502;
        p r206 = r173[r205];
        double[] r207 = r203[r205];
        int[] r208 = r168.f400128o;
        float[] r1100 = {r206.f400144d, r206.f400145e, r206.f400146f, r206.f400147g, r206.f400148h, r206.f400149i};
        int r209 = 0;
        int r1101 = 0;
    L495:
        if (r209 >= r208.length) goto L501;
        int r1102 = r208[r209];
        if (r1102 >= 6) goto L500;
        r207[r1101] = r1100[r1102];
        r1101 = r1101 + 1;
    L500:
        r209 = r209 + 1;
        r1100 = r1100;
        goto L495
    L501:
        r204[r205] = r173[r205].f400143c;
        r205 = r205 + 1;
        goto L492
    L502:
        int r221 = 0;
    L503:
        int[] r222 = r168.f400128o;
        if (r221 >= r222.length) goto L511;
        int r223 = r222[r221];
        String[] r224 = p.f400140r;
        if (r223 >= r224.length) goto L510;
        String r225 = r224[r168.f400128o[r221]] + " [";
        int r226 = 0;
    L508:
        if (r226 >= r172) goto L510;
        r225 = r225 + r203[r226][r221];
        r226 = r226 + 1;
    L510:
        r221 = r221 + 1;
        goto L503
    L511:
        r168.f400123j = new tla.b[r168.f400131r.length + 1];
        int r227 = 0;
    L512:
        String[] r228 = r168.f400131r;
        if (r227 >= r228.length) goto L537;
        String r229 = r228[r227];
        int r230 = 0;
        int r231 = 0;
        double[] r1103 = null;
        double[][] r1104 = null;
    L515:
        if (r230 >= r172) goto L536;
        if (r173[r230].f400154n.containsKey(r229) == false) goto L534;
        if (r1104 != null) goto L524;
        r1103 = new double[r172];
        ConstraintAttribute r1105 = r173[r230].f400154n.get(r229);
        if (r1105 != null) goto L522;
        int r1106 = 0;
    L523:
        r1104 = (double[][]) Array.newInstance(Double.TYPE, new int[]{r172, r1106});
        goto L524
    L522:
        r1106 = r1105.c();
    L524:
        p r1107 = r173[r230];
        r1103[r231] = r1107.f400143c;
        double[] r232 = r1104[r231];
        ConstraintAttribute r1108 = r1107.f400154n.get(r229);
        if (r1108 != null) goto L528;
    L526:
        String r513 = r229;
        r231 = r231 + 1;
        r1104 = r1104;
    L535:
        r230 = r230 + 1;
        r229 = r513;
        r108 = r108;
        r110 = r110;
        goto L515
    L528:
        if (r1108.c() != 1) goto L530;
        r232[0] = r1108.a();
        goto L526
    L530:
        int r1109 = r1108.c();
        float[] r1110 = new float[r1109];
        r1108.b(r1110);
        int r1111 = 0;
        int r412 = 0;
    L531:
        if (r1111 >= r1109) goto L526;
        r232[r412] = r1110[r1111];
        r1111 = r1111 + 1;
        r229 = r229;
        r1104 = r1104;
        r412 = r412 + 1;
        r1109 = r1109;
        goto L531
    L534:
        r513 = r229;
        goto L535
    L536:
        r227 = r227 + 1;
        r168.f400123j[r227] = tla.b.a(r168.f400118e, Arrays.copyOf(r1103, r231), (double[][]) Arrays.copyOf(r1104, r231));
        r108 = r108;
        goto L512
    L537:
        String r326 = r108;
        String r413 = r110;
        r168.f400123j[0] = tla.b.a(r168.f400118e, r204, r203);
        if (r173[0].f400150j == (-1)) goto L543;
        int[] r233 = new int[r172];
        double[] r234 = new double[r172];
        double[][] r235 = (double[][]) Array.newInstance(Double.TYPE, new int[]{r172, 2});
        int r236 = 0;
    L540:
        if (r236 >= r172) goto L542;
        p r237 = r173[r236];
        r233[r236] = r237.f400150j;
        r234[r236] = r237.f400143c;
        double[] r238 = r235[r236];
        r238[0] = r237.f400145e;
        r238[1] = r237.f400146f;
        r236 = r236 + 1;
        goto L540
    L542:
        r168.f400124k = new tla.a(r233, r234, r235);
    L543:
        r168.f400139z = new HashMap();
        if (r168.f400136w == null) goto L680;
        Iterator<String> r239 = r103.iterator();
        float r240 = Float.NaN;
    L547:
        if (r239.hasNext() == false) goto L670;
        String r241 = r239.next();
        if (r241.startsWith("CUSTOM") == false) goto L552;
        r239 = r239;
        vla.c r242 = new vla.c.b();
        String r243 = r159;
        r181 = r181;
        r220 = r220;
        r216 = r216;
        r219 = r219;
        r318 = r318;
        r325 = r325;
        r322 = r322;
        r323 = r323;
        r326 = r326;
        String r244 = r324;
        String r245 = r413;
    L630:
        if (r242 != null) goto L633;
        r245 = r245;
        String r327 = r244;
        String r328 = r216;
        String r414 = r323;
        Object r514 = r219;
    L669:
        r239 = r239;
        r220 = r220;
        r325 = r325;
        r318 = r318;
        r159 = r243;
        r413 = r245;
        r324 = r327;
        r216 = r328;
        r323 = r414;
        r219 = r514;
        r181 = r181;
        r322 = r322;
        goto L547
    L633:
        if (r242.f546681e != 1) goto L635;
        boolean r246 = true;
    L636:
        if (r246 == true) goto L638;
    L667:
        r327 = r244;
        r328 = r216;
        r414 = r323;
        r514 = r219;
    L668:
        r242.f546678b = r241;
        r168.f400139z.put(r241, r242);
        goto L669
    L638:
        if (Float.isNaN(r240) == false) goto L667;
        float[] r247 = new float[2];
        float r248 = 1.0f / 99;
        double r329 = AudioStats.AUDIO_AMPLITUDE_NONE;
        float r249 = 0.0f;
        double r250 = 0.0d;
        int r251 = 0;
    L641:
        if (r251 >= 100) goto L666;
        float r252 = r251 * r248;
        String r330 = r244;
        String r331 = r216;
        double r253 = r252;
        tla.c r254 = r168.f400119f.f400141a;
        Iterator<p> r255 = r168.f400134u.iterator();
        float r415 = Float.NaN;
        float r416 = 0.0f;
    L644:
        if (r255.hasNext() == false) goto L654;
        Iterator<p> r515 = r255;
        p r256 = r255.next();
        String r417 = r323;
        tla.c r257 = r256.f400141a;
        if (r257 == null) goto L653;
        float r258 = r256.f400143c;
        if (r258 >= r252) goto L651;
        r416 = r258;
        r254 = r257;
        goto L653
    L651:
        if (Float.isNaN(r415) == false) goto L653;
        r415 = r256.f400143c;
    L653:
        r255 = r515;
        r323 = r417;
        goto L644
    L654:
        String r418 = r323;
        if (r254 != null) goto L657;
        double r259 = r253;
    L661:
        r168.f400123j[0].c(r259, r168.f400129p);
        Object r516 = r219;
        r168.f400119f.c(r259, r168.f400128o, r168.f400129p, r247, 0);
        if (r251 <= 0) goto L664;
        char r260 = 0;
        r249 = r249 + ((float) Math.hypot(r329 - ((double) r247[1]), r250 - ((double) r247[0])));
    L665:
        r251 = r251 + 1;
        r219 = r516;
        r250 = r247[r260];
        r329 = r247[1];
        r244 = r330;
        r216 = r331;
        r323 = r418;
        goto L641
    L664:
        r260 = 0;
        goto L665
    L657:
        if (Float.isNaN(r415) == false) goto L659;
        r415 = 1.0f;
    L659:
        float r419 = r415 - r416;
        r259 = (((float) r254.a((r252 - r416) / r419)) * r419) + r416;
        goto L661
    L666:
        r327 = r244;
        r328 = r216;
        r414 = r323;
        r514 = r219;
        r240 = r249;
        goto L668
    L635:
        r246 = false;
        goto L636
    L552:
        switch(r241.hashCode()) {
            case -1249320806: goto L608;
            case -1249320805: goto L604;
            case -1225497657: goto L600;
            case -1225497656: goto L596;
            case -1225497655: goto L592;
            case -1001078227: goto L588;
            case -908189618: goto L584;
            case -908189617: goto L580;
            case -797520672: goto L576;
            case -40300674: goto L572;
            case -4379043: goto L568;
            case 37232917: goto L564;
            case 92909918: goto L560;
            case 156108012: goto L556;
            default: goto L553;
        };
    L553:
        r243 = r159;
    L554:
        r326 = r326;
    L555:
        r244 = r324;
        r245 = r413;
    L612:
        byte r1112 = -1;
    L613:
        switch(r1112) {
            case 0: goto L628;
            case 1: goto L627;
            case 2: goto L626;
            case 3: goto L625;
            case 4: goto L624;
            case 5: goto L623;
            case 6: goto L622;
            case 7: goto L621;
            case 8: goto L620;
            case 9: goto L619;
            case 10: goto L618;
            case 11: goto L617;
            case 12: goto L616;
            case 13: goto L615;
            default: goto L614;
        };
    L614:
        r171 = r171;
        r242 = null;
        goto L630
    L615:
        vla.c r1113 = new vla.c.a();
    L629:
        vla.c r420 = r1113;
        r171 = r171;
        r242 = r420;
        goto L630
    L616:
        r1113 = new vla.c.a();
        goto L629
    L617:
        r1113 = new vla.c.d();
        goto L629
    L618:
        r1113 = new vla.c.C8018c();
        goto L629
    L619:
        r1113 = new vla.c.f();
        goto L629
    L620:
        r1113 = new vla.c.a();
        goto L629
    L621:
        r1113 = new vla.c.j();
        goto L629
    L622:
        r1113 = new vla.c.i();
        goto L629
    L623:
        r1113 = new vla.c.e();
        goto L629
    L624:
        r1113 = new vla.c.m();
        goto L629
    L625:
        r1113 = new vla.c.l();
        goto L629
    L626:
        r1113 = new vla.c.k();
        goto L629
    L627:
        r1113 = new vla.c.h();
        goto L629
    L628:
        r1113 = new vla.c.g();
        goto L629
    L556:
        r243 = r159;
        if (r241.equals(r243) == false) goto L554;
        r239 = r239;
        r171 = r171;
        r181 = r181;
        r220 = r220;
        r216 = r216;
        r219 = r219;
        r318 = r318;
        r325 = r325;
        r322 = r322;
        r323 = r323;
        r326 = r326;
        r244 = r324;
        r245 = r413;
        r1112 = HTTP.CR;
        goto L613
    L560:
        r243 = r159;
        r326 = r326;
        if (r241.equals(r326) == true) goto L563;
    L562:
        r239 = r239;
        r171 = r171;
        goto L555
    L563:
        r239 = r239;
        r171 = r171;
        r181 = r181;
        r220 = r220;
        r216 = r216;
        r219 = r219;
        r318 = r318;
        r325 = r325;
        r322 = r322;
        r323 = r323;
        r244 = r324;
        r245 = r413;
        r1112 = 12;
        goto L613
    L564:
        r243 = r159;
        r326 = r326;
        if (r241.equals("transitionPathRotate") == false) goto L562;
        r239 = r239;
        r171 = r171;
        r181 = r181;
        r220 = r220;
        r216 = r216;
        r219 = r219;
        r318 = r318;
        r325 = r325;
        r322 = r322;
        r323 = r323;
        r244 = r324;
        r245 = r413;
        r1112 = 11;
        goto L613
    L568:
        r243 = r159;
        r326 = r326;
        r245 = r413;
        r239 = r239;
        r171 = r171;
        r181 = r181;
        r220 = r220;
        r216 = r216;
        r219 = r219;
        r318 = r318;
        r325 = r325;
        r322 = r322;
        r323 = r323;
        if (r241.equals(r245) == true) goto L571;
        r244 = r324;
        goto L612
    L571:
        r244 = r324;
        r1112 = 10;
        goto L613
    L572:
        r243 = r159;
        r326 = r326;
        r244 = r324;
        r245 = r413;
        if (r241.equals(r244) == true) goto L575;
        r216 = r216;
    L578:
        r239 = r239;
        r171 = r171;
        r181 = r181;
        r220 = r220;
        r219 = r219;
        r318 = r318;
        r325 = r325;
        r322 = r322;
        r323 = r323;
        goto L612
    L575:
        r239 = r239;
        r171 = r171;
        r181 = r181;
        r220 = r220;
        r216 = r216;
        r219 = r219;
        r318 = r318;
        r325 = r325;
        r322 = r322;
        r323 = r323;
        r1112 = 9;
        goto L613
    L576:
        r243 = r159;
        r216 = r216;
        r326 = r326;
        r244 = r324;
        r245 = r413;
        if (r241.equals(r216) == false) goto L578;
        r239 = r239;
        r171 = r171;
        r181 = r181;
        r220 = r220;
        r219 = r219;
        r318 = r318;
        r325 = r325;
        r322 = r322;
        r323 = r323;
        r1112 = 8;
        goto L613
    L580:
        r243 = r159;
        r216 = r216;
        r323 = r323;
        r326 = r326;
        r244 = r324;
        r245 = r413;
        if (r241.equals(r323) == true) goto L583;
        r219 = r219;
    L586:
        r220 = r220;
    L590:
        r239 = r239;
        r171 = r171;
        r181 = r181;
        r318 = r318;
        r325 = r325;
    L594:
        r322 = r322;
        goto L612
    L583:
        r239 = r239;
        r171 = r171;
        r181 = r181;
        r220 = r220;
        r219 = r219;
        r318 = r318;
        r325 = r325;
        r322 = r322;
        r1112 = 7;
        goto L613
    L584:
        r243 = r159;
        r216 = r216;
        r219 = r219;
        r323 = r323;
        r326 = r326;
        r244 = r324;
        r245 = r413;
        if (r241.equals(r219) == false) goto L586;
        r239 = r239;
        r171 = r171;
        r181 = r181;
        r220 = r220;
        r318 = r318;
        r325 = r325;
        r322 = r322;
        r1112 = 6;
        goto L613
    L588:
        r243 = r159;
        r220 = r220;
        r216 = r216;
        r219 = r219;
        r323 = r323;
        r326 = r326;
        r244 = r324;
        r245 = r413;
        if (r241.equals(r220) == false) goto L590;
        r239 = r239;
        r171 = r171;
        r181 = r181;
        r318 = r318;
        r325 = r325;
        r322 = r322;
        r1112 = 5;
        goto L613
    L592:
        r243 = r159;
        r220 = r220;
        r216 = r216;
        r219 = r219;
        r325 = r325;
        r323 = r323;
        r326 = r326;
        r244 = r324;
        r245 = r413;
        r239 = r239;
        r171 = r171;
        r181 = r181;
        r318 = r318;
        if (r241.equals(r325) == false) goto L594;
        r322 = r322;
        r1112 = 4;
        goto L613
    L596:
        r243 = r159;
        r220 = r220;
        r216 = r216;
        r219 = r219;
        r325 = r325;
        r322 = r322;
        r323 = r323;
        r326 = r326;
        r244 = r324;
        r245 = r413;
        r239 = r239;
        r171 = r171;
        r181 = r181;
        r318 = r318;
        if (r241.equals(r322) == false) goto L612;
        r1112 = 3;
        goto L613
    L600:
        r243 = r159;
        r181 = r181;
        r220 = r220;
        r216 = r216;
        r219 = r219;
        r325 = r325;
        r322 = r322;
        r323 = r323;
        r326 = r326;
        r244 = r324;
        r245 = r413;
        r239 = r239;
        r171 = r171;
        if (r241.equals(r181) == true) goto L603;
        r318 = r318;
        goto L612
    L603:
        r318 = r318;
        r1112 = 2;
        goto L613
    L604:
        r239 = r239;
        r243 = r159;
        r181 = r181;
        r220 = r220;
        r216 = r216;
        r219 = r219;
        Object r261 = r318;
        r325 = r325;
        r322 = r322;
        r323 = r323;
        r326 = r326;
        r244 = r324;
        r245 = r413;
        if (r241.equals(r261) == true) goto L607;
        r318 = r261;
        r171 = r171;
        goto L612
    L607:
        r318 = r261;
        r171 = r171;
        r1112 = 1;
        goto L613
    L608:
        r239 = r239;
        r171 = r171;
        r243 = r159;
        r181 = r181;
        r220 = r220;
        r216 = r216;
        r219 = r219;
        r318 = r318;
        r325 = r325;
        r322 = r322;
        r323 = r323;
        r326 = r326;
        r244 = r324;
        r245 = r413;
        if (r241.equals(r171) == false) goto L612;
        r1112 = 0;
        goto L613
    L670:
        Iterator<d> r262 = r168.f400136w.iterator();
    L672:
        if (r262.hasNext() == false) goto L676;
        d r263 = r262.next();
        if ((r263 instanceof f) == false) goto L672;
        ((f) r263).h(r168.f400139z);
        goto L672
    L676:
        Iterator<vla.c> r264 = r168.f400139z.values().iterator();
    L678:
        if (r264.hasNext() == false) goto L788;
        r264.next().d();
        goto L678
    L788:
        return;
    L680:
        return;
    L475:
        r189 = false;
        goto L476
    L444:
        if (r168.f400118e != (-1)) goto L446;
        r168.f400118e = 0;
        goto L446
    L227:
        if (r100.f400137x != null) goto L229;
        r100.f400137x = new HashMap();
    L229:
        Iterator<String> r265 = r101.iterator();
    L231:
        if (r265.hasNext() == false) goto L320;
        String r266 = r265.next();
        if (r100.f400137x.containsKey(r266) == true) goto L231;
        String r267 = r317;
        if (r266.startsWith(r267) == false) goto L248;
        SparseArray r1114 = new SparseArray();
        Iterator<String> r1115 = r265;
        String r268 = r266.split(r316)[1];
        r317 = r267;
        Iterator<d> r269 = r100.f400136w.iterator();
    L239:
        if (r269.hasNext() == false) goto L247;
        Iterator<d> r332 = r269;
        d r270 = r269.next();
        HashMap<String, Integer> r271 = r104;
        HashMap<String, ConstraintAttribute> r272 = r270.f400007d;
        if (r272 == null) goto L246;
        ConstraintAttribute r273 = r272.get(r268);
        if (r273 == null) goto L246;
        r1114.append(r270.f400004a, r273);
    L246:
        r104 = r271;
        r269 = r332;
        goto L239
    L247:
        HashMap<String, Integer> r274 = r104;
        vla.e r275 = new vla.e.b(r266, r1114);
        Object r276 = r158;
        Object r277 = r217;
    L316:
        if (r275 == null) goto L319;
        r275.f546745f = r266;
        r100.f400137x.put(r266, r275);
    L319:
        r217 = r277;
        r154 = r154;
        r104 = r274;
        r158 = r276;
        r265 = r1115;
        goto L231
    L248:
        r1115 = r265;
        r274 = r104;
        r317 = r267;
        switch(r266.hashCode()) {
            case -1249320806: goto L296;
            case -1249320805: goto L292;
            case -1225497657: goto L289;
            case -1225497656: goto L285;
            case -1225497655: goto L281;
            case -1001078227: goto L277;
            case -908189618: goto L273;
            case -908189617: goto L269;
            case -40300674: goto L265;
            case -4379043: goto L261;
            case 37232917: goto L257;
            case 92909918: goto L253;
            default: goto L250;
        };
    L250:
        r276 = r158;
    L251:
        r277 = r217;
    L300:
        byte r278 = -1;
    L301:
        switch(r278) {
            case 0: goto L314;
            case 1: goto L313;
            case 2: goto L312;
            case 3: goto L311;
            case 4: goto L310;
            case 5: goto L309;
            case 6: goto L308;
            case 7: goto L307;
            case 8: goto L306;
            case 9: goto L305;
            case 10: goto L304;
            case 11: goto L303;
            default: goto L302;
        };
    L302:
        r275 = null;
        goto L316
    L303:
        r275 = new vla.e.a();
    L315:
        r275.f546748i = r511;
        goto L316
    L304:
        r275 = new vla.e.d();
        goto L315
    L305:
        r275 = new vla.e.c();
        goto L315
    L306:
        r275 = new vla.e.f();
        goto L315
    L307:
        r275 = new vla.e.j();
        goto L315
    L308:
        r275 = new vla.e.i();
        goto L315
    L309:
        r275 = new vla.e.C8020e();
        goto L315
    L310:
        r275 = new vla.e.m();
        goto L315
    L311:
        r275 = new vla.e.l();
        goto L315
    L312:
        r275 = new vla.e.k();
        goto L315
    L313:
        r275 = new vla.e.h();
        goto L315
    L314:
        r275 = new vla.e.g();
        goto L315
    L292:
        r276 = r158;
        if (r266.equals(r276) == false) goto L251;
        r277 = r217;
        r278 = 1;
        goto L301
    L296:
        r276 = r158;
        r277 = r217;
        if (r266.equals(r277) == false) goto L300;
        r278 = 0;
        goto L301
    L253:
        if (r266.equals("alpha") == false) goto L778;
        r276 = r158;
        r277 = r217;
        r278 = 11;
        goto L301
    L778:
        r276 = r158;
        goto L251
    L257:
        if (r266.equals("transitionPathRotate") == false) goto L779;
        r276 = r158;
        r277 = r217;
        r278 = 10;
        goto L301
    L779:
        r276 = r158;
        goto L251
    L261:
        if (r266.equals("elevation") == false) goto L780;
        r276 = r158;
        r277 = r217;
        r278 = 9;
        goto L301
    L780:
        r276 = r158;
        goto L251
    L265:
        if (r266.equals("rotation") == false) goto L781;
        r276 = r158;
        r277 = r217;
        r278 = 8;
        goto L301
    L781:
        r276 = r158;
        goto L251
    L269:
        if (r266.equals(r155) == false) goto L782;
        r276 = r158;
        r277 = r217;
        r278 = 7;
        goto L301
    L782:
        r276 = r158;
        goto L251
    L273:
        if (r266.equals(r153) == false) goto L783;
        r276 = r158;
        r277 = r217;
        r278 = 6;
        goto L301
    L783:
        r276 = r158;
        goto L251
    L277:
        if (r266.equals(r152) == false) goto L784;
        r276 = r158;
        r277 = r217;
        r278 = 5;
        goto L301
    L784:
        r276 = r158;
        goto L251
    L281:
        if (r266.equals(r157) == false) goto L785;
        r276 = r158;
        r277 = r217;
        r278 = 4;
        goto L301
    L785:
        r276 = r158;
        goto L251
    L285:
        if (r266.equals(r156) == false) goto L786;
        r276 = r158;
        r277 = r217;
        r278 = 3;
        goto L301
    L786:
        r276 = r158;
        goto L251
    L289:
        if (r266.equals(r154) == false) goto L787;
        r276 = r158;
        r277 = r217;
        r278 = 2;
        goto L301
    L787:
        r276 = r158;
        goto L251
    L320:
        HashMap<String, Integer> r279 = r104;
        Object r280 = r158;
        Object r281 = r217;
        Object r1116 = r154;
        ArrayList<d> r282 = r100.f400136w;
        if (r282 == null) goto L432;
        Iterator<d> r283 = r282.iterator();
    L324:
        if (r283.hasNext() == false) goto L432;
        d r284 = r283.next();
        if ((r284 instanceof j) == false) goto L431;
        j r285 = (j) r284;
        HashMap<String, vla.e> r1117 = r100.f400137x;
        r285.getClass();
        Iterator<String> r1118 = r1117.keySet().iterator();
    L329:
        if (r1118.hasNext() == false) goto L431;
        r283 = r283;
        String r286 = r1118.next();
        vla.e r421 = r1117.get(r286);
        if (r421 == null) goto L332;
        HashMap<String, vla.e> r1119 = r1117;
        if (r286.startsWith("CUSTOM") == false) goto L339;
        ConstraintAttribute r287 = r285.f400007d.get(r286.substring(7));
        if (r287 != null) goto L337;
        r1117 = r1119;
        goto L329
    L337:
        vla.e.b r1120 = (vla.e.b) r421;
        Iterator<String> r517 = r1118;
        int r1121 = r285.f400004a;
        float r288 = r285.f400072s;
        Object r289 = r281;
        int r290 = r285.f400071r;
        Object r333 = r280;
        float r291 = r285.f400073t;
        r1120.f555719l.append(r1121, r287);
        r1120.f555720m.append(r1121, new float[]{r288, r291});
        r1120.f546741b = Math.max(r1120.f546741b, r290);
        r1118 = r517;
        r1117 = r1119;
        r281 = r289;
        r280 = r333;
        r285 = r285;
        r156 = r156;
        goto L329
    L339:
        Object r334 = r280;
        Object r292 = r281;
        j r335 = r285;
        String r336 = r156;
        Iterator<String> r518 = r1118;
        switch(r286.hashCode()) {
            case -1249320806: goto L386;
            case -1249320805: goto L382;
            case -1225497657: goto L378;
            case -1225497656: goto L374;
            case -1225497655: goto L370;
            case -1001078227: goto L367;
            case -908189618: goto L363;
            case -908189617: goto L359;
            case -40300674: goto L355;
            case -4379043: goto L351;
            case 37232917: goto L347;
            case 92909918: goto L343;
            default: goto L341;
        };
    L341:
        Object r293 = r1116;
        Object r294 = r292;
        Object r295 = r334;
        String r296 = r336;
    L390:
        byte r297 = -1;
    L391:
        switch(r297) {
            case 0: goto L427;
            case 1: goto L424;
            case 2: goto L421;
            case 3: goto L418;
            case 4: goto L415;
            case 5: goto L412;
            case 6: goto L409;
            case 7: goto L406;
            case 8: goto L403;
            case 9: goto L400;
            case 10: goto L397;
            case 11: goto L393;
            default: goto L392;
        };
    L392:
        Object r337 = r295;
        Object r1122 = r294;
        j r298 = r335;
    L430:
        r1118 = r518;
        r156 = r296;
        r285 = r298;
        r281 = r1122;
        r1117 = r1119;
        r1116 = r293;
        r280 = r337;
        goto L329
    L393:
        r298 = r335;
        if (Float.isNaN(r298.f400059f) == true) goto L396;
        r1122 = r294;
        r337 = r295;
        r421.b(r298.f400004a, r298.f400059f, r298.f400072s, r298.f400071r, r298.f400073t);
        goto L430
    L396:
        r337 = r295;
        r1122 = r294;
        goto L430
    L397:
        r337 = r295;
        r1122 = r294;
        r298 = r335;
        if (Float.isNaN(r298.f400064k) == true) goto L430;
        r421.b(r298.f400004a, r298.f400064k, r298.f400072s, r298.f400071r, r298.f400073t);
        goto L430
    L400:
        r337 = r295;
        r1122 = r294;
        r298 = r335;
        if (Float.isNaN(r298.f400060g) == true) goto L430;
        r421.b(r298.f400004a, r298.f400060g, r298.f400072s, r298.f400071r, r298.f400073t);
        goto L430
    L403:
        r337 = r295;
        r1122 = r294;
        r298 = r335;
        if (Float.isNaN(r298.f400061h) == true) goto L430;
        r421.b(r298.f400004a, r298.f400061h, r298.f400072s, r298.f400071r, r298.f400073t);
        goto L430
    L406:
        r337 = r295;
        r1122 = r294;
        r298 = r335;
        if (Float.isNaN(r298.f400066m) == true) goto L430;
        r421.b(r298.f400004a, r298.f400066m, r298.f400072s, r298.f400071r, r298.f400073t);
        goto L430
    L409:
        r337 = r295;
        r1122 = r294;
        r298 = r335;
        if (Float.isNaN(r298.f400065l) == true) goto L430;
        r421.b(r298.f400004a, r298.f400065l, r298.f400072s, r298.f400071r, r298.f400073t);
        goto L430
    L412:
        r337 = r295;
        r1122 = r294;
        r298 = r335;
        if (Float.isNaN(r298.f400070q) == true) goto L430;
        r421.b(r298.f400004a, r298.f400070q, r298.f400072s, r298.f400071r, r298.f400073t);
        goto L430
    L415:
        r337 = r295;
        r1122 = r294;
        r298 = r335;
        if (Float.isNaN(r298.f400069p) == true) goto L430;
        r421.b(r298.f400004a, r298.f400069p, r298.f400072s, r298.f400071r, r298.f400073t);
        goto L430
    L418:
        r337 = r295;
        r1122 = r294;
        r298 = r335;
        if (Float.isNaN(r298.f400068o) == true) goto L430;
        r421.b(r298.f400004a, r298.f400068o, r298.f400072s, r298.f400071r, r298.f400073t);
        goto L430
    L421:
        r337 = r295;
        r1122 = r294;
        r298 = r335;
        if (Float.isNaN(r298.f400067n) == true) goto L430;
        r421.b(r298.f400004a, r298.f400067n, r298.f400072s, r298.f400071r, r298.f400073t);
        goto L430
    L424:
        r337 = r295;
        r1122 = r294;
        r298 = r335;
        if (Float.isNaN(r298.f400063j) == true) goto L430;
        r421.b(r298.f400004a, r298.f400063j, r298.f400072s, r298.f400071r, r298.f400073t);
        goto L430
    L427:
        r337 = r295;
        r1122 = r294;
        r298 = r335;
        if (Float.isNaN(r298.f400062i) == true) goto L430;
        r421.b(r298.f400004a, r298.f400062i, r298.f400072s, r298.f400071r, r298.f400073t);
        goto L430
    L370:
        r293 = r1116;
        if (r286.equals(r157) == true) goto L373;
        r296 = r336;
    L380:
        r294 = r292;
        r295 = r334;
        goto L390
    L373:
        r294 = r292;
        r295 = r334;
        r296 = r336;
        r297 = 4;
        goto L391
    L374:
        r296 = r336;
        if (r286.equals(r296) == true) goto L377;
        r293 = r1116;
        goto L380
    L377:
        r293 = r1116;
        r294 = r292;
        r295 = r334;
        r297 = 3;
        goto L391
    L378:
        r293 = r1116;
        r296 = r336;
        if (r286.equals(r293) == false) goto L380;
        r294 = r292;
        r295 = r334;
        r297 = 2;
        goto L391
    L382:
        r293 = r1116;
        r295 = r334;
        r296 = r336;
        r294 = r292;
        if (r286.equals(r295) == false) goto L390;
        r297 = 1;
        goto L391
    L386:
        r293 = r1116;
        r294 = r292;
        r295 = r334;
        r296 = r336;
        if (r286.equals(r294) == false) goto L390;
        r297 = 0;
        goto L391
    L343:
        if (r286.equals("alpha") == false) goto L341;
        r293 = r1116;
        r294 = r292;
        r295 = r334;
        r296 = r336;
        r297 = 11;
        goto L391
    L347:
        if (r286.equals("transitionPathRotate") == false) goto L341;
        r293 = r1116;
        r294 = r292;
        r295 = r334;
        r296 = r336;
        r297 = 10;
        goto L391
    L351:
        if (r286.equals("elevation") == false) goto L341;
        r293 = r1116;
        r294 = r292;
        r295 = r334;
        r296 = r336;
        r297 = 9;
        goto L391
    L355:
        if (r286.equals("rotation") == false) goto L341;
        r293 = r1116;
        r294 = r292;
        r295 = r334;
        r296 = r336;
        r297 = 8;
        goto L391
    L359:
        if (r286.equals(r155) == false) goto L341;
        r293 = r1116;
        r294 = r292;
        r295 = r334;
        r296 = r336;
        r297 = 7;
        goto L391
    L363:
        if (r286.equals(r153) == false) goto L341;
        r293 = r1116;
        r294 = r292;
        r295 = r334;
        r296 = r336;
        r297 = 6;
        goto L391
    L367:
        if (r286.equals(r152) == false) goto L341;
        r293 = r1116;
        r294 = r292;
        r295 = r334;
        r296 = r336;
        r297 = 5;
        goto L391
    L332:
        r337 = r280;
        r298 = r285;
        r296 = r156;
        r1119 = r1117;
        r518 = r1118;
        r293 = r1116;
        r1122 = r281;
    L431:
        r283 = r283;
        r156 = r156;
        r281 = r281;
        r100 = this;
        r1116 = r1116;
        r280 = r280;
    L432:
        r318 = r280;
        r169 = r156;
        r170 = r1116;
        r171 = r281;
        r168 = this;
        Iterator<String> r299 = r168.f400137x.keySet().iterator();
    L434:
        if (r299.hasNext() == false) goto L441;
        String r300 = r299.next();
        HashMap<String, Integer> r301 = r279;
        if (r301.containsKey(r300) == false) goto L438;
        int r1123 = r301.get(r300).intValue();
    L439:
        r168.f400137x.get(r300).c(r1123);
        r279 = r301;
        goto L434
    L438:
        r1123 = 0;
        goto L439
    L223:
        r315 = r102;
        r316 = ",";
        r317 = "CUSTOM,";
        r152 = r117;
        r153 = r210;
        r154 = r211;
        r155 = r215;
        r156 = r313;
        r157 = r312;
        r216 = "waveVariesBy";
        r217 = r114;
        r158 = r116;
        r159 = "waveOffset";
        goto L225
    L86:
        r312 = "translationZ";
        r215 = LiveDegradeFpsAnimator.SCALE_Y;
        r313 = LiveDegradeFpsAnimator.TRANSLATION_Y;
        r133 = null;
        goto L88
    L29:
        if (Float.isNaN(r107.f400112q) == true) goto L32;
    L24:
        if (Float.isNaN(r107.f400111p) == true) goto L27;
    L14:
        if (r106.f400097b != 0) goto L18;
        if (r109 == 0) goto L17;
        if (r111 != 0) goto L18;
    L17:
        r102.add("alpha");
        goto L18
    }

    public n(View r100) {
        this.f400114a = new Rect();
        this.f400117d = false;
        this.f400118e = -1;
        this.f400119f = new p();
        this.f400120g = new p();
        this.f400121h = new l();
        this.f400122i = new l();
        this.f400125l = Float.NaN;
        this.f400126m = 0.0f;
        this.f400127n = 1.0f;
        this.f400133t = new float[4];
        this.f400134u = new ArrayList();
        this.f400135v = new float[1];
        this.f400136w = new ArrayList();
        this.B = -1;
        this.C = -1;
        this.D = null;
        this.E = -1;
        this.F = Float.NaN;
        this.G = null;
        this.H = false;
        this.f400115b = r100;
        this.f400116c = r100.getId();
        ViewGroup.LayoutParams r101 = r100.getLayoutParams();
        if ((r101 instanceof ConstraintLayout.LayoutParams) == false) goto L6;
        ((ConstraintLayout.LayoutParams) r101).getClass();
        return;
    }

    public final void a(d r100) {
        this.f400136w.add(r100);
    }

    public final void f(p r100) {
        r100.d((int) this.f400115b.getX(), (int) this.f400115b.getY(), this.f400115b.getWidth(), this.f400115b.getHeight());
    }

    public final float b(float r110, float[] r111) {
        float r100 = 0.0f;
        float r101 = 1.0f;
        if (r111 == null) goto L5;
        r111[0] = 1.0f;
    L15:
        tla.c r102 = this.f400119f.f400141a;
        Iterator<p> r103 = this.f400134u.iterator();
        float r104 = Float.NaN;
    L17:
        if (r103.hasNext() == false) goto L26;
        p r105 = r103.next();
        tla.c r106 = r105.f400141a;
        if (r106 == null) goto L17;
        float r107 = r105.f400143c;
        if (r107 < r110) goto L22;
        if (Float.isNaN(r104) == false) goto L17;
        r104 = r105.f400143c;
        goto L17
    L22:
        r102 = r106;
        r100 = r107;
        goto L17
    L26:
        if (r102 != null) goto L28;
    L34:
        return r110;
    L28:
        if (Float.isNaN(r104) == true) goto L31;
        r101 = r104;
    L31:
        float r108 = r101 - r100;
        double r109 = (r110 - r100) / r108;
        r110 = (((float) r102.a(r109)) * r108) + r100;
        if (r111 == null) goto L34;
        r111[0] = (float) r102.b(r109);
        goto L34
    L5:
        float r112 = this.f400127n;
        if (r112 == 1.0d) goto L15;
        float r113 = this.f400126m;
        if (r110 >= r113) goto L11;
        r110 = 0.0f;
    L11:
        if (r110 <= r113) goto L15;
        if (r110 >= 1.0d) goto L15;
        r110 = Math.min((r110 - r113) * r112, 1.0f);
        goto L15
    }

    public final void c(double r210, float[] r211, float[] r212) {
        double[] r100 = new double[4];
        double[] r101 = new double[4];
        this.f400123j[0].c(r210, r100);
        this.f400123j[0].f(r210, r101);
        float r102 = 0.0f;
        Arrays.fill(r212, 0.0f);
        p r103 = this.f400119f;
        int[] r110 = this.f400128o;
        float r111 = r103.f400145e;
        float r112 = r103.f400146f;
        float r113 = r103.f400147g;
        float r114 = r103.f400148h;
        float r104 = 0.0f;
        int r115 = 0;
        float r116 = 0.0f;
        float r117 = 0.0f;
    L4:
        if (r115 >= r110.length) goto L19;
        float r105 = (float) r100[r115];
        float r106 = (float) r101[r115];
        int r107 = r110[r115];
        if (r107 != 1) goto L8;
        r111 = r105;
        r102 = r106;
    L18:
        r115 = r115 + 1;
        goto L4
    L8:
        if (r107 != 2) goto L10;
        r112 = r105;
        r104 = r106;
        goto L18
    L10:
        if (r107 != 3) goto L12;
        r113 = r105;
        r116 = r106;
        goto L18
    L12:
        if (r107 != 4) goto L18;
        r114 = r105;
        r117 = r106;
        goto L18
    L19:
        float r108 = 2.0f;
        float r118 = (r116 / 2.0f) + r102;
        float r119 = (r117 / 2.0f) + r104;
        n r109 = r103.f400153m;
        if (r109 == null) goto L22;
        float[] r120 = new float[2];
        float[] r121 = new float[2];
        r109.c(r210, r120, r121);
        float r122 = r120[0];
        float r123 = r120[1];
        float r124 = r121[0];
        float r125 = r121[1];
        double r126 = r111;
        double r127 = r112;
        float r128 = (float) ((((double) r122) + (Math.sin(r127) * r126)) - ((double) (r113 / 2.0f)));
        float r129 = (float) ((((double) r123) - (r126 * Math.cos(r127))) - ((double) (r114 / 2.0f)));
        double r130 = r102;
        double r131 = r104;
        float r132 = (float) ((((double) r124) + (Math.sin(r127) * r130)) + (Math.cos(r127) * r131));
        float r133 = (float) ((((double) r125) - (r130 * Math.cos(r127))) + (Math.sin(r127) * r131));
        r111 = r128;
        r112 = r129;
        r118 = r132;
        r119 = r133;
        r108 = 2.0f;
    L22:
        r211[0] = (r111 + (r113 / r108)) + 0.0f;
        r211[1] = (r112 + (r114 / r108)) + 0.0f;
        r212[0] = r118;
        r212[1] = r119;
    }

    public final void d(float r110, float r111, float r112, float[] r113) {
        float r114 = b(r110, this.f400135v);
        tla.b[] r100 = this.f400123j;
        int r101 = 0;
        if (r100 == null) goto L16;
        double r102 = r114;
        r100[0].f(r102, this.f400130q);
        this.f400123j[0].c(r102, this.f400129p);
        float r115 = this.f400135v[0];
    L5:
        double[] r103 = this.f400130q;
        if (r101 >= r103.length) goto L8;
        r103[r101] = r103[r101] * ((double) r115);
        r101 = r101 + 1;
        goto L5
    L8:
        tla.a r116 = this.f400124k;
        if (r116 == null) goto L14;
        double[] r104 = this.f400129p;
        if (r104.length <= 0) goto L19;
        r116.c(r102, r104);
        this.f400124k.f(r102, this.f400130q);
        p r117 = this.f400119f;
        int[] r105 = this.f400128o;
        double[] r106 = this.f400130q;
        double[] r107 = this.f400129p;
        r117.getClass();
        p.e(r111, r112, r113, r105, r106, r107);
        return;
    L19:
        return;
    L14:
        p r118 = this.f400119f;
        int[] r108 = this.f400128o;
        double[] r109 = this.f400129p;
        r118.getClass();
        p.e(r111, r112, r113, r108, r103, r109);
        return;
    L16:
        p r119 = this.f400120g;
        float r120 = r119.f400145e;
        p r121 = this.f400119f;
        float r122 = r120 - r121.f400145e;
        float r123 = r119.f400146f - r121.f400146f;
        float r124 = (r119.f400147g - r121.f400147g) + r122;
        float r125 = (r119.f400148h - r121.f400148h) + r123;
        r113[0] = (r122 * (1.0f - r111)) + (r124 * r111);
        r113[1] = (r123 * (1.0f - r112)) + (r125 * r112);
    }

    public final boolean e(View r310, float r311, long r312, tla.d r313) {
        n r100 = this;
        View r101 = r310;
        float r102 = r100.b(r311, null);
        int r103 = r100.E;
        if (r103 == (-1)) goto L15;
        float r104 = 1.0f / r103;
        float r105 = ((float) Math.floor(r102 / r104)) * r104;
        float r106 = (r102 % r104) / r104;
        if (Float.isNaN(r100.F) == true) goto L7;
        r106 = (r106 + r100.F) % 1.0f;
    L7:
        Interpolator r107 = r100.G;
        if (r107 == null) goto L11;
        float r108 = r107.getInterpolation(r106);
    L14:
        r102 = (r108 * r104) + r105;
        goto L15
    L11:
        if (r106 <= 0.5d) goto L13;
        r108 = 1.0f;
        goto L14
    L13:
        r108 = 0.0f;
    L15:
        float r110 = r102;
        HashMap<String, vla.d> r109 = r100.f400138y;
        if (r109 == null) goto L21;
        Iterator<vla.d> r111 = r109.values().iterator();
    L19:
        if (r111.hasNext() == false) goto L21;
        r111.next().d(r101, r110);
    L21:
        HashMap<String, vla.e> r112 = r100.f400137x;
        if (r112 == null) goto L30;
        Iterator<vla.e> r113 = r112.values().iterator();
        vla.e.d r114 = null;
        boolean r115 = false;
    L25:
        if (r113.hasNext() == false) goto L31;
        vla.e r116 = r113.next();
        if ((r116 instanceof vla.e.d) == true) goto L28;
        r115 = r115 | r116.e(r310, r110, r312, r313);
        goto L25
    L28:
        r114 = (vla.e.d) r116;
    L31:
        tla.b[] r117 = r100.f400123j;
        if (r117 == null) goto L158;
        double r118 = r110;
        r117[0].c(r118, r100.f400129p);
        r100.f400123j[0].f(r118, r100.f400130q);
        tla.a r119 = r100.f400124k;
        if (r119 == null) goto L39;
        double[] r120 = r100.f400129p;
        if (r120.length <= 0) goto L39;
        r119.c(r118, r120);
        r100.f400124k.f(r118, r100.f400130q);
    L39:
        if (r100.H == true) goto L108;
        p r121 = r100.f400119f;
        int[] r122 = r100.f400128o;
        double[] r123 = r100.f400129p;
        double[] r124 = r100.f400130q;
        boolean r125 = r100.f400117d;
        float r126 = r121.f400145e;
        float r127 = r121.f400146f;
        float r128 = r121.f400147g;
        float r129 = r121.f400148h;
        if (r122.length == 0) goto L45;
        float r130 = r129;
        if (r121.f400156p.length > r122[r122.length - 1]) goto L46;
        int r131 = r122[r122.length - 1] + 1;
        r121.f400156p = new double[r131];
        r121.f400157q = new double[r131];
    L46:
        Arrays.fill(r121.f400156p, Double.NaN);
        int r132 = 0;
    L48:
        if (r132 >= r122.length) goto L50;
        double[] r133 = r121.f400156p;
        int r134 = r122[r132];
        r133[r134] = r123[r132];
        r121.f400157q[r134] = r124[r132];
        r132 = r132 + 1;
        goto L48
    L50:
        float r135 = Float.NaN;
        float r136 = r127;
        float r137 = r126;
        float r138 = r130;
        float r139 = r128;
        float r140 = 0.0f;
        int r141 = 0;
        float r142 = 0.0f;
        float r143 = 0.0f;
        float r144 = 0.0f;
    L51:
        double[] r145 = r121.f400156p;
        boolean r210 = r125;
        if (r141 >= r145.length) goto L79;
        if (Double.isNaN(r145[r141]) == false) goto L56;
        float r146 = r140;
        float r211 = r136;
    L72:
        r140 = r146;
        r136 = r211;
    L78:
        r141 = r141 + 1;
        r125 = r210;
        goto L51
    L56:
        boolean r147 = Double.isNaN(r121.f400156p[r141]);
        double r212 = AudioStats.AUDIO_AMPLITUDE_NONE;
        if (r147 == true) goto L60;
        r212 = r121.f400156p[r141] + AudioStats.AUDIO_AMPLITUDE_NONE;
    L60:
        r146 = r140;
        float r148 = (float) r212;
        r211 = r136;
        r140 = (float) r121.f400157q[r141];
        if (r141 != 1) goto L63;
        r137 = r148;
        r144 = r140;
    L77:
        r136 = r211;
        r140 = r146;
        goto L78
    L63:
        if (r141 != 2) goto L65;
        r136 = r148;
        goto L78
    L65:
        if (r141 != 3) goto L67;
        r139 = r148;
        r142 = r140;
        goto L77
    L67:
        if (r141 != 4) goto L69;
        r138 = r148;
        r143 = r140;
        goto L77
    L69:
        if (r141 != 5) goto L72;
        r135 = r148;
        goto L72
    L79:
        float r149 = r140;
        float r213 = r136;
        n r150 = r121.f400153m;
        if (r150 == null) goto L89;
        float[] r151 = new float[2];
        float[] r152 = new float[2];
        r150.c(r118, r151, r152);
        float r153 = r151[0];
        float r154 = r151[1];
        float r155 = r152[0];
        float r156 = r152[1];
        double r214 = r118;
        double r157 = r137;
        float r215 = r135;
        double r158 = r213;
        float r216 = r139;
        float r159 = (float) ((((double) r153) + (Math.sin(r158) * r157)) - ((double) (r139 / 2.0f)));
        float r160 = (float) ((((double) r154) - (Math.cos(r158) * r157)) - ((double) (r138 / 2.0f)));
        double r161 = r155;
        double r162 = r144;
        double r163 = r149;
        float r164 = (float) ((r161 + (Math.sin(r158) * r162)) + ((Math.cos(r158) * r157) * r163));
        float r165 = (float) ((((double) r156) - (r162 * Math.cos(r158))) + ((r157 * Math.sin(r158)) * r163));
        if (r124.length < 2) goto L85;
        r124[0] = r164;
        r124[1] = r165;
    L85:
        if (Float.isNaN(r215) == true) goto L87;
        r101 = r310;
        r101.setRotation((float) (((double) r215) + Math.toDegrees(Math.atan2(r165, r164))));
    L88:
        float r166 = r160;
        r137 = r159;
    L93:
        if ((r101 instanceof c) == false) goto L96;
        ((c) r101).a(r137, r166, r216 + r137, r138 + r166);
    L95:
        r100 = this;
        r100.f400117d = false;
    L110:
        if (r100.C != (-1)) goto L112;
    L121:
        HashMap<String, vla.d> r167 = r100.f400138y;
        if (r167 == null) goto L133;
        Iterator<vla.d> r168 = r167.values().iterator();
    L125:
        if (r168.hasNext() == false) goto L133;
        vla.d r169 = r168.next();
        if ((r169 instanceof vla.d.C8019d) == false) goto L131;
        double[] r170 = r100.f400130q;
        if (r170.length <= 1) goto L131;
        double r171 = r170[0];
        float r172 = r110;
        r101.setRotation(((vla.d.C8019d) r169).a(r172) + ((float) Math.toDegrees(Math.atan2(r170[1], r171))));
    L132:
        r110 = r172;
    L131:
        r172 = r110;
    L133:
        float r173 = r110;
        if (r114 == 0) goto L136;
        double[] r174 = r100.f400130q;
        double r175 = r174[0];
        r101.setRotation(r114.d(r173, r312, r310, r313) + ((float) Math.toDegrees(Math.atan2(r174[1], r175))));
        boolean r176 = r115 | r114.f546747h;
    L137:
        int r177 = 1;
    L138:
        tla.b[] r178 = r100.f400123j;
        if (r177 >= r178.length) goto L141;
        r178[r177].d(r214, r100.f400133t);
        vla.a.b(r100.f400119f.f400154n.get(r100.f400131r[r177 - 1]), r101, r100.f400133t);
        r177 = r177 + 1;
        goto L138
    L141:
        l r179 = r100.f400121h;
        if (r179.f400097b != 0) goto L153;
        if (r173 > 0.0f) goto L147;
        r101.setVisibility(r179.f400098c);
        goto L153
    L147:
        if (r173 < 1.0f) goto L150;
        r101.setVisibility(r100.f400122i.f400098c);
        goto L153
    L150:
        if (r100.f400122i.f400098c == r179.f400098c) goto L153;
        r101.setVisibility(0);
    L153:
        if (r100.A == null) goto L166;
        int r180 = 0;
    L155:
        k[] r181 = r100.A;
        if (r180 >= r181.length) goto L166;
        r181[r180].h(r173, r101);
        r180 = r180 + 1;
    L166:
        HashMap<String, vla.c> r182 = r100.f400139z;
        if (r182 == null) goto L175;
        Iterator<vla.c> r183 = r182.values().iterator();
    L170:
        if (r183.hasNext() == false) goto L175;
        vla.c r184 = r183.next();
        if ((r184 instanceof vla.c.d) == true) goto L173;
        r184.e(r101, r173);
        goto L170
    L173:
        double[] r185 = r100.f400130q;
        double r186 = r185[0];
        r101.setRotation(((vla.c.d) r184).a(r173) + ((float) Math.toDegrees(Math.atan2(r185[1], r186))));
    L175:
        return r176;
    L136:
        r176 = r115;
        goto L137
    L112:
        if (r100.D != null) goto L114;
        r100.D = ((View) r310.getParent()).findViewById(r100.C);
    L114:
        View r187 = r100.D;
        if (r187 == null) goto L121;
        float r188 = (r187.getTop() + r100.D.getBottom()) / 2.0f;
        float r189 = (r100.D.getLeft() + r100.D.getRight()) / 2.0f;
        if ((r310.getRight() - r310.getLeft()) <= 0) goto L121;
        if ((r310.getBottom() - r310.getTop()) <= 0) goto L121;
        float r190 = r189 - r310.getLeft();
        float r191 = r188 - r310.getTop();
        r101.setPivotX(r190);
        r101.setPivotY(r191);
        goto L121
    L96:
        float r192 = r137 + 0.5f;
        int r193 = (int) r192;
        float r194 = r166 + 0.5f;
        int r195 = (int) r194;
        int r196 = (int) (r192 + r216);
        int r197 = (int) (r194 + r138);
        int r198 = r196 - r193;
        int r199 = r197 - r195;
        if (r198 == r310.getMeasuredWidth()) goto L99;
    L102:
        boolean r200 = true;
    L103:
        if (r200 == true) goto L105;
        if (r210 == true) goto L105;
    L106:
        r101.layout(r193, r195, r196, r197);
    L105:
        r101.measure(View.MeasureSpec.makeMeasureSpec(r198, 1073741824), View.MeasureSpec.makeMeasureSpec(r199, 1073741824));
        goto L106
    L99:
        if (r199 != r310.getMeasuredHeight()) goto L102;
        r200 = false;
        goto L103
    L87:
        r101 = r310;
        goto L88
    L89:
        r214 = r118;
        r216 = r139;
        r166 = r213;
        if (Float.isNaN(r135) == true) goto L93;
        r101.setRotation((((float) Math.toDegrees(Math.atan2(r149 + (r143 / 2.0f), r144 + (r142 / 2.0f)))) + r135) + 0.0f);
        goto L93
    L45:
        r130 = r129;
        goto L46
    L108:
        r214 = r118;
        goto L110
    L158:
        r173 = r110;
        boolean r1100 = r115;
        p r201 = r100.f400119f;
        float r202 = r201.f400145e;
        p r203 = r100.f400120g;
        float r204 = r202 + ((r203.f400145e - r202) * r173);
        float r205 = r201.f400146f;
        float r206 = r205 + ((r203.f400146f - r205) * r173);
        float r207 = r201.f400147g;
        float r208 = r203.f400147g;
        float r209 = r201.f400148h;
        float r217 = r203.f400148h;
        float r218 = r204 + 0.5f;
        int r1101 = (int) r218;
        float r219 = r206 + 0.5f;
        int r1102 = (int) r219;
        int r220 = (int) (r218 + (((r208 - r207) * r173) + r207));
        int r221 = (int) (r219 + (((r217 - r209) * r173) + r209));
        int r222 = r220 - r1101;
        int r223 = r221 - r1102;
        if (r208 == r207) goto L161;
    L164:
        r101.measure(View.MeasureSpec.makeMeasureSpec(r222, 1073741824), View.MeasureSpec.makeMeasureSpec(r223, 1073741824));
        r100.f400117d = false;
    L165:
        r101.layout(r1101, r1102, r220, r221);
        r176 = r1100;
        goto L166
    L161:
        if (r217 != r209) goto L164;
        if (r100.f400117d == false) goto L165;
    L30:
        r114 = null;
        r115 = false;
        goto L31
    }

    public static void g(Rect r100, Rect r101, int r102, int r103, int r104) {
        if (r102 == 1) goto L13;
        if (r102 != 2) goto L6;
        int r105 = r100.left + r100.right;
        r101.left = r103 - (((r100.top + r100.bottom) + r100.width()) / 2);
        r101.top = (r105 - r100.height()) / 2;
        r101.right = r101.left + r100.width();
        r101.bottom = r101.top + r100.height();
        return;
    L6:
        if (r102 != 3) goto L8;
        int r106 = r100.left + r100.right;
        r101.left = ((r100.height() / 2) + r100.top) - (r106 / 2);
        r101.top = r104 - ((r106 + r100.height()) / 2);
        r101.right = r101.left + r100.width();
        r101.bottom = r101.top + r100.height();
        return;
    L8:
        if (r102 != 4) goto L18;
        int r107 = r100.left + r100.right;
        r101.left = r103 - (((r100.bottom + r100.top) + r100.width()) / 2);
        r101.top = (r107 - r100.height()) / 2;
        r101.right = r101.left + r100.width();
        r101.bottom = r101.top + r100.height();
        return;
    L18:
        return;
    L13:
        int r108 = r100.left + r100.right;
        r101.left = ((r100.top + r100.bottom) - r100.width()) / 2;
        r101.top = r104 - ((r108 + r100.height()) / 2);
        r101.right = r101.left + r100.width();
        r101.bottom = r101.top + r100.height();
    }
}
