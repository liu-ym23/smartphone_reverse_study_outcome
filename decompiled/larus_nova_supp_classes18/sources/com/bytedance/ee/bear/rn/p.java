package com.bytedance.ee.bear.rn;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class p implements tb5.f.b {
    public static final p a = null;

    static {
        a = new p();
    }

    public p() {
    }

    public final void b(String r5) {
        wl5.f r0 = RnSyncManager.j;
        if (r0 == null) goto L6;
        r0.c(new vl5.b(), r5, -1).subscribe();
        return;
    }
}
