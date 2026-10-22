package com.larus.kmp.voice_setting.voice.component;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f352224a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f352225b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f352226c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f352227d;

    public e0() {
        this(null, null, null, null, 15);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e0) == true) goto L8;
        return false;
    L8:
        e0 r101 = (e0) r100;
        if (Intrinsics.areEqual(this.f352224a, r101.f352224a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f352225b, r101.f352225b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f352226c, r101.f352226c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f352227d, r101.f352227d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.f352224a.hashCode() * 31) + this.f352225b.hashCode()) * 31) + this.f352226c.hashCode()) * 31) + this.f352227d.hashCode();
    }

    public final String toString() {
        return "VoiceDialogConfirmUiState(title=" + this.f352224a + ", message=" + this.f352225b + ", confirmText=" + this.f352226c + ", cancelText=" + this.f352227d + ')';
    }

    public e0(String r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "title");
        Intrinsics.checkNotNullParameter(r101, "message");
        Intrinsics.checkNotNullParameter(r102, "confirmText");
        Intrinsics.checkNotNullParameter(r103, "cancelText");
        this.f352224a = r100;
        this.f352225b = r101;
        this.f352226c = r102;
        this.f352227d = r103;
    }

    public /* synthetic */ e0(String r100, String r101, String r102, String r103, int r104) {
        if ((r104 & 1) == 0) goto L6;
        r100 = "";
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = "";
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = "";
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = "";
    L14:
        this(r100, r101, r102, r103);
    }
}
