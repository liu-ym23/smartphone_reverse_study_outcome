package com.ss.android.lark.officesdk.minutes.api.recording.doubao.applet.route;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f433579c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f433580a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MmRecordingEntity f433581b;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f433580a, r101.f433580a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f433581b, r101.f433581b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f433580a.hashCode() * 31) + this.f433581b.hashCode();
    }

    public final String toString() {
        return "MmRecordingRouteRequest(dataKey=" + this.f433580a + ", entity=" + this.f433581b + ')';
    }

    public b(String r100, MmRecordingEntity r101) {
        Intrinsics.checkNotNullParameter(r100, "dataKey");
        Intrinsics.checkNotNullParameter(r101, "entity");
        this.f433580a = r100;
        this.f433581b = r101;
    }
}
