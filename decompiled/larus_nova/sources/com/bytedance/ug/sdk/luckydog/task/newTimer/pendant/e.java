package com.bytedance.ug.sdk.luckydog.task.newTimer.pendant;

import com.bytedance.ug.sdk.luckyhost.api.api.timer.LuckyTimerStatus;

/* JADX INFO: loaded from: classes22.dex */
public final /* synthetic */ class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f272135a = null;

    static {
        int[] r100 = new int[LuckyTimerStatus.values().length];
        f272135a = r100;
        r100[LuckyTimerStatus.TASK_TIMER_REPORT_FAILED.ordinal()] = 1;
        r100[LuckyTimerStatus.TASK_TIMER_EXPIRE.ordinal()] = 2;
        r100[LuckyTimerStatus.TASK_TIMER_FAILED.ordinal()] = 3;
        r100[LuckyTimerStatus.TASK_TIME_END.ordinal()] = 4;
    }
}
