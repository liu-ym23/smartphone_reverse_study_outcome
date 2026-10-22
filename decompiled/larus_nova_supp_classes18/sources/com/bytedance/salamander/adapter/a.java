package com.bytedance.salamander.adapter;

import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a implements j {
    public final PThreadScheduledThreadPoolExecutor a;

    @Override // com.bytedance.salamander.adapter.j
    public final boolean b(u r2) {
        Intrinsics.checkNotNullParameter(r2, "runnable");
        this.a.execute(r2);
        return true;
    }

    public a(String r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "name");
        this.a = new PThreadScheduledThreadPoolExecutor(4, new h(r4, r3));
    }

    @Override // com.bytedance.salamander.adapter.j
    public final boolean a(u r3, long r4) {
        Intrinsics.checkNotNullParameter(r3, "runnable");
        this.a.schedule(r3, r4, TimeUnit.MILLISECONDS);
        return true;
    }
}
