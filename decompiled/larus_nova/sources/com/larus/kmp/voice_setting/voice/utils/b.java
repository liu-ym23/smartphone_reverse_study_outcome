package com.larus.kmp.voice_setting.voice.utils;

import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f355091a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f355092b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f355093c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Set<String> f355094d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Set<String> f355095e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f355096f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f355097g;

    public b() {
        this(false, false, false, SetsKt.emptySet(), SetsKt.emptySet(), "", "");
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (this.f355091a == r101.f355091a) goto L12;
        return false;
    L12:
        if (this.f355092b == r101.f355092b) goto L15;
        return false;
    L15:
        if (this.f355093c == r101.f355093c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f355094d, r101.f355094d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f355095e, r101.f355095e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f355096f, r101.f355096f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f355097g, r101.f355097g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f355091a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.f355092b == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.f355093c == true) goto L15;
        r100 = 1237;
    L15:
        return ((((((((r104 + r100) * 31) + this.f355094d.hashCode()) * 31) + this.f355095e.hashCode()) * 31) + this.f355096f.hashCode()) * 31) + this.f355097g.hashCode();
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "CreateUgcVoicePlatformInfo(audioFeatureEnabled=" + this.f355091a + ", launchInfoVoiceFeatureEnabled=" + this.f355092b + ", hasUgcVoiceRecord=" + this.f355093c + ", allowedLanguages=" + this.f355094d + ", enableTtsLanguageCodes=" + this.f355095e + ", systemLanguage=" + this.f355096f + ", appLanguage=" + this.f355097g + ')';
    }

    public b(boolean r100, boolean r101, boolean r102, Set<String> r103, Set<String> r104, String r105, String r106) {
        Intrinsics.checkNotNullParameter(r103, "allowedLanguages");
        Intrinsics.checkNotNullParameter(r104, "enableTtsLanguageCodes");
        Intrinsics.checkNotNullParameter(r105, "systemLanguage");
        Intrinsics.checkNotNullParameter(r106, "appLanguage");
        this.f355091a = r100;
        this.f355092b = r101;
        this.f355093c = r102;
        this.f355094d = r103;
        this.f355095e = r104;
        this.f355096f = r105;
        this.f355097g = r106;
    }
}
