package com.ss.android.lark.diskmanage.monitor.settings;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes35.dex */
public class MonitorGlobalConfig {
    private long abnormalFileSize;
    private long abnormalFolderSize;
    private List<String> diskCustomedPaths;
    private boolean dumpSwitch;
    private long dumpThreshold;
    private int dumpTopCount;
    private boolean useNewStorageMetrics;

    public String toString() {
        return "MonitorGlobalConfig{dumpSwitch=" + this.dumpSwitch + ", dumpThreshold=" + this.dumpThreshold + ", abnormalFileSize=" + this.abnormalFileSize + ", abnormalFolderSize=" + this.abnormalFolderSize + ", dumpTopCount=" + this.dumpTopCount + ", diskCustomedPaths=" + this.diskCustomedPaths + '}';
    }

    public MonitorGlobalConfig() {
        this.dumpSwitch = false;
        this.dumpThreshold = 629145600;
        this.abnormalFileSize = 20971520;
        this.abnormalFolderSize = 52428800;
        this.dumpTopCount = 20;
        this.diskCustomedPaths = new ArrayList();
        this.useNewStorageMetrics = false;
    }

    public long getAbnormalFileSize() {
        return this.abnormalFileSize;
    }

    public long getAbnormalFolderSize() {
        return this.abnormalFolderSize;
    }

    public List<String> getDiskCustomedPaths() {
        return this.diskCustomedPaths;
    }

    public boolean getDumpSwitch() {
        return this.dumpSwitch;
    }

    public long getDumpThreshold() {
        return this.dumpThreshold;
    }

    public int getDumpTopCount() {
        return this.dumpTopCount;
    }

    public boolean getUseNewStorageMetrics() {
        return this.useNewStorageMetrics;
    }

    public void setAbnormalFileSize(long r100) {
        this.abnormalFileSize = r100;
    }

    public void setAbnormalFolderSize(long r100) {
        this.abnormalFolderSize = r100;
    }

    public void setDiskCustomedPaths(List<String> r100) {
        this.diskCustomedPaths = r100;
    }

    public void setDumpSwitch(boolean r100) {
        this.dumpSwitch = r100;
    }

    public void setDumpThreshold(long r100) {
        this.dumpThreshold = r100;
    }

    public void setDumpTopCount(int r100) {
        this.dumpTopCount = r100;
    }

    public void setUseNewStorageMetrics(boolean r100) {
        this.useNewStorageMetrics = r100;
    }
}
