package com.hihonor.mcs.system.diagnosis.core.stability;

import java.io.Serializable;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes23.dex */
public class FdleakMetric implements Serializable {
    private static final long serialVersionUID = 4456583426696246670L;
    private String appVersion;
    private String diagInfo;
    private int fileNum;
    private long happenTime;
    private int pid;
    private String processName;

    public FdleakMetric() {
    }

    public String getAppVersion() {
        return this.appVersion;
    }

    public String getDiagInfo() {
        return this.diagInfo;
    }

    public int getFileNum() {
        return this.fileNum;
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

    public void setAppVersion(String r100) {
        this.appVersion = r100;
    }

    public void setDiagInfo(JSONObject r100) {
        this.diagInfo = r100.toString();
    }

    public void setFileNum(int r100) {
        this.fileNum = r100;
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

    public String toString() {
        return "FdleakMetric{appVersion='" + this.appVersion + "', diagInfo='" + this.diagInfo + "', fileNum=" + this.fileNum + ", happenTime=" + this.happenTime + ", pid=" + this.pid + ", processName='" + this.processName + "'}";
    }
}
