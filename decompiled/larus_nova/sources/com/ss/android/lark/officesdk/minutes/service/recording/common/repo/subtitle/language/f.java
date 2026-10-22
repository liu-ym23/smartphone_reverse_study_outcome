package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<h> f435295a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<h> f435296b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final h f435297c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final h f435298d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f435299e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f435300f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f435301g;

    public f() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.f435295a, r101.f435295a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f435296b, r101.f435296b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f435297c, r101.f435297c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f435298d, r101.f435298d) == true) goto L21;
        return false;
    L21:
        if (this.f435299e == r101.f435299e) goto L24;
        return false;
    L24:
        if (this.f435300f == r101.f435300f) goto L27;
        return false;
    L27:
        if (this.f435301g == r101.f435301g) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((this.f435295a.hashCode() * 31) + this.f435296b.hashCode()) * 31) + this.f435297c.hashCode()) * 31) + this.f435298d.hashCode()) * 31;
        int r101 = 1231;
        if (this.f435299e == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f435300f == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (r103 + r104) * 31;
        if (this.f435301g == true) goto L15;
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
        return "MmRecordingLanguageEntity(spokenLanguageList=" + this.f435295a + ", translateLanguageList=" + this.f435296b + ", currSpokenLanguage=" + this.f435297c + ", currTranslateLanguage=" + this.f435298d + ", isBilingual=" + this.f435299e + ", isLanguageSettingsReady=" + this.f435300f + ", isTranslateLanguageListReady=" + this.f435301g + ')';
    }

    public /* synthetic */ f(int r100) {
        this(CollectionsKt.emptyList(), CollectionsKt.emptyList(), new h(0), new h(0), false, false, false);
    }

    public f(List<h> r100, List<h> r101, h r102, h r103, boolean r104, boolean r105, boolean r106) {
        Intrinsics.checkNotNullParameter(r100, "spokenLanguageList");
        Intrinsics.checkNotNullParameter(r101, "translateLanguageList");
        Intrinsics.checkNotNullParameter(r102, "currSpokenLanguage");
        Intrinsics.checkNotNullParameter(r103, "currTranslateLanguage");
        this.f435295a = r100;
        this.f435296b = r101;
        this.f435297c = r102;
        this.f435298d = r103;
        this.f435299e = r104;
        this.f435300f = r105;
        this.f435301g = r106;
    }

    public static f a(f r100, List r101, List r110, h r111, h r112, boolean r113, boolean r114, boolean r115, int r116) {
        if ((r116 & 1) == 0) goto L5;
        List r102 = r100.f435295a;
    L7:
        if ((r116 & 2) == 0) goto L9;
        List r103 = r100.f435296b;
    L11:
        if ((r116 & 4) == 0) goto L13;
        h r104 = r100.f435297c;
    L15:
        if ((r116 & 8) == 0) goto L17;
        h r105 = r100.f435298d;
    L19:
        if ((r116 & 16) == 0) goto L21;
        boolean r106 = r100.f435299e;
    L23:
        if ((r116 & 32) == 0) goto L25;
        boolean r107 = r100.f435300f;
    L27:
        if ((r116 & 64) == 0) goto L29;
        boolean r108 = r100.f435301g;
    L30:
        r100.getClass();
        Intrinsics.checkNotNullParameter(r102, "spokenLanguageList");
        Intrinsics.checkNotNullParameter(r103, "translateLanguageList");
        Intrinsics.checkNotNullParameter(r104, "currSpokenLanguage");
        Intrinsics.checkNotNullParameter(r105, "currTranslateLanguage");
        return new f(r102, r103, r104, r105, r106, r107, r108);
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
