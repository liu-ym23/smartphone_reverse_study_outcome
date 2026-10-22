package com.larus.kmp.voice_setting.voice.component;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class x implements m1a.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f352602a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f352603b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f352604c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final s f352605d;

    public x() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof x) == true) goto L8;
        return false;
    L8:
        x r101 = (x) r100;
        if (this.f352602a == r101.f352602a) goto L12;
        return false;
    L12:
        if (this.f352603b == r101.f352603b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f352604c, r101.f352604c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f352605d, r101.f352605d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        long r100 = this.f352602a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        if (this.f352603b == false) goto L5;
        int r102 = 1231;
    L7:
        return ((((r101 + r102) * 31) + this.f352604c.hashCode()) * 31) + this.f352605d.hashCode();
    L5:
        r102 = 1237;
        goto L7
    }

    public final String toString() {
        return "VoiceCreatePreflightResultData(token=" + this.f352602a + ", allowed=" + this.f352603b + ", reason=" + this.f352604c + ", meta=" + this.f352605d + ')';
    }

    public /* synthetic */ x(int r100) {
        this(0, false, "", new s(0));
    }

    public x(long r100, boolean r101, String r102, s r103) {
        Intrinsics.checkNotNullParameter(r102, "reason");
        Intrinsics.checkNotNullParameter(r103, "meta");
        this.f352602a = r100;
        this.f352603b = r101;
        this.f352604c = r102;
        this.f352605d = r103;
    }
}
