package com.ss.android.lark.officesdk.minutes.ui.style.contract;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;

/* JADX INFO: loaded from: classes37.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f436892a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f436893b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final MmRecordingSource f436894c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i) == true) goto L8;
        return false;
    L8:
        i r101 = (i) r100;
        if (this.f436892a == r101.f436892a) goto L12;
        return false;
    L12:
        if (this.f436893b == r101.f436893b) goto L15;
        return false;
    L15:
        if (this.f436894c == r101.f436894c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f436892a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.f436893b == true) goto L10;
        r100 = 1237;
    L10:
        int r103 = (r102 + r100) * 31;
        MmRecordingSource r104 = this.f436894c;
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
        return "MmTopBarCapabilityContext(hasHostBridge=" + this.f436892a + ", hasHostNavRect=" + this.f436893b + ", source=" + this.f436894c + ')';
    }

    public i(boolean r100, boolean r101, MmRecordingSource r102) {
        this.f436892a = r100;
        this.f436893b = r101;
        this.f436894c = r102;
    }
}
