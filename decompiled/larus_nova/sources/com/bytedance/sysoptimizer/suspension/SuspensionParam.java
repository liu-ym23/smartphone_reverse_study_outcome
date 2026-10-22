package com.bytedance.sysoptimizer.suspension;

import java.util.Set;

/* JADX INFO: loaded from: classes22.dex */
public class SuspensionParam {
    private boolean enableCrashWhenInitFailed;
    private Set<String> ignoredThreadSet;
    private long intervalCheckSuspensionDuration;
    private float ratio;
    private long suspensionTaskMaxDuration;
    private long threadSuspendDuration;

    public SuspensionParam() {
        this.threadSuspendDuration = 2000;
        this.intervalCheckSuspensionDuration = 4000;
        this.suspensionTaskMaxDuration = 180000;
        this.ignoredThreadSet = null;
        this.ratio = 1.0f;
        this.enableCrashWhenInitFailed = false;
    }

    public Set<String> getIgnoredThreadSet() {
        return this.ignoredThreadSet;
    }

    public long getIntervalCheckSuspensionDuration() {
        return this.intervalCheckSuspensionDuration;
    }

    public float getRatio() {
        return this.ratio;
    }

    public long getSuspensionTaskMaxDuration() {
        return this.suspensionTaskMaxDuration;
    }

    public long getThreadSuspendDuration() {
        return this.threadSuspendDuration;
    }

    public boolean isEnableCrashWhenInitFailed() {
        return this.enableCrashWhenInitFailed;
    }

    public SuspensionParam setEnableCrashWhenInitFailed(boolean r100) {
        this.enableCrashWhenInitFailed = r100;
        return this;
    }

    public SuspensionParam setIgnoredThreadSet(Set<String> r100) {
        this.ignoredThreadSet = r100;
        return this;
    }

    public SuspensionParam setIntervalCheckSuspensionDuration(long r100) {
        this.intervalCheckSuspensionDuration = r100;
        return this;
    }

    public SuspensionParam setRatio(float r100) {
        this.ratio = r100;
        return this;
    }

    public SuspensionParam setSuspensionTaskMaxDuration(long r100) {
        this.suspensionTaskMaxDuration = r100;
        return this;
    }

    public SuspensionParam setThreadSuspendDuration(long r100) {
        this.threadSuspendDuration = r100;
        return this;
    }
}
