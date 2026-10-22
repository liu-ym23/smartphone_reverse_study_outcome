package com.larus.kmp.voice_setting.voice.list.row;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f353671a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f353672b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f353673c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final VoiceAvatarFallback f353674d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f353675e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f353676f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f353677g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f353678h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f353679i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f353680j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f353681k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final VoiceStatusTone f353682l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final VoiceSelectionState f353683m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f353684n;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof t) == true) goto L8;
        return false;
    L8:
        t r101 = (t) r100;
        if (Intrinsics.areEqual(this.f353671a, r101.f353671a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f353672b, r101.f353672b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f353673c, r101.f353673c) == true) goto L18;
        return false;
    L18:
        if (this.f353674d == r101.f353674d) goto L21;
        return false;
    L21:
        if (this.f353675e == r101.f353675e) goto L24;
        return false;
    L24:
        if (this.f353676f == r101.f353676f) goto L27;
        return false;
    L27:
        if (this.f353677g == r101.f353677g) goto L30;
        return false;
    L30:
        if (this.f353678h == r101.f353678h) goto L33;
        return false;
    L33:
        if (this.f353679i == r101.f353679i) goto L36;
        return false;
    L36:
        if (this.f353680j == r101.f353680j) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f353681k, r101.f353681k) == true) goto L42;
        return false;
    L42:
        if (this.f353682l == r101.f353682l) goto L45;
        return false;
    L45:
        if (this.f353683m == r101.f353683m) goto L48;
        return false;
    L48:
        if (this.f353684n == r101.f353684n) goto L50;
        return false;
    L50:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((this.f353671a.hashCode() * 31) + this.f353672b.hashCode()) * 31) + this.f353673c.hashCode()) * 31) + this.f353674d.hashCode()) * 31;
        int r101 = 1231;
        if (this.f353675e == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f353676f == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (r103 + r104) * 31;
        if (this.f353677g == false) goto L13;
        int r106 = 1231;
    L14:
        int r107 = (r105 + r106) * 31;
        if (this.f353678h == false) goto L17;
        int r108 = 1231;
    L18:
        int r109 = (r107 + r108) * 31;
        if (this.f353679i == false) goto L21;
        int r110 = 1231;
    L22:
        int r111 = (r109 + r110) * 31;
        if (this.f353680j == false) goto L25;
        int r112 = 1231;
    L26:
        int r113 = (((((((r111 + r112) * 31) + this.f353681k.hashCode()) * 31) + this.f353682l.hashCode()) * 31) + this.f353683m.hashCode()) * 31;
        if (this.f353684n == true) goto L31;
        r101 = 1237;
    L31:
        return r113 + r101;
    L25:
        r112 = 1237;
        goto L26
    L21:
        r110 = 1237;
        goto L22
    L17:
        r108 = 1237;
        goto L18
    L13:
        r106 = 1237;
        goto L14
    L9:
        r104 = 1237;
        goto L10
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "NormalVoiceItemUiState(voiceName=" + this.f353671a + ", creatorName=" + this.f353672b + ", avatarUrl=" + this.f353673c + ", avatarFallback=" + this.f353674d + ", showAvatar=" + this.f353675e + ", showCreatorName=" + this.f353676f + ", showMoreButton=" + this.f353677g + ", showStatus=" + this.f353678h + ", showStatusErrorIcon=" + this.f353679i + ", showStatusLoading=" + this.f353680j + ", statusText=" + this.f353681k + ", statusTone=" + this.f353682l + ", selectionState=" + this.f353683m + ", dividerVisible=" + this.f353684n + ')';
    }

    public t() {
        this("", "", "", VoiceAvatarFallback.DEFAULT, true, false, false, false, false, false, "", VoiceStatusTone.DANGER, VoiceSelectionState.UNSELECTED, false);
    }

    public t(String r100, String r101, String r102, VoiceAvatarFallback r103, boolean r104, boolean r105, boolean r106, boolean r107, boolean r110, boolean r111, String r112, VoiceStatusTone r113, VoiceSelectionState r114, boolean r115) {
        Intrinsics.checkNotNullParameter(r100, "voiceName");
        Intrinsics.checkNotNullParameter(r101, "creatorName");
        Intrinsics.checkNotNullParameter(r102, "avatarUrl");
        Intrinsics.checkNotNullParameter(r103, "avatarFallback");
        Intrinsics.checkNotNullParameter(r112, "statusText");
        Intrinsics.checkNotNullParameter(r113, "statusTone");
        Intrinsics.checkNotNullParameter(r114, "selectionState");
        this.f353671a = r100;
        this.f353672b = r101;
        this.f353673c = r102;
        this.f353674d = r103;
        this.f353675e = r104;
        this.f353676f = r105;
        this.f353677g = r106;
        this.f353678h = r107;
        this.f353679i = r110;
        this.f353680j = r111;
        this.f353681k = r112;
        this.f353682l = r113;
        this.f353683m = r114;
        this.f353684n = r115;
    }
}
