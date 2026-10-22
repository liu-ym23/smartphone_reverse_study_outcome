package com.larus.kmp.voice_setting.voice.dialog;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class w1 implements t1a.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f353208a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f353209b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f353210c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f353211d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f353212e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f353213f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f353214g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f353215h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f353216i;

    public w1() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof w1) == true) goto L8;
        return false;
    L8:
        w1 r101 = (w1) r100;
        if (Intrinsics.areEqual(this.f353208a, r101.f353208a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f353209b, r101.f353209b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f353210c, r101.f353210c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f353211d, r101.f353211d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f353212e, r101.f353212e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f353213f, r101.f353213f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f353214g, r101.f353214g) == true) goto L30;
        return false;
    L30:
        if (this.f353215h == r101.f353215h) goto L33;
        return false;
    L33:
        if (this.f353216i == r101.f353216i) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((((((((this.f353208a.hashCode() * 31) + this.f353209b.hashCode()) * 31) + this.f353210c.hashCode()) * 31) + this.f353211d.hashCode()) * 31) + this.f353212e.hashCode()) * 31) + this.f353213f.hashCode()) * 31) + this.f353214g.hashCode()) * 31;
        int r101 = 1231;
        if (this.f353215h == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f353216i == true) goto L11;
        r101 = 1237;
    L11:
        return r103 + r101;
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "UgcVoiceInfoEditDialogUiState(avatarUrl=" + this.f353208a + ", voiceName=" + this.f353209b + ", permissionHint=" + this.f353210c + ", privateLabel=" + this.f353211d + ", publicLabel=" + this.f353212e + ", publicWarning=" + this.f353213f + ", completeText=" + this.f353214g + ", isPublic=" + this.f353215h + ", isCompleteEnabled=" + this.f353216i + ')';
    }

    public /* synthetic */ w1(int r110) {
        this("", "", "", "", "", "", "", false, true);
    }

    public static w1 a(w1 r110, String r111, String r112, String r113, boolean r114, boolean r115, int r116) {
        if ((r116 & 1) == 0) goto L5;
        String r100 = r110.f353208a;
    L7:
        if ((r116 & 2) == 0) goto L9;
        String r101 = r110.f353209b;
    L11:
        if ((r116 & 4) == 0) goto L13;
        String r102 = r110.f353210c;
    L15:
        if ((r116 & 8) == 0) goto L17;
        String r103 = r110.f353211d;
    L19:
        if ((r116 & 16) == 0) goto L21;
        String r104 = r110.f353212e;
    L23:
        if ((r116 & 32) == 0) goto L25;
        String r105 = r110.f353213f;
    L27:
        if ((r116 & 64) == 0) goto L29;
        String r117 = r110.f353214g;
    L31:
        if ((r116 & 128) == 0) goto L33;
        boolean r118 = r110.f353215h;
    L35:
        if ((r116 & 256) == 0) goto L37;
        boolean r119 = r110.f353216i;
    L38:
        r110.getClass();
        Intrinsics.checkNotNullParameter(r100, "avatarUrl");
        Intrinsics.checkNotNullParameter(r101, "voiceName");
        Intrinsics.checkNotNullParameter(r102, "permissionHint");
        Intrinsics.checkNotNullParameter(r103, "privateLabel");
        Intrinsics.checkNotNullParameter(r104, "publicLabel");
        Intrinsics.checkNotNullParameter(r105, "publicWarning");
        Intrinsics.checkNotNullParameter(r117, "completeText");
        return new w1(r100, r101, r102, r103, r104, r105, r117, r118, r119);
    L37:
        r119 = r115;
        goto L38
    L33:
        r118 = r114;
        goto L35
    L29:
        r117 = r113;
        goto L31
    L25:
        r105 = null;
        goto L27
    L21:
        r104 = null;
        goto L23
    L17:
        r103 = null;
        goto L19
    L13:
        r102 = null;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public w1(String r100, String r101, String r102, String r103, String r104, String r105, String r106, boolean r107, boolean r110) {
        Intrinsics.checkNotNullParameter(r100, "avatarUrl");
        Intrinsics.checkNotNullParameter(r101, "voiceName");
        Intrinsics.checkNotNullParameter(r102, "permissionHint");
        Intrinsics.checkNotNullParameter(r103, "privateLabel");
        Intrinsics.checkNotNullParameter(r104, "publicLabel");
        Intrinsics.checkNotNullParameter(r105, "publicWarning");
        Intrinsics.checkNotNullParameter(r106, "completeText");
        this.f353208a = r100;
        this.f353209b = r101;
        this.f353210c = r102;
        this.f353211d = r103;
        this.f353212e = r104;
        this.f353213f = r105;
        this.f353214g = r106;
        this.f353215h = r107;
        this.f353216i = r110;
    }
}
