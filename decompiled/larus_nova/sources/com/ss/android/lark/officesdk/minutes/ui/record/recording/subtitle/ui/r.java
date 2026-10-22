package com.ss.android.lark.officesdk.minutes.ui.record.recording.subtitle.ui;

import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f436525a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set<Long> f436526b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f436527c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f436528d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f436529e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f436530f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f436531g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof r) == true) goto L8;
        return false;
    L8:
        r r101 = (r) r100;
        if (Intrinsics.areEqual(this.f436525a, r101.f436525a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f436526b, r101.f436526b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f436527c, r101.f436527c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f436528d, r101.f436528d) == true) goto L21;
        return false;
    L21:
        if (this.f436529e == r101.f436529e) goto L24;
        return false;
    L24:
        if (this.f436530f == r101.f436530f) goto L27;
        return false;
    L27:
        if (this.f436531g == r101.f436531g) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((this.f436525a.hashCode() * 31) + this.f436526b.hashCode()) * 31) + this.f436527c.hashCode()) * 31) + this.f436528d.hashCode()) * 31;
        long r101 = this.f436529e;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        long r103 = this.f436530f;
        int r104 = (r102 + ((int) (r103 ^ (r103 >>> 32)))) * 31;
        if (this.f436531g == false) goto L5;
        int r105 = 1231;
    L7:
        return r104 + r105;
    L5:
        r105 = 1237;
        goto L7
    }

    public final String toString() {
        return "MmSubtitleMarkGroup(markId=" + this.f436525a + ", segIds=" + this.f436526b + ", copyText=" + this.f436527c + ", contentMarkdown=" + this.f436528d + ", relativeAudioTimeMs=" + this.f436529e + ", audioLocationTimeMs=" + this.f436530f + ", allFinal=" + this.f436531g + ')';
    }

    public r(String r100, Set<Long> r101, String r102, String r103, long r104, long r105, boolean r110) {
        Intrinsics.checkNotNullParameter(r100, "markId");
        Intrinsics.checkNotNullParameter(r101, "segIds");
        Intrinsics.checkNotNullParameter(r102, "copyText");
        Intrinsics.checkNotNullParameter(r103, "contentMarkdown");
        this.f436525a = r100;
        this.f436526b = r101;
        this.f436527c = r102;
        this.f436528d = r103;
        this.f436529e = r104;
        this.f436530f = r105;
        this.f436531g = r110;
    }
}
