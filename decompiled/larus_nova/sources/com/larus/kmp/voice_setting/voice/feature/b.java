package com.larus.kmp.voice_setting.voice.feature;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i f353291a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f353292b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f353291a, r101.f353291a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f353292b, r101.f353292b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f353291a.hashCode() * 31) + this.f353292b.hashCode();
    }

    public final String toString() {
        return "RecommendVoiceRequestKey(param=" + this.f353291a + ", userId=" + this.f353292b + ')';
    }

    public b(i r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "param");
        Intrinsics.checkNotNullParameter(r101, "userId");
        this.f353291a = r100;
        this.f353292b = r101;
    }
}
