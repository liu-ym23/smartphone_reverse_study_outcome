package com.larus.kmp.voice_setting.voice.component;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class p1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f352451a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f352452b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f352453c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f352454d;

    public p1() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof p1) == true) goto L8;
        return false;
    L8:
        p1 r101 = (p1) r100;
        if (Intrinsics.areEqual(this.f352451a, r101.f352451a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f352452b, r101.f352452b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f352453c, r101.f352453c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f352454d, r101.f352454d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f352451a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f352452b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f352453c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f352454d;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return r109 + r101;
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "VoiceDoubleTabChromeResourceStateData(titleIconToken=" + this.f352451a + ", muteIconToken=" + this.f352452b + ", backgroundToken=" + this.f352453c + ", resourceToken=" + this.f352454d + ')';
    }

    public p1(int r100) {
        this.f352451a = null;
        this.f352452b = null;
        this.f352453c = null;
        this.f352454d = null;
    }
}
