package com.larus.agents.impl.webfetch;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes24.dex */
public final /* synthetic */ class u {
    public static /* synthetic */ void a(AtomicReference r100, t r101) {
    L3:
        if (r100.compareAndSet(r101, null) == true) goto L4;
        if (r100.get() == r101) goto L3;
        return;
    }
}
