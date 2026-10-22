package com.hihonor.mcs.system.diagnosis.core.stability;

import java.io.Serializable;

/* JADX INFO: loaded from: classes23.dex */
public abstract class BaseFaultMetric implements Serializable {
    private static final long serialVersionUID = -2287875122337284846L;
    private String appVersion;

    /* JADX INFO: renamed from: fg, reason: collision with root package name */
    private String f276666fg;
    private long happenTime;
    private int pid;
    private String processName;
    private String trustStack;

    public BaseFaultMetric() {
    }

    public String getAppVersion() {
        return this.appVersion;
    }

    public abstract String getDiagInfo();

    public String getFg() {
        return this.f276666fg;
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

    public String getTrustStack() {
        return this.trustStack;
    }

    public void setAppVersion(String r100) {
        this.appVersion = r100;
    }

    public void setFg(String r100) {
        this.f276666fg = r100;
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

    public void setTrustStack(String r100) {
        this.trustStack = r100;
    }

    public String toString() {
        return "BaseFaultMetric{appVersion='" + this.appVersion + "', fg='" + this.f276666fg + "', happenTime=" + this.happenTime + ", pid=" + this.pid + ", processName='" + this.processName + "', trustStack='" + this.trustStack + "'}";
    }
}
