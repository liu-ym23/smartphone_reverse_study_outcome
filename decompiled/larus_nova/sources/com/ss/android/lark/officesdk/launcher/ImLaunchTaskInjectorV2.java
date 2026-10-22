package com.ss.android.lark.officesdk.launcher;

import com.ss.android.lark.app.task.scheduler.AppLauncherTaskScheduler;
import com.ss.android.lark.integrator.im.card.InitCardTemplateServiceTask;
import com.ss.android.lark.officesdk.integrator.core.corrupt.InitDbCorruptPushTask;
import com.ss.android.lark.officesdk.integrator.im.InitFullImSdkTask;
import com.ss.android.lark.officesdk.integrator.im.sdk.service.InitImSdkServiceTask;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Singleton
public final class ImLaunchTaskInjectorV2 implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OfficeLaunchSchedulerType f433413a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f433414b;

    @Inject
    public ImLaunchTaskInjectorV2() {
        this.f433413a = OfficeLaunchSchedulerType.V2;
        this.f433414b = LazyKt.lazy(ImLaunchTaskInjectorV2$isIMEnabled$2.INSTANCE);
    }

    @Override // com.ss.android.lark.officesdk.launcher.b
    public final OfficeLaunchSchedulerType c() {
        return this.f433413a;
    }

    @Override // com.ss.android.lark.officesdk.launcher.b
    public final void a(AppLauncherTaskScheduler r100) {
        Intrinsics.checkNotNullParameter(r100, "launcherTaskScheduler");
        if (((Boolean) this.f433414b.getValue()).booleanValue() == true) goto L5;
        return;
    L5:
        r100.a(new InitImSdkServiceTask());
        r100.a(new InitFullImSdkTask());
        r100.a(new InitCardTemplateServiceTask());
    }

    @Override // com.ss.android.lark.officesdk.launcher.b
    public final void b(AppLauncherTaskScheduler r100) {
        Intrinsics.checkNotNullParameter(r100, "launcherTaskScheduler");
        if (((Boolean) this.f433414b.getValue()).booleanValue() == false) goto L6;
        r100.a(new InitDbCorruptPushTask());
        return;
    }
}
