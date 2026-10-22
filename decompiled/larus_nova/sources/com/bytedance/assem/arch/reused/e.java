package com.bytedance.assem.arch.reused;

import com.bytedance.assem.arch.extensions.HostInjector;
import kotlin.Lazy;

/* JADX INFO: loaded from: classes14.dex */
public final class e extends i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f193023a = null;

    static {
        f193023a = new e();
    }

    public e() {
    }

    @Override // com.bytedance.assem.arch.reused.i
    public final i a(FireCase r100) {
        int r101 = d.f193022a[r100.ordinal()];
        if (r101 == 1) goto L15;
        if (r101 == 2) goto L19;
        if (r101 != 3) goto L9;
        Lazy r102 = HostInjector.f192919a;
        return k.f193025a;
    L9:
        if (r101 == 4) goto L17;
        return this;
    L17:
        return u.f193042a;
    L19:
        return f193023a;
    L15:
        return k.f193025a;
    }
}
