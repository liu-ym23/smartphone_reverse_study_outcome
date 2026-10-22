package com.bytedance.crash.upload;

/* JADX INFO: loaded from: classes3.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f203388a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f203389b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f203390c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f203391d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f203392e;

    public final String toString() {
        return "UploadLimitConfig{crashLimitIssue=" + this.f203388a + ", crashLimitAll=" + this.f203389b + ", exceptionAllLimit=" + this.f203390c + ", exceptionMsgLimit=" + this.f203391d + ", exceptionStackLimit=" + this.f203392e + ", isNoLimit=false}";
    }

    public l(int r100, int r101, int r102, int r103, int r104) {
        this.f203388a = 50;
        this.f203389b = 100;
        this.f203390c = 100;
        this.f203391d = 5;
        this.f203392e = 2;
        if (r100 <= 0) goto L5;
        this.f203388a = r100;
    L5:
        if (r101 <= 0) goto L7;
        this.f203389b = r101;
    L7:
        if (r102 <= 0) goto L9;
        this.f203390c = r102;
    L9:
        if (r103 <= 0) goto L11;
        this.f203391d = r103;
    L11:
        if (r104 <= 0) goto L14;
        this.f203392e = r104;
        return;
    }
}
