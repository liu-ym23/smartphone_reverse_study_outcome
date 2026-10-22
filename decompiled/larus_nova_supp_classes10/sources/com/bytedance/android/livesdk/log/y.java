package com.bytedance.android.livesdk.log;

import com.bytedance.android.live.initialize.IWTORepeatableTask;
import com.bytedance.android.live.initialize.WTOPriorityType;
import com.bytedance.android.live.initialize.WTOSceneType;
import com.bytedance.android.live.initialize.WTOThreadType;
import com.bytedance.android.live.initialize.WTOThreadWorkType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class y implements IWTORepeatableTask {
    public final String a;
    public final Map<String, String> b;
    public final Object c;

    public final boolean cancelable() {
        return true;
    }

    public final boolean isEffective() {
        return true;
    }

    public final String taskBusinessInfo() {
        return "WTO-LiveLoggerReportTask";
    }

    public final int taskID() {
        return 1031;
    }

    public final List<Integer> taskCategoryList() {
        return new ArrayList();
    }

    public final void run() {
        u.l().g(this.a, true, true, this.b, new Object[]{this.c});
    }

    public final com.bytedance.android.live.initialize.a taskExecutePeriod() {
        return com.bytedance.android.live.initialize.a.b.c;
    }

    public final WTOPriorityType taskPriorityType() {
        return WTOPriorityType.SCHEDULE;
    }

    public final WTOSceneType taskSceneType() {
        return WTOSceneType.COMMON;
    }

    public final WTOThreadType taskThreadType() {
        return WTOThreadType.WorkerThread;
    }

    public final WTOThreadWorkType taskThreadWorkType() {
        return WTOThreadWorkType.CPU_FIXED;
    }

    public y(String r2, Map<String, String> r3, Object r4) {
        Intrinsics.checkNotNullParameter(r2, "eventName");
        Intrinsics.checkNotNullParameter(r4, "args");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
