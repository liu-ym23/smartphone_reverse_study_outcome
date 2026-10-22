package com.larus.bot.impl.feature.edit.feature.bgimage.preview;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f319070a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final z f319071b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final z f319072c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f319073d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f319074e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f319075f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f319076g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f319077h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f319078i;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof y) == true) goto L8;
        return false;
    L8:
        y r101 = (y) r100;
        if (this.f319070a == r101.f319070a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f319071b, r101.f319071b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f319072c, r101.f319072c) == true) goto L18;
        return false;
    L18:
        if (this.f319073d == r101.f319073d) goto L21;
        return false;
    L21:
        if (this.f319074e == r101.f319074e) goto L24;
        return false;
    L24:
        if (this.f319075f == r101.f319075f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f319076g, r101.f319076g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f319077h, r101.f319077h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f319078i, r101.f319078i) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f319070a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = ((((((r101 * 31) + this.f319071b.hashCode()) * 31) + this.f319072c.hashCode()) * 31) + this.f319073d) * 31;
        if (this.f319074e == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.f319075f == true) goto L14;
        r100 = 1237;
    L14:
        int r105 = (r104 + r100) * 31;
        String r106 = this.f319076g;
        int r107 = 0;
        if (r106 != null) goto L17;
        int r108 = 0;
    L18:
        int r109 = (r105 + r108) * 31;
        String r110 = this.f319077h;
        if (r110 != null) goto L21;
        int r111 = 0;
    L22:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f319078i;
        if (r113 == null) goto L27;
        r107 = r113.hashCode();
    L27:
        return r112 + r107;
    L21:
        r111 = r110.hashCode();
        goto L22
    L17:
        r108 = r106.hashCode();
        goto L18
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "PreviewUIState(disable=" + this.f319070a + ", avatarUri=" + this.f319071b + ", bgUri=" + this.f319072c + ", bgColor=" + this.f319073d + ", bgOpen=" + this.f319074e + ", isInAiGenProcess=" + this.f319075f + ", initialBgUrl=" + this.f319076g + ", originalAvatarImgUri=" + this.f319077h + ", originalBackgroundImgUri=" + this.f319078i + ')';
    }

    public y(boolean r100, z r101, z r102, int r103, boolean r104, boolean r105, String r106, String r107, String r110) {
        Intrinsics.checkNotNullParameter(r101, "avatarUri");
        Intrinsics.checkNotNullParameter(r102, "bgUri");
        this.f319070a = r100;
        this.f319071b = r101;
        this.f319072c = r102;
        this.f319073d = r103;
        this.f319074e = r104;
        this.f319075f = r105;
        this.f319076g = r106;
        this.f319077h = r107;
        this.f319078i = r110;
    }
}
