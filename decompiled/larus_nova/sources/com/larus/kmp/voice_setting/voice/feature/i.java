package com.larus.kmp.voice_setting.voice.feature;

import com.hihonor.honorid.core.data.UserInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f353314a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f353315b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f353316c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f353317d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f353318e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f353319f;

    public i() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i) == true) goto L8;
        return false;
    L8:
        i r101 = (i) r100;
        if (Intrinsics.areEqual(this.f353314a, r101.f353314a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f353315b, r101.f353315b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f353316c, r101.f353316c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f353317d, r101.f353317d) == true) goto L21;
        return false;
    L21:
        if (this.f353318e == r101.f353318e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f353319f, r101.f353319f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((this.f353314a.hashCode() * 31) + this.f353315b.hashCode()) * 31) + this.f353316c.hashCode()) * 31) + this.f353317d.hashCode()) * 31;
        long r101 = this.f353318e;
        return ((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.f353319f.hashCode();
    }

    public final String toString() {
        return "UgcVoiceRecommendParam(languageCode=" + this.f353314a + ", botName=" + this.f353315b + ", botDesc=" + this.f353316c + ", botId=" + this.f353317d + ", botModelType=" + this.f353318e + ", sceneName=" + this.f353319f + ')';
    }

    public /* synthetic */ i(int r100) {
        this("", "", "", "", 0, "");
    }

    public i(String r100, String r101, String r102, String r103, long r104, String r105) {
        Intrinsics.checkNotNullParameter(r100, UserInfo.LANGUAGECODE);
        Intrinsics.checkNotNullParameter(r101, "botName");
        Intrinsics.checkNotNullParameter(r102, "botDesc");
        Intrinsics.checkNotNullParameter(r103, "botId");
        Intrinsics.checkNotNullParameter(r105, "sceneName");
        this.f353314a = r100;
        this.f353315b = r101;
        this.f353316c = r102;
        this.f353317d = r103;
        this.f353318e = r104;
        this.f353319f = r105;
    }
}
