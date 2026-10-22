package com.larus.kmp.voice_setting.platform;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f351670a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f351671b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f351672c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a0) == true) goto L8;
        return false;
    L8:
        a0 r101 = (a0) r100;
        if (Intrinsics.areEqual(this.f351670a, r101.f351670a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f351671b, r101.f351671b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f351672c, r101.f351672c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f351670a.hashCode() * 31;
        String r101 = this.f351671b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        Object r105 = this.f351672c;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return r104 + r102;
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "VoiceChatRouteRequest(previousPage=" + this.f351670a + ", conversationId=" + this.f351671b + ", platformBotInfo=" + this.f351672c + ')';
    }

    public a0(String r100, String r101, Object r102) {
        Intrinsics.checkNotNullParameter(r100, "previousPage");
        this.f351670a = r100;
        this.f351671b = r101;
        this.f351672c = r102;
    }
}
