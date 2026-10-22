package com.ss.android.lark.officesdk.minutes.service.recording.common.core.service;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f434411a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f434412b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final MinutesForegroundService.ForegroundServiceType f434413c;

    public /* synthetic */ d() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f434411a, r101.f434411a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f434412b, r101.f434412b) == true) goto L15;
        return false;
    L15:
        if (this.f434413c == r101.f434413c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f434411a.hashCode() * 31) + this.f434412b.hashCode()) * 31) + this.f434413c.hashCode();
    }

    public final String toString() {
        return "MmRecordingForegroundNotificationAction(title=" + this.f434411a + ", content=" + this.f434412b + ", foregroundServiceType=" + this.f434413c + ')';
    }

    public d(String r100, String r101, MinutesForegroundService.ForegroundServiceType r102) {
        Intrinsics.checkNotNullParameter(r100, "title");
        Intrinsics.checkNotNullParameter(r101, "content");
        Intrinsics.checkNotNullParameter(r102, "foregroundServiceType");
        this.f434411a = r100;
        this.f434412b = r101;
        this.f434413c = r102;
    }
}
