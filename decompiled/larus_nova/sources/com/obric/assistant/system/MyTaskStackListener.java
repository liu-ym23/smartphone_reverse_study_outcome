package com.obric.assistant.system;

import android.app.ActivityManager;
import android.app.TaskStackListener;
import android.content.ComponentName;
import com.larus.utils.logger.FLogger;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import lha.g;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u001a\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u0018\u0010\r\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/assistant/system/MyTaskStackListener;", "Landroid/app/TaskStackListener;", "taskStackServiceImpl", "Lcom/obric/assistant/system/TaskStackServiceImpl;", "<init>", "(Lcom/obric/assistant/system/TaskStackServiceImpl;)V", "onTaskStackChanged", "", "onTaskCreated", DBDefinition.TASK_ID, "", "componentName", "Landroid/content/ComponentName;", "onTaskDisplayChanged", "newDisplayId", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MyTaskStackListener extends TaskStackListener {
    private final TaskStackServiceImpl taskStackServiceImpl;

    public void onTaskStackChanged() {
        TaskStackServiceImpl.j(this.taskStackServiceImpl);
    }

    public MyTaskStackListener(TaskStackServiceImpl r100) {
        Intrinsics.checkNotNullParameter(r100, "taskStackServiceImpl");
        this.taskStackServiceImpl = r100;
    }

    public void onTaskCreated(int r110, ComponentName r111) {
        TaskStackServiceImpl r100 = this.taskStackServiceImpl;
        r100.getClass();
        FLogger.f375446a.i("TaskStackService", "onTaskCreated taskId: " + r110 + ", componentName: " + r111);
        Object r101 = null;
        ActivityManager r102 = r100.h();     // Catch: Throwable -> L7
        if (r102 == null) goto L9;
        List<ActivityManager.RunningTaskInfo> r103 = r102.getRunningTasks(20);     // Catch: Throwable -> L7
    L10:
        boolean r104 = true;
        if (r103 == null) goto L28;
        Iterator<T> r105 = r103.iterator();
    L14:
        if (r105.hasNext() == false) goto L26;
        Object r106 = r105.next();
        ActivityManager.RunningTaskInfo r107 = (ActivityManager.RunningTaskInfo) r106;
        Intrinsics.checkNotNull(r107);
        Integer r108 = TaskStackServiceImpl.i(r107, DBDefinition.TASK_ID);
        if (r108 != null) goto L18;
        r108 = TaskStackServiceImpl.i(r107, "id");
    L18:
        if (r108 != null) goto L21;
    L23:
        boolean r109 = false;
    L24:
        if (r109 == false) goto L14;
        r101 = r106;
        goto L26
    L21:
        if (r108.intValue() != r110) goto L23;
        r109 = true;
    L26:
        r101 = (ActivityManager.RunningTaskInfo) r101;
    L28:
        if (r101 != null) goto L30;
        FLogger.f375446a.i("TaskStackService", "dispatch task-created for compatibility, taskId: " + r110 + ", componentName: " + r111 + ", reason: task not found");
    L37:
        if (r104 == false) goto L47;
        Iterator<g> r112 = r100.f393349c.iterator();
    L41:
        if (r112.hasNext() == false) goto L61;
        r112.next().onTaskCreated(r110, r111);     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        FLogger.f375446a.e("TaskStackService", "notify task created listener error", th);
        goto L41
    L61:
        return;
    L47:
        return;
    L30:
        Integer r113 = TaskStackServiceImpl.i(r101, "displayId");
        if (r113 != null) goto L34;
        FLogger.f375446a.i("TaskStackService", "dispatch task-created for compatibility, taskId: " + r110 + ", componentName: " + r111 + ", reason: display unknown");
        goto L37
    L34:
        if (r113.intValue() == 0) goto L36;
        FLogger.f375446a.i("TaskStackService", "skip task-created from non-default display, taskId: " + r110 + ", componentName: " + r111 + ", displayId: " + r113);
        r104 = false;
        goto L37
    L36:
        FLogger.f375446a.i("TaskStackService", "dispatch task-created from default display, taskId: " + r110 + ", componentName: " + r111);
    L9:
        r103 = null;
    L7:
        th = move-exception;
        FLogger.f375446a.e("TaskStackService", "getRunningTasks for task-created failed, taskId: " + r110, th);
        goto L9
    }

    public void onTaskDisplayChanged(int r100, int r101) {
        TaskStackServiceImpl r102 = this.taskStackServiceImpl;
        r102.getClass();
        FLogger.f375446a.i("TaskStackService", "onTaskDisplayChanged taskId: " + r100 + ", newDisplayId: " + r101);
        if (r101 != 0) goto L6;
        TaskStackServiceImpl.j(r102);
        return;
    }
}
