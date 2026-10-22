package com.larus.kmp.voice_setting.voice.component;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class m4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final VoiceDropdownMenuItemKind f352376a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f352377b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f352378c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof m4) == true) goto L8;
        return false;
    L8:
        m4 r101 = (m4) r100;
        if (this.f352376a == r101.f352376a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f352377b, r101.f352377b) == true) goto L15;
        return false;
    L15:
        if (this.f352378c == r101.f352378c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f352376a.hashCode() * 31) + this.f352377b.hashCode()) * 31;
        if (this.f352378c == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "VoiceDropdownMenuItemData(kind=" + this.f352376a + ", label=" + this.f352377b + ", isDestructive=" + this.f352378c + ')';
    }

    public m4(VoiceDropdownMenuItemKind r100, String r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "kind");
        Intrinsics.checkNotNullParameter(r101, "label");
        this.f352376a = r100;
        this.f352377b = r101;
        this.f352378c = r102;
    }
}
