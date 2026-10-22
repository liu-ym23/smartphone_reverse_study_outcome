package com.larus.kmp.voice_setting.voice.screen.doubletab;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class n8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f354527a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f354528b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Boolean f354529c;

    public n8() {
        this(null, 7);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof n8) == true) goto L8;
        return false;
    L8:
        n8 r101 = (n8) r100;
        if (this.f354527a == r101.f354527a) goto L12;
        return false;
    L12:
        if (this.f354528b == r101.f354528b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f354529c, r101.f354529c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f354527a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.f354528b == true) goto L10;
        r100 = 1237;
    L10:
        int r103 = (r102 + r100) * 31;
        Boolean r104 = this.f354529c;
        if (r104 != null) goto L13;
        int r105 = 0;
    L15:
        return r103 + r105;
    L13:
        r105 = r104.hashCode();
        goto L15
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "VoiceTtsBackgroundPlayState(visible=" + this.f354527a + ", checked=" + this.f354528b + ", initialChecked=" + this.f354529c + ')';
    }

    public final boolean a() {
        if (this.f354527a == false) goto L9;
        Boolean r100 = this.f354529c;
        if (r100 == null) goto L9;
        if (Intrinsics.areEqual(r100, Boolean.valueOf(this.f354528b)) == true) goto L9;
        return true;
    L9:
        return false;
    }

    public /* synthetic */ n8(Boolean r100, int r101) {
        if ((r101 & 4) == 0) goto L5;
        r100 = null;
    L5:
        this(false, false, r100);
    }

    public n8(boolean r100, boolean r101, Boolean r102) {
        this.f354527a = r100;
        this.f354528b = r101;
        this.f354529c = r102;
    }
}
