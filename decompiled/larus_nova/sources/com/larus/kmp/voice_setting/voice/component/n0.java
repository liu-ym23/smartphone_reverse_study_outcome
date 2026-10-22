package com.larus.kmp.voice_setting.voice.component;

import com.hihonor.honorid.core.data.UserInfo;
import com.ss.android.socialbase.appdownloader.util.parser.zip.UnixStat;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class n0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f352381a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f352382b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f352383c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f352384d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f352385e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f352386f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f352387g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f352388h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f352389i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f352390j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f352391k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f352392l;

    public n0() {
        this(null, 0, null, null, null, null, null, null, false, UnixStat.PERM_MASK);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof n0) == true) goto L8;
        return false;
    L8:
        n0 r101 = (n0) r100;
        if (Intrinsics.areEqual(this.f352381a, r101.f352381a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f352382b, r101.f352382b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f352383c, r101.f352383c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f352384d, r101.f352384d) == true) goto L21;
        return false;
    L21:
        if (this.f352385e == r101.f352385e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f352386f, r101.f352386f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f352387g, r101.f352387g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f352388h, r101.f352388h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f352389i, r101.f352389i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f352390j, r101.f352390j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f352391k, r101.f352391k) == true) goto L42;
        return false;
    L42:
        if (this.f352392l == r101.f352392l) goto L44;
        return false;
    L44:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((this.f352381a.hashCode() * 31) + this.f352382b.hashCode()) * 31) + this.f352383c.hashCode()) * 31) + this.f352384d.hashCode()) * 31;
        long r101 = this.f352385e;
        int r102 = (((((((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.f352386f.hashCode()) * 31) + this.f352387g.hashCode()) * 31) + this.f352388h.hashCode()) * 31;
        String r103 = this.f352389i;
        if (r103 != null) goto L5;
        int r104 = 0;
    L6:
        int r105 = (((((r102 + r104) * 31) + this.f352390j.hashCode()) * 31) + this.f352391k.hashCode()) * 31;
        if (this.f352392l == false) goto L9;
        int r106 = 1231;
    L11:
        return r105 + r106;
    L9:
        r106 = 1237;
        goto L11
    L5:
        r104 = r103.hashCode();
        goto L6
    }

    public final String toString() {
        return "VoiceDialogRecordEffectRequest(structuredText=" + this.f352381a + ", recordFileName=" + this.f352382b + ", modelAssetName=" + this.f352383c + ", modelFileName=" + this.f352384d + ", sessionToken=" + this.f352385e + ", logTraceId=" + this.f352386f + ", enterFrom=" + this.f352387g + ", enterMethod=" + this.f352388h + ", botId=" + this.f352389i + ", languageCode=" + this.f352390j + ", title=" + this.f352391k + ", useBlurRecordStyle=" + this.f352392l + ')';
    }

    public n0(String r110, long r111, String r112, String r210, String r211, String r212, String r213, String r214, boolean r215, int r216) {
        String r100 = "";
        if ((r216 & 1) == 0) goto L5;
        String r101 = "";
    L6:
        String r102 = null;
        if ((r216 & 2) == 0) goto L9;
        String r103 = "ugc_voice_record.mov";
    L10:
        String r104 = "audio_metrics_v1.4.model";
        if ((r216 & 4) == 0) goto L13;
        String r105 = "audio_metrics_v1.4.model";
    L15:
        if ((r216 & 8) != 0) goto L19;
        r104 = null;
    L19:
        if ((r216 & 16) == 0) goto L21;
        long r106 = 0;
    L23:
        if ((r216 & 32) == 0) goto L25;
        String r113 = "";
    L27:
        if ((r216 & 64) == 0) goto L29;
        String r114 = "";
    L31:
        if ((r216 & 128) == 0) goto L33;
        String r115 = "";
    L35:
        if ((r216 & 256) != 0) goto L39;
        r102 = r212;
    L39:
        if ((r216 & 512) == 0) goto L41;
        String r116 = "zh";
    L43:
        if ((r216 & 1024) != 0) goto L47;
        r100 = r214;
    L47:
        if ((r216 & 2048) == 0) goto L49;
        boolean r107 = false;
    L50:
        Intrinsics.checkNotNullParameter(r101, "structuredText");
        Intrinsics.checkNotNullParameter(r103, "recordFileName");
        Intrinsics.checkNotNullParameter(r105, "modelAssetName");
        Intrinsics.checkNotNullParameter(r104, "modelFileName");
        Intrinsics.checkNotNullParameter(r113, "logTraceId");
        Intrinsics.checkNotNullParameter(r114, "enterFrom");
        Intrinsics.checkNotNullParameter(r115, "enterMethod");
        Intrinsics.checkNotNullParameter(r116, UserInfo.LANGUAGECODE);
        Intrinsics.checkNotNullParameter(r100, "title");
        this.f352381a = r101;
        this.f352382b = r103;
        this.f352383c = r105;
        this.f352384d = r104;
        this.f352385e = r106;
        this.f352386f = r113;
        this.f352387g = r114;
        this.f352388h = r115;
        this.f352389i = r102;
        this.f352390j = r116;
        this.f352391k = r100;
        this.f352392l = r107;
        return;
    L49:
        r107 = r215;
        goto L50
    L41:
        r116 = r213;
        goto L43
    L33:
        r115 = r211;
        goto L35
    L29:
        r114 = r210;
        goto L31
    L25:
        r113 = r112;
        goto L27
    L21:
        r106 = r111;
        goto L23
    L13:
        r105 = null;
        goto L15
    L9:
        r103 = null;
        goto L10
    L5:
        r101 = r110;
        goto L6
    }
}
