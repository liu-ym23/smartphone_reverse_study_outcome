package com.lynx.tasm.behavior.ui.utils;

import android.renderscript.Matrix4f;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.lynx.tasm.base.LLog;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

/* JADX INFO: loaded from: classes32.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f383159a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f383160b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinkedHashMap<String, Float> f383161c;

    public final float c() {
        Float r100 = this.f383161c.get("rotate");
        if (r100 != null) goto L7;
        return 0.0f;
    L7:
        return r100.floatValue();
    }

    public final float d() {
        Float r100 = this.f383161c.get("rotateX");
        if (r100 != null) goto L7;
        return 0.0f;
    L7:
        return r100.floatValue();
    }

    public final float e() {
        Float r100 = this.f383161c.get("rotateY");
        if (r100 != null) goto L7;
        return 0.0f;
    L7:
        return r100.floatValue();
    }

    public final float f() {
        Float r100 = this.f383161c.get(LiveDegradeFpsAnimator.SCALE_X);
        if (r100 != null) goto L7;
        return 1.0f;
    L7:
        return r100.floatValue();
    }

    public final float g() {
        Float r100 = this.f383161c.get(LiveDegradeFpsAnimator.SCALE_Y);
        if (r100 != null) goto L7;
        return 1.0f;
    L7:
        return r100.floatValue();
    }

    public final float h() {
        Float r100 = this.f383161c.get("translateX");
        if (r100 != null) goto L7;
        return 0.0f;
    L7:
        return r100.floatValue();
    }

    public final float i() {
        Float r100 = this.f383161c.get("translateY");
        if (r100 != null) goto L7;
        return 0.0f;
    L7:
        return r100.floatValue();
    }

    public final float j() {
        Float r100 = this.f383161c.get("translateZ");
        if (r100 != null) goto L7;
        return 0.0f;
    L7:
        return r100.floatValue();
    }

    public m() {
        LinkedHashMap<String, Float> r100 = new LinkedHashMap();
        this.f383161c = r100;
        r100.clear();
    }

    public static double[] b(float[] r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        double[] r101 = new double[r100.length];
        int r102 = 0;
    L7:
        if (r102 >= r100.length) goto L9;
        r101[r102] = r100[r102];
        r102 = r102 + 1;
        goto L7
    L9:
        return r101;
    }

    public final void l(com.lynx.tasm.utils.h.a r100) {
        float r101 = com.lynx.tasm.utils.b.b((float) r100.f384093d[0]);
        this.f383161c.put("translateX", Float.valueOf(r101));
        float r102 = com.lynx.tasm.utils.b.b((float) r100.f384093d[1]);
        this.f383161c.put("translateY", Float.valueOf(r102));
        float r103 = com.lynx.tasm.utils.b.b((float) r100.f384093d[2]);
        this.f383161c.put("translateZ", Float.valueOf(r103));
        float r104 = com.lynx.tasm.utils.b.b((float) r100.f384094e[2]);
        this.f383161c.put("rotate", Float.valueOf(r104));
        float r105 = com.lynx.tasm.utils.b.b((float) r100.f384094e[0]);
        this.f383161c.put("rotateX", Float.valueOf(r105));
        float r106 = com.lynx.tasm.utils.b.b((float) r100.f384094e[1]);
        this.f383161c.put("rotateY", Float.valueOf(r106));
        float r107 = com.lynx.tasm.utils.b.b((float) r100.f384091b[0]);
        this.f383161c.put(LiveDegradeFpsAnimator.SCALE_X, Float.valueOf(r107));
        float r108 = com.lynx.tasm.utils.b.b((float) r100.f384091b[1]);
        this.f383161c.put(LiveDegradeFpsAnimator.SCALE_Y, Float.valueOf(r108));
    }

    public final void m(float r100) {
        this.f383161c.put("skewX", Float.valueOf((float) Math.tan(r100)));
    }

    public final void n(float r100) {
        this.f383161c.put("skewY", Float.valueOf((float) Math.tan(r100)));
    }

    public static float a(n r100, int r101, float r102) {
        boolean r103 = false;
        if (r101 != 0) goto L9;
        float r104 = r100.f383164c.b(r102);
        if (r100.f383165d != 1) goto L7;
        r103 = true;
    L7:
        if (r103 == false) goto L25;
        int r105 = Math.round(r104);
    L28:
        return r105;
    L25:
        return r104;
    L9:
        if (r101 != 1) goto L16;
        float r106 = r100.f383167f.b(r102);
        if (r100.f383168g != 1) goto L13;
        r103 = true;
    L13:
        if (r103 == false) goto L26;
        r105 = Math.round(r106);
        goto L28
    L26:
        return r106;
    L16:
        if (r101 != 2) goto L23;
        float r107 = r100.f383169h.b(r102);
        if (r100.f383170i != 1) goto L20;
        r103 = true;
    L20:
        if (r103 == false) goto L27;
        r105 = Math.round(r107);
        goto L28
    L27:
        return r107;
    L23:
        return 0.0f;
    }

    public static m k(List r110, int r111, int r112) {
        m r100 = new m();
        if (r110 != null) goto L5;
    L31:
        return r100;
    L5:
        if (r110.isEmpty() == true) goto L31;
        Iterator r113 = r110.iterator();
    L9:
        if (r113.hasNext() == false) goto L31;
        n r101 = (n) r113.next();
        int r102 = r101.f383162a;
        if (r102 == 1) goto L30;
        if (r102 != 2) goto L14;
        r100.f383161c.put("translateX", Float.valueOf(a(r101, 0, r111)));
        goto L9
    L14:
        switch(r102) {
            case 4: goto L28;
            case 8: goto L27;
            case 16: goto L30;
            case 32: goto L26;
            case 64: goto L25;
            case 128: goto L24;
            case 256: goto L26;
            case 512: goto L23;
            case 1024: goto L22;
            case 2048: goto L21;
            case 4096: goto L20;
            case 8192: goto L19;
            case 16384: goto L18;
            case 32768: goto L17;
            case 65536: goto L17;
            default: goto L15;
        };
    L15:
        LLog.DTHROW();
        return null;
    L18:
        r100.n((float) com.lynx.tasm.utils.h.b(r101.f383163b));
        goto L9
    L19:
        r100.m((float) com.lynx.tasm.utils.h.b(r101.f383163b));
        goto L9
    L20:
        r100.m((float) com.lynx.tasm.utils.h.b(r101.f383163b));
        r100.n((float) com.lynx.tasm.utils.h.b(r101.f383166e));
        goto L9
    L21:
        r100.f383161c.put(LiveDegradeFpsAnimator.SCALE_Y, Float.valueOf(r101.f383163b));
        goto L9
    L22:
        r100.f383161c.put(LiveDegradeFpsAnimator.SCALE_X, Float.valueOf(r101.f383163b));
        goto L9
    L23:
        r100.f383161c.put(LiveDegradeFpsAnimator.SCALE_X, Float.valueOf(r101.f383163b));
        r100.f383161c.put(LiveDegradeFpsAnimator.SCALE_Y, Float.valueOf(r101.f383166e));
        goto L9
    L24:
        r100.f383161c.put("rotateY", Float.valueOf(r101.f383163b));
        goto L9
    L25:
        r100.f383161c.put("rotateX", Float.valueOf(r101.f383163b));
        goto L9
    L26:
        r100.f383161c.put("rotate", Float.valueOf(r101.f383163b));
        goto L9
    L27:
        r100.f383161c.put("translateZ", Float.valueOf(a(r101, 0, 0.0f)));
        goto L9
    L28:
        r100.f383161c.put("translateY", Float.valueOf(a(r101, 0, r112)));
        goto L9
    L17:
        Matrix4f r103 = new Matrix4f(r101.f383171j);
        com.lynx.tasm.utils.h.a r104 = new com.lynx.tasm.utils.h.a();
        r104.a();
        com.lynx.tasm.utils.h.a(b(r103.getArray()), r104);
        r100.l(r104);
    L30:
        r100.f383161c.put("translateX", Float.valueOf(a(r101, 0, r111)));
        r100.f383161c.put("translateY", Float.valueOf(a(r101, 1, r112)));
        r100.f383161c.put("translateZ", Float.valueOf(a(r101, 2, 0.0f)));
        goto L9
    }
}
