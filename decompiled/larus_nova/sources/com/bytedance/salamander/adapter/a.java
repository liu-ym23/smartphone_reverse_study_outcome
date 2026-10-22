package com.bytedance.salamander.adapter;

import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class a implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PThreadScheduledThreadPoolExecutor f267778a;

    @Override // com.bytedance.salamander.adapter.j
    public final boolean b(u r100) {
        Intrinsics.checkNotNullParameter(r100, "runnable");
        this.f267778a.execute(r100);
        return true;
    }

    public a(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        this.f267778a = new PThreadScheduledThreadPoolExecutor(4, new h(r101, r100));
    }

    @Override // com.bytedance.salamander.adapter.j
    public final boolean a(u r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "runnable");
        this.f267778a.schedule(r100, r101, TimeUnit.MILLISECONDS);
        return true;
    }
}
