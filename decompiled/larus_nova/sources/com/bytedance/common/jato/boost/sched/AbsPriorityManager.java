package com.bytedance.common.jato.boost.sched;

import android.app.Application;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes3.dex */
public class AbsPriorityManager {
    public static int sVersion;

    public static void resetPriority() {
        int r100 = sVersion;
        if (r100 != 1) goto L6;
        PriorityManager.resetPriority();
        return;
    L6:
        if (r100 != 2) goto L10;
        PriorityManagerV2.resetPriority();
        return;
    }

    public static void resetRenderThread() {
        int r100 = sVersion;
        if (r100 != 1) goto L6;
        PriorityManager.resetRenderThread();
        return;
    L6:
        if (r100 != 2) goto L10;
        PriorityManagerV2.resetRenderThread();
        return;
    }

    public static void resetPriority(int r100) {
        int r101 = sVersion;
        if (r101 != 1) goto L6;
        PriorityManager.resetPriority(r100);
        return;
    L6:
        if (r101 != 2) goto L10;
        PriorityManagerV2.resetPriority(r100);
        return;
    }

    public static void setPriority(int r100) {
        int r101 = sVersion;
        if (r101 != 1) goto L6;
        PriorityManager.setPriority(r100);
        return;
    L6:
        if (r101 != 2) goto L10;
        PriorityManagerV2.setPriority(r100);
        return;
    }

    public static void setVersion(int r100) {
        if (sVersion != 0) goto L6;
        sVersion = r100;
        return;
    }

    public static void init(boolean r100, boolean r101) {
        int r102 = sVersion;
        if (r102 != 1) goto L6;
        return;
    L6:
        if (r102 != 2) goto L9;
        PriorityManagerV2.init(r100, r101);
        return;
    }

    public static void setPriority(int r100, int r101) {
        int r102 = sVersion;
        if (r102 != 1) goto L6;
        PriorityManager.setPriority(r100, r101);
        return;
    L6:
        if (r102 != 2) goto L10;
        PriorityManagerV2.setPriority(r100, r101);
        return;
    }

    public static void promoteRenderThread(Application r100, ExecutorService r101, int r102) {
        int r103 = sVersion;
        if (r103 != 1) goto L6;
        PriorityManager.promoteRenderThread(r100, r101, r102);
        return;
    L6:
        if (r103 != 2) goto L10;
        PriorityManagerV2.promoteRenderThread(r100, r102);
        return;
    }
}
