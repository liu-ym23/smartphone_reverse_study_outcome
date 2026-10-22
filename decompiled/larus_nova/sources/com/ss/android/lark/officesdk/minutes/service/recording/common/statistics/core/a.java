package com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core;

import com.ss.android.lark.officesdk.minutes.api.recording.doubao.DoubaoStatisticInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f435415a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MmRecordingCommonParam f435416b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final DoubaoStatisticInfo f435417c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f435418d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f435419e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f435415a, r101.f435415a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f435416b, r101.f435416b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f435417c, r101.f435417c) == true) goto L18;
        return false;
    L18:
        if (this.f435418d == r101.f435418d) goto L21;
        return false;
    L21:
        if (this.f435419e == r101.f435419e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f435415a.hashCode() * 31) + this.f435416b.hashCode()) * 31;
        DoubaoStatisticInfo r101 = this.f435417c;
        if (r101 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = (r100 + r102) * 31;
        int r104 = 1231;
        if (this.f435418d == false) goto L9;
        int r105 = 1231;
    L10:
        int r106 = (r103 + r105) * 31;
        if (this.f435419e == true) goto L15;
        r104 = 1237;
    L15:
        return r106 + r104;
    L9:
        r105 = 1237;
        goto L10
    L5:
        r102 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "MmRecordingBusinessTrackContext(sessionId=" + this.f435415a + ", commonParam=" + this.f435416b + ", doubaoStatisticInfo=" + this.f435417c + ", sessionEnded=" + this.f435418d + ", endWindowClosed=" + this.f435419e + ')';
    }

    public a(String r100, MmRecordingCommonParam r101, DoubaoStatisticInfo r102, boolean r103, boolean r104) {
        Intrinsics.checkNotNullParameter(r100, "sessionId");
        Intrinsics.checkNotNullParameter(r101, "commonParam");
        this.f435415a = r100;
        this.f435416b = r101;
        this.f435417c = r102;
        this.f435418d = r103;
        this.f435419e = r104;
    }
}
