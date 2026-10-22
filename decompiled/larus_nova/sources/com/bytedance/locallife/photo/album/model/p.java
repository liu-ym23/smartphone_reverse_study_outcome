package com.bytedance.locallife.photo.album.model;

import com.bytedance.locallife.biz.mob.EventType;
import com.bytedance.locallife.model.album.AlbumPageInfo;
import com.bytedance.locallife.model.poi.resp.PoiCoinLabel;
import com.ss.android.ugc.aweme.poi.model.PoiBundle;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<com.bytedance.locallife.photo.photodraweeview.b> f262021a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f262022b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AlbumPageInfo f262023c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f262024d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f262025e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final PoiBundle f262026f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final vx6.b f262027g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final HashMap<String, String> f262028h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final AlbumPageModel f262029i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f262030j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f262031k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f262032l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final PoiCoinLabel f262033m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final com.bytedance.locallife.biz.btm.b.a f262034n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final EventType f262035o;

    public p() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof p) == true) goto L8;
        return false;
    L8:
        p r101 = (p) r100;
        if (Intrinsics.areEqual(this.f262021a, r101.f262021a) == true) goto L12;
        return false;
    L12:
        if (this.f262022b == r101.f262022b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f262023c, r101.f262023c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f262024d, r101.f262024d) == true) goto L21;
        return false;
    L21:
        if (this.f262025e == r101.f262025e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f262026f, r101.f262026f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f262027g, r101.f262027g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f262028h, r101.f262028h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f262029i, r101.f262029i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f262030j, r101.f262030j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f262031k, r101.f262031k) == true) goto L42;
        return false;
    L42:
        if (this.f262032l == r101.f262032l) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.f262033m, r101.f262033m) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.f262034n, r101.f262034n) == true) goto L51;
        return false;
    L51:
        if (this.f262035o == r101.f262035o) goto L53;
        return false;
    L53:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f262021a.hashCode() * 31) + this.f262022b) * 31;
        AlbumPageInfo r101 = this.f262023c;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f262024d;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (((r104 + r106) * 31) + this.f262025e) * 31;
        PoiBundle r108 = this.f262026f;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (((((r107 + r109) * 31) + this.f262027g.hashCode()) * 31) + this.f262028h.hashCode()) * 31;
        AlbumPageModel r111 = this.f262029i;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        String r114 = this.f262030j;
        if (r114 != null) goto L21;
        int r115 = 0;
    L22:
        int r116 = (r113 + r115) * 31;
        String r117 = this.f262031k;
        if (r117 != null) goto L25;
        int r118 = 0;
    L26:
        int r119 = (((r116 + r118) * 31) + this.f262032l) * 31;
        PoiCoinLabel r120 = this.f262033m;
        if (r120 != null) goto L29;
        int r121 = 0;
    L30:
        int r122 = (r119 + r121) * 31;
        com.bytedance.locallife.biz.btm.b.a r123 = this.f262034n;
        if (r123 != null) goto L33;
        int r124 = 0;
    L34:
        int r125 = (r122 + r124) * 31;
        EventType r126 = this.f262035o;
        if (r126 == null) goto L39;
        r102 = r126.hashCode();
    L39:
        return r125 + r102;
    L33:
        r124 = r123.hashCode();
        goto L34
    L29:
        r121 = r120.hashCode();
        goto L30
    L25:
        r118 = r117.hashCode();
        goto L26
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
        return "PoiCoverDataForGallery(urlList=" + this.f262021a + ", mode=" + this.f262022b + ", albumPageInfo=" + this.f262023c + ", tabId=" + this.f262024d + ", totalNum=" + this.f262025e + ", poiBundle=" + this.f262026f + ", perfMonitor=" + this.f262027g + ", trackParams=" + this.f262028h + ", albumModel=" + this.f262029i + ", galleryHeaderLynx=" + this.f262030j + ", galleryBottomLynx=" + this.f262031k + ", position=" + this.f262032l + ", poiCoinLabel=" + this.f262033m + ", builder=" + this.f262034n + ", eventType=" + this.f262035o + ')';
    }

    public p(List r110, int r111, AlbumPageInfo r112, String r210, int r211, PoiBundle r212, vx6.b r213, HashMap r214, AlbumPageModel r215, String r216, String r217, int r218, PoiCoinLabel r219, com.bytedance.locallife.biz.btm.b.a r310, EventType r311, int r312) {
        int r100 = 0;
        if ((r312 & 2) == 0) goto L5;
        int r101 = 0;
    L6:
        EventType r102 = null;
        if ((r312 & 4) == 0) goto L9;
        AlbumPageInfo r103 = null;
    L11:
        if ((r312 & 8) == 0) goto L13;
        String r104 = "";
    L15:
        if ((r312 & 32) == 0) goto L17;
        PoiBundle r113 = null;
    L19:
        if ((r312 & 256) == 0) goto L21;
        AlbumPageModel r114 = null;
    L23:
        if ((r312 & 512) == 0) goto L25;
        String r115 = null;
    L27:
        if ((r312 & 1024) == 0) goto L29;
        String r116 = null;
    L31:
        if ((r312 & 2048) != 0) goto L35;
        r100 = r218;
    L35:
        if ((r312 & 4096) == 0) goto L37;
        PoiCoinLabel r117 = null;
    L39:
        if ((r312 & 8192) == 0) goto L41;
        com.bytedance.locallife.biz.btm.b.a r118 = null;
    L43:
        if ((r312 & 16384) != 0) goto L46;
        r102 = r311;
    L46:
        Intrinsics.checkNotNullParameter(r110, "urlList");
        Intrinsics.checkNotNullParameter(r213, "perfMonitor");
        Intrinsics.checkNotNullParameter(r214, "trackParams");
        this.f262021a = r110;
        this.f262022b = r101;
        this.f262023c = r103;
        this.f262024d = r104;
        this.f262025e = r211;
        this.f262026f = r113;
        this.f262027g = r213;
        this.f262028h = r214;
        this.f262029i = r114;
        this.f262030j = r115;
        this.f262031k = r116;
        this.f262032l = r100;
        this.f262033m = r117;
        this.f262034n = r118;
        this.f262035o = r102;
        return;
    L41:
        r118 = r310;
        goto L43
    L37:
        r117 = r219;
        goto L39
    L29:
        r116 = r217;
        goto L31
    L25:
        r115 = r216;
        goto L27
    L21:
        r114 = r215;
        goto L23
    L17:
        r113 = r212;
        goto L19
    L13:
        r104 = r210;
        goto L15
    L9:
        r103 = r112;
        goto L11
    L5:
        r101 = r111;
        goto L6
    }
}
