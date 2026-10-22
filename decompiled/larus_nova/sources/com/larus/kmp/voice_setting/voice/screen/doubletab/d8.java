package com.larus.kmp.voice_setting.voice.screen.doubletab;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class d8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f354252a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Boolean f354253b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d8) == true) goto L8;
        return false;
    L8:
        d8 r101 = (d8) r100;
        if (this.f354252a == r101.f354252a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f354253b, r101.f354253b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        if (this.f354252a == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = r100 * 31;
        Boolean r102 = this.f354253b;
        if (r102 != null) goto L9;
        int r103 = 0;
    L11:
        return r101 + r103;
    L9:
        r103 = r102.hashCode();
        goto L11
    L5:
        r100 = 1237;
        goto L6
    }

    public final String toString() {
        return "VoiceEditRegionCollapseSnapshot(canCollapseByScroll=" + this.f354252a + ", collapsed=" + this.f354253b + ')';
    }

    public d8(boolean r100, Boolean r101) {
        this.f354252a = r100;
        this.f354253b = r101;
    }
}
