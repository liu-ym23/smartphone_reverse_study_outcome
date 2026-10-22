package com.bytedance.bdp.appbase.base.bdptask;

/* JADX INFO: loaded from: classes11.dex */
public final /* synthetic */ class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f200510a = null;

    static {
        int[] r100 = new int[BdpTask.Stage.values().length];
        f200510a = r100;
        r100[BdpTask.Stage.DELAY.ordinal()] = 1;
        r100[BdpTask.Stage.QUEUE.ordinal()] = 2;
        r100[BdpTask.Stage.EXECUTE.ordinal()] = 3;
        r100[BdpTask.Stage.FINISH.ordinal()] = 4;
    }
}
