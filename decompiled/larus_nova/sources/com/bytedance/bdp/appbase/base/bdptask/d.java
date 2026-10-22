package com.bytedance.bdp.appbase.base.bdptask;

/* JADX INFO: loaded from: classes11.dex */
public final /* synthetic */ class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f200490a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f200491b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int[] f200492c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int[] f200493d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int[] f200494e = null;

    static {
        int[] r100 = new int[BdpTask.TaskType.values().length];
        f200490a = r100;
        BdpTask.TaskType r101 = BdpTask.TaskType.OWN;
        r100[r101.ordinal()] = 1;
        BdpTask.TaskType r102 = BdpTask.TaskType.CPU;
        r100[r102.ordinal()] = 2;
        int[] r103 = new int[BdpTask.TaskType.values().length];
        f200491b = r103;
        r103[r101.ordinal()] = 1;
        r103[r102.ordinal()] = 2;
        int[] r104 = new int[BdpTask.TaskType.values().length];
        f200492c = r104;
        BdpTask.TaskType r105 = BdpTask.TaskType.IO;
        r104[r105.ordinal()] = 1;
        r104[r101.ordinal()] = 2;
        int[] r106 = new int[BdpTask.TaskType.values().length];
        f200493d = r106;
        r106[r101.ordinal()] = 1;
        r106[r102.ordinal()] = 2;
        r106[r105.ordinal()] = 3;
        r106[BdpTask.TaskType.LOGIC.ordinal()] = 4;
        r106[BdpTask.TaskType.MAIN.ordinal()] = 5;
        int[] r107 = new int[BdpTask.TaskType.values().length];
        f200494e = r107;
        r107[r101.ordinal()] = 1;
        r107[r102.ordinal()] = 2;
        r107[r105.ordinal()] = 3;
    }
}
