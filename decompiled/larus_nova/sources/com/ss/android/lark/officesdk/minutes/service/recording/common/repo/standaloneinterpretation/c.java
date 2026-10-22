package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f435126a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f435127b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f435128c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f435126a, r101.f435126a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f435127b, r101.f435127b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f435128c, r101.f435128c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f435126a.hashCode() * 31) + this.f435127b.hashCode()) * 31) + this.f435128c.hashCode();
    }

    public final String toString() {
        return "MmStandaloneAIInterpretationLanguage(languageType=" + this.f435126a + ", description=" + this.f435127b + ", icon=" + this.f435128c + ')';
    }

    public c(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "languageType");
        Intrinsics.checkNotNullParameter(r101, "description");
        Intrinsics.checkNotNullParameter("", "icon");
        this.f435126a = r100;
        this.f435127b = r101;
        this.f435128c = "";
    }
}
