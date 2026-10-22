package com.larus.bmhome.instruction;

import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f311867a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f311868b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f311869c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f311870d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f311871e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f311872f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f311873g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f311874h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f311875i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f311876j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f311877k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f311878l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f311879m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Pair<Integer, Integer> f311880n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final String f311881o;

    public a() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f311867a == r101.f311867a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f311868b, r101.f311868b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f311869c, r101.f311869c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f311870d, r101.f311870d) == true) goto L21;
        return false;
    L21:
        if (this.f311871e == r101.f311871e) goto L24;
        return false;
    L24:
        if (this.f311872f == r101.f311872f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f311873g, r101.f311873g) == true) goto L30;
        return false;
    L30:
        if (this.f311874h == r101.f311874h) goto L33;
        return false;
    L33:
        if (this.f311875i == r101.f311875i) goto L36;
        return false;
    L36:
        if (this.f311876j == r101.f311876j) goto L39;
        return false;
    L39:
        if (this.f311877k == r101.f311877k) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f311878l, r101.f311878l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.f311879m, r101.f311879m) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.f311880n, r101.f311880n) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.f311881o, r101.f311881o) == true) goto L53;
        return false;
    L53:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f311867a * 31;
        String r101 = this.f311868b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f311869c;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.f311870d;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        int r111 = 1231;
        if (this.f311871e == false) goto L17;
        int r112 = 1231;
    L18:
        int r113 = (((r110 + r112) * 31) + this.f311872f) * 31;
        String r114 = this.f311873g;
        if (r114 != null) goto L21;
        int r115 = 0;
    L22:
        int r116 = (r113 + r115) * 31;
        if (this.f311874h == false) goto L25;
        int r117 = 1231;
    L26:
        int r118 = (r116 + r117) * 31;
        if (this.f311875i == false) goto L29;
        int r119 = 1231;
    L30:
        int r120 = (r118 + r119) * 31;
        if (this.f311876j == true) goto L34;
        r111 = 1237;
    L34:
        int r121 = (((r120 + r111) * 31) + this.f311877k) * 31;
        String r122 = this.f311878l;
        if (r122 != null) goto L37;
        int r123 = 0;
    L38:
        int r124 = (r121 + r123) * 31;
        String r125 = this.f311879m;
        if (r125 != null) goto L41;
        int r126 = 0;
    L42:
        int r127 = (r124 + r126) * 31;
        Pair<Integer, Integer> r128 = this.f311880n;
        if (r128 != null) goto L45;
        int r129 = 0;
    L46:
        int r130 = (r127 + r129) * 31;
        String r131 = this.f311881o;
        if (r131 == null) goto L51;
        r102 = r131.hashCode();
    L51:
        return r130 + r102;
    L45:
        r129 = r128.hashCode();
        goto L46
    L41:
        r126 = r125.hashCode();
        goto L42
    L37:
        r123 = r122.hashCode();
        goto L38
    L29:
        r119 = 1237;
        goto L30
    L25:
        r117 = 1237;
        goto L26
    L21:
        r115 = r114.hashCode();
        goto L22
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
        return "ActionSchemaConfig(instructionType=" + this.f311867a + ", enterMethod=" + this.f311868b + ", actionBarKey=" + this.f311869c + ", actionBarItemId=" + this.f311870d + ", isHalfScreenPage=" + this.f311871e + ", menuInstructionType=" + this.f311872f + ", feedLandingTab=" + this.f311873g + ", openAlbum=" + this.f311874h + ", albumDirectSend=" + this.f311875i + ", albumMultiSelect=" + this.f311876j + ", maxImage=" + this.f311877k + ", prompt=" + this.f311878l + ", instructionDefaultParams=" + this.f311879m + ", selectedPromptPosition=" + this.f311880n + ", conversationId=" + this.f311881o + ')';
    }

    public a(int r110, String r111, String r112, String r113, boolean r210, int r211, String r212, boolean r213, boolean r214, boolean r215, int r216, String r217, Pair r218, String r219, int r310) {
        if ((r310 & 2) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r310 & 4) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r310 & 8) == 0) goto L13;
        String r102 = null;
    L14:
        int r103 = 0;
        if ((r310 & 16) == 0) goto L17;
        boolean r104 = false;
    L19:
        if ((r310 & 64) == 0) goto L21;
        String r105 = null;
    L23:
        if ((r310 & 128) == 0) goto L25;
        boolean r106 = false;
    L27:
        if ((r310 & 256) == 0) goto L29;
        boolean r114 = false;
    L31:
        if ((r310 & 512) == 0) goto L33;
        boolean r115 = false;
    L35:
        if ((r310 & 1024) != 0) goto L39;
        r103 = r216;
    L39:
        if ((r310 & 2048) == 0) goto L41;
        String r116 = null;
    L43:
        if ((r310 & 8192) == 0) goto L45;
        Pair r117 = null;
    L47:
        if ((r310 & 16384) == 0) goto L49;
        String r107 = null;
    L50:
        this.f311867a = r110;
        this.f311868b = r100;
        this.f311869c = r101;
        this.f311870d = r102;
        this.f311871e = r104;
        this.f311872f = r211;
        this.f311873g = r105;
        this.f311874h = r106;
        this.f311875i = r114;
        this.f311876j = r115;
        this.f311877k = r103;
        this.f311878l = r116;
        this.f311879m = null;
        this.f311880n = r117;
        this.f311881o = r107;
        return;
    L49:
        r107 = r219;
        goto L50
    L45:
        r117 = r218;
        goto L47
    L41:
        r116 = r217;
        goto L43
    L33:
        r115 = r215;
        goto L35
    L29:
        r114 = r214;
        goto L31
    L25:
        r106 = r213;
        goto L27
    L21:
        r105 = r212;
        goto L23
    L17:
        r104 = r210;
        goto L19
    L13:
        r102 = r113;
        goto L14
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }
}
