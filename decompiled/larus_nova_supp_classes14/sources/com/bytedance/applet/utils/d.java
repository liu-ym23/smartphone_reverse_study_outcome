package com.bytedance.applet.utils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public interface d {

    public static final class a {
        public static /* synthetic */ void a(d r2, boolean r3, boolean r4, boolean r5, int r6) {
            if ((r6 & 2) == 0) goto L6;
            r4 = false;
        L6:
            if ((r6 & 4) == 0) goto L8;
            r5 = false;
        L8:
            r2.a(r3, r4, r5);
        }
    }

    void a(boolean r1, boolean r2, boolean r3);
}
