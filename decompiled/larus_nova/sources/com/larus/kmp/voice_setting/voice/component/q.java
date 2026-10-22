package com.larus.kmp.voice_setting.voice.component;

import com.hihonor.honorid.core.data.UserInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f352459a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f352460b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f352461c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f352462d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f352463e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f352464f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f352465g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f352466h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f352467i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f352468j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final y f352469k;

    public q() {
        this(null, null, null, null, null, null, null, null, false, false, 2047);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof q) == true) goto L8;
        return false;
    L8:
        q r101 = (q) r100;
        if (Intrinsics.areEqual(this.f352459a, r101.f352459a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f352460b, r101.f352460b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f352461c, r101.f352461c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f352462d, r101.f352462d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f352463e, r101.f352463e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f352464f, r101.f352464f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f352465g, r101.f352465g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f352466h, r101.f352466h) == true) goto L33;
        return false;
    L33:
        if (this.f352467i == r101.f352467i) goto L36;
        return false;
    L36:
        if (this.f352468j == r101.f352468j) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f352469k, r101.f352469k) == true) goto L41;
        return false;
    L41:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((((((this.f352459a.hashCode() * 31) + this.f352460b.hashCode()) * 31) + this.f352461c.hashCode()) * 31) + this.f352462d.hashCode()) * 31) + this.f352463e.hashCode()) * 31) + this.f352464f.hashCode()) * 31;
        String r101 = this.f352465g;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (((r100 + r103) * 31) + this.f352466h.hashCode()) * 31;
        int r105 = 1231;
        if (this.f352467i == false) goto L9;
        int r106 = 1231;
    L10:
        int r107 = (r104 + r106) * 31;
        if (this.f352468j == true) goto L14;
        r105 = 1237;
    L14:
        int r108 = (r107 + r105) * 31;
        y r109 = this.f352469k;
        if (r109 == null) goto L19;
        r102 = r109.hashCode();
    L19:
        return r108 + r102;
    L9:
        r106 = 1237;
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "VoiceCreateDialogArgsData(title=" + this.f352459a + ", enterFrom=" + this.f352460b + ", clickFrom=" + this.f352461c + ", enterMethod=" + this.f352462d + ", trackParams=" + this.f352463e + ", logTraceId=" + this.f352464f + ", botId=" + this.f352465g + ", languageCode=" + this.f352466h + ", disableAnimation=" + this.f352467i + ", isFromVoiceCloneScheme=" + this.f352468j + ", replace=" + this.f352469k + ')';
    }

    public static q a(q r110, String r111, String r112, y r113, int r210) {
        String r100 = null;
        if ((r210 & 1) == 0) goto L5;
        String r101 = r110.f352459a;
    L7:
        if ((r210 & 2) == 0) goto L9;
        String r102 = r110.f352460b;
    L11:
        if ((r210 & 4) == 0) goto L13;
        String r103 = r110.f352461c;
    L15:
        if ((r210 & 8) == 0) goto L17;
        String r104 = r110.f352462d;
    L19:
        if ((r210 & 16) == 0) goto L21;
        String r105 = r110.f352463e;
    L23:
        if ((r210 & 32) == 0) goto L25;
        String r114 = r110.f352464f;
    L27:
        if ((r210 & 64) == 0) goto L29;
        r100 = r110.f352465g;
    L29:
        String r115 = r100;
        if ((r210 & 128) == 0) goto L32;
        String r116 = r110.f352466h;
    L34:
        if ((r210 & 256) == 0) goto L36;
        boolean r117 = r110.f352467i;
    L38:
        if ((r210 & 512) == 0) goto L40;
        boolean r118 = r110.f352468j;
    L42:
        if ((r210 & 1024) == 0) goto L44;
        y r119 = r110.f352469k;
    L45:
        Intrinsics.checkNotNullParameter(r101, "title");
        Intrinsics.checkNotNullParameter(r102, "enterFrom");
        Intrinsics.checkNotNullParameter(r103, "clickFrom");
        Intrinsics.checkNotNullParameter(r104, "enterMethod");
        Intrinsics.checkNotNullParameter(r105, "trackParams");
        Intrinsics.checkNotNullParameter(r114, "logTraceId");
        Intrinsics.checkNotNullParameter(r116, UserInfo.LANGUAGECODE);
        return new q(r101, r102, r103, r104, r105, r114, r115, r116, r117, r118, r119);
    L44:
        r119 = r113;
        goto L45
    L40:
        r118 = false;
        goto L42
    L36:
        r117 = false;
        goto L38
    L32:
        r116 = r112;
        goto L34
    L25:
        r114 = r111;
        goto L27
    L21:
        r105 = null;
        goto L23
    L17:
        r104 = null;
        goto L19
    L13:
        r103 = null;
        goto L15
    L9:
        r102 = null;
        goto L11
    L5:
        r101 = null;
        goto L7
    }

    public /* synthetic */ q(String r110, String r111, String r112, String r113, String r210, String r211, String r212, String r213, boolean r214, boolean r215, int r216) {
        if ((r216 & 1) == 0) goto L5;
        String r100 = "";
    L7:
        if ((r216 & 2) == 0) goto L9;
        String r101 = "";
    L11:
        if ((r216 & 4) == 0) goto L13;
        String r102 = "";
    L15:
        if ((r216 & 8) == 0) goto L17;
        String r103 = "";
    L19:
        if ((r216 & 16) == 0) goto L21;
        String r104 = "";
    L23:
        if ((r216 & 32) == 0) goto L25;
        String r105 = "";
    L27:
        if ((r216 & 64) == 0) goto L29;
        String r114 = null;
    L31:
        if ((r216 & 128) == 0) goto L33;
        String r115 = "zh";
    L35:
        if ((r216 & 256) == 0) goto L37;
        boolean r116 = false;
    L39:
        if ((r216 & 512) == 0) goto L41;
        boolean r117 = false;
    L42:
        this(r100, r101, r102, r103, r104, r105, r114, r115, r116, r117, null);
        return;
    L41:
        r117 = r215;
        goto L42
    L37:
        r116 = r214;
        goto L39
    L33:
        r115 = r213;
        goto L35
    L29:
        r114 = r212;
        goto L31
    L25:
        r105 = r211;
        goto L27
    L21:
        r104 = r210;
        goto L23
    L17:
        r103 = r113;
        goto L19
    L13:
        r102 = r112;
        goto L15
    L9:
        r101 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }

    public q(String r100, String r101, String r102, String r103, String r104, String r105, String r106, String r107, boolean r110, boolean r111, y r112) {
        Intrinsics.checkNotNullParameter(r100, "title");
        Intrinsics.checkNotNullParameter(r101, "enterFrom");
        Intrinsics.checkNotNullParameter(r102, "clickFrom");
        Intrinsics.checkNotNullParameter(r103, "enterMethod");
        Intrinsics.checkNotNullParameter(r104, "trackParams");
        Intrinsics.checkNotNullParameter(r105, "logTraceId");
        Intrinsics.checkNotNullParameter(r107, UserInfo.LANGUAGECODE);
        this.f352459a = r100;
        this.f352460b = r101;
        this.f352461c = r102;
        this.f352462d = r103;
        this.f352463e = r104;
        this.f352464f = r105;
        this.f352465g = r106;
        this.f352466h = r107;
        this.f352467i = r110;
        this.f352468j = r111;
        this.f352469k = r112;
    }
}
