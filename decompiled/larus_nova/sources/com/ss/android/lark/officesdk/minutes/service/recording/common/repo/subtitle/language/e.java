package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MmAutoTranslationStatus f435289a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f435290b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final MmAutoTranslationStage f435291c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f435292d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f435293e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f435294f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (this.f435289a == r101.f435289a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f435290b, r101.f435290b) == true) goto L15;
        return false;
    L15:
        if (this.f435291c == r101.f435291c) goto L18;
        return false;
    L18:
        if (this.f435292d == r101.f435292d) goto L21;
        return false;
    L21:
        if (this.f435293e == r101.f435293e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f435294f, r101.f435294f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f435289a.hashCode() * 31) + this.f435290b.hashCode()) * 31) + this.f435291c.hashCode()) * 31;
        long r101 = this.f435292d;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        long r103 = this.f435293e;
        return ((r102 + ((int) (r103 ^ (r103 >>> 32)))) * 31) + this.f435294f.hashCode();
    }

    public final String toString() {
        return "MmAutoTranslationState(status=" + this.f435289a + ", targetLanguage=" + this.f435290b + ", stage=" + this.f435291c + ", operationId=" + this.f435292d + ", manualRevision=" + this.f435293e + ", reason=" + this.f435294f + ')';
    }

    public e(MmAutoTranslationStatus r100, String r101, MmAutoTranslationStage r102, long r103, long r104, String r105) {
        Intrinsics.checkNotNullParameter(r100, "status");
        Intrinsics.checkNotNullParameter(r101, "targetLanguage");
        Intrinsics.checkNotNullParameter(r102, "stage");
        Intrinsics.checkNotNullParameter(r105, "reason");
        this.f435289a = r100;
        this.f435290b = r101;
        this.f435291c = r102;
        this.f435292d = r103;
        this.f435293e = r104;
        this.f435294f = r105;
    }

    public static e a(e r100, MmAutoTranslationStatus r110, String r111, MmAutoTranslationStage r112, long r113, long r114, String r115, int r116) {
        if ((r116 & 1) == 0) goto L5;
        MmAutoTranslationStatus r101 = r100.f435289a;
    L7:
        if ((r116 & 2) == 0) goto L9;
        String r102 = r100.f435290b;
    L11:
        if ((r116 & 4) == 0) goto L13;
        MmAutoTranslationStage r103 = r100.f435291c;
    L15:
        if ((r116 & 8) == 0) goto L17;
        long r104 = r100.f435292d;
    L19:
        if ((r116 & 16) == 0) goto L21;
        long r105 = r100.f435293e;
    L23:
        if ((r116 & 32) == 0) goto L25;
        String r106 = r100.f435294f;
    L26:
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "status");
        Intrinsics.checkNotNullParameter(r102, "targetLanguage");
        Intrinsics.checkNotNullParameter(r103, "stage");
        Intrinsics.checkNotNullParameter(r106, "reason");
        return new e(r101, r102, r103, r104, r105, r106);
    L25:
        r106 = r115;
        goto L26
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
