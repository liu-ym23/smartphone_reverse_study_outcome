package com.bytedance.ee.bear.document.analytic.processmonitor.entity;

import com.bytedance.ee.util.io.NonProguard;
import com.ss.android.lark.appsetting.annotation.AppConfig;

/* JADX INFO: loaded from: classes16.dex */
@AppConfig(key = ProcessMonitorConfig.KEY)
public class ProcessMonitorConfig implements NonProguard {
    public static final String KEY = "process_monitor";
    private CpuConfig cpuConfig;
    private boolean jsbSceneEnable;

    public static class CpuConfig implements NonProguard {
        private long bgIntervalInMills;
        private boolean discardInBackground;
        private boolean enable;
        private long intervalInMills;
        private boolean preciseScene;
        private boolean sandboxCollectFallback;
        private boolean threadCollectEnable;
        private int threadCollectTopCount;
        private boolean upload;

        public String toString() {
            return "CpuConfig{enable=" + this.enable + ", upload=" + this.upload + ", threadCollectEnable=" + this.threadCollectEnable + ", threadCollectTopCount=" + this.threadCollectTopCount + ", intervalInMills=" + this.intervalInMills + ", bgIntervalInMills=" + this.bgIntervalInMills + ", preciseScene=" + this.preciseScene + ", discardInBackground=" + this.discardInBackground + ", sandboxCollectFallback=" + this.sandboxCollectFallback + '}';
        }

        public CpuConfig() {
            this.enable = false;
            this.upload = false;
            this.threadCollectEnable = false;
            this.threadCollectTopCount = 5;
            this.intervalInMills = 5000;
            this.bgIntervalInMills = 300000;
            this.preciseScene = false;
            this.discardInBackground = false;
            this.sandboxCollectFallback = false;
        }

        public long getBgIntervalInMills() {
            return this.bgIntervalInMills;
        }

        public long getIntervalInMills() {
            return this.intervalInMills;
        }

        public int getThreadCollectTopCount() {
            return this.threadCollectTopCount;
        }

        public boolean isDiscardInBackground() {
            return this.discardInBackground;
        }

        public boolean isEnable() {
            return this.enable;
        }

        public boolean isPreciseScene() {
            return this.preciseScene;
        }

        public boolean isSandboxCollectFallback() {
            return this.sandboxCollectFallback;
        }

        public boolean isThreadCollectEnable() {
            return this.threadCollectEnable;
        }

        public boolean isUpload() {
            return this.upload;
        }

        public void setBgIntervalInMills(long r100) {
            this.bgIntervalInMills = r100;
        }

        public void setDiscardInBackground(boolean r100) {
            this.discardInBackground = r100;
        }

        public void setEnable(boolean r100) {
            this.enable = r100;
        }

        public void setIntervalInMills(long r100) {
            this.intervalInMills = r100;
        }

        public void setPreciseScene(boolean r100) {
            this.preciseScene = r100;
        }

        public void setSandboxCollectFallback(boolean r100) {
            this.sandboxCollectFallback = r100;
        }

        public void setThreadCollectEnable(boolean r100) {
            this.threadCollectEnable = r100;
        }

        public void setThreadCollectTopCount(int r100) {
            this.threadCollectTopCount = r100;
        }

        public void setUpload(boolean r100) {
            this.upload = r100;
        }
    }

    public String toString() {
        return "ProcessMonitorConfig{cpuConfig=" + this.cpuConfig + ", jsbSceneEnable=" + this.jsbSceneEnable + '}';
    }

    public ProcessMonitorConfig() {
        this.cpuConfig = new CpuConfig();
        this.jsbSceneEnable = false;
    }

    public CpuConfig getCpuConfig() {
        return this.cpuConfig;
    }

    public boolean isJsbSceneEnable() {
        return this.jsbSceneEnable;
    }

    public void setCpuConfig(CpuConfig r100) {
        this.cpuConfig = r100;
    }

    public void setJsbSceneEnable(boolean r100) {
        this.jsbSceneEnable = r100;
    }
}
