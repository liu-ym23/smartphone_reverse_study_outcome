package com.larus.kmp.voice_setting.voice.component;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class e5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f352232a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f352233b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f352234c;

    public e5() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e5) == true) goto L8;
        return false;
    L8:
        e5 r101 = (e5) r100;
        if (Intrinsics.areEqual(this.f352232a, r101.f352232a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f352233b, r101.f352233b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f352234c, r101.f352234c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f352232a.hashCode() * 31) + this.f352233b.hashCode()) * 31) + this.f352234c.hashCode();
    }

    public final String toString() {
        return "VoiceMixLabels(emptyText=" + this.f352232a + ", mixedTitle=" + this.f352233b + ", expandContentDescription=" + this.f352234c + ')';
    }

    public /* synthetic */ e5(int r100) {
        this("", "", "");
    }

    public e5(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "emptyText");
        Intrinsics.checkNotNullParameter(r101, "mixedTitle");
        Intrinsics.checkNotNullParameter(r102, "expandContentDescription");
        this.f352232a = r100;
        this.f352233b = r101;
        this.f352234c = r102;
    }
}
