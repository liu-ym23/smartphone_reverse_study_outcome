package com.larus.kmp.voice_setting.voice.component;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class o8 implements m1a.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.larus.kmp.voice_setting.voice.screen.single.c0 f352443a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.larus.kmp.voice_setting.voice.bridge.z f352444b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f352445c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b6 f352446d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a6 f352447e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f352448f;

    public o8() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof o8) == true) goto L8;
        return false;
    L8:
        o8 r101 = (o8) r100;
        if (Intrinsics.areEqual(this.f352443a, r101.f352443a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f352444b, r101.f352444b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f352445c, r101.f352445c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f352446d, r101.f352446d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f352447e, r101.f352447e) == true) goto L24;
        return false;
    L24:
        if (this.f352448f == r101.f352448f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f352443a.hashCode() * 31) + this.f352444b.hashCode()) * 31;
        String r101 = this.f352445c;
        if (r101 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = (((((r100 + r102) * 31) + this.f352446d.hashCode()) * 31) + this.f352447e.hashCode()) * 31;
        if (this.f352448f == false) goto L9;
        int r104 = 1231;
    L11:
        return r103 + r104;
    L9:
        r104 = 1237;
        goto L11
    L5:
        r102 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "VoiceSingleScreenStateData(screenState=" + this.f352443a + ", externalState=" + this.f352444b + ", selectedVoiceId=" + this.f352445c + ", rootRouteState=" + this.f352446d + ", lastRootAction=" + this.f352447e + ", createLaunchConsumed=" + this.f352448f + ')';
    }

    public /* synthetic */ o8(int r110) {
        int r111 = 0;
        this(new com.larus.kmp.voice_setting.voice.screen.single.c0(r111), new com.larus.kmp.voice_setting.voice.bridge.z(r111), null, new b6(VoiceRootRouteKind.SINGLE_SCREEN, null, null, null, null, 62), new a6(0), false);
    }

    public o8(com.larus.kmp.voice_setting.voice.screen.single.c0 r100, com.larus.kmp.voice_setting.voice.bridge.z r101, String r102, b6 r103, a6 r104, boolean r105) {
        Intrinsics.checkNotNullParameter(r100, "screenState");
        Intrinsics.checkNotNullParameter(r101, "externalState");
        Intrinsics.checkNotNullParameter(r103, "rootRouteState");
        Intrinsics.checkNotNullParameter(r104, "lastRootAction");
        this.f352443a = r100;
        this.f352444b = r101;
        this.f352445c = r102;
        this.f352446d = r103;
        this.f352447e = r104;
        this.f352448f = r105;
    }

    public static o8 a(o8 r100, com.larus.kmp.voice_setting.voice.screen.single.c0 r101, com.larus.kmp.voice_setting.voice.bridge.z r102, String r110, boolean r111, int r112) {
        if ((r112 & 1) == 0) goto L5;
        r101 = r100.f352443a;
    L5:
        com.larus.kmp.voice_setting.voice.screen.single.c0 r103 = r101;
        if ((r112 & 2) == 0) goto L8;
        r102 = r100.f352444b;
    L8:
        com.larus.kmp.voice_setting.voice.bridge.z r104 = r102;
        if ((r112 & 4) == 0) goto L11;
        r110 = r100.f352445c;
    L11:
        String r105 = r110;
        if ((r112 & 8) == 0) goto L14;
        b6 r106 = r100.f352446d;
    L16:
        if ((r112 & 16) == 0) goto L18;
        a6 r107 = r100.f352447e;
    L20:
        if ((r112 & 32) == 0) goto L22;
        r111 = r100.f352448f;
    L22:
        r100.getClass();
        Intrinsics.checkNotNullParameter(r103, "screenState");
        Intrinsics.checkNotNullParameter(r104, "externalState");
        Intrinsics.checkNotNullParameter(r106, "rootRouteState");
        Intrinsics.checkNotNullParameter(r107, "lastRootAction");
        return new o8(r103, r104, r105, r106, r107, r111);
    L18:
        r107 = null;
        goto L20
    L14:
        r106 = null;
        goto L16
    }
}
