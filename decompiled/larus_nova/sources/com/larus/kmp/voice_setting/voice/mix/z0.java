package com.larus.kmp.voice_setting.voice.mix;

import com.tencent.qqmusic.third.api.contract.Keys;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class z0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f353975a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final VoiceMixPlayVisualState f353976b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f353977c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f353978d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof z0) == true) goto L8;
        return false;
    L8:
        z0 r101 = (z0) r100;
        if (Intrinsics.areEqual(this.f353975a, r101.f353975a) == true) goto L12;
        return false;
    L12:
        if (this.f353976b == r101.f353976b) goto L15;
        return false;
    L15:
        if (this.f353977c == r101.f353977c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f353978d, r101.f353978d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f353975a.hashCode() * 31) + this.f353976b.hashCode()) * 31;
        if (this.f353977c == false) goto L5;
        int r101 = 1231;
    L7:
        return ((r100 + r101) * 31) + this.f353978d.hashCode();
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "VoiceMixSingleRowState(title=" + this.f353975a + ", playState=" + this.f353976b + ", showExpand=" + this.f353977c + ", expandContentDescription=" + this.f353978d + ')';
    }

    public static z0 a(z0 r100, String r101) {
        String r102 = r100.f353975a;
        VoiceMixPlayVisualState r103 = r100.f353976b;
        boolean r104 = r100.f353977c;
        Intrinsics.checkNotNullParameter(r102, "title");
        Intrinsics.checkNotNullParameter(r103, Keys.API_EVENT_KEY_PLAY_STATE);
        Intrinsics.checkNotNullParameter(r101, "expandContentDescription");
        return new z0(r102, r103, r104, r101);
    }

    public z0(String r100, VoiceMixPlayVisualState r101, boolean r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "title");
        Intrinsics.checkNotNullParameter(r101, Keys.API_EVENT_KEY_PLAY_STATE);
        Intrinsics.checkNotNullParameter(r103, "expandContentDescription");
        this.f353975a = r100;
        this.f353976b = r101;
        this.f353977c = r102;
        this.f353978d = r103;
    }
}
