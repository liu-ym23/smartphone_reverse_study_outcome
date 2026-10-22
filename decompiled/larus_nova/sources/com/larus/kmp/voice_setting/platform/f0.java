package com.larus.kmp.voice_setting.platform;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f351674a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f0) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f351674a, ((f0) r100).f351674a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        Object r100 = this.f351674a;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public final String toString() {
        return "VoiceImageCropRef(platformValue=" + this.f351674a + ')';
    }

    public f0(Object r100) {
        this.f351674a = r100;
    }
}
