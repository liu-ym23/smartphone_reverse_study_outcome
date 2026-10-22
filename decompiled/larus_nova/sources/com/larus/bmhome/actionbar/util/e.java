package com.larus.bmhome.actionbar.util;

import com.hihonor.honorid.core.data.UserInfo;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f295662a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f295663b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f295664c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f295665d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f295666e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f295667f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f295668g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Function2<String, Object, String> f295669h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Function2<String, String, String> f295670i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Function2<String, Long, String> f295671j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f295672k;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f295662a, r101.f295662a) == true) goto L12;
        return false;
    L12:
        if (this.f295663b == r101.f295663b) goto L15;
        return false;
    L15:
        if (this.f295664c == r101.f295664c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f295665d, r101.f295665d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f295666e, r101.f295666e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f295667f, r101.f295667f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f295668g, r101.f295668g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f295669h, r101.f295669h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f295670i, r101.f295670i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f295671j, r101.f295671j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f295672k, r101.f295672k) == true) goto L41;
        return false;
    L41:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f295662a.hashCode() * 31;
        int r101 = 1231;
        if (this.f295663b == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f295664c == true) goto L10;
        r101 = 1237;
    L10:
        int r104 = (((((((((((((((r103 + r101) * 31) + this.f295665d.hashCode()) * 31) + this.f295666e.hashCode()) * 31) + this.f295667f.hashCode()) * 31) + this.f295668g.hashCode()) * 31) + this.f295669h.hashCode()) * 31) + this.f295670i.hashCode()) * 31) + this.f295671j.hashCode()) * 31;
        String r105 = this.f295672k;
        if (r105 != null) goto L13;
        int r106 = 0;
    L15:
        return r104 + r106;
    L13:
        r106 = r105.hashCode();
        goto L15
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "ActionBarSendMsgContentBuildOptions(languageCode=" + this.f295662a + ", isOversea=" + this.f295663b + ", removeScreenPromptPrefixEnabled=" + this.f295664c + ", outpaintOriginalRatioText=" + this.f295665d + ", outpaintSelectedRatioFormat=" + this.f295666e + ", pptPageSizeFallbackLabel=" + this.f295667f + ", pptTemplateFallbackLabel=" + this.f295668g + ", formatString=" + this.f295669h + ", obricUserInputFormatter=" + this.f295670i + ", stylePromptMessageTextProvider=" + this.f295671j + ", promptSeparator=" + this.f295672k + ')';
    }

    public e() {
        this("zh", false, false, "", "%s", "", "", new b(), c.f295660a, d.f295661a, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public e(String r100, boolean r101, boolean r102, String r103, String r104, String r105, String r106, Function2<? super String, Object, String> r107, Function2<? super String, ? super String, String> r110, Function2<? super String, ? super Long, String> r111, String r112) {
        Intrinsics.checkNotNullParameter(r100, UserInfo.LANGUAGECODE);
        Intrinsics.checkNotNullParameter(r103, "outpaintOriginalRatioText");
        Intrinsics.checkNotNullParameter(r104, "outpaintSelectedRatioFormat");
        Intrinsics.checkNotNullParameter(r105, "pptPageSizeFallbackLabel");
        Intrinsics.checkNotNullParameter(r106, "pptTemplateFallbackLabel");
        Intrinsics.checkNotNullParameter(r107, "formatString");
        Intrinsics.checkNotNullParameter(r110, "obricUserInputFormatter");
        Intrinsics.checkNotNullParameter(r111, "stylePromptMessageTextProvider");
        this.f295662a = r100;
        this.f295663b = r101;
        this.f295664c = r102;
        this.f295665d = r103;
        this.f295666e = r104;
        this.f295667f = r105;
        this.f295668g = r106;
        this.f295669h = r107;
        this.f295670i = r110;
        this.f295671j = r111;
        this.f295672k = r112;
    }
}
