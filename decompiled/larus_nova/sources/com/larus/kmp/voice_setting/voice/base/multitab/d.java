package com.larus.kmp.voice_setting.voice.base.multitab;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f351802a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ah9.c f351803b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f351802a, r101.f351802a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f351803b, r101.f351803b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f351802a.hashCode() * 31) + this.f351803b.hashCode();
    }

    public final String toString() {
        return "MultiTabVoiceLoadResult(nextContext=" + this.f351802a + ", cache=" + this.f351803b + ')';
    }

    public d(b r100, ah9.c r101) {
        Intrinsics.checkNotNullParameter(r100, "nextContext");
        Intrinsics.checkNotNullParameter(r101, "cache");
        this.f351802a = r100;
        this.f351803b = r101;
    }
}
