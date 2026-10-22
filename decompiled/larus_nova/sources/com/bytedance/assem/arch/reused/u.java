package com.bytedance.assem.arch.reused;

/* JADX INFO: loaded from: classes14.dex */
public final class u extends i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final u f193042a = null;

    static {
        f193042a = new u();
    }

    public u() {
    }

    @Override // com.bytedance.assem.arch.reused.i
    public final i a(FireCase r100) {
        int r101 = t.f193041a[r100.ordinal()];
        if (r101 == 1) goto L9;
        if (r101 == 3) goto L11;
        return this;
    L11:
        return e.f193023a;
    L9:
        return c.f193021a;
    }
}
