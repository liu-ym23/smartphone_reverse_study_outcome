package com.bytedance.ee.bear.document.analytic.processmonitor.entity;

import com.bytedance.ee.util.io.NonProguard;
import java.util.Objects;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class ThreadStatInfo implements NonProguard {
    private long cpuTime;
    private int threadId;
    private String threadName;

    public int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(this.threadId), this.threadName});
    }

    public ThreadStatInfo() {
    }

    public long getCpuTime() {
        return this.cpuTime;
    }

    public int getThreadId() {
        return this.threadId;
    }

    public String getThreadName() {
        return this.threadName;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
    L17:
        return false;
    L8:
        if (getClass() != r5.getClass()) goto L17;
        ThreadStatInfo r6 = (ThreadStatInfo) r5;
        if (this.threadId == r6.threadId) goto L13;
    L15:
        return false;
    L13:
        if (Objects.equals(this.threadName, r6.threadName) == false) goto L15;
        return true;
    }

    public void setCpuTime(long r1) {
        this.cpuTime = r1;
    }

    public void setThreadId(int r1) {
        this.threadId = r1;
    }

    public void setThreadName(String r1) {
        this.threadName = r1;
    }

    public ThreadStatInfo(int r1, String r2, long r3) {
        this.threadId = r1;
        this.threadName = r2;
        this.cpuTime = r3;
    }
}
