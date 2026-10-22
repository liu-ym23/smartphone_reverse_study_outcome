package com.larus.kmp.voice_setting.voice.dialog.v2;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes30.dex */
public final class h {
    public static List a() {
        ArrayList r100 = new ArrayList(7);
        int r101 = 0;
    L3:
        if (r101 >= 7) goto L23;
        if (r101 != 0) goto L6;
    L21:
        float r102 = 0.22f;
    L22:
        r100.add(Float.valueOf(r102));
        r101 = r101 + 1;
        goto L3
    L6:
        if (r101 == 6) goto L21;
        if (r101 != 1) goto L11;
    L20:
        r102 = 0.32f;
        goto L22
    L11:
        if (r101 == 5) goto L20;
        if (r101 != 2) goto L16;
    L19:
        r102 = 0.46f;
        goto L22
    L16:
        if (r101 == 4) goto L19;
        r102 = 0.58f;
        goto L22
    L23:
        return r100;
    }
}
