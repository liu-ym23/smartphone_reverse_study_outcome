package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.audiosave;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MmAudioSaveType f434888a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f434889b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f434890c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final g f434891d;

    public f() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (this.f434888a == r101.f434888a) goto L12;
        return false;
    L12:
        if (this.f434889b == r101.f434889b) goto L15;
        return false;
    L15:
        if (this.f434890c == r101.f434890c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f434891d, r101.f434891d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f434888a.hashCode() * 31;
        int r101 = 1231;
        if (this.f434889b == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f434890c == true) goto L11;
        r101 = 1237;
    L11:
        return ((r103 + r101) * 31) + this.f434891d.hashCode();
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "MmRecordingAudioSaveEntity(audioSaveType=" + this.f434888a + ", showAudioSaveEntry=" + this.f434889b + ", needShowAudioSaveBoarding=" + this.f434890c + ", autoSaveDecision=" + this.f434891d + ')';
    }

    public /* synthetic */ f(int r100) {
        this(MmAudioSaveType.SAVE, false, false, new g(null, false, 0, null, null, 63));
    }

    public f(MmAudioSaveType r100, boolean r101, boolean r102, g r103) {
        Intrinsics.checkNotNullParameter(r100, "audioSaveType");
        Intrinsics.checkNotNullParameter(r103, "autoSaveDecision");
        this.f434888a = r100;
        this.f434889b = r101;
        this.f434890c = r102;
        this.f434891d = r103;
    }

    public static f a(f r100, MmAudioSaveType r101, boolean r102, boolean r103, g r104, int r105) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.f434888a;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.f434889b;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.f434890c;
    L12:
        if ((r105 & 8) == 0) goto L14;
        r104 = r100.f434891d;
    L14:
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "audioSaveType");
        Intrinsics.checkNotNullParameter(r104, "autoSaveDecision");
        return new f(r101, r102, r103, r104);
    }
}
