package com.bytedance.assem.arch.reused;

/* JADX INFO: loaded from: classes14.dex */
public final class k extends i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k f193025a = null;

    static {
        f193025a = new k();
    }

    public k() {
    }

    @Override // com.bytedance.assem.arch.reused.i
    public final i a(FireCase r100) {
        int r101 = j.f193024a[r100.ordinal()];
        if (r101 == 1) goto L9;
        if (r101 == 2) goto L11;
        return this;
    L11:
        return e.f193023a;
    L9:
        return c.f193021a;
    }
}
