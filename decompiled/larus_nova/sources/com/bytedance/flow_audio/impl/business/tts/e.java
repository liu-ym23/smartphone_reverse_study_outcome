package com.bytedance.flow_audio.impl.business.tts;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f244094a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final rw5.d f244095b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f244094a, r101.f244094a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f244095b, r101.f244095b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f244094a.hashCode() * 31) + this.f244095b.hashCode();
    }

    public final String toString() {
        return "VoiceSynthesizeResult(id=" + this.f244094a + ", voiceData=" + this.f244095b + ')';
    }

    public e(String r100, rw5.d r101) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r101, "voiceData");
        this.f244094a = r100;
        this.f244095b = r101;
    }
}
