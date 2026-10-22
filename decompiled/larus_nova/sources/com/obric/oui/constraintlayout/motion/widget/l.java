package com.obric.oui.constraintlayout.motion.widget;

import android.graphics.Rect;
import android.view.View;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.obric.oui.constraintlayout.widget.ConstraintAttribute;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes34.dex */
public final class l implements Comparable<l> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f400096a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f400097b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f400098c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LinkedHashMap<String, ConstraintAttribute> f400099d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f400100e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f400101f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f400102g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f400103h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f400104i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f400105j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f400106k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f400107l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f400108m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f400109n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f400110o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f400111p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f400112q;

    static {
        new String[]{"position", "x", "y", "width", "height", "pathRotate"};
    }

    public l() {
        this.f400096a = 0.0f;
        this.f400097b = 0;
        this.f400099d = new LinkedHashMap();
        this.f400100e = 1.0f;
        this.f400101f = 0.0f;
        this.f400102g = 0.0f;
        this.f400103h = 0.0f;
        this.f400104i = 1.0f;
        this.f400105j = 1.0f;
        this.f400106k = Float.NaN;
        this.f400107l = Float.NaN;
        this.f400108m = 0.0f;
        this.f400109n = 0.0f;
        this.f400110o = 0.0f;
        this.f400111p = Float.NaN;
        this.f400112q = Float.NaN;
    }

    public final void b(View r100) {
        this.f400098c = r100.getVisibility();
        if (r100.getVisibility() == 0) goto L5;
        float r101 = 0.0f;
    L6:
        this.f400100e = r101;
        this.f400101f = r100.getElevation();
        this.f400102g = r100.getRotation();
        this.f400103h = r100.getRotationX();
        this.f400096a = r100.getRotationY();
        this.f400104i = r100.getScaleX();
        this.f400105j = r100.getScaleY();
        this.f400106k = r100.getPivotX();
        this.f400107l = r100.getPivotY();
        this.f400108m = r100.getTranslationX();
        this.f400109n = r100.getTranslationY();
        this.f400110o = r100.getTranslationZ();
        return;
    L5:
        r101 = r100.getAlpha();
        goto L6
    }

    @Override // java.lang.Comparable
    public final int compareTo(l r100) {
        r100.getClass();
        return Float.compare(0.0f, 0.0f);
    }

    public static boolean c(float r100, float r101) {
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

    public final void a(HashMap<String, vla.d> r100, int r101) {
        Iterator<String> r102 = r100.keySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L150;
        String r103 = r102.next();
        vla.d r104 = r100.get(r103);
        if (r104 == null) goto L4;
        r103.getClass();
        switch(r103.hashCode()) {
            case -1249320806: goto L64;
            case -1249320805: goto L60;
            case -1225497657: goto L56;
            case -1225497656: goto L52;
            case -1225497655: goto L48;
            case -1001078227: goto L44;
            case -908189618: goto L40;
            case -908189617: goto L36;
            case -760884510: goto L32;
            case -760884509: goto L28;
            case -40300674: goto L24;
            case -4379043: goto L20;
            case 37232917: goto L16;
            case 92909918: goto L12;
            default: goto L67;
        };
    L67:
        byte r105 = -1;
    L68:
        float r106 = 1.0f;
        float r107 = 0.0f;
        switch(r105) {
            case 0: goto L143;
            case 1: goto L138;
            case 2: goto L133;
            case 3: goto L128;
            case 4: goto L123;
            case 5: goto L118;
            case 6: goto L113;
            case 7: goto L108;
            case 8: goto L103;
            case 9: goto L98;
            case 10: goto L93;
            case 11: goto L88;
            case 12: goto L83;
            case 13: goto L78;
            default: goto L71;
        };
    L78:
        if (Float.isNaN(this.f400100e) == true) goto L81;
        r106 = this.f400100e;
    L81:
        r104.b(r101, r106);
        goto L4
    L83:
        if (Float.isNaN(this.f400111p) == true) goto L86;
        r107 = this.f400111p;
    L86:
        r104.b(r101, r107);
        goto L4
    L88:
        if (Float.isNaN(this.f400101f) == true) goto L91;
        r107 = this.f400101f;
    L91:
        r104.b(r101, r107);
        goto L4
    L93:
        if (Float.isNaN(this.f400102g) == true) goto L96;
        r107 = this.f400102g;
    L96:
        r104.b(r101, r107);
        goto L4
    L98:
        if (Float.isNaN(this.f400107l) == true) goto L101;
        r107 = this.f400107l;
    L101:
        r104.b(r101, r107);
        goto L4
    L103:
        if (Float.isNaN(this.f400106k) == true) goto L106;
        r107 = this.f400106k;
    L106:
        r104.b(r101, r107);
        goto L4
    L108:
        if (Float.isNaN(this.f400105j) == true) goto L111;
        r106 = this.f400105j;
    L111:
        r104.b(r101, r106);
        goto L4
    L113:
        if (Float.isNaN(this.f400104i) == true) goto L116;
        r106 = this.f400104i;
    L116:
        r104.b(r101, r106);
        goto L4
    L118:
        if (Float.isNaN(this.f400112q) == true) goto L121;
        r107 = this.f400112q;
    L121:
        r104.b(r101, r107);
        goto L4
    L123:
        if (Float.isNaN(this.f400110o) == true) goto L126;
        r107 = this.f400110o;
    L126:
        r104.b(r101, r107);
        goto L4
    L128:
        if (Float.isNaN(this.f400109n) == true) goto L131;
        r107 = this.f400109n;
    L131:
        r104.b(r101, r107);
        goto L4
    L133:
        if (Float.isNaN(this.f400108m) == true) goto L136;
        r107 = this.f400108m;
    L136:
        r104.b(r101, r107);
        goto L4
    L138:
        if (Float.isNaN(this.f400096a) == true) goto L141;
        r107 = this.f400096a;
    L141:
        r104.b(r101, r107);
        goto L4
    L143:
        if (Float.isNaN(this.f400103h) == true) goto L146;
        r107 = this.f400103h;
    L146:
        r104.b(r101, r107);
        goto L4
    L71:
        if (r103.startsWith("CUSTOM") == false) goto L4;
        String r108 = r103.split(",")[1];
        if (this.f400099d.containsKey(r108) == false) goto L4;
        ConstraintAttribute r109 = this.f400099d.get(r108);
        if ((r104 instanceof vla.d.b) == true) goto L147;
        r109.a();
        r104.toString();
        goto L4
    L147:
        ((vla.d.b) r104).f555715f.append(r101, r109);
        goto L4
    L12:
        if (r103.equals("alpha") == false) goto L67;
        r105 = HTTP.CR;
        goto L68
    L16:
        if (r103.equals("transitionPathRotate") == false) goto L67;
        r105 = 12;
        goto L68
    L20:
        if (r103.equals("elevation") == false) goto L67;
        r105 = 11;
        goto L68
    L24:
        if (r103.equals("rotation") == false) goto L67;
        r105 = 10;
        goto L68
    L28:
        if (r103.equals("transformPivotY") == false) goto L67;
        r105 = 9;
        goto L68
    L32:
        if (r103.equals("transformPivotX") == false) goto L67;
        r105 = 8;
        goto L68
    L36:
        if (r103.equals(LiveDegradeFpsAnimator.SCALE_Y) == false) goto L67;
        r105 = 7;
        goto L68
    L40:
        if (r103.equals(LiveDegradeFpsAnimator.SCALE_X) == false) goto L67;
        r105 = 6;
        goto L68
    L44:
        if (r103.equals("progress") == false) goto L67;
        r105 = 5;
        goto L68
    L48:
        if (r103.equals("translationZ") == false) goto L67;
        r105 = 4;
        goto L68
    L52:
        if (r103.equals(LiveDegradeFpsAnimator.TRANSLATION_Y) == false) goto L67;
        r105 = 3;
        goto L68
    L56:
        if (r103.equals(LiveDegradeFpsAnimator.TRANSLATION_X) == false) goto L67;
        r105 = 2;
        goto L68
    L60:
        if (r103.equals("rotationY") == false) goto L67;
        r105 = 1;
        goto L68
    L64:
        if (r103.equals("rotationX") == false) goto L67;
        r105 = 0;
        goto L68
    }

    public final void d(Rect r100, com.obric.oui.constraintlayout.widget.a r101, int r102, int r110) {
        r100.width();
        r100.height();
        com.obric.oui.constraintlayout.widget.a.C4670a r103 = r101.h(r110);
        com.obric.oui.constraintlayout.widget.a.d r104 = r103.f400488c;
        int r111 = r104.f400566c;
        this.f400097b = r111;
        int r105 = r104.f400565b;
        this.f400098c = r105;
        if (r105 == 0) goto L6;
        if (r111 != 0) goto L6;
        float r106 = 0.0f;
    L7:
        this.f400100e = r106;
        com.obric.oui.constraintlayout.widget.a.e r107 = r103.f400491f;
        boolean r112 = r107.f400582m;
        this.f400101f = r107.f400583n;
        this.f400102g = r107.f400571b;
        this.f400103h = r107.f400572c;
        this.f400096a = r107.f400573d;
        this.f400104i = r107.f400574e;
        this.f400105j = r107.f400575f;
        this.f400106k = r107.f400576g;
        this.f400107l = r107.f400577h;
        this.f400108m = r107.f400579j;
        this.f400109n = r107.f400580k;
        this.f400110o = r107.f400581l;
        tla.c.c(r103.f400489d.f400554d);
        this.f400111p = r103.f400489d.f400558h;
        this.f400112q = r103.f400488c.f400568e;
        Iterator<String> r108 = r103.f400492g.keySet().iterator();
    L8:
        boolean r109 = true;
        if (r108.hasNext() == false) goto L19;
        String r113 = r108.next();
        ConstraintAttribute r114 = r103.f400492g.get(r113);
        r114.getClass();
        int r115 = ConstraintAttribute.a.f400376a[r114.f400369c.ordinal()];
        if (r115 == 1) goto L15;
        if (r115 == 2) goto L15;
        if (r115 == 3) goto L15;
    L16:
        if (r109 == false) goto L8;
        this.f400099d.put(r113, r114);
    L15:
        r109 = false;
        goto L16
    L19:
        if (r102 == 1) goto L28;
        if (r102 == 2) goto L25;
        if (r102 == 3) goto L28;
        if (r102 == 4) goto L25;
        return;
    L25:
        float r116 = this.f400102g + 90.0f;
        this.f400102g = r116;
        if (r116 <= 180.0f) goto L35;
        this.f400102g = r116 - 360.0f;
        return;
    L35:
        return;
    L28:
        this.f400102g -= 90.0f;
        return;
    L6:
        r106 = r104.f400567d;
        goto L7
    }
}
