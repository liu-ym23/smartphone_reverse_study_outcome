package com.bytedance.ee.bear.office.list.adapter;

import com.baidu.platform.comapi.map.MapController;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceEventSource;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceItem;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceTab;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OfficeSpaceItem f235708a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Document f235709b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final oj5.c f235710c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f235711d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final nj5.e f235712e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function0<Boolean> f235713f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final OfficeSpaceEventSource f235714g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final OfficeSpaceTab f235715h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f235716i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final OfficeListSortFilterScene f235717j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Integer f235718k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f235719l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f235720m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final v f235721n;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a0) == true) goto L8;
        return false;
    L8:
        a0 r101 = (a0) r100;
        if (Intrinsics.areEqual(this.f235708a, r101.f235708a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f235709b, r101.f235709b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f235710c, r101.f235710c) == true) goto L18;
        return false;
    L18:
        if (this.f235711d == r101.f235711d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f235712e, r101.f235712e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f235713f, r101.f235713f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f235714g, r101.f235714g) == true) goto L30;
        return false;
    L30:
        if (this.f235715h == r101.f235715h) goto L33;
        return false;
    L33:
        if (this.f235716i == r101.f235716i) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f235717j, r101.f235717j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f235718k, r101.f235718k) == true) goto L42;
        return false;
    L42:
        if (this.f235719l == r101.f235719l) goto L45;
        return false;
    L45:
        if (this.f235720m == r101.f235720m) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.f235721n, r101.f235721n) == true) goto L50;
        return false;
    L50:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f235708a.hashCode() * 31) + this.f235709b.hashCode()) * 31) + this.f235710c.hashCode()) * 31;
        int r101 = 1231;
        if (this.f235711d == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        nj5.e r104 = this.f235712e;
        int r105 = 0;
        if (r104 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (((((((r103 + r106) * 31) + this.f235713f.hashCode()) * 31) + this.f235714g.hashCode()) * 31) + this.f235715h.hashCode()) * 31;
        if (this.f235716i == false) goto L13;
        int r108 = 1231;
    L14:
        int r109 = (r107 + r108) * 31;
        OfficeListSortFilterScene r110 = this.f235717j;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Integer r113 = this.f235718k;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        if (this.f235719l == false) goto L25;
        int r116 = 1231;
    L26:
        int r117 = (r115 + r116) * 31;
        if (this.f235720m == true) goto L30;
        r101 = 1237;
    L30:
        int r118 = (r117 + r101) * 31;
        v r119 = this.f235721n;
        if (r119 == null) goto L35;
        r105 = r119.hashCode();
    L35:
        return r118 + r105;
    L25:
        r116 = 1237;
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = 1237;
        goto L14
    L9:
        r106 = r104.hashCode();
        goto L10
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "OfficeLongPressMenuContext(item=" + this.f235708a + ", document=" + this.f235709b + ", moreInfo=" + this.f235710c + ", enableCopyLink=" + this.f235711d + ", copyLinkUrlTransformer=" + this.f235712e + ", isNetworkConnected=" + this.f235713f + ", source=" + this.f235714g + ", tab=" + this.f235715h + ", canMultiSelect=" + this.f235716i + ", scene=" + this.f235717j + ", recentDeleteTitleRes=" + this.f235718k + ", canShowRecentRealDelete=" + this.f235719l + ", isRestrictedWikiHomePage=" + this.f235720m + ", actionSession=" + this.f235721n + ')';
    }

    public a0(OfficeSpaceItem r100, Document r101, oj5.c r102, boolean r103, a r104, Function0 r105, OfficeSpaceEventSource r106, OfficeSpaceTab r107, boolean r110, OfficeListSortFilterScene r111, Integer r112, boolean r113, boolean r114, v r115) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r101, "document");
        Intrinsics.checkNotNullParameter(r102, "moreInfo");
        Intrinsics.checkNotNullParameter(r105, "isNetworkConnected");
        Intrinsics.checkNotNullParameter(r106, "source");
        Intrinsics.checkNotNullParameter(r107, "tab");
        this.f235708a = r100;
        this.f235709b = r101;
        this.f235710c = r102;
        this.f235711d = r103;
        this.f235712e = r104;
        this.f235713f = r105;
        this.f235714g = r106;
        this.f235715h = r107;
        this.f235716i = r110;
        this.f235717j = r111;
        this.f235718k = r112;
        this.f235719l = r113;
        this.f235720m = r114;
        this.f235721n = r115;
    }
}
