package com.larus.kmp.voice_setting.voice.component;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class f0 implements m1a.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final VoiceDialogKind f352243a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f352244b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d0 f352245c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f352246d;

    public f0() {
        this(null, 0, null, 15);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f0) == true) goto L8;
        return false;
    L8:
        f0 r101 = (f0) r100;
        if (this.f352243a == r101.f352243a) goto L12;
        return false;
    L12:
        if (this.f352244b == r101.f352244b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f352245c, r101.f352245c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f352246d, r101.f352246d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f352243a.hashCode() * 31;
        long r101 = this.f352244b;
        int r102 = (((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.f352245c.hashCode()) * 31;
        String r103 = this.f352246d;
        if (r103 != null) goto L5;
        int r104 = 0;
    L7:
        return r102 + r104;
    L5:
        r104 = r103.hashCode();
        goto L7
    }

    public final String toString() {
        return "VoiceDialogHostRequestData(kind=" + this.f352243a + ", token=" + this.f352244b + ", args=" + this.f352245c + ", source=" + this.f352246d + ')';
    }

    public /* synthetic */ f0(VoiceDialogKind r110, long r111, d0 r112, int r113) {
        if ((r113 & 1) == 0) goto L5;
        VoiceDialogKind r100 = VoiceDialogKind.NONE;
    L7:
        if ((r113 & 2) == 0) goto L9;
        long r101 = 0;
    L11:
        if ((r113 & 4) == 0) goto L13;
        d0 r102 = new d0(null, null, null, null, null, null, 255);
    L14:
        this(r100, r101, r102, null);
        return;
    L13:
        r102 = r112;
        goto L14
    L9:
        r101 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }

    public f0(VoiceDialogKind r100, long r101, d0 r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "kind");
        Intrinsics.checkNotNullParameter(r102, "args");
        this.f352243a = r100;
        this.f352244b = r101;
        this.f352245c = r102;
        this.f352246d = r103;
    }
}
