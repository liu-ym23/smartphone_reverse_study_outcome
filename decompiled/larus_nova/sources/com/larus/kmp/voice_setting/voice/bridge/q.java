package com.larus.kmp.voice_setting.voice.bridge;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f351890a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f351891b;

    public q() {
        this(null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof q) == true) goto L8;
        return false;
    L8:
        q r101 = (q) r100;
        if (Intrinsics.areEqual(this.f351890a, r101.f351890a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f351891b, r101.f351891b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f351890a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f351891b;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "VoiceDoubleTabPlatformIdentityData(mainBotId=" + this.f351890a + ", currentUserId=" + this.f351891b + ')';
    }

    public q(String r100, String r101) {
        this.f351890a = r100;
        this.f351891b = r101;
    }
}
