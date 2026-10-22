package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation;

import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f435145a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f435146b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<c> f435147c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<c> f435148d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, List<String>> f435149e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<String, List<String>> f435150f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final c f435151g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final c f435152h;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L8;
        return false;
    L8:
        g r101 = (g) r100;
        if (Intrinsics.areEqual(this.f435145a, r101.f435145a) == true) goto L12;
        return false;
    L12:
        if (this.f435146b == r101.f435146b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f435147c, r101.f435147c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f435148d, r101.f435148d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f435149e, r101.f435149e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f435150f, r101.f435150f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f435151g, r101.f435151g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f435152h, r101.f435152h) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((((((this.f435145a.hashCode() * 31) + this.f435146b) * 31) + this.f435147c.hashCode()) * 31) + this.f435148d.hashCode()) * 31) + this.f435149e.hashCode()) * 31) + this.f435150f.hashCode()) * 31;
        c r101 = this.f435151g;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        c r105 = this.f435152h;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return r104 + r102;
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "MmStandaloneAIInterpretationUpdateResult(channel=" + this.f435145a + ", status=" + this.f435146b + ", supportSpokenLanguages=" + this.f435147c + ", supportTargetLanguages=" + this.f435148d + ", spokenToTargetLanguageTypes=" + this.f435149e + ", targetToSpokenLanguageTypes=" + this.f435150f + ", selectedSpokenLanguage=" + this.f435151g + ", highlightLanguage=" + this.f435152h + ')';
    }

    public final boolean a() {
        int r100 = this.f435146b;
        if (r100 != 1) goto L5;
        return true;
    L5:
        if (r100 == 2) goto L10;
        return false;
    L10:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public g(String r100, int r101, List<c> r102, List<c> r103, Map<String, ? extends List<String>> r104, Map<String, ? extends List<String>> r105, c r106, c r107) {
        Intrinsics.checkNotNullParameter(r100, "channel");
        Intrinsics.checkNotNullParameter(r102, "supportSpokenLanguages");
        Intrinsics.checkNotNullParameter(r103, "supportTargetLanguages");
        Intrinsics.checkNotNullParameter(r104, "spokenToTargetLanguageTypes");
        Intrinsics.checkNotNullParameter(r105, "targetToSpokenLanguageTypes");
        this.f435145a = r100;
        this.f435146b = r101;
        this.f435147c = r102;
        this.f435148d = r103;
        this.f435149e = r104;
        this.f435150f = r105;
        this.f435151g = r106;
        this.f435152h = r107;
    }
}
