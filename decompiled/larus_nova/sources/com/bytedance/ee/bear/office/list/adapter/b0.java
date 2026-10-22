package com.bytedance.ee.bear.office.list.adapter;

import com.bytedance.ee.bear.more.office.OfficeLongPressDisabledDispatchReason;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OfficeLongPressMenuAction f235723a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f235724b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f235725c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f235726d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final OfficeLongPressMenuItemState f235727e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f235728f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Integer f235729g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Integer f235730h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f235731i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final OfficeLongPressDisabledDispatchReason f235732j;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b0) == true) goto L8;
        return false;
    L8:
        b0 r101 = (b0) r100;
        if (this.f235723a == r101.f235723a) goto L12;
        return false;
    L12:
        if (this.f235724b == r101.f235724b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f235725c, r101.f235725c) == true) goto L18;
        return false;
    L18:
        if (this.f235726d == r101.f235726d) goto L21;
        return false;
    L21:
        if (this.f235727e == r101.f235727e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f235728f, r101.f235728f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f235729g, r101.f235729g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f235730h, r101.f235730h) == true) goto L33;
        return false;
    L33:
        if (this.f235731i == r101.f235731i) goto L36;
        return false;
    L36:
        if (this.f235732j == r101.f235732j) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((((this.f235723a.hashCode() * 31) + this.f235724b) * 31) + this.f235725c.hashCode()) * 31) + this.f235726d) * 31) + this.f235727e.hashCode()) * 31;
        String r101 = this.f235728f;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        Integer r105 = this.f235729g;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        Integer r108 = this.f235730h;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        if (this.f235731i == false) goto L17;
        int r111 = 1231;
    L18:
        int r112 = (r110 + r111) * 31;
        OfficeLongPressDisabledDispatchReason r113 = this.f235732j;
        if (r113 == null) goto L23;
        r102 = r113.hashCode();
    L23:
        return r112 + r102;
    L17:
        r111 = 1237;
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
        return "OfficeLongPressMenuItemSpec(action=" + this.f235723a + ", menuId=" + this.f235724b + ", title=" + this.f235725c + ", iconRes=" + this.f235726d + ", state=" + this.f235727e + ", disabledTips=" + this.f235728f + ", endIconRes=" + this.f235729g + ", textColor=" + this.f235730h + ", dispatchWhenDisabled=" + this.f235731i + ", disabledDispatchReason=" + this.f235732j + ')';
    }

    public b0(OfficeLongPressMenuAction r100, int r101, String r102, int r103, OfficeLongPressMenuItemState r104, String r105, Integer r106, Integer r107, boolean r110, OfficeLongPressDisabledDispatchReason r111) {
        Intrinsics.checkNotNullParameter(r100, "action");
        Intrinsics.checkNotNullParameter(r102, "title");
        Intrinsics.checkNotNullParameter(r104, "state");
        this.f235723a = r100;
        this.f235724b = r101;
        this.f235725c = r102;
        this.f235726d = r103;
        this.f235727e = r104;
        this.f235728f = r105;
        this.f235729g = r106;
        this.f235730h = r107;
        this.f235731i = r110;
        this.f235732j = r111;
    }

    public /* synthetic */ b0(OfficeLongPressMenuAction r110, int r111, String r112, int r113, OfficeLongPressMenuItemState r114, String r115, Integer r210, Integer r211, boolean r212, OfficeLongPressDisabledDispatchReason r213, int r214) {
        if ((r214 & 16) == 0) goto L5;
        OfficeLongPressMenuItemState r100 = OfficeLongPressMenuItemState.VISIBLE;
    L7:
        if ((r214 & 32) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r214 & 64) == 0) goto L13;
        Integer r102 = null;
    L15:
        if ((r214 & 128) == 0) goto L17;
        Integer r116 = null;
    L19:
        if ((r214 & 256) == 0) goto L21;
        boolean r117 = false;
    L23:
        if ((r214 & 512) == 0) goto L25;
        OfficeLongPressDisabledDispatchReason r118 = null;
    L26:
        this(r110, r111, r112, r113, r100, r101, r102, r116, r117, r118);
        return;
    L25:
        r118 = r213;
        goto L26
    L21:
        r117 = r212;
        goto L23
    L17:
        r116 = r211;
        goto L19
    L13:
        r102 = r210;
        goto L15
    L9:
        r101 = r115;
        goto L11
    L5:
        r100 = r114;
        goto L7
    }
}
