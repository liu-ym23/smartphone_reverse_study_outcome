package com.bytedance.sysoptimizer;

/* JADX INFO: loaded from: classes22.dex */
public class StackLeakItem {
    private int leakCount;
    private String soBuildId;
    private long soEndAddr;
    private String soPath;
    private long soStartAddr;
    private long startRoutine;
    private long startRoutineOffset;

    public String getLeakItem() {
        return "[" + this.leakCount + "] stacks leaked: " + Long.toHexString(this.startRoutineOffset) + " " + Long.toHexString(this.soStartAddr) + "-" + Long.toHexString(this.soEndAddr) + " r-xp " + getSoName() + " (" + this.soBuildId + ")";
    }

    public String getSoName() {
        String r100 = this.soPath;
        if (r100 == null) goto L9;
        int r101 = r100.lastIndexOf(47);
        if (r101 < 0) goto L9;
        if (r101 >= (this.soPath.length() - 1)) goto L9;
        return this.soPath.substring(r101 + 1);
    L9:
        return "UNKNOWN";
    }

    public String getBuildId() {
        return this.soBuildId;
    }

    public int getLeakCount() {
        return this.leakCount;
    }

    public long getOffset() {
        return this.startRoutineOffset;
    }

    public StackLeakItem(int r100, long r101, long r102, long r103, String r104, String r105) {
        this.leakCount = r100;
        this.startRoutine = r101;
        this.soStartAddr = r102;
        this.soEndAddr = r103;
        this.soPath = r104;
        this.soBuildId = r105;
        this.startRoutineOffset = r101 - r102;
    }
}
