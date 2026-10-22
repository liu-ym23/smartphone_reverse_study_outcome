package com.larus.kmp.voice_setting.voice.component;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class t implements m1a.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f352549a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final s f352550b;

    public t() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof t) == true) goto L8;
        return false;
    L8:
        t r101 = (t) r100;
        if (this.f352549a == r101.f352549a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f352550b, r101.f352550b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        long r100 = this.f352549a;
        return (((int) (r100 ^ (r100 >>> 32))) * 31) + this.f352550b.hashCode();
    }

    public final String toString() {
        return "VoiceCreatePreflightActionData(token=" + this.f352549a + ", meta=" + this.f352550b + ')';
    }

    public /* synthetic */ t(int r100) {
        this(0, new s(0));
    }

    public t(long r100, s r101) {
        Intrinsics.checkNotNullParameter(r101, "meta");
        this.f352549a = r100;
        this.f352550b = r101;
    }
}
