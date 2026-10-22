package com.bytedance.applet.task;

import com.bytedance.applet.aibridge.navi.NavigationPageFrom;
import com.larus.multitask_management.api.data.TaskDisplayStatus;
import com.larus.multitask_management.api.data.TaskStatus;
import com.larus.navigation.api.NavigationServiceDelegate;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class w implements il9.d {

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[TaskStatus.values().length];
            r0[TaskStatus.CANCELED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L4:
            a = r0;
        }
    }

    public w() {
    }

    public final void a(String r3, TaskDisplayStatus r4) {
        Intrinsics.checkNotNullParameter(r3, "taskId");
        Intrinsics.checkNotNullParameter(r4, "taskDisplayStatus");
        int r0 = com.larus.navigation.api.c.a;
        com.larus.navigation.api.c.d("nav_multitask_map", "onRequestTaskDisplayStatusChange: taskId=" + r3 + ", status=" + r4);
    }

    public final void b(String r3, TaskStatus r4) {
        Intrinsics.checkNotNullParameter(r3, "taskId");
        Intrinsics.checkNotNullParameter(r4, "taskStatus");
        int r0 = com.larus.navigation.api.c.a;
        com.larus.navigation.api.c.d("nav_multitask_map", "onRequestTaskStatusChange: taskId=" + r3 + ", status=" + r4 + ", currentTaskId=" + NavigationMultitaskCard.d);
        if (Intrinsics.areEqual(r3, NavigationMultitaskCard.d) == true) goto L7;
        com.larus.navigation.api.c.d("nav_multitask_map", "onRequestTaskStatusChange: " + r3 + " is not our current task (stale cross-session event), ignoring");
        return;
    L7:
        if (a.a[r4.ordinal()] != 1) goto L12;
        NavigationMultitaskCard.a.getClass();
        StringBuilder r5 = new StringBuilder("cancelNavigation: user requested cancel — stop SDK + remove card, currentTaskId=");
        String r6 = NavigationMultitaskCard.d;
        if (r6 != null) goto L11;
        r6 = "null";
    L11:
        r5.append(r6);
        r5.append(" thread=");
        r5.append(ThreadMethodProxy.currentThread().getName());
        com.larus.navigation.api.c.d("nav_multitask_map", r5.toString());
        NavigationServiceDelegate.b.a("multitask_cancel");
        Intrinsics.checkNotNullParameter("user_canceled", "reason");
        NavigationMultitaskCard.j("user_canceled", null);
        return;
    L12:
        com.larus.navigation.api.c.b("nav_multitask_map", "onRequestTaskStatusChange: unhandled status " + r4);
    }

    public final boolean c(kl9.u r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "task");
        Intrinsics.checkNotNullParameter(r5, "currentPage");
        int r1 = com.larus.navigation.api.c.a;
        com.larus.navigation.api.c.d("nav_multitask_map", "onInterceptTaskClick: task.taskId=" + r4.a + " currentPage=" + r5 + " ourTaskId=" + NavigationMultitaskCard.d + " visible=" + NavigationMultitaskCard.i);
        if (Intrinsics.areEqual(r4.a, NavigationMultitaskCard.d) == true) goto L6;
        com.larus.navigation.api.c.d("nav_multitask_map", "onInterceptTaskClick: not our task (stale cross-session event)");
        return false;
    L6:
        NavigationMultitaskCard r6 = NavigationMultitaskCard.a;
        NavigationPageFrom r7 = NavigationPageFrom.TASK;
        r6.getClass();
        NavigationMultitaskCard.e("task", r7);
        return true;
    }
}
