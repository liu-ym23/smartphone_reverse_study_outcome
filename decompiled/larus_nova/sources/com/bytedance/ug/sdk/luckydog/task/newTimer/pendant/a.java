package com.bytedance.ug.sdk.luckydog.task.newTimer.pendant;

import com.bytedance.ug.sdk.luckyhost.api.api.timer.LuckyTimerStatus;

/* JADX INFO: loaded from: classes22.dex */
public final /* synthetic */ class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f272118a = null;

    static {
        int[] r100 = new int[LuckyTimerStatus.values().length];
        f272118a = r100;
        r100[LuckyTimerStatus.TASK_TIME_RUNNING.ordinal()] = 1;
        r100[LuckyTimerStatus.TASK_TIME_STOP.ordinal()] = 2;
        r100[LuckyTimerStatus.TASK_TIME_END.ordinal()] = 3;
        r100[LuckyTimerStatus.TASK_TIMER_EXPIRE.ordinal()] = 4;
    }
}
