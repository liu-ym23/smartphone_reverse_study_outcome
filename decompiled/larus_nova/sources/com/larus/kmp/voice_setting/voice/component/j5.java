package com.larus.kmp.voice_setting.voice.component;

import com.larus.im.bean.bot.SpeakerVoice;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class j5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SpeakerVoice f352310a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f352311b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f352312c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f352313d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f352314e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f352315f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f352316g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f352317h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f352318i;

    public j5() {
        this(null, null, null, null, null, null, null, null, 511);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof j5) == true) goto L8;
        return false;
    L8:
        j5 r101 = (j5) r100;
        if (Intrinsics.areEqual(this.f352310a, r101.f352310a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f352311b, r101.f352311b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f352312c, r101.f352312c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f352313d, r101.f352313d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f352314e, r101.f352314e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f352315f, r101.f352315f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f352316g, r101.f352316g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f352317h, r101.f352317h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f352318i, r101.f352318i) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        SpeakerVoice r100 = this.f352310a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = ((((r102 * 31) + this.f352311b.hashCode()) * 31) + this.f352312c.hashCode()) * 31;
        String r104 = this.f352313d;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f352314e;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (((((((r106 + r108) * 31) + this.f352315f.hashCode()) * 31) + this.f352316g.hashCode()) * 31) + this.f352317h.hashCode()) * 31;
        String r110 = this.f352318i;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return r109 + r101;
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
        return "VoiceOptimizeDialogArgsData(voice=" + this.f352310a + ", localVoiceId=" + this.f352311b + ", voiceName=" + this.f352312c + ", avatarUri=" + this.f352313d + ", avatarUrl=" + this.f352314e + ", previousPage=" + this.f352315f + ", enterFrom=" + this.f352316g + ", enterMethod=" + this.f352317h + ", botId=" + this.f352318i + ')';
    }

    public j5(String r100, String r101, String r102, String r103, String r104, String r105, String r110, String r111, int r112) {
        if ((r112 & 2) == 0) goto L6;
        r100 = "";
    L6:
        if ((r112 & 4) == 0) goto L9;
        r101 = "";
    L9:
        if ((r112 & 8) == 0) goto L12;
        r102 = null;
    L12:
        if ((r112 & 16) == 0) goto L15;
        r103 = null;
    L15:
        if ((r112 & 32) == 0) goto L18;
        r104 = "";
    L18:
        if ((r112 & 64) == 0) goto L21;
        r105 = "";
    L21:
        if ((r112 & 128) == 0) goto L24;
        r110 = "";
    L24:
        if ((r112 & 256) == 0) goto L26;
        r111 = null;
    L26:
        Intrinsics.checkNotNullParameter(r100, "localVoiceId");
        Intrinsics.checkNotNullParameter(r101, "voiceName");
        Intrinsics.checkNotNullParameter(r104, "previousPage");
        Intrinsics.checkNotNullParameter(r105, "enterFrom");
        Intrinsics.checkNotNullParameter(r110, "enterMethod");
        this.f352310a = null;
        this.f352311b = r100;
        this.f352312c = r101;
        this.f352313d = r102;
        this.f352314e = r103;
        this.f352315f = r104;
        this.f352316g = r105;
        this.f352317h = r110;
        this.f352318i = r111;
    }
}
