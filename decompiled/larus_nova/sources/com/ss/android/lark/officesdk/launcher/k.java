package com.ss.android.lark.officesdk.launcher;

import com.ss.android.lark.app.task.scheduler.AppLauncherTaskScheduler;
import com.ss.android.lark.officesdk.integrator.im.InitChatPreviewTask;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Singleton
public final class k implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OfficeLaunchSchedulerType f433451a;

    @Inject
    public k() {
        this.f433451a = OfficeLaunchSchedulerType.V2;
    }

    @Override // com.ss.android.lark.officesdk.launcher.b
    public final OfficeLaunchSchedulerType c() {
        return this.f433451a;
    }

    @Override // com.ss.android.lark.officesdk.launcher.b
    public final void a(AppLauncherTaskScheduler r100) {
        Intrinsics.checkNotNullParameter(r100, "launcherTaskScheduler");
        r100.a(new InitChatPreviewTask());
    }

    @Override // com.ss.android.lark.officesdk.launcher.b
    public final void b(AppLauncherTaskScheduler r100) {
        Intrinsics.checkNotNullParameter(r100, "launcherTaskScheduler");
    }
}
