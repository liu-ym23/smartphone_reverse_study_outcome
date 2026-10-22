package com.larus.home.impl.main.side_bar.data;

import com.larus.platform.model.showcase.Case;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class j0 implements i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SideBarItemType f344506a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final wh8.a f344507b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Case f344508c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final p f344509d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ll9.t f344510e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f344511f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final f f344512g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final com.larus.home.impl.main.side_bar.view.group.datasource.lark.d f344513h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f344514i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f344515j;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof j0) == true) goto L8;
        return false;
    L8:
        j0 r101 = (j0) r100;
        if (this.f344506a == r101.f344506a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f344507b, r101.f344507b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f344508c, r101.f344508c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f344509d, r101.f344509d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f344510e, r101.f344510e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f344511f, r101.f344511f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f344512g, r101.f344512g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f344513h, r101.f344513h) == true) goto L33;
        return false;
    L33:
        if (this.f344514i == r101.f344514i) goto L36;
        return false;
    L36:
        if (this.f344515j == r101.f344515j) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f344506a.hashCode() * 31;
        wh8.a r101 = this.f344507b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        Case r105 = this.f344508c;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        p r108 = this.f344509d;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        ll9.t r111 = this.f344510e;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (((r110 + r112) * 31) + this.f344511f.hashCode()) * 31;
        f r114 = this.f344512g;
        if (r114 != null) goto L21;
        int r115 = 0;
    L22:
        int r116 = (r113 + r115) * 31;
        com.larus.home.impl.main.side_bar.view.group.datasource.lark.d r117 = this.f344513h;
        if (r117 == null) goto L26;
        r102 = r117.hashCode();
    L26:
        int r118 = (r116 + r102) * 31;
        if (this.f344514i == false) goto L29;
        int r119 = 1231;
    L31:
        return ((r118 + r119) * 31) + this.f344515j;
    L29:
        r119 = 1237;
        goto L31
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
        return "SideBarItemConfig(itemType=" + this.f344506a + ", conversationData=" + this.f344507b + ", caseData=" + this.f344508c + ", component=" + this.f344509d + ", quickAccessNode=" + this.f344510e + ", showAllText=" + this.f344511f + ", divider=" + this.f344512g + ", humanFeed=" + this.f344513h + ", isSelected=" + this.f344514i + ", redBadgeCount=" + this.f344515j + ')';
    }

    @Override // com.larus.home.impl.main.side_bar.data.i0
    public final int a() {
        if (this.f344506a != SideBarItemType.CONVERSATION) goto L10;
        wh8.a r100 = this.f344507b;
        if (r100 == null) goto L8;
        return y0.a(r100, false);
    L8:
        return this.f344515j;
    L10:
        return this.f344515j;
    }

    public static j0 b(j0 r110, boolean r111) {
        SideBarItemType r100 = r110.f344506a;
        wh8.a r101 = r110.f344507b;
        Case r102 = r110.f344508c;
        p r103 = r110.f344509d;
        ll9.t r104 = r110.f344510e;
        String r105 = r110.f344511f;
        f r106 = r110.f344512g;
        com.larus.home.impl.main.side_bar.view.group.datasource.lark.d r107 = r110.f344513h;
        int r112 = r110.f344515j;
        Intrinsics.checkNotNullParameter(r100, "itemType");
        Intrinsics.checkNotNullParameter(r105, "showAllText");
        return new j0(r100, r101, r102, r103, r104, r105, r106, r107, r111, r112);
    }

    public j0(SideBarItemType r100, wh8.a r101, Case r102, p r103, ll9.t r104, String r105, f r106, com.larus.home.impl.main.side_bar.view.group.datasource.lark.d r107, boolean r110, int r111) {
        Intrinsics.checkNotNullParameter(r100, "itemType");
        Intrinsics.checkNotNullParameter(r105, "showAllText");
        this.f344506a = r100;
        this.f344507b = r101;
        this.f344508c = r102;
        this.f344509d = r103;
        this.f344510e = r104;
        this.f344511f = r105;
        this.f344512g = r106;
        this.f344513h = r107;
        this.f344514i = r110;
        this.f344515j = r111;
    }

    public /* synthetic */ j0(SideBarItemType r110, wh8.a r111, Case r112, p r113, ll9.t r114, String r210, f r211, com.larus.home.impl.main.side_bar.view.group.datasource.lark.d r212, boolean r213, int r214, int r215) {
        if ((r215 & 2) == 0) goto L5;
        wh8.a r100 = null;
    L7:
        if ((r215 & 4) == 0) goto L9;
        Case r101 = null;
    L11:
        if ((r215 & 8) == 0) goto L13;
        p r102 = null;
    L15:
        if ((r215 & 16) == 0) goto L17;
        ll9.t r103 = null;
    L19:
        if ((r215 & 32) == 0) goto L21;
        String r104 = "";
    L23:
        if ((r215 & 64) == 0) goto L25;
        f r115 = null;
    L27:
        if ((r215 & 128) == 0) goto L29;
        com.larus.home.impl.main.side_bar.view.group.datasource.lark.d r116 = null;
    L31:
        if ((r215 & 256) == 0) goto L33;
        boolean r117 = false;
    L35:
        if ((r215 & 512) == 0) goto L37;
        int r118 = 0;
    L38:
        this(r110, r100, r101, r102, r103, r104, r115, r116, r117, r118);
        return;
    L37:
        r118 = r214;
        goto L38
    L33:
        r117 = r213;
        goto L35
    L29:
        r116 = r212;
        goto L31
    L25:
        r115 = r211;
        goto L27
    L21:
        r104 = r210;
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
