package com.vivo.push.model;

/* JADX INFO: loaded from: classes41.dex */
public class SubscribeAppInfo {
    public static final int SUBSCIRBE = 1;
    public static final int SUBSCIRBE_CANCLE = 2;
    private int mActualStatus;
    private String mName;
    private int mTargetStatus;

    public int hashCode() {
        String r100 = this.mName;
        if (r100 != null) goto L5;
        int r101 = 0;
    L7:
        return ((r101 + 31) * 31) + this.mTargetStatus;
    L5:
        r101 = r100.hashCode();
        goto L7
    }

    public String toString() {
        return "SubscribeAppInfo [mName=" + this.mName + ", mTargetStatus=" + this.mTargetStatus + ", mActualStatus=" + this.mActualStatus + "]";
    }

    public int getActualStatus() {
        return this.mActualStatus;
    }

    public String getName() {
        return this.mName;
    }

    public int getTargetStatus() {
        return this.mTargetStatus;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L9;
        return false;
    L9:
        if (getClass() == r100.getClass()) goto L11;
        return false;
    L11:
        SubscribeAppInfo r101 = (SubscribeAppInfo) r100;
        String r102 = this.mName;
        if (r102 != null) goto L17;
        if (r101.mName == null) goto L20;
        return false;
    L20:
        if (this.mTargetStatus != r101.mTargetStatus) goto L22;
        return true;
    L22:
        return false;
    L17:
        if (r102.equals(r101.mName) == true) goto L20;
        return false;
    }

    public void setActualStatus(int r100) {
        this.mActualStatus = r100;
    }

    public void setName(String r100) {
        this.mName = r100;
    }

    public void setTargetStatus(int r100) {
        this.mTargetStatus = r100;
    }

    public SubscribeAppInfo(String r100, int r101, int r102) {
        this.mName = r100;
        this.mTargetStatus = r101;
        this.mActualStatus = r102;
    }
}
