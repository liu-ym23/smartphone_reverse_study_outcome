package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation;

import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f435116a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<c> f435117b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<c> f435118c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, List<String>> f435119d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, List<String>> f435120e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final c f435121f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final c f435122g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final c f435123h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final c f435124i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f435125j;

    public b() {
        this(0);
    }

    public static b a(boolean r110, List r111, List r112, Map r113, Map r114, c r115, c r116, c r117, c r210, String r211) {
        Intrinsics.checkNotNullParameter(r111, "supportSpokenLanguages");
        Intrinsics.checkNotNullParameter(r112, "supportTargetLanguages");
        Intrinsics.checkNotNullParameter(r113, "spokenToTargetLanguageTypes");
        Intrinsics.checkNotNullParameter(r114, "targetToSpokenLanguageTypes");
        return new b(r110, r111, r112, r113, r114, r115, r116, r117, r210, r211);
    }

    public static /* synthetic */ b b(b r110, c r111, String r112, int r113) {
        if ((r113 & 1) == 0) goto L5;
        boolean r100 = r110.f435116a;
    L7:
        if ((r113 & 2) == 0) goto L9;
        List<c> r101 = r110.f435117b;
    L11:
        if ((r113 & 4) == 0) goto L13;
        List<c> r102 = r110.f435118c;
    L15:
        if ((r113 & 8) == 0) goto L17;
        Map<String, List<String>> r103 = r110.f435119d;
    L19:
        if ((r113 & 16) == 0) goto L21;
        Map<String, List<String>> r104 = r110.f435120e;
    L23:
        if ((r113 & 32) == 0) goto L25;
        c r105 = r110.f435121f;
    L27:
        if ((r113 & 64) == 0) goto L29;
        r111 = r110.f435122g;
    L29:
        c r106 = r111;
        if ((r113 & 128) == 0) goto L32;
        c r107 = r110.f435123h;
    L34:
        if ((r113 & 256) == 0) goto L36;
        c r108 = r110.f435124i;
    L38:
        if ((r113 & 512) == 0) goto L40;
        r112 = r110.f435125j;
    L40:
        r110.getClass();
        return a(r100, r101, r102, r103, r104, r105, r106, r107, r108, r112);
    L36:
        r108 = null;
        goto L38
    L32:
        r107 = null;
        goto L34
    L25:
        r105 = null;
        goto L27
    L21:
        r104 = null;
        goto L23
    L17:
        r103 = null;
        goto L19
    L13:
        r102 = null;
        goto L15
    L9:
        r101 = null;
        goto L11
    L5:
        r100 = false;
        goto L7
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (this.f435116a == r101.f435116a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f435117b, r101.f435117b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f435118c, r101.f435118c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f435119d, r101.f435119d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f435120e, r101.f435120e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f435121f, r101.f435121f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f435122g, r101.f435122g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f435123h, r101.f435123h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f435124i, r101.f435124i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f435125j, r101.f435125j) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        if (this.f435116a == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = ((((((((r100 * 31) + this.f435117b.hashCode()) * 31) + this.f435118c.hashCode()) * 31) + this.f435119d.hashCode()) * 31) + this.f435120e.hashCode()) * 31;
        c r102 = this.f435121f;
        int r103 = 0;
        if (r102 != null) goto L9;
        int r104 = 0;
    L10:
        int r105 = (r101 + r104) * 31;
        c r106 = this.f435122g;
        if (r106 != null) goto L13;
        int r107 = 0;
    L14:
        int r108 = (r105 + r107) * 31;
        c r109 = this.f435123h;
        if (r109 != null) goto L17;
        int r110 = 0;
    L18:
        int r111 = (r108 + r110) * 31;
        c r112 = this.f435124i;
        if (r112 != null) goto L21;
        int r113 = 0;
    L22:
        int r114 = (r111 + r113) * 31;
        String r115 = this.f435125j;
        if (r115 == null) goto L27;
        r103 = r115.hashCode();
    L27:
        return r114 + r103;
    L21:
        r113 = r112.hashCode();
        goto L22
    L17:
        r110 = r109.hashCode();
        goto L18
    L13:
        r107 = r106.hashCode();
        goto L14
    L9:
        r104 = r102.hashCode();
        goto L10
    L5:
        r100 = 1237;
        goto L6
    }

    public final String toString() {
        return "MmStandaloneAIInterpretationEntity(enabled=" + this.f435116a + ", supportSpokenLanguages=" + this.f435117b + ", supportTargetLanguages=" + this.f435118c + ", spokenToTargetLanguageTypes=" + this.f435119d + ", targetToSpokenLanguageTypes=" + this.f435120e + ", selectedSpokenLanguage=" + this.f435121f + ", selectedLanguage=" + this.f435122g + ", highlightLanguage=" + this.f435123h + ", activeLanguage=" + this.f435124i + ", errorMessage=" + this.f435125j + ')';
    }

    public /* synthetic */ b(int r110) {
        this(false, CollectionsKt.emptyList(), CollectionsKt.emptyList(), MapsKt.emptyMap(), MapsKt.emptyMap(), null, null, null, null, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(boolean r100, List<c> r101, List<c> r102, Map<String, ? extends List<String>> r103, Map<String, ? extends List<String>> r104, c r105, c r106, c r107, c r110, String r111) {
        Intrinsics.checkNotNullParameter(r101, "supportSpokenLanguages");
        Intrinsics.checkNotNullParameter(r102, "supportTargetLanguages");
        Intrinsics.checkNotNullParameter(r103, "spokenToTargetLanguageTypes");
        Intrinsics.checkNotNullParameter(r104, "targetToSpokenLanguageTypes");
        this.f435116a = r100;
        this.f435117b = r101;
        this.f435118c = r102;
        this.f435119d = r103;
        this.f435120e = r104;
        this.f435121f = r105;
        this.f435122g = r106;
        this.f435123h = r107;
        this.f435124i = r110;
        this.f435125j = r111;
    }
}
