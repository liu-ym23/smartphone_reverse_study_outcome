package com.hihonor.mcs.system.diagnosis.core.stability;

import java.io.Serializable;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes23.dex */
public class ThreadleakMetric implements Serializable {
    private static final long serialVersionUID = 6034821980080623122L;
    private String appVersion;
    private String diagInfo;
    private long happenTime;
    private int pid;
    private String processName;
    private int threadNum;

    public ThreadleakMetric() {
    }

    public String getAppVersion() {
        return this.appVersion;
    }

    public String getDiagInfo() {
        return this.diagInfo;
    }

    public long getHappenTime() {
        return this.happenTime;
    }

    public int getPid() {
        return this.pid;
    }

    public String getProcessName() {
        return this.processName;
    }

    public int getThreadNum() {
        return this.threadNum;
    }

    public void setAppVersion(String r100) {
        this.appVersion = r100;
    }

    public void setDiagInfo(JSONObject r100) {
        this.diagInfo = r100.toString();
    }

    public void setHappenTime(long r100) {
        this.happenTime = r100;
    }

    public void setPid(int r100) {
        this.pid = r100;
    }

    public void setProcessName(String r100) {
        this.processName = r100;
    }

    public void setThreadNum(int r100) {
        this.threadNum = r100;
    }

    public String toString() {
        return "ThreadleakMetric{appVersion='" + this.appVersion + "', diagInfo='" + this.diagInfo + "', happenTime=" + this.happenTime + ", pid=" + this.pid + ", processName='" + this.processName + "', threadNum=" + this.threadNum + '}';
    }
}
