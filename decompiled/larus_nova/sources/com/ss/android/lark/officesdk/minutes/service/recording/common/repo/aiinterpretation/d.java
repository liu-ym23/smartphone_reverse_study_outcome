package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f434757a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<g> f434758b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final g f434759c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final g f434760d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f434761e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f434762f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f434763g;

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
        if (this.f434757a == r101.f434757a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f434758b, r101.f434758b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f434759c, r101.f434759c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f434760d, r101.f434760d) == true) goto L21;
        return false;
    L21:
        if (this.f434761e == r101.f434761e) goto L24;
        return false;
    L24:
        if (this.f434762f == r101.f434762f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f434763g, r101.f434763g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f434757a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = ((r101 * 31) + this.f434758b.hashCode()) * 31;
        g r103 = this.f434759c;
        int r104 = 0;
        if (r103 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r102 + r105) * 31;
        g r107 = this.f434760d;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        if (this.f434761e == false) goto L17;
        int r110 = 1231;
    L18:
        int r111 = (r109 + r110) * 31;
        if (this.f434762f == true) goto L22;
        r100 = 1237;
    L22:
        int r112 = (r111 + r100) * 31;
        String r113 = this.f434763g;
        if (r113 == null) goto L27;
        r104 = r113.hashCode();
    L27:
        return r112 + r104;
    L17:
        r110 = 1237;
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r103.hashCode();
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "MmAIInterpretationEntity(enabled=" + this.f434757a + ", supportLanguages=" + this.f434758b + ", selectedLanguage=" + this.f434759c + ", activeLanguage=" + this.f434760d + ", loading=" + this.f434761e + ", showEntry=" + this.f434762f + ", errorMessage=" + this.f434763g + ')';
    }

    public /* synthetic */ d(int r100) {
        this(false, CollectionsKt.emptyList(), null, null, false, false, null);
    }

    public d(boolean r100, List<g> r101, g r102, g r103, boolean r104, boolean r105, String r106) {
        Intrinsics.checkNotNullParameter(r101, "supportLanguages");
        this.f434757a = r100;
        this.f434758b = r101;
        this.f434759c = r102;
        this.f434760d = r103;
        this.f434761e = r104;
        this.f434762f = r105;
        this.f434763g = r106;
    }

    public static d a(d r100, boolean r101, List r110, g r111, g r112, boolean r113, boolean r114, String r115, int r116) {
        if ((r116 & 1) == 0) goto L5;
        boolean r102 = r100.f434757a;
    L7:
        if ((r116 & 2) == 0) goto L9;
        List r103 = r100.f434758b;
    L11:
        if ((r116 & 4) == 0) goto L13;
        g r104 = r100.f434759c;
    L15:
        if ((r116 & 8) == 0) goto L17;
        g r105 = r100.f434760d;
    L19:
        if ((r116 & 16) == 0) goto L21;
        boolean r106 = r100.f434761e;
    L23:
        if ((r116 & 32) == 0) goto L25;
        boolean r107 = r100.f434762f;
    L27:
        if ((r116 & 64) == 0) goto L29;
        String r108 = r100.f434763g;
    L30:
        r100.getClass();
        Intrinsics.checkNotNullParameter(r103, "supportLanguages");
        return new d(r102, r103, r104, r105, r106, r107, r108);
    L29:
        r108 = r115;
        goto L30
    L25:
        r107 = r114;
        goto L27
    L21:
        r106 = r113;
        goto L23
    L17:
        r105 = r112;
        goto L19
    L13:
        r104 = r111;
        goto L15
    L9:
        r103 = r110;
        goto L11
    L5:
        r102 = r101;
        goto L7
    }
}
