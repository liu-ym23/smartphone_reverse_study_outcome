package com.bytedance.assem.arch.reused;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class u extends i {
    public static final u a = null;

    static {
        a = new u();
    }

    public u() {
    }

    @Override // com.bytedance.assem.arch.reused.i
    public final i a(FireCase r2) {
        int r3 = t.a[r2.ordinal()];
        if (r3 == 1) goto L9;
        if (r3 == 3) goto L11;
        return this;
    L11:
        return e.a;
    L9:
        return c.a;
    }
}
