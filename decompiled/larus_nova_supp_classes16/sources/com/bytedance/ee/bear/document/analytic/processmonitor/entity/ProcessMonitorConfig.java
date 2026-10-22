package com.bytedance.ee.bear.document.analytic.processmonitor.entity;

import com.bytedance.ee.util.io.NonProguard;
import com.ss.android.lark.appsetting.annotation.AppConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
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

        public void setBgIntervalInMills(long r1) {
            this.bgIntervalInMills = r1;
        }

        public void setDiscardInBackground(boolean r1) {
            this.discardInBackground = r1;
        }

        public void setEnable(boolean r1) {
            this.enable = r1;
        }

        public void setIntervalInMills(long r1) {
            this.intervalInMills = r1;
        }

        public void setPreciseScene(boolean r1) {
            this.preciseScene = r1;
        }

        public void setSandboxCollectFallback(boolean r1) {
            this.sandboxCollectFallback = r1;
        }

        public void setThreadCollectEnable(boolean r1) {
            this.threadCollectEnable = r1;
        }

        public void setThreadCollectTopCount(int r1) {
            this.threadCollectTopCount = r1;
        }

        public void setUpload(boolean r1) {
            this.upload = r1;
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

    public void setCpuConfig(CpuConfig r1) {
        this.cpuConfig = r1;
    }

    public void setJsbSceneEnable(boolean r1) {
        this.jsbSceneEnable = r1;
    }
}
