package com.larus.kmp.voice_setting.platform;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class j0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final VoiceImageUploadBiz f351676a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof j0) == true) goto L9;
        return false;
    L9:
        if (this.f351676a == ((j0) r100).f351676a) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f351676a.hashCode();
    }

    public final String toString() {
        return "VoiceImageUploadRequest(biz=" + this.f351676a + ')';
    }

    public j0() {
        this(VoiceImageUploadBiz.BOT_ICON);
    }

    public j0(VoiceImageUploadBiz r100) {
        Intrinsics.checkNotNullParameter(r100, "biz");
        this.f351676a = r100;
    }
}
