package com.bytedance.bdp.appbase.chain;

import com.bytedance.bdp.appbase.base.bdptask.BdpTask;

/* JADX INFO: loaded from: classes11.dex */
public final /* synthetic */ class h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f200740a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f200741b = null;

    static {
        int[] r100 = new int[BdpTask.TaskType.values().length];
        f200740a = r100;
        BdpTask.TaskType r101 = BdpTask.TaskType.MAIN;
        r100[r101.ordinal()] = 1;
        int[] r102 = new int[BdpTask.TaskType.values().length];
        f200741b = r102;
        r102[r101.ordinal()] = 1;
        r102[BdpTask.TaskType.LOGIC.ordinal()] = 2;
        r102[BdpTask.TaskType.OWN.ordinal()] = 3;
        r102[BdpTask.TaskType.CPU.ordinal()] = 4;
        r102[BdpTask.TaskType.IO.ordinal()] = 5;
    }
}
