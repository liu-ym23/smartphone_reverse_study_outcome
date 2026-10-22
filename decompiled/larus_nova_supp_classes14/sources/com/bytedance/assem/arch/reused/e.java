package com.bytedance.assem.arch.reused;

import com.bytedance.assem.arch.extensions.HostInjector;
import kotlin.Lazy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class e extends i {
    public static final e a = null;

    static {
        a = new e();
    }

    public e() {
    }

    @Override // com.bytedance.assem.arch.reused.i
    public final i a(FireCase r2) {
        int r3 = d.a[r2.ordinal()];
        if (r3 == 1) goto L15;
        if (r3 == 2) goto L19;
        if (r3 != 3) goto L9;
        Lazy r4 = HostInjector.a;
        return k.a;
    L9:
        if (r3 == 4) goto L17;
        return this;
    L17:
        return u.a;
    L19:
        return a;
    L15:
        return k.a;
    }
}
