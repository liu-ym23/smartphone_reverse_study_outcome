package com.ss.android.lark.officesdk.launcher;

import com.ss.android.lark.app.task.scheduler.AppLauncherTaskScheduler;
import com.ss.android.lark.assembly.avatar.officesdk.OfficeInitAvatarLoaderTask;
import com.ss.android.lark.flow.notification.offline.InitFlowReportSameDeviceJudgeTask;
import com.ss.android.lark.flow.notification.online.InitFlowNotificationTask;
import com.ss.android.lark.framework.assembly.emoji_office.UpdateEmojiTask;
import com.ss.android.lark.integrator.im.card.InitCardTemplateServiceTask;
import com.ss.android.lark.officesdk.integrator.core.corrupt.InitDbCorruptPushTask;
import com.ss.android.lark.officesdk.integrator.im.InitFullImSdkTask;
import com.ss.android.lark.officesdk.integrator.im.OfficeInitSDKLanguageTask;
import com.ss.android.lark.officesdk.integrator.im.sdk.service.InitImSdkServiceTask;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Singleton
public final class ImLaunchTaskInjectorV1 implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OfficeLaunchSchedulerType f433410a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f433411b;

    @Inject
    public ImLaunchTaskInjectorV1() {
        this.f433410a = OfficeLaunchSchedulerType.V1;
        this.f433411b = LazyKt.lazy(ImLaunchTaskInjectorV1$isIMEnabled$2.INSTANCE);
    }

    @Override // com.ss.android.lark.officesdk.launcher.b
    public final OfficeLaunchSchedulerType c() {
        return this.f433410a;
    }

    @Override // com.ss.android.lark.officesdk.launcher.b
    public final void a(AppLauncherTaskScheduler r100) {
        Intrinsics.checkNotNullParameter(r100, "launcherTaskScheduler");
        if (((Boolean) this.f433411b.getValue()).booleanValue() == true) goto L5;
        return;
    L5:
        r100.a(new InitImSdkServiceTask());
        r100.a(new InitFullImSdkTask());
        r100.a(new OfficeInitSDKLanguageTask());
        r100.a(new OfficeInitAvatarLoaderTask());
        r100.a(new UpdateEmojiTask());
        r100.a(new InitCardTemplateServiceTask());
        r100.a(new InitFlowNotificationTask());
        r100.a(new InitFlowReportSameDeviceJudgeTask());
    }

    @Override // com.ss.android.lark.officesdk.launcher.b
    public final void b(AppLauncherTaskScheduler r100) {
        Intrinsics.checkNotNullParameter(r100, "launcherTaskScheduler");
        if (((Boolean) this.f433411b.getValue()).booleanValue() == false) goto L6;
        r100.a(new InitDbCorruptPushTask());
        return;
    }
}
