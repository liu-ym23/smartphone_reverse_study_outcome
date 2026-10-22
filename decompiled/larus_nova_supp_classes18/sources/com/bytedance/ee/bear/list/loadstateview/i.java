package com.bytedance.ee.bear.list.loadstateview;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class i {
    public final a a;
    public final a b;

    public static class a {
        public final int a;
        public final int b;
        public final int c;
        public final int d;

        public a(int r1, int r2, int r3, int r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [com.bytedance.ee.bear.list.loadstateview.LoadStateView] */
    /* JADX WARN: Type inference failed for: r3v1, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r3v3, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v5 */
    public static i a(LoadStateView r3) {
    L3:
        if (r3 == 0) goto L12;
        Object r1 = r3.getTag(2131378164);
        if ((r1 instanceof i) == true) goto L7;
        Object r4 = r3.getParent();
        if ((r4 instanceof View) == true) goto L10;
        r3 = 0;
        goto L3
    L10:
        r3 = (View) r4;
        goto L3
    L7:
        return (i) r1;
    L12:
        return null;
    }

    public i(a r1, a r2) {
        this.a = r1;
        this.b = r2;
    }
}
