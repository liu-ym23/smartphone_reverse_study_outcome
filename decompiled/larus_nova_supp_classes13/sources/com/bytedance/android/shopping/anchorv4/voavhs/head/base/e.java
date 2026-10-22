package com.bytedance.android.shopping.anchorv4.voavhs.head.base;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public interface e {

    public static final class a {
        public static /* synthetic */ void a(e r2, Integer r3, p r4, Boolean r5, int r6) {
            if ((r6 & 1) == 0) goto L6;
            r3 = null;
        L6:
            if ((r6 & 2) == 0) goto L9;
            r4 = null;
        L9:
            if ((r6 & 4) == 0) goto L11;
            r5 = Boolean.FALSE;
        L11:
            r2.a(r3, r4, r5);
        }
    }

    void a(Integer r1, p r2, Boolean r3);

    void d(int r1);
}
