package com.larus.kmp.voice_setting.voice.component;

import com.ss.android.socialbase.appdownloader.util.parser.zip.UnixStat;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class y3 implements m1a.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.larus.kmp.voice_setting.voice.screen.doubletab.w3 f352628a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.larus.kmp.voice_setting.voice.screen.doubletab.v f352629b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f352630c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f352631d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.larus.kmp.voice_setting.voice.screen.doubletab.n8 f352632e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<String, b5> f352633f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final b6 f352634g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final x3 f352635h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final u8 f352636i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final a6 f352637j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final VoiceDoubleTabChromeActionKind f352638k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f352639l;

    public y3() {
        this(null, null, null, null, null, null, null, null, UnixStat.PERM_MASK);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof y3) == true) goto L8;
        return false;
    L8:
        y3 r101 = (y3) r100;
        if (Intrinsics.areEqual(this.f352628a, r101.f352628a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f352629b, r101.f352629b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f352630c, r101.f352630c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f352631d, r101.f352631d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f352632e, r101.f352632e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f352633f, r101.f352633f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f352634g, r101.f352634g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f352635h, r101.f352635h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f352636i, r101.f352636i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f352637j, r101.f352637j) == true) goto L39;
        return false;
    L39:
        if (this.f352638k == r101.f352638k) goto L42;
        return false;
    L42:
        if (this.f352639l == r101.f352639l) goto L44;
        return false;
    L44:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f352628a.hashCode() * 31) + this.f352629b.hashCode()) * 31;
        String r101 = this.f352630c;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f352631d;
        if (r105 == null) goto L10;
        r102 = r105.hashCode();
    L10:
        int r106 = (((((((((((((((r104 + r102) * 31) + this.f352632e.hashCode()) * 31) + this.f352633f.hashCode()) * 31) + this.f352634g.hashCode()) * 31) + this.f352635h.hashCode()) * 31) + this.f352636i.hashCode()) * 31) + this.f352637j.hashCode()) * 31) + this.f352638k.hashCode()) * 31;
        if (this.f352639l == false) goto L13;
        int r107 = 1231;
    L15:
        return r106 + r107;
    L13:
        r107 = 1237;
        goto L15
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "VoiceDoubleTabStateData(titleBarState=" + this.f352628a + ", createButtonState=" + this.f352629b + ", activeTabKey=" + this.f352630c + ", selectedVoiceId=" + this.f352631d + ", ttsBackgroundPlayState=" + this.f352632e + ", pageListStates=" + this.f352633f + ", rootRouteState=" + this.f352634g + ", shellState=" + this.f352635h + ", tabPagerState=" + this.f352636i + ", lastRootAction=" + this.f352637j + ", lastChromeAction=" + this.f352638k + ", createLaunchConsumed=" + this.f352639l + ')';
    }

    public static y3 a(y3 r110, VoiceDoubleTabChromeActionKind r111, boolean r112, int r210) {
        a6 r100 = null;
        if ((r210 & 1) == 0) goto L5;
        com.larus.kmp.voice_setting.voice.screen.doubletab.w3 r101 = r110.f352628a;
    L7:
        if ((r210 & 2) == 0) goto L9;
        com.larus.kmp.voice_setting.voice.screen.doubletab.v r102 = r110.f352629b;
    L11:
        if ((r210 & 4) == 0) goto L13;
        String r103 = r110.f352630c;
    L15:
        if ((r210 & 8) == 0) goto L17;
        String r104 = r110.f352631d;
    L19:
        if ((r210 & 16) == 0) goto L21;
        com.larus.kmp.voice_setting.voice.screen.doubletab.n8 r105 = r110.f352632e;
    L23:
        if ((r210 & 32) == 0) goto L25;
        Map<String, b5> r113 = r110.f352633f;
    L27:
        if ((r210 & 64) == 0) goto L29;
        b6 r114 = r110.f352634g;
    L31:
        if ((r210 & 128) == 0) goto L33;
        x3 r115 = r110.f352635h;
    L35:
        if ((r210 & 256) == 0) goto L37;
        u8 r116 = r110.f352636i;
    L39:
        if ((r210 & 512) == 0) goto L41;
        r100 = r110.f352637j;
    L41:
        a6 r117 = r100;
        if ((r210 & 1024) == 0) goto L44;
        VoiceDoubleTabChromeActionKind r118 = r110.f352638k;
    L46:
        if ((r210 & 2048) == 0) goto L48;
        boolean r119 = r110.f352639l;
    L49:
        r110.getClass();
        Intrinsics.checkNotNullParameter(r101, "titleBarState");
        Intrinsics.checkNotNullParameter(r102, "createButtonState");
        Intrinsics.checkNotNullParameter(r105, "ttsBackgroundPlayState");
        Intrinsics.checkNotNullParameter(r113, "pageListStates");
        Intrinsics.checkNotNullParameter(r114, "rootRouteState");
        Intrinsics.checkNotNullParameter(r115, "shellState");
        Intrinsics.checkNotNullParameter(r116, "tabPagerState");
        Intrinsics.checkNotNullParameter(r117, "lastRootAction");
        Intrinsics.checkNotNullParameter(r118, "lastChromeAction");
        return new y3(r101, r102, r103, r104, r105, r113, r114, r115, r116, r117, r118, r119);
    L48:
        r119 = r112;
        goto L49
    L44:
        r118 = r111;
        goto L46
    L37:
        r116 = null;
        goto L39
    L33:
        r115 = null;
        goto L35
    L29:
        r114 = null;
        goto L31
    L25:
        r113 = null;
        goto L27
    L21:
        r105 = null;
        goto L23
    L17:
        r104 = null;
        goto L19
    L13:
        r103 = null;
        goto L15
    L9:
        r102 = null;
        goto L11
    L5:
        r101 = null;
        goto L7
    }

    public /* synthetic */ y3(com.larus.kmp.voice_setting.voice.screen.doubletab.w3 r110, com.larus.kmp.voice_setting.voice.screen.doubletab.v r210, String r211, String r212, com.larus.kmp.voice_setting.voice.screen.doubletab.n8 r213, Map r214, x3 r215, u8 r216, int r217) {
        VoiceDoubleTabChromeActionKind r100 = null;
        if ((r217 & 1) == 0) goto L5;
        com.larus.kmp.voice_setting.voice.screen.doubletab.w3 r101 = new com.larus.kmp.voice_setting.voice.screen.doubletab.w3(null, null, null, 15);
    L7:
        if ((r217 & 2) == 0) goto L9;
        com.larus.kmp.voice_setting.voice.screen.doubletab.v r102 = new com.larus.kmp.voice_setting.voice.screen.doubletab.v(0);
    L11:
        if ((r217 & 4) == 0) goto L13;
        String r103 = null;
    L15:
        if ((r217 & 8) == 0) goto L17;
        String r104 = null;
    L19:
        if ((r217 & 16) == 0) goto L21;
        com.larus.kmp.voice_setting.voice.screen.doubletab.n8 r105 = new com.larus.kmp.voice_setting.voice.screen.doubletab.n8(null, 7);
    L23:
        if ((r217 & 32) == 0) goto L25;
        Map r111 = MapsKt.emptyMap();
    L27:
        if ((r217 & 64) == 0) goto L29;
        b6 r112 = new b6(VoiceRootRouteKind.DOUBLE_TAB_SHELL, null, null, null, null, 62);
    L31:
        if ((r217 & 128) == 0) goto L33;
        x3 r113 = new x3(null, null, 255);
    L35:
        if ((r217 & 256) == 0) goto L37;
        u8 r114 = new u8(0);
    L39:
        if ((r217 & 512) == 0) goto L41;
        a6 r115 = new a6(0);
    L43:
        if ((r217 & 1024) == 0) goto L45;
        r100 = VoiceDoubleTabChromeActionKind.NONE;
    L45:
        this(r101, r102, r103, r104, r105, r111, r112, r113, r114, r115, r100, false);
        return;
    L41:
        r115 = null;
        goto L43
    L37:
        r114 = r216;
        goto L39
    L33:
        r113 = r215;
        goto L35
    L29:
        r112 = null;
        goto L31
    L25:
        r111 = r214;
        goto L27
    L21:
        r105 = r213;
        goto L23
    L17:
        r104 = r212;
        goto L19
    L13:
        r103 = r211;
        goto L15
    L9:
        r102 = r210;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }

    public y3(com.larus.kmp.voice_setting.voice.screen.doubletab.w3 r100, com.larus.kmp.voice_setting.voice.screen.doubletab.v r101, String r102, String r103, com.larus.kmp.voice_setting.voice.screen.doubletab.n8 r104, Map<String, b5> r105, b6 r106, x3 r107, u8 r110, a6 r111, VoiceDoubleTabChromeActionKind r112, boolean r113) {
        Intrinsics.checkNotNullParameter(r100, "titleBarState");
        Intrinsics.checkNotNullParameter(r101, "createButtonState");
        Intrinsics.checkNotNullParameter(r104, "ttsBackgroundPlayState");
        Intrinsics.checkNotNullParameter(r105, "pageListStates");
        Intrinsics.checkNotNullParameter(r106, "rootRouteState");
        Intrinsics.checkNotNullParameter(r107, "shellState");
        Intrinsics.checkNotNullParameter(r110, "tabPagerState");
        Intrinsics.checkNotNullParameter(r111, "lastRootAction");
        Intrinsics.checkNotNullParameter(r112, "lastChromeAction");
        this.f352628a = r100;
        this.f352629b = r101;
        this.f352630c = r102;
        this.f352631d = r103;
        this.f352632e = r104;
        this.f352633f = r105;
        this.f352634g = r106;
        this.f352635h = r107;
        this.f352636i = r110;
        this.f352637j = r111;
        this.f352638k = r112;
        this.f352639l = r113;
    }
}
