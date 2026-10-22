package com.ss.android.lark.app.task.scheduler;

import android.content.Context;
import com.larksuite.framework.launch.task.ILaunchTask;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.app.task.central.CentralStageFinishedTask;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.LinkedBlockingDeque;

/* JADX INFO: loaded from: classes34.dex */
public class LaunchTaskExecutor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f408760a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinkedBlockingDeque<TaskWrapper> f408761b;

    public interface IExecutor {
    }

    public static class InstanceHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final LaunchTaskExecutor f408762a = null;

        static {
            f408762a = new LaunchTaskExecutor(0);
        }
    }

    public static final class TaskWrapper {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ILaunchTask f408763a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final IExecutor f408764b;

        public TaskWrapper(ILaunchTask r100, IExecutor r101) {
            this.f408763a = r100;
            this.f408764b = r101;
        }
    }

    private LaunchTaskExecutor() {
        this.f408760a = false;
        this.f408761b = new LinkedBlockingDeque();
    }

    public static LaunchTaskExecutor b() {
        return InstanceHolder.f408762a;
    }

    public /* synthetic */ LaunchTaskExecutor(int r100) {
        this();
    }

    public final void a(AppLauncherTaskScheduler r100) {
        TaskDependencyResolver r101 = r100.f408752a;
        monitor-enter(r101);
        ArrayList r102 = new ArrayList();     // Catch: Throwable -> L27
        Iterator r103 = ((LinkedHashMap) r101.f408772f).entrySet().iterator();     // Catch: Throwable -> L27
    L6:
        if (r103.hasNext() == false) goto L11;
        Map.Entry r104 = (Map.Entry) r103.next();     // Catch: Throwable -> L27
        if (((ILaunchTask) r104.getValue()).g() == true) goto L6;
        r102.add((Class) r104.getKey());     // Catch: Throwable -> L27
        goto L6
    L11:
        monitor-exit(r101);
        CentralStageFinishedTask r105 = new CentralStageFinishedTask(r102);
        TaskWrapper r106 = null;
        if (CollectionUtils.isEmpty(null) == false) goto L26;
        r100.a(r105);
    L16:
        if (this.f408760a == true) goto L25;
        r106 = this.f408761b.take();     // Catch: InterruptedException -> L19
    L21:
        if (r106 == null) goto L16;
        ILaunchTask r107 = r106.f408763a;
        if (r107 == null) goto L16;
        AppLauncherTaskScheduler r108 = ((AppLauncherTaskScheduler.AnonymousClass2) r106.f408764b).f408759a;
        Context r109 = r108.f408753b;
        TaskConsumeType r110 = TaskConsumeType.ALL;
        r108.c(r107, r109);
        r108.b(r109, r110);
    L19:
        e = move-exception;
        e.printStackTrace();
        goto L21
    L25:
        return;
    L26:
        throw null;
    L27:
        th = move-exception;
        throw th;
    }
}
