package com.larus.voice_setting.voice;

import com.larus.im.bean.bot.SpeakerVoice;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class o2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SpeakerVoice f376965a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f376966b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f376967c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f376968d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f376969e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f376970f;

    public o2() {
        this(null, 0, 0, 0, 0, 63, 0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof o2) == true) goto L8;
        return false;
    L8:
        o2 r101 = (o2) r100;
        if (Intrinsics.areEqual(this.f376965a, r101.f376965a) == true) goto L12;
        return false;
    L12:
        if (this.f376966b == r101.f376966b) goto L15;
        return false;
    L15:
        if (this.f376967c == r101.f376967c) goto L18;
        return false;
    L18:
        if (this.f376968d == r101.f376968d) goto L21;
        return false;
    L21:
        if (this.f376969e == r101.f376969e) goto L24;
        return false;
    L24:
        if (this.f376970f == r101.f376970f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        SpeakerVoice r100 = this.f376965a;
        if (r100 != null) goto L5;
        int r101 = 0;
    L7:
        return (((((((((r101 * 31) + this.f376966b) * 31) + this.f376967c) * 31) + this.f376968d) * 31) + this.f376969e) * 31) + this.f376970f;
    L5:
        r101 = r100.hashCode();
        goto L7
    }

    public final String toString() {
        return "VoiceItem(voice=" + this.f376965a + ", selectedState=" + this.f376966b + ", uploadState=" + this.f376967c + ", playState=" + this.f376968d + ", addState=" + this.f376969e + ", itemType=" + this.f376970f + ')';
    }

    public static o2 a(o2 r100, SpeakerVoice r101) {
        return new o2(r101, r100.f376966b, r100.f376967c, r100.f376968d, r100.f376969e, r100.f376970f);
    }

    public o2(SpeakerVoice r100, int r101, int r102, int r103, int r104, int r105) {
        this.f376965a = r100;
        this.f376966b = r101;
        this.f376967c = r102;
        this.f376968d = r103;
        this.f376969e = r104;
        this.f376970f = r105;
    }

    public /* synthetic */ o2(SpeakerVoice r100, int r101, int r110, int r111, int r112, int r113, int r114) {
        if ((r113 & 1) == 0) goto L5;
        r100 = null;
    L5:
        SpeakerVoice r102 = r100;
        if ((r113 & 2) == 0) goto L8;
        int r103 = 10;
    L10:
        if ((r113 & 4) == 0) goto L12;
        int r104 = 1;
    L14:
        if ((r113 & 8) == 0) goto L16;
        int r105 = 2;
    L18:
        if ((r113 & 16) == 0) goto L20;
        int r106 = 60;
    L22:
        if ((r113 & 32) == 0) goto L24;
        int r107 = 0;
    L25:
        this(r102, r103, r104, r105, r106, r107);
        return;
    L24:
        r107 = r112;
        goto L25
    L20:
        r106 = r111;
        goto L22
    L16:
        r105 = 0;
        goto L18
    L12:
        r104 = r110;
        goto L14
    L8:
        r103 = r101;
        goto L10
    }
}
