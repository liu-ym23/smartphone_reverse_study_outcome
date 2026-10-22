package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.notification;

/* JADX INFO: loaded from: classes37.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f435046a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f435047b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f435048c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f435049d;

    public a() {
        this(false, false, false, false);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f435046a == r101.f435046a) goto L12;
        return false;
    L12:
        if (this.f435047b == r101.f435047b) goto L15;
        return false;
    L15:
        if (this.f435048c == r101.f435048c) goto L18;
        return false;
    L18:
        if (this.f435049d == r101.f435049d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f435046a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.f435047b == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.f435048c == false) goto L13;
        int r105 = 1231;
    L14:
        int r106 = (r104 + r105) * 31;
        if (this.f435049d == true) goto L19;
        r100 = 1237;
    L19:
        return r106 + r100;
    L13:
        r105 = 1237;
        goto L14
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "MmRecordingNotificationEntity(isWeakNetwork=" + this.f435046a + ", isMaxDurationReached=" + this.f435047b + ", isSubtitleFailed=" + this.f435048c + ", isPhoneCalling=" + this.f435049d + ')';
    }

    public a(boolean r100, boolean r101, boolean r102, boolean r103) {
        this.f435046a = r100;
        this.f435047b = r101;
        this.f435048c = r102;
        this.f435049d = r103;
    }

    public static a a(a r100, boolean r101, boolean r102, boolean r103, boolean r104, int r105) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.f435046a;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.f435047b;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.f435048c;
    L12:
        if ((r105 & 8) == 0) goto L14;
        r104 = r100.f435049d;
    L14:
        r100.getClass();
        return new a(r101, r102, r103, r104);
    }
}
