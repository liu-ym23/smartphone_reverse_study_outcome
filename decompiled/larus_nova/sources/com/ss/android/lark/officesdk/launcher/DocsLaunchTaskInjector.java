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
public final class DocsLaunchTaskInjector implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OfficeLaunchSchedulerType f433402a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f433403b;

    @Inject
    public DocsLaunchTaskInjector() {
        this.f433402a = OfficeLaunchSchedulerType.V1;
        this.f433403b = LazyKt.lazy(DocsLaunchTaskInjector$isIMEnabled$2.INSTANCE);
    }

    @Override // com.ss.android.lark.officesdk.launcher.b
    public final OfficeLaunchSchedulerType c() {
        return this.f433402a;
    }

    @Override // com.ss.android.lark.officesdk.launcher.b
    public final void a(AppLauncherTaskScheduler r100) {
        Intrinsics.checkNotNullParameter(r100, "launcherTaskScheduler");
        if (((Boolean) this.f433403b.getValue()).booleanValue() == true) goto L5;
        r100.a(new UpdateEmojiTask());
    L5:
        kmb.c.f504125a.a(LarkContext.getApplication());
    }

    @Override // com.ss.android.lark.officesdk.launcher.b
    public final void b(AppLauncherTaskScheduler r100) {
        Intrinsics.checkNotNullParameter(r100, "launcherTaskScheduler");
    }
}
