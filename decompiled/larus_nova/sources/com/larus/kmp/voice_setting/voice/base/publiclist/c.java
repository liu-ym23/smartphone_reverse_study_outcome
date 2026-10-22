package com.larus.kmp.voice_setting.voice.base.publiclist;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f351829a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ah9.g f351830b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f351831c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f351829a, r101.f351829a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f351830b, r101.f351830b) == true) goto L15;
        return false;
    L15:
        if (this.f351831c == r101.f351831c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f351829a.hashCode() * 31) + this.f351830b.hashCode()) * 31) + this.f351831c;
    }

    public final String toString() {
        return "PublicVoiceListLoadResult(nextContext=" + this.f351829a + ", voiceListResponse=" + this.f351830b + ", loadMoreState=" + this.f351831c + ')';
    }

    public c(a r100, ah9.g r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "nextContext");
        Intrinsics.checkNotNullParameter(r101, "voiceListResponse");
        this.f351829a = r100;
        this.f351830b = r101;
        this.f351831c = r102;
    }
}
