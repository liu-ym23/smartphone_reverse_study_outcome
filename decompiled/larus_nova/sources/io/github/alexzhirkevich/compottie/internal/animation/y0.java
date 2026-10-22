package io.github.alexzhirkevich.compottie.internal.animation;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes41.dex */
public final class y0 {
    public static final List a(int r100) {
        ArrayList r101 = new ArrayList(r100);
        int r102 = 0;
    L3:
        if (r102 >= r100) goto L5;
        r101.add(Float.valueOf(0.0f));
        r102 = r102 + 1;
        goto L3
    L5:
        return r101;
    }
}
