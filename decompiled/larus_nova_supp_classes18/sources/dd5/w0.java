package dd5;

import android.app.Activity;
import android.content.Context;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class w0 {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static int a(Activity r4) {
        int r0 = 2;
        if (r4 != null) goto L5;
    L19:
        return 2;
    L5:
        if (ku5.c.k(r4) == false) goto L19;
        if (com.bytedance.ee.util.ui.n.D(r4) == false) goto L10;
        int r5 = com.bytedance.ee.util.ui.n.a(com.bytedance.ee.util.ui.n.getResources(r4)).widthPixels;
    L11:
        int r6 = r5 - com.bytedance.ee.util.ui.n.d(32);
        int r1 = (r6 - com.bytedance.ee.util.ui.n.d(12)) / 2;
        int r2 = com.bytedance.ee.util.ui.n.d(232);
        int r3 = com.bytedance.ee.util.ui.n.d(138);
        if (r1 >= r3) goto L14;
        return 2;
    L14:
        if (r1 < r3) goto L18;
        if (r1 > r2) goto L18;
        return r0;
    L18:
        r0 = r0 + 1;
        r1 = r6 / r0;
        goto L14
    L10:
        r5 = com.bytedance.ee.util.ui.n.v();
        goto L11
    }

    public static int b(Context r5) {
        int r0 = 2;
        if (r5 != null) goto L5;
    L15:
        return 2;
    L5:
        if (ku5.c.k(r5) == false) goto L15;
        int r6 = com.bytedance.ee.util.ui.n.a(com.bytedance.ee.util.ui.n.getResources(r5)).widthPixels - com.bytedance.ee.util.ui.n.d(16);
        int r1 = com.bytedance.ee.util.ui.n.d(16);
        int r2 = (r6 - (r1 * 2)) / 2;
        int r3 = com.bytedance.ee.util.ui.n.d(232);
        int r4 = com.bytedance.ee.util.ui.n.d(138);
        if (r2 >= r4) goto L10;
        return 2;
    L10:
        if (r2 < r4) goto L14;
        if (r2 > r3) goto L14;
        return r0;
    L14:
        r0 = r0 + 1;
        r2 = (r6 - (r1 * r0)) / r0;
        goto L10
    }
}
