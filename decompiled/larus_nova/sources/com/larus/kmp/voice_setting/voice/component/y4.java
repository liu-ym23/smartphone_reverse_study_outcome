package com.larus.kmp.voice_setting.voice.component;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class y4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f352640a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f352641b;

    public y4() {
        this(null, 3);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof y4) == true) goto L8;
        return false;
    L8:
        y4 r101 = (y4) r100;
        if (Intrinsics.areEqual(this.f352640a, r101.f352640a) == true) goto L12;
        return false;
    L12:
        if (this.f352641b == r101.f352641b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f352640a;
        if (r100 != null) goto L5;
        int r101 = 0;
    L7:
        return (r101 * 31) + this.f352641b;
    L5:
        r101 = r100.hashCode();
        goto L7
    }

    public final String toString() {
        return "VoiceImagePickerRequest(source=" + this.f352640a + ", limit=" + this.f352641b + ')';
    }

    public y4(String r100, int r101) {
        if ((r101 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r101 & 2) == 0) goto L8;
        int r102 = 1;
    L9:
        this.f352640a = r100;
        this.f352641b = r102;
        return;
    L8:
        r102 = 0;
        goto L9
    }
}
