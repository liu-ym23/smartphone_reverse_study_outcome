package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.video;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public interface t {

    public static final class a {
        public static /* synthetic */ void a(t r2, boolean r3, boolean r4, boolean r5, boolean r6, int r7) {
            if ((r7 & 2) == 0) goto L6;
            r4 = false;
        L6:
            if ((r7 & 4) == 0) goto L9;
            r5 = false;
        L9:
            if ((r7 & 8) == 0) goto L11;
            r6 = false;
        L11:
            r2.a(r3, r4, r5, r6);
        }
    }

    void a(boolean r1, boolean r2, boolean r3, boolean r4);

    boolean b();

    void c(boolean r1);

    void d();

    gj.b e();

    l getParams();
}
