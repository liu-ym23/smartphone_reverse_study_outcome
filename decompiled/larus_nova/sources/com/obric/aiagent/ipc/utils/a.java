package com.obric.aiagent.ipc.utils;

/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f384719a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f384720b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f384721c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f384722d;

    public a() {
        this(15);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f384719a == r101.f384719a) goto L12;
        return false;
    L12:
        if (this.f384720b == r101.f384720b) goto L15;
        return false;
    L15:
        if (this.f384721c == r101.f384721c) goto L18;
        return false;
    L18:
        if (this.f384722d == r101.f384722d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        if (this.f384719a == false) goto L5;
        int r100 = 1231;
    L6:
        long r101 = this.f384720b;
        return (((((r100 * 31) + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.f384721c) * 31) + this.f384722d;
    L5:
        r100 = 1237;
        goto L6
    }

    public final String toString() {
        return "IPCAnomalyConfig(enabled=" + this.f384719a + ", slowCallThresholdMs=" + this.f384720b + ", frequentCallThresholdPerMinute=" + this.f384721c + ", reportLimitPerMinute=" + this.f384722d + ')';
    }

    public a(int r100) {
        int r101 = 0;
        if ((r100 & 1) == 0) goto L5;
        boolean r102 = true;
    L7:
        if ((r100 & 2) == 0) goto L9;
        long r103 = 200;
    L11:
        if ((r100 & 4) == 0) goto L13;
        int r104 = 3000;
    L15:
        if ((r100 & 8) == 0) goto L17;
        r101 = 60;
    L17:
        this.f384719a = r102;
        this.f384720b = r103;
        this.f384721c = r104;
        this.f384722d = r101;
        return;
    L13:
        r104 = 0;
        goto L15
    L9:
        r103 = 0;
        goto L11
    L5:
        r102 = false;
        goto L7
    }
}
