package com.larus.bmhome.chat.immerse;

/* JADX INFO: loaded from: classes25.dex */
public final class l0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f303288a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f303289b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f303290c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof l0) == true) goto L8;
        return false;
    L8:
        l0 r101 = (l0) r100;
        if (this.f303288a == r101.f303288a) goto L12;
        return false;
    L12:
        if (this.f303289b == r101.f303289b) goto L15;
        return false;
    L15:
        if (this.f303290c == r101.f303290c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f303288a * 31) + this.f303289b) * 31;
        if (this.f303290c == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "LastRoundChatInfo(lastRoundHeight=" + this.f303288a + ", lastSelfMessageIndex=" + this.f303289b + ", lastBotMessageMiss=" + this.f303290c + ')';
    }

    public l0(int r100, int r101, boolean r102) {
        this.f303288a = r100;
        this.f303289b = r101;
        this.f303290c = r102;
    }
}
