package com.larus.kmp.voice_setting.voice.screen.doubletab;

import com.hihonor.honorid.core.data.UserInfo;
import com.larus.im.bean.bot.SpeakerVoice;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class p6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f354570a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SpeakerVoice f354571b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SpeakerVoice f354572c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f354573d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f354574e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.larus.kmp.voice_setting.voice.feature.i f354575f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f354576g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final mh9.s f354577h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f354578i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f354579j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final k7 f354580k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f354581l;

    public p6() {
        this(null, null, null, "", null, null, false, null, false, false, new k7(0), false);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof p6) == true) goto L8;
        return false;
    L8:
        p6 r101 = (p6) r100;
        if (Intrinsics.areEqual(this.f354570a, r101.f354570a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f354571b, r101.f354571b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f354572c, r101.f354572c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f354573d, r101.f354573d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f354574e, r101.f354574e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f354575f, r101.f354575f) == true) goto L27;
        return false;
    L27:
        if (this.f354576g == r101.f354576g) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f354577h, r101.f354577h) == true) goto L33;
        return false;
    L33:
        if (this.f354578i == r101.f354578i) goto L36;
        return false;
    L36:
        if (this.f354579j == r101.f354579j) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f354580k, r101.f354580k) == true) goto L42;
        return false;
    L42:
        if (this.f354581l == r101.f354581l) goto L44;
        return false;
    L44:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f354570a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        SpeakerVoice r104 = this.f354571b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        SpeakerVoice r107 = this.f354572c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (((r106 + r108) * 31) + this.f354573d.hashCode()) * 31;
        String r110 = this.f354574e;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        com.larus.kmp.voice_setting.voice.feature.i r113 = this.f354575f;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        int r116 = 1231;
        if (this.f354576g == false) goto L25;
        int r117 = 1231;
    L26:
        int r118 = (r115 + r117) * 31;
        mh9.s r119 = this.f354577h;
        if (r119 == null) goto L30;
        r101 = r119.hashCode();
    L30:
        int r120 = (r118 + r101) * 31;
        if (this.f354578i == false) goto L33;
        int r121 = 1231;
    L34:
        int r122 = (r120 + r121) * 31;
        if (this.f354579j == false) goto L37;
        int r123 = 1231;
    L38:
        int r124 = (((r122 + r123) * 31) + this.f354580k.hashCode()) * 31;
        if (this.f354581l == true) goto L43;
        r116 = 1237;
    L43:
        return r124 + r116;
    L37:
        r123 = 1237;
        goto L38
    L33:
        r121 = 1237;
        goto L34
    L25:
        r117 = 1237;
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "VoiceDoubleTabPlatformSnapshot(botId=" + this.f354570a + ", botVoice=" + this.f354571b + ", initialVoice=" + this.f354572c + ", languageCode=" + this.f354573d + ", landingTab=" + this.f354574e + ", recommendRequest=" + this.f354575f + ", recommendRequestHasScene=" + this.f354576g + ", recommendFrom=" + this.f354577h + ", isMainBot=" + this.f354578i + ", singleUiMode=" + this.f354579j + ", selectMode=" + this.f354580k + ", defaultExpandMixVoiceView=" + this.f354581l + ')';
    }

    public p6(String r100, SpeakerVoice r101, SpeakerVoice r102, String r103, String r104, com.larus.kmp.voice_setting.voice.feature.i r105, boolean r106, mh9.s r107, boolean r110, boolean r111, k7 r112, boolean r113) {
        Intrinsics.checkNotNullParameter(r103, UserInfo.LANGUAGECODE);
        Intrinsics.checkNotNullParameter(r112, "selectMode");
        this.f354570a = r100;
        this.f354571b = r101;
        this.f354572c = r102;
        this.f354573d = r103;
        this.f354574e = r104;
        this.f354575f = r105;
        this.f354576g = r106;
        this.f354577h = r107;
        this.f354578i = r110;
        this.f354579j = r111;
        this.f354580k = r112;
        this.f354581l = r113;
    }
}
