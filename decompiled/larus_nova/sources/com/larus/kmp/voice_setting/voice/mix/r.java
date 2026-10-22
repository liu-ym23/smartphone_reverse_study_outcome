package com.larus.kmp.voice_setting.voice.mix;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f353912a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof r) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f353912a, ((r) r100).f353912a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f353912a.hashCode();
    }

    public final String toString() {
        return "VoiceEditAreaEmptyRowState(text=" + this.f353912a + ')';
    }

    public r(String r100) {
        Intrinsics.checkNotNullParameter(r100, "text");
        this.f353912a = r100;
    }
}
