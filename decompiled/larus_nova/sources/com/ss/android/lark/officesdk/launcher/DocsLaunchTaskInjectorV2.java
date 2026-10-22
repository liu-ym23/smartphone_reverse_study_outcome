package com.ss.android.lark.officesdk.launcher;

import com.ss.android.lark.app.task.scheduler.AppLauncherTaskScheduler;
import com.ss.android.lark.framework.assembly.emoji_office.UpdateEmojiTask;
import com.ss.android.lark.utils.LarkContext;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Singleton
public final class DocsLaunchTaskInjectorV2 implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OfficeLaunchSchedulerType f433404a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f433405b;

    @Inject
    public DocsLaunchTaskInjectorV2() {
        this.f433404a = OfficeLaunchSchedulerType.V2;
        this.f433405b = LazyKt.lazy(DocsLaunchTaskInjectorV2$isIMEnabled$2.INSTANCE);
    }

    @Override // com.ss.android.lark.officesdk.launcher.b
    public final OfficeLaunchSchedulerType c() {
        return this.f433404a;
    }

    @Override // com.ss.android.lark.officesdk.launcher.b
    public final void a(AppLauncherTaskScheduler r100) {
        Intrinsics.checkNotNullParameter(r100, "launcherTaskScheduler");
        if (((Boolean) this.f433405b.getValue()).booleanValue() == true) goto L5;
        r100.a(new UpdateEmojiTask());
    L5:
        kmb.c.f504125a.a(LarkContext.getApplication());
    }

    @Override // com.ss.android.lark.officesdk.launcher.b
    public final void b(AppLauncherTaskScheduler r100) {
        Intrinsics.checkNotNullParameter(r100, "launcherTaskScheduler");
    }
}
