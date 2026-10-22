package com.bytedance.ee.bear.office.list.menuconfig;

import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.ee.bear.more.office.OfficeLongPressDisabledDispatchReason;
import com.bytedance.ee.bear.office.list.adapter.OfficeLongPressMenuAction;
import com.bytedance.ee.bear.office.list.adapter.OfficeLongPressMenuItemState;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f235928a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final OfficeLongPressMenuAction f235929b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f235930c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f235931d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final OfficeLongPressMenuItemState f235932e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f235933f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Integer f235934g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Integer f235935h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f235936i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final OfficeLongPressDisabledDispatchReason f235937j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Map<String, String> f235938k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final List<a> f235939l;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f235928a, r101.f235928a) == true) goto L12;
        return false;
    L12:
        if (this.f235929b == r101.f235929b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f235930c, r101.f235930c) == true) goto L18;
        return false;
    L18:
        if (this.f235931d == r101.f235931d) goto L21;
        return false;
    L21:
        if (this.f235932e == r101.f235932e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f235933f, r101.f235933f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f235934g, r101.f235934g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f235935h, r101.f235935h) == true) goto L33;
        return false;
    L33:
        if (this.f235936i == r101.f235936i) goto L36;
        return false;
    L36:
        if (this.f235937j == r101.f235937j) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f235938k, r101.f235938k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f235939l, r101.f235939l) == true) goto L44;
        return false;
    L44:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f235928a.hashCode() * 31;
        OfficeLongPressMenuAction r101 = this.f235929b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (((((((r100 + r103) * 31) + this.f235930c.hashCode()) * 31) + this.f235931d) * 31) + this.f235932e.hashCode()) * 31;
        String r105 = this.f235933f;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        Integer r108 = this.f235934g;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        Integer r111 = this.f235935h;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        if (this.f235936i == false) goto L21;
        int r114 = 1231;
    L22:
        int r115 = (r113 + r114) * 31;
        OfficeLongPressDisabledDispatchReason r116 = this.f235937j;
        if (r116 == null) goto L27;
        r102 = r116.hashCode();
    L27:
        return ((((r115 + r102) * 31) + this.f235938k.hashCode()) * 31) + this.f235939l.hashCode();
    L21:
        r114 = 1237;
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
        return "OfficeConfiguredLongPressMenuItem(id=" + this.f235928a + ", action=" + this.f235929b + ", title=" + this.f235930c + ", iconRes=" + this.f235931d + ", state=" + this.f235932e + ", disabledTips=" + this.f235933f + ", textColor=" + this.f235934g + ", endIconRes=" + this.f235935h + ", dispatchWhenDisabled=" + this.f235936i + ", disabledDispatchReason=" + this.f235937j + ", payload=" + this.f235938k + ", children=" + this.f235939l + ')';
    }

    public a(String r100, OfficeLongPressMenuAction r101, String r102, int r103, OfficeLongPressMenuItemState r104, String r105, Integer r106, Integer r107, boolean r110, OfficeLongPressDisabledDispatchReason r111, Map<String, String> r112, List<a> r113) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r102, "title");
        Intrinsics.checkNotNullParameter(r104, "state");
        Intrinsics.checkNotNullParameter(r112, WsConstants.KEY_PAYLOAD);
        Intrinsics.checkNotNullParameter(r113, "children");
        this.f235928a = r100;
        this.f235929b = r101;
        this.f235930c = r102;
        this.f235931d = r103;
        this.f235932e = r104;
        this.f235933f = r105;
        this.f235934g = r106;
        this.f235935h = r107;
        this.f235936i = r110;
        this.f235937j = r111;
        this.f235938k = r112;
        this.f235939l = r113;
    }
}
