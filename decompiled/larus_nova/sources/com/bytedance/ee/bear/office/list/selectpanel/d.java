package com.bytedance.ee.bear.office.list.selectpanel;

import com.bytedance.ee.bear.more.office.OfficeLongPressDisabledDispatchReason;
import com.bytedance.ee.bear.office.list.adapter.OfficeLongPressMenuAction;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OfficeSelectPanelAction f236022a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f236023b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f236024c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f236025d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f236026e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f236027f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final OfficeLongPressMenuAction f236028g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f236029h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f236030i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final OfficeLongPressDisabledDispatchReason f236031j;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (this.f236022a == r101.f236022a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f236023b, r101.f236023b) == true) goto L15;
        return false;
    L15:
        if (this.f236024c == r101.f236024c) goto L18;
        return false;
    L18:
        if (this.f236025d == r101.f236025d) goto L21;
        return false;
    L21:
        if (this.f236026e == r101.f236026e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f236027f, r101.f236027f) == true) goto L27;
        return false;
    L27:
        if (this.f236028g == r101.f236028g) goto L30;
        return false;
    L30:
        if (this.f236029h == r101.f236029h) goto L33;
        return false;
    L33:
        if (this.f236030i == r101.f236030i) goto L36;
        return false;
    L36:
        if (this.f236031j == r101.f236031j) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f236022a.hashCode() * 31) + this.f236023b.hashCode()) * 31) + this.f236024c) * 31;
        int r101 = 1231;
        if (this.f236025d == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f236026e == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (((r103 + r104) * 31) + this.f236027f.hashCode()) * 31;
        OfficeLongPressMenuAction r106 = this.f236028g;
        int r107 = 0;
        if (r106 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r105 + r108) * 31;
        if (this.f236029h == false) goto L17;
        int r110 = 1231;
    L18:
        int r111 = (r109 + r110) * 31;
        if (this.f236030i == true) goto L22;
        r101 = 1237;
    L22:
        int r112 = (r111 + r101) * 31;
        OfficeLongPressDisabledDispatchReason r113 = this.f236031j;
        if (r113 == null) goto L27;
        r107 = r113.hashCode();
    L27:
        return r112 + r107;
    L17:
        r110 = 1237;
        goto L18
    L13:
        r108 = r106.hashCode();
        goto L14
    L9:
        r104 = 1237;
        goto L10
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "OfficeSelectPanelItemSpec(action=" + this.f236022a + ", title=" + this.f236023b + ", iconRes=" + this.f236024c + ", enabled=" + this.f236025d + ", danger=" + this.f236026e + ", disabledTips=" + this.f236027f + ", longPressAction=" + this.f236028g + ", blockedWhileLoading=" + this.f236029h + ", dispatchWhenDisabled=" + this.f236030i + ", disabledDispatchReason=" + this.f236031j + ')';
    }

    public d(OfficeSelectPanelAction r110, String r111, int r112, String r113, int r114) {
        if ((r114 & 8) == 0) goto L5;
        boolean r100 = true;
    L7:
        if ((r114 & 16) == 0) goto L9;
        boolean r101 = false;
    L11:
        if ((r114 & 32) == 0) goto L13;
        String r102 = com.bytedance.ee.bear.more.office.f.c();
    L14:
        this(r110, r111, r112, r100, r101, r102, null, false, false, null);
        return;
    L13:
        r102 = r113;
        goto L14
    L9:
        r101 = true;
        goto L11
    L5:
        r100 = false;
        goto L7
    }

    public d(OfficeSelectPanelAction r100, String r101, int r102, boolean r103, boolean r104, String r105, OfficeLongPressMenuAction r106, boolean r107, boolean r110, OfficeLongPressDisabledDispatchReason r111) {
        Intrinsics.checkNotNullParameter(r100, "action");
        Intrinsics.checkNotNullParameter(r101, "title");
        Intrinsics.checkNotNullParameter(r105, "disabledTips");
        this.f236022a = r100;
        this.f236023b = r101;
        this.f236024c = r102;
        this.f236025d = r103;
        this.f236026e = r104;
        this.f236027f = r105;
        this.f236028g = r106;
        this.f236029h = r107;
        this.f236030i = r110;
        this.f236031j = r111;
    }
}
