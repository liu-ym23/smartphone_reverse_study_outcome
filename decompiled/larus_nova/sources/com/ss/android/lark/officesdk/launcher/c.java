package com.ss.android.lark.officesdk.launcher;

import com.ss.android.lark.app.task.scheduler.AppLauncherTaskScheduler;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Singleton
public final class c implements com.ss.android.lark.officesdk.launcher.feed.a {
    @Inject
    public c() {
    }

    @Override // com.ss.android.lark.officesdk.launcher.feed.a
    public final void a(AppLauncherTaskScheduler r100) {
        Intrinsics.checkNotNullParameter(r100, "launcherTaskScheduler");
    }

    @Override // com.ss.android.lark.officesdk.launcher.feed.a
    public final void b(AppLauncherTaskScheduler r100) {
        Intrinsics.checkNotNullParameter(r100, "launcherTaskScheduler");
    }
}
