package com.samsung.sdk.sperf;

/* JADX INFO: loaded from: classes34.dex */
public class CustomParams {
    protected static final int BOOST_TYPE_NORMAL = 0;
    protected static final int BOOST_TYPE_TASK = 1;
    public static final int TYPE_BUS_MAX = 5;
    public static final int TYPE_BUS_MIN = 4;
    public static final int TYPE_CPU_AWAKE = 10;
    public static final int TYPE_CPU_CORE_NUM_MAX = 7;
    public static final int TYPE_CPU_CORE_NUM_MIN = 6;
    public static final int TYPE_CPU_MAX = 1;
    public static final int TYPE_CPU_MIN = 0;
    public static final int TYPE_GPU_MAX = 3;
    public static final int TYPE_GPU_MIN = 2;
    protected static final int TYPE_NUM = 11;
    public static final int TYPE_TASK_AFFINITY = 8;
    public static final int TYPE_TASK_PRIORITY = 9;
    private static SPerfManager sPerfManager;
    private BoostObject boostObj;
    private boolean isBoostObjUpdated;

    public CustomParams() {
        this.boostObj = null;
        this.isBoostObjUpdated = false;
    }

    public static int getBoostType(int r100) {
        if (r100 != 8) goto L5;
        return 1;
    L5:
        if (r100 == 9) goto L10;
        return 0;
    L10:
        return 1;
    }

    public int add(int r100, int r101, int r102) {
        monitor-enter(this);
    L18:
        th = move-exception;
        throw th;
    L4:
        if (this.boostObj != null) goto L7;
        this.boostObj = new BoostObject();     // Catch: Throwable -> L18
        this.isBoostObjUpdated = false;     // Catch: Throwable -> L18
    L7:
        if (sPerfManager != null) goto L13;
        SPerfManager r103 = SPerfManager.createInstance(null);     // Catch: Throwable -> L18
        sPerfManager = r103;     // Catch: Throwable -> L18
        if (r103 != null) goto L13;
        monitor-exit(this);
        return -1;
    L13:
        int r104 = sPerfManager.updateBoost(r100, r101, r102, this.boostObj);     // Catch: Throwable -> L18
        if (r104 < 0) goto L16;
        this.isBoostObjUpdated = true;     // Catch: Throwable -> L18
    L16:
        monitor-exit(this);
        return r104;
    }

    public BoostObject getBoostObject() {
        if (this.isBoostObjUpdated == true) goto L7;
        return null;
    L7:
        return this.boostObj;
    }
}
