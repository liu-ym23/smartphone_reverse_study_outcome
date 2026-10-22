package com.larus.bmhome.chat.trace;

import com.larus.platform.model.RecommendFrom;
import com.larus.platform.model.SearchMobParam;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f310079a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f310080b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f310081c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Integer f310082d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Integer f310083e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f310084f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f310085g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public RecommendFrom f310086h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public SearchMobParam f310087i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f310088j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f310089k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f310090l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f310091m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public com.larus.bmhome.chat.component.regen.h f310092n;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f310079a, r101.f310079a) == true) goto L12;
        return false;
    L12:
        if (this.f310080b == r101.f310080b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f310081c, r101.f310081c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f310082d, r101.f310082d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f310083e, r101.f310083e) == true) goto L24;
        return false;
    L24:
        if (this.f310084f == r101.f310084f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f310085g, r101.f310085g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f310086h, r101.f310086h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f310087i, r101.f310087i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f310088j, r101.f310088j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f310089k, r101.f310089k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f310090l, r101.f310090l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.f310091m, r101.f310091m) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.f310092n, r101.f310092n) == true) goto L50;
        return false;
    L50:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f310079a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        int r104 = 1231;
        if (this.f310080b == false) goto L9;
        int r105 = 1231;
    L10:
        int r106 = (((r103 + r105) * 31) + this.f310081c.hashCode()) * 31;
        Integer r107 = this.f310082d;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.f310083e;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        if (this.f310084f == true) goto L22;
        r104 = 1237;
    L22:
        int r113 = (r112 + r104) * 31;
        String r114 = this.f310085g;
        if (r114 != null) goto L25;
        int r115 = 0;
    L26:
        int r116 = (r113 + r115) * 31;
        RecommendFrom r117 = this.f310086h;
        if (r117 != null) goto L29;
        int r118 = 0;
    L30:
        int r119 = (r116 + r118) * 31;
        SearchMobParam r120 = this.f310087i;
        if (r120 != null) goto L33;
        int r121 = 0;
    L34:
        int r122 = (r119 + r121) * 31;
        String r123 = this.f310088j;
        if (r123 != null) goto L37;
        int r124 = 0;
    L38:
        int r125 = (r122 + r124) * 31;
        String r126 = this.f310089k;
        if (r126 != null) goto L41;
        int r127 = 0;
    L42:
        int r128 = (r125 + r127) * 31;
        String r129 = this.f310090l;
        if (r129 != null) goto L45;
        int r130 = 0;
    L46:
        int r131 = (r128 + r130) * 31;
        String r132 = this.f310091m;
        if (r132 != null) goto L49;
        int r133 = 0;
    L50:
        int r134 = (r131 + r133) * 31;
        com.larus.bmhome.chat.component.regen.h r135 = this.f310092n;
        if (r135 == null) goto L55;
        r101 = r135.hashCode();
    L55:
        return r134 + r101;
    L49:
        r133 = r132.hashCode();
        goto L50
    L45:
        r130 = r129.hashCode();
        goto L46
    L41:
        r127 = r126.hashCode();
        goto L42
    L37:
        r124 = r123.hashCode();
        goto L38
    L33:
        r121 = r120.hashCode();
        goto L34
    L29:
        r118 = r117.hashCode();
        goto L30
    L25:
        r115 = r114.hashCode();
        goto L26
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = 1237;
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "ChatBaseData(botId=" + this.f310079a + ", isOwnBot=" + this.f310080b + ", isCallBot=" + this.f310081c + ", botConversationType=" + this.f310082d + ", botType=" + this.f310083e + ", isImmerseStyle=" + this.f310084f + ", conversationId=" + this.f310085g + ", recommendFrom=" + this.f310086h + ", searchMobParam=" + this.f310087i + ", currentPage=" + this.f310088j + ", previousPage=" + this.f310089k + ", fromActivityName=" + this.f310090l + ", fromActivityModule=" + this.f310091m + ", regenAnswersData=" + this.f310092n + ')';
    }

    public final String a() {
        return this.f310088j;
    }

    public final String b() {
        return this.f310091m;
    }

    public final String c() {
        return this.f310090l;
    }

    public final String d() {
        return this.f310089k;
    }

    public final RecommendFrom e() {
        return this.f310086h;
    }

    public final SearchMobParam f() {
        return this.f310087i;
    }

    public final String g() {
        return this.f310081c;
    }

    public a(String r100, boolean r101, String r102, Integer r103, Integer r104, boolean r105, String r106, RecommendFrom r107, SearchMobParam r110, String r111, String r112, String r113) {
        Intrinsics.checkNotNullParameter(r102, "isCallBot");
        this.f310079a = r100;
        this.f310080b = r101;
        this.f310081c = r102;
        this.f310082d = r103;
        this.f310083e = r104;
        this.f310084f = r105;
        this.f310085g = r106;
        this.f310086h = r107;
        this.f310087i = r110;
        this.f310088j = "chat";
        this.f310089k = r111;
        this.f310090l = r112;
        this.f310091m = r113;
        this.f310092n = null;
    }
}
