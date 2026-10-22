package com.bytedance.ug.sdk.luckydog.task.tasktimer.view;

/* JADX INFO: loaded from: classes22.dex */
public final /* synthetic */ class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f272283a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f272284b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int[] f272285c = null;

    static {
        int[] r100 = new int[TimerTaskPendantState.values().length];
        f272283a = r100;
        TimerTaskPendantState r101 = TimerTaskPendantState.NOT_START;
        r100[r101.ordinal()] = 1;
        TimerTaskPendantState r102 = TimerTaskPendantState.COUNT_DOWN;
        r100[r102.ordinal()] = 2;
        TimerTaskPendantState r103 = TimerTaskPendantState.PAUSE;
        r100[r103.ordinal()] = 3;
        TimerTaskPendantState r104 = TimerTaskPendantState.FINISHED;
        r100[r104.ordinal()] = 4;
        int[] r105 = new int[TimerTaskPendantState.values().length];
        f272284b = r105;
        r105[r101.ordinal()] = 1;
        r105[r102.ordinal()] = 2;
        r105[r103.ordinal()] = 3;
        r105[r104.ordinal()] = 4;
        int[] r106 = new int[TimerTaskPendantState.values().length];
        f272285c = r106;
        r106[r104.ordinal()] = 1;
    }
}
