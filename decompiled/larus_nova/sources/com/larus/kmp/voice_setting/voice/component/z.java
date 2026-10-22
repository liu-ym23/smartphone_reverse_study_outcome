package com.larus.kmp.voice_setting.voice.component;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class z implements m1a.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f352650a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f352651b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f352652c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f352653d;

    public z() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof z) == true) goto L8;
        return false;
    L8:
        z r101 = (z) r100;
        if (this.f352650a == r101.f352650a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f352651b, r101.f352651b) == true) goto L15;
        return false;
    L15:
        if (this.f352652c == r101.f352652c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f352653d, r101.f352653d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        long r100 = this.f352650a;
        return (((((((int) (r100 ^ (r100 >>> 32))) * 31) + this.f352651b.hashCode()) * 31) + this.f352652c) * 31) + this.f352653d.hashCode();
    }

    public final String toString() {
        return "VoiceCreatedVoiceSelectionData(token=" + this.f352650a + ", voiceId=" + this.f352651b + ", voiceStatus=" + this.f352652c + ", source=" + this.f352653d + ')';
    }

    public /* synthetic */ z(int r100) {
        this(0, "", 0, "");
    }

    public z(long r100, String r101, int r102, String r103) {
        Intrinsics.checkNotNullParameter(r101, "voiceId");
        Intrinsics.checkNotNullParameter(r103, "source");
        this.f352650a = r100;
        this.f352651b = r101;
        this.f352652c = r102;
        this.f352653d = r103;
    }
}
