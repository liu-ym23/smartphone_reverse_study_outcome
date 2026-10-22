package com.larus.chat.gallery.impl.preview;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PreviewChromeKind f324291a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final r f324292b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c f324293c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.larus.chat.gallery.api.q f324294d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<com.larus.chat.gallery.api.o> f324295e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f324296f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f324297g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f324298h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final e f324299i;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (this.f324291a == r101.f324291a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f324292b, r101.f324292b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f324293c, r101.f324293c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f324294d, r101.f324294d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f324295e, r101.f324295e) == true) goto L24;
        return false;
    L24:
        if (this.f324296f == r101.f324296f) goto L27;
        return false;
    L27:
        if (this.f324297g == r101.f324297g) goto L30;
        return false;
    L30:
        if (this.f324298h == r101.f324298h) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f324299i, r101.f324299i) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f324291a.hashCode() * 31) + this.f324292b.hashCode()) * 31) + this.f324293c.hashCode()) * 31;
        com.larus.chat.gallery.api.q r101 = this.f324294d;
        if (r101 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = (((r100 + r102) * 31) + this.f324295e.hashCode()) * 31;
        int r104 = 1231;
        if (this.f324296f == false) goto L9;
        int r105 = 1231;
    L10:
        int r106 = (r103 + r105) * 31;
        if (this.f324297g == false) goto L13;
        int r107 = 1231;
    L14:
        int r108 = (r106 + r107) * 31;
        if (this.f324298h == true) goto L19;
        r104 = 1237;
    L19:
        return ((r108 + r104) * 31) + this.f324299i.hashCode();
    L13:
        r107 = 1237;
        goto L14
    L9:
        r105 = 1237;
        goto L10
    L5:
        r102 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "PreviewExperienceProfile(chromeKind=" + this.f324291a + ", sourcePolicy=" + this.f324292b + ", albumFlowPolicy=" + this.f324293c + ", mediaSession=" + this.f324294d + ", mediaItems=" + this.f324295e + ", showInput=" + this.f324296f + ", showTracker=" + this.f324297g + ", showLargeThumbnails=" + this.f324298h + ", displayProfile=" + this.f324299i + ')';
    }

    public f(PreviewChromeKind r100, r r101, c r102, com.larus.chat.gallery.api.q r103, List<com.larus.chat.gallery.api.o> r104, boolean r105, boolean r106, boolean r107, e r110) {
        Intrinsics.checkNotNullParameter(r100, "chromeKind");
        Intrinsics.checkNotNullParameter(r101, "sourcePolicy");
        Intrinsics.checkNotNullParameter(r102, "albumFlowPolicy");
        Intrinsics.checkNotNullParameter(r104, "mediaItems");
        Intrinsics.checkNotNullParameter(r110, "displayProfile");
        this.f324291a = r100;
        this.f324292b = r101;
        this.f324293c = r102;
        this.f324294d = r103;
        this.f324295e = r104;
        this.f324296f = r105;
        this.f324297g = r106;
        this.f324298h = r107;
        this.f324299i = r110;
    }
}
