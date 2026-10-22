package com.samsung.sdk.sperf;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.larus.apm.impl.protector.RunnableProtector;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes34.dex */
class TaskBoostReleaseHandler extends Handler implements Runnable {
    private static final int MSG_TIMEOUT = 15067;
    private SPerfManager sPerfManager;
    private int type;

    public TaskBoostReleaseHandler(Context r100, SPerfManager r101, int r102) {
        super(r100.getMainLooper());
        this.sPerfManager = r101;
        this.type = r102;
    }

    public void com_samsung_sdk_sperf_TaskBoostReleaseHandler__run$___twin___() {
        this.sPerfManager.stopBoost(this.type, PerformanceManager.getPid());
    }

    @Override // android.os.Handler
    public void handleMessage(Message r100) {
        if (r100.what != MSG_TIMEOUT) goto L7;
        run();
        return;
    }

    @Override // java.lang.Runnable
    public void run() {
        com_samsung_sdk_sperf_TaskBoostReleaseHandler_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    public void startBoostTimeout(int r100) {
        removeMessages(MSG_TIMEOUT);
        sendEmptyMessageDelayed(MSG_TIMEOUT, r100);
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void com_samsung_sdk_sperf_TaskBoostReleaseHandler_com_larus_apm_impl_protector_RunnableLancet_run(TaskBoostReleaseHandler r100) {
        r100.com_samsung_sdk_sperf_TaskBoostReleaseHandler__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
