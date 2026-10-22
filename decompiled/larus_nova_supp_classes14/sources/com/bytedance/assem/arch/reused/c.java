package com.bytedance.assem.arch.reused;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c extends i {
    public static final c a = null;

    static {
        a = new c();
    }

    public c() {
    }

    @Override // com.bytedance.assem.arch.reused.i
    public final i a(FireCase r2) {
        int r3 = b.a[r2.ordinal()];
        if (r3 == 2) goto L11;
        if (r3 == 3) goto L11;
        if (r3 == 4) goto L13;
        return this;
    L13:
        return k.a;
    L11:
        return u.a;
    }
}
