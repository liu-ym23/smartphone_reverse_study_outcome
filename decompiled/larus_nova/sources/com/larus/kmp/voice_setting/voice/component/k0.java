package com.larus.kmp.voice_setting.voice.component;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class k0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f352329a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f352330b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f352331c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f352332d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f352333e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f352334f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final VoiceDialogKind f352335g;

    public k0() {
        this(null, null, null, null, false, 127);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof k0) == true) goto L8;
        return false;
    L8:
        k0 r101 = (k0) r100;
        if (Intrinsics.areEqual(this.f352329a, r101.f352329a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f352330b, r101.f352330b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f352331c, r101.f352331c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f352332d, r101.f352332d) == true) goto L21;
        return false;
    L21:
        if (this.f352333e == r101.f352333e) goto L24;
        return false;
    L24:
        if (this.f352334f == r101.f352334f) goto L27;
        return false;
    L27:
        if (this.f352335g == r101.f352335g) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((((this.f352329a.hashCode() * 31) + this.f352330b.hashCode()) * 31) + this.f352331c.hashCode()) * 31) + this.f352332d.hashCode()) * 31) + this.f352333e) * 31;
        if (this.f352334f == false) goto L5;
        int r101 = 1231;
    L7:
        return ((r100 + r101) * 31) + this.f352335g.hashCode();
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "VoiceDialogNameInputUiState(title=" + this.f352329a + ", text=" + this.f352330b + ", confirmText=" + this.f352331c + ", cancelText=" + this.f352332d + ", maxLength=" + this.f352333e + ", confirmEnabled=" + this.f352334f + ", backgroundDialogKind=" + this.f352335g + ')';
    }

    public /* synthetic */ k0(String r110, String r111, String r112, String r113, boolean r114, int r115) {
        if ((r115 & 1) == 0) goto L5;
        String r100 = "";
    L7:
        if ((r115 & 2) == 0) goto L9;
        String r101 = "";
    L11:
        if ((r115 & 4) == 0) goto L13;
        String r102 = "";
    L15:
        if ((r115 & 8) == 0) goto L17;
        String r103 = "";
    L19:
        if ((r115 & 16) == 0) goto L21;
        int r104 = 50;
    L23:
        if ((r115 & 32) == 0) goto L25;
        boolean r105 = false;
    L27:
        if ((r115 & 64) == 0) goto L29;
        VoiceDialogKind r106 = VoiceDialogKind.NONE;
    L30:
        this(r100, r101, r102, r103, r104, r105, r106);
        return;
    L29:
        r106 = null;
        goto L30
    L25:
        r105 = r114;
        goto L27
    L21:
        r104 = 0;
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

    public k0(String r100, String r101, String r102, String r103, int r104, boolean r105, VoiceDialogKind r106) {
        Intrinsics.checkNotNullParameter(r100, "title");
        Intrinsics.checkNotNullParameter(r101, "text");
        Intrinsics.checkNotNullParameter(r102, "confirmText");
        Intrinsics.checkNotNullParameter(r103, "cancelText");
        Intrinsics.checkNotNullParameter(r106, "backgroundDialogKind");
        this.f352329a = r100;
        this.f352330b = r101;
        this.f352331c = r102;
        this.f352332d = r103;
        this.f352333e = r104;
        this.f352334f = r105;
        this.f352335g = r106;
    }

    public static k0 a(k0 r100, String r101, String r110, String r111, String r112, boolean r113, VoiceDialogKind r114, int r115) {
        if ((r115 & 1) == 0) goto L5;
        r101 = r100.f352329a;
    L5:
        String r102 = r101;
        if ((r115 & 2) == 0) goto L8;
        r110 = r100.f352330b;
    L8:
        String r103 = r110;
        if ((r115 & 4) == 0) goto L11;
        r111 = r100.f352331c;
    L11:
        String r104 = r111;
        if ((r115 & 8) == 0) goto L14;
        r112 = r100.f352332d;
    L14:
        String r105 = r112;
        if ((r115 & 16) == 0) goto L17;
        int r106 = r100.f352333e;
    L19:
        if ((r115 & 32) == 0) goto L21;
        r113 = r100.f352334f;
    L21:
        boolean r107 = r113;
        if ((r115 & 64) == 0) goto L24;
        r114 = r100.f352335g;
    L24:
        VoiceDialogKind r108 = r114;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r102, "title");
        Intrinsics.checkNotNullParameter(r103, "text");
        Intrinsics.checkNotNullParameter(r104, "confirmText");
        Intrinsics.checkNotNullParameter(r105, "cancelText");
        Intrinsics.checkNotNullParameter(r108, "backgroundDialogKind");
        return new k0(r102, r103, r104, r105, r106, r107, r108);
    L17:
        r106 = 0;
        goto L19
    }
}
