package com.bytedance.ug.sdk.luckydog.task.tasktimer.view;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/ug/sdk/luckydog/task/tasktimer/view/TimerTaskPendantState;", "", "", "tipsContext", "Ljava/lang/String;", "getTipsContext", "()Ljava/lang/String;", "setTipsContext", "(Ljava/lang/String;)V", "NOT_START", "COUNT_DOWN", "PAUSE", "FINISHED", "luckydog-task_release"}, k = 1, mv = {1, 4, 0})
public final enum TimerTaskPendantState extends Enum<TimerTaskPendantState> {
    public static final TimerTaskPendantState COUNT_DOWN = null;
    public static final TimerTaskPendantState FINISHED = null;
    public static final TimerTaskPendantState NOT_START = null;
    public static final TimerTaskPendantState PAUSE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TimerTaskPendantState[] f272281a = null;
    private String tipsContext;

    static {
        TimerTaskPendantState r100 = new TimerTaskPendantState("NOT_START", 0, "未开始");
        NOT_START = r100;
        TimerTaskPendantState r101 = new TimerTaskPendantState("COUNT_DOWN", 1, "计时中");
        COUNT_DOWN = r101;
        TimerTaskPendantState r102 = new TimerTaskPendantState("PAUSE", 2, "暂停");
        PAUSE = r102;
        TimerTaskPendantState r103 = new TimerTaskPendantState("FINISHED", 3, "结束");
        FINISHED = r103;
        f272281a = new TimerTaskPendantState[]{r100, r101, r102, r103};
    }

    public static TimerTaskPendantState valueOf(String r100) {
        return (TimerTaskPendantState) r27.a.a(TimerTaskPendantState.class, r100);
    }

    public static TimerTaskPendantState[] values() {
        return (TimerTaskPendantState[]) f272281a.clone();
    }

    public final String getTipsContext() {
        return this.tipsContext;
    }

    public final void setTipsContext(String r100) {
        this.tipsContext = r100;
    }

    public TimerTaskPendantState(String r100, int r101, String r102) {
        super(r100, r101);
        this.tipsContext = r102;
    }
}
