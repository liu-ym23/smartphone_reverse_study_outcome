package com.larus.kmp.voice_setting.voice.component;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class l0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f352350a;

    public l0() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof l0) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f352350a, ((l0) r100).f352350a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f352350a.hashCode();
    }

    public final String toString() {
        return "VoiceDialogPhotoPreviewUiState(imageUrl=" + this.f352350a + ')';
    }

    public l0(String r100) {
        Intrinsics.checkNotNullParameter(r100, "imageUrl");
        this.f352350a = r100;
    }

    public /* synthetic */ l0(int r100) {
        this("");
    }
}
