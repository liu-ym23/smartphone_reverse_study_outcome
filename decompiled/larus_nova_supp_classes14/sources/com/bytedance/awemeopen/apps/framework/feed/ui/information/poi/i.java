package com.bytedance.awemeopen.apps.framework.feed.ui.information.poi;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final /* synthetic */ class i implements Runnable {
    public final /* synthetic */ m a;
    public final /* synthetic */ long b;

    public /* synthetic */ i(m r1, long r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        m r0 = this.a;
        long r1 = this.b;
        Intrinsics.checkNotNullParameter(r0, "this$0");
        r0.e(r1);
    }
}
