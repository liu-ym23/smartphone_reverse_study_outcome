package com.larus.kmp.voice_setting.voice.dialog;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f352725a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f352726b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f352725a, r101.f352725a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f352726b, r101.f352726b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f352725a.hashCode() * 31) + this.f352726b.hashCode();
    }

    public final String toString() {
        return "UgcVoiceAuthorizeDialogItem(title=" + this.f352725a + ", description=" + this.f352726b + ')';
    }

    public d() {
        this("", "");
    }

    public d(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "title");
        Intrinsics.checkNotNullParameter(r101, "description");
        this.f352725a = r100;
        this.f352726b = r101;
    }
}
