package com.bytedance.ee.bear.rn;

/* JADX INFO: loaded from: classes18.dex */
public final class p implements tb5.f.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p f236629a = null;

    static {
        f236629a = new p();
    }

    public p() {
    }

    @Override // tb5.f.b
    public final void b(String r100) {
        wl5.f r101 = RnSyncManager.f236505j;
        if (r101 == null) goto L6;
        r101.c(new vl5.b(), r100, -1).subscribe();
        return;
    }
}
