package com.larus.kmp.voice_setting.voice.bridge;

import ouc.d0;

/* JADX INFO: loaded from: classes30.dex */
public final class w {
    public static final boolean a(d0 r100, String r101, boolean r102) {
        ouc.i r103 = (ouc.i) r100.get(r101);
        if (r103 == null) goto L8;
        Boolean r104 = ouc.k.f(ouc.k.o(r103));
        if (r104 != null) goto L7;
        return r102;
    L7:
        return r104.booleanValue();
    L8:
        return r102;
    }

    public static final float b(d0 r100, String r101, float r102) {
        ouc.i r103 = (ouc.i) r100.get(r101);
        if (r103 == null) goto L28;
        Float r104 = ouc.k.j(ouc.k.o(r103));
        if (r104 == null) goto L29;
        Float r105 = Float.valueOf(r104.floatValue());
        float r106 = r105.floatValue();
        boolean r107 = true;
        if (Float.isInfinite(r106) == false) goto L9;
    L11:
        boolean r108 = false;
    L12:
        if (r108 == true) goto L14;
    L21:
        r107 = false;
    L22:
        if (r107 == true) goto L25;
        r105 = null;
    L25:
        if (r105 != null) goto L27;
        return r102;
    L27:
        return r105.floatValue();
    L14:
        if (0.0f <= r106) goto L16;
    L18:
        boolean r109 = false;
    L19:
        if (r109 == false) goto L21;
    L16:
        if (r106 > 2.0f) goto L18;
        r109 = true;
        goto L19
    L9:
        if (Float.isNaN(r106) == true) goto L11;
        r108 = true;
        goto L12
    L29:
        return r102;
    L28:
        return r102;
    }
}
