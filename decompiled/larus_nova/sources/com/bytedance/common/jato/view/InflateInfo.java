package com.bytedance.common.jato.view;

/* JADX INFO: loaded from: classes15.dex */
public class InflateInfo {
    protected String activityName;
    protected int count;
    protected long end;
    protected Object extraInfo;
    protected ViewInfoManager.InfoItem firstView;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    protected int f202960id;
    protected String name;
    protected String scene;
    protected long start;
    protected int threadId;
    protected String threadName;
    protected InflateType type;

    public InflateInfo() {
    }

    public long duration() {
        return this.end - this.start;
    }

    public ViewInfo getFirstViewInfo() {
        ViewInfoManager.InfoItem r100 = this.firstView;
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.viewInfo;
    }

    public String toString() {
        return "InflateInfo{duration=" + duration() + ", count=" + this.count + ", scene='" + this.scene + "', type=" + this.type + ", name='" + this.name + "', threadName='" + this.threadName + "', extraInfo=" + this.extraInfo + '}';
    }

    public long getEnd() {
        return this.end;
    }

    public int getId() {
        return this.f202960id;
    }

    public long getStart() {
        return this.start;
    }

    public InflateType getType() {
        return this.type;
    }

    public void addViewRef(ViewInfoManager.InfoItem r100) {
        if (r100 != null) goto L4;
    L6:
        this.count++;
        return;
    L4:
        if (this.firstView != null) goto L6;
        this.firstView = r100;
        goto L6
    }

    public void setActivityName(String r100) {
        this.activityName = r100;
    }

    public void setEnd(long r100) {
        this.end = r100;
    }

    public void setExtraInfo(Object r100) {
        this.extraInfo = r100;
    }

    public void setId(int r100) {
        this.f202960id = r100;
    }

    public void setName(String r100) {
        this.name = r100;
    }

    public void setScene(String r100) {
        this.scene = r100;
    }

    public void setStart(long r100) {
        this.start = r100;
    }

    public void setThreadId(int r100) {
        this.threadId = r100;
    }

    public void setThreadName(String r100) {
        this.threadName = r100;
    }

    public void setType(InflateType r100) {
        this.type = r100;
    }
}
