package com.larus.kmp.voice_setting.voice.component;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class d6 implements m1a.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final VoiceRowActionKind f352212a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final VoiceListKind f352213b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f352214c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f352215d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f352216e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f352217f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f352218g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final com.larus.kmp.voice_setting.voice.screen.single.t0 f352219h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final VoiceDropdownMenuItemKind f352220i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f352221j;

    public d6() {
        this(null, null, 0, 0, null, null, null, null, null, false, 1023);
    }

    public d6(VoiceRowActionKind r100, VoiceListKind r101, int r102, int r103, String r104, String r105, String r106, com.larus.kmp.voice_setting.voice.screen.single.t0 r107, VoiceDropdownMenuItemKind r110, boolean r111) {
        Intrinsics.checkNotNullParameter(r100, "kind");
        Intrinsics.checkNotNullParameter(r101, "listKind");
        this.f352212a = r100;
        this.f352213b = r101;
        this.f352214c = r102;
        this.f352215d = r103;
        this.f352216e = r104;
        this.f352217f = r105;
        this.f352218g = r106;
        this.f352219h = r107;
        this.f352220i = r110;
        this.f352221j = r111;
    }

    public /* synthetic */ d6(VoiceRowActionKind r110, VoiceListKind r111, int r112, int r113, String r114, String r115, String r116, com.larus.kmp.voice_setting.voice.screen.single.t0 r117, VoiceDropdownMenuItemKind r210, boolean r211, int r212) {
        if ((r212 & 1) == 0) goto L5;
        VoiceRowActionKind r100 = VoiceRowActionKind.NONE;
    L7:
        if ((r212 & 2) == 0) goto L9;
        VoiceListKind r101 = VoiceListKind.UNSPECIFIED;
    L10:
        int r102 = -1;
        if ((r212 & 4) == 0) goto L13;
        int r103 = -1;
    L15:
        if ((r212 & 8) != 0) goto L18;
        r102 = r113;
    L18:
        VoiceDropdownMenuItemKind r104 = null;
        if ((r212 & 16) == 0) goto L21;
        String r105 = null;
    L23:
        if ((r212 & 32) == 0) goto L25;
        String r106 = null;
    L27:
        if ((r212 & 64) == 0) goto L29;
        String r107 = null;
    L31:
        if ((r212 & 128) == 0) goto L33;
        com.larus.kmp.voice_setting.voice.screen.single.t0 r108 = null;
    L35:
        if ((r212 & 256) != 0) goto L39;
        r104 = r210;
    L39:
        if ((r212 & 512) == 0) goto L41;
        boolean r109 = false;
    L42:
        this(r100, r101, r103, r102, r105, r106, r107, r108, r104, r109);
        return;
    L41:
        r109 = r211;
        goto L42
    L33:
        r108 = r117;
        goto L35
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L13:
        r103 = r112;
        goto L15
    L9:
        r101 = r111;
        goto L10
    L5:
        r100 = r110;
        goto L7
    }
}
