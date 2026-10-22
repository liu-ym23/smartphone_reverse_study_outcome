package com.larus.kmp.voice_setting.voice.component;

import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class d0 implements m1a.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final VoiceDialogKind f352194a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f352195b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f352196c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, String> f352197d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final q f352198e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final j5 f352199f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final t4 f352200g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final a0 f352201h;

    public d0() {
        this(null, null, null, null, null, null, 255);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d0) == true) goto L8;
        return false;
    L8:
        d0 r101 = (d0) r100;
        if (this.f352194a == r101.f352194a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f352195b, r101.f352195b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f352196c, r101.f352196c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f352197d, r101.f352197d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f352198e, r101.f352198e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f352199f, r101.f352199f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f352200g, r101.f352200g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f352201h, r101.f352201h) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f352194a.hashCode() * 31;
        String r101 = this.f352195b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f352196c;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (((r104 + r106) * 31) + this.f352197d.hashCode()) * 31;
        q r108 = this.f352198e;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        j5 r111 = this.f352199f;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        t4 r114 = this.f352200g;
        if (r114 != null) goto L21;
        int r115 = 0;
    L22:
        int r116 = (r113 + r115) * 31;
        a0 r117 = this.f352201h;
        if (r117 == null) goto L27;
        r102 = r117.hashCode();
    L27:
        return r116 + r102;
    L21:
        r115 = r114.hashCode();
        goto L22
    L17:
        r112 = r111.hashCode();
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
        return "VoiceDialogArgsData(kind=" + this.f352194a + ", voiceId=" + this.f352195b + ", source=" + this.f352196c + ", extras=" + this.f352197d + ", create=" + this.f352198e + ", optimize=" + this.f352199f + ", edit=" + this.f352200g + ", delete=" + this.f352201h + ')';
    }

    public static d0 a(d0 r100, VoiceDialogKind r110, q r111, j5 r112, int r113) {
        if ((r113 & 1) == 0) goto L5;
        r110 = r100.f352194a;
    L5:
        VoiceDialogKind r101 = r110;
        if ((r113 & 2) == 0) goto L8;
        String r102 = r100.f352195b;
    L10:
        if ((r113 & 4) == 0) goto L12;
        String r103 = r100.f352196c;
    L14:
        if ((r113 & 8) == 0) goto L16;
        Map<String, String> r104 = r100.f352197d;
    L18:
        if ((r113 & 16) == 0) goto L20;
        r111 = r100.f352198e;
    L20:
        q r105 = r111;
        if ((r113 & 32) == 0) goto L23;
        r112 = r100.f352199f;
    L23:
        j5 r106 = r112;
        if ((r113 & 64) == 0) goto L26;
        t4 r107 = r100.f352200g;
    L28:
        if ((r113 & 128) == 0) goto L30;
        a0 r108 = r100.f352201h;
    L31:
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "kind");
        Intrinsics.checkNotNullParameter(r104, "extras");
        return new d0(r101, r102, r103, r104, r105, r106, r107, r108);
    L30:
        r108 = null;
        goto L31
    L26:
        r107 = null;
        goto L28
    L16:
        r104 = null;
        goto L18
    L12:
        r103 = null;
        goto L14
    L8:
        r102 = null;
        goto L10
    }

    public /* synthetic */ d0(VoiceDialogKind r110, String r111, Map r112, q r113, t4 r114, a0 r115, int r116) {
        if ((r116 & 1) == 0) goto L5;
        VoiceDialogKind r100 = VoiceDialogKind.NONE;
    L7:
        if ((r116 & 4) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r116 & 8) == 0) goto L13;
        Map r102 = MapsKt.emptyMap();
    L15:
        if ((r116 & 16) == 0) goto L17;
        q r103 = null;
    L19:
        if ((r116 & 64) == 0) goto L21;
        t4 r104 = null;
    L23:
        if ((r116 & 128) == 0) goto L25;
        a0 r117 = null;
    L26:
        this(r100, null, r101, r102, r103, null, r104, r117);
        return;
    L25:
        r117 = r115;
        goto L26
    L21:
        r104 = r114;
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

    public d0(VoiceDialogKind r100, String r101, String r102, Map<String, String> r103, q r104, j5 r105, t4 r106, a0 r107) {
        Intrinsics.checkNotNullParameter(r100, "kind");
        Intrinsics.checkNotNullParameter(r103, "extras");
        this.f352194a = r100;
        this.f352195b = r101;
        this.f352196c = r102;
        this.f352197d = r103;
        this.f352198e = r104;
        this.f352199f = r105;
        this.f352200g = r106;
        this.f352201h = r107;
    }
}
