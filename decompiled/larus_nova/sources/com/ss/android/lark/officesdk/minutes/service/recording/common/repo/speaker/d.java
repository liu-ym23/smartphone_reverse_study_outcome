package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.speaker;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f435076a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f435077b;

    public d() {
        this(null, 3);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f435076a, r101.f435076a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f435077b, r101.f435077b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f435076a.hashCode() * 31) + this.f435077b.hashCode();
    }

    public final String toString() {
        return "Image(key='" + this.f435076a + "')";
    }

    public d(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "fsUnit");
        this.f435076a = r100;
        this.f435077b = r101;
    }

    public /* synthetic */ d(String r100, int r101) {
        String r102 = "";
        if ((r101 & 1) == 0) goto L6;
        r100 = "";
    L6:
        if ((r101 & 2) != 0) goto L9;
        r102 = null;
    L9:
        this(r100, r102);
    }
}
