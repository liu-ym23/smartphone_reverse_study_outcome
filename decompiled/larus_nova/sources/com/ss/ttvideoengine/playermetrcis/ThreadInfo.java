package com.ss.ttvideoengine.playermetrcis;

import java.util.HashMap;
import java.util.HashSet;

/* JADX INFO: loaded from: classes34.dex */
public class ThreadInfo {
    public static final int TYPE_MULTI_THREAD = 2;
    public static final int TYPE_PROC = 0;
    public static final int TYPE_SINGLE_THREAD = 1;
    public long cpuTime;
    public long cpuTimeStart;
    public float cpuUsage;
    public long currentTime;
    public HashMap<String, Object> mMutiThreadUsage;
    public String pid;
    public String pidName;
    public HashSet<String> pids;
    public int type;

    public void reset() {
        this.currentTime = 0;
        this.cpuTimeStart = 0;
        this.cpuUsage = -1.0f;
        this.cpuTime = 0;
    }

    public String toString() {
        return "ProcInfo{pidName='" + this.pidName + "', pid=" + this.pid + ", cpuTime=" + this.cpuTime + ", currentTime=" + this.currentTime + '}';
    }

    public ThreadInfo() {
        this.cpuTime = -1;
        this.currentTime = 0;
        this.cpuTimeStart = 0;
        this.cpuUsage = -1.0f;
        this.type = 1;
    }
}
