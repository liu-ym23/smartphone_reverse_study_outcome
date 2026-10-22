package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f434774a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<String> f434775b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f434776c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final MmAIInterpretationAecPolicy f434777d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof j) == true) goto L8;
        return false;
    L8:
        j r101 = (j) r100;
        if (this.f434774a == r101.f434774a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f434775b, r101.f434775b) == true) goto L15;
        return false;
    L15:
        if (this.f434776c == r101.f434776c) goto L18;
        return false;
    L18:
        if (this.f434777d == r101.f434777d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f434774a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = ((r101 * 31) + this.f434775b.hashCode()) * 31;
        if (this.f434776c == true) goto L11;
        r100 = 1237;
    L11:
        return ((r102 + r100) * 31) + this.f434777d.hashCode();
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "MmAIInterpretationRtcAction(enableRescaleAudioVolume=" + this.f434774a + ", subChannels=" + this.f434775b + ", playbackMuted=" + this.f434776c + ", aecPolicy=" + this.f434777d + ')';
    }

    public j(boolean r100, List<String> r101, boolean r102, MmAIInterpretationAecPolicy r103) {
        Intrinsics.checkNotNullParameter(r101, "subChannels");
        Intrinsics.checkNotNullParameter(r103, "aecPolicy");
        this.f434774a = r100;
        this.f434775b = r101;
        this.f434776c = r102;
        this.f434777d = r103;
    }
}
