package com.bytedance.ug.sdk.luckydog.task.newTimer.counter.pendant;

import com.bytedance.ug.sdk.luckydog.api.task.pendant.CounterPendantState;

/* JADX INFO: loaded from: classes22.dex */
public final /* synthetic */ class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f272027a = null;

    static {
        int[] r100 = new int[CounterPendantState.values().length];
        f272027a = r100;
        r100[CounterPendantState.PENDANT_STATE_GUIDE.ordinal()] = 1;
        r100[CounterPendantState.PENDANT_STATE_NEED_LOGIN.ordinal()] = 2;
        r100[CounterPendantState.PENDANT_STATE_COUNTING_UNFOLD.ordinal()] = 3;
        r100[CounterPendantState.PENDANT_STATE_TIMING_UNFOLD.ordinal()] = 4;
        r100[CounterPendantState.PENDANT_STATE_COUNTING_FOLD.ordinal()] = 5;
        r100[CounterPendantState.PENDANT_STATE_TIMING_FOLD.ordinal()] = 6;
        r100[CounterPendantState.PENDANT_STATE_FINISH_UNFOLD.ordinal()] = 7;
        r100[CounterPendantState.PENDANT_STATE_FINISH_FOLD.ordinal()] = 8;
    }
}
