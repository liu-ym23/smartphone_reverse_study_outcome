package com.ss.android.lark.diskmanage.monitor.settings;

/* JADX INFO: loaded from: classes35.dex */
public class DiskMonitorConfig {
    private MonitorExceptionConfig exceptionConfig;
    private String extraConfig;
    private MonitorGlobalConfig globalConfig;

    public String toString() {
        return "DiskMonitorConfig{globalConfig=" + this.globalConfig + ", exceptionConfig=" + this.exceptionConfig + ", extraConfig='" + this.extraConfig + "'}";
    }

    public DiskMonitorConfig() {
        this.globalConfig = new MonitorGlobalConfig();
        this.exceptionConfig = new MonitorExceptionConfig();
        this.extraConfig = "";
    }

    public MonitorExceptionConfig getExceptionConfig() {
        return this.exceptionConfig;
    }

    public String getExtraConfig() {
        return this.extraConfig;
    }

    public MonitorGlobalConfig getGlobalConfig() {
        return this.globalConfig;
    }

    public void setExceptionConfig(MonitorExceptionConfig r100) {
        this.exceptionConfig = r100;
    }

    public void setExtraConfig(String r100) {
        this.extraConfig = r100;
    }

    public void setGlobalConfig(MonitorGlobalConfig r100) {
        this.globalConfig = r100;
    }
}
