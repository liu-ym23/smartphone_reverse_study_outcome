package com.larus.kmp.voice_setting.voice.component;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class w3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f352595a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f352596b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f352597c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f352598d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f352599e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f352600f;

    public w3() {
        this(null, null, 63);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof w3) == true) goto L8;
        return false;
    L8:
        w3 r101 = (w3) r100;
        if (Intrinsics.areEqual(this.f352595a, r101.f352595a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f352596b, r101.f352596b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f352597c, r101.f352597c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f352598d, r101.f352598d) == true) goto L21;
        return false;
    L21:
        if (this.f352599e == r101.f352599e) goto L24;
        return false;
    L24:
        if (this.f352600f == r101.f352600f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f352595a.hashCode() * 31) + this.f352596b.hashCode()) * 31) + this.f352597c.hashCode()) * 31;
        String r101 = this.f352598d;
        if (r101 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = (r100 + r102) * 31;
        int r104 = 1231;
        if (this.f352599e == false) goto L9;
        int r105 = 1231;
    L10:
        int r106 = (r103 + r105) * 31;
        if (this.f352600f == true) goto L15;
        r104 = 1237;
    L15:
        return r106 + r104;
    L9:
        r105 = 1237;
        goto L10
    L5:
        r102 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "VoiceDoubleTabItemData(tabKey=" + this.f352595a + ", title=" + this.f352596b + ", badgeText=" + this.f352597c + ", iconToken=" + this.f352598d + ", isVisible=" + this.f352599e + ", isEnabled=" + this.f352600f + ')';
    }

    public w3(String r100, String r101, int r102) {
        String r103 = "";
        if ((r102 & 1) == 0) goto L6;
        r100 = "";
    L6:
        if ((r102 & 2) == 0) goto L9;
        r101 = "";
    L9:
        if ((r102 & 4) != 0) goto L12;
        r103 = null;
    L12:
        boolean r104 = false;
        if ((r102 & 16) == 0) goto L15;
        boolean r105 = true;
    L17:
        if ((r102 & 32) == 0) goto L19;
        r104 = true;
    L19:
        Intrinsics.checkNotNullParameter(r100, "tabKey");
        Intrinsics.checkNotNullParameter(r101, "title");
        Intrinsics.checkNotNullParameter(r103, "badgeText");
        this.f352595a = r100;
        this.f352596b = r101;
        this.f352597c = r103;
        this.f352598d = null;
        this.f352599e = r105;
        this.f352600f = r104;
        return;
    L15:
        r105 = false;
        goto L17
    }
}
