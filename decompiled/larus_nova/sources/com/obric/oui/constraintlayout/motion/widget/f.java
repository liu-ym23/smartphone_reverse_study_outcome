package com.obric.oui.constraintlayout.motion.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.obric.oui.constraintlayout.widget.ConstraintAttribute;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes34.dex */
public final class f extends d {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f400024e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f400025f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f400026g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f400027h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f400028i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f400029j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f400030k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f400031l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f400032m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f400033n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f400034o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f400035p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f400036q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public float f400037r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public float f400038s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public float f400039t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public float f400040u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public float f400041v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public float f400042w;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final SparseIntArray f400043a = null;

        static {
            SparseIntArray r100 = new SparseIntArray();
            f400043a = r100;
            r100.append(13, 1);
            r100.append(11, 2);
            r100.append(14, 3);
            r100.append(10, 4);
            r100.append(19, 5);
            r100.append(17, 6);
            r100.append(16, 7);
            r100.append(20, 8);
            r100.append(0, 9);
            r100.append(9, 10);
            r100.append(5, 11);
            r100.append(6, 12);
            r100.append(7, 13);
            r100.append(15, 14);
            r100.append(3, 15);
            r100.append(4, 16);
            r100.append(1, 17);
            r100.append(2, 18);
            r100.append(8, 19);
            r100.append(12, 20);
            r100.append(18, 21);
        }
    }

    @Override // com.obric.oui.constraintlayout.motion.widget.d
    public final d b() {
        f r100 = new f();
        super.c(this);
        r100.f400024e = this.f400024e;
        r100.f400025f = this.f400025f;
        r100.f400026g = this.f400026g;
        r100.f400027h = this.f400027h;
        r100.f400028i = this.f400028i;
        r100.f400029j = this.f400029j;
        r100.f400030k = this.f400030k;
        r100.f400031l = this.f400031l;
        r100.f400032m = this.f400032m;
        r100.f400033n = this.f400033n;
        r100.f400034o = this.f400034o;
        r100.f400035p = this.f400035p;
        r100.f400036q = this.f400036q;
        r100.f400037r = this.f400037r;
        r100.f400038s = this.f400038s;
        r100.f400039t = this.f400039t;
        r100.f400040u = this.f400040u;
        r100.f400041v = this.f400041v;
        r100.f400042w = this.f400042w;
        return r100;
    }

    public f() {
        this.f400024e = 0;
        this.f400025f = -1;
        this.f400026g = null;
        this.f400027h = Float.NaN;
        this.f400028i = 0.0f;
        this.f400029j = 0.0f;
        this.f400030k = Float.NaN;
        this.f400031l = -1;
        this.f400032m = Float.NaN;
        this.f400033n = Float.NaN;
        this.f400034o = Float.NaN;
        this.f400035p = Float.NaN;
        this.f400036q = Float.NaN;
        this.f400037r = Float.NaN;
        this.f400038s = Float.NaN;
        this.f400039t = Float.NaN;
        this.f400040u = Float.NaN;
        this.f400041v = Float.NaN;
        this.f400042w = Float.NaN;
        this.f400007d = new HashMap();
    }

    @Override // com.obric.oui.constraintlayout.motion.widget.d
    public final /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
        return b();
    }

    @Override // com.obric.oui.constraintlayout.motion.widget.d
    public final void a(HashMap<String, vla.d> r110) {
        r110.size();
        StackTraceElement[] r100 = new Throwable().getStackTrace();
        int r101 = Math.min(2, r100.length - 1);
        String r102 = " ";
        int r103 = 1;
    L3:
        if (r103 > r101) goto L5;
        r100[r103].getFileName();
        r100[r103].getLineNumber();
        r100[r103].getMethodName();
        r102 = r102 + " ";
        r103 = r103 + 1;
        goto L3
    L5:
        Iterator<String> r104 = r110.keySet().iterator();
    L7:
        if (r104.hasNext() == false) goto L88;
        String r105 = r104.next();
        vla.d r106 = r110.get(r105);
        if (r106 == null) goto L7;
        r105.getClass();
        byte r107 = -1;
        switch(r105.hashCode()) {
            case -1249320806: goto L67;
            case -1249320805: goto L63;
            case -1225497657: goto L59;
            case -1225497656: goto L55;
            case -1225497655: goto L51;
            case -1001078227: goto L47;
            case -908189618: goto L43;
            case -908189617: goto L39;
            case -40300674: goto L35;
            case -4379043: goto L31;
            case 37232917: goto L27;
            case 92909918: goto L23;
            case 156108012: goto L19;
            case 1530034690: goto L15;
            default: goto L70;
        };
    L70:
        switch(r107) {
            case 0: goto L87;
            case 1: goto L86;
            case 2: goto L85;
            case 3: goto L84;
            case 4: goto L83;
            case 5: goto L82;
            case 6: goto L81;
            case 7: goto L80;
            case 8: goto L79;
            case 9: goto L78;
            case 10: goto L77;
            case 11: goto L76;
            case 12: goto L75;
            case 13: goto L74;
            default: goto L72;
        };
    L74:
        r106.b(this.f400004a, this.f400029j);
        goto L7
    L75:
        r106.b(this.f400004a, this.f400028i);
        goto L7
    L76:
        r106.b(this.f400004a, this.f400032m);
        goto L7
    L77:
        r106.b(this.f400004a, this.f400035p);
        goto L7
    L78:
        r106.b(this.f400004a, this.f400033n);
        goto L7
    L79:
        r106.b(this.f400004a, this.f400034o);
        goto L7
    L80:
        r106.b(this.f400004a, this.f400039t);
        goto L7
    L81:
        r106.b(this.f400004a, this.f400038s);
        goto L7
    L82:
        r106.b(this.f400004a, this.f400030k);
        goto L7
    L83:
        r106.b(this.f400004a, this.f400042w);
        goto L7
    L84:
        r106.b(this.f400004a, this.f400041v);
        goto L7
    L85:
        r106.b(this.f400004a, this.f400040u);
        goto L7
    L86:
        r106.b(this.f400004a, this.f400037r);
        goto L7
    L87:
        r106.b(this.f400004a, this.f400036q);
        goto L7
    L72:
        if (r105.startsWith("CUSTOM") == true) goto L7;
        goto L7
    L15:
        if (r105.equals("wavePhase") == false) goto L70;
        r107 = HTTP.CR;
        goto L70
    L19:
        if (r105.equals("waveOffset") == false) goto L70;
        r107 = 12;
        goto L70
    L23:
        if (r105.equals("alpha") == false) goto L70;
        r107 = 11;
        goto L70
    L27:
        if (r105.equals("transitionPathRotate") == false) goto L70;
        r107 = 10;
        goto L70
    L31:
        if (r105.equals("elevation") == false) goto L70;
        r107 = 9;
        goto L70
    L35:
        if (r105.equals("rotation") == false) goto L70;
        r107 = 8;
        goto L70
    L39:
        if (r105.equals(LiveDegradeFpsAnimator.SCALE_Y) == false) goto L70;
        r107 = 7;
        goto L70
    L43:
        if (r105.equals(LiveDegradeFpsAnimator.SCALE_X) == false) goto L70;
        r107 = 6;
        goto L70
    L47:
        if (r105.equals("progress") == false) goto L70;
        r107 = 5;
        goto L70
    L51:
        if (r105.equals("translationZ") == false) goto L70;
        r107 = 4;
        goto L70
    L55:
        if (r105.equals(LiveDegradeFpsAnimator.TRANSLATION_Y) == false) goto L70;
        r107 = 3;
        goto L70
    L59:
        if (r105.equals(LiveDegradeFpsAnimator.TRANSLATION_X) == false) goto L70;
        r107 = 2;
        goto L70
    L63:
        if (r105.equals("rotationY") == false) goto L70;
        r107 = 1;
        goto L70
    L67:
        if (r105.equals("rotationX") == false) goto L70;
        r107 = 0;
        goto L70
    }

    @Override // com.obric.oui.constraintlayout.motion.widget.d
    public final void d(HashSet<String> r100) {
        if (Float.isNaN(this.f400032m) == true) goto L6;
        r100.add("alpha");
    L6:
        if (Float.isNaN(this.f400033n) == true) goto L9;
        r100.add("elevation");
    L9:
        if (Float.isNaN(this.f400034o) == true) goto L12;
        r100.add("rotation");
    L12:
        if (Float.isNaN(this.f400036q) == true) goto L15;
        r100.add("rotationX");
    L15:
        if (Float.isNaN(this.f400037r) == true) goto L18;
        r100.add("rotationY");
    L18:
        if (Float.isNaN(this.f400038s) == true) goto L21;
        r100.add(LiveDegradeFpsAnimator.SCALE_X);
    L21:
        if (Float.isNaN(this.f400039t) == true) goto L24;
        r100.add(LiveDegradeFpsAnimator.SCALE_Y);
    L24:
        if (Float.isNaN(this.f400035p) == true) goto L27;
        r100.add("transitionPathRotate");
    L27:
        if (Float.isNaN(this.f400040u) == true) goto L30;
        r100.add(LiveDegradeFpsAnimator.TRANSLATION_X);
    L30:
        if (Float.isNaN(this.f400041v) == true) goto L33;
        r100.add(LiveDegradeFpsAnimator.TRANSLATION_Y);
    L33:
        if (Float.isNaN(this.f400042w) == true) goto L36;
        r100.add("translationZ");
    L36:
        if (this.f400007d.size() <= 0) goto L41;
        Iterator<String> r101 = this.f400007d.keySet().iterator();
    L39:
        if (r101.hasNext() == false) goto L43;
        r100.add("CUSTOM," + r101.next());
        goto L39
    L43:
        return;
    }

    public final void h(HashMap<String, vla.c> r110) {
        Iterator<String> r100 = r110.keySet().iterator();
    L4:
        if (r100.hasNext() == false) goto L108;
        String r101 = r100.next();
        byte r102 = 7;
        if (r101.startsWith("CUSTOM") == true) goto L7;
        switch(r101.hashCode()) {
            case -1249320806: goto L74;
            case -1249320805: goto L70;
            case -1225497657: goto L66;
            case -1225497656: goto L62;
            case -1225497655: goto L58;
            case -1001078227: goto L54;
            case -908189618: goto L50;
            case -908189617: goto L47;
            case -40300674: goto L43;
            case -4379043: goto L39;
            case 37232917: goto L35;
            case 92909918: goto L31;
            case 156108012: goto L27;
            case 1530034690: goto L23;
            default: goto L77;
        };
    L77:
        r102 = -1;
    L78:
        switch(r102) {
            case 0: goto L95;
            case 1: goto L94;
            case 2: goto L93;
            case 3: goto L92;
            case 4: goto L91;
            case 5: goto L90;
            case 6: goto L89;
            case 7: goto L88;
            case 8: goto L87;
            case 9: goto L86;
            case 10: goto L85;
            case 11: goto L84;
            case 12: goto L83;
            case 13: goto L82;
            default: goto L80;
        };
    L82:
        float r103 = this.f400029j;
    L96:
        float r111 = r103;
    L99:
        if (Float.isNaN(r111) == true) goto L4;
        vla.c r104 = r110.get(r101);
        if (r104 == null) goto L4;
        int r105 = this.f400004a;
        int r106 = this.f400025f;
        String r107 = this.f400026g;
        int r112 = this.f400031l;
        float r108 = this.f400027h;
        float r113 = this.f400028i;
        float r114 = this.f400029j;
        r104.f546682f.add(new tla.f.b(r105, r108, r113, r114, r111));
        if (r112 == (-1)) goto L107;
        r104.f546681e = r112;
    L107:
        r104.f546679c = r106;
        r104.f546680d = r107;
        goto L4
    L83:
        r103 = this.f400028i;
        goto L96
    L84:
        r103 = this.f400032m;
        goto L96
    L85:
        r103 = this.f400035p;
        goto L96
    L86:
        r103 = this.f400033n;
        goto L96
    L87:
        r103 = this.f400034o;
        goto L96
    L88:
        r103 = this.f400039t;
        goto L96
    L89:
        r103 = this.f400038s;
        goto L96
    L90:
        r103 = this.f400030k;
        goto L96
    L91:
        r103 = this.f400042w;
        goto L96
    L92:
        r103 = this.f400041v;
        goto L96
    L93:
        r103 = this.f400040u;
        goto L96
    L94:
        r103 = this.f400037r;
        goto L96
    L95:
        r103 = this.f400036q;
        goto L96
    L80:
        if (r101.startsWith("CUSTOM") == false) goto L97;
    L97:
        r111 = Float.NaN;
        goto L99
    L23:
        if (r101.equals("wavePhase") == false) goto L77;
        r102 = HTTP.CR;
        goto L78
    L27:
        if (r101.equals("waveOffset") == false) goto L77;
        r102 = 12;
        goto L78
    L31:
        if (r101.equals("alpha") == false) goto L77;
        r102 = 11;
        goto L78
    L35:
        if (r101.equals("transitionPathRotate") == false) goto L77;
        r102 = 10;
        goto L78
    L39:
        if (r101.equals("elevation") == false) goto L77;
        r102 = 9;
        goto L78
    L43:
        if (r101.equals("rotation") == false) goto L77;
        r102 = 8;
        goto L78
    L47:
        if (r101.equals(LiveDegradeFpsAnimator.SCALE_Y) == true) goto L78;
    L50:
        if (r101.equals(LiveDegradeFpsAnimator.SCALE_X) == false) goto L77;
        r102 = 6;
        goto L78
    L54:
        if (r101.equals("progress") == false) goto L77;
        r102 = 5;
        goto L78
    L58:
        if (r101.equals("translationZ") == false) goto L77;
        r102 = 4;
        goto L78
    L62:
        if (r101.equals(LiveDegradeFpsAnimator.TRANSLATION_Y) == false) goto L77;
        r102 = 3;
        goto L78
    L66:
        if (r101.equals(LiveDegradeFpsAnimator.TRANSLATION_X) == false) goto L77;
        r102 = 2;
        goto L78
    L70:
        if (r101.equals("rotationY") == false) goto L77;
        r102 = 1;
        goto L78
    L74:
        if (r101.equals("rotationX") == false) goto L77;
        r102 = 0;
        goto L78
    L7:
        String r109 = r101.substring(7);
        ConstraintAttribute r115 = this.f400007d.get(r109);
        if (r115 == null) goto L4;
        if (r115.getType() != ConstraintAttribute.AttributeType.FLOAT_TYPE) goto L4;
        vla.c r116 = r110.get(r101);
        if (r116 == null) goto L4;
        int r117 = this.f400004a;
        int r118 = this.f400025f;
        String r119 = this.f400026g;
        int r120 = this.f400031l;
        float r121 = this.f400027h;
        float r122 = this.f400028i;
        float r123 = this.f400029j;
        float r124 = r115.a();
        r116.f546682f.add(new tla.f.b(r117, r121, r122, r123, r124));
        if (r120 == (-1)) goto L18;
        r116.f546681e = r120;
    L18:
        r116.f546679c = r118;
        r116.c(r115);
        r116.f546680d = r119;
        goto L4
    }

    @Override // com.obric.oui.constraintlayout.motion.widget.d
    public final void e(Context r100, AttributeSet r101) {
        TypedArray r102 = r100.obtainStyledAttributes(r101, new int[]{R.attr.alpha, R.attr.translationX, R.attr.translationY, R.attr.scaleX, R.attr.scaleY, R.attr.rotation, R.attr.rotationX, R.attr.rotationY, R.attr.translationZ, R.attr.elevation, com.larus.nova.R.attr.curveFit, com.larus.nova.R.attr.framePosition, com.larus.nova.R.attr.motionProgress, com.larus.nova.R.attr.motionTarget, com.larus.nova.R.attr.transitionEasing, com.larus.nova.R.attr.transitionPathRotate, com.larus.nova.R.attr.waveOffset, com.larus.nova.R.attr.wavePeriod, com.larus.nova.R.attr.wavePhase, com.larus.nova.R.attr.waveShape, com.larus.nova.R.attr.waveVariesBy});
        SparseIntArray r103 = a.f400043a;
        int r104 = r102.getIndexCount();
        int r105 = 0;
    L3:
        if (r105 >= r104) goto L43;
        int r106 = r102.getIndex(r105);
        SparseIntArray r107 = a.f400043a;
        switch(r107.get(r106)) {
            case 1: goto L34;
            case 2: goto L32;
            case 3: goto L31;
            case 4: goto L30;
            case 5: goto L27;
            case 6: goto L25;
            case 7: goto L22;
            case 8: goto L20;
            case 9: goto L19;
            case 10: goto L18;
            case 11: goto L17;
            case 12: goto L16;
            case 13: goto L15;
            case 14: goto L14;
            case 15: goto L13;
            case 16: goto L12;
            case 17: goto L11;
            case 18: goto L10;
            case 19: goto L9;
            case 20: goto L8;
            case 21: goto L7;
            default: goto L6;
        };
    L6:
        Integer.toHexString(r106);
        r107.get(r106);
    L42:
        r105 = r105 + 1;
        goto L3
    L7:
        this.f400029j = r102.getFloat(r106, this.f400029j) / 360.0f;
        goto L42
    L8:
        this.f400030k = r102.getFloat(r106, this.f400030k);
        goto L42
    L9:
        this.f400042w = r102.getDimension(r106, this.f400042w);
        goto L42
    L10:
        this.f400041v = r102.getDimension(r106, this.f400041v);
        goto L42
    L11:
        this.f400040u = r102.getDimension(r106, this.f400040u);
        goto L42
    L12:
        this.f400039t = r102.getFloat(r106, this.f400039t);
        goto L42
    L13:
        this.f400038s = r102.getFloat(r106, this.f400038s);
        goto L42
    L14:
        this.f400035p = r102.getFloat(r106, this.f400035p);
        goto L42
    L15:
        this.f400037r = r102.getFloat(r106, this.f400037r);
        goto L42
    L16:
        this.f400036q = r102.getFloat(r106, this.f400036q);
        goto L42
    L17:
        this.f400034o = r102.getFloat(r106, this.f400034o);
        goto L42
    L18:
        this.f400033n = r102.getDimension(r106, this.f400033n);
        goto L42
    L19:
        this.f400032m = r102.getFloat(r106, this.f400032m);
        goto L42
    L20:
        this.f400031l = r102.getInt(r106, this.f400031l);
        goto L42
    L25:
        this.f400027h = r102.getFloat(r106, this.f400027h);
        goto L42
    L30:
        this.f400024e = r102.getInteger(r106, this.f400024e);
        goto L42
    L31:
        r102.getString(r106);
        goto L42
    L32:
        this.f400004a = r102.getInt(r106, this.f400004a);
        goto L42
    L22:
        if (r102.peekValue(r106).type != 5) goto L24;
        this.f400028i = r102.getDimension(r106, this.f400028i);
        goto L42
    L24:
        this.f400028i = r102.getFloat(r106, this.f400028i);
        goto L42
    L27:
        if (r102.peekValue(r106).type != 3) goto L29;
        this.f400026g = r102.getString(r106);
        this.f400025f = 7;
        goto L42
    L29:
        this.f400025f = r102.getInt(r106, this.f400025f);
        goto L42
    L34:
        if (MotionLayout.F2 == false) goto L39;
        int r108 = r102.getResourceId(r106, this.f400005b);
        this.f400005b = r108;
        if (r108 != (-1)) goto L42;
        this.f400006c = r102.getString(r106);
        goto L42
    L39:
        if (r102.peekValue(r106).type != 3) goto L41;
        this.f400006c = r102.getString(r106);
        goto L42
    L41:
        this.f400005b = r102.getResourceId(r106, this.f400005b);
        goto L42
    }
}
