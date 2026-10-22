package com.larus.kmp.voice_setting.voice.component;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class x3 implements m1a.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<w3> f352609a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f352610b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f352611c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f352612d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f352613e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f352614f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f352615g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final p1 f352616h;

    public x3() {
        this(null, null, 255);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof x3) == true) goto L8;
        return false;
    L8:
        x3 r101 = (x3) r100;
        if (Intrinsics.areEqual(this.f352609a, r101.f352609a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f352610b, r101.f352610b) == true) goto L15;
        return false;
    L15:
        if (this.f352611c == r101.f352611c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f352612d, r101.f352612d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f352613e, r101.f352613e) == true) goto L24;
        return false;
    L24:
        if (this.f352614f == r101.f352614f) goto L27;
        return false;
    L27:
        if (this.f352615g == r101.f352615g) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f352616h, r101.f352616h) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f352609a.hashCode() * 31;
        String r101 = this.f352610b;
        if (r101 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = (r100 + r102) * 31;
        int r104 = 1231;
        if (this.f352611c == false) goto L9;
        int r105 = 1231;
    L10:
        int r106 = (((((r103 + r105) * 31) + this.f352612d.hashCode()) * 31) + this.f352613e.hashCode()) * 31;
        if (this.f352614f == false) goto L13;
        int r107 = 1231;
    L14:
        int r108 = (r106 + r107) * 31;
        if (this.f352615g == true) goto L19;
        r104 = 1237;
    L19:
        return ((r108 + r104) * 31) + this.f352616h.hashCode();
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
        return "VoiceDoubleTabShellStateData(tabs=" + this.f352609a + ", selectedTabKey=" + this.f352610b + ", isTopSelectedVoiceShellVisible=" + this.f352611c + ", selectedVoiceTitle=" + this.f352612d + ", selectedVoiceSubtitle=" + this.f352613e + ", isMuteVisible=" + this.f352614f + ", isMuted=" + this.f352615g + ", resources=" + this.f352616h + ')';
    }

    public final p1 getResources() {
        return this.f352616h;
    }

    public x3(List r100, String r101, int r102) {
        if ((r102 & 1) == 0) goto L5;
        r100 = CollectionsKt.emptyList();
    L5:
        p1 r103 = null;
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        String r104 = "";
        if ((r102 & 8) == 0) goto L11;
        String r105 = "";
    L13:
        if ((r102 & 16) != 0) goto L17;
        r104 = null;
    L17:
        if ((r102 & 128) == 0) goto L19;
        r103 = new p1(0);
    L19:
        Intrinsics.checkNotNullParameter(r100, "tabs");
        Intrinsics.checkNotNullParameter(r105, "selectedVoiceTitle");
        Intrinsics.checkNotNullParameter(r104, "selectedVoiceSubtitle");
        Intrinsics.checkNotNullParameter(r103, "resources");
        this.f352609a = r100;
        this.f352610b = r101;
        this.f352611c = false;
        this.f352612d = r105;
        this.f352613e = r104;
        this.f352614f = false;
        this.f352615g = false;
        this.f352616h = r103;
        return;
    L11:
        r105 = null;
        goto L13
    }
}
