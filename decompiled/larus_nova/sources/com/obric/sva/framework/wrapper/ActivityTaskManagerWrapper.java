package com.obric.sva.framework.wrapper;

import android.app.ActivityManager;
import android.app.ActivityTaskManager;
import java.util.List;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes34.dex */
public class ActivityTaskManagerWrapper {
    private ActivityTaskManager activityTaskManager;

    @JvmStatic
    public static Class<?> getWrapperClazz() {
        return ActivityTaskManager.class;
    }

    public ActivityTaskManagerWrapper(ActivityTaskManager r100) {
        this.activityTaskManager = r100;
    }

    public List<ActivityManager.RunningTaskInfo> getTasks(int r100) {
        ActivityTaskManager r101 = this.activityTaskManager;
        if (r101 != null) goto L5;
        return null;
    L5:
        return r101.getTasks(r100);
    }

    public void registerTaskStackListener(TaskStackListenerWrapper r100) {
        ActivityTaskManager r101 = this.activityTaskManager;
        if (r101 == null) goto L6;
        r101.registerTaskStackListener(r100.listener);
        return;
    }

    public void unregisterTaskStackListener(TaskStackListenerWrapper r100) {
        ActivityTaskManager r101 = this.activityTaskManager;
        if (r101 == null) goto L6;
        r101.unregisterTaskStackListener(r100.listener);
        return;
    }
}
