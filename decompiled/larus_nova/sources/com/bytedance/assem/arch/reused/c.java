package com.bytedance.assem.arch.reused;

/* JADX INFO: loaded from: classes14.dex */
public final class c extends i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f193021a = null;

    static {
        f193021a = new c();
    }

    public c() {
    }

    @Override // com.bytedance.assem.arch.reused.i
    public final i a(FireCase r100) {
        int r101 = b.f193020a[r100.ordinal()];
        if (r101 == 2) goto L11;
        if (r101 == 3) goto L11;
        if (r101 == 4) goto L13;
        return this;
    L13:
        return k.f193025a;
    L11:
        return u.f193042a;
    }
}
