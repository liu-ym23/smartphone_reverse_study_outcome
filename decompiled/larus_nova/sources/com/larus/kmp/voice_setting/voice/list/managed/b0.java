package com.larus.kmp.voice_setting.voice.list.managed;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<Integer> f353465a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f353466b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f353467c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f353468d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f353469e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f353470f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b0) == true) goto L8;
        return false;
    L8:
        b0 r101 = (b0) r100;
        if (Intrinsics.areEqual(this.f353465a, r101.f353465a) == true) goto L12;
        return false;
    L12:
        if (this.f353466b == r101.f353466b) goto L15;
        return false;
    L15:
        if (this.f353467c == r101.f353467c) goto L18;
        return false;
    L18:
        if (this.f353468d == r101.f353468d) goto L21;
        return false;
    L21:
        if (this.f353469e == r101.f353469e) goto L24;
        return false;
    L24:
        if (this.f353470f == r101.f353470f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f353465a.hashCode() * 31;
        int r101 = 1231;
        if (this.f353466b == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f353467c == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (((((r103 + r104) * 31) + this.f353468d) * 31) + this.f353469e) * 31;
        if (this.f353470f == true) goto L15;
        r101 = 1237;
    L15:
        return r105 + r101;
    L9:
        r104 = 1237;
        goto L10
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "ManagedVoiceListViewportSnapshot(fullyVisibleIndices=" + this.f353465a + ", canScroll=" + this.f353466b + ", isScrollInProgress=" + this.f353467c + ", firstVisibleItemIndex=" + this.f353468d + ", firstVisibleItemScrollOffset=" + this.f353469e + ", footerVisible=" + this.f353470f + ')';
    }

    public b0(List<Integer> r100, boolean r101, boolean r102, int r103, int r104, boolean r105) {
        Intrinsics.checkNotNullParameter(r100, "fullyVisibleIndices");
        this.f353465a = r100;
        this.f353466b = r101;
        this.f353467c = r102;
        this.f353468d = r103;
        this.f353469e = r104;
        this.f353470f = r105;
    }
}
