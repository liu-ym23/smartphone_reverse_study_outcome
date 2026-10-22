package com.larus.kmp.voice_setting.voice.list.p011public;

import com.larus.kmp.voice_setting.voice.list.row.u;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f353558a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f353559b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final u f353560c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f353558a, r101.f353558a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f353559b, r101.f353559b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f353560c, r101.f353560c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f353558a.hashCode() * 31) + this.f353559b.hashCode()) * 31) + this.f353560c.hashCode();
    }

    public final String toString() {
        return "PublicVoiceListRowUiState(key=" + this.f353558a + ", voiceId=" + this.f353559b + ", state=" + this.f353560c + ')';
    }

    public b(String r100, String r101, u r102) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "voiceId");
        Intrinsics.checkNotNullParameter(r102, "state");
        this.f353558a = r100;
        this.f353559b = r101;
        this.f353560c = r102;
    }
}
