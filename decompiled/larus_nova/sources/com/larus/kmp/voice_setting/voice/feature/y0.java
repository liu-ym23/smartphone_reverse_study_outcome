package com.larus.kmp.voice_setting.voice.feature;

import com.hihonor.honorid.core.data.UserInfo;
import com.larus.im.bean.bot.IconItem;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class y0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f353381a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f353382b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f353383c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f353384d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f353385e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final IconItem f353386f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f353387g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f353388h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f353389i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f353390j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f353391k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f353392l;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof y0) == true) goto L8;
        return false;
    L8:
        y0 r101 = (y0) r100;
        if (Intrinsics.areEqual(this.f353381a, r101.f353381a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f353382b, r101.f353382b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f353383c, r101.f353383c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f353384d, r101.f353384d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f353385e, r101.f353385e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f353386f, r101.f353386f) == true) goto L27;
        return false;
    L27:
        if (this.f353387g == r101.f353387g) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f353388h, r101.f353388h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f353389i, r101.f353389i) == true) goto L36;
        return false;
    L36:
        if (this.f353390j == r101.f353390j) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f353391k, r101.f353391k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f353392l, r101.f353392l) == true) goto L44;
        return false;
    L44:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f353381a.hashCode() * 31) + this.f353382b.hashCode()) * 31) + this.f353383c.hashCode()) * 31;
        String r101 = this.f353384d;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f353385e;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        IconItem r108 = this.f353386f;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        int r111 = 1231;
        if (this.f353387g == false) goto L17;
        int r112 = 1231;
    L18:
        int r113 = (r110 + r112) * 31;
        String r114 = this.f353388h;
        if (r114 == null) goto L22;
        r102 = r114.hashCode();
    L22:
        int r115 = (((r113 + r102) * 31) + this.f353389i.hashCode()) * 31;
        if (this.f353390j == true) goto L27;
        r111 = 1237;
    L27:
        return ((((r115 + r111) * 31) + this.f353391k.hashCode()) * 31) + this.f353392l.hashCode();
    L17:
        r112 = 1237;
        goto L18
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "UgcVoiceUploadParam(languageCode=" + this.f353381a + ", filePath=" + this.f353382b + ", freeTalkContent=" + this.f353383c + ", localVoiceId=" + this.f353384d + ", voiceName=" + this.f353385e + ", iconItem=" + this.f353386f + ", replaceVoice=" + this.f353387g + ", previousPage=" + this.f353388h + ", enterMethod=" + this.f353389i + ", isFromVoiceCloneScheme=" + this.f353390j + ", trackParams=" + this.f353391k + ", logTraceId=" + this.f353392l + ')';
    }

    public /* synthetic */ y0(String r110, String r111, String r112, String r113, IconItem r210, boolean r211, String r212, String r213, boolean r214, String r215, int r216) {
        if ((r216 & 8) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r216 & 16) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r216 & 32) == 0) goto L13;
        IconItem r102 = null;
    L15:
        if ((r216 & 64) == 0) goto L17;
        boolean r103 = false;
    L19:
        if ((r216 & 128) == 0) goto L21;
        String r104 = null;
    L23:
        if ((r216 & 256) == 0) goto L25;
        String r114 = "";
    L27:
        if ((r216 & 512) == 0) goto L29;
        boolean r115 = false;
    L31:
        if ((r216 & 1024) == 0) goto L33;
        String r116 = "";
    L35:
        if ((r216 & 2048) == 0) goto L37;
        String r117 = "";
    L38:
        this(r110, "", r111, r100, r101, r102, r103, r104, r114, r115, r116, r117);
        return;
    L37:
        r117 = null;
        goto L38
    L33:
        r116 = r215;
        goto L35
    L29:
        r115 = r214;
        goto L31
    L25:
        r114 = r213;
        goto L27
    L21:
        r104 = r212;
        goto L23
    L17:
        r103 = r211;
        goto L19
    L13:
        r102 = r210;
        goto L15
    L9:
        r101 = r113;
        goto L11
    L5:
        r100 = r112;
        goto L7
    }

    public y0(String r100, String r101, String r102, String r103, String r104, IconItem r105, boolean r106, String r107, String r110, boolean r111, String r112, String r113) {
        Intrinsics.checkNotNullParameter(r100, UserInfo.LANGUAGECODE);
        Intrinsics.checkNotNullParameter(r101, "filePath");
        Intrinsics.checkNotNullParameter(r102, "freeTalkContent");
        Intrinsics.checkNotNullParameter(r110, "enterMethod");
        Intrinsics.checkNotNullParameter(r112, "trackParams");
        Intrinsics.checkNotNullParameter(r113, "logTraceId");
        this.f353381a = r100;
        this.f353382b = r101;
        this.f353383c = r102;
        this.f353384d = r103;
        this.f353385e = r104;
        this.f353386f = r105;
        this.f353387g = r106;
        this.f353388h = r107;
        this.f353389i = r110;
        this.f353390j = r111;
        this.f353391k = r112;
        this.f353392l = r113;
    }
}
