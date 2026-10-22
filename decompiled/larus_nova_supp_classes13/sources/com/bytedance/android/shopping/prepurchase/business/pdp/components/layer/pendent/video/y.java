package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.video;

import kotlin.Pair;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class y {
    public int a;
    public final boolean b;
    public final boolean c;
    public final String d;
    public final String e;
    public final boolean f;
    public final Pair<Integer, Integer> g;

    public y(boolean r5, String r6, String r7, int r8) {
        boolean r1 = true;
        if ((r8 & 2) == 0) goto L6;
        r5 = true;
    L6:
        if ((r8 & 4) == 0) goto L9;
        r1 = false;
    L9:
        if ((r8 & 8) == 0) goto L12;
        r6 = null;
    L12:
        if ((r8 & 16) == 0) goto L14;
        r7 = null;
    L14:
        this.a = 0;
        this.b = r5;
        this.c = r1;
        this.d = r6;
        this.e = r7;
        this.f = false;
        this.g = null;
    }
}
