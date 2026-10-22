package com.obric.assistant.settings.memory;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f392220a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f392221b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f392222c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f392223d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f392224e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ObricReferenceMemorySwitchGroup f392225f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof y) == true) goto L8;
        return false;
    L8:
        y r101 = (y) r100;
        if (Intrinsics.areEqual(this.f392220a, r101.f392220a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f392221b, r101.f392221b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f392222c, r101.f392222c) == true) goto L18;
        return false;
    L18:
        if (this.f392223d == r101.f392223d) goto L21;
        return false;
    L21:
        if (this.f392224e == r101.f392224e) goto L24;
        return false;
    L24:
        if (this.f392225f == r101.f392225f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f392220a.hashCode() * 31) + this.f392221b.hashCode()) * 31) + this.f392222c.hashCode()) * 31;
        int r101 = 1231;
        if (this.f392223d == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f392224e == true) goto L11;
        r101 = 1237;
    L11:
        return ((r103 + r101) * 31) + this.f392225f.hashCode();
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "ObricReferenceMemoryRow(id=" + this.f392220a + ", title=" + this.f392221b + ", subtitle=" + this.f392222c + ", checked=" + this.f392223d + ", enabled=" + this.f392224e + ", group=" + this.f392225f + ')';
    }

    public y(String r100, String r101, String r102, boolean r103, boolean r104, ObricReferenceMemorySwitchGroup r105) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r101, "title");
        Intrinsics.checkNotNullParameter(r102, "subtitle");
        Intrinsics.checkNotNullParameter(r105, "group");
        this.f392220a = r100;
        this.f392221b = r101;
        this.f392222c = r102;
        this.f392223d = r103;
        this.f392224e = r104;
        this.f392225f = r105;
    }
}
