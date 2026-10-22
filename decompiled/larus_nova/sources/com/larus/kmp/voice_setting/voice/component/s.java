package com.larus.kmp.voice_setting.voice.component;

import com.hihonor.honorid.core.data.UserInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class s implements m1a.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f352514a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f352515b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f352516c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f352517d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f352518e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f352519f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f352520g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f352521h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f352522i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f352523j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f352524k;

    public s() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof s) == true) goto L8;
        return false;
    L8:
        s r101 = (s) r100;
        if (Intrinsics.areEqual(this.f352514a, r101.f352514a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f352515b, r101.f352515b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f352516c, r101.f352516c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f352517d, r101.f352517d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f352518e, r101.f352518e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f352519f, r101.f352519f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f352520g, r101.f352520g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f352521h, r101.f352521h) == true) goto L33;
        return false;
    L33:
        if (this.f352522i == r101.f352522i) goto L36;
        return false;
    L36:
        if (this.f352523j == r101.f352523j) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f352524k, r101.f352524k) == true) goto L41;
        return false;
    L41:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((((this.f352514a.hashCode() * 31) + this.f352515b.hashCode()) * 31) + this.f352516c.hashCode()) * 31) + this.f352517d.hashCode()) * 31) + this.f352518e.hashCode()) * 31;
        String r101 = this.f352519f;
        if (r101 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = (((((r100 + r102) * 31) + this.f352520g.hashCode()) * 31) + this.f352521h.hashCode()) * 31;
        int r104 = 1231;
        if (this.f352522i == false) goto L9;
        int r105 = 1231;
    L10:
        int r106 = (r103 + r105) * 31;
        if (this.f352523j == true) goto L15;
        r104 = 1237;
    L15:
        return ((r106 + r104) * 31) + this.f352524k.hashCode();
    L9:
        r105 = 1237;
        goto L10
    L5:
        r102 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "VoiceCreateFlowMeta(enterFrom=" + this.f352514a + ", enterMethod=" + this.f352515b + ", clickFrom=" + this.f352516c + ", trackParams=" + this.f352517d + ", logTraceId=" + this.f352518e + ", botId=" + this.f352519f + ", languageCode=" + this.f352520g + ", previousPage=" + this.f352521h + ", isFromVoiceCloneScheme=" + this.f352522i + ", disableAnimation=" + this.f352523j + ", source=" + this.f352524k + ')';
    }

    public /* synthetic */ s(int r110) {
        this("", "", "", "", "", null, "zh", "", false, false, "");
    }

    public s(String r100, String r101, String r102, String r103, String r104, String r105, String r106, String r107, boolean r110, boolean r111, String r112) {
        Intrinsics.checkNotNullParameter(r100, "enterFrom");
        Intrinsics.checkNotNullParameter(r101, "enterMethod");
        Intrinsics.checkNotNullParameter(r102, "clickFrom");
        Intrinsics.checkNotNullParameter(r103, "trackParams");
        Intrinsics.checkNotNullParameter(r104, "logTraceId");
        Intrinsics.checkNotNullParameter(r106, UserInfo.LANGUAGECODE);
        Intrinsics.checkNotNullParameter(r107, "previousPage");
        Intrinsics.checkNotNullParameter(r112, "source");
        this.f352514a = r100;
        this.f352515b = r101;
        this.f352516c = r102;
        this.f352517d = r103;
        this.f352518e = r104;
        this.f352519f = r105;
        this.f352520g = r106;
        this.f352521h = r107;
        this.f352522i = r110;
        this.f352523j = r111;
        this.f352524k = r112;
    }
}
