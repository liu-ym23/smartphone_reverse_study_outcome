package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f435304a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f435305b;

    public h() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h) == true) goto L8;
        return false;
    L8:
        h r101 = (h) r100;
        if (Intrinsics.areEqual(this.f435304a, r101.f435304a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f435305b, r101.f435305b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f435304a.hashCode() * 31) + this.f435305b.hashCode();
    }

    public final String toString() {
        return "MmSubtitleLanguage(language=" + this.f435304a + ", description=" + this.f435305b + ')';
    }

    public /* synthetic */ h(int r100) {
        this("", "");
    }

    public h(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "language");
        Intrinsics.checkNotNullParameter(r101, "description");
        this.f435304a = r100;
        this.f435305b = r101;
    }
}
