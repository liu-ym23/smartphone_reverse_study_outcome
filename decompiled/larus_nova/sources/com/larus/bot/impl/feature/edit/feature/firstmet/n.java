package com.larus.bot.impl.feature.edit.feature.firstmet;

import kotlin.Triple;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f319191a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f319192b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f319193c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f319194d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f319195e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Triple<String, String, String> f319196f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f319197g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f319198h;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof n) == true) goto L8;
        return false;
    L8:
        n r101 = (n) r100;
        if (this.f319191a == r101.f319191a) goto L12;
        return false;
    L12:
        if (this.f319192b == r101.f319192b) goto L15;
        return false;
    L15:
        if (this.f319193c == r101.f319193c) goto L18;
        return false;
    L18:
        if (this.f319194d == r101.f319194d) goto L21;
        return false;
    L21:
        if (this.f319195e == r101.f319195e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f319196f, r101.f319196f) == true) goto L27;
        return false;
    L27:
        if (this.f319197g == r101.f319197g) goto L30;
        return false;
    L30:
        if (this.f319198h == r101.f319198h) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f319191a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.f319192b == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (((r102 + r103) * 31) + this.f319193c) * 31;
        if (this.f319194d == false) goto L13;
        int r105 = 1231;
    L14:
        int r106 = (r104 + r105) * 31;
        if (this.f319195e == false) goto L17;
        int r107 = 1231;
    L18:
        int r108 = (((r106 + r107) * 31) + this.f319196f.hashCode()) * 31;
        if (this.f319197g == false) goto L21;
        int r109 = 1231;
    L22:
        int r110 = (r108 + r109) * 31;
        if (this.f319198h == true) goto L27;
        r100 = 1237;
    L27:
        return r110 + r100;
    L21:
        r109 = 1237;
        goto L22
    L17:
        r107 = 1237;
        goto L18
    L13:
        r105 = 1237;
        goto L14
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "FirstMetEditUIState(visible=" + this.f319191a + ", ttsEnable=" + this.f319192b + ", ttsUIState=" + this.f319193c + ", suggestsVisible=" + this.f319194d + ", suggestSwitch=" + this.f319195e + ", suggests=" + this.f319196f + ", isPrologueGenerating=" + this.f319197g + ", isSuggestsGenerating=" + this.f319198h + ')';
    }

    public n(boolean r100, boolean r101, int r102, boolean r103, boolean r104, Triple<String, String, String> r105, boolean r106, boolean r107) {
        Intrinsics.checkNotNullParameter(r105, "suggests");
        this.f319191a = r100;
        this.f319192b = r101;
        this.f319193c = r102;
        this.f319194d = r103;
        this.f319195e = r104;
        this.f319196f = r105;
        this.f319197g = r106;
        this.f319198h = r107;
    }
}
