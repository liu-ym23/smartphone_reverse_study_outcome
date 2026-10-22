package com.ss.android.lark.officesdk.launcher.feed;

import android.content.Context;
import com.ss.android.lark.app.task.scheduler.AppLauncherTaskScheduler;
import com.ss.android.lark.app.task.scheduler.LaunchTaskExecutor;
import com.ss.android.lark.app.task.scheduler.TaskConsumeType;
import com.ss.android.lark.framework.assembly.appconfig.InitSettingsTask;
import com.ss.android.lark.framework.assembly.appreciable.InitAppreciableTask;
import com.ss.android.lark.framework.assembly.displaystore.OfficeInitDisplayStoreTask;
import com.ss.android.lark.framework.assembly.navigation.InitNavigationTask;
import com.ss.android.lark.framework.assembly.network.InitNetworkTask;
import com.ss.android.lark.framework.assembly.rust.InitImSdkTask;
import com.ss.android.lark.framework.assembly.watermark.InitWaterMarkTask;
import com.ss.android.lark.integrator.security.compliance.InitSecurityComplianceTask;
import com.ss.android.lark.officesdk.OfficeSDK;
import com.ss.android.lark.officesdk.experiment.LaunchExperiment;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Singleton
public final class c implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InitImSdkTask f433442a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Inject
    public Set<a> f433443b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AppLauncherTaskScheduler f433444c;

    @Override // com.ss.android.lark.officesdk.launcher.feed.b
    public final void a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        LaunchTaskExecutor r101 = LaunchTaskExecutor.b();
        r101.f408760a = false;
        r101.f408761b.clear();
        AtomicBoolean r102 = OfficeSDK.f433090a;
        LaunchExperiment r103 = OfficeSDK.f433091b.f530687a;
        AppLauncherTaskScheduler r104 = this.f433444c;
        r104.a(new InitNetworkTask());
        r104.a(new InitNavigationTask());
        r104.a(new OfficeInitDisplayStoreTask());
        r104.a(new InitAppreciableTask());
        r104.d(r100, TaskConsumeType.ONLY_SYNC);
        Set<a> r105 = this.f433443b;
        Set<a> r106 = null;
        if (r105 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("launchTaskInjectors");
        r105 = null;
    L6:
        Iterator<a> r107 = r105.iterator();
    L8:
        if (r107.hasNext() == false) goto L10;
        r107.next().b(this.f433444c);
        goto L8
    L10:
        this.f433444c.d(r100, TaskConsumeType.ONLY_SYNC);
        AppLauncherTaskScheduler r108 = this.f433444c;
        r108.a(new InitSettingsTask());
        if (r103 != LaunchExperiment.LAUNCH_ONLY_OFFICE_SDK) goto L13;
        r108.a(this.f433442a);
    L13:
        r108.a(new InitWaterMarkTask());
        r108.a(new InitSecurityComplianceTask(0));
        Set<a> r109 = this.f433443b;
        if (r109 == null) goto L16;
        r106 = r109;
    L17:
        Iterator<a> r110 = r106.iterator();
    L19:
        if (r110.hasNext() == false) goto L21;
        r110.next().a(this.f433444c);
        goto L19
    L21:
        AppLauncherTaskScheduler r111 = this.f433444c;
        r111.getClass();
        r111.b(r100, TaskConsumeType.ALL);
        LaunchTaskExecutor.b().a(this.f433444c);
        return;
    L16:
        Intrinsics.throwUninitializedPropertyAccessException("launchTaskInjectors");
        goto L17
    }

    @Inject
    public c(InitImSdkTask r100, eva.a r101) {
        Intrinsics.checkNotNullParameter(r100, "initImSdkTask");
        Intrinsics.checkNotNullParameter(r101, "launchPerfDispatcher");
        this.f433442a = r100;
        this.f433444c = new AppLauncherTaskScheduler(r101);
    }
}
