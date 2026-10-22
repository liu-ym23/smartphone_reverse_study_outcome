package com.larus.dora.impl.device.settings.lab.env.timer;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Boolean f334660a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f334661b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f334662c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof j) == true) goto L8;
        return false;
    L8:
        j r101 = (j) r100;
        if (Intrinsics.areEqual(this.f334660a, r101.f334660a) == true) goto L12;
        return false;
    L12:
        if (this.f334661b == r101.f334661b) goto L15;
        return false;
    L15:
        if (this.f334662c == r101.f334662c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        Boolean r100 = this.f334660a;
        if (r100 != null) goto L5;
        int r101 = 0;
    L6:
        int r102 = ((r101 * 31) + this.f334661b) * 31;
        if (this.f334662c == false) goto L9;
        int r103 = 1231;
    L11:
        return r102 + r103;
    L9:
        r103 = 1237;
        goto L11
    L5:
        r101 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "TimerStateDecision(previousState=" + this.f334660a + ", reasonCode=" + this.f334661b + ", shouldReport=" + this.f334662c + ')';
    }

    public j(Boolean r100, int r101, boolean r102) {
        this.f334660a = r100;
        this.f334661b = r101;
        this.f334662c = r102;
    }
}
