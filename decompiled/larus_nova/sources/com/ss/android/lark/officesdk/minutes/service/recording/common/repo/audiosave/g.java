package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.audiosave;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MmRecordingAutoSaveDecisionScene f434892a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f434893b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f434894c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f434895d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final d f434896e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f434897f;

    public g() {
        this(null, false, 0, null, null, 63);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L8;
        return false;
    L8:
        g r101 = (g) r100;
        if (this.f434892a == r101.f434892a) goto L12;
        return false;
    L12:
        if (this.f434893b == r101.f434893b) goto L15;
        return false;
    L15:
        if (this.f434894c == r101.f434894c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f434895d, r101.f434895d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f434896e, r101.f434896e) == true) goto L24;
        return false;
    L24:
        if (this.f434897f == r101.f434897f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        MmRecordingAutoSaveDecisionScene r100 = this.f434892a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        int r104 = 1231;
        if (this.f434893b == false) goto L9;
        int r105 = 1231;
    L10:
        int r106 = (((r103 + r105) * 31) + this.f434894c) * 31;
        String r107 = this.f434895d;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        d r110 = this.f434896e;
        if (r110 == null) goto L18;
        r101 = r110.hashCode();
    L18:
        int r111 = (r109 + r101) * 31;
        if (this.f434897f == true) goto L23;
        r104 = 1237;
    L23:
        return r111 + r104;
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = 1237;
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "MmRecordingAutoSaveDecision(scene=" + this.f434892a + ", isForceSaveAudio=" + this.f434893b + ", saveAudioFinalDecision=" + this.f434894c + ", forceSaveReason=" + this.f434895d + ", unavailableReason=" + this.f434896e + ", hasShownRecordingStartDialog=" + this.f434897f + ')';
    }

    public /* synthetic */ g(MmRecordingAutoSaveDecisionScene r110, boolean r111, int r112, String r113, d r114, int r115) {
        if ((r115 & 1) == 0) goto L5;
        MmRecordingAutoSaveDecisionScene r100 = null;
    L7:
        if ((r115 & 2) == 0) goto L9;
        boolean r101 = false;
    L11:
        if ((r115 & 4) == 0) goto L13;
        r112 = MmAudioSaveType.SAVE.getValue();
    L13:
        int r102 = r112;
        if ((r115 & 8) == 0) goto L16;
        String r103 = null;
    L18:
        if ((r115 & 16) == 0) goto L20;
        d r104 = null;
    L21:
        this(r100, r101, r102, r103, r104, false);
        return;
    L20:
        r104 = r114;
        goto L21
    L16:
        r103 = r113;
        goto L18
    L9:
        r101 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }

    public g(MmRecordingAutoSaveDecisionScene r100, boolean r101, int r102, String r103, d r104, boolean r105) {
        this.f434892a = r100;
        this.f434893b = r101;
        this.f434894c = r102;
        this.f434895d = r103;
        this.f434896e = r104;
        this.f434897f = r105;
    }
}
