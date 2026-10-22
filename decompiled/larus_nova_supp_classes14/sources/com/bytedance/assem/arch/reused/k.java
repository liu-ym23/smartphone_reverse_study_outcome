package com.bytedance.assem.arch.reused;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class k extends i {
    public static final k a = null;

    static {
        a = new k();
    }

    public k() {
    }

    @Override // com.bytedance.assem.arch.reused.i
    public final i a(FireCase r2) {
        int r3 = j.a[r2.ordinal()];
        if (r3 == 1) goto L9;
        if (r3 == 2) goto L11;
        return this;
    L11:
        return e.a;
    L9:
        return c.a;
    }
}
