package com.bytedance.apm.agent.tracing;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class PageTraceEntity {
    public long onCreateEndTs;
    public long onCreateStartTs;
    public long onResumeEndTs;
    public long onResumeStartTs;
    public long onViewShowTs;
    public long onWindowFocusTs;
    public String pageName;

    public boolean isCreateAndResumeValid() {
        if (this.onCreateStartTs > 0) goto L5;
    L11:
        return false;
    L5:
        if (this.onCreateEndTs <= 0) goto L11;
        if (this.onResumeStartTs <= 0) goto L11;
        if (this.onResumeEndTs <= 0) goto L11;
        return true;
    }

    public long getOnCreateEndTs() {
        return this.onCreateEndTs;
    }

    public long getOnCreateStartTs() {
        return this.onCreateStartTs;
    }

    public long getOnResumeEndTs() {
        return this.onResumeEndTs;
    }

    public long getOnResumeStartTs() {
        return this.onResumeStartTs;
    }

    public long getOnWindowFocusTs() {
        return this.onWindowFocusTs;
    }

    public String getPageName() {
        return this.pageName;
    }

    public void setOnCreateEndTs(long r1) {
        this.onCreateEndTs = r1;
    }

    public void setOnCreateStartTs(long r1) {
        this.onCreateStartTs = r1;
    }

    public void setOnResumeEndTs(long r1) {
        this.onResumeEndTs = r1;
    }

    public void setOnResumeStartTs(long r1) {
        this.onResumeStartTs = r1;
    }

    public void setOnWindowFocusTs(long r1) {
        this.onWindowFocusTs = r1;
    }

    public void setPageName(String r1) {
        this.pageName = r1;
    }

    public PageTraceEntity(String r1, long r2) {
        this.pageName = r1;
        this.onCreateStartTs = r2;
    }
}
