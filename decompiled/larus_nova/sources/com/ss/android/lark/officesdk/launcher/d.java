package com.ss.android.lark.officesdk.launcher;

import com.ss.android.lark.app.task.scheduler.AppLauncherTaskScheduler;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Singleton
public final class d implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OfficeLaunchSchedulerType f433429a;

    @Override // com.ss.android.lark.officesdk.launcher.b
    public final void a(AppLauncherTaskScheduler r100) {
        Intrinsics.checkNotNullParameter(r100, "launcherTaskScheduler");
    }

    @Inject
    public d() {
        this.f433429a = OfficeLaunchSchedulerType.V1;
    }

    @Override // com.ss.android.lark.officesdk.launcher.b
    public final OfficeLaunchSchedulerType c() {
        return this.f433429a;
    }

    @Override // com.ss.android.lark.officesdk.launcher.b
    public final void b(AppLauncherTaskScheduler r100) {
        Intrinsics.checkNotNullParameter(r100, "launcherTaskScheduler");
    }
}
