package com.bytedance.ug.sdk.luckydog.task.newTimer.pendant;

import com.bytedance.ug.sdk.luckydog.api.task.pendant.PendantState;

/* JADX INFO: loaded from: classes22.dex */
public final /* synthetic */ class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f272165a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f272166b = null;

    static {
        int[] r100 = new int[PendantState.values().length];
        f272165a = r100;
        PendantState r101 = PendantState.NEED_LOGIN;
        r100[r101.ordinal()] = 1;
        PendantState r102 = PendantState.COUNT_DOWN;
        r100[r102.ordinal()] = 2;
        PendantState r103 = PendantState.FINISHED;
        r100[r103.ordinal()] = 3;
        int[] r104 = new int[PendantState.values().length];
        f272166b = r104;
        r104[r101.ordinal()] = 1;
        r104[r102.ordinal()] = 2;
        r104[r103.ordinal()] = 3;
    }
}
