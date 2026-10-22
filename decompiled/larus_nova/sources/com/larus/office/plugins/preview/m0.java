package com.larus.office.plugins.preview;

/* JADX INFO: loaded from: classes30.dex */
public final class m0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f363219a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f363220b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof m0) == true) goto L8;
        return false;
    L8:
        m0 r101 = (m0) r100;
        if (this.f363219a == r101.f363219a) goto L12;
        return false;
    L12:
        if (this.f363220b == r101.f363220b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f363219a * 31;
        long r101 = this.f363220b;
        return r100 + ((int) (r101 ^ (r101 >>> 32)));
    }

    public final String toString() {
        return "OfficeDrivePreviewUnreadSnapshot(unreadCount=" + this.f363219a + ", readMessageIndex=" + this.f363220b + ')';
    }

    public m0(int r100, long r101) {
        this.f363219a = r100;
        this.f363220b = r101;
    }
}
