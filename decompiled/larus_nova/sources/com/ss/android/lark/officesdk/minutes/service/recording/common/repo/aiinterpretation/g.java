package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f434765a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f434766b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f434767c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L8;
        return false;
    L8:
        g r101 = (g) r100;
        if (Intrinsics.areEqual(this.f434765a, r101.f434765a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f434766b, r101.f434766b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f434767c, r101.f434767c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f434765a.hashCode() * 31) + this.f434766b.hashCode()) * 31) + this.f434767c.hashCode();
    }

    public final String toString() {
        return "MmAIInterpretationLanguage(languageType=" + this.f434765a + ", description=" + this.f434766b + ", icon=" + this.f434767c + ')';
    }

    public g(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "languageType");
        Intrinsics.checkNotNullParameter(r101, "description");
        Intrinsics.checkNotNullParameter(r102, "icon");
        this.f434765a = r100;
        this.f434766b = r101;
        this.f434767c = r102;
    }
}
