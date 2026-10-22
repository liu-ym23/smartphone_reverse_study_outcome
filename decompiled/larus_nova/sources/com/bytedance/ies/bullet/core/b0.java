package com.bytedance.ies.bullet.core;

import com.bytedance.ies.bullet.service.base.BulletLogger;
import com.bytedance.ies.bullet.service.base.api.LogLevel;
import java.util.concurrent.ExecutorService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class b0 implements y16.b {
    public b0() {
        ExecutorService r100 = BulletLogger.f247763a;
    }

    @Override // y16.b
    public final void d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        ExecutorService r101 = BulletLogger.f247763a;
        BulletLogger.j(r100, LogLevel.D, "XResourceLoader");
    }

    @Override // y16.b
    public final void e(String r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        ExecutorService r101 = BulletLogger.f247763a;
        BulletLogger.j(r100, LogLevel.E, "XResourceLoader");
    }

    @Override // y16.b
    public final void w(String r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        ExecutorService r101 = BulletLogger.f247763a;
        BulletLogger.j(r100, LogLevel.W, "XResourceLoader");
    }

    @Override // y16.b
    public final void e(String r100, Throwable r101) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        Intrinsics.checkNotNullParameter(r101, "tr");
        ExecutorService r102 = BulletLogger.f247763a;
        BulletLogger.l(r101, r100, "XResourceLoader");
    }
}
