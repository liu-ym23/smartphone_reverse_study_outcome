package com.ss.android.lark.conditional.access.auth.v2;

import com.larksuite.framework.thread.CoreThreadPool;
import com.ss.android.lark.utils.LarkContext;
import java.util.concurrent.ScheduledExecutorService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f417828a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f417829b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ScheduledExecutorService f417830c;

    public final synchronized x4c.g a() {
        monitor-enter(this);
        x4c.g r100 = new x4c.g(LarkContext.getApplication(), "im_read_" + this.f417829b, this.f417828a);     // Catch: Throwable -> L7
        monitor-exit(this);
        return r100;
    L7:
        th = move-exception;
        throw th;
    }

    public j(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "uid");
        this.f417828a = r100;
        this.f417829b = r101;
        this.f417830c = CoreThreadPool.getDefault().getSingleScheduledThreadPool("im_read_pc_cache");
    }
}
