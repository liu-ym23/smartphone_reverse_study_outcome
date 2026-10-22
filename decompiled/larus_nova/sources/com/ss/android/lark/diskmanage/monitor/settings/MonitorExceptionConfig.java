package com.ss.android.lark.diskmanage.monitor.settings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes35.dex */
public class MonitorExceptionConfig {
    private List<String> ignoredRelativeDirs;
    private List<String> ignoredRelativeFiles;
    private Map<String, String> modules;

    public String toString() {
        return "MonitorExceptionConfig{ignoredRelativeFiles=" + this.ignoredRelativeFiles + ", ignoredRelativeDirs=" + this.ignoredRelativeDirs + ", modules=" + this.modules + '}';
    }

    public MonitorExceptionConfig() {
        this.ignoredRelativeFiles = new ArrayList();
        this.ignoredRelativeDirs = new ArrayList();
        this.modules = new HashMap();
    }

    public List<String> getIgnoredRelativeDirs() {
        return this.ignoredRelativeDirs;
    }

    public List<String> getIgnoredRelativeFiles() {
        return this.ignoredRelativeFiles;
    }

    public Map<String, String> getModules() {
        return this.modules;
    }

    public void setIgnoredRelativeDirs(List<String> r100) {
        this.ignoredRelativeDirs = r100;
    }

    public void setIgnoredRelativeFiles(List<String> r100) {
        this.ignoredRelativeFiles = r100;
    }

    public void setModules(Map<String, String> r100) {
        this.modules = r100;
    }
}
