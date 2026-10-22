package com.bytedance.sysoptimizer;

import android.os.Process;

/* JADX INFO: loaded from: classes22.dex */
public class ThreadPriorityBooster {
    private static final int PRIORITY_NOT_ADJUSTED = Integer.MAX_VALUE;
    private static final String TAG = "ThreadPriorityBooster";
    private volatile int mBoostToPriority;
    private final ThreadLocal<PriorityState> mThreadState;

    public static class PriorityState {
        int prevPriority;
        int regionCounter;
        int tid;

        private PriorityState() {
            this.tid = Process.myTid();
            this.prevPriority = Integer.MAX_VALUE;
        }

        public /* synthetic */ PriorityState(AnonymousClass1 r100) {
            this();
        }
    }

    public void boost() {
        PriorityState r100 = this.mThreadState.get();
        if (r100.regionCounter != 0) goto L7;
        int r101 = Process.getThreadPriority(r100.tid);
        if (r101 <= this.mBoostToPriority) goto L7;
        Process.setThreadPriority(r100.tid, this.mBoostToPriority);
        r100.prevPriority = r101;
    L7:
        r100.regionCounter++;
    }

    public void reset() {
        PriorityState r100 = this.mThreadState.get();
        int r101 = r100.regionCounter - 1;
        r100.regionCounter = r101;
        if (r101 != 0) goto L8;
        int r102 = r100.prevPriority;
        if (r102 == Integer.MAX_VALUE) goto L9;
        Process.setThreadPriority(r100.tid, r102);
        r100.prevPriority = Integer.MAX_VALUE;
        return;
    L9:
        return;
    }

    public ThreadPriorityBooster(int r100) {
        this.mThreadState = new AnonymousClass1(this);
        this.mBoostToPriority = r100;
    }

    public void setBoostToPriority(int r100) {
        this.mBoostToPriority = r100;
        PriorityState r101 = this.mThreadState.get();
        if (r101.regionCounter != 0) goto L5;
        return;
    L5:
        if (Process.getThreadPriority(r101.tid) == r100) goto L9;
        Process.setThreadPriority(r101.tid, r100);
        return;
    }
}
