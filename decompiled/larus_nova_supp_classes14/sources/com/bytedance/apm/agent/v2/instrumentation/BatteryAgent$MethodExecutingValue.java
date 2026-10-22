package com.bytedance.apm.agent.v2.instrumentation;

import android.os.SystemClock;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class BatteryAgent$MethodExecutingValue {
    private long end;
    private int exeCount;
    private int leftCount;
    private long start;

    public void methodIn() {
        if (this.exeCount != 0) goto L5;
        this.start = SystemClock.currentThreadTimeMillis();
    L5:
        this.leftCount++;
        this.exeCount++;
    }

    public boolean methodOut() {
        int r0 = this.leftCount - 1;
        this.leftCount = r0;
        if (r0 != 0) goto L6;
        this.end = SystemClock.currentThreadTimeMillis();
        return true;
    L6:
        return false;
    }

    public BatteryAgent$MethodExecutingValue() {
        this.start = 0;
        this.end = 0;
        this.leftCount = 0;
        this.exeCount = 0;
    }

    public static /* synthetic */ int access$000(BatteryAgent$MethodExecutingValue r0) {
        return r0.exeCount;
    }

    public static /* synthetic */ long access$100(BatteryAgent$MethodExecutingValue r2) {
        return r2.end;
    }

    public static /* synthetic */ long access$200(BatteryAgent$MethodExecutingValue r2) {
        return r2.start;
    }
}
