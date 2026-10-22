package com.relax.relaxframework;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes34.dex */
public final class l extends r {
    public final ArrayList<Object> d() {
        double r100 = this.f405242a;
        int r101 = com.bytedance.rts.foundation.d.f267577a;
        if (r100 != ModifierValue_BackgroundRepeat.RepeatY.getValue()) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L8;
        r100 = ModifierValue_BackgroundRepeat.NoRepeat.getValue();
    L8:
        double r103 = this.f405244c;
        if (r103 != ModifierValue_BackgroundRepeat.RepeatX.getValue()) goto L11;
        boolean r104 = true;
    L12:
        if (r104 == false) goto L15;
        r103 = ModifierValue_BackgroundRepeat.NoRepeat.getValue();
    L15:
        return com.bytedance.rts.foundation.j.k(new Object[]{Double.valueOf(r100), Double.valueOf(r103)});
    L11:
        r104 = false;
        goto L12
    L5:
        r102 = false;
        goto L6
    }
}
