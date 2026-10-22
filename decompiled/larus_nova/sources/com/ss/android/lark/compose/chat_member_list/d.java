package com.ss.android.lark.compose.chat_member_list;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f417339a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<com.ss.android.lark.compose.chatterselector.a> f417340b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f417341c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f417342d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f417343e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f417344f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f417345g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f417346h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f417347i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f417348j;

    public d() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f417339a, r101.f417339a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f417340b, r101.f417340b) == true) goto L15;
        return false;
    L15:
        if (this.f417341c == r101.f417341c) goto L18;
        return false;
    L18:
        if (this.f417342d == r101.f417342d) goto L21;
        return false;
    L21:
        if (this.f417343e == r101.f417343e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f417344f, r101.f417344f) == true) goto L27;
        return false;
    L27:
        if (this.f417345g == r101.f417345g) goto L30;
        return false;
    L30:
        if (this.f417346h == r101.f417346h) goto L33;
        return false;
    L33:
        if (this.f417347i == r101.f417347i) goto L36;
        return false;
    L36:
        if (this.f417348j == r101.f417348j) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f417339a.hashCode() * 31) + this.f417340b.hashCode()) * 31;
        int r101 = 1231;
        if (this.f417341c == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f417342d == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (r103 + r104) * 31;
        if (this.f417343e == false) goto L13;
        int r106 = 1231;
    L14:
        int r107 = (r105 + r106) * 31;
        String r108 = this.f417344f;
        if (r108 != null) goto L17;
        int r109 = 0;
    L18:
        int r110 = (r107 + r109) * 31;
        if (this.f417345g == false) goto L21;
        int r111 = 1231;
    L22:
        int r112 = (((r110 + r111) * 31) + this.f417346h) * 31;
        if (this.f417347i == false) goto L25;
        int r113 = 1231;
    L26:
        int r114 = (r112 + r113) * 31;
        if (this.f417348j == true) goto L31;
        r101 = 1237;
    L31:
        return r114 + r101;
    L25:
        r113 = 1237;
        goto L26
    L21:
        r111 = 1237;
        goto L22
    L17:
        r109 = r108.hashCode();
        goto L18
    L13:
        r106 = 1237;
        goto L14
    L9:
        r104 = 1237;
        goto L10
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "ChatMembersUiState(query=" + this.f417339a + ", members=" + this.f417340b + ", loading=" + this.f417341c + ", loadingMore=" + this.f417342d + ", hasMore=" + this.f417343e + ", cursor=" + this.f417344f + ", isCurrentUserAdmin=" + this.f417345g + ", userCount=" + this.f417346h + ", isUserCountVisible=" + this.f417347i + ", allCanAddMember=" + this.f417348j + ')';
    }

    public /* synthetic */ d(int r110) {
        this("", CollectionsKt.emptyList(), false, false, false, null, false, 0, true, false);
    }

    public d(String r100, List<com.ss.android.lark.compose.chatterselector.a> r101, boolean r102, boolean r103, boolean r104, String r105, boolean r106, int r107, boolean r110, boolean r111) {
        Intrinsics.checkNotNullParameter(r100, "query");
        Intrinsics.checkNotNullParameter(r101, "members");
        this.f417339a = r100;
        this.f417340b = r101;
        this.f417341c = r102;
        this.f417342d = r103;
        this.f417343e = r104;
        this.f417344f = r105;
        this.f417345g = r106;
        this.f417346h = r107;
        this.f417347i = r110;
        this.f417348j = r111;
    }

    public static d a(d r110, String r111, List r112, boolean r113, boolean r114, boolean r115, String r116, boolean r117, int r118, boolean r210, boolean r211, int r212) {
        if ((r212 & 1) == 0) goto L5;
        String r100 = r110.f417339a;
    L7:
        if ((r212 & 2) == 0) goto L9;
        List r101 = r110.f417340b;
    L11:
        if ((r212 & 4) == 0) goto L13;
        boolean r102 = r110.f417341c;
    L15:
        if ((r212 & 8) == 0) goto L17;
        boolean r103 = r110.f417342d;
    L19:
        if ((r212 & 16) == 0) goto L21;
        boolean r104 = r110.f417343e;
    L23:
        if ((r212 & 32) == 0) goto L25;
        String r105 = r110.f417344f;
    L27:
        if ((r212 & 64) == 0) goto L29;
        boolean r106 = r110.f417345g;
    L31:
        if ((r212 & 128) == 0) goto L33;
        int r107 = r110.f417346h;
    L35:
        if ((r212 & 256) == 0) goto L37;
        boolean r119 = r110.f417347i;
    L39:
        if ((r212 & 512) == 0) goto L41;
        boolean r108 = r110.f417348j;
    L42:
        r110.getClass();
        Intrinsics.checkNotNullParameter(r100, "query");
        Intrinsics.checkNotNullParameter(r101, "members");
        return new d(r100, r101, r102, r103, r104, r105, r106, r107, r119, r108);
    L41:
        r108 = r211;
        goto L42
    L37:
        r119 = r210;
        goto L39
    L33:
        r107 = r118;
        goto L35
    L29:
        r106 = r117;
        goto L31
    L25:
        r105 = r116;
        goto L27
    L21:
        r104 = r115;
        goto L23
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }
}
