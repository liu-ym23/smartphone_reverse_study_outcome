package com.samsung.sdk.sperf;

import android.content.Context;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.HashMap;

/* JADX INFO: loaded from: classes34.dex */
class SPerfManager {
    private static BoostLevelControl boostLevelControl;
    private static Context mContext;
    private static SPerfManager mInstance;
    private static int nextBoostObjectID;
    private static HashMap<Integer, TaskBoostReleaseHandler> releaserHash;
    private static SPerfInitThread sPerfThread;
    private static SessionControl sessionControl;

    static {
        sPerfThread = new SPerfInitThread();
        mContext = null;
        releaserHash = new HashMap();
    }

    private SPerfManager() {
    }

    public static SPerfManager createInstance(Context r100) {
        monitor-enter(SPerfManager.class);
        SPerfManager r101 = mInstance;     // Catch: Throwable -> L28
        if (r101 != null) goto L7;
        r101 = null;
        if (r100 != null) goto L12;
        SPerfUtil.logAlways("ERROR : Context is Null");     // Catch: Throwable -> L28
        goto L7
    L12:
        PthreadThreadV2 r102 = new PthreadThreadV2(sPerfThread, "/SPerfManager");     // Catch: Throwable -> L28
        ThreadMethodProxy.start(r102);     // Catch: IllegalThreadStateException -> L23 InterruptedException -> L25 Throwable -> L28
        ThreadMethodProxy.join(r102);     // Catch: IllegalThreadStateException -> L23 InterruptedException -> L25 Throwable -> L28
        r101 = sPerfThread.getSPerfManager();     // Catch: Throwable -> L28
        mContext = r100;     // Catch: Throwable -> L28
        int r103 = 0;
    L16:
        if (r103 >= 11) goto L7;
        if (CustomParams.getBoostType(r103) != 1) goto L22;
        if (mContext == null) goto L22;
        HashMap<Integer, TaskBoostReleaseHandler> r104 = releaserHash;     // Catch: Throwable -> L28
        TaskBoostReleaseHandler r105 = new TaskBoostReleaseHandler(mContext, r101, r103);     // Catch: Throwable -> L28
        r104.put(Integer.valueOf(r103), r105);     // Catch: Throwable -> L28
    L22:
        r103 = r103 + 1;     // Catch: Throwable -> L28
        goto L16
    L23:
        e = move-exception;
        SPerfUtil.logAlways("ERROR : IllegalThreadStateException");     // Catch: Throwable -> L28
        e.printStackTrace();     // Catch: Throwable -> L28
    L25:
        e = move-exception;
        SPerfUtil.logAlways("ERROR : InterruptedException");     // Catch: Throwable -> L28
        e.printStackTrace();     // Catch: Throwable -> L28
    L7:
        monitor-exit(SPerfManager.class);
        return r101;
    L28:
        th = move-exception;
        throw th;
    }

    public static SPerfManager initSPerfManager() {
        if (mInstance != null) goto L14;
        SessionControl r100 = SessionControl.createInstance();
        sessionControl = r100;
        if (r100 != null) goto L9;
        String r101 = "ERROR : Initialize Fail (Session)";
    L7:
        SPerfUtil.logAlways(r101);
        return null;
    L9:
        BoostLevelControl r102 = BoostLevelControl.createInstance(r100);
        boostLevelControl = r102;
        if (r102 != null) goto L12;
        r101 = "ERROR : Initialize Fail (BoostingLevelSet)";
        goto L7
    L12:
        mInstance = new SPerfManager();
    L14:
        return mInstance;
    }

    public static void startTaskReleaseHandler(int r100, int r101) {
        HashMap<Integer, TaskBoostReleaseHandler> r102 = releaserHash;
        if (r102 != null) goto L5;
        return;
    L5:
        r102.get(Integer.valueOf(r100)).startBoostTimeout(r101);
    }

    public void addSPerfListerner(SPerfListener r100) {
        if (r100 != null) goto L6;
        String r101 = "ERROR : Null listener (addPerfSDKListerner)";
    L4:
        SPerfUtil.log(r101);
        return;
    L6:
        SessionControl r102 = sessionControl;
        if (r102 != null) goto L9;
        r101 = "ERROR : SessionControl Should be initialized";
        goto L4
    L9:
        r102.addListerner(r100);
    }

    public int createBoostID() {
        monitor-enter(this);
        int r100 = nextBoostObjectID;     // Catch: Throwable -> L6
        nextBoostObjectID = r100 + 1;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public int startBoost(BoostObject r100) {
        if (r100 != null) goto L7;
        SPerfUtil.log("ERROR : null boost object (doBoost)");
        return -1;
    L7:
        if (r100.getID() != (-1)) goto L10;
        r100.setID(createBoostID());
    L10:
        return Boost.requestNativeBoost(r100);
    }

    public int startPresetBoost(int r100, int r101) {
        BoostLevelControl r102 = boostLevelControl;
        if (r102 != null) goto L7;
        String r103 = "ERROR : BoostLevelControl Should be initialized";
    L5:
        SPerfUtil.log(r103);
        return -1;
    L7:
        if (r101 >= 0) goto L10;
        r103 = "ERROR : timeout coundn't be less than 0";
        goto L5
    L10:
        return startBoost(r102.getBoostObjectByScenario(r100, r101));
    }

    public int stopBoost() {
        if (boostLevelControl != null) goto L7;
        SPerfUtil.log("ERROR : BoostLevelControl Should be initialized");
        return -1;
    L7:
        return Boost.releaseNativeBoost();
    }

    public int stopBoost(int r100, int r101) {
        if (boostLevelControl != null) goto L7;
        SPerfUtil.log("ERROR : BoostLevelControl Should be initialized");
        return -1;
    L7:
        return Boost.releaseNativeBoost(r100, r101);
    }

    public int updateBoost(int r100, int r101, int r102, BoostObject r103) {
        BoostLevelControl r104 = boostLevelControl;
        if (r104 != null) goto L7;
        SPerfUtil.log("ERROR : Initialize Fail boostLevel not exist (updateBoost)");
        return -1;
    L7:
        return r104.updateBoost(r100, r101, r102, r103);
    }
}
