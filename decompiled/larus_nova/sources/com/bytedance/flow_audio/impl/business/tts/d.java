package com.bytedance.flow_audio.impl.business.tts;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f244092a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final rw5.d f244093b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f244092a, r101.f244092a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f244093b, r101.f244093b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f244092a.hashCode() * 31) + this.f244093b.hashCode();
    }

    public final String toString() {
        return "TtsStream(id=" + this.f244092a + ", voiceData=" + this.f244093b + ')';
    }

    public d(String r100, rw5.d r101) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r101, "voiceData");
        this.f244092a = r100;
        this.f244093b = r101;
    }
}
