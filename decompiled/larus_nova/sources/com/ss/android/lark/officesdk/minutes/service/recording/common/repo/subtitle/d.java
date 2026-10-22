package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<h> f435209a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f435210b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f435211c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Boolean f435212d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f435213e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f435214f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f435215g;

    public d() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f435209a, r101.f435209a) == true) goto L12;
        return false;
    L12:
        if (this.f435210b == r101.f435210b) goto L15;
        return false;
    L15:
        if (this.f435211c == r101.f435211c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f435212d, r101.f435212d) == true) goto L21;
        return false;
    L21:
        if (this.f435213e == r101.f435213e) goto L24;
        return false;
    L24:
        if (this.f435214f == r101.f435214f) goto L27;
        return false;
    L27:
        if (this.f435215g == r101.f435215g) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f435209a.hashCode() * 31;
        long r101 = this.f435210b;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        int r103 = 1231;
        if (this.f435211c == false) goto L5;
        int r104 = 1231;
    L6:
        int r105 = (r102 + r104) * 31;
        Boolean r106 = this.f435212d;
        if (r106 != null) goto L9;
        int r107 = 0;
    L10:
        int r108 = (r105 + r107) * 31;
        if (this.f435213e == false) goto L13;
        int r109 = 1231;
    L14:
        int r110 = (r108 + r109) * 31;
        if (this.f435214f == false) goto L17;
        int r111 = 1231;
    L18:
        int r112 = (r110 + r111) * 31;
        if (this.f435215g == true) goto L23;
        r103 = 1237;
    L23:
        return r112 + r103;
    L17:
        r111 = 1237;
        goto L18
    L13:
        r109 = 1237;
        goto L14
    L9:
        r107 = r106.hashCode();
        goto L10
    L5:
        r104 = 1237;
        goto L6
    }

    public final String toString() {
        return "MmRecordingSubtitleEntity(subtitles=" + this.f435209a + ", nextSeqId=" + this.f435210b + ", hasMore=" + this.f435211c + ", isSubtitleOn=" + this.f435212d + ", showBilingual=" + this.f435213e + ", subtitleOpenFailed=" + this.f435214f + ", isSubtitleDegraded=" + this.f435215g + ')';
    }

    public /* synthetic */ d(int r110) {
        this(CollectionsKt.emptyList(), 0, false, null, false, false, false);
    }

    public d(List<h> r100, long r101, boolean r102, Boolean r103, boolean r104, boolean r105, boolean r106) {
        Intrinsics.checkNotNullParameter(r100, "subtitles");
        this.f435209a = r100;
        this.f435210b = r101;
        this.f435211c = r102;
        this.f435212d = r103;
        this.f435213e = r104;
        this.f435214f = r105;
        this.f435215g = r106;
    }

    public static d a(d r100, List r110, long r111, boolean r112, Boolean r113, boolean r114, boolean r115, boolean r116, int r117) {
        if ((r117 & 1) == 0) goto L5;
        List r101 = r100.f435209a;
    L7:
        if ((r117 & 2) == 0) goto L9;
        long r102 = r100.f435210b;
    L11:
        if ((r117 & 4) == 0) goto L13;
        boolean r103 = r100.f435211c;
    L15:
        if ((r117 & 8) == 0) goto L17;
        Boolean r104 = r100.f435212d;
    L19:
        if ((r117 & 16) == 0) goto L21;
        boolean r105 = r100.f435213e;
    L23:
        if ((r117 & 32) == 0) goto L25;
        boolean r106 = r100.f435214f;
    L27:
        if ((r117 & 64) == 0) goto L29;
        boolean r107 = r100.f435215g;
    L30:
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "subtitles");
        return new d(r101, r102, r103, r104, r105, r106, r107);
    L29:
        r107 = r116;
        goto L30
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }
}
