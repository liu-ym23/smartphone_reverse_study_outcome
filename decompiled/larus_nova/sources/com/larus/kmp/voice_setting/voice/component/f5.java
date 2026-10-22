package com.larus.kmp.voice_setting.voice.component;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class f5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final VoiceMixPreviewActionKind f352251a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f352252b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f352253c;

    public f5() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f5) == true) goto L8;
        return false;
    L8:
        f5 r101 = (f5) r100;
        if (this.f352251a == r101.f352251a) goto L12;
        return false;
    L12:
        if (this.f352252b == r101.f352252b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f352253c, r101.f352253c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f352251a.hashCode() * 31;
        long r101 = this.f352252b;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        String r103 = this.f352253c;
        if (r103 != null) goto L5;
        int r104 = 0;
    L7:
        return r102 + r104;
    L5:
        r104 = r103.hashCode();
        goto L7
    }

    public final String toString() {
        return "VoiceMixPreviewActionMeta(kind=" + this.f352251a + ", token=" + this.f352252b + ", source=" + this.f352253c + ')';
    }

    public f5(int r100) {
        VoiceMixPreviewActionKind r101 = VoiceMixPreviewActionKind.NONE;
        Intrinsics.checkNotNullParameter(r101, "kind");
        this.f352251a = r101;
        this.f352252b = 0;
        this.f352253c = null;
    }
}
