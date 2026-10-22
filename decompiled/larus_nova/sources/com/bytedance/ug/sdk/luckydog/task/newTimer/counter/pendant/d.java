package com.bytedance.ug.sdk.luckydog.task.newTimer.counter.pendant;

import com.bytedance.ug.sdk.luckydog.api.task.pendant.CounterPendantState;
import com.bytedance.ug.sdk.luckyhost.api.api.countTimer.LuckyCounterPendantHideFrom;
import com.bytedance.ug.sdk.luckyhost.api.api.countTimer.LuckyCounterTaskStatus;
import com.bytedance.ug.sdk.luckyhost.api.api.countTimer.LuckyCounterTimerStatus;

/* JADX INFO: loaded from: classes22.dex */
public final /* synthetic */ class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f272028a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f272029b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int[] f272030c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int[] f272031d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int[] f272032e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int[] f272033f = null;

    static {
        int[] r100 = new int[LuckyCounterPendantHideFrom.values().length];
        f272028a = r100;
        r100[LuckyCounterPendantHideFrom.QUIT_SCENE.ordinal()] = 1;
        int[] r101 = new int[LuckyCounterTimerStatus.values().length];
        f272029b = r101;
        r101[LuckyCounterTimerStatus.TIMER_DONE.ordinal()] = 1;
        r101[LuckyCounterTimerStatus.TIMER_SUPPLEMENT.ordinal()] = 2;
        int[] r102 = new int[LuckyCounterTaskStatus.values().length];
        f272030c = r102;
        r102[LuckyCounterTaskStatus.TASK_STATUS_EXPIRED.ordinal()] = 1;
        r102[LuckyCounterTaskStatus.TASK_STATUS_FAILED.ordinal()] = 2;
        r102[LuckyCounterTaskStatus.TASK_STATUS_COMPLETE.ordinal()] = 3;
        r102[LuckyCounterTaskStatus.TASK_STATUS_ACK_FAILED.ordinal()] = 4;
        int[] r103 = new int[CounterPendantState.values().length];
        f272031d = r103;
        r103[CounterPendantState.UNKNOW.ordinal()] = 1;
        r103[CounterPendantState.PENDANT_STATE_DESTROYED.ordinal()] = 2;
        r103[CounterPendantState.PENDANT_STATE_GUIDE.ordinal()] = 3;
        CounterPendantState r104 = CounterPendantState.PENDANT_STATE_NEED_LOGIN;
        r103[r104.ordinal()] = 4;
        CounterPendantState r105 = CounterPendantState.PENDANT_STATE_FINISH_UNFOLD;
        r103[r105.ordinal()] = 5;
        CounterPendantState r106 = CounterPendantState.PENDANT_STATE_FINISH_FOLD;
        r103[r106.ordinal()] = 6;
        CounterPendantState r107 = CounterPendantState.PENDANT_STATE_TIMING_UNFOLD;
        r103[r107.ordinal()] = 7;
        CounterPendantState r110 = CounterPendantState.PENDANT_STATE_TIMING_FOLD;
        r103[r110.ordinal()] = 8;
        CounterPendantState r111 = CounterPendantState.PENDANT_STATE_COUNTING_FOLD;
        r103[r111.ordinal()] = 9;
        CounterPendantState r112 = CounterPendantState.PENDANT_STATE_COUNTING_UNFOLD;
        r103[r112.ordinal()] = 10;
        int[] r108 = new int[CounterPendantState.values().length];
        f272032e = r108;
        r108[r112.ordinal()] = 1;
        r108[r107.ordinal()] = 2;
        int[] r109 = new int[CounterPendantState.values().length];
        f272033f = r109;
        r109[r104.ordinal()] = 1;
        r109[r110.ordinal()] = 2;
        r109[r111.ordinal()] = 3;
        r109[r105.ordinal()] = 4;
        r109[r106.ordinal()] = 5;
    }
}
