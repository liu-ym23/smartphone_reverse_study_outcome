package com.larus.kmp.voice_setting.voice.screen.doubletab;

import com.larus.im.bean.bot.SpeakerVoice;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class o6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f354544a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SpeakerVoice f354545b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Boolean f354546c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f354547d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final SpeakerVoice f354548e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof o6) == true) goto L8;
        return false;
    L8:
        o6 r101 = (o6) r100;
        if (this.f354544a == r101.f354544a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f354545b, r101.f354545b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f354546c, r101.f354546c) == true) goto L18;
        return false;
    L18:
        if (this.f354547d == r101.f354547d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f354548e, r101.f354548e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f354544a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        SpeakerVoice r103 = this.f354545b;
        int r104 = 0;
        if (r103 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r102 + r105) * 31;
        Boolean r107 = this.f354546c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        if (this.f354547d == true) goto L18;
        r100 = 1237;
    L18:
        int r110 = (r109 + r100) * 31;
        SpeakerVoice r111 = this.f354548e;
        if (r111 == null) goto L23;
        r104 = r111.hashCode();
    L23:
        return r110 + r104;
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r103.hashCode();
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "VoiceDoubleTabPlatformSaveResult(success=" + this.f354544a + ", savedVoice=" + this.f354545b + ", updateLocalBotSuccess=" + this.f354546c + ", requestedGetBotAfterSave=" + this.f354547d + ", getBotVoice=" + this.f354548e + ')';
    }

    public /* synthetic */ o6(boolean r100, SpeakerVoice r110, Boolean r111, int r112) {
        if ((r112 & 2) == 0) goto L5;
        SpeakerVoice r101 = null;
    L7:
        if ((r112 & 4) == 0) goto L9;
        Boolean r102 = null;
    L10:
        this(r100, r101, r102, false, null);
        return;
    L9:
        r102 = r111;
        goto L10
    L5:
        r101 = r110;
        goto L7
    }

    public o6(boolean r100, SpeakerVoice r101, Boolean r102, boolean r103, SpeakerVoice r104) {
        this.f354544a = r100;
        this.f354545b = r101;
        this.f354546c = r102;
        this.f354547d = r103;
        this.f354548e = r104;
    }
}
