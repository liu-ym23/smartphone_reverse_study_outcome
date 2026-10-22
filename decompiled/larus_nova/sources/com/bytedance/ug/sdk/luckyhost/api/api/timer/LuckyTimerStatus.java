package com.bytedance.ug.sdk.luckyhost.api.api.timer;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/ug/sdk/luckyhost/api/api/timer/LuckyTimerStatus;", "", "TASK_TIME_CREATED", "TASK_TIME_RUNNING", "TASK_TIME_STOP", "TASK_TIME_END", "TASK_TIMER_FAILED", "TASK_TIMER_EXPIRE", "TASK_TIMER_REPORT_FAILED", "luckyhost-api_release"}, k = 1, mv = {1, 4, 0})
public final enum LuckyTimerStatus extends Enum<LuckyTimerStatus> {
    public static final LuckyTimerStatus TASK_TIMER_EXPIRE = null;
    public static final LuckyTimerStatus TASK_TIMER_FAILED = null;
    public static final LuckyTimerStatus TASK_TIMER_REPORT_FAILED = null;
    public static final LuckyTimerStatus TASK_TIME_CREATED = null;
    public static final LuckyTimerStatus TASK_TIME_END = null;
    public static final LuckyTimerStatus TASK_TIME_RUNNING = null;
    public static final LuckyTimerStatus TASK_TIME_STOP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LuckyTimerStatus[] f272302a = null;

    static {
        LuckyTimerStatus r100 = new LuckyTimerStatus("TASK_TIME_CREATED", 0);
        TASK_TIME_CREATED = r100;
        LuckyTimerStatus r101 = new LuckyTimerStatus("TASK_TIME_RUNNING", 1);
        TASK_TIME_RUNNING = r101;
        LuckyTimerStatus r102 = new LuckyTimerStatus("TASK_TIME_STOP", 2);
        TASK_TIME_STOP = r102;
        LuckyTimerStatus r103 = new LuckyTimerStatus("TASK_TIME_END", 3);
        TASK_TIME_END = r103;
        LuckyTimerStatus r104 = new LuckyTimerStatus("TASK_TIMER_FAILED", 4);
        TASK_TIMER_FAILED = r104;
        LuckyTimerStatus r105 = new LuckyTimerStatus("TASK_TIMER_EXPIRE", 5);
        TASK_TIMER_EXPIRE = r105;
        LuckyTimerStatus r106 = new LuckyTimerStatus("TASK_TIMER_REPORT_FAILED", 6);
        TASK_TIMER_REPORT_FAILED = r106;
        f272302a = new LuckyTimerStatus[]{r100, r101, r102, r103, r104, r105, r106};
    }

    public static LuckyTimerStatus valueOf(String r100) {
        return (LuckyTimerStatus) a.a(LuckyTimerStatus.class, r100);
    }

    public static LuckyTimerStatus[] values() {
        return (LuckyTimerStatus[]) f272302a.clone();
    }

    public LuckyTimerStatus(String r100, int r101) {
        super(r100, r101);
    }
}
