package com.bytedance.live.livelink.kmp.impl.core.link;

/* JADX INFO: loaded from: classes19.dex */
public final class d implements si6.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Runnable f255420a;

    @Override // si6.c
    public final void run() {
        Runnable r100 = this.f255420a;
        if (r100 == null) goto L6;
        r100.run();
        return;
    }

    public d(a r100) {
        this.f255420a = r100;
    }
}
