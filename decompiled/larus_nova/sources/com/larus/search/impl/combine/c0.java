package com.larus.search.impl.combine;

import com.larus.im.bean.bot.BotModel;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f367556a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f367557b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f367558c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final wc9.e f367559d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final BotModel f367560e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final CharSequence f367561f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final CharSequence f367562g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f367563h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List<String> f367564i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f367565j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final long f367566k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f367567l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f367568m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Boolean f367569n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final i0 f367570o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final String f367571p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final ws9.b f367572q;

    public c0() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c0) == true) goto L8;
        return false;
    L8:
        c0 r101 = (c0) r100;
        if (Intrinsics.areEqual(this.f367556a, r101.f367556a) == true) goto L12;
        return false;
    L12:
        if (this.f367557b == r101.f367557b) goto L15;
        return false;
    L15:
        if (this.f367558c == r101.f367558c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f367559d, r101.f367559d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f367560e, r101.f367560e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f367561f, r101.f367561f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f367562g, r101.f367562g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f367563h, r101.f367563h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f367564i, r101.f367564i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f367565j, r101.f367565j) == true) goto L39;
        return false;
    L39:
        if (this.f367566k == r101.f367566k) goto L42;
        return false;
    L42:
        if (this.f367567l == r101.f367567l) goto L45;
        return false;
    L45:
        if (this.f367568m == r101.f367568m) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.f367569n, r101.f367569n) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.f367570o, r101.f367570o) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.f367571p, r101.f367571p) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.f367572q, r101.f367572q) == true) goto L59;
        return false;
    L59:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f367556a.hashCode() * 31) + this.f367557b) * 31;
        int r101 = 1231;
        if (this.f367558c == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        wc9.e r104 = this.f367559d;
        int r105 = 0;
        if (r104 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r103 + r106) * 31;
        BotModel r108 = this.f367560e;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        CharSequence r111 = this.f367561f;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        CharSequence r114 = this.f367562g;
        if (r114 != null) goto L21;
        int r115 = 0;
    L22:
        int r116 = (r113 + r115) * 31;
        String r117 = this.f367563h;
        if (r117 != null) goto L25;
        int r118 = 0;
    L26:
        int r119 = (((r116 + r118) * 31) + this.f367564i.hashCode()) * 31;
        String r120 = this.f367565j;
        if (r120 != null) goto L29;
        int r121 = 0;
    L30:
        long r122 = this.f367566k;
        int r123 = (((r119 + r121) * 31) + ((int) (r122 ^ (r122 >>> 32)))) * 31;
        if (this.f367567l == false) goto L33;
        int r124 = 1231;
    L34:
        int r125 = (r123 + r124) * 31;
        if (this.f367568m == true) goto L38;
        r101 = 1237;
    L38:
        int r126 = (r125 + r101) * 31;
        Boolean r127 = this.f367569n;
        if (r127 != null) goto L41;
        int r128 = 0;
    L42:
        int r129 = (r126 + r128) * 31;
        i0 r130 = this.f367570o;
        if (r130 != null) goto L45;
        int r131 = 0;
    L46:
        int r132 = (r129 + r131) * 31;
        String r133 = this.f367571p;
        if (r133 != null) goto L49;
        int r134 = 0;
    L50:
        int r135 = (r132 + r134) * 31;
        ws9.b r136 = this.f367572q;
        if (r136 == null) goto L55;
        r105 = r136.hashCode();
    L55:
        return r135 + r105;
    L49:
        r134 = r133.hashCode();
        goto L50
    L45:
        r131 = r130.hashCode();
        goto L46
    L41:
        r128 = r127.hashCode();
        goto L42
    L33:
        r124 = 1237;
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
        r106 = r104.hashCode();
        goto L10
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "CombineSearchResult(id=" + this.f367556a + ", type=" + this.f367557b + ", sectionTypeBot=" + this.f367558c + ", conversation=" + this.f367559d + ", botModel=" + this.f367560e + ", title=" + this.f367561f + ", subTitle=" + this.f367562g + ", avatarUrl=" + this.f367563h + ", avatarUrls=" + this.f367564i + ", date=" + this.f367565j + ", localIndex=" + this.f367566k + ", onlyShowDivider=" + this.f367567l + ", hideDivider=" + this.f367568m + ", msgSendFromUser=" + this.f367569n + ", sectionTitleItem=" + this.f367570o + ", highlightKeyword=" + this.f367571p + ", globalSearchResultItem=" + this.f367572q + ')';
    }

    public final int getType() {
        return this.f367557b;
    }

    public c0(String r110, int r111, boolean r210, wc9.e r211, BotModel r212, CharSequence r213, CharSequence r214, String r215, String r216, long r217, Boolean r218, i0 r310, String r311, ws9.b r312, int r313) {
        ws9.b r100 = null;
        if ((r313 & 8) == 0) goto L5;
        wc9.e r101 = null;
    L7:
        if ((r313 & 16) == 0) goto L9;
        BotModel r102 = null;
    L11:
        if ((r313 & 32) == 0) goto L13;
        CharSequence r103 = null;
    L15:
        if ((r313 & 64) == 0) goto L17;
        CharSequence r104 = null;
    L19:
        if ((r313 & 128) == 0) goto L21;
        String r105 = null;
    L23:
        if ((r313 & 256) == 0) goto L25;
        List<String> r106 = CollectionsKt.emptyList();
    L27:
        if ((r313 & 512) == 0) goto L29;
        String r112 = null;
    L31:
        if ((r313 & 1024) == 0) goto L33;
        long r113 = -1;
    L35:
        if ((r313 & 8192) == 0) goto L37;
        Boolean r114 = null;
    L39:
        if ((r313 & 16384) == 0) goto L41;
        i0 r115 = null;
    L43:
        if ((32768 & r313) == 0) goto L45;
        String r116 = null;
    L47:
        if ((r313 & 65536) != 0) goto L50;
        r100 = r312;
    L50:
        Intrinsics.checkNotNullParameter(r110, "id");
        Intrinsics.checkNotNullParameter(r106, "avatarUrls");
        this.f367556a = r110;
        this.f367557b = r111;
        this.f367558c = r210;
        this.f367559d = r101;
        this.f367560e = r102;
        this.f367561f = r103;
        this.f367562g = r104;
        this.f367563h = r105;
        this.f367564i = r106;
        this.f367565j = r112;
        this.f367566k = r113;
        this.f367567l = false;
        this.f367568m = false;
        this.f367569n = r114;
        this.f367570o = r115;
        this.f367571p = r116;
        this.f367572q = r100;
        return;
    L45:
        r116 = r311;
        goto L47
    L41:
        r115 = r310;
        goto L43
    L37:
        r114 = r218;
        goto L39
    L33:
        r113 = r217;
        goto L35
    L29:
        r112 = r216;
        goto L31
    L25:
        r106 = null;
        goto L27
    L21:
        r105 = r215;
        goto L23
    L17:
        r104 = r214;
        goto L19
    L13:
        r103 = r213;
        goto L15
    L9:
        r102 = r212;
        goto L11
    L5:
        r101 = r211;
        goto L7
    }
}
