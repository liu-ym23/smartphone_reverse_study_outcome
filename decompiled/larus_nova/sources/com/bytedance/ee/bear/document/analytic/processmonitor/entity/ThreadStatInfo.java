package com.bytedance.ee.bear.document.analytic.processmonitor.entity;

import com.bytedance.ee.util.io.NonProguard;
import java.util.Objects;

/* JADX INFO: loaded from: classes16.dex */
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

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L17:
        return false;
    L8:
        if (getClass() != r100.getClass()) goto L17;
        ThreadStatInfo r101 = (ThreadStatInfo) r100;
        if (this.threadId == r101.threadId) goto L13;
    L15:
        return false;
    L13:
        if (Objects.equals(this.threadName, r101.threadName) == false) goto L15;
        return true;
    }

    public void setCpuTime(long r100) {
        this.cpuTime = r100;
    }

    public void setThreadId(int r100) {
        this.threadId = r100;
    }

    public void setThreadName(String r100) {
        this.threadName = r100;
    }

    public ThreadStatInfo(int r100, String r101, long r102) {
        this.threadId = r100;
        this.threadName = r101;
        this.cpuTime = r102;
    }
}
