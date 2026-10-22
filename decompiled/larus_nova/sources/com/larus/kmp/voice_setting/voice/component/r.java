package com.larus.kmp.voice_setting.voice.component;

import com.hihonor.honorid.core.data.UserInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f352492a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f352493b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f352494c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f352495d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f352496e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f352497f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f352498g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f352499h;

    public r() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof r) == true) goto L8;
        return false;
    L8:
        r r101 = (r) r100;
        if (Intrinsics.areEqual(this.f352492a, r101.f352492a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f352493b, r101.f352493b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f352494c, r101.f352494c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f352495d, r101.f352495d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f352496e, r101.f352496e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f352497f, r101.f352497f) == true) goto L27;
        return false;
    L27:
        if (this.f352498g == r101.f352498g) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f352499h, r101.f352499h) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f352492a.hashCode() * 31) + this.f352493b.hashCode()) * 31;
        String r101 = this.f352494c;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f352495d;
        if (r105 == null) goto L10;
        r102 = r105.hashCode();
    L10:
        int r106 = (((((r104 + r102) * 31) + this.f352496e.hashCode()) * 31) + this.f352497f.hashCode()) * 31;
        if (this.f352498g == false) goto L13;
        int r107 = 1231;
    L15:
        return ((r106 + r107) * 31) + this.f352499h.hashCode();
    L13:
        r107 = 1237;
        goto L15
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "VoiceCreateFlowDraftData(localVoiceId=" + this.f352492a + ", voiceName=" + this.f352493b + ", avatarUri=" + this.f352494c + ", avatarUrl=" + this.f352495d + ", languageCode=" + this.f352496e + ", previousPage=" + this.f352497f + ", replaceVoice=" + this.f352498g + ", logTraceId=" + this.f352499h + ')';
    }

    public /* synthetic */ r(int r110) {
        this("", "", null, null, "zh", "", false, "");
    }

    public r(String r100, String r101, String r102, String r103, String r104, String r105, boolean r106, String r107) {
        Intrinsics.checkNotNullParameter(r100, "localVoiceId");
        Intrinsics.checkNotNullParameter(r101, "voiceName");
        Intrinsics.checkNotNullParameter(r104, UserInfo.LANGUAGECODE);
        Intrinsics.checkNotNullParameter(r105, "previousPage");
        Intrinsics.checkNotNullParameter(r107, "logTraceId");
        this.f352492a = r100;
        this.f352493b = r101;
        this.f352494c = r102;
        this.f352495d = r103;
        this.f352496e = r104;
        this.f352497f = r105;
        this.f352498g = r106;
        this.f352499h = r107;
    }

    public static r a(r r100, String r110, String r111, String r112, String r113, String r114, String r115, String r116, int r117) {
        if ((r117 & 1) == 0) goto L5;
        String r101 = r100.f352492a;
    L7:
        if ((r117 & 2) == 0) goto L9;
        String r102 = r100.f352493b;
    L11:
        if ((r117 & 4) == 0) goto L13;
        String r103 = r100.f352494c;
    L15:
        if ((r117 & 8) == 0) goto L17;
        String r104 = r100.f352495d;
    L19:
        if ((r117 & 16) == 0) goto L21;
        String r105 = r100.f352496e;
    L23:
        if ((r117 & 32) == 0) goto L25;
        String r106 = r100.f352497f;
    L27:
        if ((r117 & 64) == 0) goto L29;
        boolean r107 = r100.f352498g;
    L31:
        if ((r117 & 128) == 0) goto L33;
        String r108 = r100.f352499h;
    L34:
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "localVoiceId");
        Intrinsics.checkNotNullParameter(r102, "voiceName");
        Intrinsics.checkNotNullParameter(r105, UserInfo.LANGUAGECODE);
        Intrinsics.checkNotNullParameter(r106, "previousPage");
        Intrinsics.checkNotNullParameter(r108, "logTraceId");
        return new r(r101, r102, r103, r104, r105, r106, r107, r108);
    L33:
        r108 = r116;
        goto L34
    L29:
        r107 = false;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }
}
