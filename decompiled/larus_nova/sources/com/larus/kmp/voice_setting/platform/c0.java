package com.larus.kmp.voice_setting.platform;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f351673a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c0) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f351673a, ((c0) r100).f351673a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f351673a.hashCode();
    }

    public final String toString() {
        return "VoiceFileRef(path=" + this.f351673a + ')';
    }

    public c0(String r100) {
        Intrinsics.checkNotNullParameter(r100, "path");
        this.f351673a = r100;
    }
}
