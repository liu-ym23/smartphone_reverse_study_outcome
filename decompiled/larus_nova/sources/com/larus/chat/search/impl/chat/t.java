package com.larus.chat.search.impl.chat;

import com.larus.im.bean.bot.BotModel;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f325546a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f325547b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final wc9.e f325548c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final BotModel f325549d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final CharSequence f325550e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final CharSequence f325551f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f325552g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List<String> f325553h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f325554i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final long f325555j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f325556k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f325557l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Boolean f325558m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f325559n;

    public t() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof t) == true) goto L8;
        return false;
    L8:
        t r101 = (t) r100;
        if (Intrinsics.areEqual(this.f325546a, r101.f325546a) == true) goto L12;
        return false;
    L12:
        if (this.f325547b == r101.f325547b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f325548c, r101.f325548c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f325549d, r101.f325549d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f325550e, r101.f325550e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f325551f, r101.f325551f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f325552g, r101.f325552g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f325553h, r101.f325553h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f325554i, r101.f325554i) == true) goto L36;
        return false;
    L36:
        if (this.f325555j == r101.f325555j) goto L39;
        return false;
    L39:
        if (this.f325556k == r101.f325556k) goto L42;
        return false;
    L42:
        if (this.f325557l == r101.f325557l) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.f325558m, r101.f325558m) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.f325559n, r101.f325559n) == true) goto L50;
        return false;
    L50:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f325546a.hashCode() * 31) + this.f325547b) * 31;
        wc9.e r101 = this.f325548c;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        BotModel r105 = this.f325549d;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        CharSequence r108 = this.f325550e;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        CharSequence r111 = this.f325551f;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        String r114 = this.f325552g;
        if (r114 != null) goto L21;
        int r115 = 0;
    L22:
        int r116 = (((r113 + r115) * 31) + this.f325553h.hashCode()) * 31;
        String r117 = this.f325554i;
        if (r117 != null) goto L25;
        int r118 = 0;
    L26:
        long r119 = this.f325555j;
        int r120 = (((r116 + r118) * 31) + ((int) (r119 ^ (r119 >>> 32)))) * 31;
        int r121 = 1231;
        if (this.f325556k == false) goto L29;
        int r122 = 1231;
    L30:
        int r123 = (r120 + r122) * 31;
        if (this.f325557l == true) goto L34;
        r121 = 1237;
    L34:
        int r124 = (r123 + r121) * 31;
        Boolean r125 = this.f325558m;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        String r128 = this.f325559n;
        if (r128 == null) goto L43;
        r102 = r128.hashCode();
    L43:
        return r127 + r102;
    L37:
        r126 = r125.hashCode();
        goto L38
    L29:
        r122 = 1237;
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
        return "ChatSearchResult(id=" + this.f325546a + ", type=" + this.f325547b + ", conversation=" + this.f325548c + ", botModel=" + this.f325549d + ", title=" + this.f325550e + ", subTitle=" + this.f325551f + ", avatarUrl=" + this.f325552g + ", avatarUrls=" + this.f325553h + ", date=" + this.f325554i + ", localIndex=" + this.f325555j + ", onlyShowDivider=" + this.f325556k + ", hideDivider=" + this.f325557l + ", msgSendFromUser=" + this.f325558m + ", highlightKeyword=" + this.f325559n + ')';
    }

    public final int getType() {
        return this.f325547b;
    }

    public t(String r110, int r111, wc9.e r112, BotModel r210, CharSequence r211, CharSequence r212, String r213, List r214, String r215, long r216, boolean r217, boolean r218, Boolean r310, String r311, int r312) {
        String r100 = null;
        if ((r312 & 4) == 0) goto L5;
        wc9.e r101 = null;
    L7:
        if ((r312 & 8) == 0) goto L9;
        BotModel r102 = null;
    L11:
        if ((r312 & 16) == 0) goto L13;
        CharSequence r103 = null;
    L15:
        if ((r312 & 32) == 0) goto L17;
        CharSequence r104 = null;
    L19:
        if ((r312 & 64) == 0) goto L21;
        String r105 = null;
    L23:
        if ((r312 & 128) == 0) goto L25;
        List r106 = CollectionsKt.emptyList();
    L27:
        if ((r312 & 256) == 0) goto L29;
        String r113 = null;
    L31:
        if ((r312 & 512) == 0) goto L33;
        long r114 = -1;
    L34:
        boolean r115 = false;
        if ((r312 & 1024) == 0) goto L37;
        boolean r116 = false;
    L39:
        if ((r312 & 2048) != 0) goto L43;
        r115 = r218;
    L43:
        if ((r312 & 4096) == 0) goto L45;
        Boolean r117 = null;
    L47:
        if ((r312 & 8192) != 0) goto L50;
        r100 = r311;
    L50:
        Intrinsics.checkNotNullParameter(r110, "id");
        Intrinsics.checkNotNullParameter(r106, "avatarUrls");
        this.f325546a = r110;
        this.f325547b = r111;
        this.f325548c = r101;
        this.f325549d = r102;
        this.f325550e = r103;
        this.f325551f = r104;
        this.f325552g = r105;
        this.f325553h = r106;
        this.f325554i = r113;
        this.f325555j = r114;
        this.f325556k = r116;
        this.f325557l = r115;
        this.f325558m = r117;
        this.f325559n = r100;
        return;
    L45:
        r117 = r310;
        goto L47
    L37:
        r116 = r217;
        goto L39
    L33:
        r114 = r216;
        goto L34
    L29:
        r113 = r215;
        goto L31
    L25:
        r106 = r214;
        goto L27
    L21:
        r105 = r213;
        goto L23
    L17:
        r104 = r212;
        goto L19
    L13:
        r103 = r211;
        goto L15
    L9:
        r102 = r210;
        goto L11
    L5:
        r101 = r112;
        goto L7
    }
}
