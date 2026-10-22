package com.larus.common.account.bdauth.viewmodel;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BDAuthorizePageMode f325992a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f325993b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final za7.c f325994c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<c> f325995d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f325996e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f325997f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f325998g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f325999h;

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
        if (this.f325992a == r101.f325992a) goto L12;
        return false;
    L12:
        if (this.f325993b == r101.f325993b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f325994c, r101.f325994c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f325995d, r101.f325995d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f325996e, r101.f325996e) == true) goto L24;
        return false;
    L24:
        if (this.f325997f == r101.f325997f) goto L27;
        return false;
    L27:
        if (this.f325998g == r101.f325998g) goto L30;
        return false;
    L30:
        if (this.f325999h == r101.f325999h) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f325992a.hashCode() * 31;
        int r101 = 1231;
        if (this.f325993b == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        za7.c r104 = this.f325994c;
        int r105 = 0;
        if (r104 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (((r103 + r106) * 31) + this.f325995d.hashCode()) * 31;
        String r108 = this.f325996e;
        if (r108 == null) goto L14;
        r105 = r108.hashCode();
    L14:
        int r109 = (r107 + r105) * 31;
        if (this.f325997f == false) goto L17;
        int r110 = 1231;
    L18:
        int r111 = (r109 + r110) * 31;
        if (this.f325998g == false) goto L21;
        int r112 = 1231;
    L22:
        int r113 = (r111 + r112) * 31;
        if (this.f325999h == true) goto L27;
        r101 = 1237;
    L27:
        return r113 + r101;
    L21:
        r112 = 1237;
        goto L22
    L17:
        r110 = 1237;
        goto L18
    L9:
        r106 = r104.hashCode();
        goto L10
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "BDAuthorizeUiState(pageMode=" + this.f325992a + ", isSubmitting=" + this.f325993b + ", authInfoResponse=" + this.f325994c + ", accountItems=" + this.f325995d + ", selectedAccountSecUserId=" + this.f325996e + ", hasLoginAccount=" + this.f325997f + ", showAddAccount=" + this.f325998g + ", multiAccountEnabled=" + this.f325999h + ')';
    }

    public /* synthetic */ d(int r110) {
        this(BDAuthorizePageMode.Loading, false, null, CollectionsKt.emptyList(), null, false, false, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d(BDAuthorizePageMode r100, boolean r101, za7.c r102, List<? extends c> r103, String r104, boolean r105, boolean r106, boolean r107) {
        Intrinsics.checkNotNullParameter(r100, "pageMode");
        Intrinsics.checkNotNullParameter(r103, "accountItems");
        this.f325992a = r100;
        this.f325993b = r101;
        this.f325994c = r102;
        this.f325995d = r103;
        this.f325996e = r104;
        this.f325997f = r105;
        this.f325998g = r106;
        this.f325999h = r107;
    }

    public static d a(d r100, BDAuthorizePageMode r110, boolean r111, List r112, String r113, boolean r114, boolean r115, boolean r116, int r117) {
        if ((r117 & 1) == 0) goto L5;
        BDAuthorizePageMode r101 = r100.f325992a;
    L7:
        if ((r117 & 2) == 0) goto L9;
        boolean r102 = r100.f325993b;
    L11:
        if ((r117 & 4) == 0) goto L13;
        za7.c r103 = r100.f325994c;
    L15:
        if ((r117 & 8) == 0) goto L17;
        List r104 = r100.f325995d;
    L19:
        if ((r117 & 16) == 0) goto L21;
        String r105 = r100.f325996e;
    L23:
        if ((r117 & 32) == 0) goto L25;
        boolean r106 = r100.f325997f;
    L27:
        if ((r117 & 64) == 0) goto L29;
        boolean r107 = r100.f325998g;
    L31:
        if ((r117 & 128) == 0) goto L33;
        boolean r108 = r100.f325999h;
    L34:
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "pageMode");
        Intrinsics.checkNotNullParameter(r104, "accountItems");
        return new d(r101, r102, r103, r104, r105, r106, r107, r108);
    L33:
        r108 = r116;
        goto L34
    L29:
        r107 = r115;
        goto L31
    L25:
        r106 = r114;
        goto L27
    L21:
        r105 = r113;
        goto L23
    L17:
        r104 = r112;
        goto L19
    L13:
        r103 = null;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }
}
