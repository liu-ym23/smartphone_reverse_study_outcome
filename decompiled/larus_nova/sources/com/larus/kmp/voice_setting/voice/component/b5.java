package com.larus.kmp.voice_setting.voice.component;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class b5 implements m1a.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final VoiceListKind f352162a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.larus.kmp.voice_setting.voice.list.p011public.p f352163b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.larus.kmp.voice_setting.voice.list.managed.a0 f352164c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f352165d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f352166e;

    public b5() {
        this(null, null, null, null, 31);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b5) == true) goto L8;
        return false;
    L8:
        b5 r101 = (b5) r100;
        if (this.f352162a == r101.f352162a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f352163b, r101.f352163b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f352164c, r101.f352164c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f352165d, r101.f352165d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f352166e, r101.f352166e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f352162a.hashCode() * 31) + this.f352163b.hashCode()) * 31) + this.f352164c.hashCode()) * 31;
        String r101 = this.f352165d;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f352166e;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return r104 + r102;
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "VoiceListStateData(kind=" + this.f352162a + ", publicScreenState=" + this.f352163b + ", managedScreenState=" + this.f352164c + ", selectedVoiceId=" + this.f352165d + ", activeTabKey=" + this.f352166e + ')';
    }

    public /* synthetic */ b5(VoiceListKind r110, com.larus.kmp.voice_setting.voice.list.managed.a0 r111, String r112, String r113, int r210) {
        if ((r210 & 1) == 0) goto L5;
        VoiceListKind r100 = VoiceListKind.UNSPECIFIED;
    L7:
        if ((r210 & 2) == 0) goto L9;
        com.larus.kmp.voice_setting.voice.list.p011public.p r101 = new com.larus.kmp.voice_setting.voice.list.p011public.p(0);
    L11:
        if ((r210 & 4) == 0) goto L13;
        com.larus.kmp.voice_setting.voice.list.managed.a0 r102 = new com.larus.kmp.voice_setting.voice.list.managed.a0(null, null, null, null, null, null, 0, 0, null, 1023);
    L15:
        if ((r210 & 8) == 0) goto L17;
        String r103 = null;
    L19:
        if ((r210 & 16) == 0) goto L21;
        String r104 = null;
    L22:
        this(r100, r101, r102, r103, r104);
        return;
    L21:
        r104 = r113;
        goto L22
    L17:
        r103 = r112;
        goto L19
    L13:
        r102 = r111;
        goto L15
    L9:
        r101 = null;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }

    public b5(VoiceListKind r100, com.larus.kmp.voice_setting.voice.list.p011public.p r101, com.larus.kmp.voice_setting.voice.list.managed.a0 r102, String r103, String r104) {
        Intrinsics.checkNotNullParameter(r100, "kind");
        Intrinsics.checkNotNullParameter(r101, "publicScreenState");
        Intrinsics.checkNotNullParameter(r102, "managedScreenState");
        this.f352162a = r100;
        this.f352163b = r101;
        this.f352164c = r102;
        this.f352165d = r103;
        this.f352166e = r104;
    }

    public static b5 a(b5 r100, VoiceListKind r101, com.larus.kmp.voice_setting.voice.list.p011public.p r102, String r103, String r110, int r111) {
        if ((r111 & 1) == 0) goto L5;
        r101 = r100.f352162a;
    L5:
        VoiceListKind r104 = r101;
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.f352163b;
    L8:
        com.larus.kmp.voice_setting.voice.list.p011public.p r105 = r102;
        if ((r111 & 4) == 0) goto L11;
        com.larus.kmp.voice_setting.voice.list.managed.a0 r106 = r100.f352164c;
    L12:
        com.larus.kmp.voice_setting.voice.list.managed.a0 r107 = r106;
        if ((r111 & 8) == 0) goto L15;
        r103 = r100.f352165d;
    L15:
        String r108 = r103;
        if ((r111 & 16) == 0) goto L18;
        r110 = r100.f352166e;
    L18:
        r100.getClass();
        Intrinsics.checkNotNullParameter(r104, "kind");
        Intrinsics.checkNotNullParameter(r105, "publicScreenState");
        Intrinsics.checkNotNullParameter(r107, "managedScreenState");
        return new b5(r104, r105, r107, r108, r110);
    L11:
        r106 = null;
        goto L12
    }
}
