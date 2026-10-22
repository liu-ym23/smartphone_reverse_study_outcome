package vea;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f554530a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f554531b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Boolean f554532c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof p) == true) goto L8;
        return false;
    L8:
        p r101 = (p) r100;
        if (this.f554530a == r101.f554530a) goto L12;
        return false;
    L12:
        if (this.f554531b == r101.f554531b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f554532c, r101.f554532c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f554530a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.f554531b == true) goto L10;
        r100 = 1237;
    L10:
        int r103 = (r102 + r100) * 31;
        Boolean r104 = this.f554532c;
        if (r104 != null) goto L13;
        int r105 = 0;
    L15:
        return r103 + r105;
    L13:
        r105 = r104.hashCode();
        goto L15
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "ObricVoiceWakeupImprovementConfigResult(requestSucceeded=" + this.f554530a + ", keyExists=" + this.f554531b + ", enabled=" + this.f554532c + ')';
    }

    public p(boolean r100, boolean r101, Boolean r102) {
        this.f554530a = r100;
        this.f554531b = r101;
        this.f554532c = r102;
    }
}
