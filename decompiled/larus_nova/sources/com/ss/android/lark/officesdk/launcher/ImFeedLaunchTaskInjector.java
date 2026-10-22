package com.ss.android.lark.officesdk.launcher;

import com.ss.android.lark.app.task.scheduler.AppLauncherTaskScheduler;
import com.ss.android.lark.assembly.avatar.officesdk.OfficeInitAvatarLoaderTask;
import com.ss.android.lark.flow.notification.offline.InitFlowReportSameDeviceJudgeTask;
import com.ss.android.lark.flow.notification.online.InitFlowNotificationTask;
import com.ss.android.lark.framework.assembly.emoji_office.UpdateEmojiTask;
import com.ss.android.lark.officesdk.integrator.core.corrupt.InitDbCorruptPushTask;
import com.ss.android.lark.officesdk.integrator.im.InitMixFeedMoltenCacheTask;
import com.ss.android.lark.officesdk.integrator.im.OfficeInitSDKLanguageTask;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Singleton
public final class ImFeedLaunchTaskInjector implements com.ss.android.lark.officesdk.launcher.feed.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f433408a;

    @Inject
    public ImFeedLaunchTaskInjector() {
        this.f433408a = LazyKt.lazy(ImFeedLaunchTaskInjector$isIMEnabled$2.INSTANCE);
    }

    @Override // com.ss.android.lark.officesdk.launcher.feed.a
    public final void a(AppLauncherTaskScheduler r100) {
        Intrinsics.checkNotNullParameter(r100, "launcherTaskScheduler");
        if (((Boolean) this.f433408a.getValue()).booleanValue() == true) goto L5;
        return;
    L5:
        r100.a(new OfficeInitAvatarLoaderTask());
        r100.a(new OfficeInitSDKLanguageTask());
        r100.a(new UpdateEmojiTask());
        r100.a(new InitFlowNotificationTask());
        r100.a(new InitMixFeedMoltenCacheTask());
        r100.a(new InitFlowReportSameDeviceJudgeTask());
    }

    @Override // com.ss.android.lark.officesdk.launcher.feed.a
    public final void b(AppLauncherTaskScheduler r100) {
        Intrinsics.checkNotNullParameter(r100, "launcherTaskScheduler");
        if (((Boolean) this.f433408a.getValue()).booleanValue() == false) goto L6;
        r100.a(new InitDbCorruptPushTask());
        return;
    }
}
