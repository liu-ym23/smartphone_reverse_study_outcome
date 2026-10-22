package com.obric.oui.constraintlayout.motion.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes34.dex */
public final class j extends d {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f400058e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f400059f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f400060g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f400061h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f400062i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f400063j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f400064k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f400065l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f400066m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f400067n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f400068o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f400069p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f400070q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f400071r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public float f400072s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public float f400073t;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final SparseIntArray f400074a = null;

        static {
            SparseIntArray r100 = new SparseIntArray();
            f400074a = r100;
            r100.append(0, 1);
            r100.append(9, 2);
            r100.append(5, 4);
            r100.append(6, 5);
            r100.append(7, 6);
            r100.append(3, 7);
            r100.append(15, 8);
            r100.append(14, 9);
            r100.append(13, 10);
            r100.append(11, 12);
            r100.append(10, 13);
            r100.append(4, 14);
            r100.append(1, 15);
            r100.append(2, 16);
            r100.append(8, 17);
            r100.append(12, 18);
            r100.append(18, 20);
            r100.append(17, 21);
            r100.append(20, 19);
        }
    }

    @Override // com.obric.oui.constraintlayout.motion.widget.d
    public final d b() {
        j r100 = new j();
        super.c(this);
        r100.f400058e = this.f400058e;
        r100.f400071r = this.f400071r;
        r100.f400072s = this.f400072s;
        r100.f400073t = this.f400073t;
        r100.f400070q = this.f400070q;
        r100.f400059f = this.f400059f;
        r100.f400060g = this.f400060g;
        r100.f400061h = this.f400061h;
        r100.f400064k = this.f400064k;
        r100.f400062i = this.f400062i;
        r100.f400063j = this.f400063j;
        r100.f400065l = this.f400065l;
        r100.f400066m = this.f400066m;
        r100.f400067n = this.f400067n;
        r100.f400068o = this.f400068o;
        r100.f400069p = this.f400069p;
        return r100;
    }

    public j() {
        this.f400058e = -1;
        this.f400059f = Float.NaN;
        this.f400060g = Float.NaN;
        this.f400061h = Float.NaN;
        this.f400062i = Float.NaN;
        this.f400063j = Float.NaN;
        this.f400064k = Float.NaN;
        this.f400065l = Float.NaN;
        this.f400066m = Float.NaN;
        this.f400067n = Float.NaN;
        this.f400068o = Float.NaN;
        this.f400069p = Float.NaN;
        this.f400070q = Float.NaN;
        this.f400071r = 0;
        this.f400072s = Float.NaN;
        this.f400073t = 0.0f;
        this.f400007d = new HashMap();
    }

    @Override // com.obric.oui.constraintlayout.motion.widget.d
    public final /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
        return b();
    }

    @Override // com.obric.oui.constraintlayout.motion.widget.d
    public final void a(HashMap<String, vla.d> r100) {
        throw new IllegalArgumentException(" KeyTimeCycles do not support SplineSet");
    }

    @Override // com.obric.oui.constraintlayout.motion.widget.d
    public final void d(HashSet<String> r100) {
        if (Float.isNaN(this.f400059f) == true) goto L6;
        r100.add("alpha");
    L6:
        if (Float.isNaN(this.f400060g) == true) goto L9;
        r100.add("elevation");
    L9:
        if (Float.isNaN(this.f400061h) == true) goto L12;
        r100.add("rotation");
    L12:
        if (Float.isNaN(this.f400062i) == true) goto L15;
        r100.add("rotationX");
    L15:
        if (Float.isNaN(this.f400063j) == true) goto L18;
        r100.add("rotationY");
    L18:
        if (Float.isNaN(this.f400067n) == true) goto L21;
        r100.add(LiveDegradeFpsAnimator.TRANSLATION_X);
    L21:
        if (Float.isNaN(this.f400068o) == true) goto L24;
        r100.add(LiveDegradeFpsAnimator.TRANSLATION_Y);
    L24:
        if (Float.isNaN(this.f400069p) == true) goto L27;
        r100.add("translationZ");
    L27:
        if (Float.isNaN(this.f400064k) == true) goto L30;
        r100.add("transitionPathRotate");
    L30:
        if (Float.isNaN(this.f400065l) == true) goto L33;
        r100.add(LiveDegradeFpsAnimator.SCALE_X);
    L33:
        if (Float.isNaN(this.f400066m) == true) goto L36;
        r100.add(LiveDegradeFpsAnimator.SCALE_Y);
    L36:
        if (Float.isNaN(this.f400070q) == true) goto L39;
        r100.add("progress");
    L39:
        if (this.f400007d.size() <= 0) goto L44;
        Iterator<String> r101 = this.f400007d.keySet().iterator();
    L42:
        if (r101.hasNext() == false) goto L46;
        r100.add("CUSTOM," + r101.next());
        goto L42
    L46:
        return;
    }

    @Override // com.obric.oui.constraintlayout.motion.widget.d
    public final void f(HashMap<String, Integer> r100) {
        if (this.f400058e != (-1)) goto L6;
        return;
    L6:
        if (Float.isNaN(this.f400059f) == true) goto L9;
        r100.put("alpha", Integer.valueOf(this.f400058e));
    L9:
        if (Float.isNaN(this.f400060g) == true) goto L12;
        r100.put("elevation", Integer.valueOf(this.f400058e));
    L12:
        if (Float.isNaN(this.f400061h) == true) goto L15;
        r100.put("rotation", Integer.valueOf(this.f400058e));
    L15:
        if (Float.isNaN(this.f400062i) == true) goto L18;
        r100.put("rotationX", Integer.valueOf(this.f400058e));
    L18:
        if (Float.isNaN(this.f400063j) == true) goto L21;
        r100.put("rotationY", Integer.valueOf(this.f400058e));
    L21:
        if (Float.isNaN(this.f400067n) == true) goto L24;
        r100.put(LiveDegradeFpsAnimator.TRANSLATION_X, Integer.valueOf(this.f400058e));
    L24:
        if (Float.isNaN(this.f400068o) == true) goto L27;
        r100.put(LiveDegradeFpsAnimator.TRANSLATION_Y, Integer.valueOf(this.f400058e));
    L27:
        if (Float.isNaN(this.f400069p) == true) goto L30;
        r100.put("translationZ", Integer.valueOf(this.f400058e));
    L30:
        if (Float.isNaN(this.f400064k) == true) goto L33;
        r100.put("transitionPathRotate", Integer.valueOf(this.f400058e));
    L33:
        if (Float.isNaN(this.f400065l) == true) goto L36;
        r100.put(LiveDegradeFpsAnimator.SCALE_X, Integer.valueOf(this.f400058e));
    L36:
        if (Float.isNaN(this.f400065l) == true) goto L39;
        r100.put(LiveDegradeFpsAnimator.SCALE_Y, Integer.valueOf(this.f400058e));
    L39:
        if (Float.isNaN(this.f400070q) == true) goto L42;
        r100.put("progress", Integer.valueOf(this.f400058e));
    L42:
        if (this.f400007d.size() <= 0) goto L47;
        Iterator<String> r101 = this.f400007d.keySet().iterator();
    L45:
        if (r101.hasNext() == false) goto L49;
        r100.put("CUSTOM," + r101.next(), Integer.valueOf(this.f400058e));
        goto L45
    L49:
        return;
    }

    @Override // com.obric.oui.constraintlayout.motion.widget.d
    public final void e(Context r100, AttributeSet r101) {
        TypedArray r102 = r100.obtainStyledAttributes(r101, new int[]{R.attr.alpha, R.attr.translationX, R.attr.translationY, R.attr.scaleX, R.attr.scaleY, R.attr.rotation, R.attr.rotationX, R.attr.rotationY, R.attr.translationZ, R.attr.elevation, com.larus.nova.R.attr.curveFit, com.larus.nova.R.attr.framePosition, com.larus.nova.R.attr.motionProgress, com.larus.nova.R.attr.motionTarget, com.larus.nova.R.attr.transitionEasing, com.larus.nova.R.attr.transitionPathRotate, com.larus.nova.R.attr.waveDecay, com.larus.nova.R.attr.waveOffset, com.larus.nova.R.attr.wavePeriod, com.larus.nova.R.attr.wavePhase, com.larus.nova.R.attr.waveShape});
        SparseIntArray r103 = a.f400074a;
        int r104 = r102.getIndexCount();
        int r105 = 0;
    L3:
        if (r105 >= r104) goto L41;
        int r106 = r102.getIndex(r105);
        SparseIntArray r107 = a.f400074a;
        switch(r107.get(r106)) {
            case 1: goto L39;
            case 2: goto L38;
            case 3: goto L6;
            case 4: goto L37;
            case 5: goto L36;
            case 6: goto L35;
            case 7: goto L34;
            case 8: goto L33;
            case 9: goto L32;
            case 10: goto L24;
            case 11: goto L6;
            case 12: goto L22;
            case 13: goto L21;
            case 14: goto L20;
            case 15: goto L19;
            case 16: goto L18;
            case 17: goto L17;
            case 18: goto L16;
            case 19: goto L13;
            case 20: goto L11;
            case 21: goto L8;
            default: goto L6;
        };
    L6:
        Integer.toHexString(r106);
        r107.get(r106);
    L40:
        r105 = r105 + 1;
        goto L3
    L11:
        this.f400072s = r102.getFloat(r106, this.f400072s);
        goto L40
    L16:
        this.f400070q = r102.getFloat(r106, this.f400070q);
        goto L40
    L17:
        this.f400069p = r102.getDimension(r106, this.f400069p);
        goto L40
    L18:
        this.f400068o = r102.getDimension(r106, this.f400068o);
        goto L40
    L19:
        this.f400067n = r102.getDimension(r106, this.f400067n);
        goto L40
    L20:
        this.f400066m = r102.getFloat(r106, this.f400066m);
        goto L40
    L21:
        this.f400058e = r102.getInteger(r106, this.f400058e);
        goto L40
    L22:
        this.f400004a = r102.getInt(r106, this.f400004a);
        goto L40
    L32:
        r102.getString(r106);
        goto L40
    L33:
        this.f400064k = r102.getFloat(r106, this.f400064k);
        goto L40
    L34:
        this.f400065l = r102.getFloat(r106, this.f400065l);
        goto L40
    L35:
        this.f400063j = r102.getFloat(r106, this.f400063j);
        goto L40
    L36:
        this.f400062i = r102.getFloat(r106, this.f400062i);
        goto L40
    L37:
        this.f400061h = r102.getFloat(r106, this.f400061h);
        goto L40
    L38:
        this.f400060g = r102.getDimension(r106, this.f400060g);
        goto L40
    L39:
        this.f400059f = r102.getFloat(r106, this.f400059f);
        goto L40
    L8:
        if (r102.peekValue(r106).type != 5) goto L10;
        this.f400073t = r102.getDimension(r106, this.f400073t);
        goto L40
    L10:
        this.f400073t = r102.getFloat(r106, this.f400073t);
        goto L40
    L13:
        if (r102.peekValue(r106).type != 3) goto L15;
        r102.getString(r106);
        this.f400071r = 7;
        goto L40
    L15:
        this.f400071r = r102.getInt(r106, this.f400071r);
        goto L40
    L24:
        if (MotionLayout.F2 == false) goto L29;
        int r108 = r102.getResourceId(r106, this.f400005b);
        this.f400005b = r108;
        if (r108 != (-1)) goto L40;
        this.f400006c = r102.getString(r106);
        goto L40
    L29:
        if (r102.peekValue(r106).type != 3) goto L31;
        this.f400006c = r102.getString(r106);
        goto L40
    L31:
        this.f400005b = r102.getResourceId(r106, this.f400005b);
        goto L40
    }
}
