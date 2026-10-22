package com.larus.kmp.voice_setting.voice.component;

import com.hihonor.honorid.core.data.UserInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f352618a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f352619b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f352620c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f352621d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f352622e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f352623f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f352624g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof y) == true) goto L8;
        return false;
    L8:
        y r101 = (y) r100;
        if (Intrinsics.areEqual(this.f352618a, r101.f352618a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f352619b, r101.f352619b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f352620c, r101.f352620c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f352621d, r101.f352621d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f352622e, r101.f352622e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f352623f, r101.f352623f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f352624g, r101.f352624g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f352618a.hashCode() * 31) + this.f352619b.hashCode()) * 31;
        String r101 = this.f352620c;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f352621d;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return ((((((r104 + r102) * 31) + this.f352622e.hashCode()) * 31) + this.f352623f.hashCode()) * 31) + this.f352624g.hashCode();
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "VoiceCreateReplaceArgsData(localVoiceId=" + this.f352618a + ", voiceName=" + this.f352619b + ", avatarUri=" + this.f352620c + ", avatarUrl=" + this.f352621d + ", languageCode=" + this.f352622e + ", previousPage=" + this.f352623f + ", logTraceId=" + this.f352624g + ')';
    }

    public y() {
        this("", "", null, null, "zh", "", "");
    }

    public y(String r100, String r101, String r102, String r103, String r104, String r105, String r106) {
        Intrinsics.checkNotNullParameter(r100, "localVoiceId");
        Intrinsics.checkNotNullParameter(r101, "voiceName");
        Intrinsics.checkNotNullParameter(r104, UserInfo.LANGUAGECODE);
        Intrinsics.checkNotNullParameter(r105, "previousPage");
        Intrinsics.checkNotNullParameter(r106, "logTraceId");
        this.f352618a = r100;
        this.f352619b = r101;
        this.f352620c = r102;
        this.f352621d = r103;
        this.f352622e = r104;
        this.f352623f = r105;
        this.f352624g = r106;
    }
}
