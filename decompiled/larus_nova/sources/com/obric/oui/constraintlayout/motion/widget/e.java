package com.obric.oui.constraintlayout.motion.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.obric.oui.constraintlayout.widget.ConstraintAttribute;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes34.dex */
public final class e extends d {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f400008e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f400009f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f400010g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f400011h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f400012i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f400013j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f400014k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f400015l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f400016m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f400017n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f400018o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f400019p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f400020q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public float f400021r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public float f400022s;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final SparseIntArray f400023a = null;

        static {
            SparseIntArray r100 = new SparseIntArray();
            f400023a = r100;
            r100.append(0, 1);
            r100.append(11, 2);
            r100.append(7, 4);
            r100.append(8, 5);
            r100.append(9, 6);
            r100.append(1, 19);
            r100.append(2, 20);
            r100.append(5, 7);
            r100.append(18, 8);
            r100.append(17, 9);
            r100.append(15, 10);
            r100.append(13, 12);
            r100.append(12, 13);
            r100.append(6, 14);
            r100.append(3, 15);
            r100.append(4, 16);
            r100.append(10, 17);
            r100.append(14, 18);
        }
    }

    @Override // com.obric.oui.constraintlayout.motion.widget.d
    public final d b() {
        e r100 = new e();
        super.c(this);
        r100.f400008e = this.f400008e;
        r100.f400009f = this.f400009f;
        r100.f400010g = this.f400010g;
        r100.f400011h = this.f400011h;
        r100.f400012i = this.f400012i;
        r100.f400013j = this.f400013j;
        r100.f400014k = this.f400014k;
        r100.f400015l = this.f400015l;
        r100.f400016m = this.f400016m;
        r100.f400017n = this.f400017n;
        r100.f400018o = this.f400018o;
        r100.f400019p = this.f400019p;
        r100.f400020q = this.f400020q;
        r100.f400021r = this.f400021r;
        r100.f400022s = this.f400022s;
        return r100;
    }

    public e() {
        this.f400008e = -1;
        this.f400009f = Float.NaN;
        this.f400010g = Float.NaN;
        this.f400011h = Float.NaN;
        this.f400012i = Float.NaN;
        this.f400013j = Float.NaN;
        this.f400014k = Float.NaN;
        this.f400015l = Float.NaN;
        this.f400016m = Float.NaN;
        this.f400017n = Float.NaN;
        this.f400018o = Float.NaN;
        this.f400019p = Float.NaN;
        this.f400020q = Float.NaN;
        this.f400021r = Float.NaN;
        this.f400022s = Float.NaN;
        this.f400007d = new HashMap();
    }

    @Override // com.obric.oui.constraintlayout.motion.widget.d
    public final /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
        return b();
    }

    @Override // com.obric.oui.constraintlayout.motion.widget.d
    public final void a(HashMap<String, vla.d> r100) {
        Iterator<String> r101 = r100.keySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L116;
        String r102 = r101.next();
        vla.d r103 = r100.get(r102);
        if (r103 == null) goto L4;
        byte r104 = 7;
        if (r102.startsWith("CUSTOM") == true) goto L10;
        switch(r102.hashCode()) {
            case -1249320806: goto L68;
            case -1249320805: goto L64;
            case -1225497657: goto L60;
            case -1225497656: goto L56;
            case -1225497655: goto L52;
            case -1001078227: goto L48;
            case -908189618: goto L44;
            case -908189617: goto L41;
            case -760884510: goto L37;
            case -760884509: goto L33;
            case -40300674: goto L29;
            case -4379043: goto L25;
            case 37232917: goto L21;
            case 92909918: goto L17;
            default: goto L71;
        };
    L71:
        r104 = -1;
    L72:
        switch(r104) {
            case 0: goto L114;
            case 1: goto L111;
            case 2: goto L108;
            case 3: goto L105;
            case 4: goto L102;
            case 5: goto L99;
            case 6: goto L96;
            case 7: goto L93;
            case 8: goto L90;
            case 9: goto L87;
            case 10: goto L84;
            case 11: goto L81;
            case 12: goto L78;
            case 13: goto L75;
            default: goto L4;
        };
    L75:
        if (Float.isNaN(this.f400009f) == true) goto L4;
        r103.b(this.f400004a, this.f400009f);
        goto L4
    L78:
        if (Float.isNaN(this.f400016m) == true) goto L4;
        r103.b(this.f400004a, this.f400016m);
        goto L4
    L81:
        if (Float.isNaN(this.f400010g) == true) goto L4;
        r103.b(this.f400004a, this.f400010g);
        goto L4
    L84:
        if (Float.isNaN(this.f400011h) == true) goto L4;
        r103.b(this.f400004a, this.f400011h);
        goto L4
    L87:
        if (Float.isNaN(this.f400013j) == true) goto L4;
        r103.b(this.f400004a, this.f400015l);
        goto L4
    L90:
        if (Float.isNaN(this.f400012i) == true) goto L4;
        r103.b(this.f400004a, this.f400014k);
        goto L4
    L93:
        if (Float.isNaN(this.f400018o) == true) goto L4;
        r103.b(this.f400004a, this.f400018o);
        goto L4
    L96:
        if (Float.isNaN(this.f400017n) == true) goto L4;
        r103.b(this.f400004a, this.f400017n);
        goto L4
    L99:
        if (Float.isNaN(this.f400022s) == true) goto L4;
        r103.b(this.f400004a, this.f400022s);
        goto L4
    L102:
        if (Float.isNaN(this.f400021r) == true) goto L4;
        r103.b(this.f400004a, this.f400021r);
        goto L4
    L105:
        if (Float.isNaN(this.f400020q) == true) goto L4;
        r103.b(this.f400004a, this.f400020q);
        goto L4
    L108:
        if (Float.isNaN(this.f400019p) == true) goto L4;
        r103.b(this.f400004a, this.f400019p);
        goto L4
    L111:
        if (Float.isNaN(this.f400013j) == true) goto L4;
        r103.b(this.f400004a, this.f400013j);
        goto L4
    L114:
        if (Float.isNaN(this.f400012i) == true) goto L4;
        r103.b(this.f400004a, this.f400012i);
        goto L4
    L17:
        if (r102.equals("alpha") == false) goto L71;
        r104 = HTTP.CR;
        goto L72
    L21:
        if (r102.equals("transitionPathRotate") == false) goto L71;
        r104 = 12;
        goto L72
    L25:
        if (r102.equals("elevation") == false) goto L71;
        r104 = 11;
        goto L72
    L29:
        if (r102.equals("rotation") == false) goto L71;
        r104 = 10;
        goto L72
    L33:
        if (r102.equals("transformPivotY") == false) goto L71;
        r104 = 9;
        goto L72
    L37:
        if (r102.equals("transformPivotX") == false) goto L71;
        r104 = 8;
        goto L72
    L41:
        if (r102.equals(LiveDegradeFpsAnimator.SCALE_Y) == true) goto L72;
    L44:
        if (r102.equals(LiveDegradeFpsAnimator.SCALE_X) == false) goto L71;
        r104 = 6;
        goto L72
    L48:
        if (r102.equals("progress") == false) goto L71;
        r104 = 5;
        goto L72
    L52:
        if (r102.equals("translationZ") == false) goto L71;
        r104 = 4;
        goto L72
    L56:
        if (r102.equals(LiveDegradeFpsAnimator.TRANSLATION_Y) == false) goto L71;
        r104 = 3;
        goto L72
    L60:
        if (r102.equals(LiveDegradeFpsAnimator.TRANSLATION_X) == false) goto L71;
        r104 = 2;
        goto L72
    L64:
        if (r102.equals("rotationY") == false) goto L71;
        r104 = 1;
        goto L72
    L68:
        if (r102.equals("rotationX") == false) goto L71;
        r104 = 0;
        goto L72
    L10:
        String r105 = r102.substring(7);
        ConstraintAttribute r106 = this.f400007d.get(r105);
        if (r106 == null) goto L4;
        int r107 = this.f400004a;
        ((vla.d.b) r103).f555715f.append(r107, r106);
        goto L4
    }

    @Override // com.obric.oui.constraintlayout.motion.widget.d
    public final void d(HashSet<String> r100) {
        if (Float.isNaN(this.f400009f) == true) goto L6;
        r100.add("alpha");
    L6:
        if (Float.isNaN(this.f400010g) == true) goto L9;
        r100.add("elevation");
    L9:
        if (Float.isNaN(this.f400011h) == true) goto L12;
        r100.add("rotation");
    L12:
        if (Float.isNaN(this.f400012i) == true) goto L15;
        r100.add("rotationX");
    L15:
        if (Float.isNaN(this.f400013j) == true) goto L18;
        r100.add("rotationY");
    L18:
        if (Float.isNaN(this.f400014k) == true) goto L21;
        r100.add("transformPivotX");
    L21:
        if (Float.isNaN(this.f400015l) == true) goto L24;
        r100.add("transformPivotY");
    L24:
        if (Float.isNaN(this.f400019p) == true) goto L27;
        r100.add(LiveDegradeFpsAnimator.TRANSLATION_X);
    L27:
        if (Float.isNaN(this.f400020q) == true) goto L30;
        r100.add(LiveDegradeFpsAnimator.TRANSLATION_Y);
    L30:
        if (Float.isNaN(this.f400021r) == true) goto L33;
        r100.add("translationZ");
    L33:
        if (Float.isNaN(this.f400016m) == true) goto L36;
        r100.add("transitionPathRotate");
    L36:
        if (Float.isNaN(this.f400017n) == true) goto L39;
        r100.add(LiveDegradeFpsAnimator.SCALE_X);
    L39:
        if (Float.isNaN(this.f400018o) == true) goto L42;
        r100.add(LiveDegradeFpsAnimator.SCALE_Y);
    L42:
        if (Float.isNaN(this.f400022s) == true) goto L45;
        r100.add("progress");
    L45:
        if (this.f400007d.size() <= 0) goto L50;
        Iterator<String> r101 = this.f400007d.keySet().iterator();
    L48:
        if (r101.hasNext() == false) goto L52;
        r100.add("CUSTOM," + r101.next());
        goto L48
    L52:
        return;
    }

    @Override // com.obric.oui.constraintlayout.motion.widget.d
    public final void f(HashMap<String, Integer> r100) {
        if (this.f400008e != (-1)) goto L6;
        return;
    L6:
        if (Float.isNaN(this.f400009f) == true) goto L9;
        r100.put("alpha", Integer.valueOf(this.f400008e));
    L9:
        if (Float.isNaN(this.f400010g) == true) goto L12;
        r100.put("elevation", Integer.valueOf(this.f400008e));
    L12:
        if (Float.isNaN(this.f400011h) == true) goto L15;
        r100.put("rotation", Integer.valueOf(this.f400008e));
    L15:
        if (Float.isNaN(this.f400012i) == true) goto L18;
        r100.put("rotationX", Integer.valueOf(this.f400008e));
    L18:
        if (Float.isNaN(this.f400013j) == true) goto L21;
        r100.put("rotationY", Integer.valueOf(this.f400008e));
    L21:
        if (Float.isNaN(this.f400014k) == true) goto L24;
        r100.put("transformPivotX", Integer.valueOf(this.f400008e));
    L24:
        if (Float.isNaN(this.f400015l) == true) goto L27;
        r100.put("transformPivotY", Integer.valueOf(this.f400008e));
    L27:
        if (Float.isNaN(this.f400019p) == true) goto L30;
        r100.put(LiveDegradeFpsAnimator.TRANSLATION_X, Integer.valueOf(this.f400008e));
    L30:
        if (Float.isNaN(this.f400020q) == true) goto L33;
        r100.put(LiveDegradeFpsAnimator.TRANSLATION_Y, Integer.valueOf(this.f400008e));
    L33:
        if (Float.isNaN(this.f400021r) == true) goto L36;
        r100.put("translationZ", Integer.valueOf(this.f400008e));
    L36:
        if (Float.isNaN(this.f400016m) == true) goto L39;
        r100.put("transitionPathRotate", Integer.valueOf(this.f400008e));
    L39:
        if (Float.isNaN(this.f400017n) == true) goto L42;
        r100.put(LiveDegradeFpsAnimator.SCALE_X, Integer.valueOf(this.f400008e));
    L42:
        if (Float.isNaN(this.f400018o) == true) goto L45;
        r100.put(LiveDegradeFpsAnimator.SCALE_Y, Integer.valueOf(this.f400008e));
    L45:
        if (Float.isNaN(this.f400022s) == true) goto L48;
        r100.put("progress", Integer.valueOf(this.f400008e));
    L48:
        if (this.f400007d.size() <= 0) goto L53;
        Iterator<String> r101 = this.f400007d.keySet().iterator();
    L51:
        if (r101.hasNext() == false) goto L55;
        r100.put("CUSTOM," + r101.next(), Integer.valueOf(this.f400008e));
        goto L51
    L55:
        return;
    }

    @Override // com.obric.oui.constraintlayout.motion.widget.d
    public final void e(Context r100, AttributeSet r101) {
        TypedArray r102 = r100.obtainStyledAttributes(r101, new int[]{R.attr.alpha, R.attr.transformPivotX, R.attr.transformPivotY, R.attr.translationX, R.attr.translationY, R.attr.scaleX, R.attr.scaleY, R.attr.rotation, R.attr.rotationX, R.attr.rotationY, R.attr.translationZ, R.attr.elevation, com.larus.nova.R.attr.curveFit, com.larus.nova.R.attr.framePosition, com.larus.nova.R.attr.motionProgress, com.larus.nova.R.attr.motionTarget, com.larus.nova.R.attr.transformPivotTarget, com.larus.nova.R.attr.transitionEasing, com.larus.nova.R.attr.transitionPathRotate});
        SparseIntArray r103 = a.f400023a;
        int r104 = r102.getIndexCount();
        int r105 = 0;
    L3:
        if (r105 >= r104) goto L34;
        int r106 = r102.getIndex(r105);
        SparseIntArray r107 = a.f400023a;
        switch(r107.get(r106)) {
            case 1: goto L32;
            case 2: goto L31;
            case 3: goto L6;
            case 4: goto L30;
            case 5: goto L29;
            case 6: goto L28;
            case 7: goto L27;
            case 8: goto L26;
            case 9: goto L25;
            case 10: goto L17;
            case 11: goto L6;
            case 12: goto L15;
            case 13: goto L14;
            case 14: goto L13;
            case 15: goto L12;
            case 16: goto L11;
            case 17: goto L10;
            case 18: goto L9;
            case 19: goto L8;
            case 20: goto L7;
            default: goto L6;
        };
    L6:
        Integer.toHexString(r106);
        r107.get(r106);
    L33:
        r105 = r105 + 1;
        goto L3
    L7:
        this.f400015l = r102.getDimension(r106, this.f400015l);
        goto L33
    L8:
        this.f400014k = r102.getDimension(r106, this.f400014k);
        goto L33
    L9:
        this.f400022s = r102.getFloat(r106, this.f400022s);
        goto L33
    L10:
        this.f400021r = r102.getDimension(r106, this.f400021r);
        goto L33
    L11:
        this.f400020q = r102.getDimension(r106, this.f400020q);
        goto L33
    L12:
        this.f400019p = r102.getDimension(r106, this.f400019p);
        goto L33
    L13:
        this.f400018o = r102.getFloat(r106, this.f400018o);
        goto L33
    L14:
        this.f400008e = r102.getInteger(r106, this.f400008e);
        goto L33
    L15:
        this.f400004a = r102.getInt(r106, this.f400004a);
        goto L33
    L25:
        r102.getString(r106);
        goto L33
    L26:
        this.f400016m = r102.getFloat(r106, this.f400016m);
        goto L33
    L27:
        this.f400017n = r102.getFloat(r106, this.f400017n);
        goto L33
    L28:
        this.f400013j = r102.getFloat(r106, this.f400013j);
        goto L33
    L29:
        this.f400012i = r102.getFloat(r106, this.f400012i);
        goto L33
    L30:
        this.f400011h = r102.getFloat(r106, this.f400011h);
        goto L33
    L31:
        this.f400010g = r102.getDimension(r106, this.f400010g);
        goto L33
    L32:
        this.f400009f = r102.getFloat(r106, this.f400009f);
        goto L33
    L17:
        if (MotionLayout.F2 == false) goto L22;
        int r108 = r102.getResourceId(r106, this.f400005b);
        this.f400005b = r108;
        if (r108 != (-1)) goto L33;
        this.f400006c = r102.getString(r106);
        goto L33
    L22:
        if (r102.peekValue(r106).type != 3) goto L24;
        this.f400006c = r102.getString(r106);
        goto L33
    L24:
        this.f400005b = r102.getResourceId(r106, this.f400005b);
        goto L33
    }

    public final void h(String r100, Object r101) {
        byte r102 = -1;
        switch(r100.hashCode()) {
            case -1913008125: goto L70;
            case -1812823328: goto L66;
            case -1249320806: goto L62;
            case -1249320805: goto L58;
            case -1225497657: goto L54;
            case -1225497656: goto L50;
            case -1225497655: goto L46;
            case -908189618: goto L42;
            case -908189617: goto L38;
            case -760884510: goto L34;
            case -760884509: goto L30;
            case -40300674: goto L26;
            case -4379043: goto L22;
            case 37232917: goto L18;
            case 92909918: goto L14;
            case 579057826: goto L10;
            case 1941332754: goto L6;
            default: goto L73;
        };
    L73:
        switch(r102) {
            case 0: goto L98;
            case 1: goto L97;
            case 2: goto L96;
            case 3: goto L95;
            case 4: goto L94;
            case 5: goto L93;
            case 6: goto L92;
            case 7: goto L91;
            case 8: goto L90;
            case 9: goto L89;
            case 10: goto L88;
            case 11: goto L87;
            case 12: goto L86;
            case 13: goto L85;
            case 14: goto L84;
            case 15: goto L80;
            case 16: goto L76;
            default: goto L117;
        };
    L84:
        this.f400009f = d.g(r101);
        return;
    L85:
        this.f400016m = d.g(r101);
        return;
    L86:
        this.f400010g = d.g(r101);
        return;
    L87:
        this.f400011h = d.g(r101);
        return;
    L88:
        this.f400015l = d.g(r101);
        return;
    L89:
        this.f400014k = d.g(r101);
        return;
    L90:
        this.f400018o = d.g(r101);
        return;
    L91:
        this.f400017n = d.g(r101);
        return;
    L92:
        this.f400021r = d.g(r101);
        return;
    L93:
        this.f400020q = d.g(r101);
        return;
    L94:
        this.f400019p = d.g(r101);
        return;
    L95:
        this.f400013j = d.g(r101);
        return;
    L96:
        this.f400012i = d.g(r101);
        return;
    L97:
        r101.toString();
        return;
    L98:
        this.f400022s = d.g(r101);
        return;
    L117:
        return;
    L76:
        if ((r101 instanceof Boolean) == false) goto L78;
        ((Boolean) r101).booleanValue();
        return;
    L78:
        Boolean.parseBoolean(r101.toString());
        return;
    L80:
        if ((r101 instanceof Integer) == false) goto L82;
        int r103 = ((Integer) r101).intValue();
    L83:
        this.f400008e = r103;
        return;
    L82:
        r103 = CastIntegerProtector.parseInt(r101.toString());
        goto L83
    L6:
        if (r100.equals(RemoteMessageConst.Notification.VISIBILITY) == false) goto L73;
        r102 = 16;
        goto L73
    L10:
        if (r100.equals("curveFit") == false) goto L73;
        r102 = 15;
        goto L73
    L14:
        if (r100.equals("alpha") == false) goto L73;
        r102 = 14;
        goto L73
    L18:
        if (r100.equals("transitionPathRotate") == false) goto L73;
        r102 = HTTP.CR;
        goto L73
    L22:
        if (r100.equals("elevation") == false) goto L73;
        r102 = 12;
        goto L73
    L26:
        if (r100.equals("rotation") == false) goto L73;
        r102 = 11;
        goto L73
    L30:
        if (r100.equals("transformPivotY") == false) goto L73;
        r102 = 10;
        goto L73
    L34:
        if (r100.equals("transformPivotX") == false) goto L73;
        r102 = 9;
        goto L73
    L38:
        if (r100.equals(LiveDegradeFpsAnimator.SCALE_Y) == false) goto L73;
        r102 = 8;
        goto L73
    L42:
        if (r100.equals(LiveDegradeFpsAnimator.SCALE_X) == false) goto L73;
        r102 = 7;
        goto L73
    L46:
        if (r100.equals("translationZ") == false) goto L73;
        r102 = 6;
        goto L73
    L50:
        if (r100.equals(LiveDegradeFpsAnimator.TRANSLATION_Y) == false) goto L73;
        r102 = 5;
        goto L73
    L54:
        if (r100.equals(LiveDegradeFpsAnimator.TRANSLATION_X) == false) goto L73;
        r102 = 4;
        goto L73
    L58:
        if (r100.equals("rotationY") == false) goto L73;
        r102 = 3;
        goto L73
    L62:
        if (r100.equals("rotationX") == false) goto L73;
        r102 = 2;
        goto L73
    L66:
        if (r100.equals("transitionEasing") == false) goto L73;
        r102 = 1;
        goto L73
    L70:
        if (r100.equals("motionProgress") == false) goto L73;
        r102 = 0;
        goto L73
    }
}
