package com.larus.kmp.voice_setting.voice.mix;

import com.tencent.qqmusic.third.api.contract.Keys;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class y0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f353964a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f353965b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f353966c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final VoiceMixPlayVisualState f353967d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f353968e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof y0) == true) goto L8;
        return false;
    L8:
        y0 r101 = (y0) r100;
        if (Intrinsics.areEqual(this.f353964a, r101.f353964a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f353965b, r101.f353965b) == true) goto L15;
        return false;
    L15:
        if (this.f353966c == r101.f353966c) goto L18;
        return false;
    L18:
        if (this.f353967d == r101.f353967d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f353968e, r101.f353968e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f353964a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = ((((((r102 * 31) + this.f353965b.hashCode()) * 31) + this.f353966c) * 31) + this.f353967d.hashCode()) * 31;
        String r104 = this.f353968e;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "VoiceMixMultiRowState(voiceId=" + this.f353964a + ", title=" + this.f353965b + ", progress=" + this.f353966c + ", playState=" + this.f353967d + ", avatarUrl=" + this.f353968e + ')';
    }

    public y0(String r100, String r101, int r102, VoiceMixPlayVisualState r103) {
        Intrinsics.checkNotNullParameter(r101, "title");
        Intrinsics.checkNotNullParameter(r103, Keys.API_EVENT_KEY_PLAY_STATE);
        this.f353964a = r100;
        this.f353965b = r101;
        this.f353966c = r102;
        this.f353967d = r103;
        this.f353968e = null;
    }
}
