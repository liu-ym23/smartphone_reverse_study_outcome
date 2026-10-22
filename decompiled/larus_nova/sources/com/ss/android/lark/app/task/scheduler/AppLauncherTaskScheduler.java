package com.ss.android.lark.app.task.scheduler;

import android.content.Context;
import com.larksuite.framework.launch.task.AbstractLaunchTask;
import com.larksuite.framework.launch.task.ILaunchTask;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larksuite.framework.utils.CollectionUtils;
import com.larksuite.framework.utils.DevEnvUtil;
import com.ss.android.lark.app.task.central.CentralStageFinishedTask;
import com.ss.android.lark.log.Log;
import eva.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes34.dex */
public class AppLauncherTaskScheduler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TaskDependencyResolver f408752a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Context f408753b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ScheduledExecutorService f408754c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f408755d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<String> f408756e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final LaunchTaskExecutor.IExecutor f408757f;

    /* JADX INFO: renamed from: com.ss.android.lark.app.task.scheduler.AppLauncherTaskScheduler$2, reason: invalid class name */
    public class AnonymousClass2 implements LaunchTaskExecutor.IExecutor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AppLauncherTaskScheduler f408759a;

        public AnonymousClass2(AppLauncherTaskScheduler r100) {
            this.f408759a = r100;
        }
    }

    public AppLauncherTaskScheduler(a r100) {
        ScheduledExecutorService r101 = CoreThreadPool.getDefault().getScheduleThreadPool();
        this.f408756e = new CopyOnWriteArrayList();
        this.f408757f = new AnonymousClass2(this);
        this.f408754c = r101;
        this.f408755d = r100;
        this.f408752a = new TaskDependencyResolver();
    }

    public final void a(AbstractLaunchTask r100) {
        Log.i("AppLauncherTaskSchedule", "addTask taskName:" + r100.f());
        ((CopyOnWriteArrayList) this.f408756e).add(r100.f());
        TaskDependencyResolver r101 = this.f408752a;
        monitor-enter(r101);
        r101.b(r100, r100.e());     // Catch: Throwable -> L7
        monitor-exit(r101);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final void b(final Context r100, final TaskConsumeType r101) {
        Iterator r102 = ((ArrayList) this.f408752a.c(r101)).iterator();
    L4:
        if (r102.hasNext() == false) goto L22;
        final ILaunchTask r103 = (ILaunchTask) r102.next();
        Runnable r104 = new gva.a(this, r103, r100, r101);
        if (r103.g() == true) goto L8;
        this.f408753b = r100;
        LaunchTaskExecutor r105 = LaunchTaskExecutor.InstanceHolder.f408762a;
        LaunchTaskExecutor.IExecutor r106 = this.f408757f;
        monitor-enter(r105);
        r105.f408761b.add(new LaunchTaskExecutor.TaskWrapper(r103, r106));     // Catch: Throwable -> L19
        monitor-exit(r105);     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        throw th;
    L8:
        if ((r103 instanceof CentralStageFinishedTask) == true) goto L9;
        if (r103.c() > 0) goto L12;
        this.f408754c.execute(r104);
        goto L4
    L12:
        this.f408754c.schedule(r104, r103.c(), TimeUnit.SECONDS);
        goto L4
    L9:
        r103.a(r100);
        goto L4
    }

    public final void c(ILaunchTask r100, Context r101) {
        a r102 = this.f408755d;
        if (r102 == null) goto L22;
        r102.beginSection(r100.f());
    L22:
        r100.a(r101);     // Catch: Throwable -> L9
        this.f408752a.d(r100);
        a r103 = this.f408755d;
        if (r103 == null) goto L26;
    L15:
        r103.endSection();
        return;
    L26:
        return;
    L9:
        th = move-exception;
        Log.e("AppLauncherTaskSchedule", "[" + r100.f() + "]" + th.getMessage(), th);     // Catch: Throwable -> L17
        if (DevEnvUtil.isDebugMode(r101) == false) goto L13;
        CoreThreadPool.getSerialTaskHandler().postAtFrontOfQueue(new AnonymousClass1(th));     // Catch: Throwable -> L17
    L13:
        this.f408752a.d(r100);
        r103 = this.f408755d;
        if (r103 != null) goto L15;
        return;
    L17:
        th = move-exception;
        this.f408752a.d(r100);
        a r104 = this.f408755d;
        if (r104 == null) goto L21;
        r104.endSection();
    L21:
        throw th;
    }

    public final void d(Context r100, TaskConsumeType r101) {
    L2:
        List<ILaunchTask> r102 = this.f408752a.c(r101);
        if (CollectionUtils.isEmpty(r102) == true) goto L4;
        Iterator r103 = ((ArrayList) r102).iterator();
    L7:
        if (r103.hasNext() == false) goto L2;
        c((ILaunchTask) r103.next(), r100);
        goto L7
    }
}
